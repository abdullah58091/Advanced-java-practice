import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionFundamentals {

    public static void main(String[] args) {

        // Create a collection
        List<String> names = new ArrayList<>();

        // Add elements
        names.add("Abdullah");
        names.add("Ali");
        names.add("Sara");
        names.add("Zoya");

        // Display the collection
        System.out.println("Original List: " + names);

        // Display the number of elements
        System.out.println("Total Names: " + names.size());

        // Search for an element
        System.out.println(
                "Contains Ali: " + names.contains("Ali")
        );

        // Sort the list
        Collections.sort(names);
        System.out.println("Sorted List: " + names);

        // Reverse the list
        Collections.reverse(names);
        System.out.println("Reversed List: " + names);

        // Remove an element
        names.remove("Ali");
        System.out.println("After Removing Ali: " + names);

        // Check whether the collection is empty
        System.out.println("Is Empty: " + names.isEmpty());

        // Clear the collection
        names.clear();
        System.out.println("After Clear: " + names);

        System.out.println("Is Empty Now: " + names.isEmpty());
    }
}
