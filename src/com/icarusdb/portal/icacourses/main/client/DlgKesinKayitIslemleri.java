package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgKesinKayitIslemleri extends DialogBox {
	private CheckBox chxTCKimlikNoSorgulama;
	private TextBox tctTCKimlikNo;
	private TextBox tctAdi;
	private TextBox tctSoyadi;

	public DlgKesinKayitIslemleri() {
		setHTML("Kesin Kayıt İşlemleri");

		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		setWidget(decoratedTabPanel);
		decoratedTabPanel.setSize("519px", "397px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel.add(absolutePanel, "Kesin Kayıt İşlemleri (Ekleme)",
				false);
		absolutePanel.setSize("100%", "355px");

		Label lblrenci = new Label("Öğrenci");
		absolutePanel.add(lblrenci, 10, 10);

		Label lblTcKimlikNo = new Label("T.C. Kimlik No");
		absolutePanel.add(lblTcKimlikNo, 10, 39);

		chxTCKimlikNoSorgulama = new CheckBox("New check box");
		chxTCKimlikNoSorgulama.setHTML("T.C Kimlik No Sorgulama");
		absolutePanel.add(chxTCKimlikNoSorgulama, 127, 65);

		Label lblAd = new Label("Adı");
		absolutePanel.add(lblAd, 10, 103);
		lblAd.setSize("45px", "18px");

		Label lblSoyad = new Label("Soyadı");
		absolutePanel.add(lblSoyad, 10, 137);

		tctAdi = new TextBox();
		tctAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAdi, 127, 103);
		tctAdi.setSize("205px", "14px");

		tctSoyadi = new TextBox();
		tctSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSoyadi, 127, 137);
		tctSoyadi.setSize("205px", "14px");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctTCKimlikNo, 127, 39);
		tctTCKimlikNo.setSize("159px", "14px");

		Button btnBilgileriniGetir = new Button("Bilgilerini Getir");
		btnBilgileriniGetir.setStyleName("gwt-ButonYeniKayit");
		btnBilgileriniGetir
				.addClickHandler(new BtnBilgileriniGetirClickHandler());
		absolutePanel.add(btnBilgileriniGetir, 305, 35);
		btnBilgileriniGetir.setSize("109px", "22px");

		Button btnOgrenciBilgileriniKaydet = new Button("New button");
		btnOgrenciBilgileriniKaydet.setStyleName("gwt-ButtonSave");
		btnOgrenciBilgileriniKaydet
				.addClickHandler(new BtnOgrenciBilgileriniKaydetClickHandler());
		btnOgrenciBilgileriniKaydet.setText("Öğrenci Bilgilerini Kaydet");
		absolutePanel.add(btnOgrenciBilgileriniKaydet, 127, 165);
		btnOgrenciBilgileriniKaydet.setSize("167px", "22px");

		Button btnKapat = new Button("Kapat");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel.add(btnKapat, 127, 193);
		btnKapat.setSize("167px", "24px");
	}

	private class BtnOgrenciBilgileriniKaydetClickHandler implements
			ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putkesinkayit?";
			URLValue = URLValue + "tc_kimlik_no=" + tctTCKimlikNo.getText();
			URLValue = URLValue + "&tc_kimlik_no_sorgulama="
					+ chxTCKimlikNoSorgulama.getValue().toString();
			URLValue = URLValue + "&adi=" + tctAdi.getText();
			URLValue = URLValue + "&soyadi=" + tctSoyadi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue);

		}
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnBilgileriniGetirClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String urlWithParameters = Util.urlBase + "getonkayit"
					+ "?tc_kimlik_no=" + tctTCKimlikNo.getText();

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

								// XMLOdevOlustur xmlOdevOlustur =
								// XMLOdevOlustur.XML
								// .read(response.getText());

								// lblNewLabel.setText(listXmlOdevOlustur.get(0).ders);
								// grd.setRowCount(1, true);

								// Push the data into the widget.
								// grd
								// .setRowData(0, listXmlOdevOlustur);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}
			KesinKayitBilgileri dlgTemp = new KesinKayitBilgileri();
			dlgTemp.center();
		}

	}
}
