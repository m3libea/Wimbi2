package isw2.rrmasg.presentation.client.presenter;

import isw2.rrmasg.presentation.client.event.GoBackEvent;
import isw2.rrmasg.presentation.client.event.GoToListOfPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchPlaylistEvent;
import isw2.rrmasg.presentation.client.event.GoToSearchSongEvent;
import isw2.rrmasg.presentation.client.event.LogoutEvent;
import isw2.rrmasg.presentation.client.services.UserServiceAsync;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.DifferentsPasswordException;
import isw2.rrmasg.presentation.shared.exceptions.NotEmailException;
import isw2.rrmasg.presentation.shared.exceptions.NotUserInSessionException;
import isw2.rrmasg.presentation.shared.exceptions.WrongPasswordException;
import isw2.rrmasg.presentation.shared.exceptions.WrongSessionIdException;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class EditUserPresenter implements Presenter {

	public interface Display {

		HasClickHandlers getPlaylistsButton();

		HasClickHandlers getSearchSongButton();

		HasClickHandlers getSearchPlaylistButton();

		HasClickHandlers getCancelButton();

		HasClickHandlers getConfirmButton();

		HasClickHandlers getLogout();

		HasValue<String> getName();

		HasValue<String> getSurname();

		HasValue<String> getEmail();

		HasValue<String> getCity();

		HasValue<String> getCountry();

		HasValue<String> getPassword();

		HasValue<String> getNPassword();

		HasValue<String> getRNPassword();

		Widget asWidget();

	}

	private UserServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private final String sessionId;
	private UserDTO user;

	public EditUserPresenter(UserServiceAsync rpcService,
			HandlerManager eventBus, Display display) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		sessionId = Cookies.getCookie("tmpsid");
	}

	private void bind() {

		display.getSearchSongButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToSearchSongEvent());
			}
		});

		display.getSearchPlaylistButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToSearchPlaylistEvent());
			}
		});
		display.getPlaylistsButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoToListOfPlaylistEvent());
			}
		});

		display.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new GoBackEvent());
			}
		});

		display.getLogout().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new LogoutEvent());
			}
		});

		rpcService.getLoggedUser(sessionId, new AsyncCallback<UserDTO>() {
			public void onFailure(Throwable caught) {
				try {
					throw caught;
				} catch (WrongSessionIdException e) {
					Window.alert("Error validando la sesi\u00f3n.");
					eventBus.fireEvent(new LogoutEvent());
				} catch (Throwable e) {
					Window.alert("No se ha podido completar la operaci\u00f3n.");
				}

			}

			public void onSuccess(UserDTO result) {
				display.getName().setValue(result.getName());
				display.getSurname().setValue(result.getSurname());
				display.getEmail().setValue(result.getEmail());
				display.getCity().setValue(result.getCity());
				display.getCountry().setValue(result.getCountry());
				user = result;
			}

		});

		display.getConfirmButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {

				if (!user.getName().equals(display.getName().getValue())
						|| !user.getSurname().equals(
								display.getSurname().getValue())
						|| !user.getCity().equals(display.getCity().getValue())
						|| !user.getCountry().equals(
								display.getCountry().getValue())) {

					rpcService.editUserData(display.getName().getValue(),
							display.getSurname().getValue(), display.getCity()
									.getValue(), display.getCountry()
									.getValue(), sessionId,
							new AsyncCallback<UserDTO>() {

								public void onFailure(Throwable caught) {
									try {
										throw caught;
									} catch (IllegalArgumentException e) {
										Window.alert("Todos los campos son obligatorios.");
									} catch (NotUserInSessionException e) {
										Window.alert("No hay usuario conectado.");
									} catch (WrongSessionIdException e) {
										Window.alert("Error validando la sesi\u00f3n.");
										eventBus.fireEvent(new LogoutEvent());
									} catch (Throwable e) {
										Window.alert("No se ha podido completar la operaci\u00f3n.");
									}
								}

								public void onSuccess(UserDTO arg0) {
									Window.alert("Los datos se han cambiado correctamente.");
								}

							});
				}

				if (!user.getEmail().equals(display.getEmail().getValue())) {
					rpcService.editUserEmail(display.getPassword().getValue(),
							display.getEmail().getValue(), sessionId,
							new AsyncCallback<Void>() {

								public void onFailure(Throwable caught) {
									try {
										throw caught;
									} catch (IllegalArgumentException e) {
										Window.alert("Es necesario que introduzca su contrase\u00f1a.");
									} catch (WrongPasswordException e) {
										Window.alert("Contrase\u00f1a incorrecta.");
									} catch (NotEmailException e) {
										Window.alert("Debe indicar el nuevo email.");
									} catch (NotUserInSessionException e) {
										Window.alert("No hay usuario conectado.");
									} catch (WrongSessionIdException e) {
										Window.alert("Error validando la sesi\u00f3n.");
										eventBus.fireEvent(new LogoutEvent());
									} catch (Throwable e) {
										Window.alert("No se ha podido completar la operaci\u00f3n.");
									}
								}

								public void onSuccess(Void arg0) {
									Window.alert("Email cambiado correctamente.");
								}
							});
				}

				if (!"".equals(display.getNPassword().getValue())) {
					if (!"".equals(display.getRNPassword().getValue())) {
						if (!display.getNPassword().getValue()
								.equals(display.getRNPassword().getValue())) {

							Window.alert("Las contrase\u00f1as no coinciden.");
						} else {
							rpcService.editUserPassword(display.getPassword()
									.getValue(), display.getNPassword()
									.getValue(), display.getRNPassword()
									.getValue(), sessionId,
									new AsyncCallback<Void>() {
										public void onFailure(Throwable caught) {
											try {
												throw caught;
											} catch (IllegalArgumentException e) {
												Window.alert("Todos los campos son obligatorios.");
											} catch (WrongPasswordException e) {
												Window.alert("Contrase\u00f1a incorrecta.");
											} catch (DifferentsPasswordException e) {
												Window.alert("Repite la nueva contrase\u00f1a.");
											} catch (NotUserInSessionException e) {
												Window.alert("No hay usuario conectado.");
											} catch (WrongSessionIdException e) {
												Window.alert("Error validando la sesi\u00f3n.");
												eventBus.fireEvent(new LogoutEvent());
											} catch (Throwable e) {
												Window.alert("No se ha podido completar la operaci\u00f3n.");
											}
										}

										public void onSuccess(Void arg0) {
											Window.alert("Contrase\u00f1a cambiada correctamente");
										}

									});
						}
					}

				}
			}
		});

	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

}
