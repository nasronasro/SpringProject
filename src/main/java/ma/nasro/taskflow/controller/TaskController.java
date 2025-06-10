package ma.nasro.taskflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.nasro.taskflow.dto.TaskRequest;
import ma.nasro.taskflow.dto.TaskResponse;
import ma.nasro.taskflow.service.TaskService;

@Controller
@RequestMapping("/project-management/{projectId}/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping("/list") 
    public String listAllTasks(@PathVariable("projectId")Long  projectId, Model model) {
        TaskResponse taskResponse = new TaskResponse();
        model.addAttribute("projectId", projectId);
        model.addAttribute("tasks", taskResponse.TaskListToTaskResponseList( taskService.listAllTasks(projectId)));

        return "task/list";
    }
    @GetMapping("/add")
    public String createTask(@PathVariable("projectId")Long  projectId,Model model) {
        model.addAttribute("projectId", projectId);
        model.addAttribute("taskForm", new TaskResponse());
        return "task/add";
    }
    @PostMapping("/add")
    public String addTask(@ModelAttribute("taskDto") TaskRequest taskDto, Model model) {
        try {
            taskService.createTask(taskDto.FromTaskRequestToTask(), taskDto.getProjectId());
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "task/add"; // Return to the form page with error
        }
        
        return "redirect:/project-management/" + taskDto.getProjectId() + "/tasks/list";
    }

}
