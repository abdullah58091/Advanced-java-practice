import java.util.HashSet;
import java.util.Set;

public class Set_interface {
    public static void main(String[] args) {

        Set<String> names = new HashSet<>();

        names.add("Abdullah");
        names.add("Ali");
        names.add("Abdullah");

        System.out.println(names);
        System.out.println("Size: " + names.size());
    }
}
