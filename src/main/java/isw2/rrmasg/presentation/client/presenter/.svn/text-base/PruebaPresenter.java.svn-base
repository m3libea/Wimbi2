package isw2.rrmasg.presentation.client.presenter;

import isw2.rrmasg.presentation.client.event.GoToLoginEvent;
import isw2.rrmasg.presentation.client.event.LogoutEvent;
import isw2.rrmasg.presentation.client.services.PlaylistServiceAsync;
import isw2.rrmasg.presentation.client.services.SongServiceAsync;
import isw2.rrmasg.presentation.client.services.UserServiceAsync;
import isw2.rrmasg.presentation.client.view.PruebaEditUserView;
import isw2.rrmasg.presentation.client.view.PruebaPlaylistView;
import isw2.rrmasg.presentation.client.view.PruebaSearchPlaylistView;
import isw2.rrmasg.presentation.client.view.PruebaSearchSongView;
import isw2.rrmasg.presentation.client.view.PruebaSelectPlaylistView;
import isw2.rrmasg.presentation.client.view.PruebaSongView;
import isw2.rrmasg.presentation.shared.dtos.PlaylistDTO;
import isw2.rrmasg.presentation.shared.dtos.SongDTO;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.presentation.shared.exceptions.NotEmailException;
import isw2.rrmasg.presentation.shared.exceptions.NotUserInSessionException;
import isw2.rrmasg.presentation.shared.exceptions.WrongPasswordException;
import isw2.rrmasg.presentation.shared.exceptions.WrongSessionIdException;
import isw2.rrmasg.presentation.shared.exceptions.WrongUserException;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class PruebaPresenter implements Presenter {

	public interface Display {
		HasClickHandlers getEditUserButton();

		HasClickHandlers getCreatePlaylistButton();

		HasValue<String> getNewPlaylistName();

		void setUserPlaylists(List<PlaylistDTO> data);

		List<PlaylistDTO> getUserPlaylists();

		void addUserPlaylist(PlaylistDTO playlist);

		void deleteUserPlaylist(PlaylistDTO playlist);

		void changeUserPlaylist(PlaylistDTO oldPL, PlaylistDTO newPL);

		void setLoggedUser(UserDTO user);

		Widget asWidget();

		void showErrorMessage(String message);

		void showNotificationMessage(String message);

		SingleSelectionModel<PlaylistDTO> getPlaylistSelectionModel();

		void presentPlaylist(PruebaPlaylistView us);

		void presentSong(PruebaSongView sv);

		PlaylistDTO getFirstPlaylist();

		AbstractCell<PlaylistDTO> getPlaylistCell();

		void presentSelectPlaylist(PruebaSelectPlaylistView sp);

		void hideOverlay();

		void presentSearchSong(PruebaSearchSongView ss);

		HasClickHandlers getGoToSearchSongButton();

		HasClickHandlers getGoToSearchPlaylistButton();

		void presentSearchPlaylist(PruebaSearchPlaylistView sp);

		void presentEditUser(PruebaEditUserView ed);

		HasClickHandlers getLogoutButton();

	}

	private PlaylistServiceAsync playlistService;
	private UserServiceAsync userService;
	private SongServiceAsync songService;
	private final HandlerManager eventBus;
	private final Display display;
	private final String sessionId = Cookies.getCookie("tmpsid");
	private UserDTO loggedUser;
	private HandlerRegistration handlerDeletePL;
	private HandlerRegistration handlerSFromPL;
	private int searchSongMaxResults;
	private String searchSongToken;
	private int searchSongFirstResult;
	private int searchPlaylistFirstResult;
	private String searchPlaylistToken;
	private int searchPlaylistMaxResults;

	public PruebaPresenter(UserServiceAsync userService,
			PlaylistServiceAsync playlistService, SongServiceAsync songService,
			HandlerManager eventBus, Display display) {
		this.playlistService = playlistService;
		this.userService = userService;
		this.songService = songService;
		this.eventBus = eventBus;
		this.display = display;
	}

	private void bind() {
		userService.getLoggedUser(sessionId, new AsyncCallback<UserDTO>() {
			public void onFailure(Throwable caught) {
				try {
					throw caught;
				} catch (IllegalArgumentException e) {
					display.showErrorMessage("No se ha iniciado sesi\u00f3n");
					eventBus.fireEvent(new LogoutEvent());
				} catch (WrongUserException e) {
					display.showErrorMessage("No se puede borrar este usuario");
				} catch (NotUserInSessionException e) {
					display.showErrorMessage("No se ha iniciado sesi\u00f3n");
					eventBus.fireEvent(new LogoutEvent());
				} catch (WrongSessionIdException e) {
					display.showErrorMessage("Error validando la sesi\u00f3n");
					eventBus.fireEvent(new LogoutEvent());
				} catch (Throwable e) {
					display.showErrorMessage("Imposible completar la operaci\u00f3n");
				}
			}

			public void onSuccess(UserDTO result) {
				System.out.println("UserLoged");
				loggedUser = result;
				display.setLoggedUser(result);
			}
		});
		userService.getPlaylists(sessionId,
				new AsyncCallback<List<PlaylistDTO>>() {
					public void onFailure(Throwable caught) {
						try {
							throw caught;
						} catch (IllegalArgumentException e) {
							display.showErrorMessage("No ha seleccionado ninguna lista de reproducci\u00f3");
						} catch (NotUserInSessionException e) {
							display.showErrorMessage("No se ha iniciado sesi\u00f3n");
							eventBus.fireEvent(new LogoutEvent());
						} catch (WrongSessionIdException e) {
							display.showErrorMessage("Error validando la sesi\u00f3n");
							eventBus.fireEvent(new LogoutEvent());
						} catch (Throwable e) {
							display.showErrorMessage("Imposible completar la operaci\u00f3n");
						}
					}

					public void onSuccess(List<PlaylistDTO> playlists) {
						System.out.println("playlistyuju");
						display.setUserPlaylists(playlists);
					}
				});

		display.getGoToSearchSongButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				bindShowSearchSong();
			}
		});

		display.getGoToSearchPlaylistButton().addClickHandler(
				new ClickHandler() {
					public void onClick(ClickEvent arg0) {
						bindShowSearchPlaylist();
					}
				});

		display.getEditUserButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				bindShowEditUser();
			}
		});

		display.getLogoutButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new LogoutEvent());
			}
		});

		display.getCreatePlaylistButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				playlistService.createPlaylist(display.getNewPlaylistName()
						.getValue(), sessionId,
						new AsyncCallback<PlaylistDTO>() {
							public void onFailure(Throwable caught) {
								try {
									throw caught;
								} catch (IllegalArgumentException e) {
									display.showErrorMessage("Debe introducir un nombre para la lista de reproducci\u00f3");
								} catch (NotUserInSessionException e) {
									display.showErrorMessage("No se ha iniciado sesi\u00f3n");
									eventBus.fireEvent(new LogoutEvent());
								} catch (WrongSessionIdException e) {
									display.showErrorMessage("Error validando la sesi\u00f3n");
									eventBus.fireEvent(new LogoutEvent());
								} catch (Throwable e) {
									display.showErrorMessage("Imposible completar la operaci\u00f3n");
								}
							}

							public void onSuccess(PlaylistDTO playlist) {
								display.addUserPlaylist(playlist);
							}
						});
			}
		});

		display.getPlaylistSelectionModel().addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						PlaylistDTO selected = display
								.getPlaylistSelectionModel()
								.getSelectedObject();
						if (selected != null) {
							bindShowPlaylist(selected);
						}
					}
				});
		bindShowSearchSong();
	}

	private void bindShowPlaylist(final PlaylistDTO selected) {
		final PruebaPlaylistView us = new PruebaPlaylistView(selected,
				loggedUser);
		if (us.getDeletePlaylistButton() != null) {
			us.getDeletePlaylistButton().addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent arg0) {
					final String before = ((HasHTML) us
							.getDeletePlaylistButton()).getHTML();
					((HasHTML) us.getDeletePlaylistButton())
							.setText("Confirmar");
					final HandlerRegistration hr = us.getDeletePlaylistButton()
							.addClickHandler(new ClickHandler() {
								public void onClick(ClickEvent arg0) {
									playlistService.deletePlaylist(selected,
											sessionId,
											new AsyncCallback<Boolean>() {
												public void onFailure(
														Throwable arg0) {
													try {
														throw arg0;
													} catch (IllegalArgumentException e) {
														display.showErrorMessage("No ha seleccionado ninguna lista de reproducci\u00f3n");
													} catch (WrongUserException e) {
														display.showErrorMessage("No puede borrar esta lista de reproducci\u00f3n");
													} catch (NotUserInSessionException e) {
														display.showErrorMessage("No se ha iniciado sesi\u00f3n");
														eventBus.fireEvent(new LogoutEvent());
													} catch (WrongSessionIdException e) {
														display.showErrorMessage("Error validando la sesi\u00f3n");
														eventBus.fireEvent(new LogoutEvent());
													} catch (Throwable e) {
														display.showErrorMessage("Imposible completar la operaci\u00f3n");
													}
												}

												public void onSuccess(
														Boolean arg0) {
													if (arg0) {
														display.showNotificationMessage("Lista de reproducci\u00f3n eliminada");
														display.deleteUserPlaylist(selected);
														if (display
																.getFirstPlaylist() != null) {
															display.getPlaylistSelectionModel()
																	.setSelected(
																			display.getFirstPlaylist(),
																			true);
															bindShowPlaylist(display
																	.getFirstPlaylist());
														}
													} else {
														display.showErrorMessage("No se ha podido borrar la lista de reproducci\u00f3n");
													}
												}
											});
								}
							});
					handlerDeletePL = ((FocusWidget) us
							.getDeletePlaylistButton())
							.addMouseOutHandler(new MouseOutHandler() {
								public void onMouseOut(MouseOutEvent arg0) {
									((HasHTML) us.getDeletePlaylistButton())
											.setHTML(before);
									hr.removeHandler();
									handlerDeletePL.removeHandler();
								}
							});
				}
			});
		}
		if (us.getChangePlaylistNameButton() != null) {
			us.getChangePlaylistNameButton().addClickHandler(
					new ClickHandler() {
						public void onClick(ClickEvent arg0) {
							if (!us.getPlaylistName().getValue()
									.equals(selected.getName())) {
								playlistService.changePlaylistName(selected, us
										.getPlaylistName().getValue(),
										sessionId,
										new AsyncCallback<PlaylistDTO>() {
											public void onFailure(Throwable arg0) {
												try {
													throw arg0;
												} catch (NotUserInSessionException e) {
													display.showErrorMessage("No se ha iniciado sesi\u00f3n");
													eventBus.fireEvent(new LogoutEvent());
												} catch (IllegalArgumentException e) {
													display.showErrorMessage("No ha seleccionado ninguna lista de reproducci\u00f3n");
												} catch (WrongUserException e) {
													display.showErrorMessage("No puede cambair el nombre de esta lista de reproducci\u00f3n");
												} catch (WrongSessionIdException e) {
													display.showErrorMessage("Error validando la sesi\u00f3n");
													eventBus.fireEvent(new LogoutEvent());
												} catch (Throwable e) {
													display.showErrorMessage("Imposible completar la operaci\u00f3n");
												}
											}

											public void onSuccess(
													PlaylistDTO arg0) {
												display.changeUserPlaylist(
														selected, arg0);
												us.setPlaylist(arg0);
												display.showNotificationMessage("Se ha cambiado el nombre de la lista de reproducci\u00f3n.");
											}
										});
							}
						}
					});
		}

		us.getSongSelectionModel().addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						SongDTO selectedSong = us.getSongSelectionModel()
								.getSelectedObject();
						if (selected != null) {
							bindShowSong(selectedSong,
									us.getSongIndex(selectedSong), selected,
									PruebaSongView.USER_PLAYLIST, us);
						}
					}
				});

		display.presentPlaylist(us);

		playlistService.getSongs(selected, new AsyncCallback<List<SongDTO>>() {
			public void onFailure(Throwable arg0) {
				try {
					throw arg0;
				} catch (IllegalArgumentException e) {
					display.showErrorMessage("No ha seleccionado ninguna lista de reproducci\u00f3n");
				} catch (Throwable e) {
					display.showErrorMessage("Imposible completar la operaci\u00f3n");
				}
			}

			public void onSuccess(List<SongDTO> arg0) {
				us.setPlaylistSongs(arg0);
			}
		});
	}

	private void bindShowSong(final SongDTO selected, final int index,
			final PlaylistDTO plContext, int context,
			final PruebaPlaylistView us) {
		final PruebaSongView sv = new PruebaSongView(selected, context);

		if (sv.getDeleteFromPlaylistButton() != null) {
			sv.getDeleteFromPlaylistButton().addClickHandler(
					new ClickHandler() {
						public void onClick(ClickEvent arg0) {
							final String before = ((HasHTML) sv
									.getDeleteFromPlaylistButton()).getHTML();
							((HasHTML) sv.getDeleteFromPlaylistButton())
									.setText("Confirmar");
							final HandlerRegistration hr = sv
									.getDeleteFromPlaylistButton()
									.addClickHandler(new ClickHandler() {
										public void onClick(ClickEvent arg0) {
											playlistService
													.deleteSongFromPlaylist(
															plContext,
															index,
															sessionId,
															new AsyncCallback<SongDTO>() {
																public void onFailure(
																		Throwable arg0) {
																	try {
																		throw arg0;
																	} catch (IllegalArgumentException e) {
																		display.showErrorMessage("No ha seleccionado ninguna canci\u00f3n");
																	} catch (WrongUserException e) {
																		display.showErrorMessage("No puede borrar esta canci\u00f3n de la lista de reproducci\u00f3n");
																	} catch (NotUserInSessionException e) {
																		display.showErrorMessage("No se ha iniciado sesi\u00f3n");
																		eventBus.fireEvent(new LogoutEvent());
																	} catch (WrongSessionIdException e) {
																		display.showErrorMessage("Error validando la sesi\u00f3n");
																		eventBus.fireEvent(new LogoutEvent());
																	} catch (IndexOutOfBoundsException e) {
																		display.showErrorMessage("Imposible completar la operaci\u00f3n");
																	} catch (Throwable e) {
																		display.showErrorMessage("Imposible completar la operaci\u00f3n");
																	}
																}

																@Override
																public void onSuccess(
																		SongDTO arg0) {
																	display.showNotificationMessage("Canci\u00f3n eliminada de la lista de reproducci\u00f3n");
																	if (us != null) {
																		us.deleteSong(index);
																	}
																	bindShowSong(
																			arg0,
																			-1,
																			plContext,
																			PruebaSongView.SEARCH_SONG,
																			us);
																}

															});
										}
									});
							handlerSFromPL = ((FocusWidget) sv
									.getDeleteFromPlaylistButton())
									.addMouseOutHandler(new MouseOutHandler() {
										public void onMouseOut(
												MouseOutEvent arg0) {
											((HasHTML) sv
													.getDeleteFromPlaylistButton())
													.setHTML(before);
											handlerSFromPL.removeHandler();
											hr.removeHandler();
										}
									});
						}
					});
		}

		if (sv.getAddToPlaylistButton() != null) {
			sv.getAddToPlaylistButton().addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent arg0) {
					bindShowSelectPlaylist(selected, us);
				}
			});
		}

		display.presentSong(sv);
	}

	private void bindShowSelectPlaylist(final SongDTO songToAdd,
			final PruebaPlaylistView pv) {
		final PruebaSelectPlaylistView sp = new PruebaSelectPlaylistView();
		sp.setUserPlaylists(display.getUserPlaylists());

		sp.getPlaylistSelectionModel().addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						final PlaylistDTO selected = sp
								.getPlaylistSelectionModel()
								.getSelectedObject();
						if (selected != null) {
							playlistService.addSongToPlaylist(selected,
									songToAdd, sessionId,
									new AsyncCallback<Boolean>() {
										public void onFailure(Throwable arg0) {
											try {
												throw arg0;
											} catch (IllegalArgumentException e) {
												display.showErrorMessage("No ha seleccionado ninguna canci\u00f3n o lista de reproducci\u00f3n");
											} catch (WrongUserException e) {
												display.showErrorMessage("No puede a\u00f1adir esta canci\u00f3n de la lista de reproducci\u00f3n");
											} catch (NotUserInSessionException e) {
												display.showErrorMessage("No se ha iniciado sesi\u00f3n");
												eventBus.fireEvent(new LogoutEvent());
											} catch (WrongSessionIdException e) {
												display.showErrorMessage("Error validando la sesi\u00f3n");
												eventBus.fireEvent(new LogoutEvent());
											} catch (Throwable e) {
												display.showErrorMessage("Imposible completar la operaci\u00f3n");
											}
										}

										@Override
										public void onSuccess(Boolean arg0) {
											if (arg0) {
												display.showNotificationMessage("Se ha agregado la canci\u00f3n a la lista de reproducci\u00f3n");
												if (pv != null
														&& pv.getPlaylist()
																.getUniqueID()
																.equals(selected
																		.getUniqueID())) {
													pv.addSong(songToAdd);
												}
											} else {
												display.showErrorMessage("No se ha agregado la canci\u00f3n a la lista de reproducci\u00f3n");
											}

											display.hideOverlay();
										}

									});
						}
					}
				});

		display.presentSelectPlaylist(sp);
	}

	private void bindShowSearchSong() {
		final PruebaSearchSongView ss = new PruebaSearchSongView();
		ss.getSearchButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				searchSongToken = ss.getSearchToken().getValue();
				searchSongFirstResult = 0;
				searchSongMaxResults = 20;
				updateSearchSongResults(ss);
			}
		});

		ss.getNextButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				searchSongFirstResult = searchSongFirstResult + 20;
				updateSearchSongResults(ss);
			}
		});

		ss.getPreviousButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				searchSongFirstResult = searchSongFirstResult - 20;
				updateSearchSongResults(ss);
			}
		});

		ss.getSongSelectionModel().addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						SongDTO selectedSong = ss.getSongSelectionModel()
								.getSelectedObject();
						bindShowSong(selectedSong, -1, null,
								PruebaSongView.SEARCH_SONG, null);
					}
				});

		display.presentSearchSong(ss);

		songService.getAllSongs(new AsyncCallback<List<SongDTO>>() {
			public void onFailure(Throwable arg0) {
				try {
					throw arg0;
				} catch (Throwable e) {
					display.showErrorMessage("Imposible completar la operaci\u00f3n");
				}
			}

			public void onSuccess(List<SongDTO> arg0) {
				ss.setSearchSongs(arg0);
			}
		});
	}

	private void bindShowSearchPlaylist() {
		final PruebaSearchPlaylistView sp = new PruebaSearchPlaylistView();
		sp.getSearchButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				searchPlaylistToken = sp.getSearchToken().getValue();
				searchPlaylistFirstResult = 0;
				searchPlaylistMaxResults = 20;
				updateSearchPlaylistResults(sp);
			}
		});

		sp.getNextButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				searchPlaylistFirstResult = searchPlaylistFirstResult + 20;
				updateSearchPlaylistResults(sp);
			}
		});

		sp.getPreviousButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				searchPlaylistFirstResult = searchPlaylistFirstResult - 20;
				updateSearchPlaylistResults(sp);
			}
		});

		sp.getSongSelectionModel().addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						SongDTO selectedSong = sp.getSongSelectionModel()
								.getSelectedObject();
						bindShowSong(selectedSong, -1, null,
								PruebaSongView.SEARCH_SONG, null);
					}
				});

		sp.getPlaylistSelectionModel().addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						PlaylistDTO selected = sp.getPlaylistSelectionModel()
								.getSelectedObject();
						if (selected != null) {
							playlistService.getSongs(selected,
									new AsyncCallback<List<SongDTO>>() {
										public void onFailure(Throwable arg0) {
											try {
												throw arg0;
											} catch (IllegalArgumentException e) {
												display.showErrorMessage("No ha seleccionado ninguna canci\u00f3n o lista de reproducci\u00f3n");
											} catch (Throwable e) {
												display.showErrorMessage("Imposible completar la operaci\u00f3n");
											}
										}

										public void onSuccess(List<SongDTO> arg0) {
											sp.setSongsOfPlaylist(arg0);
										}
									});
						}
					}
				});
		sp.setSearchPlaylists(new LinkedList<PlaylistDTO>());
		sp.setSongsOfPlaylist(new LinkedList<SongDTO>());

		display.presentSearchPlaylist(sp);

	}

	private void bindShowEditUser() {
		final PruebaEditUserView ed = new PruebaEditUserView(loggedUser);
		if (ed.getAcceptButton() != null) {
			ed.getAcceptButton().addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent arg0) {

					if (!loggedUser.getName().equals(ed.getName().getValue())
							|| !loggedUser.getSurname().equals(
									ed.getSurname().getValue())
							|| !loggedUser.getCity().equals(
									ed.getCity().getValue())
							|| !loggedUser.getCountry().equals(
									ed.getCountry().getValue())) {

						userService.editUserData(ed.getName().getValue(), ed
								.getSurname().getValue(), ed.getCity()
								.getValue(), ed.getCountry().getValue(),
								sessionId, new AsyncCallback<UserDTO>() {

									public void onFailure(Throwable caught) {
										try {
											throw caught;
										} catch (IllegalArgumentException e) {
											display.showErrorMessage("Todos los campos son obligatorios");
										} catch (NotUserInSessionException e) {
											display.showErrorMessage("No se ha iniciado sesi\u00f3n");
											eventBus.fireEvent(new LogoutEvent());
										} catch (WrongSessionIdException e) {
											display.showErrorMessage("Error validando la sesi\u00f3n");
											eventBus.fireEvent(new LogoutEvent());
										} catch (Throwable e) {
											display.showErrorMessage("Imposible completar la operaci\u00f3n");
										}
									}

									public void onSuccess(UserDTO arg0) {
										loggedUser = arg0;
										display.setLoggedUser(arg0);
										display.showNotificationMessage("Los datos se han modificado correctamente.");
										if (!(ed.getNewPassword().getValue() != null && !""
												.equals(ed.getNewPassword()
														.getValue()))
												&& !(ed.getEmailAddress()
														.getValue() != null
														&& !"".equals(ed
																.getEmailAddress()
																.getValue()) && !loggedUser
														.getEmail()
														.equals(ed
																.getEmailAddress()
																.getValue()))) {
											display.hideOverlay();
										}
									}

								});
					}

					if (ed.getEmailAddress().getValue() != null
							&& !"".equals(ed.getEmailAddress().getValue())
							&& !loggedUser.getEmail().equals(
									ed.getEmailAddress().getValue())) {
						userService.editUserEmail(ed.getPassword().getValue(),
								ed.getEmailAddress().getValue(), sessionId,
								new AsyncCallback<Void>() {

									public void onFailure(Throwable caught) {
										try {
											throw caught;
										} catch (IllegalArgumentException e) {
											((UIObject) ed.getPassword())
													.setStyleName("tbError",
															true);
											display.showErrorMessage("Es necesario que introduzca la contrase\u00f1a");
										} catch (NotUserInSessionException e) {
											display.showErrorMessage("No se ha iniciado sesi\u00f3n");
											eventBus.fireEvent(new LogoutEvent());
										} catch (WrongSessionIdException e) {
											display.showErrorMessage("Error validando la sesi\u00f3n");
											eventBus.fireEvent(new LogoutEvent());
										} catch (WrongPasswordException e) {
											display.showErrorMessage("La contrase\u00f1a no es correcta");
										} catch (NotEmailException e) {
											display.showErrorMessage("El email introducido no es v\u00f2lido");
										} catch (Throwable e) {
											display.showErrorMessage("Imposible completar la operaci\u00f3n");
										}
									}

									public void onSuccess(Void arg0) {
										display.showNotificationMessage("Email modificado correctamente");
										if (!(ed.getNewPassword().getValue() != null && !""
												.equals(ed.getNewPassword()
														.getValue()))) {
											display.hideOverlay();
										}
									}
								});
					}

					if (ed.getNewPassword().getValue() != null
							&& !"".equals(ed.getNewPassword().getValue())) {
						if (!"".equals(ed.getCheckNewPassword().getValue())) {
							if (!ed.getNewPassword()
									.getValue()
									.equals(ed.getCheckNewPassword().getValue())) {

								display.showErrorMessage("Las contrase\u00f1as no coinciden");
								((UIObject) ed.getNewPassword()).setStyleName(
										"tbError", true);
								((UIObject) ed.getCheckNewPassword())
										.setStyleName("tbError", true);

							} else {
								userService.editUserPassword(ed.getPassword()
										.getValue(), ed.getNewPassword()
										.getValue(), ed.getCheckNewPassword()
										.getValue(), sessionId,
										new AsyncCallback<Void>() {
											public void onFailure(
													Throwable caught) {
												try {
													System.out
															.println("Porke T.T");

													throw caught;
												} catch (IllegalArgumentException e) {
													display.showErrorMessage("Es necesario que introduzca la contrase\u00f1a");
													((UIObject) ed
															.getPassword())
															.setStyleName(
																	"tbError",
																	true);
													((UIObject) ed
															.getNewPassword())
															.setStyleName(
																	"tbError",
																	true);
													((UIObject) ed
															.getCheckNewPassword())
															.setStyleName(
																	"tbError",
																	true);
												} catch (NotUserInSessionException e) {
													display.showErrorMessage("No se ha iniciado sesi\u00f3n");
													eventBus.fireEvent(new LogoutEvent());
												} catch (WrongSessionIdException e) {
													display.showErrorMessage("Error validando la sesi\u00f3n");
													eventBus.fireEvent(new LogoutEvent());
												} catch (WrongPasswordException e) {
													display.showErrorMessage("La contrase\u00f1a no es correcta");
												} catch (Throwable e) {
													display.showErrorMessage("Imposible completar la operaci\u00f3n");
												}
											}

											public void onSuccess(Void arg0) {
												display.showNotificationMessage("Contrase\u00f1a modificada correctamente");
												display.hideOverlay();
											}

										});
							}
						}
					}
				}
			});
		}
		if (ed.getCancelButton() != null) {
			ed.getCancelButton().addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent arg0) {
					display.hideOverlay();
				}
			});
		}

		if (ed.getCancelButton() != null) {
			ed.getDeleteUserButton().addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent arg0) {
					final String before = ((HasHTML) ed.getDeleteUserButton())
							.getHTML();
					((HasHTML) ed.getDeleteUserButton()).setText("Confirmar");
					final HandlerRegistration hr = ed.getDeleteUserButton()
							.addClickHandler(new ClickHandler() {
								public void onClick(ClickEvent arg0) {
									userService.deleteUser(ed.getPassword()
											.getValue(), sessionId,
											new AsyncCallback<Boolean>() {

												public void onFailure(
														Throwable arg0) {
													try {
														throw arg0;
													} catch (IllegalArgumentException e) {
														display.showErrorMessage("Es necesario que introduzca la contrase\u00f1a");
														((UIObject) ed
																.getPassword())
																.setStyleName(
																		"tbError",
																		true);
													} catch (WrongUserException e) {
														display.showErrorMessage("No se puede borrar este usuario");
													} catch (NotUserInSessionException e) {
														display.showErrorMessage("No se ha iniciado sesi\u00f3n");
														eventBus.fireEvent(new LogoutEvent());
													} catch (WrongSessionIdException e) {
														display.showErrorMessage("Error validando la sesi\u00f3n");
														eventBus.fireEvent(new LogoutEvent());
													} catch (Throwable e) {
														display.showErrorMessage("Imposible completar la operaci\u00f3n");
													}
												}

												public void onSuccess(
														Boolean arg0) {
													if (arg0) {
														display.showNotificationMessage("Usuario eliminado correctamente");
														eventBus.fireEvent(new GoToLoginEvent());
													} else {
														display.showErrorMessage("No se ha podido eliminar el usuario");
													}
												}

											});
								}
							});
					handlerSFromPL = ((FocusWidget) ed.getDeleteUserButton())
							.addMouseOutHandler(new MouseOutHandler() {
								public void onMouseOut(MouseOutEvent arg0) {
									((HasHTML) ed.getDeleteUserButton())
											.setHTML(before);
									handlerSFromPL.removeHandler();
									hr.removeHandler();
								}
							});
				}

			});
		}
		if (ed.getDeleteNonNativeUserButton() != null) {
			ed.getDeleteNonNativeUserButton().addClickHandler(
					new ClickHandler() {
						public void onClick(ClickEvent arg0) {
							final String before = ((HasHTML) ed
									.getDeleteNonNativeUserButton()).getHTML();
							((HasHTML) ed.getDeleteNonNativeUserButton())
									.setText("Confirmar");
							final HandlerRegistration hr = ed
									.getDeleteNonNativeUserButton()
									.addClickHandler(new ClickHandler() {
										public void onClick(ClickEvent arg0) {
											userService
													.deleteUserNonNative(
															sessionId,
															new AsyncCallback<Boolean>() {

																public void onFailure(
																		Throwable arg0) {
																	try {
																		throw arg0;
																	} catch (IllegalArgumentException e) {

																	} catch (WrongUserException e) {
																		display.showErrorMessage("No se puede borrar este usuario");
																	} catch (NotUserInSessionException e) {
																		display.showErrorMessage("No se ha iniciado sesi\u00f3n");
																		eventBus.fireEvent(new LogoutEvent());
																	} catch (WrongSessionIdException e) {
																		display.showErrorMessage("Error validando la sesi\u00f3n");
																		eventBus.fireEvent(new LogoutEvent());
																	} catch (Throwable e) {
																		display.showErrorMessage("Imposible completar la operaci\u00f3n");
																	}
																}

																public void onSuccess(
																		Boolean arg0) {
																	if (arg0) {
																		display.showNotificationMessage("Usuario eliminado correctamente");
																		eventBus.fireEvent(new GoToLoginEvent());
																	} else {
																		display.showErrorMessage("No se ha podido eliminar el usuario");
																	}
																}

															});
										}
									});
							handlerSFromPL = ((FocusWidget) ed
									.getDeleteNonNativeUserButton())
									.addMouseOutHandler(new MouseOutHandler() {
										public void onMouseOut(
												MouseOutEvent arg0) {
											((HasHTML) ed
													.getDeleteNonNativeUserButton())
													.setHTML(before);
											handlerSFromPL.removeHandler();
											hr.removeHandler();
										}
									});
						}

					});
		}

		display.presentEditUser(ed);
	}

	private void updateSearchSongResults(final PruebaSearchSongView ss) {
		songService.searchSongs(searchSongToken, searchSongFirstResult,
				searchSongMaxResults, new AsyncCallback<List<SongDTO>>() {
					public void onFailure(Throwable arg0) {
						try {
							throw arg0;
						} catch (IllegalArgumentException e) {
							display.showErrorMessage("Imposible completar la operaci\u00f3n");
						} catch (Throwable e) {
							display.showErrorMessage("Imposible completar la operaci\u00f3n");
						}
					}

					public void onSuccess(List<SongDTO> arg0) {
						ss.setSearchSongs(arg0);
						ss.setEnabledNextButton(arg0.size() == searchSongMaxResults);
						ss.setEnabledPrevoiusButton(searchSongFirstResult != 0);
					}
				});
	}

	private void updateSearchPlaylistResults(final PruebaSearchPlaylistView sp) {
		playlistService.searchPlaylists(searchPlaylistToken,
				searchPlaylistFirstResult, searchPlaylistMaxResults,
				new AsyncCallback<List<PlaylistDTO>>() {
					public void onFailure(Throwable arg0) {
						try {
							throw arg0;
						} catch (IllegalArgumentException e) {
							display.showErrorMessage("Imposible completar la operaci\u00f3n");
						} catch (Throwable e) {
							display.showErrorMessage("Imposible completar la operaci\u00f3n");
						}
					}

					public void onSuccess(List<PlaylistDTO> arg0) {
						sp.setSearchPlaylists(arg0);
						sp.setEnabledNextButton(arg0.size() == searchPlaylistMaxResults);
						sp.setEnabledPrevoiusButton(searchPlaylistFirstResult != 0);
					}
				});
	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}
}
