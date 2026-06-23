# Repository Structure

## Proposed Monorepo

```text
Dealna/
  apps/
    web/
      src/
        app/
        components/
        features/
        lib/
      public/
    api/
      src/
        common/
        modules/
          identity/
          businesses/
          categories/
          deals/
          vouchers/
          redemptions/
          moderation/
          analytics/
          audit/
          files/
          notifications/
    worker/
      src/
        processors/
        schedules/
  packages/
    api-client/
    database/
      prisma/
        schema.prisma
        migrations/
        seed.ts
    domain/
    observability/
    test-utils/
    typescript-config/
    eslint-config/
    ui/
  e2e/
  infrastructure/
    docker/
    scripts/
  docs/
    project-management/
    technical-implementation/
  .github/
    workflows/
  compose.yaml
  package.json
  pnpm-lock.yaml
  pnpm-workspace.yaml
  turbo.json
```

## Application Responsibilities

### `apps/web`

- Routes and layouts.
- Public SEO pages.
- Customer, merchant, and admin interfaces.
- Clerk web integration.
- Backend-for-frontend calls.
- No direct database access.
- No authoritative business rules.

### `apps/api`

- REST API and OpenAPI document.
- Authentication token verification.
- Authorization and ownership.
- Domain workflows.
- Database transactions.
- Audit event creation.
- Queue job production.

### `apps/worker`

- BullMQ consumers.
- Retryable notifications.
- Scheduled expiry maintenance.
- Analytics aggregation.
- Outbox delivery.

The worker must call shared application services or purpose-built job handlers. It must not duplicate business rules from the API.

## Shared Package Responsibilities

### `packages/database`

- Prisma schema and generated client.
- Migrations.
- Seed data.
- Database test helpers.

### `packages/domain`

- Framework-independent value objects.
- Status transition rules.
- Eligibility policies.
- Voucher token utilities.
- Shared domain errors.

This package must not import NestJS, Next.js, Prisma, Clerk, or Redis.

### `packages/api-client`

- Generated types and client from OpenAPI.
- No handwritten duplication of API response types.

### `packages/ui`

- Shared visual primitives.
- Design tokens.
- Accessible form and feedback components.
- No application-specific data fetching.

### Configuration Packages

Centralize strict TypeScript and ESLint rules. Applications may extend them but should not silently weaken them.

## Dependency Rules

Allowed:

```text
apps -> packages
infrastructure packages -> domain
api-client -> generated OpenAPI types
```

Forbidden:

```text
domain -> framework or database
web -> Prisma
worker -> web
ui -> application domain modules
```

Use lint rules and package boundaries to prevent accidental coupling.
