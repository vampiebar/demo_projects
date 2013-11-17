package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class DlgReferanslar extends DialogBox {
	private TextBox tctReferansAdiSoyadi;

	public DlgReferanslar() {
		setHTML("Referans İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("531px", "397px");

		Label lblReferansIlemleriekleme = new Label(
				"Referans İşlemleri (Ekleme / Düzenleme)");
		lblReferansIlemleriekleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblReferansIlemleriekleme, 0, 0);
		lblReferansIlemleriekleme.setSize("541px", "28px");

		Label lblReferansAdSoyad = new Label("Referans Adı Soyadı");
		lblReferansAdSoyad.setStyleName("gwt-Bold");
		absolutePanel.add(lblReferansAdSoyad, 10, 47);

		tctReferansAdiSoyadi = new TextBox();
		tctReferansAdiSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctReferansAdiSoyadi, 167, 47);
		tctReferansAdiSoyadi.setSize("149px", "14px");

		Button btnYeniKayit = new Button("New button");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.setText("Yeni Kayıt");
		absolutePanel.add(btnYeniKayit, 266, 117);
		btnYeniKayit.setSize("78px", "45px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 356, 117);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 447, 117);
		btnKapat.setSize("78px", "45px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putreferanslar?";
			URLValue = URLValue + "referans_adi_soyadi="
					+ tctReferansAdiSoyadi.getText();

			Window.alert(URLValue);

			new Util().sendRequest(URLValue, "Referans Kaydı Başarılı",
					"Referans Kaydı Yapılamadı");
		}
	}

	public void putDataFromXML(XMLReferanslar xml) {

		tctReferansAdiSoyadi.setText(xml.referans_adi_soyadi);

	}
}
