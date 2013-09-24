package isw2.rrmasg.domain.playlist;

import java.util.List;

public interface IPlaylistRepository {

	public IPlaylist findByID(String uniqueID);

	public void store(IPlaylist playlist);

	public void remove(IPlaylist playlist);

	public List<IPlaylist> searchPlaylists(String token, int firstResult,
			int maxResults);

	public void removeAllPlaylists();

	public String getNextId();

	public void reIndexPlaylists();

}
