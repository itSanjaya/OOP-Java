# The Core Philosophy: Blueprint vs. Reality

* In OOP, everything revolves around two concepts: `Classes` and `Objects`.

* `The Class (The Blueprint)`: A class is a conceptual design. It does not exist in memory. It simply defines what data an entity will hold and what actions it can perform.

* `The Object (The Instance)`: An object is the physical realization built from that blueprint. It lives in your computer's memory and holds actual data.

* `Analogy`: \
Think of an architect's sketch of a house. You cannot live in the sketch; it is just paper. That is the Class. When construction workers use that sketch to build a physical house of brick and mortar, that built house is the Object. You can use that same single sketch to build 50 identical houses on the same street.

## Anatomy of a Java Class

A class is made up of two primary components:

*   **Attributes (Fields / Variables):** What the object knows (its data).
*   **Methods (Functions):** What the object does (its behavior).

Let us look at a clean, strict Java class representing a Smartphone.

```java
//This is the sketch
public class Smartphone {
    String brand;
    String model;
    int batteryPercentage;

    //This is called Constructor (Building Phase), this runs immediately when we create an object from this class.
    Smartphone(String chosenBrand, String chosenModel){
        this.brand = chosenBrand;
        this.model = chosenModel;
        this.batteryPercentage = 100; // New phone fully charged
    }

    //Now methods (behaviors)
    void watchVideo(int minutes){
        int energyCost = minutes *2; // Watching video consumes 2% battery per minute
        this.batteryPercentage -= energyCost;
        System.out.println("Watched video for " + minutes + " minutes. Battery now at: " + this.batteryPercentage + "%");
    }
}
```

### Creating and Using Objects
To bring our blueprint to life, we use the new keyword inside our main program. This allocates memory for our object.

```java
public class Main {
    public static void main(String[] args){
        //Creating different objects from the same class (same blueprint, different realities)
        Smartphone professorPhone = new Smartphone("Apple", "iPhone 14");
        Smartphone myPhone = new Smartphone("Samsung", "Galaxy S23");

        // Accessing attributes of the objects
        System.out.println("Professor's phone is " + professorPhone.brand + " " + professorPhone.model);

        // Using methods of the objects
        myPhone.watchVideo(30); // Watch video for 30 minutes
    }
}
```

### The Assignment Question
Create a `Book` class that tracks reading progress. The class must meet the following criteria:
1. Hold three attributes: `title` (String), `author` (String), and `totalPages` (int).
2. Include a constructor to initialize these values upon object creation.
3. Include a method named `readPages(int pagesRead)` that subtracts the read pages from `totalPages` and prints the remaining page count.

---

###  How to Run the Application

You can execute this program using the manual terminal commands or built-in IDE controls. Make sure you are inside the project root directory before executing commands.

#### Using the Terminal (Recommended)

1. **Compile the source code**:
   Convert the human-readable `.java` file into machine-readable bytecode.
   ```bash
   javac Main.java
   ```
   *(Note: If you split your classes into multiple files, use `javac Book.java Main.java` instead).*

2. **Run the compiled class**:
   Execute the program using the Java launcher. Do not include file extensions like `.java` or `.class`.
   ```bash
   java Main
   ```