package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public class CmpstRowTest extends Composite {
	private FlexTable flexTable;
	private ListBox cbxKonu;
	private ListBox cbxKazanim;
	private ListBox cbxKitapcik;
	private ListBox cbxUnite;

	public CmpstRowTest() {

		flexTable = new FlexTable();
		initWidget(flexTable);
		flexTable.setWidth("100%");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flexTable.setWidget(0, 0, horizontalPanel);
		horizontalPanel.setWidth("");

		Label lblNewLabel = new Label("New label");
		horizontalPanel.add(lblNewLabel);

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		flexTable.setWidget(0, 1, horizontalPanel_1);
		horizontalPanel_1.setWidth("70px");

		cbxUnite = new ListBox();
		cbxUnite.addItem(" ");
		cbxUnite.addChangeHandler(new CbxUniteChangeHandler());
		horizontalPanel_1.add(cbxUnite);
		cbxUnite.setWidth("200px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		flexTable.setWidget(0, 2, horizontalPanel_2);

		cbxKonu = new ListBox();
		cbxKonu.addItem(" ");
		cbxKonu.addChangeHandler(new CbxKonuChangeHandler());
		horizontalPanel_2.add(cbxKonu);
		cbxKonu.setWidth("200px");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		flexTable.setWidget(0, 3, horizontalPanel_3);

		cbxKazanim = new ListBox();
		cbxKazanim.addItem(" ");
		horizontalPanel_3.add(cbxKazanim);
		cbxKazanim.setWidth("200px");

		flexTable.getColumnFormatter().setWidth(0, "30px");

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		flexTable.setWidget(0, 4, horizontalPanel_4);

		cbxKitapcik = new ListBox();
		cbxKitapcik.addItem(" ");
		horizontalPanel_4.add(cbxKitapcik);
		cbxKitapcik.setWidth("100px");
		if (!isDesignTime()) {

			putUniteToCbx(cbxUnite);

		}
	}

	private void putUniteToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("Lütfen Seçiniz");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturuuniteadi?sinif_adi=YGS");

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

					List<XMLEgitimTuruUniteAdi> xmlEgitimTuruUniteAdi = XMLEgitimTuruUniteAdi.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuruUniteAdi.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuruUniteAdi.get(i).unite_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putKonuToCbx(String unite_adi, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("Lütfen Seçiniz");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturukonuadi?unite_adi=" + unite_adi);

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

					List<XMLEgitimTuruKonuAdi> xmlEgitimTuruKonuAdi = XMLEgitimTuruKonuAdi.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuruKonuAdi.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuruKonuAdi.get(i).konu_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putKazanimlarToCbx(String unite_adi, String konu_adi,
			final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("Lütfen Seçiniz");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturukazanimlar?" + "unite_adi="
						+ unite_adi + "&konu_adi=" + konu_adi);

		// Window.alert(Util.urlBase + "getegitimturukazanimlar?unite_adi="
		// + unite_adi + "&konu_adi=" + konu_adi);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLEgitimTuruKazanimlar> xmlEgitimTuruKazanimlar = XMLEgitimTuruKazanimlar.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuruKazanimlar.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuruKazanimlar.get(i).kazanimlar);
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

	private class CbxUniteChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {

			putKonuToCbx(cbxUnite.getItemText(cbxUnite.getSelectedIndex()),
					cbxKonu);

		}
	}

	private class CbxKonuChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {

			putKazanimlarToCbx(
					cbxUnite.getItemText(cbxUnite.getSelectedIndex()),
					cbxKonu.getItemText(cbxKonu.getSelectedIndex()), cbxKazanim);

		}
	}
}
