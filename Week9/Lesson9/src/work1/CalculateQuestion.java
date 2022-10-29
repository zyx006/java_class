package work1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateQuestion {
    public static void main(String[] args) {
        String regex = "((add)|(sub)|(max)|(muti)|(div)|(min)|(doubleMe))\\(\\d+(.\\d+)?,\\d+(.\\d+)?\\)";
        Pattern p = Pattern.compile(regex);

        try(BufferedReader br = new BufferedReader(new FileReader("Week9/Lesson9/src/work1/question.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Week9/Lesson9/src/work1/answer.txt"))
        ) {
            String expression = "";
            while ((expression=br.readLine()) != null){
                String expressionStr = expression;
                String res = "";
                if("doubleMe".equals(expression.substring(0, expression.indexOf("(")))){
                    res = calcExpression(expression)+"";
                } else {
                    Matcher matcher = p.matcher(expression);
                    while (matcher.find()) {
                        String subStr = matcher.group();
                        res = calcExpression(subStr) + "";
                        expression = expression.replaceAll(regex, res);
                        matcher = p.matcher(expression);
                    }
                }
                bw.write(expressionStr + "=" + res + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                case "muti":
                    res = num1*num2;
                    break;
                case "div":
                    res = num1/num2;
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
