# Roadmap

## Product Strategy

Dealna should launch city by city. The first version should feel complete in one city rather than thin across the whole region. The recommended first launch city is Dubai or Riyadh because both have strong food, beauty, fitness, entertainment, and hospitality markets.

## Phase 0: Discovery and Planning

Goal: Confirm the MVP scope, target city, first categories, and demo success criteria.

Key activities:

- Select first launch city.
- Validate category priority and merchant pain points.
- Define target personas for customer, merchant, and admin.
- Confirm compliance-sensitive categories to exclude from MVP.
- Convert requirements into implementation tickets.
- Define the demo narrative for portfolio presentation.

Exit criteria:

- MVP scope is frozen.
- Requirements are documented.
- Initial backlog is estimated and prioritized.
- Technical stack is selected.

## Phase 1: Project Foundation

Goal: Build the technical base for the product.

Key activities:

- Create Next.js, TypeScript, and Tailwind setup.
- Configure Prisma and PostgreSQL.
- Implement authentication.
- Implement role model for customer, merchant, and admin.
- Seed priority categories and initial city data.
- Create base layout and dashboard shells.

Exit criteria:

- App runs locally.
- Database migrations work.
- Users can sign up and log in.
- Users have roles.
- Categories are seeded.

## Phase 2: Merchant Business Approval

Goal: Build the trust layer for merchant onboarding.

Key activities:

- Create merchant business profile form.
- Store business details with `PENDING` status.
- Create merchant business profile page.
- Create admin business review queue.
- Implement approve and reject actions.
- Enforce approved-business rules.

Exit criteria:

- Merchant can submit a business.
- Admin can approve or reject it.
- Only approved businesses can create publishable deals.

## Phase 3: Deal Management

Goal: Allow approved merchants to create deals and admins to control public availability.

Key activities:

- Create deal form and edit flow.
- Implement deal status workflow.
- Create admin deal review page.
- Create public deal listing.
- Create deal detail page.
- Add city and category filters.

Exit criteria:

- Merchant can create and submit deals.
- Admin can approve or reject deals.
- Approved deals appear publicly.
- Non-active deals remain hidden from public browsing.

## Phase 4: Voucher Claiming

Goal: Let customers claim deals and receive secure vouchers.

Key activities:

- Implement deal claim endpoint.
- Generate unique voucher codes.
- Generate secure QR tokens and store token hashes.
- Create customer voucher wallet.
- Create voucher detail page.
- Render QR code.
- Prevent duplicate claims.

Exit criteria:

- Customer can claim an active deal.
- Customer receives a unique manual code and QR code.
- Voucher appears in wallet.
- Customer cannot claim the same deal twice.

## Phase 5: Voucher Redemption

Goal: Complete the end-to-end marketplace loop.

Key activities:

- Build merchant redemption page.
- Support manual code redemption.
- Support QR scan redemption.
- Enforce merchant ownership.
- Implement transactional redemption.
- Create redemption record and audit log.
- Create redemption history page.

Exit criteria:

- Merchant can redeem a valid voucher.
- Voucher changes to `REDEEMED`.
- Same voucher cannot be redeemed twice.
- Merchant cannot redeem vouchers from another business.

## Phase 6: Analytics, Polish, and Portfolio Readiness

Goal: Make the MVP demo-ready and credible.

Key activities:

- Add merchant analytics.
- Add admin metrics.
- Add loading, empty, and error states.
- Improve responsive UI.
- Add seed demo data.
- Write README and setup documentation.
- Add screenshots or demo script.
- Add unit, integration, and end-to-end tests.

Exit criteria:

- Merchant can see claims and redemptions.
- Admin can see platform totals.
- UI is polished enough for a portfolio demo.
- End-to-end test validates the core flow.

## Phase 7: Post-MVP Enhancements

Goal: Increase marketplace quality, growth, and operational readiness.

Candidate features:

- Reviews and ratings.
- Merchant staff accounts.
- Multi-branch businesses.
- Arabic and English localization.
- Right-to-left layout support.
- Map-based deal discovery.
- Personalized recommendations.
- Saved deals.
- Push or email notifications.
- Payment integration for paid vouchers.
- Merchant subscription plans.
- Fraud scoring and anomaly detection.
- Scheduled expiry job.
- Advanced reporting exports.

## Suggested Timeline

For a solo developer portfolio project, a focused MVP can be built in 8 to 12 weeks:

- Week 1: Discovery, planning, setup.
- Weeks 2-3: Foundation, auth, roles, database.
- Weeks 4-5: Business and deal workflows.
- Weeks 6-7: Voucher claiming and redemption.
- Weeks 8-9: Dashboards, analytics, tests.
- Weeks 10-12: Polish, documentation, deployment, demo assets.
