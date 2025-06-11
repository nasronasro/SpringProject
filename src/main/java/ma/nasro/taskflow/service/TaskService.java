package ma.nasro.taskflow.service;

import java.util.List;

import ma.nasro.taskflow.model.Task;

public interface TaskService {
    List<Task> listAllTasks(Long projectId);
    void createTask(Task task, Long projectId);
    void updateTask(Task task,Long projectId);
    Task getTaskById(Long taskId);
    void deleteTask(Long taskId);
}
