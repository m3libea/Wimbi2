package isw2.rrmasg.presentation.client.presenter;

import isw2.rrmasg.presentation.client.event.GoBackEvent;
import isw2.rrmasg.presentation.client.event.GoToEditUserEvent;
import isw2.rrmasg.presentation.client.event.GoToListOfPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchSongEvent;
import isw2.rrmasg.presentation.client.event.GoToStartEvent;
import isw2.rrmasg.presentation.client.event.LogoutEvent;
import isw2.rrmasg.presentation.client.services.PlaylistServiceAsync;
import isw2.rrmasg.presentation.client.services.SongServiceAsync;
import isw2.rrmasg.presentation.client.services.UserServiceAsync;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
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
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class SongPresenter implements Presenter {

	public interface Display {
		HasClickHandlers getUserButton();

		HasClickHandlers getPlaylistButton();

		HasClickHandlers getSearchSongButton();

		HasClickHandlers getSearchPlaylistButton();

		HasClickHandlers getLogoutButton();

		HasClickHandlers getAddButton();

		void setTitle(String title);

		void setAuthor(String author);

		void setRecord(String record);

		void setUrl(String url);

		void setData(List<PlaylistDTO> data);

		PlaylistDTO getClickedRow();

		Widget asWidget();

		HasClickHandlers getBackButton();
	}

	private PlaylistServiceAsync playlistService;
	private UserServiceAsync userService;
	private SongServiceAsync songService;
	private final HandlerManager eventBus;
	private final Display display;
	private final String sessionId = Cookies.getCookie("tmpsid");
	private SongDTO song;
	private String uniqueID;

	public SongPresenter(UserServiceAsync userService,
			PlaylistServiceAsync playlistService, SongServiceAsync songService,
			HandlerManager eventBus, Display display, SongDTO song) {
		this.playlistService = playlistService;
		this.userService = userService;
		this.songService = songService;
		this.eventBus = eventBus;
		this.display = display;
		this.song = song;
		this.uniqueID = song.getUniqueID();
	}

	public SongPresenter(UserServiceAsync userService,
			PlaylistServiceAsync playlistService, SongServiceAsync songService,
			HandlerManager eventBus, Display display, String substring) {
		this.playlistService = playlistService;
		this.userService = userService;
		this.songService = songService;
		this.eventBus = eventBus;
		this.display = display;
		this.song = null;
		this.uniqueID = substring;
	}

	public void bind() {

		if (song == null) {
			songService.getSong(uniqueID, new AsyncCallback<SongDTO>() {

				public void onFailure(Throwable arg0) {
					try {
						throw arg0;
					} catch (IllegalArgumentException e) {
						Window.alert("Se ha cerrado la sesi\u00f3n.");
						eventBus.fireEvent(new LogoutEvent());
					} catch (PlaylistNotFoundException e) {
						Window.alert("No se ha encontrado la canci\u00f3n.");
						eventBus.fireEvent(new GoToStartEvent());
					} catch (Throwable e) {
						Window.alert("No se ha podido completar la operaci\u00f3n.");
					}
				}

				public void onSuccess(SongDTO arg0) {
					song = arg0;
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

		display.getAddButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				PlaylistDTO pl = display.getClickedRow();
				if (pl != null) {
					playlistService.addSongToPlaylist(pl, song, sessionId,
							new AsyncCallback<Boolean>() {

								public void onFailure(Throwable arg0) {
									try {
										throw arg0;
									} catch (IllegalArgumentException e) {
										Window.alert("Se ha cerrado la sesi\u00f3n.");
										eventBus.fireEvent(new LogoutEvent());
									} catch (WrongUserException e) {
										Window.alert("No spuede modificar esa lista de reproducci\u00f3n.");
										eventBus.fireEvent(new GoToStartEvent());
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

								public void onSuccess(Boolean arg0) {
									if (arg0) {
										Window.alert("Se ha agregado la canci\u00f3n.");
									} else {
										Window.alert("No se ha agregado la canci\u00f3n.");
									}
								}

							});
				}
			}
		});

		if (song != null) {
			updateData();
		}
	}

	void updateData() {
		display.setTitle(song.getTitle());
		display.setAuthor(song.getAuthor());
		display.setRecord(song.getRecord());
		display.setUrl(song.getUrl());
		userService.getPlaylists(sessionId,
				new AsyncCallback<List<PlaylistDTO>>() {

					public void onFailure(Throwable arg0) {
						try {
							throw arg0;
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

					public void onSuccess(List<PlaylistDTO> arg0) {
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
