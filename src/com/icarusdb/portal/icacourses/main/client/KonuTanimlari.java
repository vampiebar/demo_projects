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

public class KonuTanimlari extends Composite {
	private CellTable<XMLKonuTanimlari> grdKonuTanimlari;
	private DlgKonuTanimlari _dlgKonuTanimlari;

	public KonuTanimlari() {

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

		Label lblKonuTanmlar = new Label("Konu Tanımları");
		horizontalPanel_2.add(lblKonuTanmlar);
		lblKonuTanmlar.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "37px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.setText("Yeni Kayit");
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "75px");

		grdKonuTanimlari = new CellTable<XMLKonuTanimlari>();
		horizontalPanel.add(grdKonuTanimlari);
		grdKonuTanimlari.setSize("100%", "100%");

		TextColumn<XMLKonuTanimlari> textColumn_5 = new TextColumn<XMLKonuTanimlari>() {
			@Override
			public String getValue(XMLKonuTanimlari object) {
				return object.id.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_5, "İD");
		grdKonuTanimlari.setColumnWidth(textColumn_5, "24px");

		Column<XMLKonuTanimlari, ?> textColumn = new TextColumn<XMLKonuTanimlari>() {
			public String getValue(XMLKonuTanimlari object) {
				return object.egitim_turu_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn, "Eğitim Türü Adı");

		Column<XMLKonuTanimlari, ?> textColumn_1 = new TextColumn<XMLKonuTanimlari>() {
			public String getValue(XMLKonuTanimlari object) {
				return object.alan_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_1, "Alan Adı");

		Column<XMLKonuTanimlari, ?> textColumn_2 = new TextColumn<XMLKonuTanimlari>() {
			public String getValue(XMLKonuTanimlari object) {
				return object.ders_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_2, "Ders Adı");

		Column<XMLKonuTanimlari, ?> textColumn_3 = new TextColumn<XMLKonuTanimlari>() {
			public String getValue(XMLKonuTanimlari object) {
				return object.unite_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_3, "Ünite Adı");

		Column<XMLKonuTanimlari, ?> textColumn_4 = new TextColumn<XMLKonuTanimlari>() {
			@Override
			public String getValue(XMLKonuTanimlari object) {
				return object.konu_adi.toString();
			}
		};
		grdKonuTanimlari.addColumn(textColumn_4, "Konu Adı");

		Column<XMLKonuTanimlari, String> column = new Column<XMLKonuTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLKonuTanimlari object) {
				return "Düzenle";
			}
		};
		grdKonuTanimlari.addColumn(column, "Düzenle");

		Column<XMLKonuTanimlari, String> column_1 = new Column<XMLKonuTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLKonuTanimlari object) {
				return (String) null;
			}
		};
		grdKonuTanimlari.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLKonuTanimlari> selectionModel = new SingleSelectionModel<XMLKonuTanimlari>();

			grdKonuTanimlari.setSelectionModel(selectionModel);
			grdKonuTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLKonuTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLKonuTanimlari, String>() {

				@Override
				public void update(int index, XMLKonuTanimlari object,
						String value) {

					XMLKonuTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLKonuTanimlari, String>() {

				@Override
				public void update(int index, XMLKonuTanimlari object,
						String value) {
					XMLKonuTanimlari selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putkonutanimlari?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&egitim_turu_adi="
									+ object.egitim_turu_adi.toString();
							URLValue = URLValue + "&alan_adi="
									+ object.alan_adi.toString();
							URLValue = URLValue + "&ders_adi="
									+ object.ders_adi.toString();
							URLValue = URLValue + "&unite_adi="
									+ object.unite_adi.toString();
							URLValue = URLValue + "&konu_adi="
									+ object.konu_adi.toString();

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"DERS BİLGİSİ KAYIT EDİLDİ",
									"DERS BİLGİSİ KAYIT EDİLEMEDİ");

						}

						// putDataToGrid();
					}

				}
			});

		}// design time
	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getkonutanimlari?id=" + id;

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

					List<XMLKonuTanimlari> listXmlKonuTanimlari = XMLKonuTanimlari.XML
							.readList(response.getText());

					_dlgKonuTanimlari = new DlgKonuTanimlari(false,
							new Long(id).longValue());
					_dlgKonuTanimlari.putDataFromXML(listXmlKonuTanimlari
							.get(0));
					_dlgKonuTanimlari.setAnimationEnabled(true);
					_dlgKonuTanimlari.center();
					_dlgKonuTanimlari
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
				+ "getkonutanimlari?kayit_silinsin_mi=FALSE";

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

					List<XMLKonuTanimlari> listXmlKonuTanimlari = XMLKonuTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdKonuTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdKonuTanimlari.setRowData(0, listXmlKonuTanimlari);

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
			_dlgKonuTanimlari = new DlgKonuTanimlari(true, -1);
			_dlgKonuTanimlari.center();
			_dlgKonuTanimlari.setAnimationEnabled(true);

			_dlgKonuTanimlari.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}
}
