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
	private TextBox tctİsTel;
	private TextBox tctEmail;
	private TextBox tctFirma;
	private TextBox tctSektor;
	private TextBox tctUnvanı;
	private TextBox tctGorevi;
	private TextBox tctVeliBilgileriAdres;
	private SimpleCheckBox chxOdemeSorumlusu;

	public DlgVeliEkle() {
		setHTML("Veli Bilgileri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("627px", "630px");

		Label lblAd = new Label("Adı");
		lblAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblAd, 10, 10);

		Label lblSoyadı = new Label("Soyadı");
		lblSoyadı.setStyleName("gwt-Bold");
		absolutePanel.add(lblSoyadı, 10, 46);
		lblSoyadı.setSize("47px", "18px");

		Label lblTcKimlikNo = new Label("T.C Kimlik No");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblTcKimlikNo, 10, 81);

		Label lblYaknlkDurumu = new Label("Yakınlık Durumu");
		lblYaknlkDurumu.setStyleName("gwt-Bold");
		absolutePanel.add(lblYaknlkDurumu, 10, 116);

		Label lbldemeSorumlusu = new Label("Ödeme Sorumlusu");
		lbldemeSorumlusu.setStyleName("gwt-Bold");
		absolutePanel.add(lbldemeSorumlusu, 10, 151);

		Label lblCepTel = new Label("Cep Tel");
		lblCepTel.setStyleName("gwt-Bold");
		absolutePanel.add(lblCepTel, 10, 186);

		Label lblITel = new Label("İş Tel");
		lblITel.setStyleName("gwt-Bold");
		absolutePanel.add(lblITel, 10, 254);

		Label lblEvTel = new Label("Ev Tel");
		lblEvTel.setStyleName("gwt-Bold");
		absolutePanel.add(lblEvTel, 10, 221);
		lblEvTel.setSize("38px", "18px");

		Label lblEmail = new Label("E-Mail");
		lblEmail.setStyleName("gwt-Bold");
		absolutePanel.add(lblEmail, 10, 286);

		Label lblFirma = new Label("Firma");
		lblFirma.setStyleName("gwt-Bold");
		absolutePanel.add(lblFirma, 10, 319);

		Label lblSektr = new Label("Sektör");
		lblSektr.setStyleName("gwt-Bold");
		absolutePanel.add(lblSektr, 10, 356);

		Label lblNewLabel = new Label("Ünvanı");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 387);

		Label lblGrevi = new Label("Görevi");
		lblGrevi.setStyleName("gwt-Bold");
		absolutePanel.add(lblGrevi, 10, 429);

		Label lblAdress = new Label("Adres");
		lblAdress.setStyleName("gwt-Bold");
		absolutePanel.add(lblAdress, 10, 467);

		tctVeliBilgileriTcKimlikNo = new TextBox();
		tctVeliBilgileriTcKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVeliBilgileriTcKimlikNo, 129, 77);
		tctVeliBilgileriTcKimlikNo.setSize("143px", "14px");

		tctVeliBilgileriAdi = new TextBox();
		tctVeliBilgileriAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVeliBilgileriAdi, 129, 10);
		tctVeliBilgileriAdi.setSize("143px", "14px");

		tctVeliBilgileriSoyadi = new TextBox();
		tctVeliBilgileriSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVeliBilgileriSoyadi, 129, 46);
		tctVeliBilgileriSoyadi.setSize("143px", "14px");

		tctEvTel = new TextBox();
		tctEvTel.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEvTel, 129, 221);
		tctEvTel.setSize("180px", "14px");

		tctİsTel = new TextBox();
		tctİsTel.setStylePrimaryName("gwt-TextBox1");
		absolutePanel.add(tctİsTel, 129, 254);
		tctİsTel.setSize("180px", "14px");

		tctEmail = new TextBox();
		tctEmail.setStylePrimaryName("gwt-TextBox1");
		absolutePanel.add(tctEmail, 129, 286);
		tctEmail.setSize("180px", "14px");

		tctFirma = new TextBox();
		tctFirma.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctFirma, 129, 319);
		tctFirma.setSize("180px", "14px");

		tctSektor = new TextBox();
		tctSektor.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSektor, 129, 356);
		tctSektor.setSize("180px", "14px");

		tctVeliBilgileriAdres = new TextBox();
		tctVeliBilgileriAdres.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVeliBilgileriAdres, 129, 467);
		tctVeliBilgileriAdres.setSize("180px", "14px");

		tctGorevi = new TextBox();
		tctGorevi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctGorevi, 129, 429);
		tctGorevi.setSize("180px", "14px");

		tctUnvanı = new TextBox();
		tctUnvanı.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctUnvanı, 129, 387);
		tctUnvanı.setSize("180px", "14px");

		tctCepTel = new TextBox();
		tctCepTel.setStylePrimaryName("gwt-TextBox1");
		absolutePanel.add(tctCepTel, 129, 186);
		tctCepTel.setSize("180px", "14px");

		chxOdemeSorumlusu = new SimpleCheckBox();
		absolutePanel.add(chxOdemeSorumlusu, 129, 150);

		cbxYakinlikDurumu = new ListBox();
		cbxYakinlikDurumu.setStyleName("gwt-ComboBox1");
		cbxYakinlikDurumu.addItem("Anne");
		cbxYakinlikDurumu.addItem("Baba");
		cbxYakinlikDurumu.addItem("Diğer");
		absolutePanel.add(cbxYakinlikDurumu, 129, 108);
		cbxYakinlikDurumu.setSize("147px", "22px");

		btnVeliyiKaydet = new Button("New button");
		btnVeliyiKaydet.setStyleName("gwt-ButtonSave");
		btnVeliyiKaydet.addClickHandler(new BtnVeliyiKaydetClickHandler());
		btnVeliyiKaydet.setText("Veliyi Kaydet");
		absolutePanel.add(btnVeliyiKaydet, 358, 506);
		btnVeliyiKaydet.setSize("78px", "55px");

		btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 442, 506);
		btnKapat.setSize("78px", "55px");
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
			URLValue = URLValue + "&is_tel=" + tctİsTel.getText();

			URLValue = URLValue + "&e_mail=" + tctEmail.getText();
			URLValue = URLValue + "&firma=" + tctFirma.getText();
			URLValue = URLValue + "&sektor=" + tctSektor.getText();
			URLValue = URLValue + "&unvani=" + tctUnvanı.getText();
			URLValue = URLValue + "&gorevi=" + tctGorevi.getText();
			URLValue = URLValue + "&veli_bilgileri_adres="
					+ tctVeliBilgileriAdres.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue);
		}

	}
}
