import java.util.ArrayList;

public class ArrayListPractice {

public static void main(String[] args) {

    ArrayList<Integer> numbers = new ArrayList<>();

    // Add elements
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);
    numbers.add(40);
    numbers.add(50);

    System.out.println("Original List: " + numbers);

    // Get the size
    System.out.println("Size of the list: " + numbers.size());

    // Access an element
    System.out.println("Element at index 2: " + numbers.get(2));

    // Add 25 at index 2
    numbers.add(2, 25);
    System.out.println("After adding 25 at index 2: " + numbers);

    // Remove the element at index 3
    System.out.println("Removed element: " + numbers.remove(3));

    // Print the final list
    System.out.println("Final List: " + numbers);
}


}

