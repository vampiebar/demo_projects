package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgKullaniciTanimlama extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctKullaniciKodu;
	private TextBox tctAdi;
	private TextBox tctSoyadi;
	private PasswordTextBox tctSifre;
	private PasswordTextBox tctSifretekrar;
	public DecoratedTabPanel tabKullaniciTanimlama;
	private Button btnKaydet;
	private Image image;
	private Image image_1;

	public DlgKullaniciTanimlama(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Kullanici Tanimlama");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("485px", "430px");

		tabKullaniciTanimlama = new DecoratedTabPanel();
		absolutePanel.add(tabKullaniciTanimlama, 0, 0);
		tabKullaniciTanimlama.setSize("475px", "314px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabKullaniciTanimlama
				.add(absolutePanel_1, "Kullanıcı Bilgileri", false);
		absolutePanel_1.setSize("460px", "270px");

		FlexTable flexTable = new FlexTable();
		absolutePanel_1.add(flexTable, 10, 10);
		flexTable.setSize("265px", "123px");

		Label lblKullancKodu = new Label("Kullanıcı Kodu");
		flexTable.setWidget(0, 0, lblKullancKodu);
		lblKullancKodu.setStyleName("gwt-Bold");

		tctKullaniciKodu = new TextBox();
		tctKullaniciKodu.setMaxLength(3);
		flexTable.setWidget(0, 1, tctKullaniciKodu);
		tctKullaniciKodu.setStyleName("gwt-TextBox1");
		tctKullaniciKodu.setSize("143px", "16px");

		Label lblAd = new Label("Adı");
		flexTable.setWidget(1, 0, lblAd);
		lblAd.setStyleName("gwt-Bold");

		tctAdi = new TextBox();
		tctAdi.setMaxLength(30);
		flexTable.setWidget(1, 1, tctAdi);
		tctAdi.setStyleName("gwt-TextBox1");
		tctAdi.setSize("143px", "16px");

		Label lblSoyad = new Label("Soyadı");
		flexTable.setWidget(2, 0, lblSoyad);
		lblSoyad.setStyleName("gwt-Bold");

		tctSoyadi = new TextBox();
		tctSoyadi.setMaxLength(30);
		flexTable.setWidget(2, 1, tctSoyadi);
		tctSoyadi.setStyleName("gwt-TextBox1");
		tctSoyadi.setSize("143px", "16px");

		Label lblifre = new Label("Şifre");
		flexTable.setWidget(3, 0, lblifre);
		lblifre.setStyleName("gwt-Bold");

		tctSifre = new PasswordTextBox();
		tctSifre.setMaxLength(10);
		flexTable.setWidget(3, 1, tctSifre);
		tctSifre.setStyleName("gwt-TextBox1");
		tctSifre.setSize("143px", "16px");

		Label lblifreTekrar = new Label("Şifre Tekrar");
		flexTable.setWidget(4, 0, lblifreTekrar);
		lblifreTekrar.setStyleName("gwt-Bold");
		lblifreTekrar.setSize("87px", "23px");

		tctSifretekrar = new PasswordTextBox();
		tctSifretekrar.setMaxLength(10);
		flexTable.setWidget(4, 1, tctSifretekrar);
		tctSifretekrar.setStyleName("gwt-TextBox1");
		tctSifretekrar.setSize("143px", "16px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		tabKullaniciTanimlama.add(absolutePanel_2, "Yetkileri", false);
		absolutePanel_2.setSize("460px", "270px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new TctKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 68, 354);
		btnKaydet.setSize("78px", "47px");

		Button tctKapat = new Button("New button");
		tctKapat.setVisible(false);
		tctKapat.setStyleName("gwt-ButonKapat");
		tctKapat.addClickHandler(new TctKapatClickHandler());
		tctKapat.setText("Kapat");
		absolutePanel.add(tctKapat, 146, 354);
		tctKapat.setSize("78px", "47px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 302, 320);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 383, 320);
		image_1.setSize("72px", "66px");
	}

	private class TctKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class TctKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putkullanicitanimlama?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&kullanici_kodu="
					+ tctKullaniciKodu.getText();
			URLValue = URLValue + "&adi=" + tctAdi.getText();
			URLValue = URLValue + "&soyadi=" + tctSoyadi.getText();
			URLValue = URLValue + "&sifre=" + tctSifre.getText();
			URLValue = URLValue + "&sifre_tekrar=" + tctSifretekrar.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";
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

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKaydet.click();
		}
	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class Image_1MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_1.setUrl("kapat-2.png");

		}
	}

	private class ImageMouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image.setUrl("kaydet-2.png");

		}
	}

	private class ImageMouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image.setUrl("kaydet-1.png");

		}
	}

	private class Image_1MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_1.setUrl("kapat-1.png");

		}
	}
}
