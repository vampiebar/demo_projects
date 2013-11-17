package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgKullaniciTanimlama extends DialogBox {
	private TextBox tctKullaniciKodu;
	private TextBox tctAdi;
	private TextBox tctSoyadi;
	private TextBox tctSifre;
	private TextBox tctSifretekrar;

	public DlgKullaniciTanimlama() {
		setHTML("Kullanici Tanimlama");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("490px", "445px");

		Label lblKullancIlemlerieklemedzenleme = new Label(
				"Kullanıcı İşlemleri (Ekleme/Düzenleme)");
		lblKullancIlemlerieklemedzenleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblKullancIlemlerieklemedzenleme, 0, 0);
		lblKullancIlemlerieklemedzenleme.setSize("500px", "28px");

		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		absolutePanel.add(decoratedTabPanel, 10, 38);
		decoratedTabPanel.setSize("470px", "300px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel.add(absolutePanel_1, "Kullanıcı Bilgileri", false);
		absolutePanel_1.setSize("462px", "268px");

		Label lblKullancKodu = new Label("Kullanıcı kodu");
		lblKullancKodu.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblKullancKodu, 10, 10);

		Label lblAd = new Label("Adı");
		lblAd.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblAd, 10, 34);

		Label lblSoyad = new Label("Soyadı");
		lblSoyad.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblSoyad, 10, 61);

		Label lblifre = new Label("Şifre");
		lblifre.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblifre, 10, 95);

		Label lblifreTekrar = new Label("Şifre Tekrar");
		lblifreTekrar.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblifreTekrar, 10, 130);
		lblifreTekrar.setSize("87px", "23px");

		tctKullaniciKodu = new TextBox();
		tctKullaniciKodu.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctKullaniciKodu, 118, 10);
		tctKullaniciKodu.setSize("143px", "14px");

		tctAdi = new TextBox();
		tctAdi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctAdi, 118, 34);
		tctAdi.setSize("143px", "14px");

		tctSoyadi = new TextBox();
		tctSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctSoyadi, 118, 61);
		tctSoyadi.setSize("143px", "14px");

		tctSifre = new TextBox();
		tctSifre.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctSifre, 118, 95);
		tctSifre.setSize("143px", "14px");

		tctSifretekrar = new TextBox();
		tctSifretekrar.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctSifretekrar, 118, 130);
		tctSifretekrar.setSize("143px", "14px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		decoratedTabPanel.add(absolutePanel_2, "Yetkileri", false);
		absolutePanel_2.setSize("468px", "264px");

		Button tctKaydet = new Button("New button");
		tctKaydet.setStyleName("gwt-ButtonSave");
		tctKaydet.addClickHandler(new TctKaydetClickHandler());
		tctKaydet.setText("Kaydet");
		absolutePanel.add(tctKaydet, 244, 354);
		tctKaydet.setSize("78px", "47px");

		Button tctKapat = new Button("New button");
		tctKapat.setStyleName("gwt-ButonKapat");
		tctKapat.addClickHandler(new TctKapatClickHandler());
		tctKapat.setText("Kapat");
		absolutePanel.add(tctKapat, 340, 354);
		tctKapat.setSize("78px", "47px");
	}

	private class TctKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class TctKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putkullanicitanimlama?";

			URLValue = URLValue + "kullanici_kodu="
					+ tctKullaniciKodu.getText();
			URLValue = URLValue + "&adi=" + tctAdi.getText();
			URLValue = URLValue + "&soyadi=" + tctSoyadi.getText();
			URLValue = URLValue + "&sifre=" + tctSifre.getText();
			URLValue = URLValue + "&sifre_tekrar=" + tctSifretekrar.getText();
			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	public void putDataFromXML(XMLKullaniciTanimlama xml) {
		tctAdi.setText(xml.adi);
		tctKullaniciKodu.setText(xml.kullanici_kodu);
		tctSifre.setText(xml.sifre);
		tctSifretekrar.setText(xml.sifre_tekrar);
		tctSoyadi.setText(xml.soyadi);

	}
}
