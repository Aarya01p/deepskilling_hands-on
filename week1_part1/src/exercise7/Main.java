package exercise7;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 7: Financial Forecasting ===");

        double presentValue = 1000.00; // $1,000 initial investment
        double growthRate = 0.05;     // 5% annual growth rate
        int years = 10;                // Forecast for 10 years

        System.out.println(String.format("Initial Value: $%.2f", presentValue));
        System.out.println(String.format("Annual Growth Rate: %.1f%%", growthRate * 100));
        System.out.println("Forecast Period: " + years + " years");

        // 1. Recursive calculation
        System.out.println("\n--- Recursive Calculation ---");
        double futureValueRec = FinancialForecasting.calculateFutureValueRecursive(presentValue, growthRate, years);
        System.out.println(String.format("Predicted Future Value (Recursive): $%.2f", futureValueRec));

        // 2. Iterative/Optimized calculation
        System.out.println("\n--- Iterative (Optimized) Calculation ---");
        double futureValueIter = FinancialForecasting.calculateFutureValueIterative(presentValue, growthRate, years);
        System.out.println(String.format("Predicted Future Value (Iterative): $%.2f", futureValueIter));

        // Verifying results match
        System.out.println(String.format("\nDo the results match? %b", 
                Math.abs(futureValueRec - futureValueIter) < 0.0001));

        // Display forecast year by year using recursion
        System.out.println("\nYear-by-Year Forecast (Recursive):");
        for (int i = 0; i <= years; i++) {
            double val = FinancialForecasting.calculateFutureValueRecursive(presentValue, growthRate, i);
            System.out.println(String.format("  Year %2d: $%,.2f", i, val));
        }
    }
}
