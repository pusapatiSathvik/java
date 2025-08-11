import java.util.*;
class Q1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<m;i++){
            set.add(sc.nextInt());
        }

        for(int i=0;i<n;i++){
            if (!set.contains(i)) {
                System.out.println(arr[i]);
            }
        }
    }
}