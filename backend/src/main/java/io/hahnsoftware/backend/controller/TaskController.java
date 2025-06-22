package io.hahnsoftware.backend.controller;

import io.hahnsoftware.backend.dto.TaskDTO;
import io.hahnsoftware.backend.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Task API", description = "Operations related to tasks")
@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @Operation(summary = "Create a new task")
    @PostMapping
    public ResponseEntity<TaskDTO> addTask(@Valid @RequestBody TaskDTO taskDTO) {
        TaskDTO savedTaskDto = taskService.addTask(taskDTO);
        return new ResponseEntity<>(savedTaskDto, HttpStatus.CREATED);
    }

    @Operation(summary = "Get task by ID")
    @GetMapping("{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable("id") Long id) {
        TaskDTO taskDTO = taskService.getTask(id);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @Operation(summary = "Get all tasks")
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> taskDTOS = taskService.getAllTasks();
        return new ResponseEntity<>(taskDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get tasks by status")
    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskDTO>> getTasksByStatus(@PathVariable("status") String status) {
        List<TaskDTO> taskDTOS = taskService.getTasksByStatus(status);
        return new ResponseEntity<>(taskDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get tasks by priority")
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<TaskDTO>> getTasksByPriority(@PathVariable("priority") String priority) {
        List<TaskDTO> taskDTOS = taskService.getTasksByPriority(priority);
        return new ResponseEntity<>(taskDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Update an existing task")
    @PutMapping("{id}")
    public ResponseEntity<TaskDTO> updateTask(@Valid @RequestBody TaskDTO taskDTO, @PathVariable("id") Long id) {
        TaskDTO updatedTask = taskService.updateTask(taskDTO, id);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @Operation(summary = "Mark task as completed")
    @PatchMapping("{id}/complete")
    public ResponseEntity<TaskDTO> markTaskAsCompleted(@PathVariable("id") Long id) {
        TaskDTO completedTask = taskService.markTaskAsCompleted(id);
        return new ResponseEntity<>(completedTask, HttpStatus.OK);
    }

    @Operation(summary = "Delete task by ID")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully !");
    }
} 