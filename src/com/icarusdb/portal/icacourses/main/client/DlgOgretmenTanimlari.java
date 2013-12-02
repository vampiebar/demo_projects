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
import com.google.gwt.user.client.ui.VerticalPanel;

public class DlgOgretmenTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

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
	public DecoratedTabPanel tabOgretmenIslemleri;

	public DlgOgretmenTanimlari(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Öğretmen İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("700px", "524px");

		tabOgretmenIslemleri = new DecoratedTabPanel();
		absolutePanel.add(tabOgretmenIslemleri, 0, 32);
		tabOgretmenIslemleri.setSize("747px", "502px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabOgretmenIslemleri.add(absolutePanel_1, "Öğretmen Bilgileri", false);
		absolutePanel_1.setSize("694px", "457px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel_1.add(verticalPanel, 10, 10);
		verticalPanel.setSize("201px", "447px");

		Label lblretmenNo = new Label("Öğretmen No");
		verticalPanel.add(lblretmenNo);
		verticalPanel.setCellHeight(lblretmenNo, "26");
		lblretmenNo.setStyleName("gwt-Bold");

		Label lblTcKimlikNo = new Label("T.C. Kimlik No");
		verticalPanel.add(lblTcKimlikNo);
		lblTcKimlikNo.setStyleName("gwt-Bold");

		Label lblAdSoyad = new Label("Adı Soyadı");
		verticalPanel.add(lblAdSoyad);
		lblAdSoyad.setStyleName("gwt-Bold");
		lblAdSoyad.setSize("176px", "18px");

		Label lblGirdiğiDersBilgisi = new Label("Girdiği Ders Bilgisi");
		verticalPanel.add(lblGirdiğiDersBilgisi);
		lblGirdiğiDersBilgisi.setStyleName("gwt-Bold");

		Label lblEitimTr = new Label("Eğitim Türü");
		verticalPanel.add(lblEitimTr);
		verticalPanel.setCellHeight(lblEitimTr, "30");
		lblEitimTr.setHeight("21px");
		lblEitimTr.setStyleName("gwt-Bold");

		Label lblBran = new Label("Branş");
		verticalPanel.add(lblBran);
		verticalPanel.setCellHeight(lblBran, "27");
		lblBran.setHeight("20px");
		lblBran.setStyleName("gwt-Bold");

		Label lblGirdiiDersler = new Label("Girdiği Dersler");
		verticalPanel.add(lblGirdiiDersler);
		verticalPanel.setCellHeight(lblGirdiiDersler, "30");
		lblGirdiiDersler.setHeight("21px");
		lblGirdiiDersler.setStyleName("gwt-Bold");

		Label lblcreti = new Label("Ücreti");
		verticalPanel.add(lblcreti);
		lblcreti.setStyleName("gwt-Bold");

		Label lblEvTelefonu = new Label("Ev Telefonu");
		verticalPanel.add(lblEvTelefonu);
		lblEvTelefonu.setStyleName("gwt-Bold");

		Label lblCepTelefonu = new Label("Cep Telefonu");
		verticalPanel.add(lblCepTelefonu);
		lblCepTelefonu.setStyleName("gwt-Bold");

		Label lblCepTelefonu_1 = new Label("Cep Telefonu 2");
		verticalPanel.add(lblCepTelefonu_1);
		lblCepTelefonu_1.setStyleName("gwt-Bold");

		Label lblEmail = new Label("E-mail");
		verticalPanel.add(lblEmail);
		lblEmail.setStyleName("gwt-Bold");

		Label lblSigortaGnSays = new Label("Sigorta Gün Sayısı");
		verticalPanel.add(lblSigortaGnSays);
		lblSigortaGnSays.setStyleName("gwt-Bold");

		Label lblDersProgmamnGrsun = new Label("Ders Progmamını Görsün");
		verticalPanel.add(lblDersProgmamnGrsun);
		lblDersProgmamnGrsun.setWidth("159px");
		lblDersProgmamnGrsun.setStyleName("gwt-Bold");

		Label lblDurum = new Label("Durum");
		verticalPanel.add(lblDurum);
		lblDurum.setStyleName("gwt-Bold");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		absolutePanel_1.add(verticalPanel_1, 217, 10);
		verticalPanel_1.setSize("165px", "440px");

		Label lblVerilmedi = new Label("Verilmedi");
		lblVerilmedi.setStyleName("gwt-Bold");
		verticalPanel_1.add(lblVerilmedi);

		tctTCKimlikNo = new TextBox();
		verticalPanel_1.add(tctTCKimlikNo);
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		tctTCKimlikNo.setSize("143px", "14px");

		tctAdiSoyadi = new TextBox();
		verticalPanel_1.add(tctAdiSoyadi);
		tctAdiSoyadi.setStyleName("gwt-TextBox1");
		tctAdiSoyadi.setSize("143px", "14px");

		tctGirdigiDersbilgisi = new TextBox();
		verticalPanel_1.add(tctGirdigiDersbilgisi);
		tctGirdigiDersbilgisi.setStyleName("gwt-TextBox1");
		tctGirdigiDersbilgisi.setSize("143px", "14px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addItem("YGS HAZIRLIK");
		cbxEgitimTuru.addItem("YGS/LYS HAZIRLIK");
		cbxEgitimTuru.addItem("11.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("10.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("9.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("SBS HAZIRLIK");
		cbxEgitimTuru.addItem("8.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("7.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("6.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("5.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("4.SINIF TAKVİYE");
		verticalPanel_1.add(cbxEgitimTuru);
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.setSize("143px", "20px");

		cbxBrans = new ListBox();
		verticalPanel_1.add(cbxBrans);
		cbxBrans.setStyleName("gwt-ComboBox1");
		cbxBrans.addItem("a");
		cbxBrans.addItem("2");
		cbxBrans.addItem("1 ");
		cbxBrans.setSize("143px", "20px");

		cbxGirdigiDersler = new ListBox();
		verticalPanel_1.add(cbxGirdigiDersler);
		cbxGirdigiDersler.setStyleName("gwt-ComboBox1");
		cbxGirdigiDersler.addItem("1");
		cbxGirdigiDersler.addItem("2");
		cbxGirdigiDersler.addItem("  ");
		cbxGirdigiDersler.setSize("143px", "20px");

		tctUcreti = new TextBox();
		verticalPanel_1.add(tctUcreti);
		tctUcreti.setStyleName("gwt-TextBox1");
		tctUcreti.setSize("143px", "14px");

		tctEvTelefonu = new TextBox();
		verticalPanel_1.add(tctEvTelefonu);
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		tctEvTelefonu.setSize("143px", "14px");

		tctCepTelefonu = new TextBox();
		verticalPanel_1.add(tctCepTelefonu);
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		tctCepTelefonu.setSize("143px", "14px");

		tctCepTelefonu2 = new TextBox();
		verticalPanel_1.add(tctCepTelefonu2);
		tctCepTelefonu2.setStyleName("gwt-TextBox1");
		tctCepTelefonu2.setSize("143px", "14px");

		tctEmail = new TextBox();
		verticalPanel_1.add(tctEmail);
		tctEmail.setStyleName("gwt-TextBox1");
		tctEmail.setSize("143px", "14px");

		tctSigortaGunSayisi = new TextBox();
		verticalPanel_1.add(tctSigortaGunSayisi);
		tctSigortaGunSayisi.setStyleName("gwt-TextBox1");
		tctSigortaGunSayisi.setSize("143px", "14px");

		chxDersPrograminiGorsun = new SimpleCheckBox();
		verticalPanel_1.add(chxDersPrograminiGorsun);

		chxdurum = new CheckBox("Aktif / Pasif");
		verticalPanel_1.add(chxdurum);
		chxdurum.setSize("107px", "20px");

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		tabOgretmenIslemleri.add(absolutePanel_3, "Geldiği Günler", false);
		absolutePanel_3.setSize("713px", "385px");

		Label lblPazartesi = new Label("Pazartesi");
		lblPazartesi.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblPazartesi, 10, 29);

		Label lblSal = new Label("Salı");
		lblSal.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblSal, 10, 53);

		Label lblaramba = new Label("Çarşamba");
		lblaramba.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblaramba, 10, 77);

		Label lblPerembe = new Label("Perşembe");
		lblPerembe.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblPerembe, 10, 101);

		Label lblCuma = new Label("Cuma");
		lblCuma.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblCuma, 10, 125);

		Label lblCumartesi = new Label("Cumartesi");
		lblCumartesi.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblCumartesi, 10, 149);

		Label lblPazar = new Label("Pazar");
		lblPazar.setStyleName("gwt-Bold");
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
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("100%", "28px");

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

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&tc_kimlik_no=" + tctTCKimlikNo.getText();
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

			new Util().sendRequest(URLValue, "", "");
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
		tctSigortaGunSayisi.setText(xml.sigorta_gun_sayisi);

		cbxBrans.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxBrans,
				xml.brans));
		cbxEgitimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxEgitimTuru, xml.egitim_turu));
		cbxGirdigiDersler.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGirdigiDersler, xml.girdigi_dersler));

	}
}
