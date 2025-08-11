import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        char[] chars = str.toCharArray();
        for(int i=0 ;i<chars.length;i++){
            if (!Character.isLowerCase(chars[i])) {
                System.out.print(chars[i]);
                continue;
            }
            int asci = chars[i];
            asci=asci+k;
            if(asci< 65){
                int mod = 65 % asci;
                asci= 126-mod+1;
            }
            else if(asci > 126){
                asci = (asci)-65;
            }
            System.out.print((char)asci);
        }
    }
}
