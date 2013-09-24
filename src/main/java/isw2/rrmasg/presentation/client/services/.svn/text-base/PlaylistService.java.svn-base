package isw2.rrmasg.presentation.client.services;

import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.exceptions.NotUserInSessionException;
import isw2.rrmasg.presentation.shared.exceptions.PlaylistNotFoundException;
import isw2.rrmasg.presentation.shared.exceptions.WrongSessionIdException;
import isw2.rrmasg.presentation.shared.exceptions.WrongUserException;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("playlist")
public interface PlaylistService extends RemoteService {

	public List<PlaylistDTO> searchPlaylists(String token, int firstResult,
			int maxResult) throws IllegalArgumentException;

	public PlaylistDTO createPlaylist(String name, String sessionId)
			throws IllegalArgumentException, NotUserInSessionException,
			WrongSessionIdException;

	public boolean deletePlaylist(PlaylistDTO playlist, String sessionId)
			throws IllegalArgumentException, WrongUserException,
			NotUserInSessionException, WrongSessionIdException;

	public List<SongDTO> getSongs(PlaylistDTO playlist)
			throws IllegalArgumentException;

	public boolean addSongToPlaylist(PlaylistDTO playlist, SongDTO song,
			String sessionId) throws IllegalArgumentException,
			WrongUserException, NotUserInSessionException,
			WrongSessionIdException;

	public SongDTO deleteSongFromPlaylist(PlaylistDTO playlist, int position,
			String sessionId) throws IllegalArgumentException,
			WrongUserException, NotUserInSessionException,
			WrongSessionIdException, IndexOutOfBoundsException;

	public PlaylistDTO changePlaylistName(PlaylistDTO playlist, String name,
			String sessionId) throws IllegalArgumentException,
			WrongUserException, NotUserInSessionException,
			WrongSessionIdException;

	// public boolean isPlaylistFromUser(UserDTO user, PlaylistDTO playlist)
	// throws IllegalArgumentException;

	public PlaylistDTO getPlaylist(String id) throws PlaylistNotFoundException;

}