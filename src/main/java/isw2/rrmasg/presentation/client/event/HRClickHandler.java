package isw2.rrmasg.presentation.client.event;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

public abstract class HRClickHandler implements ClickHandler{
	private HandlerRegistration handlerRegistration;
	
	public HRClickHandler(HandlerRegistration hr){
		handlerRegistration = hr;
	}

	public HandlerRegistration getHandlerRegistration() {
		return handlerRegistration;
	}
	
}
