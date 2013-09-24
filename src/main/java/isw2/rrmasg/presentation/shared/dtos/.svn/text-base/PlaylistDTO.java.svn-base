package isw2.rrmasg.presentation.shared.dtos;

import java.io.Serializable;

public class PlaylistDTO implements Serializable{
	
	private static final long serialVersionUID = -7159454936539433423L;
	private String uniqueID;
	private String name;
	private UserDTO user;
	
	public PlaylistDTO(){
		
	}

	public PlaylistDTO(String uniqueID, String name, UserDTO user) {
		this.uniqueID = uniqueID;
		this.name = name;
		this.user = user;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public UserDTO getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((uniqueID == null) ? 0 : uniqueID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlaylistDTO other = (PlaylistDTO) obj;
		if (uniqueID == null) {
			if (other.uniqueID != null)
				return false;
		} else if (!uniqueID.equals(other.uniqueID))
			return false;
		return true;
	}

}
