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
import ma.nasro.taskflow.model.Task;
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
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable("projectId")Long  projectId, @PathVariable("id") Long id, Model model) {
        TaskResponse taskResponse = new TaskResponse();
        model.addAttribute("projectId", projectId);
        model.addAttribute("taskForm", taskResponse.FromTaskToTaskResponse(taskService.getTaskById(id)));
        return "task/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute("taskDto") TaskResponse taskDto, Model model) {
        try {
            Task task = taskDto.FromTaskResponseToTask();
            task.setId(id); 
            taskService.updateTask(task, taskDto.getProjectId());
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "task/edit"; // Return to the form page with error
        }
        
        return "redirect:/project-management/" + taskDto.getProjectId() + "/tasks/list";
    }
    @GetMapping("/details/{id}")
    public String getTaskDetail(@PathVariable("projectId")Long  projectId,@PathVariable("id") Long id, Model model) {
        TaskResponse taskResponse = new TaskResponse();
        model.addAttribute("task", taskResponse.FromTaskToTaskResponse(taskService.getTaskById(id)));
        return "task/details";
    }
}
