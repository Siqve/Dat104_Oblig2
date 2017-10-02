package no.hvl.dat104.db;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ParticipantEAO {

	@PersistenceContext(name = "participantPersistenceUnit")
	private EntityManager em;

	public void addParticipant(Participant p) {
		em.persist(p);
	}

	public Participant findParticipant(String phonenumber) {
		return em.find(Participant.class, phonenumber);
	}

	public void updateParticipant(Participant p) {
		em.merge(p);
	}

	public void deleteParticipant(String phonenumber) {
		em.remove(em.find(Participant.class, phonenumber));
	}

	public List<Participant> listAllParticipants() {
		TypedQuery<Participant> query = em.createQuery("SELECT p FROM Participant p", Participant.class);
		return query.getResultList();
	}
	
	public boolean phonenumberExists(String phonenumber) {
		// bush did 9/118
		return (findParticipant(phonenumber) != null);
	}

}
