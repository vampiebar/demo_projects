package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgDonemTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctDonemAdi;
	private DateBox dtpBaslangicTarihi;
	private DateBox dtpBitisTarihi;
	private ListBox cbxVarsayilanDonem;
	private Image image;
	private Button btnKaydet;
	private Image image_1;

	public DlgDonemTanimlari(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Dönem Ekle / Değiştir");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("558px", "399px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 342, 249);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 426, 249);
		btnKapat.setSize("78px", "45px");

		image = new Image("kaydet-1.png");
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addClickHandler(new ImgKaydetClickHandler());
		absolutePanel.add(image, 342, 159);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 426, 159);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("348px", "89px");

		Label lblDnemAd = new Label("Dönem Adı");
		flexTable.setWidget(0, 0, lblDnemAd);
		lblDnemAd.setStyleName("gwt-Bold");

		tctDonemAdi = new TextBox();
		flexTable.setWidget(0, 1, tctDonemAdi);
		tctDonemAdi.setStyleName("gwt-TextBox1");
		tctDonemAdi.setSize("147px", "15px");

		Label lblDnemBalangTarihi = new Label("Dönem Başlangıç Tarihi\t");
		flexTable.setWidget(1, 0, lblDnemBalangTarihi);
		lblDnemBalangTarihi.setStyleName("gwt-Bold");

		dtpBaslangicTarihi = new DateBox();
		flexTable.setWidget(1, 1, dtpBaslangicTarihi);
		dtpBaslangicTarihi.setStyleName("gwt-TextBox1");
		dtpBaslangicTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpBaslangicTarihi
				.addValueChangeHandler(new DtpDonemBaslangicTarihiValueChangeHandler());
		dtpBaslangicTarihi.setSize("147px", "15px");

		Label lblDnemBitiTarihi = new Label("Dönem Bitiş Tarihi\t");
		flexTable.setWidget(2, 0, lblDnemBitiTarihi);
		lblDnemBitiTarihi.setStyleName("gwt-Bold");

		dtpBitisTarihi = new DateBox();
		flexTable.setWidget(2, 1, dtpBitisTarihi);
		dtpBitisTarihi.setStyleName("gwt-TextBox1");
		dtpBitisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpBitisTarihi
				.addValueChangeHandler(new DtpDonemBitisTarihiValueChangeHandler());
		dtpBitisTarihi.setSize("147px", "15px");

		Label lblVarsaylanDnem = new Label("Varsayılan Dönem");
		flexTable.setWidget(3, 0, lblVarsaylanDnem);
		lblVarsaylanDnem.setStyleName("gwt-Bold");

		cbxVarsayilanDonem = new ListBox();
		flexTable.setWidget(3, 1, cbxVarsayilanDonem);
		cbxVarsayilanDonem.setStyleName("gwt-ComboBox1");
		cbxVarsayilanDonem.addItem("Varsayılan Dönem");
		cbxVarsayilanDonem.addItem("Normal Dönem");
		cbxVarsayilanDonem.setSize("148px", "22px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putdonemtanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&donem_adi=" + tctDonemAdi.getText();
			URLValue = URLValue
					+ "&varsayilan_donem="
					+ cbxVarsayilanDonem.getValue(cbxVarsayilanDonem
							.getSelectedIndex());
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&baslangic_tarihi="
					+ dtf.format(dtpBaslangicTarihi.getValue());
			URLValue = URLValue + "&bitis_tarihi="
					+ dtf.format(dtpBitisTarihi.getValue());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "DÖNEM BİLGİSİ KAYIT EDİLDİ",
					"DÖNEM BİLGİSİ KAYIT EDİLEMEDİ");
		}
	}

	private class DtpDonemBaslangicTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
			// Window.alert(dtf.format(dtpDonemBaslangicTarihi.getValue()));
		}
	}

	private class DtpDonemBitisTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
			// Window.alert(dtf.format(dtpDonemBitisTarihi.getValue()));
		}
	}

	public void putDataFromXML(XMLDonemTanimlari xml) {

		tctDonemAdi.setText(xml.donem_adi);
		cbxVarsayilanDonem.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxVarsayilanDonem, xml.varsayilan_donem));
		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

		dtpBaslangicTarihi.setValue(dtf.parse(xml.baslangic_tarihi));
		dtpBitisTarihi.setValue(dtf.parse(xml.bitis_tarihi));

	}

	private class ImgKaydetClickHandler implements ClickHandler {
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
}
