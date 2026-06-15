# Java Object-Oriented Programming (OOP): Polymorphism & Interfaces

This repository explores the concept of **Polymorphism** in Java, focusing on the differences between compile-time and runtime polymorphism, when to use classes versus interfaces, and includes a hands-on programming challenge.

---

## Core Concepts Explained

### 1. What is Polymorphism?
Polymorphism means **"many forms."** It allows a single method, interface, or object to behave differently depending on the context or the object invoking it.

Java supports two types of polymorphism:
*   **Compile-Time Polymorphism (Static Binding):** Achieved through **Method Overloading** (same method name, different parameter lists within the same class). It is resolved by the compiler.
*   **Runtime Polymorphism (Dynamic Binding):** Achieved through **Method Overriding** (a subclass redefines a parent method). The Java Virtual Machine (JVM) resolves which method to run while the program is executing.

### 2. Classes vs. Interfaces: When to Use Which?

| Feature | Parent Class (Inheritance) | Interface (Contract) |
| :--- | :--- | :--- |
| **Primary Use Case** | When objects share **identical code logic** and data fields. | When objects share **behavior names** but execute them completely differently. |
| **Inheritance Limit** | A class can extend only **one** parent class. | A class can implement **multiple** interfaces. |
| **State/Variables** | Can hold instance variables to maintain state. | Cannot hold instance variables (only constants). |

```java
// Parent Class managing shared state and code
class Animal {
    String name;

    // Both Dog and Cat will use this EXACT logic
    void sleep() {
        System.out.println(name + " is sleeping... Zzz");
    }
}

class Dog extends Animal {
    void bark() { System.out.println("Woof!"); }
}

class Cat extends Animal {
    void meow() { System.out.println("Meow!"); }
}
```

```java
// Interface enforcing pure behavior with NO shared code or variables
interface Upgradable {
    void installUpdate(); 
}

class OperatingSystem implements Upgradable {
    public void installUpdate() {
        System.out.println("Downloading GBs of files, restarting computer, rewriting kernel.");
    }
}

class VideoGame implements Upgradable {
    public void installUpdate() {
        System.out.println("Downloading new weapon skins and updating matchmaking maps.");
    }
}
```
#### In the above Examples:
*   **Use a Class:** A `Dog` and a `Cat` both share the exact same `sleep()` logic from an `Animal` parent class.
*   **Use an Interface:** An `OperatingSystem` and a `VideoGame` share zero code logic under the hood, but both must support an `installUpdate()` method. They can both implement an `Upgradable` interface.

### 3. Technical Reference: Method Overloading vs. Method Overriding

| Feature | Method Overloading (Compile-Time) | Method Overriding (Runtime) |
| :--- | :--- | :--- |
| **Definition** | Multiple methods in the **same class** share the same name but have **different parameters**. | A **subclass** redefines a method that it inherited from its **parent class** using the exact same signature. |
| **Relationship** | Happens within a single, isolated class. | Requires an inheritance relationship (Parent-Child). |
| **Method Signature**| Must have different arguments (count, types, or order). | Must have the exact same name, return type, and arguments. |
| **Binding Time** | **Static Binding** (resolved by the compiler ahead of time). | **Dynamic Binding** (resolved by the JVM while the program runs). |
| **Purpose** | Adds flexibility so a method can handle different types or numbers of input data. | Implements specific behavior for a generic action defined by a parent class. |
| **Annotation** | No special annotation is used. | Uses the `@Override` compiler tracker. |

```java
// Method Overloading Example
class Calculator {
    // Overloaded method: takes two integers
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method: takes three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method: takes two doubles
    double add(double a, double b) {
        return a + b;
    }
}
```

```java
// Method Overriding Example
// Parent Class
class Animal {
    void makeSound() {
        System.out.println("The animal makes a sound");
    }
}

// Subclass 1
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("The dog barks: Woof!");
    }
}

// Subclass 2
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("The cat meows: Meow!");
    }
}

public class Main {
    public class Main {
    public static void main(String[] args) {
        // Parent reference pointing to parent object
        Animal myAnimal = new Animal(); 
        
        // Parent reference pointing to Dog object (Upcasting)
        Animal myDog = new Dog();       
        
        // Parent reference pointing to Cat object (Upcasting)
        Animal myCat = new Cat();       

        myAnimal.makeSound(); // Outputs: The animal makes a sound
        myDog.makeSound();    // Outputs: The dog barks: Woof!
        myCat.makeSound();    // Outputs: The cat meows: Meow!
    }
}
```

---

# Hands-On Challenge

### Scenario
Create a simple program that demonstrates the use of a parent-child relationship and runtime polymorphism to compute structural properties of different geometric shapes.

### 1. Base Class: Shape
Define a parent class with the following components:

*   **Attributes:** `color` (String) and `isFilled` (boolean).
*   **Constructor:** Initialize these two attributes.
*   **Methods:** 
    *   `calculateArea()`: Returns a `double` value of `0.0`.
    *   `printDetails()`: Prints: `"This is a [color] shape. Filled status: [isFilled]."`

### 2. Subclass: Circle
Create a `Circle` class that inherits from `Shape`:

*   **Additional Attribute:** `radius` (double).
*   **Constructor:** Use the parent constructor (`super`) to initialize `color` and `isFilled`, then initialize `radius`.
*   **Methods:**
    *   Override `calculateArea()` to return the actual mathematical area (π × radius²). *Hint: Use `Math.PI`.*
    *   Override `printDetails()` to print: `"This is a [color] Circle with radius [radius]. Area: [calculated area]."`

### 3. Subclass: Rectangle
Create a `Rectangle` class that also inherits from `Shape`:

*   **Additional Attributes:** `width` (double) and `height` (double).
*   **Constructor:** Use the parent constructor (`super`) to initialize the inherited attributes, then initialize `width` and `height`.
*   **Methods:**
    *   Override `calculateArea()` to return the total area (width × height).
    *   Override `printDetails()` to print: `"This is a [color] Rectangle with dimensions [width]x[height]. Area: [calculated area]."`