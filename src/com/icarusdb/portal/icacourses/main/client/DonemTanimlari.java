package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
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

public class DonemTanimlari extends Composite {
	private CellTable<XMLDonemTanimlari> grdDonemTanimlari;
	private DlgDonemTanimlari _dlgDonemTanimlari;

	public DonemTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("812px", "441px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 56);
		btnYeniKayit.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 183);
		horizontalPanel.setSize("774px", "75px");

		grdDonemTanimlari = new CellTable<XMLDonemTanimlari>();
		horizontalPanel.add(grdDonemTanimlari);
		grdDonemTanimlari.setSize("100%", "100%");

		TextColumn<XMLDonemTanimlari> textColumn_1 = new TextColumn<XMLDonemTanimlari>() {
			@Override
			public String getValue(XMLDonemTanimlari object) {
				return object.id.toString();
			}
		};
		grdDonemTanimlari.addColumn(textColumn_1, "İD");
		grdDonemTanimlari.setColumnWidth(textColumn_1, "44px");

		Column<XMLDonemTanimlari, ?> textColumn = new TextColumn<XMLDonemTanimlari>() {
			@Override
			public String getValue(XMLDonemTanimlari object) {
				return object.donem_adi.toString();
			}
		};
		grdDonemTanimlari.addColumn(textColumn, "Dönem Adı");

		TextColumn<XMLDonemTanimlari> column_6 = new TextColumn<XMLDonemTanimlari>() {
			@Override
			public String getValue(XMLDonemTanimlari object) {
				return (object.baslangic_tarihi);
			}
		};
		grdDonemTanimlari.addColumn(column_6, "Başlangıç Tarihi");

		TextColumn<XMLDonemTanimlari> column_2 = new TextColumn<XMLDonemTanimlari>() {
			@Override
			public String getValue(XMLDonemTanimlari object) {
				return (object.bitis_tarihi);
			}
		};
		grdDonemTanimlari.addColumn(column_2, "Bitiş Tarihi");

		Column<XMLDonemTanimlari, ?> column_3 = new Column<XMLDonemTanimlari, Boolean>(
				new CheckboxCell()) {
			@Override
			public Boolean getValue(XMLDonemTanimlari object) {
				return (Boolean) null;
			}
		};
		grdDonemTanimlari.addColumn(column_3, "Varsayılan Dönem");
		grdDonemTanimlari.setColumnWidth(column_3, "158px");

		Column<XMLDonemTanimlari, String> column = new Column<XMLDonemTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLDonemTanimlari object) {
				return (String) null;
			}
		};
		grdDonemTanimlari.addColumn(column, "Düzenle");

		Column<XMLDonemTanimlari, String> column_1 = new Column<XMLDonemTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLDonemTanimlari object) {
				return (String) null;
			}
		};
		grdDonemTanimlari.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLDonemTanimlari> selectionModel = new SingleSelectionModel<XMLDonemTanimlari>();

			grdDonemTanimlari.setSelectionModel(selectionModel);
			grdDonemTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLDonemTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLDonemTanimlari, String>() {

				@Override
				public void update(int index, XMLDonemTanimlari object,
						String value) {

					XMLDonemTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLDonemTanimlari, String>() {

				@Override
				public void update(int index, XMLDonemTanimlari object,
						String value) {
					XMLDonemTanimlari selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putdonemtanimlari?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&donem_adi="
									+ object.donem_adi.toString();
							URLValue = URLValue + "&baslangic_tarihi="
									+ object.baslangic_tarihi.toString();
							URLValue = URLValue + "&bitis_tarihi="
									+ object.bitis_tarihi.toString();
							URLValue = URLValue + "&varsayilan_donem="
									+ object.varsayilan_donem.toString();

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"DÖNEM BİLGİSİ KAYIT EDİLDİ",
									"DÖNEM BİLGİSİ KAYIT EDİLEMEDİ");

						}

					}

				}
			});
		}// design time

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getdonemtanimlari?id=" + id;

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

					List<XMLDonemTanimlari> listXmlDonemTanimlari = XMLDonemTanimlari.XML
							.readList(response.getText());

					_dlgDonemTanimlari = new DlgDonemTanimlari(false, new Long(
							id).longValue());
					_dlgDonemTanimlari.putDataFromXML(listXmlDonemTanimlari
							.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
					_dlgDonemTanimlari.setAnimationEnabled(true);
					_dlgDonemTanimlari.center();
					_dlgDonemTanimlari
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
				+ "getdonemtanimlari?kayit_silinsin_mi=FALSE";

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

					List<XMLDonemTanimlari> listXmlDonemTanimlari = XMLDonemTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdDonemTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdDonemTanimlari.setRowData(0, listXmlDonemTanimlari);

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
			_dlgDonemTanimlari = new DlgDonemTanimlari(true, -1);
			_dlgDonemTanimlari.center();
			_dlgDonemTanimlari.setAnimationEnabled(true);

			_dlgDonemTanimlari.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}
}
