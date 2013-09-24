package isw2.rrmasg.presentation.client.presenter;

import isw2.rrmasg.presentation.client.event.GoBackEvent;
import isw2.rrmasg.presentation.client.event.LoginEvent;
import isw2.rrmasg.presentation.client.services.UserServiceAsync;
import isw2.rrmasg.presentation.shared.exceptions.DifferentsPasswordException;
import isw2.rrmasg.presentation.shared.exceptions.NotEmailException;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

public class NewUserPresenter implements Presenter {

	public interface Display {
		HasClickHandlers getAcceptButton();

		HasClickHandlers getCancelButton();

		HasValue<String> getName();

		HasValue<String> getEmailAddress();

		HasValue<String> getPassword();

		HasValue<String> getCheckPassword();

		HasValue<String> getSurname();

		HasValue<String> getCity();

		HasValue<String> getCountry();

		void showErrorMessage(String message);

		Widget asWidget();
	}

	private UserServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;

	public NewUserPresenter(UserServiceAsync rpcService,
			HandlerManager eventBus, Display display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
	}

	public void bind() {
		display.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoBackEvent());
			}
		});

		display.getAcceptButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				((UIObject) display.getName()).setStyleName("tbError", false);
				((UIObject) display.getSurname())
						.setStyleName("tbError", false);
				((UIObject) display.getCity()).setStyleName("tbError", false);
				((UIObject) display.getCountry())
						.setStyleName("tbError", false);
				((UIObject) display.getEmailAddress()).setStyleName("tbError",
						false);
				((UIObject) display.getPassword()).setStyleName("tbError",
						false);
				((UIObject) display.getCheckPassword()).setStyleName("tbError",
						false);
				rpcService.createNativeUser(display.getEmailAddress()
						.getValue(), display.getPassword().getValue(), display
						.getCheckPassword().getValue(), display.getName()
						.getValue(), display.getSurname().getValue(), display
						.getCity().getValue(), display.getCountry().getValue(),
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								try {
									throw caught;
								} catch (IllegalArgumentException e) {
									display.showErrorMessage("Todos los campos son obligatorios");
									if (display.getName().getValue().isEmpty())
										((UIObject) display.getName())
												.setStyleName("tbError", true);
									if (display.getSurname().getValue()
											.isEmpty())
										((UIObject) display.getSurname())
												.setStyleName("tbError", true);
									if (display.getCity().getValue().isEmpty())
										((UIObject) display.getCity())
												.setStyleName("tbError", true);
									if (display.getCountry().getValue()
											.isEmpty())
										((UIObject) display.getCountry())
												.setStyleName("tbError", true);
									if (display.getEmailAddress().getValue()
											.isEmpty())
										((UIObject) display.getEmailAddress())
												.setStyleName("tbError", true);
									if (display.getPassword().getValue()
											.isEmpty())
										((UIObject) display.getPassword())
												.setStyleName("tbError", true);
									if (display.getCheckPassword().getValue()
											.isEmpty())
										((UIObject) display.getCheckPassword())
												.setStyleName("tbError", true);
								} catch (DifferentsPasswordException e) {
									display.showErrorMessage("Las contrase\u00f1as escritas no coinciden");
									((UIObject) display.getPassword())
											.setStyleName("tbError", true);
									((UIObject) display.getCheckPassword())
											.setStyleName("tbError", true);
								} catch (NotEmailException e) {
									display.showErrorMessage("Direcci\u00f3n de correo no v\u00e1lida");
									((UIObject) display.getEmailAddress())
											.setStyleName("tbError", true);
								} catch (Throwable e) {
									display.showErrorMessage("La direcci\u00f3n de correo ya est\u00e1 en uso");
								}
							}

							public void onSuccess(String sessionId) {
								Cookies.setCookie("tmpsid", sessionId);
								eventBus.fireEvent(new LoginEvent(sessionId));
							}
						});
			}
		});
	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

}
