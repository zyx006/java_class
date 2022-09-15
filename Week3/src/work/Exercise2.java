package work;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = -1;
        while (n == -1) {
            System.out.println("请输入一个正整数(3<=n<=7)：");
            n = checkInputNumber(scanner, 3, 7);
        }

        int[] pow = new int[10];
        for (int i = 0; i < 10; i++) {
            pow[i] = (int) Math.pow(i, n);
        }

        int begin = (int) Math.pow(10, n - 1), end = (int) (Math.pow(10, n) - 1);
        for (int i = begin; i <= end; i++) {
            int sum = 0, tmp = i;
            while (tmp != 0) {
                sum += pow[tmp % 10];
                tmp /= 10;
            }
            if (sum == i) System.out.println(sum);
        }
        System.out.println("求解完毕！");
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
