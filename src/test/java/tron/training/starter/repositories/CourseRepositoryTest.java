package tron.training.starter.repositories;

import tron.training.starter.entities.Course;
import tron.training.starter.entities.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testFindByName() {

        Teacher pj = new Teacher(
                "Professor Jirafales",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg",
                "jirafales@yahoo_.com"
        );

//
//        Integer id = entityManager.persistAndGetId(pj, Integer.class);
        entityManager.persist(pj);
        entityManager.flush();

//        assertThat("test").isEqualTo("test");

        Course mathematics = new Course("Mathematics", 20, (short) 10, pj);
        entityManager.persist(mathematics);
        entityManager.flush();
        Course foundCourse = courseRepository.findByName("Mathematics");
//
//        assertNotNull(mathematics);
        assertThat(foundCourse.getName()).isEqualTo("Mathematics");


    }

}