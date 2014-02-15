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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgVeliEkle extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private Button btnVeliyiKaydet;
	private Button btnKapat;
	private TextBox tctVeliBilgileriAdi;
	private TextBox tctVeliBilgileriSoyadi;
	private TextBox tctVeliBilgileriTcKimlikNo;
	private ListBox cbxYakinlikDurumu;
	private TextBox tctCepTel;
	private TextBox tctEvTel;
	private TextBox tctIsTel;
	private TextBox tctEmail;
	private TextBox tctFirma;
	private TextBox tctSektor;
	private TextBox tctUnvani;
	private TextBox tctGorevi;
	private TextBox tctVeliBilgileriAdres;
	private SimpleCheckBox chxOdemeSorumlusu;
	private TextBox tctOgrenciTCKimlikNo;
	private Image image;
	private Image image_1;

	public DlgVeliEkle(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;
		setHTML("Veli Bilgileri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("580px", "494px");

		btnVeliyiKaydet = new Button("New button");
		btnVeliyiKaydet.setVisible(false);
		btnVeliyiKaydet.setStyleName("gwt-ButtonSave");
		btnVeliyiKaydet.addClickHandler(new BtnVeliyiKaydetClickHandler());
		btnVeliyiKaydet.setText("Veliyi Kaydet");
		absolutePanel.add(btnVeliyiKaydet, 408, 315);
		btnVeliyiKaydet.setSize("83px", "64px");

		btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("");
		absolutePanel.add(btnKapat, 501, 315);
		btnKapat.setSize("83px", "64px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 363, 406);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 448, 406);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 10, 10);
		flexTable.setSize("357px", "311px");

		Label lblrenciTcKimlik = new Label("Öğrenci T.C Kimlik No");
		flexTable.setWidget(0, 0, lblrenciTcKimlik);
		lblrenciTcKimlik.setStyleName("gwt-Bold");
		lblrenciTcKimlik.setSize("165px", "16px");

		tctOgrenciTCKimlikNo = new TextBox();
		tctOgrenciTCKimlikNo
				.addKeyPressHandler(new TctOgrenciTCKimlikNoKeyPressHandler());
		flexTable.setWidget(0, 1, tctOgrenciTCKimlikNo);
		tctOgrenciTCKimlikNo.setMaxLength(11);
		tctOgrenciTCKimlikNo.setStyleName("gwt-TextBox1");
		tctOgrenciTCKimlikNo.setSize("180px", "14px");

		Label lblAd = new Label("Adı");
		flexTable.setWidget(1, 0, lblAd);
		lblAd.setStyleName("gwt-Bold");
		lblAd.setSize("36px", "16px");

		tctVeliBilgileriAdi = new TextBox();
		flexTable.setWidget(1, 1, tctVeliBilgileriAdi);
		tctVeliBilgileriAdi.setStyleName("gwt-TextBox1");
		tctVeliBilgileriAdi.setSize("180px", "14px");

		Label lblSoyadı = new Label("Soyadı");
		flexTable.setWidget(2, 0, lblSoyadı);
		lblSoyadı.setStyleName("gwt-Bold");
		lblSoyadı.setSize("105px", "18px");

		tctVeliBilgileriSoyadi = new TextBox();
		flexTable.setWidget(2, 1, tctVeliBilgileriSoyadi);
		tctVeliBilgileriSoyadi.setStyleName("gwt-TextBox1");
		tctVeliBilgileriSoyadi.setSize("180px", "14px");

		Label lblTcKimlikNo = new Label("T.C Kimlik No");
		flexTable.setWidget(3, 0, lblTcKimlikNo);
		lblTcKimlikNo.setStyleName("gwt-Bold");
		lblTcKimlikNo.setSize("105px", "16px");

		tctVeliBilgileriTcKimlikNo = new TextBox();
		tctVeliBilgileriTcKimlikNo
				.addKeyPressHandler(new TctVeliBilgileriTcKimlikNoKeyPressHandler());
		flexTable.setWidget(3, 1, tctVeliBilgileriTcKimlikNo);
		tctVeliBilgileriTcKimlikNo.setMaxLength(11);
		tctVeliBilgileriTcKimlikNo.setStyleName("gwt-TextBox1");
		tctVeliBilgileriTcKimlikNo.setSize("180px", "14px");

		Label lblYaknlkDurumu = new Label("Yakınlık Durumu");
		flexTable.setWidget(4, 0, lblYaknlkDurumu);
		lblYaknlkDurumu.setStyleName("gwt-Bold");
		lblYaknlkDurumu.setSize("149px", "16px");

		cbxYakinlikDurumu = new ListBox();
		flexTable.setWidget(4, 1, cbxYakinlikDurumu);
		cbxYakinlikDurumu.setStyleName("gwt-ComboBox1");
		cbxYakinlikDurumu.addItem("Anne");
		cbxYakinlikDurumu.addItem("Baba");
		cbxYakinlikDurumu.addItem("Diğer");
		cbxYakinlikDurumu.setSize("182px", "22px");

		Label lbldemeSorumlusu = new Label("Ödeme Sorumlusu");
		flexTable.setWidget(5, 0, lbldemeSorumlusu);
		lbldemeSorumlusu.setStyleName("gwt-Bold");
		lbldemeSorumlusu.setSize("149px", "16px");

		chxOdemeSorumlusu = new SimpleCheckBox();
		flexTable.setWidget(5, 1, chxOdemeSorumlusu);

		Label lblCepTel = new Label("Cep Tel");
		flexTable.setWidget(6, 0, lblCepTel);
		lblCepTel.setStyleName("gwt-Bold");
		lblCepTel.setSize("105px", "16px");

		tctCepTel = new TextBox();
		tctCepTel.addKeyPressHandler(new TctCepTelKeyPressHandler());
		flexTable.setWidget(6, 1, tctCepTel);
		tctCepTel.setMaxLength(10);
		tctCepTel.setStylePrimaryName("gwt-TextBox1");
		tctCepTel.setSize("180px", "14px");

		Label lblEvTel = new Label("Ev Tel");
		flexTable.setWidget(7, 0, lblEvTel);
		lblEvTel.setStyleName("gwt-Bold");
		lblEvTel.setSize("105px", "18px");

		tctEvTel = new TextBox();
		tctEvTel.addKeyPressHandler(new TctEvTelKeyPressHandler());
		flexTable.setWidget(7, 1, tctEvTel);
		tctEvTel.setMaxLength(10);
		tctEvTel.setStyleName("gwt-TextBox1");
		tctEvTel.setSize("180px", "14px");

		Label lblITel = new Label("İş Tel");
		flexTable.setWidget(8, 0, lblITel);
		lblITel.setStyleName("gwt-Bold");
		lblITel.setSize("105px", "16px");

		tctIsTel = new TextBox();
		tctIsTel.addKeyPressHandler(new TctIsTelKeyPressHandler());
		flexTable.setWidget(8, 1, tctIsTel);
		tctIsTel.setMaxLength(10);
		tctIsTel.setStylePrimaryName("gwt-TextBox1");
		tctIsTel.setSize("180px", "14px");

		Label lblEmail = new Label("E-Mail");
		flexTable.setWidget(9, 0, lblEmail);
		lblEmail.setStyleName("gwt-Bold");
		lblEmail.setSize("105px", "16px");

		tctEmail = new TextBox();
		tctEmail.addKeyPressHandler(new TctEmailKeyPressHandler());
		flexTable.setWidget(9, 1, tctEmail);
		tctEmail.setStylePrimaryName("gwt-TextBox1");
		tctEmail.setSize("180px", "14px");

		Label lblFirma = new Label("Firma");
		flexTable.setWidget(10, 0, lblFirma);
		lblFirma.setStyleName("gwt-Bold");
		lblFirma.setSize("105px", "16px");

		tctFirma = new TextBox();
		flexTable.setWidget(10, 1, tctFirma);
		tctFirma.setStyleName("gwt-TextBox1");
		tctFirma.setSize("180px", "14px");

		Label lblSektr = new Label("Sektör");
		flexTable.setWidget(11, 0, lblSektr);
		lblSektr.setStyleName("gwt-Bold");
		lblSektr.setSize("105px", "16px");

		tctSektor = new TextBox();
		flexTable.setWidget(11, 1, tctSektor);
		tctSektor.setStyleName("gwt-TextBox1");
		tctSektor.setSize("180px", "14px");

		Label lblNewLabel = new Label("Ünvanı");
		flexTable.setWidget(12, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");
		lblNewLabel.setSize("105px", "16px");

		tctUnvani = new TextBox();
		flexTable.setWidget(12, 1, tctUnvani);
		tctUnvani.setStyleName("gwt-TextBox1");
		tctUnvani.setSize("180px", "14px");

		Label lblGrevi = new Label("Görevi");
		flexTable.setWidget(13, 0, lblGrevi);
		lblGrevi.setStyleName("gwt-Bold");
		lblGrevi.setSize("65px", "16px");

		tctGorevi = new TextBox();
		flexTable.setWidget(13, 1, tctGorevi);
		tctGorevi.setStyleName("gwt-TextBox1");
		tctGorevi.setSize("180px", "14px");

		Label lblAdress = new Label("Adres");
		flexTable.setWidget(14, 0, lblAdress);
		lblAdress.setStyleName("gwt-Bold");
		lblAdress.setSize("95px", "16px");

		tctVeliBilgileriAdres = new TextBox();
		flexTable.setWidget(14, 1, tctVeliBilgileriAdres);
		tctVeliBilgileriAdres.setStyleName("gwt-TextBox1");
		tctVeliBilgileriAdres.setSize("180px", "14px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnVeliyiKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putveliler?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&veli_bilgileri_adi="
					+ tctVeliBilgileriAdi.getText();
			URLValue = URLValue + "&veli_bilgileri_soyadi="
					+ tctVeliBilgileriSoyadi.getText();
			URLValue = URLValue + "&veli_bilgileri_tc_kimlik_no="
					+ tctVeliBilgileriTcKimlikNo.getText();
			URLValue = URLValue
					+ "&yakinlik_durumu="
					+ cbxYakinlikDurumu.getValue(cbxYakinlikDurumu
							.getSelectedIndex());
			URLValue = URLValue + "&odeme_sorumlusu="
					+ chxOdemeSorumlusu.getValue().toString();
			URLValue = URLValue + "&cep_tel=" + tctCepTel.getText();
			URLValue = URLValue + "&ev_tel=" + tctEvTel.getText();
			URLValue = URLValue + "&is_tel=" + tctIsTel.getText();

			URLValue = URLValue + "&e_mail=" + tctEmail.getText();
			URLValue = URLValue + "&firma=" + tctFirma.getText();
			URLValue = URLValue + "&sektor=" + tctSektor.getText();
			URLValue = URLValue + "&unvani=" + tctUnvani.getText();
			URLValue = URLValue + "&gorevi=" + tctGorevi.getText();
			URLValue = URLValue + "&veli_bilgileri_adres="
					+ tctVeliBilgileriAdres.getText();
			URLValue = URLValue + "&ogrenci_tc_kimlik_no="
					+ tctOgrenciTCKimlikNo.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue,
					"Veli Bilgisi Başarıyla Eklenmiştir",
					"Veli Bilgisi Eklenemedi");
		}

	}

	public void putDataFromXML(XMLVeliler xml) {
		tctCepTel.setText(xml.cep_tel);
		tctEmail.setText(xml.e_mail);
		tctEvTel.setText(xml.ev_tel);
		tctFirma.setText(xml.firma);
		tctGorevi.setText(xml.gorevi);
		tctIsTel.setText(xml.is_tel);
		tctSektor.setText(xml.sektor);
		tctUnvani.setText(xml.unvani);
		tctVeliBilgileriAdi.setText(xml.veli_bilgileri_adi);
		tctVeliBilgileriAdres.setText(xml.veli_bilgileri_adres);
		tctVeliBilgileriSoyadi.setText(xml.veli_bilgileri_soyadi);
		tctVeliBilgileriTcKimlikNo.setText(xml.veli_bilgileri_tc_kimlik_no);
		tctOgrenciTCKimlikNo.setText(xml.ogrenci_tc_kimlik_no);

		tctOgrenciTCKimlikNo.setReadOnly(true);

		cbxYakinlikDurumu.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxYakinlikDurumu, xml.yakinlik_durumu));

		chxOdemeSorumlusu
				.setValue(xml.odeme_sorumlusu.equalsIgnoreCase("t") ? true
						: false);

	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnVeliyiKaydet.click();
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

	private class TctOgrenciTCKimlikNoKeyPressHandler implements
			KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctOgrenciTCKimlikNo.getText();
			if (!input.matches("[0-9]*")) {
				tctOgrenciTCKimlikNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctOgrenciTCKimlikNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctIsTelKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctIsTel.getText();
			if (!input.matches("[0-9]*")) {
				tctIsTel.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctIsTel.setStyleName("gwt-TextBox1");

		}
	}

	private class TctVeliBilgileriTcKimlikNoKeyPressHandler implements
			KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctVeliBilgileriTcKimlikNo.getText();
			if (!input.matches("[0-9]*")) {
				tctVeliBilgileriTcKimlikNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctVeliBilgileriTcKimlikNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctEvTelKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctEvTel.getText();
			if (!input.matches("[0-9]*")) {
				tctEvTel.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctEvTel.setStyleName("gwt-TextBox1");

		}
	}

	private class TctCepTelKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctCepTel.getText();
			if (!input.matches("[0-9]*")) {
				tctCepTel.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctCepTel.setStyleName("gwt-TextBox1");

		}
	}

	private class TctEmailKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctEmail.getText();
			if (!input
					.matches("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$")) {
				tctEmail.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctEmail.setStyleName("gwt-TextBox1");

		}
	}
}
