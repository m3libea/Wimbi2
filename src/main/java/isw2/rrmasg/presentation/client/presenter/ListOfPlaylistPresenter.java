package isw2.rrmasg.presentation.client.presenter;

import isw2.rrmasg.presentation.client.event.GoToEditUserEvent;
import isw2.rrmasg.presentation.client.event.GoToPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchSongEvent;
import isw2.rrmasg.presentation.client.event.LogoutEvent;
import isw2.rrmasg.presentation.client.services.PlaylistServiceAsync;
import isw2.rrmasg.presentation.client.services.UserServiceAsync;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.exceptions.NotUserInSessionException;
import isw2.rrmasg.presentation.shared.exceptions.WrongSessionIdException;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ListOfPlaylistPresenter implements Presenter {

	public interface Display {
		void setData(List<PlaylistDTO> data);

		void addData(PlaylistDTO playlist);

		PlaylistDTO getClickedRow();

		HasValue<String> getPlaylistName();

		HasClickHandlers getNewPlaylistButton();

		HasClickHandlers getOpenSelectedPlaylistButton();

		HasClickHandlers getGoToEditUserButton();

		HasClickHandlers getGoToSearchSongButton();

		HasClickHandlers getGoToSearchPlaylistButton();

		HasClickHandlers getLogoutButton();

		Widget asWidget();
	}

	private UserServiceAsync userService;
	private PlaylistServiceAsync playlistService;
	private final HandlerManager eventBus;
	private final Display display;
	private final String sessionId = Cookies.getCookie("tmpsid");

	public ListOfPlaylistPresenter(UserServiceAsync userService,
			PlaylistServiceAsync playlistService, HandlerManager eventBus,
			Display display) {
		this.userService = userService;
		this.playlistService = playlistService;
		this.eventBus = eventBus;
		this.display = display;
		
	}

	public void bind() {

		display.getLogoutButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new LogoutEvent());
			}
		});

		display.getGoToEditUserButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToEditUserEvent());
			}
		});

		display.getGoToSearchSongButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToSearchSongEvent());
			}
		});

		display.getGoToSearchPlaylistButton().addClickHandler(
				new ClickHandler() {
					public void onClick(ClickEvent arg0) {
						eventBus.fireEvent(new GoToSearchPlaylistEvent());
					}
				});

		display.getOpenSelectedPlaylistButton().addClickHandler(
				new ClickHandler() {
					public void onClick(ClickEvent arg0) {
						PlaylistDTO pl = display.getClickedRow();
						if (pl != null) {
							eventBus.fireEvent(new GoToPlaylistEvent(pl));
						}
					}
				});

		display.getNewPlaylistButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				playlistService.createPlaylist(display.getPlaylistName()
						.getValue(), sessionId,
						new AsyncCallback<PlaylistDTO>() {
							public void onFailure(Throwable caught) {
								try {
									throw caught;
								} catch (NotUserInSessionException e) {
									Window.alert("No se ha iniciado sesi\u00f3n.");
									eventBus.fireEvent(new LogoutEvent());
								} catch (IllegalArgumentException e) {
									Window.alert("Ha ocurrido un error inesperado.");
									eventBus.fireEvent(new LogoutEvent());
								} catch (WrongSessionIdException e) {
									Window.alert("Error validando la sesi\u00f3n.");
									eventBus.fireEvent(new LogoutEvent());
								} catch (Throwable e) {
									Window.alert("No se ha podido completar la operaci\u00f3n.");
								}
							}

							public void onSuccess(PlaylistDTO playlist) {
								display.addData(playlist);
							}
						});
			}
		});

		userService.getPlaylists(sessionId,
				new AsyncCallback<List<PlaylistDTO>>() {
					public void onFailure(Throwable caught) {
						try {
							throw caught;
						} catch (IllegalArgumentException e) {
							Window.alert("Se ha cerrado la sesi\u00f3n.");
							eventBus.fireEvent(new LogoutEvent());
						} catch (NotUserInSessionException e) {
							Window.alert("No se ha iniciado sesi\u00f3n.");
							eventBus.fireEvent(new LogoutEvent());
						} catch (WrongSessionIdException e) {
							Window.alert("Error validando la sesi\u00f3n.");
							eventBus.fireEvent(new LogoutEvent());
						} catch (Throwable e) {
							Window.alert("No se ha podido completar la operaci\u00f3n.");
						}
					}

					public void onSuccess(List<PlaylistDTO> playlists) {
						display.setData(playlists);
					}
				});

	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

}
