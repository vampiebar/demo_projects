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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class KullaniciTanimlama extends Composite {
	private CellTable<XMLKullaniciTanimlama> grdKullaniciTanimlari;

	public KullaniciTanimlama() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("780px", "449px");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 459, 53);
		btnYeniKayit.setSize("78px", "48px");

		Button btnListeyiYenile = new Button("Listeyi Yenile");
		btnListeyiYenile.setStyleName("gwt-ButtonListeyiYenile");
		absolutePanel.add(btnListeyiYenile, 556, 53);
		btnListeyiYenile.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 647, 53);
		btnExceleAktar.setSize("78px", "48px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 177);
		horizontalPanel.setSize("760px", "222px");

		grdKullaniciTanimlari = new CellTable<XMLKullaniciTanimlama>();
		horizontalPanel.add(grdKullaniciTanimlari);
		grdKullaniciTanimlari.setSize("100%", "100%");

		TextColumn<XMLKullaniciTanimlama> column = new TextColumn<XMLKullaniciTanimlama>() {
			@Override
			public String getValue(XMLKullaniciTanimlama object) {
				return (object.kullanici_kodu);
			}
		};
		grdKullaniciTanimlari.addColumn(column, "Kullanıcı Kodu");

		Column<XMLKullaniciTanimlama, ?> textColumn = new TextColumn<XMLKullaniciTanimlama>() {
			@Override
			public String getValue(XMLKullaniciTanimlama object) {
				return object.adi.toString();
			}
		};
		grdKullaniciTanimlari.addColumn(textColumn, "Adı");

		Column<XMLKullaniciTanimlama, ?> textColumn_1 = new TextColumn<XMLKullaniciTanimlama>() {
			@Override
			public String getValue(XMLKullaniciTanimlama object) {
				return object.soyadi.toString();
			}
		};
		grdKullaniciTanimlari.addColumn(textColumn_1, "Soyadı");

		TextColumn<XMLKullaniciTanimlama> column_1 = new TextColumn<XMLKullaniciTanimlama>() {
			@Override
			public String getValue(XMLKullaniciTanimlama object) {
				return (object.sifre);
			}
		};
		grdKullaniciTanimlari.addColumn(column_1, "Şifre");

		Column<XMLKullaniciTanimlama, ?> column_2 = new Column<XMLKullaniciTanimlama, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLKullaniciTanimlama object) {
				return (String) null;
			}
		};
		grdKullaniciTanimlari.addColumn(column_2, "İşlemler");
		if (!isDesignTime()) {

			putDataToGrid();
			final SingleSelectionModel<XMLKullaniciTanimlama> selectionModel = new SingleSelectionModel<XMLKullaniciTanimlama>();

			grdKullaniciTanimlari.setSelectionModel(selectionModel);
			grdKullaniciTanimlari.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLKullaniciTanimlama selected = selectionModel
							.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.adi);

					}

				}
			}, DoubleClickEvent.getType());
		}

	}

	protected void showWithData(String adi) {

		String urlWithParameters = Util.urlBase + "getkullanicitanimlama?";

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

					List<XMLKullaniciTanimlama> listXmlKullaniciTanimlama = XMLKullaniciTanimlama.XML
							.readList(response.getText());

					DlgKullaniciTanimlama dlgTemp = new DlgKullaniciTanimlama();
					dlgTemp.putDataFromXML(listXmlKullaniciTanimlama.get(0));
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

		String urlWithParameters = Util.urlBase + "getkullanicitanimlama";

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

					List<XMLKullaniciTanimlama> listXmlKullaniciTanimlama = XMLKullaniciTanimlama.XML
							.readList(response.getText());

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdKullaniciTanimlari.setRowCount(1, true);

					// Push the data into the widget.
					grdKullaniciTanimlari.setRowData(0,
							listXmlKullaniciTanimlama);

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

			DlgKullaniciTanimlama dlgTemp = new DlgKullaniciTanimlama();
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}
