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
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgOdevTakipUnite extends DialogBox {
	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private ListBox cbxDers;
	private TextBox tctUnite;

	public boolean _isInsert = true;
	public long _id = -1;
	private Button btnKaydet;
	private Image image;
	private Image image_1;

	public DlgOdevTakipUnite(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Ödev Takip Ünite Ekleme / Düzenleme ");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("542px", "406px");

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 39, 143);
		btnKaydet.setSize("78px", "43px");

		Button btnKapat = new Button("Kapat");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		absolutePanel.add(btnKapat, 131, 143);
		btnKapat.setSize("78px", "43px");

		image = new Image("kaydet-1.png");
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 285, 134);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel.add(image_1, 363, 134);
		image_1.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 0, 0);
		flexTable.setSize("275px", "50px");

		Label lblEitimTr = new Label("Eğitim Türü");
		flexTable.setWidget(0, 0, lblEitimTr);
		lblEitimTr.setStyleName("gwt-Bold");
		lblEitimTr.setSize("102px", "16px");

		cbxEgitimTuru = new ListBox();
		flexTable.setWidget(0, 1, cbxEgitimTuru);
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.setSize("163px", "22px");

		Label lblAlan = new Label("Alan");
		flexTable.setWidget(1, 0, lblAlan);
		lblAlan.setStyleName("gwt-Bold");
		lblAlan.setSize("41px", "16px");

		cbxAlan = new ListBox();
		flexTable.setWidget(1, 1, cbxAlan);
		cbxAlan.addChangeHandler(new CbxAlanChangeHandler());

		cbxAlan.addItem(" ");
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.setSize("163px", "22px");

		Label lblDers = new Label("Ders");
		flexTable.setWidget(2, 0, lblDers);
		lblDers.setStyleName("gwt-Bold");
		lblDers.setSize("41px", "16px");

		cbxDers = new ListBox();
		flexTable.setWidget(2, 1, cbxDers);
		cbxDers.addItem(" ");
		cbxDers.setStyleName("gwt-ComboBox1");
		cbxDers.setSize("163px", "22px");

		Label lblnite = new Label("Ünite");
		flexTable.setWidget(3, 0, lblnite);
		lblnite.setStyleName("gwt-Bold");
		lblnite.setSize("65px", "16px");

		tctUnite = new TextBox();
		flexTable.setWidget(3, 1, tctUnite);
		tctUnite.setStyleName("gwt-TextBox1");
		tctUnite.setSize("161px", "16px");

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

			String URLValue = Util.urlBase + "putodevtakipunite?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue
					+ "&egitim_turu="
					+ cbxEgitimTuru.getItemText(cbxEgitimTuru
							.getSelectedIndex());
			URLValue = URLValue + "&alan="
					+ cbxAlan.getItemText(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&ders="
					+ cbxDers.getItemText(cbxDers.getSelectedIndex());

			URLValue = URLValue + "&unite=" + tctUnite.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLOdevTakipUnite xml) {

		cbxEgitimTuru.setItemText(0, xml.egitim_turu);
		cbxAlan.setItemText(0, xml.alan);
		cbxDers.setItemText(0, xml.ders);

		tctUnite.setText(xml.unite);
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
