package com.icarusdb.portal.icacourses.main.client;

import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DlgLogIn extends DialogBox {
	private TextBox tctKullaniciKodu;
	private PasswordTextBox tctSifre;
	private Button btnGirisYap;
	public CKEditor ckhtmlLogIn;
	private CheckBox chxSifreyiHatirla;
	private CheckBox chxKullaniciKodunuHatirla;
	private Button btnIptal;

	public DlgLogIn() {
		setGlassEnabled(true);
		setHTML("DERSHANE YÖNETİM SİSTEMİ");

		VerticalPanel verticalPanel = new VerticalPanel();
		setWidget(verticalPanel);
		verticalPanel.setSize("693px", "417px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Loginbackground");
		verticalPanel.add(absolutePanel);
		absolutePanel.setSize("693px", "418px");

		AbsolutePanel verticalPanel_1 = new AbsolutePanel();
		verticalPanel_1.setStyleName("gwt-LOG İN BACKGROUND");
		absolutePanel.add(verticalPanel_1, 35, 115);
		verticalPanel_1.setSize("248px", "231px");

		Label lblKullaniciKodu = new Label("KULLANICI KODU");
		lblKullaniciKodu
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		verticalPanel_1.add(lblKullaniciKodu);
		lblKullaniciKodu.setStyleName("gwt-Label-Login");
		lblKullaniciKodu.setSize("142px", "18px");

		tctKullaniciKodu = new TextBox();
		tctKullaniciKodu.setStyleName("gwt-TextBox1");
		verticalPanel_1.add(tctKullaniciKodu, 0, 24);
		tctKullaniciKodu.setWidth("85%");

		Label lblNewLabel = new Label("ŞİFRE");
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		verticalPanel_1.add(lblNewLabel, 0, 56);
		lblNewLabel.setStyleName("gwt-Label-Login");
		lblNewLabel.setSize("142px", "18px");

		tctSifre = new PasswordTextBox();
		tctSifre.setStyleName("gwt-TextBox1");
		verticalPanel_1.add(tctSifre, 0, 80);
		tctSifre.setWidth("85%");

		btnGirisYap = new Button("New button");
		btnGirisYap.setStyleName("gwt-ButtonLogIn");
		verticalPanel_1.add(btnGirisYap, 10, 174);
		btnGirisYap.setText("GİRİŞ YAP");
		btnGirisYap.setSize("100px", "27px");

		chxKullaniciKodunuHatirla = new CheckBox("Beni Hatırla");
		chxKullaniciKodunuHatirla.setHTML("Kullanıcı Kodunu Hatırla");
		verticalPanel_1.add(chxKullaniciKodunuHatirla, 0, 110);

		btnIptal = new Button("New button");
		btnIptal.setStyleName("gwt-ButtonLogIn");
		btnIptal.addClickHandler(new BtnIptalClickHandler());
		btnIptal.setText("İPTAL");
		verticalPanel_1.add(btnIptal, 124, 174);
		btnIptal.setSize("100px", "27px");

		chxSifreyiHatirla = new CheckBox("Şifreyi Hatırla");
		verticalPanel_1.add(chxSifreyiHatirla, 0, 136);

		Label txtrSistemzerindeIzleyeceiniz = new Label();
		txtrSistemzerindeIzleyeceiniz
				.setText("Sistem üzerinde izleyeceğiniz bilgiler resmi bilgi olarak değerlendirilemez ve yasal geçerliliği yoktur. Öğrencilerin resmi bilgileri dershane yönetimi tarafından öğrenci ve/veya velilerimize basılı evrak olarak elden iletilmektedir.");
		absolutePanel.add(txtrSistemzerindeIzleyeceiniz, 300, 230);
		txtrSistemzerindeIzleyeceiniz.setSize("255px", "110px");

		Label lblSistemGirii = new Label("SİSTEM GİRİŞİ");
		lblSistemGirii.setStyleName("gwt-LabelSistemGirisi");
		absolutePanel.add(lblSistemGirii, 46, 84);
		lblSistemGirii.setSize("120px", "18px");

		if (!isDesignTime()) {

			// ckhtmlLogIn = new CKEditor(CKConfig.basic);
			// ckhtmlLogIn.setSize("100%", "100%");
			//
			// smpanHtmlEditor.add(ckhtmlLogIn);

		}
	}

	private boolean isDesignTime() {
		// TODO Auto-generated method stub
		return false;
	}

	private class BtnIptalClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			// Window.Location.assign("https://www.google.com.tr");
			hide();
		}
	}
}
