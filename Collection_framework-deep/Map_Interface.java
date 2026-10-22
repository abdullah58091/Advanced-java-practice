 import java.util.HashMap;
import java.util.Map;

public class Map_Interface {
   
    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Abdullah");
        students.put(102, "Ali");
        students.put(103, "Sara");

        System.out.println(students);

        System.out.println(students.get(102));
    }
}

