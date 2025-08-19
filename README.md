# Geeks Cafe - OOP Implementation

## Project Overview
This project is a simple **console-based cafe ordering system** implemented in **Java** using **Object-Oriented Programming (OOP)** concepts.  
It is divided into two parts:

- **Part A** - Basic procedural implementation (non-OOP).  
- **Part B** - Object-Oriented design using classes for `FoodItem`, `Muffin`, `Shake`, `Coffee`, and `Combo`.  

The aim of **Part B** is to practice **encapsulation, inheritance, and polymorphism**, while maintaining the same functionalities from Part A, plus **combo deals**.

---

## Features
- Order **individual items**: Muffins, Coffee, and Shakes.
- **Muffin stock is limited to 25**. Coffee and Shakes have **unlimited stock**.
- Prevents **negative stock**: if a customer orders more muffins than available, the order is rejected.
- Order **combo deals**:
  - Coffee + Muffin (discount: $1.00)
  - Shake + Muffin (discount: $1.00)
- Stock updates automatically after every order.
- Keeps track of **total sales** for each item and overall cafe revenue.
- Provides a **sales summary report** at the end of the session. 

---

## Class Structure
src/
- FoodItem.java # Abstract parent class
- Muffin.java # Subclass (has stock)
- Coffee.java # Subclass (unlimited supply)
- Shake.java # Subclass (unlimited supply)
- Combo.java # Represents a combo (drink + muffin)
- GeeksCafe.java # Main driver program
- GeeksCafeOOp.java # Main Driver program with OOP Concepts

---

## Running the Program
- Open the project in IntelliJ IDEA (or any Java IDE).
- Place each class (FoodItem, Muffin, Coffee, Shake, Combo) in separate .java files under src/.
- Run GeeksCafe.java (the main program).
- Follow the menu prompts in the console.


---

## Running the Program (Command Line)

- Navigate to the `src` folder
cd src

- Compile all Java files
javac *.java

- Run the main program
java GeeksCafe/ java GeeksCafeOOP


---

## Concepts Covered
- Encapsulation - private/protected fields with getters/setters.
- Inheritance - Muffin, Coffee, and Shake inherit from FoodItem.
- Polymorphism - Overriding order() for different item behaviors.
- Abstraction - FoodItem is abstract; cannot be instantiated directly.