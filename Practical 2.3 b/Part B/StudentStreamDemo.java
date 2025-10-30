import java.util.*;
import java.util.stream.Collectors;

public class StudentStreamDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 80),
                new Student("Bob", 70),
                new Student("Charlie", 90),
                new Student("David", 76)
        );

        List<String> topStudents = students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Students scoring above 75% sorted by marks:");
        topStudents.forEach(System.out::println);
    }
}
