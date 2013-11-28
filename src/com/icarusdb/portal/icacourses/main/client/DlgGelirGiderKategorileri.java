package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgGelirGiderKategorileri extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private Button btnKaydet;
	private Button btnKapat;
	private TextBox tctKategoriAdi;

	public DlgGelirGiderKategorileri(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Gelir / Gider Kategori ( Ekleme / Düzenleme )");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("632px", "387px");

		Label lblGelirgiderKategoriIlemleri = new Label(
				"Gelir/Gider Kategori İşlemleri (Ekleme / Düzenleme)");
		lblGelirgiderKategoriIlemleri.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblGelirgiderKategoriIlemleri, 0, 0);
		lblGelirgiderKategoriIlemleri.setSize("632px", "28px");

		Label lblKategoriAd = new Label("Kategori Adı");
		lblKategoriAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblKategoriAd, 10, 44);

		tctKategoriAdi = new TextBox();
		tctKategoriAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctKategoriAdi, 98, 44);
		tctKategoriAdi.setSize("143px", "14px");

		btnKaydet = new Button("Kaydet");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 320, 98);
		btnKaydet.setSize("78px", "43px");

		btnKapat = new Button("Kapat");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel.add(btnKapat, 422, 98);
		btnKapat.setSize("78px", "43px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putgelirgiderkategorileri?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&kategori_adi=" + tctKategoriAdi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLGelirGiderKategorileri xml) {

		tctKategoriAdi.setText(xml.kategori_adi);

	}
}
