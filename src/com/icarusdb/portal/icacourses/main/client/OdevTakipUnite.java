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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class OdevTakipUnite extends Composite {
	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private ListBox cbxDersAdi;
	private CellTable<XMLOdevTakipUnite> grdOdevTakipUnite;
	private TextColumn<XMLOdevTakipUnite> grdcEgitimTuruAdi;
	private TextColumn<XMLOdevTakipUnite> grdcalanAdi;
	private TextColumn<XMLOdevTakipUnite> grdcDersAdi;
	private TextColumn<XMLOdevTakipUnite> grdcUniteAdi;
	private Column<XMLOdevTakipUnite, String> column;

	private DlgOdevTakipUnite _dlgOdevTakipUnite;
	private Column<XMLOdevTakipUnite, String> column_1;

	public OdevTakipUnite() {

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
		verticalPanel.setCellHeight(horizontalPanel_2, "40");
		horizontalPanel_2.setSize("100%", "33px");

		Label lbldevTakipnite = new Label("Ödev Takip Ünite");
		horizontalPanel_2.add(lbldevTakipnite);
		lbldevTakipnite.setWidth("100%");

		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		verticalPanel.setCellHeight(flexTable, "30");
		flexTable.setSize("100px", "100px");

		Label label = new Label("Eğitim Türü");
		flexTable.setWidget(0, 0, label);
		label.setStyleName("gwt-Bold");
		label.setSize("100px", "16px");

		cbxEgitimTuru = new ListBox();
		flexTable.setWidget(0, 1, cbxEgitimTuru);
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.addItem("YGS HAZIRLIK");
		cbxEgitimTuru.addItem("YGS/LYS HAZIRLIK");
		cbxEgitimTuru.addItem("11.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("10.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("9.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("SBS HAZIRLIK");
		cbxEgitimTuru.addItem("8.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("7.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("6.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("5.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("4.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("3.SINIF TAKVİYE");
		cbxEgitimTuru.setSize("139px", "25px");

		Label label_1 = new Label("Alan");
		flexTable.setWidget(1, 0, label_1);
		label_1.setStyleName("gwt-Bold");
		label_1.setSize("56px", "16px");

		cbxAlan = new ListBox();
		flexTable.setWidget(1, 1, cbxAlan);
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem(" ");
		cbxAlan.addItem("Lütfen Seçiniz");
		cbxAlan.addItem("ALAN YOK");
		cbxAlan.setSize("139px", "25px");

		Label label_2 = new Label("Ders Adı");
		flexTable.setWidget(2, 0, label_2);
		label_2.setStyleName("gwt-Bold");
		label_2.setSize("100px", "16px");

		cbxDersAdi = new ListBox();
		flexTable.setWidget(2, 1, cbxDersAdi);
		cbxDersAdi.setStyleName("gwt-ComboBox1");
		cbxDersAdi.addItem("Lütfen Seçiniz");
		cbxDersAdi.setSize("139px", "25px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1.setSpacing(15);
		horizontalPanel_1.setSize("100%", "27px");

		Button btnYeniKayit = new Button("ARA");
		horizontalPanel_1.add(btnYeniKayit);
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.setText("Yeni Kayıt");
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "309px");

		grdOdevTakipUnite = new CellTable<XMLOdevTakipUnite>();
		horizontalPanel.add(grdOdevTakipUnite);
		grdOdevTakipUnite.setSize("100%", "100%");

		grdcEgitimTuruAdi = new TextColumn<XMLOdevTakipUnite>() {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return object.egitim_turu.toString();
			}
		};
		grdOdevTakipUnite.addColumn(grdcEgitimTuruAdi, "Eğitim Türü Adı");

		grdcalanAdi = new TextColumn<XMLOdevTakipUnite>() {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return object.alan.toString();
			}
		};
		grdOdevTakipUnite.addColumn(grdcalanAdi, "Alan Adı");

		grdcDersAdi = new TextColumn<XMLOdevTakipUnite>() {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return object.ders.toString();
			}
		};
		grdOdevTakipUnite.addColumn(grdcDersAdi, "Ders Adı");

		grdcUniteAdi = new TextColumn<XMLOdevTakipUnite>() {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return object.unite.toString();
			}
		};
		grdOdevTakipUnite.addColumn(grdcUniteAdi, "Ünite Adı");

		column = new Column<XMLOdevTakipUnite, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return "Düzenle";
			}
		};
		grdOdevTakipUnite.addColumn(column, "Düzenle");

		column_1 = new Column<XMLOdevTakipUnite, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return "Sil";
			}
		};
		grdOdevTakipUnite.addColumn(column_1, "Sil");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLOdevTakipUnite> selectionModel = new SingleSelectionModel<XMLOdevTakipUnite>();

			grdOdevTakipUnite.setSelectionModel(selectionModel);
			grdOdevTakipUnite.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLOdevTakipUnite selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);
						column.setFieldUpdater(new FieldUpdater<XMLOdevTakipUnite, String>() {

							@Override
							public void update(int index,
									XMLOdevTakipUnite object, String value) {

								XMLOdevTakipUnite selected = selectionModel
										.getSelectedObject();
								if (selected != null) {
									// DO YOUR STUFF

									// Window.alert("selected id: " +
									// selected.id);
									showWithData(selected.id);

								}

							}
						});

						column_1.setFieldUpdater(new FieldUpdater<XMLOdevTakipUnite, String>() {

							@Override
							public void update(int index,
									XMLOdevTakipUnite object, String value) {
								XMLOdevTakipUnite selected = selectionModel
										.getSelectedObject();

								Boolean x = Window
										.confirm("Kayit Silinecektir, Emin Misiniz?");

								if (x == true) {

									if (selected != null) {
										// DO YOUR STUFF

										// Window.alert("selected id: " +
										// selected.id);
										// showWithData(selected.id);

										String URLValue = Util.urlBase
												+ "putodevtakipunite?";

										URLValue = URLValue + "id="
												+ selected.id;

										URLValue = URLValue + "&egitim_turu="
												+ object.egitim_turu.toString();
										URLValue = URLValue + "&alan="
												+ object.alan.toString();
										URLValue = URLValue + "&ders="
												+ object.ders.toString();
										URLValue = URLValue + "&unite="
												+ object.unite.toString();

										URLValue = URLValue
												+ "&kayit_silinsin_mi=TRUE";

										// Window.alert(URLValue);

										new Util().sendRequest(URLValue,
												"DERS BİLGİSİ KAYIT EDİLDİ",
												"DERS BİLGİSİ KAYIT EDİLEMEDİ");

									}

									// putDataToGrid();
								}

							}
						});

					}// design time
				}

				protected void showWithData(final String id) {

					String urlWithParameters = Util.urlBase
							+ "getodevtakipunite?id=" + id;

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

										List<XMLOdevTakipUnite> listXmlOdevTakipUnite = XMLOdevTakipUnite.XML
												.readList(response.getText());

										_dlgOdevTakipUnite = new DlgOdevTakipUnite(
												false, new Long(id).longValue());
										_dlgOdevTakipUnite
												.putDataFromXML(listXmlOdevTakipUnite
														.get(0));
										_dlgOdevTakipUnite
												.setAnimationEnabled(true);
										_dlgOdevTakipUnite.center();
										_dlgOdevTakipUnite
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

		String urlWithParameters = Util.urlBase
				+ "getodevtakipunite?kayit_silinsin_mi=FALSE";

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

					List<XMLOdevTakipUnite> listXmlOdevTakipUnite = XMLOdevTakipUnite.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdOdevTakipUnite.setRowCount(1, true);

					// Push the data into the widget.
					grdOdevTakipUnite.setRowData(0, listXmlOdevTakipUnite);

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
			_dlgOdevTakipUnite = new DlgOdevTakipUnite(true, -1);
			_dlgOdevTakipUnite.center();
			_dlgOdevTakipUnite.setAnimationEnabled(true);

			_dlgOdevTakipUnite.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});
		}
	}
}

// private class ButtonClickHandler implements ClickHandler {
// public void onClick(ClickEvent event) {
//
// String urlWithParameters = Util.urlBase + "getodevtakipunite"
// + "?egitim_turu=" + cbxEgitimTuru.getSelectedIndex();
//
// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
// urlWithParameters);
// // Window.alert("URL TO GET VALUES: " + urlWithParameters);
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
// // Window.alert("AAABBBCCC " +
// // response.getText());
//
// List<XMLOdevTakipUnite> listXmlOdevTakipUnite = XMLOdevTakipUnite.XML
// .readList(response.getText());
//
// // XMLOdevTakipUnite xmlOdevTakipUnite =
// // XMLOdevTakipUnite.XML
// // .read(response.getText());
//
// // lblNewLabel.setText(listxmlOdevTakipUnite
// // .get(0).egitim_turu);
//
// grdOdevTakipUnite.setRowCount(1, true);
//
// // Push the data into the widget.
// grdOdevTakipUnite.setRowData(0,
// listXmlOdevTakipUnite);
// }
//
// });
//
// } catch (RequestException e) {
// // displayError("Couldn't retrieve JSON");
//
// // Window.alert(e.getMessage() + "ERROR");
// }
//
// }
// }

