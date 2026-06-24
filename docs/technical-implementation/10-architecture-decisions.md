# Architecture Decisions

## ADR-001: Use Angular for the Frontend

**Status:** Accepted

Angular is selected for the web application because it is structured, enterprise-friendly, and useful for portfolio roles that value frontend architecture.

## ADR-002: Use Spring Boot Java for the Backend

**Status:** Accepted

Spring Boot is selected for API, security, persistence, validation, transactions, and operations.

## ADR-003: Start as a Modular Monolith

**Status:** Accepted

The project will not start with microservices. Voucher claiming and redemption need strong transactional consistency, and a modular monolith is the right first architecture.

## ADR-004: Use PostgreSQL and Flyway

**Status:** Accepted

PostgreSQL provides the transactional guarantees needed for voucher integrity. Flyway keeps schema changes controlled and reviewable.

## ADR-005: Keep Authorization on the Backend

**Status:** Accepted

Angular route guards may improve UX, but Spring Boot authorization is the real security boundary.

## ADR-006: Defer Payments and Native Apps

**Status:** Accepted

Payments and native mobile apps are out of scope until the marketplace, approval, claim, and redemption flows work.
