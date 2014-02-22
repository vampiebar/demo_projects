package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;

public class dlgsanlon_baris extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctSablonAdi;
	private ListBox cbxSinavTuru;
	private Button btnSablonuKaydet;
	private FlexTable flxSablonParametreleri;
	private Label lblParametreAdi;
	private IntegerBox tctBit;
	private IntegerBox tctBas;
	private XMLSablonTanimlari _xml;
	private Button btnRemoveParameter;

	public dlgsanlon_baris(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Dönem Ekle/Değiştir");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("744px", "619px");

		Label lblNewLabel = new Label(
				"Form Şablonu Tanımlama (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("744px", "28px");

		Label lblablonAd = new Label("Şablon Kodu");
		lblablonAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblablonAd, 10, 46);

		tctSablonAdi = new TextBox();
		tctSablonAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSablonAdi, 130, 44);
		tctSablonAdi.setSize("149px", "16px");

		Label lblNewLabel_3 = new Label("Parametreler");
		lblNewLabel_3.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel_3, 0, 104);
		lblNewLabel_3.setSize("744px", "29px");

		Button btnParametreDegeriEkle = new Button("Parametre Değeri Ekle");
		absolutePanel.add(btnParametreDegeriEkle, 10, 139);
		btnParametreDegeriEkle.setSize("169px", "22px");

		btnSablonuKaydet = new Button("New button");
		btnSablonuKaydet.setVisible(false);
		btnSablonuKaydet.setStyleName("gwt-ButtonSave");
		btnSablonuKaydet.addClickHandler(new BtnSablonuKaydetClickHandler());
		btnSablonuKaydet.setText("Şablonu Kaydet");
		absolutePanel.add(btnSablonuKaydet, 549, 354);
		btnSablonuKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 656, 354);
		btnKapat.setSize("78px", "45px");

		Label lblNewLabel_4 = new Label("Gruplar");
		lblNewLabel_4.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel_4, 0, 174);
		lblNewLabel_4.setSize("744px", "30px");

		Label lblSnavTr = new Label("Sınav Türü");
		lblSnavTr.setStyleName("gwt-Bold");
		absolutePanel.add(lblSnavTr, 10, 221);

		cbxSinavTuru = new ListBox();
		cbxSinavTuru.setStyleName("gwt-ComboBox1");
		cbxSinavTuru.addItem("Lütfen Seçiniz");
		absolutePanel.add(cbxSinavTuru, 102, 219);
		cbxSinavTuru.setSize("139px", "22px");

		Button btnSinavaAitBilgileriYukle = new Button("New button");
		btnSinavaAitBilgileriYukle.setText("Sınava Ait Bilgileri Yükle");
		absolutePanel.add(btnSinavaAitBilgileriYukle, 260, 217);
		btnSinavaAitBilgileriYukle.setSize("186px", "23px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 537, 265);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 625, 265);
		image_1.setSize("72px", "66px");

		Label label = new Label("Şablon Adı");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 10, 69);
		label.setSize("71px", "15px");

		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox1");
		absolutePanel.add(textBox, 130, 67);
		textBox.setSize("149px", "16px");

		ScrollPanel scrollPanel = new ScrollPanel();
		absolutePanel.add(scrollPanel, 10, 242);
		scrollPanel.setSize("520px", "342px");

		flxSablonParametreleri = new FlexTable();
		flxSablonParametreleri.setBorderWidth(1);
		scrollPanel.setWidget(flxSablonParametreleri);
		flxSablonParametreleri.setSize("100%", "100%");

		lblParametreAdi = new Label("...");
		flxSablonParametreleri.setWidget(0, 0, lblParametreAdi);

		tctBas = new IntegerBox();
		flxSablonParametreleri.setWidget(0, 1, tctBas);

		tctBit = new IntegerBox();
		flxSablonParametreleri.setWidget(0, 2, tctBit);

		btnRemoveParameter = new Button("New button");
		btnRemoveParameter.setText("X");
		flxSablonParametreleri.setWidget(0, 3, btnRemoveParameter);

		ListBox comboBox = new ListBox();
		absolutePanel.add(comboBox, 466, 139);

		TextBox tctParametre = new TextBox();
		absolutePanel.add(tctParametre, 185, 139);
		tctParametre.setSize("96px", "13px");

		if (!isDesignTime()) {

			// Sablonu oku ve gerekli yerlere getir

		}

	}

	private boolean isDesignTime() {

		return false;
	}

	private void putSablonDegerleri(XMLSablonTanimlari xml) {

		// Window.alert(xml.sablon);
		flxSablonParametreleri.clear();

		// Olmazsa olmaz alanlar

		String parametreler[] = xml.sablon.split("zzz");

		for (int i = 0; i < parametreler.length; i++) {

			String grup = "";
			String ders = "";

			ListBox cbxGrup = new ListBox();

			ListBox cbxDers = new ListBox();

			TextBox tctOther = new TextBox();

			HorizontalPanel panel1 = new HorizontalPanel();

			panel1.add(cbxGrup);
			panel1.add(cbxDers);
			panel1.add(tctOther);

			if (parametreler[i].contains("$$$")) {

				grup = parametreler[i].split("___")[0].split("$$$")[0];
				// ders = parametreler[i].split("___")[0].split("$$$")[1];

			} else {

				tctOther.setText(".");
			}

			String bas = parametreler[i].split("___")[1].split("---")[0];
			String bit = parametreler[i].split("___")[1].split("---")[1];

			cbxGrup.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {

					// putGrupDersleri(i);

				}
			});

			IntegerBox basBox = new IntegerBox();
			basBox.setValue(new Integer(bas).intValue());

			IntegerBox bitBox = new IntegerBox();
			bitBox.setValue(new Integer(bit).intValue());

			boolean isGrupDers = !tctOther.getText().equalsIgnoreCase(".");
			cbxGrup.setVisible(isGrupDers);
			cbxDers.setVisible(isGrupDers);
			tctOther.setVisible(!isGrupDers);
			tctOther.setText(parametreler[i].split("___")[0].split("$$$")[0]);

			Button btnRemoveParameter = new Button("");
			btnRemoveParameter.setText("X");
			btnRemoveParameter.setTitle(i + "");

			final int index = i;
			btnRemoveParameter.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					flxSablonParametreleri.removeRow(index);
				}
			});

			flxSablonParametreleri.setWidget(i, 0, panel1);

			flxSablonParametreleri.setWidget(i, 1, basBox);
			flxSablonParametreleri.setWidget(i, 2, bitBox);
			flxSablonParametreleri.setWidget(i, 3, btnRemoveParameter);

		}

	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnSablonuKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putsablontanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&sablon_adi=" + tctSablonAdi.getText();
			URLValue = URLValue + "&sinav_turu="
					+ cbxSinavTuru.getValue(cbxSinavTuru.getSelectedIndex());
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLSablonTanimlari xml) {

		tctSablonAdi.setText(xml.sablon_adi);
		cbxSinavTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxSinavTuru, xml.sinav_turu));

		putSablonDegerleri(xml);

	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnSablonuKaydet.click();
		}
	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}
}
