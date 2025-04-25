# Modular Android App

This is a modern, scalable Android application built entirely with **Jetpack Compose**, utilizing a **multi-module architecture** and following **Clean Architecture** principles. The app is designed to be modular, testable, and maintainable, using the latest Android development tools and best practices.

## **Tech Stack**

- **Jetpack Compose** – Modern declarative UI toolkit
- **Kotlin Coroutines & Flow** – Asynchronous and reactive programming
- **Hilt** – Dependency injection
- **Room** – Local database management
- **Navigation Component** – For in-app navigation
- **MVVM + Clean Architecture** – Separation of concerns and testability
- **Multi-Module Architecture** – Scalable and organized project structure

---

## **Project Structure**

The project is structured into several modules, categorized as follows:

### **1. App Module**
- The main entry point of the application.
- Sets up navigation, theming, and initializes required dependencies.
- Acts as a host for all features and core modules.

### **2. Build Logic Module**
- Contains Gradle configuration files and custom build logic.
- Helps in maintaining centralized build settings and plugin versions.

---

### **3. Core Modules**

These modules provide shared functionality used across features:

- **`core:common`**  
  Utility classes, constants, and helper functions shared globally.

- **`core:data`**  
  Repository implementations, API interfaces, and data sources (remote and local).

- **`core:database`**  
  Contains Room database setup, entities, DAOs, and database access logic.

- **`core:designsystem`**  
  A shared design system including theme, colors, typography, and reusable UI components.

- **`core:domain`**  
  Business logic layer with use cases and interfaces for repositories.

- **`core:model`**  
  Data models used across different layers of the app (UI, domain, and data layers).

- **`core:ui`**  
  Common UI components, widgets, modifiers, and extensions used across the app.

---

### **4. Feature Modules**

Each feature represents a screen or major section of the app:

- **`feature:home`**  
  Displays the home screen content and logic.

- **`feature:search`**  
  Provides search functionality with relevant UI and business logic.

- **`feature:mygames`**  
  Displays a list or history of games relevant to the user.

Each feature module is fully isolated and communicates with core modules, following clean boundaries.

---

## **Architecture Overview**

The app follows **Clean Architecture**, dividing the codebase into distinct layers:

- **UI Layer**: Built with Jetpack Compose, interacts with ViewModels.
- **Domain Layer**: Contains business logic, use cases, and repository interfaces.
- **Data Layer**: Provides actual data from local Room DB or remote sources via repositories.
