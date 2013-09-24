package isw2.rrmasg.presentation.server.service;

import isw2.rrmasg.presentation.client.services.PlaylistService;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.NotUserInSessionException;
import isw2.rrmasg.presentation.shared.exceptions.PlaylistNotFoundException;
import isw2.rrmasg.presentation.shared.exceptions.WrongSessionIdException;
import isw2.rrmasg.services.ServiceFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PlaylistServiceServletImpl extends RemoteServiceServlet implements
		PlaylistService {

	private static final long serialVersionUID = -7082916440995015134L;

	public List<PlaylistDTO> searchPlaylists(String token, int firstResult,
			int maxResult) {
		return ServiceFactory.getPlaylistService().searchPlaylists(token,
				firstResult, maxResult);
	}

	public PlaylistDTO createPlaylist(String name, String sessionId) {
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
		return ServiceFactory.getPlaylistService().createPlaylist(user, name);
	}

	public boolean deletePlaylist(PlaylistDTO playlist, String sessionId) {
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
		return ServiceFactory.getPlaylistService().deletePlaylist(user,
				playlist);
	}

	public List<SongDTO> getSongs(PlaylistDTO playlist) {
		return ServiceFactory.getPlaylistService().getSongs(playlist);
	}

	public boolean addSongToPlaylist(PlaylistDTO playlist, SongDTO song,
			String sessionId) {
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
		return ServiceFactory.getPlaylistService().addSongToPlaylist(user,
				playlist, song);
	}

	public SongDTO deleteSongFromPlaylist(PlaylistDTO playlist, int position,
			String sessionId) {
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
		return ServiceFactory.getPlaylistService().deleteSongFromPlaylist(user,
				playlist, position);
	}

	public PlaylistDTO changePlaylistName(PlaylistDTO playlist, String name,
			String sessionId) {
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
		return ServiceFactory.getPlaylistService().changePlaylistName(user,
				playlist, name);
	}

	/*
	 * public boolean isPlaylistFromUser(UserDTO user, PlaylistDTO playlist) {
	 * return ServiceFactory.getPlaylistService().isPlaylistFromUser(user,
	 * playlist); }
	 */

	public PlaylistDTO getPlaylist(String id) throws PlaylistNotFoundException {
		return ServiceFactory.getPlaylistService().getPlaylist(id);
	}

}
