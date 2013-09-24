package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;

import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.SingleSelectionModel;

public class PruebaPlaylistView extends Composite {

	private PlaylistDTO playlist;
	private UserDTO loggedUser;
	private PruebaListOfSongView songView;
	private TextBox txtbxPlaylistName = null;
	private Button btnBorrar;
	private Button btnChangePlaylistName = null;
	private HTML btnTweet;

	public PruebaPlaylistView(PlaylistDTO pl, UserDTO lu) {

		this.playlist = pl;
		this.loggedUser = lu;
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("fpPlaylist");
		initWidget(flowPanel);

		FlowPanel fpTitleBar = new FlowPanel();
		fpTitleBar.setStyleName("fpPlaylistTitle");
		flowPanel.add(fpTitleBar);
		if (playlist.getUser().getUniqueID().equals(loggedUser.getUniqueID())) {
			btnChangePlaylistName = new Button("Cambiar nombre");
			btnChangePlaylistName.setStyleName("button");
			btnChangePlaylistName.setStyleName("btDeletePL", true);
			btnChangePlaylistName.setStyleName("invisible", true);
			txtbxPlaylistName = new TextBox();
			txtbxPlaylistName.setStyleName("txtPLName", true);
			txtbxPlaylistName.setText(playlist.getName());
			txtbxPlaylistName.addKeyUpHandler(new KeyUpHandler() {
				public void onKeyUp(KeyUpEvent arg0) {
					if (arg0.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
						btnChangePlaylistName.click();
					}
				}
			});
			fpTitleBar.add(txtbxPlaylistName);
			fpTitleBar.add(btnChangePlaylistName);

		} else {
			Label txtbxPlaylistName = new Label();
			txtbxPlaylistName.setStyleName("txtPLName", true);
			txtbxPlaylistName.setText(playlist.getName());
			fpTitleBar.add(txtbxPlaylistName);
		}

		btnTweet = new HTML();
		btnTweet.setStyleName("btTweet");
		fpTitleBar.add(btnTweet);

		updateTwitterButton();
		
		if (playlist.getUser().getUniqueID().equals(loggedUser.getUniqueID())) {
			btnBorrar = new Button("Borrar");
			btnBorrar.setStyleName("button btDeletePL negative");
			fpTitleBar.add(btnBorrar);
			btnBorrar
					.setHTML("<span class=\"trash icon\" style=\"margin:auto;\"></span>");
		}
		FlowPanel fpSongs = new FlowPanel();
		fpSongs.setStyleName("fpPlaylistSongs");
		flowPanel.add(fpSongs);

		songView = new PruebaListOfSongView();
		fpSongs.add(songView);
	}

	public void setPlaylistSongs(List<SongDTO> data) {
		songView.setSongs(data);
	}

	public HasValue<String> getPlaylistName() {
		return txtbxPlaylistName;
	}

	public HasClickHandlers getDeletePlaylistButton() {
		return btnBorrar;
	}

	public HasClickHandlers getChangePlaylistNameButton() {
		return btnChangePlaylistName;
	}

	public void setPlaylist(PlaylistDTO arg0) {
		playlist = arg0;
		updateTwitterButton();
	}
	
	private void updateTwitterButton(){
		btnTweet.setHTML("<a href=\"http://twitter.com/share\" class=\"twitter-share-button\" data-url=\""
				+ "http://127.0.0.1:8890/Wimbi.html?gwt.codesvr=127.0.0.1:9997#"
				+ "playlist?id="
				+ playlist.getUniqueID()
				+ "\" "
				+ "data-text=\""
				+ playlist.getName()
				+ "\" "
				+ "data-count=\"none\">Tweet</a> <script type=\"text/javascript\" src=\"http://platform.twitter.com/widgets.js\"></script>");
	
		Document doc = Document.get();
		ScriptElement script = doc.createScriptElement();
		script.setSrc("http://platform.twitter.com/widgets.js");
		script.setType("text/javascript");
		script.setLang("javascript");
		doc.getBody().appendChild(script);	
	}
	
	public SingleSelectionModel<SongDTO> getSongSelectionModel(){
		return songView.getSelectionModel();
	}
	
	public int getSongIndex(SongDTO song){
		return songView.getSongIndex(song);
	}

	public void deleteSong(int index) {
		songView.deleteSong(index);
	}
	
	public void addSong(SongDTO song){
		songView.addSong(song);
	}
	
	public PlaylistDTO getPlaylist(){
		return playlist;
	}

}
