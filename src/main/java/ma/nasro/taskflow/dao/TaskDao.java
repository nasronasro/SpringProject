package ma.nasro.taskflow.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.nasro.taskflow.model.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.project.id = :projectId")
    List<Task> findTasksByProjectId(@Param("projectId") Long projectId);
}
