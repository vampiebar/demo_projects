package com.icarusdb.portal.icacourses.main.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class OgrenciIsleri extends Composite {
	private Button btnBugunuGetir;
	private DateBox dtpTarihSeciniz;
	private FlexTable flxDersDagitim;

	public List<String> lstStartTimes;
	public List<String> lstStopTimes;

	public OgrenciIsleri() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

		AbsolutePanel absolutePanel = new AbsolutePanel();
		verticalPanel.add(absolutePanel);
		absolutePanel.setSize("811px", "465px");

		Label lblrenciDersDatm = new Label("Öğrenci Ders Dağıtım İşlemler");
		absolutePanel.add(lblrenciDersDatm, 10, 10);
		lblrenciDersDatm.setSize("775px", "25px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		absolutePanel.add(horizontalPanel, 10, 84);
		horizontalPanel.setSize("775px", "37px");

		Label lblTarihSeiniz = new Label("Tarih Seçiniz");
		horizontalPanel.add(lblTarihSeiniz);
		horizontalPanel.setCellWidth(lblTarihSeiniz, "10");
		lblTarihSeiniz.setSize("109px", "18px");

		dtpTarihSeciniz = new DateBox();
		dtpTarihSeciniz.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("dd.MM.yyyy")));
		horizontalPanel.add(dtpTarihSeciniz);
		horizontalPanel.setCellWidth(dtpTarihSeciniz, "1");
		dtpTarihSeciniz.setSize("146px", "15px");

		btnBugunuGetir = new Button("Bugünü Getir");
		horizontalPanel.add(btnBugunuGetir);
		horizontalPanel.setCellWidth(btnBugunuGetir, "0");

		flxDersDagitim = new FlexTable();
		absolutePanel.add(flxDersDagitim, 10, 139);
		flxDersDagitim.setSize("791px", "256px");

		String strTemplate = "_NO_. Ders _TIME1_-_TIME2_";

		Label lblNewLabel = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 1, lblNewLabel);

		Label lblNewLabel_1 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 2, lblNewLabel_1);

		Label lblNewLabel_3 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 3, lblNewLabel_3);

		Label lblNewLabel_4 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 4, lblNewLabel_4);

		Label lblNewLabel_5 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 5, lblNewLabel_5);

		Label lblNewLabel_6 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 6, lblNewLabel_6);

		Label lblNewLabel_7 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 7, lblNewLabel_7);

		Label lblNewLabel_8 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 8, lblNewLabel_8);

		Label lblNewLabel_9 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 9, lblNewLabel_9);

		Label lblNewLabel_10 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 10, lblNewLabel_10);

		Label lblNewLabel_11 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 11, lblNewLabel_11);

		Label lblNewLabel_12 = new Label(strTemplate);
		flxDersDagitim.setWidget(0, 12, lblNewLabel_12);

		Label lblNewLabel_2 = new Label("New label");
		flxDersDagitim.setWidget(1, 0, lblNewLabel_2);

		if (!isDesignTime()) {

			lstStartTimes = new ArrayList<String>();
			lstStopTimes = new ArrayList<String>();

			lstStartTimes.add("09:10");
			lstStopTimes.add("09:50");

			lstStartTimes.add("10:00");
			lstStopTimes.add("10:40");

			lstStartTimes.add("10:50");
			lstStopTimes.add("11:30");

			lstStartTimes.add("11:40");
			lstStopTimes.add("12:20");

			lstStartTimes.add("12:30");
			lstStopTimes.add("13:10");

			lstStartTimes.add("13:10");
			lstStopTimes.add("14:00");

			lstStartTimes.add("14:00");
			lstStopTimes.add("14:40");

			lstStartTimes.add("14:50");
			lstStopTimes.add("15:30");

			lstStartTimes.add("15:40");
			lstStopTimes.add("16:20");

			lstStartTimes.add("16:30");
			lstStopTimes.add("17:10");

			lstStartTimes.add("17:30");
			lstStopTimes.add("18:10");

			lstStartTimes.add("18:20");
			lstStopTimes.add("19:00");

			flxDersDagitim.setVisible(false);

			dtpTarihSeciniz.setValue(new Date());

			for (int i = 1; i <= 12; i++) {

				((Label) flxDersDagitim.getWidget(0, i)).setText(strTemplate
						.replace("_NO_", i + "")
						.replace("_TIME1_", lstStartTimes.get(i - 1))
						.replace("_TIME2_", lstStopTimes.get(i - 1)));

			}

			// lblNewLabel_10.setText();

			putActiveOgretmenler();

		}// design time

	}

	private void putActiveOgretmenler() {

		final String urlWithParameters = Util.urlBase + "getogretmentanimlari";

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

					List<XMLOgretmenTanimlari> listXmlOgretmenTanimlari = XMLOgretmenTanimlari.XML
							.readList(response.getText());

					for (int i = 0; i < listXmlOgretmenTanimlari.size(); i++) {

						flxDersDagitim.setWidget(i + 1, 0, new CmpstDers(
								listXmlOgretmenTanimlari.get(i).adi_soyadi));

						for (int j = 1; j < 12; j++) {

							final PanDers panDers = new PanDers(lstStartTimes
									.get(j - 1), lstStopTimes.get(j - 1));

							panDers.setSize("100%", "100%");

							panDers.addClickHandler(new ClickHandler() {

								@Override
								public void onClick(ClickEvent event) {

									Window.alert(panDers.getTimeStart() + " "
											+ panDers.getTimeStop());
								}
							});

							flxDersDagitim.setWidget(i + 1, j, panDers);
						}

					}

					flxDersDagitim.setVisible(true);

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
}
