package afcea.mgm.event.dao;

import afcea.mgm.event.entities.Course;
import afcea.mgm.event.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseDAO extends CrudRepository<Course, UUID> {
}
