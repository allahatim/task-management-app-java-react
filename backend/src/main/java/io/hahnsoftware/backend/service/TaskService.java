package io.hahnsoftware.backend.service;

import io.hahnsoftware.backend.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    TaskDTO addTask(TaskDTO taskDTO);

    TaskDTO getTask(Long id);

    List<TaskDTO> getAllTasks();

    List<TaskDTO> getTasksByStatus(String status);

    List<TaskDTO> getTasksByPriority(String priority);

    TaskDTO updateTask(TaskDTO taskDTO, Long id);

    void deleteTask(Long id);
    
    TaskDTO markTaskAsCompleted(Long id);
} 