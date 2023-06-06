package com.example.mappers;

import com.example.dto.lesson.LessonDto;
import com.example.dto.lesson.NewOrUpdateLessonDto;
import com.example.models.Lesson;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T16:46:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonDto toDto(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDto.LessonDtoBuilder lessonDto = LessonDto.builder();

        lessonDto.id( lesson.getId() );
        lessonDto.subject( lesson.getSubject() );
        lessonDto.topic( lesson.getTopic() );

        return lessonDto.build();
    }

    @Override
    public Lesson toLesson(LessonDto lessonDto) {
        if ( lessonDto == null ) {
            return null;
        }

        Lesson.LessonBuilder lesson = Lesson.builder();

        lesson.id( lessonDto.getId() );
        lesson.subject( lessonDto.getSubject() );
        lesson.topic( lessonDto.getTopic() );

        return lesson.build();
    }

    @Override
    public Lesson toLesson(NewOrUpdateLessonDto lessonDto) {
        if ( lessonDto == null ) {
            return null;
        }

        Lesson.LessonBuilder lesson = Lesson.builder();

        lesson.subject( lessonDto.getSubject() );
        lesson.topic( lessonDto.getTopic() );

        return lesson.build();
    }
}
