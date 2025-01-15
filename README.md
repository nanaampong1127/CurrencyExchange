# CurrencyExchange

## Overview
This project is a beginner test application created to practice integrating Java with external APIs. The app serves as a currency converter, enabling users to:

- Select two currencies from dropdown menus.
- Input an amount in one currency.
- Convert the amount to another currency using real-time exchange rates.

## Features
- Dynamically fetches supported currency codes and their names from an API.
- Displays user-friendly dropdown menus for currency selection.
- Performs real-time currency conversion using an external API.
- Provides basic error handling and user feedback.

## Technologies Used
- **Java**: Primary programming language for logic and API interaction.
- **JavaFX**: Used for designing the graphical user interface (GUI).
- **Gson**: For parsing and processing JSON data.

## API Integration
This application integrates with an external exchange rate API to:

- Fetch a list of supported currency codes and names.
- Perform currency conversion using the specified source and target currencies.

### Example API Endpoints:
- `/codes`: Retrieves supported currency codes and their full names.
- `/pair/{codeOne}/{codeTwo}/{amount}`: Converts the specified amount from one currency to another.

## How to Use
1. Launch the application.
2. Wait for the dropdown menus to populate with currency codes and names.
3. Choose the source currency from the first dropdown.
4. Select the target currency from the second dropdown.
5. Enter the amount to convert in the input field.
6. Click the "Convert" button to see the result displayed.

## Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/nanaampong1127/CurrencyExchange
   ```
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure all dependencies are installed (e.g., Gson).
4. Run the application.

## Project Structure
- **`ExchangeRatesAPI.java`**: Handles interactions with the exchange rate API.
- **`HelloController.java`**: Manages the logic for user interaction in the GUI.
- **`HelloApplication.java`**: Launches the application.
- **FXML File**: Defines the layout of the JavaFX GUI.

## Example Usage
- **Input**: Amount = 10, From = USD, To = EUR
- **Output**: 10 USD = 8.5 EUR

## Error Handling
- Displays an error message if the API request fails.
- Checks for valid user inputs in the dropdowns and text fields.

## Future Improvements
- Add support for offline mode with cached exchange rate data.
- Implement a historical exchange rate view.
- Improve GUI styling for a more modern look and responsive behavior.

## Contributing
1. Fork this repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-branch
   ```
3. Commit your changes:
   ```bash
   git commit -m "Description of changes"
   ```
4. Push your changes:
   ```bash
   git push origin feature-branch
   ```
5. Submit a pull request for review.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
