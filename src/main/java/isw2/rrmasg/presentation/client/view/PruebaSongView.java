package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.shared.dtos.SongDTO;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

public class PruebaSongView extends Composite {

	public static final int USER_PLAYLIST = 1;
	public static final int SEARCH_SONG = 2;
	public static final int NOT_USER = 3;

	private Button btnDeleteFromPlaylist;
	private Button btnAddToPlaylist;

	public PruebaSongView(SongDTO song, int context) {

		final FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("full fpSong");
		flowPanel.addDomHandler(new MouseOverHandler() {
			public void onMouseOver(MouseOverEvent arg0) {
				flowPanel.setStyleName("fpSong-hover", true);
			}

		}, MouseOverEvent.getType());
		flowPanel.addDomHandler(new MouseOutHandler() {
			public void onMouseOut(MouseOutEvent arg0) {
				flowPanel.setStyleName("fpSong-hover", false);
			}

		}, MouseOutEvent.getType());
		initWidget(flowPanel);

		FlowPanel fpSongInfo = new FlowPanel();
		fpSongInfo.setStyleName("fpSongInfo");
		flowPanel.add(fpSongInfo);

		if (context != NOT_USER) {
			FlowPanel fpSongTitleShow = new FlowPanel();
			fpSongInfo.add(fpSongTitleShow);
			Label lblTitleShow = new Label(song.getTitle());
			fpSongTitleShow.setStyleName("fpSongTitleShow");
			fpSongTitleShow.add(lblTitleShow);
		}

		FlowPanel fpSongLittleInfo = new FlowPanel();
		fpSongLittleInfo.setStyleName("fpSongLittleInfo");
		fpSongInfo.add(fpSongLittleInfo);

		Label lblTtulo = new Label("T\u00EDtulo: " + song.getTitle());
		fpSongLittleInfo.add(lblTtulo);

		Label lblArtista = new Label("Artista: " + song.getAuthor());
		fpSongLittleInfo.add(lblArtista);

		Label lblDiscogrfica = new Label("Discogr\u00E1fica: "
				+ song.getRecord());
		fpSongLittleInfo.add(lblDiscogrfica);
		
		Label lblUrl = new Label("Url: "
				+ song.getUrl());
		fpSongLittleInfo.add(lblUrl);

		FlowPanel fpSongButtons = new FlowPanel();
		fpSongButtons.setStyleName("fpSongButton");
		fpSongInfo.add(fpSongButtons);

		HTML btnTweet = new HTML("btnTweet", true);
		btnTweet.setStyleName("btTweet");
		fpSongButtons.add(btnTweet);
		if (context == USER_PLAYLIST) {
			btnDeleteFromPlaylist = new Button("Borrar");
			btnDeleteFromPlaylist.setStyleName("button btDeletePL negative");
			btnDeleteFromPlaylist
					.setHTML("<span class=\"trash icon\" style=\"margin:auto;\"></span>Borrar de la lista");
			fpSongButtons.add(btnDeleteFromPlaylist);
		} else {
			btnAddToPlaylist = new Button("A\u00f1adir");
			btnAddToPlaylist.setStyleName("button btDeletePL positive");
			btnAddToPlaylist
					.setHTML("<span class=\"plus icon\" style=\"margin:auto;\"></span>A\u00f1adir a una lista");
			fpSongButtons.add(btnAddToPlaylist);
		}

		FlowPanel fpSongPreview = new FlowPanel();
		fpSongPreview.setStyleName("fpSongPreview");
		flowPanel.add(fpSongPreview);

		String trackID = song.getUrl().substring(song.getUrl().lastIndexOf("/") + 1);
		HTML songPreview = new HTML(
				"<div style=\"text-align:center;\">"
						+ "<object width=\"200\" height=\"300\" classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0\" align=\"middle\">" +
								"<param name=\"allowScriptAccess\" value=\"always\" />" +
								"<param name=\"wmode\" value=\"transparent\" />" +
								"<param name=\"movie\" value=\"http://widgets.jamendo.com/es/track/?playertype=2008&track_id=" +
								trackID +
								"\" />" +
								"<param name=\"quality\" value=\"high\" /><param name=\"bgcolor\" value=\"#FFFFFF\" />" +
								"<embed src=\"http://widgets.jamendo.com/es/track/?playertype=2008&track_id=" +
								trackID +
								"\" " +
								"quality=\"high\" wmode=\"transparent\" bgcolor=\"#FFFFFF\" width=\"200\" height=\"300\" " +
								"align=\"middle\" allowScriptAccess=\"always\" type=\"application/x-shockwave-flash\" " +
								"pluginspage=\"http://www.macromedia.com/go/getflashplayer\">&nbsp;</embed>&nbsp;</object>" +
								"</div>");
		fpSongPreview.add(songPreview);

		FlowPanel fpPreview = new FlowPanel();
		fpSongPreview.add(fpPreview);
		Timer t = new Timer() {
			public void run() {
				flowPanel.setStyleName("fpSong-hover", true);
			}
		};
		t.schedule(10);
		Timer t2 = new Timer() {
			public void run() {
				flowPanel.setStyleName("fpSong-hover", false);
			}
		};
		t2.schedule(5000);

		btnTweet.setHTML("<a href=\"http://twitter.com/share\" class=\"twitter-share-button\" data-url=\""
				+ "http://127.0.0.1:8890/Wimbi.html?gwt.codesvr=127.0.0.1:9997#"
				+ "song?id="
				+ song.getUniqueID()
				+ "\" "
				+ "data-text=\""
				+ song.getTitle()
				+ " - "
				+ song.getAuthor()
				+ "\" "
				+ "data-count=\"none\">Tweet</a> <script type=\"text/javascript\" src=\"http://platform.twitter.com/widgets.js\"></script>");

		Document doc = Document.get();
		ScriptElement script = doc.createScriptElement();
		script.setSrc("http://platform.twitter.com/widgets.js");
		script.setType("text/javascript");
		script.setLang("javascript");
		doc.getBody().appendChild(script);

	}

	public HasClickHandlers getDeleteFromPlaylistButton() {
		return btnDeleteFromPlaylist;
	}

	public HasClickHandlers getAddToPlaylistButton() {
		return btnAddToPlaylist;
	}

}
