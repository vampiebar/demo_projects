package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Yetki extends Composite {

	public Yetki() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "750px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_2.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "50");
		horizontalPanel_2.setSize("100%", "33px");

		Label lblYetki = new Label("Kullanıcı Tanımlama");
		horizontalPanel_2.add(lblYetki);
		lblYetki.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "44px");

		Button button_1 = new Button("Yeni Kayıt");
		horizontalPanel_1.add(button_1);
		button_1.setStyleName("gwt-YeniKayit2");
		button_1.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "75px");

		CellTable<Object> cellTable = new CellTable<Object>();
		horizontalPanel.add(cellTable);
		cellTable.setSize("100%", "100%");

		Column<Object, Number> column_1 = new Column<Object, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Object object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(column_1, "Kullanıcı Kodu");

		TextColumn<Object> textColumn = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn, "Adı");

		TextColumn<Object> textColumn_1 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_1, "Soyadı");

		Column<Object, Number> column_2 = new Column<Object, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Object object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(column_2, "Şifre");

		Column<Object, String> column = new Column<Object, String>((Cell) null) {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable.addColumn(column, "İşlemler");
	}
}
