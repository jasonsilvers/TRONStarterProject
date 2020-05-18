package tron.training.starter.repositories;

import tron.training.starter.entities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseRepository extends CrudRepository<Course, UUID> {
    Course findByName(String name);
}
