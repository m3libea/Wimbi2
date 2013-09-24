package isw2.rrmasg.test.services;

import isw2.rrmasg.domain.user.User;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.DifferentsPasswordException;
import isw2.rrmasg.presentation.shared.exceptions.UserNotFoundException;
import isw2.rrmasg.presentation.shared.exceptions.WrongPasswordException;
import isw2.rrmasg.services.DTOsFactory;
import isw2.rrmasg.services.RepositoryFactory;
import isw2.rrmasg.services.ServiceFactory;

import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

public class UserServiceTestSuite2 {

	@Before
	public void resetRepositories() {
		RepositoryFactory.getPlaylistRepository().removeAllPlaylists();
		RepositoryFactory.getUserRepository().removeAllUsers();
	}

	@Test
	public void pTestEditEditUserEmail() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserEmail(user, "password",
				"smith@example.com");
		assert RepositoryFactory.getUserRepository()
				.findById(user.getUniqueID()).getEmail()
				.equals("smith@example.com");
	}

	@Test(expected = UserNotFoundException.class)
	public void nTestEditEditUserEmailUserNotExist() {
		UserDTO user = DTOsFactory.createUserDTO(new User("1", true));
		ServiceFactory.getUserService().editUserEmail(user, "password",
				"smith@example.com");
	}

	@Test(expected = WrongPasswordException.class)
	public void nTestEditEditUserEmailWrongPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserEmail(user, "wrong",
				"smith@example.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditEditUserEmailNullPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserEmail(user, null,
				"smith@example.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditEditUserEmailNullEmail() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserEmail(user, "wrong", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditEditUserEmailNullUser() {
		ServiceFactory.getUserService().editUserEmail(null, "wrong",
				"smith@example.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditEditUserEmailEmptyPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserEmail(user, "",
				"smith@example.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditEditUserEmailEmptyEmail() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserEmail(user, "wrong", "");
	}

	@Test
	public void pTestEditUserPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserPassword(user, "password",
				"newpass", "newpass");
		assert BCrypt.checkpw("newpass", RepositoryFactory.getUserRepository()
				.findById(user.getUniqueID()).getPassword());
	}

	@Test(expected = UserNotFoundException.class)
	public void nTestEditUserPasswordUserNotExist() {
		UserDTO user = DTOsFactory.createUserDTO(new User("1", true));
		ServiceFactory.getUserService().editUserPassword(user, "password",
				"newpass", "newpass");
	}

	@Test(expected = WrongPasswordException.class)
	public void nTestEditUserPasswordWrongPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserPassword(user, "wrong",
				"newpass", "newpass");
	}

	@Test(expected = DifferentsPasswordException.class)
	public void nTestEditUserPasswordDifferentPasswords() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserPassword(user, "password",
				"newpass1", "newpass2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserPasswordNullPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserPassword(user, null, "newpass",
				"newpass");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserPasswordNullUser() {
		ServiceFactory.getUserService().editUserPassword(null, "password",
				"newpass", "newpass");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserPasswordNullNPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserPassword(user, "password",
				null, "newpass");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserPasswordNullRNPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserPassword(user, "password",
				"newpass", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserPasswordEMptyPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserPassword(user, "", "newpass",
				"newpass");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserPasswordEmptyNPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserPassword(user, "password", "",
				"newpass");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserPasswordEmptyRNPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserPassword(user, "password",
				"newpass", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void pTestLoginUser() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		UserDTO user2 = ServiceFactory.getUserService().loginUser(
				"john@example.com", "password", "");
		assert user.getUniqueID().equals(user2.getUniqueID());
	}

	@Test(expected = UserNotFoundException.class)
	public void nTestLoginUserUserNotExist() {
		ServiceFactory.getUserService().loginUser("john@example.com",
				"password", "ses");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestLoginUserNullEmail() {
		ServiceFactory.getUserService().createNativeUser("john@example.com",
				"password", "password", "John", "Smith", "NYC", "USA");
		ServiceFactory.getUserService().loginUser(null, "password", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestLoginUserNullPassword() {
		ServiceFactory.getUserService().createNativeUser("john@example.com",
				"password", "password", "John", "Smith", "NYC", "USA");
		ServiceFactory.getUserService().loginUser("john@example.com", null, "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestLoginUserEmptyEmail() {
		ServiceFactory.getUserService().createNativeUser("john@example.com",
				"password", "password", "John", "Smith", "NYC", "USA");
		ServiceFactory.getUserService().loginUser("", "password", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestLoginUserEmptyPassword() {
		ServiceFactory.getUserService().createNativeUser("john@example.com",
				"password", "password", "John", "Smith", "NYC", "USA");
		ServiceFactory.getUserService().loginUser("john@example.com", "", "");
	}

	@Test
	public void pTestGetPlaylistsZeroPlaylistsSize() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		assert ServiceFactory.getUserService().getPlaylists(user).size() == 0;
	}

	@Test
	public void pTestGetPlaylistsOnePlaylistSize() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getPlaylistService().createPlaylist(user, "playlist");
		assert ServiceFactory.getUserService().getPlaylists(user).size() == 1;
	}

	@Test
	public void pTestGetPlaylistsOnePlaylistName() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getPlaylistService().createPlaylist(user, "playlist");
		assert ServiceFactory.getUserService().getPlaylists(user).get(0)
				.getName().equals("playlist");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestGetPlylistsNullUser() {
		ServiceFactory.getUserService().getPlaylists(null);
	}

	@Test(expected = UserNotFoundException.class)
	public void pTestGetPlaylistsUserNotExist() {
		UserDTO user = DTOsFactory.createUserDTO(new User("1", true));
		ServiceFactory.getUserService().getPlaylists(user);
	}

	@Test
	public void pTestIsPasswordFromUserCorrect() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		assert ServiceFactory.getUserService().isPasswordFromUser(user,
				"password");
	}

	@Test
	public void pTestIsPasswordFromUserIncorrect() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		assert !ServiceFactory.getUserService().isPasswordFromUser(user,
				"wrong");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestIsPasswordFromUserNullUser() {
		ServiceFactory.getUserService().isPasswordFromUser(null, "password");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestIsPasswordFromUserNullPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().isPasswordFromUser(user, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestIsPasswordFromUserEmptyPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().isPasswordFromUser(user, "");
	}
}
