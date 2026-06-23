# Data and Consistency

## Data Principles

- PostgreSQL is the source of truth.
- Financial and voucher values use exact decimal types.
- Timestamps are stored in UTC.
- User-facing dates are rendered in the selected city timezone.
- Critical state changes are transactional and auditable.
- Redis is never authoritative for voucher state.

## Core Model Refinements

The implementation should extend the initial domain model with:

- `BusinessMember` for owners and merchant staff.
- `ModerationDecision` for approval history and reasons.
- `OutboxEvent` for reliable asynchronous work.
- `IdempotencyKey` for retry-safe mutations where appropriate.
- `version` or guarded status updates for concurrency-sensitive records.
- `deletedAt` only where soft deletion has a defined operational purpose.

## Identifier Strategy

- Use UUIDs for internal primary keys.
- Use slugs for public business and deal URLs.
- Never place voucher database IDs in QR payloads.
- Use a cryptographically random 256-bit token for QR redemption.
- Store only a keyed hash or SHA-256 hash of the QR token.
- Display a separate human-readable manual voucher code.

## Constraints and Indexes

Required constraints:

- Unique user identity provider ID.
- Unique category slug.
- Unique business slug within the selected scope.
- Unique deal slug within a business.
- Unique voucher code.
- Unique QR token hash.
- Unique voucher per customer and deal for the MVP.
- Unique redemption per voucher.
- Valid price and date check constraints where practical.

Required indexes:

- Deals by `status`, `city`, `categoryId`, `startDate`, and `endDate`.
- Businesses by `status`, `city`, and category.
- Vouchers by customer and status.
- Vouchers by deal and status.
- Redemptions by business and redeemed timestamp.
- Pending moderation queues by status and submitted timestamp.
- Audit records by entity and timestamp.

## Claim Transaction

The claim workflow must:

1. Start a short transaction.
2. Re-read the deal inside the transaction.
3. Validate status and active date range.
4. Guard inventory with a conditional update.
5. Create the voucher.
6. Create an audit or outbox record.
7. Commit.

Use `Serializable` isolation with bounded retry for serialization conflicts, or implement an equivalent conditional update that cannot exceed `maxClaims`.

The database unique constraint on `(dealId, customerId)` is the final protection against duplicate claims.

## Redemption Transaction

Redemption should use a guarded state transition:

```sql
UPDATE vouchers
SET status = 'REDEEMED',
    redeemed_at = NOW(),
    redeemed_by_merchant_user_id = $merchantUserId
WHERE id = $voucherId
  AND status = 'ACTIVE'
  AND expires_at > NOW();
```

The application verifies that exactly one row changed. In the same transaction it creates:

- One `Redemption` record.
- One `AuditLog` record.
- Optional `OutboxEvent` records.

A unique constraint on `redemptions.voucher_id` provides an additional database guarantee.

## Idempotency

Use an `Idempotency-Key` header for claim and redemption mutations.

Store:

- Actor ID.
- Endpoint or operation.
- Request hash.
- Response status and body reference.
- Expiry timestamp.

Reusing the same key with a different payload must return an error.

## Migrations

- Migrations are created locally and reviewed in pull requests.
- Production uses `prisma migrate deploy`.
- Application startup must not generate migrations.
- Destructive migrations require a documented expand/migrate/contract plan.
- Backups and rollback procedures are verified before high-risk migrations.

## Search

Initial search uses PostgreSQL:

- Normalized city and category filters.
- `ILIKE` for early development only.
- Trigram indexes or full-text search when the dataset grows.

Introduce a dedicated search engine only after measuring a real limitation.

## Official References

- [Prisma transactions](https://www.prisma.io/docs/orm/prisma-client/queries/transactions)
- [PostgreSQL transaction isolation](https://www.postgresql.org/docs/current/transaction-iso.html)
