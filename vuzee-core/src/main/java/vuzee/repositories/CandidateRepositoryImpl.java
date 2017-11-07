package vuzee.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vuzee.entities.tasks.Candidate;

@Repository("candidateRepository")
public class CandidateRepositoryImpl implements CandidateRepositoryCustom{
	@PersistenceContext private EntityManager entityManager;
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Candidate> getCandidatesSortedByName() {
		String jql ="SELECT c FROM Candidate as c order by c.name";
		Query query = entityManager.createQuery (jql);
		List<Candidate> resultList = null;
		if(query!=null)
			resultList = query.getResultList();
		return resultList;
	}
	
}