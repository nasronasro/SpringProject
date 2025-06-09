package ma.nasro.taskflow.service.ProjectServiceImplimentations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.nasro.taskflow.dao.ProjectDao;
import ma.nasro.taskflow.model.Project;
import ma.nasro.taskflow.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public void createProject(Project project) {
        if (project == null || project.getName() == null || project.getName().isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be null or empty");
        }
        //add the default state for each inserted project
        if (project.getStartDate() == null || project.getEndDate() == null) {
            throw new IllegalArgumentException("Project start date and end date cannot be null");
        }
        
        projectDao.save(project);
    }
    
    @Override
    public List<Project> ListAllProjects() {
        if (projectDao == null) {
            throw new IllegalStateException("ProjectDao is not initialized");
        }
        if (projectDao.findAll() == null) {
            throw new IllegalStateException("No projects found");
        }
        // Fetch all projects from the database
        if (projectDao.findAll().isEmpty()) {
            throw new IllegalStateException("No projects found in the database");
        }

        return projectDao.findAll();
    }

    @Override
    public Project findProjectById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Project ID must be a positive number");
        }
        return projectDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found with ID: " + id));
    }
    @Override
    public void ModifyProject(Project project) {
        if (project == null || project.getId() == null) {
            throw new IllegalArgumentException("Project or Project ID cannot be null");
        }
        if (!projectDao.existsById(project.getId())) {
            throw new IllegalArgumentException("Project not found with ID: " + project.getId());
        }
        projectDao.save(project);
    }
    
}
