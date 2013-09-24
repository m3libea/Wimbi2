package isw2.rrmasg.presentation.client.view;

import java.util.List;

import isw2.rrmasg.presentation.client.presenter.SearchSongPresenter;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;

public class SearchSongView extends Composite implements
		SearchSongPresenter.Display {

	private List<SongDTO> songs;
	private Button btnUser;
	private Button btnPlaylist;
	private Button btnSearchPlaylist;
	private Button btnSearch;
	private Button btnLogout;
	private ListBox listBox;
	private TextBox tbSearch;
	private Button button_1;
	private Button button_2;
	private Label lblSearchSong;
	private Button button;

	public SearchSongView() {

		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("453px", "385px");

		btnUser = new Button("User");
		layoutPanel.add(btnUser);
		layoutPanel.setWidgetLeftWidth(btnUser, 70.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnUser, 23.0, Unit.PX, 24.0, Unit.PX);

		btnPlaylist = new Button("Playlist");
		layoutPanel.add(btnPlaylist);
		layoutPanel.setWidgetLeftWidth(btnPlaylist, 176.0, Unit.PX, 86.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(btnPlaylist, 23.0, Unit.PX, 24.0,
				Unit.PX);

		btnSearch = new Button("Search");
		layoutPanel.add(btnSearch);
		layoutPanel
				.setWidgetLeftWidth(btnSearch, 339.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearch, 68.0, Unit.PX, 24.0, Unit.PX);

		tbSearch = new TextBox();
		layoutPanel.add(tbSearch);
		layoutPanel
				.setWidgetLeftWidth(tbSearch, 140.0, Unit.PX, 193.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbSearch, 68.0, Unit.PX, 24.0, Unit.PX);

		listBox = new ListBox();
		layoutPanel.add(listBox);
		layoutPanel.setWidgetLeftWidth(listBox, 31.0, Unit.PX, 394.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(listBox, 104.0, Unit.PX, 175.0, Unit.PX);
		listBox.setVisibleItemCount(5);

		btnSearchPlaylist = new Button("Search Playlist");
		layoutPanel.add(btnSearchPlaylist);
		layoutPanel.setWidgetLeftWidth(btnSearchPlaylist, 282.0, Unit.PX,
				107.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearchPlaylist, 23.0, Unit.PX, 24.0,
				Unit.PX);

		btnLogout = new Button("Logout");
		layoutPanel.add(btnLogout);
		layoutPanel.setWidgetLeftWidth(btnLogout, 31.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel
				.setWidgetTopHeight(btnLogout, 327.0, Unit.PX, 24.0, Unit.PX);

		button = new Button("<<");
		layoutPanel.add(button);
		layoutPanel.setWidgetLeftWidth(button, 31.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(button, 285.0, Unit.PX, 24.0, Unit.PX);

		button_1 = new Button(">>");
		layoutPanel.add(button_1);
		layoutPanel.setWidgetLeftWidth(button_1, 339.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(button_1, 285.0, Unit.PX, 24.0, Unit.PX);

		button_2 = new Button("Open Selected Playlist");
		layoutPanel.add(button_2);
		layoutPanel
				.setWidgetLeftWidth(button_2, 287.0, Unit.PX, 138.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(button_2, 327.0, Unit.PX, 24.0, Unit.PX);

		lblSearchSong = new Label("Search song:");
		layoutPanel.add(lblSearchSong);
		layoutPanel.setWidgetLeftWidth(lblSearchSong, 31.0, Unit.PX, 91.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(lblSearchSong, 70.0, Unit.PX, 18.0,
				Unit.PX);
	}

	@Override
	public HasClickHandlers getUserButton() {
		return btnUser;
	}

	@Override
	public HasClickHandlers getPlaylistButton() {
		return btnPlaylist;
	}

	@Override
	public HasClickHandlers getSearchPlaylistButton() {
		return btnSearchPlaylist;
	}

	@Override
	public HasClickHandlers getSearchButton() {
		return btnSearch;
	}

	@Override
	public HasClickHandlers getLogoutButton() {
		return btnLogout;
	}

	@Override
	public HasValue<String> getSearch() {
		return tbSearch;
	}

	@Override
	public void setData(List<SongDTO> data) {
		songs = data;
		listBox.clear();
		for (int i = 0; i < data.size(); ++i) {
			listBox.insertItem(data.get(i).getTitle(), i);
		}
	}

	public SongDTO getClickedRow() {
		SongDTO result = null;
		if (listBox.getSelectedIndex() > -1
				&& listBox.getSelectedIndex() < songs.size()) {
			result = songs.get(listBox.getSelectedIndex());
		}
		return result;
	}

	public void setSearch(String value) {
		tbSearch.setText(value);
	}

	public HasClickHandlers getBtnPrevious() {
		return button;
	}

	public HasClickHandlers getBtnNext() {
		return button_1;
	}

	public HasClickHandlers getOpenSelectedSongButton() {
		return button_2;
	}
}
