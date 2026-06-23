# Product Manager Action Plan

## As a Product Manager, What I Would Do Is...

As a product manager, what I would do is keep Dealna focused on proving one strong marketplace loop before expanding the idea. The temptation with a MENA deals marketplace is to support every city, every category, every merchant type, payments, mobile apps, and advanced analytics immediately. I would not start there. I would first make one city, five categories, and one end-to-end redemption flow feel trustworthy and complete.

## 1. Define the MVP Around One Core Promise

The product promise should be simple:

Customers can find real local deals, claim a secure voucher, and redeem it once at the merchant.

Everything in the MVP should support that promise. If a feature does not help the claim or redemption loop, I would move it to the post-MVP backlog.

## 2. Choose One Launch City

I would select one first city, most likely Dubai or Riyadh, and make the product feel full there. A marketplace fails when supply feels empty. One dense city is better than eight thin cities.

My launch category mix would be:

- 40% restaurants and cafes.
- 25% beauty and grooming.
- 15% entertainment and experiences.
- 10% fitness and wellness.
- 10% hotels, brunches, day passes, and staycations.

## 3. Prioritize Trust Before Growth

The admin approval workflow is not just an internal feature. It is part of the product's trust system. I would make sure businesses and deals cannot go live without approval.

For the MVP, I would manually review businesses and deals. Automated verification can come later.

## 4. Treat Voucher Redemption as the Critical Technical Risk

The highest-risk part of the product is duplicate or fraudulent redemption. I would prioritize this early:

- High-entropy QR tokens.
- Stored token hashes only.
- Manual voucher codes.
- Transactional redemption.
- Merchant ownership checks.
- Audit logs.
- Clear redeemed and expired states.

This is the feature that makes the project credible as a serious full-stack portfolio build.

## 5. Build the Product in This Order

I would implement the project in this order:

1. Foundation: app setup, database, roles, auth, categories.
2. Merchant onboarding: business profile and admin approval.
3. Deal workflow: create, submit, approve, publish.
4. Customer discovery: browse, filter, detail page.
5. Voucher claiming: unique code, secure QR token, wallet.
6. Redemption: manual code, QR scan, single-use enforcement.
7. Dashboards: merchant analytics and admin metrics.
8. Polish: responsive UI, seed data, tests, deployment, demo script.

## 6. Define Success Metrics Early

Even for a portfolio project, I would define product metrics so the system feels real:

- Active deals by city.
- Deal claims.
- Voucher redemptions.
- Redemption rate.
- Pending business approvals.
- Pending deal approvals.
- Merchant deal performance.

For a real launch, I would add:

- Customer repeat claim rate.
- Merchant repeat publishing rate.
- Deal approval rejection reasons.
- Time from claim to redemption.
- Category-level conversion rate.

## 7. Keep the First Version Operationally Honest

I would avoid pretending the MVP is more automated than it is. A good first marketplace can rely on manual admin operations if the workflow is clear.

The MVP should support:

- Manual business approval.
- Manual deal moderation.
- Basic support investigation through audit logs.
- Simple analytics.
- Clear seed data for demos.

## 8. Exclude Risky Categories From MVP

I would explicitly exclude:

- Complex medical procedures.
- Financial products.
- Insurance.
- Prescription medicines.
- Tobacco and vape products.
- Alcohol-related offers where country-specific law is unclear.
- Luxury brands that do not want public discounting.

Medical-adjacent offers like dental cleaning or skin consultations should only be introduced later with license checks and careful wording.

## 9. Prepare the Portfolio Story

The project should not only work. It should explain itself well.

I would prepare a demo flow:

1. Merchant signs up.
2. Merchant submits business.
3. Admin approves business.
4. Merchant creates deal.
5. Admin approves deal.
6. Customer browses deal.
7. Customer claims voucher.
8. Merchant redeems voucher.
9. Admin and merchant dashboards update.

This tells a clean story about product thinking, security, database design, workflows, and role-based access control.

## 10. PM Decisions I Would Make Now

I would make these decisions before coding:

- First city: choose Dubai or Riyadh.
- MVP categories: use the five recommended categories only.
- Authentication approach: use Clerk for identity and keep Dealna roles and business permissions in PostgreSQL.
- Database provider: choose Supabase or Neon for a simple managed PostgreSQL setup.
- Voucher policy: one claim per customer per deal in MVP.
- Payment policy: no paid checkout in MVP.
- Language policy: English first, architecture ready for Arabic later.
- Admin policy: all businesses and deals require approval before public visibility.

## 11. Main Risks

| Risk | Impact | Mitigation |
| --- | --- | --- |
| Marketplace feels empty | Customers do not return | Launch one city with seeded/demo supply first |
| Duplicate voucher redemption | Breaks merchant trust | Use transactions, unique constraints, and audit logs |
| Merchant fraud or low-quality deals | Hurts customer trust | Admin approval and category restrictions |
| Scope creep | MVP takes too long | Freeze MVP around the end-to-end redemption loop |
| Compliance issues | Launch risk in regulated categories | Exclude sensitive categories initially |
| Weak demo narrative | Portfolio impact drops | Build and document one polished end-to-end flow |

## 12. My Recommended Next Step

The next step is to turn the roadmap into implementation tickets and start Phase 1. The first technical milestone should produce a running Next.js app with authentication, roles, database migrations, seeded categories, and the first dashboard shells.
