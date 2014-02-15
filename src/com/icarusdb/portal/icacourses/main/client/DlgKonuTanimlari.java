package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgKonuTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private ListBox cbxDers;
	private ListBox cbxUniteAdi;
	private TextBox tctKonu;
	private Button btnKaydet;
	private Image image;
	private Image image_1;

	public DlgKonuTanimlari(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Konu Ekleme / Düzenleme");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("498px", "373px");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 122, 318);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 206, 318);
		btnKapat.setSize("78px", "45px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 307, 153);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 385, 153);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("270px", "85px");

		Label label = new Label("Eğitim Türü");
		flexTable.setWidget(0, 0, label);
		label.setStyleName("gwt-Bold");
		label.setSize("106px", "18px");

		cbxEgitimTuru = new ListBox();
		flexTable.setWidget(0, 1, cbxEgitimTuru);
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.setSize("151px", "18px");

		Label label_1 = new Label("Alan");
		flexTable.setWidget(1, 0, label_1);
		label_1.setStyleName("gwt-Bold");
		label_1.setSize("105px", "18px");

		cbxAlan = new ListBox();
		flexTable.setWidget(1, 1, cbxAlan);
		cbxAlan.addChangeHandler(new CbxAlanChangeHandler());
		cbxAlan.addItem(" ");
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.setSize("151px", "18px");

		Label label_2 = new Label("Ders");
		flexTable.setWidget(2, 0, label_2);
		label_2.setStyleName("gwt-Bold");
		label_2.setSize("106px", "18px");

		cbxDers = new ListBox();
		flexTable.setWidget(2, 1, cbxDers);
		cbxDers.addChangeHandler(new CbxDersChangeHandler());
		cbxDers.addItem(" ");
		cbxDers.setStyleName("gwt-ComboBox1");
		cbxDers.setSize("151px", "18px");

		Label label_3 = new Label("Ünite Adı");
		flexTable.setWidget(3, 0, label_3);
		label_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		label_3.setStyleName("gwt-Bold");
		label_3.setSize("106px", "18px");

		cbxUniteAdi = new ListBox();
		flexTable.setWidget(3, 1, cbxUniteAdi);
		cbxUniteAdi.addItem(" ");
		cbxUniteAdi.setStyleName("gwt-ComboBox1");
		cbxUniteAdi.setSize("151px", "18px");

		Label lblKonu = new Label("Konu");
		flexTable.setWidget(4, 0, lblKonu);
		lblKonu.setStyleName("gwt-Bold");
		lblKonu.setSize("106px", "16px");

		tctKonu = new TextBox();
		flexTable.setWidget(4, 1, tctKonu);
		tctKonu.setStyleName("gwt-TextBox1");
		tctKonu.setSize("149px", "16px");
		if (!isDesignTime()) {

			putEgitimTuruToCbx(cbxEgitimTuru);

		}

	}

	private boolean isDesignTime() {

		return false;
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

	public void putUniteAdiToCbx(String egitim_turu_adi, String alan_adi,
			String ders_adi, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getunitetanimlari?egitim_turu_adi="
						+ egitim_turu_adi + "&alan_adi=" + alan_adi
						+ "&ders_adi=" + ders_adi);

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

					List<XMLUniteTanimlari> xmlUniteTanimlari = XMLUniteTanimlari.XML
							.readList(response.getText());

					for (int i = 0; i < xmlUniteTanimlari.size(); i++) {

						lbxTemp.addItem(xmlUniteTanimlari.get(i).unite_adi);
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
			String URLValue = Util.urlBase + "putkonutanimlari?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue
					+ "&egitim_turu_adi="
					+ cbxEgitimTuru.getItemText(cbxEgitimTuru
							.getSelectedIndex());
			URLValue = URLValue + "&alan_adi="
					+ cbxAlan.getItemText(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders_adi="
					+ cbxDers.getItemText(cbxDers.getSelectedIndex());
			URLValue = URLValue + "&unite_adi="
					+ cbxUniteAdi.getItemText(cbxUniteAdi.getSelectedIndex());
			URLValue = URLValue + "&konu_adi=" + tctKonu.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLKonuTanimlari xml) {

		cbxEgitimTuru.setItemText(0, xml.egitim_turu_adi);
		cbxAlan.setItemText(0, xml.alan_adi);
		cbxDers.setItemText(0, xml.ders_adi);
		cbxUniteAdi.setItemText(0, xml.unite_adi);
		tctKonu.setText(xml.konu_adi);
	}

	private class CbxEgitimTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxEgitimTuru.getSelectedIndex() + "");
			putEgitimTuruAlanToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxAlan);
		}
	}

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
					cbxDers.getItemText(cbxDers.getSelectedIndex()),
					cbxUniteAdi);

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
