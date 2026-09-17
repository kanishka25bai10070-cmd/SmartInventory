# Test Plan and Execution Report

## System Test Scenarios

| Test ID | Module | Scenario Description | Input Data | Expected Output | Status |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **TC-01** | Inventory Catalog | View initial product listing | Menu option `1` | Displays all seeded inventory records with pricing and thresholds | Passed |
| **TC-02** | Inward Restock | Increase existing stock level | Item: `ITM101`, Qty: `20`, Note: `Shipment A` | Quantity increments from 45 to 65; `RESTOCK` log saved | Passed |
| **TC-03** | Outward Dispatch | Valid stock issue | Item: `ITM101`, Qty: `10`, Note: `Floor Sale` | Quantity decrements to 55; `DISPATCH` log saved | Passed |
| **TC-04** | Balance Validation | Attempt dispatch exceeding stock | Item: `ITM102`, Qty: `100` (Available: 12) | Rejects transaction with insufficient stock warning; balance untouched | Passed |
| **TC-05** | Safety Monitoring | Real-time threshold alerting | Menu option `5` | Filters and displays all items where $\text{Quantity} \le \text{Threshold}$ | Passed |
| **TC-06** | Valuation Engine | Total inventory holding value | Menu option `6` | Computes cumulative monetary worth: $\sum (\text{Price} \times \text{Quantity})$ | Passed |
| **TC-07** | Transaction Audit | View logged inventory movements | Menu option `7` | Prints append-only chronological log of all restocks and dispatches | Passed |
