package isw2.rrmasg.presentation.server.service;

import isw2.rrmasg.presentation.client.services.UserService;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.NotUserInSessionException;
import isw2.rrmasg.presentation.shared.exceptions.UserNotFoundException;
import isw2.rrmasg.presentation.shared.exceptions.WrongSessionIdException;
import isw2.rrmasg.services.ServiceFactory;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserServiceServletImpl extends RemoteServiceServlet implements
		UserService {

	private static final long serialVersionUID = 6070443706010643796L;

	public String createNativeUser(String email, String password,
			String rPassword, String name, String surname, String city,
			String country) {
		String sid = UUID.randomUUID().toString();
		UserDTO user = ServiceFactory.getUserService().createNativeUser(email,
				password, rPassword, name, surname, city, country);
		user = ServiceFactory.getUserService().loginUser(email,
				password, sid);
		HttpServletRequest request = this.getThreadLocalRequest();
		request.getSession().setAttribute("session.user", user);
		request.getSession().setAttribute("sid", sid);
		return sid;
	}

	public boolean deleteUser(String password, String sessionId) {
		HttpServletRequest request = this.getThreadLocalRequest();
		UserDTO user = (UserDTO) request.getSession().getAttribute(
				"session.user");
		String sid = (String) request.getSession().getAttribute("sid");
		if (user == null) {
			throw new NotUserInSessionException();
		}
		if (!sid.equals(sessionId)
				|| !ServiceFactory.getUserService().checkCorrectUserSessionId(
						user, sessionId)) {
			throw new WrongSessionIdException();
		}
		return ServiceFactory.getUserService().deleteUser(user, password);
	}

	public UserDTO editUserData(String name, String surname, String city,
			String country, String sessionId) {
		HttpServletRequest request = this.getThreadLocalRequest();
		UserDTO user = (UserDTO) request.getSession().getAttribute(
				"session.user");
		String sid = (String) request.getSession().getAttribute("sid");
		if (user == null) {
			throw new NotUserInSessionException();
		}
		if (!sid.equals(sessionId)
				|| !ServiceFactory.getUserService().checkCorrectUserSessionId(
						user, sessionId)) {
			throw new WrongSessionIdException();
		}

		user = ServiceFactory.getUserService().editUserData(user, name,
				surname, city, country);

		request.getSession().setAttribute("session.user", user);
		return user;
	}

	public void editUserEmail(String password, String email, String sessionId) {
		HttpServletRequest request = this.getThreadLocalRequest();
		UserDTO user = (UserDTO) request.getSession().getAttribute(
				"session.user");
		String sid = (String) request.getSession().getAttribute("sid");
		if (user == null) {
			throw new NotUserInSessionException();
		}
		if (!sid.equals(sessionId)
				|| !ServiceFactory.getUserService().checkCorrectUserSessionId(
						user, sessionId)) {
			throw new WrongSessionIdException();
		}

		user = ServiceFactory.getUserService().editUserEmail(user, password,
				email);

		request.getSession().setAttribute("session.user", user);
	}

	public void editUserPassword(String password, String nPassword,
			String rnPassword, String sessionId) {
		HttpServletRequest request = this.getThreadLocalRequest();
		UserDTO user = (UserDTO) request.getSession().getAttribute(
				"session.user");
		String sid = (String) request.getSession().getAttribute("sid");
		if (user == null) {
			throw new NotUserInSessionException();
		}
		if (!sid.equals(sessionId)
				|| !ServiceFactory.getUserService().checkCorrectUserSessionId(
						user, sessionId)) {
			throw new WrongSessionIdException();
		}

		user = ServiceFactory.getUserService().editUserPassword(user, password,
				nPassword, rnPassword);

		request.getSession().setAttribute("session.user", user);
	}

	public String loginUser(String email, String password) {
		String sid = UUID.randomUUID().toString();
		UserDTO user = ServiceFactory.getUserService().loginUser(email,
				password, sid);
		HttpServletRequest request = this.getThreadLocalRequest();
		request.getSession().setAttribute("session.user", user);
		request.getSession().setAttribute("sid", sid);
		return sid;
	}

	public List<PlaylistDTO> getPlaylists(String sessionId) {
		HttpServletRequest request = this.getThreadLocalRequest();
		UserDTO user = (UserDTO) request.getSession().getAttribute(
				"session.user");
		String sid = (String) request.getSession().getAttribute("sid");
		if (user == null) {
			throw new NotUserInSessionException();
		}
		if (!sid.equals(sessionId)
				|| !ServiceFactory.getUserService().checkCorrectUserSessionId(
						user, sessionId)) {
			throw new WrongSessionIdException();
		}
		return ServiceFactory.getUserService().getPlaylists(user);
	}

	/*
	 * public boolean isPasswordFromUser(UserDTO user, String password) { return
	 * ServiceFactory.getUserService().isPasswordFromUser(user, password); }
	 */

	public boolean userIsLogged(String sessionId) {
		HttpServletRequest request = this.getThreadLocalRequest();
		UserDTO user = (UserDTO) request.getSession().getAttribute(
				"session.user");
		String sid = (String) request.getSession().getAttribute("sid");
		if (user == null) {
			return false;
		}
		if (!sid.equals(sessionId)
				|| !ServiceFactory.getUserService().checkCorrectUserSessionId(
						user, sessionId)) {
			throw new WrongSessionIdException();
		}
		return true;
	}

	public void logoutUser() {
		HttpServletRequest request = this.getThreadLocalRequest();
		UserDTO user = (UserDTO) request.getSession().getAttribute(
				"session.user");
		ServiceFactory.getUserService().deleteLastSessionId(user);
		request.getSession().setAttribute("session.user", null);
		request.getSession().setAttribute("sid", null);
	}

	public UserDTO getLoggedUser(String sessionId) {
		HttpServletRequest request = this.getThreadLocalRequest();
		UserDTO user = (UserDTO) request.getSession().getAttribute(
				"session.user");
		String sid = (String) request.getSession().getAttribute("sid");
		if (user == null) {
			throw new NotUserInSessionException();
		}
		if (!sid.equals(sessionId)
				|| !ServiceFactory.getUserService().checkCorrectUserSessionId(
						user, sessionId)) {
			throw new WrongSessionIdException();
		}
		return user;
	}

	public boolean validateSessionId(String sessionId) {
		try {
			UserDTO user = ServiceFactory.getUserService()
					.getUserFromSessionId(sessionId);
			HttpServletRequest request = this.getThreadLocalRequest();
			request.getSession().setAttribute("session.user", user);
			request.getSession().setAttribute("sid", sessionId);
			return true;
		} catch (UserNotFoundException e) {
			return false;
		}
	}

	public String createOrLoginNonNativeUser(Integer service, String id,
			String name) throws IllegalArgumentException {
		String sid = UUID.randomUUID().toString();

		UserDTO user = ServiceFactory.getUserService()
				.createOrLoginNonNativeUser(service, id, name, sid);

		HttpServletRequest request = this.getThreadLocalRequest();
		request.getSession().setAttribute("session.user", user);
		request.getSession().setAttribute("sid", sid);
		return sid;
	}

	@Override
	public boolean deleteUserNonNative(String sessionId){
		HttpServletRequest request = this.getThreadLocalRequest();
		UserDTO user = (UserDTO) request.getSession().getAttribute(
				"session.user");
		String sid = (String) request.getSession().getAttribute("sid");
		if (user == null) {
			throw new NotUserInSessionException();
		}
		if (!sid.equals(sessionId)
				|| !ServiceFactory.getUserService().checkCorrectUserSessionId(
						user, sessionId)) {
			throw new WrongSessionIdException();
		}
		return ServiceFactory.getUserService().deleteUserNonNative(user);
	}

}
