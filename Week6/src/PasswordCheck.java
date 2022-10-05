import java.util.Scanner;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/5 - 8:17
 */
public class PasswordCheck {
    public static void main(String[] args) {
        System.out.println("密码要求：\n长度必须在8到15个字符之间\n" +
                "不得包含空格\n" +
                "必须至少包含一个非数字的大写字符和一个非数字的小写字符\n" +
                "必须包含至少一个数字数字");
        System.out.println("请输入密码：");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        System.out.println(checkFormat(password));
    }

    public static String checkFormat(String pwd) {
        String info = "";
        if (pwd.length() >= 8 && pwd.length() <= 15) {
            int numCnt = 0, lowCnt = 0, upCnt = 0, spaceCnt = 0;
            for (int i = 0; i < pwd.length(); i++) {
                if (pwd.charAt(i) >= '0' && pwd.charAt(i) <= '9')
                    numCnt++;
                else if (pwd.charAt(i) >= 'a' && pwd.charAt(i) <= 'z')
                    lowCnt++;
                else if (pwd.charAt(i) >= 'A' && pwd.charAt(i) <= 'Z')
                    upCnt++;
                else if (pwd.charAt(i) == ' ')
                    spaceCnt++;
            }
            if (numCnt >= 1 && lowCnt >= 1 && upCnt >= 1 && spaceCnt == 0) {
                info = "符合要求";
                return "恭喜你，你的密码'" + pwd  + "'" + info;
            }
            else{
                if (numCnt == 0) info += "密码至少需要一个数字\n";
                if (upCnt == 0) info += "密码至少需要一个大写字母\n";
                if (lowCnt == 0) info += "密码至少需要一个小写字母\n";
                if (spaceCnt == 1) info += "密码包含了空格\n";
            }
        } else info += "密码长度不符合要求";
        return "你的密码" + pwd + "无效，原因如下：\n" + info;
    }
}