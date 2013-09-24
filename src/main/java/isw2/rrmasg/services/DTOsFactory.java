package isw2.rrmasg.services;

import isw2.rrmasg.domain.playlist.IPlaylist;
import isw2.rrmasg.domain.song.ISong;
import isw2.rrmasg.domain.user.IUser;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;

public class DTOsFactory {

	public static SongDTO createSongDTO(ISong song) {
		return new SongDTO(song.getUniqueID(), song.getTitle(),
				song.getAuthor(), song.getRecord(), song.getUrl());
	}

	public static PlaylistDTO createPlaylistDTO(IPlaylist playlist) {
		return new PlaylistDTO(playlist.getUniqueID(),playlist.getName(), createUserDTO(playlist.getUser()));
	}

	public static UserDTO createUserDTO(IUser user) {
		return new UserDTO(user.getUniqueID(),user.getEmail(), user.getName(),user.getSurname(),user.getCity(), user.getCountry(),user.getNativeAccount(), user.getLastSessionId());
	}
	
}
