package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
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
	private Button btnKaydet;

	public DlgSinifTanimlari(boolean isInsert, long id) {
		setAnimationEnabled(true);
		setGlassEnabled(true);

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
		lblSnfAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblSnfAd, 10, 47);

		Label lblFizikselSnfAd = new Label("Fiziksel Sınıf Adı");
		lblFizikselSnfAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblFizikselSnfAd, 10, 84);
		lblFizikselSnfAd.setSize("145px", "16px");

		Label lblNewLabel = new Label("Kurs Zamanı");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 122);
		lblNewLabel.setSize("90px", "16px");

		Label lblEitimTr = new Label("Eğitim türü");
		lblEitimTr.setStyleName("gwt-Bold");
		absolutePanel.add(lblEitimTr, 10, 161);
		lblEitimTr.setSize("90px", "16px");

		Label lblAlan = new Label("Alan");
		lblAlan.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlan, 10, 201);

		Label lblDanmanretmen = new Label("Danışman Öğretmen");
		lblDanmanretmen.setStyleName("gwt-Bold");
		absolutePanel.add(lblDanmanretmen, 10, 238);
		lblDanmanretmen.setSize("145px", "16px");

		Label lblSnfKontenjan = new Label("Sınıf  Kontenjanı");
		lblSnfKontenjan.setStyleName("gwt-Bold");
		absolutePanel.add(lblSnfKontenjan, 10, 274);
		lblSnfKontenjan.setSize("126px", "16px");

		Label lblBalang = new Label("Başlangıç Numarası");
		lblBalang.setStyleName("gwt-Bold");
		absolutePanel.add(lblBalang, 10, 309);
		lblBalang.setSize("156px", "16px");

		Label lblBitiNumaras = new Label("Bitiş Numarası");
		lblBitiNumaras.setStyleName("gwt-Bold");
		absolutePanel.add(lblBitiNumaras, 10, 345);
		lblBitiNumaras.setSize("156px", "16px");

		Label lblzelDersSays = new Label("Özel Ders Sayısı");
		lblzelDersSays.setStyleName("gwt-Bold");
		absolutePanel.add(lblzelDersSays, 10, 381);
		lblzelDersSays.setSize("126px", "16px");

		Label lblFiyat = new Label("Fiyatı");
		lblFiyat.setStyleName("gwt-Bold");
		absolutePanel.add(lblFiyat, 10, 412);

		Label lblBalangTarihi = new Label("Başlangıç Tarihi");
		lblBalangTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblBalangTarihi, 10, 443);
		lblBalangTarihi.setSize("126px", "16px");

		Label lblBitiTarihi = new Label("Bitiş Tarihi");
		lblBitiTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblBitiTarihi, 10, 477);
		lblBitiTarihi.setSize("90px", "16px");

		dtpBaslangicTarihi = new DateBox();
		dtpBaslangicTarihi.setStyleName("gwt-TextBox1");
		dtpBaslangicTarihi
				.addValueChangeHandler(new DtpBaslangicTarihiValueChangeHandler());
		dtpBaslangicTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		absolutePanel.add(dtpBaslangicTarihi, 186, 439);
		dtpBaslangicTarihi.setSize("143px", "16px");

		dtpBitisTarihi = new DateBox();
		dtpBitisTarihi.setStyleName("gwt-TextBox1");
		dtpBitisTarihi
				.addValueChangeHandler(new DptBitisTarihiValueChangeHandler());
		dtpBitisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		absolutePanel.add(dtpBitisTarihi, 186, 473);
		dtpBitisTarihi.setSize("143px", "16px");

		tctFiyati = new TextBox();
		tctFiyati.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctFiyati, 186, 408);
		tctFiyati.setSize("143px", "16px");

		tctOzelDersSayisi = new TextBox();
		tctOzelDersSayisi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctOzelDersSayisi, 186, 377);
		tctOzelDersSayisi.setSize("143px", "16px");

		tctBtisiNumarasi = new TextBox();
		tctBtisiNumarasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctBtisiNumarasi, 186, 341);
		tctBtisiNumarasi.setSize("143px", "16px");

		tctBaslangicNumarasi = new TextBox();
		tctBaslangicNumarasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctBaslangicNumarasi, 186, 305);
		tctBaslangicNumarasi.setSize("143px", "16px");

		tctSinifKontenjani = new TextBox();
		tctSinifKontenjani.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSinifKontenjani, 186, 270);
		tctSinifKontenjani.setSize("143px", "16px");

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
		cbxAlan.addItem(" ");
		cbxAlan.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxAlan, 186, 197);
		cbxAlan.setSize("147px", "22px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxEgitimTuru, 186, 161);
		cbxEgitimTuru.setSize("147px", "22px");

		cbxKursZamani = new ListBox();
		cbxKursZamani.addItem(" ");
		cbxKursZamani.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxKursZamani, 186, 122);
		cbxKursZamani.setSize("147px", "22px");

		cbxFizikselSinifAdi = new ListBox();
		cbxFizikselSinifAdi.addItem(" ");
		cbxFizikselSinifAdi.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxFizikselSinifAdi, 186, 84);
		cbxFizikselSinifAdi.setSize("147px", "22px");

		tctSinifAdi = new TextBox();
		tctSinifAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSinifAdi, 186, 47);
		tctSinifAdi.setSize("143px", "16px");

		Button btnYeniKayit = new Button("New button");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.setText("Yeni Kayıt");
		absolutePanel.add(btnYeniKayit, 388, 497);
		btnYeniKayit.setSize("78px", "68px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 485, 414);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 569, 414);
		btnKapat.setSize("78px", "45px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 480, 497);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 569, 497);
		image_1.setSize("72px", "66px");

		if (!isDesignTime()) {

			putFizikselSinifAdiToCbx(cbxFizikselSinifAdi);

			putKursZamaniToCbx(cbxKursZamani);

			putEgitimTuruToCbx(cbxEgitimTuru);
		}

	}

	private void putFizikselSinifAdiToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getfizikselsiniftanimlari");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getdbssinavtanimla " + response.getText());

					List<XMLFizikselSinifTanimlari> xmlFizikselSinifTanimlari = XMLFizikselSinifTanimlari.XML
							.readList(response.getText());

					for (int i = 0; i < xmlFizikselSinifTanimlari.size(); i++) {

						lbxTemp.addItem(xmlFizikselSinifTanimlari.get(i).fiziksel_sinif_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putKursZamaniToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getkurszamanitanimlama");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLKursZamaniTanimlama> xmlKursZamaniTanimlama = XMLKursZamaniTanimlama.XML
							.readList(response.getText());

					for (int i = 0; i < xmlKursZamaniTanimlama.size(); i++) {

						lbxTemp.addItem(xmlKursZamaniTanimlama.get(i).kurs_zamani);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private boolean isDesignTime() {

		return false;
	}

	private void putEgitimTuruToCbx(final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturu");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLEgitimTuru> xmlEgitimTuru = XMLEgitimTuru.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuru.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuru.get(i).egitim_turu_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putEgitimTuruAlanToCbx(String egitim_turu_adi,
			final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturutanimlama?egitim_turu_adi="
						+ egitim_turu_adi);
		// Window.alert("egitim_turu_adi=" + egitim_turu_adi);
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLEgitimTuruTanimlama> xmlEgitimTuruTanimlama = XMLEgitimTuruTanimlama.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuruTanimlama.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuruTanimlama.get(i).alan_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

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
					+ cbxFizikselSinifAdi.getItemText(cbxFizikselSinifAdi
							.getSelectedIndex());
			URLValue = URLValue
					+ "&kurs_zamani="
					+ cbxKursZamani.getItemText(cbxKursZamani
							.getSelectedIndex());
			URLValue = URLValue
					+ "&egitim_turu="
					+ cbxEgitimTuru.getItemText(cbxEgitimTuru
							.getSelectedIndex());
			URLValue = URLValue + "&alan="
					+ cbxAlan.getItemText(cbxAlan.getSelectedIndex());
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

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&baslangic_tarihi="
					+ dtf.format(dtpBaslangicTarihi.getValue());

			URLValue = URLValue + "&bitis_tarihi="
					+ dtf.format(dtpBitisTarihi.getValue());

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

		cbxDanismanOgretmen.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxDanismanOgretmen, xml.dan_ogretmen));

		cbxFizikselSinifAdi.setItemText(0, xml.fiziksel_sinif_adi);
		cbxKursZamani.setItemText(0, xml.kurs_zamani);
		cbxEgitimTuru.setItemText(0, xml.egitim_turu);
		cbxAlan.setItemText(0, xml.alan);

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

		dtpBaslangicTarihi.setValue(dtf.parse(xml.baslangic_tarihi));
		dtpBitisTarihi.setValue(dtf.parse(xml.bitis_tarihi));

	}

	private class CbxEgitimTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxGorusmeEgitimTuru.getSelectedIndex() + "");
			putEgitimTuruAlanToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxAlan);
		}
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
}
