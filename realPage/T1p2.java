import java.util.HashSet;
import java.util.*;

public class T1p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        System.out.println(Solver(strs));
    }
    public static int Solver(String[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if (i==j) continue;
                Set<Character> set = new HashSet<>();
                String xor ="";
                String news = arr[i] + arr[j];
                int len = news.length();
                for(char c : news.toCharArray()){
                    set.add(c);
                }
                if (set.size()==len) {
                    
                }

            }
        }
    }
}
