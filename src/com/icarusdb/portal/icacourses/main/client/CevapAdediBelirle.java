package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CevapAdediBelirle extends Composite {
	private TextBox tctCevapSayisi;
	private ListBox cbxEgitimTuru;
	private Button btnKaydet;

	public CevapAdediBelirle() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "431px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHeight(horizontalPanel, "50");
		horizontalPanel.setSize("100%", "33px");

		Label lblCevapAdediBelirle = new Label("Cevap Adedi Belirle");
		horizontalPanel.add(lblCevapAdediBelirle);
		lblCevapAdediBelirle.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "119");
		horizontalPanel_1.setWidth("100%");

		Label lblNewLabel_2 = new Label("");
		horizontalPanel_1.add(lblNewLabel_2);
		lblNewLabel_2.setWidth("10px");

		FlexTable flexTable = new FlexTable();
		horizontalPanel_1.add(flexTable);
		flexTable.setSize("242px", "100px");

		Label lblNewLabel = new Label("Eğitim Türü");
		flexTable.setWidget(0, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");

		cbxEgitimTuru = new ListBox();
		flexTable.setWidget(0, 1, cbxEgitimTuru);
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.addItem("YGS HAZIRLIK");
		cbxEgitimTuru.addItem("YGS/LYS HAZIRLIK");
		cbxEgitimTuru.addItem("11.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("10.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("9.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("SBS HAZIRLIK");
		cbxEgitimTuru.addItem("8.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("7.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("6.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("5.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("4.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("3.SINIF TAKVİYE");
		cbxEgitimTuru.setSize("151px", "25px");

		Label lblNewLabel_1 = new Label("Cevap Sayısı");
		flexTable.setWidget(1, 0, lblNewLabel_1);
		lblNewLabel_1.setWidth("85px");
		lblNewLabel_1.setStyleName("gwt-Bold");

		tctCevapSayisi = new TextBox();
		flexTable.setWidget(1, 1, tctCevapSayisi);
		tctCevapSayisi.setStyleName("gwt-TextBox1");
		tctCevapSayisi.setSize("149px", "16px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_2);
		horizontalPanel_2.setWidth("100%");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		horizontalPanel_2.add(btnKaydet);
		horizontalPanel_2.setCellWidth(btnKaydet, "176");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		btnKaydet.setSize("78px", "61px");

		Image image = new Image("kaydet-1.png");
		horizontalPanel_2.add(image);
		image.addClickHandler(new ImageClickHandler());
		image.setSize("72px", "66px");
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putcevapadedibelirle?";
			URLValue = URLValue + "egitim_turu="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&cevap_sayisi=" + tctCevapSayisi.getText();
			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			btnKaydet.click();

		}
	}
}
