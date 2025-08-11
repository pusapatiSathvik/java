import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class StreetLights {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (number of street lights)
        int N = scanner.nextInt();

        // Read current state of street lights
        int[] currentState = new int[N];
        for (int i = 0; i < N; i++) {
            currentState[i] = scanner.nextInt();
        }

        // Read M (number of days)
        int M = scanner.nextInt();

        scanner.close(); 
        HashMap<String, Integer> statesSeenMap = new HashMap<>();
        List<int[]> statesInOrder = new ArrayList<>();

        int dayCount = 0;

        while (dayCount < M) {
            String currentStateKey = Arrays.toString(currentState);

            if (statesSeenMap.containsKey(currentStateKey)) {
                // Cycle detected!
                int firstOccurrenceDay = statesSeenMap.get(currentStateKey);
                int cycleLength = dayCount - firstOccurrenceDay;

                long remainingDaysToSimulate = M - dayCount;
                int offsetWithinCycle = (int) (remainingDaysToSimulate % cycleLength);

                // The final state will be the one at this index in `statesInOrder`
                int finalStateIndex = firstOccurrenceDay + offsetWithinCycle;

                currentState = statesInOrder.get(finalStateIndex);
                break; // Exit loop, we've found the final state
            } else {
                // Store the current state and day number
                statesSeenMap.put(currentStateKey, dayCount);
                // Create a copy of the current state array to store,
                // otherwise, it will be modified by reference later
                statesInOrder.add(Arrays.copyOf(currentState, N));
            }

            // Calculate the next day's state
            int[] nextState = new int[N];
            for (int i = 0; i < N; i++) {
                int leftAdj = (i > 0) ? currentState[i - 1] : 0; // Left neighbor, 0 if at index 0
                int rightAdj = (i < N - 1) ? currentState[i + 1] : 0; // Right neighbor, 0 if at index N-1

                // Rule: Light goes OFF if both adjacent are ON or both OFF (XOR operation)
                // Otherwise, it goes ON.
                nextState[i] = leftAdj ^ rightAdj; // XOR operation directly implements the rule
            }

            currentState = nextState; // Update state for the next day's calculation
            dayCount++;
        }

        // Print the final state
        for (int i = 0; i < N; i++) {
            System.out.print(currentState[i]);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}