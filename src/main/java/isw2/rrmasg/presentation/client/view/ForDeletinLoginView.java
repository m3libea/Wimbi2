package isw2.rrmasg.presentation.client.view;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ForDeletinLoginView extends Composite {//implements LoginPresenter.Display {

	private TextBox tbEmail;
	private PasswordTextBox tbPassword;
	private Button btnAddUser;
	private Button btnLogin;
	private Label lblEmail;

	public ForDeletinLoginView() {

		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);

		Label lblPassword = new Label("Contrase\u00F1a");
		layoutPanel.add(lblPassword);
		layoutPanel.setWidgetLeftWidth(lblPassword, 116.0, Unit.PX, 78.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(lblPassword, 100.0, Unit.PX, 18.0,
				Unit.PX);

		tbEmail = new TextBox();
		layoutPanel.add(tbEmail);
		layoutPanel.setWidgetLeftWidth(tbEmail, 214.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbEmail, 69.0, Unit.PX, 25.0, Unit.PX);

		tbPassword = new PasswordTextBox();
		layoutPanel.add(tbPassword);
		layoutPanel.setWidgetLeftWidth(tbPassword, 214.0, Unit.PX, 131.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(tbPassword, 100.0, Unit.PX, 25.0,
				Unit.PX);

		btnAddUser = new Button("Crear usuario");
		layoutPanel.add(btnAddUser);
		layoutPanel.setWidgetLeftWidth(btnAddUser, 103.0, Unit.PX, 99.0,
				Unit.PX);
		layoutPanel.setWidgetTopHeight(btnAddUser, 156.0, Unit.PX, 24.0,
				Unit.PX);

		btnLogin = new Button("Iniciar sesi\u00F3n");
		layoutPanel.add(btnLogin);
		layoutPanel.setWidgetLeftWidth(btnLogin, 246.0, Unit.PX, 99.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnLogin, 156.0, Unit.PX, 24.0, Unit.PX);
		
		lblEmail = new Label("Email");
		layoutPanel.add(lblEmail);
		layoutPanel.setWidgetLeftWidth(lblEmail, 116.0, Unit.PX, 78.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblEmail, 69.0, Unit.PX, 18.0, Unit.PX);
	}

	public HasClickHandlers getLoginButton() {
		return btnLogin;
	}

	public HasClickHandlers getNewUserButton() {
		return btnAddUser;
	}

	public HasValue<String> getEmailAddress() {
		return tbEmail;
	}

	public HasValue<String> getPassword() {
		return tbPassword;
	}

	public Widget asWidget() {
		return this;
	}

	public HasClickHandlers getTwitterButton() {
		return null;
	}
}
