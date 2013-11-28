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

public class KonuTanimlari extends Composite {
	private CellTable<XMLKonuTanimlari> grdKonuTanimlari;

	public KonuTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("823px", "430px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonListeyiYenile");
		absolutePanel.add(btnListeyiYenile, 545, 25);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 25);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 634, 25);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 152);
		horizontalPanel.setSize("774px", "75px");

		grdKonuTanimlari = new CellTable<XMLKonuTanimlari>();
		horizontalPanel.add(grdKonuTanimlari);
		grdKonuTanimlari.setSize("100%", "100%");

		TextColumn<XMLKonuTanimlari> textColumn_5 = new TextColumn<XMLKonuTanimlari>() {
			@Override
			public String getValue(XMLKonuTanimlari object) {
				return object.id.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_5, "İD");
		grdKonuTanimlari.setColumnWidth(textColumn_5, "24px");

		Column<XMLKonuTanimlari, ?> textColumn = new TextColumn<XMLKonuTanimlari>() {
			public String getValue(XMLKonuTanimlari object) {
				return object.egitim_turu_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn, "Eğitim Türü Adı");

		Column<XMLKonuTanimlari, ?> textColumn_1 = new TextColumn<XMLKonuTanimlari>() {
			public String getValue(XMLKonuTanimlari object) {
				return object.alan_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_1, "Alan Adı");

		Column<XMLKonuTanimlari, ?> textColumn_2 = new TextColumn<XMLKonuTanimlari>() {
			public String getValue(XMLKonuTanimlari object) {
				return object.ders_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_2, "Ders Adı");

		Column<XMLKonuTanimlari, ?> textColumn_3 = new TextColumn<XMLKonuTanimlari>() {
			public String getValue(XMLKonuTanimlari object) {
				return object.unite_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_3, "Ünite Adı");

		Column<XMLKonuTanimlari, ?> textColumn_4 = new TextColumn<XMLKonuTanimlari>() {
			@Override
			public String getValue(XMLKonuTanimlari object) {
				return object.konu_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_4, "Konu Adı");

		Column<XMLKonuTanimlari, ?> column = new Column<XMLKonuTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLKonuTanimlari object) {
				return (String) null;
			}
		};
		grdKonuTanimlari.addColumn(column, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLKonuTanimlari> selectionModel = new SingleSelectionModel<XMLKonuTanimlari>();

			grdKonuTanimlari.setSelectionModel(selectionModel);
			grdKonuTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLKonuTanimlari selected = selectionModel
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

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getkonutanimlari?id=" + id;

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

					List<XMLKonuTanimlari> listXmlKonuTanimlari = XMLKonuTanimlari.XML
							.readList(response.getText());

					DlgKonuTanimlari dlgTemp = new DlgKonuTanimlari(false,
							new Long(id).longValue());
					dlgTemp.putDataFromXML(listXmlKonuTanimlari.get(0));
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

		String urlWithParameters = Util.urlBase + "getkonutanimlari";

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

					List<XMLKonuTanimlari> listXmlKonuTanimlari = XMLKonuTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdKonuTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdKonuTanimlari.setRowData(0, listXmlKonuTanimlari);

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
			DlgKonuTanimlari dlgTemp = new DlgKonuTanimlari(true, -1);
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}
