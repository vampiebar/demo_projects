package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgSablonTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctSablonAdi;
	private ListBox cbxSinavTuru;

	public DlgSablonTanimlari(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Dönem Ekle/Değiştir");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("744px", "619px");

		Label lblNewLabel = new Label(
				"Form Şablonu Tanımlama (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("744px", "28px");

		Label lblablonAd = new Label("Şablon Adı");
		lblablonAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblablonAd, 10, 46);

		tctSablonAdi = new TextBox();
		tctSablonAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSablonAdi, 130, 44);
		tctSablonAdi.setSize("149px", "16px");

		Label lblNewLabel_3 = new Label("Parametreler");
		lblNewLabel_3.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel_3, 0, 84);
		lblNewLabel_3.setSize("744px", "29px");

		Button btnParametreDegeriEkle = new Button("Parametre Değeri Ekle");
		absolutePanel.add(btnParametreDegeriEkle, 10, 119);
		btnParametreDegeriEkle.setSize("169px", "22px");

		Button btnSablonuKaydet = new Button("New button");
		btnSablonuKaydet.setStyleName("gwt-ButtonSave");
		btnSablonuKaydet.addClickHandler(new BtnSablonuKaydetClickHandler());
		btnSablonuKaydet.setText("Şablonu Kaydet");
		absolutePanel.add(btnSablonuKaydet, 439, 374);
		btnSablonuKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 546, 374);
		btnKapat.setSize("78px", "45px");

		Label lblNewLabel_4 = new Label("Gruplar");
		lblNewLabel_4.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel_4, 0, 154);
		lblNewLabel_4.setSize("744px", "30px");

		Label lblSnavTr = new Label("Sınav Türü");
		lblSnavTr.setStyleName("gwt-Bold");
		absolutePanel.add(lblSnavTr, 10, 201);

		cbxSinavTuru = new ListBox();
		cbxSinavTuru.setStyleName("gwt-ComboBox1");
		cbxSinavTuru.addItem("Lütfen Seçiniz");
		absolutePanel.add(cbxSinavTuru, 102, 195);
		cbxSinavTuru.setSize("139px", "22px");

		Button btnSinavaAitBilgileriYukle = new Button("New button");
		btnSinavaAitBilgileriYukle.setText("Sınava Ait Bilgileri Yükle");
		absolutePanel.add(btnSinavaAitBilgileriYukle, 260, 193);
		btnSinavaAitBilgileriYukle.setSize("186px", "23px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnSablonuKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putsablontanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&sablon_adi=" + tctSablonAdi.getText();
			URLValue = URLValue + "&sinav_turu="
					+ cbxSinavTuru.getValue(cbxSinavTuru.getSelectedIndex());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLSablonTanimlari xml) {
		tctSablonAdi.setText(xml.sablon_adi);
		cbxSinavTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxSinavTuru, xml.sinav_turu));

	}
}
