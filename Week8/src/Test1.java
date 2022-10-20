import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/19 - 9:09
 */
public class Test1 {
    public static void main(String[] args) {
        String htmlStr = "<html><head></head>...<div><IMG alt ='xxx' SRC='1.jpg'/><img alt='xxx' src='2.jpg'/><img alt='xxx'\n" +
                "src='3.jpg'></img></div></html>";
        Pattern p = Pattern.compile("<img.*?>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(htmlStr);
        int cnt=0;
        while (matcher.find()){
            String imgStr = matcher.group().toLowerCase();
            System.out.println(imgStr);
            String src = getSrc(imgStr);
            System.out.println(src);
            cnt++;
        }
    }

    public static String getSrc(String imgStr){
        Pattern p = Pattern.compile("(src)=(\"|\')(.*?)(\"|\')", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(imgStr);
        if(matcher.find()){
            return matcher.group();
        }
        return "";
    }
}
