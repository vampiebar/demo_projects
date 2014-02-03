package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgSaatGirisi extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctAciklama;
	private ListBox cbxGun;
	public DecoratedTabPanel tabSaatGirisi;
	private ListBox cbxBitisSaat;
	private ListBox cbxBitisDakika;
	private ListBox cbxBaslangicDakika;
	private ListBox cbxBaslangicSaat;
	private Button btnKaydet;

	public DlgSaatGirisi(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Ders Dağıtım Saat İşlemleri");

		tabSaatGirisi = new DecoratedTabPanel();
		tabSaatGirisi.setAnimationEnabled(true);
		setWidget(tabSaatGirisi);
		tabSaatGirisi.setSize("351px", "256px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		tabSaatGirisi.add(absolutePanel, "El İle Ekleme", false);
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

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 237, 271);
		btnKaydet.setSize("78px", "43px");

		Button btnKapat = new Button("Kapat");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel.add(btnKapat, 333, 271);
		btnKapat.setSize("78px", "43px");

		cbxGun = new ListBox();
		cbxGun.setStyleName("gwt-ComboBox1");
		cbxGun.addItem("Pazartesi");
		cbxGun.addItem("Salı");
		cbxGun.addItem("Çarşamba");
		cbxGun.addItem("Perşembe");
		cbxGun.addItem("Cuma");
		cbxGun.addItem("Cumartesi");
		cbxGun.addItem("Pazar");
		absolutePanel.add(cbxGun, 128, 108);
		cbxGun.setSize("143px", "22px");

		tctAciklama = new TextBox();
		tctAciklama.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAciklama, 128, 150);
		tctAciklama.setSize("143px", "14px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 126, 26);
		horizontalPanel.setSize("184px", "24px");

		cbxBaslangicSaat = new ListBox();
		cbxBaslangicSaat.setStyleName("gwt-ComboBox1");
		cbxBaslangicSaat.addItem("00");
		cbxBaslangicSaat.addItem("01");
		cbxBaslangicSaat.addItem("02");
		cbxBaslangicSaat.addItem("03");
		cbxBaslangicSaat.addItem("04");
		cbxBaslangicSaat.addItem("05");
		cbxBaslangicSaat.addItem("06");
		cbxBaslangicSaat.addItem("07");
		cbxBaslangicSaat.addItem("08");
		cbxBaslangicSaat.addItem("09");
		cbxBaslangicSaat.addItem("10");
		cbxBaslangicSaat.addItem("11");
		cbxBaslangicSaat.addItem("12");
		cbxBaslangicSaat.addItem("13");
		cbxBaslangicSaat.addItem("14");
		cbxBaslangicSaat.addItem("15");
		cbxBaslangicSaat.addItem("16");
		cbxBaslangicSaat.addItem("17");
		cbxBaslangicSaat.addItem("18");
		cbxBaslangicSaat.addItem("19");
		cbxBaslangicSaat.addItem("20");
		cbxBaslangicSaat.addItem("21");
		cbxBaslangicSaat.addItem("22");
		cbxBaslangicSaat.addItem("23");
		horizontalPanel.add(cbxBaslangicSaat);
		horizontalPanel.setCellWidth(cbxBaslangicSaat, "50");
		cbxBaslangicSaat.setSize("45px", "23px");

		Label label = new Label(":");
		horizontalPanel.add(label);
		label.setStyleName("gwt-Bold");
		label.setSize("6px", "16px");

		cbxBaslangicDakika = new ListBox();
		cbxBaslangicDakika.setStyleName("gwt-ComboBox1");
		cbxBaslangicDakika.addItem("00");
		cbxBaslangicDakika.addItem("01");
		cbxBaslangicDakika.addItem("02");
		cbxBaslangicDakika.addItem("03");
		cbxBaslangicDakika.addItem("04");
		cbxBaslangicDakika.addItem("05");
		cbxBaslangicDakika.addItem("06");
		cbxBaslangicDakika.addItem("07");
		cbxBaslangicDakika.addItem("08");
		cbxBaslangicDakika.addItem("09");
		cbxBaslangicDakika.addItem("10");
		cbxBaslangicDakika.addItem("11");
		cbxBaslangicDakika.addItem("12");
		cbxBaslangicDakika.addItem("13");
		cbxBaslangicDakika.addItem("14");
		cbxBaslangicDakika.addItem("15");
		cbxBaslangicDakika.addItem("16");
		cbxBaslangicDakika.addItem("17");
		cbxBaslangicDakika.addItem("18");
		cbxBaslangicDakika.addItem("19");
		cbxBaslangicDakika.addItem("20");
		cbxBaslangicDakika.addItem("21");
		cbxBaslangicDakika.addItem("22");
		cbxBaslangicDakika.addItem("23");
		cbxBaslangicDakika.addItem("24");
		cbxBaslangicDakika.addItem("25");
		cbxBaslangicDakika.addItem("26");
		cbxBaslangicDakika.addItem("27");
		cbxBaslangicDakika.addItem("28");
		cbxBaslangicDakika.addItem("29");
		cbxBaslangicDakika.addItem("30");
		cbxBaslangicDakika.addItem("31");
		cbxBaslangicDakika.addItem("32");
		cbxBaslangicDakika.addItem("33");
		cbxBaslangicDakika.addItem("34");
		cbxBaslangicDakika.addItem("35");
		cbxBaslangicDakika.addItem("36");
		cbxBaslangicDakika.addItem("37");
		cbxBaslangicDakika.addItem("38");
		cbxBaslangicDakika.addItem("39");
		cbxBaslangicDakika.addItem("40");
		cbxBaslangicDakika.addItem("41");
		cbxBaslangicDakika.addItem("42");
		cbxBaslangicDakika.addItem("43");
		cbxBaslangicDakika.addItem("44");
		cbxBaslangicDakika.addItem("45");
		cbxBaslangicDakika.addItem("46");
		cbxBaslangicDakika.addItem("47");
		cbxBaslangicDakika.addItem("48");
		cbxBaslangicDakika.addItem("49");
		cbxBaslangicDakika.addItem("50");
		cbxBaslangicDakika.addItem("51");
		cbxBaslangicDakika.addItem("52");
		cbxBaslangicDakika.addItem("53");
		cbxBaslangicDakika.addItem("54");
		cbxBaslangicDakika.addItem("55");
		cbxBaslangicDakika.addItem("56");
		cbxBaslangicDakika.addItem("57");
		cbxBaslangicDakika.addItem("58");
		cbxBaslangicDakika.addItem("59");
		horizontalPanel.add(cbxBaslangicDakika);
		cbxBaslangicDakika.setSize("45px", "23px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 128, 68);
		horizontalPanel_1.setSize("184px", "24px");

		cbxBitisSaat = new ListBox();
		cbxBitisSaat.setStyleName("gwt-ComboBox1");
		cbxBitisSaat.addItem("00");
		cbxBitisSaat.addItem("01");
		cbxBitisSaat.addItem("02");
		cbxBitisSaat.addItem("03");
		cbxBitisSaat.addItem("04");
		cbxBitisSaat.addItem("05");
		cbxBitisSaat.addItem("06");
		cbxBitisSaat.addItem("07");
		cbxBitisSaat.addItem("08");
		cbxBitisSaat.addItem("09");
		cbxBitisSaat.addItem("10");
		cbxBitisSaat.addItem("11");
		cbxBitisSaat.addItem("12");
		cbxBitisSaat.addItem("13");
		cbxBitisSaat.addItem("14");
		cbxBitisSaat.addItem("15");
		cbxBitisSaat.addItem("16");
		cbxBitisSaat.addItem("17");
		cbxBitisSaat.addItem("18");
		cbxBitisSaat.addItem("19");
		cbxBitisSaat.addItem("20");
		cbxBitisSaat.addItem("21");
		cbxBitisSaat.addItem("22");
		cbxBitisSaat.addItem("23");
		horizontalPanel_1.add(cbxBitisSaat);
		horizontalPanel_1.setCellWidth(cbxBitisSaat, "50");
		cbxBitisSaat.setSize("45px", "23px");

		Label label_1 = new Label(":");
		label_1.setStyleName("gwt-Bold");
		horizontalPanel_1.add(label_1);
		label_1.setSize("5px", "16px");

		cbxBitisDakika = new ListBox();
		cbxBitisDakika.setStyleName("gwt-ComboBox1");
		cbxBitisDakika.addItem("00");
		cbxBitisDakika.addItem("01");
		cbxBitisDakika.addItem("02");
		cbxBitisDakika.addItem("03");
		cbxBitisDakika.addItem("04");
		cbxBitisDakika.addItem("05");
		cbxBitisDakika.addItem("06");
		cbxBitisDakika.addItem("07");
		cbxBitisDakika.addItem("08");
		cbxBitisDakika.addItem("09");
		cbxBitisDakika.addItem("10");
		cbxBitisDakika.addItem("11");
		cbxBitisDakika.addItem("12");
		cbxBitisDakika.addItem("13");
		cbxBitisDakika.addItem("14");
		cbxBitisDakika.addItem("15");
		cbxBitisDakika.addItem("16");
		cbxBitisDakika.addItem("17");
		cbxBitisDakika.addItem("18");
		cbxBitisDakika.addItem("19");
		cbxBitisDakika.addItem("20");
		cbxBitisDakika.addItem("21");
		cbxBitisDakika.addItem("22");
		cbxBitisDakika.addItem("23");
		cbxBitisDakika.addItem("24");
		cbxBitisDakika.addItem("25");
		cbxBitisDakika.addItem("26");
		cbxBitisDakika.addItem("27");
		cbxBitisDakika.addItem("28");
		cbxBitisDakika.addItem("29");
		cbxBitisDakika.addItem("30");
		cbxBitisDakika.addItem("31");
		cbxBitisDakika.addItem("32");
		cbxBitisDakika.addItem("33");
		cbxBitisDakika.addItem("34");
		cbxBitisDakika.addItem("35");
		cbxBitisDakika.addItem("36");
		cbxBitisDakika.addItem("37");
		cbxBitisDakika.addItem("38");
		cbxBitisDakika.addItem("39");
		cbxBitisDakika.addItem("40");
		cbxBitisDakika.addItem("41");
		cbxBitisDakika.addItem("42");
		cbxBitisDakika.addItem("43");
		cbxBitisDakika.addItem("44");
		cbxBitisDakika.addItem("45");
		cbxBitisDakika.addItem("46");
		cbxBitisDakika.addItem("47");
		cbxBitisDakika.addItem("48");
		cbxBitisDakika.addItem("49");
		cbxBitisDakika.addItem("50");
		cbxBitisDakika.addItem("51");
		cbxBitisDakika.addItem("52");
		cbxBitisDakika.addItem("53");
		cbxBitisDakika.addItem("54");
		cbxBitisDakika.addItem("55");
		cbxBitisDakika.addItem("56");
		cbxBitisDakika.addItem("57");
		cbxBitisDakika.addItem("58");
		cbxBitisDakika.addItem("59");
		horizontalPanel_1.add(cbxBitisDakika);
		cbxBitisDakika.setSize("45px", "23px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());

		absolutePanel.add(image, 237, 184);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 325, 184);
		image_1.setSize("72px", "66px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabSaatGirisi.add(absolutePanel_1, "Kopyalama İşlemi", false);
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

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putsaatgirisi?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&gun="
					+ cbxGun.getValue(cbxGun.getSelectedIndex());
			URLValue = URLValue + "&aciklama=" + tctAciklama.getText();

			URLValue = URLValue
					+ "&baslangic_saat="
					+ cbxBaslangicSaat.getValue(cbxBaslangicSaat
							.getSelectedIndex());
			URLValue = URLValue
					+ "&baslangic_dakika="
					+ cbxBaslangicDakika.getValue(cbxBaslangicDakika
							.getSelectedIndex());
			URLValue = URLValue + "&bitis_saat="
					+ cbxBitisSaat.getValue(cbxBitisSaat.getSelectedIndex());
			URLValue = URLValue
					+ "&bitis_dakika="
					+ cbxBitisDakika
							.getValue(cbxBitisDakika.getSelectedIndex());
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "1", "1");

		}
	}

	public void putDataFromXML(XMLSaatGirisi xml) {
		tctAciklama.setText(xml.aciklama);
		cbxGun.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxGun, xml.gun));
		cbxBaslangicSaat.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxBaslangicSaat, xml.baslangic_saat));
		cbxBaslangicDakika.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxBaslangicDakika, xml.baslangic_dakika));
		cbxBitisSaat.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxBitisSaat, xml.bitis_saat));
		cbxBitisDakika.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxBitisDakika, xml.bitis_dakika));

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
}
