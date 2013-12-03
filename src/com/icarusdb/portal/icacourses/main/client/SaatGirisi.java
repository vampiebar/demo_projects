package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
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

public class SaatGirisi extends Composite {
	private CellTable<XMLSaatGirisi> grdSaatGirisi;
	private TextColumn<XMLSaatGirisi> grdcSeciliGun;
	private Column<XMLSaatGirisi, String> column;
	private Column<XMLSaatGirisi, String> column_1;
	private Column<XMLSaatGirisi, ?> textColumn;
	private Column<XMLSaatGirisi, ?> column_2;
	private DlgSaatGirisi _dlgSaatGirisi;

	public SaatGirisi() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("781px", "450px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 103);
		horizontalPanel.setSize("761px", "301px");

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

		column = new TextColumn<XMLSaatGirisi>() {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return (object.baslangic_saati);
			}
		};
		grdSaatGirisi.addColumn(column, "Başlangıç Saati");

		column_1 = new TextColumn<XMLSaatGirisi>() {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return (object.bitis_saati);
			}
		};
		grdSaatGirisi.addColumn(column_1, "Bitiş Saati");

		textColumn = new TextColumn<XMLSaatGirisi>() {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return object.aciklama.toString();
			}
		};
		grdSaatGirisi.addColumn(textColumn, "Açıklama");

		column_2 = new Column<XMLSaatGirisi, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLSaatGirisi object) {
				return (String) null;
			}
		};
		grdSaatGirisi.addColumn(column_2, "İşlemler");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 485, 49);
		btnYeniKayit.setSize("78px", "48px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 582, 49);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 673, 49);
		btnExceleAktar.setSize("78px", "48px");

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
		}

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

		String urlWithParameters = Util.urlBase + "getsaatgirisi";

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
					grdSaatGirisi.setRowData(0, listXmlSaatGirisi);

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
