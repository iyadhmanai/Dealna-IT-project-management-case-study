# Testing and Quality

## Quality Strategy

Tests are organized around risk. Voucher claims, redemptions, authorization, and moderation receive deeper coverage than static content pages.

## Test Pyramid

### Unit Tests

Use Vitest for framework-independent domain packages and frontend utilities.

Test:

- Deal eligibility.
- Date and expiry policies.
- Discount calculations.
- Voucher code generation.
- QR token hashing.
- Status transitions.
- Authorization policy decisions.

### API Unit and Integration Tests

Use Jest and Supertest with NestJS.

Use real PostgreSQL and Redis containers for integration tests rather than mocking transaction behavior.

Test:

- DTO validation.
- Authentication mapping.
- Role and membership guards.
- Business approval.
- Deal approval.
- Claim transactions.
- Redemption transactions.
- Idempotency behavior.
- Audit record creation.

### Frontend Component Tests

Use Vitest and Testing Library for:

- Forms.
- Filters.
- Voucher status presentation.
- Permission-aware navigation.
- Error and empty states.

Test user-visible behavior rather than implementation details.

### End-to-End Tests

Use Playwright for:

1. Merchant creates a business.
2. Admin approves it.
3. Merchant creates a deal.
4. Admin approves it.
5. Customer claims it.
6. Merchant redeems it.
7. Customer sees the redeemed status.

Also cover:

- Manual voucher fallback.
- Mobile viewport.
- Merchant cross-business access denial.
- Duplicate redemption.
- Expired voucher.

## Concurrency Tests

The core system requires explicit concurrency tests:

- Two simultaneous claims for the final available voucher.
- Two simultaneous redemption requests for one voucher.
- Repeated requests with one idempotency key.
- Same idempotency key with different payloads.

Only one valid state transition may commit.

## Contract Tests

- Generate OpenAPI from the API build.
- Generate the frontend client from that document.
- Fail CI if generated client changes are not committed.
- Verify error responses and pagination contracts.

## Quality Gates

Required before merge:

- Formatting and linting pass.
- Type checking passes.
- Unit and integration tests pass.
- Build succeeds.
- Prisma schema and migrations validate.
- No high-severity dependency finding without documented acceptance.

Required before release:

- Critical Playwright journeys pass.
- Migration dry run succeeds on staging.
- Health checks pass.
- No unresolved blocker-level issue.

## Coverage

Do not optimize for a single repository-wide coverage percentage. Set higher expectations for:

- Vouchers.
- Redemptions.
- Authorization.
- Moderation.
- Money and date calculations.

Coverage reports identify gaps; they do not replace behavior-focused tests.

## Manual Acceptance Testing

Each milestone includes:

- Customer mobile flow.
- Merchant mobile redemption.
- Admin desktop workflow.
- Keyboard navigation.
- Slow and failed network behavior.
- Empty, loading, error, expired, and rejected states.

## Official Reference

- [Playwright documentation](https://playwright.dev/docs/intro)
- [NestJS testing documentation](https://docs.nestjs.com/fundamentals/testing)
- [Vitest documentation](https://vitest.dev/guide/)
