package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgDersTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private TextBox tctDersAdi;

	public DlgDersTanimlari(boolean isInsert, long id) {

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
		absolutePanel.add(lblDersAd, 10, 46);

		Label lblAlan = new Label("Alan");
		lblAlan.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlan, 10, 77);
		lblAlan.setSize("26px", "28px");

		Label lblDersAd_1 = new Label("Ders Adı");
		lblDersAd_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblDersAd_1, 10, 111);

		tctDersAdi = new TextBox();
		tctDersAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctDersAdi, 112, 111);
		tctDersAdi.setSize("149px", "18px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addItem("1");
		cbxEgitimTuru.addItem("2");
		absolutePanel.add(cbxEgitimTuru, 112, 46);
		cbxEgitimTuru.setSize("151px", "22px");

		cbxAlan = new ListBox();
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem("a");
		cbxAlan.addItem("b");
		absolutePanel.add(cbxAlan, 112, 77);
		cbxAlan.setSize("151px", "22px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 112, 166);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 196, 166);
		btnKapat.setSize("78px", "45px");

		if (!isDesignTime()) {

			putEgitimTuruToCbx(cbxEgitimTuru);

		}

	}

	public void putEgitimTuruToCbx(final ListBox lbxTemp) {

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
			URLValue = URLValue + "&egitim_turu_adi="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&alan_adi="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders_adi=" + tctDersAdi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue,
					"DERS BİLGİSİ BAŞARI İLE KAYIT EDİLDİ",
					"DERS BİLGİSİ KAYIT EDİLEMEDİ");
		}
	}

	public void putDataFromXML(XMLDersTanimlari xml) {
		tctDersAdi.setText(xml.ders_adi);
		cbxAlan.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxAlan,
				xml.alan_adi));
		cbxEgitimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxEgitimTuru, xml.egitim_turu_adi));
	}
}
