# Testing and Quality

## Frontend Tests

Use Angular's generated test setup for:

- Component rendering.
- Form behavior.
- API service behavior.
- Route-level screens.

## Backend Tests

Use:

- JUnit.
- Spring Boot Test.
- Spring Security Test.
- Testcontainers for PostgreSQL.

## Critical Test Areas

- Deal eligibility.
- Business approval workflow.
- Deal approval workflow.
- Voucher code generation.
- Duplicate claim prevention.
- Single-use redemption.
- Merchant ownership checks.
- Admin-only actions.

## Quality Gates

Before merging implementation work:

- Angular build passes.
- Angular tests pass.
- Maven tests pass.
- Spring context loads.
- No secrets are committed.
- Documentation is updated when architecture changes.
