package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.client.presenter.PruebaPresenter;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.SingleSelectionModel;

public class PruebaView extends Composite implements PruebaPresenter.Display {
	private Label lblUserName;
	private TextBox txtbxNombreLista;
	private Button btnCrear;
	private FocusPanel fcpNameEdit;
	private FlowPanel flowPanel;
	private FlowPanel fpMain;
	private FlowPanel fpOverlay;
	private PruebaSelectPlaylistView userPlaylistsView;
	private PruebaPlaylistView actualPlaylistView;
	private PruebaSearchSongView actualSearchSongView;
	private PruebaSearchPlaylistView actualSearchPlaylistView;
	private PruebaSongView actualSongView;
	private Button btnGoToSearchSong;
	private Button btnGoToSearchPlaylist;
	private Button btnLogout;


	public PruebaView() {

		flowPanel = new FlowPanel();
		flowPanel.setStyleName("full");
		initWidget(flowPanel);

		fpOverlay = new FlowPanel();
		fpOverlay.setStyleName("fpOverlay invisible");
		flowPanel.add(fpOverlay);

		SplitLayoutPanel splitPanel = new SplitLayoutPanel(1);
		flowPanel.add(splitPanel);

		FlowPanel fpSidebar = new FlowPanel();
		fpSidebar.setStyleName("fpSidebar");
		splitPanel.addWest(fpSidebar, 300.0);

		FlowPanel fpWelcome = new FlowPanel();
		fpWelcome.setStyleName("fpWelcome");
		fpSidebar.add(fpWelcome);

		Label lblBienvenido = new Label("Bienvenido,");
		fpWelcome.add(lblBienvenido);

		fcpNameEdit = new FocusPanel();
		fcpNameEdit.setStyleName("noHighlight");
		fpWelcome.add(fcpNameEdit);
		
		FlowPanel fpNameEdit = new FlowPanel();
		fpNameEdit.setStyleName("userLabel");
		fcpNameEdit.add(fpNameEdit);

		lblUserName = new Label();
		fpNameEdit.add(lblUserName);

		Label lblEditar = new Label(" - Editar");
		lblEditar.setStyleName("lblEdit");
		fpNameEdit.add(lblEditar);

		FlowPanel fpCreatePlaylist = new FlowPanel();
		fpCreatePlaylist.setStyleName("fpCreatePlaylist");
		fpSidebar.add(fpCreatePlaylist);

		txtbxNombreLista = new TextBox();
		txtbxNombreLista.setStyleName("txtCreatePL", true);
		txtbxNombreLista.setText("Nombre de la nueva lista");
		fpCreatePlaylist.add(txtbxNombreLista);

		txtbxNombreLista.addFocusHandler(new FocusHandler() {
			public void onFocus(FocusEvent arg0) {
				if (txtbxNombreLista.getValue().equals(
						"Nombre de la nueva lista")) {
					txtbxNombreLista.setValue("");
				}
			}
		});
		txtbxNombreLista.addBlurHandler(new BlurHandler() {
			public void onBlur(BlurEvent arg0) {
				if (txtbxNombreLista.getValue().equals("")) {
					txtbxNombreLista.setValue("Nombre de la nueva lista");
				}
			}
		});

		btnCrear = new Button("Crear ");
		btnCrear.setStyleName("button btCreatePL");
		fpCreatePlaylist.add(btnCrear);

		txtbxNombreLista.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent arg0) {
				if (arg0.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					btnCrear.click();
				}
			}
		});

		userPlaylistsView = new PruebaSelectPlaylistView();
		fpSidebar.add(userPlaylistsView);

		fpMain = new FlowPanel();
		fpMain.setStyleName("fpMain");
		splitPanel.add(fpMain);

		FlowPanel fpMainUpBar = new FlowPanel();
		fpMain.add(fpMainUpBar);
		fpMainUpBar.setStyleName("fpWelcome");

		btnGoToSearchSong = new Button("Buscar canciones");
		btnGoToSearchSong.setStyleName("button");
		fpMainUpBar.add(btnGoToSearchSong);

		btnGoToSearchPlaylist = new Button("Buscar listas de reproducci\u00f3n");
		btnGoToSearchPlaylist.setStyleName("button");
		fpMainUpBar.add(btnGoToSearchPlaylist);

		btnLogout = new Button("Cerrar sesi\u00f3n");
		btnLogout.setStyleName("button");
		fpMainUpBar.add(btnLogout);
		
	}

	public HasClickHandlers getEditUserButton() {
		return fcpNameEdit;
	}

	public HasClickHandlers getLogoutButton() {
		return btnLogout;
	}
	
	public HasClickHandlers getCreatePlaylistButton() {
		return btnCrear;
	}

	public HasValue<String> getNewPlaylistName() {
		return txtbxNombreLista;
	}

	public void setUserPlaylists(List<PlaylistDTO> data) {
		userPlaylistsView.setUserPlaylists(data);
	}

	public void addUserPlaylist(PlaylistDTO playlist) {
		userPlaylistsView.addUserPlaylist(playlist);
	}

	public void deleteUserPlaylist(PlaylistDTO playlist) {
		userPlaylistsView.deleteUserPlaylist(playlist);
	}

	public void changeUserPlaylist(PlaylistDTO oldPL, PlaylistDTO newPL) {
		userPlaylistsView.changeUserPlaylist(oldPL, newPL);
	}

	public void setLoggedUser(UserDTO user) {
		lblUserName.setText(user.getName());
	}

	public void showErrorMessage(String message) {
		FlowPanel fpNotification = new FlowPanel();
		fpNotification.setStyleName("notification notificationError");

		Label lblNotificationMessage = new Label(message);
		fpNotification.add(lblNotificationMessage);

		flowPanel.add(fpNotification);
	}

	public void showNotificationMessage(String message) {
		FlowPanel fpNotification = new FlowPanel();
		fpNotification.setStyleName("notification");

		Label lblNotificationMessage = new Label(message);
		fpNotification.add(lblNotificationMessage);

		flowPanel.add(fpNotification);
	}

	public SingleSelectionModel<PlaylistDTO> getPlaylistSelectionModel() {
		return userPlaylistsView.getPlaylistSelectionModel();
	}

	public void presentPlaylist(PruebaPlaylistView us) {
		if (actualSearchPlaylistView != null) {
			fpMain.remove(actualSearchPlaylistView);
			actualSearchPlaylistView = null;
		}
		if (actualSearchSongView != null) {
			fpMain.remove(actualSearchSongView);
			actualSearchSongView = null;
		}
		if (actualPlaylistView != null) {
			fpMain.remove(actualPlaylistView);
		}
		actualPlaylistView = us;
		fpMain.add(us);
	}

	public void presentSong(PruebaSongView sv) {
		if (actualSongView != null) {
			fpMain.remove(actualSongView);
		}
		actualSongView = sv;
		fpMain.add(sv);
	}

	public PlaylistDTO getFirstPlaylist() {
		return userPlaylistsView.getFirstPlaylist();
	}

	public AbstractCell<PlaylistDTO> getPlaylistCell() {
		return userPlaylistsView.getPlaylistCell();
	}

	public List<PlaylistDTO> getUserPlaylists() {
		return userPlaylistsView.getUserPlaylists();
	}

	public void presentSelectPlaylist(PruebaSelectPlaylistView sp) {
		FlowPanel fpSelectPlaylist = new FlowPanel();
		fpSelectPlaylist.setStyleName("fpSelectPlaylist");

		Label lblMessage = new Label("Seleccione una lista");
		lblMessage.setStyleName("fpSelectPlaylistLabel");
		fpSelectPlaylist.add(lblMessage);
		fpSelectPlaylist.add(sp);

		fpOverlay.add(fpSelectPlaylist);
		fpOverlay.setStyleName("invisible", false);
		fpOverlay.setStyleName("fpOverlayChangeable", false);
	}

	public void hideOverlay() {
		fpOverlay.clear();
		fpOverlay.setStyleName("invisible", true);
	}

	public void presentSearchSong(PruebaSearchSongView ss) {
		if (actualPlaylistView != null) {
			fpMain.remove(actualPlaylistView);
		}
		if (actualSearchPlaylistView != null) {
			fpMain.remove(actualSearchPlaylistView);
			actualSearchPlaylistView = null;
		}
		if (actualSearchSongView != null) {
			fpMain.remove(actualSearchSongView);
		}
		getPlaylistSelectionModel().setSelected(
				getPlaylistSelectionModel().getSelectedObject(), false);
		actualSearchSongView = ss;
		fpMain.add(ss);
	}

	public HasClickHandlers getGoToSearchSongButton() {
		return btnGoToSearchSong;
	}

	public HasClickHandlers getGoToSearchPlaylistButton() {
		return btnGoToSearchPlaylist;
	}

	public void presentSearchPlaylist(PruebaSearchPlaylistView sp) {
		if (actualPlaylistView != null) {
			fpMain.remove(actualPlaylistView);
		}
		if (actualSearchSongView != null) {
			fpMain.remove(actualSearchSongView);
			actualSearchSongView = null;
		}
		if (actualSearchPlaylistView != null) {
			fpMain.remove(actualSearchPlaylistView);
		}
		actualSearchPlaylistView = sp;
		fpMain.add(sp);

	}

	public void presentEditUser(PruebaEditUserView ed) {
		FlowPanel fpSelectPlaylist = new FlowPanel();
		fpSelectPlaylist.setStyleName("fpEditUser");

		fpSelectPlaylist.add(ed);

		fpOverlay.add(fpSelectPlaylist);
		fpOverlay.setStyleName("invisible", false);
		fpOverlay.setStyleName("fpOverlayChangeable", true);
	}

}
