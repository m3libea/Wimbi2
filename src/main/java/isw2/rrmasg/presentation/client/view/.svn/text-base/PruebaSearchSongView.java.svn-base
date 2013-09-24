package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.shared.dtos.SongDTO;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.SingleSelectionModel;

public class PruebaSearchSongView extends Composite {

	private PruebaListOfSongView songView;
	private TextBox txtbxSearchToken;
	private Button btnSearch;
	private Button btnPrevious;
	private Button btnNext;

	public PruebaSearchSongView() {

		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("fpSearchSong");
		initWidget(flowPanel);

		FlowPanel fpTitleBar = new FlowPanel();
		fpTitleBar.setStyleName("fpSearchTitle");
		flowPanel.add(fpTitleBar);
		btnSearch = new Button("Buscar");
		btnSearch.setStyleName("button positive");
		btnSearch.setStyleName("btSearch", true);
		txtbxSearchToken = new TextBox();
		txtbxSearchToken.setStyleName("txtSearch", true);
		txtbxSearchToken.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent arg0) {
				if (arg0.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					btnSearch.click();
				}
			}
		});
		fpTitleBar.add(txtbxSearchToken);
		fpTitleBar.add(btnSearch);

		btnNext = new Button("Siguientes");
		btnNext.setStyleName("button btNext");

		btnPrevious = new Button("Anteriores");
		btnPrevious.setStyleName("button btPrevious");
		fpTitleBar.add(btnPrevious);
		fpTitleBar.add(btnNext);


		FlowPanel fpSongs = new FlowPanel();
		fpSongs.setStyleName("fpPlaylistSongs");
		flowPanel.add(fpSongs);

		songView = new PruebaListOfSongView();
		fpSongs.add(songView);
	}

	public void setSearchSongs(List<SongDTO> data) {
		songView.setSongs(data);
	}

	public HasValue<String> getSearchToken() {
		return txtbxSearchToken;
	}

	public HasClickHandlers getSearchButton() {
		return btnSearch;
	}

	public HasClickHandlers getPreviousButton() {
		return btnPrevious;
	}

	public HasClickHandlers getNextButton() {
		return btnNext;
	}

	public SingleSelectionModel<SongDTO> getSongSelectionModel() {
		return songView.getSelectionModel();
	}

	public int getSongIndex(SongDTO song) {
		return songView.getSongIndex(song);
	}

	public void setEnabledNextButton(boolean b) {
		btnNext.setEnabled(b);
	}

	public void setEnabledPrevoiusButton(boolean b) {
		btnPrevious.setEnabled(b);
	}

}
