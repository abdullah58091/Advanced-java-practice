import java.util.ArrayList;
import java.util.Collection;

public class CollectionInterface {
    public static void main(String[] args) {

        Collection<String> names = new ArrayList<>();

        names.add("Abdullah");
        names.add("Ali");
        names.add("Sara");

        System.out.println(names);
        System.out.println("Size: " + names.size());
        System.out.println("Contains Ali: " + names.contains("Ali"));

        names.remove("Ali");

        System.out.println(names);
    }
}