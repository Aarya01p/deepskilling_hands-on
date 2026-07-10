package exercise4;

public class EmployeeManager {
    private Employee[] employees;
    private int size; // Tracks the actual number of employees in the array
    private int capacity;

    public EmployeeManager(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size >= capacity) {
            // Resize array if it's full (double the capacity)
            resize();
        }
        employees[size] = employee;
        size++;
        System.out.println("Employee added: " + employee.getName());
    }

    // Resize array (simulating dynamic arrays/ArrayList behavior)
    private void resize() {
        capacity = capacity * 2;
        Employee[] temp = new Employee[capacity];
        System.arraycopy(employees, 0, temp, 0, size);
        employees = temp;
        System.out.println("Array resized to capacity: " + capacity);
    }

    // Search employee by ID
    // Time Complexity: O(n)
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Delete employee by ID
    // Time Complexity: O(n) due to element shifting
    public void deleteEmployee(String employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) {
            String name = employees[indexToDelete].getName();
            // Shift elements to the left to maintain contiguity
            for (int i = indexToDelete; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null; // Clear last element
            size--;
            System.out.println("Employee deleted: " + name);
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    // Traverse and print all employees
    // Time Complexity: O(n)
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employee records found.");
            return;
        }
        System.out.println("--- Employee Directory (Size: " + size + ", Capacity: " + capacity + ") ---");
        for (int i = 0; i < size; i++) {
            System.out.println("  " + employees[i]);
        }
        System.out.println("--------------------------------------------------");
    }
}
