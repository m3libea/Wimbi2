package isw2.rrmasg.presentation.client.services;

import isw2.rrmasg.presentation.shared.dtos.SongDTO;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SongServiceAsync {

	void searchSongs(String token, int firstResult, int maxResult,
			AsyncCallback<List<SongDTO>> callback);

	void getSong(String id, AsyncCallback<SongDTO> callback);

	void getAllSongs(AsyncCallback<List<SongDTO>> callback);

}
