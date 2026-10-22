# SmartPantryManager

## 1. Project Overview

SmartPantryManager is an Android mobile application developed using Java to help users organise pantry ingredients and identify recipes that can be prepared using the ingredients they have available.

The application allows users to record ingredients, manage quantities, update pantry information, and view recipes based on ingredient availability. It uses an SQLite database to store pantry records locally.

## 2. Project Objectives

The main objectives of SmartPantryManager are to:

- Simplify the process of managing pantry ingredients.
- Allow users to add, view, update, and delete ingredient records.
- Keep track of ingredient quantities, units of measurement, and expiry dates.
- Help users identify recipes that match the ingredients available in their pantry.
- Store pantry information locally using SQLite.

## 3. Main Features

### 3.1 Ingredient Management

Users can add ingredients to their pantry and maintain their information. Existing ingredient records can be viewed, edited, and deleted when necessary.

### 3.2 Quantity and Expiry Tracking

The application displays ingredient quantities, units of measurement, and expiry dates to help users keep their pantry information organised.

### 3.3 Recipe Matching

SmartPantryManager compares available pantry ingredients with recipe requirements to identify recipes that can be prepared. The matching results can change when ingredient quantities are updated.

### 3.4 Local Data Storage

The application uses SQLite database functionality to manage pantry records locally on the device.

### 3.5 User Interface

The application includes a pantry screen with ingredient cards, readable ingredient details, and navigation controls designed to make pantry management straightforward.

## 4. Technologies Used

- **Programming Language:** Java
- **Development Environment:** Android Studio
- **Platform:** Android
- **Database:** SQLite
- **Build System:** Gradle
- **Testing Environment:** Appetize browser-based Android emulator
- **Version Control:** GitHub

## 5. Project Structure

The main Java source files are located in `app/src/main/java/com/example/smartpantry/`.

| File | Responsibility |
|---|---|
| `DB.java` | Handles database operations for pantry information. |
| `PantryActivity.java` | Displays pantry ingredients and provides access to ingredient management functions. |
| `EditIngredientActivity.java` | Supports editing ingredient information. |
| `RecipesActivity.java` | Displays recipes based on pantry ingredient availability. |
| `RecipeDetailActivity.java` | Presents recipe details. |
| `SettingsActivity.java` | Provides the application's settings screen. |
| `UI.java` | Contains shared user interface components and styling. |

Additional project files include the Android manifest, style resources, Gradle build scripts, and Gradle wrapper files.

## 6. Application Testing

The application has been tested using Appetize, a browser-based Android emulator.

The following tests have been performed:

- **Ingredient creation:** An ingredient was added successfully.
- **Ingredient display:** Added ingredients appeared in the pantry list.
- **Ingredient editing:** An existing ingredient's quantity was updated successfully.
- **Recipe matching:** Cheese Omelette and Scrambled Eggs initially appeared with the tested ingredients and quantities. After the cheese quantity was reduced from 30 g to 20 g, Cheese Omelette disappeared while Scrambled Eggs remained displayed.
- **Data persistence:** Pantry ingredients remained available after navigating away from the application and reopening it.

Further testing is required to verify data persistence after the application process is fully stopped, as well as to recheck all ingredient management functions and recipe-matching scenarios following the latest interface changes.

## 7. Project Status

SmartPantryManager is currently under development. Core pantry management, local database functionality, and preliminary recipe-matching behaviour have been tested. Additional testing and improvements may be carried out as development progresses.

## 8. Conclusion

SmartPantryManager aims to provide a practical solution for organising pantry ingredients and identifying recipes based on available supplies. By combining an Android interface, Java, and SQLite, the application provides a foundation for managing pantry information and supporting everyday meal planning.
