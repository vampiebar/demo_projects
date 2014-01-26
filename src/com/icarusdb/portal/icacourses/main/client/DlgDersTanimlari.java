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
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgDersTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private TextBox tctDersAdi;
	private Button btnKaydet;

	public DlgDersTanimlari(boolean isInsert, long id) {
		setAnimationEnabled(true);
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Ders Ekleme / Düzenleme");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("524px", "403px");

		Label lblDersIlemleriekleme = new Label(
				"Ders İşlemleri (Ekleme / Düzenleme)");
		lblDersIlemleriekleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblDersIlemleriekleme, 0, 0);
		lblDersIlemleriekleme.setSize("524px", "28px");

		Label lblDersAd = new Label("Eğitim Türü");
		lblDersAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblDersAd, 10, 50);
		lblDersAd.setSize("96px", "16px");

		Label lblAlan = new Label("Alan");
		lblAlan.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlan, 10, 81);
		lblAlan.setSize("46px", "16px");

		Label lblDersAd_1 = new Label("Ders Adı");
		lblDersAd_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblDersAd_1, 10, 115);
		lblDersAd_1.setSize("66px", "16px");

		tctDersAdi = new TextBox();
		tctDersAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctDersAdi, 112, 111);
		tctDersAdi.setSize("149px", "18px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
		absolutePanel.add(cbxEgitimTuru, 112, 46);
		cbxEgitimTuru.setSize("151px", "22px");

		cbxAlan = new ListBox();
		cbxAlan.addItem(" ");
		cbxAlan.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxAlan, 112, 77);
		cbxAlan.setSize("151px", "22px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 112, 227);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 196, 227);
		btnKapat.setSize("78px", "45px");

		Button btnNewButton = new Button("New button");
		btnNewButton.setStyleName("gwt-ButonYeniKayit");
		btnNewButton.setText("");
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		absolutePanel.add(btnNewButton, 23, 155);
		btnNewButton.setSize("78px", "66px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 112, 155);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 196, 155);
		image_1.setSize("72px", "66px");

		if (!isDesignTime()) {

			putEgitimTuruToCbx(cbxEgitimTuru);

		}

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

	// Implement the following method exactly as-is
	private static final boolean isDesignTime() {
		// return Beans.isDesignTime(); // GWT 2.4 and above
		return false; // GWT 2.2 and earlier

	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putderstanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue
					+ "&egitim_turu_adi="
					+ cbxEgitimTuru.getItemText(cbxEgitimTuru
							.getSelectedIndex());
			URLValue = URLValue + "&alan_adi="
					+ cbxAlan.getItemText(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders_adi=" + tctDersAdi.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue,
					"DERS BİLGİSİ BAŞARI İLE KAYIT EDİLDİ",
					"DERS BİLGİSİ KAYIT EDİLEMEDİ");
		}
	}

	public void putDataFromXML(XMLDersTanimlari xml) {
		cbxEgitimTuru.setItemText(0, xml.egitim_turu_adi);
		cbxAlan.setItemText(0, xml.alan_adi);
		tctDersAdi.setText(xml.ders_adi);
	}

	private class CbxEgitimTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxGorusmeEgitimTuru.getSelectedIndex() + "");
			putEgitimTuruAlanToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxAlan);
		}
	}

	private class BtnNewButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			cbxAlan.clear();
			cbxEgitimTuru.clear();
			tctDersAdi.setText("");
			putEgitimTuruToCbx(cbxEgitimTuru);

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

}
