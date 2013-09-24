package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.shared.dtos.SongDTO;

import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.SingleSelectionModel;

public class PruebaListOfSongView extends Composite {

	private SingleSelectionModel<SongDTO> selectionModel;
	private List<SongDTO> songs;
	private CellTable<SongDTO> songTable;

	public PruebaListOfSongView() {

		/* Render for SongDTOs */
		TextColumn<SongDTO> titleColumn = new TextColumn<SongDTO>() {
			public String getValue(SongDTO song) {
				return song.getTitle();
			}
		};
		TextColumn<SongDTO> authorColumn = new TextColumn<SongDTO>() {
			public String getValue(SongDTO song) {
				return song.getAuthor();
			}
		};
		TextColumn<SongDTO> recordColumn = new TextColumn<SongDTO>() {
			public String getValue(SongDTO song) {
				return song.getRecord();
			}
		};

		/* Selection model for mantaining selection */
		selectionModel = new SingleSelectionModel<SongDTO>();

		songTable = new CellTable<SongDTO>();
		songTable.addColumn(titleColumn, "T\u00EDtulo");
		songTable.addColumn(authorColumn, "Artista");
		songTable.addColumn(recordColumn, "Record");
		songTable.setSelectionModel(selectionModel);

		initWidget(songTable);
	}
	
	public void setSongs(List<SongDTO> data){
		songs = data;
		songTable.setRowData(songs);
		songTable.redraw();
	}
	
	public void deleteSong(int index){
		if (index >= 0 && index < songs.size()){
			songs.remove(index);
			songTable.setRowData(songs);
			songTable.redraw();
		}
	}
	
	public int getSongIndex(SongDTO song){
		return songs.indexOf(song);
	}

	public SingleSelectionModel<SongDTO> getSelectionModel(){
		return selectionModel;
	}

	public void addSong(SongDTO song) {
		songs.add(new SongDTO(song.getUniqueID(), song.getTitle(), song.getAuthor(), song.getRecord(), song.getUrl()));
		songTable.setRowData(songs);
		songTable.redraw();
	}
}
