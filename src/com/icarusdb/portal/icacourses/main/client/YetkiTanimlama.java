package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
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
		absolutePanel.setSize("777px", "497px");

		Label lblNewLabel = new Label("Ders Dağıtım Yetki Belirleme");
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("794px", "33px");

		Label lblDersSilme = new Label("Ders Silme Zamanı");
		lblDersSilme.setStyleName("gwt-Bold");
		absolutePanel.add(lblDersSilme, 10, 56);
		lblDersSilme.setSize("131px", "16px");

		tctDersSilmeZamani = new IntegerBox();
		tctDersSilmeZamani.setStyleName("gwt-TextBox1");
		tctDersSilmeZamani.setText("0");
		absolutePanel.add(tctDersSilmeZamani, 226, 53);
		tctDersSilmeZamani.setSize("147px", "18px");

		Label lblGnnceSilindi = new Label("gün önce");
		lblGnnceSilindi.setStyleName("gwt-Bold");
		absolutePanel.add(lblGnnceSilindi, 381, 59);

		Label lblEnErkenRezervasyon = new Label("En Erken Rezervasyon");
		lblEnErkenRezervasyon.setStyleName("gwt-Bold");
		absolutePanel.add(lblEnErkenRezervasyon, 10, 151);
		lblEnErkenRezervasyon.setSize("149px", "16px");

		Label lblEnGeRezervasyon = new Label("En Geç Rezervasyon");
		lblEnGeRezervasyon.setStyleName("gwt-Bold");
		absolutePanel.add(lblEnGeRezervasyon, 10, 189);
		lblEnGeRezervasyon.setSize("143px", "16px");

		Label lblEttMaksimumKii = new Label("Etüt Maksimum Kişi Sayısı");
		lblEttMaksimumKii.setStyleName("gwt-Bold");
		absolutePanel.add(lblEttMaksimumKii, 10, 228);
		lblEttMaksimumKii.setSize("190px", "16px");

		tctEnErkenRezervasyon = new TextBox();
		tctEnErkenRezervasyon.setText("0");
		tctEnErkenRezervasyon.setStyleName("gwt-TextBox1");
		tctEnErkenRezervasyon.setAlignment(TextAlignment.LEFT);
		absolutePanel.add(tctEnErkenRezervasyon, 226, 154);
		tctEnErkenRezervasyon.setSize("147px", "18px");

		tctEnGecRezervasyon = new TextBox();
		tctEnGecRezervasyon.setText("0");
		tctEnGecRezervasyon.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEnGecRezervasyon, 226, 192);
		tctEnGecRezervasyon.setSize("147px", "18px");

		Label lblGmnce = new Label("gün sonra");
		lblGmnce.setStyleName("gwt-Bold");
		absolutePanel.add(lblGmnce, 381, 160);

		Label lblNewLabel_1 = new Label("gün sonra");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 381, 198);

		tctEtutMaksimumKisiSayisi = new TextBox();
		tctEtutMaksimumKisiSayisi.setText("0");
		tctEtutMaksimumKisiSayisi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEtutMaksimumKisiSayisi, 226, 231);
		tctEtutMaksimumKisiSayisi.setSize("147px", "18px");

		Label lblKii = new Label("kişi");
		lblKii.setStyleName("gwt-Bold");
		absolutePanel.add(lblKii, 381, 237);
		lblKii.setSize("57px", "16px");

		Label lblGnlkSaatKotas = new Label("Günlük Saat Kotası");
		lblGnlkSaatKotas.setStyleName("gwt-Bold");
		absolutePanel.add(lblGnlkSaatKotas, 10, 282);
		lblGnlkSaatKotas.setSize("137px", "16px");

		tctGunlukSaatKotasi = new TextBox();
		tctGunlukSaatKotasi.setText("0");
		tctGunlukSaatKotasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctGunlukSaatKotasi, 226, 285);
		tctGunlukSaatKotasi.setSize("147px", "18px");

		Label lblHaftalkSaatKotas = new Label("Haftalık Saat Kotası");
		lblHaftalkSaatKotas.setStyleName("gwt-Bold");
		absolutePanel.add(lblHaftalkSaatKotas, 10, 335);
		lblHaftalkSaatKotas.setSize("158px", "16px");

		Label lblAylkSaatKotas = new Label("Aylık Saat Kotası");
		lblAylkSaatKotas.setStyleName("gwt-Bold");
		absolutePanel.add(lblAylkSaatKotas, 10, 388);
		lblAylkSaatKotas.setSize("148px", "16px");

		tctHaftalikSaatKotasi = new TextBox();
		tctHaftalikSaatKotasi.setText("0");
		tctHaftalikSaatKotasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctHaftalikSaatKotasi, 226, 338);
		tctHaftalikSaatKotasi.setSize("147px", "18px");

		tctAylikSaatKotasi = new TextBox();
		tctAylikSaatKotasi.setText("0");
		tctAylikSaatKotasi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAylikSaatKotasi, 226, 391);
		tctAylikSaatKotasi.setSize("147px", "18px");

		Label lblSaat = new Label("saat");
		lblSaat.setStyleName("gwt-Bold");
		absolutePanel.add(lblSaat, 381, 291);
		lblSaat.setSize("57px", "16px");

		Label lblSaat_1 = new Label("saat");
		lblSaat_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblSaat_1, 381, 344);
		lblSaat_1.setSize("57px", "16px");

		Label lblSaat_2 = new Label("saat");
		lblSaat_2.setStyleName("gwt-Bold");
		absolutePanel.add(lblSaat_2, 381, 397);
		lblSaat_2.setSize("57px", "16px");

		Button btnNewButton = new Button("New button");
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		btnNewButton.setStyleName("gwt-ButtonSave");
		btnNewButton.setText("Kaydet");
		absolutePanel.add(btnNewButton, 228, 438);
		btnNewButton.setSize("78px", "49px");

		Label lblNewLabel_2 = new Label("0 Limit Yok Demektir.");
		lblNewLabel_2.setStyleName("gwt-MenuButton2");
		absolutePanel.add(lblNewLabel_2, 10, 250);
		lblNewLabel_2.setSize("149px", "16px");

		Label label = new Label("0 Limit Yok Demektir.");
		label.setStyleName("gwt-MenuButton2");
		absolutePanel.add(label, 10, 301);
		label.setSize("149px", "16px");

		Label label_1 = new Label("0 Limit Yok Demektir.");
		label_1.setStyleName("gwt-MenuButton2");
		absolutePanel.add(label_1, 10, 357);
		label_1.setSize("149px", "16px");

		Label label_2 = new Label("0 Limit Yok Demektir.");
		label_2.setStyleName("gwt-MenuButton2");
		absolutePanel.add(label_2, 10, 412);
		label_2.setSize("149px", "16px");

		Label lblDersinBalamasnaKa = new Label(
				"Dersin Başlamasına Kaç Gün Kala\r\nÖğrenci Dersi Silebilsin?                \r\n0 Herzaman Silebilir Demektir.");
		lblDersinBalamasnaKa.setStyleName("gwt-MenuButton2");
		absolutePanel.add(lblDersinBalamasnaKa, 10, 78);
		lblDersinBalamasnaKa.setSize("205px", "49px");
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

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}
}
