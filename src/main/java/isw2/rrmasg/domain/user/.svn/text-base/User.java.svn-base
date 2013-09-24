package isw2.rrmasg.domain.user;

import isw2.rrmasg.domain.DomainFactory;
import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.playlist.Playlist;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
public class User implements IUser, Serializable {

	private static final long serialVersionUID = -4019725128863332580L;
	@Id
	@DocumentId
	private String uniqueID;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Field
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private boolean nativeAccount;
	@Column(nullable = false)
	private String lastSessionId;
	@ContainedIn
	@OneToMany(mappedBy = "user", targetEntity = Playlist.class, cascade = CascadeType.ALL)
	private List<IPlaylist> playlists;

	public User() {
		super();
		this.playlists = new LinkedList<IPlaylist>();
		this.nativeAccount = true;
		this.uniqueID = "";
		this.email = "";
		this.password = "";
		this.name = "";
		this.surname = "";
		this.city = "";
		this.country = "";
		this.lastSessionId = "";
	}

	public User(String id, boolean nativeAccount) {
		super();
		this.playlists = new LinkedList<IPlaylist>();
		this.uniqueID = id;
		this.email = "";
		this.password = "";
		this.name = "";
		this.surname = "";
		this.city = "";
		this.country = "";
		this.nativeAccount = nativeAccount;
		this.lastSessionId = "";
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws IllegalArgumentException {
		if (email == null)
			throw new IllegalArgumentException("User email can't be null");
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws IllegalArgumentException {
		if (password == null)
			throw new IllegalArgumentException("User password can't be null");
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
		if (name == null)
			throw new IllegalArgumentException("User name can't be null");
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) throws IllegalArgumentException {
		if (surname == null)
			throw new IllegalArgumentException("User surname can't be null");
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) throws IllegalArgumentException {
		if (city == null)
			throw new IllegalArgumentException("User city can't be null");
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) throws IllegalArgumentException {
		if (country == null)
			throw new IllegalArgumentException("User country can't be null");
		this.country = country;
	}

	public boolean getNativeAccount() {
		return nativeAccount;
	}

	public List<IPlaylist> getPlaylists() {
		return Collections.unmodifiableList(playlists);
	}

	public IPlaylist createPlaylist() {
		IPlaylist pl = DomainFactory.createPlaylist(this);
		playlists.add(pl);
		return pl;
	}

	public boolean deletePlaylist(IPlaylist playlist) {
		return playlists.remove(playlist);
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
		User other = (User) obj;
		if (uniqueID == null) {
			if (other.uniqueID != null)
				return false;
		} else if (!uniqueID.equals(other.uniqueID))
			return false;
		return true;
	}

	public String getLastSessionId() {
		return lastSessionId;
	}

	public void setLastSessionId(String lastSessionId) {
		if (lastSessionId == null){
			throw new IllegalArgumentException();
		}
		this.lastSessionId = lastSessionId;
	}
}
