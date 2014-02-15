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

public class DersTanimlari extends Composite {
	private CellTable<XMLDersTanimlari> grdDersTanimlari;

	private DlgDersTanimlari _dlgDersTanimlari;

	// public long _id = -1;

	public DersTanimlari() {

		// _id = id;

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "443px");

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

		Label lblDersTanmlar = new Label("Ders Tanımları");
		horizontalPanel_2.add(lblDersTanmlar);
		lblDersTanmlar.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "40px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "75px");

		grdDersTanimlari = new CellTable<XMLDersTanimlari>();
		horizontalPanel.add(grdDersTanimlari);
		grdDersTanimlari.setSize("100%", "100%");

		TextColumn<XMLDersTanimlari> textColumn_3 = new TextColumn<XMLDersTanimlari>() {
			@Override
			public String getValue(XMLDersTanimlari object) {
				return object.id.toString();
			}
		};
		grdDersTanimlari.addColumn(textColumn_3, "İD");
		grdDersTanimlari.setColumnWidth(textColumn_3, "32px");

		final Column<XMLDersTanimlari, String> textColumn = new TextColumn<XMLDersTanimlari>() {
			public String getValue(XMLDersTanimlari object) {
				return object.egitim_turu_adi.toString();
			}
		};
		grdDersTanimlari.addColumn(textColumn, "Eğitim Türü Adı");

		final Column<XMLDersTanimlari, String> textColumn_1 = new TextColumn<XMLDersTanimlari>() {
			public String getValue(XMLDersTanimlari object) {
				return object.alan_adi.toString();
			}
		};
		grdDersTanimlari.addColumn(textColumn_1, "Alan Adı");

		final Column<XMLDersTanimlari, String> textColumn_2 = new TextColumn<XMLDersTanimlari>() {
			@Override
			public String getValue(XMLDersTanimlari object) {
				return object.ders_adi.toString();
			}
		};
		grdDersTanimlari.addColumn(textColumn_2, "Ders Adı");

		Column<XMLDersTanimlari, String> column = new Column<XMLDersTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLDersTanimlari object) {
				return "Düzenle";
			}
		};
		grdDersTanimlari.addColumn(column, "Düzenle");

		Column<XMLDersTanimlari, String> column_1 = new Column<XMLDersTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLDersTanimlari object) {
				return "Sil";
			}
		};
		grdDersTanimlari.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLDersTanimlari> selectionModel = new SingleSelectionModel<XMLDersTanimlari>();

			grdDersTanimlari.setSelectionModel(selectionModel);

			grdDersTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLDersTanimlari selected = selectionModel
							.getSelectedObject();

					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());
			column.setFieldUpdater(new FieldUpdater<XMLDersTanimlari, String>() {

				@Override
				public void update(int index, XMLDersTanimlari object, String id) {

					XMLDersTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLDersTanimlari, String>() {

				@Override
				public void update(int index, XMLDersTanimlari object,
						String value) {
					XMLDersTanimlari selected = selectionModel
							.getSelectedObject();
					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putderstanimlari?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&egitim_turu_adi="
									+ textColumn.getValue(selected);
							URLValue = URLValue + "&alan_adi="
									+ textColumn_1.getValue(selected);
							URLValue = URLValue + "&ders_adi="
									+ textColumn_2.getValue(selected);

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"DERS BİLGİSİ KAYIT EDİLDİ",
									"DERS BİLGİSİ KAYIT EDİLEMEDİ");

						}

					}

				}
			});

		}// design time

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getderstanimlari?id=" + id;

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

					List<XMLDersTanimlari> listXmlDersTanimlari = XMLDersTanimlari.XML
							.readList(response.getText());

					_dlgDersTanimlari = new DlgDersTanimlari(false,
							new Long(id).longValue());
					_dlgDersTanimlari.putDataFromXML(listXmlDersTanimlari
							.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
					_dlgDersTanimlari.setAnimationEnabled(true);
					_dlgDersTanimlari.center();

					_dlgDersTanimlari
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
				+ "getderstanimlari?kayit_silinsin_mi=FALSE";

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

					List<XMLDersTanimlari> listXmlDersTanimlari = XMLDersTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdDersTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdDersTanimlari.setRowData(0, listXmlDersTanimlari);

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
			_dlgDersTanimlari = new DlgDersTanimlari(true, -1);
			_dlgDersTanimlari.center();
			_dlgDersTanimlari.setAnimationEnabled(true);

			_dlgDersTanimlari.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}
}