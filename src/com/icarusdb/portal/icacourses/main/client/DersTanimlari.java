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

public class DersTanimlari extends Composite {
	private CellTable<XMLDersTanimlari> grdDersTanimlari;

	public DersTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("824px", "443px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 545, 33);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 33);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 634, 33);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 160);
		horizontalPanel.setSize("774px", "75px");

		grdDersTanimlari = new CellTable<XMLDersTanimlari>();
		horizontalPanel.add(grdDersTanimlari);
		grdDersTanimlari.setSize("100%", "100%");

		TextColumn<XMLDersTanimlari> textColumn_3 = new TextColumn<XMLDersTanimlari>() {
			@Override
			public String getValue(XMLDersTanimlari object) {
				return object.id.toString();
			}
		};
		grdDersTanimlari.addColumn(textColumn_3, "İD");
		grdDersTanimlari.setColumnWidth(textColumn_3, "32px");

		Column<XMLDersTanimlari, String> textColumn = new TextColumn<XMLDersTanimlari>() {
			public String getValue(XMLDersTanimlari object) {
				return object.egitim_turu_adi.toString();
			}
		};
		grdDersTanimlari.addColumn(textColumn, "Eğitim Türü Adı");

		Column<XMLDersTanimlari, String> textColumn_1 = new TextColumn<XMLDersTanimlari>() {
			public String getValue(XMLDersTanimlari object) {
				return object.alan_adi.toString();
			}
		};
		grdDersTanimlari.addColumn(textColumn_1, "Alan Adı");

		Column<XMLDersTanimlari, String> textColumn_2 = new TextColumn<XMLDersTanimlari>() {
			@Override
			public String getValue(XMLDersTanimlari object) {
				return object.ders_adi.toString();
			}
		};
		grdDersTanimlari.addColumn(textColumn_2, "Ders Adı");

		Column<XMLDersTanimlari, String> column = new Column<XMLDersTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLDersTanimlari object) {
				return (String) null;
			}
		};
		grdDersTanimlari.addColumn(column, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLDersTanimlari> selectionModel = new SingleSelectionModel<XMLDersTanimlari>();

			grdDersTanimlari.setSelectionModel(selectionModel);
			grdDersTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLDersTanimlari selected = selectionModel
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

		String urlWithParameters = Util.urlBase + "getderstanimlari?id=" + id;

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

					List<XMLDersTanimlari> listXmlDersTanimlari = XMLDersTanimlari.XML
							.readList(response.getText());

					DlgDersTanimlari dlgTemp = new DlgDersTanimlari(false,
							new Long(id).longValue());
					dlgTemp.putDataFromXML(listXmlDersTanimlari.get(0));
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

		String urlWithParameters = Util.urlBase + "getderstanimlari";

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

					List<XMLDersTanimlari> listXmlDersTanimlari = XMLDersTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdDersTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdDersTanimlari.setRowData(0, listXmlDersTanimlari);

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
			DlgDersTanimlari dlgTemp = new DlgDersTanimlari(true, -1);
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}