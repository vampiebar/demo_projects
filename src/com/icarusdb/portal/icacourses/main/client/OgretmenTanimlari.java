package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.NumberCell;
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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class OgretmenTanimlari extends Composite {
	private CellTable<XMLOgretmenTanimlari> grdOgretmenTanimlari;
	private DlgOgretmenTanimlari _dlgOgretmenTanimlari;

	public OgretmenTanimlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("797px", "453px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 545, 62);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 62);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 634, 62);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 189);
		horizontalPanel.setSize("774px", "75px");

		grdOgretmenTanimlari = new CellTable<XMLOgretmenTanimlari>();
		horizontalPanel.add(grdOgretmenTanimlari);
		grdOgretmenTanimlari.setSize("100%", "100%");

		TextColumn<XMLOgretmenTanimlari> textColumn_1 = new TextColumn<XMLOgretmenTanimlari>() {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return object.id.toString();
			}
		};
		grdOgretmenTanimlari.addColumn(textColumn_1, "İD");
		grdOgretmenTanimlari.setColumnWidth(textColumn_1, "19px");

		Column<XMLOgretmenTanimlari, ?> column_1 = new Column<XMLOgretmenTanimlari, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(XMLOgretmenTanimlari object) {
				return (Number) null;
			}
		};
		grdOgretmenTanimlari.addColumn(column_1, "Öğretmen Özel No");

		TextColumn<XMLOgretmenTanimlari> column_2 = new TextColumn<XMLOgretmenTanimlari>() {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return (object.tc_kimlik_no);
			}
		};
		grdOgretmenTanimlari.addColumn(column_2, "TC Kimlik No");

		Column<XMLOgretmenTanimlari, ?> textColumn = new TextColumn<XMLOgretmenTanimlari>() {
			public String getValue(XMLOgretmenTanimlari object) {
				return object.adi_soyadi.toString();
			}
		};
		grdOgretmenTanimlari.addColumn(textColumn, "Öğretmen Adı Soyadı");

		TextColumn<XMLOgretmenTanimlari> column_3 = new TextColumn<XMLOgretmenTanimlari>() {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return (object.cep_telefonu);
			}
		};
		grdOgretmenTanimlari.addColumn(column_3, "Cep Tel.");

		TextColumn<XMLOgretmenTanimlari> column_4 = new TextColumn<XMLOgretmenTanimlari>() {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return (object.ev_telefonu);
			}
		};
		grdOgretmenTanimlari.addColumn(column_4, "Ev Tel.");

		Column<XMLOgretmenTanimlari, ?> column = new Column<XMLOgretmenTanimlari, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLOgretmenTanimlari object) {
				return (String) null;
			}
		};
		grdOgretmenTanimlari.addColumn(column, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLOgretmenTanimlari> selectionModel = new SingleSelectionModel<XMLOgretmenTanimlari>();

			grdOgretmenTanimlari.setSelectionModel(selectionModel);
			grdOgretmenTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLOgretmenTanimlari selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());
		}

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getogretmentanimlari?id="
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

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLOgretmenTanimlari> listXmlOgretmenTanimlari = XMLOgretmenTanimlari.XML
							.readList(response.getText());

					_dlgOgretmenTanimlari = new DlgOgretmenTanimlari(false,
							new Long(id).longValue());
					_dlgOgretmenTanimlari
							.putDataFromXML(listXmlOgretmenTanimlari.get(0));
					_dlgOgretmenTanimlari.setAnimationEnabled(true);
					_dlgOgretmenTanimlari.center();
					_dlgOgretmenTanimlari.tabOgretmenIslemleri.selectTab(0);
					_dlgOgretmenTanimlari
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

		String urlWithParameters = Util.urlBase + "getogretmentanimlari";

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

					List<XMLOgretmenTanimlari> listXmlOgretmenTanimlari = XMLOgretmenTanimlari.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdOgretmenTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdOgretmenTanimlari
							.setRowData(0, listXmlOgretmenTanimlari);

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
			_dlgOgretmenTanimlari = new DlgOgretmenTanimlari(true, -1);
			_dlgOgretmenTanimlari.center();
			_dlgOgretmenTanimlari.setAnimationEnabled(true);
			_dlgOgretmenTanimlari.tabOgretmenIslemleri.selectTab(0);

			_dlgOgretmenTanimlari
					.addCloseHandler(new CloseHandler<PopupPanel>() {

						@Override
						public void onClose(CloseEvent<PopupPanel> event) {

							putDataToGrid();

						}
					});

		}
	}
}
