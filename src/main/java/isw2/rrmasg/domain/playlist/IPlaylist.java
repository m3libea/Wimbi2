package isw2.rrmasg.domain.playlist;

import isw2.rrmasg.domain.Equalable;
import isw2.rrmasg.domain.song.ISong;
import isw2.rrmasg.domain.user.IUser;

import java.util.List;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({ "getSongs().isEmpty()", "getUser() != null", "getName().equals(\"\")" })
@Inv({ "getUniqueID() != null", "getSongs() != null", "getUser() != null",
		"getName() != null" })
public interface IPlaylist extends Equalable {

	@Query
	public String getUniqueID();

	@Query
	public String getName();

	@Pre("name != null #IllegalArgumentException")
	@Pos({
			"forall i : {0, getSongs()@pre.size()-1} ~ (getSongs()@pre.get(i).equals(getSongs().get(i)))",
			"forall i : {0, getSongs().size()-1} ~ (getSongs().get(i).equals(getSongs()@pre.get(i)))",
			"getUser().equals(getUser()@pre)", "getName().equals(name)",
			"getUniqueID()@pre.equals(getUniqueID())" })
	public void setName(String name);

	@Pre({ "song != null #IllegalArgumentException",
			"getSongs().size() < Integer.MAX_VALUE #IllegalArgumentException" })
	@Pos({
			"getUser().equals(getUser()@pre)",
			"getName().equals(getName()@pre)",
			"getUniqueID()@pre.equals(getUniqueID())",
			"getSongs().get(getSongs()@pre.size()).equals(song)",
			"getSongs().size() == getSongs()@pre.size() + 1",
			"forall i : {0, getSongs()@pre.size()-1} ~ (getSongs()@pre.get(i).equals(getSongs().get(i)))" })
	public boolean addSong(ISong song);

	@Pre({ "index >= 0 #IndexOutOfBoundsException",
			"index < getSongs().size() #IndexOutOfBoundsException" })
	@Pos({
			"getUser().equals(getUser()@pre)",
			"getName().equals(getName()@pre)",
			"getUniqueID()@pre.equals(getUniqueID())",
			"getSongs().size() == getSongs()@pre.size() - 1",
			"forall i : {0, index - 1} ~ (getSongs()@pre.get(i).equals(getSongs().get(i)))",
			"forall i : {index, getSongs().size() - 1} ~ (getSongs()@pre.get(i + 1).equals(getSongs().get(i)))" })
	public ISong deleteSongAtIndex(int index);

	@Query
	public List<ISong> getSongs();

	@Query
	public IUser getUser();

}