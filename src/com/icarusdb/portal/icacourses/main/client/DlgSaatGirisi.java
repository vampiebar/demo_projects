package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgSaatGirisi extends DialogBox {
	private TextBox tctAciklama;
	private ListBox cbxGun;
	private DateBox dtpBaslangicSaati;
	private DateBox dtpBitisSaati;
	public DecoratedTabPanel tabSaatGrisi;

	public DlgSaatGirisi() {
		setHTML("Ders Dağıtım Saat İşlemleri");

		tabSaatGrisi = new DecoratedTabPanel();
		setWidget(tabSaatGrisi);
		tabSaatGrisi.setSize("351px", "256px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		tabSaatGrisi.add(absolutePanel, "El İle Ekleme", false);
		absolutePanel.setSize("550px", "400px");

		Label lblBalangSaati = new Label("Başlangıç Saati");
		lblBalangSaati.setStyleName("gwt-Bold");
		absolutePanel.add(lblBalangSaati, 10, 30);

		Label lblBitiSaati = new Label("Bitiş Saati");
		lblBitiSaati.setStyleName("gwt-Bold");
		absolutePanel.add(lblBitiSaati, 10, 72);
		lblBitiSaati.setSize("91px", "18px");

		Label lblGn = new Label("Gün");
		lblGn.setStyleName("gwt-Bold");
		absolutePanel.add(lblGn, 10, 112);

		Label lblAklama = new Label("Açıklama");
		lblAklama.setStyleName("gwt-Bold");
		absolutePanel.add(lblAklama, 10, 150);
		lblAklama.setSize("54px", "18px");

		Button btnKaydet = new Button("Kaydet");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 326, 207);
		btnKaydet.setSize("78px", "43px");

		Button btnKapat = new Button("Kapat");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel.add(btnKapat, 428, 207);
		btnKapat.setSize("78px", "43px");

		dtpBaslangicSaati = new DateBox();
		dtpBaslangicSaati.setStyleName("gwt-TextBox1");
		dtpBaslangicSaati.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("HH:mm")));
		dtpBaslangicSaati
				.addValueChangeHandler(new DtpBaslangicSaatiValueChangeHandler());
		absolutePanel.add(dtpBaslangicSaati, 134, 30);
		dtpBaslangicSaati.setSize("143px", "14px");

		dtpBitisSaati = new DateBox();
		dtpBitisSaati.setStyleName("gwt-TextBox1");
		dtpBitisSaati.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("HH:mm")));
		dtpBitisSaati
				.addValueChangeHandler(new DtpBitisSaatiValueChangeHandler());
		absolutePanel.add(dtpBitisSaati, 134, 72);
		dtpBitisSaati.setSize("143px", "14px");

		cbxGun = new ListBox();
		cbxGun.setStyleName("gwt-ComboBox1");
		cbxGun.addItem("Pazartesi");
		cbxGun.addItem("Salı");
		cbxGun.addItem("Çarşamba");
		cbxGun.addItem("Perşembe");
		cbxGun.addItem("Cuma");
		cbxGun.addItem("Cumartesi");
		cbxGun.addItem("Pazar");
		absolutePanel.add(cbxGun, 136, 108);
		cbxGun.setSize("143px", "22px");

		tctAciklama = new TextBox();
		tctAciklama.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAciklama, 134, 150);
		tctAciklama.setSize("143px", "14px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabSaatGrisi.add(absolutePanel_1, "Kopyalama İşlemi", false);
		absolutePanel_1.setSize("550px", "400px");

		Label lblKopyalanacakGn = new Label("Kopyalanacak Gün");
		lblKopyalanacakGn.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblKopyalanacakGn, 10, 21);

		Label lblYaptrlacakGn = new Label("Yapıştırılacak Gün");
		lblYaptrlacakGn.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblYaptrlacakGn, 10, 65);

		ListBox cbxKopyalanacakGun = new ListBox();
		cbxKopyalanacakGun.setStyleName("gwt-ComboBox1");
		cbxKopyalanacakGun.addItem("Pazartesi");
		cbxKopyalanacakGun.addItem("Salı");
		cbxKopyalanacakGun.addItem("Çarşamba");
		cbxKopyalanacakGun.addItem("Perşembe");
		cbxKopyalanacakGun.addItem("Cuma");
		cbxKopyalanacakGun.addItem("Cumartesi");
		cbxKopyalanacakGun.addItem("Pazar");
		absolutePanel_1.add(cbxKopyalanacakGun, 149, 17);
		cbxKopyalanacakGun.setSize("106px", "22px");

		ListBox cbxListelenecekGun = new ListBox();
		cbxListelenecekGun.setStyleName("gwt-ComboBox1");
		cbxListelenecekGun.addItem("Pazartesi");
		cbxListelenecekGun.addItem("Salı");
		cbxListelenecekGun.addItem("Çarşamba");
		cbxListelenecekGun.addItem("Perşembe");
		cbxListelenecekGun.addItem("Cuma");
		cbxListelenecekGun.addItem("Cumartesi");
		cbxListelenecekGun.addItem("Pazar");
		absolutePanel_1.add(cbxListelenecekGun, 149, 61);
		cbxListelenecekGun.setSize("106px", "22px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class DtpBaslangicSaatiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("HH:mm");
			// Window.alert(dtf.format(dtpBaslangicSaati.getValue()));
		}
	}

	private class DtpBitisSaatiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("HH:mm");
			// .alert(dtf.format(dtpBitisSaati.getValue()));
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putsaatgirisi?";

			URLValue = URLValue + "gun="
					+ cbxGun.getValue(cbxGun.getSelectedIndex());
			URLValue = URLValue + "&aciklama=" + tctAciklama.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	public void putDataFromXML(XMLSaatGirisi xml) {
		tctAciklama.setText(xml.aciklama);
		cbxGun.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxGun, xml.gun));

	}
}
