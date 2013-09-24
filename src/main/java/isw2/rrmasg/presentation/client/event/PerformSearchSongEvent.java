package isw2.rrmasg.presentation.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class PerformSearchSongEvent extends
		GwtEvent<PerformSearchSongEventHandler> {
	public static Type<PerformSearchSongEventHandler> TYPE = new Type<PerformSearchSongEventHandler>();

	private String token = null;
	private int firstResult = 0;
	private int maxResults = 10;

	public PerformSearchSongEvent(String token, int firstResult,
			int maxResults) {
		super();
		this.token = token;
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

	protected void dispatch(PerformSearchSongEventHandler arg0) {
		arg0.onPerformSearchSong(this);
	}

	public Type<PerformSearchSongEventHandler> getAssociatedType() {
		return TYPE;
	}

	public String getSearchSToken() {
		return token;
	}

	public int getSearchSFirstResult() {
		return firstResult;
	}

	public int getSearchSMaxResult() {
		return maxResults;
	}

}