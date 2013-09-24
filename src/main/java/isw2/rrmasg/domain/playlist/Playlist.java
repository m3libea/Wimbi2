package isw2.rrmasg.domain.playlist;

import isw2.rrmasg.domain.song.ISong;
import isw2.rrmasg.domain.song.Song;
import isw2.rrmasg.domain.user.IUser;
import isw2.rrmasg.domain.user.User;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

import org.hibernate.search.annotations.Boost;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Indexed
public class Playlist implements IPlaylist, Serializable {

	private static final long serialVersionUID = 9034439778091367587L;
	@Id
	@DocumentId
	private String uniqueID;
	@Field
	@Boost(2f)
	@Column(nullable = false)
	private String name;
	@IndexedEmbedded(targetElement = User.class)
	@ManyToOne(optional = false, targetEntity = User.class)
	private IUser user;
	@ManyToMany(targetEntity = Song.class)
	@OrderColumn
	@JoinTable(name = "PLAYLIST_SONG", joinColumns = @JoinColumn(name = "PLAYLIST_ID"), inverseJoinColumns = @JoinColumn(name = "SONG_ID"))
	private List<ISong> songs;

	public Playlist() {
		super();
		this.songs = new LinkedList<ISong>();
		this.user = new User();
		this.name = "";
		this.uniqueID = "";
	}

	public Playlist(String id, IUser user) {
		super();
		this.songs = new LinkedList<ISong>();
		this.user = user;
		this.name = "";
		this.uniqueID = id;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Playlist name can't be null");
		this.name = name;
	}

	public boolean addSong(ISong song) {
		if (song == null)
			throw new IllegalArgumentException(
					"Playlist can't be added null songs");
		if (songs.size() == Integer.MAX_VALUE)
			throw new IllegalArgumentException(
					"Playlist can't contain more songs");
		return songs.add(song);
	}

	public ISong deleteSongAtIndex(int index) {
		return songs.remove(index);
	}

	public List<ISong> getSongs() {
		return Collections.unmodifiableList(songs);
	}

	public IUser getUser() {
		return user;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((uniqueID == null) ? 0 : uniqueID.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		if (uniqueID == null) {
			if (other.uniqueID != null)
				return false;
		} else if (!uniqueID.equals(other.uniqueID))
			return false;
		return true;
	}
}
