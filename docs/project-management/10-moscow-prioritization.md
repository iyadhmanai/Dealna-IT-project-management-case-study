# MoSCoW Prioritization

## Purpose

This document separates the Dealna feature set into Must Have, Should Have, Could Have, and Won't Have for the MVP.

## Must Have

These are required for the MVP to be considered complete.

| Feature | Reason |
| --- | --- |
| User registration and login | Required for customer, merchant, and admin flows |
| Role-based access control | Required to separate customer, merchant, and admin permissions |
| Category seed data | Required for browsing and deal creation |
| Merchant business profile | Required before merchants can publish deals |
| Business approval workflow | Required for marketplace trust |
| Deal creation | Required for merchant value |
| Deal submission and approval workflow | Required to control public marketplace quality |
| Public active deal listing | Required for customer discovery |
| Deal detail page | Required before customers claim |
| City and category filters | Required for local marketplace relevance |
| Voucher claiming | Required for the core product loop |
| Unique voucher code | Required for manual redemption |
| QR token generation | Required for QR redemption |
| Voucher wallet | Required for customers to access claimed vouchers |
| Manual voucher redemption | Required as reliable fallback |
| QR voucher redemption | Required for intended in-store flow |
| Single-use redemption enforcement | Required for merchant trust |
| Merchant ownership checks | Required for security |
| Basic admin metrics | Required for operational visibility |
| Basic merchant analytics | Required for merchant value |
| Deployment documentation | Required for portfolio presentation |

## Should Have

These should be included if time allows after the Must Have scope is stable.

| Feature | Reason |
| --- | --- |
| Redemption history page | Useful for merchant operations |
| Audit log viewer | Useful for admin investigation |
| Loading, empty, and error states | Important for demo quality |
| Responsive UI polish | Important for customer and merchant usability |
| Integration tests | Important for quality confidence |
| End-to-end Playwright test | Strong portfolio evidence |
| Seed demo data | Makes demos easier |
| README with screenshots | Improves application and portfolio value |

## Could Have

These are valuable but not necessary for MVP.

| Feature | Reason |
| --- | --- |
| Reviews and ratings | Useful later for trust |
| Saved deals | Nice customer feature |
| Email notifications | Useful but not core to redemption |
| Merchant staff accounts | Useful for real merchants with teams |
| Multi-branch businesses | Important later, complex for MVP |
| Map-based deal discovery | Good UX but extra implementation cost |
| Advanced analytics | Valuable later after real usage exists |
| Arabic localization | Important for MENA, but can follow the English MVP |
| Right-to-left layout support | Important later with Arabic localization |

## Won't Have in MVP

These are intentionally excluded from the first release.

| Feature | Reason |
| --- | --- |
| Native iOS or Android app | Web MVP is faster and cheaper |
| Paid voucher checkout | Adds payment, refund, and accounting complexity |
| Merchant subscription billing | Not needed to prove the redemption loop |
| Automated business verification | Manual review is acceptable for MVP |
| Advanced fraud scoring | Too complex before real usage data |
| AI recommendations | Not needed for first marketplace validation |
| Complex medical offers | Compliance risk |
| Financial products and insurance | Compliance risk |
| Prescription medicines | Compliance risk |
| Tobacco or vape deals | Brand and compliance risk |

## MVP Priority Rule

If a feature does not directly support business approval, deal approval, customer claiming, or single-use redemption, it should be challenged before entering the MVP.
