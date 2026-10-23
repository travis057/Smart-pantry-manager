# Smart Pantry Manager

## 1. Project Overview

Smart Pantry Manager is an Android application developed using **Java and SQLite**. The application helps users manage ingredients stored in their pantry and identify recipes that can be prepared using the ingredients and quantities currently available.

The application was developed as part of the **Mobile App Development 700** practical assignment.

**GitHub Repository:**  
https://github.com/travis057/Smart-pantry-manager

---

## 2. Project Objectives

The main objectives of Smart Pantry Manager are to:

- Provide a simple mobile interface for managing pantry ingredients.
- Allow users to add, view, edit and delete ingredients.
- Store pantry information locally using an SQLite database.
- Provide a predefined collection of 20 recipes.
- Match available pantry ingredients with recipe requirements.
- Apply strict recipe matching so that partial matches are not suggested.
- Display recipe information and preparation steps.
- Provide input validation when adding or editing pantry ingredients.
- Demonstrate Java Android development, database integration, screen navigation and user interface design.

---

## 3. Main Features

### Pantry Management

Users can:

- Add ingredients to the pantry.
- View stored pantry ingredients.
- Edit existing ingredient information.
- Delete ingredients from the pantry.
- Store an optional expiry date for ingredients.

Each pantry item contains an ingredient name, quantity, unit and optional expiry date.

### Local SQLite Database

The application uses **SQLite** to store pantry and recipe information locally on the Android device.

#### Why SQLite was chosen

SQLite was selected because Smart Pantry Manager is primarily a local Android application that requires persistent storage for pantry ingredients and predefined recipes. SQLite is lightweight, works locally on Android devices, does not require an external database server and allows pantry information to remain available after the application is closed and reopened.

### Strict Recipe Matching

The application compares the ingredients and quantities stored in the pantry with the requirements of each predefined recipe.

A recipe is suggested **only when every required ingredient is available in the pantry in at least the required quantity**.

Partial matches are excluded.

The matching process also handles simple ingredient-name differences and compatible unit conversions where supported by the application.

For example, if a recipe requires:

- Eggs: 2
- Cheese: 50 g
- Butter: 10 g

the recipe will only be suggested when all three requirements can be satisfied by the pantry.

### Recipe Collection

The application contains **20 predefined recipes** that are seeded into the SQLite database.

The recipe collection includes:

- Scrambled Eggs
- Boiled Eggs
- Cheese Omelette
- Tomato Sandwich
- Cheese Sandwich
- Toast with Butter
- Peanut Butter Toast
- Banana Oats
- Porridge
- Fruit Yogurt
- Rice Bowl
- Tomato Rice
- Garlic Pasta
- Butter Pasta
- Tomato Pasta
- Potato Mash
- Roast Potatoes
- Carrot Salad
- Egg Fried Rice
- Banana Milkshake

Each recipe contains its required ingredients and simple preparation steps.

### Recipe Details

Users can select a suggested recipe to view:

- Recipe name
- Required ingredients
- Required quantities
- Preparation steps

### Input Validation

The application validates pantry input before saving it.

Validation includes:

- Required ingredient name.
- Positive numeric quantity.
- Valid optional expiry-date format.
- Prevention of invalid or incomplete pantry records.

---

## 4. Technologies Used

- **Programming language:** Java
- **Platform:** Android
- **Database:** SQLite
- **Development environment:** Android Studio
- **Build system:** Gradle
- **Version control:** Git and GitHub
- **Testing:** Android emulator and Appetize

---

## 5. Project Structure

The project contains the following main files and resources:

- `DB.java` — SQLite database operations, database creation and predefined recipe data.
- `PantryActivity.java` — Main pantry screen and pantry ingredient management.
- `EditIngredientActivity.java` — Adding, editing, validation and deleting pantry ingredients.
- `RecipesActivity.java` — Recipe suggestions and strict ingredient matching.
- `RecipeDetailActivity.java` — Recipe detail screen.
- `SettingsActivity.java` — Application settings screen.
- `UI.java` — Reusable user interface components and navigation helpers.
- `AndroidManifest.xml` — Android application configuration.
- `res/values/styles.xml` — Application styling resources.
- `build.gradle` — Gradle build configuration.

---

## 6. Database Structure

The application uses a local SQLite database named `smart_pantry.db`.

