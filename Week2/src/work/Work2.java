package work;

import java.util.Scanner;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/7 - 9:23
 */
public class Work2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        while (n == -1) {
            System.out.println("请输入一个正整数(3<=n<=7)：");
            n = checkInputNumber(scanner,3,7);
        }

        int begin = (int) Math.pow(10,n-1), end = (int) (Math.pow(10,n) -1);
        for (int i = begin; i <= end; i++) {
            int sum = 0, tmp = i;
            while (tmp != 0){
                sum += (int) Math.pow(tmp%10,n);
                tmp /= 10;
            }
            if(sum == i) System.out.println(sum);
        }
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
