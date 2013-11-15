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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class BankaEkle extends Composite {
	private CellTable<XMLBankaEkle> grdBankaEkle;
	private Column<XMLBankaEkle, ?> textColumn;
	private Column<XMLBankaEkle, ?> column;

	public BankaEkle() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("795px", "471px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonListeyiYenile");
		absolutePanel.add(btnListeyiYenile, 545, 70);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 450, 70);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 634, 70);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 197);
		horizontalPanel.setSize("774px", "75px");

		grdBankaEkle = new CellTable<XMLBankaEkle>();
		horizontalPanel.add(grdBankaEkle);
		grdBankaEkle.setSize("100%", "100%");

		textColumn = new TextColumn<XMLBankaEkle>() {
			@Override
			public String getValue(XMLBankaEkle object) {
				return object.banka_adi.toString();
			}
		};
		grdBankaEkle.addColumn(textColumn, "Banka Adı");

		column = new Column<XMLBankaEkle, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLBankaEkle object) {
				return (String) null;
			}
		};
		grdBankaEkle.addColumn(column, "İşlemler");

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
						showWithData(selected.banka_adi);

					}

				}
			}, DoubleClickEvent.getType());
		}

	}

	protected void showWithData(String banka_adi) {

		String urlWithParameters = Util.urlBase + "getbankaekle?";

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

					Window.alert("AAABBBCCC " + response.getText());

					List<XMLBankaEkle> listXmlBankaEkle = XMLBankaEkle.XML
							.readList(response.getText());

					DlgBankaEkle dlgTemp = new DlgBankaEkle();
					dlgTemp.putDataFromXML(listXmlBankaEkle.get(0));
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

		String urlWithParameters = Util.urlBase + "getbankaekle";

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				urlWithParameters);

		Window.alert("URL TO GET VALUES: " + urlWithParameters);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					Window.alert("AAABBBCCC " + response.getText());

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

			Window.alert(e.getMessage() + "ERROR");
		}

	}

	// Implement the following method exactly as-is
	private static final boolean isDesignTime() {
		// return Beans.isDesignTime(); // GWT 2.4 and above
		return false; // GWT 2.2 and earlier

	}

	public class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			DlgBankaEkle dlgTemp = new DlgBankaEkle();
			dlgTemp.center();
		}
	}
}
