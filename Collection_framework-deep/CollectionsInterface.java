import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsInterface {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        Collections.sort(numbers);

        System.out.println(numbers);

        Collections.reverse(numbers);

        System.out.println(numbers);
    }
}

