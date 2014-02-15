package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
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
import com.google.gwt.user.client.ui.FlexTable;
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
	private Image image;
	private Image image_1;

	public DlgSinifTanimlari(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Sınıf İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("609px", "473px");

		Button btnYeniKayit = new Button("New button");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.setText("");
		absolutePanel.add(btnYeniKayit, 356, 341);
		btnYeniKayit.setSize("87px", "66px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 404, 236);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 488, 236);
		btnKapat.setSize("78px", "45px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 449, 341);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 527, 341);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("100px", "100px");

		Label lblSnfAd = new Label("Sınıf Adı");
		flexTable.setWidget(0, 0, lblSnfAd);
		lblSnfAd.setStyleName("gwt-Bold");

		tctSinifAdi = new TextBox();
		tctSinifAdi.setMaxLength(40);
		flexTable.setWidget(0, 1, tctSinifAdi);
		tctSinifAdi.setStyleName("gwt-TextBox1");
		tctSinifAdi.setSize("215px", "16px");

		Label lblFizikselSnfAd = new Label("Fiziksel Sınıf Adı");
		flexTable.setWidget(1, 0, lblFizikselSnfAd);
		lblFizikselSnfAd.setStyleName("gwt-Bold");
		lblFizikselSnfAd.setSize("145px", "16px");

		cbxFizikselSinifAdi = new ListBox();
		flexTable.setWidget(1, 1, cbxFizikselSinifAdi);
		cbxFizikselSinifAdi.addItem(" ");
		cbxFizikselSinifAdi.setStyleName("gwt-ComboBox1");
		cbxFizikselSinifAdi.setSize("147px", "22px");

		Label lblNewLabel = new Label("Kurs Zamanı");
		flexTable.setWidget(2, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");
		lblNewLabel.setSize("90px", "16px");

		cbxKursZamani = new ListBox();
		flexTable.setWidget(2, 1, cbxKursZamani);
		cbxKursZamani.addItem(" ");
		cbxKursZamani.setStyleName("gwt-ComboBox1");
		cbxKursZamani.setSize("147px", "22px");

		Label lblEitimTr = new Label("Eğitim türü");
		flexTable.setWidget(3, 0, lblEitimTr);
		lblEitimTr.setStyleName("gwt-Bold");
		lblEitimTr.setSize("90px", "16px");

		cbxEgitimTuru = new ListBox();
		flexTable.setWidget(3, 1, cbxEgitimTuru);
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.setSize("147px", "22px");

		Label lblAlan = new Label("Alan");
		flexTable.setWidget(4, 0, lblAlan);
		lblAlan.setStyleName("gwt-Bold");

		cbxAlan = new ListBox();
		flexTable.setWidget(4, 1, cbxAlan);
		cbxAlan.addItem(" ");
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.setSize("147px", "22px");

		Label lblDanmanretmen = new Label("Danışman Öğretmen");
		flexTable.setWidget(5, 0, lblDanmanretmen);
		lblDanmanretmen.setStyleName("gwt-Bold");
		lblDanmanretmen.setSize("145px", "16px");

		cbxDanismanOgretmen = new ListBox();
		flexTable.setWidget(5, 1, cbxDanismanOgretmen);
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
		cbxDanismanOgretmen.setSize("147px", "22px");

		Label lblSnfKontenjan = new Label("Sınıf  Kontenjanı");
		flexTable.setWidget(6, 0, lblSnfKontenjan);
		lblSnfKontenjan.setStyleName("gwt-Bold");
		lblSnfKontenjan.setSize("126px", "16px");

		tctSinifKontenjani = new TextBox();
		tctSinifKontenjani
				.addKeyPressHandler(new TctSinifKontenjaniKeyPressHandler());
		flexTable.setWidget(6, 1, tctSinifKontenjani);
		tctSinifKontenjani.setStyleName("gwt-TextBox1");
		tctSinifKontenjani.setSize("143px", "16px");

		Label lblBalang = new Label("Başlangıç Numarası");
		flexTable.setWidget(7, 0, lblBalang);
		lblBalang.setStyleName("gwt-Bold");
		lblBalang.setSize("156px", "16px");

		tctBaslangicNumarasi = new TextBox();
		tctBaslangicNumarasi
				.addKeyPressHandler(new TctBaslangicNumarasiKeyPressHandler());
		flexTable.setWidget(7, 1, tctBaslangicNumarasi);
		tctBaslangicNumarasi.setStyleName("gwt-TextBox1");
		tctBaslangicNumarasi.setSize("143px", "16px");

		Label lblBitiNumaras = new Label("Bitiş Numarası");
		flexTable.setWidget(8, 0, lblBitiNumaras);
		lblBitiNumaras.setStyleName("gwt-Bold");
		lblBitiNumaras.setSize("156px", "16px");

		tctBtisiNumarasi = new TextBox();
		tctBtisiNumarasi
				.addKeyPressHandler(new TctBtisiNumarasiKeyPressHandler());
		flexTable.setWidget(8, 1, tctBtisiNumarasi);
		tctBtisiNumarasi.setStyleName("gwt-TextBox1");
		tctBtisiNumarasi.setSize("143px", "16px");

		Label lblzelDersSays = new Label("Özel Ders Sayısı");
		flexTable.setWidget(9, 0, lblzelDersSays);
		lblzelDersSays.setStyleName("gwt-Bold");
		lblzelDersSays.setSize("126px", "16px");

		tctOzelDersSayisi = new TextBox();
		tctOzelDersSayisi
				.addKeyPressHandler(new TctOzelDersSayisiKeyPressHandler());
		flexTable.setWidget(9, 1, tctOzelDersSayisi);
		tctOzelDersSayisi.setStyleName("gwt-TextBox1");
		tctOzelDersSayisi.setSize("143px", "16px");

		Label lblFiyat = new Label("Fiyatı");
		flexTable.setWidget(10, 0, lblFiyat);
		lblFiyat.setStyleName("gwt-Bold");

		tctFiyati = new TextBox();
		tctFiyati.addKeyPressHandler(new TctFiyatiKeyPressHandler());
		flexTable.setWidget(10, 1, tctFiyati);
		tctFiyati.setStyleName("gwt-TextBox1");
		tctFiyati.setSize("143px", "16px");

		Label lblBalangTarihi = new Label("Başlangıç Tarihi");
		flexTable.setWidget(11, 0, lblBalangTarihi);
		lblBalangTarihi.setStyleName("gwt-Bold");
		lblBalangTarihi.setSize("126px", "16px");

		dtpBaslangicTarihi = new DateBox();
		flexTable.setWidget(11, 1, dtpBaslangicTarihi);
		dtpBaslangicTarihi.setStyleName("gwt-TextBox1");
		dtpBaslangicTarihi
				.addValueChangeHandler(new DtpBaslangicTarihiValueChangeHandler());
		dtpBaslangicTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpBaslangicTarihi.setSize("143px", "16px");

		Label lblBitiTarihi = new Label("Bitiş Tarihi");
		flexTable.setWidget(12, 0, lblBitiTarihi);
		lblBitiTarihi.setStyleName("gwt-Bold");
		lblBitiTarihi.setSize("90px", "16px");

		dtpBitisTarihi = new DateBox();
		flexTable.setWidget(12, 1, dtpBitisTarihi);
		dtpBitisTarihi.setStyleName("gwt-TextBox1");
		dtpBitisTarihi
				.addValueChangeHandler(new DptBitisTarihiValueChangeHandler());
		dtpBitisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpBitisTarihi.setSize("143px", "16px");

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

			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

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

	private class TctBtisiNumarasiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctBtisiNumarasi.getText();
			if (!input.matches("[0-9]*")) {
				tctBtisiNumarasi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctBtisiNumarasi.setStyleName("gwt-TextBox1");

		}
	}

	private class TctBaslangicNumarasiKeyPressHandler implements
			KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctBaslangicNumarasi.getText();
			if (!input.matches("[0-9]*")) {
				tctBaslangicNumarasi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctBaslangicNumarasi.setStyleName("gwt-TextBox1");

		}
	}

	private class TctOzelDersSayisiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctOzelDersSayisi.getText();
			if (!input.matches("[0-9]*")) {
				tctOzelDersSayisi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctOzelDersSayisi.setStyleName("gwt-TextBox1");

		}
	}

	private class TctSinifKontenjaniKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctSinifKontenjani.getText();
			if (!input.matches("[0-9]*")) {
				tctSinifKontenjani.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctSinifKontenjani.setStyleName("gwt-TextBox1");

		}
	}

	private class TctFiyatiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctFiyati.getText();
			if (!input.matches("[0-9]*")) {
				tctFiyati.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctFiyati.setStyleName("gwt-TextBox1");

		}
	}
}
