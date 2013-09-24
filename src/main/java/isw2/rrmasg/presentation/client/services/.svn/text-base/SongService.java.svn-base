package isw2.rrmasg.presentation.client.services;

import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.exceptions.SongNotFoundException;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("song")
public interface SongService extends RemoteService {

	public List<SongDTO> searchSongs(String token, int firstResult,
			int maxResult) throws IllegalArgumentException;
	
	public SongDTO getSong(String id) throws SongNotFoundException;

	public List<SongDTO> getAllSongs();

}