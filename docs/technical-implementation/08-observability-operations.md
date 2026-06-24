# Observability and Operations

## Spring Boot Operations

Use Actuator for:

- Health checks.
- Readiness and liveness probes.
- Application info.
- Future metrics exposure.

## Logging

Backend logs should include:

- Timestamp.
- Request path.
- Status code.
- Actor ID when authenticated.
- Business ID when relevant.
- Stable error code.

Never log:

- Passwords.
- Access tokens.
- Raw QR tokens.
- Full voucher codes.

## Future Monitoring

Add later:

- Structured JSON logs.
- Micrometer metrics.
- OpenTelemetry tracing.
- Error monitoring.
- Alerts for redemption failures and API error spikes.
