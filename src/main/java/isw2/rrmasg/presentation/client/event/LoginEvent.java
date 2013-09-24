package isw2.rrmasg.presentation.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class LoginEvent extends GwtEvent<LoginEventHandler> {
	public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();

	private String sessionId;
	
	public LoginEvent(String sessionId){
		this.sessionId = sessionId;
	}
	
	protected void dispatch(LoginEventHandler handler) {
		handler.onLogin(this);
	}

	public Type<LoginEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	public String getSessionId() {
		return sessionId;
	}

}
