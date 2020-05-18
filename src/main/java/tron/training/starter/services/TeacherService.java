package tron.training.starter.services;

import tron.training.starter.entities.Teacher;
import tron.training.starter.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAll() {
       return (List<Teacher>) teacherRepository.findAll();
    }

}
