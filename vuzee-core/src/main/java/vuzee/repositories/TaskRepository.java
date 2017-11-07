package vuzee.repositories;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vuzee.entities.tasks.Task;
import vuzee.models.TaskStatistics;


@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public interface TaskRepository extends JpaRepository<Task, Long>, TaskRepositoryCustom{
	Task findByTitle(String title);
	
	List<TaskStatistics> findStatistics();
}
