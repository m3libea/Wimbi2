package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.client.presenter.LoginPresenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HTML;

public class LoginView extends Composite implements LoginPresenter.Display {
	private TextBox txtbxEmail;
	private TextBox txtbxContrasea;
	private Button btnCrearUsuario;
	private Button btnIniciarSesin;
	private Button btnIniciaSesinCon;
	private CheckBox chckbxNoCerrarSesin;
	private FlowPanel flowPanel;
	FlowPanel htmlSpinner;

	public LoginView() {

		flowPanel = new FlowPanel();
		flowPanel.setStyleName("fpCenterContent");
		initWidget(flowPanel);
		
		htmlSpinner = new FlowPanel();
		flowPanel.add(htmlSpinner);

		FlowPanel fpLoginBox = new FlowPanel();
		flowPanel.add(fpLoginBox);
		fpLoginBox.setStyleName("loginBox");

		FlowPanel fpEmail = new FlowPanel();
		fpLoginBox.add(fpEmail);
		fpEmail.setStyleName("formElementHorizontal");

		Label lblEmail = new Label("Email");
		fpEmail.add(lblEmail);

		txtbxEmail = new TextBox();
		txtbxEmail.setTabIndex(1);
		fpEmail.add(txtbxEmail);

		FlowPanel fpPassword = new FlowPanel();
		fpLoginBox.add(fpPassword);
		fpPassword.setStyleName("formElementHorizontal");

		Label lblContrasea = new Label("Contrase\u00F1a");
		fpPassword.add(lblContrasea);

		txtbxContrasea = new PasswordTextBox();
		txtbxContrasea.setTabIndex(1);
		txtbxContrasea.setStyleName("gwt-TextBox");
		fpPassword.add(txtbxContrasea);

		FlowPanel fpSession = new FlowPanel();
		fpLoginBox.add(fpSession);
		fpSession.setStyleName("formElementHorizontal boxContainerRight");

		chckbxNoCerrarSesin = new CheckBox("No cerrar sesi\u00F3n");
		chckbxNoCerrarSesin.setTabIndex(1);
		fpSession.add(chckbxNoCerrarSesin);

		FlowPanel fpButtons = new FlowPanel();
		fpLoginBox.add(fpButtons);
		fpButtons.setStyleName("fpButtons");

		FlowPanel fpCreate = new FlowPanel();
		fpCreate.setStyleName("fpCreate");
		fpButtons.add(fpCreate);

		btnCrearUsuario = new Button("Crear usuario");
		btnCrearUsuario.setTabIndex(3);
		fpCreate.add(btnCrearUsuario);
		btnCrearUsuario.setStyleName("button");

		FlowPanel fpLogin = new FlowPanel();
		fpButtons.add(fpLogin);
		fpLogin.setStyleName("fpLogin");

		btnIniciarSesin = new Button("Iniciar sesi\u00F3n");
		btnIniciarSesin.setTabIndex(2);
		fpLogin.add(btnIniciarSesin);
		btnIniciarSesin.setStyleName("button primary positive");

		btnIniciaSesinCon = new Button(
				"<span>Inicia sesi\u00F3n con Twitter</span>");
		btnIniciaSesinCon.setTabIndex(4);
		flowPanel.add(btnIniciaSesinCon);
		btnIniciaSesinCon.setStyleName("social_buttons sb_twitter sb_24");

		KeyUpHandler enterHandler = new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent arg0) {
				if (arg0.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					btnIniciarSesin.click();
				}
			}
		};
		txtbxContrasea.addKeyUpHandler(enterHandler);
		txtbxEmail.addKeyUpHandler(enterHandler);
		chckbxNoCerrarSesin.addKeyUpHandler(enterHandler);
	}

	public HasClickHandlers getLoginButton() {
		return btnIniciarSesin;
	}

	public HasClickHandlers getNewUserButton() {
		return btnCrearUsuario;
	}

	public HasClickHandlers getTwitterButton() {
		return btnIniciaSesinCon;
	}

	public HasValue<String> getEmailAddress() {
		return txtbxEmail;
	}

	public HasValue<String> getPassword() {
		return txtbxContrasea;
	}

	public HasValue<Boolean> getRemember() {
		return chckbxNoCerrarSesin;
	}

	public void showErrorMessage(String message) {
		FlowPanel fpNotification = new FlowPanel();
		fpNotification.setStyleName("notification notificationError");

		Label lblNotificationMessage = new Label(message);
		fpNotification.add(lblNotificationMessage);

		flowPanel.add(fpNotification);
	}
	
	public void showLoading(String message){
		htmlSpinner.setStyleName("loadingAllPage");
		HTML html = new HTML();
		html.setHTML("<div class=\"spinner\">"
				+ "<div class=\"bar1\"></div>" + "<div class=\"bar2\"></div> "
				+ "<div class=\"bar3\"></div> " + "<div class=\"bar4\"></div> "
				+ "<div class=\"bar5\"></div> " + "<div class=\"bar6\"></div> "
				+ "<div class=\"bar7\"></div> " + "<div class=\"bar8\"></div> "
				+ "<div class=\"bar9\"></div> " + "<div class=\"bar10\"></div> "
				+ "<div class=\"bar11\"></div> " + "<div class=\"bar12\"></div> "
				+ "</div>");
		Label lblMessage = new Label("caca");
		htmlSpinner.add(html);
		htmlSpinner.add(lblMessage);
		System.out.println("Mostrando");
	}
	
	public void hideLoading(){
		//htmlSpinner.removeFromParent();
		System.out.println("Ocultando");
	}

}
