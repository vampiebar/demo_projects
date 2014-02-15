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
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class ServisTanimlama extends Composite {
	private CellTable<XMLServisTanimlama> grdServisTanimlama;
	private DlgServisTanimlama _dlgServisTanimlama;

	public ServisTanimlama() {

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

		Label lblServisTanmlama = new Label("Servis Tanımlama");
		horizontalPanel_2.add(lblServisTanmlama);
		lblServisTanmlama.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "47px");

		Button btnYenikayit = new Button("New button");
		horizontalPanel_1.add(btnYenikayit);
		btnYenikayit.setStyleName("gwt-YeniKayit2");
		btnYenikayit.addClickHandler(new BtnYenikayitClickHandler());

		btnYenikayit.setText("Yeni Kayıt");
		btnYenikayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "174px");

		grdServisTanimlama = new CellTable<XMLServisTanimlama>();
		horizontalPanel.add(grdServisTanimlama);
		grdServisTanimlama.setSize("100%", "100%");

		TextColumn<XMLServisTanimlama> textColumn = new TextColumn<XMLServisTanimlama>() {
			@Override
			public String getValue(XMLServisTanimlama object) {
				return object.kodu.toString();
			}
		};
		grdServisTanimlama.addColumn(textColumn, "Kodu");
		grdServisTanimlama.setColumnWidth(textColumn, "162px");

		TextColumn<XMLServisTanimlama> textColumn_1 = new TextColumn<XMLServisTanimlama>() {
			@Override
			public String getValue(XMLServisTanimlama object) {
				return object.guzergah.toString();
			}
		};
		grdServisTanimlama.addColumn(textColumn_1, "Güzergah");

		TextColumn<XMLServisTanimlama> textColumn_2 = new TextColumn<XMLServisTanimlama>() {
			@Override
			public String getValue(XMLServisTanimlama object) {
				return object.servis_ucreti.toString();
			}
		};
		grdServisTanimlama.addColumn(textColumn_2, "Servis Ücreti");

		Column<XMLServisTanimlama, String> column = new Column<XMLServisTanimlama, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLServisTanimlama object) {
				return (String) null;
			}
		};
		grdServisTanimlama.addColumn(column, "Düzenle");

		Column<XMLServisTanimlama, String> column_1 = new Column<XMLServisTanimlama, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLServisTanimlama object) {
				return (String) null;
			}
		};
		grdServisTanimlama.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLServisTanimlama> selectionModel = new SingleSelectionModel<XMLServisTanimlama>();

			grdServisTanimlama.setSelectionModel(selectionModel);
			grdServisTanimlama.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLServisTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLServisTanimlama, String>() {

				@Override
				public void update(int index, XMLServisTanimlama object,
						String value) {

					XMLServisTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLServisTanimlama, String>() {

				@Override
				public void update(int index, XMLServisTanimlama object,
						String value) {
					XMLServisTanimlama selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putservistanimlama?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&kodu="
									+ object.kodu.toString();
							URLValue = URLValue + "&guzergah="
									+ object.guzergah.toString();
							URLValue = URLValue + "&servis_ucreti="
									+ object.servis_ucreti.toString();
							URLValue = URLValue + "&sofor_adi="
									+ object.sofor_adi.toString();
							URLValue = URLValue + "&soforun_telefonu="
									+ object.soforun_telefonu.toString();
							URLValue = URLValue + "&arac_sahibi="
									+ object.arac_sahibi.toString();
							URLValue = URLValue + "&arac_sahibinin_telefonu="
									+ object.arac_sahibinin_telefonu.toString();
							URLValue = URLValue + "&arac_plakasi="
									+ object.arac_plakasi.toString();
							URLValue = URLValue + "&kapasitesi="
									+ object.kapasitesi.toString();
							URLValue = URLValue + "&yolcu_sayisi="
									+ object.yolcu_sayisi.toString();

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"SERVİS BİLGİSİ KAYIT EDİLDİ",
									"SERVİS BİLGİSİ KAYIT EDİLEMEDİ");

						}

					}

					// putDataToGrid();
				}
			});

		}// design time
	}

	private boolean isDesignTime() {

		return false;
	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase
				+ "getservistanimlama?kayit_silinsin_mi=FALSE";

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

					List<XMLServisTanimlama> listXmlServisTanimlama = XMLServisTanimlama.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdServisTanimlama.setRowCount(1, true);

					// Push the data into the widget.
					grdServisTanimlama.setRowData(0, listXmlServisTanimlama);

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getservistanimlama?id=" + id;

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

					List<XMLServisTanimlama> listXmlServisTanimlama = XMLServisTanimlama.XML
							.readList(response.getText());

					_dlgServisTanimlama = new DlgServisTanimlama(false,
							new Long(id).longValue());
					_dlgServisTanimlama.putDataFromXML(listXmlServisTanimlama
							.get(0));
					_dlgServisTanimlama.setAnimationEnabled(true);
					_dlgServisTanimlama.center();
					_dlgServisTanimlama
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

	private class BtnYenikayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			_dlgServisTanimlama = new DlgServisTanimlama(true, -1);
			_dlgServisTanimlama.center();
			_dlgServisTanimlama.setAnimationEnabled(true);

			_dlgServisTanimlama.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});
		}
	}
}
