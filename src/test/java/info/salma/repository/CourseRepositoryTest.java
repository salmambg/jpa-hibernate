package info.salma.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;

    @Test
    public void findById() {
        repository.findById(10001L)
                .ifPresent(
                        course -> assertEquals("JPA in 50 Steps", course.getName())
                );
    }
}