package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
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
		verticalPanel.setSize("488px", "366px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		verticalPanel.add(absolutePanel);
		absolutePanel.setSize("755px", "472px");

		Label lblAranacakAnahtarKelime = new Label("Aranacak Anahtar Kelime");
		lblAranacakAnahtarKelime.setStyleName("gwt-Bold");
		absolutePanel.add(lblAranacakAnahtarKelime, 37, 38);
		lblAranacakAnahtarKelime.setSize("156px", "16px");

		tctAranacakAnahtarKelime = new TextBox();
		tctAranacakAnahtarKelime.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAranacakAnahtarKelime, 207, 31);
		tctAranacakAnahtarKelime.setSize("239px", "19px");

		grdOgrenciKayitlari = new CellTable<XMLOnKayit>();
		absolutePanel.add(grdOgrenciKayitlari, 10, 97);
		grdOgrenciKayitlari.setSize("100%", "154px");

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

		Column<XMLOnKayit, String> column = new Column<XMLOnKayit, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLOnKayit object) {
				return "Düzenle";
			}
		};
		grdOgrenciKayitlari.addColumn(column, "İşlemler");

		Button btnNewButton = new Button("");
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		btnNewButton.setStyleName("gwt-ButtonAra");
		absolutePanel.add(btnNewButton, 608, 10);
		btnNewButton.setSize("93px", "61px");

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

	private class BtnNewButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String urlWithParameters = Util.urlBase + "getonkayit"
					+ "?adi_soyadi_tc_kimlik_no="
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

								// Set the total row count. This isn't strictly
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
