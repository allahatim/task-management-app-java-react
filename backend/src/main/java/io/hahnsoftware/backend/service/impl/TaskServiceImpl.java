package io.hahnsoftware.backend.service.impl;


import io.hahnsoftware.backend.dto.TaskDTO;
import io.hahnsoftware.backend.entity.Task;
import io.hahnsoftware.backend.exception.ResourceNotFoundException;
import io.hahnsoftware.backend.repository.TaskRepository;
import io.hahnsoftware.backend.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TaskDTO addTask(TaskDTO taskDTO) {
        // convert TaskDTO into Task Jpa entity
        Task task = modelMapper.map(taskDTO, Task.class);
        // Set default status if not provided
        if (task.getStatus() == null) {
            task.setStatus(Task.TaskStatus.TODO);
        }
        // Set default priority if not provided
        if (task.getPriority() == null) {
            task.setPriority(Task.TaskPriority.MEDIUM);
        }
        // Task Jpa entity
        Task savedTask = taskRepository.save(task);
        // Convert saved Task Jpa entity object into TaskDto object
        TaskDTO savedTaskDto = modelMapper.map(savedTask, TaskDTO.class);

        return savedTaskDto;
    }

    @Override
    public TaskDTO getTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id:" + id));
        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map((task -> modelMapper.map(task, TaskDTO.class))).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> getTasksByStatus(String status) {
        Task.TaskStatus taskStatus = Task.TaskStatus.valueOf(status.toUpperCase());
        List<Task> tasks = taskRepository.findByStatus(taskStatus);
        return tasks.stream().map((task -> modelMapper.map(task, TaskDTO.class))).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> getTasksByPriority(String priority) {
        Task.TaskPriority taskPriority = Task.TaskPriority.valueOf(priority.toUpperCase());
        List<Task> tasks = taskRepository.findByPriority(taskPriority);
        return tasks.stream().map((task -> modelMapper.map(task, TaskDTO.class))).collect(Collectors.toList());
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id:" + id));
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());
        Task updatedTask = taskRepository.save(task);
        return modelMapper.map(updatedTask, TaskDTO.class);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id:" + id));
        taskRepository.deleteById(id);
    }
    
    @Override
    public TaskDTO markTaskAsCompleted(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id:" + id));
        task.setStatus(Task.TaskStatus.COMPLETED);
        task.setCompletedAt(LocalDateTime.now());
        Task completedTask = taskRepository.save(task);
        return modelMapper.map(completedTask, TaskDTO.class);
    }
} 