The database contains three main tables:

### `pantry`

Stores the ingredients currently available to the user.

Main information includes:

- Ingredient ID
- Ingredient name
- Quantity
- Unit
- Optional expiry date

### `recipes`

Stores the predefined recipes.

Main information includes:

- Recipe ID
- Recipe name
- Preparation steps

### `requirements`

Stores the ingredients required by each recipe.

Main information includes:

- Recipe ID
- Ingredient name
- Required quantity
- Unit

The `requirements` table connects recipe requirements to the corresponding recipe.

---

## 7. Application Screens

The application includes the following main screens:

1. **My Pantry** — Displays the user's stored ingredients.
2. **Add Ingredient** — Allows a new pantry ingredient to be created.
3. **Edit Ingredient** — Allows an existing ingredient to be updated or deleted.
4. **Suggested Recipes** — Displays recipes that satisfy the strict pantry-matching rules.
5. **Recipe Detail** — Displays the ingredients and preparation steps for a selected recipe.
6. **Settings** — Provides application settings and navigation options.

---

## 8. Navigation and Intents

Android `Intent` objects are used to navigate between Activities and pass information between screens.

For example, when a user selects a recipe, the application passes the selected recipe ID to `RecipeDetailActivity`. The recipe detail screen then uses this ID to retrieve the appropriate recipe information from the SQLite database.

Intents are also used when opening an existing pantry ingredient for editing.

---

## 9. Testing

The application was tested using the Android emulator and Appetize.

The tests included:

- Launching the application.
- Opening the My Pantry screen.
- Adding ingredients.
- Editing existing ingredients.
- Deleting ingredients.
- Testing input validation.
- Checking pantry data after CRUD operations.
- Testing recipe matching using different pantry quantities.
- Checking that recipe suggestions change when pantry quantities change.
- Opening recipe details.
- Testing application navigation.
- Checking that pantry information persists through the application's database.

During recipe-matching tests, Cheese Omelette and Scrambled Eggs appeared when the pantry contained the required ingredients in the tested quantities. After the cheese quantity was reduced, Cheese Omelette was no longer available while Scrambled Eggs remained available.

This demonstrates the application's strict matching behaviour, where recipes requiring unavailable quantities are excluded.

---

## 10. Building and Running the Project

To build the project locally:

1. Clone or download the repository.
2. Open the project in Android Studio.
3. Configure the Android SDK for the local computer.
4. Allow Gradle to sync and download the required dependencies.
5. Build and run the application on an Android emulator or compatible Android device.

The Android SDK path is specific to each computer and should be configured locally rather than committed to the repository.

### Windows Gradle Build

On a Windows computer with the required Android SDK installed, run the following command from the project root:

```bash
.\gradlew.bat assembleDebug
```

---

## 11. Git and Version Control

The project was developed using **Git** and hosted on GitHub.

The repository contains more than the required 10 meaningful commits and provides the project source code and development history.

**Repository:**  
https://github.com/travis057/Smart-pantry-manager

---

## 12. Current Project Status

The core Smart Pantry Manager functionality has been implemented and tested.

The following functionality has been tested:

- Pantry creation.
- Pantry viewing.
- Pantry editing.
- Pantry deletion.
- Input validation.
- SQLite database storage.
- Recipe matching.
- Recipe suggestions.
- Recipe details.
- Application navigation.
- Persistence of pantry information.

The written report has been prepared, and the final demonstration video is being completed as part of the Mobile App Development 700 submission.

---

## 13. Known Technical Note

The current implementation uses dynamically generated Android layouts for displaying pantry and recipe records.

The assignment brief specifies the use of a **RecyclerView or ListView with a custom Adapter** for a database-backed dynamic list. The current implementation does not use a RecyclerView/ListView custom Adapter.

The remaining application functionality, including SQLite storage, CRUD operations, strict recipe matching, validation and navigation, is implemented in the project.

---

## 14. Conclusion

Smart Pantry Manager demonstrates how a Java Android application can combine local SQLite storage, pantry management and ingredient-based recipe matching to address a practical everyday problem.

The application allows users to manage pantry ingredients, maintain persistent local data and identify recipes that can be prepared using the ingredients currently available.

The project demonstrates practical Android development concepts including Activities, Intents, SQLite database operations, input validation, local persistence, user interface design and strict recipe-matching logic.
