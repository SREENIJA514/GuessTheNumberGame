import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1; // Minimum number to guess
        int upperBound = 100; // Maximum number to guess
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10; // Maximum number of attempts allowed
        int numberOfAttempts = 0;
        boolean hasGuessedCorrectly = false;

        int score = 0;

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");
        System.out.println("Try to guess it!");

        while (!hasGuessedCorrectly && numberOfAttempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please guess a number between " + lowerBound + " and " + upperBound + ".");
            } else if (userGuess < numberToGuess) {
                System.out.println("Higher! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Lower! Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly in " + numberOfAttempts + " attempts.");
                
                // Calculate score based on attempts (fewer attempts = higher score)
                score = (maxAttempts - numberOfAttempts) * 10;
                System.out.println("Your score is: " + score);
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
        }

        scanner.close();
    }
}
