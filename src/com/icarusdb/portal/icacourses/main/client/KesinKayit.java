package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.SingleSelectionModel;

public class KesinKayit extends Composite {
	private TextBox tctAdi;
	private TextBox tctSoyadi;
	private TextBox tctTCKimlikNo;
	private ListBox cbxETuru;
	private ListBox cbxAlan;
	private ListBox cbxKZamani;
	private ListBox cbxSinif;
	private ListBox cbxKayitDurumu;
	private CellTable<XMLOnKayit> grdKesinKayit;
	private Column<XMLOnKayit, ?> grdcAdi;
	private Column<XMLOnKayit, ?> grdcSoyadi;

	public KesinKayit() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("911px", "651px");

		Label lblAdsoyad = new Label("Adı Soyadı");
		lblAdsoyad.setStyleName("gwt-Bold");
		absolutePanel.add(lblAdsoyad, 22, 33);
		lblAdsoyad.setSize("83px", "16px");

		tctAdi = new TextBox();
		tctAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAdi, 133, 33);
		tctAdi.setSize("143px", "16px");

		tctSoyadi = new TextBox();
		tctSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSoyadi, 295, 33);
		tctSoyadi.setSize("149px", "16px");

		Label lblTcKimlikNo = new Label("T.C Kimlik No");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblTcKimlikNo, 22, 68);

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctTCKimlikNo, 133, 64);
		tctTCKimlikNo.setSize("142px", "16px");

		Label lblEtrAlan = new Label("E.Türü - Alan");
		lblEtrAlan.setStyleName("gwt-Bold");
		absolutePanel.add(lblEtrAlan, 22, 105);

		cbxETuru = new ListBox();
		cbxETuru.setStyleName("gwt-ComboBox1");
		cbxETuru.addItem("YGS HAZIRLIK");
		cbxETuru.addItem("YGS/LYS HAZIRLIK");
		cbxETuru.addItem("11.SINIF TAKVİYE");
		cbxETuru.addItem("10.SINIF TAKVİYE");
		cbxETuru.addItem("9.SINIF TAKVİYE");
		cbxETuru.addItem("SBS HAZIRLIK");
		cbxETuru.addItem("8.SINIF TAKVİYE");
		cbxETuru.addItem("7.SINIF TAKVİYE");
		cbxETuru.addItem("6.SINIF TAKVİYE");
		cbxETuru.addItem("5.SINIF TAKVİYE");
		cbxETuru.addItem("4.SINIF TAKVİYE");
		absolutePanel.add(cbxETuru, 133, 99);
		cbxETuru.setSize("144px", "25px");

		cbxAlan = new ListBox();
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem("ALAN YOK");
		absolutePanel.add(cbxAlan, 296, 99);
		cbxAlan.setSize("150px", "25px");

		Label lblKzamanSnf = new Label("K.Zamanı - Sınıf");
		lblKzamanSnf.setStyleName("gwt-Bold");
		absolutePanel.add(lblKzamanSnf, 22, 145);

		cbxKZamani = new ListBox();
		cbxKZamani.setStyleName("gwt-ComboBox1");
		cbxKZamani.addItem("HAFTA SONU ");
		cbxKZamani.addItem("HAFTA İÇİ");
		absolutePanel.add(cbxKZamani, 133, 135);
		cbxKZamani.setSize("144px", "25px");

		cbxSinif = new ListBox();
		cbxSinif.setStyleName("gwt-ComboBox1");
		cbxSinif.addItem("Lütfen Seçiniz");
		absolutePanel.add(cbxSinif, 296, 135);
		cbxSinif.setSize("150px", "25px");

		Label lblKaytDurumu = new Label("Kayıt Durumu");
		lblKaytDurumu.setStyleName("gwt-Bold");
		absolutePanel.add(lblKaytDurumu, 22, 182);

		cbxKayitDurumu = new ListBox();
		cbxKayitDurumu.addItem("1");
		cbxKayitDurumu.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxKayitDurumu, 133, 176);
		cbxKayitDurumu.setSize("144px", "25px");

		Button btnAra = new Button("ARA");
		btnAra.setStyleName("gwt-ButonKapat");
		btnAra.addClickHandler(new BtnAraClickHandler());
		absolutePanel.add(btnAra, 493, 33);
		btnAra.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 590, 33);
		btnYeniKayit.setSize("78px", "48px");

		Button btnKaydet = new Button("Excel'e Aktar");
		btnKaydet.setStyleName("gwt-ButtonSave");

		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 681, 33);
		btnKaydet.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 22, 224);
		horizontalPanel.setSize("758px", "164px");

		grdKesinKayit = new CellTable<XMLOnKayit>();

		horizontalPanel.add(grdKesinKayit);
		grdKesinKayit.setSize("758px", "170px");

		grdcAdi = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.adi.toString();
			}
		};
		grdKesinKayit.addColumn(grdcAdi, "Adı");
		grdKesinKayit.setColumnWidth(grdcAdi, "73px");

		grdcSoyadi = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.soyadi.toString();
			}
		};
		grdKesinKayit.addColumn(grdcSoyadi, "Soyadı");
		grdKesinKayit.setColumnWidth(grdcSoyadi, "68px");

		Column<XMLOnKayit, ?> column = new TextColumn<XMLOnKayit>() {

			@Override
			public String getValue(XMLOnKayit object) {
				return (object.tc_kimlik_no);
			}
		};
		grdKesinKayit.addColumn(column, "TC Kimlik No");

		Column<XMLOnKayit, ?> textColumn = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.egitim_turu.toString();
			}
		};
		grdKesinKayit.addColumn(textColumn, "Eğitim Türü");

		Column<XMLOnKayit, ?> textColumn_3 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return "???";
			}
		};
		grdKesinKayit.addColumn(textColumn_3, "Sınıf Adı");

		Column<XMLOnKayit, ?> column_1 = new Column<XMLOnKayit, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(XMLOnKayit object) {
				return (Number) null;
			}
		};
		grdKesinKayit.addColumn(column_1, "Öğrenci D. No");

		Column<XMLOnKayit, ?> column_2 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return (object.cep_telefonu);
			}
		};
		grdKesinKayit.addColumn(column_2, "Cep Tel.");

		Column<XMLOnKayit, ?> textColumn_4 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return "???";
			}
		};
		grdKesinKayit.addColumn(textColumn_4, "Durum");

		Column<XMLOnKayit, ?> column_3 = new Column<XMLOnKayit, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLOnKayit object) {
				return (String) null;
			}
		};
		grdKesinKayit.addColumn(column_3, "Şifre Sıfırla");

		Column<XMLOnKayit, ?> textColumn_5 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return "İşlemler";
			}
		};
		grdKesinKayit.addColumn(textColumn_5, "İşlemler");

		Button button = new Button("Excel'e Aktar");
		button.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(button, 773, 33);
		button.setSize("78px", "48px");

		// private class BtnKaydetClickHandler implements ClickHandler {
		// public void onClick(ClickEvent event) {
		//
		// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
		// "http://localhost:9090/ICACoursesWS/jaxrs/genel/getkesinkayit");
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
		// Window.alert(response.getText());
		//
		// }
		// });
		// } catch (RequestException e) {
		// // displayError("Couldn't retrieve JSON");
		//
		// Window.alert(e.getMessage() + "ERROR");
		// }
		// }
		// }

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLOnKayit> selectionModel = new SingleSelectionModel<XMLOnKayit>();

			grdKesinKayit.setSelectionModel(selectionModel);
			grdKesinKayit.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLOnKayit selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());
		}

	}

	private boolean isDesignTime() {
		// TODO Auto-generated method stub
		return false;
	}

	private void putDataToGrid() {
		// TODO Auto-generated method stub

	}

	protected void showWithData(String id) {

		String urlWithParameters = Util.urlBase + "getonkayit?id=" + id;

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

					List<XMLOnKayit> listXmlOnKayit = XMLOnKayit.XML
							.readList(response.getText());

					KesinKayitBilgileri dlgTemp = new KesinKayitBilgileri();
					dlgTemp.putDataFromXML(listXmlOnKayit.get(0));
					dlgTemp.setAnimationEnabled(true);
					dlgTemp.center();

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			// tctAdi.setText("");
			// tctSoyadi.setText("");
			// tctTCKimlikNo.setText("");
			//
			// cbxETuru.setSelectedIndex(0);
			// cbxAlan.setSelectedIndex(0);
			// cbxKZamani.setSelectedIndex(0);
			// cbxSinif.setSelectedIndex(0);
			// cbxKayitDurumu.setSelectedIndex(0);

			DlgKesinKayitIslemleri dlgTemp = new DlgKesinKayitIslemleri();
			dlgTemp.tabKesinKayitIslemleri.selectTab(0);
			dlgTemp.center();

		}
	}

	private class BtnAraClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String urlWithParameters = Util.urlBase + "getonkayit"
					+ "?kesin_kayit_mi=TRUE";

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

								List<XMLOnKayit> listXmlOnKayit = XMLOnKayit.XML
										.readList(response.getText());

								// listXmlOnKayit.add(xmlOnKayit);

								// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

								// Set the total row count. This isn't strictly
								// necessary, but it affects
								// paging calculations, so its good habit to
								// keep the row count up to date.
								grdKesinKayit.setRowCount(1, true);

								// Push the data into the widget.
								grdKesinKayit.setRowData(0, listXmlOnKayit);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}
}
