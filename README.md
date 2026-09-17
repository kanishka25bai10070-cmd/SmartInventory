# SmartInventory
# Inventory & Stock Management System

A CLI-based in-memory inventory control and transactional tracking application developed in Core Java (JDK 21+) using Object-Oriented Programming (OOP) paradigms.

---

## 📌 Project Overview
The **Inventory & Stock Management System** simulates core retail and warehouse operations without requiring heavy third-party dependencies or external databases. It tracks product catalogs, handles stock inward (restock) and outward (dispatch) operations with defensive input validations, issues automated low-stock warnings, and calculates cumulative holding valuations.

---

## 🚀 Key Features
- **Product & Supplier Association:** Manages item catalogs linked directly to vendor contact records via aggregation.
- **Defensive Transaction Handling:** Enforces balance verification before dispatches to prevent negative inventory states.
- **Low-Stock Alerting:** Automatically detects items dipping below configured minimum threshold levels.
- **Audit Logging:** Logs transactional records (`RESTOCK`, `DISPATCH`) with unit counts, reasons/batches, and timestamps.
- **Valuation Analytics:** Computes the total real-time financial asset valuation of warehouse inventory.

---

## 🏗 System Architecture & Class Design
The application is structured into five modular components under the source directory:

- `Supplier.java`: Vendor metadata model (Supplier ID, Company Name, Contact Information).
- `Item.java`: Core item model encapsulating stock quantities, unit pricing, minimum safety thresholds, and validation methods.
- `StockTransaction.java`: Data model recording movement history (transaction type, quantity, reference notes).
- `InventoryManager.java`: Business service logic handling item lookups, additions, dispatches, audits, and financial aggregations.
- `Main.java`: Interactive command-line interface managing user inputs, menu loops, and system displays.

---

## ⚙️ Requirements & Prerequisites
- **JDK:** Java Development Kit 17 or higher (tested on JDK 21 / OpenJDK 26)
- **IDE / Environment:** IntelliJ IDEA, Eclipse, VS Code, or command-line terminal
- **Dependencies:** Standard Java SE Library (`java.util.Scanner`, `java.util.ArrayList`)

---

## 🛠 Compilation & Execution

### Running via Terminal / Command Line:
1. Navigate to the project root directory:
   ```bash
   cd SmartInventory
