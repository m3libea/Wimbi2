package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.client.presenter.EditUserPresenter;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class EditUserView extends Composite implements EditUserPresenter.Display {
	private Button btnPlaylists;
	private Button btnSearchSong;
	private Button btnSearchPlaylist;
	private Button btnCancel;
	private Button btnConfirm;
	private TextBox tbName;
	private TextBox tbSurname;
	private TextBox tbEmail;
	private TextBox tbCity;
	private TextBox tbCountry;
	private TextBox tbPassword;
	private TextBox tbNPassword;
	private TextBox tbRNPassword;
	private Button btnLogout;
	public EditUserView() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("446px", "406px");
		
		btnPlaylists = new Button("PlayLists");
		layoutPanel.add(btnPlaylists);
		layoutPanel.setWidgetLeftWidth(btnPlaylists, 61.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnPlaylists, 18.0, Unit.PX, 24.0, Unit.PX);
		
		Label lblName = new Label("Name");
		layoutPanel.add(lblName);
		layoutPanel.setWidgetLeftWidth(lblName, 89.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblName, 56.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblEmail = new Label("Email");
		layoutPanel.add(lblEmail);
		layoutPanel.setWidgetLeftWidth(lblEmail, 89.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblEmail, 128.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblPassword = new Label("Password");
		layoutPanel.add(lblPassword);
		layoutPanel.setWidgetLeftWidth(lblPassword, 89.0, Unit.PX, 73.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblPassword, 228.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblRNewPassword = new Label("Repeat New Password");
		layoutPanel.add(lblRNewPassword);
		layoutPanel.setWidgetLeftWidth(lblRNewPassword, 89.0, Unit.PX, 144.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblRNewPassword, 297.0, Unit.PX, 18.0, Unit.PX);
		
		tbName = new TextBox();
		layoutPanel.add(tbName);
		layoutPanel.setWidgetLeftWidth(tbName, 239.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbName, 56.0, Unit.PX, 25.0, Unit.PX);
		
		tbEmail = new TextBox();
		layoutPanel.add(tbEmail);
		layoutPanel.setWidgetLeftWidth(tbEmail, 239.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbEmail, 128.0, Unit.PX, 25.0, Unit.PX);
		
		tbPassword = new TextBox();
		layoutPanel.add(tbPassword);
		layoutPanel.setWidgetLeftWidth(tbPassword, 239.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbPassword, 228.0, Unit.PX, 25.0, Unit.PX);
		
		tbRNPassword = new TextBox();
		layoutPanel.add(tbRNPassword);
		layoutPanel.setWidgetLeftWidth(tbRNPassword, 239.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbRNPassword, 290.0, Unit.PX, 25.0, Unit.PX);
		
		Label lblSurname = new Label("Surname");
		layoutPanel.add(lblSurname);
		layoutPanel.setWidgetLeftWidth(lblSurname, 89.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblSurname, 94.0, Unit.PX, 18.0, Unit.PX);
		
		tbSurname = new TextBox();
		layoutPanel.add(tbSurname);
		layoutPanel.setWidgetLeftWidth(tbSurname, 239.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbSurname, 87.0, Unit.PX, 25.0, Unit.PX);
		
		Label lblCity = new Label("City");
		layoutPanel.add(lblCity);
		layoutPanel.setWidgetLeftWidth(lblCity, 89.0, Unit.PX, 123.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblCity, 166.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblCountry = new Label("Country");
		layoutPanel.add(lblCountry);
		layoutPanel.setWidgetLeftWidth(lblCountry, 89.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblCountry, 197.0, Unit.PX, 18.0, Unit.PX);
		
		tbCity = new TextBox();
		layoutPanel.add(tbCity);
		layoutPanel.setWidgetLeftWidth(tbCity, 239.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbCity, 159.0, Unit.PX, 25.0, Unit.PX);
		
		tbCountry = new TextBox();
		layoutPanel.add(tbCountry);
		layoutPanel.setWidgetLeftWidth(tbCountry, 239.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbCountry, 197.0, Unit.PX, 25.0, Unit.PX);
		
		Label lblNewPassword = new Label("New Password");
		layoutPanel.add(lblNewPassword);
		layoutPanel.setWidgetLeftWidth(lblNewPassword, 89.0, Unit.PX, 103.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblNewPassword, 259.0, Unit.PX, 18.0, Unit.PX);
		
		tbNPassword = new TextBox();
		layoutPanel.add(tbNPassword);
		layoutPanel.setWidgetLeftWidth(tbNPassword, 239.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbNPassword, 259.0, Unit.PX, 25.0, Unit.PX);
		
		btnCancel = new Button("Cancel");
		layoutPanel.add(btnCancel);
		layoutPanel.setWidgetLeftWidth(btnCancel, 89.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnCancel, 321.0, Unit.PX, 24.0, Unit.PX);
		
		btnConfirm = new Button("Confirm");
		layoutPanel.add(btnConfirm);
		layoutPanel.setWidgetLeftWidth(btnConfirm, 258.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnConfirm, 321.0, Unit.PX, 24.0, Unit.PX);
		
		btnSearchSong = new Button("Search Song");
		layoutPanel.add(btnSearchSong);
		layoutPanel.setWidgetLeftWidth(btnSearchSong, 170.0, Unit.PX, 107.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearchSong, 18.0, Unit.PX, 24.0, Unit.PX);
		
		btnSearchPlaylist = new Button("Search Playlist");
		layoutPanel.add(btnSearchPlaylist);
		layoutPanel.setWidgetLeftWidth(btnSearchPlaylist, 299.0, Unit.PX, 107.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnSearchPlaylist, 18.0, Unit.PX, 24.0, Unit.PX);
		
		btnLogout = new Button("Logout");
		layoutPanel.add(btnLogout);
		layoutPanel.setWidgetLeftWidth(btnLogout, 12.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnLogout, 367.0, Unit.PX, 24.0, Unit.PX);
	}
	@Override
	public HasClickHandlers getPlaylistsButton() {
		return btnPlaylists;
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
	public HasClickHandlers getCancelButton() {
		return btnCancel;
	}
	@Override
	public HasClickHandlers getConfirmButton() {
		return btnConfirm;
	}
	@Override
	public HasValue<String> getName() {
		return tbName;
	}
	@Override
	public HasValue<String> getSurname() {
		return tbSurname;
	}
	@Override
	public HasValue<String> getEmail() {
		return tbEmail;
	}
	@Override
	public HasValue<String> getCity() {
		return tbCity;
	}
	@Override
	public HasValue<String> getCountry() {
		return tbCountry;
	}
	@Override
	public HasValue<String> getPassword() {
		return tbPassword;
	}
	@Override
	public HasValue<String> getNPassword() {
		return tbNPassword;
	}
	@Override
	public HasValue<String> getRNPassword() {
		return tbRNPassword;
	}
	@Override
	public HasClickHandlers getLogout() {
		return btnLogout;
	}
}
