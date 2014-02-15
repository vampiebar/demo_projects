package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
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
	private Image image;
	private Image image_1;

	public DlgFizikselSinifTanimlari(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Fiziksel Sınıf İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("503px", "388px");

		Label lblFizikselSnfAd = new Label("Fiziksel Sınıf Adı");
		lblFizikselSnfAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblFizikselSnfAd, 10, 10);
		lblFizikselSnfAd.setSize("126px", "18px");

		tctFizikselSinifAdi = new TextBox();
		tctFizikselSinifAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctFizikselSinifAdi, 142, 10);
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
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.setText("");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 219, 64);
		btnYeniKayit.setSize("87px", "66px");

		image = new Image("kaydet-1.png");
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 312, 64);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 390, 64);
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
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

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

	private class Image_1MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_1.setUrl("kapat-2.png");

		}
	}

	private class ImageMouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image.setUrl("kaydet-2.png");

		}
	}

	private class ImageMouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image.setUrl("kaydet-1.png");

		}
	}

	private class Image_1MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_1.setUrl("kapat-1.png");

		}
	}
}
