# Client-Side E-Commerce Application

A modular Java console application designed as a final academic project. This repository contains the primary controller interface that establishes the client-side user experience, simulating catalog browsing, cart management, and checkout pipelines.

---

## Technical Stack
*   **Language:** Java (JDK 17 or higher)
*   **Architecture:** Command-Line Interface (CLI) text loop
*   **Programming Paradigm:** Object-Oriented Programming (OOP) structural design

---
## Core Flow Architecture
The application runs an infinite execution loop driven by standard input parsing to navigate across client sub-modules:
*   **Main Menu Dashboard:** Entry gateway managing operational states.
*   **Product Catalog View:** Interface stub intended for product listing, search mechanics, and cart additions.
*   **Shopping Cart Manager:** Interface stub intended to track client items, quantities, and pricing calculations.
*   **Checkout Simulator:** Processing pipeline interface intended for order placement and validation.

---
## File Structure
The project consists strictly of the primary execution coordinator located in the root of the source directory:
```text
FinalProject/
├── docs/          # Project documentation files
├── src/           # Application source directory
│   ├── Main.java  # Core application entry point and user routing logic
│   └── Main.class # Compiled Java bytecode executable
└── README.md      # Technical documentation reference
```

---

## Prerequisites
*   Java Development Kit (JDK) 17 or higher
*   A command-line terminal environment (Bash, PowerShell, or Zsh)

---
## Compilation & Execution
Follow these steps in your terminal to clone, compile, and run the project locally:

### 1. Clone the Repository
Clone the project tracking data from GitHub and move into the project root directory:
```bash
git clone https://github.com
cd FinalProject
```

### 2. Code Compilation
Compile the raw source file directly inside the source workspace:
```bash
javac src/Main.java
```
*Note: This operation outputs the executable bytecode binary file (`src/Main.class`) alongside your code.*

### 3. Runtime Execution
Launch the compiled entry class binary from the root project directory:
```bash
java -cp src Main
```


---
1. Upon execution, select an integer option `(1-4)` from the console command prompt.
2. Enter submenu actions using standard text responses as prompted.
3. Exit the execution loop gracefully by choosing option `4`.

---

## Contributors
*   **NowellKFiler** - *Lead Developer* - [GitHub Profile](https://github.com/NowellKFiler)
*   **SyafiqKarmen** - *Technical Lead* - [GitHub Profile](https://github.com/SyafiqKarmen)
*   **Kenzoku00** - *Software Architect* - [GitHub Profile](https://github.com/Kenzoku00)

---

## License
Developed exclusively for educational evaluation as a final project submission.
