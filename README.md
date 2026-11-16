# Client-Side E-Commerce Application

A Java console application built as a final academic project to demonstrate the **four pillars of Object-Oriented Programming (OOP)**. The current codebase provides a domain model for products, users, and inventory management; the interactive CLI loop is not yet implemented.

## Tech Stack
- **Language:** Java (JDK 17+)
- **Paradigm:** Object-Oriented Programming (OOP)
- **Interface:** Command-line (CLI) – entry point only at present

## OOP Design
The project is structured around two abstract hierarchies and a composition-based store manager:

| Pillar | Implementation |
|--------|----------------|
| **Abstraction** | `Product` and `User` are abstract base classes with abstract methods (`calculateFinalPrice()`, `getCategory()`, `getRole()`, `canManageProducts()`) |
| **Inheritance** | `Electronics` and `Clothing` extend `Product`; `Admin` and `Customer` extend `User` |
| **Polymorphism** | Concrete subclasses override abstract methods (e.g., `calculateFinalPrice()` per product type) |
| **Encapsulation** | `Store` holds a private `List<Product>`, exposes unmodifiable views, and enforces manager-only mutations via `requireManager()` |

## Source Files
```
FinalProject/
├── docs/
│   ├── documentation.md          # Design rationale (OOP pillars)
│   └── TechStack&InitialSetup.md
├── src/
│   ├── Main.java                 # Entry point (Scanner stub; CLI loop pending)
│   ├── Product.java              # Abstract product base class
│   ├── Electronics.java          # Product subclass
│   ├── Clothing.java             # Product subclass
│   ├── User.java                 # Abstract user base class
│   ├── Admin.java                # User subclass (manager role)
│   ├── Customer.java             # User subclass (customer role)
│   └── Store.java                # Inventory manager (encapsulation + composition)
└── README.md
```

> **Note:** The root README previously described an "infinite execution loop" with menu options, but `Main.java` currently only creates a `Scanner` and closes it. The interactive CLI is a planned feature; the domain model is complete.

## Build & Run
1. **Clone and enter**
   ```bash
   git clone https://github.com/NowellKFiler/FinalProject.git
   cd FinalProject
   ```

2. **Compile all sources**
   ```bash
   javac src/*.java
   ```

3. **Run**
   ```bash
   java -cp src Main
   ```
> **Note:** *The program currently exits immediately because the CLI loop is not yet wired up.*

## Contributors
- **NowellKFiler** – Lead Developer ([GitHub](https://github.com/NowellKFiler))
- **SyafiqKarmen** – Technical Lead ([GitHub](https://github.com/SyafiqKarmen))
- **Kenzoku00** – Software Architect ([GitHub](https://github.com/Kenzoku00))
- **gian451** - Software Architect ([Github](https://github.com/gian451))

## License
Developed exclusively for educational evaluation as a final project submission.
