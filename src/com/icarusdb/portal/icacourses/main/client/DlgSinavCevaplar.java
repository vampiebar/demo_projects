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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DlgSinavCevaplar extends DialogBox {
	private HorizontalPanel hzPanKazanimlar;
	private Button btnCevaplariGetir;

	public boolean _isInsert = true;
	public long _id = -1;
	private VerticalPanel vtPanKazanimlar;
	private ListBox cbxDers;
	private ListBox cbxDersGrubu;

	public DlgSinavCevaplar() {
		// boolean isInsert, long id
		// _isInsert = isInsert;
		// _id = id;

		setGlassEnabled(true);
		setHTML("Sınav Tanım Cevap (Ekleme / Düzenleme)");

		AbsolutePanel AbsolutePanel = new AbsolutePanel();
		setWidget(AbsolutePanel);
		AbsolutePanel.setSize("808px", "547px");

		ScrollPanel scrollPanel = new ScrollPanel();
		AbsolutePanel.add(scrollPanel);
		scrollPanel.setSize("100%", "100%");

		VerticalPanel verticalPanel = new VerticalPanel();
		scrollPanel.setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		verticalPanel.setCellHeight(flexTable, "95");
		flexTable.setSize("229px", "43px");

		Label lblNewLabel = new Label("Ders Grubu");
		flexTable.setWidget(0, 0, lblNewLabel);

		cbxDersGrubu = new ListBox();
		cbxDersGrubu.addChangeHandler(new CbxDersGrubuChangeHandler());
		cbxDersGrubu.addItem("Lütfen Seçiniz");
		cbxDersGrubu.setStyleName("gwt-ComboBox1");
		flexTable.setWidget(0, 1, cbxDersGrubu);
		cbxDersGrubu.setWidth("120px");

		Label lblNewLabel_1 = new Label("Ders");
		flexTable.setWidget(1, 0, lblNewLabel_1);

		cbxDers = new ListBox();
		cbxDers.addItem(" ");
		cbxDers.setStyleName("gwt-ComboBox1");
		flexTable.setWidget(1, 1, cbxDers);
		cbxDers.setWidth("120px");

		btnCevaplariGetir = new Button("New button");
		btnCevaplariGetir.addClickHandler(new BtnCevaplariGetirClickHandler());
		btnCevaplariGetir.setStyleName("gwt-BilgileriniGetir");
		btnCevaplariGetir.setText("Cevapları Getir");
		flexTable.setWidget(2, 1, btnCevaplariGetir);
		btnCevaplariGetir.setWidth("120px");
		flexTable.getCellFormatter().setHorizontalAlignment(2, 1,
				HasHorizontalAlignment.ALIGN_LEFT);

		hzPanKazanimlar = new HorizontalPanel();
		verticalPanel.add(hzPanKazanimlar);
		verticalPanel.setCellHeight(hzPanKazanimlar, "30");
		hzPanKazanimlar.setVisible(false);
		hzPanKazanimlar.setSize("100%", "17px");

		Label lblNewLabel_5 = new Label("Soru No");
		hzPanKazanimlar.add(lblNewLabel_5);
		hzPanKazanimlar.setCellHeight(lblNewLabel_5, "30");
		lblNewLabel_5.setWidth("50px");

		Label lblNewLabel_4 = new Label("Ünite");
		hzPanKazanimlar.add(lblNewLabel_4);

		Label lblNewLabel_3 = new Label("");
		hzPanKazanimlar.add(lblNewLabel_3);

		Label lblNewLabel_2 = new Label("Konu");
		hzPanKazanimlar.add(lblNewLabel_2);

		Label lblNewLabel_6 = new Label("Kazanım");
		hzPanKazanimlar.add(lblNewLabel_6);
		lblNewLabel_6.setWidth("156px");

		vtPanKazanimlar = new VerticalPanel();
		verticalPanel.add(vtPanKazanimlar);
		verticalPanel.setCellHeight(vtPanKazanimlar, "30");
		vtPanKazanimlar.setSize("100%", "88px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel.setSize("100%", "70px");

		Image image_2 = new Image("kaydet-1.png");
		horizontalPanel.add(image_2);
		horizontalPanel.setCellWidth(image_2, "0");
		image_2.setSize("72px", "66px");

		Image image_1 = new Image("kapat-1.png");
		image_1.addClickHandler(new Image_1ClickHandler());
		horizontalPanel.add(image_1);
		image_1.setSize("72px", "66px");

		if (!isDesignTime()) {

			putDersGrubuToCbx(cbxDersGrubu);

			for (int i = 0; i <= 5; i++) {
				vtPanKazanimlar.add(new CmpstRowTest());
			}

		}
	}

	private void putDersGrubuToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("Lütfen Seçiniz");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturudersgrupadi");

		// Window.alert(Util.urlBase + "getpostakodumahalle?il=" + il +
		// "&ilce="
		// + ilce + "&semt_bucak_belde=" + semt_bucak_belde);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " +
					// response.getText());

					List<XMLEgitimTuruDersAdi> xmlEgitimTuruDersAdi = XMLEgitimTuruDersAdi.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuruDersAdi.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuruDersAdi.get(i).ders_grup_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putDersToCbx(String ders_grup_adi, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("Lütfen Seçiniz");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturudersadi?" + "&ders_grup_adi="
						+ ders_grup_adi);

		// Window.alert(Util.urlBase + "getpostakodumahalle?il=" + il +
		// "&ilce="
		// + ilce + "&semt_bucak_belde=" + semt_bucak_belde);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " +
					// response.getText());

					List<XMLEgitimTuruDersAdi> xmlEgitimTuruDersAdi = XMLEgitimTuruDersAdi.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuruDersAdi.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuruDersAdi.get(i).ders_adi);
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

	private class BtnCevaplariGetirClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			hzPanKazanimlar.setVisible(true);

		}
	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class CbxDersGrubuChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {

			putDersToCbx(
					cbxDersGrubu.getItemText(cbxDersGrubu.getSelectedIndex()),
					cbxDers);

		}
	}
}
