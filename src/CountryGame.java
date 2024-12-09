import java.util.ArrayList;
import java.util.Scanner;

public class CountryGame {
    private ArrayList<String> countries;
    private Scanner scanner;
    private boolean isRunning;

    public CountryGame() {
        countries = new ArrayList<>();
        scanner = new Scanner(System.in);
        isRunning = true;
    }

    public String gameRunner() {
        int userScore = 0;
        System.out.println("Welcome to the Country Game! For each correct country you guess, you will receive one point!");
        askUserForCountries();
        while (isRunning && !countries.isEmpty()) {
            System.out.println("\n\n\n");
            System.out.print("Your turn. Enter a country: ");
            String userInput = scanner.nextLine();
            // Check if the user's input is invalid or repeated
            if (!countries.contains(userInput)) {
                System.out.println("\n\n\n");
                System.out.println("Invalid or repeated country! Game over!");
                System.out.println("CPU: Haha, better start memorizing your countries!");
                isRunning = false; // End the game by setting isRunning to false
            } else {
                countries.remove(userInput);
                userScore++;
                System.out.println("\n\n\n");
                System.out.println("Good choice! Now it's my turn.");
            }
            // Check if there are countries left for the CPU's turn
            if (isRunning && !countries.isEmpty()) {
                String cpuChoice = countries.remove((int) (Math.random() * countries.size()));
                System.out.println("CPU: I choose " + cpuChoice + ".");

                // Check if the list is empty after the CPU's turn
                if (countries.isEmpty()) {
                    System.out.println("\n\n\n");
                    System.out.println("CPU: I ran out of countries. You win!");
                    isRunning = false; // End the game since there are no countries left
                } else {
                    System.out.println("Your turn!");
                }
            }
        }

        // Will only reach here when there's 1 Country or None
        if (!isRunning) {
            return "Game over! Your score: " + userScore; // Return the final score after the game ends
        }
        return "Unexpected end of game!";
    }


    private void askUserForCountries() {
        boolean loop = true;
        System.out.println("Enter the countries you want to be in the game.");
        System.out.println("Type 'done' when you are finished entering countries.");
        while (loop) {
            System.out.print("Enter a country: ");
            String userInputCountry = scanner.nextLine();
            if (userInputCountry.isEmpty()) {
                System.out.println("Country name cannot be empty. Please enter a valid country.");
                // keep looping until 'done' //
            } else if (userInputCountry.equals("done")) {
                System.out.println("Countries successfully added. Starting the game!");
                loop = false; // Exit the loop //
            } else {
                countries.add(userInputCountry);
                System.out.println(userInputCountry + " has been added.");
                // keep looping until 'done' //
            }
        }
    }
}