package isw2.rrmasg.presentation.client.event;

import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;

import com.google.gwt.event.shared.GwtEvent;

public class GoToPlaylistEvent extends GwtEvent<GoToPlaylistEventHandler> {
	public static Type<GoToPlaylistEventHandler> TYPE = new Type<GoToPlaylistEventHandler>();

	private PlaylistDTO playlist;

	public GoToPlaylistEvent(PlaylistDTO playlist) {
		super();
		this.playlist = playlist;
	}

	public PlaylistDTO getPlaylist() {
		return playlist;
	}

	protected void dispatch(GoToPlaylistEventHandler arg0) {
		arg0.onGoToPlaylist(this);
	}

	public Type<GoToPlaylistEventHandler> getAssociatedType() {
		return TYPE;
	}

}
