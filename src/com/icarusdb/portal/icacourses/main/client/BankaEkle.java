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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class BankaEkle extends Composite {
	private CellTable<XMLBankaEkle> grdBankaEkle;
	private Column<XMLBankaEkle, ?> textColumn;
	private Column<XMLBankaEkle, ?> column;
	private DlgBankaEkle _dlgBankaEkle;

	public BankaEkle() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("795px", "750px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 70);
		btnYeniKayit.setSize("81px", "58px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 197);
		horizontalPanel.setSize("774px", "75px");

		grdBankaEkle = new CellTable<XMLBankaEkle>();
		horizontalPanel.add(grdBankaEkle);
		grdBankaEkle.setSize("100%", "100%");

		final TextColumn<XMLBankaEkle> textColumn_1 = new TextColumn<XMLBankaEkle>() {
			@Override
			public String getValue(XMLBankaEkle object) {
				return object.id.toString();
			}
		};
		grdBankaEkle.addColumn(textColumn_1, "İD");
		grdBankaEkle.setColumnWidth(textColumn_1, "75px");

		textColumn = new TextColumn<XMLBankaEkle>() {
			@Override
			public String getValue(XMLBankaEkle object) {
				return object.banka_adi.toString();
			}
		};
		grdBankaEkle.addColumn(textColumn, "Banka Adı");

		Column<XMLBankaEkle, String> column = new Column<XMLBankaEkle, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLBankaEkle object) {
				return "Düzenle";
			}
		};
		grdBankaEkle.addColumn(column, "Düzenle");
		grdBankaEkle.setColumnWidth(column, "142px");

		Column<XMLBankaEkle, String> column_1 = new Column<XMLBankaEkle, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLBankaEkle object) {
				return "Sil";
			}
		};
		grdBankaEkle.addColumn(column_1, "Sil");
		grdBankaEkle.setColumnWidth(column_1, "166px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLBankaEkle> selectionModel = new SingleSelectionModel<XMLBankaEkle>();

			grdBankaEkle.setSelectionModel(selectionModel);
			grdBankaEkle.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLBankaEkle selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLBankaEkle, String>() {

				@Override
				public void update(int index, XMLBankaEkle object, String value) {

					XMLBankaEkle selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});
			column_1.setFieldUpdater(new FieldUpdater<XMLBankaEkle, String>() {

				@Override
				public void update(int index, XMLBankaEkle object, String value) {

					XMLBankaEkle selected = selectionModel.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase + "putbankaekle?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&banka_adi="
									+ textColumn.getValue(selected);
							URLValue = URLValue + "&banka_sube="
									+ object.banka_sube.toString();
							URLValue = URLValue + "&hesap_no="
									+ object.hesap_no.toString();
							URLValue = URLValue + "&iban_no="
									+ object.iban_no.toString();
							URLValue = URLValue + "&bankanin_odeme_sekli="
									+ object.bankanin_odeme_sekli.toString();
							URLValue = URLValue + "&vade_tarihi="
									+ object.vade_tarihi.toString();
							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"DERS BİLGİSİ KAYIT EDİLDİ",
									"DERS BİLGİSİ KAYIT EDİLEMEDİ");

						}

						putDataToGrid();
					}

					// putDataToGrid();
				}
			});

		}// design time
	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getbankaekle?id=" + id;

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

					List<XMLBankaEkle> listXmlBankaEkle = XMLBankaEkle.XML
							.readList(response.getText());

					_dlgBankaEkle = new DlgBankaEkle(false, new Long(id)
							.longValue());
					_dlgBankaEkle.putDataFromXML(listXmlBankaEkle.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
					_dlgBankaEkle.setAnimationEnabled(true);
					_dlgBankaEkle.center();

					_dlgBankaEkle
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
				+ "getbankaekle?kayit_silinsin_mi=FALSE";

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

					List<XMLBankaEkle> listXmlBankaEkle = XMLBankaEkle.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdBankaEkle.setRowCount(1, true);

					// Push the data into the widget.
					grdBankaEkle.setRowData(0, listXmlBankaEkle);

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

	public class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			_dlgBankaEkle = new DlgBankaEkle(true, -1);
			_dlgBankaEkle.center();
			_dlgBankaEkle.setAnimationEnabled(true);

			_dlgBankaEkle.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}
}
