import java.util.*;
public class T1p1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum =0;
        while (n>0) {
            sum += n%10;
            n/=10;
        }
        System.out.println(sum);
        sum=sum*2;
        n++;
        while(true){
            if (sum == dsum(n)) {
                System.out.println(n);
                break;
            }
            n++;
        }
    }
    public static int dsum(int n){
        int sum =0;
        while (n>0) {
            sum += n%10;
            n/=10;
        }
        return sum;
    }
}