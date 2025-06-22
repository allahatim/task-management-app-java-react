package io.hahnsoftware.backend.dto;

import io.hahnsoftware.backend.entity.Task;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    
    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must be at most 255 characters")
    private String title;
    
    @Size(max = 1000, message = "Description must be at most 1000 characters")
    private String description;
    
    @NotNull(message = "Status is required")
    private Task.TaskStatus status;
    
    @NotNull(message = "Priority is required")
    private Task.TaskPriority priority;
    
    @Future(message = "Due date must be in the future")
    private LocalDate dueDate;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    private LocalDateTime completedAt;
} 