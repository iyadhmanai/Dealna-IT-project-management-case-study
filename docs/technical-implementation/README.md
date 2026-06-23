# Technical Implementation Documentation

## Purpose

This folder defines the engineering baseline for implementing Dealna as a production-oriented portfolio project.

The architecture is designed to demonstrate current full-stack engineering practices while remaining realistic for a small team. It starts as a modular monolith rather than a distributed microservice system. Clear domain boundaries make later extraction possible without paying the operational cost on day one.

## Architecture Summary

```text
Browser
  |
  v
Next.js web application and BFF
  |
  v
NestJS REST API
  |
  +--> PostgreSQL
  +--> Redis / BullMQ
  +--> S3-compatible object storage
  +--> Clerk identity platform
  |
  v
Background worker
```

## Selected Baseline

| Area | Selection |
| --- | --- |
| Runtime | Node.js 24 LTS |
| Language | TypeScript with strict mode |
| Monorepo | pnpm workspaces and Turborepo |
| Web | Next.js 16 App Router and React 19 |
| API | NestJS 11 with the Express adapter |
| UI | Tailwind CSS 4, shadcn/ui, Lucide icons |
| Identity | Clerk Core 3 |
| Authorization | Dealna-owned RBAC and business membership records |
| Database | PostgreSQL 18 |
| ORM | Prisma ORM 7 and Prisma Migrate |
| Cache and queues | Redis and BullMQ |
| Storage | S3-compatible object storage |
| API contract | REST `/v1`, OpenAPI, generated TypeScript client |
| Testing | Vitest, Jest/Supertest, Testcontainers, Playwright |
| Observability | Structured logs, OpenTelemetry, Sentry |
| CI/CD | GitHub Actions and container builds |

Versions are the architecture baseline as of June 13, 2026. Exact patch versions must be locked in `pnpm-lock.yaml` when the workspace is scaffolded.

## Documents

- [Technology Stack](./01-technology-stack.md)
- [System Architecture](./02-system-architecture.md)
- [Repository Structure](./03-repository-structure.md)
- [Data and Consistency](./04-data-and-consistency.md)
- [API, Authentication, and Security](./05-api-authentication-security.md)
- [DevOps and Deployment](./06-devops-deployment.md)
- [Testing and Quality](./07-testing-quality.md)
- [Observability and Operations](./08-observability-operations.md)
- [Technical Implementation Roadmap](./09-implementation-roadmap.md)
- [Architecture Decisions](./10-architecture-decisions.md)

## Official Reference Baseline

- [Next.js documentation](https://nextjs.org/docs)
- [NestJS documentation](https://docs.nestjs.com/)
- [PostgreSQL documentation](https://www.postgresql.org/docs/current/)
- [Prisma ORM documentation](https://www.prisma.io/docs/orm)
- [Clerk Next.js documentation](https://clerk.com/docs/nextjs/getting-started/quickstart)
- [Clerk Express SDK](https://clerk.com/docs/reference/express/overview)
- [Turborepo documentation](https://turborepo.com/docs)
- [pnpm workspace documentation](https://pnpm.io/workspaces)
- [Tailwind CSS documentation](https://tailwindcss.com/docs/installation/framework-guides/nextjs)
- [Playwright documentation](https://playwright.dev/docs/intro)
- [OpenTelemetry JavaScript documentation](https://opentelemetry.io/docs/languages/js/getting-started/nodejs/)

## Governing Principle

Business rules belong in the API domain modules, not in React components, controllers, Prisma models, or queue processors. PostgreSQL is the source of truth for claims and redemptions. Redis improves performance and supports background jobs but must not determine whether a voucher is valid.
