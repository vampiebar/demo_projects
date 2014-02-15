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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SifreDegistirme extends Composite {
	private TextBox tctEskiSifre;
	private TextBox tctYeniSifre;
	private TextBox tctTekrarYeniSifre;
	private Image image;
	private Button btnKaydet;

	public SifreDegistirme() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "433px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHeight(horizontalPanel, "50");
		horizontalPanel.setSize("100%", "33px");

		Label lblifreDeitirme = new Label("Şifre Değiştirme");
		horizontalPanel.add(lblifreDeitirme);
		lblifreDeitirme.setWidth("100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "119");
		horizontalPanel_2.setWidth("100%");

		Label lblNewLabel_1 = new Label("");
		horizontalPanel_2.add(lblNewLabel_1);
		lblNewLabel_1.setWidth("16px");

		FlexTable flexTable = new FlexTable();
		horizontalPanel_2.add(flexTable);
		verticalPanel.setCellHeight(flexTable, "119");
		flexTable.setSize("351px", "100px");

		Label lblVarolanifreniziDeitirin = new Label(
				"Varolan Şifrenizi Değiştirin");
		flexTable.setWidget(0, 0, lblVarolanifreniziDeitirin);
		lblVarolanifreniziDeitirin.setSize("176px", "23px");
		lblVarolanifreniziDeitirin.setStyleName("gwt-Bold");

		Label lblEskisifre = new Label("Eski Şifre");
		flexTable.setWidget(1, 0, lblEskisifre);
		lblEskisifre.setStyleName("gwt-Bold");
		lblEskisifre.setSize("78px", "16px");

		tctEskiSifre = new TextBox();
		flexTable.setWidget(1, 1, tctEskiSifre);
		tctEskiSifre.setStyleName("gwt-TextBox1");
		tctEskiSifre.setSize("151px", "16px");

		Label lblYeni = new Label("Yeni Şifre");
		flexTable.setWidget(2, 0, lblYeni);
		lblYeni.setStyleName("gwt-Bold");
		lblYeni.setSize("120px", "16px");

		tctYeniSifre = new TextBox();
		flexTable.setWidget(2, 1, tctYeniSifre);
		tctYeniSifre.setStyleName("gwt-TextBox1");
		tctYeniSifre.setSize("151px", "16px");

		Label lblNewLabel = new Label("Tekrar Yeni Şifre");
		flexTable.setWidget(3, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");
		lblNewLabel.setSize("129px", "16px");

		tctTekrarYeniSifre = new TextBox();
		flexTable.setWidget(3, 1, tctTekrarYeniSifre);
		tctTekrarYeniSifre.setStyleName("gwt-TextBox1");
		tctTekrarYeniSifre.setSize("151px", "16px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("100%");

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		horizontalPanel_1.add(btnKaydet);
		horizontalPanel_1.setCellWidth(btnKaydet, "279");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setSize("78px", "51px");

		image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());
		horizontalPanel_1.add(image);
		image.setSize("72px", "66px");
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
