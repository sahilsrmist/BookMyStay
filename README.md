# UC 2 - Basic Room Types & Static Availability

**Author:** Sahil Prajapati  
**Date:** 25 March 2026

---

## 🎯 Goal
Introduce object modeling through inheritance and abstraction before introducing data structures, allowing students to focus on domain design rather than optimization.

## 👤 Actor
**User** – runs the application to view predefined room types and their availability.

## 🔄 Flow
1. User runs the application.
2. `Room` objects representing different room types are created.
3. Availability for each room type is stored using simple variables.
4. Room details and availability information are printed to the console.
5. Application terminates.

---

## 🧠 Key Concepts Used

* **Abstract Class:** An abstract class is used to represent a generalized concept that should not be instantiated directly. The `Room` class defines common attributes and behavior shared by all room types while enforcing a consistent structure.
* **Inheritance:** Concrete room classes (`SingleRoom`, `DoubleRoom`, `SuiteRoom`) extend the abstract `Room` class. This allows shared properties to be reused while enabling specialization for each room type.
* **Polymorphism:** Room objects are referenced using the `Room` type, enabling uniform handling of different room implementations. This prepares the system for future extensibility without changing client code.
* **Encapsulation:** Room attributes such as number of beds, size, and price are encapsulated within the `Room` class. This ensures that room characteristics are controlled and modified only through defined behavior.
* **Static Availability Representation:** Room availability is stored using simple variables rather than data structures. This intentionally highlights the limitations of hardcoded and scattered state management.
* **Separation of Domain and State:** Room objects represent what a room is, while availability variables represent current system state. This distinction becomes critical when inventory management is introduced later.

---

## ✅ Key Requirements

- [ ] Define an abstract `Room` class with common attributes.
- [ ] Create concrete room classes for Single, Double, and Suite rooms.
- [ ] Initialize room objects in the application entry point.
- [ ] Store room availability using individual variables.
- [ ] Display room details and availability to the console.
# BookMyStay
  Hotel Booking Management System <br>
  (App-Based Learning Using Core Java &amp; Data Structures) <br>

# Objective
  This project focuses on the design and implementation of a Hotel Booking Management System to demonstrate how Core Java and     fundamental data structures are applied to solve real-world software engineering challenges. <br>
  Rather than treating data structures as isolated theory, the system shows how they enable: <br>
    --> Fair request handling using FIFO principles <br>
    --> Real-time inventory consistency across booking operations <br>
    --> Prevention of double-booking through uniqueness enforcement <br>
    --> Extensible and maintainable system design suitable for real applications <br>
  
# Learning Approach
  The application is developed incrementally, with each use case introducing one new concept at a time while reinforcing          previously learned ideas. Every design decision is intentional and mirrors how production systems evolve—from simple, rigid     implementations to scalable, robust architectures. <br>

# Each stage highlights:
  --> Why a specific data structure is needed <br>
  --> What problem it solves in a real business context <br>
  --> What limitations exist before refactoring <br>
  
# Scope & Focus
  --> The emphasis is on data structures, object-oriented design, and advanced Java concepts <br>
  --> User input and UI handling are intentionally minimized to maintain focus on core logic and system behavior <br>
  --> All interactions are deterministic and console-based for clarity, traceability, and ease of debugging <br>
  
# Outcome
  By the end of this project, learners will understand not only how to use Java data structures, but when and why to use them—    bridging the gap between academic knowledge and real-world system design. <br>
