package isw2.rrmasg.persistence.mysql;

import isw2.rrmasg.domain.song.ISong;
import isw2.rrmasg.domain.song.ISongRepository;
import isw2.rrmasg.domain.song.Song;
import isw2.rrmasg.presentation.shared.exceptions.SongNotFoundException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;

public class SongRepositoryMySQL implements ISongRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("wimbi");

	public ISong findByID(String uniqueID) {
		EntityManager em = emf.createEntityManager();
		ISong s = em.find(Song.class, uniqueID);
		em.close();
		if (s == null) {
			throw new SongNotFoundException();
		}
		return s;
	}

	public List<ISong> searchSongs(String token, int firstResult, int maxResults) {

		EntityManager em = emf.createEntityManager();

		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
				.getFullTextEntityManager(em);
		
		QueryBuilder qb = fullTextEntityManager.getSearchFactory()
				.buildQueryBuilder().forEntity(Song.class).get();

		org.apache.lucene.search.Query luceneQuery = qb.keyword()
				.onFields("title", "author", "record").matching(token)
				.createQuery();

		javax.persistence.Query fullTextQuery = fullTextEntityManager
				.createFullTextQuery(luceneQuery).setFirstResult(firstResult)
				.setMaxResults(maxResults);

		@SuppressWarnings("unchecked")
		List<ISong> resultList = (List<ISong>) fullTextQuery.getResultList();
		em.close();

		return resultList;
	}

	public String getNextId() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT MAX(uniqueID + 0) FROM Song");
		@SuppressWarnings("unchecked")
		List<Integer> idList = q.getResultList();
		em.getTransaction().commit();
		em.close();
		if (idList == null || idList.size() == 0 || idList.get(0) == null) {
			return "1";
		}
		int id = idList.get(0);
		id++;
		return (new Integer(id)).toString();
	}
	
	public void reIndexSongs(){
		EntityManager em = emf.createEntityManager();
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
		.getFullTextEntityManager(em);
		try {
			fullTextEntityManager.createIndexer(Song.class).startAndWait();
		} catch (InterruptedException e) {
			System.out.println("Can't reindex songs");
		}
	}

	public List<ISong> findAllSongs() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("FROM Song ORDER BY (uniqueID + 0)");
		@SuppressWarnings("unchecked")
		List<ISong> list = q.getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}

}
