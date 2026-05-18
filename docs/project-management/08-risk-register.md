# Risk Register

## Risk Rating Scale

Probability and impact are rated as Low, Medium, or High. Priority is based on the combination of probability and impact.

| ID | Risk | Probability | Impact | Priority | Mitigation | Owner |
| --- | --- | --- | --- | --- | --- | --- |
| R-001 | MVP scope becomes too large | High | High | High | Freeze MVP around the end-to-end redemption flow and defer non-core features | Project Manager |
| R-002 | Voucher can be redeemed more than once | Medium | High | High | Use database transactions, status checks, unique constraints, and audit logs | Developer |
| R-003 | Merchant can redeem another business's voucher | Medium | High | High | Enforce server-side ownership checks during redemption | Developer |
| R-004 | Marketplace feels empty in first launch city | Medium | High | High | Start with one city and seed enough demo businesses and deals | Product Manager |
| R-005 | Weak admin moderation creates low-quality deals | Medium | High | High | Require approval before businesses or deals become public | Product Manager |
| R-006 | Compliance-sensitive categories create legal risk | Medium | High | High | Exclude medical procedures, finance, insurance, tobacco, prescription medicines, and unclear alcohol-related offers from MVP | Product Manager |
| R-007 | Authentication and role model become complex | Medium | Medium | Medium | Choose a proven auth approach and keep roles limited to customer, merchant, and admin | Developer |
| R-008 | QR scanning is unreliable on mobile browsers | Medium | Medium | Medium | Support manual voucher code redemption as a fallback | Developer |
| R-009 | Estimate is too optimistic | Medium | Medium | Medium | Use milestone reviews and add contingency to effort estimates | Project Manager |
| R-010 | Hosting or database costs increase | Low | Medium | Low | Use free or low-cost managed services for MVP | Project Manager |
| R-011 | Poor mobile usability hurts demo quality | Medium | Medium | Medium | Prioritize responsive customer and merchant redemption screens | Developer |
| R-012 | Lack of tests reduces confidence | Medium | High | High | Add unit, integration, and one end-to-end test for the core flow | Developer |
| R-013 | Admin approval workflow is unclear | Medium | Medium | Medium | Define explicit statuses and acceptance criteria | Product Manager |
| R-014 | Data model does not support future localization | Low | Medium | Low | Store country, city, currency, and category metadata clearly | Developer |
| R-015 | Portfolio reviewers do not understand project value | Medium | Medium | Medium | Add executive summary, demo script, and PM documentation | Project Manager |

## Top Risks To Monitor

The top three risks are:

1. Scope creep.
2. Duplicate or unauthorized voucher redemption.
3. Weak marketplace trust caused by poor approval controls.

These risks should be reviewed at every milestone.
