package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgEgitimTuruTanimlama extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctEgitimTuruAdi;
	private TextBox tctAlanAdi;
	private Button btnKaydet;

	public DlgEgitimTuruTanimlama(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Eğitim Türü İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		setWidget(absolutePanel);
		absolutePanel.setSize("483px", "367px");

		Label lblEitimTrIlemleri = new Label(
				"Eğitim Türü İşlemleri (Ekleme / Düzenleme");
		lblEitimTrIlemleri.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblEitimTrIlemleri, 0, 0);
		lblEitimTrIlemleri.setSize("100%", "25px");

		Label lblNewLabel = new Label("Eğitim Türü Adı");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 57);
		lblNewLabel.setSize("112px", "18px");

		tctEgitimTuruAdi = new TextBox();
		tctEgitimTuruAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEgitimTuruAdi, 128, 53);
		tctEgitimTuruAdi.setSize("143px", "18px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		btnKapat.setStyleName("gwt-ButonKapat");
		absolutePanel.add(btnKapat, 313, 232);
		btnKapat.setSize("78px", "45px");

		Label lblAlanAd = new Label("Alan Adı");
		lblAlanAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlanAd, 10, 96);
		lblAlanAd.setSize("64px", "16px");

		tctAlanAdi = new TextBox();
		tctAlanAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAlanAdi, 128, 90);
		tctAlanAdi.setSize("143px", "18px");

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnKaydet, 216, 232);
		btnKaydet.setSize("78px", "45px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 205, 129);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 293, 129);
		image_1.setSize("72px", "66px");
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
}
