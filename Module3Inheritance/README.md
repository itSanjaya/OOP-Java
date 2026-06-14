# Practice Question: Fleet Management System (OOP Inheritance)

## Scenario
Create a simple Vehicle Management System that demonstrates the use of a parent-child relationship.

### 1. Base Class: `Vehicle`
Define a parent class with the following components:
* **Attributes:** `make`, `model`, and `year`.
* **Constructor:** Initialize these three attributes.
* **Method:** A method called `startEngine()` that prints: `"The [make] [model]'s engine is now running."`

### 2. Subclass: `Car`
Create a `Car` class that inherits from `Vehicle`:
* **Additional Attribute:** `numDoors` (integer).
* **Constructor:** Use the parent constructor (`super`) to initialize `make`, `model`, and `year`, then initialize `numDoors`.
* **Method:** Override the `startEngine()` method to print: `"The [make] [model] roars to life! It has [numDoors] doors."`

### 3. Subclass: `Truck`
Create a `Truck` class that also inherits from `Vehicle`:
* **Additional Attribute:** `payloadCapacity` (double/float).
* **Constructor:** Use the parent constructor (`super`) to initialize the inherited attributes, then initialize `payloadCapacity`.
* **Method:** Override the `startEngine()` method to print: `"The heavy-duty [make] [model] is rumbling. Payload capacity: [payloadCapacity] tons."`

### 4. Testing
Write a main program that:
* Creates one `Car` object and one `Truck` object with sample data.