import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        String s = "bcda";
        String regexStr = "a";
        Pattern p = Pattern.compile(regexStr);
        Matcher m = p.matcher(s);
        System.out.println(m.find());

        ///
        /// 
        String regexStr2 = "[aeiou]";
        String inp2 = "abcde";
        Pattern p2 = Pattern.compile(regexStr2);
        Matcher m2 = p2.matcher(inp2);
        System.out.println(m2.matches());



    }
}
