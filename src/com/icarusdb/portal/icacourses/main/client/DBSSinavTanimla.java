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

public class DBSSinavTanimla extends Composite {
	private CellTable<XMLDBSSinavTanimla> grdDBSSinavTanimla;
	private DlgDBSSinavTanimla _dlgDbsSinavTanimla;

	public DBSSinavTanimla() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("791px", "455px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 32);
		btnYeniKayit.setSize("89px", "64px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 159);
		horizontalPanel.setSize("774px", "75px");

		grdDBSSinavTanimla = new CellTable<XMLDBSSinavTanimla>();
		horizontalPanel.add(grdDBSSinavTanimla);
		grdDBSSinavTanimla.setSize("100%", "100%");

		TextColumn<XMLDBSSinavTanimla> textColumn_4 = new TextColumn<XMLDBSSinavTanimla>() {
			@Override
			public String getValue(XMLDBSSinavTanimla object) {
				return object.id.toString();
			}
		};
		grdDBSSinavTanimla.addColumn(textColumn_4, "İD");
		grdDBSSinavTanimla.setColumnWidth(textColumn_4, "53px");

		Column<XMLDBSSinavTanimla, ?> textColumn = new TextColumn<XMLDBSSinavTanimla>() {
			public String getValue(XMLDBSSinavTanimla object) {
				return object.okul_durumu.toString();
			}
		};
		grdDBSSinavTanimla.addColumn(textColumn, "Okul Adı");

		Column<XMLDBSSinavTanimla, ?> textColumn_1 = new TextColumn<XMLDBSSinavTanimla>() {
			@Override
			public String getValue(XMLDBSSinavTanimla object) {
				return object.alan_bilgisi.toString();
			}
		};
		grdDBSSinavTanimla.addColumn(textColumn_1, "Alan Bilgisi");
		grdDBSSinavTanimla.setColumnWidth(textColumn_1, "102px");

		TextColumn<XMLDBSSinavTanimla> column_1 = new TextColumn<XMLDBSSinavTanimla>() {
			@Override
			public String getValue(XMLDBSSinavTanimla object) {
				return (object.sinav_tarihi);
			}
		};
		grdDBSSinavTanimla.addColumn(column_1, "Sınav Tarihi");
		grdDBSSinavTanimla.setColumnWidth(column_1, "135px");

		TextColumn<XMLDBSSinavTanimla> textColumn_5 = new TextColumn<XMLDBSSinavTanimla>() {
			@Override
			public String getValue(XMLDBSSinavTanimla object) {
				return object.saat + ":" + object.dakika.toString();
			}
		};
		grdDBSSinavTanimla.addColumn(textColumn_5, "Sınav Saati");
		grdDBSSinavTanimla.setColumnWidth(textColumn_5, "103px");

		Column<XMLDBSSinavTanimla, ?> textColumn_2 = new TextColumn<XMLDBSSinavTanimla>() {
			@Override
			public String getValue(XMLDBSSinavTanimla object) {
				return object.sinav_yeri.toString();
			}
		};
		grdDBSSinavTanimla.addColumn(textColumn_2, "Sınav Yeri");
		grdDBSSinavTanimla.setColumnWidth(textColumn_2, "118px");

		Column<XMLDBSSinavTanimla, ?> textColumn_3 = new TextColumn<XMLDBSSinavTanimla>() {
			@Override
			public String getValue(XMLDBSSinavTanimla object) {
				if (object.adres != null) {
					return object.adres.toString();

				}
				return "";
			}
		};
		grdDBSSinavTanimla.addColumn(textColumn_3, "Adres");
		grdDBSSinavTanimla.setColumnWidth(textColumn_3, "57px");

		Column<XMLDBSSinavTanimla, String> column_4 = new Column<XMLDBSSinavTanimla, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLDBSSinavTanimla object) {
				return "Düzenle";
			}
		};
		grdDBSSinavTanimla.addColumn(column_4, "Düzenle");

		Column<XMLDBSSinavTanimla, String> column_2 = new Column<XMLDBSSinavTanimla, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLDBSSinavTanimla object) {
				return "Sil";
			}
		};
		grdDBSSinavTanimla.addColumn(column_2, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLDBSSinavTanimla> selectionModel = new SingleSelectionModel<XMLDBSSinavTanimla>();

			grdDBSSinavTanimla.setSelectionModel(selectionModel);
			grdDBSSinavTanimla.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLDBSSinavTanimla selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());
			column_4.setFieldUpdater(new FieldUpdater<XMLDBSSinavTanimla, String>() {

				@Override
				public void update(int index, XMLDBSSinavTanimla object,
						String value) {

					XMLDBSSinavTanimla selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});
		}

		column_2.setFieldUpdater(new FieldUpdater<XMLDBSSinavTanimla, String>() {

			@Override
			public void update(int index, XMLDBSSinavTanimla object,
					String value) {
				Window.confirm("Kayit Silinecektir Emin Misiniz");

			}
		});

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getdbssinavtanimla?id=" + id;

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

					List<XMLDBSSinavTanimla> listXmlDBSinavTanimla = XMLDBSSinavTanimla.XML
							.readList(response.getText());

					_dlgDbsSinavTanimla = new DlgDBSSinavTanimla(false,
							new Long(id).longValue());
					_dlgDbsSinavTanimla.putDataFromXML(listXmlDBSinavTanimla
							.get(0));

					// dlgTemp.tabOnKayit.selectTab(0);
					_dlgDbsSinavTanimla.setAnimationEnabled(true);
					_dlgDbsSinavTanimla.center();

					_dlgDbsSinavTanimla
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

		String urlWithParameters = Util.urlBase + "getdbssinavtanimla";

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

					List<XMLDBSSinavTanimla> listXmlDBSSinavTanimla = XMLDBSSinavTanimla.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdDBSSinavTanimla.setRowCount(1, true);

					// Push the data into the widget.
					grdDBSSinavTanimla.setRowData(0, listXmlDBSSinavTanimla);

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

			_dlgDbsSinavTanimla = new DlgDBSSinavTanimla(true, -1);
			_dlgDbsSinavTanimla.center();
			_dlgDbsSinavTanimla.setAnimationEnabled(true);

			_dlgDbsSinavTanimla.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}
}
