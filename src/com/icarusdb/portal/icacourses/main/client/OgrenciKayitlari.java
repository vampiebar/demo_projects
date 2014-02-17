package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class OgrenciKayitlari extends Composite {
	private TextBox tctAranacakAnahtarKelime;
	private CellTable<XMLOnKayit> grdOgrenciKayitlari;

	public OgrenciKayitlari() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_2.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "50");
		horizontalPanel_2.setSize("100%", "33px");

		Label lblrenciKaytlar = new Label("Öğrenci Kayıtları");
		horizontalPanel_2.add(lblrenciKaytlar);
		lblrenciKaytlar.setWidth("100%");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(15);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHeight(horizontalPanel, "30");
		horizontalPanel.setSize("100%", "19px");

		tctAranacakAnahtarKelime = new TextBox();
		tctAranacakAnahtarKelime
				.addKeyDownHandler(new TctAranacakAnahtarKelimeKeyDownHandler());
		tctAranacakAnahtarKelime
				.addFocusHandler(new TctAranacakAnahtarKelimeFocusHandler());
		tctAranacakAnahtarKelime.setText("Ne Aramıştınız?");
		horizontalPanel.add(tctAranacakAnahtarKelime);
		horizontalPanel.setCellHeight(tctAranacakAnahtarKelime, "30");
		tctAranacakAnahtarKelime.setStyleName("gwt-TextBoxAra");
		tctAranacakAnahtarKelime.setSize("239px", "19px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(10);
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("100%", "100px");

		grdOgrenciKayitlari = new CellTable<XMLOnKayit>();
		horizontalPanel_1.add(grdOgrenciKayitlari);
		grdOgrenciKayitlari.setSize("100%", "100%");

		TextColumn<XMLOnKayit> textColumn_2 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.id.toString();
			}
		};
		grdOgrenciKayitlari.addColumn(textColumn_2, "İD");
		grdOgrenciKayitlari.setColumnWidth(textColumn_2, "41px");

		TextColumn<XMLOnKayit> textColumn_1 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.adi.toString();
			}
		};
		grdOgrenciKayitlari.addColumn(textColumn_1, "Adı");

		TextColumn<XMLOnKayit> textColumn = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.soyadi.toString();
			}
		};
		grdOgrenciKayitlari.addColumn(textColumn, "Soyadı");

		TextColumn<XMLOnKayit> textColumn_3 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.tc_kimlik_no.toString();
			}
		};
		grdOgrenciKayitlari.addColumn(textColumn_3, "TC Kimlik No");

		Column<XMLOnKayit, String> column = new Column<XMLOnKayit, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLOnKayit object) {
				return "Düzenle";
			}
		};
		grdOgrenciKayitlari.addColumn(column, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLOnKayit> selectionModel = new SingleSelectionModel<XMLOnKayit>();

			grdOgrenciKayitlari.setSelectionModel(selectionModel);
			grdOgrenciKayitlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLOnKayit selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

		}

	}

	private boolean isDesignTime() {

		return false;
	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase + "getonkayit"
				+ "?kesin_kayit_mi=TRUE";

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

					// Window.alert("AAABBBCCC " +
					// response.getText());

					List<XMLOnKayit> listXmlOnKayit = XMLOnKayit.XML
							.readList(response.getText());

					// listXmlOnKayit.add(xmlOnKayit);

					// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdOgrenciKayitlari.setRowCount(1, true);

					// Push the data into the widget.
					grdOgrenciKayitlari.setRowData(0, listXmlOnKayit);

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getonkayit?id=" + id;

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

					List<XMLOnKayit> listXmlOnKayit = XMLOnKayit.XML
							.readList(response.getText());

					DlgOgrenciKayitlari dlgTemp = new DlgOgrenciKayitlari(
							false, new Long(id).longValue());
					dlgTemp.putDataFromXML(listXmlOnKayit.get(0));
					dlgTemp.tabOgrenciIsleri.selectTab(0);
					dlgTemp.setAnimationEnabled(true);
					dlgTemp.center();

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private class TctAranacakAnahtarKelimeFocusHandler implements FocusHandler {
		public void onFocus(FocusEvent event) {

			tctAranacakAnahtarKelime.setText(tctAranacakAnahtarKelime.getText()
					.replace("Ne Aramıştınız?", ""));
		}
	}

	private class TctAranacakAnahtarKelimeKeyDownHandler implements
			KeyDownHandler {
		public void onKeyDown(KeyDownEvent event) {

			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				// do something
				String urlWithParameters = Util.urlBase
						+ "getonkayit?kayit_silinsin_mi=FALSE"
						+ "&kesin_kayit_mi=TRUE" + "&adi_soyadi_tc_kimlik_no="
						+ tctAranacakAnahtarKelime.getText();

				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
						urlWithParameters);

				// Window.alert("URL TO GET VALUES: " + urlWithParameters);

				try {
					Request request = builder.sendRequest(null,
							new RequestCallback() {
								public void onError(Request request,
										Throwable exception) {

								}

								@Override
								public void onResponseReceived(Request request,
										Response response) {

									// Window.alert("AAABBBCCC " +
									// response.getText());

									List<XMLOnKayit> listXmlOnKayit = XMLOnKayit.XML
											.readList(response.getText());

									// listXmlOnKayit.add(xmlOnKayit);

									// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

									// Set the total row count. This isn't
									// strictly
									// necessary, but it affects
									// paging calculations, so its good habit to
									// keep the row count up to date.
									grdOgrenciKayitlari.setRowCount(1, true);

									// Push the data into the widget.
									grdOgrenciKayitlari.setRowData(0,
											listXmlOnKayit);

								}

							});

				} catch (RequestException e) {
					// displayError("Couldn't retrieve JSON");

					// Window.alert(e.getMessage() + "ERROR");
				}
			}
		}

	}
}
