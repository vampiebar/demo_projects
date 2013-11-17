package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
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
import com.google.gwt.view.client.SingleSelectionModel;

public class GelirlerveGiderler extends Composite {
	private CellTable<XMLGelirlerveGiderler> grdGelirlerveGiderler;
	private Column<XMLGelirlerveGiderler, String> column;

	public GelirlerveGiderler() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("781px", "423px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 170);
		horizontalPanel.setSize("727px", "156px");

		grdGelirlerveGiderler = new CellTable<XMLGelirlerveGiderler>();
		horizontalPanel.add(grdGelirlerveGiderler);
		grdGelirlerveGiderler.setSize("100%", "100%");

		column = new TextColumn<XMLGelirlerveGiderler>() {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return (object.tarih);
			}
		};
		grdGelirlerveGiderler.addColumn(column, "Tarih - Saat");

		TextColumn<XMLGelirlerveGiderler> textColumn = new TextColumn<XMLGelirlerveGiderler>() {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return object.gelirler.toString();
			}
		};
		grdGelirlerveGiderler.addColumn(textColumn, "Gelir / Gider Tanımı");

		TextColumn<XMLGelirlerveGiderler> column_1 = new TextColumn<XMLGelirlerveGiderler>() {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return object.islem_tipi.toString();
			}
		};
		grdGelirlerveGiderler.addColumn(column_1, "Gelir / Gider Tipi");

		TextColumn<XMLGelirlerveGiderler> textColumn_1 = new TextColumn<XMLGelirlerveGiderler>() {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return object.miktar.toString();
			}
		};
		grdGelirlerveGiderler.addColumn(textColumn_1, "Ödeme Miktarı");

		Column<XMLGelirlerveGiderler, String> column_4 = new Column<XMLGelirlerveGiderler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return (String) null;
			}
		};
		grdGelirlerveGiderler.addColumn(column_4, "İşlemler");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 580, 75);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 485, 75);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 669, 75);
		btnExceleAktar.setSize("78px", "48px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLGelirlerveGiderler> selectionModel = new SingleSelectionModel<XMLGelirlerveGiderler>();

			grdGelirlerveGiderler.setSelectionModel(selectionModel);
			grdGelirlerveGiderler.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLGelirlerveGiderler selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());
		}

	}

	protected void showWithData(String id) {

		String urlWithParameters = Util.urlBase + "getgelirlervegiderler?id="
				+ id;

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

					List<XMLGelirlerveGiderler> listXmlGelirlerveGiderler = XMLGelirlerveGiderler.XML
							.readList(response.getText());

					DlgGelirlerveGiderler dlgTemp = new DlgGelirlerveGiderler();
					dlgTemp.putDataFromXML(listXmlGelirlerveGiderler.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
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

		String urlWithParameters = Util.urlBase + "getgelirlervegiderler";

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

					List<XMLGelirlerveGiderler> listXmlGelirlerveGiderler = XMLGelirlerveGiderler.XML
							.readList(response.getText());

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdGelirlerveGiderler.setRowCount(1, true);

					// Push the data into the widget.
					grdGelirlerveGiderler.setRowData(0,
							listXmlGelirlerveGiderler);

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
			DlgGelirlerveGiderler dlgTemp = new DlgGelirlerveGiderler();
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}
