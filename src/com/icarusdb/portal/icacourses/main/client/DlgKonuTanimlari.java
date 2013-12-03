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

public class DlgKonuTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private ListBox cbxDers;
	private ListBox cbxUniteAdi;
	private TextBox tctKonu;

	public DlgKonuTanimlari(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Konu Ekleme / Düzenleme");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("527px", "373px");

		Label lblDersIlemleriekleme = new Label(
				"Ders İşlemleri (Ekleme / Düzenleme)");
		lblDersIlemleriekleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblDersIlemleriekleme, 0, 0);
		lblDersIlemleriekleme.setSize("527px", "28px");

		Label label = new Label("Eğitim Türü");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 10, 44);
		label.setSize("67px", "18px");

		Label label_1 = new Label("Alan");
		label_1.setStyleName("gwt-Bold");
		absolutePanel.add(label_1, 11, 78);
		label_1.setSize("26px", "18px");

		Label label_2 = new Label("Ders");
		label_2.setStyleName("gwt-Bold");
		absolutePanel.add(label_2, 10, 102);
		label_2.setSize("27px", "25px");

		Label label_3 = new Label("Ünite Adı");
		label_3.setStyleName("gwt-Bold");
		absolutePanel.add(label_3, 10, 133);
		label_3.setSize("67px", "18px");

		Label lblKonu = new Label("Konu");
		lblKonu.setStyleName("gwt-Bold");
		absolutePanel.add(lblKonu, 10, 170);

		cbxDers = new ListBox();
		cbxDers.setStyleName("gwt-ComboBox1");
		cbxDers.addItem("a");
		cbxDers.addItem("b");
		cbxDers.addItem(" ");
		absolutePanel.add(cbxDers, 122, 105);
		cbxDers.setSize("151px", "18px");

		cbxAlan = new ListBox();
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem(" 2");
		cbxAlan.addItem("3");
		absolutePanel.add(cbxAlan, 122, 75);
		cbxAlan.setSize("151px", "18px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxEgitimTuru, 122, 40);
		cbxEgitimTuru.setSize("151px", "18px");

		cbxUniteAdi = new ListBox();
		cbxUniteAdi.setStyleName("gwt-ComboBox1");
		cbxUniteAdi.addItem("c");
		cbxUniteAdi.addItem("d");
		cbxUniteAdi.addItem(" ");
		absolutePanel.add(cbxUniteAdi, 122, 133);
		cbxUniteAdi.setSize("151px", "18px");

		tctKonu = new TextBox();
		tctKonu.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctKonu, 122, 170);
		tctKonu.setSize("149px", "14px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 310, 203);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 394, 203);
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
			String URLValue = Util.urlBase + "putkonutanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&egitim_turu_adi="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&alan_adi="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders_adi="
					+ cbxDers.getValue(cbxDers.getSelectedIndex());
			URLValue = URLValue + "&unite_adi="
					+ cbxUniteAdi.getValue(cbxUniteAdi.getSelectedIndex());
			URLValue = URLValue + "&konu_adi=" + tctKonu.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLKonuTanimlari xml) {
		tctKonu.setText(xml.konu_adi);
		cbxAlan.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxAlan,
				xml.alan_adi));
		cbxDers.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxDers,
				xml.ders_adi));
		cbxEgitimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxEgitimTuru, xml.egitim_turu_adi));
		cbxUniteAdi.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxUniteAdi,
				xml.unite_adi));

	}
}
