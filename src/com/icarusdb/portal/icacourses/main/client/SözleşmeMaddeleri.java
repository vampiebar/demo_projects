package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBoxBase;

public class SözleşmeMaddeleri extends Composite {

	public SözleşmeMaddeleri() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("813px", "443px");

		Label lblKesinKaytSzleme = new Label(
				"Kesin Kayıt Sözleşme Maddeleri (Düzenleme)");
		lblKesinKaytSzleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblKesinKaytSzleme, 0, 10);
		lblKesinKaytSzleme.setSize("813px", "32px");

		Label lblMteriSzlemeMaddeleri = new Label("Müşteri Sözleşme Maddeleri");
		lblMteriSzlemeMaddeleri.setStyleName("gwt-Bold");
		absolutePanel.add(lblMteriSzlemeMaddeleri, 43, 60);

		Label lblSzlemeMaddelri = new Label("Sözleşme Maddeleri\r\n");
		absolutePanel.add(lblSzlemeMaddelri, 43, 92);

		TextArea tctSozlesmeMaddeleri = new TextArea();
		tctSozlesmeMaddeleri.setStyleName("gwt-TextBox1");
		tctSozlesmeMaddeleri.setTextAlignment(TextBoxBase.ALIGN_LEFT);
		tctSozlesmeMaddeleri
				.setText("ALYA ÖĞRETİM KURUMLARI TİC LTD ŞTİ.  ÖĞRENCİ KAYIT SÖZLEŞMESİ\r\n\r\nÖğrencisini dershanemize kayıt yaptıran velimiz aşağıdaki maddelere uyacağını kabul eder.\r\n\r\n1. Velimiz, öğrencisinin disiplin yönergesine uyacağını kabul eder. Disiplinsiz davranışlarda bulunan öğrencinin kaydının silinmesi durumunda, yıllık kayıt ücreti tahsil edilir.\r\n\r\n2. Tek kişilik sınıflara kayıt olan öğrencinin, gelmediği günlere denk gelen dersleri toplam ders hakkından düşer.\r\n\r\nKAYIT SİLME VE ÜCRET İADESİ\r\n\r\nŞirketimiz mali planlarını öğrenci kayıt sayısına göre yaptığından, kayıtlı öğrencilerin öğretim yılı boyunca kayıtlarını sildirmemeleri temel esastır.\r\n\r\n3. Öğretim dönemi içinde zorunlu bir sebeple kayıt sildirmek isteyen öğrenci için, velisinin yazılı müracaatı gereklidir. Müracaat sonrası şirket yetkilisi veya dershane müdürü tarafından kayıt silme gerekçesi incelenerek kayıt silinir.\r\n\r\n4. Kayıt silme tarihi, ilgili müracaat dilekçesinin dershaneye ulaştığı tarihtir.\r\n\r\n5. Kaydını sildirmek isteyen öğrenciye verilen indirimler iptal edilir. Kaydı silinen öğrencimizin velisi, öğrencisinin almış olduğu toplam ders saatini, 6 kişilik sınıflar için 25 TL'den, aldığı özel dersler için 60 TL'den, tek kişilik sınıf için 60 TL'den çarpılarak hesaplanacağını kabul eder. Erken kayıt yaptıran öğrencilerimize verdiğimiz ücretsiz özel ders toplamı 60 TL'den çarpılarak, tahsil edilir.\r\n\r\n6. Velimiz ücretsiz yaz programına katılan öğrencisi için, kayıt sildirme durumunda almış olduğu bu hizmete istinaden 750 TL ödemeyi kabul eder. \r\n\r\n7. Velimiz, öğrencisinin dershaneden almış olduğu kitap, test v.b. yayınlar için 300 TL ödemeyi kabul eder.\r\n\r\n8. Öğrencinin almış olduğu hizmetlerin toplam ücreti, ödemiş olduğu ücretten düşülür. Öğrencinin alacağı ücret çıkarsa kendisine 2 hafta içinde ödeme yapılır. Öğrencinin vereceği ücret varsa kendisinden tahsil edilir.\r\n\r\n9. İhtilaf vukuunda bu sözleşmeden doğabilecek tüm anlaşmazlıklarda İstanbul  Mahkemeleri ve icra dairelerinin yetkili olduğunu kabul ederim. İş bu kayıt sözleşmesinin tüm hükümleri tarafımızca eksiksiz olarak okunmuş ve herhangi bir tereddüdüm olmaksızın anlaşılmış olup, tamamen hür irade ve arzumla yukarıdaki ikaz çerçevesinde sözleşme şartlarını kesin olarak kabul ediyorum.\r\n\r\n");
		absolutePanel.add(tctSozlesmeMaddeleri, 43, 126);
		tctSozlesmeMaddeleri.setSize("727px", "269px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 681, 409);
	}
}
