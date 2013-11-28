package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgGelirGiderTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private ListBox cbxKategoriAdi;
	private ListBox cbxTipi;
	private TextBox tctGelirGiderAdi;

	public DlgGelirGiderTanimlari(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Gelir / Gider Tanımı");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		setWidget(absolutePanel);
		absolutePanel.setSize("691px", "470px");

		Label lblGelirGider = new Label(
				"Gelir / Gider Tanımı ( Ekleme / Düzenleme ) ");
		lblGelirGider.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblGelirGider, 0, 0);
		lblGelirGider.setSize("691px", "28px");

		Label lblKategoriAdı = new Label("Kategori Adı");
		lblKategoriAdı.setStyleName("gwt-Bold");
		absolutePanel.add(lblKategoriAdı, 10, 46);
		lblKategoriAdı.setSize("78px", "18px");

		Label lblTipi = new Label("Tipi");
		lblTipi.setStyleName("gwt-Bold");
		absolutePanel.add(lblTipi, 10, 76);

		Label lblGelirGider_1 = new Label("Gelir / Gider Adı");
		lblGelirGider_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblGelirGider_1, 10, 106);

		cbxKategoriAdi = new ListBox();
		cbxKategoriAdi.addItem("Fatura");
		cbxKategoriAdi.addItem("Araç Gideri");
		cbxKategoriAdi.addItem("Bina Bakım Onarım Giderleri");
		cbxKategoriAdi.addItem("Demirbaş Giderleri");
		cbxKategoriAdi.addItem("Fatura Giderleri");
		cbxKategoriAdi.addItem("Kırtasiye Giderleri");
		cbxKategoriAdi.addItem("Muhtelif Giderler");
		cbxKategoriAdi.addItem("SGK - Vergi Giderleri");
		cbxKategoriAdi.addItem("Temizlik Giderleri");
		cbxKategoriAdi.addItem("Yayın Giderleri");
		cbxKategoriAdi.addItem("Mutfak Gideri");
		cbxKategoriAdi.addItem("Öğrenci Dışı Gelirler");
		cbxKategoriAdi.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxKategoriAdi, 136, 46);
		cbxKategoriAdi.setSize("158px", "22px");

		cbxTipi = new ListBox();
		cbxTipi.addItem("Gelir");
		cbxTipi.addItem("Gider");
		cbxTipi.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxTipi, 136, 72);
		cbxTipi.setSize("158px", "22px");

		tctGelirGiderAdi = new TextBox();
		tctGelirGiderAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctGelirGiderAdi, 136, 110);
		tctGelirGiderAdi.setSize("156px", "14px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 435, 164);
		btnKaydet.setSize("78px", "48px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 539, 164);
		btnKapat.setSize("78px", "48px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putgelirgidertanimlari?";
			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue
					+ "&kategori_adi="
					+ cbxKategoriAdi
							.getValue(cbxKategoriAdi.getSelectedIndex());
			URLValue = URLValue + "&tipi="
					+ cbxTipi.getValue(cbxTipi.getSelectedIndex());
			URLValue = URLValue + "&gelir_gider_adi="
					+ tctGelirGiderAdi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLGelirGiderTanimlari xml) {
		tctGelirGiderAdi.setText(xml.gelir_gider_adi);
		cbxKategoriAdi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxKategoriAdi, xml.kategori_adi));
		cbxTipi.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxTipi, xml.tipi));

	}
}
