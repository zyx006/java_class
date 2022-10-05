import java.io.IOException;
import java.util.Scanner;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/5 - 18:24
 */
public class Exercise5 {
    public static void main(String[] args) throws IOException {
        while (true) {
            int opt = menu();
            switch (opt) {
                case 1:
                   checkPasswordFormat();
                    break;
                case 2:
                    break;
                case 3:
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

    public static void checkPasswordFormat() {
        System.out.println();
        while (true) {
            System.out.println("密码要求：\n1.长度必须在8到15个字符之间\n" +
                    "2.不得包含空格\n" +
                    "3.必须至少包含一个非数字的大写字符和一个非数字的小写字符\n" +
                    "4.必须包含至少一个数字数字");
            System.out.println(">>请输入密码：");
            Scanner scanner = new Scanner(System.in);
            String password = scanner.nextLine();

            String info = "";
            if (password.length() >= 8 && password.length() <= 15) {
                int numCnt = 0, lowCnt = 0, upCnt = 0, spaceCnt = 0;
                for (int i = 0; i < password.length(); i++) {
                    if (password.charAt(i) >= '0' && password.charAt(i) <= '9')
                        numCnt++;
                    else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
                        lowCnt++;
                    else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
                        upCnt++;
                    else if (password.charAt(i) == ' ')
                        spaceCnt++;
                }
                if (numCnt >= 1 && lowCnt >= 1 && upCnt >= 1 && spaceCnt == 0) {
                    info = "符合要求";
                    System.out.println("恭喜你，你的密码'" + password + "'" + info);
                    return;
                }
                else{
                    if (numCnt == 0) info += "密码至少需要一个数字\n";
                    if (upCnt == 0) info += "密码至少需要一个大写字母\n";
                    if (lowCnt == 0) info += "密码至少需要一个小写字母\n";
                    if (spaceCnt == 1) info += "密码包含了空格\n";
                }
            } else info += "密码长度不符合要求\n";
            System.out.println("你的密码" + password + "无效，原因如下：\n" + info);
        }
    }
}
