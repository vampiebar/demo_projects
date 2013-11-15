package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.SingleSelectionModel;

public class SablonTaninmlari extends Composite {
	private TextColumn<XMLSablonTanimlari> grdcSablon;
	private CellTable<XMLSablonTanimlari> grdSablonTanimlari;
	private TextColumn<XMLSablonTanimlari> grdcIslemler;
	private TextBox tctSablonAdi;

	public SablonTaninmlari() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("785px", "403px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 23, 138);
		horizontalPanel.setSize("727px", "156px");

		grdSablonTanimlari = new CellTable<XMLSablonTanimlari>();
		horizontalPanel.add(grdSablonTanimlari);
		grdSablonTanimlari.setSize("737px", "124px");

		Column<XMLSablonTanimlari, String> grdcSablon = new TextColumn<XMLSablonTanimlari>() {
			@Override
			public String getValue(XMLSablonTanimlari object) {
				return object.sablon_adi.toString();
			}
		};

		grdSablonTanimlari.addColumn(grdcSablon, "Şablon Adı");
		Column<XMLSablonTanimlari, String> grdcIslemler = new TextColumn<XMLSablonTanimlari>() {
			@Override
			public String getValue(XMLSablonTanimlari object) {
				return "İşlemler";
			}
		};
		grdSablonTanimlari.addColumn(grdcIslemler, "İşlemler");

		Button btnAra = new Button("ARA");
		btnAra.setStyleName("gwt-ButonKapat");
		btnAra.addClickHandler(new BtnAraClickHandler());
		absolutePanel.add(btnAra, 494, 43);
		btnAra.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 591, 43);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 682, 43);
		btnExceleAktar.setSize("78px", "48px");

		Label label = new Label("Şablon Adı");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 35, 38);
		label.setSize("78px", "16px");

		tctSablonAdi = new TextBox();
		tctSablonAdi.setStyleName("gwt-ComboBox1");
		absolutePanel.add(tctSablonAdi, 137, 38);
		tctSablonAdi.setSize("140px", "16px");

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
						showWithData(selected.sablon_adi);

					}

				}
			}, DoubleClickEvent.getType());

		}
	}

	protected void showWithData(String sablon_adi) {

		String urlWithParameters = Util.urlBase + "getsablontanimlari?";

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

					DlgSablonTanimlari dlgTemp = new DlgSablonTanimlari();
					dlgTemp.putDataFromXML(listXmlSablonTanimlari.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);
					dlgTemp.setAnimationEnabled(true);
					dlgTemp.center();

				}
			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putDataToGrid() {
		// TODO Auto-generated method stub

	}

	private boolean isDesignTime() {
		// TODO Auto-generated method stub
		return false;
	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			DlgSablonTanimlari dlgTemp = new DlgSablonTanimlari();
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);
		}

	}

	private class BtnAraClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String urlWithParameters = Util.urlBase + "getsablontanimlari"
					+ "?sablon_adi=" + tctSablonAdi.getText();

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

								List<XMLSablonTanimlari> listxmlSablonTanimlari = XMLSablonTanimlari.XML
										.readList(response.getText());

								// listXmlOnKayit.add(xmlOnKayit);

								// lblNewLabel.setText(listxmlSablonTanimlari
								// .get(0).sablon_adi);

								// Set the total row count. This isn't strictly
								// necessary, but it affects
								// paging calculations, so its good habit to
								// keep the row count up to date.
								grdSablonTanimlari.setRowCount(1, true);

								// Push the data into the widget.
								grdSablonTanimlari.setRowData(0,
										listxmlSablonTanimlari);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}
}
