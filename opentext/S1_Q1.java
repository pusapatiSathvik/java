import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class test{
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 8, 9, 10};
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){

            if (map.containsKey(arr[i])) {
                int[] freq = map.get(arr[i]);
                freq[0]++;
                map.put(arr[i], freq);
            }else{
                map.put(arr[i], new int[]{1,i});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                if (a[1]!=b[1]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(a[2],b[2]);
            }
        });

        
        for(int key : map.keySet()){
            int[] freq = map.get(key);
            pq.add(new int[]{key,freq[0],freq[1]});
        }

        int[] res = new int[arr.length];
        int idx=0;
        
        while (!pq.isEmpty()) {
            int[] inter = pq.poll();
            int i=inter[1];
            while (i>0) {
                res[idx]=inter[0];
                idx++;
                i--;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}