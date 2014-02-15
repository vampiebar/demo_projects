package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgSinavTanimlama extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private Button btnKaydet;
	private Button btnKapat;
	private TextBox tctSinavNo;
	private TextBox tctSinavAdi;
	private DateBox dtpTarih;
	private TextBox tctSOnKitapcikNo;
	private ListBox cbxSablonSeciniz;
	private ListBox cbxSaat;
	private ListBox cbxDakika;
	private Image image;
	private Image image_1;

	public DlgSinavTanimlama(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Dönem  Ekle / Değiştir");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("541px", "409px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 287, 312);
		btnKaydet.setSize("78px", "50px");

		btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 393, 312);
		btnKapat.setSize("78px", "50px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 360, 139);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 438, 139);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("100px", "100px");

		Label label = new Label("Sınav No - Sınav Adı");
		flexTable.setWidget(0, 0, label);
		label.setStyleName("gwt-Bold");
		label.setSize("149px", "18px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flexTable.setWidget(0, 1, horizontalPanel);

		tctSinavNo = new TextBox();
		tctSinavNo.setMaxLength(1000);
		horizontalPanel.add(tctSinavNo);
		tctSinavNo.setStyleName("gwt-TextBox1");
		tctSinavNo.setSize("152px", "14px");

		Label label_4 = new Label("      -");
		horizontalPanel.add(label_4);
		label_4.setSize("6px", "18px");

		tctSinavAdi = new TextBox();
		tctSinavAdi.setMaxLength(30);
		horizontalPanel.add(tctSinavAdi);
		tctSinavAdi.setStyleName("gwt-TextBox1");
		tctSinavAdi.setSize("143px", "14px");

		Label lblTarihSaat = new Label("Tarih - Saat");
		flexTable.setWidget(1, 0, lblTarihSaat);
		lblTarihSaat.setStyleName("gwt-Bold");
		lblTarihSaat.setSize("85px", "18px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		flexTable.setWidget(1, 1, horizontalPanel_1);
		horizontalPanel_1.setSize("272px", "22px");

		dtpTarih = new DateBox();
		horizontalPanel_1.add(dtpTarih);
		dtpTarih.setStyleName("gwt-TextBox1");
		dtpTarih.addValueChangeHandler(new DtpTarihValueChangeHandler());
		dtpTarih.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpTarih.setSize("152px", "14px");

		cbxSaat = new ListBox();
		horizontalPanel_1.add(cbxSaat);
		cbxSaat.addItem("00");
		cbxSaat.addItem("01");
		cbxSaat.addItem("02");
		cbxSaat.addItem("03");
		cbxSaat.addItem("04");
		cbxSaat.addItem("05");
		cbxSaat.addItem("06");
		cbxSaat.addItem("07");
		cbxSaat.addItem("08");
		cbxSaat.addItem("09");
		cbxSaat.addItem("10");
		cbxSaat.addItem("11");
		cbxSaat.addItem("12");
		cbxSaat.addItem("13");
		cbxSaat.addItem("14");
		cbxSaat.addItem("15");
		cbxSaat.addItem("16");
		cbxSaat.addItem("17");
		cbxSaat.addItem("18");
		cbxSaat.addItem("19");
		cbxSaat.addItem("20");
		cbxSaat.addItem("21");
		cbxSaat.addItem("22");
		cbxSaat.addItem("23");
		cbxSaat.setStyleName("gwt-ComboBox1");
		cbxSaat.setSize("43px", "22px");

		Label label_5 = new Label(":");
		horizontalPanel_1.add(label_5);
		label_5.setDirection(Direction.RTL);
		label_5.setStyleName("gwt-Bold");
		label_5.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_5.setSize("14px", "18px");

		cbxDakika = new ListBox();
		horizontalPanel_1.add(cbxDakika);
		cbxDakika.addItem("00");
		cbxDakika.addItem("15");
		cbxDakika.addItem("30");
		cbxDakika.addItem("45");
		cbxDakika.setStyleName("gwt-ComboBox1");
		cbxDakika.setSize("43px", "22px");

		Label label_2 = new Label("Son Kitapçık No");
		flexTable.setWidget(2, 0, label_2);
		label_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		label_2.setStyleName("gwt-Bold");
		label_2.setSize("126px", "18px");

		tctSOnKitapcikNo = new TextBox();
		flexTable.setWidget(2, 1, tctSOnKitapcikNo);
		tctSOnKitapcikNo.setMaxLength(1);
		tctSOnKitapcikNo.setStyleName("gwt-TextBox1");
		tctSOnKitapcikNo.setSize("152px", "14px");

		Label label_3 = new Label("Şablon Seçiniz");
		flexTable.setWidget(3, 0, label_3);
		label_3.setStyleName("gwt-Bold");
		label_3.setSize("104px", "18px");

		cbxSablonSeciniz = new ListBox();
		flexTable.setWidget(3, 1, cbxSablonSeciniz);
		cbxSablonSeciniz.addItem(" ");
		cbxSablonSeciniz.setStyleName("gwt-ComboBox1");
		cbxSablonSeciniz.setSize("154px", "22px");
		if (!isDesignTime()) {

			putSablonAdiToCbx(cbxSablonSeciniz);
		}

	}

	private void putSablonAdiToCbx(final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getsablontanimlari");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getdbssinavtanimla " + response.getText());

					List<XMLSablonTanimlari> xmlSablonTanimlari = XMLSablonTanimlari.XML
							.readList(response.getText());

					for (int i = 0; i < xmlSablonTanimlari.size(); i++) {

						lbxTemp.addItem(xmlSablonTanimlari.get(i).sablon_adi);

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
			String URLValue = Util.urlBase + "putsinavtanimlama?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&sinav_no=" + tctSinavNo.getText();
			URLValue = URLValue + "&sinav_adi=" + tctSinavAdi.getText();
			URLValue = URLValue + "&son_kitapcik_no="
					+ tctSOnKitapcikNo.getText();
			URLValue = URLValue
					+ "&sablon_seciniz="
					+ cbxSablonSeciniz.getItemText(cbxSablonSeciniz
							.getSelectedIndex());
			URLValue = URLValue + "&saat="
					+ cbxSaat.getValue(cbxSaat.getSelectedIndex());
			URLValue = URLValue + "&dakika="
					+ cbxDakika.getValue(cbxDakika.getSelectedIndex());
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&tarih=" + dtf.format(dtpTarih.getValue());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	private class DtpTarihValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
			// Window.alert(dtf.format(dtpTarih.getValue()));
		}
	}

	public void putDataFromXML(XMLSinavTanimlama xml) {
		tctSinavAdi.setText(xml.sinav_adi);
		tctSinavNo.setText(xml.sinav_no);
		tctSOnKitapcikNo.setText(xml.son_kitapcik_no);
		cbxSaat.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxSaat, xml.saat));
		cbxSablonSeciniz.setItemText(0, xml.sablon_seciniz);

		cbxDakika.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxDakika,
				xml.dakika));

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

		dtpTarih.setValue(dtf.parse(xml.tarih));

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
