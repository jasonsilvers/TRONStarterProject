package tron.training.starter.entities;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import tron.training.starter.model.Teacher;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TeacherEntityTest {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void checkTeacherMapping() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setEmail("joe.anderson@gmail.com");
        teacherEntity.setName("Joe Anderson");
        teacherEntity.setPictureUrl("/joeandersonprofilepic.jps");

        Teacher teacher = modelMapper.map(teacherEntity, Teacher.class);

        assertThat(teacherEntity.getId()).isEqualTo(teacher.getId());
        assertThat(teacherEntity.getEmail()).isEqualTo(teacher.getEmail());
        assertThat(teacherEntity.getName()).isEqualTo(teacher.getName());
        assertThat(teacherEntity.getPictureUrl()).isEqualTo(teacher.getPictureUrl());
    }
}