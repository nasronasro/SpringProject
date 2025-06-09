package ma.nasro.taskflow.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.nasro.taskflow.dto.ProjectRequest;
import ma.nasro.taskflow.dto.ProjectResponse;
import ma.nasro.taskflow.model.Project;
import ma.nasro.taskflow.service.ProjectService;


@Controller
@RequestMapping("/project-management")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/add")
    public String createProject(Model model) {
        model.addAttribute("projectForm", new ProjectRequest());
        return "project/add";
    }

     @PostMapping("/add")
    public String addProject( @ModelAttribute("projectDto") ProjectRequest projectDto, 
                             BindingResult bindingResult,
                             Model model) { 

        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            return "project/add"; // Return to the form page
        }
        
        projectService.createProject(projectDto.ProjectDtoToProject());

        // Redirect to a different page after successful 
        return "redirect:/project-management/list";
    }
    
    @GetMapping("/list")
    public String listProjects(Model model) {
        ProjectResponse projectResponse = new ProjectResponse();

        model.addAttribute("projects", projectResponse.ProjectListToProjectResponseList( projectService.ListAllProjects()));

        return "project/list";
    }
    @GetMapping("/details/{id}")
    public String projectDetails(@PathVariable("id")Long  projectId, Model model) {
        if (projectId == null || projectId <= 0) {
            model.addAttribute("error", "Invalid project ID");
            return "error";
        }

        Project project = projectService.findProjectById(projectId);
        ProjectResponse projectResponse = new ProjectResponse();
        
        if(project == null)
            return "project/List";

        projectResponse.ProjectToProjectResponse(project);
        model.addAttribute("project", projectResponse);

        return "project/details";
    }
}
