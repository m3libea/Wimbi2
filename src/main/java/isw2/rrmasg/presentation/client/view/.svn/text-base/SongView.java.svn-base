package isw2.rrmasg.presentation.client.view;

import java.util.List;

import isw2.rrmasg.presentation.client.presenter.SongPresenter;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;

public class SongView extends Composite implements SongPresenter.Display {

	private Button btnUser;
	private Button btnPlaylist;
	private Button btnSearchSong;
	private Button btnSearchPlaylist;
	private Button btnLogout;
	private Anchor hprlnkUrl;
	private Label lblRecord_1;
	private Label lblAuthor_1;
	private Label lblTitle_1;
	private Button btnAdd;
	private ListBox comboBox;

	private List<PlaylistDTO> playlists;
	private Button btnBack;

	public SongView() {

		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("453px", "324px");

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
		layoutPanel.setWidgetLeftWidth(btnLogout, 25.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel
				.setWidgetTopHeight(btnLogout, 287.0, Unit.PX, 24.0, Unit.PX);

		Label lblTitle = new Label("Title:");
		layoutPanel.add(lblTitle);
		layoutPanel.setWidgetLeftWidth(lblTitle, 25.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblTitle, 77.0, Unit.PX, 18.0, Unit.PX);

		Label lblAuthor = new Label("Author:");
		layoutPanel.add(lblAuthor);
		layoutPanel.setWidgetLeftWidth(lblAuthor, 25.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel
				.setWidgetTopHeight(lblAuthor, 113.0, Unit.PX, 18.0, Unit.PX);

		Label lblRecord = new Label("Record:");
		layoutPanel.add(lblRecord);
		layoutPanel.setWidgetLeftWidth(lblRecord, 25.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel
				.setWidgetTopHeight(lblRecord, 156.0, Unit.PX, 18.0, Unit.PX);

		Label lblUrl = new Label("Url:");
		layoutPanel.add(lblUrl);
		layoutPanel.setWidgetLeftWidth(lblUrl, 25.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblUrl, 193.0, Unit.PX, 18.0, Unit.PX);

		btnBack = new Button("Back");
		layoutPanel.add(btnBack);
		layoutPanel.setWidgetLeftWidth(btnBack, 25.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnBack, 238.0, Unit.PX, 24.0, Unit.PX);

		lblTitle_1 = new Label("Title");
		layoutPanel.add(lblTitle_1);
		layoutPanel.setWidgetLeftWidth(lblTitle_1, 117.0, Unit.PX, 312.0,
				Unit.PX);
		layoutPanel
				.setWidgetTopHeight(lblTitle_1, 77.0, Unit.PX, 18.0, Unit.PX);

		lblAuthor_1 = new Label("Author");
		layoutPanel.add(lblAuthor_1);
		layoutPanel.setWidgetLeftWidth(lblAuthor_1, 117.0, Unit.PX, 312.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(lblAuthor_1, 113.0, Unit.PX, 18.0,
				Unit.PX);

		lblRecord_1 = new Label("Record");
		layoutPanel.add(lblRecord_1);
		layoutPanel.setWidgetLeftWidth(lblRecord_1, 117.0, Unit.PX, 312.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(lblRecord_1, 156.0, Unit.PX, 18.0,
				Unit.PX);

		hprlnkUrl = new Anchor("Url");
		layoutPanel.add(hprlnkUrl);
		layoutPanel.setWidgetLeftWidth(hprlnkUrl, 117.0, Unit.PX, 312.0,
				Unit.PX);
		layoutPanel
				.setWidgetTopHeight(hprlnkUrl, 193.0, Unit.PX, 18.0, Unit.PX);

		Label lblAddTo = new Label("Add to:");
		layoutPanel.add(lblAddTo);
		layoutPanel.setWidgetLeftWidth(lblAddTo, 147.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblAddTo, 238.0, Unit.PX, 18.0, Unit.PX);

		comboBox = new ListBox();
		layoutPanel.add(comboBox);
		layoutPanel
				.setWidgetLeftWidth(comboBox, 234.0, Unit.PX, 195.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(comboBox, 237.0, Unit.PX, 22.0, Unit.PX);

		btnAdd = new Button("Add");
		layoutPanel.add(btnAdd);
		layoutPanel.setWidgetLeftWidth(btnAdd, 343.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnAdd, 287.0, Unit.PX, 24.0, Unit.PX);
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

	@Override
	public HasClickHandlers getLogoutButton() {
		return btnLogout;
	}

	@Override
	public void setAuthor(String author) {
		lblAuthor_1.setText(author);
	}

	@Override
	public void setRecord(String record) {
		lblRecord_1.setText(record);
	}

	@Override
	public void setUrl(String url) {
		hprlnkUrl.setText(url);
		hprlnkUrl.setHref(url);
	}

	@Override
	public void setTitle(String title) {
		lblTitle_1.setText(title);
	}

	@Override
	public HasClickHandlers getAddButton() {
		return btnAdd;
	}

	@Override
	public void setData(List<PlaylistDTO> data) {
		playlists = data;
		comboBox.clear();
		for (int i = 0; i < data.size(); ++i) {
			comboBox.insertItem(data.get(i).getName(), i);
		}
	}

	@Override
	public PlaylistDTO getClickedRow() {
		PlaylistDTO result = null;
		if (comboBox.getSelectedIndex() > -1
				&& comboBox.getSelectedIndex() < playlists.size()) {
			result = playlists.get(comboBox.getSelectedIndex());
		}
		return result;
	}

	public HasClickHandlers getBackButton() {
		return btnBack;
	}
}
