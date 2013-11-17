package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgUniteTanimlari extends DialogBox {
	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private ListBox cbxDers;
	private TextBox tctUniteAdi;

	public DlgUniteTanimlari() {
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
		absolutePanel.add(lblAlan, 11, 77);

		Label lblDers = new Label("Ders");
		lblDers.setStyleName("gwt-Bold");
		absolutePanel.add(lblDers, 10, 101);
		lblDers.setSize("27px", "25px");

		Label lblniteAd = new Label("Ünite Adı");
		lblniteAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblniteAd, 10, 132);
		lblniteAd.setSize("67px", "18px");

		tctUniteAdi = new TextBox();
		tctUniteAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctUniteAdi, 129, 132);
		tctUniteAdi.setSize("149px", "18px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.addItem("1");
		cbxEgitimTuru.addItem("2");
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
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putunitetanimlari?";
			URLValue = URLValue + "egitim_turu_adi="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&alan_adi="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders_adi="
					+ cbxDers.getValue(cbxDers.getSelectedIndex());

			URLValue = URLValue + "&unite_adi=" + tctUniteAdi.getText();

			Window.alert(URLValue);

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
		cbxEgitimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxEgitimTuru, xml.egitim_turu_adi));
	}
}
