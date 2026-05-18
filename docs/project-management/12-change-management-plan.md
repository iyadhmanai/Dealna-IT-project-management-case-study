# Change Management Plan

## Purpose

This plan defines how changes to Dealna's MVP scope, timeline, requirements, and priorities should be handled.

## Change Management Principle

The MVP should stay focused on the end-to-end redemption flow. Any change that does not support this flow should usually be deferred.

## What Counts as a Change

A change request is any proposed adjustment that affects:

- MVP scope.
- Functional requirements.
- Non-functional requirements.
- Timeline.
- Cost estimate.
- Architecture.
- Security model.
- Compliance exposure.
- User roles or permissions.
- Data model.

## Change Request Template

```md
# Change Request

## Request ID

CR-001

## Requested Change

Describe the proposed change.

## Reason

Explain why the change is needed.

## Affected Areas

- Scope
- Timeline
- Cost
- Risk
- Architecture
- User experience

## Impact Assessment

Describe expected effort, risks, and dependencies.

## Recommendation

Approve / Reject / Defer

## Decision

Approved / Rejected / Deferred

## Decision Date

YYYY-MM-DD
```

## Change Evaluation Criteria

Each request should be evaluated using these questions:

- Does it support the core MVP redemption loop?
- Is it required for security, compliance, or data integrity?
- Does it reduce risk?
- Does it improve demo value significantly?
- Can it be delivered without delaying Must Have features?
- Can it be deferred without harming the MVP?

## Approval Levels

| Change Type | Approval |
| --- | --- |
| Minor copy or UI adjustment | Project Manager |
| Requirement clarification | Product Owner |
| New Should Have or Could Have feature | Product Owner and Project Manager |
| New Must Have feature | Product Owner, Project Manager, and Sponsor |
| Architecture change | Developer and Project Manager |
| Security or compliance change | Product Owner, Developer, and Project Manager |
| Timeline or cost change above 10% | Sponsor |

## Change Workflow

1. Capture the change request.
2. Assess impact on scope, timeline, cost, risk, and quality.
3. Classify the change as Must, Should, Could, or Won't.
4. Decide whether to approve, reject, or defer.
5. Update requirements, roadmap, backlog, and estimates if approved.
6. Communicate the decision to affected stakeholders.

## Change Log

| ID | Change | Status | Decision Date | Owner |
| --- | --- | --- | --- | --- |
| CR-001 | Initial MVP scope baseline | Approved | TBD | Project Manager |

## Scope Protection Rules

- Paid checkout is deferred until after MVP.
- Native mobile apps are deferred until after MVP.
- Multi-city launch is deferred until one city works well.
- Advanced analytics are deferred until basic metrics exist.
- Arabic localization is planned for post-MVP unless required by the selected launch scenario.
- Sensitive regulated categories are excluded unless reviewed separately.

## Portfolio Note

For job applications, this plan shows that scope changes are not handled informally. They are captured, assessed, approved, rejected, or deferred through a clear process.
