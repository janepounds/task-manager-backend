package com.example.taskmanager.controller;


import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
     private final TaskService taskService;
     private final UserRepository userRepository;

    public TaskController(TaskRepository taskRepository, TaskService taskService, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
        this.userRepository = userRepository;
    }

    // Secured endpoint: only works if JWT is valid
    // @GetMapping("/api/tasks/hello")
    // public String hello(Authentication authentication) {
    //     return "Hello " + authentication.name() + ", you are authenticated!";
    // }

   // Get tasks for the logged-in user
    @GetMapping
    public List<Task> getTasks(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName())
                                   .orElseThrow(() -> new RuntimeException("User not found"));
        return taskRepository.findByUser(user);
    }

  @PostMapping
public Task createTask(@RequestBody Task task, Authentication authentication) {
    String username = authentication.getName(); // current logged-in user
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

    task.setUser(user); // associate task with user
    return taskRepository.save(task);
}

@PutMapping("/{id}")
public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask, Authentication authentication) {
    String username = authentication.getName();
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

    return taskRepository.findById(id)
            .filter(task -> task.getUser().getId().equals(user.getId())) // ensure user owns the task
            .map(task -> {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.isCompleted());
                return taskRepository.save(task);
            })
            .orElseThrow(() -> new RuntimeException("Task not found or not authorized"));
}

@DeleteMapping("/{id}")
public void deleteTask(@PathVariable Long id, Authentication authentication) {
    String username = authentication.getName();
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

    Task task = taskRepository.findById(id)
            .filter(t -> t.getUser().getId().equals(user.getId()))
            .orElseThrow(() -> new RuntimeException("Task not found or not authorized"));

    taskRepository.delete(task);
}

}

