package com.edufelizardo.taskbackend.repo;

import com.edufelizardo.taskbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long>{

}
