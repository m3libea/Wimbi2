package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.client.presenter.SearchPlaylistPresenter;
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
import com.google.gwt.user.client.ui.Label;

public class SearchPlaylistView extends Composite implements SearchPlaylistPresenter.Display{
	
	private List<PlaylistDTO> playlist;
	private Button btnUser;
	private Button btnPlaylist;
	private Button btnSearchSong;
	private Button btnSearch;
	private Button btnLogout;
	private ListBox listBox;
	private TextBox tbSearch;
	private Button btnOpenSelectedPlaylist;
	private Button btnPrevious;
	private Button btnNext;
	public SearchPlaylistView() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("450px", "381px");
		
		btnUser = new Button("User");
		layoutPanel.add(btnUser);
		layoutPanel.setWidgetLeftWidth(btnUser, 65.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnUser, 21.0, Unit.PX, 24.0, Unit.PX);
		
		btnPlaylist = new Button("Playlist");
		layoutPanel.add(btnPlaylist);
		layoutPanel.setWidgetLeftWidth(btnPlaylist, 171.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnPlaylist, 21.0, Unit.PX, 24.0, Unit.PX);
		
		btnSearch = new Button("Search");
		layoutPanel.add(btnSearch);
		layoutPanel.setWidgetLeftWidth(btnSearch, 334.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearch, 66.0, Unit.PX, 24.0, Unit.PX);
		
		tbSearch = new TextBox();
		layoutPanel.add(tbSearch);
		layoutPanel.setWidgetLeftWidth(tbSearch, 123.0, Unit.PX, 205.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbSearch, 66.0, Unit.PX, 24.0, Unit.PX);
		
		listBox = new ListBox();
		listBox.setVisibleItemCount(5);
		layoutPanel.add(listBox);
		layoutPanel.setWidgetLeftWidth(listBox, 26.0, Unit.PX, 394.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(listBox, 102.0, Unit.PX, 175.0, Unit.PX);
		
		btnSearchSong = new Button("Search Song");
		layoutPanel.add(btnSearchSong);
		layoutPanel.setWidgetLeftWidth(btnSearchSong, 282.0, Unit.PX, 107.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearchSong, 21.0, Unit.PX, 24.0, Unit.PX);
		
		btnLogout = new Button("Logout");
		layoutPanel.add(btnLogout);
		layoutPanel.setWidgetLeftWidth(btnLogout, 26.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnLogout, 326.0, Unit.PX, 24.0, Unit.PX);
		
		btnOpenSelectedPlaylist = new Button("Open Selected Playlist");
		layoutPanel.add(btnOpenSelectedPlaylist);
		layoutPanel.setWidgetLeftWidth(btnOpenSelectedPlaylist, 282.0, Unit.PX, 138.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnOpenSelectedPlaylist, 326.0, Unit.PX, 24.0, Unit.PX);
		
		btnNext = new Button(">>");
		layoutPanel.add(btnNext);
		layoutPanel.setWidgetLeftWidth(btnNext, 334.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnNext, 283.0, Unit.PX, 24.0, Unit.PX);
		
		btnPrevious = new Button("<<");
		layoutPanel.add(btnPrevious);
		layoutPanel.setWidgetLeftWidth(btnPrevious, 26.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnPrevious, 283.0, Unit.PX, 24.0, Unit.PX);
		
		Label lblSearchPlaylist = new Label("Search playlist:");
		layoutPanel.add(lblSearchPlaylist);
		layoutPanel.setWidgetLeftWidth(lblSearchPlaylist, 26.0, Unit.PX, 91.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblSearchPlaylist, 69.0, Unit.PX, 18.0, Unit.PX);
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
	public void setData(List<PlaylistDTO> data) {
		playlist = data;
		listBox.clear();
		for(int i = 0; i < data.size(); ++i){
			listBox.insertItem(data.get(i).getName(), i);
		}			
	}
	public PlaylistDTO getClickedRow() {		
		PlaylistDTO result = null;
		if(listBox.getSelectedIndex() > -1 && listBox.getSelectedIndex() < playlist.size()){
			result = playlist.get(listBox.getSelectedIndex());
		}
		return result;
	}
	@Override
	public HasClickHandlers getOpenSelectedPlaylistButton() {
		return btnOpenSelectedPlaylist;
	}
	@Override
	public void setSearch(String value) {
		tbSearch.setText(value);
	}
	public HasClickHandlers getBtnPrevious() {
		return btnPrevious;
	}
	public HasClickHandlers getBtnNext() {
		return btnNext;
	}
}
