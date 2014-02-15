package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class AtanmisOdevler extends Composite {
	private DateBox dtpBaslangicTarihi;
	private DateBox dtpBitisTarihi;
	private CellTable<Object> grdAtanmisOdevler;

	public AtanmisOdevler() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "750px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "50");
		horizontalPanel_1.setSize("100%", "33px");

		Label lblAtanmdevler = new Label("Atanmış Ödevler");
		horizontalPanel_1.add(lblAtanmdevler);
		lblAtanmdevler.setWidth("100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "30");
		horizontalPanel_2.setWidth("100%");

		Label lblNewLabel = new Label("");
		horizontalPanel_2.add(lblNewLabel);
		lblNewLabel.setWidth("12px");

		FlexTable flexTable = new FlexTable();
		horizontalPanel_2.add(flexTable);
		flexTable.setSize("100px", "100px");

		Label lblBalangTarihi = new Label("Başlangıç Tarihi");
		flexTable.setWidget(0, 0, lblBalangTarihi);
		lblBalangTarihi.setStyleName("gwt-Bold");

		dtpBaslangicTarihi = new DateBox();
		flexTable.setWidget(0, 1, dtpBaslangicTarihi);
		dtpBaslangicTarihi
				.addValueChangeHandler(new DtpBaslangicTarihiValueChangeHandler());
		dtpBaslangicTarihi.setStyleName("gwt-TextBox1");
		dtpBaslangicTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getShortDateTimeFormat()));
		dtpBaslangicTarihi.setSize("143px", "16px");

		Label lblBitiTarihi = new Label("Bitiş Tarihi");
		flexTable.setWidget(1, 0, lblBitiTarihi);
		lblBitiTarihi.setStyleName("gwt-Bold");

		dtpBitisTarihi = new DateBox();
		flexTable.setWidget(1, 1, dtpBitisTarihi);
		dtpBitisTarihi
				.addValueChangeHandler(new DtpBitisTarihiValueChangeHandler());
		dtpBitisTarihi.setStyleName("gwt-TextBox1");
		dtpBitisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getShortDateTimeFormat()));
		dtpBitisTarihi.setSize("143px", "16px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "183px");

		grdAtanmisOdevler = new CellTable<Object>();
		horizontalPanel.add(grdAtanmisOdevler);
		grdAtanmisOdevler.setSize("100%", "100%");

		TextColumn<Object> textColumn = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		grdAtanmisOdevler.addColumn(textColumn, "Öğretmen Adı Soyadı");

		Column<Object, Number> column = new Column<Object, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Object object) {
				return (Number) null;
			}
		};
		grdAtanmisOdevler.addColumn(column, "Verilmiş Ödev Sayısı");

		Column<Object, String> column_1 = new Column<Object, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Object object) {
				return (String) null;
			}
		};
		grdAtanmisOdevler.addColumn(column_1, "");
	}

	private class DtpBaslangicTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm");
			// Window.alert(dtf.format(dtpBaslangicTarihi.getValue()));
		}
	}

	private class DtpBitisTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm");
			// Window.alert(dtf.format(dtpBitisTarihi.getValue()));
		}
	}
}
