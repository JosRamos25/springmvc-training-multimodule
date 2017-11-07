package vuzee.services;

import java.util.List;

import vuzee.entities.tasks.Task;
import vuzee.models.TaskStatistics;



public interface TaskService {
	
	Long addTask(Task task);
	
	Task findByTitle(String title);
	
	List<TaskStatistics> findStatistics();
}
