package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
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
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
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
	private FlexTable flxOdevCevaplari;
	private ListBox cbxSonHarf;
	private Image image_2;
	private Image image_3;
	private Button btnCevaplariKaydet;

	public DlgOdevOlustur(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Ödev Takip ( Ekleme / Düzenleme)");

		absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("616px", "456px");

		tabOdevOlustur = new DecoratedTabPanel();
		tabOdevOlustur
				.addSelectionHandler(new TabOdevOlusturSelectionHandler());
		tabOdevOlustur.setAnimationEnabled(true);
		absolutePanel.add(tabOdevOlustur, 0, 0);
		tabOdevOlustur.setSize("616px", "456px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabOdevOlustur.add(absolutePanel_1, "Ödev Bilgileri", false);
		absolutePanel_1.setSize("600px", "410px");

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
		absolutePanel_1.add(image, 325, 209);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel_1.add(image_1, 403, 209);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel_1.add(flexTable, 0, 0);
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
		tctSoruSayisi.addKeyPressHandler(new TctSoruSayisiKeyPressHandler());
		flexTable.setWidget(5, 1, tctSoruSayisi);
		tctSoruSayisi.setStyleName("gwt-TextBox1");
		tctSoruSayisi.setSize("149px", "16px");

		Label lblNewLabel_3 = new Label("Son Harf");
		lblNewLabel_3.setStyleName("gwt-Bold");
		flexTable.setWidget(6, 0, lblNewLabel_3);

		cbxSonHarf = new ListBox();
		cbxSonHarf.addItem("A");
		cbxSonHarf.addItem("B");
		cbxSonHarf.addItem("C");
		cbxSonHarf.addItem("D");
		cbxSonHarf.addItem("E");
		cbxSonHarf.addItem("F");
		cbxSonHarf.setStyleName("gwt-ComboBox1");
		flexTable.setWidget(6, 1, cbxSonHarf);
		cbxSonHarf.setSize("151px", "22px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_2.setStyleName("gwt-DialogBackGround");
		tabOdevOlustur.add(absolutePanel_2, "Ödev Cevapları", false);
		absolutePanel_2.setSize("600px", "410px");

		ScrollPanel scrollPanel = new ScrollPanel();
		absolutePanel_2.add(scrollPanel);
		scrollPanel.setSize("100%", "100%");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		scrollPanel.setWidget(verticalPanel_1);
		verticalPanel_1.setSize("100%", "100%");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel);
		verticalPanel_1.setCellHeight(horizontalPanel, "25");
		horizontalPanel.setSize("100%", "8px");

		Label lblSoruNo = new Label("Soru No");
		horizontalPanel.add(lblSoruNo);
		horizontalPanel.setCellWidth(lblSoruNo, "20");
		lblSoruNo.setWidth("92px");
		lblSoruNo.setStyleName("gwt-Bold");

		Label lblCevaplar = new Label("Cevaplar");
		horizontalPanel.add(lblCevaplar);
		lblCevaplar.setWidth("400px");
		lblCevaplar.setStyleName("gwt-Bold");

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel_1.add(verticalPanel);
		verticalPanel_1.setCellHeight(verticalPanel, "205");
		verticalPanel.setSize("100%", "199px");

		flxOdevCevaplari = new FlexTable();
		verticalPanel.add(flxOdevCevaplari);
		flxOdevCevaplari.setSize("30%", "100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel_1);
		horizontalPanel_1.setSize("100%", "66px");

		btnCevaplariKaydet = new Button("Cevapları Kaydet");
		btnCevaplariKaydet.setVisible(false);
		horizontalPanel_1.add(btnCevaplariKaydet);
		horizontalPanel_1.setCellWidth(btnCevaplariKaydet, "340");
		btnCevaplariKaydet
				.addClickHandler(new BtnCevaplariKaydetClickHandler());
		btnCevaplariKaydet.setStyleName("gwt-ButtonSave");
		btnCevaplariKaydet.setSize("78px", "47px");

		Button btnYenikayit = new Button("Yeni Kayit");
		horizontalPanel_1.add(btnYenikayit);
		btnYenikayit.setText("");
		btnYenikayit.setStyleName("gwt-ButonYeniKayit");
		btnYenikayit.setSize("90px", "66px");

		image_2 = new Image("kaydet-1.png");
		horizontalPanel_1.add(image_2);
		image_2.addMouseOutHandler(new Image_2MouseOutHandler());
		image_2.addMouseOverHandler(new Image_2MouseOverHandler());
		image_2.addClickHandler(new Image_2ClickHandler());
		image_2.setSize("72px", "66px");

		image_3 = new Image("kapat-1.png");
		horizontalPanel_1.add(image_3);
		image_3.addMouseOutHandler(new Image_3MouseOutHandler());
		image_3.addMouseOverHandler(new Image_3MouseOverHandler());
		image_3.addClickHandler(new Image_3ClickHandler());
		image_3.setSize("72px", "66px");

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		tabOdevOlustur.add(absolutePanel_3, "Dosya Ekle", false);
		absolutePanel_3.setSize("600px", "410px");

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

			for (int i = 0; i <= 4; i++) {

				flxOdevCevaplari.setWidget(i, 0, new Label("1"));

			}

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
			URLValue = URLValue + "&son_harf="
					+ cbxSonHarf.getValue(cbxSonHarf.getSelectedIndex());

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

		cbxSonHarf.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxSonHarf,
				xml.son_harf));

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

	private class TabOdevOlusturSelectionHandler implements
			SelectionHandler<Integer> {
		public void onSelection(SelectionEvent<Integer> event) {
			if (event.getSelectedItem() == 1) {
				showWithData(String.valueOf(_id));
			}

		}

		protected void showWithData(final String id) {

			String urlWithParameters = Util.urlBase + "getodevolustur?id=" + id;

			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
					urlWithParameters);

			// Window.alert("URL TO GET VALUES: " + urlWithParameters);
			try {
				Request request = builder.sendRequest(null,
						new RequestCallback() {
							public void onError(Request request,
									Throwable exception) {

							}

							@Override
							public void onResponseReceived(Request request,
									Response response) {

								// Window.alert("AAABBBCCC " +
								// response.getText());

								List<XMLOdevOlustur> listXmlOdevOlustur = XMLOdevOlustur.XML
										.readList(response.getText());

								putDataFromXML2(listXmlOdevOlustur.get(0));

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}

	}

	private void putDataFromXML2(XMLOdevOlustur xml) {

		// Window.alert("Soru Sayısı" + xml.soru_sayisi);

		int soruSayisi = new Integer(xml.soru_sayisi).intValue();

		flxOdevCevaplari.clear();

		for (int i = 0; i < soruSayisi; i++) {

			flxOdevCevaplari.setWidget(i, 0, new Label(i + ". Soru "));

			ListBox cbxSecenekler = new ListBox();

			cbxSecenekler.setTitle(i + "");

			cbxSecenekler.addItem("A");
			cbxSecenekler.addItem("B");
			cbxSecenekler.addItem("C");
			cbxSecenekler.addItem("D");
			cbxSecenekler.addItem("E");

			// for(;;)
			flxOdevCevaplari.setWidget(i, 1, cbxSecenekler);

		}

	}

	private class BtnCevaplariKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String cevaplar = produceAllAnswers();
			// Window.alert("Cevaplar:" + cevaplar);

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
			URLValue = URLValue + "&son_harf="
					+ cbxSonHarf.getValue(cbxSonHarf.getSelectedIndex());

			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			URLValue = URLValue + "&cevaplar=" + cevaplar;
			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	public String produceAllAnswers() {

		String answers = "";
		ListBox lbxTemp;
		for (int i = 0; i < flxOdevCevaplari.getRowCount(); i++) {

			lbxTemp = ((ListBox) flxOdevCevaplari.getWidget(i, 1));

			answers = answers + lbxTemp.getItemText(lbxTemp.getSelectedIndex());

		}

		return answers;
	}

	private class Image_3ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			hide();

		}
	}

	private class Image_2ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			btnCevaplariKaydet.click();

		}
	}

	private class TctSoruSayisiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctSoruSayisi.getText();
			if (!input.matches("[0-9]*")) {
				tctSoruSayisi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctSoruSayisi.setStyleName("gwt-TextBox1");

		}
	}

	private class Image_3MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_3.setUrl("kapat-2.png");

		}
	}

	private class Image_3MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_3.setUrl("kapat-1.png");

		}
	}

	private class Image_2MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_2.setUrl("kaydet-2.png");

		}
	}

	private class Image_2MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_2.setUrl("kaydet-1.png");

		}
	}
}
