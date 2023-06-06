package com.example.mappers;

import com.example.dto.lesson.LessonDto;
import com.example.dto.studyClass.StudyClassDto;
import com.example.dto.studyTimetable.NewOrUpdateStudyTimetableDto;
import com.example.dto.studyTimetable.StudyTimetableDto;
import com.example.dto.teacher.TeacherDto;
import com.example.models.Lesson;
import com.example.models.StudyClass;
import com.example.models.StudyTimetable;
import com.example.models.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T16:46:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class StudyTimetableMapperImpl implements StudyTimetableMapper {

    @Override
    public StudyTimetableDto toDto(StudyTimetable studyTimetable) {
        if ( studyTimetable == null ) {
            return null;
        }

        StudyTimetableDto.StudyTimetableDtoBuilder studyTimetableDto = StudyTimetableDto.builder();

        studyTimetableDto.id( studyTimetable.getId() );
        studyTimetableDto.lesson( lessonToLessonDto( studyTimetable.getLesson() ) );
        studyTimetableDto.studyClass( studyClassToStudyClassDto( studyTimetable.getStudyClass() ) );
        studyTimetableDto.teacher( teacherToTeacherDto( studyTimetable.getTeacher() ) );
        studyTimetableDto.room( studyTimetable.getRoom() );
        studyTimetableDto.lessonStartDate( studyTimetable.getLessonStartDate() );

        return studyTimetableDto.build();
    }

    @Override
    public StudyTimetable toTimetable(StudyTimetableDto studyTimetableDto) {
        if ( studyTimetableDto == null ) {
            return null;
        }

        StudyTimetable.StudyTimetableBuilder studyTimetable = StudyTimetable.builder();

        studyTimetable.id( studyTimetableDto.getId() );
        studyTimetable.lesson( lessonDtoToLesson( studyTimetableDto.getLesson() ) );
        studyTimetable.studyClass( studyClassDtoToStudyClass( studyTimetableDto.getStudyClass() ) );
        studyTimetable.teacher( teacherDtoToTeacher( studyTimetableDto.getTeacher() ) );
        studyTimetable.room( studyTimetableDto.getRoom() );
        studyTimetable.lessonStartDate( studyTimetableDto.getLessonStartDate() );

        return studyTimetable.build();
    }

    @Override
    public StudyTimetable toTimetable(NewOrUpdateStudyTimetableDto studyTimetableDto) {
        if ( studyTimetableDto == null ) {
            return null;
        }

        StudyTimetable.StudyTimetableBuilder studyTimetable = StudyTimetable.builder();

        studyTimetable.room( studyTimetableDto.getRoom() );
        studyTimetable.lessonStartDate( studyTimetableDto.getLessonStartDate() );

        return studyTimetable.build();
    }

    @Override
    public List<StudyTimetableDto> studyTimetableDtoList(List<StudyTimetable> studyTimetable) {
        if ( studyTimetable == null ) {
            return null;
        }

        List<StudyTimetableDto> list = new ArrayList<StudyTimetableDto>( studyTimetable.size() );
        for ( StudyTimetable studyTimetable1 : studyTimetable ) {
            list.add( toDto( studyTimetable1 ) );
        }

        return list;
    }

    protected LessonDto lessonToLessonDto(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDto.LessonDtoBuilder lessonDto = LessonDto.builder();

        lessonDto.id( lesson.getId() );
        lessonDto.subject( lesson.getSubject() );
        lessonDto.topic( lesson.getTopic() );

        return lessonDto.build();
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

    protected StudyClassDto studyClassToStudyClassDto(StudyClass studyClass) {
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

    protected Lesson lessonDtoToLesson(LessonDto lessonDto) {
        if ( lessonDto == null ) {
            return null;
        }

        Lesson.LessonBuilder lesson = Lesson.builder();

        lesson.id( lessonDto.getId() );
        lesson.subject( lessonDto.getSubject() );
        lesson.topic( lessonDto.getTopic() );

        return lesson.build();
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

    protected StudyClass studyClassDtoToStudyClass(StudyClassDto studyClassDto) {
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
}
