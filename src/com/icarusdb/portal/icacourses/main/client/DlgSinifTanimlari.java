package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgSinifTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private DateBox dtpBitisTarihi;
	private DateBox dtpBaslangicTarihi;
	private TextBox tctOzelDersSayisi;
	private TextBox tctFiyati;
	private TextBox tctBtisiNumarasi;
	private TextBox tctBaslangicNumarasi;
	private TextBox tctSinifKontenjani;
	private ListBox cbxDanismanOgretmen;
	private ListBox cbxAlan;
	private ListBox cbxEgitimTuru;
	private ListBox cbxKursZamani;
	private ListBox cbxFizikselSinifAdi;
	private TextBox tctSinifAdi;

	public DlgSinifTanimlari(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Sınıf İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("704px", "575px");

		Label lblSnfIlemleriekleme = new Label(
				"Sınıf İşlemleri (Ekleme / Düzenleme)");
		lblSnfIlemleriekleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblSnfIlemleriekleme, 0, 0);
		lblSnfIlemleriekleme.setSize("704px", "28px");

		Label lblSnfAd = new Label("Sınıf Adı");
		absolutePanel.add(lblSnfAd, 10, 47);

		Label lblFizikselSnfAd = new Label("Fiziksel Sınıf Adı");
		absolutePanel.add(lblFizikselSnfAd, 10, 84);

		Label lblNewLabel = new Label("Kurs Zamanı");
		absolutePanel.add(lblNewLabel, 10, 122);

		Label lblEitimTr = new Label("Eğitim türü");
		absolutePanel.add(lblEitimTr, 10, 161);

		Label lblAlan = new Label("Alan");
		absolutePanel.add(lblAlan, 10, 201);

		Label lblDanmanretmen = new Label("Danışman Öğretmen");
		absolutePanel.add(lblDanmanretmen, 10, 238);

		Label lblSnfKontenjan = new Label("Sınıf  Kontenjanı");
		absolutePanel.add(lblSnfKontenjan, 10, 274);

		Label lblBalang = new Label("Başlangıç Numarası");
		absolutePanel.add(lblBalang, 10, 309);

		Label lblBitiNumaras = new Label("Bitiş Numarası");
		absolutePanel.add(lblBitiNumaras, 10, 345);

		Label lblzelDersSays = new Label("Özel Ders Sayısı");
		absolutePanel.add(lblzelDersSays, 10, 381);

		Label lblFiyat = new Label("Fiyatı");
		absolutePanel.add(lblFiyat, 10, 410);

		Label lblBalangTarihi = new Label("Başlangıç Tarihi");
		absolutePanel.add(lblBalangTarihi, 10, 443);

		Label lblBitiTarihi = new Label("Bitiş Tarihi");
		absolutePanel.add(lblBitiTarihi, 10, 477);

		dtpBaslangicTarihi = new DateBox();
		dtpBaslangicTarihi.setStyleName("gwt-TextBox1");
		dtpBaslangicTarihi
				.addValueChangeHandler(new DtpBaslangicTarihiValueChangeHandler());
		dtpBaslangicTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		absolutePanel.add(dtpBaslangicTarihi, 186, 443);
		dtpBaslangicTarihi.setSize("143px", "14px");

		dtpBitisTarihi = new DateBox();
		dtpBitisTarihi.setStyleName("gwt-TextBox1");
		dtpBitisTarihi
				.addValueChangeHandler(new DptBitisTarihiValueChangeHandler());
		dtpBitisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		absolutePanel.add(dtpBitisTarihi, 186, 477);
		dtpBitisTarihi.setSize("143px", "14px");

		tctFiyati = new TextBox();
		tctFiyati.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctFiyati, 186, 414);
		tctFiyati.setSize("143px", "14px");

		tctOzelDersSayisi = new TextBox();
		tctOzelDersSayisi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctOzelDersSayisi, 186, 385);
		tctOzelDersSayisi.setSize("143px", "14px");

		tctBtisiNumarasi = new TextBox();
		tctBtisiNumarasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctBtisiNumarasi, 186, 349);
		tctBtisiNumarasi.setSize("143px", "14px");

		tctBaslangicNumarasi = new TextBox();
		tctBaslangicNumarasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctBaslangicNumarasi, 186, 309);
		tctBaslangicNumarasi.setSize("143px", "14px");

		tctSinifKontenjani = new TextBox();
		tctSinifKontenjani.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSinifKontenjani, 186, 278);
		tctSinifKontenjani.setSize("143px", "14px");

		cbxDanismanOgretmen = new ListBox();
		cbxDanismanOgretmen.addItem("İlhami YILDIZ");
		cbxDanismanOgretmen.addItem("Tuba YILDIZ");
		cbxDanismanOgretmen.addItem("Melike AKDAĞ");
		cbxDanismanOgretmen.addItem("Onur MIHÇI");
		cbxDanismanOgretmen.addItem("Alpaslan ÇOLAK");
		cbxDanismanOgretmen.addItem("Hazal Erol");
		cbxDanismanOgretmen.addItem("Mesut ÇALIŞKAN");
		cbxDanismanOgretmen.addItem("Kübra UĞUR");
		cbxDanismanOgretmen.addItem("Mehmet AKİF ÖZER");
		cbxDanismanOgretmen.addItem("Murat AKGÜN");
		cbxDanismanOgretmen.addItem("Mehmet Şahin DEMİR");
		cbxDanismanOgretmen.addItem("Şems HOCA");
		cbxDanismanOgretmen.addItem("Kıymet AKGÜN");
		cbxDanismanOgretmen.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxDanismanOgretmen, 186, 238);
		cbxDanismanOgretmen.setSize("147px", "22px");

		cbxAlan = new ListBox();
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem("1");
		cbxAlan.addItem("2");
		absolutePanel.add(cbxAlan, 186, 197);
		cbxAlan.setSize("147px", "22px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.addItem("a");
		cbxEgitimTuru.addItem("b");
		absolutePanel.add(cbxEgitimTuru, 186, 161);
		cbxEgitimTuru.setSize("147px", "22px");

		cbxKursZamani = new ListBox();
		cbxKursZamani.addItem("HAFTA SONU");
		cbxKursZamani.addItem("HAFTA İÇİ");
		cbxKursZamani.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxKursZamani, 186, 122);
		cbxKursZamani.setSize("147px", "22px");

		cbxFizikselSinifAdi = new ListBox();
		cbxFizikselSinifAdi.addItem("A SINIFI");
		cbxFizikselSinifAdi.addItem("B SINIFI");
		cbxFizikselSinifAdi.addItem("C SINIFI");
		cbxFizikselSinifAdi.addItem("D SINIFI");
		cbxFizikselSinifAdi.addItem("E SINIFI");
		cbxFizikselSinifAdi.addItem("F SINIFI");
		cbxFizikselSinifAdi.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxFizikselSinifAdi, 186, 84);
		cbxFizikselSinifAdi.setSize("147px", "22px");

		tctSinifAdi = new TextBox();
		tctSinifAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSinifAdi, 186, 47);
		tctSinifAdi.setSize("143px", "14px");

		Button btnYeniKayit = new Button("New button");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.setText("Yeni Kayıt");
		absolutePanel.add(btnYeniKayit, 388, 497);
		btnYeniKayit.setSize("78px", "45px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 472, 497);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 556, 497);
		btnKapat.setSize("78px", "45px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putsiniftanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&sinif_adi=" + tctSinifAdi.getText();
			URLValue = URLValue
					+ "&fiziksel_sinif_adi="
					+ cbxFizikselSinifAdi.getValue(cbxFizikselSinifAdi
							.getSelectedIndex());
			URLValue = URLValue + "&kurs_zamani="
					+ cbxKursZamani.getValue(cbxKursZamani.getSelectedIndex());
			URLValue = URLValue + "&egitim_turu="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&alan="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue
					+ "&danisman_ogretmen="
					+ cbxDanismanOgretmen.getValue(cbxDanismanOgretmen
							.getSelectedIndex());
			URLValue = URLValue + "&sinif_kontenjani="
					+ tctSinifKontenjani.getText();
			URLValue = URLValue + "&baslangic_numarasi="
					+ tctBaslangicNumarasi.getText();
			URLValue = URLValue + "&bitis_numarasi="
					+ tctBtisiNumarasi.getText();
			URLValue = URLValue + "&ozel_ders_sayisi="
					+ tctOzelDersSayisi.getText();
			URLValue = URLValue + "&fiyati=" + tctFiyati.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	private class DtpBaslangicTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm");
			// Window.alert(dtf.format(dtpBaslangicTarihi.getValue()));
		}
	}

	private class DptBitisTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm");
			// Window.alert(dtf.format(dtpBitisTarihi.getValue()));
		}
	}

	public void putDataFromXML(XMLSinifTanimlari xml) {
		tctBaslangicNumarasi.setText(xml.baslangic_numarasi);
		tctBtisiNumarasi.setText(xml.bitis_numarasi);
		tctFiyati.setText(xml.fiyati);
		tctOzelDersSayisi.setText(xml.ozel_ders_sayisi);
		tctSinifAdi.setText(xml.sinif_adi);
		tctSinifKontenjani.setText(xml.sinif_kontenjani);

		cbxAlan.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxAlan, xml.alan));
		cbxDanismanOgretmen.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxDanismanOgretmen, xml.danisman_ogretmen));

		cbxEgitimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxEgitimTuru, xml.egitim_turu));
		cbxFizikselSinifAdi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxFizikselSinifAdi, xml.fiziksel_sinif_adi));
		cbxKursZamani.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxKursZamani, xml.kurs_zamani));

	}

}
