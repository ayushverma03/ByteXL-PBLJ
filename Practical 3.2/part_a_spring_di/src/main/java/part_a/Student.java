package parta;

public class Student {
    private String name;
    private Course course;

    // Constructor injection
    public Student(Course course) {
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Student Name: " + name);
        course.displayCourse();
    }
}
