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

public class EgitimTuruTanimlama extends Composite {
	private CellTable<XMLEgitimTuruTanimlama> grdEgitimTuru;
	public DlgEgitimTuruTanimlama _dlgEgitimTuruTanimlama;
	private Column<XMLEgitimTuruTanimlama, String> column;
	private Column<XMLEgitimTuruTanimlama, String> column_1;

	public EgitimTuruTanimlama() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "750px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "50");
		horizontalPanel_1.setSize("100%", "33px");

		Label lblEitimTrTanmlama = new Label("Eğitim Türü Tanımlama");
		horizontalPanel_1.add(lblEitimTrTanmlama);
		lblEitimTrTanmlama.setWidth("100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setSpacing(15);
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "30");
		horizontalPanel_2.setWidth("100%");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_2.add(btnYeniKayit);
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "100px");

		grdEgitimTuru = new CellTable<XMLEgitimTuruTanimlama>();
		horizontalPanel.add(grdEgitimTuru);
		grdEgitimTuru.setStyleName("gwt-cellTable");
		grdEgitimTuru.setPageStart(2);
		grdEgitimTuru.setSize("100%", "100%");

		TextColumn<XMLEgitimTuruTanimlama> textColumn_1 = new TextColumn<XMLEgitimTuruTanimlama>() {
			@Override
			public String getValue(XMLEgitimTuruTanimlama object) {
				return object.id.toString();
			}
		};
		grdEgitimTuru.addColumn(textColumn_1, "İD");
		grdEgitimTuru.setColumnWidth(textColumn_1, "100px");

		TextColumn<XMLEgitimTuruTanimlama> textColumn = new TextColumn<XMLEgitimTuruTanimlama>() {
			@Override
			public String getValue(XMLEgitimTuruTanimlama object) {
				return object.egitim_turu_adi.toString();
			}
		};
		grdEgitimTuru.addColumn(textColumn, "Eğitim Türü Adı");

		TextColumn<XMLEgitimTuruTanimlama> textColumn_2 = new TextColumn<XMLEgitimTuruTanimlama>() {
			@Override
			public String getValue(XMLEgitimTuruTanimlama object) {
				return object.alan_adi.toString();
			}
		};
		grdEgitimTuru.addColumn(textColumn_2, "Alan Adi");

		column = new Column<XMLEgitimTuruTanimlama, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLEgitimTuruTanimlama object) {
				return "Düzenle";
			}
		};
		grdEgitimTuru.addColumn(column, "Düzenle");

		column_1 = new Column<XMLEgitimTuruTanimlama, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLEgitimTuruTanimlama object) {
				return "Sil";
			}
		};
		grdEgitimTuru.addColumn(column_1, "Sil");
		grdEgitimTuru.setColumnWidth(column_1, "135px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLEgitimTuruTanimlama> selectionModel = new SingleSelectionModel<XMLEgitimTuruTanimlama>();

			grdEgitimTuru.setSelectionModel(selectionModel);
			grdEgitimTuru.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLEgitimTuruTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}

			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLEgitimTuruTanimlama, String>() {

				@Override
				public void update(int index, XMLEgitimTuruTanimlama object,
						String value) {

					XMLEgitimTuruTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}

			});

			column_1.setFieldUpdater(new FieldUpdater<XMLEgitimTuruTanimlama, String>() {

				@Override
				public void update(int index, XMLEgitimTuruTanimlama object,
						String value) {

					XMLEgitimTuruTanimlama selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putegitimturutanimlama?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&egitim_turu_adi="
									+ object.egitim_turu_adi.toString();
							URLValue = URLValue + "&alan_adi="
									+ object.alan_adi.toString();

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

	private void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getegitimturutanimlama?id="
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

					// Window.alert("AAABBBCCC " +
					// response.getText());

					List<XMLEgitimTuruTanimlama> listXmlegitimTuru = XMLEgitimTuruTanimlama.XML
							.readList(response.getText());

					_dlgEgitimTuruTanimlama = new DlgEgitimTuruTanimlama(false,
							new Long(id).longValue());
					_dlgEgitimTuruTanimlama.putDataFromXML(listXmlegitimTuru
							.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
					_dlgEgitimTuruTanimlama.setAnimationEnabled(true);
					_dlgEgitimTuruTanimlama.center();
					_dlgEgitimTuruTanimlama
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
				+ "getegitimturutanimlama?kayit_silinsin_mi=FALSE";

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

					List<XMLEgitimTuruTanimlama> listXmlEgitimTuru = XMLEgitimTuruTanimlama.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdEgitimTuru.setRowCount(1, true);

					// Push the data into the widget.
					// grdEgitimTuru.setRowData(0, listXmlEgitimTuru);

					if (listXmlEgitimTuru != null) {

						grdEgitimTuru.setRowData(0, listXmlEgitimTuru);

						grdEgitimTuru.redraw();

					} else {

						grdEgitimTuru.setRowCount(0, true);
						grdEgitimTuru.redraw();
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private boolean isDesignTime() {

		return false;
	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			DlgEgitimTuruTanimlama dlgTemp = new DlgEgitimTuruTanimlama(true,
					-1);
			dlgTemp.center();

		}
	}
}
