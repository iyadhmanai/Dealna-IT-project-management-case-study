# DevOps and Deployment

## Local Development

Run the apps separately:

```text
apps/web  -> Angular dev server on port 4200
apps/api  -> Spring Boot API on port 8080
```

Local PostgreSQL is defined in `apps/api/compose.yaml`.

## Deployment Direction

Recommended production-style deployment:

- Angular built as static assets and served through a CDN or static hosting.
- Spring Boot packaged as a container image.
- PostgreSQL hosted as a managed database.
- Secrets configured through the deployment platform.
- Health checks based on Spring Boot Actuator.

## CI Direction

GitHub Actions should run:

- Angular install, test, and build.
- Maven test and package.
- Static checks.
- Migration validation.

## Environment Variables

Backend database variables:

```text
DEALNA_DATABASE_URL
DEALNA_DATABASE_USERNAME
DEALNA_DATABASE_PASSWORD
```

Frontend API variable strategy should be added before production build configuration.
