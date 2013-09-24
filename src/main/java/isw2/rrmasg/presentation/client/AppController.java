package isw2.rrmasg.presentation.client;

import isw2.rrmasg.presentation.client.event.GoBackEvent;
import isw2.rrmasg.presentation.client.event.GoBackEventHandler;
import isw2.rrmasg.presentation.client.event.GoToCreateNewUserEvent;
import isw2.rrmasg.presentation.client.event.GoToCreateNewUserEventHandler;
import isw2.rrmasg.presentation.client.event.GoToEditUserEvent;
import isw2.rrmasg.presentation.client.event.GoToEditUserEventHandler;
import isw2.rrmasg.presentation.client.event.GoToListOfPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToListOfPlaylistEventHandler;
import isw2.rrmasg.presentation.client.event.GoToLoginEvent;
import isw2.rrmasg.presentation.client.event.GoToLoginEventHandler;
import isw2.rrmasg.presentation.client.event.GoToPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToPlaylistEventHandler;
import isw2.rrmasg.presentation.client.event.GoToSearchPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchPlaylistEventHandler;
import isw2.rrmasg.presentation.client.event.GoToSearchSongEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchSongEventHandler;
import isw2.rrmasg.presentation.client.event.GoToSongEvent;
import isw2.rrmasg.presentation.client.event.GoToSongEventHandler;
import isw2.rrmasg.presentation.client.event.GoToStartEvent;
import isw2.rrmasg.presentation.client.event.GoToStartEventHandler;
import isw2.rrmasg.presentation.client.event.LoginEvent;
import isw2.rrmasg.presentation.client.event.LoginEventHandler;
import isw2.rrmasg.presentation.client.event.LogoutEvent;
import isw2.rrmasg.presentation.client.event.LogoutEventHandler;
import isw2.rrmasg.presentation.client.event.PerformSearchPlaylistEvent;
import isw2.rrmasg.presentation.client.event.PerformSearchPlaylistEventHandler;
import isw2.rrmasg.presentation.client.event.PerformSearchSongEvent;
import isw2.rrmasg.presentation.client.event.PerformSearchSongEventHandler;
import isw2.rrmasg.presentation.client.presenter.EditUserPresenter;
import isw2.rrmasg.presentation.client.presenter.ListOfPlaylistPresenter;
import isw2.rrmasg.presentation.client.presenter.LoginPresenter;
import isw2.rrmasg.presentation.client.presenter.NewUserPresenter;
import isw2.rrmasg.presentation.client.presenter.PlaylistPresenter;
import isw2.rrmasg.presentation.client.presenter.Presenter;
import isw2.rrmasg.presentation.client.presenter.PruebaPresenter;
import isw2.rrmasg.presentation.client.presenter.SearchPlaylistPresenter;
import isw2.rrmasg.presentation.client.presenter.SearchSongPresenter;
import isw2.rrmasg.presentation.client.presenter.SongPresenter;
import isw2.rrmasg.presentation.client.services.PlaylistServiceAsync;
import isw2.rrmasg.presentation.client.services.SongServiceAsync;
import isw2.rrmasg.presentation.client.services.UserServiceAsync;
import isw2.rrmasg.presentation.client.view.EditUserView;
import isw2.rrmasg.presentation.client.view.ListOfPlaylistView;
import isw2.rrmasg.presentation.client.view.LoginView;
import isw2.rrmasg.presentation.client.view.NewUserView;
import isw2.rrmasg.presentation.client.view.PlaylistView;
import isw2.rrmasg.presentation.client.view.PruebaView;
import isw2.rrmasg.presentation.client.view.SearchPlaylistView;
import isw2.rrmasg.presentation.client.view.SearchSongView;
import isw2.rrmasg.presentation.client.view.SongView;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final UserServiceAsync userService;
	private final PlaylistServiceAsync playlistService;
	private final SongServiceAsync songService;
	private HasWidgets container;
	//private UserDTO loggedUser;
	private PlaylistDTO actualPlaylist;
	private SongDTO actualSong;
	private String actualSearchPLToken;
	private int actualSearchPLFirstResult;
	private int actualSearchPLMaxResults;
	private String actualSearchSToken;
	private int actualSearchSFirstResult;
	private int actualSearchSMaxResults;
	//private String sessionId;

	public AppController(HandlerManager eventBus, UserServiceAsync userService,
			PlaylistServiceAsync playlistService, SongServiceAsync songService) {
		this.eventBus = eventBus;
		this.userService = userService;
		this.playlistService = playlistService;
		this.songService = songService;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(GoToCreateNewUserEvent.TYPE,
				new GoToCreateNewUserEventHandler() {
					public void onGoToCreateNewUser(GoToCreateNewUserEvent event) {
						doGoToAddUser();
					}
				});

		eventBus.addHandler(GoToListOfPlaylistEvent.TYPE,
				new GoToListOfPlaylistEventHandler() {
					public void onLoginUser(GoToListOfPlaylistEvent event) {
						doGoToListOfPlaylist();
					}
				});

		eventBus.addHandler(GoToLoginEvent.TYPE, new GoToLoginEventHandler() {
			public void onGoToLogin(GoToLoginEvent event) {
				doGoToLogin();
			}
		});

		eventBus.addHandler(GoToEditUserEvent.TYPE,
				new GoToEditUserEventHandler() {
					public void onGoToEditUser(GoToEditUserEvent event) {
						doGoToEditUser();
					}
				});

		eventBus.addHandler(GoToSearchSongEvent.TYPE,
				new GoToSearchSongEventHandler() {
					public void onGoToSearchSong(GoToSearchSongEvent event) {
						doGoToSearchSong();
					}
				});

		eventBus.addHandler(GoToSearchPlaylistEvent.TYPE,
				new GoToSearchPlaylistEventHandler() {
					public void onGoToSearchPlaylist(
							GoToSearchPlaylistEvent event) {
						doGoToSearchPlaylist();
					}
				});

		eventBus.addHandler(GoToPlaylistEvent.TYPE,
				new GoToPlaylistEventHandler() {
					public void onGoToPlaylist(GoToPlaylistEvent event) {
						actualPlaylist = event.getPlaylist();
						doGoToPlaylist();
					}
				});

		eventBus.addHandler(GoToSongEvent.TYPE, new GoToSongEventHandler() {
			public void onGoToSong(GoToSongEvent event) {
				actualSong = event.getSong();
				doGoToSong();
			}
		});

		eventBus.addHandler(GoBackEvent.TYPE, new GoBackEventHandler() {
			public void onGoBack(GoBackEvent event) {
				doGoBack();
			}
		});

		eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
			public void onLogin(LoginEvent event) {
				//loggedUser = event.getUser();
				//sessionId = event.getSessionId();
				doGoToApplication();
			}
		});

		eventBus.addHandler(LogoutEvent.TYPE, new LogoutEventHandler() {
			public void onLogout(LogoutEvent event) {
				userService.logoutUser(new AsyncCallback<Void>() {
					public void onFailure(Throwable caught) {
					}

					public void onSuccess(Void result) {
						Cookies.removeCookie("sid");
						//loggedUser = null;
						actualSong = null;
						actualPlaylist = null;
						actualSearchPLToken = null;
						actualSearchSToken = null;
						History.newItem("login");
					}
				});
			}
		});

		eventBus.addHandler(PerformSearchPlaylistEvent.TYPE,
				new PerformSearchPlaylistEventHandler() {
					public void onPerformSearchPlaylist(
							PerformSearchPlaylistEvent event) {
						actualSearchPLToken = event.getSearchPLToken();
						actualSearchPLFirstResult = event
								.getSearchPLFirstResult();
						actualSearchPLMaxResults = event.getSearchPLMaxResult();
						History.newItem("searchPlaylist?token="
								+ actualSearchPLToken + "&start="
								+ actualSearchPLFirstResult, false);
					}
				});

		eventBus.addHandler(PerformSearchSongEvent.TYPE,
				new PerformSearchSongEventHandler() {
					public void onPerformSearchSong(PerformSearchSongEvent event) {
						actualSearchSToken = event.getSearchSToken();
						actualSearchSFirstResult = event
								.getSearchSFirstResult();
						actualSearchSMaxResults = event.getSearchSMaxResult();
						History.newItem("searchSong?token="
								+ actualSearchSToken + "&start="
								+ actualSearchSFirstResult, false);
					}
				});

		eventBus.addHandler(GoToStartEvent.TYPE, new GoToStartEventHandler() {
			public void onGoToStart(GoToStartEvent event) {
				doGoToStart();
			}
		});
	}
	
	protected void doGoToApplication() {
		History.newItem("app");
	}

	protected void doGoToStart() {
		History.newItem("");
	}

	protected void doGoToLogin() {
		History.newItem("login");
	}

	protected void doGoToAddUser() {
		History.newItem("newuser");
	}

	protected void doGoToListOfPlaylist() {
		History.newItem("playlists");
	}

	protected void doGoToEditUser() {
		History.newItem("edituser");
	}

	protected void doGoToSearchSong() {
		History.newItem("searchsong");
	}

	protected void doGoToSearchPlaylist() {
		History.newItem("searchplaylist");
	}

	protected void doGoToPlaylist() {
		History.newItem("playlist?id=" + actualPlaylist.getUniqueID());
	}

	protected void doGoToSong() {
		History.newItem("song?id=" + actualSong.getUniqueID());
	}

	protected void doGoBack() {
		History.back();
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("login")) {
				presenter = new LoginPresenter(userService, eventBus,
						new LoginView());
			} else if (token.equals("newuser")) {
				presenter = new NewUserPresenter(userService, eventBus,
						new NewUserView());
			} else if (token.equals("playlists")) {
				presenter = new ListOfPlaylistPresenter(userService,
						playlistService, eventBus, new ListOfPlaylistView());
			} else if (token.equals("edituser")) {
				presenter = new EditUserPresenter(userService, eventBus,
						new EditUserView());
			} else if (token.startsWith("searchsong")) {
				String PToken = RegExp.compile("token=([^&]*)").exec(token)
						.getGroup(1);
				String PStart = RegExp.compile("start=([^&]*)").exec(token)
						.getGroup(1);
				String PMax = RegExp.compile("max=([^&]*)").exec(token)
						.getGroup(1);

				if (PToken != null && !"".equals(PToken)) {
					actualSearchSToken = PToken;
					if (PStart != null && !"".equals(PStart)) {
						actualSearchSFirstResult = Integer.parseInt(PStart);
					} else {
						actualSearchSFirstResult = 0;
					}
					if (PMax != null && !"".equals(PMax)) {
						actualSearchSMaxResults = Integer.parseInt(PMax);
					} else {
						actualSearchSMaxResults = 10;
					}
				}
				presenter = new SearchSongPresenter(songService, eventBus,
						new SearchSongView(), actualSearchSToken,
						actualSearchSFirstResult, actualSearchSMaxResults);
			} else if (token.startsWith("searchplaylist")) {
				String PToken = RegExp.compile("token=([^&]*)").exec(token)
						.getGroup(1);
				String PStart = RegExp.compile("start=([^&]*)").exec(token)
						.getGroup(1);
				String PMax = RegExp.compile("max=([^&]*)").exec(token)
						.getGroup(1);

				if (PToken != null && !"".equals(PToken)) {
					actualSearchPLToken = PToken;
					if (PStart != null && !"".equals(PStart)) {
						actualSearchPLFirstResult = Integer.parseInt(PStart);
					} else {
						actualSearchPLFirstResult = 0;
					}
					if (PMax != null && !"".equals(PMax)) {
						actualSearchPLMaxResults = Integer.parseInt(PMax);
					} else {
						actualSearchPLMaxResults = 10;
					}
				}
				presenter = new SearchPlaylistPresenter(playlistService,
						eventBus, new SearchPlaylistView(),
						actualSearchPLToken, actualSearchPLFirstResult,
						actualSearchPLMaxResults);
			} else if (token.startsWith("playlist")) {
				if (actualPlaylist != null
						&& token.substring(12).equals(
								actualPlaylist.getUniqueID())) {
					presenter = new PlaylistPresenter(playlistService,
							userService, eventBus, new PlaylistView(),
							actualPlaylist);
				} else {
					presenter = new PlaylistPresenter(playlistService,
							userService, eventBus, new PlaylistView(),
							token.substring(12));
				}
			} else if (token.startsWith("song")) {
				if (actualSong != null
						&& token.substring(8).equals(actualSong.getUniqueID())) {
					presenter = new SongPresenter(userService, playlistService,
							songService, eventBus, new SongView(), actualSong);
				} else {
					presenter = new SongPresenter(userService, playlistService,
							songService, eventBus, new SongView(),
							token.substring(8));
				}
			} else if (token.startsWith("loginTwitter")){
				String sid = token.substring(17);
				Cookies.setCookie("tmpsid", sid);
				doGoToApplication();
			} else if (token.equals("app")){
				presenter = new PruebaPresenter(userService, playlistService, songService, eventBus, new PruebaView());
			}

			if (presenter != null) {
				presenter.go(container);
			}
		}
	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			userService.userIsLogged(Cookies.getCookie("sid"), new AsyncCallback<Boolean>() {
				public void onFailure(Throwable caught) {
					History.newItem("login");
				}

				public void onSuccess(Boolean result) {
					if (result) {
						Cookies.setCookie("tmpsid", Cookies.getCookie("sid"));
						History.newItem("playlists");
					} else {
						History.newItem("login");
					}
				}
			});
		} else {
			History.fireCurrentHistoryState();
		}
	}

}
