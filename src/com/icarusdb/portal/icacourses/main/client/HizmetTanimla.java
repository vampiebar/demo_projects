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

public class HizmetTanimla extends Composite {
	private CellTable<XMLHizmetTanimla> grdHizmetTanimla;

	public HizmetTanimla() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("808px", "750px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 545, 29);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 29);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 634, 29);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 156);
		horizontalPanel.setSize("774px", "75px");

		grdHizmetTanimla = new CellTable<XMLHizmetTanimla>();
		horizontalPanel.add(grdHizmetTanimla);
		grdHizmetTanimla.setSize("100%", "100%");

		TextColumn<XMLHizmetTanimla> textColumn_2 = new TextColumn<XMLHizmetTanimla>() {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return object.id.toString();
			}
		};
		grdHizmetTanimla.addColumn(textColumn_2, "İD");
		grdHizmetTanimla.setColumnWidth(textColumn_2, "60px");

		Column<XMLHizmetTanimla, ?> textColumn = new TextColumn<XMLHizmetTanimla>() {
			public String getValue(XMLHizmetTanimla object) {
				return object.hizmet_adi.toString();
			}
		};
		grdHizmetTanimla.addColumn(textColumn, "Hizmet Adı");

		Column<XMLHizmetTanimla, ?> textColumn_1 = new TextColumn<XMLHizmetTanimla>() {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return object.hizmet_turu.toString();
			}
		};
		grdHizmetTanimla.addColumn(textColumn_1, "Grup Adı");

		TextColumn<XMLHizmetTanimla> column_1 = new TextColumn<XMLHizmetTanimla>() {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return (object.birim_fiyati);
			}
		};
		grdHizmetTanimla.addColumn(column_1, "Fiyatı");

		Column<XMLHizmetTanimla, ?> column = new Column<XMLHizmetTanimla, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return (String) null;
			}
		};
		grdHizmetTanimla.addColumn(column, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLHizmetTanimla> selectionModel = new SingleSelectionModel<XMLHizmetTanimla>();

			grdHizmetTanimla.setSelectionModel(selectionModel);
			grdHizmetTanimla.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLHizmetTanimla selected = selectionModel
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

		String urlWithParameters = Util.urlBase + "gethizmettanimla?id=" + id;

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

					List<XMLHizmetTanimla> listXmlHizmetTanimla = XMLHizmetTanimla.XML
							.readList(response.getText());

					DlgHizmetTanimla dlgTemp = new DlgHizmetTanimla(false,
							new Long(id).longValue());
					dlgTemp.putDataFromXML(listXmlHizmetTanimla.get(0));
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

		String urlWithParameters = Util.urlBase + "gethizmettanimla";

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

					List<XMLHizmetTanimla> listXmlHizmetTanimla = XMLHizmetTanimla.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdHizmetTanimla.setRowCount(1, true);

					// Push the data into the widget.
					grdHizmetTanimla.setRowData(0, listXmlHizmetTanimla);

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
			DlgHizmetTanimla dlgTemp = new DlgHizmetTanimla(true, -1);
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}
