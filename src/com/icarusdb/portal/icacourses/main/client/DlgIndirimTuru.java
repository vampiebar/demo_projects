package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
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
	private Image image;
	private Image image_1;

	public DlgIndirimTuru(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("İndirim Türü İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("555px", "392px");

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
		btnYeniKAyit.setText("");
		absolutePanel.add(btnYeniKAyit, 289, 110);
		btnYeniKAyit.setSize("84px", "66px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 353, 275);
		btnKaydet.setSize("78px", "45px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 378, 110);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 456, 110);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("295px", "72px");

		Label lblIndirimTr = new Label("İndirim Türü");
		flexTable.setWidget(0, 0, lblIndirimTr);
		lblIndirimTr.setStyleName("gwt-Bold");
		lblIndirimTr.setSize("105px", "18px");

		tctIndirimTuru = new TextBox();
		flexTable.setWidget(0, 1, tctIndirimTuru);
		tctIndirimTuru.setStyleName("gwt-TextBox1");
		tctIndirimTuru.setSize("149px", "15px");

		Label lblInidirmekli = new Label("İnidirm Şekli");
		flexTable.setWidget(1, 0, lblInidirmekli);
		lblInidirmekli.setStyleName("gwt-Bold");
		lblInidirmekli.setSize("105px", "18px");

		cbxIndirimSekli = new ListBox();
		flexTable.setWidget(1, 1, cbxIndirimSekli);
		cbxIndirimSekli.setStyleName("gwt-ComboBox1");
		cbxIndirimSekli.addItem("Para");
		cbxIndirimSekli.addItem("Yüzde");
		cbxIndirimSekli.setSize("151px", "22px");

		Label lblIndrmMiktar = new Label("İndirim Miktarı");
		flexTable.setWidget(2, 0, lblIndrmMiktar);
		lblIndrmMiktar.setStyleName("gwt-Bold");
		lblIndrmMiktar.setSize("105px", "18px");

		tctIndirimMiktari = new TextBox();
		tctIndirimMiktari
				.addKeyPressHandler(new TctIndirimMiktariKeyPressHandler());
		flexTable.setWidget(2, 1, tctIndirimMiktari);
		tctIndirimMiktari.setStyleName("gwt-TextBox1");
		tctIndirimMiktari.setSize("149px", "15px");
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
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";
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

	private class Image_1MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_1.setUrl("kapat-2.png");

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

	private class Image_1MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_1.setUrl("kapat-1.png");

		}
	}

	private class TctIndirimMiktariKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctIndirimMiktari.getText();
			if (!input.matches("[0-9]*")) {
				tctIndirimMiktari.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctIndirimMiktari.setStyleName("gwt-TextBox1");

		}
	}
}
