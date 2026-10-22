# Smart Pantry Manager

## 1. Project Overview

Smart Pantry Manager is an Android application developed using Java and SQLite. The application helps users manage ingredients stored in their pantry, update ingredient information, remove ingredients, and identify recipes that can be prepared using available ingredients.

The application was developed as part of the Mobile App Development 700 assignment.

## 2. Project Objectives

The main objectives of Smart Pantry Manager are to:

- Provide a simple interface for managing pantry ingredients.
- Allow users to add, view, edit and delete ingredients.
- Store pantry information locally using an SQLite database.
- Match available pantry ingredients with predefined recipes.
- Display recipe information to help users decide what they can prepare.
- Demonstrate Android application development, database integration and user interface design.

## 3. Main Features

### Pantry Management

Users can add ingredients to their pantry, view stored ingredients, update existing information and remove ingredients when they are no longer needed.

### Local Database

The application uses SQLite to store pantry information locally on the device.

### Recipe Matching

The application compares the ingredients and quantities available in the pantry with the requirements of predefined recipes. Recipes are suggested when the available ingredients meet the application's matching requirements.

### Recipe Information

Users can view available recipe suggestions and access recipe details where supported by the application.

### Input Validation

The application handles ingredient input through its forms. Validation behaviour can be tested using empty or invalid entries.

## 4. Technologies Used

- **Programming language:** Java
- **Platform:** Android
- **Database:** SQLite
- **Development environment:** Android Studio
- **Build system:** Gradle
- **Version control:** Git and GitHub
- **Testing:** Android emulator and Appetize

## 5. Project Structure

The project contains the following main files and resources:

- `DB.java` — database operations and recipe data.
- `PantryActivity.java` — pantry screen and ingredient management.
- `EditIngredientActivity.java` — ingredient editing functionality.
- `RecipesActivity.java` — recipe suggestions and matching.
- `RecipeDetailActivity.java` — recipe detail screen.
- `SettingsActivity.java` — application settings screen.
- `UI.java` — reusable user interface components.
- `AndroidManifest.xml` — Android application configuration.
- `res/values/styles.xml` — application styling resources.
- `build.gradle` — Gradle build configuration.

## 6. Recipe Database

The application includes predefined recipes intended to demonstrate ingredient-based recipe matching. The recipe collection includes examples such as scrambled eggs, boiled eggs, cheese omelette, sandwiches, porridge, pasta dishes, rice dishes, potato dishes, carrot salad and banana milkshake.

Recipe suggestions depend on the ingredients and quantities stored in the pantry.

## 7. Testing

The application was tested using Appetize to check its main functionality.

The tests performed included:

- Launching the application and opening the pantry screen.
- Adding ingredients to the pantry.
- Editing existing ingredient information.
- Removing ingredients from the pantry.
- Checking whether ingredient suggestions changed when pantry quantities were updated.
- Testing recipe matching using available ingredients.

During recipe-matching tests, Cheese Omelette and Scrambled Eggs appeared when the pantry contained eggs, cheese and butter in the tested quantities. After the cheese quantity was reduced, Cheese Omelette disappeared while Scrambled Eggs remained available.

Additional screenshots will be captured to document the application's screens and test results.

## 8. Building the Project

To build the project locally:

1. Clone or download the repository.
2. Open the project in Android Studio.
3. Configure the Android SDK for the local computer.
4. Allow Gradle to sync and download the required dependencies.
5. Build and run the application on an Android emulator or compatible Android device.

The Android SDK path is specific to each computer and should be configured locally rather than committed to the repository.

Alternatively, on a Windows computer with the required Android SDK installed, run the Gradle wrapper from the project root:

```powershell
.\gradlew.bat assembleDebug
```

## 9. Project Status

The core pantry management functions have been tested, including adding, editing and deleting ingredients. Recipe matching has also been tested using sample pantry quantities.

Further evidence collection and assignment documentation will be completed as part of the final submission.

## 10. Conclusion

Smart Pantry Manager demonstrates how an Android application can combine Java, SQLite and a user-friendly interface to manage pantry ingredients and suggest recipes. The project applies mobile application development concepts, local data storage and basic ingredient-based matching to a practical everyday problem.
