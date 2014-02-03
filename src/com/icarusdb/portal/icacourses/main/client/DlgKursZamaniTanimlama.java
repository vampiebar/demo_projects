package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgKursZamaniTanimlama extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctKursZamani;
	private Button btnKaydet;

	public DlgKursZamaniTanimlama(boolean isInsert, long id) {
		setAnimationEnabled(true);
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Kurs Zamani Tanimlama");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("562px", "414px");

		Label lblKursZamanIlemleri = new Label(
				"Kurs Zamanı İşlemleri (Ekleme / Düzenleme)");
		lblKursZamanIlemleri.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblKursZamanIlemleri, 0, 0);
		lblKursZamanIlemleri.setSize("572px", "28px");

		Label lblKursZaman = new Label("Kurs Zamanı");
		lblKursZaman.setStyleName("gwt-Bold");
		absolutePanel.add(lblKursZaman, 10, 47);

		tctKursZamani = new TextBox();
		tctKursZamani.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctKursZamani, 126, 44);
		tctKursZamani.setSize("143px", "17px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 275, 245);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("");
		absolutePanel.add(btnKapat, 359, 245);
		btnKapat.setSize("78px", "45px");

		Button btnYeniKaydet = new Button("New button");
		btnYeniKaydet.addClickHandler(new BtnYeniKaydetClickHandler());
		btnYeniKaydet.setStyleName("gwt-ButonYeniKayit");
		btnYeniKaydet.setText("");
		absolutePanel.add(btnYeniKaydet, 222, 109);
		btnYeniKaydet.setSize("78px", "66px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 314, 109);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 402, 109);
		image_1.setSize("72px", "66px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putkurszamanitanimlama?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&kurs_zamani=" + tctKursZamani.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLKursZamaniTanimlama xml) {
		tctKursZamani.setText(xml.kurs_zamani);

	}

	private class BtnYeniKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			tctKursZamani.setText("");

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
