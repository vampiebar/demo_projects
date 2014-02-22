package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
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
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class IndirimTuru extends Composite {
	private CellTable<XMLIndirimTuru> grdIndirimTuru;
	private DlgIndirimTuru _dlgIndirimTuru;

	public IndirimTuru() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "750px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_2.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "50");
		horizontalPanel_2.setSize("100%", "33px");

		Label lblIndirimTr = new Label("İndirim Türü");
		horizontalPanel_2.add(lblIndirimTr);
		lblIndirimTr.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "36px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.setText("Yeni Kayit");
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "75px");

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

		Column<XMLIndirimTuru, String> column = new Column<XMLIndirimTuru, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLIndirimTuru object) {
				return (String) null;
			}
		};
		grdIndirimTuru.addColumn(column, "Düzenle");
		grdIndirimTuru.setColumnWidth(column, "129px");

		Column<XMLIndirimTuru, String> column_1 = new Column<XMLIndirimTuru, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLIndirimTuru object) {
				return (String) null;
			}
		};
		grdIndirimTuru.addColumn(column_1, "Sil");
		grdIndirimTuru.setColumnWidth(column_1, "118px");

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

			column.setFieldUpdater(new FieldUpdater<XMLIndirimTuru, String>() {

				@Override
				public void update(int index, XMLIndirimTuru object,
						String value) {

					XMLIndirimTuru selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLIndirimTuru, String>() {

				@Override
				public void update(int index, XMLIndirimTuru object,
						String value) {
					XMLIndirimTuru selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase + "putindirimturu?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&indirim_turu="
									+ object.indirim_turu.toString();
							URLValue = URLValue + "&indirim_sekli="
									+ object.indirim_sekli.toString();
							URLValue = URLValue + "&indirim_miktari="
									+ object.indirim_miktari.toString();

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"DERS BİLGİSİ KAYIT EDİLDİ",
									"DERS BİLGİSİ KAYIT EDİLEMEDİ");

							Timer t = new Timer() {
								@Override
								public void run() {

									putDataToGrid();
								}
							};

							// Schedule the timer to run once in 1s seconds.
							t.schedule(1000);

						}

						// putDataToGrid();
					}

				}
			});

		}// design time
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

		String urlWithParameters = Util.urlBase
				+ "getindirimturu?kayit_silinsin_mi=FALSE";

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
					// grdIndirimTuru.setRowData(0, listXmlIndirimTuru);

					if (listXmlIndirimTuru != null) {

						grdIndirimTuru.setRowData(0, listXmlIndirimTuru);

						grdIndirimTuru.redraw();

					} else {

						grdIndirimTuru.setRowCount(0, true);
						grdIndirimTuru.redraw();
					}

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
