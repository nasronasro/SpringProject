package ma.nasro.taskflow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.nasro.taskflow.model.Project;

@Service
public interface ProjectService {

    //create a new project
    public void createProject(Project project);
    public List<Project> ListAllProjects();
    public Project findProjectById(Long id);
    public void ModifyProject(Project project);
    public void DeleteProject(Long id);
}

 