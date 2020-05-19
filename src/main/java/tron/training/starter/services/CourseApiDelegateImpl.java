package tron.training.starter.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tron.training.starter.api.CoursesApiDelegate;
import tron.training.starter.entities.CourseEntity;
import tron.training.starter.model.Course;
import tron.training.starter.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseApiDelegateImpl implements CoursesApiDelegate {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public ResponseEntity<List<Course>> getcourses() {

        List<CourseEntity> courseEntities = (List<CourseEntity>) courseRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<Course> courses = courseEntities
                                .stream()
                                .map(courseEntity -> modelMapper.map(courseEntity, Course.class))
                                .collect(Collectors.toList());

        return ResponseEntity.ok(courses);
    }
}
