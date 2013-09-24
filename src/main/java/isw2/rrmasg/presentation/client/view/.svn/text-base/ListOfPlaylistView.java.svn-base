package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.client.presenter.ListOfPlaylistPresenter;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;

import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class ListOfPlaylistView extends Composite implements
		ListOfPlaylistPresenter.Display {

	private List<PlaylistDTO> playlists;
	private ListBox listBox;
	private Button btnCreateNewPlaylist;
	private Button btnOpenSelectedPlaylist;
	private Button btnUser;
	private Button btnSearch;
	private Button btnSearchPlaylist;

	private Button button;
	private TextBox tbPlaylistName;

	public ListOfPlaylistView() {

		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("452px", "344px");

		btnUser = new Button("User");
		layoutPanel.add(btnUser);
		layoutPanel.setWidgetLeftWidth(btnUser, 50.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnUser, 23.0, Unit.PX, 24.0, Unit.PX);

		btnSearch = new Button("Search Song");
		layoutPanel.add(btnSearch);
		layoutPanel.setWidgetLeftWidth(btnSearch, 166.0, Unit.PX, 107.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearch, 23.0, Unit.PX, 24.0, Unit.PX);

		listBox = new ListBox();
		layoutPanel.add(listBox);
		layoutPanel.setWidgetLeftWidth(listBox, 26.0, Unit.PX, 402.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(listBox, 96.0, Unit.PX, 200.0, Unit.PX);
		listBox.setVisibleItemCount(5);

		btnSearchPlaylist = new Button("Search Playlist");
		layoutPanel.add(btnSearchPlaylist);
		layoutPanel.setWidgetLeftWidth(btnSearchPlaylist, 295.0, Unit.PX,
				107.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearchPlaylist, 23.0, Unit.PX, 24.0,
				Unit.PX);

		tbPlaylistName = new TextBox();
		tbPlaylistName.setText("Playlist name");
		layoutPanel.add(tbPlaylistName);
		layoutPanel.setWidgetLeftWidth(tbPlaylistName, 29.0, Unit.PX, 239.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(tbPlaylistName, 67.0, Unit.PX, 23.0,
				Unit.PX);

		btnCreateNewPlaylist = new Button("Create New Playlist");
		layoutPanel.add(btnCreateNewPlaylist);
		layoutPanel.setWidgetLeftWidth(btnCreateNewPlaylist, 274.0, Unit.PX,
				154.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnCreateNewPlaylist, 67.0, Unit.PX,
				23.0, Unit.PX);

		btnOpenSelectedPlaylist = new Button("Open Selected Playlist");
		layoutPanel.add(btnOpenSelectedPlaylist);
		layoutPanel.setWidgetLeftWidth(btnOpenSelectedPlaylist, 252.0, Unit.PX,
				176.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnOpenSelectedPlaylist, 302.0, Unit.PX,
				24.0, Unit.PX);
		
		button = new Button("Logout");
		layoutPanel.add(button);
		layoutPanel.setWidgetLeftWidth(button, 26.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(button, 302.0, Unit.PX, 24.0, Unit.PX);
	}

	public void setData(List<PlaylistDTO> data) {
		playlists = data;
		listBox.clear();
		for (int i = 0; i < data.size(); ++i) {
			listBox.insertItem(data.get(i).getName(), i);
		}
	}

	public PlaylistDTO getClickedRow() {
		PlaylistDTO result = null;
		if(listBox.getSelectedIndex() > -1 && listBox.getSelectedIndex() < playlists.size()){
			result = playlists.get(listBox.getSelectedIndex());
		}
		return result;
	}

	public HasValue<String> getPlaylistName() {
		return tbPlaylistName;
	}

	public HasClickHandlers getNewPlaylistButton() {
		return btnCreateNewPlaylist;
	}

	public void addData(PlaylistDTO playlist) {
		playlists.add(playlist);
		listBox.insertItem(playlist.getName(), playlists.size() - 1);
	}
	
	public HasClickHandlers getOpenSelectedPlaylistButton() {
		return btnOpenSelectedPlaylist;
	}

	public HasClickHandlers getGoToEditUserButton() {
		return btnUser;
	}

	public HasClickHandlers getGoToSearchSongButton() {
		return btnSearch;
	}

	public HasClickHandlers getGoToSearchPlaylistButton() {
		return btnSearchPlaylist;
	}

	public HasClickHandlers getLogoutButton() {
		return button;
	}
	
	
}
