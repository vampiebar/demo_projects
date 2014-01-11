package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.google.gwt.user.client.ui.HasVerticalAlignment;
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
	private SimpleCheckBox chxPazartesi;
	private SimpleCheckBox chxSali;
	private SimpleCheckBox chxCarsamba;
	private SimpleCheckBox chxPersembe;
	private SimpleCheckBox chxCuma;
	private SimpleCheckBox chxCumartesi;
	private SimpleCheckBox chxPazar;
	public DecoratedTabPanel tabOgretmenIslemleri;

	public DlgOgretmenTanimlari(boolean isInsert, long id) {
		setAnimationEnabled(true);
		setGlassEnabled(true);

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
		verticalPanel.setSize("208px", "447px");

		Label lblretmenNo = new Label("Öğretmen No");
		verticalPanel.add(lblretmenNo);
		verticalPanel.setCellHeight(lblretmenNo, "28");
		lblretmenNo.setStyleName("gwt-Bold");

		Label lblTcKimlikNo = new Label("T.C. Kimlik No");
		verticalPanel.add(lblTcKimlikNo);
		verticalPanel.setCellHeight(lblTcKimlikNo, "27");
		lblTcKimlikNo.setStyleName("gwt-Bold");

		Label lblAdSoyad = new Label("Adı Soyadı");
		verticalPanel.add(lblAdSoyad);
		verticalPanel.setCellHeight(lblAdSoyad, "27");
		lblAdSoyad.setStyleName("gwt-Bold");
		lblAdSoyad.setSize("176px", "18px");

		Label lblGirdiğiDersBilgisi = new Label("Girdiği Ders Bilgisi");
		verticalPanel.add(lblGirdiğiDersBilgisi);
		verticalPanel.setCellHeight(lblGirdiğiDersBilgisi, "29");
		lblGirdiğiDersBilgisi.setHeight("19px");
		lblGirdiğiDersBilgisi.setStyleName("gwt-Bold");

		Label lblEitimTr = new Label("Eğitim Türü");
		verticalPanel.add(lblEitimTr);
		verticalPanel.setCellVerticalAlignment(lblEitimTr,
				HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setCellHeight(lblEitimTr, "32");
		lblEitimTr.setHeight("21px");
		lblEitimTr.setStyleName("gwt-Bold");

		Label lblBran = new Label("Branş");
		verticalPanel.add(lblBran);
		verticalPanel.setCellHeight(lblBran, "33");
		lblBran.setHeight("20px");
		lblBran.setStyleName("gwt-Bold");

		Label lblGirdiiDersler = new Label("Girdiği Dersler");
		verticalPanel.add(lblGirdiiDersler);
		verticalPanel.setCellHeight(lblGirdiiDersler, "33");
		lblGirdiiDersler.setHeight("21px");
		lblGirdiiDersler.setStyleName("gwt-Bold");

		Label lblcreti = new Label("Ücreti");
		verticalPanel.add(lblcreti);
		verticalPanel.setCellHeight(lblcreti, "28");
		lblcreti.setStyleName("gwt-Bold");

		Label lblEvTelefonu = new Label("Ev Telefonu");
		verticalPanel.add(lblEvTelefonu);
		verticalPanel.setCellHeight(lblEvTelefonu, "28");
		lblEvTelefonu.setStyleName("gwt-Bold");

		Label lblCepTelefonu = new Label("Cep Telefonu");
		verticalPanel.add(lblCepTelefonu);
		verticalPanel.setCellHeight(lblCepTelefonu, "30");
		lblCepTelefonu.setStyleName("gwt-Bold");

		Label lblCepTelefonu_1 = new Label("Cep Telefonu 2");
		verticalPanel.add(lblCepTelefonu_1);
		verticalPanel.setCellHeight(lblCepTelefonu_1, "30");
		lblCepTelefonu_1.setStyleName("gwt-Bold");

		Label lblEmail = new Label("E-mail");
		verticalPanel.add(lblEmail);
		verticalPanel.setCellHeight(lblEmail, "29");
		lblEmail.setStyleName("gwt-Bold");

		Label lblSigortaGnSays = new Label("Sigorta Gün Sayısı");
		verticalPanel.add(lblSigortaGnSays);
		verticalPanel.setCellHeight(lblSigortaGnSays, "31");
		lblSigortaGnSays.setStyleName("gwt-Bold");

		Label lblDersProgmamnGrsun = new Label("Ders Progmamını Görsün");
		verticalPanel.add(lblDersProgmamnGrsun);
		verticalPanel.setCellHeight(lblDersProgmamnGrsun, "29");
		lblDersProgmamnGrsun.setWidth("193px");
		lblDersProgmamnGrsun.setStyleName("gwt-Bold");

		Label lblDurum = new Label("Durum");
		verticalPanel.add(lblDurum);
		lblDurum.setStyleName("gwt-Bold");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		absolutePanel_1.add(verticalPanel_1, 225, 10);
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
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
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
		cbxGirdigiDersler.addItem(" ");
		verticalPanel_1.add(cbxGirdigiDersler);
		cbxGirdigiDersler.setStyleName("gwt-ComboBox1");
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
		absolutePanel_3.setSize("713px", "456px");

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

		chxSali = new SimpleCheckBox();
		absolutePanel_3.add(chxSali, 114, 53);
		chxSali.setSize("20px", "19px");

		chxCarsamba = new SimpleCheckBox();
		absolutePanel_3.add(chxCarsamba, 114, 76);
		chxCarsamba.setSize("20px", "19px");

		chxPersembe = new SimpleCheckBox();
		absolutePanel_3.add(chxPersembe, 114, 100);
		chxPersembe.setSize("20px", "19px");

		chxCuma = new SimpleCheckBox();
		absolutePanel_3.add(chxCuma, 114, 124);
		chxCuma.setSize("20px", "19px");

		chxCumartesi = new SimpleCheckBox();
		absolutePanel_3.add(chxCumartesi, 114, 148);
		chxCumartesi.setSize("20px", "19px");

		chxPazar = new SimpleCheckBox();
		absolutePanel_3.add(chxPazar, 114, 173);
		chxPazar.setSize("20px", "19px");

		chxPazartesi = new SimpleCheckBox();
		absolutePanel_3.add(chxPazartesi, 114, 29);
		chxPazartesi.setSize("20px", "19px");

		Label lblNewLabel = new Label("Öğretmen İşlemleri (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("100%", "28px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel.add(absolutePanel_2, 399, -33);
		absolutePanel_2.setSize("258px", "567px");

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
					+ cbxBrans.getValue(cbxBrans.getSelectedIndex());
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

		cbxBrans.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxBrans,
				xml.brans));

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
}
