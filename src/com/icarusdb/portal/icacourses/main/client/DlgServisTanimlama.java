package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgServisTanimlama extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private Button btnKaydet;
	private TextBox tctKodu;
	private TextBox tctSoforunTelefonu;
	private TextBox tctSoforAdi;
	private TextBox tctGuzergah;
	private TextBox tctServisUcreti;
	private TextBox tctAracSahibi;
	private TextBox tctAracSahibininTelefonu;
	private TextBox tctYolcuSayisi;
	private TextBox tctKapasitesi;
	private TextBox tctAracPlakası;

	public DlgServisTanimlama(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setGlassEnabled(true);
		setHTML("Servis Tanimlama");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("513px", "442px");

		Label lblNewLabel = new Label("Kodu");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 30);
		lblNewLabel.setSize("97px", "18px");

		Label lblNewLabel_1 = new Label("Güzergah");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 10, 60);
		lblNewLabel_1.setSize("97px", "18px");

		Label lblServiscreti = new Label("Servis Ücreti");
		lblServiscreti.setStyleName("gwt-Bold");
		absolutePanel.add(lblServiscreti, 10, 90);
		lblServiscreti.setSize("97px", "18px");

		Label lblNewLabel_2 = new Label("Şöför Adı");
		lblNewLabel_2.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_2, 10, 120);
		lblNewLabel_2.setSize("97px", "18px");

		Label lblNewLabel_3 = new Label("Telefonu");
		lblNewLabel_3.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_3, 10, 150);
		lblNewLabel_3.setSize("97px", "18px");

		Label lblNewLabel_4 = new Label("Araç Sahibi");
		lblNewLabel_4.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_4, 10, 180);
		lblNewLabel_4.setSize("97px", "18px");

		Label lblNewLabel_5 = new Label("Telefonu");
		lblNewLabel_5.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_5, 10, 210);
		lblNewLabel_5.setSize("97px", "18px");

		Label lblNewLabel_6 = new Label("Araç Plakası");
		lblNewLabel_6.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_6, 10, 240);
		lblNewLabel_6.setSize("97px", "18px");

		Label lblNewLabel_7 = new Label("Kapasitesi");
		lblNewLabel_7.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_7, 10, 270);
		lblNewLabel_7.setSize("97px", "16px");

		Label lblNewLabel_8 = new Label("Yolcu Sayısı");
		lblNewLabel_8.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_8, 10, 300);
		lblNewLabel_8.setSize("97px", "18px");

		tctKodu = new TextBox();
		tctKodu.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctKodu, 126, 29);
		tctKodu.setSize("168px", "15px");

		tctGuzergah = new TextBox();
		tctGuzergah.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctGuzergah, 126, 59);
		tctGuzergah.setSize("168px", "15px");

		tctServisUcreti = new TextBox();
		tctServisUcreti.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctServisUcreti, 126, 89);
		tctServisUcreti.setSize("168px", "15px");

		tctAracSahibi = new TextBox();
		tctAracSahibi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAracSahibi, 126, 179);
		tctAracSahibi.setSize("168px", "15px");

		tctSoforunTelefonu = new TextBox();
		tctSoforunTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSoforunTelefonu, 126, 149);
		tctSoforunTelefonu.setSize("168px", "15px");

		tctSoforAdi = new TextBox();
		tctSoforAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSoforAdi, 126, 119);
		tctSoforAdi.setSize("168px", "15px");

		tctYolcuSayisi = new TextBox();
		tctYolcuSayisi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctYolcuSayisi, 126, 299);
		tctYolcuSayisi.setSize("168px", "15px");

		tctKapasitesi = new TextBox();
		tctKapasitesi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctKapasitesi, 126, 269);
		tctKapasitesi.setSize("168px", "15px");

		tctAracPlakası = new TextBox();
		tctAracPlakası.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAracPlakası, 126, 239);
		tctAracPlakası.setSize("168px", "15px");

		tctAracSahibininTelefonu = new TextBox();
		tctAracSahibininTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAracSahibininTelefonu, 126, 209);
		tctAracSahibininTelefonu.setSize("168px", "15px");

		Button btnNewButton = new Button("New button");
		btnNewButton.setVisible(false);
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		btnNewButton.setStyleName("gwt-ButonKapat");
		btnNewButton.setText("");
		absolutePanel.add(btnNewButton, 397, 273);
		btnNewButton.setSize("78px", "46px");

		btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.setVisible(false);
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());

		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 305, 270);
		btnKaydet.setSize("78px", "49px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 217, 336);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 305, 336);
		image_1.setSize("72px", "66px");
	}

	private class BtnNewButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putservistanimlama?";
			URLValue = URLValue + "id=" + _id;

			URLValue = URLValue + "&kodu=" + tctKodu.getText();
			URLValue = URLValue + "&guzergah=" + tctGuzergah.getText();
			URLValue = URLValue + "&servis_ucreti=" + tctServisUcreti.getText();
			URLValue = URLValue + "&sofor_adi=" + tctSoforAdi.getText();
			URLValue = URLValue + "&soforun_telefonu="
					+ tctAracSahibininTelefonu.getText();
			URLValue = URLValue + "&arac_sahibi=" + tctAracSahibi.getText();
			URLValue = URLValue + "&arac_sahibinin_telefonu="
					+ tctAracSahibininTelefonu.getText();
			URLValue = URLValue + "&arac_plakasi=" + tctAracPlakası.getText();
			URLValue = URLValue + "&kapasitesi=" + tctKapasitesi.getText();
			URLValue = URLValue + "&yolcu_sayisi=" + tctYolcuSayisi.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	public void putDataFromXML(XMLServisTanimlama xml) {
		tctKodu.setText(xml.kodu);
		tctGuzergah.setText(xml.guzergah);
		tctServisUcreti.setText(xml.servis_ucreti);
		tctSoforAdi.setText(xml.sofor_adi);
		tctSoforunTelefonu.setText(xml.soforun_telefonu);
		tctAracSahibi.setText(xml.arac_sahibi);
		tctAracSahibininTelefonu.setText(xml.arac_sahibinin_telefonu);
		tctAracPlakası.setText(xml.arac_plakasi);
		tctKapasitesi.setText(xml.kapasitesi);
		tctYolcuSayisi.setText(xml.yolcu_sayisi);

	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKaydet.click();
		}
	}
}
