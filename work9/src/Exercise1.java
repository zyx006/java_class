import java.util.Scanner;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/1 - 22:21
 */
public class Exercise1 {
    public static void main(String[] args) {
        String expression = new Scanner(System.in).nextLine();

        int cnt = 0;
        for (int i = 0; i < expression.length(); i++) {
            if ('(' == expression.charAt(i)){
                cnt++;
            } else if (')' == expression.charAt(i)){
                cnt--;
            }
        }
        if (cnt != 0){
            System.out.println("输入格式错误！");
            return;
        }

        String[] opts = expression.split(",");
        double res = 0;
        if(opts.length == 2){
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
        } else {
            for (int i = opts.length-1; i >= 0; i--) {
                String exp = opts[i].substring(0, opts[i].indexOf("("));
                double num;
                if(i != opts.length-1){
                    num = Double.parseDouble(opts[i].substring(opts[i].indexOf("(")+1));
                } else {
                    num = Double.parseDouble(opts[i].substring(opts[i].indexOf("(") + 1, opts[i].indexOf(")")));
                }
                switch (exp){
                    case "add":
                        res += num;
                        break;
                    case "sub":
                        res -= num;
                        break;
                    case "max":
                        res = Math.max(res, num);
                        break;
                    case "min":
                        res = Math.min(res, num);
                        break;
                    case "doubleMe":
                        res = num*2;
                        break;
                }
            }
        }
        System.out.println(expression + "=" + res);
    }
}
