package isw2.rrmasg.presentation.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoToEditUserEvent extends GwtEvent<GoToEditUserEventHandler>{
	public static Type<GoToEditUserEventHandler> TYPE = new Type<GoToEditUserEventHandler>();

	
	protected void dispatch(GoToEditUserEventHandler arg0) {
		arg0.onGoToEditUser(this);
	}

	public Type<GoToEditUserEventHandler> getAssociatedType() {
		return TYPE;
	}

}
