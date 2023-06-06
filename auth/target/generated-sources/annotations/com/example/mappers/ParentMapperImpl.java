package com.example.mappers;

import com.example.dto.parent.NewOrUpdateParentDto;
import com.example.dto.parent.ParentDto;
import com.example.models.Parent;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T16:46:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ParentMapperImpl implements ParentMapper {

    @Override
    public ParentDto toDto(Parent parent) {
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

    @Override
    public Parent toParent(ParentDto parentDto) {
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

    @Override
    public Parent toParent(NewOrUpdateParentDto parentDto) {
        if ( parentDto == null ) {
            return null;
        }

        Parent.ParentBuilder<?, ?> parent = Parent.builder();

        parent.firstName( parentDto.getFirstName() );
        parent.lastName( parentDto.getLastName() );
        parent.age( parentDto.getAge() );

        return parent.build();
    }
}
