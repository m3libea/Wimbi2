package isw2.rrmasg.presentation.server.service;

import isw2.rrmasg.domain.DomainFactory;
import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.user.IUser;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.DifferentsPasswordException;
import isw2.rrmasg.presentation.shared.exceptions.NotEmailException;
import isw2.rrmasg.presentation.shared.exceptions.UserNotFoundException;
import isw2.rrmasg.presentation.shared.exceptions.WrongPasswordException;
import isw2.rrmasg.services.CheckEmailService;
import isw2.rrmasg.services.DTOsFactory;
import isw2.rrmasg.services.RepositoryFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceImpl {

	public UserDTO createNativeUser(String email, String password,
			String rPassword, String name, String surname, String city,
			String country) {

		if (email == null || password == null || rPassword == null
				|| name == null || surname == null || city == null
				|| country == null || "".equals(email) || "".equals(password)
				|| "".equals(rPassword) || "".equals(name)
				|| "".equals(surname) || "".equals(city) || "".equals(country)) {
			throw new IllegalArgumentException();
		}

		if (!(password.equals(rPassword) && rPassword.equals(password))) {
			throw new DifferentsPasswordException();
		}
		if (!CheckEmailService.isEmail(email)) {
			throw new NotEmailException();
		}
		IUser realUser = DomainFactory.createUser();
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		realUser.setEmail(email);
		realUser.setPassword(hashed);
		realUser.setName(name);
		realUser.setSurname(surname);
		realUser.setCity(city);
		realUser.setCountry(country);
		RepositoryFactory.getUserRepository().store(realUser);
		return DTOsFactory.createUserDTO(realUser);
	}

	public boolean deleteUser(UserDTO user, String password) {

		if (user == null || password == null || "".equals(password)) {
			throw new IllegalArgumentException();
		}

		if (!isPasswordFromUser(user, password)) {
			throw new WrongPasswordException();
		}
		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		RepositoryFactory.getUserRepository().remove(realUser);
		try {
			RepositoryFactory.getUserRepository().findById(user.getUniqueID());
		} catch (Exception e) {
			return true;
		}
		return false;

	}

	public UserDTO editUserData(UserDTO user, String name, String surname,
			String city, String country) {

		if (user == null || name == null || surname == null || city == null
				|| country == null || "".equals(name) || "".equals(surname)
				|| "".equals(city) || "".equals(country)) {
			throw new IllegalArgumentException();
		}

		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		realUser.setName(name);
		realUser.setSurname(surname);
		realUser.setCity(city);
		realUser.setCountry(country);
		RepositoryFactory.getUserRepository().store(realUser);
		return DTOsFactory.createUserDTO(realUser);

	}

	public UserDTO editUserEmail(UserDTO user, String password, String email) {

		if (user == null || password == null || "".equals(password)
				|| email == null || "".equals(email)) {
			throw new IllegalArgumentException();
		}

		if (!isPasswordFromUser(user, password)) {
			throw new WrongPasswordException();
		}
		if (!CheckEmailService.isEmail(email)) {
			throw new NotEmailException();
		}
		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		realUser.setEmail(email);
		RepositoryFactory.getUserRepository().store(realUser);
		return DTOsFactory.createUserDTO(realUser);

	}

	public UserDTO editUserPassword(UserDTO user, String password,
			String nPassword, String rnPassword) {

		if (user == null || password == null || nPassword == null
				|| rnPassword == null || "".equals(password)
				|| "".equals(nPassword) || "".equals(rnPassword)) {
			throw new IllegalArgumentException();
		}

		if (!isPasswordFromUser(user, password)) {
			throw new WrongPasswordException();
		}
		if (!(nPassword.equals(rnPassword) && rnPassword.equals(nPassword))) {
			throw new DifferentsPasswordException();
		}
		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		String hashed = BCrypt.hashpw(nPassword, BCrypt.gensalt());
		realUser.setPassword(hashed);
		RepositoryFactory.getUserRepository().store(realUser);
		return DTOsFactory.createUserDTO(realUser);
	}

	public UserDTO loginUser(String email, String password, String sessionId) {

		if (password == null || "".equals(password) || email == null
				|| "".equals(email) || sessionId == null
				|| "".equals(sessionId)) {
			throw new IllegalArgumentException();
		}

		if (!CheckEmailService.isEmail(email)) {
			throw new NotEmailException();
		}

		IUser realUser = RepositoryFactory.getUserRepository().findByEmail(
				email);
		UserDTO user = DTOsFactory.createUserDTO(realUser);
		if (!isPasswordFromUser(user, password)) {
			throw new WrongPasswordException();
		}
		realUser.setLastSessionId(sessionId);
		RepositoryFactory.getUserRepository().store(realUser);
		return DTOsFactory.createUserDTO(realUser);

	}

	public List<PlaylistDTO> getPlaylists(UserDTO user) {

		if (user == null) {
			throw new IllegalArgumentException();
		}

		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		List<PlaylistDTO> result = new LinkedList<PlaylistDTO>();
		for (IPlaylist pl : realUser.getPlaylists()) {
			result.add(DTOsFactory.createPlaylistDTO(pl));
		}
		Collections.sort(result, new Comparator<PlaylistDTO>() {
			public int compare(PlaylistDTO arg0, PlaylistDTO arg1) {
				return new Long(arg0.getUniqueID()).compareTo(new Long(arg1
						.getUniqueID()));
			}
		});
		return result;

	}

	public boolean isPasswordFromUser(UserDTO user, String password) {

		if (user == null || password == null || "".equals(password)) {
			throw new IllegalArgumentException();
		}

		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		return BCrypt.checkpw(password, realUser.getPassword());
	}

	public UserDTO createOrLoginNonNativeUser(Integer service, String id,
			String name, String sessionId) {
		if (service == null || id == null || "".equals(name)
				|| sessionId == null || "".equals(sessionId)) {
			throw new IllegalArgumentException();
		}
		String uniqueID = service + "-" + id;
		IUser realUser;
		try {
			realUser = RepositoryFactory.getUserRepository().findById(uniqueID);
		} catch (UserNotFoundException e) {
			realUser = DomainFactory.createNonNativeUser(uniqueID);
		}
		realUser.setName(name);
		realUser.setLastSessionId(sessionId);
		RepositoryFactory.getUserRepository().store(realUser);

		return DTOsFactory.createUserDTO(realUser);
	}

	public UserDTO getUserFromSessionId(String sessionId) {
		if (sessionId == null || "".equals(sessionId)) {
			throw new IllegalArgumentException();
		}
		IUser realUser = RepositoryFactory.getUserRepository().findBySessionId(
				sessionId);
		return DTOsFactory.createUserDTO(realUser);
	}

	public void deleteLastSessionId(UserDTO user) {
		if (user == null) {
			throw new IllegalArgumentException();
		}
		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		realUser.setLastSessionId("");
		RepositoryFactory.getUserRepository().store(realUser);
	}

	public boolean checkCorrectUserSessionId(UserDTO user, String sessionId) {
		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		return realUser.getLastSessionId().equals(sessionId);
	}

	public boolean deleteUserNonNative(UserDTO user) {
		if (user == null || user.isNativeAccount()) {
			throw new IllegalArgumentException();
		}

		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		RepositoryFactory.getUserRepository().remove(realUser);
		try {
			RepositoryFactory.getUserRepository().findById(user.getUniqueID());
		} catch (Exception e) {
			return true;
		}
		return false;
	}

}
