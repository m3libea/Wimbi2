package isw2.rrmasg.infrastructure.persistence.inmemory;

import isw2.rrmasg.domain.user.IUser;
import isw2.rrmasg.domain.user.IUserRepository;
import isw2.rrmasg.presentation.shared.exceptions.UserNotFoundException;

import java.util.LinkedList;
import java.util.List;

public class UserRepositoryInMem implements IUserRepository {

	private List<IUser> users;

	public UserRepositoryInMem() {
		users = new LinkedList<IUser>();
	}

	public IUser findByEmail(String email) {
		for (IUser u : users) {
			if (u.getEmail().equals(email))
				return u;
		}
		throw new UserNotFoundException();
	}

	public IUser findById(String uniqueID) {
		for (IUser u : users) {
			if (u.getUniqueID().equals(uniqueID))
				return u;
		}
		throw new UserNotFoundException();
	}

	public void store(IUser user) {
		if (!users.contains(user))
			users.add(user);
	}

	public void remove(IUser user) {
		users.remove(user);
	}

	public void removeAllUsers() {
		users.clear();
	}

	public String getNextId() {
		return new Integer(users.size()).toString();
	}

	public IUser findBySessionId(String sessionId) {
		for (IUser u : users) {
			if (u.getLastSessionId().equals(sessionId))
				return u;
		}
		throw new UserNotFoundException();	}

}
