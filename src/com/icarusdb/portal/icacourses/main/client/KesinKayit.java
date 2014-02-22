package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class KesinKayit extends Composite {
	private TextBox tctAranacakAnahtarKelime;
	private CellTable<XMLOnKayit> grdKesinKayit;
	private Column<XMLOnKayit, ?> grdcAdi;
	private Column<XMLOnKayit, ?> grdcSoyadi;
	private CheckBox chxSilinmisKayitlariGoster;

	public KesinKayit() {

		final Resources resources = GWT.create(Resources.class);

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "750px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_3
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_3.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_3);
		verticalPanel.setCellHeight(horizontalPanel_3, "50");
		horizontalPanel_3.setSize("100%", "33px");

		Label lblKesinKayt = new Label("Kesin Kayıt");
		horizontalPanel_3.add(lblKesinKayt);
		lblKesinKayt.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "24");
		horizontalPanel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel_1.setSize("100%", "23px");

		tctAranacakAnahtarKelime = new TextBox();

		tctAranacakAnahtarKelime
				.addKeyDownHandler(new TctAranacakAnahtarKelimeKeyDownHandler());
		tctAranacakAnahtarKelime
				.addFocusHandler(new TctAranacakAnahtarKelimeFocusHandler());
		tctAranacakAnahtarKelime.setText("Ne Aramıştınız?");
		horizontalPanel_1.add(tctAranacakAnahtarKelime);
		tctAranacakAnahtarKelime.setStyleName("gwt-TextBoxAra");
		tctAranacakAnahtarKelime.setSize("200px", "17px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "20px");
		horizontalPanel_2
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel_2.setSize("100%", "20px");

		chxSilinmisKayitlariGoster = new CheckBox("Silinmiş Kayitlari Göster");
		chxSilinmisKayitlariGoster
				.addClickHandler(new ChxSilinmisKayitlariGosterClickHandler());
		horizontalPanel_2.add(chxSilinmisKayitlariGoster);

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		horizontalPanel_4.setSpacing(15);
		verticalPanel.add(horizontalPanel_4);
		verticalPanel.setCellHeight(horizontalPanel_4, "30");
		horizontalPanel_4.setWidth("100%");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_4.add(btnYeniKayit);
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "104px");

		grdKesinKayit = new CellTable<XMLOnKayit>();

		horizontalPanel.add(grdKesinKayit);
		grdKesinKayit.setSize("100%", "100%");

		grdcAdi = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.adi.toString();
			}
		};
		grdKesinKayit.addColumn(grdcAdi, "Adı");
		grdKesinKayit.setColumnWidth(grdcAdi, "124px");

		grdcSoyadi = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.soyadi.toString();
			}
		};
		grdKesinKayit.addColumn(grdcSoyadi, "Soyadı");
		grdKesinKayit.setColumnWidth(grdcSoyadi, "106px");

		Column<XMLOnKayit, ?> column_5 = new TextColumn<XMLOnKayit>() {

			@Override
			public String getValue(XMLOnKayit object) {
				return (object.tc_kimlik_no);
			}
		};
		grdKesinKayit.addColumn(column_5, "TC Kimlik No");
		grdKesinKayit.setColumnWidth(column_5, "156px");

		Column<XMLOnKayit, ?> textColumn = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return object.gorusme_egitim_turu.toString();
			}
		};
		grdKesinKayit.addColumn(textColumn, "Eğitim Türü");
		grdKesinKayit.setColumnWidth(textColumn, "132px");

		Column<XMLOnKayit, ?> textColumn_3 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {

				if (object.sinif != null) {
					return object.sinif.toString();

				}
				return "";
			}
		};
		grdKesinKayit.addColumn(textColumn_3, "Sınıf Adı");
		grdKesinKayit.setColumnWidth(textColumn_3, "177px");

		Column<XMLOnKayit, ?> column_1 = new Column<XMLOnKayit, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(XMLOnKayit object) {
				return (Number) null;
			}
		};
		grdKesinKayit.addColumn(column_1, "Öğrenci D. No");
		grdKesinKayit.setColumnWidth(column_1, "154px");

		Column<XMLOnKayit, ?> column_2 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return (object.cep_telefonu);
			}
		};
		grdKesinKayit.addColumn(column_2, "Cep Tel.");
		grdKesinKayit.setColumnWidth(column_2, "155px");

		Column<XMLOnKayit, ?> textColumn_4 = new TextColumn<XMLOnKayit>() {
			@Override
			public String getValue(XMLOnKayit object) {
				return "???";
			}
		};
		grdKesinKayit.addColumn(textColumn_4, "Durum");
		grdKesinKayit.setColumnWidth(textColumn_4, "98px");

		Column<XMLOnKayit, ?> column_3 = new Column<XMLOnKayit, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLOnKayit object) {
				return (String) null;
			}
		};
		grdKesinKayit.addColumn(column_3, "Şifre Sıfırla");
		grdKesinKayit.setColumnWidth(column_3, "101px");

		Column<XMLOnKayit, ImageResource> imageColumn = new Column<XMLOnKayit, ImageResource>(
				new ImageResourceCell()) {
			@Override
			public ImageResource getValue(XMLOnKayit object) {
				return resources.getImageResource();
			}
		};

		grdKesinKayit.addColumn(imageColumn, "Düzenle");
		grdKesinKayit.setColumnWidth(imageColumn, "125px");

		// private class BtnKaydetClickHandler implements ClickHandler {
		// public void onClick(ClickEvent event) {
		//
		// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
		// "http://localhost:9090/ICACoursesWS/jaxrs/genel/getkesinkayit");
		//
		// try {
		// Request request = builder.sendRequest(null,
		// new RequestCallback() {
		// public void onError(Request request,
		// Throwable exception) {
		//
		// }
		//
		// @Override
		// public void onResponseReceived(Request request,
		// Response response) {
		//
		// Window.alert(response.getText());
		//
		// }
		// });
		// } catch (RequestException e) {
		// // displayError("Couldn't retrieve JSON");
		//
		// Window.alert(e.getMessage() + "ERROR");
		// }
		// }
		// }

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLOnKayit> selectionModel = new SingleSelectionModel<XMLOnKayit>();

			grdKesinKayit.setSelectionModel(selectionModel);
			grdKesinKayit.addDomHandler(new DoubleClickHandler() {

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
			imageColumn
					.setFieldUpdater(new FieldUpdater<XMLOnKayit, ImageResource>() {

						@Override
						public void update(int index, XMLOnKayit object,
								ImageResource value) {

							XMLOnKayit selected = selectionModel
									.getSelectedObject();
							if (selected != null) {
								// DO YOUR STUFF

								// Window.alert("selected id: " + selected.id);
								showWithData(selected.id);

							}

						}
					});
		}

	}

	private boolean isDesignTime() {

		return false;
	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase + "getonkayit"
				+ "?kesin_kayit_mi=TRUE" + "&kayit_silinsin_mi=FALSE";

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
					grdKesinKayit.setRowCount(1, true);

					// Push the data into the widget.
					grdKesinKayit.setRowData(0, listXmlOnKayit);

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

					KesinKayitBilgileri dlgTemp = new KesinKayitBilgileri(
							false, new Long(id).longValue());
					dlgTemp.putDataFromXML(listXmlOnKayit.get(0));
					dlgTemp.tabKesinKayitBilgileri.selectTab(0);
					dlgTemp.setAnimationEnabled(true);
					dlgTemp.center();

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			DlgKesinKayitIslemleri dlgTemp = new DlgKesinKayitIslemleri(true,
					-1);
			dlgTemp.tabKesinKayitIslemleri.selectTab(0);
			dlgTemp.center();

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
									grdKesinKayit.setRowCount(1, true);

									// Push the data into the widget.
									grdKesinKayit.setRowData(0, listXmlOnKayit);

								}

							});

				} catch (RequestException e) {
					// displayError("Couldn't retrieve JSON");

					// Window.alert(e.getMessage() + "ERROR");
				}
			}
		}

	}

	private class ChxSilinmisKayitlariGosterClickHandler implements
			ClickHandler {
		public void onClick(ClickEvent event) {

			if (chxSilinmisKayitlariGoster.getValue() == true) {

				String urlWithParameters = Util.urlBase
						+ "getonkayit?kayit_silinsin_mi=TRUE"
						+ "&kesin_kayit_mi=TRUE";

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
									grdKesinKayit.setRowCount(1, true);

									// Push the data into the widget.
									grdKesinKayit.setRowData(0, listXmlOnKayit);

								}

							});

				} catch (RequestException e) {
					// displayError("Couldn't retrieve JSON");

					// Window.alert(e.getMessage() + "ERROR");
				}
			}

			else {

				String urlWithParameters = Util.urlBase
						+ "getonkayit?kayit_silinsin_mi=FALSE"
						+ "&kesin_kayit_mi=TRUE";

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
									grdKesinKayit.setRowCount(1, true);

									// Push the data into the widget.
									grdKesinKayit.setRowData(0, listXmlOnKayit);

								}

							});

				} catch (RequestException e) {
					// displayError("Couldn't retrieve JSON");

					// Window.alert(e.getMessage() + "ERROR");
				}
			}

		}
	}

	private class TctAranacakAnahtarKelimeFocusHandler implements FocusHandler {
		public void onFocus(FocusEvent event) {

			tctAranacakAnahtarKelime.setText(tctAranacakAnahtarKelime.getText()
					.replace("Ne Aramıştınız?", ""));

		}
	}

}
