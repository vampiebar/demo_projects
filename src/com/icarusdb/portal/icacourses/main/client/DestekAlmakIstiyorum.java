package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class DestekAlmakIstiyorum extends Composite {
	private TextBox tctKonu;
	private ListBox cbxBolum;
	private TextArea tctMesajiniz;
	public TabPanel tabDestekAlmakIstiyorum;

	public DestekAlmakIstiyorum() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("795px", "457px");

		Label lblNewLabel = new Label(
				"Destek Bölümü (Soru , İstek , Hata Bildirimi )");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 10);
		lblNewLabel.setSize("775px", "31px");

		tabDestekAlmakIstiyorum = new TabPanel();
		tabDestekAlmakIstiyorum.setAnimationEnabled(true);
		absolutePanel.add(tabDestekAlmakIstiyorum, 25, 67);
		tabDestekAlmakIstiyorum.setSize("614px", "239px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_2.setStyleName("gwt-DialogBackGround");
		tabDestekAlmakIstiyorum.add(absolutePanel_2, "Destek İstiyorum", false);
		absolutePanel_2.setSize("605px", "323px");

		Label lblNewLabel_1 = new Label("Soru, İstek veya Hata Bildirme Formu");
		lblNewLabel_1.setStyleName("gwt-LabelMor");
		absolutePanel_2.add(lblNewLabel_1, 0, 0);
		lblNewLabel_1.setSize("100%", "28px");

		Label lblNewLabel_2 = new Label("Konu");
		lblNewLabel_2.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblNewLabel_2, 10, 46);

		Label lblNewLabel_3 = new Label("Bölüm");
		lblNewLabel_3.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblNewLabel_3, 10, 77);

		tctKonu = new TextBox();
		tctKonu.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctKonu, 107, 44);
		tctKonu.setSize("240px", "16px");

		cbxBolum = new ListBox();
		cbxBolum.addItem("KAYIT İŞLEMLERİ");
		cbxBolum.addItem("ÖĞRENCİ İŞLERİ");
		cbxBolum.addItem("DERS DAĞITIM");
		cbxBolum.addItem("ÖDEV TAKİP");
		cbxBolum.addItem("SINAV DEĞERLENDİRME");
		cbxBolum.addItem("MUHASEBE");
		cbxBolum.addItem("MEVZUAT");
		cbxBolum.addItem("DONEMSEL TANIMLAR");
		cbxBolum.addItem("SABİT TANIMLAMALAR");
		cbxBolum.addItem("DESTEK");
		cbxBolum.addItem("YETKİ");
		cbxBolum.setStyleName("gwt-ComboBox1");
		absolutePanel_2.add(cbxBolum, 107, 77);
		cbxBolum.setSize("155px", "25px");

		tctMesajiniz = new TextArea();
		tctMesajiniz.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctMesajiniz, 107, 111);
		tctMesajiniz.setSize("236px", "88px");

		Label lblMesajnz = new Label("Mesajınız");
		lblMesajnz.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblMesajnz, 10, 111);

		Button btnKaydet = new Button("Kaydet");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel_2.add(btnKaydet, 188, 228);
		btnKaydet.setSize("78px", "46px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabDestekAlmakIstiyorum.add(absolutePanel_1, "Gönderilen Mesajlar",
				false);
		absolutePanel_1.setSize("503px", "321px");
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putdestekalmakistiyorum?";
			URLValue = URLValue + "konu=" + tctKonu.getText();
			URLValue = URLValue + "&bolum="
					+ cbxBolum.getValue(cbxBolum.getSelectedIndex());
			URLValue = URLValue + "&mesajiniz=" + tctMesajiniz.getText();
			Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}
}
