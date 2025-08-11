class PatternCounter {

    // Method to count occurrences of the pattern in the text
    public static int countPatternOccurrences(String text, String pattern) {
        int count = 0;
        int index = 0;

        // Loop through the string to find all occurrences of the pattern
        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index++; // Move one character ahead to count overlapping patterns
        }

        return count;
    }

    public static void main(String[] args) {
        String text = "ababababa";
        String pattern = "aba";

        int occurrences = countPatternOccurrences(text, pattern);
        System.out.println("The pattern \"" + pattern + "\" occurs " + occurrences + " times.");
    }
}

class SecondLargest {

    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            throw new RuntimeException("No second largest element found (array might have all elements equal).");
        }

        return second;
    }

    public static void main(String[] args) {
        int[] numbers = {12, 35, 1, 10, 34, 1};

        try {
            int secondLargest = findSecondLargest(numbers);
            System.out.println("The second largest number is: " + secondLargest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class FirstLetterAfterSpace {

    public static void findLettersAfterSpaces(String input) {
        System.out.println("First letters after spaces in the string:");

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == ' ' && input.charAt(i + 1) != ' ') {
                System.out.println("Character after space at index " + i + ": " + input.charAt(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        String input = "Hello world this is Java";

        System.out.println("Input String: \"" + input + "\"");
        findLettersAfterSpaces(input);
    }
}

class StringPermutations {

    public static void permute(String str, StringBuilder prefix, boolean[] used) {
        if (prefix.length() == str.length()) {
            System.out.println(prefix.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                prefix.append(str.charAt(i));

                permute(str, prefix, used);

                // Backtrack
                prefix.deleteCharAt(prefix.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("Permutations of " + input + " are:");

        permute(input, new StringBuilder(), new boolean[input.length()]);
    }
}


class PairSumHashSet {

    public static void findPairs(int[] arr, int K) {
        HashSet<Integer> seen = new HashSet<>();
        boolean found = false;

        for (int num : arr) {
            int target = K - num;
            if (seen.contains(target)) {
                System.out.println("Pair found: (" + num + ", " + target + ")");
                found = true;
            }
            seen.add(num);
        }

        if (!found) {
            System.out.println("No pairs found with sum = " + K);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15, 3, 6};
        int K = 9;
        findPairs(arr, K);
    }
}

class SmallestMissingPositive {

    public static int findMissingPositive(int[] A) {
        int n = A.length;
        boolean[] present = new boolean[n + 1]; // Index 0 unused

        // Mark the numbers present in the array (only positives <= n)
        for (int num : A) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        // Find the first index i such that present[i] is false
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        // If all 1..n are present, then missing number is n+1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("Smallest missing positive integer is: " + findMissingPositive(arr));

        int[] arr2 = {1, 2, 0};
        System.out.println("Smallest missing positive integer is: " + findMissingPositive(arr2));

        int[] arr3 = {7, 8, 9, 11, 12};
        System.out.println("Smallest missing positive integer is: " + findMissingPositive(arr3));
    }
}



class RemoveThreeDuplicates {

    // Helper class to store character and its count
    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String removeTriplets(String s) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().count++;
                // Remove group if count reaches 3
                if (stack.peek().count == 3) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }

        // Rebuild the string from the stack
        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = "aaabbc";
        String input2 = "aaabbbccc";
        String input3 = "aabbbaccddd";

        System.out.println(removeTriplets(input1)); // Output: "bbc"
        System.out.println(removeTriplets(input2)); // Output: ""
        System.out.println(removeTriplets(input3)); // Output: "aacc"
    }
}



class LargestKWithNegation {

    public static int findLargestK(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the set
        for (int num : arr) {
            set.add(num);
        }

        int largestK = -1;
        for (int num : arr) {
            if (num > 0 && set.contains(-num)) {
                largestK = Math.max(largestK, num);
            }
        }

        return largestK;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, -2, 5, -3};
        int[] arr2 = {1, 2, 3, -4};

        System.out.println(findLargestK(arr1));  // Output: 3
        System.out.println(findLargestK(arr2));  // Output: -1
    }
}

class SetBitsInProduct {

    // Count set bits in an integer using Brian Kernighan’s Algorithm
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);  // clear the least significant set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 5;  // example values
        int B = 3;

        int product = A * B;
        System.out.println("Product: " + product);
        System.out.println("Set bits count in product: " + countSetBits(product));
    }
}



