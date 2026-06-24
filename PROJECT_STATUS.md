# Project Status

## Current Status

**Status:** In Progress
**Phase:** Angular and Spring Boot Implementation Foundation
**Last Updated:** 2026-06-23

## Summary

The project contains a complete first version of the product and project management documentation, plus a first runnable implementation foundation with Angular for the frontend and Spring Boot Java for the backend.

## Completed

- Created documentation folder structure.
- Created functional requirements.
- Created non-functional requirements.
- Created roadmap.
- Created effort and cost estimate.
- Created product manager action plan.
- Created project charter.
- Created stakeholder analysis.
- Created risk register.
- Created RACI matrix.
- Created MoSCoW prioritization.
- Created communication plan.
- Created change management plan.
- Created GitHub-ready root README.
- Created project status file.
- Created changelog.
- Created asset and export folders.
- Created GitHub issue templates for tasks, risks, and change requests.
- Published the project repository on GitHub.
- Selected Angular and Spring Boot as the implementation stack.
- Documented the modular-monolith system architecture.
- Documented repository boundaries and deployment processes.
- Documented transactional claim and redemption strategies.
- Documented security, testing, and observability requirements.
- Created the technical implementation roadmap and architecture decisions.
- Scaffolded the Angular frontend in `apps/web`.
- Scaffolded the Spring Boot backend in `apps/api`.
- Added public status and category endpoints.
- Connected the Angular shell to the Spring Boot API contract.
- Added local PostgreSQL Compose configuration.

## In Progress

- Building the application foundation.
- Preparing the first domain model and migration slice.

## Planned Next

1. Add the first Flyway migration.
2. Add JPA entities for categories and businesses.
3. Replace static category metadata with persisted seed data.
4. Add CORS and security configuration for authenticated phases.
5. Add CI for Angular build and Maven test.
6. Create GitHub Issues based on the technical roadmap.
7. Create a GitHub Project board.
8. Add diagrams:
   - Stakeholder map.
   - User journey.
   - Voucher redemption flow.
   - High-level system context.
9. Export selected documentation as PDF for job applications.
10. Build a portfolio website case study page.

## Open Decisions

| Decision | Options | Recommendation |
| --- | --- | --- |
| First launch city | Dubai, Riyadh, Jeddah, Cairo, Doha | Dubai or Riyadh |
| Initial deployment provider | Railway, Render, Fly.io, AWS | Start with a managed container platform |
| Managed PostgreSQL provider | Neon, Supabase, Railway, AWS RDS | Choose during deployment setup |
| Initial implementation target | Foundation, domain model, business workflow | Build the domain model next |
| PDF exports | None, selected docs, full pack | Selected docs plus one full pack later |

## Current Risks

| Risk | Status | Action |
| --- | --- | --- |
| Scope creep | Active | Keep MVP focused on voucher lifecycle |
| Portfolio presentation feels too document-heavy | Active | Add case study summary and diagrams |
| No working MVP yet | Active | Begin implementation from the technical roadmap |
| Missing visual artifacts | Active | Add diagrams before broad job application sharing |
| Architecture is too broad for one developer | Active | Deliver in vertical phases and defer optional infrastructure |
| Identity provider decision is open | Active | Keep authorization backend-owned and choose provider during identity phase |

## GitHub Presentation Checklist

- [x] Root README exists.
- [x] Documentation index exists.
- [x] Project management documents exist.
- [x] Status is clearly marked as in progress.
- [x] `.gitignore` excludes system files.
- [x] Asset folders exist.
- [x] GitHub issue templates exist.
- [x] Git repository initialized.
- [x] GitHub repository created.
- [ ] Issues created.
- [ ] Project board created.
- [ ] Diagrams added.
- [ ] Portfolio website linked.
