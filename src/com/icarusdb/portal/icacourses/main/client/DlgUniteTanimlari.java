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

public class DlgUniteTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private ListBox cbxDers;
	private TextBox tctUniteAdi;

	public DlgUniteTanimlari(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Unite Ekleme / Duzenleme");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("501px", "378px");

		Label lblniteIlemleriekleme = new Label(
				"Ünite İşlemleri (Ekleme / Düzenleme)");
		lblniteIlemleriekleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblniteIlemleriekleme, 0, 0);
		lblniteIlemleriekleme.setSize("501px", "28px");

		Label lblEitimTr = new Label("Eğitim Türü");
		lblEitimTr.setStyleName("gwt-Bold");
		absolutePanel.add(lblEitimTr, 10, 43);

		Label lblAlan = new Label("Alan");
		lblAlan.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlan, 10, 80);

		Label lblDers = new Label("Ders");
		lblDers.setStyleName("gwt-Bold");
		absolutePanel.add(lblDers, 9, 110);
		lblDers.setSize("27px", "16px");

		Label lblniteAd = new Label("Ünite Adı");
		lblniteAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblniteAd, 10, 138);
		lblniteAd.setSize("67px", "16px");

		tctUniteAdi = new TextBox();
		tctUniteAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctUniteAdi, 129, 132);
		tctUniteAdi.setSize("149px", "18px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxEgitimTuru, 129, 39);
		cbxEgitimTuru.setSize("151px", "18px");

		cbxAlan = new ListBox();
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem("1");
		cbxAlan.addItem("2");
		absolutePanel.add(cbxAlan, 129, 74);
		cbxAlan.setSize("151px", "18px");

		cbxDers = new ListBox();
		cbxDers.setStyleName("gwt-ComboBox1");
		cbxDers.addItem("1");
		cbxDers.addItem("2");
		absolutePanel.add(cbxDers, 129, 104);
		cbxDers.setSize("151px", "18px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 242, 171);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 326, 171);
		btnKapat.setSize("78px", "45px");

		if (!isDesignTime()) {

			putEgitimTuruToCbx(cbxEgitimTuru);

		}

	}

	private boolean isDesignTime() {

		return false;
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

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putunitetanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&egitim_turu_adi="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&alan_adi="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders_adi="
					+ cbxDers.getValue(cbxDers.getSelectedIndex());

			URLValue = URLValue + "&unite_adi=" + tctUniteAdi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue,
					"Ünite Bilgisi Başarıyla Ekşenmiştir.",
					"Ünite Bilgisi Eklenememiştir.");

		}
	}

	public void putDataFromXML(XMLUniteTanimlari xml) {

		tctUniteAdi.setText(xml.unite_adi);
		cbxAlan.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxAlan,
				xml.alan_adi));
		cbxDers.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxDers,
				xml.ders_adi));
		cbxEgitimTuru.setItemText(0, xml.egitim_turu_adi);
	}
}
