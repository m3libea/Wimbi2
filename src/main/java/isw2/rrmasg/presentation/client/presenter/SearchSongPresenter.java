package isw2.rrmasg.presentation.client.presenter;

import isw2.rrmasg.presentation.client.event.GoToEditUserEvent;
import isw2.rrmasg.presentation.client.event.GoToListOfPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSongEvent;
import isw2.rrmasg.presentation.client.event.LogoutEvent;
import isw2.rrmasg.presentation.client.event.PerformSearchSongEvent;
import isw2.rrmasg.presentation.client.services.SongServiceAsync;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;

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

public class SearchSongPresenter implements Presenter {

	public interface Display {

		HasClickHandlers getUserButton();

		HasClickHandlers getPlaylistButton();

		HasClickHandlers getSearchPlaylistButton();

		HasClickHandlers getSearchButton();

		HasClickHandlers getLogoutButton();

		HasValue<String> getSearch();

		void setData(List<SongDTO> data);

		SongDTO getClickedRow();

		void setSearch(String value);

		HasClickHandlers getBtnPrevious();

		HasClickHandlers getBtnNext();

		HasClickHandlers getOpenSelectedSongButton();

		Widget asWidget();
	}

	private SongServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private String token;
	private int firstResult;
	private int maxResults;
	private boolean thereIsMore;

	public SearchSongPresenter(SongServiceAsync rpcService,
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

		display.getSearchPlaylistButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToSearchPlaylistEvent());
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
		
		display.getOpenSelectedSongButton().addClickHandler(
				new ClickHandler() {
					public void onClick(ClickEvent arg0) {
						SongDTO s = display.getClickedRow();
						if (s != null) {
							eventBus.fireEvent(new GoToSongEvent(s));
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
		rpcService.searchSongs(token, firstResult, maxResults,
				new AsyncCallback<List<SongDTO>>() {
					public void onFailure(Throwable arg0) {
						try {
							throw arg0;
						} catch (IllegalArgumentException e) {
							Window.alert("Es necesario que introduzca todos los datos.");
						} catch (Throwable e) {
							Window.alert("No se ha podido completar la operaci\u00f3n.");
						}
					}

					public void onSuccess(List<SongDTO> arg0) {
						display.setData(arg0);
						eventBus.fireEvent(new PerformSearchSongEvent(
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
