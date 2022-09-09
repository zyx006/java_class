package work;

import java.util.Scanner;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/7 - 9:23
 */
public class Work1 {
    public static void main(String[] args) {
        String again;
        do {
            int randomNumber = 1 + (int) (Math.random() * 1000);
//            System.out.println(randomNumber);
            System.out.println("I have a number between 1 and 1000. \nCan you guess my number?\nPlease type your first guess.");
            Scanner scanner = new Scanner(System.in);

            boolean success = false;
            int cnt = 1;
            for (int i = 1; i <= 10; i++) {
                int guessNumber = scanner.nextInt();

                if (randomNumber == guessNumber) {
                    System.out.println("Excellent! You guessed the number");
                    success = true;
                    break;
                } else {
                    if (i == 10) break;
                    if (guessNumber > randomNumber) {
                        System.out.println("Too High. Try Again.");
                    } else {
                        System.out.println("Too Low. Try Again");
                    }
                }
                cnt++;
                System.out.println("Please type your guess again:");
            }
            if (success) {
                System.out.println("Success! You have cost " + cnt + " times");
            } else {
                System.out.println("Sorry! You failed!\nThe answer is: " + randomNumber);
            }

            System.out.println("Would you like to play again (y or n)?：");
            again = scanner.next();
        } while ("y".equalsIgnoreCase(again));
        System.out.println("Game Over! Welcome to play again!");
    }
}
