package isw2.rrmasg.presentation.server.service;

import isw2.rrmasg.domain.song.ISong;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.exceptions.SongNotFoundException;
import isw2.rrmasg.services.DTOsFactory;
import isw2.rrmasg.services.RepositoryFactory;

import java.util.LinkedList;
import java.util.List;

public class SongServiceImpl {

	public List<SongDTO> searchSongs(String token, int firstResult,
			int maxResult) {

		if (token == null || "".equals(token) || firstResult < 0
				|| maxResult <= 0) {
			throw new IllegalArgumentException();
		}

		List<ISong> songs = RepositoryFactory.getSongRepository().searchSongs(
				token, firstResult, maxResult);
		List<SongDTO> result = new LinkedList<SongDTO>();
		for (ISong s : songs) {
			result.add(DTOsFactory.createSongDTO(s));
		}
		return result;
	}

	public SongDTO getSong(String id) {
		if (id == null | "".equals(id)) {
			throw new IllegalArgumentException();
		}

		ISong s = RepositoryFactory.getSongRepository().findByID(id);

		if (s == null) {
			throw new SongNotFoundException();
		}

		return DTOsFactory.createSongDTO(s);
	}

	public List<SongDTO> getAllSongs() {
		List<ISong> songs = RepositoryFactory.getSongRepository().findAllSongs();
		List<SongDTO> result = new LinkedList<SongDTO>();
		for (ISong s : songs) {
			result.add(DTOsFactory.createSongDTO(s));
		}
		return result;
	}
}
