package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DersDagitimSistemi extends Composite {
	private SimplePanel smpanCalendar;
	private DateBox dtpTarihSeciniz;

	public DersDagitimSistemi() {

		// Calendar calendar = new Calendar();
		// calendar.setDate(new Date()); //calendar date, not required
		// calendar.setDays(3); //number of days displayed at a time, not
		// required
		// calendar.setWidth("500px");
		// calendar.setHeight("400px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "601px");

		smpanCalendar = new SimplePanel();
		absolutePanel.add(smpanCalendar, 10, 153);
		smpanCalendar.setSize("800px", "347px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setStyleName("gwt-LabelMor2");
		absolutePanel.add(horizontalPanel, 0, 0);
		horizontalPanel.setSize("100%", "33px");

		Label lblDersDatmSistemi = new Label("Ders Dağıtım Sistemi");
		horizontalPanel.add(lblDersDatmSistemi);
		lblDersDatmSistemi.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		absolutePanel.add(horizontalPanel_1, 10, 85);
		horizontalPanel_1.setSize("249px", "23px");

		Label lblTarihSeiniz = new Label("Tarih Seçiniz");
		horizontalPanel_1.add(lblTarihSeiniz);
		lblTarihSeiniz.setStyleName("gwt-Bold");
		lblTarihSeiniz.setSize("104px", "18px");

		dtpTarihSeciniz = new DateBox();
		horizontalPanel_1.add(dtpTarihSeciniz);
		dtpTarihSeciniz.setStyleName("gwt-TextBox1");
		dtpTarihSeciniz.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("dd-MM-yyyy")));
		dtpTarihSeciniz.setSize("143px", "17px");

		if (!isDesignTime()) {
			dtpTarihSeciniz.setValue(new Date());

			// smpanCalendar.add(calendar);
		}

	}

	// Implement the following method exactly as-is
	private static final boolean isDesignTime() {
		return false; // GWT 2.2 and earlier
		// return Beans.isDesignTime(); // GWT 2.4 and above

	}
}
