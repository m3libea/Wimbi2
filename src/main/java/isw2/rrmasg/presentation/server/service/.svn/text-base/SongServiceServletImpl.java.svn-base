package isw2.rrmasg.presentation.server.service;

import isw2.rrmasg.presentation.client.services.SongService;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.exceptions.SongNotFoundException;
import isw2.rrmasg.services.ServiceFactory;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SongServiceServletImpl  extends RemoteServiceServlet implements SongService {

	private static final long serialVersionUID = -1013219456683287185L;

	public List<SongDTO> searchSongs(String token, int firstResult,
			int maxResult) {
		return ServiceFactory.getSongService().searchSongs(token, firstResult, maxResult);
	}

	public SongDTO getSong(String id) throws SongNotFoundException {
		return ServiceFactory.getSongService().getSong(id);
	}

	public List<SongDTO> getAllSongs() {
		return ServiceFactory.getSongService().getAllSongs();
	}

}
