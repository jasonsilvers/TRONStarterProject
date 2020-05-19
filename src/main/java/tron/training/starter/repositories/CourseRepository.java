package tron.training.starter.repositories;

import tron.training.starter.entities.CourseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseRepository extends CrudRepository<CourseEntity, UUID> {
    CourseEntity findByName(String name);
}
