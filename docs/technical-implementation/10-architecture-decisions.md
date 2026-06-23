# Architecture Decisions

## ADR-001: Use a Modular Monolith

**Status:** Accepted

**Decision:** Build one domain API with explicit NestJS modules, plus a separate web process and worker.

**Why:** The domain requires strong transactional consistency but does not yet justify distributed operations.

**Rejected alternative:** Microservices from the start.

## ADR-002: Separate Web and Domain API

**Status:** Accepted

**Decision:** Next.js owns presentation and backend-for-frontend behavior. NestJS owns authoritative business logic and persistence.

**Why:** This creates a reusable API for future mobile clients and demonstrates clear system boundaries.

**Trade-off:** More deployment and authentication integration work than a single Next.js application.

## ADR-003: Use REST and OpenAPI

**Status:** Accepted

**Decision:** Use versioned REST endpoints and generate a TypeScript client from OpenAPI.

**Why:** The workflows map naturally to resources and commands, and OpenAPI supports documentation, testing, and future clients.

**Rejected alternatives:** GraphQL and frontend-only RPC.

## ADR-004: Use PostgreSQL as the Source of Truth

**Status:** Accepted

**Decision:** All voucher validity, claims, and redemption state live in PostgreSQL.

**Why:** The core product requires transactional integrity and strong constraints.

**Consequence:** Redis outages may affect rate limiting or background jobs but must not corrupt voucher state.

## ADR-005: Use Prisma with Reviewed SQL Escape Hatches

**Status:** Accepted

**Decision:** Use Prisma for normal persistence and migrations. Use parameterized SQL when a critical concurrency operation is clearer or safer in SQL.

**Why:** Type-safe productivity should not prevent use of PostgreSQL guarantees.

## ADR-006: Use Clerk for Identity

**Status:** Accepted

**Decision:** Delegate user authentication and session lifecycle to Clerk. Store Dealna roles and business memberships in PostgreSQL.

**Why:** Custom authentication adds significant security scope without differentiating the product.

**Risk:** Vendor dependency.

**Mitigation:** Keep authorization and domain profile data provider-independent and isolate Clerk behind an identity adapter.

## ADR-007: Add Redis Without Making It Authoritative

**Status:** Accepted

**Decision:** Use Redis for queues, rate limits, and short-lived cache data.

**Why:** These workloads benefit from Redis, while PostgreSQL remains authoritative.

## ADR-008: Use Background Jobs for Side Effects

**Status:** Accepted

**Decision:** Email, expiry maintenance, and aggregate analytics run through BullMQ and a worker.

**Why:** User-facing claims and redemptions should not fail because an external notification provider is unavailable.

## ADR-009: Use a Transactional Outbox

**Status:** Planned for the first asynchronous features

**Decision:** Write important domain events to an outbox table in the same database transaction as the state change.

**Why:** Publishing directly to Redis after a database commit can lose events during partial failures.

## ADR-010: Defer Kubernetes and Dedicated Search

**Status:** Accepted

**Decision:** Use managed containers and PostgreSQL search initially.

**Why:** Neither Kubernetes nor a separate search cluster solves a demonstrated MVP problem.

## Decision Review

Review an ADR when:

- A constraint materially changes.
- Production measurements contradict the decision.
- A selected tool becomes unsupported.
- Team ownership or deployment scale changes.

Do not replace architecture based only on novelty.
