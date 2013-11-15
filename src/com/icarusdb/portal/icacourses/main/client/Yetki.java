package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class Yetki extends Composite {

	public Yetki() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("796px", "461px");

		Button button = new Button("Listeyi Yenile");
		button.setStyleName("gwt-ButtonListeyiYenile");
		absolutePanel.add(button, 565, 35);
		button.setSize("78px", "48px");

		Button button_1 = new Button("Yeni Kayıt");
		button_1.setStyleName("gwt-ButonYeniKayit");
		absolutePanel.add(button_1, 470, 35);
		button_1.setSize("78px", "48px");

		Button button_2 = new Button("Excel'e Aktar");
		button_2.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(button_2, 654, 35);
		button_2.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 146);
		horizontalPanel.setSize("774px", "75px");

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
