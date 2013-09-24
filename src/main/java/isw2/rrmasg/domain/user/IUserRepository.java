package isw2.rrmasg.domain.user;

public interface IUserRepository {

	public IUser findByEmail(String email);

	public IUser findById(String uniqueID);

	public void store(IUser user);

	public void remove(IUser user);

	public void removeAllUsers();

	public String getNextId();

	public IUser findBySessionId(String sessionId);

}
