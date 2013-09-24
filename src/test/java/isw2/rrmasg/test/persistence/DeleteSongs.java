package isw2.rrmasg.test.persistence;

import isw2.rrmasg.domain.song.ISong;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class DeleteSongs {

	@Test
	public void deleteSongs() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("wimbi");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("FROM Song");
		@SuppressWarnings("unchecked")
		List<ISong> songs = q.getResultList();
		for (ISong s : songs) {
			em.remove(s);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
