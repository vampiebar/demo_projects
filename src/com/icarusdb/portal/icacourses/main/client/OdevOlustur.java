package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

public class OdevOlustur extends Composite {
	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private ListBox cbxDersAdi;
	private CellTable<XMLOdevOlustur> grdOdevOlustur;
	private TextColumn<XMLOdevOlustur> grdcDers;
	private TextColumn<XMLOdevOlustur> grdcAlan;
	private TextColumn<XMLOdevOlustur> grdcEgitimTuru;
	private TextColumn<XMLOdevOlustur> grdcOdevAdi;
	private Column<XMLOdevOlustur, Number> grdcSoruSayisi;
	private Column<XMLOdevOlustur, String> grdcIslemler;

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

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addItem("Lütfen Seçiniz");
		cbxEgitimTuru.addItem("YGS HAZIRLIK");
		cbxEgitimTuru.addItem("YGS/LYS HAZIRLIK");
		cbxEgitimTuru.addItem("11.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("10.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("9.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("SBS HAZIRLIK");
		cbxEgitimTuru.addItem("8.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("7.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("6.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("5.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("4.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("3.SINIF TAKVİYE");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxEgitimTuru, 106, 22);
		cbxEgitimTuru.setSize("149px", "24px");

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

		grdcSoruSayisi = new Column<XMLOdevOlustur, Number>(new NumberCell()) {
			@Override
			public Number getValue(XMLOdevOlustur object) {
				return (Number) null;
			}
		};
		grdOdevOlustur.addColumn(grdcSoruSayisi, "Soru Sayısı");

		grdcIslemler = new Column<XMLOdevOlustur, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLOdevOlustur object) {
				return (String) null;
			}
		};
		grdOdevOlustur.addColumn(grdcIslemler, "İşlemler");

		Button btnYeniKayit = new Button("ARA");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setText("Yeni Kayit");
		absolutePanel.add(btnYeniKayit, 441, 42);
		btnYeniKayit.setSize("78px", "48px");

		Button btnKaydet = new Button("Yeni Kayıt");
		btnKaydet.setStyleName("gwt-ButtonSave");

		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 531, 42);
		btnKaydet.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 621, 42);
		btnExceleAktar.setSize("78px", "48px");

		Button btnAra = new Button("ARA");
		btnAra.setStyleName("gwt-ButonKapat");
		btnAra.addClickHandler(new BtnAraClickHandler());
		absolutePanel.add(btnAra, 346, 42);
		btnAra.setSize("78px", "48px");
	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			// cbxEgitimTuru.setSelectedIndex(0);
			// cbxAlan.setSelectedIndex(0);
			// cbxDersAdi.setSelectedIndex(0);
			DlgOdevOlustur dlgTemp = new DlgOdevOlustur();
			dlgTemp.show();

		}
	}

	private class BtnAraClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String urlWithParameters = Util.urlBase + "getodevolustur"
					+ "?egitim_turu=" + cbxEgitimTuru.getSelectedIndex();

			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
					urlWithParameters);
			Window.alert("URL TO GET VALUES: " + urlWithParameters);

			try {
				Request request = builder.sendRequest(null,
						new RequestCallback() {
							public void onError(Request request,
									Throwable exception) {

							}

							@Override
							public void onResponseReceived(Request request,
									Response response) {

								Window.alert("AAABBBCCC " + response.getText());
								List<XMLOdevOlustur> listXmlOdevOlustur = XMLOdevOlustur.XML
										.readList(response.getText());

								// XMLOdevOlustur xmlOdevOlustur =
								// XMLOdevOlustur.XML
								// .read(response.getText());

								// lblNewLabel.setText(listXmlOdevOlustur.get(0).ders);
								grdOdevOlustur.setRowCount(1, true);

								// Push the data into the widget.
								grdOdevOlustur
										.setRowData(0, listXmlOdevOlustur);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				Window.alert(e.getMessage() + "ERROR");
			}

		}
	}
}
