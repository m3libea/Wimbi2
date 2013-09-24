package isw2.rrmasg.presentation.client.presenter;

import isw2.rrmasg.presentation.client.event.GoBackEvent;
import isw2.rrmasg.presentation.client.event.GoToEditUserEvent;
import isw2.rrmasg.presentation.client.event.GoToListOfPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchSongEvent;
import isw2.rrmasg.presentation.client.event.GoToSongEvent;
import isw2.rrmasg.presentation.client.event.GoToStartEvent;
import isw2.rrmasg.presentation.client.event.LogoutEvent;
import isw2.rrmasg.presentation.client.services.PlaylistServiceAsync;
import isw2.rrmasg.presentation.client.services.UserServiceAsync;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.NotUserInSessionException;
import isw2.rrmasg.presentation.shared.exceptions.PlaylistNotFoundException;
import isw2.rrmasg.presentation.shared.exceptions.WrongSessionIdException;
import isw2.rrmasg.presentation.shared.exceptions.WrongUserException;

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

public class PlaylistPresenter implements Presenter {

	public interface Display {
		HasClickHandlers getUserButton();

		HasClickHandlers getPlaylistButton();

		HasClickHandlers getSearchSongButton();

		HasClickHandlers getSearchPlaylistButton();

		HasClickHandlers getLogoutButton();

		HasClickHandlers getOpenSelectedSongButton();

		HasClickHandlers getChangeNameButton();

		HasClickHandlers getBackButton();

		HasValue<String> getName();

		void setData(List<SongDTO> data);

		void setName(String name);

		void setUser(String userName);

		void userIsLogged();

		SongDTO getClickedRow();

		Widget asWidget();
	}

	private PlaylistServiceAsync playlistService;
	private UserServiceAsync userService;
	private final HandlerManager eventBus;
	private final Display display;
	private final String sessionId = Cookies.getCookie("tmpsid");
	private PlaylistDTO playlist;
	private String uniqueID;
	private UserDTO loggedUser;

	public PlaylistPresenter(PlaylistServiceAsync playlistService,
			UserServiceAsync userService, HandlerManager eventBus,
			Display display, PlaylistDTO playlist) {
		this.playlistService = playlistService;
		this.userService = userService;
		this.eventBus = eventBus;
		this.display = display;
		this.playlist = playlist;
		this.uniqueID = playlist.getUniqueID();
	}

	public PlaylistPresenter(PlaylistServiceAsync playlistService,
			UserServiceAsync userService, HandlerManager eventBus,
			Display display, String substring) {
		this.playlistService = playlistService;
		this.userService = userService;
		this.eventBus = eventBus;
		this.display = display;
		this.playlist = null;
		this.uniqueID = substring;
	}

	public void bind() {

		if (playlist == null) {
			playlistService.getPlaylist(uniqueID,
					new AsyncCallback<PlaylistDTO>() {

						public void onFailure(Throwable arg0) {
							try {
								throw arg0;
							} catch (IllegalArgumentException e) {
								Window.alert("Se ha cerrado la sesi\u00f3n.");
								eventBus.fireEvent(new LogoutEvent());
							} catch (PlaylistNotFoundException e) {
								Window.alert("No se ha encontrado la lista de reproducci\u00f3n.");
								eventBus.fireEvent(new GoToStartEvent());
							} catch (Throwable e) {
								Window.alert("No se ha podido completar la operaci\u00f3n.");
							}
						}

						public void onSuccess(PlaylistDTO arg0) {
							playlist = arg0;
							updateData();
						}
					});
		}

		display.getLogoutButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new LogoutEvent());
			}
		});

		display.getSearchSongButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToSearchSongEvent());
			}
		});

		display.getPlaylistButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToListOfPlaylistEvent());
			}
		});

		display.getUserButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToEditUserEvent());
			}
		});
		display.getSearchPlaylistButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToSearchPlaylistEvent());
			}
		});

		display.getBackButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoBackEvent());
			}
		});

		display.getOpenSelectedSongButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				SongDTO s = display.getClickedRow();
				if (s != null) {
					eventBus.fireEvent(new GoToSongEvent(s));
				}
			}
		});

		display.getChangeNameButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				if (!display.getName().equals(playlist.getName())) {
					playlistService.changePlaylistName(playlist, display
							.getName().getValue(), sessionId,
							new AsyncCallback<PlaylistDTO>() {
								public void onFailure(Throwable arg0) {
									try {
										throw arg0;
									} catch (NotUserInSessionException e) {
										Window.alert("No se ha iniciado sesi\u00f3n.");
										eventBus.fireEvent(new LogoutEvent());
									} catch (IllegalArgumentException e) {
										Window.alert("Ha ocurrido un error inesperado.");
										eventBus.fireEvent(new LogoutEvent());
									} catch (WrongUserException e) {
										Window.alert("No puede cambiar el nombre de esta lista de reproducci\u00f3n.");
									} catch (WrongSessionIdException e) {
										Window.alert("Error validando la sesi\u00f3n.");
										eventBus.fireEvent(new LogoutEvent());
									} catch (Throwable e) {
										Window.alert("No se ha podido completar la operaci\u00f3n.");
									}
								}

								public void onSuccess(PlaylistDTO arg0) {
									playlist = arg0;
									Window.alert("Se ha cambiado el nombre de la lista de reproducci\u00f3n.");
								}
							});
				}
			}
		});

		if (playlist != null) {
			updateData();
		}
	}

	void updateData() {
		display.setName(playlist.getName());
		display.setUser(playlist.getUser().getName());

		userService.getLoggedUser(sessionId, new AsyncCallback<UserDTO>() {

			public void onFailure(Throwable arg0) {
				try {
					throw arg0;
				} catch (NotUserInSessionException e) {
				} catch (WrongSessionIdException e) {
					Window.alert("Error validando la sesi\u00f3n.");
					eventBus.fireEvent(new LogoutEvent());
				} catch (Throwable e) {
					Window.alert("No se ha podido completar la operaci\u00f3n.");
				}
			}

			public void onSuccess(UserDTO arg0) {
				loggedUser = arg0;
				if (loggedUser.getUniqueID().equals(
						playlist.getUser().getUniqueID())) {
					display.userIsLogged();
					display.setName(playlist.getName());
				}
			}
		});

		playlistService.getSongs(playlist, new AsyncCallback<List<SongDTO>>() {

			public void onFailure(Throwable arg0) {
				try {
					throw arg0;
				} catch (IllegalArgumentException e) {
					Window.alert("Se ha cerrado la sesi\u00f3n.");
					eventBus.fireEvent(new LogoutEvent());
				} catch (Throwable e) {
					Window.alert("No se ha podido completar la operaci\u00f3n.");
				}
			}

			public void onSuccess(List<SongDTO> arg0) {
				display.setData(arg0);
			}

		});
	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

}
