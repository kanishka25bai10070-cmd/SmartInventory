# Software Architecture & Design Patterns

## Architectural Overview
The system is built using a multi-tiered structural model tailored for Java console applications:

1. **Presentation Layer (`Main.java`):**
   - Handles the menu display, user console inputs via `Scanner`, and formatted terminal outputs.

2. **Application Service Layer (`InventoryManager.java`):**
   - Coordinates business rules, search operations, stock deductions, safety threshold filters, and cumulative asset mathematics.

3. **Domain Layer (`Item.java`, `Supplier.java`, `StockTransaction.java`):**
   - Encapsulates object data and ensures data integrity through restricted accessors and mutators.

## OOP Principles & Design Patterns
- **Encapsulation:** Class variables are set to `private`, preventing direct external modification. Access is controlled via getters and specific mutators like `addStock()` and `reduceStock()`.
- **Aggregation / Composition:** `Item` has-a `Supplier`, directly coupling vendor contact data without requiring external database foreign keys.
- **Defensive Programming:** The stock deduction method returns a boolean status, ensuring invalid dispatches are intercepted before recording transaction logs.
