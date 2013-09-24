package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.client.presenter.NewUserPresenter;

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

public class NewUserView extends Composite implements NewUserPresenter.Display {
	private PasswordTextBox pswrdtxtbxRepetirContrasea;
	private PasswordTextBox pswrdtxtbxContrasea;
	private TextBox txtbxEmail;
	private TextBox txtbxPas;
	private TextBox txtbxCiudad;
	private TextBox txtbxApellidos;
	private TextBox txtbxNombre;
	private Button btnCancelar;
	private Button btnCrearUsuario;
	private FlowPanel flowPanel;

	public NewUserView() {

		flowPanel = new FlowPanel();
		flowPanel.setStyleName("fpCenterContent");
		initWidget(flowPanel);

		FlowPanel fpNewUserBox = new FlowPanel();
		fpNewUserBox.setStyleName("loginBox");
		flowPanel.add(fpNewUserBox);

		FlowPanel fpName = new FlowPanel();
		fpName.setStyleName("formElementHorizontal");
		fpNewUserBox.add(fpName);

		Label lblNombre = new Label("Nombre");
		fpName.add(lblNombre);

		txtbxNombre = new TextBox();
		txtbxNombre.setTabIndex(1);
		fpName.add(txtbxNombre);

		FlowPanel fpSurname = new FlowPanel();
		fpSurname.setStyleName("formElementHorizontal");
		fpNewUserBox.add(fpSurname);

		Label lblApellidos = new Label("Apellidos");
		fpSurname.add(lblApellidos);

		txtbxApellidos = new TextBox();
		txtbxApellidos.setTabIndex(1);
		fpSurname.add(txtbxApellidos);

		FlowPanel fpCity = new FlowPanel();
		fpCity.setStyleName("formElementHorizontal");
		fpNewUserBox.add(fpCity);

		Label lblCiudad = new Label("Ciudad");
		fpCity.add(lblCiudad);

		txtbxCiudad = new TextBox();
		txtbxCiudad.setTabIndex(1);
		fpCity.add(txtbxCiudad);

		FlowPanel fpCountry = new FlowPanel();
		fpCountry.setStyleName("formElementHorizontal");
		fpNewUserBox.add(fpCountry);

		Label lblPas = new Label("Pa\u00EDs");
		fpCountry.add(lblPas);

		txtbxPas = new TextBox();
		txtbxPas.setTabIndex(1);
		fpCountry.add(txtbxPas);

		FlowPanel fpEmail = new FlowPanel();
		fpEmail.setStyleName("formElementHorizontal");
		fpNewUserBox.add(fpEmail);

		Label lblEmail = new Label("Email");
		fpEmail.add(lblEmail);

		txtbxEmail = new TextBox();
		txtbxEmail.setTabIndex(1);
		fpEmail.add(txtbxEmail);

		FlowPanel fpPassword = new FlowPanel();
		fpPassword.setStyleName("formElementHorizontal");
		fpNewUserBox.add(fpPassword);

		Label lblContrasea = new Label("Contrase\u00F1a");
		fpPassword.add(lblContrasea);

		pswrdtxtbxContrasea = new PasswordTextBox();
		pswrdtxtbxContrasea.setTabIndex(1);
		pswrdtxtbxContrasea.setStyleName("gwt-TextBox");
		fpPassword.add(pswrdtxtbxContrasea);

		FlowPanel fpRPassword = new FlowPanel();
		fpRPassword.setStyleName("formElementHorizontal");
		fpNewUserBox.add(fpRPassword);

		Label lblRepetirContrasea = new Label("Repetir contrase\u00F1a");
		fpRPassword.add(lblRepetirContrasea);

		pswrdtxtbxRepetirContrasea = new PasswordTextBox();
		pswrdtxtbxRepetirContrasea.setTabIndex(1);
		pswrdtxtbxRepetirContrasea.setStyleName("gwt-TextBox");
		fpRPassword.add(pswrdtxtbxRepetirContrasea);

		FlowPanel fpButtons = new FlowPanel();
		fpButtons.setStyleName("fpButtons");
		fpNewUserBox.add(fpButtons);

		FlowPanel fpCancel = new FlowPanel();
		fpButtons.add(fpCancel);

		btnCancelar = new Button("Cancelar");
		btnCancelar.setTabIndex(3);
		fpCancel.add(btnCancelar);
		btnCancelar.setStyleName("button negative");

		FlowPanel fpCreate = new FlowPanel();
		fpButtons.add(fpCreate);

		btnCrearUsuario = new Button("Crear usuario");
		btnCrearUsuario.setTabIndex(2);
		fpCreate.add(btnCrearUsuario);
		btnCrearUsuario.setStyleName("button positive primary");
		KeyUpHandler enterHandler = new KeyUpHandler(){
			public void onKeyUp(KeyUpEvent arg0) {
				if (arg0.getNativeKeyCode() == KeyCodes.KEY_ENTER){
					btnCrearUsuario.click();
				}
			}
		};
		txtbxNombre.addKeyUpHandler(enterHandler);
		txtbxEmail.addKeyUpHandler(enterHandler);
		txtbxPas.addKeyUpHandler(enterHandler);
		txtbxCiudad.addKeyUpHandler(enterHandler);
		txtbxApellidos.addKeyUpHandler(enterHandler);
		pswrdtxtbxRepetirContrasea.addKeyUpHandler(enterHandler);
		pswrdtxtbxContrasea.addKeyUpHandler(enterHandler);
	}

	public HasClickHandlers getAcceptButton() {
		return btnCrearUsuario;
	}

	public HasClickHandlers getCancelButton() {
		return btnCancelar;
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
		return pswrdtxtbxContrasea;
	}

	public HasValue<String> getCheckPassword() {
		return pswrdtxtbxRepetirContrasea;
	}
	
	public void showErrorMessage(String message){
		FlowPanel fpNotification = new FlowPanel();
		fpNotification.setStyleName("notification notificationError");
		
		Label lblNotificationMessage = new Label(message);
		fpNotification.add(lblNotificationMessage);
		
		flowPanel.add(fpNotification);
	}

}
