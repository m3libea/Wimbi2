package isw2.rrmasg.test.services;

import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.services.RepositoryFactory;
import isw2.rrmasg.services.ServiceFactory;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SongServiceTestSuite {

	@Before
	public void resetRepositories() {
		RepositoryFactory.getPlaylistRepository().removeAllPlaylists();
		RepositoryFactory.getUserRepository().removeAllUsers();
	}

	@Test
	public void pTestSearchTenSongsAuthorStartingAtZeroSize() {
		List<SongDTO> songs = ServiceFactory.getSongService().searchSongs(
				"Beatles", 0, 10);
		assert songs.size() == 10;
	}

	@Test
	public void pTestSearchTenSongsAuthorStartingAtZeroAuthor() {
		List<SongDTO> songs = ServiceFactory.getSongService().searchSongs(
				"Beatles", 0, 10);
		boolean result = true;
		for (SongDTO s : songs) {
			result = result && s.getAuthor().equals("The Beatles");
		}
		assert result;
	}

	@Test
	public void pTestSearchTenSongsAuthorStartingAtTenSize() {
		List<SongDTO> songs = ServiceFactory.getSongService().searchSongs(
				"Beatles", 10, 10);
		assert songs.size() == 10;
	}

	@Test
	public void pTestSearchTenSongsAuthorStartingAtTenAuthor() {
		List<SongDTO> songs = ServiceFactory.getSongService().searchSongs(
				"Beatles", 10, 10);
		boolean result = true;
		for (SongDTO s : songs) {
			result = result && s.getAuthor().equals("The Beatles");
		}
		assert result;
	}

	@Test
	public void pTestSearchTenSongsAuthorStartingAtTenDifferent() {
		List<SongDTO> songs1 = ServiceFactory.getSongService().searchSongs(
				"Beatles", 0, 10);
		List<SongDTO> songs2 = ServiceFactory.getSongService().searchSongs(
				"Beatles", 10, 10);
		boolean result = true;
		for (SongDTO s : songs1) {
			result = result && !songs2.contains(s);
		}
		for (SongDTO s : songs2) {
			result = result && !songs1.contains(s);
		}
		assert result;
	}

	@Test
	public void pTestSearchFiveSongsAuthorStartingAtZeroSize() {
		List<SongDTO> songs = ServiceFactory.getSongService().searchSongs(
				"Beatles", 0, 5);
		assert songs.size() == 5;
	}

	@Test
	public void pTestSearchFiveSongsAuthorStartingAtTenDifferent() {
		List<SongDTO> songs1 = ServiceFactory.getSongService().searchSongs(
				"Beatles", 0, 5);
		List<SongDTO> songs2 = ServiceFactory.getSongService().searchSongs(
				"Beatles", 10, 5);
		boolean result = true;
		for (SongDTO s : songs1) {
			result = result && !songs2.contains(s);
		}
		for (SongDTO s : songs2) {
			result = result && !songs1.contains(s);
		}
		assert result;
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSearchToken() {
		@SuppressWarnings("unused")
		List<SongDTO> songs = ServiceFactory.getSongService().searchSongs("",
				0, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSearchStart() {
		@SuppressWarnings("unused")
		List<SongDTO> songs = ServiceFactory.getSongService().searchSongs("",
				-10, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSearchMax() {
		@SuppressWarnings("unused")
		List<SongDTO> songs = ServiceFactory.getSongService().searchSongs("",
				0, -10);
	}

}
