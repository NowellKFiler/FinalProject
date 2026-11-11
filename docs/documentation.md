Regarding this, I have interpreted at which the current program has talked much about OOP (Object-Oriented Programming), and thus it has come to my assumptions that we must implement those things via the Four Pillars of OOP. These being:
- Abstraction
- Polymorphism
- Inheritance
- Encapsulation

Thus, the program should reflect those. By Wednesday, 11/11/2026, I've only written the base function for Products (which is an abstract) and one class that extends it, that being Electronics. Hopefully there could be some more addtions for other classes, but that's that and this is this.
As much as I hate OOP due to dependencies and redundant tasks, this is used for a finals, so there's nothing more to be done than doing it for the grades. This is also the first time I'm using git and gh, so expect a few noisy histories.
I plan to add User for Identity as a class, store that stores products. Maybe orders if it cant be bypassed since OOP.

Thus:
Product.java       (abstract)  		 ← abstraction
Electronics.java   extends Product 	 ← inheritance
Clothing.java      extends Product 	 ← inheritance (2nd subclass, needed for polymorphism)
User.java          (abstract)  		 ← abstraction, 2nd hierarchy
Admin.java         extends User
Customer.java      extends User
Store.java        					 ← composition + encapsulation
Main.java         					 ← demo
