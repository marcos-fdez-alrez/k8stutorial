package es.nom.marcosfernandez.k8stutorial.infraestructure.mapper;

import es.nom.marcosfernandez.k8stutorial.domain.entity.TodoEntity;
import es.nom.marcosfernandez.k8stutorial.infraestructure.dto.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapper {

	TodoMapper INSTANCE = Mappers.getMapper( TodoMapper.class );

	Todo todoEntityToTodo(TodoEntity todoEntity);

	TodoEntity todoToTodoEntity(Todo todo);

}
