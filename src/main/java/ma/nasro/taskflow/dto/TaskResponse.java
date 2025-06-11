package ma.nasro.taskflow.dto;

import java.util.List;
import java.util.stream.Collectors;

import ma.nasro.taskflow.model.Task;

public class TaskResponse {
    private Long id;
    private String title;
    private String content;
    private Long projectId;
    private String dateDuo;
    private int priority;

    public TaskResponse FromTaskToTaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.content = task.getContent();
        this.projectId = task.getProject().getId();
        this.dateDuo = task.getDateDuo();
        this.priority = task.getPriority();
        return this;
    }
    
    public List<TaskResponse> TaskListToTaskResponseList(List<Task> tasks) {
        return tasks.stream()
                .map(task -> new TaskResponse().FromTaskToTaskResponse(task))
                .collect(Collectors.toList());
    }
    public Task FromTaskResponseToTask() {
        Task task = new Task();
        task.setId(this.id);
        task.setTitle(this.title);
        task.setContent(this.content);
        task.setDateDuo(this.dateDuo);
        task.setPriority(this.priority);
        return task;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }



}
