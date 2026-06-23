# Effort and Cost Estimate

## Estimation Assumptions

This estimate assumes:

- One full-stack developer building a portfolio-grade MVP.
- Stack: Next.js, NestJS, TypeScript, Tailwind CSS, Prisma, PostgreSQL, Clerk, Redis, and containerized deployment.
- Scope includes customer, merchant, and admin flows.
- Scope excludes paid voucher checkout, mobile native apps, advanced fraud scoring, multilingual UI, and production-scale compliance operations.
- Estimates include implementation, basic testing, and documentation.

## Cost Models

Use the model that fits the project goal:

- Solo portfolio build: direct labor cost may be treated as zero, but effort still matters.
- Freelance build: estimated at USD 40 to USD 80 per hour.
- Agency or senior consultant build: estimated at USD 90 to USD 150 per hour.

For planning, this document uses a midpoint freelance rate of USD 60 per hour.

## MVP Effort Estimate

| Workstream | Estimated Hours | Cost at USD 60/hour |
| --- | ---: | ---: |
| Discovery, requirements, backlog setup | 12-20 | USD 720-1,200 |
| Project setup, tooling, layout foundation | 16-28 | USD 960-1,680 |
| Database design and Prisma schema | 16-24 | USD 960-1,440 |
| Authentication and role-based access control | 24-40 | USD 1,440-2,400 |
| Merchant business profile and approval workflow | 28-44 | USD 1,680-2,640 |
| Deal creation, edit, submission, approval workflow | 36-56 | USD 2,160-3,360 |
| Public deal listing, filters, and detail pages | 28-44 | USD 1,680-2,640 |
| Voucher claiming and QR generation | 28-44 | USD 1,680-2,640 |
| Voucher redemption by manual code and QR scan | 36-60 | USD 2,160-3,600 |
| Merchant analytics and redemption history | 20-36 | USD 1,200-2,160 |
| Admin metrics and management views | 20-36 | USD 1,200-2,160 |
| Testing: unit, integration, end-to-end | 32-56 | USD 1,920-3,360 |
| Responsive UI polish, loading, empty, error states | 24-44 | USD 1,440-2,640 |
| Deployment, seed data, README, demo script | 16-28 | USD 960-1,680 |
| **Total** | **336-560** | **USD 20,160-33,600** |

## Timeline Estimate

| Team Setup | Calendar Estimate |
| --- | --- |
| Solo part-time developer, 15-20 hours/week | 17-28 weeks |
| Solo focused developer, 30-40 hours/week | 8-14 weeks |
| Two developers with clear ownership split | 6-10 weeks |

## Infrastructure Costs for MVP

| Service | Likely Choice | Monthly Cost Range |
| --- | --- | ---: |
| Hosting | Vercel hobby/pro | USD 0-20 |
| PostgreSQL | Supabase, Neon, Railway, Render | USD 0-25 |
| File storage | Supabase Storage or Cloudinary | USD 0-20 |
| Identity | Clerk | USD 0-variable by usage |
| Email | Resend, SendGrid, Postmark | USD 0-20 |
| Monitoring/logging | Vercel logs, Sentry free tier | USD 0-26 |
| Domain | Any registrar | USD 1-3 monthly equivalent |
| **Estimated MVP monthly total** |  | **USD 1-139** |

For a portfolio MVP, the realistic monthly cost can be kept near USD 0-30 by using free tiers carefully.

## Task-Level Estimate

| ID | Task | Priority | Effort |
| --- | --- | --- | ---: |
| T-001 | Initialize Next.js, TypeScript, Tailwind | Must | 6-10h |
| T-002 | Configure Prisma and PostgreSQL | Must | 6-10h |
| T-003 | Create domain schema and migrations | Must | 10-14h |
| T-004 | Seed categories and demo city | Must | 4-6h |
| T-005 | Implement auth and roles | Must | 18-30h |
| T-006 | Add protected route middleware | Must | 6-10h |
| T-007 | Build merchant business form | Must | 10-16h |
| T-008 | Build admin business approval page | Must | 10-16h |
| T-009 | Enforce approved-business rule | Must | 4-8h |
| T-010 | Build deal create and edit form | Must | 14-22h |
| T-011 | Build deal submission workflow | Must | 8-12h |
| T-012 | Build admin deal approval page | Must | 10-16h |
| T-013 | Build public deal listing | Must | 12-18h |
| T-014 | Build deal detail page | Must | 8-14h |
| T-015 | Add city and category filtering | Must | 8-12h |
| T-016 | Implement voucher claim logic | Must | 12-20h |
| T-017 | Generate secure code and QR token | Must | 8-14h |
| T-018 | Build voucher wallet | Must | 10-16h |
| T-019 | Build voucher detail and QR page | Must | 8-14h |
| T-020 | Implement manual redemption | Must | 12-18h |
| T-021 | Implement QR scan redemption | Must | 12-22h |
| T-022 | Implement redemption transaction and audit log | Must | 10-16h |
| T-023 | Build merchant redemption history | Should | 8-14h |
| T-024 | Build merchant analytics | Should | 10-18h |
| T-025 | Build admin metrics | Should | 10-18h |
| T-026 | Add unit tests for domain logic | Must | 12-20h |
| T-027 | Add integration tests for core flows | Must | 14-24h |
| T-028 | Add Playwright end-to-end test | Should | 10-18h |
| T-029 | Add responsive UI polish and states | Should | 18-30h |
| T-030 | Write README, deployment docs, and demo script | Must | 8-14h |

## Cost Control Recommendations

- Build one city first.
- Use free tiers for hosting, database, storage, and auth where possible.
- Avoid payments, subscriptions, and mobile apps until after the voucher lifecycle works.
- Keep search simple in MVP with database filtering before adding external search services.
- Use manual admin approval before investing in automated merchant verification.
- Build only the analytics that prove merchant and admin value.
