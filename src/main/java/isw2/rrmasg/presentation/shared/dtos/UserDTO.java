package isw2.rrmasg.presentation.shared.dtos;

import java.io.Serializable;


public class UserDTO implements Serializable{

	private static final long serialVersionUID = -5840449956681350664L;
	private String uniqueID;
	private String email;
	private String name;
	private String surname;
	private String city;
	private String country;
	private boolean nativeAccount;
	private String lastSessionId;

	public UserDTO(){
		
	}
	
	public UserDTO(String uniqueID, String email, String name, String surname,
			String city, String country, boolean nativeAccount, String lastSessionId) {
		this.uniqueID = uniqueID;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.country = country;
		this.nativeAccount = nativeAccount;
		this.lastSessionId = lastSessionId;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public boolean isNativeAccount() {
		return nativeAccount;
	}

	public String getLastSessionId() {
		return lastSessionId;
	}

}
