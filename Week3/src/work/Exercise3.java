package work;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise3 {
    static int[] score = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int opt = menu(scanner);
            switch (opt) {
                case 1:
                    input(scanner);
                    break;
                case 2:
                    if (score == null) {
                        System.out.println("请先输入分数，然后执行该功能");
                        break;
                    }
                    System.out.println("班级平均成绩是：" + avgScore());
                    break;
                case 3:
                    if (score == null) {
                        System.out.println("请先输入分数，然后执行该功能");
                        break;
                    }
                    System.out.println("班级最高成绩是：" + highestScore());
                    break;
                case 4:
                    if (score == null) {
                        System.out.println("请先输入分数，然后执行该功能");
                        break;
                    }
                    System.out.println("班级最低成绩是：" + lowestScore());
                    break;
                case 5:
                    if (score == null) {
                        System.out.println("请先输入分数，然后执行该功能");
                        break;
                    }
                    sortScores();
                    break;
                default:
                    return;
            }
        }
    }

    public static int menu(Scanner scanner){
        System.out.println("1.输入学生成绩");
        System.out.println("2.获取班级平均成绩");
        System.out.println("3.获取班级最高分");
        System.out.println("4.获取班级最低分");
        System.out.println("5.排序");
        System.out.println("6.退出");
        int opt = -1;
        while (opt == -1) {
            System.out.print(">>>请输入选项：");
            opt = checkInputNumber(scanner, 1, 6);
        }
        return opt;
    }

    public static void input(Scanner scanner){
        score = new int[5];
        scanner = new Scanner(System.in);
        for (int i = 0; i < score.length; i++) {
            int tmp = -1;
            while (tmp == -1) {
                System.out.println("请输入第" + (i+1) + "个成绩:");
                tmp = checkInputNumber(scanner,0,100);
            }
            score[i] = tmp;
        }
        System.out.println("输入完毕！");
    }

    public static double avgScore(){
        double sum = 0;
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        return sum / score.length;
    }

    public static int highestScore(){
        int max = score[0];
        for (int i = 0; i < score.length; i++) {
            if(score[i] > max)
                max = score[i];
        }
        return max;
    }

    public static int lowestScore(){
        int min = score[0];
        for (int i = 0; i < score.length; i++) {
            if(score[i] < min)
                min = score[i];
        }
        return min;
    }

    public static void sortScores(){
        Arrays.sort(score);
        System.out.println("学生成绩从高到低依次为:");
        for (int i = score.length-1; i >= 0 ; i--) {
            System.out.print(score[i] + " ");
        }
        System.out.println();
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
