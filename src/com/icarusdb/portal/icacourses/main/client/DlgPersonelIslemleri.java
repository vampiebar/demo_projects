package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
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
	private Button btnKaydet;
	private Image image;
	private Image image_1;

	public DlgPersonelIslemleri(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Personel İşlemleri ");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("587px", "400px");

		Button btnYenikayit = new Button("New button");
		btnYenikayit.addClickHandler(new BtnYenikayitClickHandler());
		btnYenikayit.setStyleName("gwt-ButonYeniKayit");
		btnYenikayit.setText("");
		absolutePanel.add(btnYenikayit, 303, 165);
		btnYenikayit.setSize("84px", "66px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 368, 96);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 467, 96);
		btnKapat.setSize("78px", "45px");

		image = new Image("kaydet-1.png");
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 396, 165);

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 474, 165);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("302px", "87px");

		Label lblAd = new Label("Adı Soyadı");
		flexTable.setWidget(0, 0, lblAd);
		lblAd.setStyleName("gwt-Bold");

		tctAdiSoyadi = new TextBox();
		tctAdiSoyadi.setMaxLength(30);
		flexTable.setWidget(0, 1, tctAdiSoyadi);
		tctAdiSoyadi.setStyleName("gwt-TextBox1");
		tctAdiSoyadi.setSize("151px", "14px");

		Label lblGorevi = new Label("Görevi");
		flexTable.setWidget(1, 0, lblGorevi);
		lblGorevi.setStyleName("gwt-Bold");

		tctGorevi = new TextBox();
		tctGorevi.setMaxLength(30);
		flexTable.setWidget(1, 1, tctGorevi);
		tctGorevi.setStyleName("gwt-TextBox1");
		tctGorevi.setSize("151px", "14px");

		Label lblIeGiriTarihi = new Label("İşe Giriş Tarihi");
		flexTable.setWidget(2, 0, lblIeGiriTarihi);
		lblIeGiriTarihi.setStyleName("gwt-Bold");

		dtpIseGirisTarihi = new DateBox();
		flexTable.setWidget(2, 1, dtpIseGirisTarihi);
		dtpIseGirisTarihi.setStyleName("gwt-TextBox1");
		dtpIseGirisTarihi
				.addValueChangeHandler(new DtpIseGirisTarihiValueChangeHandler());
		dtpIseGirisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		dtpIseGirisTarihi.setSize("151px", "14px");

		Label lblcreti = new Label("Ücreti");
		flexTable.setWidget(3, 0, lblcreti);
		lblcreti.setStyleName("gwt-Bold");

		tctUcreti = new TextBox();
		tctUcreti.addKeyPressHandler(new TctUcretiKeyPressHandler());
		flexTable.setWidget(3, 1, tctUcreti);
		tctUcreti.setStyleName("gwt-TextBox1");
		tctUcreti.setSize("151px", "14px");

		Label lblTelefonu = new Label("Telefonu 1");
		flexTable.setWidget(4, 0, lblTelefonu);
		lblTelefonu.setStyleName("gwt-Bold");
		lblTelefonu.setSize("84px", "18px");

		tctTelefonu1 = new TextBox();
		tctTelefonu1.addKeyPressHandler(new TctTelefonu1KeyPressHandler());
		tctTelefonu1.setMaxLength(11);
		flexTable.setWidget(4, 1, tctTelefonu1);
		tctTelefonu1.setStyleName("gwt-TextBox1");
		tctTelefonu1.setSize("151px", "14px");

		Label lblTelefonu_1 = new Label("Telefonu 2");
		flexTable.setWidget(5, 0, lblTelefonu_1);
		lblTelefonu_1.setStyleName("gwt-Bold");
		lblTelefonu_1.setSize("84px", "18px");

		tctTelefonu2 = new TextBox();
		tctTelefonu2.addKeyPressHandler(new TctTelefonu2KeyPressHandler());
		tctTelefonu2.setMaxLength(11);
		flexTable.setWidget(5, 1, tctTelefonu2);
		tctTelefonu2.setStyleName("gwt-TextBox1");
		tctTelefonu2.setSize("151px", "14px");
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
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

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

	private class BtnYenikayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			tctAdiSoyadi.setText("");
			tctGorevi.setText("");
			tctTelefonu1.setText("");
			tctTelefonu2.setText("");
			tctUcreti.setText("");
			dtpIseGirisTarihi.setValue(null);

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

	private class TctTelefonu2KeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctTelefonu2.getText();
			if (!input.matches("[0-9]*")) {
				tctTelefonu2.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctTelefonu2.setStyleName("gwt-TextBox1");

		}
	}

	private class TctUcretiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctUcreti.getText();
			if (!input.matches("[0-9]*")) {
				tctUcreti.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctUcreti.setStyleName("gwt-TextBox1");

		}
	}

	private class TctTelefonu1KeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctTelefonu1.getText();
			if (!input.matches("[0-9]*")) {
				tctTelefonu1.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctTelefonu1.setStyleName("gwt-TextBox1");

		}
	}
}
