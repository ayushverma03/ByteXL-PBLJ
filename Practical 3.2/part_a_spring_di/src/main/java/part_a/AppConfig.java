package parta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        return new Course("Spring Framework Basics");
    }

    @Bean
    public Student student() {
        Student s = new Student(course());
        s.setName("Ayush"); // example name; change if desired
        return s;
    }
}
