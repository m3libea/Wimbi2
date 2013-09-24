package isw2.rrmasg.presentation.client.event;

import isw2.rrmasg.presentation.shared.dtos.SongDTO;

import com.google.gwt.event.shared.GwtEvent;

public class GoToSongEvent extends GwtEvent<GoToSongEventHandler> {
	public static Type<GoToSongEventHandler> TYPE = new Type<GoToSongEventHandler>();

	private SongDTO song;

	public GoToSongEvent(SongDTO song) {
		super();
		this.song = song;
	}

	public SongDTO getSong() {
		return song;
	}

	protected void dispatch(GoToSongEventHandler arg0) {
		arg0.onGoToSong(this);
	}

	public Type<GoToSongEventHandler> getAssociatedType() {
		return TYPE;
	}

}
