package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
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
	public DecoratedTabPanel tabOdevOlustur;

	public boolean _isInsert = true;
	public long _id = -1;
	private Button btnKaydet;
	private Image image;
	private Image image_1;

	public DlgOdevOlustur(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Ödev Takip ( Ekleme / Düzenleme)");

		absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("625px", "472px");

		tabOdevOlustur = new DecoratedTabPanel();
		tabOdevOlustur.setAnimationEnabled(true);
		absolutePanel.add(tabOdevOlustur, 0, 0);
		tabOdevOlustur.setSize("615px", "442px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabOdevOlustur.add(absolutePanel_1, "Ödev Bilgileri", false);
		absolutePanel_1.setSize("600px", "400px");

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel_1.add(btnKaydet, 109, 256);
		btnKaydet.setSize("78px", "43px");

		image = new Image("kaydet-1.png");
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel_1.add(image, 255, 198);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel_1.add(image_1, 333, 198);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel_1.add(flexTable, 10, 10);
		flexTable.setSize("258px", "144px");

		Label lbldevAd = new Label("Ödev Adı");
		flexTable.setWidget(0, 0, lbldevAd);
		lbldevAd.setStyleName("gwt-Bold");
		lbldevAd.setSize("86px", "18px");

		tctOdevAdi = new TextBox();
		flexTable.setWidget(0, 1, tctOdevAdi);
		tctOdevAdi.setStyleName("gwt-TextBox1");
		tctOdevAdi.setSize("149px", "16px");

		Label lblEitimTr = new Label("Eğitim Türü");
		flexTable.setWidget(1, 0, lblEitimTr);
		lblEitimTr.setStyleName("gwt-Bold");
		lblEitimTr.setSize("86px", "18px");

		cbxEgitimTuru = new ListBox();
		flexTable.setWidget(1, 1, cbxEgitimTuru);
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.setSize("151px", "22px");

		Label lblAlan = new Label("Alan");
		flexTable.setWidget(2, 0, lblAlan);
		lblAlan.setStyleName("gwt-Bold");
		lblAlan.setSize("86px", "18px");

		cbxAlan = new ListBox();
		flexTable.setWidget(2, 1, cbxAlan);
		cbxAlan.addChangeHandler(new CbxAlanChangeHandler());
		cbxAlan.addItem(" ");
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.setSize("151px", "22px");

		Label lblDers = new Label("Ders");
		flexTable.setWidget(3, 0, lblDers);
		lblDers.setStyleName("gwt-Bold");
		lblDers.setSize("86px", "18px");

		cbxDers = new ListBox();
		flexTable.setWidget(3, 1, cbxDers);
		cbxDers.addChangeHandler(new CbxDersChangeHandler());
		cbxDers.addItem(" ");
		cbxDers.setStyleName("gwt-ComboBox1");
		cbxDers.setSize("151px", "22px");

		Label lblUnite = new Label("Ünite");
		flexTable.setWidget(4, 0, lblUnite);
		lblUnite.setStyleName("gwt-Bold");
		lblUnite.setSize("90px", "18px");

		cbxUnite = new ListBox();
		flexTable.setWidget(4, 1, cbxUnite);

		cbxUnite.addItem(" ");
		cbxUnite.setStyleName("gwt-ComboBox1");
		cbxUnite.setSize("151px", "22px");

		Label lblSoruSays = new Label("Soru Sayısı");
		flexTable.setWidget(5, 0, lblSoruSays);
		lblSoruSays.setStyleName("gwt-Bold");
		lblSoruSays.setSize("86px", "18px");

		tctSoruSayisi = new TextBox();
		flexTable.setWidget(5, 1, tctSoruSayisi);
		tctSoruSayisi.setStyleName("gwt-TextBox1");
		tctSoruSayisi.setSize("149px", "16px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_2.setStyleName("gwt-DialogBackGround");
		tabOdevOlustur.add(absolutePanel_2, "Ödev Cevapları", false);
		absolutePanel_2.setSize("600px", "400px");

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
		tabOdevOlustur.add(absolutePanel_3, "Dosya Ekle", false);
		absolutePanel_3.setSize("600px", "400px");

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

		if (!isDesignTime()) {

			putEgitimTuruToCbx(cbxEgitimTuru);

		}
	}

	private void putEgitimTuruToCbx(final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturu");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLEgitimTuru> xmlEgitimTuru = XMLEgitimTuru.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuru.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuru.get(i).egitim_turu_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putEgitimTuruAlanToCbx(String egitim_turu_adi,
			final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturutanimlama?egitim_turu_adi="
						+ egitim_turu_adi);
		// Window.alert("egitim_turu_adi=" + egitim_turu_adi);
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLEgitimTuruTanimlama> xmlEgitimTuruTanimlama = XMLEgitimTuruTanimlama.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuruTanimlama.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuruTanimlama.get(i).alan_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putDersAdiToCbx(String egitim_turu_adi, String alan_adi,
			final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getderstanimlari?egitim_turu_adi="
						+ egitim_turu_adi + "&alan_adi=" + alan_adi);

		// Window.alert(Util.urlBase + "getpostakodu?il=" + il + "&ilce=" +
		// ilce);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLDersTanimlari> xmlDersTanimlari = XMLDersTanimlari.XML
							.readList(response.getText());

					for (int i = 0; i < xmlDersTanimlari.size(); i++) {

						lbxTemp.addItem(xmlDersTanimlari.get(i).ders_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putUniteAdiToCbx(String egitim_turu, String alan, String ders,
			final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getodevtakipunite?egitim_turu=" + egitim_turu
						+ "&alan=" + alan + "&ders=" + ders);

		// Window.alert(Util.urlBase + "getpostakodu?il=" + il + "&ilce=" +
		// ilce);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLOdevTakipUnite> xmlOdevTakipUnite = XMLOdevTakipUnite.XML
							.readList(response.getText());

					for (int i = 0; i < xmlOdevTakipUnite.size(); i++) {

						lbxTemp.addItem(xmlOdevTakipUnite.get(i).unite);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private boolean isDesignTime() {

		return false;
	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putodevolustur?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&odev_adi=" + tctOdevAdi.getText();
			URLValue = URLValue
					+ "&egitim_turu="
					+ cbxEgitimTuru.getItemText(cbxEgitimTuru
							.getSelectedIndex());
			URLValue = URLValue + "&alan="
					+ cbxAlan.getItemText(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders="
					+ cbxDers.getItemText(cbxDers.getSelectedIndex());
			URLValue = URLValue + "&unite="
					+ cbxUnite.getItemText(cbxUnite.getSelectedIndex());
			URLValue = URLValue + "&soru_sayisi=" + tctSoruSayisi.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";
			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	public void putDataFromXML(XMLOdevOlustur xml) {
		tctSoruSayisi.setText(xml.soru_sayisi);
		tctOdevAdi.setText(xml.odev_adi);

		cbxEgitimTuru.setItemText(0, xml.egitim_turu);
		cbxAlan.setItemText(0, xml.alan);
		cbxDers.setItemText(0, xml.ders);
		cbxUnite.setItemText(0, xml.unite);

		// cbxDers.setSelectedIndex(Util
		// .GetLBXSelectedTextIndex(cbxDers, xml.ders));
		// cbxUnite.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxUnite,
		// xml.unite));

	}

	private class CbxEgitimTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxEgitimTuru.getSelectedIndex() + "");
			putEgitimTuruAlanToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxAlan);
		}
	}

	// private class CbxAlanChangeHandler implements ChangeHandler {
	// public void onChange(ChangeEvent event) {
	// putDersAdiToCbx(
	// cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
	// cbxAlan.getItemText(cbxAlan.getSelectedIndex()), cbxDers);
	// }
	// }
	private class CbxAlanChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putDersAdiToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxAlan.getItemText(cbxAlan.getSelectedIndex()), cbxDers);
		}
	}

	private class CbxDersChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putUniteAdiToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxAlan.getItemText(cbxAlan.getSelectedIndex()),
					cbxDers.getItemText(cbxDers.getSelectedIndex()), cbxUnite);
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
}
