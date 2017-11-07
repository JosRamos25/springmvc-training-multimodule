package vuzee.repositories;

import java.util.List;

import vuzee.entities.tasks.Candidate;

public interface CandidateRepositoryCustom {
	List<Candidate> getCandidatesSortedByName();
}
