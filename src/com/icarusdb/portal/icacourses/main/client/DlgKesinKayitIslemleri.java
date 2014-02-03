package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgKesinKayitIslemleri extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private CheckBox chxTCKimlikNoSorgulama;
	private TextBox tctTCKimlikNo;
	private TextBox tctAdi;
	private TextBox tctSoyadi;
	private AbsolutePanel absolutepanel;
	public DecoratedTabPanel tabKesinKayitIslemleri;
	public DialogBox _dlgKesinKayitIslemleri;
	private Button btnOgrenciBilgileriniKaydet;

	public DlgKesinKayitIslemleri(boolean isInsert, long id) {
		setGlassEnabled(true);
		_dlgKesinKayitIslemleri = this;
		_isInsert = isInsert;
		_id = id;

		setAutoHideEnabled(true);
		setHTML("Kesin Kayıt İşlemleri");

		tabKesinKayitIslemleri = new DecoratedTabPanel();
		setWidget(tabKesinKayitIslemleri);
		tabKesinKayitIslemleri.setSize("519px", "459px");

		absolutepanel = new AbsolutePanel();
		absolutepanel.setStyleName("gwt-DialogBackGround");
		tabKesinKayitIslemleri.add(absolutepanel,
				"Kesin Kayıt İşlemleri (Ekleme)", false);
		absolutepanel.setSize("559px", "430px");

		Label lblrenci = new Label("Öğrenci");
		lblrenci.setStyleName("gwt-Bold");
		absolutepanel.add(lblrenci, 10, 10);

		Label lblTcKimlikNo = new Label("T.C. Kimlik No");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		absolutepanel.add(lblTcKimlikNo, 10, 39);
		lblTcKimlikNo.setSize("100px", "18px");

		chxTCKimlikNoSorgulama = new CheckBox("New check box");
		chxTCKimlikNoSorgulama.setHTML("T.C Kimlik No Sorgulama");
		absolutepanel.add(chxTCKimlikNoSorgulama, 127, 65);

		Label lblAd = new Label("Adı");
		lblAd.setStyleName("gwt-Bold");
		absolutepanel.add(lblAd, 10, 103);
		lblAd.setSize("45px", "18px");

		Label lblSoyad = new Label("Soyadı");
		lblSoyad.setStyleName("gwt-Bold");
		absolutepanel.add(lblSoyad, 10, 137);

		tctAdi = new TextBox();
		tctAdi.setStyleName("gwt-TextBox1");
		absolutepanel.add(tctAdi, 127, 103);
		tctAdi.setSize("205px", "14px");

		tctSoyadi = new TextBox();
		tctSoyadi.setStyleName("gwt-TextBox1");
		absolutepanel.add(tctSoyadi, 127, 137);
		tctSoyadi.setSize("205px", "14px");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		absolutepanel.add(tctTCKimlikNo, 127, 39);
		tctTCKimlikNo.setSize("159px", "14px");

		Button btnBilgileriniGetir = new Button("Bilgilerini Getir");
		btnBilgileriniGetir.setStyleName("gwt-ButonYeniKayit");
		btnBilgileriniGetir
				.addClickHandler(new BtnBilgileriniGetirClickHandler());
		absolutepanel.add(btnBilgileriniGetir, 305, 35);
		btnBilgileriniGetir.setSize("109px", "22px");

		btnOgrenciBilgileriniKaydet = new Button("New button");
		btnOgrenciBilgileriniKaydet.setVisible(false);
		btnOgrenciBilgileriniKaydet.setStyleName("gwt-ButtonSave");
		btnOgrenciBilgileriniKaydet
				.addClickHandler(new BtnOgrenciBilgileriniKaydetClickHandler());
		btnOgrenciBilgileriniKaydet.setText("Öğrenci Bilgilerini Kaydet");
		absolutepanel.add(btnOgrenciBilgileriniKaydet, 107, 292);
		btnOgrenciBilgileriniKaydet.setSize("181px", "22px");

		Button btnKapat = new Button("Kapat");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutepanel.add(btnKapat, 107, 320);
		btnKapat.setSize("181px", "24px");

		Image image = new Image("kaydet-1.png");
		absolutepanel.add(image, 157, 172);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutepanel.add(image_1, 245, 172);
		image_1.setSize("72px", "66px");
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

			new Util().sendRequest(URLValue, "", "");

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

								Window.alert("AAABBBCCC1235 "
										+ response.getText());
								List<XMLOnKayit> listXmlOnKayit = XMLOnKayit.XML
										.readList(response.getText());

								//
								// List<XMLOdemeler> listXmlOdemeler =
								// XMLOdemeler.XML
								// .readList(response.getText());

								KesinKayitBilgileri dlgTemp = new KesinKayitBilgileri(
										_isInsert, -1);
								_dlgKesinKayitIslemleri.hide();

								if (listXmlOnKayit != null) {

									dlgTemp.putDataFromXML(listXmlOnKayit
											.get(0));
								} else {

								}

								dlgTemp.center();
								dlgTemp.tabKesinKayitBilgileri.selectTab(0);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}
}
