# Non-Functional Requirements

## 1. Security

### NFR-SEC-001: Server-Side Authorization

All role and ownership checks must be enforced on the server. UI hiding is not sufficient.

### NFR-SEC-002: Password and Session Security

Passwords must never be stored in plain text. Authentication should use secure cookies or secure JWT handling, depending on the selected auth solution.

### NFR-SEC-003: Voucher Token Security

QR codes must not expose sequential database IDs. QR tokens must be high-entropy random values, and only hashes should be stored in the database.

### NFR-SEC-004: Duplicate Redemption Protection

Voucher redemption must use database transactions and status checks that prevent race-condition based duplicate redemptions.

### NFR-SEC-005: Rate Limiting

Claiming and redemption endpoints should be rate limited to reduce abuse and brute-force voucher attempts.

### NFR-SEC-006: Input Validation

All user-controlled input must be validated with schema validation such as Zod.

## 2. Privacy and Data Protection

### NFR-PRV-001: Data Minimization

The system should collect only the customer and merchant information needed for account operation, business review, and voucher redemption.

### NFR-PRV-002: Merchant Data Boundaries

Merchants must not be able to see private customer data beyond what is necessary to validate and redeem a voucher.

### NFR-PRV-003: Auditability

Approval, rejection, redemption, and sensitive admin actions should be auditable.

## 3. Reliability

### NFR-REL-001: Core Flow Availability

The claim and redemption flows should remain operational during normal traffic spikes from deal campaigns.

### NFR-REL-002: Error Handling

The app must provide clear error states for failed claims, expired vouchers, invalid vouchers, unauthorized access, and duplicate redemption attempts.

### NFR-REL-003: Data Integrity

Voucher, redemption, deal, and claim counts must remain consistent. Claim count increments and voucher creation should be handled transactionally where possible.

## 4. Performance

### NFR-PERF-001: Page Load Performance

Public deal listing and deal detail pages should load quickly on mobile connections. Initial target: Largest Contentful Paint under 2.5 seconds for seeded MVP data.

### NFR-PERF-002: Query Efficiency

Common deal listing filters by city, category, status, and date should be backed by appropriate database indexes.

### NFR-PERF-003: QR Redemption Speed

Manual and QR redemption attempts should return a clear success or failure result within 2 seconds under normal MVP load.

## 5. Usability

### NFR-USE-001: Mobile Responsiveness

Customer-facing pages and merchant redemption screens must work well on mobile devices.

### NFR-USE-002: Simple Merchant Operations

The merchant redemption screen should support fast in-store use with minimal navigation.

### NFR-USE-003: Clear Status Language

Voucher and deal statuses must be obvious to non-technical users.

## 6. Maintainability

### NFR-MNT-001: Type Safety

The project should use TypeScript with strict typing for domain entities, API inputs, and UI data contracts.

### NFR-MNT-002: Database Migrations

All database schema changes must be captured through Prisma migrations.

### NFR-MNT-003: Modular Domain Logic

Claiming, eligibility, voucher generation, redemption, and authorization rules should live in testable service modules rather than being scattered across UI components.

### NFR-MNT-004: Documentation

Architecture decisions, setup steps, environment variables, and demo flows must be documented before portfolio presentation.

## 7. Testing

### NFR-TST-001: Unit Testing

Unit tests should cover voucher generation, deal eligibility, claim validation, redemption validation, role checks, and expiry logic.

### NFR-TST-002: Integration Testing

Integration tests should cover business approval, deal approval, claim flow, redemption flow, duplicate redemption prevention, and merchant ownership enforcement.

### NFR-TST-003: End-to-End Testing

An end-to-end test should cover the full MVP lifecycle from merchant business creation to customer claim to merchant redemption.

## 8. Compliance and Market Suitability

### NFR-COMP-001: Restricted Categories

The MVP should avoid complex medical procedures, financial products, insurance, prescription medicines, tobacco, vape products, and alcohol-related promotions where country-specific rules may apply.

### NFR-COMP-002: Business Verification

Business approval should include enough fields to support manual review of legitimacy, especially for beauty, wellness, tourism, and medical-adjacent categories.

### NFR-COMP-003: Localization Readiness

The system should be designed so currency, city, country, language, and right-to-left layout support can be added later without major rewrites.

## 9. Deployment and Operations

### NFR-OPS-001: Cloud Deployment

The MVP should be deployable on Vercel with a managed PostgreSQL database such as Supabase, Neon, Railway, or Render.

### NFR-OPS-002: Environment Separation

Local, preview, and production environments should use separate environment variables and databases.

### NFR-OPS-003: CI Checks

GitHub Actions should run linting, type checks, tests, and database migration checks before merge.
