package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgDBSSinavTanimla extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private ListBox cbxSinavYeri;
	private TextBox tctKota;
	private DateBox dtpSinavTarihi;
	private ListBox cbxOkulDurumu;
	private ListBox cbxAlan;
	public HorizontalPanel hzpanOtherBuilding;
	private ListBox cbxUlke;
	private ListBox cbxMahalleKoy;
	private ListBox cbxSemt;
	private ListBox cbxIlce;
	private ListBox cbxIl;
	private ListBox cbxSaat;
	private ListBox cbxDakika;
	private TextArea tctAdres;
	private Button btnKaydet;
	private Button btnKapat;

	public DlgDBSSinavTanimla(boolean isInsert, long id) {
		setAnimationEnabled(true);
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("DBS Sınav Ekleme / Düzenleme");

		VerticalPanel vtpanMain = new VerticalPanel();
		vtpanMain.setStyleName("gwt-DialogBackGround");
		setWidget(vtpanMain);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		vtpanMain.add(horizontalPanel);

		Label lblDbsSnavIlemleri = new Label(
				"DBS Sınav İşlemleri (Ekleme / Düzenleme)");
		horizontalPanel.add(lblDbsSnavIlemleri);
		lblDbsSnavIlemleri.setStyleName("gwt-LabelMor");
		lblDbsSnavIlemleri.setSize("660px", "29px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		vtpanMain.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("100%");

		FlexTable flexTable = new FlexTable();
		horizontalPanel_1.add(flexTable);

		Label lblOkulDurumu = new Label("Okul Durumu");
		flexTable.setWidget(0, 0, lblOkulDurumu);
		lblOkulDurumu.setStyleName("gwt-Bold");

		cbxOkulDurumu = new ListBox();
		cbxOkulDurumu.addItem("1. Sınıf");
		cbxOkulDurumu.addItem("2. Sınıf");
		cbxOkulDurumu.addItem("3. Sınıf");
		cbxOkulDurumu.addItem("4. Sınıf");
		cbxOkulDurumu.addItem("5. Sınıf");
		cbxOkulDurumu.addItem("6. Sınıf");
		cbxOkulDurumu.addItem("7. Sınıf");
		cbxOkulDurumu.addItem("8. Sınıf");
		cbxOkulDurumu.addItem("9. Sınıf");
		cbxOkulDurumu.addItem("10. Sınıf");
		cbxOkulDurumu.addItem("11. Sınıf");
		cbxOkulDurumu.addItem("Lise Mezun");
		cbxOkulDurumu.addItem("Üniversite Mezun");
		cbxOkulDurumu.addItem("12. Sınıf");
		flexTable.setWidget(0, 1, cbxOkulDurumu);
		cbxOkulDurumu.setStyleName("gwt-ComboBox1");
		cbxOkulDurumu.setSize("174px", "22px");

		Label lblAlan = new Label("Alan");
		flexTable.setWidget(1, 0, lblAlan);
		lblAlan.setStyleName("gwt-Bold");

		cbxAlan = new ListBox();
		flexTable.setWidget(1, 1, cbxAlan);
		cbxAlan.addItem("ALAN YOK");
		cbxAlan.addItem("SAYISAL");
		cbxAlan.addItem("EŞİT AĞIRLIK");
		cbxAlan.addItem("SÖZEL");
		cbxAlan.addItem("DİL");
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.setSize("174px", "22px");

		Label lblSnavTarihi = new Label("Sınav Tarihi/Zamanı");
		flexTable.setWidget(2, 0, lblSnavTarihi);
		lblSnavTarihi.setStyleName("gwt-Bold");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_3.setSpacing(2);
		horizontalPanel_3
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_3
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		flexTable.setWidget(2, 1, horizontalPanel_3);

		dtpSinavTarihi = new DateBox();
		horizontalPanel_3.add(dtpSinavTarihi);
		dtpSinavTarihi.setStyleName("gwt-TextBox1");
		dtpSinavTarihi
				.addValueChangeHandler(new DtpSinavTarihiValueChangeHandler());
		dtpSinavTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpSinavTarihi.setSize("172px", "14px");

		cbxSaat = new ListBox();
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
		horizontalPanel_3.add(cbxSaat);

		Label lblNewLabel_5 = new Label(":");
		lblNewLabel_5
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblNewLabel_5.setStyleName("gwt-Bold");
		horizontalPanel_3.add(lblNewLabel_5);
		lblNewLabel_5.setSize("14px", "23px");

		cbxDakika = new ListBox();
		cbxDakika.setStyleName("gwt-ComboBox1");
		cbxDakika.addItem("00");
		cbxDakika.addItem("15");
		cbxDakika.addItem("30");
		cbxDakika.addItem("45");
		horizontalPanel_3.add(cbxDakika);

		Label lblNewLabel = new Label("Kota ( Kişi)");
		flexTable.setWidget(3, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");

		tctKota = new TextBox();
		flexTable.setWidget(3, 1, tctKota);
		tctKota.setStyleName("gwt-TextBox1");
		tctKota.setSize("174px", "14px");

		Label lblSinavYeri = new Label("Sınav Yeri");
		flexTable.setWidget(4, 0, lblSinavYeri);
		lblSinavYeri.setStyleName("gwt-Bold");
		lblSinavYeri.setSize("76px", "18px");

		cbxSinavYeri = new ListBox();
		cbxSinavYeri.addChangeHandler(new CbxSinavYeriChangeHandler());
		flexTable.setWidget(4, 1, cbxSinavYeri);
		cbxSinavYeri.setStyleName("gwt-ComboBox1");
		cbxSinavYeri.addItem("Dershane Binası");
		cbxSinavYeri.addItem("Başka Bina");
		cbxSinavYeri.setSize("174px", "22px");

		hzpanOtherBuilding = new HorizontalPanel();
		hzpanOtherBuilding.setVisible(false);
		vtpanMain.add(hzpanOtherBuilding);
		hzpanOtherBuilding.setWidth("100%");

		FlexTable flexTable_1 = new FlexTable();
		flexTable_1.setCellPadding(2);
		flexTable_1.setBorderWidth(0);
		hzpanOtherBuilding.add(flexTable_1);
		flexTable_1.setSize("392px", "111px");

		Label lblNewLabel_1 = new Label("Ülke");
		lblNewLabel_1.setStyleName("gwt-Bold");
		flexTable_1.setWidget(0, 0, lblNewLabel_1);
		lblNewLabel_1.setWidth("137px");

		cbxUlke = new ListBox();
		cbxUlke.setStyleName("gwt-ComboBox1");
		cbxUlke.addItem("Türkiye");
		flexTable_1.setWidget(0, 1, cbxUlke);
		cbxUlke.setWidth("70%");

		Label lblNewLabel_2 = new Label("İl");
		lblNewLabel_2.setStyleName("gwt-Bold");
		flexTable_1.setWidget(1, 0, lblNewLabel_2);

		cbxIl = new ListBox();
		cbxIl.addChangeHandler(new CbxIlChangeHandler());
		cbxIl.addItem(" ");
		cbxIl.setStyleName("gwt-ComboBox1");
		flexTable_1.setWidget(1, 1, cbxIl);
		cbxIl.setWidth("176px");

		Label lblNewLabel_3 = new Label("İlçe");
		lblNewLabel_3.setStyleName("gwt-Bold");
		flexTable_1.setWidget(2, 0, lblNewLabel_3);

		cbxIlce = new ListBox();
		cbxIlce.addChangeHandler(new CbxIlceChangeHandler());
		cbxIlce.addItem(" ");
		cbxIlce.setStyleName("gwt-ComboBox1");
		flexTable_1.setWidget(2, 1, cbxIlce);
		cbxIlce.setWidth("70%");

		Label lblNewLabel_4 = new Label("Semt");
		lblNewLabel_4.setStyleName("gwt-Bold");
		flexTable_1.setWidget(3, 0, lblNewLabel_4);

		cbxSemt = new ListBox();
		cbxSemt.addChangeHandler(new CbxSemtChangeHandler());
		cbxSemt.addItem(" ");
		cbxSemt.setStyleName("gwt-ComboBox1");
		flexTable_1.setWidget(3, 1, cbxSemt);
		cbxSemt.setWidth("70%");

		Label lblMahalleky = new Label("Mahalle / Köy");
		lblMahalleky.setStyleName("gwt-Bold");
		flexTable_1.setWidget(4, 0, lblMahalleky);

		cbxMahalleKoy = new ListBox();
		cbxMahalleKoy.addItem(" ");
		cbxMahalleKoy.setStyleName("gwt-ComboBox1");
		flexTable_1.setWidget(4, 1, cbxMahalleKoy);
		cbxMahalleKoy.setWidth("250px");

		Label lblAdres = new Label("Adres");
		lblAdres.setStyleName("gwt-Bold");
		flexTable_1.setWidget(5, 0, lblAdres);
		lblAdres.setWidth("20%");
		flexTable_1.getCellFormatter().setVerticalAlignment(5, 0,
				HasVerticalAlignment.ALIGN_TOP);
		flexTable_1.getCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_LEFT);

		tctAdres = new TextArea();
		flexTable_1.setWidget(5, 1, tctAdres);
		tctAdres.setStyleName("gwt-TextAreaResible");
		tctAdres.setWidth("246px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setSpacing(6);
		vtpanMain.add(horizontalPanel_2);
		vtpanMain.setCellHorizontalAlignment(horizontalPanel_2,
				HasHorizontalAlignment.ALIGN_RIGHT);

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		horizontalPanel_2.add(btnKaydet);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setSize("78px", "49px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		horizontalPanel_2.add(image);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		horizontalPanel_2.add(image_1);
		image_1.setSize("72px", "66px");

		btnKapat = new Button("Kapat");
		btnKapat.setVisible(false);
		horizontalPanel_2.add(btnKapat);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setSize("78px", "49px");

		if (!isDesignTime()) {

			putIlToCbx(cbxIl);

		}
	}

	private boolean isDesignTime() {

		return false;
	}

	public void putIlToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getil");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLIl> xmlil = XMLIl.XML.readList(response.getText());

					for (int i = 0; i < xmlil.size(); i++) {

						lbxTemp.addItem(xmlil.get(i).il_adi);

					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putIlceToCbx(int il_id, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getilce?il_id=" + il_id);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLIlce> xmlilce = XMLIlce.XML.readList(response
							.getText());

					for (int i = 0; i < xmlilce.size(); i++) {

						lbxTemp.addItem(xmlilce.get(i).ilce_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putSemtToCbx(String il, String ilce, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getpostakodu?il=" + il + "&ilce=" + ilce);

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

					List<XMLPostaKodu> xmlpostakodu = XMLPostaKodu.XML
							.readList(response.getText());

					for (int i = 0; i < xmlpostakodu.size(); i++) {

						lbxTemp.addItem(xmlpostakodu.get(i).semt_bucak_belde);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putMahalleToCbx(String il, String ilce,
			String semt_bucak_belde, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getpostakodumahalle?il=" + il + "&ilce=" + ilce
						+ "&semt_bucak_belde=" + semt_bucak_belde);

		// Window.alert(Util.urlBase + "getpostakodumahalle?il=" + il + "&ilce="
		// + ilce + "&semt_bucak_belde=" + semt_bucak_belde);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLPostaKoduMahalle> xmlpostakodumahalle = XMLPostaKoduMahalle.XML
							.readList(response.getText());

					for (int i = 0; i < xmlpostakodumahalle.size(); i++) {

						lbxTemp.addItem(xmlpostakodumahalle.get(i).mahalle
								+ " - " + xmlpostakodumahalle.get(i).posta_kodu);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private class BtnKapatClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putdbssinavtanimla?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&okul_durumu="
					+ cbxOkulDurumu.getValue(cbxOkulDurumu.getSelectedIndex());
			URLValue = URLValue + "&alan_bilgisi="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&kota=" + tctKota.getText();
			URLValue = URLValue + "&sinav_yeri="
					+ cbxSinavYeri.getValue(cbxSinavYeri.getSelectedIndex());
			URLValue = URLValue + "&ulke="
					+ cbxUlke.getItemText(cbxUlke.getSelectedIndex());
			URLValue = URLValue + "&il="
					+ cbxIl.getItemText(cbxIl.getSelectedIndex());
			URLValue = URLValue + "&ilce="
					+ cbxIlce.getItemText(cbxIlce.getSelectedIndex());
			URLValue = URLValue + "&semt="
					+ cbxSemt.getItemText(cbxSemt.getSelectedIndex());
			URLValue = URLValue
					+ "&mahalle_koy="
					+ cbxMahalleKoy.getItemText(cbxMahalleKoy
							.getSelectedIndex());
			URLValue = URLValue + "&adres=" + tctAdres.getText();
			URLValue = URLValue + "&saat="
					+ cbxSaat.getValue(cbxSaat.getSelectedIndex());
			URLValue = URLValue + "&dakika="
					+ cbxDakika.getValue(cbxDakika.getSelectedIndex());

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&sinav_tarihi="
					+ dtf.format(dtpSinavTarihi.getValue());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "SINAV BİLGİSİ KAYIT EDİLDİ",
					"SINAV BİLGİSİ KAYIT EDİLEMEDİ");
		}
	}

	private class DtpSinavTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm");
			// Window.alert(dtf.format(dtpSinavTarihi.getValue()));

		}
	}

	public void putDataFromXML(XMLDBSSinavTanimla xml) {

		tctKota.setText(xml.kota);
		tctAdres.setText(xml.adres);
		cbxAlan.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxAlan,
				xml.alan_bilgisi));
		cbxSinavYeri.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxSinavYeri, xml.sinav_yeri));

		hzpanOtherBuilding.setVisible((cbxSinavYeri.getSelectedIndex() == 1));

		cbxOkulDurumu.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOkulDurumu, xml.okul_durumu));

		cbxUlke.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxUlke, xml.ulke));
		cbxSaat.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxSaat, xml.saat));

		cbxDakika.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxDakika,
				xml.dakika));

		cbxIl.setItemText(0, (xml.il == null) ? "" : xml.il);
		cbxIlce.setItemText(0, (xml.ilce == null) ? "" : xml.ilce);
		cbxSemt.setItemText(0, (xml.semt == null) ? "" : xml.semt);
		cbxMahalleKoy.setItemText(0, (xml.mahalle_koy == null) ? ""
				: xml.mahalle_koy);

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
		dtpSinavTarihi.setValue(dtf.parse(xml.sinav_tarihi));

	}

	private class CbxIlChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putIlceToCbx(cbxIl.getSelectedIndex(), cbxIlce);
		}
	}

	private class CbxIlceChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putSemtToCbx(cbxIl.getItemText(cbxIl.getSelectedIndex()),
					cbxIlce.getItemText(cbxIlce.getSelectedIndex()), cbxSemt);
		}
	}

	private class CbxSemtChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putMahalleToCbx(cbxIl.getItemText(cbxIl.getSelectedIndex()),
					cbxIlce.getItemText(cbxIlce.getSelectedIndex()),
					cbxSemt.getItemText(cbxSemt.getSelectedIndex()),
					cbxMahalleKoy);
		}
	}

	private class CbxSinavYeriChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {

			hzpanOtherBuilding
					.setVisible((cbxSinavYeri.getSelectedIndex() == 1));

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
