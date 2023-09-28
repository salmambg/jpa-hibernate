package info.salma.repository;

import info.salma.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void findById() {
        repository.findById(10001L)
                .ifPresent(
                        entity -> assertEquals("JPA in 50 Steps", entity.getName())
                );
    }


    @Test
    public void UpdateCourse() {
        // Arrange: Retrieve an existing course from the database
        Optional<Course> courseOptional = repository.findById(10002L);
        assertTrue(courseOptional.isPresent());

        // Act: Update the course
        Course courseToUpdate = courseOptional.get();
        courseToUpdate.setName("MicroService in 50 steps");
        repository.save(courseToUpdate);

        // Assert: Retrieve the course again to check if it was updated
        Optional<Course> updatedCourseOptional = repository.findById(10002L);
        assertTrue(updatedCourseOptional.isPresent());

        // Assert that the updated properties match your expectations
        assertEquals("MicroService in 50 steps", updatedCourseOptional.get().getName());
    }

    @Test
    public void DeleteCourseById() {
        repository.deleteById(10003L);
        assertFalse(repository.findById(10003L).isPresent());
    }
}