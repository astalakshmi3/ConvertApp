package astalakshmi.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ConverterApp {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Converter Application ---");
            System.out.println("1. Temperature Converter");
            System.out.println("2. Length Converter");
            System.out.println("3. Time Converter");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = readInt();  // data validation for menu
            switch (choice) {
                case 1:
                    temperatureConverter();
                    break;
                case 2:
                    lengthConverter();
                    break;
                case 3:
                    timeConverter();
                    break;
                case 4:
                    System.out.println("Bye Bye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);
    }
    // DATA VALIDATION METHODS

    // Valid integer input
    public static int readInt() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Enter a whole number: ");
                sc.next();  // clear wrong input
            }
        }
    }

    // Valid double input (temperature can be negative)
    public static double readDouble() {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Enter a number: ");
                sc.next();
            }
        }
    }

    // Valid positive double input (length, time)
    public static double readPositiveDouble() {
        while (true) {
            try {
                double v = sc.nextDouble();
                if (v < 0) {
                    System.out.print("Negative values not allowed. Enter again: ");
                } else {
                    return v;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Enter a number: ");
                sc.next();
            }
        }
    }


    // DATE AND TIME FORMATTER

    public static void printResult(String result) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = LocalDateTime.now().format(dtf);

        System.out.println(result);
        System.out.println("Converted at: " + now);
    }


    // 1. TEMPERATURE CONVERTER

    public static void temperatureConverter() {
        System.out.println("\n--- Temperature Converter ---");
        System.out.println("1. Celsius -> Fahrenheit");
        System.out.println("2. Fahrenheit -> Celsius");
        System.out.print("Choose an option: ");

        int option = readInt();

        System.out.print("Enter temperature: ");
        double temp = readDouble();  // temperature can be negative

        double result;
        String text;

        if (option == 1) {
            result = (temp * 9 / 5) + 32;
            text = String.format("Result: %.2f Celsius = %.2f Fahrenheit", temp, result);
        } else if (option == 2) {
            result = (temp - 32) * 5 / 9;
            text = String.format("Result: %.2f Fahrenheit = %.2f Celsius", temp, result);
        } else {
            System.out.println("Invalid option");
            return;
        }

        printResult(text);
    }


    // 2. LENGTH CONVERTER

    public static void lengthConverter() {
        System.out.println("\n--- Length Converter ---");
        System.out.println("1. Meter -> Kilometer");
        System.out.println("2. Kilometer -> Meter");
        System.out.print("Choose an option: ");

        int option = readInt();

        System.out.print("Enter length: ");
        double input = readPositiveDouble();  // length cannot be negative

        double result;
        String text;

        if (option == 1) {
            result = input / 1000;  // correct formula
            text = String.format("Result: %.2f Meter = %.2f Kilometer", input, result);
        } else if (option == 2) {
            result = input * 1000;
            text = String.format("Result: %.2f Kilometer = %.2f Meter", input, result);
        } else {
            System.out.println("Invalid option");
            return;
        }

        printResult(text);
    }



    // 3. TIME CONVERTER

    public static void timeConverter() {
        System.out.println("\n--- Time Converter ---");
        System.out.println("1. Minutes -> Seconds");
        System.out.println("2. Seconds -> Minutes");
        System.out.print("Choose an option: ");

        int option = readInt();

        System.out.print("Enter time: ");
        double input = readPositiveDouble();  // time cannot be negative

        double result;
        String text;

        if (option == 1) {
            result = input * 60;
            text = String.format("Result: %.2f Minutes = %.2f Seconds", input, result);
        } else if (option == 2) {
            result = input / 60;
            text = String.format("Result: %.2f Seconds = %.2f Minutes", input, result);
        } else {
            System.out.println("Invalid option");
            return;
        }

        printResult(text);
    }
}
