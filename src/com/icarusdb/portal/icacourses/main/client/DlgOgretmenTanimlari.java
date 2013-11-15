package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgOgretmenTanimlari extends DialogBox {
	private TextBox tctTCKimlikNo;
	private TextBox tctAdiSoyadi;
	private TextBox tctGirdigiDersbilgisi;
	private ListBox cbxEgitimTuru;
	private ListBox cbxBrans;
	private ListBox cbxGirdigiDersler;
	private TextBox tctUcreti;
	private TextBox tctEvTelefonu;
	private TextBox tctCepTelefonu;
	private TextBox tctCepTelefonu2;
	private TextBox tctEmail;
	private TextBox tctSigortaGunSayisi;
	private CheckBox chxdurum;
	private SimpleCheckBox chxDersPrograminiGorsun;
	private SimpleCheckBox chx1;
	private SimpleCheckBox chx2;
	private SimpleCheckBox chx3;
	private SimpleCheckBox chx4;
	private SimpleCheckBox chx5;
	private SimpleCheckBox chx6;
	private SimpleCheckBox chx7;

	public DlgOgretmenTanimlari() {
		setHTML("Öğretmen İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("774px", "534px");

		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		absolutePanel.add(decoratedTabPanel, 0, 32);
		decoratedTabPanel.setSize("774px", "545px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel.add(absolutePanel_1, "Öğretmen Bilgileri", false);
		absolutePanel_1.setSize("694px", "457px");

		Label lblretmenNo = new Label("Öğretmen No");
		lblretmenNo.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblretmenNo, 10, 10);

		Label lblTcKimlikNo = new Label("T.C. Kimlik No");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblTcKimlikNo, 10, 49);

		Label lblAdSoyad = new Label("Adı Soyadı");
		lblAdSoyad.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblAdSoyad, 10, 73);

		Label lblGirdiğiDersBilgisi = new Label("Girdiği Ders Bilgisi");
		lblGirdiğiDersBilgisi.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblGirdiğiDersBilgisi, 10, 97);

		Label lblEitimTr = new Label("Eğitim Türü");
		lblEitimTr.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblEitimTr, 10, 121);

		Label lblBran = new Label("Branş");
		lblBran.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblBran, 10, 145);

		Label lblGirdiiDersler = new Label("Girdiği Dersler");
		lblGirdiiDersler.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblGirdiiDersler, 10, 169);

		Label lblcreti = new Label("Ücreti");
		lblcreti.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblcreti, 10, 193);

		Label lblEvTelefonu = new Label("Ev Telefonu");
		lblEvTelefonu.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblEvTelefonu, 10, 217);

		Label lblCepTelefonu = new Label("Cep Telefonu");
		lblCepTelefonu.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblCepTelefonu, 10, 241);

		Label lblCepTelefonu_1 = new Label("Cep Telefonu 2");
		lblCepTelefonu_1.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblCepTelefonu_1, 10, 265);

		Label lblEmail = new Label("E-mail");
		lblEmail.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblEmail, 10, 289);

		Label lblSigortaGnSays = new Label("Sigorta Gün Sayısı");
		lblSigortaGnSays.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblSigortaGnSays, 10, 313);

		Label lblDersProgmamnGrsun = new Label("Ders progmamını Görsün");
		lblDersProgmamnGrsun.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblDersProgmamnGrsun, 10, 337);

		Label lblDurum = new Label("Durum");
		lblDurum.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblDurum, 10, 367);

		chxdurum = new CheckBox("Aktif / Pasif");
		absolutePanel_1.add(chxdurum, 160, 365);
		chxdurum.setSize("107px", "20px");

		chxDersPrograminiGorsun = new SimpleCheckBox();
		absolutePanel_1.add(chxDersPrograminiGorsun, 160, 337);

		tctSigortaGunSayisi = new TextBox();
		tctSigortaGunSayisi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctSigortaGunSayisi, 160, 313);
		tctSigortaGunSayisi.setSize("143px", "14px");

		tctEmail = new TextBox();
		tctEmail.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctEmail, 160, 289);
		tctEmail.setSize("143px", "14px");

		tctCepTelefonu2 = new TextBox();
		tctCepTelefonu2.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctCepTelefonu2, 160, 265);
		tctCepTelefonu2.setSize("143px", "14px");

		tctCepTelefonu = new TextBox();
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctCepTelefonu, 160, 241);
		tctCepTelefonu.setSize("143px", "14px");

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctEvTelefonu, 160, 217);
		tctEvTelefonu.setSize("143px", "14px");

		tctUcreti = new TextBox();
		tctUcreti.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctUcreti, 160, 193);
		tctUcreti.setSize("143px", "14px");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctTCKimlikNo, 160, 49);
		tctTCKimlikNo.setSize("143px", "14px");

		tctAdiSoyadi = new TextBox();
		tctAdiSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctAdiSoyadi, 160, 73);
		tctAdiSoyadi.setSize("143px", "14px");

		tctGirdigiDersbilgisi = new TextBox();
		tctGirdigiDersbilgisi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctGirdigiDersbilgisi, 160, 97);
		tctGirdigiDersbilgisi.setSize("143px", "14px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.addItem("1");
		cbxEgitimTuru.addItem("2 ");
		absolutePanel_1.add(cbxEgitimTuru, 160, 121);
		cbxEgitimTuru.setSize("151px", "14px");

		cbxBrans = new ListBox();
		cbxBrans.setStyleName("gwt-ComboBox1");
		cbxBrans.addItem("a");
		cbxBrans.addItem("2");
		cbxBrans.addItem("1 ");
		absolutePanel_1.add(cbxBrans, 160, 145);
		cbxBrans.setSize("151px", "14px");

		cbxGirdigiDersler = new ListBox();
		cbxGirdigiDersler.setStyleName("gwt-ComboBox1");
		cbxGirdigiDersler.addItem("1");
		cbxGirdigiDersler.addItem("2");
		cbxGirdigiDersler.addItem("  ");
		absolutePanel_1.add(cbxGirdigiDersler, 160, 165);
		cbxGirdigiDersler.setSize("151px", "14px");

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel.add(absolutePanel_3, "Geldiği Günler", false);
		absolutePanel_3.setSize("713px", "385px");

		Label lblPazartesi = new Label("Pazartesi");
		absolutePanel_3.add(lblPazartesi, 10, 29);

		Label lblSal = new Label("Salı");
		absolutePanel_3.add(lblSal, 10, 53);

		Label lblaramba = new Label("Çarşamba");
		absolutePanel_3.add(lblaramba, 10, 77);

		Label lblPerembe = new Label("Perşembe");
		absolutePanel_3.add(lblPerembe, 10, 101);

		Label lblCuma = new Label("Cuma");
		absolutePanel_3.add(lblCuma, 10, 125);

		Label lblCumartesi = new Label("Cumartesi");
		absolutePanel_3.add(lblCumartesi, 10, 149);

		Label lblPazar = new Label("Pazar");
		absolutePanel_3.add(lblPazar, 10, 173);

		chx2 = new SimpleCheckBox();
		absolutePanel_3.add(chx2, 114, 53);
		chx2.setSize("20px", "19px");

		chx3 = new SimpleCheckBox();
		absolutePanel_3.add(chx3, 114, 76);
		chx3.setSize("20px", "19px");

		chx4 = new SimpleCheckBox();
		absolutePanel_3.add(chx4, 114, 100);
		chx4.setSize("20px", "19px");

		chx5 = new SimpleCheckBox();
		absolutePanel_3.add(chx5, 114, 124);
		chx5.setSize("20px", "19px");

		chx6 = new SimpleCheckBox();
		absolutePanel_3.add(chx6, 114, 148);
		chx6.setSize("20px", "19px");

		chx7 = new SimpleCheckBox();
		absolutePanel_3.add(chx7, 114, 173);
		chx7.setSize("20px", "19px");

		chx1 = new SimpleCheckBox();
		absolutePanel_3.add(chx1, 114, 29);
		chx1.setSize("20px", "19px");

		Label lblNewLabel = new Label("Öğretmen İşlemleri (Ekleme / Düzenleme)");
		absolutePanel.add(lblNewLabel, 10, 10);
		lblNewLabel.setSize("448px", "18px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel.add(absolutePanel_2, 399, -33);
		absolutePanel_2.setSize("258px", "567px");

		Button btnYenikayit = new Button("New button");
		btnYenikayit.setStyleName("gwt-ButonYeniKayit");
		btnYenikayit.setText("Yeni Kayıt");
		absolutePanel_2.add(btnYenikayit, 10, 500);
		btnYenikayit.setSize("74px", "47px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel_2.add(btnKaydet, 90, 500);
		btnKaydet.setSize("78px", "47px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel_2.add(btnKapat, 174, 500);
		btnKapat.setSize("78px", "47px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putogretmentanimlari?";
			URLValue = URLValue + "tc_kimlik_no=" + tctTCKimlikNo.getText();
			URLValue = URLValue + "&adi_soyadi=" + tctAdiSoyadi.getText();
			URLValue = URLValue + "&girdigi_ders_bilgisi="
					+ tctGirdigiDersbilgisi.getText();

			URLValue = URLValue + "&egitim_turu="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&brans="
					+ cbxBrans.getValue(cbxBrans.getSelectedIndex());
			URLValue = URLValue
					+ "&girdigi_dersler="
					+ cbxGirdigiDersler.getValue(cbxGirdigiDersler
							.getSelectedIndex());

			URLValue = URLValue + "&ucreti=" + tctUcreti.getText();
			URLValue = URLValue + "&ev_telefonu=" + tctEvTelefonu.getText();
			URLValue = URLValue + "&cep_telefonu=" + tctCepTelefonu.getText();
			URLValue = URLValue + "&cep_telefonu_2="
					+ tctCepTelefonu2.getText();
			URLValue = URLValue + "&email=" + tctEmail.getText();
			URLValue = URLValue + "&sigorta_gun_sayisi="
					+ tctSigortaGunSayisi.getText();
			URLValue = URLValue + "&ders_programini_gorsun="
					+ chxDersPrograminiGorsun.getValue().toString();
			URLValue = URLValue + "&durum=" + chxdurum.getValue().toString();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue);
		}
	}

	public void putDataFromXML(XMLOgretmenTanimlari xml) {
		tctAdiSoyadi.setText(xml.adi_soyadi);
		tctCepTelefonu.setText(xml.cep_telefonu);
		tctCepTelefonu2.setText(xml.cep_telefonu_2);
		tctEmail.setText(xml.email);
		tctEvTelefonu.setText(xml.ev_telefonu);
		tctGirdigiDersbilgisi.setText(xml.girdigi_ders_bilgisi);
		tctTCKimlikNo.setText(xml.tc_kimlik_no);
		tctUcreti.setText(xml.ucreti);
		cbxBrans.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxBrans,
				xml.brans));
		cbxEgitimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxEgitimTuru, xml.egitim_turu));
		cbxGirdigiDersler.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGirdigiDersler, xml.girdigi_dersler));

	}
}
