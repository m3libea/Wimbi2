package isw2.rrmasg.test.services;

import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.playlist.Playlist;
import isw2.rrmasg.domain.song.ISong;
import isw2.rrmasg.domain.user.User;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.PlaylistNotFoundException;
import isw2.rrmasg.services.DTOsFactory;
import isw2.rrmasg.services.RepositoryFactory;
import isw2.rrmasg.services.ServiceFactory;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlaylistServiceTestSuite {

	@Before
	public void resetRepositories() {
		RepositoryFactory.getPlaylistRepository().removeAllPlaylists();
		RepositoryFactory.getUserRepository().removeAllUsers();
	}

	@Test
	public void pTestCreatePlaylist() {

		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");

		assert playlist.getName().equals("ExampleList")
				&& playlist.getUser().getName().equals("John");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNullUser() {
		@SuppressWarnings("unused")
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(null, "ExampleList");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateNullName() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		@SuppressWarnings("unused")
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestCreateEmptyName() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		@SuppressWarnings("unused")
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "");
	}

	@Test(expected = PlaylistNotFoundException.class)
	public void pTestDeletePlaylist() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		ServiceFactory.getPlaylistService().deletePlaylist(user, playlist);
		RepositoryFactory.getPlaylistRepository().findByID(
				playlist.getUniqueID());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestDeleteNullUser() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		ServiceFactory.getPlaylistService().deletePlaylist(null, playlist);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestDeleteNullPlaylist() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getPlaylistService().deletePlaylist(user, null);
	}

	@Test(expected = PlaylistNotFoundException.class)
	public void nTestDeletePlaylistNotExist() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = DTOsFactory.createPlaylistDTO(new Playlist("A", new User("B",
				true)));
		ServiceFactory.getPlaylistService().deletePlaylist(user, playlist);
	}

	@Test
	public void pTestGetSongsZeroSongsSize() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");

		assert ServiceFactory.getPlaylistService().getSongs(playlist).size() == 0;
	}

	@Test
	public void pTestGetSongsOneSongsSize() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song);
		assert ServiceFactory.getPlaylistService().getSongs(playlist).size() == 1;
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestGetSongsNullPlaylist() {
		ServiceFactory.getPlaylistService().getSongs(null);
	}

	@Test(expected = PlaylistNotFoundException.class)
	public void nTestGetSongsPlaylistNotExist() {
		PlaylistDTO playlist = DTOsFactory.createPlaylistDTO(new Playlist("A", new User("B",
				true)));
		ServiceFactory.getPlaylistService().getSongs(playlist);
	}

	@Test
	public void pTestAddSongToPlaylistEmptyList() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song);

		assert RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID()).getSongs().size() == 1;

	}

	@Test
	public void pTestAddSongToPlaylistNotEmptyList() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		SongDTO song2 = ServiceFactory.getSongService()
				.searchSongs("Beatles", 1, 2).get(0);

		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song2);

		assert RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID()).getSongs().size() == 2;

	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestAddSongToPlaylistNullUser() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		ServiceFactory.getPlaylistService().addSongToPlaylist(null, playlist,
				song);

	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestAddSongToPlaylistNullPlaylist() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, null, song);

	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestAddSongToPlaylistNullSong() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				null);

	}

	@Test
	public void pTestDeleteSongFromPlaylistZeroPosition() {

		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song);

		ServiceFactory.getPlaylistService().deleteSongFromPlaylist(user,
				playlist, 0);

		assert RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID()).getSongs().size() == 0;

	}

	@Test
	public void pTestDeleteSongFromPlaylistOnePosition() {

		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		SongDTO song2 = ServiceFactory.getSongService()
				.searchSongs("Beatles", 1, 2).get(0);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song2);

		ServiceFactory.getPlaylistService().deleteSongFromPlaylist(user,
				playlist, 1);

		List<ISong> songs = RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID()).getSongs();

		assert songs.get(0).getUniqueID().equals(song.getUniqueID())
				&& songs.size() == 1;

	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestDeleteSongFromPlaylistNullUser() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song);
		ServiceFactory.getPlaylistService().deleteSongFromPlaylist(null,
				playlist, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestDeleteSongFromPlaylistNullPlaylist() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getPlaylistService().deleteSongFromPlaylist(user, null,
				0);

	}
	

	@Test(expected = IndexOutOfBoundsException.class)
	public void nTestDeleteSongFromPlaylistLessThanZeroIndex() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song);
		ServiceFactory.getPlaylistService().deleteSongFromPlaylist(user,
				playlist, -1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void nTestDeleteSongFromPlaylistMoreThanMaxIndex() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		SongDTO song = ServiceFactory.getSongService()
				.searchSongs("Beatles", 0, 2).get(0);
		ServiceFactory.getPlaylistService().addSongToPlaylist(user, playlist,
				song);
		ServiceFactory.getPlaylistService().deleteSongFromPlaylist(user,
				playlist, 10);
	}

	@Test
	public void pTestChangePlaylistName() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");

		ServiceFactory.getPlaylistService().changePlaylistName(user, playlist,
				"NewName");

		IPlaylist realPlaylist = RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID());
		assert realPlaylist.getName().equals("NewName");

	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestChangePlaylistNameNullUser() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		ServiceFactory.getPlaylistService().changePlaylistName(null, playlist,
				"NewName");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestChangePlaylistNameNullPlaylist() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getPlaylistService().changePlaylistName(user, null,
				"NewName");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestChangePlaylistNameNullName() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		ServiceFactory.getPlaylistService().changePlaylistName(user, playlist,
				null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestChangePlaylistNameEmptyName() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		ServiceFactory.getPlaylistService().changePlaylistName(user, playlist,
				"");
	}

	@Test
	public void pTestIsPlaylistFromUser() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");

		assert ServiceFactory.getPlaylistService().isPlaylistFromUser(user,
				playlist);
	}

	@Test
	public void pTestIsPlaylistFromUserNot() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		UserDTO user2 = ServiceFactory.getUserService().createNativeUser(
				"Jack@example.com", "password", "password", "Jack", "Jackson",
				"NYC", "USA");
		PlaylistDTO playlist2 = ServiceFactory.getPlaylistService()
				.createPlaylist(user2, "ExampleList2");
		assert !ServiceFactory.getPlaylistService().isPlaylistFromUser(user,
				playlist2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestIsPlaylistFromUserNullUser() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		PlaylistDTO playlist = ServiceFactory.getPlaylistService()
				.createPlaylist(user, "ExampleList");
		ServiceFactory.getPlaylistService().isPlaylistFromUser(null, playlist);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestIsPlaylistFromUserNullPlaylist() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		assert ServiceFactory.getPlaylistService().isPlaylistFromUser(user,
				null);
	}

	@Test
	public void pTestSearchTenPlaylistStartingAtZeroTenSize() {
		createPlaylists();
		List<PlaylistDTO> playlists = ServiceFactory.getPlaylistService()
				.searchPlaylists("Classic", 0, 10);
		assert playlists.size() == 10;
	}

	@Test
	public void pTestSearchTenPlaylistStartingAtZeroFiveSize() {
		createPlaylists();
		List<PlaylistDTO> playlists = ServiceFactory.getPlaylistService()
				.searchPlaylists("Classic", 0, 5);
		assert playlists.size() == 5;
	}

	@Test
	public void pTestSearchTenPlaylistStartingAtTenTenSize() {
		createPlaylists();
		List<PlaylistDTO> playlists = ServiceFactory.getPlaylistService()
				.searchPlaylists("Classic", 10, 10);
		assert playlists.size() == 10;
	}

	@Test
	public void pTestSearchTenPlaylistStartingAtTenFiveSize() {
		createPlaylists();
		List<PlaylistDTO> playlists = ServiceFactory.getPlaylistService()
				.searchPlaylists("Classic", 10, 5);
		assert playlists.size() == 5;
	}

	@Test
	public void pTestSearchTenPlaylistStartingAtTenDifferent() {
		createPlaylists();
		List<PlaylistDTO> playlists = ServiceFactory.getPlaylistService()
				.searchPlaylists("Classic", 0, 10);
		List<PlaylistDTO> playlists2 = ServiceFactory.getPlaylistService()
				.searchPlaylists("Classic", 10, 10);
		boolean result = true;
		for (PlaylistDTO p : playlists) {
			result = result && !playlists2.contains(p);
		}
		for (PlaylistDTO p : playlists2) {
			result = result && !playlists.contains(p);
		}
		assert result;
	}

	@Test
	public void pTestSearchTenPlaylistStartingAtFiveDifferent() {
		createPlaylists();
		List<PlaylistDTO> playlists = ServiceFactory.getPlaylistService()
				.searchPlaylists("Classic", 0, 5);
		List<PlaylistDTO> playlists2 = ServiceFactory.getPlaylistService()
				.searchPlaylists("Classic", 5, 5);
		boolean result = true;
		for (PlaylistDTO p : playlists) {
			result = result && !playlists2.contains(p);
		}
		for (PlaylistDTO p : playlists2) {
			result = result && !playlists.contains(p);
		}
		assert result;
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSearchToken() {
		@SuppressWarnings("unused")
		List<PlaylistDTO> playlists = ServiceFactory.getPlaylistService()
				.searchPlaylists("", 0, 5);

	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSearchStart() {
		@SuppressWarnings("unused")
		List<PlaylistDTO> playlists = ServiceFactory.getPlaylistService()
				.searchPlaylists("", -5, 5);

	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSearchMax() {
		@SuppressWarnings("unused")
		List<PlaylistDTO> playlists = ServiceFactory.getPlaylistService()
				.searchPlaylists("", 0, -5);

	}

	public void createPlaylists() {
		UserDTO user = ServiceFactory.getUserService().createNativeUser(
				"john@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		UserDTO user2 = ServiceFactory.getUserService().createNativeUser(
				"john2@example.com", "password", "password", "John", "Smith",
				"NYC", "USA");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
		ServiceFactory.getPlaylistService().createPlaylist(user2, "Classic");
	}
}
