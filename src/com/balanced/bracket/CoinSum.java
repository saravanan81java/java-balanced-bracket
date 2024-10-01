package com.balanced.bracket;

public class CoinSum {
	
	public static int countWaysToMakeChange(int[] coins, int amount) {
        // Array to store the number of ways to make change for each amount
        int[] dp = new int[amount + 1];

        // Base case: There is 1 way to make change for amount 0 (no coins)
        dp[0] = 1;

        // Loop over each coin
        for (int coin : coins) {
            // For each coin, update the ways to make change for all amounts
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
        int amount = 4;

        int numberOfWays = countWaysToMakeChange(coins, amount);
        System.out.println("Number of ways to make change for " + amount + ": " + numberOfWays);


	}

}
