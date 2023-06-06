package com.example.mappers;

import com.example.dto.teacher.NewOrUpdateTeacherDto;
import com.example.dto.teacher.TeacherDto;
import com.example.models.Teacher;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T16:46:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherDto toDto(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDto.TeacherDtoBuilder teacherDto = TeacherDto.builder();

        teacherDto.id( teacher.getId() );
        teacherDto.experience( teacher.getExperience() );
        teacherDto.firstName( teacher.getFirstName() );
        teacherDto.lastName( teacher.getLastName() );
        teacherDto.age( teacher.getAge() );

        return teacherDto.build();
    }

    @Override
    public Teacher toTeacher(TeacherDto teacherDto) {
        if ( teacherDto == null ) {
            return null;
        }

        Teacher.TeacherBuilder<?, ?> teacher = Teacher.builder();

        teacher.id( teacherDto.getId() );
        teacher.firstName( teacherDto.getFirstName() );
        teacher.lastName( teacherDto.getLastName() );
        teacher.age( teacherDto.getAge() );
        teacher.experience( teacherDto.getExperience() );

        return teacher.build();
    }

    @Override
    public Teacher toTeacher(NewOrUpdateTeacherDto teacherDto) {
        if ( teacherDto == null ) {
            return null;
        }

        Teacher.TeacherBuilder<?, ?> teacher = Teacher.builder();

        teacher.firstName( teacherDto.getFirstName() );
        teacher.lastName( teacherDto.getLastName() );
        teacher.age( teacherDto.getAge() );
        teacher.experience( teacherDto.getExperience() );

        return teacher.build();
    }
}
