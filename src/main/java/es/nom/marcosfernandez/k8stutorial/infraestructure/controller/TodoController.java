package es.nom.marcosfernandez.k8stutorial.infraestructure.controller;

import es.nom.marcosfernandez.k8stutorial.infraestructure.dto.Todo;
import es.nom.marcosfernandez.k8stutorial.infraestructure.exception.ResourceNotFoundException;
import es.nom.marcosfernandez.k8stutorial.infraestructure.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@Validated
public class TodoController implements TodoOAS3 {
    private TodoService todoService;

    @Override
    public ResponseEntity<List<Todo>> getAllTodos() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Todo> getTodo(Integer id) {
        Todo task = null;
        try {
            task = todoService.findById(id);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } finally {
            return new ResponseEntity<>(task,HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Todo> createTodo(Todo todo) {
        return new ResponseEntity<>(todoService.createTodo(todo),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Todo> updateTodo(Integer id, Todo todo) {
        Todo task = null;
        try {
            task = todoService.updateTodo(id, todo);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } finally {
            return new ResponseEntity<>(task,HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<HttpStatus> deleteTodo(Integer id) throws ResourceNotFoundException {
        todoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
