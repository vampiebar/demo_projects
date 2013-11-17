package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgOdevTakipUnite extends DialogBox {
	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private ListBox cbxDers;
	private TextBox tctUnite;

	public DlgOdevTakipUnite() {
		setHTML("Ödev Takip Ünite Ekleme / Düzenleme ");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("562px", "460px");

		Label lbldevTakipnite = new Label(
				"Ödev Takip Ünite İşlemleri (Ekleme / Düzenleme)");
		lbldevTakipnite.setStyleName("gwt-LabelMor");
		absolutePanel.add(lbldevTakipnite, 0, 0);
		lbldevTakipnite.setSize("562px", "28px");

		Label lblEitimTr = new Label("Eğitim Türü");
		absolutePanel.add(lblEitimTr, 10, 53);

		Label lblAlan = new Label("Alan");
		absolutePanel.add(lblAlan, 10, 90);

		Label lblDers = new Label("Ders");
		absolutePanel.add(lblDers, 10, 135);

		Label lblnite = new Label("Ünite");
		absolutePanel.add(lblnite, 10, 174);

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.addItem("1");
		cbxEgitimTuru.addItem("");
		cbxEgitimTuru.addItem("2 ");
		absolutePanel.add(cbxEgitimTuru, 118, 45);
		cbxEgitimTuru.setSize("163px", "22px");

		cbxAlan = new ListBox();
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem("1");
		cbxAlan.addItem("2");
		cbxAlan.addItem(" ");
		absolutePanel.add(cbxAlan, 118, 86);
		cbxAlan.setSize("163px", "22px");

		cbxDers = new ListBox();
		cbxDers.setStyleName("gwt-ComboBox1");
		cbxDers.addItem("a");
		cbxDers.addItem("b ");
		absolutePanel.add(cbxDers, 118, 131);
		cbxDers.setSize("163px", "22px");

		tctUnite = new TextBox();
		tctUnite.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctUnite, 118, 174);
		tctUnite.setSize("161px", "14px");

		Button btnKaydet = new Button("Kaydet");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 324, 218);
		btnKaydet.setSize("78px", "43px");

		Button btnKapat = new Button("Kapat");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel.add(btnKapat, 416, 218);
		btnKapat.setSize("78px", "43px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putodevtakipunite?";
			URLValue = URLValue + "egitim_turu="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&alan="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders="
					+ cbxDers.getValue(cbxDers.getSelectedIndex());

			URLValue = URLValue + "&unite=" + tctUnite.getText();

			Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}
}
