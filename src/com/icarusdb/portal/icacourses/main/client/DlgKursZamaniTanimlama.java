package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgKursZamaniTanimlama extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctKursZamani;

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

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 335, 109);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 419, 109);
		btnKapat.setSize("78px", "45px");

		Button btnYeniKaydet = new Button("New button");
		btnYeniKaydet.setStyleName("gwt-ButonYeniKayit");
		btnYeniKaydet.setText("Yeni Kayıt");
		absolutePanel.add(btnYeniKaydet, 251, 109);
		btnYeniKaydet.setSize("78px", "45px");
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

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLKursZamaniTanimlama xml) {
		tctKursZamani.setText(xml.kurs_zamani);

	}
}
