package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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

public class DlgBankaEkle extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private Button btnKaydet;
	private TextBox tctBankaAdi;
	private TextBox tctBankaSube;
	private TextBox tctHesapNo;
	private TextBox tctIBANNo;
	private ListBox cbxBankaninOdemeSekli;
	private TextBox tctVadeTarihi;
	private Button btnKapat;
	private Image image;
	private Image image_1;

	public DlgBankaEkle(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;
		setHTML("Banka İşlemleri (Ekleme / Düzenleme)");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("596px", "403px");

		Label label = new Label("");
		absolutePanel.add(label, 154, 63);

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 238, 229);
		btnKaydet.setSize("78px", "46px");

		btnKapat = new Button("Kapat");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel.add(btnKapat, 154, 229);
		btnKapat.setSize("78px", "46px");

		image = new Image("kaydet-1.png");
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());

		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 374, 213);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());

		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 452, 213);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("435px", "163px");

		Label lblBankaAd = new Label("Banka Adı");
		flexTable.setWidget(0, 0, lblBankaAd);
		lblBankaAd.setStyleName("gwt-Bold");

		tctBankaAdi = new TextBox();
		flexTable.setWidget(0, 1, tctBankaAdi);
		tctBankaAdi.setStyleName("gwt-TextBox1");
		tctBankaAdi.setSize("193px", "14px");

		Label lblBankaube = new Label("Banka Şube");
		flexTable.setWidget(1, 0, lblBankaube);
		lblBankaube.setStyleName("gwt-Bold");

		tctBankaSube = new TextBox();
		flexTable.setWidget(1, 1, tctBankaSube);
		tctBankaSube.setStyleName("gwt-TextBox1");
		tctBankaSube.setSize("193px", "14px");

		Label lblHesapNo = new Label("Hesap No");
		flexTable.setWidget(2, 0, lblHesapNo);
		lblHesapNo.setStyleName("gwt-Bold");

		tctHesapNo = new TextBox();
		tctHesapNo.addKeyPressHandler(new TctHesapNoKeyPressHandler());
		flexTable.setWidget(2, 1, tctHesapNo);
		tctHesapNo.setStyleName("gwt-TextBox1");
		tctHesapNo.setSize("193px", "14px");

		Label lblNewLabel = new Label("IBAN No");
		flexTable.setWidget(3, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");

		tctIBANNo = new TextBox();
		tctIBANNo.addKeyPressHandler(new TctIBANNoKeyPressHandler());
		flexTable.setWidget(3, 1, tctIBANNo);
		tctIBANNo.setStyleName("gwt-TextBox1");
		tctIBANNo.setSize("246px", "14px");

		Label lblBankanndemeekli = new Label("Bankanın Ödeme Şekli");
		flexTable.setWidget(4, 0, lblBankanndemeekli);
		lblBankanndemeekli.setStyleName("gwt-Bold");

		cbxBankaninOdemeSekli = new ListBox();
		flexTable.setWidget(4, 1, cbxBankaninOdemeSekli);
		cbxBankaninOdemeSekli.setStyleName("gwt-ComboBox1");
		cbxBankaninOdemeSekli
				.addChangeHandler(new CbxBankaninOdemeSekliChangeHandler());
		cbxBankaninOdemeSekli.addItem("Ertesi Gün");
		cbxBankaninOdemeSekli.addItem("Vadeli");
		cbxBankaninOdemeSekli.setSize("198px", "22px");

		Label lblVadeTarihi = new Label("Vade Tarihi");
		flexTable.setWidget(5, 0, lblVadeTarihi);
		lblVadeTarihi.setStyleName("gwt-Bold");

		tctVadeTarihi = new TextBox();
		tctVadeTarihi.addKeyPressHandler(new TctVadeTarihiKeyPressHandler());
		flexTable.setWidget(5, 1, tctVadeTarihi);
		tctVadeTarihi.setEnabled(false);
		tctVadeTarihi.setText("0");
		tctVadeTarihi.setStyleName("gwt-TextBox1");
		tctVadeTarihi.setSize("193px", "14px");

		if (!isDesignTime()) {

		}
	}

	// Implement the following method exactly as-is
	private static final boolean isDesignTime() {
		// return Beans.isDesignTime(); // GWT 2.4 and above
		return false; // GWT 2.2 and earlier
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	public void putDataFromXML(XMLBankaEkle xml) {

		// Window.alert("adi:" + xml.adi);
		// Window.alert(xml);
		tctBankaAdi.setText(xml.banka_adi);
		tctBankaSube.setText(xml.banka_sube);
		tctHesapNo.setText(xml.hesap_no);
		tctIBANNo.setText(xml.iban_no);
		tctVadeTarihi.setText(xml.vade_tarihi);

		cbxBankaninOdemeSekli.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxBankaninOdemeSekli, xml.bankanin_odeme_sekli));

		if (cbxBankaninOdemeSekli.getSelectedIndex() == 1) {
			tctVadeTarihi.setEnabled(true);
		}

	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putbankaekle?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&banka_adi=" + tctBankaAdi.getText();
			URLValue = URLValue + "&banka_sube=" + tctBankaSube.getText();
			URLValue = URLValue + "&hesap_no=" + tctHesapNo.getText();
			URLValue = URLValue + "&iban_no=" + tctIBANNo.getText();
			URLValue = URLValue
					+ "&bankanin_odeme_sekli="
					+ cbxBankaninOdemeSekli.getValue(cbxBankaninOdemeSekli
							.getSelectedIndex());
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			URLValue = URLValue + "&vade_tarihi=" + tctVadeTarihi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "BANKA BİLGİLERİ KAYIT EDİLDİ",
					"BANKA BİLGİLERİ KAYIT EDİLEMEDİ");
		}
	}

	private class CbxBankaninOdemeSekliChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {

			if (cbxBankaninOdemeSekli.getSelectedIndex() == 1) {
				tctVadeTarihi.setEnabled(true);

			} else if (cbxBankaninOdemeSekli.getSelectedIndex() == 0) {
				tctVadeTarihi.setEnabled(false);
				tctVadeTarihi.setText("0");
			}
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

	private class TctHesapNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctHesapNo.getText();
			if (!input.matches("[0-9]*")) {
				tctHesapNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctHesapNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctIBANNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctIBANNo.getText();
			if (!input.matches("[0-9]*")) {
				tctIBANNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctIBANNo.setStyleName("gwt-TextBox1");

		}

	}

	private class TctVadeTarihiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctVadeTarihi.getText();
			if (!input.matches("[0-9]*")) {
				tctVadeTarihi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctVadeTarihi.setStyleName("gwt-TextBox1");

		}
	}
}
