package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;

import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.SingleSelectionModel;

public class PruebaListOfPlaylistView extends Composite {

	private SingleSelectionModel<PlaylistDTO> selectionModel;
	private List<PlaylistDTO> playlists;
	private CellTable<PlaylistDTO> playlistTable;

	public PruebaListOfPlaylistView() {

		/* Render for PlaylistDTOs */
		TextColumn<PlaylistDTO> titleColumn = new TextColumn<PlaylistDTO>() {
			public String getValue(PlaylistDTO playlist) {
				return playlist.getName();
			}
		};
		TextColumn<PlaylistDTO> authorColumn = new TextColumn<PlaylistDTO>() {
			public String getValue(PlaylistDTO playlist) {
				return playlist.getUser().getName();
			}
		};

		/* Selection model for mantaining selection */
		selectionModel = new SingleSelectionModel<PlaylistDTO>();

		playlistTable = new CellTable<PlaylistDTO>();
		playlistTable.setStyleName("ctPlaylist", true);
		playlistTable.addColumn(titleColumn, "Nombre");
		playlistTable.addColumn(authorColumn, "Usuario");
		playlistTable.setSelectionModel(selectionModel);

		initWidget(playlistTable);
	}

	public void setPlaylists(List<PlaylistDTO> data) {
		playlists = data;
		playlistTable.setRowData(playlists);
		playlistTable.redraw();
	}

	public int getPlaylistIndex(PlaylistDTO playlist) {
		return playlists.indexOf(playlist);
	}

	public SingleSelectionModel<PlaylistDTO> getSelectionModel() {
		return selectionModel;
	}

}
