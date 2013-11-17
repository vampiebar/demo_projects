package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgBankaEkle extends DialogBox {
	private Button btnKaydet;
	private TextBox tctBankaAdi;
	private TextBox tctBankaSube;
	private TextBox tctHesapNo;
	private TextBox tctIBANNo;
	private ListBox cbxBankaninOdemeSekli;
	private TextBox tctVadeTarihi;
	private Button btnKapat;

	public DlgBankaEkle() {
		setHTML("Banka İşlemleri (Ekleme / Düzenleme)");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("596px", "403px");

		Label lblBankaIlemleriekleme = new Label(
				"Banka İşlemleri (Ekleme / Düzenleme)");
		lblBankaIlemleriekleme.setVisible(false);
		lblBankaIlemleriekleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblBankaIlemleriekleme, 0, 0);
		lblBankaIlemleriekleme.setSize("596px", "30px");

		Label lblBankaAd = new Label("Banka Adı");
		lblBankaAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblBankaAd, 10, 63);

		Label lblBankaube = new Label("Banka Şube");
		lblBankaube.setStyleName("gwt-Bold");
		absolutePanel.add(lblBankaube, 10, 102);

		Label lblHesapNo = new Label("Hesap No");
		lblHesapNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblHesapNo, 10, 143);

		Label lblNewLabel = new Label("IBAN No");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 188);

		Label lblBankanndemeekli = new Label("Bankanın Ödeme Şekli");
		lblBankanndemeekli.setStyleName("gwt-Bold");
		absolutePanel.add(lblBankanndemeekli, 10, 229);

		Label lblVadeTarihi = new Label("Vade Tarihi");
		lblVadeTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblVadeTarihi, 10, 273);

		cbxBankaninOdemeSekli = new ListBox();
		cbxBankaninOdemeSekli.addItem("Ertesi Gün");
		cbxBankaninOdemeSekli.addItem("Vadeli");
		absolutePanel.add(cbxBankaninOdemeSekli, 243, 225);
		cbxBankaninOdemeSekli.setSize("198px", "22px");

		Label label = new Label("");
		absolutePanel.add(label, 154, 63);

		tctBankaAdi = new TextBox();
		tctBankaAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctBankaAdi, 246, 63);
		tctBankaAdi.setSize("193px", "14px");

		tctBankaSube = new TextBox();
		tctBankaSube.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctBankaSube, 246, 102);
		tctBankaSube.setSize("193px", "14px");

		tctHesapNo = new TextBox();
		tctHesapNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctHesapNo, 246, 143);
		tctHesapNo.setSize("193px", "14px");

		tctIBANNo = new TextBox();
		tctIBANNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctIBANNo, 246, 184);
		tctIBANNo.setSize("246px", "14px");

		tctVadeTarihi = new TextBox();
		tctVadeTarihi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVadeTarihi, 246, 273);
		tctVadeTarihi.setSize("193px", "14px");

		btnKaydet = new Button("Kaydet");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 274, 312);
		btnKaydet.setSize("78px", "46px");

		btnKapat = new Button("Kapat");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel.add(btnKapat, 366, 312);
		btnKapat.setSize("78px", "46px");

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
				cbxBankaninOdemeSekli, xml.bankanin_ödeme_sekli));
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putbankaekle?";

			URLValue = URLValue + "banka_adi=" + tctBankaAdi.getText();
			URLValue = URLValue + "&banka_sube=" + tctBankaSube.getText();
			URLValue = URLValue + "&hesap_no=" + tctHesapNo.getText();
			URLValue = URLValue + "&iban_no=" + tctIBANNo.getText();
			URLValue = URLValue
					+ "&bankanin_odeme_sekli="
					+ cbxBankaninOdemeSekli.getValue(cbxBankaninOdemeSekli
							.getSelectedIndex());
			URLValue = URLValue + "&vade_tarihi=" + tctVadeTarihi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue);
		}
	}
}
