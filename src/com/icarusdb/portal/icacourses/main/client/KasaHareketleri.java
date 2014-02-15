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
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class KasaHareketleri extends Composite {
	private ListHandler<Object> sortHandler = new ListHandler<Object>(
			Collections.<Object> emptyList());

	public KasaHareketleri() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "783px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		horizontalPanel_4
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_4.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_4);
		verticalPanel.setCellHeight(horizontalPanel_4, "30");
		horizontalPanel_4.setSize("100%", "33px");

		Label lblKasaHareketleri = new Label("Kasa Hareketleri");
		horizontalPanel_4.add(lblKasaHareketleri);
		lblKasaHareketleri.setWidth("100%");

		HorizontalPanel horizontalPanel_6 = new HorizontalPanel();
		horizontalPanel_6
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_6.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_6);
		horizontalPanel_6.setSize("100%", "33px");

		Label lblrencidemeleri = new Label("Öğrenci Ödemeleri");
		horizontalPanel_6.add(lblrencidemeleri);
		lblrencidemeleri.setWidth("100%");

		Label lblNewLabel = new Label("Öğrenci Ödemeleri");
		lblNewLabel.setVisible(false);
		verticalPanel.add(lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");
		lblNewLabel.setSize("833px", "22px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "75px");

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

		HorizontalPanel horizontalPanel_5 = new HorizontalPanel();
		horizontalPanel_5
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_5.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_5);
		horizontalPanel_5.setSize("100%", "33px");

		Label lblGelirler = new Label("Gelirler");
		horizontalPanel_5.add(lblGelirler);
		lblGelirler.setWidth("100%");

		Label lblNewLabel_1 = new Label("Gelirler");
		lblNewLabel_1.setVisible(false);
		verticalPanel.add(lblNewLabel_1);
		lblNewLabel_1.setStyleName("gwt-Bold");
		lblNewLabel_1.setSize("784px", "16px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("100%", "75px");

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
		lblGiderler.setVisible(false);

		HorizontalPanel horizontalPanel_7 = new HorizontalPanel();
		horizontalPanel_7
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_7.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_7);
		horizontalPanel_7.setSize("100%", "33px");

		Label lblGiderler_1 = new Label("Giderler");
		horizontalPanel_7.add(lblGiderler_1);
		lblGiderler_1.setWidth("100%");
		verticalPanel.add(lblGiderler);
		lblGiderler.setStyleName("gwt-Bold");
		lblGiderler.setSize("784px", "16px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_2);
		horizontalPanel_2.setSize("100%", "75px");

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

		HorizontalPanel horizontalPanel_8 = new HorizontalPanel();
		horizontalPanel_8
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_8.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_8);
		horizontalPanel_8.setSize("100%", "33px");

		Label lblSonDurum_1 = new Label("Son Durum");
		horizontalPanel_8.add(lblSonDurum_1);
		lblSonDurum_1.setWidth("100%");

		Label lblSonDurum = new Label("Son Durum");
		lblSonDurum.setVisible(false);
		verticalPanel.add(lblSonDurum);
		lblSonDurum.setStyleName("gwt-Bold");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_3);
		horizontalPanel_3.setSize("100%", "75px");

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
