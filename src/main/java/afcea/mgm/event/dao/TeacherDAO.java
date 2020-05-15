package afcea.mgm.event.dao;

import afcea.mgm.event.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TeacherDAO extends CrudRepository<Teacher, UUID> {
    Teacher findTeacherById(UUID id);
    Teacher findTeacherByName(String name);
}
