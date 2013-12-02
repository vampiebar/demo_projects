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

public class DlgDBSSinavTanimla extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private ListBox cbxBinaSekli;
	private TextBox tctKota;
	private DateBox dtpSinavTarihi;
	private ListBox cbxOkulDurumu;
	private ListBox cbxAlan;

	public DlgDBSSinavTanimla(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("DBS Sınav Ekleme / Düzenleme");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("660px", "445px");

		Label lblDbsSnavIlemleri = new Label(
				"DBS Sınav İşlemleri (Ekleme / Düzenleme)");
		lblDbsSnavIlemleri.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblDbsSnavIlemleri, 0, 0);
		lblDbsSnavIlemleri.setSize("660px", "29px");

		Label lblOkulDurumu = new Label("Okul Durumu");
		lblOkulDurumu.setStyleName("gwt-Bold");
		absolutePanel.add(lblOkulDurumu, 10, 63);

		Label lblAlan = new Label("Alan");
		lblAlan.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlan, 10, 101);

		Label lblSnavTarihi = new Label("Sınav Tarihi");
		lblSnavTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblSnavTarihi, 10, 144);

		Label lblNewLabel = new Label("Kota ( Kişi)");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 185);

		Label lblBinaekli = new Label("Bina Şekli");
		lblBinaekli.setStyleName("gwt-Bold");
		absolutePanel.add(lblBinaekli, 10, 229);

		cbxOkulDurumu = new ListBox();
		cbxOkulDurumu.addItem("1. Sınıf");
		cbxOkulDurumu.addItem("2.. Sınıf");
		cbxOkulDurumu.addItem("3. Sınıf");
		cbxOkulDurumu.addItem("4. Sınıf");
		cbxOkulDurumu.addItem("5. Sınıf");
		cbxOkulDurumu.addItem("6. Sınıf");
		cbxOkulDurumu.addItem("7. Sınıf");
		cbxOkulDurumu.addItem("8. Sınıf");
		cbxOkulDurumu.addItem("9. Sınıf");
		cbxOkulDurumu.addItem("10. Sınıf");
		cbxOkulDurumu.addItem("11. Sınıf");
		cbxOkulDurumu.addItem("Lise Mezun");
		cbxOkulDurumu.addItem("Üniversite Mezun");
		cbxOkulDurumu.addItem("12. Sınıf");
		cbxOkulDurumu.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxOkulDurumu, 141, 63);
		cbxOkulDurumu.setSize("174px", "22px");

		cbxAlan = new ListBox();
		cbxAlan.addItem("ALAN YOK");
		cbxAlan.addItem("SAYISAL");
		cbxAlan.addItem("EŞİT AĞIRLIK");
		cbxAlan.addItem("SÖZEL");
		cbxAlan.addItem("DİL");
		cbxAlan.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxAlan, 141, 97);
		cbxAlan.setSize("174px", "22px");

		cbxBinaSekli = new ListBox();
		cbxBinaSekli.setStyleName("gwt-ComboBox1");
		cbxBinaSekli.addItem("Dershane Binası");
		cbxBinaSekli.addItem("Başka Bina");
		absolutePanel.add(cbxBinaSekli, 141, 225);
		cbxBinaSekli.setSize("174px", "22px");

		dtpSinavTarihi = new DateBox();
		dtpSinavTarihi.setStyleName("gwt-TextBox1");
		dtpSinavTarihi
				.addValueChangeHandler(new DtpSinavTarihiValueChangeHandler());
		dtpSinavTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		absolutePanel.add(dtpSinavTarihi, 141, 144);
		dtpSinavTarihi.setSize("172px", "14px");

		tctKota = new TextBox();
		tctKota.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctKota, 141, 185);
		tctKota.setSize("172px", "14px");

		Button btnKaydet = new Button("Kaydet");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 318, 288);
		btnKaydet.setSize("78px", "49px");

		Button btnKapat = new Button("Kapat");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel.add(btnKapat, 414, 288);
		btnKapat.setSize("78px", "49px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putdbssinavtanimla?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&okul_durumu="
					+ cbxOkulDurumu.getValue(cbxOkulDurumu.getSelectedIndex());
			URLValue = URLValue + "&alan="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&kota=" + tctKota.getText();
			URLValue = URLValue + "&bina_sekli="
					+ cbxBinaSekli.getValue(cbxBinaSekli.getSelectedIndex());

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&sinav_tarihi="
					+ dtf.format(dtpSinavTarihi.getValue());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "SINAV BİLGİSİ KAYIT EDİLDİ",
					"SINAV BİLGİSİ KAYIT EDİLEMEDİ");
		}
	}

	private class DtpSinavTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm");
			// Window.alert(dtf.format(dtpSinavTarihi.getValue()));

		}
	}

	public void putDataFromXML(XMLDBSSinavTanimla xml) {

		tctKota.setText(xml.kota);
		cbxAlan.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxAlan,
				xml.alan_bilgisi));
		cbxBinaSekli.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxBinaSekli, xml.bina_sekli));
		cbxOkulDurumu.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOkulDurumu, xml.okul_adi));

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
		dtpSinavTarihi.setValue(dtf.parse(xml.sinav_tarihi));

	}
}
