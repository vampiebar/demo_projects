package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgFizikselSinifTanimlari extends DialogBox {
	public boolean _isInsert = true;
	public long _id = -1;
	private Button btnKaydet;
	private Button btnKapat;
	private TextBox tctFizikselSinifAdi;

	public DlgFizikselSinifTanimlari(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Fiziksel Sınıf İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("503px", "388px");

		Label lblFizikselSnfIlemleri = new Label(
				"Fiziksel Sınıf İşlemleri (Ekleme / Düzenleme)");
		lblFizikselSnfIlemleri.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblFizikselSnfIlemleri, 0, 0);
		lblFizikselSnfIlemleri.setSize("503px", "28px");

		Label lblFizikselSnfAd = new Label("Fiziksel Sınıf Adı");
		lblFizikselSnfAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblFizikselSnfAd, 10, 49);
		lblFizikselSnfAd.setSize("126px", "18px");

		tctFizikselSinifAdi = new TextBox();
		tctFizikselSinifAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctFizikselSinifAdi, 142, 49);
		tctFizikselSinifAdi.setSize("143px", "14px");

		btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 274, 83);
		btnKaydet.setSize("78px", "45px");

		btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 358, 83);
		btnKapat.setSize("78px", "45px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putfizikselsiniftanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&fiziksel_sinif_adi="
					+ tctFizikselSinifAdi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLFizikselSinifTanimlari xml) {

		tctFizikselSinifAdi.setText(xml.fiziksel_sinif_adi);

	}
}
