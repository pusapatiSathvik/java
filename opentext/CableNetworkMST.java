import java.util.*;

public class CableNetworkMST {
    static class Node {
        int index;
        int cost;
        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public static int minCableCost(int[] systems, int[] coords) {
        int n = systems.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        // Start MST with all ON systems (cost 0)
        for (int i = 0; i < n; i++) {
            if (systems[i] == 1) {
                pq.offer(new Node(i, 0));
            }
        }

        int totalCost = 0;
        int visitedCount = 0;

        while (!pq.isEmpty() && visitedCount < n) {
            Node curr = pq.poll();
            if (visited[curr.index]) continue;

            visited[curr.index] = true;
            totalCost += curr.cost;
            visitedCount++;

            // Add all neighbors with distance cost
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(coords[curr.index] - coords[j]);
                    pq.offer(new Node(j, dist));
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] systems = {1, 0, 0, 1, 0, 0, 0, 1};
        int[] coords  = {0, 2, 5, 6, 10, 13, 15, 20};

        System.out.println("Minimum Cable Cost = " + minCableCost(systems, coords));
    }
}
