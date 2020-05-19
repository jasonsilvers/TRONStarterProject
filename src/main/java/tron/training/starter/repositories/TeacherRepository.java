package tron.training.starter.repositories;

import tron.training.starter.entities.TeacherEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeacherRepository extends CrudRepository<TeacherEntity, UUID> {
    TeacherEntity findTeacherById(UUID id);
    TeacherEntity findTeacherByName(String name);
}
