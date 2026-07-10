package exercise5;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 5: Task Management System ===");

        TaskList list = new TaskList();

        Task t1 = new Task("T001", "Design Database", "Completed");
        Task t2 = new Task("T002", "Implement APIs", "In Progress");
        Task t3 = new Task("T003", "Write Unit Tests", "Pending");
        Task t4 = new Task("T004", "Deploy Application", "Pending");

        // 1. Add tasks
        System.out.println("\nAdding tasks:");
        list.addTask(t1);
        list.addTask(t2);
        list.addTask(t3);
        list.addTask(t4);

        // 2. Traverse tasks
        System.out.println("\nTraversing tasks:");
        list.traverseTasks();

        // 3. Search task
        System.out.println("\nSearching for Task T002:");
        Task found = list.searchTask("T002");
        System.out.println("Result: " + found);

        System.out.println("\nSearching for non-existent Task T999:");
        Task notFound = list.searchTask("T999");
        System.out.println("Result: " + notFound);

        // 4. Delete task
        System.out.println("\nDeleting Task T002 (Implement APIs):");
        list.deleteTask("T002");

        // Traverse after deletion
        System.out.println("\nTraversing tasks after deletion:");
        list.traverseTasks();

        System.out.println("\nDeleting head Task T001 (Design Database):");
        list.deleteTask("T001");

        // Traverse after deleting head
        System.out.println("\nTraversing tasks after deleting head:");
        list.traverseTasks();
    }
}
