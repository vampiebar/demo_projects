package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;

public class YetkiTanimlama extends Composite {
	private TextBox tctHaftalikSaatKotasi;
	private TextBox tctAylikSaatKotasi;
	private TextBox tctGunlukSaatKotasi;
	private TextBox tctEtutMaksimumKisiSayisi;
	private TextBox tctEnGecRezervasyon;
	private TextBox tctEnErkenRezervasyon;
	private IntegerBox tctDersSilmeZamani;

	public YetkiTanimlama() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("794px", "472px");

		Label lblNewLabel = new Label("Ders Dağıtım Yetki Belirleme");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("794px", "33px");

		Label lblDersSilme = new Label("Ders Silme Zamanı");
		lblDersSilme.setStyleName("gwt-Bold");
		absolutePanel.add(lblDersSilme, 10, 54);

		tctDersSilmeZamani = new IntegerBox();
		tctDersSilmeZamani.setStyleName("gwt-TextBox1");
		tctDersSilmeZamani.setText("0");
		absolutePanel.add(tctDersSilmeZamani, 195, 48);
		tctDersSilmeZamani.setSize("147px", "18px");

		Label lblGnnceSilindi = new Label("gün önce");
		lblGnnceSilindi.setStyleName("gwt-Bold");
		absolutePanel.add(lblGnnceSilindi, 356, 54);

		Label lblEnErkenRezervasyon = new Label("En Erken Rezervasyon");
		lblEnErkenRezervasyon.setStyleName("gwt-Bold");
		absolutePanel.add(lblEnErkenRezervasyon, 10, 149);

		Label lblEnGeRezervasyon = new Label("En Geç Rezervasyon");
		lblEnGeRezervasyon.setStyleName("gwt-Bold");
		absolutePanel.add(lblEnGeRezervasyon, 10, 187);

		Label lblEttMaksimumKii = new Label("Etüt Maksimum Kişi Sayısı");
		lblEttMaksimumKii.setStyleName("gwt-Bold");
		absolutePanel.add(lblEttMaksimumKii, 10, 226);

		TextBox txtrLimitYok = new TextBox();
		txtrLimitYok.setStyleName("gwt-TextBox1");
		txtrLimitYok.setText("0 Limit yok demektir.");
		txtrLimitYok.setReadOnly(true);
		absolutePanel.add(txtrLimitYok, 10, 248);
		txtrLimitYok.setSize("168px", "20px");

		tctEnErkenRezervasyon = new TextBox();
		tctEnErkenRezervasyon.setText("0");
		tctEnErkenRezervasyon.setStyleName("gwt-TextBox1");
		tctEnErkenRezervasyon.setAlignment(TextAlignment.LEFT);
		absolutePanel.add(tctEnErkenRezervasyon, 195, 149);
		tctEnErkenRezervasyon.setSize("147px", "18px");

