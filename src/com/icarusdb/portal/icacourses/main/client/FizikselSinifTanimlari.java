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

public class FizikselSinifTanimlari extends Composite {
	private CellTable<XMLFizikselSinifTanimlari> grdFizikselSinifTanimlari;
	private DlgFizikselSinifTanimlari _dlgFizikselSinifTanimlari;

	public FizikselSinifTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "750px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_2.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "50");
		horizontalPanel_2.setSize("100%", "33px");

		Label lblFizikselSnfTanmlar = new Label("Fiziksel Sınıf Tanımları");
		horizontalPanel_2.add(lblFizikselSnfTanmlar);
		lblFizikselSnfTanmlar.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "42px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "75px");

		grdFizikselSinifTanimlari = new CellTable<XMLFizikselSinifTanimlari>();
		horizontalPanel.add(grdFizikselSinifTanimlari);
		grdFizikselSinifTanimlari.setSize("100%", "100%");

		TextColumn<XMLFizikselSinifTanimlari> textColumn_1 = new TextColumn<XMLFizikselSinifTanimlari>() {
			@Override
			public String getValue(XMLFizikselSinifTanimlari object) {
				return object.id.toString();
			}
		};
		grdFizikselSinifTanimlari.addColumn(textColumn_1, "İD");
		grdFizikselSinifTanimlari.setColumnWidth(textColumn_1, "56px");

		final Column<XMLFizikselSinifTanimlari, ?> textColumn = new TextColumn<XMLFizikselSinifTanimlari>() {
			public String getValue(XMLFizikselSinifTanimlari object) {
				return object.fiziksel_sinif_adi.toString();
			}
		};
		grdFizikselSinifTanimlari.addColumn(textColumn, "Fiziksel Sınıf Adı");
		grdFizikselSinifTanimlari.setColumnWidth(textColumn, "328px");

		Column<XMLFizikselSinifTanimlari, String> column = new Column<XMLFizikselSinifTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLFizikselSinifTanimlari object) {
				return (String) null;
			}
		};
		grdFizikselSinifTanimlari.addColumn(column, "Düzenle");
		grdFizikselSinifTanimlari.setColumnWidth(column, "148px");

		Column<XMLFizikselSinifTanimlari, String> column_1 = new Column<XMLFizikselSinifTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLFizikselSinifTanimlari object) {
				return (String) null;
			}
		};
		grdFizikselSinifTanimlari.addColumn(column_1, "Sil");
		grdFizikselSinifTanimlari.setColumnWidth(column_1, "142px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLFizikselSinifTanimlari> selectionModel = new SingleSelectionModel<XMLFizikselSinifTanimlari>();

			grdFizikselSinifTanimlari.setSelectionModel(selectionModel);
			grdFizikselSinifTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLFizikselSinifTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLFizikselSinifTanimlari, String>() {

				@Override
				public void update(int index, XMLFizikselSinifTanimlari object,
						String value) {

					XMLFizikselSinifTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});
			column_1.setFieldUpdater(new FieldUpdater<XMLFizikselSinifTanimlari, String>() {

				@Override
				public void update(int index, XMLFizikselSinifTanimlari object,
						String id) {

					XMLFizikselSinifTanimlari selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putfizikselsiniftanimlari?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&fiziksel_sinif_adi="
									+ textColumn.getValue(selected);

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"DERS BİLGİSİ KAYIT EDİLDİ",
									"DERS BİLGİSİ KAYIT EDİLEMEDİ");
						}
					}
				}
			});
		}
	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase
				+ "getfizikselsiniftanimlari?id=" + id;

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

					List<XMLFizikselSinifTanimlari> listXmlFizikselSinifTanimlari = XMLFizikselSinifTanimlari.XML
							.readList(response.getText());

					_dlgFizikselSinifTanimlari = new DlgFizikselSinifTanimlari(
							false, new Long(id).longValue());
					_dlgFizikselSinifTanimlari
							.putDataFromXML(listXmlFizikselSinifTanimlari
									.get(0));
					_dlgFizikselSinifTanimlari.setAnimationEnabled(true);
					_dlgFizikselSinifTanimlari.center();

					_dlgFizikselSinifTanimlari
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
				+ "getfizikselsiniftanimlari?kayit_silinsin_mi=FALSE";

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

					List<XMLFizikselSinifTanimlari> listXmlFizikselSinifTanimlari = XMLFizikselSinifTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdFizikselSinifTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdFizikselSinifTanimlari.setRowData(0,
							listXmlFizikselSinifTanimlari);

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
			_dlgFizikselSinifTanimlari = new DlgFizikselSinifTanimlari(true, -1);
			_dlgFizikselSinifTanimlari.center();
			_dlgFizikselSinifTanimlari.setAnimationEnabled(true);

			_dlgFizikselSinifTanimlari
					.addCloseHandler(new CloseHandler<PopupPanel>() {

						@Override
						public void onClose(CloseEvent<PopupPanel> event) {

							putDataToGrid();

						}
					});
		}
	}
}
