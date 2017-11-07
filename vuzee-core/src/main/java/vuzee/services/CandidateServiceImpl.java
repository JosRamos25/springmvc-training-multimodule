package vuzee.services;

import java.util.List;

import javax.naming.InsufficientResourcesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vuzee.entities.tasks.Candidate;
import vuzee.repositories.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService{

	private CandidateRepository candidateRepository;

	/**
	 * @param candidateRepository
	 */
	@Autowired
	public CandidateServiceImpl(CandidateRepository candidateRepository) {
		super();
		this.candidateRepository = candidateRepository;
	}

	@Override
	public List<Candidate> getAll() {
		List<Candidate> candidates =(List<Candidate>) this.candidateRepository.findAll();
		return candidates;
	}

	@Override
	public Candidate findById(Long id) {
		return candidateRepository.findOne(id);
	}

	@Override
	public Long addCandidate(Candidate candidate) {
		if(candidate==null)
			throw new CandidateServiceException("No se pudo agregar el candidato, objeto nulo.", new NullPointerException());
		
		if(candidate.getName().length()==0)
			throw new CandidateServiceException("No se pudo agregar el candidato, asigne un nombre.", new InsufficientResourcesException());
		
		if(candidate.getPositionApplied().length()==0)
			throw new CandidateServiceException("No se pudo agregar el candidato, especifique el puesto.", new InsufficientResourcesException());
		
		Candidate insertedCandidate = this.candidateRepository.save(candidate);
		if(insertedCandidate!=null)
			return insertedCandidate.getId();
		
		return null;
	}

	@Override
	public void updateCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
	}

	@Override
	public void deleteCandidate(Candidate candidate) {
		candidateRepository.delete(candidate);
	}

	@Override
	public List<Candidate> getAllCandidatesSortedByName() {
		return candidateRepository.getCandidatesSortedByName();
	}
	
	
}
