import java.util.ArrayList;
import java.util.Collection;
public class Hierarchy {

    public static void main(String[] args) {
    
    Collection<String> names = new ArrayList<>();

    names.add("Abdullah");
     names.add("Ali");
    names.add("Sara");

      System.out.println(names);

      System.out.println(names.size());
System.out.println(names.contains("Ali"));

names.remove("Sara");

System.out.println(names);

    }
}