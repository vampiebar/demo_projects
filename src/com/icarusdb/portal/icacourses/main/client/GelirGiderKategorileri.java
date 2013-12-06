package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
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
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class GelirGiderKategorileri extends Composite {
	private CellTable<XMLGelirGiderKategorileri> grdGelirGiderKategorileri;
	private Button btnYeniKayit;
	private DlgGelirGiderKategorileri _dlgGelirGiderKategorileri;

	public GelirGiderKategorileri() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("807px", "750px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 545, 46);
		btnListeyiYenile.setSize("78px", "48px");

		btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 46);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 634, 46);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 0, 168);
		horizontalPanel.setSize("774px", "75px");

		grdGelirGiderKategorileri = new CellTable<XMLGelirGiderKategorileri>();
		horizontalPanel.add(grdGelirGiderKategorileri);
		grdGelirGiderKategorileri.setSize("100%", "100%");

		TextColumn<XMLGelirGiderKategorileri> textColumn_1 = new TextColumn<XMLGelirGiderKategorileri>() {
			@Override
			public String getValue(XMLGelirGiderKategorileri object) {
				return object.id.toString();
			}
		};
		grdGelirGiderKategorileri.addColumn(textColumn_1, "İD");
		grdGelirGiderKategorileri.setColumnWidth(textColumn_1, "51px");

		Column<XMLGelirGiderKategorileri, ?> textColumn = new TextColumn<XMLGelirGiderKategorileri>() {
			@Override
			public String getValue(XMLGelirGiderKategorileri object) {
				return object.kategori_adi.toString();
			}
		};
		grdGelirGiderKategorileri.addColumn(textColumn, "Kategori Adı");

		Column<XMLGelirGiderKategorileri, ?> column = new Column<XMLGelirGiderKategorileri, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLGelirGiderKategorileri object) {
				return (String) null;
			}
		};
		grdGelirGiderKategorileri.addColumn(column, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLGelirGiderKategorileri> selectionModel = new SingleSelectionModel<XMLGelirGiderKategorileri>();

			grdGelirGiderKategorileri.setSelectionModel(selectionModel);
			grdGelirGiderKategorileri.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLGelirGiderKategorileri selected = selectionModel
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

		String urlWithParameters = Util.urlBase
				+ "getgelirgiderkategorileri?id=" + id;

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

					List<XMLGelirGiderKategorileri> listXmlGelirGiderKategorileri = XMLGelirGiderKategorileri.XML
							.readList(response.getText());

					_dlgGelirGiderKategorileri = new DlgGelirGiderKategorileri(
							false, new Long(id).longValue());
					_dlgGelirGiderKategorileri
							.putDataFromXML(listXmlGelirGiderKategorileri
									.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
					_dlgGelirGiderKategorileri.setAnimationEnabled(true);
					_dlgGelirGiderKategorileri.center();
					_dlgGelirGiderKategorileri
							.addCloseHandler(new CloseHandler<PopupPanel>() {

								@Override
								public void onClose(CloseEvent<PopupPanel> event) {

									putDataToGrid();

								}
							});

				}
			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase + "getgelirgiderkategorileri";

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

					List<XMLGelirGiderKategorileri> listXnmlGelirGiderKategorileri = XMLGelirGiderKategorileri.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdGelirGiderKategorileri.setRowCount(1, true);

					// Push the data into the widget.
					grdGelirGiderKategorileri.setRowData(0,
							listXnmlGelirGiderKategorileri);

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
			_dlgGelirGiderKategorileri = new DlgGelirGiderKategorileri(true, -1);
			_dlgGelirGiderKategorileri.center();
			_dlgGelirGiderKategorileri.setAnimationEnabled(true);

			_dlgGelirGiderKategorileri
					.addCloseHandler(new CloseHandler<PopupPanel>() {

						@Override
						public void onClose(CloseEvent<PopupPanel> event) {

							putDataToGrid();

						}
					});

		}
	}
}
