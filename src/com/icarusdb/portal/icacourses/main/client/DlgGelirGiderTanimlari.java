package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class DlgGelirGiderTanimlari extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private ListBox cbxKategoriAdi;
	private ListBox cbxTipi;
	private TextBox tctGelirGiderAdi;

	public DlgGelirGiderTanimlari(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		setHTML("Gelir / Gider Tanımı");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		setWidget(absolutePanel);
		absolutePanel.setSize("691px", "470px");

		Label lblGelirGider = new Label(
				"Gelir / Gider Tanımı ( Ekleme / Düzenleme ) ");
		lblGelirGider.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblGelirGider, 0, 0);
		lblGelirGider.setSize("691px", "28px");

		Label lblKategoriAdı = new Label("Kategori Adı");
		lblKategoriAdı.setStyleName("gwt-Bold");
		absolutePanel.add(lblKategoriAdı, 10, 50);
		lblKategoriAdı.setSize("92px", "28px");

		Label lblTipi = new Label("Tipi");
		lblTipi.setStyleName("gwt-Bold");
		absolutePanel.add(lblTipi, 10, 84);

		Label lblGelirGider_1 = new Label("Gelir / Gider Adı");
		lblGelirGider_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblGelirGider_1, 10, 112);
		lblGelirGider_1.setSize("103px", "16px");

		cbxKategoriAdi = new ListBox();
		cbxKategoriAdi.addItem(" ");
		cbxKategoriAdi.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxKategoriAdi, 136, 46);
		cbxKategoriAdi.setSize("158px", "22px");

		cbxTipi = new ListBox();
		cbxTipi.addItem("Gelir");
		cbxTipi.addItem("Gider");
		cbxTipi.setStyleName("gwt-ComboBox1");
		absolutePanel.add(cbxTipi, 136, 76);
		cbxTipi.setSize("158px", "22px");

		tctGelirGiderAdi = new TextBox();
		tctGelirGiderAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctGelirGiderAdi, 136, 110);
		tctGelirGiderAdi.setSize("156px", "14px");

		Button btnKaydet = new Button("New button");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 435, 164);
		btnKaydet.setSize("78px", "48px");

		Button btnKapat = new Button("New button");
		btnKapat.setStyleName("gwt-ButonKapat");
		btnKapat.addClickHandler(new BtnKapatClickHandler());
		btnKapat.setText("Kapat");
		absolutePanel.add(btnKapat, 539, 164);
		btnKapat.setSize("78px", "48px");

		if (!isDesignTime()) {

			putKategoriAdiToCbx(cbxKategoriAdi);

		}
	}

	private void putKategoriAdiToCbx(final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getgelirgiderkategorileri");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getdbssinavtanimla " + response.getText());

					List<XMLGelirGiderKategorileri> xmlGelirGiderKategorileri = XMLGelirGiderKategorileri.XML
							.readList(response.getText());

					for (int i = 0; i < xmlGelirGiderKategorileri.size(); i++) {

						lbxTemp.addItem(xmlGelirGiderKategorileri.get(i).kategori_adi);

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
			String URLValue = Util.urlBase + "putgelirgidertanimlari?";
			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue
					+ "&kategori_adi="
					+ cbxKategoriAdi.getItemText(cbxKategoriAdi
							.getSelectedIndex());
			URLValue = URLValue + "&tipi="
					+ cbxTipi.getValue(cbxTipi.getSelectedIndex());
			URLValue = URLValue + "&gelir_gider_adi="
					+ tctGelirGiderAdi.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");
		}
	}

	public void putDataFromXML(XMLGelirGiderTanimlari xml) {
		tctGelirGiderAdi.setText(xml.gelir_gider_adi);
		cbxKategoriAdi.setItemText(0, xml.kategori_adi);

		cbxTipi.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxTipi, xml.tipi));

	}
}
