package isw2.rrmasg.presentation.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class PerformSearchPlaylistEvent extends
		GwtEvent<PerformSearchPlaylistEventHandler> {
	public static Type<PerformSearchPlaylistEventHandler> TYPE = new Type<PerformSearchPlaylistEventHandler>();

	private String token = null;
	private int firstResult = 0;
	private int maxResults = 10;

	public PerformSearchPlaylistEvent(String token, int firstResult,
			int maxResults) {
		super();
		this.token = token;
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

	protected void dispatch(PerformSearchPlaylistEventHandler arg0) {
		arg0.onPerformSearchPlaylist(this);
	}

	public Type<PerformSearchPlaylistEventHandler> getAssociatedType() {
		return TYPE;
	}

	public String getSearchPLToken() {
		return token;
	}

	public int getSearchPLFirstResult() {
		return firstResult;
	}

	public int getSearchPLMaxResult() {
		return maxResults;
	}

}