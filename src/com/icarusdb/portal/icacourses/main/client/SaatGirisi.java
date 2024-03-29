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

public class SaatGirisi extends Composite {
	private CellTable<XMLSaatGirisi> grdSaatGirisi;
	private TextColumn<XMLSaatGirisi> grdcSeciliGun;
	private Column<XMLSaatGirisi, String> column_4;
	private Column<XMLSaatGirisi, String> column_5;
	private Column<XMLSaatGirisi, ?> textColumn;
	private Column<XMLSaatGirisi, ?> column;
	private DlgSaatGirisi _dlgSaatGirisi;
	private Column<XMLSaatGirisi, String> column_1;

	public SaatGirisi() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
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

		Label lblSaatGirii = new Label("Saat Girişi");
		horizontalPanel_1.add(lblSaatGirii);
		lblSaatGirii.setWidth("100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setSpacing(15);
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "30");
		horizontalPanel_2.setWidth("100%");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_2.add(btnYeniKayit);
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "212px");

		grdSaatGirisi = new CellTable<XMLSaatGirisi>();
		horizontalPanel.add(grdSaatGirisi);
		grdSaatGirisi.setSize("100%", "100%");

		grdcSeciliGun = new TextColumn<XMLSaatGirisi>() {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return object.gun.toString();
			}
		};
		grdSaatGirisi.addColumn(grdcSeciliGun, "Seçili Gün");

		column_4 = new TextColumn<XMLSaatGirisi>() {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return (object.baslangic_saat + ":" + object.baslangic_dakika);
			}
		};
		grdSaatGirisi.addColumn(column_4, "Başlangıç Saati");

		column_5 = new TextColumn<XMLSaatGirisi>() {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return (object.bitis_saat + ":" + object.bitis_dakika);
			}
		};
		grdSaatGirisi.addColumn(column_5, "Bitiş Saati");

		textColumn = new TextColumn<XMLSaatGirisi>() {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return object.aciklama.toString();
			}
		};
		grdSaatGirisi.addColumn(textColumn, "Açıklama");

		Column<XMLSaatGirisi, String> column_2 = new Column<XMLSaatGirisi, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return (String) null;
			}
		};
		grdSaatGirisi.addColumn(column_2, "Düzenle");

		Column<XMLSaatGirisi, String> column_1_1 = new Column<XMLSaatGirisi, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return (String) null;
			}
		};
		grdSaatGirisi.addColumn(column_1_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();
			final SingleSelectionModel<XMLSaatGirisi> selectionModel = new SingleSelectionModel<XMLSaatGirisi>();

			grdSaatGirisi.setSelectionModel(selectionModel);
			grdSaatGirisi.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLSaatGirisi selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column_2.setFieldUpdater(new FieldUpdater<XMLSaatGirisi, String>() {

				@Override
				public void update(int index, XMLSaatGirisi object, String value) {

					XMLSaatGirisi selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1_1
					.setFieldUpdater(new FieldUpdater<XMLSaatGirisi, String>() {

						@Override
						public void update(int index, XMLSaatGirisi object,
								String value) {

							XMLSaatGirisi selected = selectionModel
									.getSelectedObject();

							Boolean x = Window
									.confirm("Kayit Silinecektir, Emin Misiniz?");

							if (x == true) {

								if (selected != null) {
									// DO YOUR STUFF

									// Window.alert("selected id: " +
									// selected.id);
									// showWithData(selected.id);

									String URLValue = Util.urlBase
											+ "putsaatgirisi?";

									URLValue = URLValue + "id=" + selected.id;
									URLValue = URLValue + "&baslangic_saat="
											+ object.baslangic_saat.toString();
									URLValue = URLValue + "&bitis_saat="
											+ object.bitis_saat.toString();
									URLValue = URLValue
											+ "&baslangic_dakika="
											+ object.baslangic_dakika
													.toString();
									URLValue = URLValue + "&bitis_dakika="
											+ object.bitis_dakika.toString();
									URLValue = URLValue + "&gun="
											+ object.gun.toString();
									URLValue = URLValue + "&aciklama="
											+ object.aciklama.toString();
									URLValue = URLValue
											+ "&kayit_silinsin_mi=TRUE";

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

									// Schedule the timer to run once in 1s
									// seconds.
									t.schedule(1000);

								}

								// putDataToGrid();
							}

						}
					});

		}// design time
	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getsaatgirisi?id=" + id;

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

					List<XMLSaatGirisi> listXmlSaatGirisi = XMLSaatGirisi.XML
							.readList(response.getText());

					_dlgSaatGirisi = new DlgSaatGirisi(false, new Long(id)
							.longValue());
					_dlgSaatGirisi.putDataFromXML(listXmlSaatGirisi.get(0));
					_dlgSaatGirisi.setAnimationEnabled(true);
					_dlgSaatGirisi.center();
					_dlgSaatGirisi.tabSaatGirisi.selectTab(0);
					_dlgSaatGirisi
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
				+ "getsaatgirisi?kayit_silinsin_mi=FALSE";

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

					List<XMLSaatGirisi> listXmlSaatGirisi = XMLSaatGirisi.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdSaatGirisi.setRowCount(1, true);

					// Push the data into the widget.
					// grdSaatGirisi.setRowData(0, listXmlSaatGirisi);

					if (listXmlSaatGirisi != null) {

						grdSaatGirisi.setRowData(0, listXmlSaatGirisi);

						grdSaatGirisi.redraw();

					} else {

						grdSaatGirisi.setRowCount(0, true);
						grdSaatGirisi.redraw();
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
			_dlgSaatGirisi = new DlgSaatGirisi(true, -1);
			_dlgSaatGirisi.center();
			_dlgSaatGirisi.setAnimationEnabled(true);
			_dlgSaatGirisi.tabSaatGirisi.selectTab(0);

			_dlgSaatGirisi.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});
		}
	}
}
