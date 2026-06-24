# Technical Implementation Documentation

## Purpose

This folder defines the implementation baseline for Dealna using Angular for the frontend and Spring Boot Java for the backend, domain logic, security, persistence, background work, and operations.

## Selected Baseline

| Area | Selection |
| --- | --- |
| Frontend | Angular 22, TypeScript, SCSS |
| Backend | Spring Boot 4.1, Java 17, Maven |
| API style | REST under `/api/v1` |
| Security | Spring Security, OAuth2 Resource Server in the identity phase |
| Database | PostgreSQL |
| Persistence | Spring Data JPA and Flyway |
| Validation | Jakarta Bean Validation through Spring Boot validation |
| Operations | Spring Boot Actuator |
| Local infrastructure | Docker Compose |
| Testing | Angular Vitest, JUnit, Spring Boot Test, Testcontainers |

## Current Implementation

The first implementation slice creates:

- `apps/web`: Angular application shell.
- `apps/api`: Spring Boot API application.
- Public API endpoints for implementation status and MVP categories.
- Local PostgreSQL Compose configuration.
- A frontend API service that calls the Spring Boot backend.

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

## Governing Principle

Angular owns presentation and browser interaction. Spring Boot owns business rules, authorization, transactional consistency, auditability, and integration with infrastructure.
