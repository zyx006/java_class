import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/19 - 10:40
 */
public class Test3 {
    public static void main(String[] args) {
        String htmlStr = "<html><head><title>欢迎访问武汉纺织大学主页</title></head>\n" +
                "<body><img src='1.jpg'/>\n" +
                "<a href='1.htm'>首页</a>\n" +
                "<a href='2.htm'>教务处</a>\n" +
                "<a href='3.htm'>数计学院</a>\n" +
                "<img src='2.jpg'/>\n" +
                "<img src='3.jpg'/>\n" +
                "</body></html>";
        System.out.println(getContext(htmlStr, "a"));
        System.out.println(getAttribute(htmlStr,"a"));
    }

    public static List<String> getContext(String htmlStr, String tagName){
        List<String> list = new ArrayList<>();
        String regex = "<" + tagName + "(.*?)>(.*?)</" + tagName + ">";
        System.out.println(regex);
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(htmlStr);
        while (matcher.find()){
            list.add(matcher.group(1));
        }
        return list;
    }

    public static List<String> getAttribute(String htmlStr,String tagName){
        List<String> list = new ArrayList<>();
        String regex = "<" + tagName + "(.*?)>(.*?)</" + tagName + ">";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(htmlStr);
        while (matcher.find()){
            list.add(matcher.group(1).split("=")[1]);
        }
        return list;
    }
}
