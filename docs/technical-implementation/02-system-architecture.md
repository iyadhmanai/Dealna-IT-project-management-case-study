# System Architecture

## Architecture Style

Dealna starts as a web application plus a Spring Boot modular monolith.

```text
Browser
  |
  v
Angular web application
  |
  v
Spring Boot REST API
  |
  v
PostgreSQL
```

## Runtime Components

| Component | Responsibility |
| --- | --- |
| Angular app | User experience, routes, forms, QR scanner UI, API calls |
| Spring Boot API | Domain logic, authorization, transactions, persistence |
| PostgreSQL | Authoritative data store |
| Flyway | Database versioning |
| Actuator | Health and operations endpoints |

## Backend Module Boundaries

Initial Spring packages should be organized by domain:

```text
com.dealna.api
  common
  marketplace
  identity
  businesses
  categories
  deals
  vouchers
  redemptions
  moderation
  analytics
  audit
```

The first committed slice adds `common` and `marketplace`. Later slices should add domain packages only when the related workflow is implemented.

## Request Flow

1. Angular calls `/api/v1/*`.
2. Spring MVC receives the request.
3. Spring Security applies public or protected route rules.
4. Controllers delegate to application services.
5. Services enforce business policies and transactions.
6. Repositories persist changes through Spring Data JPA.

## Core Rule

Angular may improve usability, but Spring Boot is the authority. A user must never gain permission or change voucher state because of frontend-only logic.
