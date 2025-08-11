import java.util.Scanner;

public class T2P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = Integer.parseInt(s);
        int max=0;
        if(n<0){
            max = Integer.MIN_VALUE;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='5'){
                String news = s.substring(0,i) + s.substring(i+1);
                int newn = Integer.parseInt(news);
                max = Math.max(max, newn);
            }
        }
        System.out.println(max);

    }
}
