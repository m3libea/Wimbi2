package isw2.rrmasg.presentation.client.view;

import isw2.rrmasg.presentation.client.presenter.NewUserPresenter;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class ForDeletingNewUserView extends Composite implements NewUserPresenter.Display {
	private TextBox tbEmail;
	private TextBox tbName;
	private TextBox tbPassword;
	private TextBox tbCheckingPassword;
	private TextBox tbSurname;
	private TextBox tbCity;
	private TextBox tbCountry;
	private Button btnCancel;
	private Button btnConfirm;
	public ForDeletingNewUserView() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("532px", "368px");
		
		Label lblName = new Label("Nombre");
		layoutPanel.add(lblName);
		layoutPanel.setWidgetLeftWidth(lblName, 47.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblName, 39.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblEmail = new Label("Email");
		layoutPanel.add(lblEmail);
		layoutPanel.setWidgetLeftWidth(lblEmail, 47.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblEmail, 111.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblPassword = new Label("Contrase\u00F1a");
		layoutPanel.add(lblPassword);
		layoutPanel.setWidgetLeftWidth(lblPassword, 47.0, Unit.PX, 73.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblPassword, 144.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblCheckingPassword = new Label("Repeat Password");
		layoutPanel.add(lblCheckingPassword);
		layoutPanel.setWidgetLeftWidth(lblCheckingPassword, 47.0, Unit.PX, 123.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblCheckingPassword, 187.0, Unit.PX, 18.0, Unit.PX);
		
		tbName = new TextBox();
		tbName.setTabIndex(1);
		tbName.setFocus(true);
		layoutPanel.add(tbName);
		layoutPanel.setWidgetLeftWidth(tbName, 197.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbName, 39.0, Unit.PX, 25.0, Unit.PX);
		
		tbEmail = new TextBox();
		tbEmail.setTabIndex(3);
		layoutPanel.add(tbEmail);
		layoutPanel.setWidgetLeftWidth(tbEmail, 197.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbEmail, 111.0, Unit.PX, 25.0, Unit.PX);
		
		tbPassword = new PasswordTextBox();
		tbPassword.setTabIndex(4);
		layoutPanel.add(tbPassword);
		layoutPanel.setWidgetLeftWidth(tbPassword, 197.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbPassword, 144.0, Unit.PX, 25.0, Unit.PX);
		
		tbCheckingPassword = new PasswordTextBox();
		tbCheckingPassword.setTabIndex(5);
		layoutPanel.add(tbCheckingPassword);
		layoutPanel.setWidgetLeftWidth(tbCheckingPassword, 197.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbCheckingPassword, 180.0, Unit.PX, 25.0, Unit.PX);
		
		btnCancel = new Button("Cancel");
		btnCancel.setText("Cancelar");
		layoutPanel.add(btnCancel);
		layoutPanel.setWidgetLeftWidth(btnCancel, 120.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnCancel, 326.0, Unit.PX, 24.0, Unit.PX);
		
		btnConfirm = new Button("Confirm");
		btnConfirm.setText("Aceptar");
		btnConfirm.setTabIndex(8);
		layoutPanel.add(btnConfirm);
		layoutPanel.setWidgetLeftWidth(btnConfirm, 315.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnConfirm, 326.0, Unit.PX, 24.0, Unit.PX);
		
		Label lblApellido = new Label("Appellidos");
		layoutPanel.add(lblApellido);
		layoutPanel.setWidgetLeftWidth(lblApellido, 47.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblApellido, 77.0, Unit.PX, 18.0, Unit.PX);
		
		tbSurname = new TextBox();
		tbSurname.setTabIndex(2);
		layoutPanel.add(tbSurname);
		layoutPanel.setWidgetLeftWidth(tbSurname, 197.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbSurname, 70.0, Unit.PX, 25.0, Unit.PX);
		
		Label lblCity = new Label("Ciudad");
		layoutPanel.add(lblCity);
		layoutPanel.setWidgetLeftWidth(lblCity, 47.0, Unit.PX, 123.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblCity, 224.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblCountry = new Label("Pa\u00EDs");
		layoutPanel.add(lblCountry);
		layoutPanel.setWidgetLeftWidth(lblCountry, 47.0, Unit.PX, 56.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblCountry, 255.0, Unit.PX, 18.0, Unit.PX);
		
		tbCity = new TextBox();
		tbCity.setTabIndex(6);
		layoutPanel.add(tbCity);
		layoutPanel.setWidgetLeftWidth(tbCity, 197.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbCity, 217.0, Unit.PX, 25.0, Unit.PX);
		
		tbCountry = new TextBox();
		tbCountry.setTabIndex(7);
		layoutPanel.add(tbCountry);
		layoutPanel.setWidgetLeftWidth(tbCountry, 197.0, Unit.PX, 131.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(tbCountry, 255.0, Unit.PX, 25.0, Unit.PX);
	}

	public HasClickHandlers getAcceptButton() {
		return btnConfirm;
	}


	public HasClickHandlers getCancelButton() {
		return btnCancel;
	}

	public HasValue<String> getName() {
		return tbName;
	}

	public HasValue<String> getEmailAddress() {
		return tbEmail;
	}

	public HasValue<String> getPassword() {
		return tbPassword;
	}

	public HasValue<String> getCheckPassword() {
		return tbCheckingPassword;
	}

	public HasValue<String> getSurname() {
		return tbSurname;
	}

	public HasValue<String> getCity() {
		return tbCity;
	}

	public HasValue<String> getCountry() {
		return tbCountry;
	}

	@Override
	public void showErrorMessage(String message) {
		// TODO Auto-generated method stub
		
	}

}
