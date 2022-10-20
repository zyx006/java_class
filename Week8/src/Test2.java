import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/19 - 10:01
 */
public class Test2 {
    public static void main(String[] args) {
        String regex = "((add)|(sub)|(max)|(min)|(doubleMe))\\(\\d+(.\\d+)?,\\d+(.\\d+)?\\)";
        Pattern p = Pattern.compile(regex);
        String str = new Scanner(System.in).nextLine();
        Matcher matcher = p.matcher(str);
        String res = "";
        while (matcher.find()){
            String subStr = matcher.group();
            res = calcExpression(subStr)+"";
            System.out.print(subStr + " " + res + "->");
            str = str.replaceAll(regex,res);
            System.out.println(str);
            matcher = p.matcher(str);
        }
        System.out.println("运算结果：" + res);
    }

    public static double calcExpression(String expression){
        double res = 0;
        String exp = expression.substring(0, expression.indexOf("("));
        if ("doubleMe".equals(exp)){
            double num = Double.parseDouble(expression.substring(expression.indexOf("(")+1,expression.indexOf(")")));
            res = num*2;
        } else {
            double num1 = Double.parseDouble(expression.substring(expression.indexOf("(")+1, expression.indexOf(",")));
            double num2 = Double.parseDouble(expression.substring(expression.indexOf(",")+1, expression.indexOf(")")));
            switch (exp){
                case "add":
                    res = num1+num2;
                    break;
                case "sub":
                    res = num1-num2;
                    break;
                case "max":
                    res = Math.max(num1, num2);
                    break;
                case "min":
                    res = Math.min(num1, num2);
                    break;
            }
        }
        return res;
    }
}
