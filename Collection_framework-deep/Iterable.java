import java.util.ArrayList;
public class Iterable {


    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Abdullah");
        names.add("Ali");
        names.add("Sara");

        for (String name : names) {
            System.out.println(name);
        }
    }
}

