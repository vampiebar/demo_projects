package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
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
		absolutePanel.setSize("820px", "601px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwtabsolute");
		absolutePanel.add(absolutePanel_1, 10, 10);
		absolutePanel_1.setSize("694px", "33px");

		Label lblDersDatmIlemler = new Label("Ders Dağıtım İşlemler");
		lblDersDatmIlemler.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblDersDatmIlemler, 20, 10);

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setText("");
		btnListeyiYenile.setStyleName("gwt-ButtonListeyiYenile");
		absolutePanel.add(btnListeyiYenile, 509, 49);
		btnListeyiYenile.setSize("91px", "75px");

		Button btnRaporAl = new Button("Rapor Al");
		btnRaporAl.setText("");
		btnRaporAl.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnRaporAl, 606, 49);
		btnRaporAl.setSize("97px", "75px");

		Label lblTarihSeiniz = new Label("Tarih Seçiniz...");
		lblTarihSeiniz.setStyleName("gwt-Bold");
		absolutePanel.add(lblTarihSeiniz, 10, 121);
		lblTarihSeiniz.setSize("104px", "26px");

		dtpTarihSeciniz = new DateBox();
		dtpTarihSeciniz.setStyleName("gwt-TextBox1");
		dtpTarihSeciniz.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("dd-MM-yyyy")));
		absolutePanel.add(dtpTarihSeciniz, 120, 121);
		dtpTarihSeciniz.setSize("143px", "17px");

		smpanCalendar = new SimplePanel();
		absolutePanel.add(smpanCalendar, 10, 153);
		smpanCalendar.setSize("800px", "347px");

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
