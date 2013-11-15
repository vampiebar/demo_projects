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

public class KursZamaniTanimlama extends Composite {
	private CellTable<XMLKursZamaniTanimlama> grdKursZamaniTanimlama;

	public KursZamaniTanimlama() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("806px", "417px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonListeyiYenile");
		absolutePanel.add(btnListeyiYenile, 545, 36);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 36);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 634, 36);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 163);
		horizontalPanel.setSize("774px", "75px");

		grdKursZamaniTanimlama = new CellTable<XMLKursZamaniTanimlama>();
		horizontalPanel.add(grdKursZamaniTanimlama);
		grdKursZamaniTanimlama.setSize("100%", "100%");

		Column<XMLKursZamaniTanimlama, ?> textColumn_3 = new TextColumn<XMLKursZamaniTanimlama>() {
			public String getValue(XMLKursZamaniTanimlama object) {
				return object.kurs_zamani.toString();
			}
		};
		grdKursZamaniTanimlama.addColumn(textColumn_3, "Kurs Zamanı");

		Column<XMLKursZamaniTanimlama, ?> column = new Column<XMLKursZamaniTanimlama, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLKursZamaniTanimlama object) {
				return (String) null;
			}
		};
		grdKursZamaniTanimlama.addColumn(column, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLKursZamaniTanimlama> selectionModel = new SingleSelectionModel<XMLKursZamaniTanimlama>();

			grdKursZamaniTanimlama.setSelectionModel(selectionModel);
			grdKursZamaniTanimlama.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLKursZamaniTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.kurs_zamani);

					}

				}
			}, DoubleClickEvent.getType());
		}

	}

	protected void showWithData(String kurs_zamani) {

		String urlWithParameters = Util.urlBase + "getkurszamani?";

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

					List<XMLKursZamaniTanimlama> listXmlKursZamaniTanimlama = XMLKursZamaniTanimlama.XML
							.readList(response.getText());

					DlgKursZamaniTanimlama dlgTemp = new DlgKursZamaniTanimlama();
					dlgTemp.putDataFromXML(listXmlKursZamaniTanimlama.get(0));
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

		String urlWithParameters = Util.urlBase + "getkurszamanitanimlama";

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

					List<XMLKursZamaniTanimlama> listXmlKursZamaniTanimlama = XMLKursZamaniTanimlama.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdKursZamaniTanimlama.setRowCount(1, true);

					// Push the data into the widget.
					grdKursZamaniTanimlama.setRowData(0,
							listXmlKursZamaniTanimlama);

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
			DlgKursZamaniTanimlama dlgTemp = new DlgKursZamaniTanimlama();
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}
