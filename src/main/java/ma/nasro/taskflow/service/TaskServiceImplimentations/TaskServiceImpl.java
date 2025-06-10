package ma.nasro.taskflow.service.TaskServiceImplimentations;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.nasro.taskflow.dao.TaskDao;
import ma.nasro.taskflow.model.Task;
import ma.nasro.taskflow.service.TaskService;

@Service
public class TaskServiceImpl implements  TaskService {
    private TaskDao taskDao;
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    @Override
    public List<Task> listAllTasks() {
        List<Task> tasks = taskDao.findAll();
        if (tasks.isEmpty()) {
            throw new RuntimeException("No tasks found");
        }
        return tasks;
    }
    
}