		tctEnGecRezervasyon = new TextBox();
		tctEnGecRezervasyon.setText("0");
		tctEnGecRezervasyon.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEnGecRezervasyon, 195, 187);
		tctEnGecRezervasyon.setSize("147px", "18px");

		Label lblGmnce = new Label("gün sonra");
		lblGmnce.setStyleName("gwt-Bold");
		absolutePanel.add(lblGmnce, 356, 149);

		Label lblNewLabel_1 = new Label("gün sonra");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 356, 187);

		tctEtutMaksimumKisiSayisi = new TextBox();
		tctEtutMaksimumKisiSayisi.setText("0");
		tctEtutMaksimumKisiSayisi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEtutMaksimumKisiSayisi, 195, 226);
		tctEtutMaksimumKisiSayisi.setSize("147px", "18px");

		Label lblKii = new Label("kişi");
		lblKii.setStyleName("gwt-Bold");
		absolutePanel.add(lblKii, 356, 226);
		lblKii.setSize("57px", "16px");

		Label lblGnlkSaatKotas = new Label("Günlük Saat Kotası");
		lblGnlkSaatKotas.setStyleName("gwt-Bold");
		absolutePanel.add(lblGnlkSaatKotas, 10, 280);

		tctGunlukSaatKotasi = new TextBox();
		tctGunlukSaatKotasi.setText("0");
		tctGunlukSaatKotasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctGunlukSaatKotasi, 195, 280);
		tctGunlukSaatKotasi.setSize("147px", "18px");

		TextBox textArea = new TextBox();
		textArea.setStyleName("gwt-TextBox1");
		textArea.setText("0 Limit yok demektir.");
		textArea.setReadOnly(true);
		absolutePanel.add(textArea, 10, 302);
		textArea.setSize("168px", "17px");

		Label lblHaftalkSaatKotas = new Label("Haftalık Saat Kotası");
		lblHaftalkSaatKotas.setStyleName("gwt-Bold");
		absolutePanel.add(lblHaftalkSaatKotas, 10, 333);
		lblHaftalkSaatKotas.setSize("158px", "16px");

		TextBox textArea_1 = new TextBox();
		textArea_1.setStyleName("gwt-TextBox1");
		textArea_1.setText("0 Limit yok demektir.");
		textArea_1.setReadOnly(true);
		absolutePanel.add(textArea_1, 10, 356);
		textArea_1.setSize("168px", "18px");

		Label lblAylkSaatKotas = new Label("Aylık Saat Kotası");
		lblAylkSaatKotas.setStyleName("gwt-Bold");
		absolutePanel.add(lblAylkSaatKotas, 10, 386);
		lblAylkSaatKotas.setSize("113px", "16px");

		TextBox textArea_2 = new TextBox();
		textArea_2.setStyleName("gwt-TextBox1");
		textArea_2.setText("0 Limit yok demektir.");
		textArea_2.setReadOnly(true);
		absolutePanel.add(textArea_2, 10, 411);
		textArea_2.setSize("168px", "17px");

		tctHaftalikSaatKotasi = new TextBox();
		tctHaftalikSaatKotasi.setText("0");
		tctHaftalikSaatKotasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctHaftalikSaatKotasi, 195, 333);
		tctHaftalikSaatKotasi.setSize("147px", "18px");

		tctAylikSaatKotasi = new TextBox();
		tctAylikSaatKotasi.setText("0");
		tctAylikSaatKotasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAylikSaatKotasi, 195, 386);
		tctAylikSaatKotasi.setSize("147px", "18px");

		Label lblSaat = new Label("saat");
		lblSaat.setStyleName("gwt-Bold");
		absolutePanel.add(lblSaat, 356, 280);
		lblSaat.setSize("57px", "16px");

		Label lblSaat_1 = new Label("saat");
		lblSaat_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblSaat_1, 356, 333);
		lblSaat_1.setSize("57px", "16px");

		Label lblSaat_2 = new Label("saat");
		lblSaat_2.setStyleName("gwt-Bold");
		absolutePanel.add(lblSaat_2, 356, 386);
		lblSaat_2.setSize("57px", "16px");

		Button btnNewButton = new Button("New button");
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		btnNewButton.setStyleName("gwt-ButtonSave");
		btnNewButton.setText("Kaydet");
		absolutePanel.add(btnNewButton, 539, 359);
		btnNewButton.setSize("78px", "49px");

		TextBox txtrDersinBalamasna = new TextBox();
		txtrDersinBalamasna.setStyleName("gwt-TextBox1");
		txtrDersinBalamasna.setReadOnly(true);
		txtrDersinBalamasna.setMaxLength(5555);
		absolutePanel.add(txtrDersinBalamasna, 10, 76);
		txtrDersinBalamasna.setSize("168px", "41px");
		txtrDersinBalamasna
				.setText("Dersin Başlamasına \r\nKaç Gün Kala Öğrenci Dersi Silebilsin?\r\n 0 Herzaman Silebilir Demektir.");
	}

	private class BtnNewButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putyetkitanimlama?";

			URLValue = URLValue + "ders_silme_zamani="
					+ tctDersSilmeZamani.getText();
			URLValue = URLValue + "&en_erken_rezervasyon="
					+ tctEnErkenRezervasyon.getText();
			URLValue = URLValue + "&en_gec_rezervasyon="
					+ tctEnGecRezervasyon.getText();
			URLValue = URLValue + "&etut_maksimum_kisi_sayisi="
					+ tctEtutMaksimumKisiSayisi.getText();
			URLValue = URLValue + "&gunluk_saat_kotasi="
					+ tctGunlukSaatKotasi.getText();
			URLValue = URLValue + "&haftalik_saat_kotasi="
					+ tctHaftalikSaatKotasi.getText();
			URLValue = URLValue + "&aylik_saat_kotasi="
					+ tctAylikSaatKotasi.getText();

			Window.alert(URLValue);

			new Util().sendRequest(URLValue);
		}
	}
}
