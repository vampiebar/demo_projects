package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class DBSKayit extends Composite {
	private TextBox tctAranacakAnahtarKelime;
	private CellTable<XMLDBSKayit> grdDBSKayit;
	private DlgDBSYeniKayit _dlgDbsYeniKayit;
	private Button btnAra;
	private CheckBox chxSilinmisKayitlariGoster;

	public DBSKayit() {

		final Resources resources = GWT.create(Resources.class);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);
		horizontalPanel.setSize("100%", "750px");

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel.add(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel verticalPanel_1 = new HorizontalPanel();
		verticalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_1.setStyleName("gwt-LabelMor2");
		verticalPanel.add(verticalPanel_1);
		verticalPanel.setCellHeight(verticalPanel_1, "50px");
		verticalPanel_1.setSize("100%", "33px");

		Label lblNewLabel = new Label("DBS Kayıt");
		verticalPanel_1.add(lblNewLabel);
		verticalPanel_1.setCellVerticalAlignment(lblNewLabel,
				HasVerticalAlignment.ALIGN_MIDDLE);
		lblNewLabel.setWidth("100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "24");

		btnAra = new Button("");
		horizontalPanel_2.add(btnAra);
		btnAra.setVisible(false);
		btnAra.setTitle("Ara");
		btnAra.addClickHandler(new BtnAraClickHandler());

		btnAra.setStyleName("gwt-ButtonAra");
		btnAra.setText("");
		btnAra.setSize("56px", "21px");

		tctAranacakAnahtarKelime = new TextBox();
		tctAranacakAnahtarKelime
				.addKeyDownHandler(new TctAranacakAnahtarKelimeKeyDownHandler());
		tctAranacakAnahtarKelime
				.addValueChangeHandler(new TctAranacakAnahtarKelimeValueChangeHandler());
		tctAranacakAnahtarKelime
				.addFocusHandler(new TctAranacakAnahtarKelimeFocusHandler());
		horizontalPanel_2.add(tctAranacakAnahtarKelime);
		tctAranacakAnahtarKelime.setText("Ne Aramıştınız?");
		tctAranacakAnahtarKelime.setStyleName("gwt-TextBoxAra");
		tctAranacakAnahtarKelime.setSize("200px", "17px");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_3);
		verticalPanel.setCellHeight(horizontalPanel_3, "20px");

		chxSilinmisKayitlariGoster = new CheckBox("Silinmiş Kayıtları Göster");
		horizontalPanel_3.add(chxSilinmisKayitlariGoster);
		chxSilinmisKayitlariGoster
				.addClickHandler(new ChxSilinmisKayitlariGosterClickHandler());
		chxSilinmisKayitlariGoster.setSize("186px", "20px");

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		horizontalPanel_4.setSpacing(15);
		verticalPanel.add(horizontalPanel_4);
		verticalPanel.setCellHeight(horizontalPanel_4, "30px");
		horizontalPanel_4.setSize("100%", "48px");

		Button btnYeniKayit = new Button("");
		horizontalPanel_4.add(btnYeniKayit);
		horizontalPanel_3.setCellWidth(btnYeniKayit, "1000");
		horizontalPanel_2.setCellWidth(btnYeniKayit, "1200");
		btnYeniKayit.setText("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(10);
		horizontalPanel_1.setStyleName("gwt-LeftPadding");
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("100%", "104px");

		grdDBSKayit = new CellTable<XMLDBSKayit>();
		horizontalPanel_1.add(grdDBSKayit);
		grdDBSKayit.setSize("100%", "100%");

		TextColumn<XMLDBSKayit> textColumn_5 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.id.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_5, "İD");
		grdDBSKayit.setColumnWidth(textColumn_5, "27px");

		TextColumn<XMLDBSKayit> textColumn_1 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.adi.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_1, "Adı");
		grdDBSKayit.setColumnWidth(textColumn_1, "91px");

		TextColumn<XMLDBSKayit> textColumn_2 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.soyadi.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_2, "Soyadı");

		TextColumn<XMLDBSKayit> textColumn_7 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.tc_kimlik_no.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_7, "TC Kimlik No");
		grdDBSKayit.setColumnWidth(textColumn_7, "156px");

		TextColumn<XMLDBSKayit> textColumn_6 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.okul.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_6, "Okul Adı");
		grdDBSKayit.setColumnWidth(textColumn_6, "142px");

		TextColumn<XMLDBSKayit> textColumn = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return (object.sinav_tarihi);
			}
		};
		grdDBSKayit.addColumn(textColumn, "Sınav Zamanı");
		grdDBSKayit.setColumnWidth(textColumn, "128px");

		TextColumn<XMLDBSKayit> textColumn_4 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return "???";
			}
		};
		grdDBSKayit.addColumn(textColumn_4, "Oluşturma Zamanı");

		// Column<XMLDBSKayit, String> column = new Column<XMLDBSKayit, String>(
		// new ButtonCell()) {
		// @Override
		// public String getValue(XMLDBSKayit object) {
		// return "Düzenle";
		// }
		// };
		// grdDBSKayit.addColumn(column, "İşlemler");

		Column<XMLDBSKayit, ImageResource> imageColumn = new Column<XMLDBSKayit, ImageResource>(
				new ImageResourceCell()) {
			@Override
			public ImageResource getValue(XMLDBSKayit object) {
				return resources.getImageResource();
			}
		};

		grdDBSKayit.addColumn(imageColumn, "Düzenle");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLDBSKayit> selectionModel = new SingleSelectionModel<XMLDBSKayit>();

			grdDBSKayit.setSelectionModel(selectionModel);
			// grdDBSKayit.addDomHandler(new ClickHandler() {
			// @Override
			// public void onClick(ClickEvent event) {
			// CellTable<List<String>> selectedcell = (CellTable<List<String>>)
			// event
			// .getSource();
			// Window.alert("  Current Selected Row : "
			// + selectedcell.getKeyboardSelectedRow()
			// + selectedcell.getColumnCount());
			// }
			// }, ClickEvent.getType());

			grdDBSKayit.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLDBSKayit selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " +
						// selected.tc_kimlik_no);
						showWithData(selected.id);
						// showWithData(selected.tc_kimlik_no);

					}

				}
			}, DoubleClickEvent.getType());

			// imageColumn.setFieldUpdater(new FieldUpdater<XMLDBSKayit,
			// String>() {
			//
			// @Override
			// public void update(int index, XMLDBSKayit object, String value) {
			//
			// XMLDBSKayit selected = selectionModel.getSelectedObject();
			// if (selected != null) {
			// // DO YOUR STUFF
			//
			// // Window.alert("selected id: " + selected.id);
			// showWithData(selected.id);
			//
			// }
			//
			// }
			// });

			imageColumn
					.setFieldUpdater(new FieldUpdater<XMLDBSKayit, ImageResource>() {

						@Override
						public void update(int index, XMLDBSKayit object,
								ImageResource value) {
							Window.alert("qweqwe");
							XMLDBSKayit selected = selectionModel
									.getSelectedObject();

							if (selected != null) {
								// DO YOUR STUFF

								// Window.alert("selected id: " + selected.id);
								showWithData(selected.id);

							}

						}
					});
		}
		setWidth("100%");
	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getdbskayit?id=" + id;

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				urlWithParameters);

		// Window.alert("URL TO GET VALUES: " + urlWithParameters);
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLDBSKayit> listXmlDBSKayit = XMLDBSKayit.XML
							.readList(response.getText());

					_dlgDbsYeniKayit = new DlgDBSYeniKayit(false, new Long(id)
							.longValue());

					_dlgDbsYeniKayit.putDataFromXML(listXmlDBSKayit.get(0));
					_dlgDbsYeniKayit.center();
					_dlgDbsYeniKayit
							.addCloseHandler(new CloseHandler<PopupPanel>() {

								@Override
								public void onClose(CloseEvent<PopupPanel> event) {

									putDataToGrid();

								}
							});
				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase
				+ "getdbskayit?kayit_silinsin_mi=FALSE";

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				urlWithParameters);

		// Window.alert("URL TO GET VALUES: " + urlWithParameters);
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLDBSKayit> listXmlDBSKayit = XMLDBSKayit.XML
							.readList(response.getText());

					// Window.alert("SIZE DBSKAYIT: " + listXmlDBSKayit.);

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdDBSKayit.setRowCount(1, true);

					// Push the data into the widget.
					grdDBSKayit.setRowData(0, listXmlDBSKayit);

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	// Implement the following method exactly as-is
	private static final boolean isDesignTime() {
		// return Beans.isDesignTime(); // GWT 2.4 and above
		return false; // GWT 2.2 and earlier
	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			_dlgDbsYeniKayit = new DlgDBSYeniKayit(true, -1);
			_dlgDbsYeniKayit.center();
			_dlgDbsYeniKayit.setAnimationEnabled(true);

			_dlgDbsYeniKayit.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}

	// private class BtnAraClickHandler implements ClickHandler {
	// public void onClick(ClickEvent event) {
	// String urlWithParameters = Util.urlBase + "getdbskayit" + "?adi="
	// + tctAdi.getText();
	//
	// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
	// urlWithParameters);
	//
	// // Window.alert("URL TO GET VALUES: " + urlWithParameters);
	//
	// try {
	// Request request = builder.sendRequest(null,
	// new RequestCallback() {
	// public void onError(Request request,
	// Throwable exception) {
	//
	// }
	//
	// @Override
	// public void onResponseReceived(Request request,
	// Response response) {
	//
	// // Window.alert("AAABBBCCC " +
	// // response.getText());
	//
	// List<XMLDBSKayit> listxmlDbsKayit = XMLDBSKayit.XML
	// .readList(response.getText());
	//
	// // listXmlOnKayit.add(xmlOnKayit);
	//
	// // lblNewLabel.setText(listxmlSablonTanimlari
	// // .get(0).sablon_adi);
	//
	// // Set the total row count. This isn't strictly
	// // necessary, but it affects
	// // paging calculations, so its good habit to
	// // keep the row count up to date.
	// grdDBSKayit.setRowCount(1, true);
	//
	// // Push the data into the widget.
	// grdDBSKayit.setRowData(0, listxmlDbsKayit);
	//
	// }
	//
	// });
	//
	// } catch (RequestException e) {
	// // displayError("Couldn't retrieve JSON");
	//
	// // Window.alert(e.getMessage() + "ERROR");
	// }
	//
	// }

	private class BtnAraClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String urlWithParameters = Util.urlBase
					+ "getdbskayit?kayit_silinsin_mi=FALSE"
					+ "&adi_soyadi_tc_kimlik_no="
					+ tctAranacakAnahtarKelime.getText();

			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
					urlWithParameters);

			// Window.alert("URL TO GET VALUES: " + urlWithParameters);

			try {
				Request request = builder.sendRequest(null,
						new RequestCallback() {
							public void onError(Request request,
									Throwable exception) {

							}

							@Override
							public void onResponseReceived(Request request,
									Response response) {

								// Window.alert("AAABBBCCC " +
								// response.getText());

								List<XMLDBSKayit> listXmlDbsKayit = XMLDBSKayit.XML
										.readList(response.getText());

								// listXmlOnKayit.add(xmlOnKayit);

								// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

								// Set the total row count. This isn't strictly
								// necessary, but it affects
								// paging calculations, so its good habit to
								// keep the row count up to date.
								grdDBSKayit.setRowCount(1, true);

								// Push the data into the widget.
								grdDBSKayit.setRowData(0, listXmlDbsKayit);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}

	private class ChxSilinmisKayitlariGosterClickHandler implements
			ClickHandler {
		public void onClick(ClickEvent event) {
			if (chxSilinmisKayitlariGoster.getValue() == true) {
				String urlWithParameters = Util.urlBase + "getdbskayit"
						+ "?kayit_silinsin_mi=TRUE";

				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
						urlWithParameters);

				// Window.alert("URL TO GET VALUES: " + urlWithParameters);

				try {
					Request request = builder.sendRequest(null,
							new RequestCallback() {
								public void onError(Request request,
										Throwable exception) {

								}

								@Override
								public void onResponseReceived(Request request,
										Response response) {

									// Window.alert("AAABBBCCC " +
									// response.getText());

									List<XMLDBSKayit> listXmlDbsKayit = XMLDBSKayit.XML
											.readList(response.getText());

									// listXmlOnKayit.add(xmlOnKayit);

									// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

									// Set the total row count. This isn't
									// strictly
									// necessary, but it affects
									// paging calculations, so its good habit to
									// keep the row count up to date.
									grdDBSKayit.setRowCount(1, true);

									// Push the data into the widget.
									grdDBSKayit.setRowData(0, listXmlDbsKayit);

								}

							});

				} catch (RequestException e) {
					// displayError("Couldn't retrieve JSON");

					// Window.alert(e.getMessage() + "ERROR");
				}
			}

			else {
				String urlWithParameters = Util.urlBase + "getdbskayit"
						+ "?kayit_silinsin_mi=FALSE";

				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
						urlWithParameters);

				// Window.alert("URL TO GET VALUES: " + urlWithParameters);

				try {
					Request request = builder.sendRequest(null,
							new RequestCallback() {
								public void onError(Request request,
										Throwable exception) {

								}

								@Override
								public void onResponseReceived(Request request,
										Response response) {

									// Window.alert("AAABBBCCC " +
									// response.getText());

									List<XMLDBSKayit> listXmlDbsKayit = XMLDBSKayit.XML
											.readList(response.getText());

									// listXmlOnKayit.add(xmlOnKayit);

									// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

									// Set the total row count. This isn't
									// strictly
									// necessary, but it affects
									// paging calculations, so its good habit to
									// keep the row count up to date.
									grdDBSKayit.setRowCount(1, true);

									// Push the data into the widget.
									grdDBSKayit.setRowData(0, listXmlDbsKayit);

								}

							});

				} catch (RequestException e) {
					// displayError("Couldn't retrieve JSON");

					// Window.alert(e.getMessage() + "ERROR");
				}
			}
		}
	}

	interface Resources extends ClientBundle {
		@Source("duzenle.png")
		ImageResource getImageResource();

	}

	private class TctAranacakAnahtarKelimeFocusHandler implements FocusHandler {
		public void onFocus(FocusEvent event) {

			tctAranacakAnahtarKelime.setText(tctAranacakAnahtarKelime.getText()
					.replace("Ne Aramıştınız?", ""));
		}
	}

	private class TctAranacakAnahtarKelimeValueChangeHandler implements
			ValueChangeHandler<String> {
		public void onValueChange(ValueChangeEvent<String> event) {

			if (tctAranacakAnahtarKelime.getText().trim().length() <= 0) {

				tctAranacakAnahtarKelime.setText("Ne Aramıştınız?");

			}
		}
	}

	private class TctAranacakAnahtarKelimeKeyDownHandler implements
			KeyDownHandler {
		public void onKeyDown(KeyDownEvent event) {

			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				// do something
				String urlWithParameters = Util.urlBase
						+ "getdbskayit?kayit_silinsin_mi=FALSE"
						+ "&adi_soyadi_tc_kimlik_no="
						+ tctAranacakAnahtarKelime.getText();

				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
						urlWithParameters);

				// Window.alert("URL TO GET VALUES: " + urlWithParameters);

				try {
					Request request = builder.sendRequest(null,
							new RequestCallback() {
								public void onError(Request request,
										Throwable exception) {

								}

								@Override
								public void onResponseReceived(Request request,
										Response response) {

									// Window.alert("AAABBBCCC " +
									// response.getText());

									List<XMLDBSKayit> listXmlDbsKayit = XMLDBSKayit.XML
											.readList(response.getText());

									// listXmlOnKayit.add(xmlOnKayit);

									// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

									// Set the total row count. This isn't
									// strictly
									// necessary, but it affects
									// paging calculations, so its good habit to
									// keep the row count up to date.
									grdDBSKayit.setRowCount(1, true);

									// Push the data into the widget.
									grdDBSKayit.setRowData(0, listXmlDbsKayit);

								}

							});

				} catch (RequestException e) {
					// displayError("Couldn't retrieve JSON");

					// Window.alert(e.getMessage() + "ERROR");
				}

			}
		}
	}
}
