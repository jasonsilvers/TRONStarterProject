package tron.training.starter.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tron.training.starter.api.TeachersApiDelegate;
import tron.training.starter.entities.TeacherEntity;
import tron.training.starter.model.Teacher;
import tron.training.starter.repositories.TeacherRepository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherApiDelegateImpl implements TeachersApiDelegate {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public ResponseEntity<List<Teacher>> getTeachers() {
        List<TeacherEntity> teacherEntities = (List<TeacherEntity>) teacherRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<Teacher> teachers = teacherEntities
                                    .stream()
                                    .map(teacherEntity -> modelMapper.map(teacherEntity, Teacher.class))
                                    .collect(Collectors.toList());

        return ResponseEntity.ok(teachers);

    }
}
