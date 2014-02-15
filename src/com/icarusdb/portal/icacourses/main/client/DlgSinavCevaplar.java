package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

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
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public class DlgSinavCevaplar extends DialogBox {
	private Image image_1;

	public DlgSinavCevaplar() {
		setGlassEnabled(true);
		setHTML("Sınav Tanım Cevap (Ekleme / Düzenleme)");

		AbsolutePanel verticalPanel = new AbsolutePanel();
		setWidget(verticalPanel);
		verticalPanel.setSize("514px", "421px");

		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		flexTable.setSize("229px", "43px");

		Label lblNewLabel = new Label("Ders Grubu");
		flexTable.setWidget(0, 0, lblNewLabel);

		ListBox comboBox = new ListBox();
		comboBox.addItem("Lütfen Seçiniz");
		comboBox.setStyleName("gwt-ComboBox1");
		flexTable.setWidget(0, 1, comboBox);
		comboBox.setWidth("120px");

		Label lblNewLabel_1 = new Label("Ders");
		flexTable.setWidget(1, 0, lblNewLabel_1);

		ListBox comboBox_1 = new ListBox();
		comboBox_1.addItem(" ");
		comboBox_1.setStyleName("gwt-ComboBox1");
		flexTable.setWidget(1, 1, comboBox_1);
		comboBox_1.setWidth("120px");

		Image image = new Image((String) null);
		verticalPanel.add(image);

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		verticalPanel.add(image_1, 377, 96);
		image_1.setSize("72px", "66px");

		if (!isDesignTime()) {

		}
	}

	private void putOKulDurumuToCbx(final ListBox lbxTemp,
			final ListBox lbxTemp2) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		lbxTemp2.clear();
		lbxTemp2.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getokulsinifbilgisi");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getdbssinavtanimla " + response.getText());

					List<XMLOkulSinifBilgisi> xmlOkulSinifBilgisi = XMLOkulSinifBilgisi.XML
							.readList(response.getText());

					for (int i = 0; i < xmlOkulSinifBilgisi.size(); i++) {

						lbxTemp.addItem(xmlOkulSinifBilgisi.get(i).okul_durumu);

						lbxTemp2.addItem(xmlOkulSinifBilgisi.get(i).okul_durumu);
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

	private class Image_1MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_1.setUrl("kapat-1.png");

		}
	}
}
