package es.nom.marcosfernandez.k8stutorial.infraestructure.controller;

import es.nom.marcosfernandez.k8stutorial.infraestructure.dto.Todo;
import es.nom.marcosfernandez.k8stutorial.infraestructure.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/v1/todos")
@Tag(name = "Portfolio Movements API", description = "Actions on portfolio movements")
public interface TodoOAS3 {

    String DEFAULT_PAGE_NUMBER = "0";
    String DEFAULT_PAGE_SIZE = "5";
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get all TODOs", description = "Get all TODOs information", responses = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not found")})
    ResponseEntity<List<Todo>> getAllTodos();

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get id TODO", description = "Get id TODOs information", responses = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not found")})
    ResponseEntity<Todo> getTodo(@PathVariable("id") Integer id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Create a not abante portfolio with movements", description = "Create portfolio movements", responses = {
            @ApiResponse(responseCode = "201", description = "Create"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "409", description = "Conflict")})
    ResponseEntity<Todo> createTodo(@RequestBody Todo todo);

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Update id todo", description = "Update id todo", responses = {
            @ApiResponse(responseCode = "201", description = "Create"),
            @ApiResponse(responseCode = "404", description = "Not found")})
    ResponseEntity<Todo> updateTodo(@PathVariable("id") Integer id, @RequestBody Todo todo);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete id todo", description = "Delete todo", responses = {
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "404", description = "Not found")})
    ResponseEntity<HttpStatus> deleteTodo(@PathVariable("id") Integer id) throws ResourceNotFoundException;


}

