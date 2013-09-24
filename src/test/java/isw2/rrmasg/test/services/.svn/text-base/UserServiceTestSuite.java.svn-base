package isw2.rrmasg.test.services;

import isw2.rrmasg.domain.user.IUser;
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

public class UserServiceTestSuite {

	@Before
	public void resetRepositories() {
		RepositoryFactory.getPlaylistRepository().removeAllPlaylists();
		RepositoryFactory.getUserRepository().removeAllUsers();
	}

	@Test
	public void pTestCreateNativeUser() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		assert user.getName().equals("John");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserNullEmail() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(null,
				"password", "password", "John", "Smith", "NYC", "USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserNullPassword() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", null, "password", "John", "Smith", "NYC",
				"USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserNullRPassword() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", null, "John", "Smith", "NYC",
				"USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserNullName() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", null, "Smith",
				"NYC", "USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserNullSurname() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "Jonh", null,
				"NYC", "USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserNullCity() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "Jonh", "Smith",
				null, "USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserNullCountry() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "Jonh", "Smith",
				"NYC", null);
	}

	@Test(expected = DifferentsPasswordException.class)
	public void nTestCreateNativeUserDifferentPasswords() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password1", "password2", "Jonh", "Smith",
				"NYC", "USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserEmptyEmail() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser("",
				"password", "password", "John", "Smith", "NYC", "USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserEmptyPassword() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "", "password", "John", "Smith", "NYC",
				"USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserEmptyRPassword() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "", "John", "Smith", "NYC",
				"USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserEmptyName() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "", "Smith", "NYC",
				"USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserEmptySurname() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "Jonh", "", "NYC",
				"USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserEmptyCity() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "Jonh", "Smith",
				"", "USA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNativeUserEmptyCountry() {
		@SuppressWarnings("unused")
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "Jonh", "Smith",
				"NYC", "");
	}

	@Test(expected = UserNotFoundException.class)
	public void pTestDeleteUser() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().deleteUser(user, "password");
		RepositoryFactory.getUserRepository().findByEmail("john@example.com");
	}

	@Test(expected = WrongPasswordException.class)
	public void nTestDeleteUserWrongPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().deleteUser(user, "wrong");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestDeleteUserEmptyPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().deleteUser(user, "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestDeleteUserNullPassword() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().deleteUser(user, null);
	}

	@Test(expected = UserNotFoundException.class)
	public void nTestDeleteUserNotExist() {
		UserDTO user = DTOsFactory.createUserDTO(new User("1", true));
		ServiceFactory.getUserService().deleteUser(user, "password");
	}

	@Test
	public void pTestEditUserData() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserData(user, "George", "Wilson",
				"London", "UK");
		IUser user2 = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		assert user2.getName().equals("George")
				&& user2.getSurname().equals("Wilson")
				&& user2.getCity().equals("London")
				&& user2.getCountry().equals("UK");
	}

	@Test(expected = UserNotFoundException.class)
	public void nTestEditUserDataUserNotExist() {
		UserDTO user = DTOsFactory.createUserDTO(new User("1", true));
		ServiceFactory.getUserService().editUserData(user, "George", "Wilson",
				"London", "UK");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserDataNullName() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserData(user, null, "Wilson",
				"London", "UK");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserDataNullSurname() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserData(user, "George", null,
				"London", "UK");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserDataNullCity() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserData(user, "George", "Wilson",
				null, "UK");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserDataNullCountry() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserData(user, "George", "Wilson",
				"London", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserDataNullUser() {
		ServiceFactory.getUserService().editUserData(null, "George", "Wilson",
				"London", "UK");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserDataEmptyName() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserData(user, "", "Wilson",
				"London", "UK");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserDataEmptySurname() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserData(user, "George", "",
				"London", "UK");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserDataEmptyCity() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserData(user, "George", "Wilson",
				"", "UK");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestEditUserDataEmptyCountry() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getUserService().editUserData(user, "George", "Wilson",
				"London", "");
	}
}
