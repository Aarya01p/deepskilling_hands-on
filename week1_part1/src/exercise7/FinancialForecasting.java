package exercise7;

public class FinancialForecasting {

    /**
     * Recursive method to calculate Future Value.
     * Formula: FV = PV * (1 + growthRate)^years
     * Recursive formulation:
     * - Base Case: years == 0 -> return PV
     * - Recursive Step: FV(years) = FV(years - 1) * (1 + growthRate)
     * Time Complexity: O(n) where n is the number of years.
     * Space Complexity: O(n) due to call stack size.
     */
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int years) {
        // Base case
        if (years == 0) {
            return presentValue;
        }
        // Recursive step
        return calculateFutureValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    /**
     * Optimized Iterative method to calculate Future Value.
     * This avoids stack overflow issues for large values of years.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;
        double multiplier = 1 + growthRate;
        for (int i = 0; i < years; i++) {
            futureValue *= multiplier;
        }
        return futureValue;
    }
}
