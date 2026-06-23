# Technical Implementation Roadmap

## Delivery Approach

Build vertical slices that finish a user outcome, while establishing shared infrastructure only when the next slice needs it.

## Phase 1: Workspace Foundation

Deliver:

- pnpm and Turborepo workspace.
- Next.js web application.
- NestJS API.
- Worker application.
- Shared TypeScript and lint configuration.
- Docker Compose for PostgreSQL, Redis, and object storage.
- GitHub Actions baseline.
- Health endpoints.

Exit criteria:

- All applications run locally.
- CI can lint, type check, test, and build.
- API exposes OpenAPI.
- Local infrastructure starts with one command.

## Phase 2: Identity and Authorization

Deliver:

- Clerk integration in web and API.
- Dealna user profile synchronization.
- Customer, merchant, and admin roles.
- Business membership permissions.
- Authentication and authorization test helpers.

Exit criteria:

- Protected API requests are verified independently by the API.
- Role and ownership tests pass.
- An admin can be seeded safely.

## Phase 3: Businesses and Moderation

Deliver:

- Business schema and membership model.
- Merchant business form.
- File upload flow for logos.
- Admin moderation queue.
- Approval, rejection, and audit records.

Exit criteria:

- Only approved businesses can progress to publishable deals.
- Every moderation decision is auditable.

## Phase 4: Deals and Discovery

Deliver:

- Deal schema and status transitions.
- Merchant create and edit flows.
- Admin deal moderation.
- Public listing and details.
- City and category filters.
- SEO metadata and cache strategy.

Exit criteria:

- Only eligible active deals are publicly visible.
- Generated API client is used by the web app.

## Phase 5: Voucher Claims

Deliver:

- Eligibility domain service.
- Transactional claim operation.
- Unique manual code.
- Secure QR token hashing.
- Customer voucher wallet.
- Claim idempotency and rate limiting.

Exit criteria:

- Duplicate claims are prevented at the database level.
- Inventory cannot exceed `maxClaims` under concurrent requests.

## Phase 6: Voucher Redemption

Deliver:

- Mobile merchant redemption screen.
- QR scanner.
- Manual code fallback.
- Transactional single-use redemption.
- Redemption history.
- Audit and outbox events.

Exit criteria:

- Concurrent redemption test proves only one redemption succeeds.
- A merchant cannot redeem another business's voucher.

## Phase 7: Jobs, Analytics, and Notifications

Deliver:

- BullMQ worker.
- Transactional outbox delivery.
- Claim and redemption notifications.
- Voucher expiry maintenance.
- Merchant and admin analytics read models.

Exit criteria:

- Jobs are retryable and observable.
- Core user requests do not depend on email availability.

## Phase 8: Production Readiness

Deliver:

- Staging deployment.
- OpenTelemetry and Sentry.
- Security headers and rate-limit review.
- Backup and restore documentation.
- End-to-end browser suite.
- Accessibility and performance review.
- Production deployment runbook.

Exit criteria:

- Critical journey passes in staging.
- Alerts and health checks work.
- Rollback and restore steps are documented.

## First Implementation Backlog

| ID | Task | Priority |
| --- | --- | --- |
| TECH-001 | Scaffold pnpm/Turborepo workspace | Must |
| TECH-002 | Create Next.js web app | Must |
| TECH-003 | Create NestJS API app | Must |
| TECH-004 | Create worker app | Should |
| TECH-005 | Add shared configuration packages | Must |
| TECH-006 | Add PostgreSQL, Redis, and MinIO Compose services | Must |
| TECH-007 | Configure Prisma schema and migration workflow | Must |
| TECH-008 | Add OpenAPI and generated client pipeline | Must |
| TECH-009 | Add CI quality gates | Must |
| TECH-010 | Add health, request ID, logging, and error handling | Must |
| TECH-011 | Integrate Clerk | Must |
| TECH-012 | Implement Dealna roles and memberships | Must |

## Definition of Done

A technical task is done when:

- Acceptance criteria are met.
- Relevant tests pass.
- Type checking and linting pass.
- Documentation or OpenAPI is updated.
- Security and observability implications are addressed.
- No secret or environment-specific value is committed.
