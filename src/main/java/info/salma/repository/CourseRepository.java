package info.salma.repository;

import info.salma.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class CourseRepository {
    @Autowired
    EntityManager entityManager;

    public Course findById(long id) {
        return  entityManager.find(Course.class, id);
    }
}
