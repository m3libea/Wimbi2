package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SingleSelectionModel;

public class PruebaSelectPlaylistView extends Composite {

	private AbstractCell<PlaylistDTO> playlistCell;
	private CellList<PlaylistDTO> userPlaylistList;
	private SingleSelectionModel<PlaylistDTO> selectionModel;
	private List<PlaylistDTO> userPlaylists;

	public PruebaSelectPlaylistView() {
		FlowPanel fpListOfPlaylist = new FlowPanel();
		fpListOfPlaylist.setStyleName("fpListOfPlaylist");
		
		initWidget(fpListOfPlaylist);

		/* Render for PlaylistDTOs */
		playlistCell = new AbstractCell<PlaylistDTO>() {
			public void render(Context context, PlaylistDTO playlist,
					SafeHtmlBuilder sb) {
				if (playlist != null) {
					sb.appendEscaped(playlist.getName());
				}
			}
		};

		/* ProviderKey for PlaylistsDTOs */
		ProvidesKey<PlaylistDTO> playlistKeyProvider = new ProvidesKey<PlaylistDTO>() {
			public Object getKey(PlaylistDTO item) {
				if (item != null) {
					return new Long(item.getUniqueID());
				}
				return null;
			}
		};

		userPlaylistList = new CellList<PlaylistDTO>(playlistCell,
				playlistKeyProvider);
		fpListOfPlaylist.add(userPlaylistList);

		/* Selection model for mantaining selection */
		selectionModel = new SingleSelectionModel<PlaylistDTO>(
				playlistKeyProvider);

		userPlaylistList.setSelectionModel(selectionModel);

	}
	
	public void setUserPlaylists(List<PlaylistDTO> data) {
		userPlaylists = data;
		userPlaylistList.setRowData(userPlaylists);
	}

	public void addUserPlaylist(PlaylistDTO playlist) {
		userPlaylists.add(playlist);
		userPlaylistList.setRowData(userPlaylists);
		userPlaylistList.redraw();
	}

	public void deleteUserPlaylist(PlaylistDTO playlist) {
		userPlaylists.remove(playlist);
		userPlaylistList.setRowData(userPlaylists);
		userPlaylistList.redraw();
	}

	public void changeUserPlaylist(PlaylistDTO oldPL, PlaylistDTO newPL) {
		int index = userPlaylists.indexOf(oldPL);
		userPlaylists.set(index, newPL);
		userPlaylistList.setRowData(userPlaylists);
		userPlaylistList.redraw();
	}

	public SingleSelectionModel<PlaylistDTO> getPlaylistSelectionModel() {
		return selectionModel;
	}
	
	public AbstractCell<PlaylistDTO> getPlaylistCell() {
		return playlistCell;
	}

	public PlaylistDTO getFirstPlaylist() {
		if (userPlaylists != null && userPlaylists.get(0) != null)
			return userPlaylists.get(0);
		else
			return null;
	}

	public List<PlaylistDTO> getUserPlaylists() {
		return userPlaylists;
	}
	
}
