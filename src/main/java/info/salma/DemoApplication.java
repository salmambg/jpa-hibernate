package info.salma;

import info.salma.entity.Course;
import info.salma.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CourseRepository courseRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Override
    public void run(String... arg0) throws Exception {
        List<Course> courses = courseRepository.findAll();
        for (Course course : courses) {
            logger.info("Course -> {}", course);
        }
        Optional<Course> specificCourse = courseRepository.findById(10001L);
        logger.info("Course 10001 -> {}", specificCourse.orElse(null));

        specificCourse.ifPresent(course -> {
            course.setName("MicroService in 50 Steps"); // Set the new name
            courseRepository.save(course); // Save the updated course
            logger.info("Course 10001 updated -> {}", course);
        });

        Optional<Course> specificCourse2 = courseRepository.findById(10002L);
        logger.info("Course 10002 -> {}", specificCourse2.orElse(null));

        specificCourse2.ifPresent(course -> {
            course.setName("JPA Hibernate Basics with 100 Steps"); // Set the new name
            courseRepository.save(course); // Save the updated course
            logger.info("Course 10002 updated -> {}", course);
        });

        courseRepository.deleteById(10003L);
    }
}