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

public class UniteTanimlari extends Composite {
	private CellTable<XMLUniteTanimlari> grdUnitetanimlari;
	private DlgUniteTanimlari _dlgUniteTanimlari;

	public UniteTanimlari() {

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

		Label lblUniteTanmlar = new Label("Ünite Tanımları");
		horizontalPanel_2.add(lblUniteTanmlar);
		lblUniteTanmlar.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "31px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "75px");

		grdUnitetanimlari = new CellTable<XMLUniteTanimlari>();
		horizontalPanel.add(grdUnitetanimlari);
		grdUnitetanimlari.setSize("100%", "100%");

		TextColumn<XMLUniteTanimlari> textColumn_4 = new TextColumn<XMLUniteTanimlari>() {
			@Override
			public String getValue(XMLUniteTanimlari object) {
				return object.id.toString();
			}
		};
		grdUnitetanimlari.addColumn(textColumn_4, "İD");

		Column<XMLUniteTanimlari, ?> textColumn = new TextColumn<XMLUniteTanimlari>() {
			public String getValue(XMLUniteTanimlari object) {
				return object.egitim_turu_adi.toString();
			}
		};
		grdUnitetanimlari.addColumn(textColumn, "Eğitim Türü Adı");

		Column<XMLUniteTanimlari, ?> textColumn_1 = new TextColumn<XMLUniteTanimlari>() {
			public String getValue(XMLUniteTanimlari object) {
				return object.alan_adi.toString();
			}
		};
		grdUnitetanimlari.addColumn(textColumn_1, "Alan Adı");

		Column<XMLUniteTanimlari, ?> textColumn_2 = new TextColumn<XMLUniteTanimlari>() {
			@Override
			public String getValue(XMLUniteTanimlari object) {
				return object.ders_adi.toString();
			}
		};
		grdUnitetanimlari.addColumn(textColumn_2, "Ders Adı");

		Column<XMLUniteTanimlari, ?> textColumn_3 = new TextColumn<XMLUniteTanimlari>() {
			@Override
			public String getValue(XMLUniteTanimlari object) {
				return object.unite_adi.toString();
			}
		};
		grdUnitetanimlari.addColumn(textColumn_3, "Ünite Adı");

		Column<XMLUniteTanimlari, String> column = new Column<XMLUniteTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLUniteTanimlari object) {
				return (String) null;
			}
		};
		grdUnitetanimlari.addColumn(column, "Düzenle");

		Column<XMLUniteTanimlari, String> column_1 = new Column<XMLUniteTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLUniteTanimlari object) {
				return (String) null;
			}
		};
		grdUnitetanimlari.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLUniteTanimlari> selectionModel = new SingleSelectionModel<XMLUniteTanimlari>();

			grdUnitetanimlari.setSelectionModel(selectionModel);

			grdUnitetanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLUniteTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLUniteTanimlari, String>() {

				@Override
				public void update(int index, XMLUniteTanimlari object,
						String value) {

					XMLUniteTanimlari selected = selectionModel
							.getSelectedObject();

					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLUniteTanimlari, String>() {

				@Override
				public void update(int index, XMLUniteTanimlari object,
						String value) {
					XMLUniteTanimlari selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putunitetanimlari?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&egitim_turu_adi="
									+ object.egitim_turu_adi.toString();
							URLValue = URLValue + "&alan_adi="
									+ object.alan_adi.toString();
							URLValue = URLValue + "&ders_adi="
									+ object.ders_adi.toString();
							URLValue = URLValue + "&unite_adi="
									+ object.unite_adi.toString();

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"UNİTE BİLGİSİ KAYIT EDİLDİ",
									"UNİTE BİLGİSİ KAYIT EDİLEMEDİ");

						}

					}

				}
			});

		}// design time
	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getunitetanimlari?id=" + id;

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

					List<XMLUniteTanimlari> listXmlUniteTanimlari = XMLUniteTanimlari.XML
							.readList(response.getText());

					_dlgUniteTanimlari = new DlgUniteTanimlari(false, new Long(
							id).longValue());
					_dlgUniteTanimlari.putDataFromXML(listXmlUniteTanimlari
							.get(0));
					_dlgUniteTanimlari.setAnimationEnabled(true);
					_dlgUniteTanimlari.center();
					_dlgUniteTanimlari
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
				+ "getunitetanimlari?kayit_silinsin_mi=FALSE";

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

					List<XMLUniteTanimlari> listXmlUniteTanimlari = XMLUniteTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdUnitetanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdUnitetanimlari.setRowData(0, listXmlUniteTanimlari);

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
			_dlgUniteTanimlari = new DlgUniteTanimlari(true, -1);
			_dlgUniteTanimlari.center();
			_dlgUniteTanimlari.setAnimationEnabled(true);

			_dlgUniteTanimlari.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});
		}
	}
}
