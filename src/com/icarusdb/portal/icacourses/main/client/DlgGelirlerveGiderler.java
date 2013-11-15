package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgGelirlerveGiderler extends DialogBox {
	private LongBox tctAciklama;
	private DateBox dtpTarih;
	private TextBox tctMiktar;
	private ListBox cbxCek;
	private ListBox cbxBanka;
	private ListBox cbxOdemeTuru;
	private ListBox cbxGelirler;
	private ListBox cbxKategoriler;
	private ListBox cbxİslemTipi;
	private DateBox dtpVadeTarihi;

	public DlgGelirlerveGiderler() {
		setHTML("Gelir / Gider İşlemleri ( Ekleme / Düzenleme )");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("632px", "512px");

		Label lblNewLabel = new Label(
				"Gelir / Gider Giriş İşlemleri ( Ekleme / Düzenleme )");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("525px", "28px");

		Label lblIlemTipi = new Label("İşlem Tipi");
		lblIlemTipi.setStyleName("gwt-Bold");
		absolutePanel.add(lblIlemTipi, 10, 46);

		Label lblNewLabel_1 = new Label("Kategoriler");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 10, 84);

		Label lblGelirler = new Label("Gelirler");
		lblGelirler.setStyleName("gwt-Bold");
		absolutePanel.add(lblGelirler, 10, 127);

		Label lbldemeTr = new Label("Ödeme Türü");
		lbldemeTr.setStyleName("gwt-Bold");
		absolutePanel.add(lbldemeTr, 10, 168);

		Label lblBanka = new Label("Banka");
		lblBanka.setStyleName("gwt-Bold");
		absolutePanel.add(lblBanka, 10, 203);

		Label lblekVade = new Label("Çek - Vade Tarihi");
		lblekVade.setStyleName("gwt-Bold");
		absolutePanel.add(lblekVade, 10, 242);

		Label lblMiktar = new Label("Miktar");
		lblMiktar.setStyleName("gwt-Bold");
		absolutePanel.add(lblMiktar, 10, 275);

		Label lblTarijh = new Label("Tarih");
		lblTarijh.setStyleName("gwt-Bold");
		absolutePanel.add(lblTarijh, 10, 312);

		Label lblAklama = new Label("Açıklama");
		lblAklama.setStyleName("gwt-Bold");
		absolutePanel.add(lblAklama, 10, 349);

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 371, 402);
		btnKaydet.setSize("78px", "46px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 481, 402);
		btnKapat.setSize("78px", "46px");

		cbxİslemTipi = new ListBox();
		cbxİslemTipi.setStyleName("gwt-ComboBox1");
		cbxİslemTipi.addItem("Gelir");
		cbxİslemTipi.addItem("Gider");
		absolutePanel.add(cbxİslemTipi, 155, 42);
		cbxİslemTipi.setSize("157px", "22px");

		cbxKategoriler = new ListBox();
		cbxKategoriler.setStyleName("gwt-ComboBox1");
		cbxKategoriler.addItem(" ");
		cbxKategoriler.addItem("1");
		cbxKategoriler.addItem("2");
		absolutePanel.add(cbxKategoriler, 155, 80);
		cbxKategoriler.setSize("278px", "22px");

		cbxGelirler = new ListBox();
		cbxGelirler.setStyleName("gwt-ComboBox1");
		cbxGelirler.addItem(" 1");
		cbxGelirler.addItem("2");
		absolutePanel.add(cbxGelirler, 155, 123);
		cbxGelirler.setSize("278px", "22px");

		cbxOdemeTuru = new ListBox();
		cbxOdemeTuru.setStyleName("gwt-ComboBox1");
		cbxOdemeTuru.addItem(" 1");
		cbxOdemeTuru.addItem("2");
		absolutePanel.add(cbxOdemeTuru, 155, 164);
		cbxOdemeTuru.setSize("157px", "22px");

		cbxBanka = new ListBox();
		cbxBanka.setStyleName("gwt-ComboBox1");
		cbxBanka.addItem(" a");
		cbxBanka.addItem("b");
		absolutePanel.add(cbxBanka, 155, 199);
		cbxBanka.setSize("157px", "22px");

		cbxCek = new ListBox();
		cbxCek.setStyleName("gwt-ComboBox1");
		cbxCek.addItem(" 1");
		cbxCek.addItem("1");
		cbxCek.addItem("3");
		absolutePanel.add(cbxCek, 155, 238);
		cbxCek.setSize("278px", "22px");

		dtpVadeTarihi = new DateBox();
		dtpVadeTarihi.setStyleName("gwt-TextBox1");
		dtpVadeTarihi
				.addValueChangeHandler(new DtpVadeTarihiValueChangeHandler());
		dtpVadeTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		absolutePanel.add(dtpVadeTarihi, 447, 238);
		dtpVadeTarihi.setSize("127px", "16px");

		tctMiktar = new TextBox();
		tctMiktar.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctMiktar, 155, 275);
		tctMiktar.setSize("136px", "14px");

		dtpTarih = new DateBox();
		dtpTarih.setStyleName("gwt-TextBox1");
		dtpTarih.addValueChangeHandler(new DtpTarihValueChangeHandler());
		dtpTarih.setFormat(new DefaultFormat(DateTimeFormat
				.getShortDateTimeFormat()));
		absolutePanel.add(dtpTarih, 155, 308);
		dtpTarih.setSize("136px", "16px");

		tctAciklama = new LongBox();
		tctAciklama.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAciklama, 155, 349);
		tctAciklama.setSize("188px", "48px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putgelirlervegiderler?";
			URLValue = URLValue + "islem_tipi="
					+ cbxİslemTipi.getValue(cbxİslemTipi.getSelectedIndex());

			URLValue = URLValue
					+ "&kategoriler="
					+ cbxKategoriler
							.getValue(cbxKategoriler.getSelectedIndex());
			URLValue = URLValue + "&gelirler="
					+ cbxGelirler.getValue(cbxGelirler.getSelectedIndex());
			URLValue = URLValue + "&odeme_turu="
					+ cbxOdemeTuru.getValue(cbxOdemeTuru.getSelectedIndex());
			URLValue = URLValue + "&banka="
					+ cbxBanka.getValue(cbxBanka.getSelectedIndex());
			URLValue = URLValue + "&cek="
					+ cbxCek.getValue(cbxCek.getSelectedIndex());
			URLValue = URLValue + "&miktar=" + tctMiktar.getText();
			URLValue = URLValue + "&aciklama=" + tctAciklama.getText();

			Window.alert(URLValue);

			new Util().sendRequest(URLValue);

		}
	}

	private class DtpTarihValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm");
			Window.alert(dtf.format(dtpTarih.getValue()));
		}
	}

	private class DtpVadeTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
			Window.alert(dtf.format(dtpVadeTarihi.getValue()));
		}
	}

	public void putDataFromXML(XMLGelirlerveGiderler xml) {
		tctAciklama.setText(xml.aciklama);
		tctMiktar.setText(xml.miktar);
		cbxBanka.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxBanka,
				xml.banka));
		cbxCek.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxCek, xml.cek));
		cbxGelirler.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxGelirler,
				xml.gelirler));
		cbxİslemTipi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxİslemTipi, xml.islem_tipi));
		cbxKategoriler.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxKategoriler, xml.kategoriler));
		cbxOdemeTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOdemeTuru, xml.odeme_turu));

	}
}
