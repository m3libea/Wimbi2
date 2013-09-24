package isw2.rrmasg.presentation.server.service;

import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.song.ISong;
import isw2.rrmasg.domain.user.IUser;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.PlaylistNotFoundException;
import isw2.rrmasg.presentation.shared.exceptions.WrongUserException;
import isw2.rrmasg.services.DTOsFactory;
import isw2.rrmasg.services.RepositoryFactory;

import java.util.LinkedList;
import java.util.List;

public class PlaylistServiceImpl {


	public List<PlaylistDTO> searchPlaylists(String token, int firstResult,
			int maxResult) {
		if (token == null || "".equals(token) || firstResult < 0
				|| maxResult <= 0) {
			throw new IllegalArgumentException();
		}
		List<IPlaylist> playlists = RepositoryFactory.getPlaylistRepository()
				.searchPlaylists(token, firstResult, maxResult);
		List<PlaylistDTO> result = new LinkedList<PlaylistDTO>();
		for (IPlaylist pl : playlists) {
			result.add(DTOsFactory.createPlaylistDTO(pl));
		}
		return result;
	}

	public PlaylistDTO createPlaylist(UserDTO user, String name) {

		if (user == null || name == null || "".equals(name)) {
			throw new IllegalArgumentException();
		}

		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		IPlaylist realPlaylist = realUser.createPlaylist();
		realPlaylist.setName(name);
		RepositoryFactory.getPlaylistRepository().store(realPlaylist);
		return DTOsFactory.createPlaylistDTO(realPlaylist);
	}

	public boolean deletePlaylist(UserDTO user, PlaylistDTO playlist) {

		if (user == null || playlist == null) {
			throw new IllegalArgumentException();
		}

		if (!isPlaylistFromUser(user, playlist)) {
			throw new WrongUserException();
		}
		IPlaylist realPlaylist = RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID());
		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		realUser.deletePlaylist(realPlaylist);
		RepositoryFactory.getPlaylistRepository().remove(realPlaylist);
		try {
			RepositoryFactory.getPlaylistRepository().findByID(
					playlist.getUniqueID());
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	public List<SongDTO> getSongs(PlaylistDTO playlist) {

		if (playlist == null) {
			throw new IllegalArgumentException();
		}

		IPlaylist realPlaylist = RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID());
		List<SongDTO> result = new LinkedList<SongDTO>();
		for (ISong s : realPlaylist.getSongs()) {
			result.add(DTOsFactory.createSongDTO(s));
		}
		return result;
	}

	public boolean addSongToPlaylist(UserDTO user, PlaylistDTO playlist,
			SongDTO song) {

		if (user == null || playlist == null || song == null) {
			throw new IllegalArgumentException();
		}

		if (!isPlaylistFromUser(user, playlist)) {
			throw new WrongUserException();
		}
		IPlaylist realPlaylist = RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID());
		ISong realSong = RepositoryFactory.getSongRepository().findByID(
				song.getUniqueID());
		boolean result = realPlaylist.addSong(realSong);
		RepositoryFactory.getPlaylistRepository().store(realPlaylist);
		return result;
	}

	public SongDTO deleteSongFromPlaylist(UserDTO user, PlaylistDTO playlist,
			int position) {

		if (user == null || playlist == null) {
			throw new IllegalArgumentException();
		}

		if (!isPlaylistFromUser(user, playlist)) {
			throw new WrongUserException();
		}
		IPlaylist realPlaylist = RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID());
		SongDTO result =DTOsFactory.createSongDTO(realPlaylist.deleteSongAtIndex(position));
		RepositoryFactory.getPlaylistRepository().store(realPlaylist);
		return result;
	}

	public PlaylistDTO changePlaylistName(UserDTO user, PlaylistDTO playlist,
			String name) {

		if (user == null || playlist == null || name == null || "".equals(name)) {
			throw new IllegalArgumentException();
		}

		if (!isPlaylistFromUser(user, playlist)) {
			throw new WrongUserException();
		}
		IPlaylist realPlaylist = RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID());
		realPlaylist.setName(name);
		RepositoryFactory.getPlaylistRepository().store(realPlaylist);
		return DTOsFactory.createPlaylistDTO(realPlaylist);
	}

	public boolean isPlaylistFromUser(UserDTO user, PlaylistDTO playlist) {

		if (user == null || playlist == null) {
			throw new IllegalArgumentException();
		}
		IUser realUser = RepositoryFactory.getUserRepository().findById(
				user.getUniqueID());
		IPlaylist realPlaylist = RepositoryFactory.getPlaylistRepository()
				.findByID(playlist.getUniqueID());

		return realUser.getPlaylists().contains(realPlaylist);
	}

	public PlaylistDTO getPlaylist(String id) {
		if (id == null | "".equals(id)){
			throw new IllegalArgumentException();
		}
		
		IPlaylist pl = RepositoryFactory.getPlaylistRepository().findByID(id);
		
		if (pl == null){
			throw new PlaylistNotFoundException();
		}
		
		return DTOsFactory.createPlaylistDTO(pl);
	}

}
