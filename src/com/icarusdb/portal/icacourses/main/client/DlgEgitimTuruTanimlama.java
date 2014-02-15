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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgEgitimTuruTanimlama extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctEgitimTuruAdi;
	private TextBox tctAlanAdi;
	private Button btnKaydet;
	private Image image;
	private Image image_1;

	public DlgEgitimTuruTanimlama(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Eğitim Türü Ekleme / Düzenleme");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		setWidget(absolutePanel);
		absolutePanel.setSize("483px", "367px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		btnKapat.setStyleName("gwt-ButonKapat");
		absolutePanel.add(btnKapat, 358, 196);
		btnKapat.setSize("78px", "45px");

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnKaydet, 257, 196);
		btnKaydet.setSize("78px", "45px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 291, 77);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 369, 77);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("267px", "33px");

		Label lblNewLabel = new Label("Eğitim Türü Adı");
		flexTable.setWidget(0, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");
		lblNewLabel.setSize("112px", "18px");

		tctEgitimTuruAdi = new TextBox();
		flexTable.setWidget(0, 1, tctEgitimTuruAdi);
		tctEgitimTuruAdi.setStyleName("gwt-TextBox1");
		tctEgitimTuruAdi.setSize("143px", "18px");

		Label lblAlanAd = new Label("Alan Adı");
		flexTable.setWidget(1, 0, lblAlanAd);
		lblAlanAd.setStyleName("gwt-Bold");
		lblAlanAd.setSize("64px", "16px");

		tctAlanAdi = new TextBox();
		flexTable.setWidget(1, 1, tctAlanAdi);
		tctAlanAdi.setStyleName("gwt-TextBox1");
		tctAlanAdi.setSize("143px", "18px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	public void putDataFromXML(XMLEgitimTuruTanimlama xml) {
		tctEgitimTuruAdi.setText(xml.egitim_turu_adi);
		tctAlanAdi.setText(xml.alan_adi);

	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putegitimturutanimlama?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&egitim_turu_adi="
					+ tctEgitimTuruAdi.getText();
			URLValue = URLValue + "&alan_adi=" + tctEgitimTuruAdi.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
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
