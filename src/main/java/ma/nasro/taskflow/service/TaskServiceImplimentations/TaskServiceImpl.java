package ma.nasro.taskflow.service.TaskServiceImplimentations;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.nasro.taskflow.dao.ProjectDao;
import ma.nasro.taskflow.dao.TaskDao;
import ma.nasro.taskflow.model.Project;
import ma.nasro.taskflow.model.Task;
import ma.nasro.taskflow.service.TaskService;

@Service
public class TaskServiceImpl implements  TaskService {
    private final TaskDao taskDao;
    private final ProjectDao projectDao;
    public TaskServiceImpl(TaskDao taskDao,ProjectDao projectDao) {
        this.taskDao = taskDao;
        this.projectDao = projectDao;
    }
    @Override
    public List<Task> listAllTasks(Long projectId) {
        if (projectId == null || projectId <= 0) {
            throw new IllegalArgumentException("Invalid project ID");
        }
        
        List<Task> tasks = taskDao.findTasksByProjectId(projectId);
        if (tasks.isEmpty()) {
            throw new RuntimeException("No tasks found");
        }
        return tasks;
    }
    @Override
    public void createTask(Task task, Long projectId) {
        if (task == null || task.getTitle() == null || task.getContent() == null) {
            throw new IllegalArgumentException("Task title and content cannot be null");
        }
        Project project = projectDao.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId)); 
        task.setProject(project);
        taskDao.save(task);
    }
    @Override
    public void updateTask(Task task,Long projectId) {
        if (task == null || task.getId() == null) {
            throw new IllegalArgumentException("Task ID and project ID cannot be null");
        }
        task.setProject(projectDao.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId)));
        taskDao.save(task);
    }
    @Override
    public Task getTaskById(Long taskId) {
        if (taskId == null || taskId <= 0) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        
        return taskDao.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + taskId));
    }
    
}
