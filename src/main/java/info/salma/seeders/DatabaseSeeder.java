package info.salma.seeders;

import info.salma.entity.Course;
import info.salma.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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

    public void seedCourseData() {
        Course course = new Course();
        course.setId(10001);
        course.setName("JPA in 50 Steps");
        courseRepository.save(course);
    }
}
