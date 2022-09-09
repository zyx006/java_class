package work;

import java.io.IOException;
import java.util.Scanner;

/**
 * 菜单
 * 作业2
 * 1.猜数
 * 2.求解水仙花数
 * 3.打印图形
 * 4.求解表达式
 */
public class Work2_0908 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("作业2");
            System.out.println("1.猜数游戏");
            System.out.println("2.求解水仙花数");
            System.out.println("3.打印菱形");
            System.out.println("4.求解表达式");
            System.out.println("0.退出程序");
            int opt = -1;
            while (opt == -1) {
                System.out.print(">>>请输入选项(0-4)：");
                opt = checkInputNumber(scanner,0,4);
            }
            switch (opt){
                case 1:
                    guessNumber(scanner);
                    break;
                case 2:
                    getNarcissisticNumber(scanner);
                    break;
                case 3:
                    printRhombus();
                    break;
                case 4:
                    calcExpression(scanner);
                    break;
                default:
                    return;
            }
            System.out.println("按任意键继续...");
            System.in.read();
        }

    }

    /**
     * 猜数游戏
     * @param scanner 通用的输入
     */
    public static void guessNumber(Scanner scanner) {
        String again;
        do {
            int randomNumber = 1 + (int) (Math.random() * 1000);
            System.out.println("I have a number between 1 and 1000. \nCan you guess my number?\nPlease type your first guess.");

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

    /**
     * 求解水仙花数
     * @param scanner 通用的输入
     */
    public static void getNarcissisticNumber(Scanner scanner) {
        int n = -1;
        while (n == -1) {
            System.out.println("请输入一个正整数(3<=n<=7)：");
            n = checkInputNumber(scanner, 3, 7);
        }

        int begin = (int) Math.pow(10, n - 1), end = (int) (Math.pow(10, n) - 1);
        for (int i = begin; i <= end; i++) {
            int sum = 0, tmp = i;
            while (tmp != 0) {
                sum += (int) Math.pow(tmp % 10, n);
                tmp /= 10;
            }
            if (sum == i) System.out.println(sum);
        }
        System.out.println("求解完毕！");
    }


    /**
     * 输出菱形图案
     */
    public static void printRhombus() {
        for (int i = 1; i <= 3; i++) {//上半部分
            for (int j = 1; j <= 3 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= 3; i++) {//下半部分
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 5 - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 计算表达式
     * @param scanner 通用的输入
     */
    public static void calcExpression(Scanner scanner) {
        System.out.println("计算1 + 1/2 - 1/3 + 1/4 - 1/5 + ... + 1/n");

        int n;
        while (true) {
            System.out.println("请输入n(n>=1)：");
            String input = scanner.next();
            try {
                n = Integer.parseInt(input);
                if (n >= 1) break;
            } catch (NumberFormatException ignored) {}
        }

        int flag = 1;
        double sum = 1;
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                sum += 1.0 * flag / i;
                flag = -flag;
            }
        }
        System.out.println("表达式的值为：" + sum);
    }

    public static int checkInputNumber(Scanner scanner, int low, int high) {
        String input = scanner.next();
        try {
            int opt = Integer.parseInt(input);
            if (opt >= low && opt <= high)
                return opt;
            else {
                System.out.println("输入无效，只能输入" + low + "-" + high);
            }
        } catch (NumberFormatException e) {
            System.out.println("输入无效，只能输入" + low + "-" + high);
        }
        return -1;
    }
}

