package tron.training.starter.services;

import tron.training.starter.repositories.CourseRepository;
import tron.training.starter.repositories.TeacherRepository;
import tron.training.starter.entities.Course;
import tron.training.starter.entities.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class DataFillerService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public DataFillerService(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }
    @PostConstruct
    @Transactional
    public void fillData(){
        Teacher pj = new Teacher(
                "Professor Jirafales",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg",
                "jirafales@yahoo_.com"
        );
        Teacher px = new Teacher(
                "Professor X",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4",
                "director@xproject_.com"
        );

        Teacher pt = new Teacher(
                "Professor Boberson",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4",
                "bob@bob.com"
        );
        teacherRepository.save(pj);
        teacherRepository.save(px);
        teacherRepository.save(pt);
        // create courses
        Course mathematics = new Course("Mathematics", 20, (short) 10, pj);
        Course spanish = new Course("Spanish", 20, (short) 10, pj);
        Course dealingWithUnknown = new Course("Dealing with unknown", 10, (short) 100, pj);
        Course handlingYourMentalPower = new Course("Handling your mental power", 50, (short) 100, pj);
        Course introductionToPsychology = new Course("Introduction to psychology", 90, (short) 100, pj);
        courseRepository.save(mathematics);
        courseRepository.save(spanish);
        courseRepository.save(dealingWithUnknown);
        courseRepository.save(handlingYourMentalPower);
        courseRepository.save(introductionToPsychology);
    }
}
