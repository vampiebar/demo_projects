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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class GelirGiderTanimlari extends Composite {
	private CellTable<XMLGelirGiderTanimlari> grdGelirgiderTanimnlari;
	private DlgGelirGiderTanimlari _dlgGelirGiderTanimlari;

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

		final Column<XMLGelirGiderTanimlari, ?> textColumn = new TextColumn<XMLGelirGiderTanimlari>() {
			@Override
			public String getValue(XMLGelirGiderTanimlari object) {
				return object.tipi.toString();
			}
		};
		grdGelirgiderTanimnlari.addColumn(textColumn, "Açıklama");

		final Column<XMLGelirGiderTanimlari, ?> textColumn_1 = new TextColumn<XMLGelirGiderTanimlari>() {
			@Override
			public String getValue(XMLGelirGiderTanimlari object) {
				return object.kategori_adi.toString();
			}
		};
		grdGelirgiderTanimnlari.addColumn(textColumn_1, "Kategori Adı");

		final TextColumn<XMLGelirGiderTanimlari> textColumn_2 = new TextColumn<XMLGelirGiderTanimlari>() {
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
		grdGelirgiderTanimnlari.addColumn(column, "Düzenle");

		Column<XMLGelirGiderTanimlari, String> column_1 = new Column<XMLGelirGiderTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLGelirGiderTanimlari object) {
				return (String) null;
			}
		};
		grdGelirgiderTanimnlari.addColumn(column_1, "Sil");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 502, 50);
		btnYeniKayit.setSize("78px", "48px");

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
			column.setFieldUpdater(new FieldUpdater<XMLGelirGiderTanimlari, String>() {

				@Override
				public void update(int index, XMLGelirGiderTanimlari object,
						String value) {

					XMLGelirGiderTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});
			column_1.setFieldUpdater(new FieldUpdater<XMLGelirGiderTanimlari, String>() {

				@Override
				public void update(int index, XMLGelirGiderTanimlari object,
						String value) {
					XMLGelirGiderTanimlari selected = selectionModel
							.getSelectedObject();
					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putgelirgidertanimlari?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&tipi="
									+ textColumn.getValue(selected);
							URLValue = URLValue + "&kategori_adi="
									+ textColumn_1.getValue(selected);
							URLValue = URLValue + "&gelir_gider_adi="
									+ object.gelir_gider_adi.toString();

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util()
									.sendRequest(URLValue,
											"BAŞARIYLA KAYIT EDİLDİ",
											"KAYIT EDİLEMEDİ");
						}
					}
				}
			});
		}

	}

	protected void showWithData(final String id) {

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

					_dlgGelirGiderTanimlari = new DlgGelirGiderTanimlari(false,
							new Long(id).longValue());
					_dlgGelirGiderTanimlari
							.putDataFromXML(listXmlGelirGiderTanimlari.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
					_dlgGelirGiderTanimlari.setAnimationEnabled(true);
					_dlgGelirGiderTanimlari.center();
					_dlgGelirGiderTanimlari
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
				+ "getgelirgidertanimlari?kayit_silinsin_mi=FALSE";

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
			_dlgGelirGiderTanimlari = new DlgGelirGiderTanimlari(true, -1);
			_dlgGelirGiderTanimlari.center();
			_dlgGelirGiderTanimlari.setAnimationEnabled(true);

			_dlgGelirGiderTanimlari
					.addCloseHandler(new CloseHandler<PopupPanel>() {

						@Override
						public void onClose(CloseEvent<PopupPanel> event) {

							putDataToGrid();

						}
					});
		}
	}
}
