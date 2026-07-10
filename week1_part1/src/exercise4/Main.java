package exercise4;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 4: Employee Management System ===");

        // Initialize manager with an initial capacity of 2
        EmployeeManager manager = new EmployeeManager(2);

        Employee e1 = new Employee("E001", "Alice Smith", "Manager", 85000.00);
        Employee e2 = new Employee("E002", "Bob Jones", "Developer", 75000.00);
        Employee e3 = new Employee("E003", "Charlie Brown", "Designer", 65000.00);

        // 1. Add employees (this will trigger a resize when adding e3)
        System.out.println("\nAdding employees:");
        manager.addEmployee(e1);
        manager.addEmployee(e2);
        manager.addEmployee(e3);

        // 2. Traverse employees
        System.out.println("\nTraversing employees:");
        manager.traverseEmployees();

        // 3. Search employee
        System.out.println("\nSearching for Employee E002:");
        Employee found = manager.searchEmployee("E002");
        System.out.println("Result: " + found);

        System.out.println("\nSearching for non-existent Employee E999:");
        Employee notFound = manager.searchEmployee("E999");
        System.out.println("Result: " + notFound);

        // 4. Delete employee (should shift Charlie to index 1)
        System.out.println("\nDeleting Employee E002 (Bob Jones):");
        manager.deleteEmployee("E002");

        // Traverse again to see shifting
        System.out.println("\nTraversing employees after deletion:");
        manager.traverseEmployees();
    }
}
