import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/20 - 8:47
 */
public class Exercise3 {
    public static void main(String[] args) {
        String htmlStr = "<font face=\"Arial Serif\" size=\"10px\" color=\"red\" />";
        Pattern p1 = Pattern.compile("<\\s*font\\s*([^>]*)\\s*>",Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(htmlStr);
        if(m1.find()) {
            String fontStr = m1.group();
            Pattern p2 = Pattern.compile("([a-z]+)\\s*=\\s*\"([^\"]+)\"",Pattern.CASE_INSENSITIVE);
            Matcher m2 = p2.matcher(fontStr);
            while (m2.find()) {
                String eachAttribute = m2.group();
                eachAttribute = eachAttribute.replaceAll("=",":");
                eachAttribute = eachAttribute.replaceAll("\"","");
                System.out.println(eachAttribute);
            }
        }
    }
}
