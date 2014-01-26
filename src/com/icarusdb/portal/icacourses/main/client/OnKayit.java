package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.CellPreviewEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;

public class OnKayit extends Composite {
	private CellTable<XMLOnKayit> grdOnKayit;
	private DlgOnKayit _dlgOnKayit;
	private TextBox tctAranacakAnahtarKelime;
	private CheckBox chxSilinmisKayitlariGoster;

	public OnKayit() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("900px", "750px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 136);
		horizontalPanel.setSize("727px", "156px");

		grdOnKayit = new CellTable<XMLOnKayit>();
		grdOnKayit.addCellPreviewHandler(new GrdOnKayitHandler());
		horizontalPanel.add(grdOnKayit);
		grdOnKayit.setSize("890px", "156px");

		TextColumn<XMLOnKayit> textColumn_4 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.id.toString();
			}
		};
		grdOnKayit.addColumn(textColumn_4, "K.No");
		grdOnKayit.setColumnWidth(textColumn_4, "51px");

		TextColumn<XMLOnKayit> textColumn_1 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.adi.toString();
			}
		};
		grdOnKayit.addColumn(textColumn_1, "Adı");

		TextColumn<XMLOnKayit> textColumn = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.soyadi.toString();
			}
		};
		grdOnKayit.addColumn(textColumn, "Soyadı");

		TextColumn<XMLOnKayit> textColumn_3 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.tc_kimlik_no.toString();
			}
		};
		grdOnKayit.addColumn(textColumn_3, "Tc Kimlik No");

		Column<XMLOnKayit, Boolean> column = new Column<XMLOnKayit, Boolean>(
				new CheckboxCell()) {
			@Override
			public Boolean getValue(XMLOnKayit object) {
				return object.kesin_kayit_mi.equalsIgnoreCase("t") ? true
						: false;
			}
		};
		grdOnKayit.addColumn(column, "Kesin Kayit Mı?");

		Column<XMLOnKayit, String> column_1 = new Column<XMLOnKayit, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLOnKayit object) {
				return "Düzenle";
			}
		};
		grdOnKayit.addColumn(column_1, "İşlemler");

		Button btnYeniKayit = new Button("Yeni Kayit");
		btnYeniKayit.setText("");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 607, 51);
		btnYeniKayit.setSize("90px", "65px");

		Label lblAd = new Label("Aranacak Anahtar Kelime");
		lblAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblAd, 10, 30);
		lblAd.setSize("177px", "16px");

		tctAranacakAnahtarKelime = new TextBox();

		tctAranacakAnahtarKelime.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAranacakAnahtarKelime, 191, 30);
		tctAranacakAnahtarKelime.setSize("200px", "17px");

		Button btnAra = new Button("Ara");
		btnAra.setText("");
		btnAra.addClickHandler(new BtnAraClickHandler());
		btnAra.setStyleName("gwt-ButtonAra");
		absolutePanel.add(btnAra, 506, 51);
		btnAra.setSize("90px", "65px");

		chxSilinmisKayitlariGoster = new CheckBox("New check box");
		chxSilinmisKayitlariGoster
				.addClickHandler(new ChxSilinmisKayitlariGosterClickHandler());
		chxSilinmisKayitlariGoster.setHTML("Silinmiş Kayıtları Goster");
		absolutePanel.add(chxSilinmisKayitlariGoster, 191, 66);
		chxSilinmisKayitlariGoster.setSize("202px", "19px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLOnKayit> selectionModel = new SingleSelectionModel<XMLOnKayit>();

			grdOnKayit.setSelectionModel(selectionModel);
			grdOnKayit.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLOnKayit selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						// Window.alert("selected tc: " +
						// selected.tc_kimlik_no);

						showWithData(selected.id);
						showWithData(selected.tc_kimlik_no);

					}

				}
			}, DoubleClickEvent.getType());
			column_1.setFieldUpdater(new FieldUpdater<XMLOnKayit, String>() {

				@Override
				public void update(int index, XMLOnKayit object, String value) {

					XMLOnKayit selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});
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

					_dlgOnKayit = new DlgOnKayit(false, new Long(id)
							.longValue());
					_dlgOnKayit.putDataFromXML(listXmlOnKayit.get(0));
					_dlgOnKayit.tabOnKayit.selectTab(0);
					_dlgOnKayit.setAnimationEnabled(true);
					_dlgOnKayit.center();
					_dlgOnKayit.addCloseHandler(new CloseHandler<PopupPanel>() {

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
				+ "getonkayit?kayit_silinsin_mi=FALSE";

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

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdOnKayit.setRowCount(1, true);

					// Push the data into the widget.
					grdOnKayit.setRowData(0, listXmlOnKayit);

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

			_dlgOnKayit = new DlgOnKayit(true, -1);
			_dlgOnKayit.center();
			_dlgOnKayit.setAnimationEnabled(true);
			_dlgOnKayit.tabOnKayit.selectTab(0);

			_dlgOnKayit.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

		}
	}

	private class GrdOnKayitHandler implements Handler<XMLOnKayit> {
		public void onCellPreview(CellPreviewEvent<XMLOnKayit> event) {

			// boolean isClick =
			// "click".equals(event.getNativeEvent().getType());

			// Window.alert("Click : " + event.getNativeEvent().getType());

		}
	}

	private class BtnAraClickHandler implements ClickHandler {
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
								grdOnKayit.setRowCount(1, true);

								// Push the data into the widget.
								grdOnKayit.setRowData(0, listXmlOnKayit);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}

	private class ChxSilinmisKayitlariGosterClickHandler implements
			ClickHandler {
		public void onClick(ClickEvent event) {
			if (chxSilinmisKayitlariGoster.getValue() == true) {

				String urlWithParameters = Util.urlBase
						+ "getonkayit?kayit_silinsin_mi=TRUE";

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

									// Window.alert("gun: " +
									// listXmlSaatGirisi.get(0).gun);

									// Set the total row count. This isn't
									// strictly
									// necessary, but it affects
									// paging calculations, so its good habit to
									// keep the row count up to date.
									grdOnKayit.setRowCount(1, true);

									// Push the data into the widget.
									grdOnKayit.setRowData(0, listXmlOnKayit);

								}

							});

				} catch (RequestException e) {
					// displayError("Couldn't retrieve JSON");

					// Window.alert(e.getMessage() + "ERROR");
				}
			}

			else {

				String urlWithParameters = Util.urlBase
						+ "getonkayit?kayit_silinsin_mi=FALSE";

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

									// Window.alert("gun: " +
									// listXmlSaatGirisi.get(0).gun);

									// Set the total row count. This isn't
									// strictly
									// necessary, but it affects
									// paging calculations, so its good habit to
									// keep the row count up to date.
									grdOnKayit.setRowCount(1, true);

									// Push the data into the widget.
									grdOnKayit.setRowData(0, listXmlOnKayit);

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
