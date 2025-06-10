package ma.nasro.taskflow.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.nasro.taskflow.model.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Long> {}
