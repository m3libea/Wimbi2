package isw2.rrmasg.test.domain;

import isw2.rrmasg.domain.DomainFactory;
import isw2.rrmasg.domain.song.ISong;

import org.junit.Test;

public class SongTestSuite {

	@Test
	public void pTestCreateSong() {
		ISong s = DomainFactory.createSong();
		assert (s.getAuthor().equals("") && s.getTitle().equals("")
				&& s.getRecord().equals("") && s.getUrl().equals(""));
	}

	@Test
	public void pTestSetTitle() {
		ISong s = DomainFactory.createSong();
		String title = new String("All You Need Is Love");
		s.setTitle(title);
		assert s.getTitle().equals(title);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetTitle() {
		ISong s = DomainFactory.createSong();
		s.setTitle(null);
	}

	@Test
	public void pTestSetAuthor() {
		ISong s = DomainFactory.createSong();
		String author = new String("The Beatles");
		s.setAuthor(author);
		assert s.getAuthor().equals(author);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetAuthor() {
		ISong s = DomainFactory.createSong();
		s.setAuthor(null);
	}

	@Test
	public void pTestSetRecord() {
		ISong s = DomainFactory.createSong();
		String record = new String("Apple");
		s.setRecord(record);
		assert s.getRecord().equals(record);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetRecord() {
		ISong s = DomainFactory.createSong();
		s.setRecord(null);
	}

	@Test
	public void pTestSetUrl() {
		ISong s = DomainFactory.createSong();
		String url = new String("http://www.youtube.com/watch?v=7uE2-cc4f_k");
		s.setUrl(url);
		assert s.getUrl().equals(url);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nTestSetUrl() {
		ISong s = DomainFactory.createSong();
		s.setUrl(null);
	}
}
