package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
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
		absolutePanel.setSize("628px", "579px");

		Label lblBalangTarihi = new Label("Başlangıç Tarihi");
		lblBalangTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblBalangTarihi, 10, 24);

		Label lblBitiTarihi = new Label("Bitiş Tarihi");
		lblBitiTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblBitiTarihi, 10, 59);

		dtpBaslangicTarihi = new DateBox();
		dtpBaslangicTarihi
				.addValueChangeHandler(new DtpBaslangicTarihiValueChangeHandler());
		dtpBaslangicTarihi.setStyleName("gwt-TextBox1");
		dtpBaslangicTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getShortDateTimeFormat()));
		absolutePanel.add(dtpBaslangicTarihi, 128, 24);
		dtpBaslangicTarihi.setSize("143px", "16px");

		dtpBitisTarihi = new DateBox();
		dtpBitisTarihi
				.addValueChangeHandler(new DtpBitisTarihiValueChangeHandler());
		dtpBitisTarihi.setStyleName("gwt-TextBox1");
		dtpBitisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getShortDateTimeFormat()));
		absolutePanel.add(dtpBitisTarihi, 128, 55);
		dtpBitisTarihi.setSize("143px", "16px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 109);
		horizontalPanel.setSize("608px", "183px");

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

		Button btnAra = new Button("ARA");
		btnAra.setStyleName("gwt-ButtonSave");
		btnAra.addClickHandler(new BtnAraClickHandler());
		absolutePanel.add(btnAra, 448, 48);
		btnAra.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButonYeniKayit");
		absolutePanel.add(btnExceleAktar, 540, 48);
		btnExceleAktar.setSize("78px", "48px");
	}

	private class BtnAraClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
					Util.urlBase + "getatanmisodevler");

			try {
				Request request = builder.sendRequest(null,
						new RequestCallback() {
							public void onError(Request request,
									Throwable exception) {

							}

							@Override
							public void onResponseReceived(Request request,
									Response response) {

								// Window.alert("AAABBBCCC " +
								// response.getText());

								XMLAtanmisODevler xmlAtanmisODevler = XMLAtanmisODevler.XML
										.read(response.getText());

								// lblNewLabel
								// .setText(xmlAtanmisODevler.baslangic_tarihi);
								// Set the total row count. This isn't strictly
								// necessary, but it affects
								// paging calculations, so its good habit to
								// keep the row count up to date.
								// grdAtanmisOdevler.setRowCount(1, true);

								// Push the data into the widget.
								// grdAtanmisOdevler.setRowData(0,
								// list);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
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
