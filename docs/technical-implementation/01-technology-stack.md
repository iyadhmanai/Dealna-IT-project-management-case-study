# Technology Stack

## Frontend

Use Angular 22 as the frontend application framework.

Frontend responsibilities:

- Public marketplace browsing.
- Customer voucher wallet.
- Merchant dashboard.
- Admin dashboard.
- QR scanning user interface.
- Typed communication with the Spring Boot API.

Supporting tools:

- TypeScript.
- SCSS.
- Angular Router.
- Angular HttpClient.
- Angular testing through the generated Vitest setup.

## Backend

Use Spring Boot 4.1 with Java 17 and Maven.

Backend responsibilities:

- REST API.
- Authentication integration.
- Role-based and resource-based authorization.
- Business, deal, voucher, redemption, moderation, and analytics workflows.
- Transactional claim and redemption logic.
- Persistence and migrations.
- Audit logging.
- Operational endpoints.

Supporting Spring modules:

- Spring Web MVC.
- Spring Security.
- OAuth2 Resource Server.
- Spring Data JPA.
- Flyway.
- Bean Validation.
- Actuator.
- Testcontainers.

## Data and Infrastructure

- PostgreSQL is the source of truth.
- Flyway manages database migrations.
- Docker Compose provides local infrastructure.
- Object storage and background jobs are deferred until the core voucher lifecycle is implemented.

## Why This Stack

This stack is meaningful for current enterprise and product engineering roles because it combines:

- Angular for structured frontend applications.
- Spring Boot for production-grade Java backend development.
- PostgreSQL for transactional integrity.
- Spring Security for real-world authorization concerns.
- Maven, JUnit, and Testcontainers for professional backend delivery.

## Deliberately Deferred

- Native mobile apps.
- Microservices.
- Kubernetes.
- Payment processing.
- Dedicated search infrastructure.
- Event streaming.

The MVP starts as a modular monolith so the project can demonstrate professional architecture without unnecessary distributed-system overhead.
