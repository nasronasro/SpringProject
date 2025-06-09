package ma.nasro.taskflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ma.nasro.taskflow.dto.ProjectDto;
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
        model.addAttribute("projectForm", new ProjectDto());
        return "project/add";
    }

     @PostMapping("/add")
    public String addProject( @ModelAttribute("projectDto") ProjectDto projectDto, 
                             BindingResult bindingResult,
                             Model model) { 

        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            return "project/add"; // Return to the form page
        }

        System.out.println("Access accepted: ");
        
        projectService.createProject(projectDto.ProjectDtoToProject());
        System.out.println("Project created successfully: " + projectDto.getName());

        // Redirect to a different page after successful 
        return "redirect:/projects/list";
    }
    

}
