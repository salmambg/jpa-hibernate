package info.salma.seeders;

import info.salma.entity.Course;
import info.salma.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Autowired
    CourseRepository courseRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        logger.info("insert course data");
        seedCourseData();
        logger.info("finish insert course data");
    }

    private void seedCourseData() {
        List<Course> courses = new ArrayList<>();

        Course course1 = new Course();
        course1.setId(10001);
        course1.setName("JPA in 50 Steps");
        courses.add(course1);

        Course course2 = new Course();
        course2.setId(10002);
        course2.setName("Spring Boot Basics");
        courses.add(course2);

        Course course3 = new Course();
        course3.setId(10003);
        course3.setName("Hibernate Fundamentals");
        courses.add(course3);

        courseRepository.saveAll(courses);

    }

    public void RemoveData() {
        long courseIdToDelete = 10001; // Set the ID of the course you want to delete
        courseRepository.deleteById(courseIdToDelete);
    }

}
