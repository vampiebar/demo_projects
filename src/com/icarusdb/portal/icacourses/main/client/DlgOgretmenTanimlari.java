package com.icarusdb.portal.icacourses.main.client;

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
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;

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
	private SimpleCheckBox chxPazartesi;
	private SimpleCheckBox chxSali;
	private SimpleCheckBox chxCarsamba;
	private SimpleCheckBox chxPersembe;
	private SimpleCheckBox chxCuma;
	private SimpleCheckBox chxCumartesi;
	private SimpleCheckBox chxPazar;
	public DecoratedTabPanel tabOgretmenIslemleri;
	private Button btnKaydet;
	private Image image;
	private Image image_1;

	public DlgOgretmenTanimlari(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Öğretmen İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("607px", "498px");

		tabOgretmenIslemleri = new DecoratedTabPanel();
		absolutePanel.add(tabOgretmenIslemleri, 0, 0);
		tabOgretmenIslemleri.setSize("597px", "502px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabOgretmenIslemleri.add(absolutePanel_1, "Öğretmen Bilgileri", false);
		absolutePanel_1.setSize("584px", "450px");

		FlexTable flexTable = new FlexTable();
		absolutePanel_1.add(flexTable, 10, 10);
		flexTable.setSize("348px", "301px");

		Label lblTcKimlikNo = new Label("T.C. Kimlik No");
		flexTable.setWidget(0, 0, lblTcKimlikNo);
		lblTcKimlikNo.setStyleName("gwt-Bold");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.addKeyPressHandler(new TctTCKimlikNoKeyPressHandler());
		flexTable.setWidget(0, 1, tctTCKimlikNo);
		tctTCKimlikNo.setMaxLength(11);
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		tctTCKimlikNo.setSize("143px", "14px");

		Label lblAdSoyad = new Label("Adı Soyadı");
		flexTable.setWidget(1, 0, lblAdSoyad);
		lblAdSoyad.setStyleName("gwt-Bold");
		lblAdSoyad.setSize("176px", "18px");

		tctAdiSoyadi = new TextBox();
		tctAdiSoyadi.setMaxLength(35);
		flexTable.setWidget(1, 1, tctAdiSoyadi);
		tctAdiSoyadi.setStyleName("gwt-TextBox1");
		tctAdiSoyadi.setSize("143px", "14px");

		Label lblGirdiğiDersBilgisi = new Label("Girdiği Ders Bilgisi");
		flexTable.setWidget(2, 0, lblGirdiğiDersBilgisi);
		lblGirdiğiDersBilgisi.setHeight("19px");
		lblGirdiğiDersBilgisi.setStyleName("gwt-Bold");

		tctGirdigiDersbilgisi = new TextBox();
		flexTable.setWidget(2, 1, tctGirdigiDersbilgisi);
		tctGirdigiDersbilgisi.setStyleName("gwt-TextBox1");
		tctGirdigiDersbilgisi.setSize("143px", "14px");

		Label lblEitimTr = new Label("Eğitim Türü");
		flexTable.setWidget(3, 0, lblEitimTr);
		lblEitimTr.setHeight("21px");
		lblEitimTr.setStyleName("gwt-Bold");

		cbxEgitimTuru = new ListBox();
		flexTable.setWidget(3, 1, cbxEgitimTuru);
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.setSize("143px", "20px");

		Label lblBran = new Label("Branş");
		flexTable.setWidget(4, 0, lblBran);
		lblBran.setHeight("20px");
		lblBran.setStyleName("gwt-Bold");

		cbxBrans = new ListBox();
		flexTable.setWidget(4, 1, cbxBrans);
		cbxBrans.addItem(" ");
		cbxBrans.setStyleName("gwt-ComboBox1");
		cbxBrans.setSize("143px", "20px");

		Label lblGirdiiDersler = new Label("Girdiği Dersler");
		flexTable.setWidget(5, 0, lblGirdiiDersler);
		lblGirdiiDersler.setHeight("21px");
		lblGirdiiDersler.setStyleName("gwt-Bold");

		cbxGirdigiDersler = new ListBox();
		flexTable.setWidget(5, 1, cbxGirdigiDersler);
		cbxGirdigiDersler.addItem(" ");
		cbxGirdigiDersler.setStyleName("gwt-ComboBox1");
		cbxGirdigiDersler.setSize("143px", "20px");

		Label lblcreti = new Label("Ücreti");
		flexTable.setWidget(6, 0, lblcreti);
		lblcreti.setStyleName("gwt-Bold");

		tctUcreti = new TextBox();
		tctUcreti.addKeyPressHandler(new TctUcretiKeyPressHandler());
		flexTable.setWidget(6, 1, tctUcreti);
		tctUcreti.setStyleName("gwt-TextBox1");
		tctUcreti.setSize("143px", "14px");

		Label lblEvTelefonu = new Label("Ev Telefonu");
		flexTable.setWidget(7, 0, lblEvTelefonu);
		lblEvTelefonu.setStyleName("gwt-Bold");

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.setMaxLength(11);
		tctEvTelefonu.addKeyPressHandler(new TctEvTelefonuKeyPressHandler());
		flexTable.setWidget(7, 1, tctEvTelefonu);
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		tctEvTelefonu.setSize("143px", "14px");

		Label lblCepTelefonu = new Label("Cep Telefonu");
		flexTable.setWidget(8, 0, lblCepTelefonu);
		lblCepTelefonu.setStyleName("gwt-Bold");

		tctCepTelefonu = new TextBox();
		tctCepTelefonu.setMaxLength(11);
		tctCepTelefonu.addKeyPressHandler(new TctCepTelefonuKeyPressHandler());
		flexTable.setWidget(8, 1, tctCepTelefonu);
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		tctCepTelefonu.setSize("143px", "14px");

		Label lblCepTelefonu_1 = new Label("Cep Telefonu 2");
		flexTable.setWidget(9, 0, lblCepTelefonu_1);
		lblCepTelefonu_1.setStyleName("gwt-Bold");

		tctCepTelefonu2 = new TextBox();
		tctCepTelefonu2.setMaxLength(11);
		tctCepTelefonu2
				.addKeyPressHandler(new TctCepTelefonu2KeyPressHandler());
		flexTable.setWidget(9, 1, tctCepTelefonu2);
		tctCepTelefonu2.setStyleName("gwt-TextBox1");
		tctCepTelefonu2.setSize("143px", "14px");

		Label lblEmail = new Label("E-mail");
		flexTable.setWidget(10, 0, lblEmail);
		lblEmail.setStyleName("gwt-Bold");

		tctEmail = new TextBox();
		tctEmail.setMaxLength(30);
		tctEmail.addKeyPressHandler(new TctEmailKeyPressHandler());
		flexTable.setWidget(10, 1, tctEmail);
		tctEmail.setStyleName("gwt-TextBox1");
		tctEmail.setSize("143px", "14px");

		Label lblSigortaGnSays = new Label("Sigorta Gün Sayısı");
		flexTable.setWidget(11, 0, lblSigortaGnSays);
		lblSigortaGnSays.setStyleName("gwt-Bold");

		tctSigortaGunSayisi = new TextBox();
		tctSigortaGunSayisi.setMaxLength(10);
		tctSigortaGunSayisi
				.addKeyPressHandler(new TctSigortaGunSayisiKeyPressHandler());
		flexTable.setWidget(11, 1, tctSigortaGunSayisi);
		tctSigortaGunSayisi.setStyleName("gwt-TextBox1");
		tctSigortaGunSayisi.setSize("143px", "14px");

		Label lblDersProgmamnGrsun = new Label("Ders Progmamını Görsün");
		flexTable.setWidget(12, 0, lblDersProgmamnGrsun);
		lblDersProgmamnGrsun.setWidth("193px");
		lblDersProgmamnGrsun.setStyleName("gwt-Bold");

		chxDersPrograminiGorsun = new SimpleCheckBox();
		flexTable.setWidget(12, 1, chxDersPrograminiGorsun);

		Label lblDurum = new Label("Durum");
		flexTable.setWidget(13, 0, lblDurum);
		lblDurum.setStyleName("gwt-Bold");

		chxdurum = new CheckBox("Aktif / Pasif");
		chxdurum.setValue(true);
		flexTable.setWidget(13, 1, chxdurum);
		chxdurum.setSize("107px", "20px");

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		tabOgretmenIslemleri.add(absolutePanel_3, "Geldiği Günler", false);
		absolutePanel_3.setSize("584px", "450px");

		FlexTable flexTable_1 = new FlexTable();
		absolutePanel_3.add(flexTable_1, 10, 10);
		flexTable_1.setSize("78px", "130px");

		Label lblPazartesi = new Label("Pazartesi");
		flexTable_1.setWidget(0, 0, lblPazartesi);
		lblPazartesi.setStyleName("gwt-Bold");

		chxPazartesi = new SimpleCheckBox();
		flexTable_1.setWidget(0, 1, chxPazartesi);
		chxPazartesi.setSize("20px", "14px");

		Label lblSal = new Label("Salı");
		flexTable_1.setWidget(1, 0, lblSal);
		lblSal.setStyleName("gwt-Bold");

		chxSali = new SimpleCheckBox();
		flexTable_1.setWidget(1, 1, chxSali);
		chxSali.setSize("20px", "14px");

		Label lblaramba = new Label("Çarşamba");
		flexTable_1.setWidget(2, 0, lblaramba);
		lblaramba.setStyleName("gwt-Bold");

		chxCarsamba = new SimpleCheckBox();
		flexTable_1.setWidget(2, 1, chxCarsamba);
		chxCarsamba.setSize("20px", "14px");

		Label lblPerembe = new Label("Perşembe");
		flexTable_1.setWidget(3, 0, lblPerembe);
		lblPerembe.setStyleName("gwt-Bold");

		chxPersembe = new SimpleCheckBox();
		flexTable_1.setWidget(3, 1, chxPersembe);
		chxPersembe.setSize("20px", "14px");

		Label lblCuma = new Label("Cuma");
		flexTable_1.setWidget(4, 0, lblCuma);
		lblCuma.setStyleName("gwt-Bold");

		chxCuma = new SimpleCheckBox();
		flexTable_1.setWidget(4, 1, chxCuma);
		chxCuma.setSize("20px", "14px");

		Label lblCumartesi = new Label("Cumartesi");
		flexTable_1.setWidget(5, 0, lblCumartesi);
		lblCumartesi.setStyleName("gwt-Bold");

		chxCumartesi = new SimpleCheckBox();
		flexTable_1.setWidget(5, 1, chxCumartesi);
		chxCumartesi.setSize("20px", "14px");

		Label lblPazar = new Label("Pazar");
		flexTable_1.setWidget(6, 0, lblPazar);
		lblPazar.setStyleName("gwt-Bold");

		chxPazar = new SimpleCheckBox();
		flexTable_1.setWidget(6, 1, chxPazar);
		chxPazar.setSize("20px", "14px");

		btnKaydet = new Button("New button");
		absolutePanel_3.add(btnKaydet, 223, 50);
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		btnKaydet.setSize("78px", "47px");

		Button btnKapat = new Button("New button");
		absolutePanel_3.add(btnKapat, 307, 50);
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		btnKapat.setSize("78px", "47px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel.add(absolutePanel_2, 399, -33);
		absolutePanel_2.setSize("258px", "567px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel_2.add(image, 10, 444);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel_2.add(image_1, 88, 444);
		image_1.setSize("72px", "66px");

		if (!isDesignTime()) {

			putEgitimTuruToCbx(cbxEgitimTuru);

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

	private void putDersBilgisiToCbx(String egitim_turu_adi,
			final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getderstanimlari?egitim_turu_adi="
						+ egitim_turu_adi);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLDersTanimlari> xmlDersTanimlari = XMLDersTanimlari.XML
							.readList(response.getText());

					for (int i = 0; i < xmlDersTanimlari.size(); i++) {

						lbxTemp.addItem(xmlDersTanimlari.get(i).ders_adi + "-"
								+ xmlDersTanimlari.get(i).egitim_turu_adi + "-"
								+ xmlDersTanimlari.get(i).alan_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}
	}

	private void putBransToCbx(String egitim_turu_adi, final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getderstanimlari?egitim_turu_adi="
						+ egitim_turu_adi);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLDersTanimlari> xmlDersTanimlari = XMLDersTanimlari.XML
							.readList(response.getText());

					for (int i = 0; i < xmlDersTanimlari.size(); i++) {

						lbxTemp.addItem(xmlDersTanimlari.get(i).ders_adi);
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
			String URLValue = Util.urlBase + "putogretmentanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&tc_kimlik_no=" + tctTCKimlikNo.getText();
			URLValue = URLValue + "&adi_soyadi=" + tctAdiSoyadi.getText();
			URLValue = URLValue + "&girdigi_ders_bilgisi="
					+ tctGirdigiDersbilgisi.getText();

			URLValue = URLValue
					+ "&egitim_turu="
					+ cbxEgitimTuru.getItemText(cbxEgitimTuru
							.getSelectedIndex());
			URLValue = URLValue + "&brans="
					+ cbxBrans.getItemText(cbxBrans.getSelectedIndex());

			URLValue = URLValue
					+ "&girdigi_dersler="
					+ cbxGirdigiDersler.getItemText(cbxGirdigiDersler
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
			URLValue = URLValue + "&pazartesi="
					+ chxPazartesi.getValue().toString();
			URLValue = URLValue + "&sali=" + chxSali.getValue().toString();
			URLValue = URLValue + "&carsamba="
					+ chxCarsamba.getValue().toString();
			URLValue = URLValue + "&persembe="
					+ chxPersembe.getValue().toString();
			URLValue = URLValue + "&cuma=" + chxCuma.getValue().toString();
			URLValue = URLValue + "&cumartesi="
					+ chxCumartesi.getValue().toString();
			URLValue = URLValue + "&pazar=" + chxPazar.getValue().toString();

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

		// cbxBrans.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxBrans,
		// xml.brans));
		cbxBrans.setItemText(0, xml.brans);

		cbxEgitimTuru.setItemText(0, xml.egitim_turu);
		cbxGirdigiDersler.setItemText(0, xml.girdigi_dersler);

		chxDersPrograminiGorsun.setValue(xml.ders_programini_gorsun
				.equalsIgnoreCase("t") ? true : false);

		chxdurum.setValue(xml.durum.equalsIgnoreCase("t") ? true : false);
		chxPazartesi.setValue(xml.pazartesi.equalsIgnoreCase("t") ? true
				: false);
		// Window.alert("1:" + xml.pazartesi);
		chxSali.setValue(xml.sali.equalsIgnoreCase("t") ? true : false);
		chxCarsamba.setValue(xml.carsamba.equalsIgnoreCase("t") ? true : false);
		chxPersembe.setValue(xml.persembe.equalsIgnoreCase("t") ? true : false);
		chxCuma.setValue(xml.cuma.equalsIgnoreCase("t") ? true : false);
		chxCumartesi.setValue(xml.cumartesi.equalsIgnoreCase("t") ? true
				: false);
		chxPazar.setValue(xml.pazar.equalsIgnoreCase("t") ? true : false);

	}

	private class CbxEgitimTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putDersBilgisiToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxGirdigiDersler);

			putBransToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxBrans);

		}
	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKaydet.click();
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

	private class TctTCKimlikNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctTCKimlikNo.getText();
			if (!input.matches("[0-9]*")) {
				tctTCKimlikNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctTCKimlikNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctCepTelefonuKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctCepTelefonu.getText();
			if (!input.matches("[0-9]*")) {
				tctCepTelefonu.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctCepTelefonu.setStyleName("gwt-TextBox1");

		}
	}

	private class TctEvTelefonuKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctEvTelefonu.getText();
			if (!input.matches("[0-9]*")) {
				tctEvTelefonu.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctEvTelefonu.setStyleName("gwt-TextBox1");

		}
	}

	private class TctCepTelefonu2KeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctCepTelefonu2.getText();
			if (!input.matches("[0-9]*")) {
				tctCepTelefonu2.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctCepTelefonu2.setStyleName("gwt-TextBox1");

		}
	}

	private class TctUcretiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctUcreti.getText();
			if (!input.matches("[0-9]*")) {
				tctUcreti.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctUcreti.setStyleName("gwt-TextBox1");

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

	private class TctSigortaGunSayisiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctSigortaGunSayisi.getText();
			if (!input.matches("[0-9]*")) {
				tctSigortaGunSayisi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctSigortaGunSayisi.setStyleName("gwt-TextBox1");

		}
	}
}
