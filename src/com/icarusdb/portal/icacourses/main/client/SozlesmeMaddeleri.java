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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBoxBase;

public class SozlesmeMaddeleri extends Composite {
	private TextArea tctSozlesmeMaddeleri;
	public boolean _isInsert = true;
	public long _id = -1;

	public SozlesmeMaddeleri(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("813px", "750px");

		Label lblKesinKaytSzleme = new Label(
				"Kesin Kayıt Sözleşme Maddeleri (Düzenleme)");
		lblKesinKaytSzleme.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblKesinKaytSzleme, 0, 10);
		lblKesinKaytSzleme.setSize("813px", "32px");

		Label lblMteriSzlemeMaddeleri = new Label("Müşteri Sözleşme Maddeleri");
		lblMteriSzlemeMaddeleri.setStyleName("gwt-Bold");
		absolutePanel.add(lblMteriSzlemeMaddeleri, 43, 60);

		Label lblSzlemeMaddelri = new Label("Sözleşme Maddeleri\r\n");
		lblSzlemeMaddelri.setStyleName("gwt-Bold");
		absolutePanel.add(lblSzlemeMaddelri, 43, 92);

		Button btnKaydet = new Button("New button");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 647, 530);
		btnKaydet.setSize("69px", "36px");

		tctSozlesmeMaddeleri = new TextArea();
		absolutePanel.add(tctSozlesmeMaddeleri, 35, 161);
		tctSozlesmeMaddeleri.setSize("675px", "328px");
		tctSozlesmeMaddeleri.setStyleName("gwt-TextBox1");
		tctSozlesmeMaddeleri.setTextAlignment(TextBoxBase.ALIGN_LEFT);

		if (!isDesignTime()) {
			getSozlesmeMaddeleri(1);

		}

	}

	private void getSozlesmeMaddeleri(long id) {
		String urlWithParameters = Util.urlBase + "getsozlesmemaddeleri?id="
				+ id;

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				urlWithParameters);

		// Window.alert("URL TO GET VALUES: " + urlWithParameters);
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					List<XMLSozlesmeMaddeleri> listXmlSozlesmeMaddeleri = XMLSozlesmeMaddeleri.XML
							.readList(response.getText());

					// Window.alert("AAABBBCCC " + response.getText());

					putDataFromXML(listXmlSozlesmeMaddeleri.get(0));

				}

				private void putDataFromXML(XMLSozlesmeMaddeleri xml) {
					tctSozlesmeMaddeleri.setText(xml.sozlesme);

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

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putsozlesmemaddeleri?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&sozlesme=" + tctSozlesmeMaddeleri.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue,
					"SÖZLEŞME MADDELERİ BAŞARI İLE KAYIT EDİLDİ",
					"SÖZLEŞME MADDELERİ KAYIT EDİLEMEDİ");
		}
	}
}
