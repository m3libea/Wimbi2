package isw2.rrmasg.domain.user;

import isw2.rrmasg.domain.Equalable;
import isw2.rrmasg.domain.playlist.IPlaylist;

import java.util.List;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({ "getPlaylists().isEmpty()", "getEmail().equals(\"\")",
		"getPassword().equals(\"\")", "getName().equals(\"\")",
		"getSurname().equals(\"\")", "getCity().equals(\"\")",
		"getCountry().equals(\"\")", "getLastSessionId().equals(\"\")" })
@Inv({ "getPlaylists() != null", "getEmail() != null", "getPassword() != null",
		"getName() != null", "getSurname() != null", "getCity() != null",
		"getCountry() != null", "getUniqueID() != null", "getLastSessionId() != null" })
public interface IUser extends Equalable {

	@Query
	public String getUniqueID();

	@Query
	public String getEmail();

	@Pre("email !=null #IllegalArgumentException")
	@Pos({
			"getUniqueID()@pre.equals(getUniqueID())",
			"getEmail().equals(email)",
			"getPassword()@pre.equals(getPassword())",
			"getName()@pre.equals(getName())",
			"getSurname()@pre.equals(getSurname())",
			"getCity()@pre.equals(getCity())",
			"getCountry()@pre.equals(getCountry())",
			"getNativeAccount()@pre == getNativeAccount()",
			"getLastSessionId()@pre.equals(getLastSessionId())",
			"forall i : {0, getPlaylists()@pre.size()-1} ~ (getPlaylists()@pre.get(i).equals(getPlaylists().get(i)))",
			"forall i : {0, getPlaylists().size()-1} ~ (getPlaylists().get(i).equals(getPlaylists()@pre.get(i)))" })
	public void setEmail(String email);

	@Query
	public String getPassword();

	@Pre({
			"password != null #IllegalArgumentException" })
	@Pos({
			"getUniqueID()@pre.equals(getUniqueID())",
			"getEmail()@pre.equals(getEmail())",
			"getPassword().equals(password)",
			"getName()@pre.equals(getName())",
			"getSurname()@pre.equals(getSurname())",
			"getCity()@pre.equals(getCity())",
			"getCountry()@pre.equals(getCountry())",
			"getNativeAccount()@pre == getNativeAccount()",
			"getLastSessionId()@pre.equals(getLastSessionId())",
			"forall i : {0, getPlaylists()@pre.size()-1} ~ (getPlaylists()@pre.get(i).equals(getPlaylists().get(i)))",
			"forall i : {0, getPlaylists().size()-1} ~ (getPlaylists().get(i).equals(getPlaylists()@pre.get(i)))" })
	public void setPassword(String password);

	@Query
	public String getName();

	@Pre("name !=null #IllegalArgumentException")
	@Pos({
			"getUniqueID()@pre.equals(getUniqueID())",
			"getEmail()@pre.equals(getEmail())",
			"getPassword()@pre.equals(getPassword())",
			"getName().equals(name)",
			"getSurname()@pre.equals(getSurname())",
			"getCity()@pre.equals(getCity())",
			"getCountry()@pre.equals(getCountry())",
			"getNativeAccount()@pre == getNativeAccount()",
			"getLastSessionId()@pre.equals(getLastSessionId())",
			"forall i : {0, getPlaylists()@pre.size()-1} ~ (getPlaylists()@pre.get(i).equals(getPlaylists().get(i)))",
			"forall i : {0, getPlaylists().size()-1} ~ (getPlaylists().get(i).equals(getPlaylists()@pre.get(i)))" })
	public void setName(String name);

	@Query
	public String getSurname();

	@Pre("surname !=null #IllegalArgumentException")
	@Pos({
			"getUniqueID()@pre.equals(getUniqueID())",
			"getEmail()@pre.equals(getEmail())",
			"getPassword()@pre.equals(getPassword())",
			"getName()@pre.equals(getName())",
			"getSurname().equals(surname)",
			"getCity()@pre.equals(getCity())",
			"getCountry()@pre.equals(getCountry())",
			"getNativeAccount()@pre == getNativeAccount()",
			"getLastSessionId()@pre.equals(getLastSessionId())",
			"forall i : {0, getPlaylists()@pre.size()-1} ~ (getPlaylists()@pre.get(i).equals(getPlaylists().get(i)))",
			"forall i : {0, getPlaylists().size()-1} ~ (getPlaylists().get(i).equals(getPlaylists()@pre.get(i)))" })
	public void setSurname(String surname);

	@Query
	public String getCity();

