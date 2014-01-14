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

public class DlgDonemTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctDonemAdi;
	private DateBox dtpBaslangicTarihi;
	private DateBox dtpBitisTarihi;
	private ListBox cbxVarsayilanDonem;

	public DlgDonemTanimlari(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Dönem Ekle / Değiştir");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("573px", "427px");

		Label lblNewLabel = new Label("Dönem İşlemleri (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("573px", "28px");

		Label lblDnemAd = new Label("Dönem Adı");
		lblDnemAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblDnemAd, 10, 48);

		Label lblDnemBalangTarihi = new Label("Dönem Başlangıç Tarihi\t");
		lblDnemBalangTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblDnemBalangTarihi, 10, 83);

		Label lblDnemBitiTarihi = new Label("Dönem Bitiş Tarihi\t");
		lblDnemBitiTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblDnemBitiTarihi, 10, 119);

		Label lblVarsaylanDnem = new Label("Varsayılan Dönem");
		lblVarsaylanDnem.setStyleName("gwt-Bold");
		absolutePanel.add(lblVarsaylanDnem, 10, 160);

		tctDonemAdi = new TextBox();
		tctDonemAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctDonemAdi, 186, 48);
		tctDonemAdi.setSize("147px", "15px");

		dtpBaslangicTarihi = new DateBox();
		dtpBaslangicTarihi.setStyleName("gwt-TextBox1");
		dtpBaslangicTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpBaslangicTarihi
				.addValueChangeHandler(new DtpDonemBaslangicTarihiValueChangeHandler());
		absolutePanel.add(dtpBaslangicTarihi, 186, 83);
		dtpBaslangicTarihi.setSize("147px", "15px");

		dtpBitisTarihi = new DateBox();
		dtpBitisTarihi.setStyleName("gwt-TextBox1");
		dtpBitisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpBitisTarihi
				.addValueChangeHandler(new DtpDonemBitisTarihiValueChangeHandler());
		absolutePanel.add(dtpBitisTarihi, 186, 119);
		dtpBitisTarihi.setSize("147px", "15px");

		cbxVarsayilanDonem = new ListBox();
		cbxVarsayilanDonem.setStyleName("gwt-ComboBox1");
		cbxVarsayilanDonem.addItem("Varsayılan Dönem");
		cbxVarsayilanDonem.addItem("Normal Dönem");
		absolutePanel.add(cbxVarsayilanDonem, 186, 160);
		cbxVarsayilanDonem.setSize("147px", "22px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 327, 204);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 411, 204);
		btnKapat.setSize("78px", "45px");
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
}
