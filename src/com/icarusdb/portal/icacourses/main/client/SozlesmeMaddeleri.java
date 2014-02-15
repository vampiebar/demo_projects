package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.axeiya.gwtckeditor.client.CKConfig;
import com.axeiya.gwtckeditor.client.CKEditor;
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
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SozlesmeMaddeleri extends Composite {
	public boolean _isInsert = true;
	public long _id = -1;
	private SimplePanel smpanHtmlEditor;

	public CKEditor ckhtmlSozlesmeMaddeleri;
	private Button btnKaydet;
	private Image image;

	public SozlesmeMaddeleri(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "750px");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		absolutePanel.add(verticalPanel_1, 0, 0);
		verticalPanel_1.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setStyleName("gwt-LabelMor2");
		verticalPanel_1.add(horizontalPanel_1);
		verticalPanel_1.setCellHeight(horizontalPanel_1, "50");
		horizontalPanel_1.setSize("100%", "33px");

		Label lblKesinKaytSzleme = new Label(
				"Kesin Kayıt Sözleşme Maddeleri (Düzenleme)");
		horizontalPanel_1.add(lblKesinKaytSzleme);
		lblKesinKaytSzleme.setWidth("100%");

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel_1.add(verticalPanel);
		verticalPanel.setSize("100px", "100px");

		Label lblMteriSzlemeMaddeleri = new Label("Müşteri Sözleşme Maddeleri");
		verticalPanel.add(lblMteriSzlemeMaddeleri);
		lblMteriSzlemeMaddeleri.setWidth("100%");
		verticalPanel.setCellHeight(lblMteriSzlemeMaddeleri, "25");
		lblMteriSzlemeMaddeleri.setStyleName("gwt-Bold");

		Label lblSzlemeMaddelri = new Label("Sözleşme Maddeleri\r\n");
		verticalPanel.add(lblSzlemeMaddelri);
		lblSzlemeMaddelri.setWidth("100%");
		verticalPanel.setCellHeight(lblSzlemeMaddelri, "25");
		lblSzlemeMaddelri.setStyleName("gwt-Bold");

		smpanHtmlEditor = new SimplePanel();
		verticalPanel.add(smpanHtmlEditor);
		smpanHtmlEditor.setSize("760px", "414px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setWidth("100%");

		btnKaydet = new Button("New button");
		btnKaydet.setVisible(false);
		horizontalPanel.add(btnKaydet);
		horizontalPanel.setCellWidth(btnKaydet, "600");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.setText("Kaydet");
		btnKaydet.setSize("69px", "36px");

		image = new Image("kaydet-1.png");
		horizontalPanel.add(image);
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addClickHandler(new ImageClickHandler());
		image.setSize("72px", "66px");

		if (!isDesignTime()) {

			getSozlesmeMaddeleri(1);

			ckhtmlSozlesmeMaddeleri = new CKEditor(CKConfig.basic);

			smpanHtmlEditor.add(ckhtmlSozlesmeMaddeleri);

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

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private boolean isDesignTime() {

		return false;
	}

	private void putDataFromXML(XMLSozlesmeMaddeleri xml) {

		// tctSozlesmeMaddeleri.setText(xml.sozlesme);
		ckhtmlSozlesmeMaddeleri.setHTML(xml.sozlesme);

	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URL2 = URL.encode(ckhtmlSozlesmeMaddeleri.getHTML());
			String URLValue = Util.urlBase + "putsozlesmemaddeleri?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue
					+ "&sozlesme="
					+ URL2.replace("&Ccedil;", "___C___")
							.replace("&ccedil;", "___c___")
							.replace("&Uuml;", "___U___")
							.replace("&uuml;", "___u___")
							.replace("&Ouml;", "___O___")
							.replace("&ouml;", "___o___");

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue,
					"SÖZLEŞME MADDELERİ BAŞARI İLE KAYIT EDİLDİ",
					"SÖZLEŞME MADDELERİ KAYIT EDİLEMEDİ");
		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKaydet.click();
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
}
