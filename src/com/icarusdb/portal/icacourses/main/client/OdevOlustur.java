package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class OdevOlustur extends Composite {
	private ListBox cbxAlan;
	private ListBox cbxDersAdi;
	private CellTable<XMLOdevOlustur> grdOdevOlustur;
	private TextColumn<XMLOdevOlustur> grdcDers;
	private TextColumn<XMLOdevOlustur> grdcAlan;
	private TextColumn<XMLOdevOlustur> grdcEgitimTuru;
	private TextColumn<XMLOdevOlustur> grdcOdevAdi;
	private Column<XMLOdevOlustur, String> column;

	private DlgOdevOlustur _dlgOdevOlustur;
	private ListBox cbxEgitimTuru;
	private TextColumn<XMLOdevOlustur> textColumn;
	private Column<XMLOdevOlustur, String> column_1;

	public OdevOlustur() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("721px", "439px");

		Label lblNewLabel_2 = new Label("Eğitim Türü");
		lblNewLabel_2.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_2, 10, 22);

		Label label = new Label("Alan");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 10, 56);
		label.setSize("56px", "16px");

		Label label_1 = new Label("Ders Adı");
		label_1.setStyleName("gwt-Bold");
		absolutePanel.add(label_1, 10, 88);
		label_1.setSize("56px", "16px");

		cbxAlan = new ListBox();
		cbxAlan.addItem("Lütfen Seçiniz ");
		cbxAlan.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxAlan, 106, 50);
		cbxAlan.setSize("149px", "24px");

		cbxDersAdi = new ListBox();
		cbxDersAdi.addItem("Lütfen Seçiniz ");
		cbxDersAdi.setStyleName("gwt-ComboBox1");
		cbxDersAdi.setName("Lütfen Seçiniz");
		absolutePanel.add(cbxDersAdi, 106, 82);
		cbxDersAdi.setSize("149px", "24px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 120);
		horizontalPanel.setSize("701px", "309px");

		grdOdevOlustur = new CellTable<XMLOdevOlustur>();
		horizontalPanel.add(grdOdevOlustur);
		grdOdevOlustur.setSize("100%", "100%");

		grdcOdevAdi = new TextColumn<XMLOdevOlustur>() {
			@Override
			public String getValue(XMLOdevOlustur object) {
				return object.odev_adi.toString();
			}
		};
		grdOdevOlustur.addColumn(grdcOdevAdi, "Ödev Adı");

		grdcEgitimTuru = new TextColumn<XMLOdevOlustur>() {
			@Override
			public String getValue(XMLOdevOlustur object) {
				return object.egitim_turu.toString();
			}
		};
		grdOdevOlustur.addColumn(grdcEgitimTuru, "Eğitim Türü");

		grdcAlan = new TextColumn<XMLOdevOlustur>() {
			@Override
			public String getValue(XMLOdevOlustur object) {
				return object.alan.toString();
			}
		};
		grdOdevOlustur.addColumn(grdcAlan, "Alan");

		grdcDers = new TextColumn<XMLOdevOlustur>() {
			@Override
			public String getValue(XMLOdevOlustur object) {
				return object.ders.toString();
			}
		};
		grdOdevOlustur.addColumn(grdcDers, "Ders");

		textColumn = new TextColumn<XMLOdevOlustur>() {
			@Override
			public String getValue(XMLOdevOlustur object) {
				return object.soru_sayisi.toString();
			}
		};
		grdOdevOlustur.addColumn(textColumn, "Soru Sayısı");

		column = new Column<XMLOdevOlustur, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLOdevOlustur object) {
				return "İşlemler";
			}
		};
		grdOdevOlustur.addColumn(column, "Düzenle");

		column_1 = new Column<XMLOdevOlustur, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLOdevOlustur object) {
				return (String) null;
			}
		};
		grdOdevOlustur.addColumn(column_1, "Sil");

		Button btnYeniKayit = new Button("ARA");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler1());
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");

		btnYeniKayit.setText("");
		absolutePanel.add(btnYeniKayit, 441, 42);
		btnYeniKayit.setSize("78px", "48px");

		Button btnAra = new Button("ARA");
		btnAra.setText("");
		btnAra.addClickHandler(new BtnAraClickHandler());
		btnAra.setStyleName("gwt-ButtonAra");

		absolutePanel.add(btnAra, 346, 42);
		btnAra.setSize("78px", "48px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem("Lütfen Seçiniz");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxEgitimTuru, 106, 16);
		cbxEgitimTuru.setSize("145px", "22px");

		if (!isDesignTime()) {

			putEgitimTuruToCbx(cbxEgitimTuru);
			putDataToGrid();

			final SingleSelectionModel<XMLOdevOlustur> selectionModel = new SingleSelectionModel<XMLOdevOlustur>();

			grdOdevOlustur.setSelectionModel(selectionModel);
			grdOdevOlustur.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLOdevOlustur selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLOdevOlustur, String>() {

				@Override
				public void update(int index, XMLOdevOlustur object,
						String value) {

					XMLOdevOlustur selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLOdevOlustur, String>() {

				@Override
				public void update(int index, XMLOdevOlustur object,
						String value) {
					XMLOdevOlustur selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase + "putodevolustur?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&odev_adi="
									+ object.odev_adi.toString();
							URLValue = URLValue + "&egitim_turu="
									+ object.egitim_turu.toString();
							URLValue = URLValue + "&alan="
									+ object.alan.toString();
							URLValue = URLValue + "&ders="
									+ object.ders.toString();
							URLValue = URLValue + "&unite="
									+ object.unite.toString();
							URLValue = URLValue + "&soru_sayisi="
									+ object.soru_sayisi.toString();
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

	private void putEgitimTuruToCbx(final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturu");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLEgitimTuru> xmlEgitimTuru = XMLEgitimTuru.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuru.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuru.get(i).egitim_turu_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putEgitimTuruAlanToCbx(String egitim_turu_adi,
			final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturutanimlama?egitim_turu_adi="
						+ egitim_turu_adi);
		// Window.alert("egitim_turu_adi=" + egitim_turu_adi);
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLEgitimTuruTanimlama> xmlEgitimTuruTanimlama = XMLEgitimTuruTanimlama.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuruTanimlama.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuruTanimlama.get(i).alan_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase
				+ "getodevolustur?kayit_silinsin_mi=FALSE";

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

					List<XMLOdevOlustur> listXmlOdevOlustur = XMLOdevOlustur.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdOdevOlustur.setRowCount(1, true);

					// Push the data into the widget.
					grdOdevOlustur.setRowData(0, listXmlOdevOlustur);

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getodevolustur?id=" + id;

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

					List<XMLOdevOlustur> listXmlOdevOlustur = XMLOdevOlustur.XML
							.readList(response.getText());

					_dlgOdevOlustur = new DlgOdevOlustur(false, new Long(id)
							.longValue());
					_dlgOdevOlustur.putDataFromXML(listXmlOdevOlustur.get(0));
					_dlgOdevOlustur.setAnimationEnabled(true);
					_dlgOdevOlustur.center();
					_dlgOdevOlustur.tabOdevOlustur.selectTab(0);
					_dlgOdevOlustur
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

	private boolean isDesignTime() {

		return false;
	}

	private class BtnYeniKayitClickHandler1 implements ClickHandler {
		public void onClick(ClickEvent event) {
			_dlgOdevOlustur = new DlgOdevOlustur(true, -1);
			_dlgOdevOlustur.center();
			_dlgOdevOlustur.setAnimationEnabled(true);
			_dlgOdevOlustur.tabOdevOlustur.selectTab(0);

			_dlgOdevOlustur.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});
		}
	}

	private class CbxEgitimTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putEgitimTuruAlanToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxAlan);
		}
	}

	private class BtnAraClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			// String urlWithParameters = Util.urlBase + "getodevolustur?"
			// + "egitim_turu=" + cbxEgitimTuru.getSelectedIndex()
			// + "&alan=" + cbxAlan.getSelectedIndex();
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
			// List<XMLOdevOlustur> listXmlOdevOlustur = XMLOdevOlustur.XML
			// .readList(response.getText());
			//
			// // listXmlOnKayit.add(xmlOnKayit);
			//
			// // lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);
			//
			// // Set the total row count. This isn't strictly
			// // necessary, but it affects
			// // paging calculations, so its good habit to
			// // keep the row count up to date.
			// grdOdevOlustur.setRowCount(1, true);
			//
			// // Push the data into the widget.
			// grdOdevOlustur
			// .setRowData(0, listXmlOdevOlustur);
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
		}
	}
}
// ARA................................
// String urlWithParameters = Util.urlBase + "getodevolustur"
// + "?egitim_turu=" + cbx.getSelectedIndex();
//
// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
// urlWithParameters);
// // Window.alert("URL TO GET VALUES: " + urlWithParameters);

// try {
// Request request = builder.sendRequest(null, new RequestCallback() {
// public void onError(Request request, Throwable exception) {

// }

// @Override
// public void onResponseReceived(Request request,
// Response response) {
//
// // Window.alert("AAABBBCCC " +
// // response.getText());
// List<XMLOdevOlustur> listXmlOdevOlustur = XMLOdevOlustur.XML
// .readList(response.getText());
//
// // XMLOdevOlustur xmlOdevOlustur =
// // XMLOdevOlustur.XML
// // .read(response.getText());
//
// // lblNewLabel.setText(listXmlOdevOlustur.get(0).ders);
// grd.setRowCount(1, true);
//
// // Push the data into the widget.
// grdOdevOlustur.setRowData(0, listXmlOdevOlustur);
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
// }
