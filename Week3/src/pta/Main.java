package pta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] pow = new int[10];
        for (int i = 0; i < 10; i++) {
            pow[i] = (int) Math.pow(i,n);
        }

        int begin = (int) Math.pow(10, n - 1), end = (int) (Math.pow(10, n) - 1);
        for (int i = begin; i <= end; i++) {
            int sum = 0, tmp = i;
            while (tmp != 0) {
                sum += pow[tmp%10];
                tmp /= 10;
            }
            if (sum == i) System.out.println(sum);
        }
    }
}