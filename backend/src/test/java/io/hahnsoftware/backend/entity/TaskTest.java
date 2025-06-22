package io.hahnsoftware.backend.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Task Entity Basic CRUD Tests")
class TaskTest {

    private Task task;
    private LocalDateTime testDateTime;

    @BeforeEach
    void setUp() {
        testDateTime = LocalDateTime.of(2025, 6, 22, 10, 30);
        task = new Task();
    }

    @Test
    @DisplayName("CREATE - Should create a new task")
    void shouldCreateNewTask() {
        // Given
        String title = "Test Task";
        String description = "Test Description";
        Task.TaskStatus status = Task.TaskStatus.TODO;
        Task.TaskPriority priority = Task.TaskPriority.MEDIUM;

        // When
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        task.setPriority(priority);

        // Then
        assertEquals(title, task.getTitle());
        assertEquals(description, task.getDescription());
        assertEquals(status, task.getStatus());
        assertEquals(priority, task.getPriority());
    }

    @Test
    @DisplayName("READ - Should read task properties")
    void shouldReadTaskProperties() {
        // Given
        task.setId(1L);
        task.setTitle("Read Test Task");
        task.setStatus(Task.TaskStatus.IN_PROGRESS);

        // When & Then
        assertEquals(1L, task.getId());
        assertEquals("Read Test Task", task.getTitle());
        assertEquals(Task.TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test
    @DisplayName("UPDATE - Should update task properties")
    void shouldUpdateTaskProperties() {
        // Given - Initial values
        task.setTitle("Old Title");
        task.setStatus(Task.TaskStatus.TODO);

        // When - Update values
        task.setTitle("Updated Title");
        task.setStatus(Task.TaskStatus.COMPLETED);
        task.setCompletedAt(testDateTime);

        // Then
        assertEquals("Updated Title", task.getTitle());
        assertEquals(Task.TaskStatus.COMPLETED, task.getStatus());
        assertEquals(testDateTime, task.getCompletedAt());
    }

    @Test
    @DisplayName("DELETE - Should handle task deletion (set to null)")
    void shouldHandleTaskDeletion() {
        // Given - Task with values
        task.setTitle("Task to Delete");
        task.setDescription("Description to Delete");
        task.setStatus(Task.TaskStatus.IN_PROGRESS);

        // When - Set values to null (simulate deletion)
        task.setTitle(null);
        task.setDescription(null);
        task.setStatus(null);

        // Then
        assertNull(task.getTitle());
        assertNull(task.getDescription());
        assertNull(task.getStatus());
    }

    @Test
    @DisplayName("CRUD - Complete task lifecycle test")
    void shouldHandleCompleteTaskLifecycle() {
        // CREATE
        task.setTitle("Lifecycle Task");
        task.setDescription("Test the complete lifecycle");
        task.setStatus(Task.TaskStatus.TODO);
        task.setPriority(Task.TaskPriority.HIGH);
        
        assertEquals("Lifecycle Task", task.getTitle());
        assertEquals(Task.TaskStatus.TODO, task.getStatus());

        // UPDATE - Change status
        task.setStatus(Task.TaskStatus.IN_PROGRESS);
        assertEquals(Task.TaskStatus.IN_PROGRESS, task.getStatus());

        // UPDATE - Complete the task
        task.setStatus(Task.TaskStatus.COMPLETED);
        task.setCompletedAt(testDateTime);
        
        assertEquals(Task.TaskStatus.COMPLETED, task.getStatus());
        assertEquals(testDateTime, task.getCompletedAt());

        // READ - Verify all properties
        assertEquals("Lifecycle Task", task.getTitle());
        assertEquals("Test the complete lifecycle", task.getDescription());
        assertEquals(Task.TaskPriority.HIGH, task.getPriority());
    }
} 