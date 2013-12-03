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

public class IndirimTuru extends Composite {
	private CellTable<XMLIndirimTuru> grdIndirimTuru;
	private DlgIndirimTuru _dlgIndirimTuru;

	public IndirimTuru() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("809px", "750px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 545, 27);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 27);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 629, 27);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 154);
		horizontalPanel.setSize("774px", "75px");

		grdIndirimTuru = new CellTable<XMLIndirimTuru>();
		horizontalPanel.add(grdIndirimTuru);
		grdIndirimTuru.setSize("100%", "100%");

		TextColumn<XMLIndirimTuru> textColumn_1 = new TextColumn<XMLIndirimTuru>() {
			@Override
			public String getValue(XMLIndirimTuru object) {
				return object.id.toString();
			}
		};
		grdIndirimTuru.addColumn(textColumn_1, "İD");
		grdIndirimTuru.setColumnWidth(textColumn_1, "90px");

		Column<XMLIndirimTuru, ?> textColumn = new TextColumn<XMLIndirimTuru>() {
			public String getValue(XMLIndirimTuru object) {
				return object.indirim_turu.toString();

			}
		};
		grdIndirimTuru.addColumn(textColumn, "İndirim Türü");

		Column<XMLIndirimTuru, ?> column_1 = new Column<XMLIndirimTuru, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLIndirimTuru object) {
				return (String) null;
			}
		};
		grdIndirimTuru.addColumn(column_1, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLIndirimTuru> selectionModel = new SingleSelectionModel<XMLIndirimTuru>();

			grdIndirimTuru.setSelectionModel(selectionModel);
			grdIndirimTuru.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLIndirimTuru selected = selectionModel
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

		String urlWithParameters = Util.urlBase + "getindirimturu?id=" + id;

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

					List<XMLIndirimTuru> listXmlIndirimTuru = XMLIndirimTuru.XML
							.readList(response.getText());

					_dlgIndirimTuru = new DlgIndirimTuru(false, new Long(id)
							.longValue());
					_dlgIndirimTuru.putDataFromXML(listXmlIndirimTuru.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
					_dlgIndirimTuru.setAnimationEnabled(true);
					_dlgIndirimTuru.center();

					_dlgIndirimTuru
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

		String urlWithParameters = Util.urlBase + "getindirimturu";

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

					List<XMLIndirimTuru> listXmlIndirimTuru = XMLIndirimTuru.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdIndirimTuru.setRowCount(1, true);

					// Push the data into the widget.
					grdIndirimTuru.setRowData(0, listXmlIndirimTuru);

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
			_dlgIndirimTuru = new DlgIndirimTuru(true, -1);
			_dlgIndirimTuru.center();
			_dlgIndirimTuru.setAnimationEnabled(true);

			_dlgIndirimTuru.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}
}
