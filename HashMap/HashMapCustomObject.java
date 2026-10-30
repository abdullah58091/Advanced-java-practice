import java.util.HashMap;
import java.util.Objects;

class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return this.id == other.id;
    }
}

public class HashMapCustomObject {

    public static void main(String[] args) {

        HashMap<Student, String> students = new HashMap<>();

        Student s1 = new Student(101, "Abdullah");
        Student s2 = new Student(102, "Ali");

        students.put(s1, "Computer Science");
        students.put(s2, "Information Technology");

        System.out.println(students.get(s2));
    }
}