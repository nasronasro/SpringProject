package ma.nasro.taskflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.nasro.taskflow.dto.TaskResponse;
import ma.nasro.taskflow.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping("/list")
    public String listAllTasks(Model model) {
        TaskResponse taskResponse = new TaskResponse();

        model.addAttribute("Tasks", taskResponse.TaskListToTaskResponseList( taskService.listAllTasks()));

        return "task/list";
    }

}
