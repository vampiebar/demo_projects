package com.icarusdb.portal.icacourses.main.client;

import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DlgLogIn extends DialogBox {
	private TextBox tctKullaniciKodu;
	private PasswordTextBox tctSifre;
	private Button btnGirisYap;
	private SimplePanel smpanHtmlEditor;
	public CKEditor ckhtmlLogIn;
	private CheckBox chckbxKullaniciKoduHatirla;
	private CheckBox chckbxifreyiHatrla;

	public DlgLogIn() {
		setGlassEnabled(true);
		setHTML("DERSHANE YÖNETİM SİSTEMİ");

		VerticalPanel verticalPanel = new VerticalPanel();
		setWidget(verticalPanel);
		verticalPanel.setSize("335px", "317px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-Loginbackground");
		verticalPanel.add(absolutePanel);
		absolutePanel.setSize("573px", "504px");

		AbsolutePanel verticalPanel_1 = new AbsolutePanel();
		verticalPanel_1.setStyleName("gwt-LOG İN BACKGROUND");
		absolutePanel.add(verticalPanel_1, 10, 40);
		verticalPanel_1.setSize("267px", "231px");

		Label lblKullaniciKodu = new Label("KULLANICI KODU");
		lblKullaniciKodu
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		verticalPanel_1.add(lblKullaniciKodu);
		lblKullaniciKodu.setStyleName("gwt-Label-Login");
		lblKullaniciKodu.setSize("142px", "18px");

		tctKullaniciKodu = new TextBox();
		tctKullaniciKodu.setStyleName("gwt-TextBox1");
		verticalPanel_1.add(tctKullaniciKodu);
		tctKullaniciKodu.setWidth("90%");

		Label lblNewLabel = new Label("ŞİFRE");
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		verticalPanel_1.add(lblNewLabel);
		lblNewLabel.setStyleName("gwt-Label-Login");
		lblNewLabel.setSize("142px", "18px");

		tctSifre = new PasswordTextBox();
		tctSifre.setStyleName("gwt-TextBox1");
		verticalPanel_1.add(tctSifre);
		tctSifre.setWidth("90%");

		btnGirisYap = new Button("New button");
		verticalPanel_1.add(btnGirisYap, 28, 149);
		btnGirisYap.setText("GİRİŞ YAP");
		btnGirisYap.setSize("100px", "27px");

		chckbxKullaniciKoduHatirla = new CheckBox("Beni Hatırla");
		chckbxKullaniciKoduHatirla.setHTML("Kullanıcı Kodunu Hatırla");
		verticalPanel_1.add(chckbxKullaniciKoduHatirla, 0, 95);

		Button btnIptal = new Button("New button");
		btnIptal.addClickHandler(new BtnIptalClickHandler());
		btnIptal.setText("İPTAL");
		verticalPanel_1.add(btnIptal, 142, 149);
		btnIptal.setSize("100px", "27px");

		chckbxifreyiHatrla = new CheckBox("Şifreyi Hatırla");
		verticalPanel_1.add(chckbxifreyiHatrla, 0, 121);

		smpanHtmlEditor = new SimplePanel();
		absolutePanel.add(smpanHtmlEditor, 283, 40);
		smpanHtmlEditor.setSize("280px", "231px");

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

			Window.Location.assign("https://www.google.com.tr");
		}
	}
}
