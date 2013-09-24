package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.shared.dtos.UserDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class PruebaEditUserView extends Composite {

	private PasswordTextBox tbxRNPassword;
	private PasswordTextBox tbxPassword;
	private TextBox txtbxEmail;
	private TextBox txtbxPas;
	private TextBox txtbxCiudad;
	private TextBox txtbxApellidos;
	private TextBox txtbxNombre;
	private FlowPanel flowPanel;
	private Button btnEliminarUsuario;
	private PasswordTextBox tbxNPassword;
	private Button btnChangeEmail;
	private Button btnChangePassword;
	private Button btnAccept;
	private Button btnCancel;
	private Button btnEliminarUsuarioNoNativo;

	public PruebaEditUserView(UserDTO loggedUser) {

		flowPanel = new FlowPanel();
		flowPanel.setStyleName("full");
		initWidget(flowPanel);
		if (loggedUser.isNativeAccount()) {
			FlowPanel fpName = new FlowPanel();
			fpName.setStyleName("formElementHorizontal");
			flowPanel.add(fpName);

			Label lblNombre = new Label("Nombre");
			fpName.add(lblNombre);

			txtbxNombre = new TextBox();
			txtbxNombre.setText(loggedUser.getName());
			txtbxNombre.setTabIndex(1);
			fpName.add(txtbxNombre);

			FlowPanel fpSurname = new FlowPanel();
			fpSurname.setStyleName("formElementHorizontal");
			flowPanel.add(fpSurname);

			Label lblApellidos = new Label("Apellidos");
			fpSurname.add(lblApellidos);

			txtbxApellidos = new TextBox();
			txtbxApellidos.setText(loggedUser.getSurname());
			txtbxApellidos.setTabIndex(1);
			fpSurname.add(txtbxApellidos);

			FlowPanel fpCity = new FlowPanel();
			fpCity.setStyleName("formElementHorizontal");
			flowPanel.add(fpCity);

			Label lblCiudad = new Label("Ciudad");
			fpCity.add(lblCiudad);

			txtbxCiudad = new TextBox();
			txtbxCiudad.setText(loggedUser.getCity());
			txtbxCiudad.setTabIndex(1);
			fpCity.add(txtbxCiudad);

			FlowPanel fpCountry = new FlowPanel();
			fpCountry.setStyleName("formElementHorizontal");
			flowPanel.add(fpCountry);

			Label lblPas = new Label("Pa\u00EDs");
			fpCountry.add(lblPas);

			txtbxPas = new TextBox();
			txtbxPas.setText(loggedUser.getCountry());
			txtbxPas.setTabIndex(1);
			fpCountry.add(txtbxPas);

			final FlowPanel fpEmail = new FlowPanel();
			fpEmail.setStyleName("formElementHorizontal");
			flowPanel.add(fpEmail);
			fpEmail.setVisible(false);

			Label lblEmail = new Label("Email");
			fpEmail.add(lblEmail);

			txtbxEmail = new TextBox();
			txtbxEmail.setTabIndex(1);
			fpEmail.add(txtbxEmail);

			final FlowPanel fpPassword = new FlowPanel();
			fpPassword.setStyleName("formElementHorizontal");
			fpPassword.setVisible(false);
			flowPanel.add(fpPassword);

			Label lblContrasea = new Label("Contrase\u00F1a");
			fpPassword.add(lblContrasea);

			tbxPassword = new PasswordTextBox();
			tbxPassword.setTabIndex(1);
			tbxPassword.setStyleName("gwt-TextBox");
			fpPassword.add(tbxPassword);

			final FlowPanel fpNPassword = new FlowPanel();
			fpNPassword.setStyleName("formElementHorizontal");
			fpNPassword.setVisible(false);
			flowPanel.add(fpNPassword);

			Label lblNuevaContrasea = new Label("Nueva contrase\u00F1a");
			fpNPassword.add(lblNuevaContrasea);

			tbxNPassword = new PasswordTextBox();
			tbxNPassword.setTabIndex(1);
			tbxNPassword.setStyleName("gwt-TextBox");
			fpNPassword.add(tbxNPassword);

			final FlowPanel fpRNPassword = new FlowPanel();
			fpRNPassword.setStyleName("formElementHorizontal");
			fpRNPassword.setVisible(false);
			flowPanel.add(fpRNPassword);

			Label lblRepetirContrasea = new Label("Repetir contrase\u00F1a");
			fpRNPassword.add(lblRepetirContrasea);

			tbxRNPassword = new PasswordTextBox();
			tbxRNPassword.setTabIndex(1);
			tbxRNPassword.setStyleName("gwt-TextBox");
			fpRNPassword.add(tbxRNPassword);

			FlowPanel fpButtons = new FlowPanel();
			fpButtons.setStyleName("fpButtons");
			flowPanel.add(fpButtons);

			FlowPanel flowPanel_5 = new FlowPanel();
			fpButtons.add(flowPanel_5);

			btnCancel = new Button("Cancelar");
			btnCancel.setTabIndex(3);
			btnCancel.setStyleName("button");
			flowPanel_5.add(btnCancel);

			FlowPanel fpEmailButton = new FlowPanel();
			fpButtons.add(fpEmailButton);

			btnChangeEmail = new Button("Cambiar email");
			btnChangeEmail.setTabIndex(3);
			btnChangeEmail.setStyleName("button");
			fpEmailButton.add(btnChangeEmail);

			FlowPanel fpPasswordButton = new FlowPanel();
			fpButtons.add(fpPasswordButton);

			btnChangePassword = new Button("Cambiar contrase\u00F1a");
			btnChangePassword.setStyleName("button");
			btnChangePassword.setTabIndex(3);
			fpPasswordButton.add(btnChangePassword);

			FlowPanel flowPanel_6 = new FlowPanel();
			fpButtons.add(flowPanel_6);

			btnAccept = new Button("Aceptar");
			btnAccept.setTabIndex(2);
			btnAccept.setStyleName("button primary positive");
			flowPanel_6.add(btnAccept);

			FlowPanel fpDeleteUser = new FlowPanel();
			fpDeleteUser.setStyleName("formElementHorizontal feCenter");
			flowPanel.add(fpDeleteUser);

			FlowPanel fpDeleteUserButton = new FlowPanel();
			fpDeleteUserButton.setStyleName("fpDeleteUser");
			btnChangePassword.setTabIndex(4);
			fpDeleteUser.add(fpDeleteUserButton);

			btnEliminarUsuario = new Button("Eliminar usuario");
			btnEliminarUsuario.setStyleName("button negative");
			fpDeleteUserButton.add(btnEliminarUsuario);
			KeyUpHandler enterHandler = new KeyUpHandler() {
				public void onKeyUp(KeyUpEvent arg0) {
					if (arg0.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
						btnAccept.click();
					}
				}
			};

			btnChangeEmail.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent arg0) {
					fpEmail.setVisible(true);
					fpPassword.setVisible(true);
				}
			});

			btnChangePassword.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent arg0) {
					fpEmail.setVisible(true);
					fpPassword.setVisible(true);
					fpNPassword.setVisible(true);
					fpRNPassword.setVisible(true);
				}
			});

			btnEliminarUsuario.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent arg0) {
					fpPassword.setVisible(true);
				}
			});

			txtbxNombre.addKeyUpHandler(enterHandler);
			txtbxEmail.addKeyUpHandler(enterHandler);
			txtbxPas.addKeyUpHandler(enterHandler);
			txtbxCiudad.addKeyUpHandler(enterHandler);
			txtbxApellidos.addKeyUpHandler(enterHandler);
			tbxPassword.addKeyUpHandler(enterHandler);
			tbxNPassword.addKeyUpHandler(enterHandler);
			tbxRNPassword.addKeyUpHandler(enterHandler);
		} else {
			FlowPanel fpDeleteUser = new FlowPanel();
			fpDeleteUser.setStyleName("formElementHorizontal feCenter");
			flowPanel.add(fpDeleteUser);
			
			FlowPanel fpDeleteUserButton = new FlowPanel();
			fpDeleteUserButton.setStyleName("fpDeleteUser");
			fpDeleteUser.add(fpDeleteUserButton);
			
			btnEliminarUsuarioNoNativo = new Button("Eliminar usuario");
			btnEliminarUsuarioNoNativo.setStyleName("button negative");
			fpDeleteUserButton.add(btnEliminarUsuarioNoNativo);
		}
	}

	public HasClickHandlers getAcceptButton() {
		return btnAccept;
	}

	public HasClickHandlers getCancelButton() {
		return btnCancel;
	}

	public HasValue<String> getName() {
		return txtbxNombre;
	}

	public HasValue<String> getSurname() {
		return txtbxApellidos;
	}

	public HasValue<String> getCity() {
		return txtbxCiudad;
	}

	public HasValue<String> getCountry() {
		return txtbxPas;
	}

	public HasValue<String> getEmailAddress() {
		return txtbxEmail;
	}

	public HasValue<String> getPassword() {
		return tbxPassword;
	}

	public HasValue<String> getNewPassword() {
		return tbxRNPassword;
	}

	public HasValue<String> getCheckNewPassword() {
		return tbxRNPassword;
	}

	public HasClickHandlers getDeleteUserButton() {
		return btnEliminarUsuario;
	}

	public HasClickHandlers getDeleteNonNativeUserButton() {
		return btnEliminarUsuarioNoNativo;
	}

}
