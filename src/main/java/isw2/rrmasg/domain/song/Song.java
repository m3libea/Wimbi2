package isw2.rrmasg.domain.song;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.search.annotations.Boost;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
public class Song implements ISong, Serializable {

	private static final long serialVersionUID = -7422310868529683176L;
	@Id
	@DocumentId
	private String uniqueID;
	@Field
	@Boost(3f)
	@Column(nullable = false)
	private String title;
	@Field
	@Boost(2f)
	@Column(nullable = false)
	private String author;
	@Field
	@Column(nullable = false)
	private String record;
	@Column(nullable = false)
	private String url;

	public Song() {
		super();
		this.title = "";
		this.author = "";
		this.record = "";
		this.url = "";
		this.uniqueID = "";
	}

	public Song(String id) {
		super();
		this.title = "";
		this.author = "";
		this.record = "";
		this.url = "";
		this.uniqueID = id;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null)
			throw new IllegalArgumentException("Song title can't be null");
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if (author == null)
			throw new IllegalArgumentException("Song author can't be null");
		this.author = author;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		if (record == null)
			throw new IllegalArgumentException("Song record can't be null");
		this.record = record;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		if (url == null)
			throw new IllegalArgumentException("Song url can't be null");

		this.url = url;
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
		Song other = (Song) obj;
		if (uniqueID == null) {
			if (other.uniqueID != null)
				return false;
		} else if (!uniqueID.equals(other.uniqueID))
			return false;
		return true;
	}
}
