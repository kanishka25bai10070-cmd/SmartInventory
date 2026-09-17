# Problem Statement & System Scope

## 1. Problem Definition
Small and medium-scale enterprises frequently rely on manual bookkeeping or fragmented spreadsheets to track retail items and inventory flow. This approach suffers from critical operational bottlenecks:
1. Human Error in Record-Keeping: Dispatches and deliveries are manually entered, causing discrepancies between physical stock and ledger counts.
2. Stockout Vulnerability: Lack of automated threshold alerts means reordering occurs reactively after shelves are empty, leading to delayed fulfillment.
3. Absence of Transactional Audit Logs: Inability to track who dispatched which batch or when inward stock was received hampers inventory reconciliation.

## 2. Proposed Solution
The Inventory & Stock Management System implements an automated, object-oriented console application in Java to provide an in-memory control system. It incorporates:
- Unified catalog tracking linked to vendor data.
- Atomic stock movement logic where dispatches are rejected if available units are insufficient.
- Real-time safety threshold evaluations to notify operators of impending stock depletion.
- Append-only transactional history logs for auditability.

## 3. Functional Scope
- Item management with unit price and safety thresholds.
- Defensive dispatching blocking negative balances.
- Inward stock replenishment.
- Inventory asset valuation and movement transaction logs.

## 4. Academic Declaration
- Developer: Kanishka
- Registration Number: 25BAI10070
- Degree: B.Tech (AIML)
