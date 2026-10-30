import java.util.HashMap;

public class HashMapPractice {

    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Abdullah");
        students.put(102, "Ali");
        students.put(103, "Sara");
        students.put(104, "David");

        System.out.println(students);

        System.out.println("Student with ID 101: "
                + students.get(101));
    }
}