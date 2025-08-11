import java.util.Scanner;
import java.util.*;
class S2_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,Integer> pfact = new HashMap<>();
        for(int i : arr){
            if (!freq.containsKey(i)) {
                freq.put(i,1);
            }
            else{
                freq.put(i, freq.get(i)+1);
            }
        }
        // factors
        for(int i : arr){
            if (!pfact.containsKey(i)) {
                int num = getPf(i);
                pfact.put(i,num);
            }
        }

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i : arr){
            set.add(i);
        }

        for(int i : set){
            if (freq.get(i) == pfact.get(i)) {
                System.out.println(i);
            }
        }
    }
    public static int getPf(int num){
        int count=0;
        System.out.print(num + ": " );
        while (num%2 == 0) {
            count++;
            num = num/2;
            System.out.print(2 + " ");
        }
        for(int i=3;i<=Math.sqrt(num);i+=2){
            while (num%i==0) {
                count++;
                System.out.print(i + " ");
                num = num/i;
            }
        }
        
        if(num>2){
            count++;
            System.out.print(num);
        }
        System.out.println();
        return count;
    }
}
