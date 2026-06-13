## The Core Problem: Unrestricted Data Access

In an unencapsulated class (like the `Smartphone` class in Module 1), any external class can directly modify an object's fields using the dot (`.`) operator:

```java
Smartphone faultyPhone = new Smartphone("Apple", "iPhone 14");
faultyPhone.batteryPercentage = -5000; // Technical and logical corruption!
```

This violates real-world physics, bypasses all application rules, and breaks system stability. To prevent this, software engineers utilize **Encapsulation**.

---

## 1. Access Modifiers (The Gatekeepers)

Java provides four levels of access control to explicitly define which parts of a program can see and modify your code's data:

| Modifier | Inside Same Class | Inside Same Package | Inside Subclass (Different Package) | Anywhere Globally |
| :--- | :--- | :--- | :--- | :--- |
| **`private`** | ✅ Yes | ❌ No | ❌ No | ❌ No |
| **`default`** (No modifier) | ✅ Yes | ✅ Yes | ❌ No | ❌ No |
| **`protected`** | ✅ Yes | ✅ Yes | ✅ Yes | ❌ No |
| **`public`** | ✅ Yes | ✅ Yes | ✅ Yes | ✅ Yes |

>  **Edge Case Danger:** If you omit an explicit access modifier (e.g., writing `String brand;`), Java automatically applies the **default (package-private)** modifier. This allows *any* rogue file located within the exact same folder package to step in and alter your variables without validation.

---

## 2. Implementing Strict Encapsulation

To implement true encapsulation, we follow a strict two-step pattern:
1. Declare all fields as `private`.
2. Expose specific data processing through public **Getter** (`getX()`) and **Setter** (`setX()`) methods containing rigorous input validation.

### Refactored Smartphone Blueprint

```java
public class Smartphone {
    // 1. Private fields completely safe from external direct tampering
    private String brand;
    private String model;
    private int batteryPercentage;

    // 2. Secure Constructor
    public Smartphone(String brand, String model) {
        // Edge Case: Intercepting null, empty, or whitespace-only inputs
        if (brand == null || brand.trim().isEmpty()) {
            this.brand = "Unknown Brand";
        } else {
            this.brand = brand;
        }
        
        this.model = (model != null) ? model : "Unknown Model";
        this.batteryPercentage = 100; // Guaranteed safe initialized state
    }

    // 3. Read-Only Access (Getter)
    public String getBrand() {
        return this.brand; 
    }

    public int getBatteryPercentage() {
        return this.batteryPercentage;
    }

    // 4. Controlled Write Access with Input Validation (Setter)
    public void setBatteryPercentage(int batteryPercentage) {
        // Edge Case: Clipping out-of-bounds metrics to acceptable minimum/maximum
        if (batteryPercentage < 0) {
            this.batteryPercentage = 0; 
        } else if (batteryPercentage > 100) {
            this.batteryPercentage = 100;
        } else {
            this.batteryPercentage = batteryPercentage;
        }
    }

    // 5. Business Logic Method
    public void watchVideo(int minutes) {
        // Edge Case: Disallowing zero or negative time values
        if (minutes <= 0) {
            System.out.println("Invalid video duration.");
            return; // Immediate early termination
        }

        int energyCost = minutes * 2;
        
        // Mutate data safely using our internal validation framework
        setBatteryPercentage(this.batteryPercentage - energyCost);
        System.out.println("Watched video. Current battery: " + this.batteryPercentage + "%");
    }
}
```

---

## 3. The `this` Keyword & Variable Shadowing

Inside the constructor or setters, you notice the syntax `this.brand = brand;`. 
* **`brand`** (Right side): Refers to the local execution parameter variable passed into the method argument.
* **`this.brand`** (Left side): Refers explicitly to the specific field belonging to the unique object instance currently living on the memory heap.

If you write `brand = brand;` without `this.`, Java encounters **Variable Shadowing**. The local argument variable completely obscures the class field. Java assigns the value back to itself locally, leaving the object's instance variable permanently uninitialized (`null`).

---

## 4. The Architecture of JVM Memory Management

When you run a Java program, the JVM organizes memory into distinct areas to manage data efficiently:
1. **The Stack**: A fast memory environment that holds immediate method primitives and direct reference variable pointers (the names of your objects, like `myPhone`).
2. **The Heap**: A large physical memory environment that dynamically stores the raw data structures of the actual objects instantiated via the `new` keyword.
3. **The Link**: The variable on the stack does not contain the object data; it holds a hexadecimal address pointing directly to where that data lives on the heap.


## Module 2 Assignment: Secure Financial Ledger

To verify complete structural comprehension of strict encapsulation and JVM boundary handling, you must engineer a highly secure bank ledger application.

### Functional Requirements
Create a single class file named `BankAccount` that tracks and isolates fiscal properties:

1. **Attributes**: 
   * `accountHolder` (String)
   * `balance` (double)
   * Both fields must be completely inaccessible (`private`) from outside modification.
2. **Constructor**: 
   * Must accept and initialize `accountHolder`. 
   * If a `null`, empty, or whitespace-only name is provided, fall back safely to `"Standard Holder"`.
   * The `balance` attribute must always initialize strictly to exactly `0.0`.
3. **Encapsulation Purity**:
   * Provide a public getter for `accountHolder`.
   * Provide a public getter for `balance`.
   * **Do not create a setter for the balance variable.** (External classes must never be allowed to override balances arbitrarily).
4. **Isolated Business Processing Methods**:
   * `deposit(double amount)`: Increases the underlying balance field. 
     * *Edge Case:* If the deposit amount is zero or negative, reject the transaction and print an explicit error message.
   * `withdraw(double amount)`: Decreases the underlying balance field.
     * *Edge Case 1:* If the withdrawal amount is zero or negative, reject the transaction.
     * *Edge Case 2:* If the user attempts to withdraw more funds than their current `balance` stores, block the operation from execution to prevent an overdraft, maintaining a floor limit of exactly `0.0`. Print a clear error message.

### Compilation and Validation Matrix
Compile your assignment using your command line terminal before review:
```bash
javac BankAccount.java Main.java
java Main
```