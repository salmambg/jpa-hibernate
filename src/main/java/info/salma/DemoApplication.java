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
        Optional<Course> specificCourses = courseRepository.findById(10001L);
        if (specificCourses.isPresent()) {
            Course courseToUpdate = specificCourses.get();
            courseToUpdate.setName("MicroService in 50 steps"); // Update the course name
            courseRepository.save(courseToUpdate); // Save the updated course
            logger.info("Course 10001 updated -> {}", courseToUpdate);
        } else {
            logger.warn("Course 10001 not found");
        }
        Optional<Course> specificCourse = courseRepository.findById(10001L);
        logger.info("Course 10001 -> {}", specificCourse.orElse(null));
        courseRepository.deleteById(10002L);

    }
}