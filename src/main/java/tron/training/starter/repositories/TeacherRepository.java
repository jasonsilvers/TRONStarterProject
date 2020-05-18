package tron.training.starter.repositories;

import tron.training.starter.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeacherRepository extends CrudRepository<Teacher, UUID> {
    Teacher findTeacherById(UUID id);
    Teacher findTeacherByName(String name);
}
