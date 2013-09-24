package isw2.rrmasg.test.domain;

import isw2.rrmasg.domain.DomainFactory;
import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.song.ISong;
import isw2.rrmasg.domain.user.IUser;

import org.junit.Test;

public class PlaylistTestSuite {

	@Test
	public void pTestCreatePlaylist() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		assert (pl.getUser().equals(u) && pl.getName().equals("") && pl
				.getSongs().isEmpty());
	}

	@Test
	public void pTestSetName() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		String name = new String("Beatles");
		pl.setName(name);
		assert pl.getName().equals(name);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetName() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		pl.setName(null);
	}

	@Test
	public void pTestAddSongContains() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		ISong s = DomainFactory.createSong();
		pl.addSong(s);
		assert pl.getSongs().contains(s);
	}

	@Test
	public void pTestAddSongAddedAtLastIndex() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		ISong s = DomainFactory.createSong();
		pl.addSong(s);
		assert pl.getSongs().get(pl.getSongs().size() - 1).equals(s);
	}

	@Test
	public void pTestAddSongAddedTwoSongCorrectIndex() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		ISong s = DomainFactory.createSong();
		ISong s2 = DomainFactory.createSong();
		pl.addSong(s);
		pl.addSong(s2);
		assert pl.getSongs().get(0).equals(s)
				&& pl.getSongs().get(1).equals(s2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestAddSong() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		pl.addSong(null);
	}

	@Test
	public void pTestDeleteSong() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		ISong s = DomainFactory.createSong();
		pl.addSong(s);
		pl.deleteSongAtIndex(0);
		assert pl.getSongs().isEmpty();
	}

	@Test
	public void pTestDeleteSongCorrectIndexes() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		ISong s1 = DomainFactory.createSong();
		ISong s2 = DomainFactory.createSong();
		ISong s3 = DomainFactory.createSong();
		pl.addSong(s1);
		pl.addSong(s2);
		pl.addSong(s3);
		pl.deleteSongAtIndex(1);
		assert (pl.getSongs().get(0).equals(s1)
				&& pl.getSongs().get(1).equals(s3));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void nTestDeleteSongLessThanZero() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		ISong s = DomainFactory.createSong();
		pl.addSong(s);
		pl.deleteSongAtIndex(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void nTestDeleteSongLessThanZero2() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		ISong s = DomainFactory.createSong();
		pl.addSong(s);
		pl.deleteSongAtIndex(-2);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void nTestDeleteSongGreaterThanMax() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		ISong s = DomainFactory.createSong();
		pl.addSong(s);
		pl.deleteSongAtIndex(2);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void nTestDeleteSongGreaterThanMax2() {
		IUser u = DomainFactory.createUser();
		IPlaylist pl = DomainFactory.createPlaylist(u);
		ISong s = DomainFactory.createSong();
		pl.addSong(s);
		pl.deleteSongAtIndex(3);
	}

}
