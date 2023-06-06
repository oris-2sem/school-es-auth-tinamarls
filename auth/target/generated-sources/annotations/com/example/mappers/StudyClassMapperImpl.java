package com.example.mappers;

import com.example.dto.studyClass.NewOrUpdateStudyClassDto;
import com.example.dto.studyClass.StudyClassDto;
import com.example.dto.teacher.TeacherDto;
import com.example.models.StudyClass;
import com.example.models.Teacher;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T16:46:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class StudyClassMapperImpl implements StudyClassMapper {

    @Override
    public StudyClassDto toDto(StudyClass studyClass) {
        if ( studyClass == null ) {
            return null;
        }

        StudyClassDto.StudyClassDtoBuilder studyClassDto = StudyClassDto.builder();

        studyClassDto.id( studyClass.getId() );
        studyClassDto.literal( studyClass.getLiteral() );
        studyClassDto.startDateOfStudying( studyClass.getStartDateOfStudying() );
        studyClassDto.teacher( teacherToTeacherDto( studyClass.getTeacher() ) );

        return studyClassDto.build();
    }

    @Override
    public StudyClass toClass(StudyClassDto studyClassDto) {
        if ( studyClassDto == null ) {
            return null;
        }

        StudyClass.StudyClassBuilder studyClass = StudyClass.builder();

        studyClass.id( studyClassDto.getId() );
        studyClass.literal( studyClassDto.getLiteral() );
        studyClass.startDateOfStudying( studyClassDto.getStartDateOfStudying() );
        studyClass.teacher( teacherDtoToTeacher( studyClassDto.getTeacher() ) );

        return studyClass.build();
    }

    @Override
    public StudyClass toClass(NewOrUpdateStudyClassDto studyClassDto) {
        if ( studyClassDto == null ) {
            return null;
        }

        StudyClass.StudyClassBuilder studyClass = StudyClass.builder();

        studyClass.literal( studyClassDto.getLiteral() );
        studyClass.startDateOfStudying( studyClassDto.getStartDateOfStudying() );

        return studyClass.build();
    }

    protected TeacherDto teacherToTeacherDto(Teacher teacher) {
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

    protected Teacher teacherDtoToTeacher(TeacherDto teacherDto) {
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
}
