import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListRemovePractice {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements to add: ");
        int n = scanner.nextInt();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("Original: " + numbers);

        numbers.remove(1);

        System.out.println("After removing index 1: " + numbers);

        numbers.remove(Integer.valueOf(40));

        System.out.println("After removing value 40: " + numbers);
        scanner.close();
    }
}