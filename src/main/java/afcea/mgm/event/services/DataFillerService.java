package afcea.mgm.event.services;

import afcea.mgm.event.dao.CourseDAO;
import afcea.mgm.event.dao.TeacherDAO;
import afcea.mgm.event.entities.Course;
import afcea.mgm.event.entities.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataFillerService {
    private final CourseDAO courseDAO;
    private final TeacherDAO teacherDAO;


    public DataFillerService(CourseDAO courseDAO, TeacherDAO teacherDAO) {
        this.courseDAO = courseDAO;
        this.teacherDAO = teacherDAO;
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
        teacherDAO.save(pj);
        teacherDAO.save(px);
        teacherDAO.save(pt);
        // create courses
        Course mathematics = new Course("Mathematics", 20, (short) 10, pj);
        Course spanish = new Course("Spanish", 20, (short) 10, pj);
        Course dealingWithUnknown = new Course("Dealing with unknown", 10, (short) 100, pj);
        Course handlingYourMentalPower = new Course("Handling your mental power", 50, (short) 100, pj);
        Course introductionToPsychology = new Course("Introduction to psychology", 90, (short) 100, pj);
        courseDAO.save(mathematics);
        courseDAO.save(spanish);
        courseDAO.save(dealingWithUnknown);
        courseDAO.save(handlingYourMentalPower);
        courseDAO.save(introductionToPsychology);
    }
}
