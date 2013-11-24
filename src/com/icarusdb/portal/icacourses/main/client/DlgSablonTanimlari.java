package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgSablonTanimlari extends DialogBox {
	private TextBox tctSablonAdi;
	private TextBox tctSayisal;
	private TextBox tctSozel;
	private TextBox tctEsitA;
	private TextBox tctDil;
	private TextBox tctAlanYok;
	private ListBox cbxAlan;
	private TextBox tctDeger;
	private TextBox tctLYS1;
	private TextBox tctLYS2;
	private TextBox tctLYS3;
	private TextBox tctLYS4;
	private TextBox tctLYS5;
	private ListBox cbxSinavTuru;
	private CheckBox chxErkek;
	private CheckBox chxKiz;

	public DlgSablonTanimlari() {
		setHTML("Dönem Ekle/Değiştir");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("744px", "619px");

		Label lblNewLabel = new Label(
				"Form Şablonu Tanımlama (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("744px", "28px");

		Label lblablonAd = new Label("Şablon Adı");
		lblablonAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblablonAd, 10, 46);

		tctSablonAdi = new TextBox();
		tctSablonAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSablonAdi, 130, 44);
		tctSablonAdi.setSize("149px", "16px");

		Label lblNewLabel_1 = new Label("Parametrelerin Gelen Kodları");
		lblNewLabel_1.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel_1, 0, 83);
		lblNewLabel_1.setSize("744px", "28px");

		Label lblCinsiyet = new Label("CİNSİYET");
		lblCinsiyet.setStyleName("gwt-Bold");
		absolutePanel.add(lblCinsiyet, 58, 117);

		chxErkek = new CheckBox("Erkek");
		absolutePanel.add(chxErkek, 31, 144);

		chxKiz = new CheckBox("Kız");
		absolutePanel.add(chxKiz, 31, 170);

		Label lblAlani = new Label("ALANI");
		lblAlani.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlani, 58, 206);

		Label lblSaysal = new Label("Sayısal");
		lblSaysal.setStyleName("gwt-Bold");
		absolutePanel.add(lblSaysal, 10, 242);

		Label lblSzel = new Label("Sözel");
		lblSzel.setStyleName("gwt-Bold");
		absolutePanel.add(lblSzel, 10, 266);

		Label lblEArlk = new Label("Eşit A.");
		lblEArlk.setStyleName("gwt-Bold");
		absolutePanel.add(lblEArlk, 10, 290);

		Label lblNewLabel_2 = new Label("Dil");
		lblNewLabel_2.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_2, 10, 315);

		Label lblAlanYok = new Label("Alanı yok");
		lblAlanYok.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlanYok, 10, 339);

		tctSayisal = new TextBox();
		tctSayisal.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSayisal, 90, 246);
		tctSayisal.setSize("143px", "14px");

		tctSozel = new TextBox();
		tctSozel.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSozel, 90, 270);
		tctSozel.setSize("143px", "14px");

		tctEsitA = new TextBox();
		tctEsitA.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEsitA, 90, 294);
		tctEsitA.setSize("143px", "15px");

		tctDil = new TextBox();
		tctDil.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctDil, 90, 319);
		tctDil.setSize("143px", "14px");

		tctAlanYok = new TextBox();
		tctAlanYok.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAlanYok, 90, 343);
		tctAlanYok.setSize("143px", "14px");

		Label lblDatadanCevapAnahtar = new Label(
				"Datadan Cevap Anahtarı Alan Parametresi");
		lblDatadanCevapAnahtar.setStyleName("gwt-Bold");
		absolutePanel.add(lblDatadanCevapAnahtar, 363, 117);
		lblDatadanCevapAnahtar.setSize("309px", "18px");

		Label lblAlan = new Label("Alan");
		lblAlan.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlan, 373, 144);

		Label lblDeer = new Label("Değer");
		lblDeer.setStyleName("gwt-Bold");
		absolutePanel.add(lblDeer, 370, 174);

		Label lblNewLabel_3 = new Label("Parametreler");
		lblNewLabel_3.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_3, 0, 425);
		lblNewLabel_3.setSize("744px", "29px");

		Button btnParametreDegeriEkle = new Button("Parametre Değeri Ekle");
		absolutePanel.add(btnParametreDegeriEkle, 10, 460);
		btnParametreDegeriEkle.setSize("169px", "18px");

		Label lblLysTr = new Label("LYS TÜRÜ");
		lblLysTr.setStyleName("gwt-Bold");
		absolutePanel.add(lblLysTr, 430, 208);

		Label lblLys = new Label("LYS - 1");
		lblLys.setStyleName("gwt-Bold");
		absolutePanel.add(lblLys, 363, 242);
		lblLys.setSize("54px", "18px");

		Label label = new Label("LYS - 2");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 363, 266);
		label.setSize("54px", "18px");

		Label label_1 = new Label("LYS - 3");
		label_1.setStyleName("gwt-Bold");
		absolutePanel.add(label_1, 363, 290);
		label_1.setSize("54px", "18px");

		Label label_2 = new Label("LYS - 4");
		label_2.setStyleName("gwt-Bold");
		absolutePanel.add(label_2, 363, 315);
		label_2.setSize("54px", "18px");

		Label label_3 = new Label("LYS - 5");
		label_3.setStyleName("gwt-Bold");
		absolutePanel.add(label_3, 363, 339);
		label_3.setSize("54px", "18px");

		tctLYS1 = new TextBox();
		tctLYS1.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctLYS1, 445, 246);
		tctLYS1.setSize("149px", "14px");

		tctLYS2 = new TextBox();
		tctLYS2.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctLYS2, 445, 270);
		tctLYS2.setSize("149px", "14px");

		tctLYS3 = new TextBox();
		tctLYS3.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctLYS3, 445, 294);
		tctLYS3.setSize("149px", "15px");

		tctLYS4 = new TextBox();
		tctLYS4.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctLYS4, 445, 319);
		tctLYS4.setSize("149px", "14px");

		tctLYS5 = new TextBox();
		tctLYS5.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctLYS5, 445, 343);
		tctLYS5.setSize("149px", "14px");

		Button btnSablonuKaydet = new Button("New button");
		btnSablonuKaydet.setStyleName("gwt-ButtonSave");
		btnSablonuKaydet.addClickHandler(new BtnSablonuKaydetClickHandler());
		btnSablonuKaydet.setText("Şablonu Kaydet");
		absolutePanel.add(btnSablonuKaydet, 439, 374);
		btnSablonuKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 546, 374);
		btnKapat.setSize("78px", "45px");

		Label lblNewLabel_4 = new Label("Gruplar");
		lblNewLabel_4.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_4, 0, 484);
		lblNewLabel_4.setSize("744px", "30px");

		Label lblSnavTr = new Label("Sınav Türü");
		lblSnavTr.setStyleName("gwt-Bold");
		absolutePanel.add(lblSnavTr, 17, 531);

		cbxSinavTuru = new ListBox();
		cbxSinavTuru.setStyleName("gwt-ComboBox1");
		cbxSinavTuru.addItem("Lütfen Seçiniz");
		absolutePanel.add(cbxSinavTuru, 102, 527);
		cbxSinavTuru.setSize("139px", "22px");

		Button btnSinavaAitBilgileriYukle = new Button("New button");
		btnSinavaAitBilgileriYukle.setText("Sınava Ait Bilgileri Yükle");
		absolutePanel.add(btnSinavaAitBilgileriYukle, 260, 525);
		btnSinavaAitBilgileriYukle.setSize("157px", "24px");

		cbxAlan = new ListBox();
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem("Adı Soyadı");
		cbxAlan.addItem("Öğrenci No");
		cbxAlan.addItem("T.C. Kimlik no");
		absolutePanel.add(cbxAlan, 445, 144);
		cbxAlan.setSize("151px", "22px");

		tctDeger = new TextBox();
		tctDeger.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctDeger, 445, 172);
		tctDeger.setSize("149px", "14px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnSablonuKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putsablontanimlari?";
			URLValue = URLValue + "sablon_adi=" + tctSablonAdi.getText();
			URLValue = URLValue + "&erkek=" + chxErkek.getValue().toString();
			URLValue = URLValue + "&kiz=" + chxKiz.getValue().toString();

			URLValue = URLValue + "&sayisal=" + tctSayisal.getText();
			URLValue = URLValue + "&sozel=" + tctSozel.getText();
			URLValue = URLValue + "&esit_a=" + tctEsitA.getText();
			URLValue = URLValue + "&dil=" + tctDil.getText();
			URLValue = URLValue + "&alani_yok=" + tctAlanYok.getText();
			URLValue = URLValue + "&alan="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&deger=" + tctDeger.getText();
			URLValue = URLValue + "&lys_1=" + tctLYS1.getText();
			URLValue = URLValue + "&lys_2=" + tctLYS2.getText();
			URLValue = URLValue + "&lys_3=" + tctLYS3.getText();
			URLValue = URLValue + "&lys_4=" + tctLYS4.getText();
			URLValue = URLValue + "&lys_5=" + tctLYS5.getText();
			URLValue = URLValue + "&alan="
					+ cbxSinavTuru.getValue(cbxSinavTuru.getSelectedIndex());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLSablonTanimlari xml) {
		tctAlanYok.setText(xml.alani_yok);
		tctDeger.setText(xml.deger);
		tctDil.setText(xml.dil);
		tctEsitA.setText(xml.esit_a);
		tctLYS1.setText(xml.lys_1);
		tctLYS2.setText(xml.lys_2);
		tctLYS3.setText(xml.lys_3);
		tctLYS4.setText(xml.lys_4);
		tctLYS5.setText(xml.lys_5);
		tctSablonAdi.setText(xml.sablon_adi);
		tctSayisal.setText(xml.sayisal);
		tctSozel.setText(xml.sozel);

		cbxAlan.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxAlan, xml.alan));
		cbxSinavTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxSinavTuru, xml.sinav_turu));

	}
}
