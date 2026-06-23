# DevOps and Deployment

## Environment Model

| Environment | Purpose |
| --- | --- |
| Local | Developer machine with Docker Compose dependencies |
| Test | Automated integration and end-to-end tests |
| Preview | Per-pull-request web and API validation |
| Staging | Production-like acceptance testing |
| Production | Public release |

Each environment has isolated databases, storage prefixes, identity keys, Redis namespaces, and secrets.

## Local Development

Docker Compose should provide:

- PostgreSQL.
- Redis.
- S3-compatible storage such as MinIO.
- Optional local email capture service.

Applications run through pnpm for fast reload and debugging.

## Container Strategy

Build separate OCI images for:

- API.
- Worker.

Use:

- Multi-stage Docker builds.
- Non-root runtime user.
- Minimal production dependencies.
- Read-only filesystem where practical.
- Health checks.
- Pinned base image digest in production.

The Next.js web application may run on Vercel or as a standalone container.

## Recommended Portfolio Deployment

| Component | Initial Provider Type |
| --- | --- |
| Web | Vercel |
| API | Managed container platform |
| Worker | Managed container worker |
| PostgreSQL | Managed PostgreSQL |
| Redis | Managed Redis |
| Storage | S3-compatible managed storage |
| Identity | Clerk |
| Errors | Sentry |

Provider examples include Railway, Render, Fly.io, Neon, Supabase, Upstash, Cloudflare R2, and AWS. The application must depend on standard protocols rather than provider-specific APIs where reasonable.

## Production Scale Profile

If usage justifies it, the same containers can move to:

- AWS ECS/Fargate.
- Amazon RDS for PostgreSQL.
- ElastiCache for Redis.
- Amazon S3 and CloudFront.
- Managed secrets and centralized telemetry.

Kubernetes is not part of the initial plan.

## CI Pipeline

GitHub Actions should run:

1. Install with frozen lockfile.
2. Lint.
3. Type check.
4. Unit tests.
5. Start test PostgreSQL and Redis.
6. Apply migrations.
7. Integration tests.
8. Build web, API, and worker.
9. Generate and compare OpenAPI client.
10. Build container images.
11. Run security scans.

Pull requests cannot merge when required checks fail.

## CD Pipeline

Staging deployment:

1. Build immutable artifacts.
2. Apply reviewed migrations.
3. Deploy API and worker.
4. Deploy web.
5. Run smoke tests.

Production deployment:

1. Require manual approval initially.
2. Verify backup and migration plan.
3. Deploy using rolling replacement.
4. Run health and critical-path checks.
5. Monitor errors, latency, and redemption failures.

## Database Release Safety

- Use backward-compatible schema changes.
- Deploy additive schema before code that depends on it.
- Backfill asynchronously when possible.
- Remove old fields only after all code stops using them.
- Never use local development migration commands against production.

## Backup and Recovery

Minimum requirements:

- Automated daily database backups.
- Point-in-time recovery when available.
- Object storage versioning or retention.
- Documented restore procedure.
- Quarterly restore exercise for a real production system.

Initial recovery objectives:

- RPO: 24 hours for portfolio staging, 15 minutes for production target.
- RTO: 4 hours for portfolio staging, 1 hour for production target.

## Branching and Releases

- `main` is always releasable.
- Use short-lived feature branches.
- Require pull requests for changes.
- Use conventional commit intent where useful.
- Tag portfolio milestones such as `v0.1-planning` and `v0.2-foundation`.
