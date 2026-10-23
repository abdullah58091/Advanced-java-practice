import java.util.ArrayList;

public class ArrayListGetPractice {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Abdullah");
        names.add("Ali");
        names.add("Sara");
        names.add("Aman");

        System.out.println(names.get(0));
        System.out.println(names.get(1));
        System.out.println(names.get(2));
        System.out.println(names.get(3));
    }
}