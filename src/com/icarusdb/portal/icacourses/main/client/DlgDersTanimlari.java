package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgDersTanimlari extends DialogBox {
	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private TextBox tctDersAdi;

	public DlgDersTanimlari() {
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
		tctDersAdi.setSize("149px", "14px");

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
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putderstanimlari?";
			URLValue = URLValue + "egitim_turu_adi="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&alan_adi="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders_adi=" + tctDersAdi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue);
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
