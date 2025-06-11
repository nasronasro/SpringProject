package ma.nasro.taskflow.dto;

import ma.nasro.taskflow.model.Task;

public class TaskRequest {
    private String title;
    private String content;
    private String dateDuo;
    private Integer priority;
    private Long projectId;
    public Task FromTaskRequestToTask(){
        Task task = new Task();
        task.setTitle(this.title);
        task.setContent(this.content);
        task.setDateDuo(this.dateDuo);
        task.setPriority(this.priority);
        
        return task;
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
