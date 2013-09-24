package isw2.rrmasg.presentation.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoToStartEvent extends GwtEvent<GoToStartEventHandler> {

	public static Type<GoToStartEventHandler> TYPE = new Type<GoToStartEventHandler>();

	protected void dispatch(GoToStartEventHandler arg0) {
		arg0.onGoToStart(this);
	}

	public Type<GoToStartEventHandler> getAssociatedType() {
		return TYPE;
	}

}
