package vuzee.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vuzee.models.TaskStatistics;


@Repository("taskRepository")
public class TaskRepositoryImpl implements TaskRepositoryCustom {
	@PersistenceContext private EntityManager entityManager;
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<TaskStatistics> findStatistics() {
		
		//@Query(value = "select new com.path.to.class.SurveyAnswerStatistics(v.answer, count(v)) from Survey v group by v.answer")
		TypedQuery<Object[]> q = entityManager.createQuery(
			    "SELECT c.id, c.name," + 
			    "CAST((SELECT COUNT(t.id) FROM Task t WHERE t.taskState = 0 AND t.candidate=c) as int)," + 
			    "CAST((SELECT COUNT(t.id) FROM Task t WHERE t.taskState = 1 AND t.candidate=c) as int)," + 
			    "CAST((SELECT COUNT(t.id) FROM Task t WHERE t.taskState = 2 AND t.candidate=c) as int)" +
			    " FROM Candidate c", Object[].class);
			
		List<Object[]> resultList = q.getResultList();
		List<TaskStatistics> stats = new ArrayList<>();
		for (Object[] result : resultList) {
			TaskStatistics stat = new TaskStatistics((Long)result[0], (String)result[1], (int)result[2], (int)result[3], (int)result[4]);
			stats.add(stat);
		}
		return stats;
	}
	
}
