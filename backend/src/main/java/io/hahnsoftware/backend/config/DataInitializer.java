package io.hahnsoftware.backend.config;

import io.hahnsoftware.backend.dto.TaskDTO;
import io.hahnsoftware.backend.entity.Task;
import io.hahnsoftware.backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final TaskService taskService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Initializing sample data...");
        
        // Create sample tasks
        TaskDTO task1 = new TaskDTO();
        task1.setTitle("Complete Project Documentation");
        task1.setDescription("Write comprehensive documentation for the backend API");
        task1.setPriority(Task.TaskPriority.HIGH);
        task1.setStatus(Task.TaskStatus.TODO);
        task1.setDueDate(LocalDateTime.now().plusDays(7).toLocalDate());
        
        TaskDTO task2 = new TaskDTO();
        task2.setTitle("Implement User Authentication");
        task2.setDescription("Add JWT-based authentication to the application");
        task2.setPriority(Task.TaskPriority.URGENT);
        task2.setStatus(Task.TaskStatus.IN_PROGRESS);
        task2.setDueDate(LocalDateTime.now().plusDays(3).toLocalDate());
        
        TaskDTO task3 = new TaskDTO();
        task3.setTitle("Write Unit Tests");
        task3.setDescription("Create comprehensive unit tests for all services");
        task3.setPriority(Task.TaskPriority.MEDIUM);
        task3.setStatus(Task.TaskStatus.TODO);
        task3.setDueDate(LocalDateTime.now().plusDays(14).toLocalDate());
        
        TaskDTO task4 = new TaskDTO();
        task4.setTitle("Code Review");
        task4.setDescription("Review pull requests and provide feedback");
        task4.setPriority(Task.TaskPriority.LOW);
        task4.setStatus(Task.TaskStatus.REVIEW);
        task4.setDueDate(LocalDateTime.now().plusDays(1).toLocalDate());
        
        // Save tasks
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);
        taskService.addTask(task4);
        
        log.info("Sample data initialized successfully!");
    }
} 