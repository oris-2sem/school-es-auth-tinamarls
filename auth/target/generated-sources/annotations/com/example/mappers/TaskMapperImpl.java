package com.example.mappers;

import com.example.dto.lesson.LessonDto;
import com.example.dto.parent.ParentDto;
import com.example.dto.student.StudentDto;
import com.example.dto.studyClass.StudyClassDto;
import com.example.dto.task.NewOrUpdateTaskDto;
import com.example.dto.task.TaskDto;
import com.example.dto.teacher.TeacherDto;
import com.example.models.Lesson;
import com.example.models.Parent;
import com.example.models.Student;
import com.example.models.StudyClass;
import com.example.models.Task;
import com.example.models.Teacher;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T16:46:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDto toDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto.TaskDtoBuilder taskDto = TaskDto.builder();

        taskDto.id( task.getId() );
        taskDto.lesson( lessonToLessonDto( task.getLesson() ) );
        taskDto.student( studentToStudentDto( task.getStudent() ) );
        taskDto.mark( task.getMark() );
        taskDto.description( task.getDescription() );
        taskDto.commentary( task.getCommentary() );
        taskDto.type( task.getType() );

        return taskDto.build();
    }

    @Override
    public Task toTask(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.id( taskDto.getId() );
        task.lesson( lessonDtoToLesson( taskDto.getLesson() ) );
        task.student( studentDtoToStudent( taskDto.getStudent() ) );
        task.mark( taskDto.getMark() );
        task.description( taskDto.getDescription() );
        task.commentary( taskDto.getCommentary() );
        task.type( taskDto.getType() );

        return task.build();
    }

    @Override
    public Task toTask(NewOrUpdateTaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.mark( taskDto.getMark() );
        task.description( taskDto.getDescription() );
        task.commentary( taskDto.getCommentary() );
        task.type( taskDto.getType() );

        return task.build();
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

    protected ParentDto parentToParentDto(Parent parent) {
        if ( parent == null ) {
            return null;
        }

        ParentDto.ParentDtoBuilder parentDto = ParentDto.builder();

        parentDto.id( parent.getId() );
        parentDto.firstName( parent.getFirstName() );
        parentDto.lastName( parent.getLastName() );
        parentDto.age( parent.getAge() );

        return parentDto.build();
    }

    protected StudentDto studentToStudentDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto.StudentDtoBuilder studentDto = StudentDto.builder();

        studentDto.id( student.getId() );
        studentDto.studyClass( studyClassToStudyClassDto( student.getStudyClass() ) );
        studentDto.parent( parentToParentDto( student.getParent() ) );
        studentDto.firstName( student.getFirstName() );
        studentDto.lastName( student.getLastName() );
        studentDto.age( student.getAge() );

        return studentDto.build();
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

    protected Parent parentDtoToParent(ParentDto parentDto) {
        if ( parentDto == null ) {
            return null;
        }

        Parent.ParentBuilder<?, ?> parent = Parent.builder();

        parent.id( parentDto.getId() );
        parent.firstName( parentDto.getFirstName() );
        parent.lastName( parentDto.getLastName() );
        parent.age( parentDto.getAge() );

        return parent.build();
    }

    protected Student studentDtoToStudent(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student.StudentBuilder<?, ?> student = Student.builder();

        student.id( studentDto.getId() );
        student.firstName( studentDto.getFirstName() );
        student.lastName( studentDto.getLastName() );
        student.age( studentDto.getAge() );
        student.studyClass( studyClassDtoToStudyClass( studentDto.getStudyClass() ) );
        student.parent( parentDtoToParent( studentDto.getParent() ) );

        return student.build();
    }
}
