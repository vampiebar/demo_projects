package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class OgrenciKayitlari extends Composite {
	private TextBox tctAranacakAnahtarKelime;

	public OgrenciKayitlari() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("488px", "366px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		verticalPanel.add(absolutePanel);
		absolutePanel.setSize("755px", "472px");

		Label lblAranacakAnahtarKelime = new Label("Aranacak Anahtar Kelime");
		lblAranacakAnahtarKelime.setStyleName("gwt-Bold");
		absolutePanel.add(lblAranacakAnahtarKelime, 49, 38);

		tctAranacakAnahtarKelime = new TextBox();
		tctAranacakAnahtarKelime.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAranacakAnahtarKelime, 199, 31);
		tctAranacakAnahtarKelime.setSize("239px", "19px");

		CellTable<Object> cellTable = new CellTable<Object>();
		absolutePanel.add(cellTable, 10, 83);
		cellTable.setSize("100%", "154px");

		TextColumn<Object> textColumn_2 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_2, "New Column");
		cellTable.setColumnWidth(textColumn_2, "41px");

		TextColumn<Object> textColumn_1 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_1, "New Column");

		Column<Object, Number> column = new Column<Object, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Object object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(column, "New Column");

		TextColumn<Object> textColumn = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn, "New Column");
	}
}
