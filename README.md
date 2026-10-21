# SmartPantryManager

## Project Overview

SmartPantryManager is an Android application developed using Java to help users manage pantry ingredients and find recipes based on the ingredients they have available.

The application provides a simple interface for recording ingredients, maintaining pantry information, and checking which recipes can be prepared with the available ingredients.

## Main Features

- **Add ingredients:** Record ingredients in the pantry.
- **View ingredients:** Display ingredients currently stored in the pantry.
- **Update ingredients:** Change ingredient details or quantities.
- **Delete ingredients:** Remove ingredients that are no longer needed.
- **Recipe matching:** Compare available pantry ingredients with recipe requirements.
- **Data storage:** Use SQLite database functionality to manage pantry records.

## Technologies Used

- Java
- Android SDK
- Android Studio
- SQLite
- Gradle

## Application Purpose

The purpose of SmartPantryManager is to make pantry management easier by keeping ingredient information organised and helping users identify recipes that match their available ingredients.

## Testing

The application has been tested using Appetize, a browser-based Android emulator. Initial tests confirmed that ingredients could be added, viewed, updated and deleted. A preliminary recipe-matching test also showed that the displayed recipes changed when the quantity of cheese was reduced.

Pantry ingredients remained visible after navigating away from the application and reopening it. Further testing is needed to verify persistence after the application process is fully stopped and to confirm all recipe-matching rules.

## Project Status

The application is under development. Features and test results should be updated as further implementation and testing are completed.
