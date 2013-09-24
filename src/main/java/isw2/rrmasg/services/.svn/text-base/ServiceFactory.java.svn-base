package isw2.rrmasg.services;

import isw2.rrmasg.presentation.server.service.PlaylistServiceImpl;
import isw2.rrmasg.presentation.server.service.SongServiceImpl;
import isw2.rrmasg.presentation.server.service.UserServiceImpl;

public class ServiceFactory {
	private static SongServiceImpl songService;
	private static PlaylistServiceImpl playlistService;
	private static UserServiceImpl userService;

	public static SongServiceImpl getSongService() {
		if (songService == null) {
			songService = new SongServiceImpl();
		}
		return songService;
	}

	public static PlaylistServiceImpl getPlaylistService() {
		if (playlistService == null) {
			playlistService = new PlaylistServiceImpl();
		}
		return playlistService;
	}

	public static UserServiceImpl getUserService() {
		if (userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}
}
