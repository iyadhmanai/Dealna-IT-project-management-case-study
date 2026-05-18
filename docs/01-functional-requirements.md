# Functional Requirements

## 1. Product Scope

Dealna is a local deals marketplace for the MENA region. Customers discover and claim deals, merchants publish and redeem deals, and admins approve businesses, deals, categories, and platform activity.

The first MVP must prove the full redemption lifecycle:

1. Merchant creates a business profile.
2. Admin approves the business.
3. Merchant creates and submits a deal.
4. Admin approves the deal.
5. Customer browses and claims the deal.
6. Customer receives a unique voucher code and QR code.
7. Merchant redeems the voucher exactly once.

## 2. User Roles

### Customer

Customers can:

- Register and log in.
- Select country and city.
- Browse active deals.
- Search deals.
- Filter deals by city, category, price, discount, expiry, and popularity.
- View deal details.
- Claim an active deal.
- Receive a unique voucher code and QR code.
- View active, redeemed, and expired vouchers.
- View voucher redemption status.

Customers cannot:

- Create businesses or deals.
- Redeem vouchers as merchants.
- Access merchant or admin dashboards.
- View another customer's vouchers.

### Merchant

Merchants can:

- Register and log in.
- Create a business profile.
- Submit a business for approval.
- Create draft deals.
- Submit deals for admin approval.
- Pause, edit, or expire their own deals.
- View claimed vouchers for their own businesses.
- Redeem vouchers using manual code entry.
- Redeem vouchers using QR scanning.
- View basic analytics for their own businesses.

Merchants cannot:

- Approve their own businesses or deals.
- Redeem vouchers belonging to other businesses.
- Access admin dashboard features.
- View other merchants' private analytics.

### Admin

Admins can:

- Log in to the admin dashboard.
- Approve or reject businesses.
- Approve or reject deals.
- Manage categories.
- View users, businesses, deals, and vouchers.
- View platform-level metrics.
- Monitor redemption activity.

## 3. Business Management

### FR-BIZ-001: Business Creation

The system shall allow a merchant to create a business profile with name, description, category, country, city, address, phone, website, and logo.

### FR-BIZ-002: Business Approval Workflow

The system shall create new businesses with `PENDING` status. Admins shall be able to approve, reject, or suspend a business.

### FR-BIZ-003: Deal Publishing Restriction

The system shall only allow merchants to submit publishable deals for approved businesses.

### FR-BIZ-004: Business Ownership

The system shall enforce that merchants can only edit and manage businesses they own or are authorized to operate.

## 4. Deal Management

### FR-DEAL-001: Deal Creation

The system shall allow merchants to create deals with title, description, category, price fields, discount percentage, currency, terms, start date, end date, max claims, and redemption type.

### FR-DEAL-002: Deal Status Workflow

Deals shall support these statuses:

- `DRAFT`
- `PENDING_REVIEW`
- `ACTIVE`
- `PAUSED`
- `EXPIRED`
- `REJECTED`

### FR-DEAL-003: Admin Deal Review

Admins shall be able to approve or reject submitted deals.

### FR-DEAL-004: Public Deal Visibility

Only active, approved, non-expired deals shall appear in public deal listings.

### FR-DEAL-005: Deal Filtering

Customers shall be able to filter active deals by city and category in the MVP. Additional filters such as price, discount, expiry, and popularity may be added after the core flow is complete.

## 5. Voucher Claiming

### FR-VOU-001: Claim Eligibility

The system shall only allow authenticated customers to claim active deals that are within the deal date range and have not reached their max claim limit.

### FR-VOU-002: Unique Voucher Generation

When a customer claims a deal, the system shall generate:

- A human-readable voucher code.
- A high-entropy QR token.
- A stored hash of the QR token.

### FR-VOU-003: Duplicate Claim Prevention

The MVP shall prevent the same customer from claiming the same deal more than once.

### FR-VOU-004: Voucher Wallet

Customers shall be able to view their own vouchers, including active, redeemed, and expired statuses.

### FR-VOU-005: QR Rendering

The voucher detail page shall display a QR code generated from the secure raw QR token or an authenticated token retrieval flow.

## 6. Voucher Redemption

### FR-RED-001: Manual Code Redemption

Merchants shall be able to redeem a voucher by entering its manual voucher code.

### FR-RED-002: QR Redemption

Merchants shall be able to redeem a voucher by scanning a QR code.

### FR-RED-003: Merchant Authorization

The system shall verify that the merchant redeeming the voucher belongs to the business that owns the deal.

### FR-RED-004: Single-Use Enforcement

The system shall make duplicate redemption impossible by performing redemption inside a database transaction.

### FR-RED-005: Redemption Record

Each successful redemption shall create a redemption record containing voucher, business, merchant user, method, metadata, and timestamp.

### FR-RED-006: Audit Log

Each redemption and approval action should create an audit log entry.

## 7. Admin Features

### FR-ADM-001: Business Review Queue

Admins shall have a page listing pending businesses with approve and reject actions.

### FR-ADM-002: Deal Review Queue

Admins shall have a page listing pending deals with approve and reject actions.

### FR-ADM-003: Category Management

Admins shall be able to create, edit, and deactivate categories.

### FR-ADM-004: Platform Metrics

Admins shall be able to view totals for users, customers, merchants, businesses, deals, vouchers, redemptions, pending approvals, and redemption rate.

## 8. Analytics

### Merchant Analytics

The merchant dashboard shall show:

- Total active deals.
- Total claims.
- Total redemptions.
- Redemption rate.
- Most claimed deals.
- Most redeemed deals.
- Recent redemptions.

### Admin Analytics

The admin dashboard shall show:

- Total users.
- Total customers.
- Total merchants.
- Total businesses.
- Pending businesses.
- Active businesses.
- Total deals.
- Pending deals.
- Active deals.
- Total vouchers claimed.
- Total vouchers redeemed.
- Platform redemption rate.

## 9. MVP Acceptance Criteria

The MVP is acceptable when:

- Users can register and log in with roles.
- Categories are seeded.
- Merchants can create and submit businesses.
- Admins can approve or reject businesses.
- Merchants can create and submit deals.
- Admins can approve or reject deals.
- Customers can browse active deals by city and category.
- Customers can claim active deals.
- Vouchers include unique manual codes and QR codes.
- Merchants can redeem vouchers by manual code and QR token.
- Redeemed vouchers cannot be redeemed again.
- Merchants cannot redeem vouchers from another business.
- Basic merchant and admin analytics are visible.
