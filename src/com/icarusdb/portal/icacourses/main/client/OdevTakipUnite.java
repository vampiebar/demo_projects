package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
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
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class OdevTakipUnite extends Composite {
	private CellTable<XMLOdevTakipUnite> grdOdevTakipUnite;
	private TextColumn<XMLOdevTakipUnite> grdcEgitimTuruAdi;
	private TextColumn<XMLOdevTakipUnite> grdcalanAdi;
	private TextColumn<XMLOdevTakipUnite> grdcDersAdi;
	private TextColumn<XMLOdevTakipUnite> grdcUniteAdi;
	private Column<XMLOdevTakipUnite, String> column;

	private DlgOdevTakipUnite _dlgOdevTakipUnite;
	private Column<XMLOdevTakipUnite, String> column_1;
	private TextBox tctAranacakAnahtarKelime;

	public OdevTakipUnite() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "750px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_2.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "40");
		horizontalPanel_2.setSize("100%", "33px");

		Label lbldevTakipnite = new Label("Ödev Takip Ünite");
		horizontalPanel_2.add(lbldevTakipnite);
		lbldevTakipnite.setWidth("100%");

		VerticalPanel horizontalPanel_1 = new VerticalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "27px");

		tctAranacakAnahtarKelime = new TextBox();
		tctAranacakAnahtarKelime
				.addKeyDownHandler(new TctAranacakAnahtarKelimeKeyDownHandler());
		tctAranacakAnahtarKelime.addFocusHandler(new TextBoxFocusHandler());
		horizontalPanel_1.add(tctAranacakAnahtarKelime);
		tctAranacakAnahtarKelime.setText("Ne Aramıştınız?");
		tctAranacakAnahtarKelime.setStyleName("gwt-TextBoxAra");
		verticalPanel.setCellHeight(tctAranacakAnahtarKelime, "30");
		tctAranacakAnahtarKelime.setSize("200px", "17px");

		Button btnYeniKayit = new Button("ARA");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.setText("Yeni Kayıt");
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "309px");

		grdOdevTakipUnite = new CellTable<XMLOdevTakipUnite>();
		horizontalPanel.add(grdOdevTakipUnite);
		grdOdevTakipUnite.setSize("100%", "100%");

		grdcEgitimTuruAdi = new TextColumn<XMLOdevTakipUnite>() {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return object.egitim_turu.toString();
			}
		};
		grdOdevTakipUnite.addColumn(grdcEgitimTuruAdi, "Eğitim Türü Adı");

		grdcalanAdi = new TextColumn<XMLOdevTakipUnite>() {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return object.alan.toString();
			}
		};
		grdOdevTakipUnite.addColumn(grdcalanAdi, "Alan Adı");

		grdcDersAdi = new TextColumn<XMLOdevTakipUnite>() {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return object.ders.toString();
			}
		};
		grdOdevTakipUnite.addColumn(grdcDersAdi, "Ders Adı");

		grdcUniteAdi = new TextColumn<XMLOdevTakipUnite>() {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return object.unite.toString();
			}
		};
		grdOdevTakipUnite.addColumn(grdcUniteAdi, "Ünite Adı");

		column = new Column<XMLOdevTakipUnite, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return "Düzenle";
			}
		};
		grdOdevTakipUnite.addColumn(column, "Düzenle");

		column_1 = new Column<XMLOdevTakipUnite, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return "Sil";
			}
		};
		grdOdevTakipUnite.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLOdevTakipUnite> selectionModel = new SingleSelectionModel<XMLOdevTakipUnite>();

			grdOdevTakipUnite.setSelectionModel(selectionModel);
			grdOdevTakipUnite.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLOdevTakipUnite selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLOdevTakipUnite, String>() {

				@Override
				public void update(int index, XMLOdevTakipUnite object,
						String value) {

					XMLOdevTakipUnite selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " +
						// selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLOdevTakipUnite, String>() {

				@Override
				public void update(int index, XMLOdevTakipUnite object,
						String value) {
					XMLOdevTakipUnite selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " +
							// selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putodevtakipunite?";

							URLValue = URLValue + "id=" + selected.id;

							URLValue = URLValue + "&egitim_turu="
									+ object.egitim_turu.toString();
							URLValue = URLValue + "&alan="
									+ object.alan.toString();
							URLValue = URLValue + "&ders="
									+ object.ders.toString();
							URLValue = URLValue + "&unite="
									+ object.unite.toString();

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"DERS BİLGİSİ KAYIT EDİLDİ",
									"DERS BİLGİSİ KAYIT EDİLEMEDİ");

						}

						// putDataToGrid();
					}

				}
			});

		}// design time
	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getodevtakipunite?id=" + id;

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

					// Window.alert("AAABBBCCC " +
					// response.getText());

					List<XMLOdevTakipUnite> listXmlOdevTakipUnite = XMLOdevTakipUnite.XML
							.readList(response.getText());

					_dlgOdevTakipUnite = new DlgOdevTakipUnite(false, new Long(
							id).longValue());
					_dlgOdevTakipUnite.putDataFromXML(listXmlOdevTakipUnite
							.get(0));
					_dlgOdevTakipUnite.setAnimationEnabled(true);
					_dlgOdevTakipUnite.center();
					_dlgOdevTakipUnite
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
				+ "getodevtakipunite?kayit_silinsin_mi=FALSE";

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

					List<XMLOdevTakipUnite> listXmlOdevTakipUnite = XMLOdevTakipUnite.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdOdevTakipUnite.setRowCount(1, true);

					// Push the data into the widget.
					grdOdevTakipUnite.setRowData(0, listXmlOdevTakipUnite);

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private boolean isDesignTime() {

		return false;
	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			_dlgOdevTakipUnite = new DlgOdevTakipUnite(true, -1);
			_dlgOdevTakipUnite.center();
			_dlgOdevTakipUnite.setAnimationEnabled(true);

			_dlgOdevTakipUnite.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});
		}
	}

	private class TextBoxFocusHandler implements FocusHandler {
		public void onFocus(FocusEvent event) {

			tctAranacakAnahtarKelime.setText(tctAranacakAnahtarKelime.getText()
					.replace("Ne Aramıştınız?", ""));

		}
	}

	private class TctAranacakAnahtarKelimeKeyDownHandler implements
			KeyDownHandler {
		public void onKeyDown(KeyDownEvent event) {

			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				// do something
				String urlWithParameters = Util.urlBase
						+ "getodevtakipunite?kayit_silinsin_mi=FALSE"
						+ "&egitim_turu_alan_ders="
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

									List<XMLOdevTakipUnite> listXmlOdevTakipUnite = XMLOdevTakipUnite.XML
											.readList(response.getText());

									// listXmlOnKayit.add(xmlOnKayit);

									// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

									// Set the total row count. This isn't
									// strictly
									// necessary, but it affects
									// paging calculations, so its good habit to
									// keep the row count up to date.
									grdOdevTakipUnite.setRowCount(1, true);

									// Push the data into the widget.
									grdOdevTakipUnite.setRowData(0,
											listXmlOdevTakipUnite);

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