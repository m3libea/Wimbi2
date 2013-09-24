package isw2.rrmasg.persistence.mysql;

import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.playlist.IPlaylistRepository;
import isw2.rrmasg.domain.playlist.Playlist;
import isw2.rrmasg.presentation.shared.exceptions.PlaylistNotFoundException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;

public class PlaylistRepositoryMySQL implements IPlaylistRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("wimbi");

	public IPlaylist findByID(String uniqueID) {
		EntityManager em = emf.createEntityManager();
		IPlaylist p = em.find(Playlist.class, uniqueID);
		if (p == null) {
			throw new PlaylistNotFoundException();
		}
		p.getSongs().size();
		em.close();
		return p;
	}

	public void store(IPlaylist playlist) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(playlist);
		em.getTransaction().commit();
		em.close();

	}

	public void remove(IPlaylist playlist) {
		EntityManager em = emf.createEntityManager();
		IPlaylist p = em.find(Playlist.class, playlist.getUniqueID());
		if (p != null) {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		}
		em.close();
	}

	public List<IPlaylist> searchPlaylists(String token, int firstResult,
			int maxResults) {
		EntityManager em = emf.createEntityManager();

		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
				.getFullTextEntityManager(em);

		QueryBuilder qb = fullTextEntityManager.getSearchFactory()
				.buildQueryBuilder().forEntity(Playlist.class).get();

		org.apache.lucene.search.Query luceneQuery = qb.keyword()
				.onFields("name", "user.name").matching(token).createQuery();

		javax.persistence.Query fullTextQuery = fullTextEntityManager
				.createFullTextQuery(luceneQuery).setFirstResult(firstResult)
				.setMaxResults(maxResults);

		@SuppressWarnings("unchecked")
		List<IPlaylist> resultList = (List<IPlaylist>) fullTextQuery
				.getResultList();
		em.close();

		return resultList;
	}

	public void removeAllPlaylists() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("FROM Playlist");
		@SuppressWarnings("unchecked")
		List<IPlaylist> playlists = q.getResultList();
		for (IPlaylist pl : playlists) {
			em.remove(pl);
		}
		em.getTransaction().commit();
		em.close();
	}

	public String getNextId() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT MAX(uniqueID + 0) FROM Playlist");
		@SuppressWarnings("unchecked")
		List<Integer> idList = q.getResultList();
		em.getTransaction().commit();
		em.close();
		if (idList == null || idList.size() == 0 || idList.get(0) == null) {
			return "1";
		}
		int id = idList.get(0);
		id++;
		System.out.println(id);
		return (new Integer(id)).toString();
	}

	@Override
	public void reIndexPlaylists() {
		EntityManager em = emf.createEntityManager();
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
		.getFullTextEntityManager(em);
		try {
			fullTextEntityManager.createIndexer(Playlist.class).startAndWait();
		} catch (InterruptedException e) {
			System.out.println("Can't reindex playlists");
		}	}

}
