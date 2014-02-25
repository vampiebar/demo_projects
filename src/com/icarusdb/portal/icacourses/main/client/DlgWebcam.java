package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.gwt.webcam.client.Webcam;

public class DlgWebcam extends DialogBox {
	private SimplePanel smpanWebcam;

	public DlgWebcam() {

		setHTML("Webcam");

		VerticalPanel verticalPanel = new VerticalPanel();
		setWidget(verticalPanel);
		verticalPanel.setSize("388px", "341px");

		smpanWebcam = new SimplePanel();
		verticalPanel.add(smpanWebcam);
		smpanWebcam.setHeight("123px");

		Button btnNewButton = new Button("New button");
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		verticalPanel.add(btnNewButton);

		if (!isDesignTime()) {

			final Webcam webcam = Webcam.get();

			// smpanWebcam.add(Webcam.get());

			webcam.setShutterSoundEnabled(true);
			webcam.setQuality(90);
			webcam.setShutterSoundEnabled(false);
			webcam.setStealthEnabled(true);

			webcam.addWebcamErrorHandler(new Webcam.ErrorHandler() {

				@Override
				public void onWebcamError(
						com.logikas.gwt.webcam.client.Webcam.ErrorEvent event) {
					Window.alert("There is an error: " + event.getResult());

				}
			});

			webcam.addWebcamLoadHandler(new Webcam.LoadHandler() {

				@Override
				public void onWebcamLoad(
						com.logikas.gwt.webcam.client.Webcam.LoadEvent event) {
					webcam.configure(Webcam.ConfigurationType.PRIVACY);

				}
			});

			Widget webcamCanvas = webcam.createCurrentCanvas(320, 240);

			smpanWebcam.add(webcamCanvas);

		}

	}

	private boolean isDesignTime() {

		return false;
	}

	private class BtnNewButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}
}