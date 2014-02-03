package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.NumberCell;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class OgretmenTanimlari extends Composite {
	private CellTable<XMLOgretmenTanimlari> grdOgretmenTanimlari;
	private DlgOgretmenTanimlari _dlgOgretmenTanimlari;

	public OgretmenTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("797px", "453px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 62);
		btnYeniKayit.setSize("91px", "70px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 189);
		horizontalPanel.setSize("774px", "75px");

		grdOgretmenTanimlari = new CellTable<XMLOgretmenTanimlari>();
		horizontalPanel.add(grdOgretmenTanimlari);
		grdOgretmenTanimlari.setSize("100%", "100%");

		TextColumn<XMLOgretmenTanimlari> textColumn_1 = new TextColumn<XMLOgretmenTanimlari>() {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return object.id.toString();
			}
		};
		grdOgretmenTanimlari.addColumn(textColumn_1, "İD");
		grdOgretmenTanimlari.setColumnWidth(textColumn_1, "19px");

		Column<XMLOgretmenTanimlari, ?> column_6 = new Column<XMLOgretmenTanimlari, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(XMLOgretmenTanimlari object) {
				return (Number) null;
			}
		};
		grdOgretmenTanimlari.addColumn(column_6, "Öğretmen Özel No");

		TextColumn<XMLOgretmenTanimlari> column_2 = new TextColumn<XMLOgretmenTanimlari>() {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return (object.tc_kimlik_no);
			}
		};
		grdOgretmenTanimlari.addColumn(column_2, "TC Kimlik No");

		Column<XMLOgretmenTanimlari, ?> textColumn = new TextColumn<XMLOgretmenTanimlari>() {
			public String getValue(XMLOgretmenTanimlari object) {
				return object.adi_soyadi.toString();
			}
		};
		grdOgretmenTanimlari.addColumn(textColumn, "Öğretmen Adı Soyadı");
		grdOgretmenTanimlari.setColumnWidth(textColumn, "145px");

		TextColumn<XMLOgretmenTanimlari> column_3 = new TextColumn<XMLOgretmenTanimlari>() {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return (object.cep_telefonu);
			}
		};
		grdOgretmenTanimlari.addColumn(column_3, "Cep Tel.");

		TextColumn<XMLOgretmenTanimlari> column_4 = new TextColumn<XMLOgretmenTanimlari>() {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return (object.ev_telefonu);
			}
		};
		grdOgretmenTanimlari.addColumn(column_4, "Ev Tel.");

		Column<XMLOgretmenTanimlari, String> column = new Column<XMLOgretmenTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return "Düzenle";
			}
		};
		grdOgretmenTanimlari.addColumn(column, "Düzenle");

		Column<XMLOgretmenTanimlari, String> column_1 = new Column<XMLOgretmenTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return "Sil";
			}
		};
		grdOgretmenTanimlari.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLOgretmenTanimlari> selectionModel = new SingleSelectionModel<XMLOgretmenTanimlari>();

			grdOgretmenTanimlari.setSelectionModel(selectionModel);
			grdOgretmenTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLOgretmenTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLOgretmenTanimlari, String>() {

				@Override
				public void update(int index, XMLOgretmenTanimlari object,
						String value) {

					XMLOgretmenTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLOgretmenTanimlari, String>() {

				@Override
				public void update(int index, XMLOgretmenTanimlari object,
						String value) {
					Window.confirm("Kayit Silinecektir, Emin Misiniz?");
					XMLOgretmenTanimlari selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putogretmentanimlari?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&tc_kimlik_no="
									+ object.tc_kimlik_no.toString();
							URLValue = URLValue + "&adi_soyadi="
									+ object.adi_soyadi.toString();
							URLValue = URLValue + "&girdigi_ders_bilgisi="
									+ object.girdigi_ders_bilgisi.toString();
							URLValue = URLValue + "&egitim_turu="
									+ object.egitim_turu.toString();
							URLValue = URLValue + "&brans="
									+ object.brans.toString();
							URLValue = URLValue + "&girdigi_dersler="
									+ object.girdigi_dersler.toString();
							URLValue = URLValue + "&ucreti="
									+ object.ucreti.toString();
							URLValue = URLValue + "&ev_telefonu="
									+ object.ev_telefonu.toString();
							URLValue = URLValue + "&cep_telefonu="
									+ object.cep_telefonu.toString();
							URLValue = URLValue + "&cep_telefonu_2="
									+ object.cep_telefonu_2.toString();
							URLValue = URLValue + "&email="
									+ object.email.toString();
							URLValue = URLValue + "&sigorta_gun_sayisi="
									+ object.sigorta_gun_sayisi.toString();
							URLValue = URLValue + "&ders_programini_gorsun="
									+ object.ders_programini_gorsun.toString();
							URLValue = URLValue + "&durum="
									+ object.durum.toString();
							URLValue = URLValue + "&pazartesi="
									+ object.pazartesi.toString();
							URLValue = URLValue + "&pazartesi="
									+ object.pazartesi.toString();
							URLValue = URLValue + "&sali="
									+ object.sali.toString();
							URLValue = URLValue + "&carsamba="
									+ object.carsamba.toString();
							URLValue = URLValue + "&persembe="
									+ object.persembe.toString();
							URLValue = URLValue + "&cuma="
									+ object.cuma.toString();
							URLValue = URLValue + "&cumartesi="
									+ object.cumartesi.toString();
							URLValue = URLValue + "&pazar="
									+ object.pazar.toString();
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

		String urlWithParameters = Util.urlBase + "getogretmentanimlari?id="
				+ id;

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

					List<XMLOgretmenTanimlari> listXmlOgretmenTanimlari = XMLOgretmenTanimlari.XML
							.readList(response.getText());

					_dlgOgretmenTanimlari = new DlgOgretmenTanimlari(false,
							new Long(id).longValue());
					_dlgOgretmenTanimlari
							.putDataFromXML(listXmlOgretmenTanimlari.get(0));
					_dlgOgretmenTanimlari.setAnimationEnabled(true);
					_dlgOgretmenTanimlari.center();
					_dlgOgretmenTanimlari.tabOgretmenIslemleri.selectTab(0);
					_dlgOgretmenTanimlari
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
				+ "getogretmentanimlari?kayit_silinsin_mi=FALSE";

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

					List<XMLOgretmenTanimlari> listXmlOgretmenTanimlari = XMLOgretmenTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdOgretmenTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdOgretmenTanimlari
							.setRowData(0, listXmlOgretmenTanimlari);

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
			_dlgOgretmenTanimlari = new DlgOgretmenTanimlari(true, -1);
			_dlgOgretmenTanimlari.center();
			_dlgOgretmenTanimlari.setAnimationEnabled(true);
			_dlgOgretmenTanimlari.tabOgretmenIslemleri.selectTab(0);

			_dlgOgretmenTanimlari
					.addCloseHandler(new CloseHandler<PopupPanel>() {

						@Override
						public void onClose(CloseEvent<PopupPanel> event) {

							putDataToGrid();

						}
					});

		}
	}
}
