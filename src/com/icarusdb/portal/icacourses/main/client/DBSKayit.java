package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.SingleSelectionModel;

public class DBSKayit extends Composite {
	private TextBox tctAranacakAnahtarKelime;
	private CellTable<XMLDBSKayit> grdDBSKayit;
	private DlgDBSYeniKayit _dlgDbsYeniKayit;
	private Button btnAra;
	private CheckBox chxSilinmisKayitlariGoster;
	private Button btnNewButton;

	public DBSKayit() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		horizontalPanel.add(absolutePanel);
		absolutePanel.setSize("900px", "651px");

		Label lblNewLabel = new Label("Aranacak Anahtar Kelime");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 30);
		lblNewLabel.setSize("175px", "16px");

		tctAranacakAnahtarKelime = new TextBox();
		tctAranacakAnahtarKelime.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAranacakAnahtarKelime, 191, 30);
		tctAranacakAnahtarKelime.setSize("200px", "17px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 10, 143);
		horizontalPanel_1.setSize("890px", "174px");

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
		grdDBSKayit.setColumnWidth(textColumn_7, "117px");

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
		grdDBSKayit.addColumn(textColumn, "Sınav Tarih Saat");

		TextColumn<XMLDBSKayit> textColumn_4 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return "???";
			}
		};
		grdDBSKayit.addColumn(textColumn_4, "Oluşturma Tarih Saat");

		Column<XMLDBSKayit, String> column = new Column<XMLDBSKayit, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLDBSKayit object) {
				return "Düzenle";
			}
		};
		grdDBSKayit.addColumn(column, "İşlemler");

		Button btnYeniKayit = new Button("");

		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 607, 30);
		btnYeniKayit.setSize("90px", "65px");

		btnAra = new Button("");
		btnAra.setTitle("Ara");
		btnAra.addClickHandler(new BtnAraClickHandler());

		btnAra.setStyleName("gwt-ButtonAra");
		btnAra.setText("");
		absolutePanel.add(btnAra, 513, 30);
		btnAra.setSize("90px", "65px");

		btnNewButton = new Button("New button");
		btnNewButton.setVisible(false);
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		btnNewButton.setText("Silinmiş Kayıtları Göster");
		absolutePanel.add(btnNewButton, 191, 81);
		btnNewButton.setSize("202px", "21px");

		chxSilinmisKayitlariGoster = new CheckBox("Silinmiş Kayıtları Göster");
		chxSilinmisKayitlariGoster
				.addClickHandler(new ChxSilinmisKayitlariGosterClickHandler());
		absolutePanel.add(chxSilinmisKayitlariGoster, 191, 55);
		chxSilinmisKayitlariGoster.setSize("186px", "20px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLDBSKayit> selectionModel = new SingleSelectionModel<XMLDBSKayit>();

			grdDBSKayit.setSelectionModel(selectionModel);
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

			column.setFieldUpdater(new FieldUpdater<XMLDBSKayit, String>() {

				@Override
				public void update(int index, XMLDBSKayit object, String value) {

					XMLDBSKayit selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});
		}
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

			String urlWithParameters = Util.urlBase + "getdbskayit"
					+ "?adi_soyadi_tc_kimlik_no="
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

	private class BtnNewButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

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
				btnNewButton.click();
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
}
