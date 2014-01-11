package com.icarusdb.portal.icacourses.main.client;

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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DlgLogIn extends DialogBox {
	private TextBox tctKullaniciKodu;
	private PasswordTextBox tctSifre;
	private Button btnGirisYap;

	public DlgLogIn() {
		setGlassEnabled(true);
		setHTML("DERSHANE YÖNETİM SİSTEMİ");

		VerticalPanel verticalPanel = new VerticalPanel();
		setWidget(verticalPanel);
		verticalPanel.setSize("335px", "317px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		verticalPanel.add(absolutePanel);
		absolutePanel.setSize("381px", "324px");

		AbsolutePanel verticalPanel_1 = new AbsolutePanel();
		verticalPanel_1.setStyleName("gwt-LOG İN BACKGROUND");
		absolutePanel.add(verticalPanel_1, 39, 40);
		verticalPanel_1.setSize("303px", "231px");

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
		verticalPanel_1.add(btnGirisYap, 27, 133);
		btnGirisYap.setStyleName("gwt-ButonKapat");
		btnGirisYap.setText("GİRİŞ YAP");
		btnGirisYap.setSize("100px", "26px");

		CheckBox chckbxNewCheckBox = new CheckBox("Beni Hatırla");
		verticalPanel_1.add(chckbxNewCheckBox, 0, 95);

		Button btnIptal = new Button("New button");
		btnIptal.addClickHandler(new BtnIptalClickHandler());
		btnIptal.setText("İPTAL");
		btnIptal.setStyleName("gwt-ButtonSave");
		verticalPanel_1.add(btnIptal, 148, 133);
		btnIptal.setSize("100px", "26px");
	}

	private class BtnIptalClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			Window.Location.assign("https://www.google.com.tr");
		}
	}
}
