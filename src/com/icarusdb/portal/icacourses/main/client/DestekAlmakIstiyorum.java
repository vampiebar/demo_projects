package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DestekAlmakIstiyorum extends Composite {
	private TextBox tctKonu;
	private ListBox cbxBolum;
	private TextArea tctMesajiniz;
	public TabPanel tabDestekAlmakIstiyorum;
	private Image image;
	private Button btnKaydet;

	public DestekAlmakIstiyorum() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "457px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "33px");

		Label lblDestekAlmakIstiyorum = new Label("Destek Almak İstiyorum");
		horizontalPanel.add(lblDestekAlmakIstiyorum);
		lblDestekAlmakIstiyorum.setWidth("100%");

		tabDestekAlmakIstiyorum = new TabPanel();
		verticalPanel.add(tabDestekAlmakIstiyorum);
		tabDestekAlmakIstiyorum.setAnimationEnabled(true);
		tabDestekAlmakIstiyorum.setSize("659px", "387px");

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
		tctMesajiniz.setStyleName("gwt-TextAreaResible");
		absolutePanel_2.add(tctMesajiniz, 107, 111);
		tctMesajiniz.setSize("236px", "88px");

		Label lblMesajnz = new Label("Mesajınız");
		lblMesajnz.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblMesajnz, 10, 111);

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		btnKaydet.setText("");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel_2.add(btnKaydet, 57, 224);
		btnKaydet.setSize("78px", "59px");

		image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());
		absolutePanel_2.add(image, 196, 224);
		image.setSize("72px", "66px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabDestekAlmakIstiyorum.add(absolutePanel_1, "Gönderilen Mesajlar",
				false);
		absolutePanel_1.setSize("605px", "323px");
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

	private class ImageMouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image.setUrl("kaydet-2.png");

		}
	}

	private class ImageMouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image.setUrl("kaydet-1.png");

		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			btnKaydet.click();

		}
	}
}
