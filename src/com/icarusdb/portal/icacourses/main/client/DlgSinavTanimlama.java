package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
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

	public DlgSinavTanimlama(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Dönem  Ekle / Değiştir");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("541px", "409px");

		Label label = new Label("Sınav No - Sınav Adı");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 10, 41);
		label.setSize("149px", "18px");

		Label lblTarihSaat = new Label("Tarih - Saat");
		lblTarihSaat.setStyleName("gwt-Bold");
		absolutePanel.add(lblTarihSaat, 10, 75);
		lblTarihSaat.setSize("85px", "18px");

		Label label_2 = new Label("Son Kitapçık No");
		label_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		label_2.setStyleName("gwt-Bold");
		absolutePanel.add(label_2, 10, 107);
		label_2.setSize("104px", "18px");

		Label label_3 = new Label("Şablon Seçiniz");
		label_3.setStyleName("gwt-Bold");
		absolutePanel.add(label_3, 10, 143);
		label_3.setSize("104px", "18px");

		tctSinavNo = new TextBox();
		tctSinavNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSinavNo, 165, 41);
		tctSinavNo.setSize("152px", "14px");

		tctSinavAdi = new TextBox();
		tctSinavAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSinavAdi, 345, 41);
		tctSinavAdi.setSize("143px", "14px");

		Label label_4 = new Label("-");
		absolutePanel.add(label_4, 325, 41);
		label_4.setSize("14px", "18px");

		dtpTarih = new DateBox();
		dtpTarih.setStyleName("gwt-TextBox1");
		dtpTarih.addValueChangeHandler(new DtpTarihValueChangeHandler());
		dtpTarih.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		absolutePanel.add(dtpTarih, 165, 75);
		dtpTarih.setSize("152px", "14px");

		tctSOnKitapcikNo = new TextBox();
		tctSOnKitapcikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSOnKitapcikNo, 165, 107);
		tctSOnKitapcikNo.setSize("152px", "14px");

		cbxSablonSeciniz = new ListBox();
		cbxSablonSeciniz.addItem(" ");
		cbxSablonSeciniz.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxSablonSeciniz, 165, 139);
		cbxSablonSeciniz.setSize("154px", "22px");

		btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 295, 239);
		btnKaydet.setSize("78px", "50px");

		btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 401, 239);
		btnKapat.setSize("78px", "50px");

		Label lblNewLabel = new Label("Sınav Tanımlama (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("541px", "28px");

		cbxSaat = new ListBox();
		cbxSaat.addItem("1");
		cbxSaat.addItem("2");
		cbxSaat.addItem("3");
		cbxSaat.addItem("4");
		cbxSaat.addItem("5");
		cbxSaat.addItem("6");
		cbxSaat.addItem("7");
		cbxSaat.addItem("8");
		cbxSaat.addItem("9");
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
		cbxSaat.addItem("00");
		cbxSaat.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxSaat, 345, 71);
		cbxSaat.setSize("43px", "22px");

		Label label_5 = new Label(":");
		label_5.setDirection(Direction.RTL);
		label_5.setStyleName("gwt-Bold");
		label_5.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		absolutePanel.add(label_5, 386, 71);
		label_5.setSize("14px", "18px");

		cbxDakika = new ListBox();
		cbxDakika.addItem("00");
		cbxDakika.addItem("15");
		cbxDakika.addItem("30");
		cbxDakika.addItem("45");
		cbxDakika.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxDakika, 396, 71);
		cbxDakika.setSize("43px", "22px");
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
}
