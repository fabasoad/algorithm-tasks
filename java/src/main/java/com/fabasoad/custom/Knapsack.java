package com.fabasoad.custom;

// A Dynamic Programming based solution
// for 0-1 Knapsack problem
class Knapsack {

	// Returns the maximum value that can
	// be put in a knapsack of capacity W
	private static int knapsack(int capacity, int[] wt, int[] val) {
		int[][] K = new int[val.length + 1][capacity + 1];

		// Build table K[][] in bottom up manner
		for (int i = 0; i <= val.length; i++) {
			for (int w = 0; w <= capacity; w++) {
				if (i == 0 || w == 0) {
					K[i][w] = 0;
				} else if (wt[i - 1] <= w) {
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				} else {
					K[i][w] = K[i - 1][w];
				}
			}
		}

		return K[val.length][capacity];
	}

	// Driver code
	public static void main(String[] args) {
		int[] val = { 2, 1, 3 };
		int[] wt = { 3, 2, 4 };
		int capacity = 2;
		System.out.println(knapsack(capacity, wt, val));
	}
}
/*This code is contributed by Rajat Mishra */
