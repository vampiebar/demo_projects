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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgPersonelIslemleri extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctAdiSoyadi;
	private TextBox tctGorevi;
	private DateBox dtpIseGirisTarihi;
	private TextBox tctUcreti;
	private TextBox tctTelefonu1;
	private TextBox tctTelefonu2;

	public DlgPersonelIslemleri(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Personel İşlemleri ");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("621px", "493px");

		Label lblNewLabel = new Label("Personel İşlemleri (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("621px", "28px");

		Label lblAd = new Label("Adı Soyadı");
		lblAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblAd, 10, 46);

		Label lblGorevi = new Label("Görevi");
		lblGorevi.setStyleName("gwt-Bold");
		absolutePanel.add(lblGorevi, 10, 81);

		Label lblIeGiriTarihi = new Label("İşe Giriş Tarihi");
		lblIeGiriTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblIeGiriTarihi, 10, 121);

		Label lblcreti = new Label("Ücreti");
		lblcreti.setStyleName("gwt-Bold");
		absolutePanel.add(lblcreti, 10, 158);

		Label lblTelefonu = new Label("Telefonu 1");
		lblTelefonu.setStyleName("gwt-Bold");
		absolutePanel.add(lblTelefonu, 10, 194);
		lblTelefonu.setSize("69px", "18px");

		Label lblTelefonu_1 = new Label("Telefonu 2");
		lblTelefonu_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblTelefonu_1, 10, 229);
		lblTelefonu_1.setSize("63px", "18px");

		tctAdiSoyadi = new TextBox();
		tctAdiSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAdiSoyadi, 130, 42);
		tctAdiSoyadi.setSize("151px", "14px");

		tctGorevi = new TextBox();
		tctGorevi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctGorevi, 130, 81);
		tctGorevi.setSize("151px", "14px");

		tctUcreti = new TextBox();
		tctUcreti.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctUcreti, 130, 158);
		tctUcreti.setSize("151px", "14px");

		tctTelefonu1 = new TextBox();
		tctTelefonu1.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctTelefonu1, 130, 194);
		tctTelefonu1.setSize("151px", "14px");

		tctTelefonu2 = new TextBox();
		tctTelefonu2.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctTelefonu2, 130, 229);
		tctTelefonu2.setSize("151px", "14px");

		dtpIseGirisTarihi = new DateBox();
		dtpIseGirisTarihi.setStyleName("gwt-TextBox1");
		dtpIseGirisTarihi
				.addValueChangeHandler(new DtpIseGirisTarihiValueChangeHandler());
		dtpIseGirisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		absolutePanel.add(dtpIseGirisTarihi, 130, 121);
		dtpIseGirisTarihi.setSize("151px", "14px");

		Button btnYenikayit = new Button("New button");
		btnYenikayit.setStyleName("gwt-ButonYeniKayit");
		btnYenikayit.setText("Yeni Kayıt");
		absolutePanel.add(btnYenikayit, 304, 281);
		btnYenikayit.setSize("78px", "45px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 388, 281);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 472, 281);
		btnKapat.setSize("78px", "45px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putpersoneltanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&adi_soyadi=" + tctAdiSoyadi.getText();
			URLValue = URLValue + "&gorevi=" + tctGorevi.getText();
			URLValue = URLValue + "&ucreti=" + tctUcreti.getText();
			URLValue = URLValue + "&telefonu_1=" + tctTelefonu1.getText();
			URLValue = URLValue + "&telefonu_2=" + tctTelefonu2.getText();

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&ise_giris_tarihi="
					+ dtf.format(dtpIseGirisTarihi.getValue());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "Personel Kaydı Başarılı",
					"Personel Kaydı Yapılamadı");

		}
	}

	private class DtpIseGirisTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
			// Window.alert(dtf.format(dtpIseGirisTarihi.getValue()));
		}
	}

	public void putDataFromXML(XMLPersonelTanimlari xml) {
		tctAdiSoyadi.setText(xml.adi_soyadi);
		tctGorevi.setText(xml.gorevi);
		tctTelefonu1.setText(xml.telefonu_1);
		tctTelefonu2.setText(xml.telefonu_2);
		tctUcreti.setText(xml.ucreti);

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
		dtpIseGirisTarihi.setValue(dtf.parse(xml.ise_giris_tarihi));

	}
}
