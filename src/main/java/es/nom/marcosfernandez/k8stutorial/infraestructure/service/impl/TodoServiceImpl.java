package es.nom.marcosfernandez.k8stutorial.infraestructure.service.impl;

import es.nom.marcosfernandez.k8stutorial.domain.entity.TodoEntity;
import es.nom.marcosfernandez.k8stutorial.domain.repository.TodoRepository;
import es.nom.marcosfernandez.k8stutorial.infraestructure.dto.Todo;
import es.nom.marcosfernandez.k8stutorial.infraestructure.exception.ResourceNotFoundException;
import es.nom.marcosfernandez.k8stutorial.infraestructure.mapper.TodoMapper;
import es.nom.marcosfernandez.k8stutorial.infraestructure.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

	private TodoRepository todoRepository;

	@Override
	public Todo findById(Integer id) throws ResourceNotFoundException {
		return todoRepository
				.findById(id)
				.map(TodoMapper.INSTANCE::todoEntityToTodo)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found: " + id));
	}

	@Override
	public List<Todo> findAll()  {
		return todoRepository.findAll()
				.stream().map(TodoMapper.INSTANCE::todoEntityToTodo)
				.toList();
	}

	@Override
	public Todo createTodo(Todo todo) {
		TodoEntity todoEntity = todoRepository.save(TodoMapper.INSTANCE.todoToTodoEntity(todo));
		return TodoMapper.INSTANCE.todoEntityToTodo(todoEntity);
	}

	@Override
	public Todo updateTodo(Integer id, Todo todo) throws ResourceNotFoundException {
		TodoEntity todoEntity = todoRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found: " + id));

		// Update fields
		todoEntity.setTitle(todo.getTitle());
		todoEntity.setDescription(todo.getDescription());
		todoEntity.setCompleted(todo.getCompleted());

		todoEntity = todoRepository.save(todoEntity);

		return TodoMapper.INSTANCE.todoEntityToTodo(todoEntity);
	}

	@Override
	public void deleteById(Integer id) throws ResourceNotFoundException {

		// Verify if resource exists
		Todo todo = findById(id);
		todoRepository.deleteById(todo.getId());
	}

}
