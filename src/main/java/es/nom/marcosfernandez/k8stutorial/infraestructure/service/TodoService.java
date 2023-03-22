package es.nom.marcosfernandez.k8stutorial.infraestructure.service;

import es.nom.marcosfernandez.k8stutorial.domain.entity.TodoEntity;
import es.nom.marcosfernandez.k8stutorial.infraestructure.dto.Todo;
import es.nom.marcosfernandez.k8stutorial.infraestructure.exception.ResourceNotFoundException;

import java.util.List;

public interface TodoService {

	Todo findById(Integer id) throws ResourceNotFoundException;

	List<Todo> findAll();

	Todo createTodo(Todo todo);

	Todo updateTodo(Integer id, Todo todo) throws ResourceNotFoundException;

	void deleteById(Integer id) throws ResourceNotFoundException;

}
