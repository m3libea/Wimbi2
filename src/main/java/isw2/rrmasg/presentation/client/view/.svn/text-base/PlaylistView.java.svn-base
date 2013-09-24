package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.client.presenter.PlaylistPresenter;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;

import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PlaylistView extends Composite implements
		PlaylistPresenter.Display {

	private List<SongDTO> songs;
	private Button btnUser;
	private Button btnPlaylist;
	private Button btnSearchSong;
	private Button btnSearchPlaylist;
	private ListBox listBox;
	private Widget lblName;
	private Button btnLogout;
	private Button button;
	private Label lblUserName;
	private Button btnChangeName;
	private LayoutPanel layoutPanel;
	private Button btnBack;

	public PlaylistView() {

		layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("453px", "412px");

		btnUser = new Button("User");
		layoutPanel.add(btnUser);
		layoutPanel.setWidgetLeftWidth(btnUser, 25.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnUser, 20.0, Unit.PX, 24.0, Unit.PX);

		btnPlaylist = new Button("Playlist");
		layoutPanel.add(btnPlaylist);
		layoutPanel.setWidgetLeftWidth(btnPlaylist, 117.0, Unit.PX, 86.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(btnPlaylist, 20.0, Unit.PX, 24.0,
				Unit.PX);

		lblName = new Label("Name");
		layoutPanel.add(lblName);
		layoutPanel.setWidgetLeftWidth(lblName, 117.0, Unit.PX, 201.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblName, 69.0, Unit.PX, 18.0, Unit.PX);

		listBox = new ListBox();
		layoutPanel.add(listBox);
		layoutPanel.setWidgetLeftWidth(listBox, 45.0, Unit.PX, 365.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(listBox, 146.0, Unit.PX, 172.0, Unit.PX);
		listBox.setVisibleItemCount(5);

		btnSearchSong = new Button("Search Song");
		layoutPanel.add(btnSearchSong);
		layoutPanel.setWidgetLeftWidth(btnSearchSong, 209.0, Unit.PX, 107.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearchSong, 20.0, Unit.PX, 24.0,
				Unit.PX);

		btnSearchPlaylist = new Button("Search Playlist");
		layoutPanel.add(btnSearchPlaylist);
		layoutPanel.setWidgetLeftWidth(btnSearchPlaylist, 322.0, Unit.PX,
				107.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearchPlaylist, 20.0, Unit.PX, 24.0,
				Unit.PX);

		btnLogout = new Button("Logout");
		layoutPanel.add(btnLogout);
		layoutPanel.setWidgetLeftWidth(btnLogout, 24.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel
				.setWidgetTopHeight(btnLogout, 380.0, Unit.PX, 24.0, Unit.PX);

		button = new Button("Open Selected Song");
		layoutPanel.add(button);
		layoutPanel.setWidgetLeftWidth(button, 234.0, Unit.PX, 176.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(button, 380.0, Unit.PX, 24.0, Unit.PX);

		Label lblPlaylist = new Label("Playlist:");
		layoutPanel.add(lblPlaylist);
		layoutPanel.setWidgetLeftWidth(lblPlaylist, 55.0, Unit.PX, 56.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(lblPlaylist, 69.0, Unit.PX, 18.0,
				Unit.PX);

		Label lblUser = new Label("User:");
		layoutPanel.add(lblUser);
		layoutPanel.setWidgetLeftWidth(lblUser, 55.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblUser, 98.0, Unit.PX, 18.0, Unit.PX);

		lblUserName = new Label("User name");
		layoutPanel.add(lblUserName);
		layoutPanel.setWidgetLeftWidth(lblUserName, 117.0, Unit.PX, 293.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(lblUserName, 98.0, Unit.PX, 18.0,
				Unit.PX);

		btnChangeName = new Button("Change name");
		btnChangeName.setVisible(false);
		layoutPanel.add(btnChangeName);
		layoutPanel.setWidgetLeftWidth(btnChangeName, 324.0, Unit.PX, 107.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(btnChangeName, 66.0, Unit.PX, 24.0,
				Unit.PX);
		
		btnBack = new Button("Back");
		layoutPanel.add(btnBack);
		layoutPanel.setWidgetLeftWidth(btnBack, 25.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnBack, 336.0, Unit.PX, 24.0, Unit.PX);
	}

	@Override
	public void setData(List<SongDTO> data) {
		songs = data;
		listBox.clear();
		for (int i = 0; i < data.size(); ++i) {
			listBox.insertItem(data.get(i).getTitle() + " - "
					+ data.get(i).getAuthor(), i);
		}
	}

	@Override
	public SongDTO getClickedRow() {
		SongDTO result = null;
		if (listBox.getSelectedIndex() > -1
				&& listBox.getSelectedIndex() < songs.size()) {
			result = songs.get(listBox.getSelectedIndex());
		}
		return result;
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
	public HasClickHandlers getSearchSongButton() {
		return btnSearchSong;
	}

	@Override
	public HasClickHandlers getSearchPlaylistButton() {
		return btnSearchPlaylist;
	}

	public HasClickHandlers getOpenSelectedSongButton() {
		return button;
	}

	@Override
	public HasClickHandlers getLogoutButton() {
		return btnLogout;
	}

	@Override
	public void setName(String name) {
		((HasText) lblName).setText(name);
	}

	@Override
	public void setUser(String userName) {
		lblUserName.setText(userName);
	}

	@Override
	public HasClickHandlers getChangeNameButton() {
		return btnChangeName;
	}

	@Override
	public void userIsLogged() {
		btnChangeName.setVisible(true);

		layoutPanel.remove(lblName);
		lblName = new TextBox();
		layoutPanel.add(lblName);
		layoutPanel.setWidgetLeftWidth(lblName, 117.0, Unit.PX, 201.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblName, 69.0, Unit.PX, 25.0, Unit.PX);

	}

	@SuppressWarnings("unchecked")
	@Override
	public HasValue<String> getName() {
		return (HasValue<String>)lblName;
	}

	@Override
	public HasClickHandlers getBackButton() {
		return btnBack;
	}
}
