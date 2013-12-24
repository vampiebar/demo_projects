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
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class EgitimTuruTanimlama extends Composite {
	private CellTable<XMLEgitimTuruTanimlama> grdEgitimTuru;
	public DlgEgitimTuruTanimlama _dlgEgitimTuruTanimlama;

	public EgitimTuruTanimlama() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		initWidget(absolutePanel);
		absolutePanel.setSize("738px", "650px");

		grdEgitimTuru = new CellTable<XMLEgitimTuruTanimlama>();
		absolutePanel.add(grdEgitimTuru, 0, 147);
		grdEgitimTuru.setSize("100%", "154px");

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

		Column<XMLEgitimTuruTanimlama, String> column = new Column<XMLEgitimTuruTanimlama, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLEgitimTuruTanimlama object) {
				return (String) null;
			}
		};
		grdEgitimTuru.addColumn(column, "İşlemler");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		absolutePanel.add(btnYeniKayit, 342, 65);
		btnYeniKayit.setSize("78px", "48px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonSave");
		absolutePanel.add(btnListeyiYenile, 437, 65);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 526, 65);
		btnExceleAktar.setSize("78px", "48px");

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

				private void showWithData(final String id) {

					String urlWithParameters = Util.urlBase
							+ "getegitimturutanimlama?id=" + id;

					RequestBuilder builder = new RequestBuilder(
							RequestBuilder.GET, urlWithParameters);

					// Window.alert("URL TO GET VALUES: " + urlWithParameters);
					try {
						Request request = builder.sendRequest(null,
								new RequestCallback() {
									public void onError(Request request,
											Throwable exception) {

									}

									@Override
									public void onResponseReceived(
											Request request, Response response) {

										// Window.alert("AAABBBCCC " +
										// response.getText());

										List<XMLEgitimTuruTanimlama> listXmlegitimTuru = XMLEgitimTuruTanimlama.XML
												.readList(response.getText());

										_dlgEgitimTuruTanimlama = new DlgEgitimTuruTanimlama(
												false, new Long(id).longValue());
										_dlgEgitimTuruTanimlama
												.putDataFromXML(listXmlegitimTuru
														.get(0));
										// dlgTemp.tabOnKayit.selectTab(0);
										_dlgEgitimTuruTanimlama
												.setAnimationEnabled(true);
										_dlgEgitimTuruTanimlama.center();
										_dlgEgitimTuruTanimlama
												.addCloseHandler(new CloseHandler<PopupPanel>() {

													@Override
													public void onClose(
															CloseEvent<PopupPanel> event) {

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
			}, DoubleClickEvent.getType());
		}

	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase + "getegitimturutanimlama";

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
					grdEgitimTuru.setRowData(0, listXmlEgitimTuru);

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
