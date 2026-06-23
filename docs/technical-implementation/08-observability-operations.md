# Observability and Operations

## Objectives

Operations should answer:

- Is the platform available?
- Are claims and redemptions succeeding?
- Is one business or endpoint experiencing failures?
- Did a deployment cause a regression?
- Can a sensitive action be reconstructed safely?

## Logs

Use structured JSON logs with:

- Timestamp.
- Severity.
- Service and environment.
- Request ID and trace ID.
- Route and status code.
- Duration.
- Authenticated actor ID when safe.
- Business ID when relevant.
- Stable error code.

Never log:

- Passwords.
- Session tokens.
- Raw QR tokens.
- Full voucher codes.
- Sensitive customer profile data.

## Traces

Use OpenTelemetry across:

- Next.js server requests.
- NestJS API requests.
- PostgreSQL calls.
- Redis and BullMQ jobs.
- Calls to identity, storage, and email providers.

Propagate trace and request IDs from web to API to worker.

## Error Monitoring

Use Sentry for:

- Unhandled web and API exceptions.
- Frontend runtime failures.
- Release and environment correlation.
- Performance regressions on critical flows.

Expected business rejections such as expired vouchers should be tracked as metrics or structured warnings, not reported as application crashes.

## Metrics

### Technical Metrics

- Request rate.
- Error rate.
- API latency percentiles.
- Database pool usage.
- Slow query count.
- Queue depth and oldest job age.
- Job retry and failure rate.

### Product-Critical Metrics

- Claim success and rejection rate.
- Redemption success and rejection rate.
- Duplicate redemption attempts.
- Cross-business authorization denials.
- Pending moderation age.
- Active voucher count.

Avoid high-cardinality labels such as raw user or voucher IDs.

## Health Endpoints

### Liveness

`/health/live` confirms the process is running. It should not depend on external providers.

### Readiness

`/health/ready` verifies required dependencies such as PostgreSQL and Redis.

Optional providers should degrade gracefully rather than make the API unavailable.

## Alerts

Initial alerts:

- API error rate exceeds threshold.
- Redemption failure rate changes sharply.
- Database connections approach capacity.
- Queue jobs remain unprocessed.
- Staging or production health checks fail.
- Error spike follows a deployment.

## Runbooks

Create runbooks before production launch for:

- Database unavailable.
- Redis unavailable.
- Identity provider unavailable.
- Queue backlog.
- Storage upload failures.
- Suspected voucher abuse.
- Failed migration.
- Rollback.

## Retention

- Application logs: based on environment and privacy needs.
- Audit logs: longer retention with access controls.
- Traces: sampled and shorter-lived.
- Metrics: aggregated and retained for trend analysis.

Retention periods must be finalized against the launch country's privacy and legal requirements.

## Official Reference

- [OpenTelemetry for Node.js](https://opentelemetry.io/docs/languages/js/getting-started/nodejs/)
- [Sentry for Next.js](https://docs.sentry.io/platforms/javascript/guides/nextjs/)
