# API, Authentication, and Security

## API Style

- REST.
- Base path `/api/v1`.
- JSON request and response bodies.
- Versioned endpoints.
- Clear validation errors.

## Current Public Endpoints

```text
GET /api/v1/status
GET /api/v1/categories
GET /actuator/health
```

## Security Direction

Spring Security is included from the beginning. The first slice permits public metadata endpoints and protects future mutation endpoints.

Identity integration should be added in the next implementation phase:

- OAuth2 JWT validation.
- Role mapping.
- Business membership authorization.
- Admin-only moderation actions.

## Authorization Rules

The backend must enforce:

- Customers can claim deals.
- Merchants can manage only their own businesses.
- Merchants can redeem only vouchers for their own businesses.
- Admins can approve or reject businesses and deals.

Frontend route guards are useful for navigation, but they are not a security boundary.

## Security Requirements

- Validate all request bodies.
- Store only hashed QR tokens.
- Do not expose sequential voucher IDs.
- Do not log secrets or raw QR tokens.
- Rate limit claim and redemption attempts.
- Use HTTPS outside local development.
