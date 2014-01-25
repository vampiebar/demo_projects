package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgIndirimTuru extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctIndirimTuru;
	private ListBox cbxIndirimSekli;
	private TextBox tctIndirimMiktari;
	private Button btnKaydet;

	public DlgIndirimTuru(boolean isInsert, long id) {
		setAnimationEnabled(true);
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("İndirim Türü İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("586px", "452px");

		Label lblIndirimTrIlemleri = new Label(
				"İndirim Türü İşlemleri (Ekleme / Düzenleme)");
		lblIndirimTrIlemleri.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblIndirimTrIlemleri, 0, 0);
		lblIndirimTrIlemleri.setSize("586px", "28px");

		Label lblIndirimTr = new Label("İndirim Türü");
		lblIndirimTr.setStyleName("gwt-Bold");
		absolutePanel.add(lblIndirimTr, 10, 52);
		lblIndirimTr.setSize("105px", "18px");

		Label lblInidirmekli = new Label("İnidirm Şekli");
		lblInidirmekli.setStyleName("gwt-Bold");
		absolutePanel.add(lblInidirmekli, 10, 93);
		lblInidirmekli.setSize("105px", "18px");

		Label lblIndrmMiktar = new Label("İndirim Miktarı");
		lblIndrmMiktar.setStyleName("gwt-Bold");
		absolutePanel.add(lblIndrmMiktar, 10, 136);
		lblIndrmMiktar.setSize("105px", "18px");

		tctIndirimTuru = new TextBox();
		tctIndirimTuru.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctIndirimTuru, 127, 52);
		tctIndirimTuru.setSize("149px", "14px");

		tctIndirimMiktari = new TextBox();
		tctIndirimMiktari.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctIndirimMiktari, 127, 135);
		tctIndirimMiktari.setSize("149px", "14px");

		cbxIndirimSekli = new ListBox();
		cbxIndirimSekli.setStyleName("gwt-ComboBox1");
		cbxIndirimSekli.addItem("Para");
		cbxIndirimSekli.addItem("Yüzde");
		absolutePanel.add(cbxIndirimSekli, 127, 93);
		cbxIndirimSekli.setSize("151px", "22px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 437, 275);
		btnKapat.setSize("78px", "45px");

		Button btnYeniKAyit = new Button("New button");
		btnYeniKAyit.addClickHandler(new BtnYeniKAyitClickHandler());
		btnYeniKAyit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKAyit.setText("Yeni Kayıt");
		absolutePanel.add(btnYeniKAyit, 282, 179);
		btnYeniKAyit.setSize("78px", "53px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 353, 275);
		btnKaydet.setSize("78px", "45px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 371, 166);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 449, 166);
		image_1.setSize("72px", "66px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putindirimturu?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&indirim_turu=" + tctIndirimTuru.getText();
			URLValue = URLValue
					+ "&indirim_sekli="
					+ cbxIndirimSekli.getValue(cbxIndirimSekli
							.getSelectedIndex());
			URLValue = URLValue + "&indirim_miktari="
					+ tctIndirimMiktari.getText();
			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLIndirimTuru xml) {
		tctIndirimMiktari.setText(xml.indirim_miktari);
		tctIndirimTuru.setText(xml.indirim_turu);
		cbxIndirimSekli.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxIndirimSekli, xml.indirim_sekli));
	}

	private class BtnYeniKAyitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			tctIndirimMiktari.setText("");
			tctIndirimTuru.setText("");
			cbxIndirimSekli.setSelectedIndex(0);

		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKaydet.click();
		}
	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}
}
