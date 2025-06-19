import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        // Outer loop for multiple rounds (requirement #6)
        while (true) {
            roundsPlayed++;
            int lowerBound = 1;
            int upperBound = 100;
            int maxAttempts = 7;       // requirement #5: limit attempts
            
            // requirement #1: generate random number in [lowerBound, upperBound]
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.printf("\n--- Round %d ---\n", roundsPlayed);
            System.out.printf("I'm thinking of a number between %d and %d.\n", lowerBound, upperBound);
            System.out.printf("You have %d attempts to guess it.\n\n", maxAttempts);

            // Inner loop: prompt, compare, feedback, repeat until correct or out of attempts
            while (attempts < maxAttempts) {
                System.out.printf("Attempt %d of %d. Enter your guess: ", attempts + 1, maxAttempts);
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    continue;
                }

                attempts++;

                // requirement #3: compare guess to generated number
                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.printf("Correct! You got it in %d attempts.\n", attempts);
                    guessedCorrectly = true;
                    totalScore++;   // requirement #7: increment score for a win
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.printf("Sorry, you've used all attempts. The number was %d.\n", numberToGuess);
            }

            // Show current score (requirement #7)
            System.out.printf("Score: %d correct %s out of %d rounds.\n",
                              totalScore,
                              totalScore == 1 ? "guess" : "guesses",
                              roundsPlayed);

            // requirement #6: ask to play again
            System.out.print("Play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!(playAgain.equals("yes") || playAgain.equals("y"))) {
                break;
            }
        }

        // Game over summary
        System.out.println("\nThanks for playing!");
        System.out.printf("You played %d round%s and guessed correctly %d time%s.\n",
                          roundsPlayed,
                          roundsPlayed == 1 ? "" : "s",
                          totalScore,
                          totalScore == 1 ? "" : "s");

        scanner.close();
    }
}
