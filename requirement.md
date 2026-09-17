# Requirements Specification

**Project Title:** Inventory & Stock Management System  
**Course:** Object-Oriented Programming (Java)  
**Student Name:** Kanishka  
**Registration Number:** 25BAI10070  

---

## 1. Functional Requirements

- **FR-1: Product Catalog Management**
  - The system shall store item records containing SKU/ID, description/name, unit price, stock quantity, and minimum safety threshold.
  - Each item shall be associated with a verified vendor/supplier profile.

- **FR-2: Inward Stock Replenishment (Restocking)**
  - The system shall allow restocking existing catalog items by a specified positive quantity.
  - The system shall record a corresponding transaction log entry with details and notes.

- **FR-3: Outward Stock Dispatch with Defensive Validation**
  - The system shall validate requested dispatch quantities against current available inventory before deduction.
  - If requested units exceed available stock, the operation shall abort with an error, preventing negative inventory balances.

- **FR-4: Automated Low-Stock Alerting**
  - The system shall identify and display all inventory items where current stock is less than or equal to the defined threshold level.

- **FR-5: Audit Trail & Transaction Logging**
  - Every successful restock or dispatch operation shall append an immutable transaction entry (type, item ID, quantity, notes, timestamp).

- **FR-6: Cumulative Valuation Reporting**
  - The system shall calculate and display the total monetary holding value of inventory ($Value = \sum (\text{Price} \times \text{Quantity})$).

---

## 2. Non-Functional Requirements

- **NFR-1: Usability & Accessibility**
  - Provide an interactive, numbered command-line menu interface requiring no complex graphical framework configuration.

- **NFR-2: Data Integrity & Robustness**
  - Validate all numeric and string inputs to avoid runtime exceptions (e.g., input buffer clearing on scanner readings).

- **NFR-3: Modularity & Code Quality**
  - Maintain strict separation of concerns across dedicated OOP classes (`Item`, `Supplier`, `StockTransaction`, `InventoryManager`, `Main`).

- **NFR-4: In-Memory Performance**
  - Utilize standard Java Collections (`ArrayList`) for fast $O(N)$ lookup and lightweight in-memory footprint without requiring an external database setup.

---

## 3. Environment & Compatibility

- **Language:** Java Standard Edition (JDK 17 or higher)
- **Runtime Dependencies:** Standard Java Library (`java.util.*`, `java.time.*`)
- **Execution Platform:** Cross-platform command-line execution (Windows / Linux / macOS)
