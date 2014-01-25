package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgReferanslar extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctReferansAdiSoyadi;
	private Button btnKaydet;

	public DlgReferanslar(boolean isInsert, long id) {
		setAnimationEnabled(true);
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Referans İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("531px", "397px");

		Label lblReferansIlemleriekleme = new Label(
				"Referans İşlemleri (Ekleme / Düzenleme)");
		lblReferansIlemleriekleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblReferansIlemleriekleme, 0, 0);
		lblReferansIlemleriekleme.setSize("541px", "28px");

		Label lblReferansAdSoyad = new Label("Referans Adı Soyadı");
		lblReferansAdSoyad.setStyleName("gwt-Bold");
		absolutePanel.add(lblReferansAdSoyad, 10, 47);

		tctReferansAdiSoyadi = new TextBox();
		tctReferansAdiSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctReferansAdiSoyadi, 167, 47);
		tctReferansAdiSoyadi.setSize("149px", "14px");

		Button btnYeniKayit = new Button("New button");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.setText("Yeni Kayıt");
		absolutePanel.add(btnYeniKayit, 192, 118);
		btnYeniKayit.setSize("78px", "65px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 281, 228);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 372, 228);
		btnKapat.setSize("78px", "45px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 281, 117);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 369, 117);
		image_1.setSize("72px", "66px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putreferanslar?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&referans_adi_soyadi="
					+ tctReferansAdiSoyadi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "Referans Kaydı Başarılı",
					"Referans Kaydı Yapılamadı");
		}
	}

	public void putDataFromXML(XMLReferanslar xml) {

		tctReferansAdiSoyadi.setText(xml.referans_adi_soyadi);

	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			tctReferansAdiSoyadi.setText("");
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
