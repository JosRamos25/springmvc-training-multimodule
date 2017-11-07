package vuzee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import vuzee.models.TaskStatistics;



public interface TaskRepositoryCustom {

	List<TaskStatistics> findStatistics();

}
