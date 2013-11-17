package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBoxBase;

public class SozlesmeMaddeleri extends Composite {

	public SozlesmeMaddeleri() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("813px", "750px");

		Label lblKesinKaytSzleme = new Label(
				"Kesin Kayıt Sözleşme Maddeleri (Düzenleme)");
		lblKesinKaytSzleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblKesinKaytSzleme, 0, 10);
		lblKesinKaytSzleme.setSize("813px", "32px");

		Label lblMteriSzlemeMaddeleri = new Label("Müşteri Sözleşme Maddeleri");
		lblMteriSzlemeMaddeleri.setStyleName("gwt-Bold");
		absolutePanel.add(lblMteriSzlemeMaddeleri, 43, 60);

		Label lblSzlemeMaddelri = new Label("Sözleşme Maddeleri\r\n");
		lblSzlemeMaddelri.setStyleName("gwt-Bold");
		absolutePanel.add(lblSzlemeMaddelri, 43, 92);

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 647, 530);
		btnKaydet.setSize("69px", "36px");

		TextArea tctSozlesmeMaddeleri = new TextArea();
		absolutePanel.add(tctSozlesmeMaddeleri, 35, 161);
		tctSozlesmeMaddeleri.setSize("675px", "328px");
		tctSozlesmeMaddeleri.setStyleName("gwt-TextBox1");
		tctSozlesmeMaddeleri.setTextAlignment(TextBoxBase.ALIGN_LEFT);
		tctSozlesmeMaddeleri
				.setText("    ALYA ÖĞRETİM KURUMLARI TİC LTD ŞTİ.  ÖĞRENCİ KAYIT SÖZLEŞMESİ\r\n\r\n\r\n \tKaydını sildirmek isteyen öğrenciye verilen indirimler iptal edilir. Kaydı silinen  öğrencimizin  velisi, öğrencisinin almış olduğu toplam ders saatini, 60 TL'den çarpılarak  hesaplanacağını  kabul eder. \r\n\r\n\tÖğrencinin almış olduğu hizmetlerin toplam ücreti, ödemiş olduğu ücretten düşülür.  Öğrencinin alacağı ücret çıkarsa kendisine 2 hafta içinde ödeme yapılır. Öğrencinin  vereceği ücret varsa kendisinden tahsil edilir.");
	}
}
