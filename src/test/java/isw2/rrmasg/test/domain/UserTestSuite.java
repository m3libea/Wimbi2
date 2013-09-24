package isw2.rrmasg.test.domain;

import isw2.rrmasg.domain.DomainFactory;
import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.user.IUser;

import org.junit.Test;

public class UserTestSuite {

	@Test
	public void pTestCreateUser() {
		IUser u = DomainFactory.createUser();
		assert (u.getPlaylists().isEmpty() && u.getEmail().equals("")
				&& u.getPassword().equals("") && u.getName().equals("")
				&& u.getSurname().equals("") && u.getCity().equals("") && u
				.getCountry().equals(""));
	}

	@Test
	public void pTestCreateNonNativeUser() {
		IUser u = DomainFactory.createNonNativeUser("id");
		assert (u.getPlaylists().isEmpty() && u.getEmail().equals("")
				&& u.getPassword().equals("") && u.getName().equals("")
				&& u.getSurname().equals("") && u.getCity().equals("") && u
				.getCountry().equals(""));
	}

	@Test
	public void pTestSetEmail() {
		IUser u = DomainFactory.createUser();
		String email = new String("john@example.com");
		u.setEmail(email);
		assert u.getEmail().equals(email);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetEmail() {
		IUser u = DomainFactory.createUser();
		u.setEmail(null);
	}

	@Test
	public void pTestSetPasword() {
		IUser u = DomainFactory.createUser();
		String password = new String("password");
		u.setPassword(password);
		assert u.getPassword().equals(password);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetPassword() {
		IUser u = DomainFactory.createUser();
		u.setPassword(null);
	}

	@Test
	public void pTestSetName() {
		IUser u = DomainFactory.createUser();
		String name = new String("John");
		u.setName(name);
		assert u.getName().equals(name);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetName() {
		IUser u = DomainFactory.createUser();
		u.setName(null);
	}

	@Test
	public void pTestSetSurname() {
		IUser u = DomainFactory.createUser();
		String surname = new String("Smith");
		u.setSurname(surname);
		assert u.getSurname().equals(surname);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetSurname() {
		IUser u = DomainFactory.createUser();
		u.setSurname(null);
	}

	@Test
	public void pTestSetCity() {
		IUser u = DomainFactory.createUser();
		String city = new String("NYC");
		u.setCity(city);
		assert u.getCity().equals(city);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetCity() {
		IUser u = DomainFactory.createUser();
		u.setCity(null);
	}

	@Test
	public void pTestSetCountry() {
		IUser u = DomainFactory.createUser();
		String country = new String("NYC");
		u.setCountry(country);
		assert u.getCountry().equals(country);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetCountry() {
		IUser u = DomainFactory.createUser();
		u.setCity(null);
	}

	@Test
	public void pTestCreatePlaylistContains() {
		IUser u = DomainFactory.createUser();
		IPlaylist p = u.createPlaylist();
		assert u.getPlaylists().contains(p);
	}

	@Test
	public void pTestCreatePlaylistAtLastIndex() {
		IUser u = DomainFactory.createUser();
		IPlaylist p = u.createPlaylist();
		assert u.getPlaylists().get(u.getPlaylists().size() - 1).equals(p);
	}

	@Test
	public void pTestCreatePlaylistTwoPLCorrectIndex() {
		IUser u = DomainFactory.createUser();
		IPlaylist p = u.createPlaylist();
		IPlaylist p2 = u.createPlaylist();
		assert u.getPlaylists().get(0).equals(p)
				&& u.getPlaylists().get(1).equals(p2);
	}

	@Test
	public void pTestDeletePlaylist() {
		IUser u = DomainFactory.createUser();
		IPlaylist p = u.createPlaylist();
		boolean deleted = u.deletePlaylist(p);
		assert deleted && u.getPlaylists().isEmpty();
	}

	@Test
	public void pTestDeletePlaylistCorrectIndexes() {
		IUser u = DomainFactory.createUser();
		IPlaylist p1 = u.createPlaylist();
		IPlaylist p2 = u.createPlaylist();
		IPlaylist p3 = u.createPlaylist();
		boolean deleted = u.deletePlaylist(p2);
		assert (deleted && u.getPlaylists().get(0).equals(p1)
				&& u.getPlaylists().get(1).equals(p3));
	}

	@Test
	public void pTestDeletePlaylistDontFromUser() {
		IUser u = DomainFactory.createUser();
		IUser u2 = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u2);
		assert !u.deletePlaylist(pl);
	}
}
