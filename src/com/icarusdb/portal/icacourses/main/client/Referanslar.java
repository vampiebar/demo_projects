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

public class Referanslar extends Composite {
	private CellTable<XMLReferanslar> grdReferanslar;
	private DlgReferanslar _dlgReferanslar;

	public Referanslar() {

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

		Label lblReferanslar = new Label("Referanslar");
		horizontalPanel_2.add(lblReferanslar);
		lblReferanslar.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "38px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "75px");

		grdReferanslar = new CellTable<XMLReferanslar>();
		horizontalPanel.add(grdReferanslar);
		grdReferanslar.setSize("100%", "100%");

		TextColumn<XMLReferanslar> textColumn_1 = new TextColumn<XMLReferanslar>() {
			@Override
			public String getValue(XMLReferanslar object) {
				return object.id.toString();
			}
		};
		grdReferanslar.addColumn(textColumn_1, "İD");
		grdReferanslar.setColumnWidth(textColumn_1, "75px");

		Column<XMLReferanslar, ?> textColumn = new TextColumn<XMLReferanslar>() {
			public String getValue(XMLReferanslar object) {
				return object.referans_adi_soyadi.toString();
			}
		};
		grdReferanslar.addColumn(textColumn, "Referans Adı Soyadı");
		grdReferanslar.setColumnWidth(textColumn, "394px");

		Column<XMLReferanslar, String> column = new Column<XMLReferanslar, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLReferanslar object) {
				return (String) null;
			}
		};
		grdReferanslar.addColumn(column, "Düzenle");
		grdReferanslar.setColumnWidth(column, "148px");

		Column<XMLReferanslar, String> column_1 = new Column<XMLReferanslar, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLReferanslar object) {
				return (String) null;
			}
		};
		grdReferanslar.addColumn(column_1, "Sil");
		grdReferanslar.setColumnWidth(column_1, "121px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLReferanslar> selectionModel = new SingleSelectionModel<XMLReferanslar>();

			grdReferanslar.setSelectionModel(selectionModel);
			grdReferanslar.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLReferanslar selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLReferanslar, String>() {

				@Override
				public void update(int index, XMLReferanslar object,
						String value) {

					XMLReferanslar selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLReferanslar, String>() {

				@Override
				public void update(int index, XMLReferanslar object,
						String value) {
					XMLReferanslar selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase + "putreferanslar?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&referans_adi_soyadi="
									+ object.referans_adi_soyadi.toString();

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

		String urlWithParameters = Util.urlBase + "getreferanslar?id=" + id;

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

					List<XMLReferanslar> listXmlReferanslar = XMLReferanslar.XML
							.readList(response.getText());

					_dlgReferanslar = new DlgReferanslar(false, new Long(id)
							.longValue());
					_dlgReferanslar.putDataFromXML(listXmlReferanslar.get(0));
					_dlgReferanslar.center();
					_dlgReferanslar
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
				+ "getreferanslar?kayit_silinsin_mi=FALSE";

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

					List<XMLReferanslar> listXmlReferanslar = XMLReferanslar.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdReferanslar.setRowCount(1, true);

					// Push the data into the widget.
					// grdReferanslar.setRowData(0, listXmlReferanslar);

					if (listXmlReferanslar != null) {

						grdReferanslar.setRowData(0, listXmlReferanslar);

						grdReferanslar.redraw();
					} else {

						grdReferanslar.setRowCount(0, true);
						grdReferanslar.redraw();
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
			_dlgReferanslar = new DlgReferanslar(true, -1);
			_dlgReferanslar.center();
			_dlgReferanslar.setAnimationEnabled(true);

			_dlgReferanslar.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}
}
