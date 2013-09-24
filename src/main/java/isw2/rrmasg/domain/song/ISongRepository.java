package isw2.rrmasg.domain.song;

import java.util.List;

public interface ISongRepository {

	public ISong findByID(String uniqueID);

	public List<ISong> searchSongs(String token, int firstResult, int maxResults);

	public String getNextId();

	public void reIndexSongs();

	public List<ISong> findAllSongs();
}
