package com.example.taskmanager.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.repository.UserRepository;

@Service
public class TaskService {
     private final TaskRepository taskRepository;
     private final UserRepository userRepository;


    public TaskService(TaskRepository taskRepository, UserRepository userRepository ) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    
    public List<Task> getTasksForUser(String username) {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found"));
    return taskRepository.findByUser(user);
}

public Task addTaskForUser(Task task, String username) {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found"));
    task.setUser(user);
    return taskRepository.save(task);
}

}
