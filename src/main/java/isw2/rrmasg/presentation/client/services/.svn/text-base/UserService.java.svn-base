package isw2.rrmasg.presentation.client.services;

import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.DifferentsPasswordException;
import isw2.rrmasg.presentation.shared.exceptions.NotEmailException;
import isw2.rrmasg.presentation.shared.exceptions.NotUserInSessionException;
import isw2.rrmasg.presentation.shared.exceptions.UserNotFoundException;
import isw2.rrmasg.presentation.shared.exceptions.WrongPasswordException;
import isw2.rrmasg.presentation.shared.exceptions.WrongSessionIdException;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("user")
public interface UserService extends RemoteService {

	public String createNativeUser(String email, String password,
			String rPassword, String name, String surname, String city,
			String country) throws IllegalArgumentException,
			DifferentsPasswordException, NotEmailException;

	public boolean deleteUser(String password, String sessionId) throws IllegalArgumentException,
			WrongPasswordException, NotUserInSessionException, WrongSessionIdException;

	public UserDTO editUserData(String name, String surname, String city,
			String country, String sessionId) throws IllegalArgumentException,
			NotEmailException, NotUserInSessionException, WrongSessionIdException;

	public void editUserEmail(String password, String email, String sessionId)
			throws IllegalArgumentException, WrongPasswordException,
			NotEmailException, NotUserInSessionException, WrongSessionIdException;

	public void editUserPassword(String password, String nPassword,
			String rnPassword, String sessionId) throws IllegalArgumentException,
			WrongPasswordException, DifferentsPasswordException,
			NotUserInSessionException, WrongSessionIdException;

	public String loginUser(String email, String password)
			throws UserNotFoundException, WrongPasswordException,
			NotEmailException, IllegalArgumentException;

	public List<PlaylistDTO> getPlaylists(String sessionId) throws IllegalArgumentException,
			NotUserInSessionException;

	public boolean userIsLogged(String sessionId) throws WrongSessionIdException;

	public void logoutUser() throws IllegalArgumentException;

	public UserDTO getLoggedUser(String sessionId) throws NotUserInSessionException, WrongSessionIdException;

	public String createOrLoginNonNativeUser(Integer service, String id,
			String name) throws IllegalArgumentException;
	
	public boolean validateSessionId(String sessionID);

	boolean deleteUserNonNative(String sessionId) throws IllegalArgumentException,
	WrongPasswordException, NotUserInSessionException, WrongSessionIdException;

}