package isw2.rrmasg.domain;

import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.playlist.Playlist;
import isw2.rrmasg.domain.song.ISong;
import isw2.rrmasg.domain.song.Song;
import isw2.rrmasg.domain.user.IUser;
import isw2.rrmasg.domain.user.User;
import isw2.rrmasg.services.RepositoryFactory;

public class DomainFactory {

	private static long songCount = 1000;
	
	public static IUser createUser() {
		return new User(RepositoryFactory.getUserRepository().getNextId(), true);
	}

	public static IUser createNonNativeUser(String id) {
		return new User(id, false);
	}

	public static ISong createSong() {
		return new Song(RepositoryFactory.getSongRepository().getNextId());
	}

	public static IPlaylist createPlaylist(IUser user) {
		return new Playlist(RepositoryFactory.getPlaylistRepository()
				.getNextId(), user);
	}
	
	public static ISong createTestSong() {
		songCount++;
		return new Song((new Long(songCount)).toString());
	}
}
