import java.util.LinkedList;

public class LinkedListPractice {

    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();
        LinkedList<Integer> numbers = new LinkedList<>();
        names.add("Abdullah");
        names.add("Ali");
        names.add("Sara");
        names.add("David");
        names.remove("Ali");
        names.addFirst("rahul");
        names.addLast("Zara");

        System.out.println(names);

        
        numbers.add(20);    
        numbers.add(30);
        numbers.add(40);

        numbers.addFirst(10);
        numbers.addLast(50);
        System.out.println( "Linked List of numbers: " + numbers);

        System.out.println("Size of the list: " + numbers.size());
        System.out.println("Add First number:" + numbers.getFirst());
        System.out.println("Add Last number:" + numbers.getLast());
    }
}