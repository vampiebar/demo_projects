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

public class SinifTanimlari extends Composite {
	private CellTable<XMLSinifTanimlari> grdSinifTanimlari;

	public SinifTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("809px", "439px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 560, 44);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 465, 44);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 649, 44);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 25, 171);
		horizontalPanel.setSize("774px", "75px");

		grdSinifTanimlari = new CellTable<XMLSinifTanimlari>();
		horizontalPanel.add(grdSinifTanimlari);
		grdSinifTanimlari.setSize("100%", "100%");

		TextColumn<XMLSinifTanimlari> textColumn = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return object.id.toString();
			}
		};
		grdSinifTanimlari.addColumn(textColumn, "İD");
		grdSinifTanimlari.setColumnWidth(textColumn, "53px");

		Column<XMLSinifTanimlari, ?> textColumn_1 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return object.sinif_adi.toString();
			}
		};
		grdSinifTanimlari.addColumn(textColumn_1, "Sınıf Adı");

		Column<XMLSinifTanimlari, ?> textColumn_2 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return object.egitim_turu.toString();
			}
		};
		grdSinifTanimlari.addColumn(textColumn_2, "Eğitim Türü");

		Column<XMLSinifTanimlari, ?> textColumn_3 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return object.alan.toString();
			}
		};
		grdSinifTanimlari.addColumn(textColumn_3, "Alan Adı");

		TextColumn<XMLSinifTanimlari> column_1 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return (object.fiyati);
			}
		};
		grdSinifTanimlari.addColumn(column_1, "Fiyatı");

		TextColumn<XMLSinifTanimlari> column_2 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return (object.baslangic_tarihi);
			}
		};
		grdSinifTanimlari.addColumn(column_2, "Başlangıç Tarihi");

		TextColumn<XMLSinifTanimlari> column_3 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return (object.bitis_tarihi);
			}
		};
		grdSinifTanimlari.addColumn(column_3, "Bitiş Tarihi");

		Column<XMLSinifTanimlari, ?> column = new Column<XMLSinifTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return (String) null;
			}
		};
		grdSinifTanimlari.addColumn(column, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLSinifTanimlari> selectionModel = new SingleSelectionModel<XMLSinifTanimlari>();

			grdSinifTanimlari.setSelectionModel(selectionModel);
			grdSinifTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLSinifTanimlari selected = selectionModel
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

		String urlWithParameters = Util.urlBase + "getsiniftanimlari?id=" + id;

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

					List<XMLSinifTanimlari> listXmlSinifTanimlari = XMLSinifTanimlari.XML
							.readList(response.getText());

					DlgSinifTanimlari dlgTemp = new DlgSinifTanimlari();
					dlgTemp.putDataFromXML(listXmlSinifTanimlari.get(0));
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

		String urlWithParameters = Util.urlBase + "getsiniftanimlari";

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

					List<XMLSinifTanimlari> listXmlSinifTanimlari = XMLSinifTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdSinifTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdSinifTanimlari.setRowData(0, listXmlSinifTanimlari);

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
			DlgSinifTanimlari dlgTemp = new DlgSinifTanimlari();
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}
