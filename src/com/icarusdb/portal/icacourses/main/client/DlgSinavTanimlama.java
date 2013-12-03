package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgSinavTanimlama extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private Button btnKaydet;
	private Button btnKapat;
	private TextBox tctSinavNo;
	private TextBox tctSinavAdi;
	private DateBox dtpTarih;
	private TextBox tctSOnKitapcikNo;
	private ListBox cbxSablonSeciniz;

	public DlgSinavTanimlama(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Dönem  Ekle / Değiştir");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("541px", "409px");

		Label label = new Label("Sınav No - Sınav Adı");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 10, 41);
		label.setSize("149px", "18px");

		Label label_1 = new Label("Tarih");
		label_1.setStyleName("gwt-Bold");
		absolutePanel.add(label_1, 10, 75);
		label_1.setSize("50px", "18px");

		Label label_2 = new Label("Son Kitapçık No");
		label_2.setStyleName("gwt-Bold");
		absolutePanel.add(label_2, 10, 107);
		label_2.setSize("104px", "18px");

		Label label_3 = new Label("Şablon Seçiniz");
		label_3.setStyleName("gwt-Bold");
		absolutePanel.add(label_3, 10, 147);
		label_3.setSize("104px", "18px");

		tctSinavNo = new TextBox();
		tctSinavNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSinavNo, 165, 41);
		tctSinavNo.setSize("152px", "14px");

		tctSinavAdi = new TextBox();
		tctSinavAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSinavAdi, 345, 41);
		tctSinavAdi.setSize("143px", "14px");

		Label label_4 = new Label("-");
		absolutePanel.add(label_4, 325, 41);
		label_4.setSize("14px", "18px");

		dtpTarih = new DateBox();
		dtpTarih.setStyleName("gwt-TextBox1");
		dtpTarih.addValueChangeHandler(new DtpTarihValueChangeHandler());
		dtpTarih.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd HH:mm")));
		absolutePanel.add(dtpTarih, 165, 75);
		dtpTarih.setSize("152px", "14px");

		tctSOnKitapcikNo = new TextBox();
		tctSOnKitapcikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSOnKitapcikNo, 165, 107);
		tctSOnKitapcikNo.setSize("152px", "14px");

		cbxSablonSeciniz = new ListBox();
		cbxSablonSeciniz.setStyleName("gwt-ComboBox1");
		cbxSablonSeciniz.addItem("1");
		cbxSablonSeciniz.addItem("a");
		absolutePanel.add(cbxSablonSeciniz, 165, 147);
		cbxSablonSeciniz.setSize("147px", "23px");

		btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 295, 239);
		btnKaydet.setSize("78px", "50px");

		btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 401, 239);
		btnKapat.setSize("78px", "50px");

		Label lblNewLabel = new Label("Sınav Tanımlama (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("541px", "28px");

	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putsinavtanimlama?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&sinav_no=" + tctSinavNo.getText();
			URLValue = URLValue + "&sinav_adi=" + tctSinavAdi.getText();
			URLValue = URLValue + "&son_kitapcik_no="
					+ tctSOnKitapcikNo.getText();
			URLValue = URLValue
					+ "&sablon_seciniz="
					+ cbxSablonSeciniz.getValue(cbxSablonSeciniz
							.getSelectedIndex());

			DateTimeFormat dtf = DateTimeFormat
					.getFormat("yyyy-MM-dd HH:mm:ss");

			URLValue = URLValue + "&tarih=" + dtf.format(dtpTarih.getValue());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	private class DtpTarihValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat
					.getFormat("yyyy-MM-dd HH:mm:ss");
			// Window.alert(dtf.format(dtpTarih.getValue()));
		}
	}

	public void putDataFromXML(XMLSinavTanimlama xml) {
		tctSinavAdi.setText(xml.sinav_adi);
		tctSinavNo.setText(xml.sinav_no);
		tctSOnKitapcikNo.setText(xml.son_kitapcik_no);
		cbxSablonSeciniz.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxSablonSeciniz, xml.sablon_seciniz));

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");

		dtpTarih.setValue(dtf.parse(xml.tarih));

	}
}
