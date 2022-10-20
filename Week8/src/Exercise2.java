import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2 {
    public static void main(String[] args) {
        String htmlStr = "<html><head><title>欢迎访问武汉纺织大学主页</title></head>\n" +
                "<body><img src='1.jpg'/>\n" +
                "<a href='1.htm'>首页</a>\n" +
                "<a href='2.htm'>教务处</a>\n" +
                "<a href='3.htm'>数计学院</a>\n" +
                "<img src='2.jpg'/>\n" +
                "<img src='3.jpg'/>\n" +
                "</body></html>";
        
        System.out.println("网页标题：" + getContext(htmlStr, "title").get(0));
        
        List<String> img = getAttribute(htmlStr, "img", "src");
        System.out.print("网页中共" + img.size() + "个图片，文件名为");
        for (int i = 0; i < img.size(); i++) {
            System.out.print(img.get(i));
            if(i != img.size()-1)
                System.out.print(",");
        }
        System.out.println();

        List<String> linkContext = getContext(htmlStr, "a");
        List<String> linkHref = getAttribute(htmlStr, "a", "href");
        System.out.println("网页中包含" + linkContext.size() + "个超链接，超链接信息如下：\n名称\t地址");
        for (int i = 0; i < linkContext.size(); i++) {
            System.out.println(linkContext.get(i) + "\t" + linkHref.get(i));
        }
    }

    public static List<String> getContext(String htmlStr, String tagName){
        List<String> list = new ArrayList<>();
        String regex = "<" + tagName + "(.*?)>(.*?)</" + tagName + ">";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(htmlStr);
        while (matcher.find()){
            list.add(matcher.group(2));
        }
        return list;
    }

    public static List<String> getAttribute(String htmlStr,String tagName,String attributeName){
        List<String> list = new ArrayList<>();
        String regex = "<" + tagName + ".+?" + attributeName + "='(.*?)'.+?>";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(htmlStr);
        while (matcher.find()){
            list.add(matcher.group(1));
        }
        return list;
    }
}
