package vuzee.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vuzee.entities.tasks.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate,Long>, CandidateRepositoryCustom{
	List<Candidate> findByName(String name);
}