	@Pre("city !=null #IllegalArgumentException")
	@Pos({
			"getUniqueID()@pre.equals(getUniqueID())",
			"getEmail()@pre.equals(getEmail())",
			"getPassword()@pre.equals(getPassword())",
			"getName()@pre.equals(getName())",
			"getSurname()@pre.equals(getSurname())",
			"getCity().equals(city)",
			"getCountry()@pre.equals(getCountry())",
			"getNativeAccount()@pre == getNativeAccount()",
			"getLastSessionId()@pre.equals(getLastSessionId())",
			"forall i : {0, getPlaylists()@pre.size()-1} ~ (getPlaylists()@pre.get(i).equals(getPlaylists().get(i)))",
			"forall i : {0, getPlaylists().size()-1} ~ (getPlaylists().get(i).equals(getPlaylists()@pre.get(i)))" })
	public void setCity(String city);

	@Query
	public String getCountry();

	@Pre("country !=null #IllegalArgumentException")
	@Pos({
			"getUniqueID()@pre.equals(getUniqueID())",
			"getEmail()@pre.equals(getEmail())",
			"getPassword()@pre.equals(getPassword())",
			"getName()@pre.equals(getName())",
			"getSurname()@pre.equals(getSurname())",
			"getCity()@pre.equals(getCity())",
			"getCountry().equals(country)",
			"getNativeAccount()@pre == getNativeAccount()",
			"getLastSessionId()@pre.equals(getLastSessionId())",
			"forall i : {0, getPlaylists()@pre.size()-1} ~ (getPlaylists()@pre.get(i).equals(getPlaylists().get(i)))",
			"forall i : {0, getPlaylists().size()-1} ~ (getPlaylists().get(i).equals(getPlaylists()@pre.get(i)))" })
	public void setCountry(String country);

	@Query
	public boolean getNativeAccount();

	@Query
	public List<IPlaylist> getPlaylists();

	@Pre("getPlaylists().size() < Integer.MAX_VALUE #IndexOutOfBoundsException")
	@Pos({
			"getUniqueID()@pre.equals(getUniqueID())",
			"getEmail()@pre.equals(getEmail())",
			"getPassword()@pre.equals(getPassword())",
			"getName()@pre.equals(getName())",
			"getSurname()@pre.equals(getSurname())",
			"getCity()@pre.equals(getCity())",
			"getCountry()@pre.equals(getCountry())",
			"getNativeAccount()@pre == getNativeAccount()",
			"getLastSessionId()@pre.equals(getLastSessionId())",
			"getPlaylists().get(getPlaylists()@pre.size()).equals(result)",
			"getPlaylists().size() == getPlaylists()@pre.size() + 1",
			"forall i : {0, getPlaylists()@pre.size()-1} ~ (getPlaylists()@pre.get(i).equals(getPlaylists().get(i)))" })
	public IPlaylist createPlaylist();

	@Pre("playlist != null #IllegalArgumentException")
	@Pos({
			"result == getPlaylists()@pre.contains(playlist)",
			"getUniqueID()@pre.equals(getUniqueID())",
			"getEmail()@pre.equals(getEmail())",
			"getPassword()@pre.equals(getPassword())",
			"getName()@pre.equals(getName())",
			"getSurname()@pre.equals(getSurname())",
			"getCity()@pre.equals(getCity())",
			"getCountry()@pre.equals(getCountry())",
			"getNativeAccount()@pre == getNativeAccount()",
			"getLastSessionId()@pre.equals(getLastSessionId())",
			"result ==> getPlaylists().size() == getPlaylists()@pre.size() - 1",
			"!result ==> getPlaylists().size() == getPlaylists()@pre.size()",
			"result ==> forall i : {0, getPlaylists()@pre.indexOf(playlist) - 1} ~ (getPlaylists()@pre.get(i).equals(getPlaylists().get(i)))",
			"result ==> forall i : {getPlaylists()@pre.indexOf(playlist), getPlaylists().size() - 1} ~ (getPlaylists()@pre.get(i + 1).equals(getPlaylists().get(i)))" })
	public boolean deletePlaylist(IPlaylist playlist);

	@Query
	public String getLastSessionId();
	
	@Pre("lastSessionId != null #IllegalArgumentException")
		@Pos({
			"getUniqueID()@pre.equals(getUniqueID())",
			"getEmail()@pre.equals(getEmail())",
			"getPassword()@pre.equals(getPassword())",
			"getName()@pre.equals(getName())",
			"getSurname()@pre.equals(getSurname())",
			"getCity()@pre.equals(getCity())",
			"getCountry()@pre.equals(getCountry())",
			"getNativeAccount()@pre == getNativeAccount()",
			"getLastSessionId().equals(lastSessionId)",
			"forall i : {0, getPlaylists()@pre.size()-1} ~ (getPlaylists()@pre.get(i).equals(getPlaylists().get(i)))",
			"forall i : {0, getPlaylists().size()-1} ~ (getPlaylists().get(i).equals(getPlaylists()@pre.get(i)))" })
	public void setLastSessionId(String lastSessionId);

	
}