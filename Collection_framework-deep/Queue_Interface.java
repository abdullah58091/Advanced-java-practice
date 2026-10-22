import java.util.LinkedList;
import java.util.Queue;

    public class Queue_Interface {
    public static void main(String[] args) {

        Queue<String> tasks = new LinkedList<>();

        tasks.offer("Task 1");
        tasks.offer("Task 2");
        tasks.offer("Task 3");

        System.out.println(tasks);

        System.out.println("Processed: " + tasks.poll());

        System.out.println(tasks);
    }
}

