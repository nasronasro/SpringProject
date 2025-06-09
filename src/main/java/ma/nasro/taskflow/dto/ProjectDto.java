package ma.nasro.taskflow.dto;

import ma.nasro.taskflow.model.Project;

public class ProjectDto {

    private String name;
    private String description;
    private String startDate;
    private String endDate;

    public ProjectDto() {
    }

    public ProjectDto( String name, String description, String startDate, String endDate) {
 
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Project ProjectDtoToProject() {
        Project project = new Project();
        project.setName(this.getName());
        project.setDescription(this.getDescription());
        project.setStartDate(this.getStartDate());
        project.setEndDate(this.getEndDate());
        // Set default status for the project
        project.setStatus("Pending");
        return project;
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
    
}
