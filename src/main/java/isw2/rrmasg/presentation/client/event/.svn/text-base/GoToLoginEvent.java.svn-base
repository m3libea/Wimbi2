package isw2.rrmasg.presentation.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoToLoginEvent extends GwtEvent<GoToLoginEventHandler> {
	public static Type<GoToLoginEventHandler> TYPE = new Type<GoToLoginEventHandler>();
	
	
	protected void dispatch(GoToLoginEventHandler handler) {
		handler.onGoToLogin(this);
	}

	public Type<GoToLoginEventHandler> getAssociatedType() {
		return TYPE;
	}

}
