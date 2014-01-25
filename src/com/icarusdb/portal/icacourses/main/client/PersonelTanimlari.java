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

public class PersonelTanimlari extends Composite {
	private CellTable<XMLPersonelTanimlari> grdPersonelTanimlari;
	private DlgPersonelIslemleri _dlgPersonelIslemleri;

	public PersonelTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("806px", "750px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 462, 52);
		btnYeniKayit.setSize("86px", "60px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 22, 179);
		horizontalPanel.setSize("774px", "75px");

		grdPersonelTanimlari = new CellTable<XMLPersonelTanimlari>();
		horizontalPanel.add(grdPersonelTanimlari);
		grdPersonelTanimlari.setSize("100%", "100%");

		TextColumn<XMLPersonelTanimlari> textColumn_2 = new TextColumn<XMLPersonelTanimlari>() {
			@Override
			public String getValue(XMLPersonelTanimlari object) {
				return object.id.toString();
			}
		};
		grdPersonelTanimlari.addColumn(textColumn_2, "İD");
		grdPersonelTanimlari.setColumnWidth(textColumn_2, "58px");

		Column<XMLPersonelTanimlari, ?> textColumn = new TextColumn<XMLPersonelTanimlari>() {
			public String getValue(XMLPersonelTanimlari object) {
				return object.adi_soyadi.toString();
			}
		};
		grdPersonelTanimlari.addColumn(textColumn, "Adı Soyadı");

		Column<XMLPersonelTanimlari, ?> textColumn_1 = new TextColumn<XMLPersonelTanimlari>() {
			@Override
			public String getValue(XMLPersonelTanimlari object) {
				return object.gorevi.toString();
			}
		};
		grdPersonelTanimlari.addColumn(textColumn_1, "Görevi");

		TextColumn<XMLPersonelTanimlari> textColumn_3 = new TextColumn<XMLPersonelTanimlari>() {
			@Override
			public String getValue(XMLPersonelTanimlari object) {
				return (object.ise_giris_tarihi);
			}
		};
		grdPersonelTanimlari.addColumn(textColumn_3, "İşe Giriş Tarihi");

		TextColumn<XMLPersonelTanimlari> textColumn_4 = new TextColumn<XMLPersonelTanimlari>() {
			@Override
			public String getValue(XMLPersonelTanimlari object) {
				return object.telefonu_1.toString();
			}
		};
		grdPersonelTanimlari.addColumn(textColumn_4, "1. Tel");

		TextColumn<XMLPersonelTanimlari> textColumn_5 = new TextColumn<XMLPersonelTanimlari>() {
			@Override
			public String getValue(XMLPersonelTanimlari object) {
				if (object.telefonu_2 != null) {
					return object.telefonu_2.toString();

				}
				return "";
			}

		};

		grdPersonelTanimlari.addColumn(textColumn_5, "2. Tel");

		Column<XMLPersonelTanimlari, String> column = new Column<XMLPersonelTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLPersonelTanimlari object) {

				return (String) null;
			}
		};
		grdPersonelTanimlari.addColumn(column, "Düzenle");

		Column<XMLPersonelTanimlari, String> column_1 = new Column<XMLPersonelTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLPersonelTanimlari object) {
				return (String) null;
			}
		};
		grdPersonelTanimlari.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLPersonelTanimlari> selectionModel = new SingleSelectionModel<XMLPersonelTanimlari>();

			grdPersonelTanimlari.setSelectionModel(selectionModel);
			grdPersonelTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLPersonelTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());
			column.setFieldUpdater(new FieldUpdater<XMLPersonelTanimlari, String>() {

				@Override
				public void update(int index, XMLPersonelTanimlari object,
						String value) {

					XMLPersonelTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});
		}

		column_1.setFieldUpdater(new FieldUpdater<XMLPersonelTanimlari, String>() {

			@Override
			public void update(int index, XMLPersonelTanimlari object,
					String value) {
				Window.confirm("Kayit Silinecektir, Emin Misiniz?");

			}
		});

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getpersoneltanimlari?id="
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

					List<XMLPersonelTanimlari> listXmlPersonelTanimlari = XMLPersonelTanimlari.XML
							.readList(response.getText());

					_dlgPersonelIslemleri = new DlgPersonelIslemleri(false,
							new Long(id).longValue());
					_dlgPersonelIslemleri
							.putDataFromXML(listXmlPersonelTanimlari.get(0));
					_dlgPersonelIslemleri.setAnimationEnabled(true);
					_dlgPersonelIslemleri.center();

					_dlgPersonelIslemleri
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

		String urlWithParameters = Util.urlBase + "getpersoneltanimlari";

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

					List<XMLPersonelTanimlari> listXmlPersonelTanimlari = XMLPersonelTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdPersonelTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdPersonelTanimlari
							.setRowData(0, listXmlPersonelTanimlari);

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
			_dlgPersonelIslemleri = new DlgPersonelIslemleri(true, -1);
			_dlgPersonelIslemleri.center();
			_dlgPersonelIslemleri.setAnimationEnabled(true);

			_dlgPersonelIslemleri
					.addCloseHandler(new CloseHandler<PopupPanel>() {

						@Override
						public void onClose(CloseEvent<PopupPanel> event) {

							putDataToGrid();

						}
					});

		}
	}
}
