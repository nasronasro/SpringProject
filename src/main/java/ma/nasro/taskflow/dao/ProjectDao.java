package ma.nasro.taskflow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.nasro.taskflow.model.Project;

@Repository
public interface ProjectDao extends JpaRepository<Project, Long>{
}
