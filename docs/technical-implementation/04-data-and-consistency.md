# Data and Consistency

## Source of Truth

PostgreSQL is the source of truth for:

- Users and profiles.
- Businesses.
- Deals.
- Vouchers.
- Redemptions.
- Audit logs.

## Migration Strategy

Use Flyway for every database schema change.

Rules:

- No manual production schema changes.
- No Hibernate auto-create in production.
- Use `spring.jpa.hibernate.ddl-auto=validate`.
- Every table change must have a migration.

## Voucher Claim Consistency

Claiming must be transactional:

1. Validate customer role.
2. Load deal with current status and dates.
3. Check claim limit.
4. Create voucher with unique code and QR token hash.
5. Increment claim count.
6. Commit once.

Database constraints must protect against duplicate customer claims.

## Voucher Redemption Consistency

Redemption must be transactional:

1. Validate merchant membership.
2. Find voucher by manual code or QR token hash.
3. Ensure voucher is active and not expired.
4. Ensure voucher belongs to the merchant business.
5. Mark voucher as redeemed.
6. Create redemption record.
7. Create audit record.

A unique redemption constraint per voucher must make duplicate redemption impossible.
