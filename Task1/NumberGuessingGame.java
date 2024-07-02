import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int totalAttempts = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("\n\nWelcome to the Number Guessing Game!\n");

        while (playAgain) {
            totalRounds++;
            System.out.println("\n--- Round " + totalRounds + " ---");

            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess (1-100): ");
                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundsWon++;
                    hasGuessedCorrectly = true;
                    break;
                }
            }

            totalAttempts += attempts;

            if (!hasGuessedCorrectly) {
                System.out
                        .println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // Consume the newline character
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Attempts Made: " + totalAttempts);
        System.out.printf("Average Attempts per Round: %.2f\n", (double) totalAttempts / totalRounds);

        scanner.close();
    }
}
