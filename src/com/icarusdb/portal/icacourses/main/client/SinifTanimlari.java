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

public class SinifTanimlari extends Composite {
	private CellTable<XMLSinifTanimlari> grdSinifTanimlari;
	private DlgSinifTanimlari _dlgSinifTanimlari;

	public SinifTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("809px", "439px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 465, 44);
		btnYeniKayit.setSize("84px", "62px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 25, 171);
		horizontalPanel.setSize("774px", "75px");

		grdSinifTanimlari = new CellTable<XMLSinifTanimlari>();
		horizontalPanel.add(grdSinifTanimlari);
		grdSinifTanimlari.setSize("100%", "100%");

		TextColumn<XMLSinifTanimlari> textColumn = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return object.id.toString();
			}
		};
		grdSinifTanimlari.addColumn(textColumn, "İD");
		grdSinifTanimlari.setColumnWidth(textColumn, "53px");

		Column<XMLSinifTanimlari, ?> textColumn_1 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return object.sinif_adi.toString();
			}
		};
		grdSinifTanimlari.addColumn(textColumn_1, "Sınıf Adı");

		Column<XMLSinifTanimlari, ?> textColumn_2 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return object.egitim_turu.toString();
			}
		};
		grdSinifTanimlari.addColumn(textColumn_2, "Eğitim Türü");

		Column<XMLSinifTanimlari, ?> textColumn_3 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return object.alan.toString();
			}
		};
		grdSinifTanimlari.addColumn(textColumn_3, "Alan Adı");

		TextColumn<XMLSinifTanimlari> column_5 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return (object.fiyati);
			}
		};
		grdSinifTanimlari.addColumn(column_5, "Fiyatı");

		TextColumn<XMLSinifTanimlari> column_2 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return (object.baslangic_tarihi);
			}
		};
		grdSinifTanimlari.addColumn(column_2, "Başlangıç Tarihi");

		TextColumn<XMLSinifTanimlari> column_3 = new TextColumn<XMLSinifTanimlari>() {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return (object.bitis_tarihi);
			}
		};
		grdSinifTanimlari.addColumn(column_3, "Bitiş Tarihi");

		Column<XMLSinifTanimlari, String> column = new Column<XMLSinifTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return (String) null;
			}
		};
		grdSinifTanimlari.addColumn(column, "Düzenle");

		Column<XMLSinifTanimlari, String> column_1 = new Column<XMLSinifTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLSinifTanimlari object) {
				return (String) null;
			}
		};
		grdSinifTanimlari.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLSinifTanimlari> selectionModel = new SingleSelectionModel<XMLSinifTanimlari>();

			grdSinifTanimlari.setSelectionModel(selectionModel);
			grdSinifTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLSinifTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLSinifTanimlari, String>() {

				@Override
				public void update(int index, XMLSinifTanimlari object,
						String value) {

					XMLSinifTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});
		}

		column_1.setFieldUpdater(new FieldUpdater<XMLSinifTanimlari, String>() {

			@Override
			public void update(int index, XMLSinifTanimlari object, String value) {
				Window.confirm("Kayit Silinecektir, Emin Misiniz?");

			}
		});

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getsiniftanimlari?id=" + id;

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

					List<XMLSinifTanimlari> listXmlSinifTanimlari = XMLSinifTanimlari.XML
							.readList(response.getText());

					_dlgSinifTanimlari = new DlgSinifTanimlari(false, new Long(
							id).longValue());
					_dlgSinifTanimlari.putDataFromXML(listXmlSinifTanimlari
							.get(0));
					_dlgSinifTanimlari.setAnimationEnabled(true);
					_dlgSinifTanimlari.center();
					_dlgSinifTanimlari
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

		String urlWithParameters = Util.urlBase + "getsiniftanimlari";

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

					List<XMLSinifTanimlari> listXmlSinifTanimlari = XMLSinifTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdSinifTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdSinifTanimlari.setRowData(0, listXmlSinifTanimlari);

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
			_dlgSinifTanimlari = new DlgSinifTanimlari(true, -1);
			_dlgSinifTanimlari.center();
			_dlgSinifTanimlari.setAnimationEnabled(true);

			_dlgSinifTanimlari.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}
}
