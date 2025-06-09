package ma.nasro.taskflow.dto;

import java.util.List;
import java.util.Optional;

import ma.nasro.taskflow.model.Project;

public class ProjectResponse {
    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String status;


    public ProjectResponse ProjectToProjectResponse(Project project) {
        this.setId(project.getId());
        this.setName(project.getName());
        this.setDescription(project.getDescription());
        this.setStartDate(project.getStartDate());
        this.setEndDate(project.getEndDate());
        this.setStatus(project.getStatus());
        return this;
    }
    public List<ProjectResponse> ProjectListToProjectResponseList(List<Project> projects) {
        return projects.stream()
                .map(project -> new ProjectResponse().ProjectToProjectResponse(project))
                .toList();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
