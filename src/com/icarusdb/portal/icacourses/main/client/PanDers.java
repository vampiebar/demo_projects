package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanDers extends VerticalPanel implements HasClickHandlers {

	String _timeStart = "09:10";
	String _timeStop = "09:50";

	public PanDers(String timeStart, String timeStop) {

		_timeStart = timeStart;
		_timeStop = timeStop;

	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {

		return addDomHandler(handler, ClickEvent.getType());
	}

	public String getTimeStart() {

		return _timeStart;
	}

	public String getTimeStop() {

		return _timeStop;
	}

}
