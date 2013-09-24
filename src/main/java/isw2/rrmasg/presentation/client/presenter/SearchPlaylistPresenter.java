package isw2.rrmasg.presentation.client.presenter;

import isw2.rrmasg.presentation.client.event.GoToEditUserEvent;
import isw2.rrmasg.presentation.client.event.GoToListOfPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchSongEvent;
import isw2.rrmasg.presentation.client.event.LogoutEvent;
import isw2.rrmasg.presentation.client.event.PerformSearchPlaylistEvent;
import isw2.rrmasg.presentation.client.services.PlaylistServiceAsync;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class SearchPlaylistPresenter implements Presenter {

	public interface Display {

		HasClickHandlers getUserButton();

		HasClickHandlers getPlaylistButton();

		HasClickHandlers getSearchSongButton();

		HasClickHandlers getSearchButton();

		HasClickHandlers getLogoutButton();

		HasClickHandlers getOpenSelectedPlaylistButton();

		HasClickHandlers getBtnPrevious();

		HasClickHandlers getBtnNext();

		HasValue<String> getSearch();

		void setSearch(String value);

		void setData(List<PlaylistDTO> data);

		PlaylistDTO getClickedRow();

		Widget asWidget();
	}

	private PlaylistServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private String token;
	private int firstResult;
	private int maxResults;
	private boolean thereIsMore;

	public SearchPlaylistPresenter(PlaylistServiceAsync rpcService,
			HandlerManager eventBus, Display display, String token,
			int firstResult, int maxResults) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.token = token;
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

	public void bind() {
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

		display.getSearchButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				token = display.getSearch().getValue();
				firstResult = 0;
				maxResults = 10;
				updateResults();
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
		if (token != null && maxResults > 1) {
			display.setSearch(token);
			updateResults();
		}

		display.getBtnNext().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				if (thereIsMore) {
					firstResult += 10;
					updateResults();
				}
			}
		});

		display.getBtnPrevious().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				firstResult -= 10;
				if (firstResult < 0) {
					firstResult = 0;
				}
				updateResults();
			}
		});

	}

	public void updateResults() {
		rpcService.searchPlaylists(token, firstResult, maxResults,
				new AsyncCallback<List<PlaylistDTO>>() {
					public void onFailure(Throwable arg0) {
						try {
							throw arg0;
						} catch (IllegalArgumentException e) {
							Window.alert("Es necesario que introduzca todos los datos.");
						} catch (Throwable e) {
							Window.alert("No se ha podido completar la operaci\u00f3n.");
						}
					}

					public void onSuccess(List<PlaylistDTO> arg0) {
						display.setData(arg0);
						eventBus.fireEvent(new PerformSearchPlaylistEvent(
								token, firstResult, maxResults));
						thereIsMore = arg0.size() == maxResults;
					}
				});
	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

}
