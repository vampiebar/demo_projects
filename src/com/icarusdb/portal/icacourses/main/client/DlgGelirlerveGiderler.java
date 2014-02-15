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
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
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
	private Button btnKaydet;
	private Image image_1;
	private Image image;

	public DlgGelirlerveGiderler(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Gelir / Gider İşlemleri ( Ekleme / Düzenleme )");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("632px", "467px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 183, 387);
		btnKaydet.setSize("83px", "56px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("");
		absolutePanel.add(btnKapat, 272, 387);
		btnKapat.setSize("83px", "56px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 444, 333);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 521, 333);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("576px", "292px");

		Label lblIlemTipi = new Label("İşlem Tipi");
		flexTable.setWidget(0, 0, lblIlemTipi);
		lblIlemTipi.setStyleName("gwt-Bold");

		cbxİslemTipi = new ListBox();
		flexTable.setWidget(0, 1, cbxİslemTipi);
		cbxİslemTipi.addItem("Gelir");
		cbxİslemTipi.addItem("Gider");
		cbxİslemTipi.setStyleName("gwt-ComboBox1");
		cbxİslemTipi.setSize("157px", "22px");

		Label lblNewLabel_1 = new Label("Kategoriler");
		flexTable.setWidget(1, 0, lblNewLabel_1);
		lblNewLabel_1.setStyleName("gwt-Bold");

		cbxKategoriler = new ListBox();
		flexTable.setWidget(1, 1, cbxKategoriler);
		cbxKategoriler.addItem(" ");
		cbxKategoriler.setStyleName("gwt-ComboBox1");
		cbxKategoriler.setSize("190px", "22px");

		Label lblGelirler = new Label("Gelirler");
		flexTable.setWidget(2, 0, lblGelirler);
		lblGelirler.setStyleName("gwt-Bold");

		cbxGelirler = new ListBox();
		flexTable.setWidget(2, 1, cbxGelirler);
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
		cbxGelirler.setSize("157px", "22px");

		Label lbldemeTr = new Label("Ödeme Türü");
		flexTable.setWidget(3, 0, lbldemeTr);
		lbldemeTr.setStyleName("gwt-Bold");

		cbxOdemeTuru = new ListBox();
		flexTable.setWidget(3, 1, cbxOdemeTuru);
		cbxOdemeTuru.addChangeHandler(new CbxOdemeTuruChangeHandler());
		cbxOdemeTuru.addItem("Senet");
		cbxOdemeTuru.addItem("Kredi Kartı");
		cbxOdemeTuru.addItem("Çek");
		cbxOdemeTuru.addItem("Nakit");
		cbxOdemeTuru.addItem("Havale - EFT");
		cbxOdemeTuru.setStyleName("gwt-ComboBox1");
		cbxOdemeTuru.setSize("157px", "22px");

		Label lblBanka = new Label("Banka");
		flexTable.setWidget(4, 0, lblBanka);
		lblBanka.setStyleName("gwt-Bold");

		cbxBanka = new ListBox();
		flexTable.setWidget(4, 1, cbxBanka);
		cbxBanka.setEnabled(false);
		cbxBanka.addItem(" ");
		cbxBanka.setStyleName("gwt-ComboBox1");
		cbxBanka.setSize("157px", "22px");

		Label lblekVade = new Label("Çek - Vade Tarihi");
		flexTable.setWidget(5, 0, lblekVade);
		lblekVade.setStyleName("gwt-Bold");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flexTable.setWidget(5, 1, horizontalPanel);
		horizontalPanel.setSize("100%", "20px");

		cbxCek = new ListBox();
		cbxCek.setVisible(false);

		dtpVadeTarihi = new DateBox();
		horizontalPanel.add(dtpVadeTarihi);
		horizontalPanel.setCellWidth(dtpVadeTarihi, "160px");
		dtpVadeTarihi.setEnabled(false);
		dtpVadeTarihi.setStyleName("gwt-TextBox1");
		dtpVadeTarihi
				.addValueChangeHandler(new DtpVadeTarihiValueChangeHandler());
		dtpVadeTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpVadeTarihi.setSize("156px", "16px");
		horizontalPanel.add(cbxCek);
		horizontalPanel.setCellWidth(cbxCek, "50");
		cbxCek.setEnabled(false);
		cbxCek.addItem(" ");
		cbxCek.setStyleName("gwt-ComboBox1");
		cbxCek.setSize("278px", "22px");

		Label lblMiktar = new Label("Miktar");
		flexTable.setWidget(6, 0, lblMiktar);
		lblMiktar.setStyleName("gwt-Bold");

		tctMiktar = new TextBox();
		tctMiktar.addKeyPressHandler(new TctMiktarKeyPressHandler());
		flexTable.setWidget(6, 1, tctMiktar);
		tctMiktar.setStyleName("gwt-TextBox1");
		tctMiktar.setSize("155px", "14px");

		Label lblTarijh = new Label("Tarih");
		lblTarijh.setVisible(false);
		flexTable.setWidget(7, 0, lblTarijh);
		lblTarijh.setStyleName("gwt-Bold");

		dtpTarih = new DateBox();
		dtpTarih.setVisible(false);
		dtpTarih.setEnabled(false);
		flexTable.setWidget(7, 1, dtpTarih);
		dtpTarih.setStyleName("gwt-TextBox1");
		dtpTarih.addValueChangeHandler(new DtpTarihValueChangeHandler());
		dtpTarih.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd HH:mm:ss")));
		dtpTarih.setSize("155px", "16px");

		Label lblAklama = new Label("Açıklama");
		flexTable.setWidget(8, 0, lblAklama);
		lblAklama.setStyleName("gwt-Bold");

		tctAciklama = new TextArea();
		flexTable.setWidget(8, 1, tctAciklama);
		tctAciklama.setStyleName("gwt-TextAreaResible");
		tctAciklama.setSize("274px", "67px");
		flexTable.getCellFormatter().setVerticalAlignment(8, 0,
				HasVerticalAlignment.ALIGN_TOP);

		if (!isDesignTime()) {

			putKategoriAdiToCbx(cbxKategoriler);
			putBankalarToCbx(cbxBanka);
			// dtpTarih.setValue(new Date());
			dtpTarih.setValue(new Date());
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
			// URLValue = URLValue + "&cek="
			// + cbxCek.getValue(cbxCek.getSelectedIndex());
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
		// cbxBanka.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxBanka,
		// xml.banka));

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
			// cbxCek.setEnabled(false);
			dtpVadeTarihi.setEnabled(false);
			// cbxBanka.setItemText(0, xml.banka);

		} else if (cbxOdemeTuru.getSelectedIndex() == 2) {

			cbxBanka.setEnabled(false);
			// cbxCek.setEnabled(false);
			dtpVadeTarihi.setEnabled(true);
			// cbxBanka.setItemText(0, xml.banka);

		} else if (cbxOdemeTuru.getSelectedIndex() == 1) {
			cbxBanka.setEnabled(true);
			// cbxCek.setEnabled(false);
			// dtpVadeTarihi.setEnabled(false);

		} else if (cbxOdemeTuru.getSelectedIndex() == 0) {
			cbxBanka.setEnabled(false);
			// cbxCek.setEnabled(false);
			dtpVadeTarihi.setEnabled(false);
			// cbxBanka.addItem("Lütfen Seçiniz");

		} else if (cbxOdemeTuru.getSelectedIndex() == 4) {
			cbxBanka.setEnabled(true);
			// cbxCek.setEnabled(false);
			dtpVadeTarihi.setEnabled(false);
			// cbxBanka.setItemText(0, xml.banka);

		}

	}

	private class CbxOdemeTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			if (cbxOdemeTuru.getSelectedIndex() == 3) {
				cbxBanka.setEnabled(false);
				// cbxCek.setEnabled(false);
				dtpVadeTarihi.setEnabled(false);
				// cbxBanka.setItemText(0, "Lütfen Seçiniz");

			} else if (cbxOdemeTuru.getSelectedIndex() == 2) {

				cbxBanka.setEnabled(false);
				// cbxCek.setEnabled(false);
				dtpVadeTarihi.setEnabled(true);
				// cbxBanka.setItemText(0, "Lütfen Seçiniz");

			} else if (cbxOdemeTuru.getSelectedIndex() == 1) {
				cbxBanka.setEnabled(true);
				// cbxCek.setEnabled(false);
				dtpVadeTarihi.setEnabled(false);

			} else if (cbxOdemeTuru.getSelectedIndex() == 0) {
				cbxBanka.setEnabled(false);
				// cbxCek.setEnabled(false);
				dtpVadeTarihi.setEnabled(false);
				// cbxBanka.setItemText(0, "Lütfen Seçiniz");

			} else if (cbxOdemeTuru.getSelectedIndex() == 4) {
				cbxBanka.setEnabled(true);
				// cbxCek.setEnabled(false);
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

	private class TctMiktarKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctMiktar.getText();
			if (!input.matches("[0-9]*")) {
				tctMiktar.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctMiktar.setStyleName("gwt-TextBox1");

		}
	}
}
