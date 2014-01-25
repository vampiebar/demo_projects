package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgFizikselSinifTanimlari extends DialogBox {
	public boolean _isInsert = true;
	public long _id = -1;
	private Button btnKaydet;
	private Button btnKapat;
	private TextBox tctFizikselSinifAdi;

	public DlgFizikselSinifTanimlari(boolean isInsert, long id) {
		setAnimationEnabled(true);
		setGlassEnabled(true);

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
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 237, 177);
		btnKaydet.setSize("78px", "45px");

		btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 321, 177);
		btnKapat.setSize("78px", "45px");

		Button btnYeniKayit = new Button("New button");
		btnYeniKayit.setText("Yeni Kayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 125, 105);
		btnYeniKayit.setSize("78px", "45px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 219, 94);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 302, 94);
		image_1.setSize("72px", "66px");
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

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			tctFizikselSinifAdi.setText("");
		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKaydet.click();
		}
	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}
}
