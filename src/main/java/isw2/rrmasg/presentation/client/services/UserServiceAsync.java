package isw2.rrmasg.presentation.client.services;

import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {

	void createNativeUser(String email, String password, String rPassword,
			String name, String surname, String city, String country,
			AsyncCallback<String> asyncCallback);

	void deleteUser(String password, String sessionId,
			AsyncCallback<Boolean> callback);

	void editUserData(String name, String surname, String city, String country,
			String sessionId, AsyncCallback<UserDTO> asyncCallback);

	void editUserEmail(String password, String email, String sessionId,
			AsyncCallback<Void> callback);

	void editUserPassword(String password, String nPassword, String rnPassword,
			String sessionId, AsyncCallback<Void> callback);

	void getPlaylists(String sessionId,
			AsyncCallback<List<PlaylistDTO>> callback);

	void loginUser(String email, String password, AsyncCallback<String> callback);

	void userIsLogged(String sessionId, AsyncCallback<Boolean> callback);

	void logoutUser(AsyncCallback<Void> callback);
	
	void getLoggedUser(String sessionId, AsyncCallback<UserDTO> callback);

	void createOrLoginNonNativeUser(Integer service, String id, String name,
			AsyncCallback<String> callback);

	void validateSessionId(String sessionID, AsyncCallback<Boolean> callback);

	void deleteUserNonNative(String sessionId,
			AsyncCallback<Boolean> asyncCallback);


}
