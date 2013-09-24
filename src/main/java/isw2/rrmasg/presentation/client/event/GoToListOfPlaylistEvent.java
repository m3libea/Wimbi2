package isw2.rrmasg.presentation.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoToListOfPlaylistEvent extends GwtEvent<GoToListOfPlaylistEventHandler> {
	public static Type<GoToListOfPlaylistEventHandler> TYPE = new Type<GoToListOfPlaylistEventHandler>();

	public Type<GoToListOfPlaylistEventHandler> getAssociatedType() {
		return TYPE;
	}

	protected void dispatch(GoToListOfPlaylistEventHandler handler) {
		handler.onLoginUser(this);
	}


}
