# Dealna - IT Project Management Case Study

## Project Status

**Status:** In Progress
**Current Phase:** Technical Architecture and Implementation Preparation
**Role:** IT Project Manager / Product Manager
**Project Type:** Portfolio case study for a software MVP

## Executive Summary

Dealna is a local deals marketplace MVP concept for the MENA region. The platform is designed to help customers discover verified local deals while allowing merchants to publish offers and redeem customer vouchers through QR codes or manual voucher codes.

This repository documents the project management and product planning work needed to turn the idea into an executable IT project. It includes scope definition, functional and non-functional requirements, roadmap planning, effort and cost estimation, stakeholder analysis, risk management, RACI, prioritization, communication planning, and change management.

## My Role

In this case study, I act as the IT Project Manager and Product Manager. My focus is to structure the product idea into a professional delivery package that could be handed to a development team or discussed with stakeholders.

Responsibilities demonstrated:

- Define the MVP scope.
- Translate product goals into requirements.
- Identify stakeholders and responsibilities.
- Prioritize features using MoSCoW.
- Estimate effort, cost, and timeline.
- Identify risks and mitigations.
- Create a roadmap and delivery phases.
- Define communication and change management processes.

## Product Vision

Local businesses in the MENA region often rely on Instagram, WhatsApp, word of mouth, and informal promotions to attract customers. Customers, meanwhile, do not have one reliable place to discover verified local offers across restaurants, cafes, beauty, fitness, entertainment, and hospitality.

Dealna addresses this by creating a marketplace where:

- Customers can browse and claim local deals.
- Merchants can publish and manage offers.
- Admins can approve businesses and deals.
- Each claimed deal generates a unique voucher that can only be redeemed once.

## MVP Goal

The MVP is successful when:

1. A merchant creates a business profile.
2. An admin approves the business.
3. The merchant creates and submits a deal.
4. The admin approves the deal.
5. A customer browses and claims the deal.
6. The customer receives a QR code and manual voucher code.
7. The merchant redeems the voucher exactly once.

## Key PM Skills Demonstrated

- Requirements analysis
- MVP scoping
- Stakeholder management
- Risk management
- Roadmap planning
- Effort and cost estimation
- RACI definition
- MoSCoW prioritization
- Communication planning
- Change control
- Product thinking
- Documentation for developer handoff

## Documentation Library

### Product and Requirements

- [Documentation Index](./docs/README.md)
- [Functional Requirements](./docs/01-functional-requirements.md)
- [Non-Functional Requirements](./docs/02-non-functional-requirements.md)
- [Roadmap](./docs/03-roadmap.md)
- [Effort and Cost Estimate](./docs/04-effort-and-cost-estimate.md)
- [Product Manager Action Plan](./docs/05-product-manager-action-plan.md)

### Project Management

- [Project Charter](./docs/project-management/06-project-charter.md)
- [Stakeholder Analysis](./docs/project-management/07-stakeholder-analysis.md)
- [Risk Register](./docs/project-management/08-risk-register.md)
- [RACI Matrix](./docs/project-management/09-raci-matrix.md)
- [MoSCoW Prioritization](./docs/project-management/10-moscow-prioritization.md)
- [Communication Plan](./docs/project-management/11-communication-plan.md)
- [Change Management Plan](./docs/project-management/12-change-management-plan.md)

### Technical Implementation

- [Technical Documentation Index](./docs/technical-implementation/README.md)
- [Technology Stack](./docs/technical-implementation/01-technology-stack.md)
- [System Architecture](./docs/technical-implementation/02-system-architecture.md)
- [Repository Structure](./docs/technical-implementation/03-repository-structure.md)
- [Data and Consistency](./docs/technical-implementation/04-data-and-consistency.md)
- [API, Authentication, and Security](./docs/technical-implementation/05-api-authentication-security.md)
- [DevOps and Deployment](./docs/technical-implementation/06-devops-deployment.md)
- [Testing and Quality](./docs/technical-implementation/07-testing-quality.md)
- [Observability and Operations](./docs/technical-implementation/08-observability-operations.md)
- [Technical Implementation Roadmap](./docs/technical-implementation/09-implementation-roadmap.md)
- [Architecture Decisions](./docs/technical-implementation/10-architecture-decisions.md)

## Current Deliverables

| Deliverable | Status |
| --- | --- |
| Functional requirements | Complete |
| Non-functional requirements | Complete |
| Roadmap | Complete |
| Effort and cost estimate | Complete |
| Product manager action plan | Complete |
| Project charter | Complete |
| Stakeholder analysis | Complete |
| Risk register | Complete |
| RACI matrix | Complete |
| MoSCoW prioritization | Complete |
| Communication plan | Complete |
| Change management plan | Complete |
| Production technology stack | Complete |
| System architecture | Complete |
| Data consistency strategy | Complete |
| Security and deployment strategy | Complete |
| Technical implementation roadmap | Complete |
| Visual diagrams | Planned |
| Portfolio website case study | Planned |
| Working MVP application | Planned |

## Selected Implementation Stack

- Node.js 24 LTS and strict TypeScript
- pnpm workspaces and Turborepo
- Next.js 16, React 19, Tailwind CSS 4, and shadcn/ui
- NestJS 11 REST API with OpenAPI
- Clerk for identity and Dealna-owned authorization
- PostgreSQL 18 and Prisma ORM 7
- Redis and BullMQ for rate limiting and background jobs
- S3-compatible object storage
- Vitest, Jest/Supertest, Testcontainers, and Playwright
- OpenTelemetry, structured logs, and Sentry
- Docker, GitHub Actions, and managed cloud deployments

See the [technical implementation documentation](./docs/technical-implementation/README.md) for rationale, boundaries, and rollout decisions.

## Repository Structure

```text
Dealna/
  README.md
  PROJECT_STATUS.md
  CHANGELOG.md
  LICENSE
  docs/
    README.md
    01-functional-requirements.md
    02-non-functional-requirements.md
    03-roadmap.md
    04-effort-and-cost-estimate.md
    05-product-manager-action-plan.md
    project-management/
      06-project-charter.md
      07-stakeholder-analysis.md
      08-risk-register.md
      09-raci-matrix.md
      10-moscow-prioritization.md
      11-communication-plan.md
      12-change-management-plan.md
    technical-implementation/
      README.md
      01-technology-stack.md
      02-system-architecture.md
      03-repository-structure.md
      04-data-and-consistency.md
      05-api-authentication-security.md
      06-devops-deployment.md
      07-testing-quality.md
      08-observability-operations.md
      09-implementation-roadmap.md
      10-architecture-decisions.md
  assets/
    diagrams/
    screenshots/
  exports/
  .github/
    ISSUE_TEMPLATE/
```

## Next Steps

- Scaffold the pnpm and Turborepo workspace.
- Create the Next.js web, NestJS API, and worker applications.
- Add local PostgreSQL, Redis, and object storage through Docker Compose.
- Create GitHub Issues from the technical implementation roadmap.
- Create a GitHub Project board with Backlog, Planned, In Progress, Review, and Done.
- Add visual diagrams for the user journey, voucher redemption flow, and system context.
- Build a portfolio case study page that summarizes this work for job applications.

## Portfolio Positioning

This project is intended to demonstrate junior IT project management readiness by showing how a software product idea can be structured into a professional project plan before implementation begins.
