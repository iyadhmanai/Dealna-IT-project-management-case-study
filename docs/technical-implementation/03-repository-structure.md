# Repository Structure

## Current Structure

```text
Dealna/
  apps/
    web/
      src/
        app/
        environments/
      angular.json
      package.json
    api/
      src/
        main/
          java/com/dealna/api/
          resources/
        test/
      compose.yaml
      pom.xml
  docs/
    project-management/
    technical-implementation/
```

## Frontend Rules

`apps/web` contains only Angular code.

Recommended feature structure:

```text
src/app/
  core/
  shared/
  features/
    public-deals/
    customer-vouchers/
    merchant-dashboard/
    admin-dashboard/
```

## Backend Rules

`apps/api` contains all Spring Boot backend logic.

Recommended package structure:

```text
common/
  config/
  errors/
  security/
marketplace/
identity/
businesses/
deals/
vouchers/
redemptions/
moderation/
analytics/
audit/
```

## Dependency Direction

- Angular calls Spring Boot through HTTP only.
- Angular does not connect to the database.
- Controllers stay thin.
- Services own business rules.
- Database transactions live in Spring services.
- Repositories do not contain authorization logic.
