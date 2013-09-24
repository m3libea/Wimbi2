package isw2.rrmasg.infrastructure.persistence.inmemory;

import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.playlist.IPlaylistRepository;
import isw2.rrmasg.presentation.shared.exceptions.PlaylistNotFoundException;

import java.util.LinkedList;
import java.util.List;

public class PlaylistRepositoryInMem implements IPlaylistRepository {

	List<IPlaylist> playlists;

	public PlaylistRepositoryInMem() {
		playlists = new LinkedList<IPlaylist>();
	}

	public IPlaylist findByID(String id) {
		for (IPlaylist pl : playlists) {
			if (pl.getUniqueID().equals(id)) {
				return pl;
			}
		}
		throw new PlaylistNotFoundException();
	}

	public void store(IPlaylist playlist) {
		if (!playlists.contains(playlist))
			playlists.add(playlist);
	}

	public void remove(IPlaylist playlist) {
		playlists.remove(playlist);
	}

	public List<IPlaylist> searchPlaylists(String token, int firstResult,
			int maxResult) {
		List<IPlaylist> result = new LinkedList<IPlaylist>();
		int resultsUntilStart = firstResult;
		for (IPlaylist s : playlists) {
			if (s.getName().contains(token)
					|| s.getUser().getName().contains(token)) {
				resultsUntilStart--;
				if (resultsUntilStart <= 0)
					result.add(s);
			}
			if (result.size() == maxResult) {
				return result;
			}
		}
		return result;
	}

	public void removeAllPlaylists() {
		playlists.clear();
	}

	public String getNextId() {
		return new Integer(playlists.size()).toString();
	}

	public void reIndexPlaylists() {
		
	}

}
