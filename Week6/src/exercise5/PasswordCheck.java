package exercise5;

import java.util.Scanner;

public class PasswordCheck {
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
                    if (spaceCnt != 0) info += "密码包含了空格\n";
                }
            } else info += "密码长度不符合要求\n";
            System.out.println("你的密码" + password + "无效，原因如下：\n" + info);
        }
    }
}
