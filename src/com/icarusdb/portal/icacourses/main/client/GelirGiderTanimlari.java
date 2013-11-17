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

public class GelirGiderTanimlari extends Composite {
	private CellTable<XMLGelirGiderTanimlari> grdGelirgiderTanimnlari;

	public GelirGiderTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("801px", "750px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 127);
		horizontalPanel.setSize("774px", "75px");

		grdGelirgiderTanimnlari = new CellTable<XMLGelirGiderTanimlari>();
		horizontalPanel.add(grdGelirgiderTanimnlari);
		grdGelirgiderTanimnlari.setSize("100%", "100%");

		TextColumn<XMLGelirGiderTanimlari> textColumn_3 = new TextColumn<XMLGelirGiderTanimlari>() {
			@Override
			public String getValue(XMLGelirGiderTanimlari object) {
				return object.id.toString();
			}
		};
		grdGelirgiderTanimnlari.addColumn(textColumn_3, "İD");
		grdGelirgiderTanimnlari.setColumnWidth(textColumn_3, "68px");

		Column<XMLGelirGiderTanimlari, ?> textColumn = new TextColumn<XMLGelirGiderTanimlari>() {
			@Override
			public String getValue(XMLGelirGiderTanimlari object) {
				return object.tipi.toString();
			}
		};
		grdGelirgiderTanimnlari.addColumn(textColumn, "Açıklama");

		Column<XMLGelirGiderTanimlari, ?> textColumn_1 = new TextColumn<XMLGelirGiderTanimlari>() {
			@Override
			public String getValue(XMLGelirGiderTanimlari object) {
				return object.kategori_adi.toString();
			}
		};
		grdGelirgiderTanimnlari.addColumn(textColumn_1, "Kategori Adı");

		TextColumn<XMLGelirGiderTanimlari> textColumn_2 = new TextColumn<XMLGelirGiderTanimlari>() {
			@Override
			public String getValue(XMLGelirGiderTanimlari object) {
				return object.gelir_gider_adi.toString();
			}
		};
		grdGelirgiderTanimnlari.addColumn(textColumn_2, "Gelir / Gider");

		Column<XMLGelirGiderTanimlari, String> column = new Column<XMLGelirGiderTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLGelirGiderTanimlari object) {
				return (String) null;
			}
		};
		grdGelirgiderTanimnlari.addColumn(column, "İşlemler");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 597, 50);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 502, 50);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 686, 50);
		btnExceleAktar.setSize("78px", "48px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLGelirGiderTanimlari> selectionModel = new SingleSelectionModel<XMLGelirGiderTanimlari>();

			grdGelirgiderTanimnlari.setSelectionModel(selectionModel);
			grdGelirgiderTanimnlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLGelirGiderTanimlari selected = selectionModel
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

		String urlWithParameters = Util.urlBase + "getgelirgidertanimlari?id="
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

					List<XMLGelirGiderTanimlari> listXmlGelirGiderTanimlari = XMLGelirGiderTanimlari.XML
							.readList(response.getText());

					DlgGelirGiderTanimlari dlgTemp = new DlgGelirGiderTanimlari();
					dlgTemp.putDataFromXML(listXmlGelirGiderTanimlari.get(0));
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

		String urlWithParameters = Util.urlBase + "getgelirgidertanimlari";

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

					List<XMLGelirGiderTanimlari> listXmlGelirGiderTanimlari = XMLGelirGiderTanimlari.XML
							.readList(response.getText());

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdGelirgiderTanimnlari.setRowCount(1, true);

					// Push the data into the widget.
					grdGelirgiderTanimnlari.setRowData(0,
							listXmlGelirGiderTanimlari);

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
			DlgGelirGiderTanimlari dlgTemp = new DlgGelirGiderTanimlari();
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}
