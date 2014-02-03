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
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgGelirlerveGiderler extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;
	private DateBox dtpTarih;
	private TextBox tctMiktar;
	private ListBox cbxCek;
	private ListBox cbxBanka;
	private ListBox cbxOdemeTuru;
	private ListBox cbxGelirler;
	private ListBox cbxKategoriler;
	private ListBox cbxİslemTipi;
	private DateBox dtpVadeTarihi;
	private TextArea tctAciklama;
	private SimpleCheckBox chxKayitSilinsinMi;
	private Label lblKayitSilinsinMi;
	private Button btnKaydet;

	public DlgGelirlerveGiderler(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Gelir / Gider İşlemleri ( Ekleme / Düzenleme )");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("632px", "529px");

		Label lblNewLabel = new Label(
				"Gelir / Gider Giriş İşlemleri ( Ekleme / Düzenleme )");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("100%", "28px");

		Label lblIlemTipi = new Label("İşlem Tipi");
		lblIlemTipi.setStyleName("gwt-Bold");
		absolutePanel.add(lblIlemTipi, 10, 46);

		Label lblNewLabel_1 = new Label("Kategoriler");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 10, 84);

		Label lblGelirler = new Label("Gelirler");
		lblGelirler.setStyleName("gwt-Bold");
		absolutePanel.add(lblGelirler, 10, 127);

		Label lbldemeTr = new Label("Ödeme Türü");
		lbldemeTr.setStyleName("gwt-Bold");
		absolutePanel.add(lbldemeTr, 10, 168);

		Label lblBanka = new Label("Banka");
		lblBanka.setStyleName("gwt-Bold");
		absolutePanel.add(lblBanka, 10, 203);

		Label lblekVade = new Label("Çek - Vade Tarihi");
		lblekVade.setStyleName("gwt-Bold");
		absolutePanel.add(lblekVade, 10, 242);

		Label lblMiktar = new Label("Miktar");
		lblMiktar.setStyleName("gwt-Bold");
		absolutePanel.add(lblMiktar, 10, 275);

		Label lblTarijh = new Label("Tarih");
		lblTarijh.setStyleName("gwt-Bold");
		absolutePanel.add(lblTarijh, 10, 312);

		Label lblAklama = new Label("Açıklama");
		lblAklama.setStyleName("gwt-Bold");
		absolutePanel.add(lblAklama, 10, 349);

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 180, 425);
		btnKaydet.setSize("83px", "56px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("");
		absolutePanel.add(btnKapat, 290, 425);
		btnKapat.setSize("83px", "56px");

		cbxİslemTipi = new ListBox();
		cbxİslemTipi.addItem("Gelir");
		cbxİslemTipi.addItem("Gider");
		cbxİslemTipi.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxİslemTipi, 155, 42);
		cbxİslemTipi.setSize("157px", "22px");

		cbxKategoriler = new ListBox();
		cbxKategoriler.addItem(" ");
		cbxKategoriler.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxKategoriler, 155, 80);
		cbxKategoriler.setSize("190px", "22px");

		cbxGelirler = new ListBox();
		cbxGelirler.addItem("İlhami YILDIZ");
		cbxGelirler.addItem("Tuba YILDIZ");
		cbxGelirler.addItem("Melike AKDAĞ");
		cbxGelirler.addItem("Onur MIHÇI");
		cbxGelirler.addItem("Alpaslan ÇOLAK");
		cbxGelirler.addItem("Hazal Erol");
		cbxGelirler.addItem("Mesut ÇALIŞKAN");
		cbxGelirler.addItem("Kübra UĞUR");
		cbxGelirler.addItem("Mehmet AKİF ÖZER");
		cbxGelirler.addItem("Murat AKGÜN");
		cbxGelirler.addItem("Mehmet Şahin DEMİR");
		cbxGelirler.addItem("Şems HOCA");
		cbxGelirler.addItem("Kıymet AKGÜN");
		cbxGelirler.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxGelirler, 155, 123);
		cbxGelirler.setSize("157px", "22px");

		cbxOdemeTuru = new ListBox();
		cbxOdemeTuru.addChangeHandler(new CbxOdemeTuruChangeHandler());
		cbxOdemeTuru.addItem("Senet");
		cbxOdemeTuru.addItem("Kredi Kartı");
		cbxOdemeTuru.addItem("Çek");
		cbxOdemeTuru.addItem("Nakit");
		cbxOdemeTuru.addItem("Havale - EFT");
		cbxOdemeTuru.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxOdemeTuru, 155, 164);
		cbxOdemeTuru.setSize("157px", "22px");

		cbxBanka = new ListBox();
		cbxBanka.setEnabled(false);
		cbxBanka.addItem(" ");
		cbxBanka.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxBanka, 155, 199);
		cbxBanka.setSize("157px", "22px");

		cbxCek = new ListBox();
		cbxCek.setEnabled(false);
		cbxCek.addItem(" ");
		cbxCek.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxCek, 155, 238);
		cbxCek.setSize("278px", "22px");

		dtpVadeTarihi = new DateBox();
		dtpVadeTarihi.setEnabled(false);
		dtpVadeTarihi.setStyleName("gwt-TextBox1");
		dtpVadeTarihi
				.addValueChangeHandler(new DtpVadeTarihiValueChangeHandler());
		dtpVadeTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		absolutePanel.add(dtpVadeTarihi, 447, 238);
		dtpVadeTarihi.setSize("127px", "16px");

		tctMiktar = new TextBox();
		tctMiktar.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctMiktar, 155, 275);
		tctMiktar.setSize("155px", "14px");

		dtpTarih = new DateBox();
		dtpTarih.setStyleName("gwt-TextBox1");
		dtpTarih.addValueChangeHandler(new DtpTarihValueChangeHandler());
		dtpTarih.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd HH:mm:ss")));
		absolutePanel.add(dtpTarih, 155, 308);
		dtpTarih.setSize("155px", "16px");

		tctAciklama = new TextArea();
		tctAciklama.setStyleName("gwt-TextAreaResible");
		absolutePanel.add(tctAciklama, 155, 349);
		tctAciklama.setSize("275px", "50px");

		chxKayitSilinsinMi = new SimpleCheckBox();
		chxKayitSilinsinMi.setVisible(false);
		absolutePanel.add(chxKayitSilinsinMi, 166, 476);

		lblKayitSilinsinMi = new Label("Kayit Silinsin Mi ?");
		lblKayitSilinsinMi.setVisible(false);
		absolutePanel.add(lblKayitSilinsinMi, 10, 476);

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 432, 425);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 514, 425);
		image_1.setSize("72px", "66px");

		if (!isDesignTime()) {

			putKategoriAdiToCbx(cbxKategoriler);
			putBankalarToCbx(cbxBanka);

		}
	}

	private void putBankalarToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("Lütfen Seçiniz");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getbankaekle");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getgelirlervegiderler " +
					// response.getText());

					List<XMLBankaEkle> xmlBankaEkle = XMLBankaEkle.XML
							.readList(response.getText());

					for (int i = 0; i < xmlBankaEkle.size(); i++) {

						lbxTemp.addItem(xmlBankaEkle.get(i).banka_adi);

					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putKategoriAdiToCbx(final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getgelirgiderkategorileri");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getgelirlervegiderler " +
					// response.getText());

					List<XMLGelirGiderKategorileri> xmlGelirGiderKategorileri = XMLGelirGiderKategorileri.XML
							.readList(response.getText());

					for (int i = 0; i < xmlGelirGiderKategorileri.size(); i++) {

						lbxTemp.addItem(xmlGelirGiderKategorileri.get(i).kategori_adi);

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

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase
					+ "putgelirlervegiderler?kayit_silinsin_mi=FALSE";

			URLValue = URLValue + "id=" + _id;

			URLValue = URLValue + "&islem_tipi="
					+ cbxİslemTipi.getValue(cbxİslemTipi.getSelectedIndex());
			URLValue = URLValue
					+ "&kategoriler="
					+ cbxKategoriler.getItemText(cbxKategoriler
							.getSelectedIndex());
			URLValue = URLValue + "&gelirler="
					+ cbxGelirler.getValue(cbxGelirler.getSelectedIndex());
			URLValue = URLValue + "&odeme_turu="
					+ cbxOdemeTuru.getValue(cbxOdemeTuru.getSelectedIndex());
			URLValue = URLValue + "&banka="
					+ cbxBanka.getItemText(cbxBanka.getSelectedIndex());
			URLValue = URLValue + "&cek="
					+ cbxCek.getValue(cbxCek.getSelectedIndex());
			URLValue = URLValue + "&miktar=" + tctMiktar.getText();
			URLValue = URLValue + "&aciklama=" + tctAciklama.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			DateTimeFormat dtf = DateTimeFormat
					.getFormat("yyyy-MM-dd HH:mm:ss");

			URLValue = URLValue + "&tarih=" + dtf.format(dtpTarih.getValue());

			DateTimeFormat dtf2 = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&vade_tarihi="
					+ dtf2.format(dtpVadeTarihi.getValue());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	private class DtpTarihValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat
					.getFormat("yyyy-MM-dd HH:mm:ss");
			// Window.alert(dtf.format(dtpTarih.getValue()));
		}
	}

	private class DtpVadeTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf2 = DateTimeFormat.getFormat("yyyy-MM-dd");
			// Window.alert(dtf.format(dtpVadeTarihi.getValue()));
		}
	}

	public void putDataFromXML(XMLGelirlerveGiderler xml) {
		tctAciklama.setText(xml.aciklama);
		tctMiktar.setText(xml.miktar);
		cbxBanka.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxBanka,
				xml.banka));
		// cbxCek.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxCek,
		// xml.cek));
		cbxCek.setItemText(0, (xml.cek == null) ? "" : xml.cek);
		cbxGelirler.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxGelirler,
				xml.gelirler));
		cbxİslemTipi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxİslemTipi, xml.islem_tipi));
		cbxKategoriler.setItemText(0, xml.kategoriler);
		cbxOdemeTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOdemeTuru, xml.odeme_turu));

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");

		dtpTarih.setValue(dtf.parse(xml.tarih));

		DateTimeFormat dtf2 = DateTimeFormat.getFormat("yyyy-MM-dd");

		dtpVadeTarihi.setValue(dtf2.parse(xml.vade_tarihi));

		if (cbxOdemeTuru.getSelectedIndex() == 3) {
			cbxBanka.setEnabled(false);
			cbxCek.setEnabled(false);
			dtpVadeTarihi.setEnabled(false);

		} else if (cbxOdemeTuru.getSelectedIndex() == 2) {

			cbxBanka.setEnabled(false);
			cbxCek.setEnabled(false);
			dtpVadeTarihi.setEnabled(true);

		} else if (cbxOdemeTuru.getSelectedIndex() == 1) {
			cbxBanka.setEnabled(true);
			cbxCek.setEnabled(false);
			dtpVadeTarihi.setEnabled(false);

		} else if (cbxOdemeTuru.getSelectedIndex() == 0) {
			cbxBanka.setEnabled(false);
			cbxCek.setEnabled(false);
			dtpVadeTarihi.setEnabled(false);

		} else if (cbxOdemeTuru.getSelectedIndex() == 4) {
			cbxBanka.setEnabled(true);
			cbxCek.setEnabled(false);
			dtpVadeTarihi.setEnabled(false);

		}

	}

	private class CbxOdemeTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			if (cbxOdemeTuru.getSelectedIndex() == 3) {
				cbxBanka.setEnabled(false);
				cbxCek.setEnabled(false);
				dtpVadeTarihi.setEnabled(false);

			} else if (cbxOdemeTuru.getSelectedIndex() == 2) {

				cbxBanka.setEnabled(false);
				cbxCek.setEnabled(false);
				dtpVadeTarihi.setEnabled(true);

			} else if (cbxOdemeTuru.getSelectedIndex() == 1) {
				cbxBanka.setEnabled(true);
				cbxCek.setEnabled(false);
				dtpVadeTarihi.setEnabled(false);

			} else if (cbxOdemeTuru.getSelectedIndex() == 0) {
				cbxBanka.setEnabled(false);
				cbxCek.setEnabled(false);
				dtpVadeTarihi.setEnabled(false);

			} else if (cbxOdemeTuru.getSelectedIndex() == 4) {
				cbxBanka.setEnabled(true);
				cbxCek.setEnabled(false);
				dtpVadeTarihi.setEnabled(false);

			}

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
