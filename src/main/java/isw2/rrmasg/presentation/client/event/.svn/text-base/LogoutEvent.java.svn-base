package isw2.rrmasg.presentation.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class LogoutEvent extends GwtEvent<LogoutEventHandler> {
	public static Type<LogoutEventHandler> TYPE = new Type<LogoutEventHandler>();

	protected void dispatch(LogoutEventHandler handler) {
		handler.onLogout(this);
	}

	public com.google.gwt.event.shared.GwtEvent.Type<LogoutEventHandler> getAssociatedType() {
		return TYPE;
	}

}
