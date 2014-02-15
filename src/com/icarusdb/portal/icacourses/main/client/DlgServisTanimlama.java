package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgServisTanimlama extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private Button btnKaydet;
	private TextBox tctKodu;
	private TextBox tctSoforunTelefonu;
	private TextBox tctSoforAdi;
	private TextBox tctGuzergah;
	private TextBox tctServisUcreti;
	private TextBox tctAracSahibi;
	private TextBox tctAracSahibininTelefonu;
	private TextBox tctYolcuSayisi;
	private TextBox tctKapasitesi;
	private TextBox tctAracPlakası;
	private Image image;
	private Image image_1;

	public DlgServisTanimlama(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setGlassEnabled(true);
		setHTML("Servis Tanimlama");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("485px", "420px");

		Button btnNewButton = new Button("New button");
		btnNewButton.setVisible(false);
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		btnNewButton.setStyleName("gwt-ButonKapat");
		btnNewButton.setText("");
		absolutePanel.add(btnNewButton, 404, 204);
		btnNewButton.setSize("78px", "46px");

		btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.setVisible(false);
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());

		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 320, 201);
		btnKaydet.setSize("78px", "49px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 275, 302);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 353, 302);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 10, 10);
		flexTable.setSize("279px", "252px");

		Label lblNewLabel = new Label("Kodu");
		flexTable.setWidget(0, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");
		lblNewLabel.setSize("97px", "18px");

		tctKodu = new TextBox();
		flexTable.setWidget(0, 1, tctKodu);
		tctKodu.setStyleName("gwt-TextBox1");
		tctKodu.setSize("168px", "15px");

		Label lblNewLabel_1 = new Label("Güzergah");
		flexTable.setWidget(1, 0, lblNewLabel_1);
		lblNewLabel_1.setStyleName("gwt-Bold");
		lblNewLabel_1.setSize("97px", "18px");

		tctGuzergah = new TextBox();
		flexTable.setWidget(1, 1, tctGuzergah);
		tctGuzergah.setStyleName("gwt-TextBox1");
		tctGuzergah.setSize("168px", "15px");

		Label lblServiscreti = new Label("Servis Ücreti");
		flexTable.setWidget(2, 0, lblServiscreti);
		lblServiscreti.setStyleName("gwt-Bold");
		lblServiscreti.setSize("97px", "18px");

		tctServisUcreti = new TextBox();
		tctServisUcreti
				.addKeyPressHandler(new TctServisUcretiKeyPressHandler());
		flexTable.setWidget(2, 1, tctServisUcreti);
		tctServisUcreti.setStyleName("gwt-TextBox1");
		tctServisUcreti.setSize("168px", "15px");

		Label lblNewLabel_2 = new Label("Şöför Adı");
		flexTable.setWidget(3, 0, lblNewLabel_2);
		lblNewLabel_2.setStyleName("gwt-Bold");
		lblNewLabel_2.setSize("97px", "18px");

		tctSoforAdi = new TextBox();
		tctSoforAdi.setMaxLength(30);
		flexTable.setWidget(3, 1, tctSoforAdi);
		tctSoforAdi.setStyleName("gwt-TextBox1");
		tctSoforAdi.setSize("168px", "15px");

		Label lblNewLabel_3 = new Label("Telefonu");
		flexTable.setWidget(4, 0, lblNewLabel_3);
		lblNewLabel_3.setStyleName("gwt-Bold");
		lblNewLabel_3.setSize("97px", "18px");

		tctSoforunTelefonu = new TextBox();
		tctSoforunTelefonu.setMaxLength(11);
		tctSoforunTelefonu
				.addKeyPressHandler(new TctSoforunTelefonuKeyPressHandler());
		flexTable.setWidget(4, 1, tctSoforunTelefonu);
		tctSoforunTelefonu.setStyleName("gwt-TextBox1");
		tctSoforunTelefonu.setSize("168px", "15px");

		Label lblNewLabel_4 = new Label("Araç Sahibi");
		flexTable.setWidget(5, 0, lblNewLabel_4);
		lblNewLabel_4.setStyleName("gwt-Bold");
		lblNewLabel_4.setSize("97px", "18px");

		tctAracSahibi = new TextBox();
		tctAracSahibi.setMaxLength(30);
		flexTable.setWidget(5, 1, tctAracSahibi);
		tctAracSahibi.setStyleName("gwt-TextBox1");
		tctAracSahibi.setSize("168px", "15px");

		Label lblNewLabel_5 = new Label("Telefonu");
		flexTable.setWidget(6, 0, lblNewLabel_5);
		lblNewLabel_5.setStyleName("gwt-Bold");
		lblNewLabel_5.setSize("97px", "18px");

		tctAracSahibininTelefonu = new TextBox();
		tctAracSahibininTelefonu.setMaxLength(11);
		tctAracSahibininTelefonu
				.addKeyPressHandler(new TctAracSahibininTelefonuKeyPressHandler());
		flexTable.setWidget(6, 1, tctAracSahibininTelefonu);
		tctAracSahibininTelefonu.setStyleName("gwt-TextBox1");
		tctAracSahibininTelefonu.setSize("168px", "15px");

		Label lblNewLabel_6 = new Label("Araç Plakası");
		flexTable.setWidget(7, 0, lblNewLabel_6);
		lblNewLabel_6.setStyleName("gwt-Bold");
		lblNewLabel_6.setSize("97px", "18px");

		tctAracPlakası = new TextBox();
		tctAracPlakası.setMaxLength(10);
		flexTable.setWidget(7, 1, tctAracPlakası);
		tctAracPlakası.setStyleName("gwt-TextBox1");
		tctAracPlakası.setSize("168px", "15px");

		Label lblNewLabel_7 = new Label("Kapasitesi");
		flexTable.setWidget(8, 0, lblNewLabel_7);
		lblNewLabel_7.setStyleName("gwt-Bold");
		lblNewLabel_7.setSize("97px", "16px");

		tctKapasitesi = new TextBox();
		tctKapasitesi.setMaxLength(4);
		tctKapasitesi.addKeyPressHandler(new TctKapasitesiKeyPressHandler());
		flexTable.setWidget(8, 1, tctKapasitesi);
		tctKapasitesi.setStyleName("gwt-TextBox1");
		tctKapasitesi.setSize("168px", "15px");

		Label lblNewLabel_8 = new Label("Yolcu Sayısı");
		flexTable.setWidget(9, 0, lblNewLabel_8);
		lblNewLabel_8.setStyleName("gwt-Bold");
		lblNewLabel_8.setSize("97px", "18px");

		tctYolcuSayisi = new TextBox();
		tctYolcuSayisi.setMaxLength(4);
		tctYolcuSayisi.addKeyPressHandler(new TctYolcuSayisiKeyPressHandler());
		flexTable.setWidget(9, 1, tctYolcuSayisi);
		tctYolcuSayisi.setStyleName("gwt-TextBox1");
		tctYolcuSayisi.setSize("168px", "15px");
	}

	private class BtnNewButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putservistanimlama?";
			URLValue = URLValue + "id=" + _id;

			URLValue = URLValue + "&kodu=" + tctKodu.getText();
			URLValue = URLValue + "&guzergah=" + tctGuzergah.getText();
			URLValue = URLValue + "&servis_ucreti=" + tctServisUcreti.getText();
			URLValue = URLValue + "&sofor_adi=" + tctSoforAdi.getText();
			URLValue = URLValue + "&soforun_telefonu="
					+ tctAracSahibininTelefonu.getText();
			URLValue = URLValue + "&arac_sahibi=" + tctAracSahibi.getText();
			URLValue = URLValue + "&arac_sahibinin_telefonu="
					+ tctAracSahibininTelefonu.getText();
			URLValue = URLValue + "&arac_plakasi=" + tctAracPlakası.getText();
			URLValue = URLValue + "&kapasitesi=" + tctKapasitesi.getText();
			URLValue = URLValue + "&yolcu_sayisi=" + tctYolcuSayisi.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	public void putDataFromXML(XMLServisTanimlama xml) {
		tctKodu.setText(xml.kodu);
		tctGuzergah.setText(xml.guzergah);
		tctServisUcreti.setText(xml.servis_ucreti);
		tctSoforAdi.setText(xml.sofor_adi);
		tctSoforunTelefonu.setText(xml.soforun_telefonu);
		tctAracSahibi.setText(xml.arac_sahibi);
		tctAracSahibininTelefonu.setText(xml.arac_sahibinin_telefonu);
		tctAracPlakası.setText(xml.arac_plakasi);
		tctKapasitesi.setText(xml.kapasitesi);
		tctYolcuSayisi.setText(xml.yolcu_sayisi);

	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKaydet.click();
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

	private class TctKapasitesiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctKapasitesi.getText();
			if (!input.matches("[0-9]*")) {
				tctKapasitesi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctKapasitesi.setStyleName("gwt-TextBox1");

		}
	}

	private class TctAracSahibininTelefonuKeyPressHandler implements
			KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctAracSahibininTelefonu.getText();
			if (!input.matches("[0-9]*")) {
				tctAracSahibininTelefonu.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctAracSahibininTelefonu.setStyleName("gwt-TextBox1");

		}
	}

	private class TctYolcuSayisiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctYolcuSayisi.getText();
			if (!input.matches("[0-9]*")) {
				tctYolcuSayisi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctYolcuSayisi.setStyleName("gwt-TextBox1");

		}
	}

	private class TctServisUcretiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctServisUcreti.getText();
			if (!input.matches("[0-9]*")) {
				tctServisUcreti.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctServisUcreti.setStyleName("gwt-TextBox1");

		}
	}

	private class TctSoforunTelefonuKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctSoforunTelefonu.getText();
			if (!input.matches("[0-9]*")) {
				tctSoforunTelefonu.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctSoforunTelefonu.setStyleName("gwt-TextBox1");

		}
	}
}
