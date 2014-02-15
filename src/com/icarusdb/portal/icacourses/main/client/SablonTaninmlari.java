package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

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
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class SablonTaninmlari extends Composite {
	private TextColumn<XMLSablonTanimlari> grdcSablon;
	private CellTable<XMLSablonTanimlari> grdSablonTanimlari;
	private TextColumn<XMLSablonTanimlari> grdcIslemler;
	private TextBox tctSablonAdi;
	private DlgSablonTanimlari _dlgDlgSablonTanimlari;

	public SablonTaninmlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "403px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel.add(verticalPanel, 0, 0);
		verticalPanel.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_2.setStyleName("gwt-LabelMor2");
		verticalPanel.add(horizontalPanel_2);
		verticalPanel.setCellHeight(horizontalPanel_2, "50");
		horizontalPanel_2.setSize("100%", "33px");

		Label lblSablonTanmlar = new Label("Şablon Tanımları");
		horizontalPanel_2.add(lblSablonTanmlar);
		lblSablonTanmlar.setWidth("100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(15);
		verticalPanel.add(horizontalPanel_1);
		verticalPanel.setCellHeight(horizontalPanel_1, "30");
		horizontalPanel_1
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setSize("100%", "21px");

		Label label = new Label("Şablon Adı");
		horizontalPanel_1.add(label);
		horizontalPanel_1.setCellWidth(label, "10");
		label.setStyleName("gwt-Bold");
		label.setSize("81px", "16px");

		tctSablonAdi = new TextBox();
		horizontalPanel_1.add(tctSablonAdi);
		tctSablonAdi.setStyleName("gwt-ComboBox1");
		tctSablonAdi.setSize("140px", "16px");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_3.setSpacing(15);
		verticalPanel.add(horizontalPanel_3);
		verticalPanel.setCellHeight(horizontalPanel_3, "30");
		horizontalPanel_3.setWidth("100%");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		horizontalPanel_3.add(btnYeniKayit);
		btnYeniKayit.setText("Yeni Kayit");
		btnYeniKayit.setStyleName("gwt-YeniKayit2");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setSize("115px", "30px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setSize("100%", "156px");

		grdSablonTanimlari = new CellTable<XMLSablonTanimlari>();
		horizontalPanel.add(grdSablonTanimlari);
		grdSablonTanimlari.setSize("100%", "100%");

		TextColumn<XMLSablonTanimlari> textColumn = new TextColumn<XMLSablonTanimlari>() {
			@Override
			public String getValue(XMLSablonTanimlari object) {
				return object.id.toString();
			}
		};
		grdSablonTanimlari.addColumn(textColumn, "İD");
		grdSablonTanimlari.setColumnWidth(textColumn, "51px");

		Column<XMLSablonTanimlari, String> grdcSablon_1 = new TextColumn<XMLSablonTanimlari>() {
			@Override
			public String getValue(XMLSablonTanimlari object) {
				return object.sablon_adi.toString();
			}
		};

		grdSablonTanimlari.addColumn(grdcSablon_1, "Şablon Adı");
		Column<XMLSablonTanimlari, String> grdcIslemler_1 = new TextColumn<XMLSablonTanimlari>() {
			@Override
			public String getValue(XMLSablonTanimlari object) {
				return "İşlemler";
			}
		};
		grdSablonTanimlari.addColumn(grdcIslemler_1, "İşlemler");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLSablonTanimlari> selectionModel = new SingleSelectionModel<XMLSablonTanimlari>();

			grdSablonTanimlari.setSelectionModel(selectionModel);
			grdSablonTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLSablonTanimlari selected = selectionModel
							.getSelectedObject();
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

		String urlWithParameters = Util.urlBase + "getsablontanimlari?id=" + id;

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

					List<XMLSablonTanimlari> listXmlSablonTanimlari = XMLSablonTanimlari.XML
							.readList(response.getText());

					_dlgDlgSablonTanimlari = new DlgSablonTanimlari(false,
							new Long(id).longValue());
					_dlgDlgSablonTanimlari
							.putDataFromXML(listXmlSablonTanimlari.get(0));
					_dlgDlgSablonTanimlari.setAnimationEnabled(true);
					_dlgDlgSablonTanimlari.center();

					_dlgDlgSablonTanimlari
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

	}

	private boolean isDesignTime() {

		return false;
	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			_dlgDlgSablonTanimlari = new DlgSablonTanimlari(true, -1);
			_dlgDlgSablonTanimlari.center();
			_dlgDlgSablonTanimlari.setAnimationEnabled(true);

			_dlgDlgSablonTanimlari
					.addCloseHandler(new CloseHandler<PopupPanel>() {

						@Override
						public void onClose(CloseEvent<PopupPanel> event) {

							putDataToGrid();

						}
					});
		}

	}
}
