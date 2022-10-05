package exercise5;

import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException {
        while (true) {
            int opt = menu();
            switch (opt) {
                case 1:
                    PasswordCheck.checkPasswordFormat();
                    break;
                case 2:
                    ExpressionCalculate.calculate();
                    break;
                case 3:
                    MarketCashier.cashier();
                    break;
                case 4:
                    return;
            }
            System.out.println("按任意键继续...");
            System.in.read();
        }
    }

    /**
     * 检查菜单选项输入合法性
     * @param low 选项下界
     * @param high 选项上界
     * @return 合法选项值
     */
    public static int checkInput(int low, int high) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int opt = scanner.nextInt();
            if (opt >= low && opt <= high) {
                return opt;
            }
            System.out.println("输入超限，请输入" + low + "-" + high + "的数字");
        } else {
            System.out.println("输入数据类型错误，请输入" + low + "-" + high + "的数字");
            scanner.next();
        }
        return -1;
    }

    public static int menu() {
        System.out.println("1.密码有效性检查");
        System.out.println("2.运算表达式求解(支持嵌套)");
        System.out.println("3.超市收银");
        System.out.println("4.退出");
        System.out.print(">>>请选择(1-4)：");
        int opt = -1;
        while (opt == -1) {
            opt = checkInput(1,4);
        }
        return opt;
    }
}

