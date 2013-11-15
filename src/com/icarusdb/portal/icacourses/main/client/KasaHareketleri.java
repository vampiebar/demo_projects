package com.icarusdb.portal.icacourses.main.client;

import java.util.Collections;
import java.util.Comparator;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class KasaHareketleri extends Composite {
	private ListHandler<Object> sortHandler = new ListHandler<Object>(
			Collections.<Object> emptyList());

	public KasaHareketleri() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("843px", "783px");

		Label lblNewLabel = new Label("Öğrenci Ödemeleri");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 28);
		lblNewLabel.setSize("833px", "22px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 50);
		horizontalPanel.setSize("774px", "75px");

		CellTable<Object> grdOgrenciOdemeleri = new CellTable<Object>();
		grdOgrenciOdemeleri.addColumnSortHandler(sortHandler);
		horizontalPanel.add(grdOgrenciOdemeleri);
		grdOgrenciOdemeleri.setSize("100%", "100%");

		TextColumn<Object> textColumn_1 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		textColumn_1.setDataStoreName("");
		textColumn_1.setSortable(true);
		grdOgrenciOdemeleri.addColumn(textColumn_1, "Ödeme Türü");
		sortHandler.setComparator(textColumn_1, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				return 0;
			}
		});

		TextColumn<Object> textColumn = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		grdOgrenciOdemeleri.addColumn(textColumn, "Banka Adı");

		Column<Object, Number> column = new Column<Object, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Object object) {
				return (Number) null;
			}
		};
		grdOgrenciOdemeleri.addColumn(column, "Toplam Ödeme Miktarı");

		Label lblNewLabel_1 = new Label("Gelirler");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 10, 210);
		lblNewLabel_1.setSize("784px", "16px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 10, 232);
		horizontalPanel_1.setSize("774px", "75px");

		CellTable<Object> grdGelirler = new CellTable<Object>();
		horizontalPanel_1.add(grdGelirler);
		grdGelirler.setSize("100%", "100%");

		TextColumn<Object> textColumn_2 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		grdGelirler.addColumn(textColumn_2, "Ödeme Türü");

		TextColumn<Object> textColumn_3 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		grdGelirler.addColumn(textColumn_3, "Banka Adı");

		Column<Object, Number> column_1 = new Column<Object, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Object object) {
				return (Number) null;
			}
		};
		grdGelirler.addColumn(column_1, "Toplam Ödeme Miktarı");

		Label lblGiderler = new Label("Giderler");
		lblGiderler.setStyleName("gwt-Bold");
		absolutePanel.add(lblGiderler, 10, 394);
		lblGiderler.setSize("784px", "16px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_2, 10, 416);
		horizontalPanel_2.setSize("774px", "75px");

		CellTable<Object> grdGiderler = new CellTable<Object>();
		horizontalPanel_2.add(grdGiderler);
		grdGiderler.setSize("100%", "100%");

		TextColumn<Object> textColumn_5 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		grdGiderler.addColumn(textColumn_5, "Ödeme Türü");

		TextColumn<Object> textColumn_4 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		grdGiderler.addColumn(textColumn_4, "Banka Adı");

		Column<Object, Number> column_2 = new Column<Object, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Object object) {
				return (Number) null;
			}
		};
		grdGiderler.addColumn(column_2, "Toplam Ödeme Miktarı");

		Label lblSonDurum = new Label("Son Durum");
		lblSonDurum.setStyleName("gwt-Bold");
		absolutePanel.add(lblSonDurum, 10, 578);

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_3, 10, 603);
		horizontalPanel_3.setSize("774px", "75px");

		CellTable<Object> grdSonDurum = new CellTable<Object>();
		horizontalPanel_3.add(grdSonDurum);
		grdSonDurum.setSize("100%", "100%");

		TextColumn<Object> textColumn_7 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		grdSonDurum.addColumn(textColumn_7, "Ödeme Türü");

		TextColumn<Object> textColumn_6 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		grdSonDurum.addColumn(textColumn_6, "Banka Adı");

		Column<Object, Number> column_3 = new Column<Object, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(Object object) {
				return (Number) null;
			}
		};
		grdSonDurum.addColumn(column_3, "Toplam Ödeme Miktarı");
	}
}
