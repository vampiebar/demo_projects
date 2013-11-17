package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class SifreDegistirme extends Composite {
	private TextBox tctEskiSifre;
	private TextBox tctYeniSifre;
	private TextBox tctTekrarYeniSifre;

	public SifreDegistirme() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("803px", "433px");

		Label lblifreDeitirme = new Label("Şifre Değiştirme");
		lblifreDeitirme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblifreDeitirme, 0, 10);
		lblifreDeitirme.setSize("803px", "30px");

		Label lblVarolanifreniziDeitirin = new Label(
				"Varolan Şifrenizi Değiştirin");
		lblVarolanifreniziDeitirin.setStyleName("gwt-Bold");
		absolutePanel.add(lblVarolanifreniziDeitirin, 40, 60);

		Label lblEskisifre = new Label("Eski Şifre");
		lblEskisifre.setStyleName("gwt-Bold");
		absolutePanel.add(lblEskisifre, 40, 98);
		lblEskisifre.setSize("78px", "16px");

		Label lblYeni = new Label("Yeni Şifre");
		lblYeni.setStyleName("gwt-Bold");
		absolutePanel.add(lblYeni, 40, 147);

		Label lblNewLabel = new Label("Tekrar Yeni Şifre");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 40, 193);
		lblNewLabel.setSize("115px", "27px");

		tctEskiSifre = new TextBox();
		tctEskiSifre.setStyleName("gwt-ComboBox1");
		absolutePanel.add(tctEskiSifre, 161, 98);
		tctEskiSifre.setSize("143px", "16px");

		tctYeniSifre = new TextBox();
		tctYeniSifre.setStyleName("gwt-ComboBox1");
		absolutePanel.add(tctYeniSifre, 161, 142);
		tctYeniSifre.setSize("143px", "16px");

		tctTekrarYeniSifre = new TextBox();
		tctTekrarYeniSifre.setStyleName("gwt-ComboBox1");
		absolutePanel.add(tctTekrarYeniSifre, 161, 193);
		tctTekrarYeniSifre.setSize("143px", "16px");

		Button btnKaydet = new Button("Kaydet");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 194, 251);
		btnKaydet.setSize("78px", "51px");
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putsifredegistirme?";

			URLValue = URLValue + "eski_sifre=" + tctEskiSifre.getText();

			URLValue = URLValue + "&yeni_sifre=" + tctYeniSifre.getText();
			URLValue = URLValue + "&tekrar_yeni_sifre="
					+ tctTekrarYeniSifre.getText();

			Window.alert(URLValue);

			new Util().sendRequest(URLValue, "ŞİFRE BAŞARIYLA DEĞİŞTİ",
					"ŞİFRE DEĞİŞTİRİLEMEDİ");
		}
	}
}
