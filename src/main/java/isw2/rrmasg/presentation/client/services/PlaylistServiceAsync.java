package isw2.rrmasg.presentation.client.services;

import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PlaylistServiceAsync {

	void addSongToPlaylist(PlaylistDTO playlist, SongDTO song,
			String sessionId, AsyncCallback<Boolean> callback);

	void changePlaylistName(PlaylistDTO playlist, String name,
			String sessionId, AsyncCallback<PlaylistDTO> callback);

	void createPlaylist(String name, String sessionId,
			AsyncCallback<PlaylistDTO> callback);

	void deletePlaylist(PlaylistDTO playlist, String sessionId,
			AsyncCallback<Boolean> callback);

	void deleteSongFromPlaylist(PlaylistDTO playlist, int position,
			String sessionId, AsyncCallback<SongDTO> callback);

	void getSongs(PlaylistDTO playlist, AsyncCallback<List<SongDTO>> callback);

	//void isPlaylistFromUser(UserDTO user, PlaylistDTO playlist,
	//		AsyncCallback<Boolean> callback);

	void searchPlaylists(String token, int firstResult, int maxResult,
			AsyncCallback<List<PlaylistDTO>> callback);

	void getPlaylist(String id, AsyncCallback<PlaylistDTO> callback);

}
