import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        Scanner guess = new Scanner(System.in);
        Random random = new Random();
        boolean PlayAgain = true;
        int TimeLimit = 30;
        System.out.println("lets play a number guessing game!! \n guess a number from 1 to 100");
        while (PlayAgain) {
            int RandomNumber = random.nextInt(100) + 1;
            int UserGuess = 0;
            int NumberOfAttempts = 0;
            AtomicBoolean TimesUp = new AtomicBoolean(false);

            Thread timer = new Thread(() -> {
                for (int i = TimeLimit; i > 0; i--) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(i + " seconds left");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Restore interrupted status
                    }
                }
                TimesUp.set(true);
                System.out.println("You ran out of time!");
            });
            timer.start();

            while (UserGuess != RandomNumber) {
                if (TimesUp.get()) {
                    System.out.println("The correct number was: " + RandomNumber);
                    break;
                }
                System.out.println("enter your guess");
                UserGuess = guess.nextInt();
                NumberOfAttempts++;
                if (UserGuess > 100 || UserGuess < 1) {
                    System.out.println("please enter a number from 1 to 100");
                    continue;
                }
                if (UserGuess > RandomNumber) {
                    System.out.println("too high");
                } else if (UserGuess < RandomNumber) {
                    System.out.println("too low");
                } else {
                    System.out.println("CONGRATS!!! YOU ARE CORRECT");

                }}}}}