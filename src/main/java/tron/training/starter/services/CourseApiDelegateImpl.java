package tron.training.starter.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tron.training.starter.api.CoursesApiDelegate;
import tron.training.starter.model.Course;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseApiDelegateImpl implements CoursesApiDelegate {

    @Override
    public ResponseEntity<List<Course>> getcourses() {
        List<Course> courses = new ArrayList<>();
        Course c1 = new Course();
        c1.setName("bob");
        c1.setRate(23939.233f);
        c1.setWorkload(234);
        courses.add(c1);

        return ResponseEntity.ok(courses);
    }
}
