# API, Authentication, and Security

## API Style

- REST over HTTPS.
- Base path `/v1`.
- JSON request and response bodies.
- OpenAPI generated from the API.
- Cursor pagination for growing collections.
- Consistent problem-details error format.
- Request ID returned in every response.

## Endpoint Groups

```text
/v1/me
/v1/businesses
/v1/deals
/v1/categories
/v1/vouchers
/v1/redemptions
/v1/merchant/*
/v1/admin/*
/v1/files/*
/health/live
/health/ready
```

## Authentication Flow

1. Clerk authenticates the user.
2. The web application obtains the current Clerk session token.
3. The token is forwarded to the API as a bearer token.
4. Clerk middleware verifies the token.
5. The API maps the Clerk user ID to a Dealna profile.
6. Authorization guards load Dealna roles and memberships.

Authentication answers who the user is. Dealna authorization answers what the user may do.

## Authorization Model

Use policy checks based on:

- Global role: customer, merchant, admin.
- Business membership: owner, manager, redeemer.
- Business status.
- Resource ownership.
- Deal and voucher state.

Example permissions:

| Action | Required Permission |
| --- | --- |
| Claim deal | Authenticated customer |
| Edit business | Business owner or manager |
| Redeem voucher | Business member with redeem permission |
| Approve business | Admin |
| Approve deal | Admin |
| View merchant analytics | Authorized member of that business |

Never trust role or business IDs submitted by the client without server-side verification.

## Validation

- NestJS validates all API DTOs.
- Zod validates browser forms and environment configuration.
- Unknown properties are rejected for mutation requests.
- Prices, currencies, dates, URLs, and text lengths have explicit rules.
- Uploaded files are checked by content type, size, and decoded format.

## Voucher Security

- Generate QR tokens with a cryptographically secure random generator.
- Use at least 256 bits of entropy.
- Store only a token hash.
- Compare hashes in constant time where applicable.
- Do not log voucher tokens or full manual codes.
- Rate limit manual-code attempts by actor, business, and IP.
- Return generic invalid-voucher messages to reduce enumeration.

## HTTP Security

- HTTPS only in non-local environments.
- Helmet security headers.
- Strict CORS allowlist.
- Content Security Policy for the web application.
- Secure, HTTP-only, same-site cookies where cookies are used.
- Payload size limits.
- Request timeouts.
- Rate limiting on authentication-adjacent and voucher endpoints.

## Secrets

- No secrets in Git or client bundles.
- Use platform secret stores.
- Separate secrets by environment.
- Rotate identity, database, storage, and email credentials.
- Scan commits and CI output for accidental leaks.

## Audit Requirements

Audit:

- Business approval and rejection.
- Deal approval and rejection.
- Role and membership changes.
- Voucher redemption.
- Admin access to sensitive records.
- Account suspension.

Audit records contain actor, action, target, timestamp, request ID, and safe metadata. They must not contain secrets or raw QR tokens.

## Security Verification

CI and release checks include:

- Dependency vulnerability scan.
- Static analysis.
- Authorization integration tests.
- Cross-business access tests.
- Duplicate redemption concurrency test.
- Secret scanning.
- Manual review of security-sensitive migrations.

## Official References

- [Clerk Next.js integration](https://clerk.com/docs/nextjs/getting-started/quickstart)
- [Clerk Express SDK](https://clerk.com/docs/reference/express/overview)
- [NestJS security documentation](https://docs.nestjs.com/security/authentication)
- [NestJS OpenAPI documentation](https://docs.nestjs.com/openapi/introduction)
