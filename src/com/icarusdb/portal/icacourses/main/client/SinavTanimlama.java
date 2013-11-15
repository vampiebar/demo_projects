package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.view.client.SingleSelectionModel;

public class SinavTanimlama extends Composite {
	private CellTable<XMLSinavTanimlama> grdSinavTanimlama;
	private Column<XMLSinavTanimlama, Number> column;
	private TextColumn<XMLSinavTanimlama> textColumn;
	private Column<XMLSinavTanimlama, String> column_1;
	private TextColumn<XMLSinavTanimlama> textColumn_1;
	private TextColumn<XMLSinavTanimlama> textColumn_2;
	private Button btnYeniKayit;
	private ListBox cbxSinavTuru;

	public SinavTanimlama() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("780px", "429px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 20, 137);
		horizontalPanel.setSize("727px", "156px");

		grdSinavTanimlama = new CellTable<XMLSinavTanimlama>();
		horizontalPanel.add(grdSinavTanimlama);
		grdSinavTanimlama.setSize("737px", "124px");

		column = new Column<XMLSinavTanimlama, Number>(new NumberCell()) {
			@Override
			public Number getValue(XMLSinavTanimlama object) {
				return (Number) null;
			}
		};
		grdSinavTanimlama.addColumn(column, "Kayıt No");

		textColumn = new TextColumn<XMLSinavTanimlama>() {
			public String getValue(XMLSinavTanimlama object) {
				return object.sinav_adi.toString();
			}
		};
		grdSinavTanimlama.addColumn(textColumn, "Sınav Adı");

		column_1 = new TextColumn<XMLSinavTanimlama>() {
			@Override
			public String getValue(XMLSinavTanimlama object) {
				return (object.tarih);
			}
		};
		grdSinavTanimlama.addColumn(column_1, "Sınav Tarihi");

		textColumn_1 = new TextColumn<XMLSinavTanimlama>() {
			public String getValue(XMLSinavTanimlama object) {
				return object.son_kitapcik_no.toString();
			}
		};
		grdSinavTanimlama.addColumn(textColumn_1, "Son Kitapçık No");

		textColumn_2 = new TextColumn<XMLSinavTanimlama>() {
			public String getValue(XMLSinavTanimlama object) {
				return (String) null;
			}
		};
		grdSinavTanimlama.addColumn(textColumn_2, "İşlemler");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonListeyiYenile");
		absolutePanel.add(btnListeyiYenile, 491, 42);
		btnListeyiYenile.setSize("78px", "48px");

		btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 588, 42);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 679, 42);
		btnExceleAktar.setSize("78px", "48px");

		Label lblSnavTuru = new Label("Sınav Türü");
		lblSnavTuru.setStyleName("gwt-Bold");
		absolutePanel.add(lblSnavTuru, 32, 37);

		cbxSinavTuru = new ListBox();
		cbxSinavTuru.setStyleName("gwt-ComboBox1");
		cbxSinavTuru.addItem(" ");
		absolutePanel.add(cbxSinavTuru, 115, 37);
		cbxSinavTuru.setSize("153px", "24px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLSinavTanimlama> selectionModel = new SingleSelectionModel<XMLSinavTanimlama>();

			grdSinavTanimlama.setSelectionModel(selectionModel);
			grdSinavTanimlama.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLSinavTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.sinav_adi);

					}

				}
			}, DoubleClickEvent.getType());
		}

	}

	protected void showWithData(String sinav_adi) {

		String urlWithParameters = Util.urlBase
				+ "getsinavtanimlama?sinav_adi=" + sinav_adi;

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				urlWithParameters);

		// Window.alert("URL TO GET VALUES: " + urlWithParameters);
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLSinavTanimlama> listXmlSinavTanimlama = XMLSinavTanimlama.XML
							.readList(response.getText());

					DlgSinavTanimlama dlgTemp = new DlgSinavTanimlama();
					dlgTemp.putDataFromXML(listXmlSinavTanimlama.get(0));
					dlgTemp.setAnimationEnabled(true);
					dlgTemp.center();

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase + "getsinavtanimlama";

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				urlWithParameters);

		// Window.alert("URL TO GET VALUES: " + urlWithParameters);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLSinavTanimlama> listXmlSinavTanimlama = XMLSinavTanimlama.XML
							.readList(response.getText());

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdSinavTanimlama.setRowCount(1, true);

					// Push the data into the widget.
					grdSinavTanimlama.setRowData(0, listXmlSinavTanimlama);

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	// Implement the following method exactly as-is
	private static final boolean isDesignTime() {
		// return Beans.isDesignTime(); // GWT 2.4 and above
		return false; // GWT 2.2 and earlier
	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			DlgSinavTanimlama dlgTemp = new DlgSinavTanimlama();
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}

	}
}
