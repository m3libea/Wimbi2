package isw2.rrmasg.presentation.client.presenter;

import isw2.rrmasg.presentation.client.event.GoToCreateNewUserEvent;
import isw2.rrmasg.presentation.client.event.LoginEvent;
import isw2.rrmasg.presentation.client.services.UserServiceAsync;
import isw2.rrmasg.presentation.shared.exceptions.NotEmailException;
import isw2.rrmasg.presentation.shared.exceptions.UserNotFoundException;
import isw2.rrmasg.presentation.shared.exceptions.WrongPasswordException;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class LoginPresenter implements Presenter {

	public interface Display {
		HasClickHandlers getLoginButton();

		HasClickHandlers getNewUserButton();

		HasClickHandlers getTwitterButton();

		HasValue<String> getEmailAddress();

		HasValue<String> getPassword();

		HasValue<Boolean> getRemember();

		void showErrorMessage(String message);
		
		void showLoading(String message);
		
		void hideLoading();

		Widget asWidget();
	}

	private UserServiceAsync rcpService;
	private final HandlerManager eventBus;
	private final Display display;

	public LoginPresenter(UserServiceAsync rcpService, HandlerManager eventBus,
			Display display) {
		this.rcpService = rcpService;
		this.eventBus = eventBus;
		this.display = display;
	}

	public void bind() {
		display.getNewUserButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToCreateNewUserEvent());
			}
		});

		display.getLoginButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				((UIObject) display.getEmailAddress()).setStyleName("tbError", false);
				((UIObject) display.getPassword()).setStyleName("tbError", false);
				rcpService.loginUser(display.getEmailAddress().getValue(),
						display.getPassword().getValue(),
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								try {
									throw caught;
								} catch (UserNotFoundException e) {
									((UIObject) display.getEmailAddress())
											.setStyleName("tbError", true);
									display.showErrorMessage("Email incorrecto");
								} catch (WrongPasswordException e) {
									((UIObject) display.getPassword())
											.setStyleName("tbError", true);
									display.showErrorMessage("Contrase\u00f1a incorrecta");
								} catch (NotEmailException e) {
									display.showErrorMessage("Email incorrecto");
									((UIObject) display.getEmailAddress())
											.setStyleName("tbError", true);
								} catch (IllegalArgumentException e) {
									display.showErrorMessage("Introduzca el email y la contrase\u00f1a");
									((UIObject) display.getEmailAddress())
											.setStyleName("tbError", true);
									((UIObject) display.getPassword())
											.setStyleName("tbError", true);
								} catch (Throwable e) {
									display.showErrorMessage("Imposible completar la operaci\u00f3n");
								}
							}

							public void onSuccess(String sessionId) {
								if (display.getRemember().getValue()) {
									final long DURATION = 1000 * 60 * 60 * 24
											* 14;
									Date expires = new Date(System
											.currentTimeMillis() + DURATION);
									Cookies.setCookie("sid", sessionId,
											expires, null, "/", false);
								}
								Cookies.setCookie("tmpsid", sessionId);
								eventBus.fireEvent(new LoginEvent(sessionId));
							}
						});
			}
		});

		if (display.getTwitterButton() != null) {
			display.getTwitterButton().addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent arg0) {
					Window.Location.assign("/wimbi/twitterAuth");
				}

			});
		}
	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

}
