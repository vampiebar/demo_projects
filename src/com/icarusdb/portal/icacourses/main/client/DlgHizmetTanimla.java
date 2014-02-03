package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

public class DlgHizmetTanimla extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctHizmetAdi;
	private ListBox cbxHizmetTuru;
	private TextBox tctBirimFiyati;
	private ListBox cbxGuzergah;
	private Label lblGuzergah;
	private Button btnKaydet;

	public DlgHizmetTanimla(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;

		setHTML("Hizmet Ekleme / Düzenleme");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		setWidget(absolutePanel);
		absolutePanel.setSize("590px", "446px");

		Label lblNewLabel = new Label("Hizmet İşlemleri (Ekleme / Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("100%", "28px");

		Button btnYeniKayit = new Button("New button");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.setText("Yeni Kayıt");
		absolutePanel.add(btnYeniKayit, 258, 196);
		btnYeniKayit.setSize("78px", "66px");

		btnKaydet = new Button("");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 258, 304);
		btnKaydet.setSize("78px", "45px");

		Button btnKapat = new Button("New button");
		btnKapat.setVisible(false);
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 342, 304);
		btnKapat.setSize("78px", "45px");

		FlexTable flexTable = new FlexTable();
		absolutePanel.add(flexTable, 10, 46);
		flexTable.setSize("345px", "144px");

		Label lblHizmetAd = new Label("Hizmet Adı");
		flexTable.setWidget(0, 0, lblHizmetAd);
		lblHizmetAd.setStyleName("gwt-Bold");
		lblHizmetAd.setSize("81px", "18px");

		tctHizmetAdi = new TextBox();
		flexTable.setWidget(0, 1, tctHizmetAdi);
		tctHizmetAdi.setStyleName("gwt-TextBox1");
		tctHizmetAdi.setSize("149px", "15px");

		Label lblHzmetT = new Label("Hizmet Türü");
		flexTable.setWidget(1, 0, lblHzmetT);
		lblHzmetT.setStyleName("gwt-Bold");
		lblHzmetT.setSize("92px", "18px");

		cbxHizmetTuru = new ListBox();
		flexTable.setWidget(1, 1, cbxHizmetTuru);
		cbxHizmetTuru.addItem("Ders");
		cbxHizmetTuru.addItem("Servis");
		cbxHizmetTuru.addItem("Diğer");
		cbxHizmetTuru.addChangeHandler(new CbxHizmetTuruChangeHandler());
		cbxHizmetTuru.setSize("151px", "22px");

		lblGuzergah = new Label("Güzergah");
		flexTable.setWidget(2, 0, lblGuzergah);
		lblGuzergah.setVisible(false);
		lblGuzergah.setStyleName("gwt-Bold");

		cbxGuzergah = new ListBox();
		flexTable.setWidget(2, 1, cbxGuzergah);
		cbxGuzergah.setVisible(false);
		cbxGuzergah.addItem(" ");
		cbxGuzergah.setSize("151px", "22px");

		Label lblBirimFiyat = new Label("Birim Fiyatı");
		flexTable.setWidget(3, 0, lblBirimFiyat);
		lblBirimFiyat.setStyleName("gwt-Bold");
		lblBirimFiyat.setSize("81px", "18px");

		tctBirimFiyati = new TextBox();
		flexTable.setWidget(3, 1, tctBirimFiyati);
		tctBirimFiyati.setStyleName("gwt-TextBox1");
		tctBirimFiyati.setSize("149px", "15px");

		Image image = new Image("kaydet-1.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 342, 196);
		image.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		image_1.setAltText("aedasda");
		absolutePanel.add(image_1, 421, 196);
		image_1.setSize("72px", "66px");

		if (!isDesignTime()) {

		}
	}

	private boolean isDesignTime() {

		return false;
	}

	public void putGuzergahToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getservistanimlama");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLServisTanimlama> xmlServisTanimlama = XMLServisTanimlama.XML
							.readList(response.getText());

					for (int i = 0; i < xmlServisTanimlama.size(); i++) {

						lbxTemp.addItem(xmlServisTanimlama.get(i).guzergah);

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
			String URLValue = Util.urlBase + "puthizmettanimla?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&hizmet_adi=" + tctHizmetAdi.getText();
			URLValue = URLValue + "&hizmet_turu="
					+ cbxHizmetTuru.getValue(cbxHizmetTuru.getSelectedIndex());
			URLValue = URLValue + "&birim_fiyati=" + tctBirimFiyati.getText();
			URLValue = URLValue + "&guzergah="
					+ cbxGuzergah.getItemText(cbxGuzergah.getSelectedIndex());

			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";
			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	public void putDataFromXML(XMLHizmetTanimla xml) {
		tctBirimFiyati.setText(xml.birim_fiyati);
		tctHizmetAdi.setText(xml.hizmet_adi);
		cbxHizmetTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxHizmetTuru, xml.hizmet_turu));
		cbxGuzergah.setItemText(0, (xml.guzergah == null) ? "" : xml.guzergah);

		cbxGuzergah.setVisible((cbxHizmetTuru.getSelectedIndex() == 1));
		lblGuzergah.setVisible((cbxHizmetTuru.getSelectedIndex() == 1));
	}

	private class CbxHizmetTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			if (cbxHizmetTuru.getSelectedIndex() == 1) {
				cbxGuzergah.setVisible(true);
				lblGuzergah.setVisible(true);

				putGuzergahToCbx(cbxGuzergah);
			} else if (cbxHizmetTuru.getSelectedIndex() == 0) {
				cbxGuzergah.setVisible(false);
				lblGuzergah.setVisible(false);

			} else if (cbxHizmetTuru.getSelectedIndex() == 2) {
				cbxGuzergah.setVisible(false);
				lblGuzergah.setVisible(false);

			}
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
