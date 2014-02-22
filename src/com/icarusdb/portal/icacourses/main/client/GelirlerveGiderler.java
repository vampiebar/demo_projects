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

public class GelirlerveGiderler extends Composite {
	private CellTable<XMLGelirlerveGiderler> grdGelirlerveGiderler;
	private Column<XMLGelirlerveGiderler, String> column;
	private DlgGelirlerveGiderler _dlgGelirlerveGiderler;

	public GelirlerveGiderler() {

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

		Label lblGelirlerVeGiderler = new Label("Gelirler ve Giderler");
		horizontalPanel_2.add(lblGelirlerVeGiderler);
		lblGelirlerVeGiderler.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "23px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "156px");

		grdGelirlerveGiderler = new CellTable<XMLGelirlerveGiderler>();
		horizontalPanel.add(grdGelirlerveGiderler);
		grdGelirlerveGiderler.setSize("100%", "100%");

		TextColumn<XMLGelirlerveGiderler> textColumn_2 = new TextColumn<XMLGelirlerveGiderler>() {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return object.id.toString();
			}
		};
		grdGelirlerveGiderler.addColumn(textColumn_2, "İD");
		grdGelirlerveGiderler.setColumnWidth(textColumn_2, "72px");

		column = new TextColumn<XMLGelirlerveGiderler>() {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return (object.tarih);
			}
		};
		grdGelirlerveGiderler.addColumn(column, "Tarih - Saat");
		grdGelirlerveGiderler.setColumnWidth(column, "132px");

		TextColumn<XMLGelirlerveGiderler> textColumn = new TextColumn<XMLGelirlerveGiderler>() {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return object.gelirler.toString();
			}
		};
		grdGelirlerveGiderler.addColumn(textColumn, "Gelir / Gider Tanımı");

		TextColumn<XMLGelirlerveGiderler> column_1 = new TextColumn<XMLGelirlerveGiderler>() {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return object.islem_tipi.toString();
			}
		};
		grdGelirlerveGiderler.addColumn(column_1, "Gelir / Gider Tipi");

		TextColumn<XMLGelirlerveGiderler> textColumn_1 = new TextColumn<XMLGelirlerveGiderler>() {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return object.miktar.toString();
			}
		};
		grdGelirlerveGiderler.addColumn(textColumn_1, "Ödeme Miktarı");

		Column<XMLGelirlerveGiderler, String> column_4 = new Column<XMLGelirlerveGiderler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return "Düzenle";
			}
		};

		grdGelirlerveGiderler.addColumn(column_4, "Düzenle");

		Column<XMLGelirlerveGiderler, String> column_2 = new Column<XMLGelirlerveGiderler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLGelirlerveGiderler object) {
				return "Sil";
			}
		};
		grdGelirlerveGiderler.addColumn(column_2, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLGelirlerveGiderler> selectionModel = new SingleSelectionModel<XMLGelirlerveGiderler>();

			grdGelirlerveGiderler.setSelectionModel(selectionModel);
			grdGelirlerveGiderler.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLGelirlerveGiderler selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column_4.setFieldUpdater(new FieldUpdater<XMLGelirlerveGiderler, String>() {

				@Override
				public void update(int index, XMLGelirlerveGiderler object,
						String value) {

					XMLGelirlerveGiderler selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_2.setFieldUpdater(new FieldUpdater<XMLGelirlerveGiderler, String>() {

				@Override
				public void update(int index, XMLGelirlerveGiderler object,
						String value) {
					XMLGelirlerveGiderler selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putgelirlervegiderler?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&islem_tipi="
									+ object.islem_tipi.toString();
							URLValue = URLValue + "&kategoriler="
									+ object.kategoriler.toString();
							URLValue = URLValue + "&gelirler="
									+ object.gelirler.toString();
							URLValue = URLValue + "&odeme_turu="
									+ object.odeme_turu.toString();
							URLValue = URLValue + "&banka="
									+ object.banka.toString();
							URLValue = URLValue + "&vade_tarihi="
									+ object.vade_tarihi.toString();
							URLValue = URLValue + "&miktar="
									+ object.miktar.toString();
							URLValue = URLValue + "&tarih="
									+ object.tarih.toString();
							URLValue = URLValue + "&aciklama="
									+ object.aciklama.toString();
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

		String urlWithParameters = Util.urlBase + "getgelirlervegiderler?id="
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

					List<XMLGelirlerveGiderler> listXmlGelirlerveGiderler = XMLGelirlerveGiderler.XML
							.readList(response.getText());

					_dlgGelirlerveGiderler = new DlgGelirlerveGiderler(false,
							new Long(id).longValue());

					_dlgGelirlerveGiderler
							.putDataFromXML(listXmlGelirlerveGiderler.get(0));
					_dlgGelirlerveGiderler.setAnimationEnabled(true);
					_dlgGelirlerveGiderler.center();
					_dlgGelirlerveGiderler
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
				+ "getgelirlervegiderler?kayit_silinsin_mi=FALSE";

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

					List<XMLGelirlerveGiderler> listXmlGelirlerveGiderler = XMLGelirlerveGiderler.XML
							.readList(response.getText());

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdGelirlerveGiderler.setRowCount(1, true);

					// Push the data into the widget.
					// grdGelirlerveGiderler.setRowData(0,
					// listXmlGelirlerveGiderler);

					if (listXmlGelirlerveGiderler != null) {

						grdGelirlerveGiderler.setRowData(0,
								listXmlGelirlerveGiderler);

						grdGelirlerveGiderler.redraw();
					} else {

						grdGelirlerveGiderler.setRowCount(0, true);
						grdGelirlerveGiderler.redraw();
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
			_dlgGelirlerveGiderler = new DlgGelirlerveGiderler(true, -1);
			_dlgGelirlerveGiderler.center();
			_dlgGelirlerveGiderler.setAnimationEnabled(true);

			_dlgGelirlerveGiderler
					.addCloseHandler(new CloseHandler<PopupPanel>() {

						@Override
						public void onClose(CloseEvent<PopupPanel> event) {

							putDataToGrid();

						}
					});
		}
	}
}
