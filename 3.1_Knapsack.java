

public class Knapsack {

    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the dp table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Find the selected items
        int result = dp[n][capacity];
        int w = capacity;
        System.out.println("Selected items:");
        for (int i = n; i > 0 && result > 0; i--) {
            if (result != dp[i - 1][w]) {
                System.out.println("Weight: " + weights[i - 1] + ", Value: " + values[i - 1]);
                result -= values[i - 1];
                w -= weights[i - 1];
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int capacity = 50;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int n = weights.length;

        int maxValue = knapsack(capacity, weights, values, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}

