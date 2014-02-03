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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class SinavTanimlama extends Composite {
	private CellTable<XMLSinavTanimlama> grdSinavTanimlama;
	private TextColumn<XMLSinavTanimlama> textColumn;
	private Column<XMLSinavTanimlama, String> column_2;
	private TextColumn<XMLSinavTanimlama> textColumn_1;
	private Button btnYeniKayit;
	private ListBox cbxSinavTuru;
	private TextColumn<XMLSinavTanimlama> textColumn_3;
	private DlgSinavTanimlama _dlgSinavTanimlama;
	private Column<XMLSinavTanimlama, String> column_1;
	private Column<XMLSinavTanimlama, String> column;

	public SinavTanimlama() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("780px", "750px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 20, 137);
		horizontalPanel.setSize("727px", "156px");

		grdSinavTanimlama = new CellTable<XMLSinavTanimlama>();
		horizontalPanel.add(grdSinavTanimlama);
		grdSinavTanimlama.setSize("737px", "124px");

		textColumn_3 = new TextColumn<XMLSinavTanimlama>() {
			@Override
			public String getValue(XMLSinavTanimlama object) {
				return object.sinav_no.toString();
			}
		};
		grdSinavTanimlama.addColumn(textColumn_3, "Sınav No");
		grdSinavTanimlama.setColumnWidth(textColumn_3, "91px");

		textColumn = new TextColumn<XMLSinavTanimlama>() {
			public String getValue(XMLSinavTanimlama object) {
				return object.sinav_adi.toString();
			}
		};
		grdSinavTanimlama.addColumn(textColumn, "Sınav Adı");

		column_2 = new TextColumn<XMLSinavTanimlama>() {
			@Override
			public String getValue(XMLSinavTanimlama object) {
				return (object.tarih + " " + object.saat + ":" + object.dakika);
			}
		};
		grdSinavTanimlama.addColumn(column_2, "Sınav Tarihi");

		textColumn_1 = new TextColumn<XMLSinavTanimlama>() {
			public String getValue(XMLSinavTanimlama object) {
				return object.son_kitapcik_no.toString();
			}
		};
		grdSinavTanimlama.addColumn(textColumn_1, "Son Kitapçık No");

		column = new Column<XMLSinavTanimlama, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLSinavTanimlama object) {
				return "Düzenle";
			}
		};
		grdSinavTanimlama.addColumn(column, "Düzenle");
		grdSinavTanimlama.setColumnWidth(column, "105px");

		column_1 = new Column<XMLSinavTanimlama, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLSinavTanimlama object) {
				return "Sil";
			}
		};
		grdSinavTanimlama.addColumn(column_1, "Sil");
		grdSinavTanimlama.setColumnWidth(column_1, "101px");

		btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 588, 42);
		btnYeniKayit.setSize("85px", "56px");

		Label lblSnavTuru = new Label("Sınav Türü");
		lblSnavTuru.setStyleName("gwt-Bold");
		absolutePanel.add(lblSnavTuru, 32, 37);

		cbxSinavTuru = new ListBox();
		cbxSinavTuru.setStyleName("gwt-ComboBox1");
		cbxSinavTuru.addItem(" ");
		absolutePanel.add(cbxSinavTuru, 115, 37);
		cbxSinavTuru.setSize("153px", "24px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLSinavTanimlama> selectionModel = new SingleSelectionModel<XMLSinavTanimlama>();

			grdSinavTanimlama.setSelectionModel(selectionModel);
			grdSinavTanimlama.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLSinavTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column.setFieldUpdater(new FieldUpdater<XMLSinavTanimlama, String>() {

				@Override
				public void update(int index, XMLSinavTanimlama object,
						String value) {

					XMLSinavTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});

			column_1.setFieldUpdater(new FieldUpdater<XMLSinavTanimlama, String>() {

				@Override
				public void update(int index, XMLSinavTanimlama object,
						String value) {
					XMLSinavTanimlama selected = selectionModel
							.getSelectedObject();

					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase
									+ "putsinavtanimlama?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&sinav_no="
									+ object.sinav_no.toString();
							URLValue = URLValue + "&sinav_adi="
									+ object.sinav_adi.toString();
							URLValue = URLValue + "&tarih="
									+ object.tarih.toString();
							URLValue = URLValue + "&saat="
									+ object.saat.toString();
							URLValue = URLValue + "&dakika="
									+ object.dakika.toString();
							URLValue = URLValue + "&son_kitapcik_no="
									+ object.son_kitapcik_no.toString();
							URLValue = URLValue + "&sablon_seciniz="
									+ object.sablon_seciniz.toString();
							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util().sendRequest(URLValue,
									"DERS BİLGİSİ KAYIT EDİLDİ",
									"DERS BİLGİSİ KAYIT EDİLEMEDİ");

						}

						putDataToGrid();
					}

					putDataToGrid();
				}
			});

		}// design time
	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getsinavtanimlama?id=" + id;

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

					List<XMLSinavTanimlama> listXmlSinavTanimlama = XMLSinavTanimlama.XML
							.readList(response.getText());

					_dlgSinavTanimlama = new DlgSinavTanimlama(false, new Long(
							id).longValue());
					_dlgSinavTanimlama.putDataFromXML(listXmlSinavTanimlama
							.get(0));
					_dlgSinavTanimlama.setAnimationEnabled(true);
					_dlgSinavTanimlama.center();
					_dlgSinavTanimlama
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
				+ "getsinavtanimlama?kayit_silinsin_mi=FALSE";

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

					List<XMLSinavTanimlama> listXmlSinavTanimlama = XMLSinavTanimlama.XML
							.readList(response.getText());

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdSinavTanimlama.setRowCount(1, true);

					// Push the data into the widget.
					grdSinavTanimlama.setRowData(0, listXmlSinavTanimlama);

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
			_dlgSinavTanimlama = new DlgSinavTanimlama(true, -1);
			_dlgSinavTanimlama.center();
			_dlgSinavTanimlama.setAnimationEnabled(true);

			_dlgSinavTanimlama.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});
		}

	}
}
