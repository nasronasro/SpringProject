package ma.nasro.taskflow.dto;

import java.util.List;
import java.util.stream.Collectors;

import ma.nasro.taskflow.model.Project;
import ma.nasro.taskflow.model.Task;

public class TaskResponse {
    private Long id;
    private String title;
    private String content;
    private Project project;
    private String dateDuo;
    private int priority;

    public TaskResponse FromTaskToTaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.content = task.getContent();
        this.project = task.getProject();
        this.dateDuo = task.getDateDuo();
        this.priority = task.getPriority();
        return this;
    }
    
    public List<TaskResponse> TaskListToTaskResponseList(List<Task> tasks) {
        return tasks.stream()
                .map(task -> new TaskResponse().FromTaskToTaskResponse(task))
                .collect(Collectors.toList());
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getDateDuo() {
        return dateDuo;
    }
    public void setDateDuo(String dateDuo) {
        this.dateDuo = dateDuo;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
