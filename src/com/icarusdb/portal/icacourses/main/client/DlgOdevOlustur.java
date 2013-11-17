package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.widget.client.TextButton;

public class DlgOdevOlustur extends DialogBox {
	private ListBox cbxEgitimTuru;
	private TextBox tctOdevAdi;
	private ListBox cbxAlan;
	private ListBox cbxDers;
	private ListBox cbxUnite;
	private TextBox tctSoruSayisi;
	private AbsolutePanel absolutePanel;
	public DecoratedTabPanel tabOdevTakip;

	public DlgOdevOlustur() {
		setHTML("Ödev Takip ( Ekleme / Düzenleme)");

		absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("625px", "449px");

		tabOdevTakip = new DecoratedTabPanel();
		absolutePanel.add(tabOdevTakip, 10, 32);
		tabOdevTakip.setSize("640px", "449px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabOdevTakip.add(absolutePanel_1, "Ödev Bilgileri", false);
		absolutePanel_1.setSize("544px", "373px");

		Label lbldevAd = new Label("Ödev Adı");
		absolutePanel_1.add(lbldevAd, 10, 10);

		Label lblEitimTr = new Label("Eğitim Türü");
		absolutePanel_1.add(lblEitimTr, 10, 48);
		lblEitimTr.setSize("85px", "18px");

		Label lblAlan = new Label("Alan");
		absolutePanel_1.add(lblAlan, 10, 86);

		Label lblDers = new Label("Ders");
		absolutePanel_1.add(lblDers, 10, 121);

		Label lblUnite = new Label("Ünite");
		absolutePanel_1.add(lblUnite, 6, 159);

		Label lblSoruSays = new Label("Soru Sayısı");
		absolutePanel_1.add(lblSoruSays, 10, 195);

		tctOdevAdi = new TextBox();
		tctOdevAdi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctOdevAdi, 111, 10);
		tctOdevAdi.setSize("149px", "14px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.addItem("YGS HAZIRLIK");
		cbxEgitimTuru.addItem("14");
		cbxEgitimTuru.addItem("2");
		cbxEgitimTuru.addItem(" ");
		absolutePanel_1.add(cbxEgitimTuru, 111, 44);
		cbxEgitimTuru.setSize("151px", "22px");

		cbxAlan = new ListBox();
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem("a");
		cbxAlan.addItem("");
		cbxAlan.addItem("b ");
		absolutePanel_1.add(cbxAlan, 111, 82);
		cbxAlan.setSize("151px", "22px");

		cbxDers = new ListBox();
		cbxDers.setStyleName("gwt-ComboBox1");
		cbxDers.addItem("1");
		cbxDers.addItem("2 ");
		absolutePanel_1.add(cbxDers, 111, 117);
		cbxDers.setSize("151px", "22px");

		cbxUnite = new ListBox();
		cbxUnite.setStyleName("gwt-ComboBox1");
		cbxUnite.addItem("1");
		cbxUnite.addItem("2 ");
		absolutePanel_1.add(cbxUnite, 111, 155);
		cbxUnite.setSize("151px", "22px");

		tctSoruSayisi = new TextBox();
		tctSoruSayisi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctSoruSayisi, 111, 195);
		tctSoruSayisi.setSize("149px", "14px");

		Button btnKaydet = new Button("Kaydet");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel_1.add(btnKaydet, 150, 238);
		btnKaydet.setSize("78px", "36px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_2.setStyleName("gwt-DialogBackGround");
		tabOdevTakip.add(absolutePanel_2, "Ödev Cevapları", false);
		absolutePanel_2.setSize("585px", "369px");

		CellTable<Object> grdOdevCevaplari = new CellTable<Object>();
		absolutePanel_2.add(grdOdevCevaplari, 10, 10);
		grdOdevCevaplari.setSize("537px", "156px");

		Column<Object, Number> column = new Column<Object, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Object object) {
				return (Number) null;
			}
		};
		grdOdevCevaplari.addColumn(column, "Soru No");

		TextColumn<Object> textColumn = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		grdOdevCevaplari.addColumn(textColumn, "Cevaplar");

		Button btnYenikayit = new Button("Yeni Kayit");
		btnYenikayit.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_2.add(btnYenikayit, 159, 190);
		btnYenikayit.setSize("78px", "47px");

		Button btnCevaplarIeriAl = new Button("Cevapları İçeri Al");
		absolutePanel_2.add(btnCevaplarIeriAl, 235, 190);
		btnCevaplarIeriAl.setSize("78px", "47px");

		Button btnCevaplariDısariAl = new Button("Cevapları Dışarı Al");
		absolutePanel_2.add(btnCevaplariDısariAl, 310, 190);
		btnCevaplariDısariAl.setSize("78px", "47px");

		Button btnCevaplariKaydet = new Button("Cevapları Kaydet");
		btnCevaplariKaydet.setStyleName("gwt-ButtonSave");
		absolutePanel_2.add(btnCevaplariKaydet, 385, 190);
		btnCevaplariKaydet.setSize("78px", "47px");

		Button btnKapat = new Button("Kapat");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel_2.add(btnKapat, 457, 190);
		btnKapat.setSize("78px", "47px");

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		tabOdevTakip.add(absolutePanel_3, "Dosya Ekle", false);
		absolutePanel_3.setSize("624px", "391px");

		Label lblDosyaAklama = new Label("Dosya Açıklama");
		absolutePanel_3.add(lblDosyaAklama, 10, 10);

		Label lblNewLabel = new Label("Dosya Ekle");
		absolutePanel_3.add(lblNewLabel, 10, 34);

		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox1");
		absolutePanel_3.add(textBox, 134, 6);
		textBox.setSize("300px", "15px");

		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox1");
		absolutePanel_3.add(textBox_1, 134, 38);
		textBox_1.setSize("143px", "15px");

		TextButton txtbtnNewButton = new TextButton("Seç");
		absolutePanel_3.add(txtbtnNewButton, 299, 34);
		txtbtnNewButton.setSize("85px", "27px");

		CellTable<Object> cellTable = new CellTable<Object>();
		absolutePanel_3.add(cellTable, 10, 132);
		cellTable.setSize("516px", "156px");

		TextColumn<Object> textColumn_1 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_1, "Dosya Linki");

		Column<Object, String> column_1 = new Column<Object, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable.addColumn(column_1, "İşlemler");

		Button btnDosyayiKaydet = new Button("Dosyayı Kaydet");
		absolutePanel_3.add(btnDosyayiKaydet, 448, 60);
		btnDosyayiKaydet.setSize("78px", "44px");

		Label lbldevIlemleriekleme = new Label(
				"Ödev İşlemleri (Ekleme / Düzenleme)");
		lbldevIlemleriekleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lbldevIlemleriekleme, 0, 0);
		lbldevIlemleriekleme.setSize("625px", "28px");
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putodevolustur?";
			URLValue = URLValue + "odev_adi=" + tctOdevAdi.getText();
			URLValue = URLValue + "&egitim_turu="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&alan="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders="
					+ cbxDers.getValue(cbxDers.getSelectedIndex());
			URLValue = URLValue + "&unite="
					+ cbxUnite.getValue(cbxUnite.getSelectedIndex());
			URLValue = URLValue + "&soru_sayisi=" + tctSoruSayisi.getText();

			Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}
}
