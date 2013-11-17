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

public class FizikselSinifTanimlari extends Composite {
	private CellTable<XMLFizikselSinifTanimlari> grdFizikselSinifTanimlari;

	public FizikselSinifTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("807px", "434px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 545, 38);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 437, 38);
		btnYeniKayit.setSize("91px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 634, 38);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 165);
		horizontalPanel.setSize("774px", "75px");

		grdFizikselSinifTanimlari = new CellTable<XMLFizikselSinifTanimlari>();
		horizontalPanel.add(grdFizikselSinifTanimlari);
		grdFizikselSinifTanimlari.setSize("773px", "100%");

		TextColumn<XMLFizikselSinifTanimlari> textColumn_1 = new TextColumn<XMLFizikselSinifTanimlari>() {
			@Override
			public String getValue(XMLFizikselSinifTanimlari object) {
				return object.id.toString();
			}
		};
		grdFizikselSinifTanimlari.addColumn(textColumn_1, "İD");
		grdFizikselSinifTanimlari.setColumnWidth(textColumn_1, "56px");

		Column<XMLFizikselSinifTanimlari, ?> textColumn = new TextColumn<XMLFizikselSinifTanimlari>() {
			public String getValue(XMLFizikselSinifTanimlari object) {
				return object.fiziksel_sinif_adi.toString();
			}
		};
		grdFizikselSinifTanimlari.addColumn(textColumn, "Fiziksel Sınıf Adı");
		grdFizikselSinifTanimlari.setColumnWidth(textColumn, "265px");

		Column<XMLFizikselSinifTanimlari, ?> column = new Column<XMLFizikselSinifTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLFizikselSinifTanimlari object) {
				return (String) null;
			}
		};
		grdFizikselSinifTanimlari.addColumn(column, "İşlemler");
		grdFizikselSinifTanimlari.setColumnWidth(column, "227px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLFizikselSinifTanimlari> selectionModel = new SingleSelectionModel<XMLFizikselSinifTanimlari>();

			grdFizikselSinifTanimlari.setSelectionModel(selectionModel);
			grdFizikselSinifTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLFizikselSinifTanimlari selected = selectionModel
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

		String urlWithParameters = Util.urlBase
				+ "getfizikselsiniftanimlari?id=" + id;

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

					List<XMLFizikselSinifTanimlari> listXmlFizikselSinifTanimlari = XMLFizikselSinifTanimlari.XML
							.readList(response.getText());

					DlgFizikselSinifTanimlari dlgTemp = new DlgFizikselSinifTanimlari();
					dlgTemp.putDataFromXML(listXmlFizikselSinifTanimlari.get(0));
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

		String urlWithParameters = Util.urlBase + "getfizikselsiniftanimlari";

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

					List<XMLFizikselSinifTanimlari> listXmlFizikselSinifTanimlari = XMLFizikselSinifTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdFizikselSinifTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdFizikselSinifTanimlari.setRowData(0,
							listXmlFizikselSinifTanimlari);

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
			DlgFizikselSinifTanimlari dlgTemp = new DlgFizikselSinifTanimlari();
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}
