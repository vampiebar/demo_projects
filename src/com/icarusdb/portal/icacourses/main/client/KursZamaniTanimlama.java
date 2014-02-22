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

public class KursZamaniTanimlama extends Composite {
	private CellTable<XMLKursZamaniTanimlama> grdKursZamaniTanimlama;
	private DlgKursZamaniTanimlama _dlgKursZamaniTanimlama;

	public KursZamaniTanimlama() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "417px");

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

		Label lblKursZamanTanmlama = new Label("Kurs Zamanı Tanımlama");
		horizontalPanel_2.add(lblKursZamanTanmlama);
		lblKursZamanTanmlama.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "46px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "75px");

		grdKursZamaniTanimlama = new CellTable<XMLKursZamaniTanimlama>();
		horizontalPanel.add(grdKursZamaniTanimlama);
		grdKursZamaniTanimlama.setSize("100%", "100%");

		TextColumn<XMLKursZamaniTanimlama> textColumn = new TextColumn<XMLKursZamaniTanimlama>() {
			@Override
			public String getValue(XMLKursZamaniTanimlama object) {
				return object.id.toString();
			}
		};
		grdKursZamaniTanimlama.addColumn(textColumn, "İD");
		grdKursZamaniTanimlama.setColumnWidth(textColumn, "69px");

		Column<XMLKursZamaniTanimlama, ?> textColumn_3 = new TextColumn<XMLKursZamaniTanimlama>() {
			public String getValue(XMLKursZamaniTanimlama object) {
				return object.kurs_zamani.toString();
			}
		};
		grdKursZamaniTanimlama.addColumn(textColumn_3, "Kurs Zamanı");
		grdKursZamaniTanimlama.setColumnWidth(textColumn_3, "335px");

		Column<XMLKursZamaniTanimlama, String> column = new Column<XMLKursZamaniTanimlama, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLKursZamaniTanimlama object) {
				return (String) null;
			}
		};
		grdKursZamaniTanimlama.addColumn(column, "Düzenle");
		grdKursZamaniTanimlama.setColumnWidth(column, "148px");

		Column<XMLKursZamaniTanimlama, String> column_1 = new Column<XMLKursZamaniTanimlama, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLKursZamaniTanimlama object) {
				return (String) null;
			}
		};
		grdKursZamaniTanimlama.addColumn(column_1, "Sil");
		grdKursZamaniTanimlama.setColumnWidth(column_1, "127px");

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
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());
			column.setFieldUpdater(new FieldUpdater<XMLKursZamaniTanimlama, String>() {

				@Override
				public void update(int index, XMLKursZamaniTanimlama object,
						String value) {

					XMLKursZamaniTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLKursZamaniTanimlama, String>() {

				@Override
				public void update(int index, XMLKursZamaniTanimlama object,
						String value) {
					XMLKursZamaniTanimlama selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putkurszamanitanimlama?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&kurs_zamani="
									+ object.kurs_zamani.toString();

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

		String urlWithParameters = Util.urlBase + "getkurszamanitanimlama?id="
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

					List<XMLKursZamaniTanimlama> listXmlKursZamaniTanimlama = XMLKursZamaniTanimlama.XML
							.readList(response.getText());

					_dlgKursZamaniTanimlama = new DlgKursZamaniTanimlama(false,
							new Long(id).longValue());
					_dlgKursZamaniTanimlama
							.putDataFromXML(listXmlKursZamaniTanimlama.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
					_dlgKursZamaniTanimlama.setAnimationEnabled(true);
					_dlgKursZamaniTanimlama.center();
					_dlgKursZamaniTanimlama
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
				+ "getkurszamanitanimlama?kayit_silinsin_mi=FALSE";

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
					// grdKursZamaniTanimlama.setRowData(0,
					// listXmlKursZamaniTanimlama);

					if (listXmlKursZamaniTanimlama != null) {

						grdKursZamaniTanimlama.setRowData(0,
								listXmlKursZamaniTanimlama);

						grdKursZamaniTanimlama.redraw();
					} else {

						grdKursZamaniTanimlama.setRowCount(0, true);
						grdKursZamaniTanimlama.redraw();
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
			_dlgKursZamaniTanimlama = new DlgKursZamaniTanimlama(true, -1);
			_dlgKursZamaniTanimlama.center();
			_dlgKursZamaniTanimlama.setAnimationEnabled(true);

			_dlgKursZamaniTanimlama
					.addCloseHandler(new CloseHandler<PopupPanel>() {

						@Override
						public void onClose(CloseEvent<PopupPanel> event) {

							putDataToGrid();

						}
					});

		}
	}
}
