package isw2.rrmasg.presentation.client;

import isw2.rrmasg.presentation.client.services.PlaylistService;
import isw2.rrmasg.presentation.client.services.PlaylistServiceAsync;
import isw2.rrmasg.presentation.client.services.SongService;
import isw2.rrmasg.presentation.client.services.SongServiceAsync;
import isw2.rrmasg.presentation.client.services.UserService;
import isw2.rrmasg.presentation.client.services.UserServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class Wimbi implements EntryPoint {

	UserServiceAsync userService = GWT.create(UserService.class);
	PlaylistServiceAsync playlistService = GWT.create(PlaylistService.class);
	SongServiceAsync songService = GWT.create(SongService.class);
	HandlerManager eventBus = new HandlerManager(null);

	public void onModuleLoad() {
		String sessionID = Cookies.getCookie("sid");
		if (sessionID != null) {
			checkWithServerIfSessionIdIsStillLegal(sessionID);
		} else {
			launchApplication();

		}
	}

	private void checkWithServerIfSessionIdIsStillLegal(String sessionID) {
		userService.validateSessionId(sessionID, new AsyncCallback<Boolean>() {

			public void onFailure(Throwable arg0) {
				Window.alert("Error: no se puede cargar la sesion");
				Cookies.removeCookie("sid");
				launchApplication();
			}

			public void onSuccess(Boolean arg0) {
				if (!arg0)
					Cookies.removeCookie("sid");
				launchApplication();
			}
		});
	}

	private void launchApplication() {
		AppController appViewer = new AppController(eventBus, userService,
				playlistService, songService);
		appViewer.go(RootPanel.get());
	}

}
