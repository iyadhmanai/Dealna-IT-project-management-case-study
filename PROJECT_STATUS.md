# Project Status

## Current Status

**Status:** In Progress
**Phase:** Technical Architecture and Implementation Preparation
**Last Updated:** 2026-06-13

## Summary

The project contains a complete first version of the product, project management, and technical architecture documentation for the Dealna MVP. The next delivery phase is scaffolding and implementing the production-oriented application workspace.

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
- Selected the production-oriented technology stack.
- Documented the modular-monolith system architecture.
- Documented repository boundaries and deployment processes.
- Documented transactional claim and redemption strategies.
- Documented security, testing, and observability requirements.
- Created the technical implementation roadmap and architecture decisions.

## In Progress

- Converting the technical roadmap into implementation work.
- Preparing the monorepo foundation.

## Planned Next

1. Scaffold the pnpm and Turborepo workspace.
2. Create the Next.js web application.
3. Create the NestJS API.
4. Add PostgreSQL, Redis, and object storage to Docker Compose.
5. Configure Prisma, OpenAPI, CI, and health checks.
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
| Initial implementation target | Foundation, identity, business workflow | Build the workspace foundation first |
| PDF exports | None, selected docs, full pack | Selected docs plus one full pack later |

## Current Risks

| Risk | Status | Action |
| --- | --- | --- |
| Scope creep | Active | Keep MVP focused on voucher lifecycle |
| Portfolio presentation feels too document-heavy | Active | Add case study summary and diagrams |
| No working MVP yet | Active | Begin implementation from the technical roadmap |
| Missing visual artifacts | Active | Add diagrams before broad job application sharing |
| Architecture is too broad for one developer | Active | Deliver in vertical phases and defer optional infrastructure |
| Identity provider dependency | Accepted | Keep Dealna authorization provider-independent |

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
