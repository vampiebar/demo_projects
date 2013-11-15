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

public class DlgHizmetTanimla extends DialogBox {
	private TextBox tctHizmetAdi;
	private ListBox cbxHizmetTuru;
	private TextBox tctBirimFiyati;

	public DlgHizmetTanimla() {
		setHTML("Hizmet Ekleme / Düzenleme");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		setWidget(absolutePanel);
		absolutePanel.setSize("590px", "446px");

		Label lblNewLabel = new Label("Hizmet İşlemleri (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("100%", "28px");

		Label lblBirimFiyat = new Label("Birim fiyatı");
		lblBirimFiyat.setStyleName("gwt-Bold");
		absolutePanel.add(lblBirimFiyat, 10, 133);
		lblBirimFiyat.setSize("81px", "18px");

		Label lblHzmetT = new Label("Hizmet türü");
		lblHzmetT.setStyleName("gwt-Bold");
		absolutePanel.add(lblHzmetT, 10, 90);
		lblHzmetT.setSize("71px", "18px");

		Label lblHizmetAd = new Label("Hizmet Adı");
		lblHizmetAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblHizmetAd, 10, 49);
		lblHizmetAd.setSize("68px", "18px");

		tctHizmetAdi = new TextBox();
		tctHizmetAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctHizmetAdi, 108, 50);
		tctHizmetAdi.setSize("149px", "15px");

		cbxHizmetTuru = new ListBox();
		cbxHizmetTuru.addItem("Servis");
		cbxHizmetTuru.addItem("Ders");
		cbxHizmetTuru.addItem("Diğer");
		absolutePanel.add(cbxHizmetTuru, 108, 91);
		cbxHizmetTuru.setSize("151px", "22px");

		tctBirimFiyati = new TextBox();
		tctBirimFiyati.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctBirimFiyati, 108, 133);
		tctBirimFiyati.setSize("149px", "15px");

		Button btnYeniKayit = new Button("New button");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.setText("Yeni Kayıt");
		absolutePanel.add(btnYeniKayit, 259, 168);
		btnYeniKayit.setSize("78px", "45px");

		Button btnKaydet = new Button("");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 343, 168);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 427, 168);
		btnKapat.setSize("78px", "45px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "puthizmettanimla?";
			URLValue = URLValue + "hizmet_adi=" + tctHizmetAdi.getText();
			URLValue = URLValue + "&hizmet_turu="
					+ cbxHizmetTuru.getValue(cbxHizmetTuru.getSelectedIndex());
			URLValue = URLValue + "&birim_fiyati=" + tctBirimFiyati.getText();

			Window.alert(URLValue);

			new Util().sendRequest(URLValue);

		}
	}

	public void putDataFromXML(XMLHizmetTanimla xml) {
		tctBirimFiyati.setText(xml.birim_fiyati);
		tctHizmetAdi.setText(xml.hizmet_adi);
		cbxHizmetTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxHizmetTuru, xml.hizmet_turu));
	}
}
