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
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.SingleSelectionModel;

public class DBSKayit extends Composite {
	private TextBox tctAdi;
	private TextBox tctTCKimlikNo;
	private ListBox cbxOkulDurumu;
	private ListBox cbxAlanBilgi;
	private ListBox cbxSinavTarihi;
	private TextBox tctSoyadi;
	private CellTable<XMLDBSKayit> grdDBSKayit;

	public DBSKayit() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		horizontalPanel.add(absolutePanel);
		absolutePanel.setSize("853px", "651px");

		Label lblNewLabel = new Label("Adı");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 30);

		tctAdi = new TextBox();
		tctAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAdi, 166, 30);
		tctAdi.setSize("230px", "16px");

		Label lblSoyad = new Label("Soyadı");
		lblSoyad.setStyleName("gwt-Bold");
		absolutePanel.add(lblSoyad, 10, 60);

		Label lblNewLabel_1 = new Label("T.C Kimlik No");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 10, 90);

		tctSoyadi = new TextBox();
		tctSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSoyadi, 166, 60);
		tctSoyadi.setSize("230px", "16px");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctTCKimlikNo, 166, 90);
		tctTCKimlikNo.setSize("230px", "16px");

		Label lblOkulDurumu = new Label("Okul Durumu");
		lblOkulDurumu.setStyleName("gwt-Bold");
		absolutePanel.add(lblOkulDurumu, 10, 120);

		Label lblAlanBilgi = new Label("Alan Bilgi");
		lblAlanBilgi.setStyleName("gwt-Bold");
		absolutePanel.add(lblAlanBilgi, 10, 150);

		Label lblSnavTarihi = new Label("Sınav Tarihi");
		lblSnavTarihi.setStyleName("gwt-Bold");
		absolutePanel.add(lblSnavTarihi, 10, 187);

		cbxOkulDurumu = new ListBox();
		cbxOkulDurumu.setStyleName("gwt-ComboBox1");
		cbxOkulDurumu.addItem("1.Sınıf");
		cbxOkulDurumu.addItem("2.Sınıf");
		cbxOkulDurumu.addItem("3.Sınıf");
		cbxOkulDurumu.addItem("4.Sınıf");
		cbxOkulDurumu.addItem("5.Sınıf");
		cbxOkulDurumu.addItem("6.Sınıf");
		cbxOkulDurumu.addItem("7.Sınıf");
		cbxOkulDurumu.addItem("8.Sınıf");
		cbxOkulDurumu.addItem("9.Sınıf");
		cbxOkulDurumu.addItem("10.Sınıf");
		cbxOkulDurumu.addItem("11.Sınıf");
		cbxOkulDurumu.addItem("Lise Mezun");
		cbxOkulDurumu.addItem("Üniversite Mezun");
		cbxOkulDurumu.addItem("12.Sınıf ");
		absolutePanel.add(cbxOkulDurumu, 166, 120);
		cbxOkulDurumu.setSize("232px", "25px");

		cbxAlanBilgi = new ListBox();
		cbxAlanBilgi.setStyleName("gwt-ComboBox1");
		cbxAlanBilgi.addItem(" ");
		absolutePanel.add(cbxAlanBilgi, 166, 150);
		cbxAlanBilgi.setSize("232px", "25px");

		cbxSinavTarihi = new ListBox();
		cbxSinavTarihi.setStyleName("gwt-ComboBox1");
		cbxSinavTarihi.addItem("");
		absolutePanel.add(cbxSinavTarihi, 166, 180);
		cbxSinavTarihi.setSize("232px", "25px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel.add(horizontalPanel_1, 10, 242);
		horizontalPanel_1.setSize("817px", "174px");

		grdDBSKayit = new CellTable<XMLDBSKayit>();
		horizontalPanel_1.add(grdDBSKayit);
		grdDBSKayit.setSize("100%", "146px");

		TextColumn<XMLDBSKayit> textColumn_5 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.id.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_5, "İD");
		grdDBSKayit.setColumnWidth(textColumn_5, "44px");

		TextColumn<XMLDBSKayit> textColumn_1 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.adi.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_1, "Adı");

		TextColumn<XMLDBSKayit> textColumn_2 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.soyadi.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_2, "Soyadı");

		TextColumn<XMLDBSKayit> textColumn_7 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.tc_kimlik_no.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_7, "TC Kimlik No");
		grdDBSKayit.setColumnWidth(textColumn_7, "123px");

		TextColumn<XMLDBSKayit> textColumn_6 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return object.okul.toString();
			}
		};
		grdDBSKayit.addColumn(textColumn_6, "Okul Adı");

		TextColumn<XMLDBSKayit> textColumn = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return (object.sinav_tarihi);
			}
		};
		grdDBSKayit.addColumn(textColumn, "Sınav Tarih Saat");

		TextColumn<XMLDBSKayit> textColumn_4 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return "???";
			}
		};
		grdDBSKayit.addColumn(textColumn_4, "Oluşturma Tarih Saat");

		TextColumn<XMLDBSKayit> textColumn_3 = new TextColumn<XMLDBSKayit>() {
			@Override
			public String getValue(XMLDBSKayit object) {
				return "İşlemler";
			}
		};
		grdDBSKayit.addColumn(textColumn_3, "İşlemler");

		Button btnYeniKayit = new Button("Yeni Kayıt");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		absolutePanel.add(btnYeniKayit, 592, 30);
		btnYeniKayit.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 760, 30);
		btnExceleAktar.setSize("78px", "48px");

		Button btnKaydet = new Button("Yeni Kayıt");
		btnKaydet.setStyleName("gwt-ButtonSave");
		// btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 676, 30);
		btnKaydet.setSize("78px", "48px");

		Button btnAra = new Button("Yeni Kayıt");
		btnAra.setStyleName("gwt-ButonKapat");
		btnAra.setText("Ara");
		absolutePanel.add(btnAra, 508, 30);
		btnAra.setSize("78px", "48px");

		if (!isDesignTime()) {

			putDataToGrid();

			final SingleSelectionModel<XMLDBSKayit> selectionModel = new SingleSelectionModel<XMLDBSKayit>();

			grdDBSKayit.setSelectionModel(selectionModel);
			grdDBSKayit.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLDBSKayit selected = selectionModel.getSelectedObject();
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

		String urlWithParameters = Util.urlBase + "getdbskayit?id=" + id;

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

					List<XMLDBSKayit> listXmlDBSKayit = XMLDBSKayit.XML
							.readList(response.getText());

					DlgDBSYeniKayit dlgTemp = new DlgDBSYeniKayit(false,
							new Long(id).longValue());

					dlgTemp.putDataFromXML(listXmlDBSKayit.get(0));
					dlgTemp.center();

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase + "getdbskayit";

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

					List<XMLDBSKayit> listXmlDBSKayit = XMLDBSKayit.XML
							.readList(response.getText());

					// Window.alert("SIZE DBSKAYIT: " + listXmlDBSKayit.);

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdDBSKayit.setRowCount(1, true);

					// Push the data into the widget.
					grdDBSKayit.setRowData(0, listXmlDBSKayit);

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

	// private class BtnKaydetClickHandler implements ClickHandler {
	// public void onClick(ClickEvent event) {
	//
	// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
	// "http://localhost:9090/ICACoursesWS/jaxrs/genel/getdbskayit");
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
	// // Window.alert(response.getText());
	//
	// }
	// });
	// } catch (RequestException e) {
	// // displayError("Couldn't retrieve JSON");
	//
	// // Window.alert(e.getMessage() + "ERROR");
	// }
	// }
	// }

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			// tctAdi.setText("");
			// tctSoyadi.setText("");
			// tctTCKimlikNo.setText("");
			//
			// cbxOkulDurumu.setSelectedIndex(0);
			// cbxAlanBilgi.setSelectedIndex(0);
			// cbxSinavTarihi.setSelectedIndex(0);

			DlgDBSYeniKayit dlgTemp = new DlgDBSYeniKayit(true, -1);

			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}
}
