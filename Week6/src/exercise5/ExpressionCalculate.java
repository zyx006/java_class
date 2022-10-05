package exercise5;

import java.util.Scanner;

public class ExpressionCalculate {
    public static void calculate() {
        System.out.println("add将两个操作数相加\n" +
                "sub将两个操作数相减\n" +
                "max求解两个数中的较大数\n" +
                "min求解两个数中的较小数\n" +
                "doubleMe将一个操作数翻倍（乘以2）");
        System.out.println("请输入待运算的表达式：");
        String expression = new Scanner(System.in).nextLine();

        if (!checkFormat(expression)){
            System.out.println("输入格式错误！");
            return;
        }

        String[] opts = expression.split(",");
        double res;
        if(opts.length == 2){
            res = calcSingletonExpression(expression);
        } else {
            res = calcMultipleExpression(opts);
        }
        System.out.println(expression + "=" + res);
    }

    /**
     * 检查输入格式(括号是否匹配)
     * @param expression 输入的表达式
     * @return true为表达式括号格式正确
     */
    public static boolean checkFormat(String expression){
        int cnt = 0;
        for (int i = 0; i < expression.length(); i++) {
            if ('(' == expression.charAt(i)){
                cnt++;
            } else if (')' == expression.charAt(i)){
                cnt--;
            }
        }
        return cnt == 0;
    }

    /**
     * 计算单运算符的表达式
     * @param expression 输入的单运算符的表达式
     * @return 运算结果
     */
    public static double calcSingletonExpression(String expression){
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

    /**
     * 计算多运算符(运算符嵌套)的表达式
     * @param opts 输入的多运算符的表达式以','分割的String数组
     * @return 运算结果
     */
    public static double calcMultipleExpression(String[] opts){
        double res = 0;
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
        return res;
    }
}