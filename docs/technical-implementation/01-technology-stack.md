# Technology Stack

## Selection Criteria

The stack was selected against these criteria:

- Strong production adoption and active maintenance.
- Good TypeScript support across the full system.
- Clear support for transactions, authorization, validation, and testing.
- Useful skills for current full-stack and backend job markets.
- Reasonable local development and portfolio deployment costs.
- Low enough complexity for a small team to operate.

## Runtime and Workspace

### Node.js 24 LTS

Use Node.js 24 LTS for local development, CI, API containers, and workers. Production applications should use an Active LTS or Maintenance LTS Node.js release rather than the Current release.

### TypeScript

Use TypeScript with:

- `strict: true`
- `noUncheckedIndexedAccess: true`
- `exactOptionalPropertyTypes: true`
- Shared lint and compiler configurations.
- No untyped API response objects.

### pnpm and Turborepo

Use pnpm workspaces for dependency management and Turborepo for task orchestration and caching.

Benefits:

- One lockfile for the whole system.
- Shared packages without publishing them.
- Parallelized builds, tests, and linting.
- Clear ownership between applications and shared libraries.

## Frontend

### Next.js 16 App Router

Use Next.js for:

- Public deal discovery pages.
- Customer voucher wallet.
- Merchant dashboard.
- Admin dashboard.
- Server-rendered and cached public content.
- Backend-for-frontend calls to the NestJS API.

Prefer Server Components for data-driven pages. Add Client Components only where browser state, camera access, or interactive controls require them.

### React 19

Use the React version supported by the selected Next.js release. Avoid manually overriding framework-managed React versions.

### Tailwind CSS 4 and shadcn/ui

Use Tailwind CSS for layout and design tokens. Use shadcn/ui as owned component source code rather than as a black-box component dependency.

UI rules:

- Build accessible forms and dialogs.
- Use Lucide icons for familiar actions.
- Maintain WCAG 2.2 AA contrast and keyboard operation.
- Design mobile-first, especially the voucher wallet and redemption scanner.
- Keep the design ready for Arabic and right-to-left layouts.

### Frontend Data and Forms

- Use the generated OpenAPI client for API calls.
- Use TanStack Query only for client-side server state that benefits from caching or polling.
- Use React Hook Form and Zod for complex interactive forms.
- Prefer URL search parameters for public deal filters.

## Backend

### NestJS 11

Use NestJS as a modular monolith with the default Express adapter.

Reasons:

- Strong module boundaries and dependency injection.
- First-class guards, validation, rate limiting, queues, testing, and OpenAPI support.
- A clear path to separate workers or services later.
- The Express adapter integrates directly with Clerk's official Express middleware.

Initial domain modules:

- Identity and profiles
- Businesses and memberships
- Categories
- Deals
- Vouchers and claims
- Redemptions
- Moderation
- Analytics
- Audit
- Files
- Notifications

### REST and OpenAPI

Expose versioned REST endpoints under `/v1`.

Use NestJS Swagger/OpenAPI generation and create a TypeScript client from the generated specification. The OpenAPI document is the contract for the web app and any future mobile client.

Do not expose Prisma types directly as public API types.

## Identity and Authorization

### Clerk Core 3

Use Clerk for:

- Sign-up and sign-in.
- Session handling.
- Password reset and account security.
- Social login when introduced.
- Identity lifecycle and token verification.

Use the official Next.js SDK in the web application and official Express middleware in the NestJS API.

Dealna remains responsible for:

- Application roles.
- Business ownership.
- Merchant staff membership.
- Admin privileges.
- Resource-level authorization.
- Suspension and moderation status.

This separation prevents identity-provider metadata from becoming the only source of authorization truth.

## Data Layer

### PostgreSQL 18

PostgreSQL is the authoritative data store for:

- Users and profiles.
- Businesses and memberships.
- Deals.
- Claims and vouchers.
- Redemptions.
- Audit logs.
- Transactional outbox events.

Use standard PostgreSQL capabilities first. Add external search infrastructure only when PostgreSQL full-text or trigram search is no longer sufficient.

### Prisma ORM 7

Use Prisma for:

- Schema definition.
- Type-safe data access.
- Migrations.
- Interactive transactions.
- Local seed data.

Use SQL migrations or parameterized raw SQL when a critical operation requires a database feature that Prisma cannot express clearly.

## Cache, Jobs, and Storage

### Redis and BullMQ

Use Redis for:

- Distributed rate limiting.
- Short-lived cache entries.
- BullMQ queues.
- Idempotency records where database persistence is unnecessary.

Use BullMQ for:

- Email delivery.
- Voucher expiry maintenance.
- Image processing hooks.
- Analytics aggregation.
- Retryable notifications.

Claims and redemptions remain synchronous database operations.

### S3-Compatible Object Storage

Use S3-compatible storage for business logos and deal images.

Requirements:

- Presigned uploads.
- File type and size validation.
- Random object keys.
- Private origin with controlled public delivery.
- Image metadata stored in PostgreSQL.

## Supporting Tools

| Concern | Tool |
| --- | --- |
| QR generation | `qrcode` |
| QR scanning | `@zxing/browser` |
| API unit/integration tests | Jest and Supertest |
| Shared/frontend tests | Vitest and Testing Library |
| Database integration | Testcontainers |
| End-to-end tests | Playwright |
| Structured API logs | Pino |
| Tracing and metrics | OpenTelemetry |
| Error monitoring | Sentry |
| Local infrastructure | Docker Compose |

## Deliberately Not Selected

- Microservices: operational overhead is not justified for the initial product.
- GraphQL: REST and OpenAPI are simpler for the known workflows.
- Kubernetes: unnecessary for the expected launch scale and team size.
- Elasticsearch or OpenSearch: PostgreSQL search is enough initially.
- Custom password authentication: identity security is not a differentiating Dealna feature.
