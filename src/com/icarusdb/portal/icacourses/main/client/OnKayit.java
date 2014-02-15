package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.ImageResourceCell;
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
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.resources.client.ClientBundle;
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
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.CellPreviewEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;

public class OnKayit extends Composite {
	private CellTable<XMLOnKayit> grdOnKayit;
	private DlgOnKayit _dlgOnKayit;
	private TextBox tctAranacakAnahtarKelime;
	private CheckBox chxSilinmisKayitlariGoster;

	public OnKayit() {

		final Resources resources = GWT.create(Resources.class);

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "750px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "50px");
		horizontalPanel_1
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setStyleName("gwt-LabelMor2");
		horizontalPanel_1.setSize("100%", "33px");

		Label lblOnKayt = new Label("Ön Kayıt");
		horizontalPanel_1.add(lblOnKayt);
		lblOnKayt.setWidth("100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "24px");
		horizontalPanel_2.setWidth("100%");

		tctAranacakAnahtarKelime = new TextBox();
		tctAranacakAnahtarKelime
				.addKeyDownHandler(new TctAranacakAnahtarKelimeKeyDownHandler());
		tctAranacakAnahtarKelime
				.addFocusHandler(new TctAranacakAnahtarKelimeFocusHandler());
		tctAranacakAnahtarKelime.setText("Ne Aramıştınız?");
		horizontalPanel_2.add(tctAranacakAnahtarKelime);

		tctAranacakAnahtarKelime.setStyleName("gwt-TextBoxAra");
		tctAranacakAnahtarKelime.setSize("200px", "17px");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_3
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(horizontalPanel_3);
		verticalPanel.setCellHeight(horizontalPanel_3, "20px");
		horizontalPanel_3.setSize("100%", "");

		chxSilinmisKayitlariGoster = new CheckBox("New check box");
		horizontalPanel_3.add(chxSilinmisKayitlariGoster);
		chxSilinmisKayitlariGoster
				.addClickHandler(new ChxSilinmisKayitlariGosterClickHandler());
		chxSilinmisKayitlariGoster.setHTML("Silinmiş Kayıtları Göster");
		chxSilinmisKayitlariGoster.setSize("202px", "19px");

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		horizontalPanel_4.setSpacing(15);
		verticalPanel.add(horizontalPanel_4);
		verticalPanel.setCellHeight(horizontalPanel_4, "30px");
		horizontalPanel_4.setWidth("100%");

		Button btnYeniKayit = new Button("Yeni Kayit");
		horizontalPanel_4.add(btnYeniKayit);
		btnYeniKayit.setText("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "156px");

		grdOnKayit = new CellTable<XMLOnKayit>();
		grdOnKayit.addCellPreviewHandler(new GrdOnKayitHandler());
		horizontalPanel.add(grdOnKayit);
		grdOnKayit.setSize("100%", "100%");

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

		Column<XMLOnKayit, ImageResource> imageColumn = new Column<XMLOnKayit, ImageResource>(
				new ImageResourceCell()) {
			@Override
			public ImageResource getValue(XMLOnKayit object) {
				return resources.getImageResource();
			}
		};

		grdOnKayit.addColumn(imageColumn, "Düzenle");

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

	private class TctAranacakAnahtarKelimeKeyDownHandler implements
			KeyDownHandler {
		public void onKeyDown(KeyDownEvent event) {

			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				// do something
				String urlWithParameters = Util.urlBase
						+ "getonkayit?kayit_silinsin_mi=FALSE"
						+ "&adi_soyadi_tc_kimlik_no="
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

	private class TctAranacakAnahtarKelimeFocusHandler implements FocusHandler {
		public void onFocus(FocusEvent event) {

			tctAranacakAnahtarKelime.setText(tctAranacakAnahtarKelime.getText()
					.replace("Ne Aramıştınız?", ""));
		}
	}
}

interface Resources extends ClientBundle {
	@Source("duzenle.png")
	ImageResource getImageResource();

}
