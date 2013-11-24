package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgVeliEkle extends DialogBox {
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

	public DlgVeliEkle() {
		setAutoHideEnabled(true);
		setHTML("Veli Bilgileri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("627px", "630px");

		Label lblAd = new Label("Adı");
		lblAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblAd, 10, 40);

		Label lblSoyadı = new Label("Soyadı");
		lblSoyadı.setStyleName("gwt-Bold");
		absolutePanel.add(lblSoyadı, 10, 76);
		lblSoyadı.setSize("47px", "18px");

		Label lblTcKimlikNo = new Label("T.C Kimlik No");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblTcKimlikNo, 10, 111);

		Label lblYaknlkDurumu = new Label("Yakınlık Durumu");
		lblYaknlkDurumu.setStyleName("gwt-Bold");
		absolutePanel.add(lblYaknlkDurumu, 10, 146);

		Label lbldemeSorumlusu = new Label("Ödeme Sorumlusu");
		lbldemeSorumlusu.setStyleName("gwt-Bold");
		absolutePanel.add(lbldemeSorumlusu, 10, 181);

		Label lblCepTel = new Label("Cep Tel");
		lblCepTel.setStyleName("gwt-Bold");
		absolutePanel.add(lblCepTel, 10, 216);

		Label lblITel = new Label("İş Tel");
		lblITel.setStyleName("gwt-Bold");
		absolutePanel.add(lblITel, 10, 284);

		Label lblEvTel = new Label("Ev Tel");
		lblEvTel.setStyleName("gwt-Bold");
		absolutePanel.add(lblEvTel, 10, 251);
		lblEvTel.setSize("38px", "18px");

		Label lblEmail = new Label("E-Mail");
		lblEmail.setStyleName("gwt-Bold");
		absolutePanel.add(lblEmail, 10, 316);

		Label lblFirma = new Label("Firma");
		lblFirma.setStyleName("gwt-Bold");
		absolutePanel.add(lblFirma, 10, 349);

		Label lblSektr = new Label("Sektör");
		lblSektr.setStyleName("gwt-Bold");
		absolutePanel.add(lblSektr, 10, 386);

		Label lblNewLabel = new Label("Ünvanı");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 417);

		Label lblGrevi = new Label("Görevi");
		lblGrevi.setStyleName("gwt-Bold");
		absolutePanel.add(lblGrevi, 10, 459);

		Label lblAdress = new Label("Adres");
		lblAdress.setStyleName("gwt-Bold");
		absolutePanel.add(lblAdress, 10, 497);

		tctVeliBilgileriTcKimlikNo = new TextBox();
		tctVeliBilgileriTcKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVeliBilgileriTcKimlikNo, 165, 107);
		tctVeliBilgileriTcKimlikNo.setSize("143px", "14px");

		tctVeliBilgileriAdi = new TextBox();
		tctVeliBilgileriAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVeliBilgileriAdi, 165, 40);
		tctVeliBilgileriAdi.setSize("143px", "14px");

		tctVeliBilgileriSoyadi = new TextBox();
		tctVeliBilgileriSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVeliBilgileriSoyadi, 165, 76);
		tctVeliBilgileriSoyadi.setSize("143px", "14px");

		tctEvTel = new TextBox();
		tctEvTel.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEvTel, 165, 251);
		tctEvTel.setSize("180px", "14px");

		tctIsTel = new TextBox();
		tctIsTel.setStylePrimaryName("gwt-TextBox1");
		absolutePanel.add(tctIsTel, 165, 284);
		tctIsTel.setSize("180px", "14px");

		tctEmail = new TextBox();
		tctEmail.setStylePrimaryName("gwt-TextBox1");
		absolutePanel.add(tctEmail, 165, 316);
		tctEmail.setSize("180px", "14px");

		tctFirma = new TextBox();
		tctFirma.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctFirma, 165, 349);
		tctFirma.setSize("180px", "14px");

		tctSektor = new TextBox();
		tctSektor.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSektor, 165, 386);
		tctSektor.setSize("180px", "14px");

		tctVeliBilgileriAdres = new TextBox();
		tctVeliBilgileriAdres.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVeliBilgileriAdres, 165, 497);
		tctVeliBilgileriAdres.setSize("180px", "14px");

		tctGorevi = new TextBox();
		tctGorevi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctGorevi, 165, 459);
		tctGorevi.setSize("180px", "14px");

		tctUnvani = new TextBox();
		tctUnvani.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctUnvani, 165, 417);
		tctUnvani.setSize("180px", "14px");

		tctCepTel = new TextBox();
		tctCepTel.setStylePrimaryName("gwt-TextBox1");
		absolutePanel.add(tctCepTel, 165, 216);
		tctCepTel.setSize("180px", "14px");

		chxOdemeSorumlusu = new SimpleCheckBox();
		absolutePanel.add(chxOdemeSorumlusu, 165, 180);

		cbxYakinlikDurumu = new ListBox();
		cbxYakinlikDurumu.setStyleName("gwt-ComboBox1");
		cbxYakinlikDurumu.addItem("Anne");
		cbxYakinlikDurumu.addItem("Baba");
		cbxYakinlikDurumu.addItem("Diğer");
		absolutePanel.add(cbxYakinlikDurumu, 165, 142);
		cbxYakinlikDurumu.setSize("147px", "22px");

		btnVeliyiKaydet = new Button("New button");
		btnVeliyiKaydet.setStyleName("gwt-ButtonSave");
		btnVeliyiKaydet.addClickHandler(new BtnVeliyiKaydetClickHandler());
		btnVeliyiKaydet.setText("Veliyi Kaydet");
		absolutePanel.add(btnVeliyiKaydet, 357, 522);
		btnVeliyiKaydet.setSize("78px", "55px");

		btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 445, 522);
		btnKapat.setSize("78px", "55px");

		Label lblrenciTcKimlik = new Label("Öğrenci T.C Kimlik No");
		lblrenciTcKimlik.setStyleName("gwt-Bold");
		absolutePanel.add(lblrenciTcKimlik, 10, 10);

		tctOgrenciTCKimlikNo = new TextBox();
		tctOgrenciTCKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctOgrenciTCKimlikNo, 165, 10);
		tctOgrenciTCKimlikNo.setSize("143px", "14px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnVeliyiKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putveliekle?";

			URLValue = URLValue + "veli_bilgileri_adi="
					+ tctVeliBilgileriAdi.getText();
			URLValue = URLValue + "&veli_bilgileri_soyadi="
					+ tctVeliBilgileriAdi.getText();
			URLValue = URLValue + "&veli_bilgileri_adi="
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

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue,
					"Veli Bilgisi Başarıyla Eklenmiştir",
					"Veli Bilgisi Eklenemedi");
		}

	}

	public void putDataFromXML(XMLVeliEkle xml) {
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

	}
}
