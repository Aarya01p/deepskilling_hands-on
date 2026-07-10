package exercise5;

public class TaskList {
    private Node head;

    // Node class representing an element in the singly linked list
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public TaskList() {
        this.head = null;
    }

    // Add a task to the end of the list
    // Time Complexity: O(n) (since we traverse to the end. Note: could be O(1) if we kept a tail pointer)
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task added: " + task.getTaskName());
    }

    // Search for a task by ID
    // Time Complexity: O(n)
    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null; // Not found
    }

    // Delete a task by ID
    // Time Complexity: O(n)
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        // If head itself holds the task to be deleted
        if (head.task.getTaskId().equals(taskId)) {
            String name = head.task.getTaskName();
            head = head.next; // Move head
            System.out.println("Task deleted: " + name);
            return;
        }

        // Search for the task to be deleted, keep track of the previous node
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.task.getTaskId().equals(taskId)) {
                String name = curr.task.getTaskName();
                prev.next = curr.next; // Unlink node
                System.out.println("Task deleted: " + name);
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // Traverse and display all tasks
    // Time Complexity: O(n)
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("--- Task List ---");
        Node temp = head;
        while (temp != null) {
            System.out.println("  " + temp.task);
            temp = temp.next;
        }
        System.out.println("-----------------");
    }
}
