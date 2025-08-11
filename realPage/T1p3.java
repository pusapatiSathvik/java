import java.util.Scanner;

public class T1p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
        sc.close();
    }

    public static int solution(int N, int K) {
        long totalSum = (long) N * (N + 1) / 2;

        if (K > totalSum) {
            return -1; // Not enough capacity
        } else if (K == totalSum) {
            return N; // Use all glasses
        } else {
            // The problem is to find the minimum number of glasses.
            // This is equivalent to finding the smallest number 'm'
            // such that K can be formed by summing 'm' distinct numbers
            // from the set {1, 2, ..., N}.
            //
            // A greedy approach that works is to iterate through the possible
            // number of glasses ('m') starting from 1. For each 'm', we
            // check if K is a possible sum.
            //
            // The smallest possible sum for 'm' glasses is 1 + 2 + ... + m.
            // The largest possible sum for 'm' glasses is N + (N-1) + ... + (N-m+1).
            //
            // If K falls within this range [min_sum, max_sum], then a solution
            // with 'm' glasses exists, and since we are iterating from m=1,
            // this 'm' will be the minimum.

            for (int m = 1; m <= N; m++) {
                // Calculate the minimum sum for 'm' glasses (1 to m)
                long min_sum = (long) m * (m + 1) / 2;
                
                // Calculate the maximum sum for 'm' glasses (N down to N-m+1)
                long max_sum = (long) m * N - (long) m * (m - 1) / 2;

                if (K >= min_sum && K <= max_sum) {
                    return m;
                }
            }
        }
        
        return -1; // Should not be reached if K <= totalSum
    }
}