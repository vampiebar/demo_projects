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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
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
		absolutePanel.setSize("100%", "439px");

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

		Label lbldevOlutur = new Label("Ödev Oluştur");
		horizontalPanel_2.add(lbldevOlutur);
		lbldevOlutur.setWidth("100%");

		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		verticalPanel.setCellHeight(flexTable, "30");
		flexTable.setSize("247px", "100px");

		Label lblNewLabel_2 = new Label("Eğitim Türü");
		flexTable.setWidget(0, 0, lblNewLabel_2);
		lblNewLabel_2.setWidth("100px");
		lblNewLabel_2.setStyleName("gwt-Bold");

		cbxEgitimTuru = new ListBox();
		flexTable.setWidget(0, 1, cbxEgitimTuru);
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem("Lütfen Seçiniz");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.setSize("145px", "22px");

		Label label = new Label("Alan");
		flexTable.setWidget(1, 0, label);
		label.setStyleName("gwt-Bold");
		label.setSize("56px", "16px");

		cbxAlan = new ListBox();
		flexTable.setWidget(1, 1, cbxAlan);
		cbxAlan.addItem("Lütfen Seçiniz ");
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.setSize("149px", "24px");

		Label label_1 = new Label("Ders Adı");
		flexTable.setWidget(2, 0, label_1);
		label_1.setStyleName("gwt-Bold");
		label_1.setSize("100px", "16px");

		cbxDersAdi = new ListBox();
		flexTable.setWidget(2, 1, cbxDersAdi);
		cbxDersAdi.addItem("Lütfen Seçiniz ");
		cbxDersAdi.setStyleName("gwt-ComboBox1");
		cbxDersAdi.setName("Lütfen Seçiniz");
		cbxDersAdi.setSize("149px", "24px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "62px");

		Button btnYeniKayit = new Button("ARA");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler1());
		btnYeniKayit.setStyleName("gwt-YeniKayit2");

		btnYeniKayit.setText("Yeni Kayit");
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "180px");

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
