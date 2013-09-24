package isw2.rrmasg.persistence.mysql;

import isw2.rrmasg.domain.user.IUser;
import isw2.rrmasg.domain.user.IUserRepository;
import isw2.rrmasg.domain.user.User;
import isw2.rrmasg.presentation.shared.exceptions.UserNotFoundException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserRepositoryMySQL implements IUserRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("wimbi");

	public IUser findByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT x FROM User x WHERE x.email = '"
				+ email + "'");
		List<?> users = q.getResultList();
		em.getTransaction().commit();
		em.close();
		if (users == null || users.size() == 0) {
			throw new UserNotFoundException();
		}
		return (IUser) users.get(0);
	}

	public IUser findById(String uniqueID) {
		EntityManager em = emf.createEntityManager();
		IUser u = em.find(User.class, uniqueID);
		if (u == null) {
			throw new UserNotFoundException();
		}
		u.getPlaylists().size();
		em.close();
		return u;
	}

	public void store(IUser user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(IUser user) {
		EntityManager em = emf.createEntityManager();
		IUser u = em.find(User.class, user.getUniqueID());
		if (u != null) {
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
		}
		em.close();
	}

	public void removeAllUsers() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("FROM User");
		@SuppressWarnings("unchecked")
		List<IUser> users = q.getResultList();
		for (IUser u : users) {
			em.remove(u);
		}
		em.getTransaction().commit();
		em.close();
	}

	public String getNextId() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT MAX(uniqueID + 0) FROM User WHERE nativeAccount = true");
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

	public IUser findBySessionId(String sessionId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT x FROM User x WHERE x.lastSessionId = '"
				+ sessionId + "'");
		List<?> users = q.getResultList();
		em.getTransaction().commit();
		em.close();
		if (users == null || users.size() == 0) {
			throw new UserNotFoundException();
		}
		return (IUser) users.get(0);	}

}
