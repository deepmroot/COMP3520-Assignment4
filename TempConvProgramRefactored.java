import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Temperature Conversion Application
 * Provides conversions between Celsius, Fahrenheit, and Kelvin temperature scales.
 */
public class TempConvProgramRefactored {

    // Constants for conversion formulas
    private static final double FAHRENHEIT_OFFSET = 32.0;
    private static final double FAHRENHEIT_RATIO = 9.0 / 5.0;
    private static final double CELSIUS_RATIO = 5.0 / 9.0;
    private static final double KELVIN_OFFSET = 273.15;

    // Menu option constants
    private static final int OPTION_CELSIUS_TO_FAHRENHEIT = 1;
    private static final int OPTION_FAHRENHEIT_TO_CELSIUS = 2;
    private static final int OPTION_CELSIUS_TO_KELVIN = 3;
    private static final int OPTION_EXIT = 4;

    // Menu messages
    private static final String MENU_OPTION_1 = "1. Convert Celsius to Fahrenheit";
    private static final String MENU_OPTION_2 = "2. Convert Fahrenheit to Celsius";
    private static final String MENU_OPTION_3 = "3. Convert Celsius to Kelvin";
    private static final String MENU_OPTION_4 = "4. Exit";
    private static final String WELCOME_MESSAGE = "Welcome to the Temperature Conversion Application!";
    private static final String EXIT_MESSAGE = "Thank you for using the Temperature Converter. Goodbye!";
    private static final String PROMPT_CHOICE = "Please enter your choice (1-4): ";
    private static final String PROMPT_TEMPERATURE = "Please enter the temperature value: ";
    private static final String ERROR_INVALID_CHOICE = "Invalid choice. Please enter a number between 1 and 4.";
    private static final String ERROR_INVALID_INPUT = "Invalid input. Please enter a valid number.";

    /**
     * Converts temperature from Celsius to Fahrenheit.
     * Formula: F = C × 9/5 + 32
     *
     * @param celsius the temperature in Celsius
     * @return the temperature in Fahrenheit
     */
    public static double convertCelsiusToFahrenheit(double celsius) {
        return celsius * FAHRENHEIT_RATIO + FAHRENHEIT_OFFSET;
    }

    /**
     * Converts temperature from Fahrenheit to Celsius.
     * Formula: C = (F - 32) × 5/9
     *
     * @param fahrenheit the temperature in Fahrenheit
     * @return the temperature in Celsius
     */
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - FAHRENHEIT_OFFSET) * CELSIUS_RATIO;
    }

    /**
     * Converts temperature from Celsius to Kelvin.
     * Formula: K = C + 273.15
     *
     * @param celsius the temperature in Celsius
     * @return the temperature in Kelvin
     */
    public static double convertCelsiusToKelvin(double celsius) {
        return celsius + KELVIN_OFFSET;
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(MENU_OPTION_1);
        System.out.println(MENU_OPTION_2);
        System.out.println(MENU_OPTION_3);
        System.out.println(MENU_OPTION_4);
        System.out.println("=".repeat(50));
    }

    /**
     * Prompts the user for a temperature value and validates the input.
     *
     * @param scanner the Scanner object for reading user input
     * @return the temperature value entered by the user
     */
    private static double getTemperatureInput(Scanner scanner) {
        while (true) {
            try {
                System.out.print(PROMPT_TEMPERATURE);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_INVALID_INPUT);
                scanner.next(); // Clear invalid input
            }
        }
    }

    /**
     * Prompts the user for a menu choice and validates the input.
     *
     * @param scanner the Scanner object for reading user input
     * @return the menu choice entered by the user
     */
    private static int getMenuChoice(Scanner scanner) {
        while (true) {
            try {
                System.out.print(PROMPT_CHOICE);
                int choice = scanner.nextInt();
                if (choice >= OPTION_CELSIUS_TO_FAHRENHEIT && choice <= OPTION_EXIT) {
                    return choice;
                } else {
                    System.out.println(ERROR_INVALID_CHOICE);
                }
            } catch (InputMismatchException e) {
                System.out.println(ERROR_INVALID_INPUT);
                scanner.next(); // Clear invalid input
            }
        }
    }

    /**
     * Formats and displays the conversion result.
     *
     * @param result the converted temperature value
     * @param unit   the unit of the result temperature
     */
    private static void displayResult(double result, String unit) {
        System.out.printf("Result: %.2f %s%n", result, unit);
    }

    /**
     * Processes the Celsius to Fahrenheit conversion.
     *
     * @param scanner the Scanner object for reading user input
     */
    private static void processCelsiusToFahrenheit(Scanner scanner) {
        double celsius = getTemperatureInput(scanner);
        double fahrenheit = convertCelsiusToFahrenheit(celsius);
        displayResult(fahrenheit, "°F");
    }

    /**
     * Processes the Fahrenheit to Celsius conversion.
     *
     * @param scanner the Scanner object for reading user input
     */
    private static void processFahrenheitToCelsius(Scanner scanner) {
        double fahrenheit = getTemperatureInput(scanner);
        double celsius = convertFahrenheitToCelsius(fahrenheit);
        displayResult(celsius, "°C");
    }

    /**
     * Processes the Celsius to Kelvin conversion.
     *
     * @param scanner the Scanner object for reading user input
     */
    private static void processCelsiusToKelvin(Scanner scanner) {
        double celsius = getTemperatureInput(scanner);
        double kelvin = convertCelsiusToKelvin(celsius);
        displayResult(kelvin, "K");
    }

    /**
     * Main application loop that handles user interaction.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println(WELCOME_MESSAGE);

        while (running) {
            displayMenu();
            int userChoice = getMenuChoice(scanner);

            switch (userChoice) {
                case OPTION_CELSIUS_TO_FAHRENHEIT:
                    processCelsiusToFahrenheit(scanner);
                    break;

                case OPTION_FAHRENHEIT_TO_CELSIUS:
                    processFahrenheitToCelsius(scanner);
                    break;

                case OPTION_CELSIUS_TO_KELVIN:
                    processCelsiusToKelvin(scanner);
                    break;

                case OPTION_EXIT:
                    System.out.println(EXIT_MESSAGE);
                    running = false;
                    break;

                default:
                    // Should never reach here due to input validation
                    System.out.println(ERROR_INVALID_CHOICE);
            }
        }

        scanner.close();
    }
}
