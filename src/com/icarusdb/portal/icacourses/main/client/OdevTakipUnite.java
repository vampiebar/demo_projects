package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.google.gwt.user.client.ui.ListBox;

public class OdevTakipUnite extends Composite {
	private ListBox cbxEgitimTuru;
	private ListBox cbxAlan;
	private ListBox cbxDersAdi;
	private Button button;
	private CellTable<XMLOdevTakipUnite> grdOdevTakipUnite;
	private TextColumn<XMLOdevTakipUnite> grdcEgitimTuruAdi;
	private TextColumn<XMLOdevTakipUnite> grdcalanAdi;
	private TextColumn<XMLOdevTakipUnite> grdcDersAdi;
	private TextColumn<XMLOdevTakipUnite> grdcUniteAdi;
	private Column<XMLOdevTakipUnite, String> grdcIslemler;

	public OdevTakipUnite() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("789px", "750px");

		Label label = new Label("Eğitim Türü");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 10, 10);
		label.setSize("66px", "16px");

		Label label_1 = new Label("Alan");
		label_1.setStyleName("gwt-Bold");
		absolutePanel.add(label_1, 10, 45);
		label_1.setSize("56px", "16px");

		Label label_2 = new Label("Ders Adı");
		label_2.setStyleName("gwt-Bold");
		absolutePanel.add(label_2, 10, 80);
		label_2.setSize("56px", "16px");

		cbxEgitimTuru = new ListBox();
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
		absolutePanel.add(cbxEgitimTuru, 137, 10);
		cbxEgitimTuru.setSize("139px", "25px");

		cbxAlan = new ListBox();
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.addItem(" ");
		cbxAlan.addItem("Lütfen Seçiniz");
		cbxAlan.addItem("ALAN YOK");
		absolutePanel.add(cbxAlan, 137, 45);
		cbxAlan.setSize("139px", "25px");

		cbxDersAdi = new ListBox();
		cbxDersAdi.setStyleName("gwt-ComboBox1");
		cbxDersAdi.addItem("Lütfen Seçiniz");
		absolutePanel.add(cbxDersAdi, 137, 80);
		cbxDersAdi.setSize("139px", "25px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel.add(horizontalPanel, 10, 108);
		horizontalPanel.setSize("701px", "309px");

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

		grdcIslemler = new Column<XMLOdevTakipUnite, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLOdevTakipUnite object) {
				return (String) null;
			}
		};
		grdOdevTakipUnite.addColumn(grdcIslemler, "İşlemler");

		Button btnYeniKayit = new Button("ARA");
		btnYeniKayit.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit.addClickHandler(new BtnYeniKayitClickHandler());
		btnYeniKayit.setText("Yeni Kayıt");
		absolutePanel.add(btnYeniKayit, 434, 30);
		btnYeniKayit.setSize("78px", "48px");

		Button btnKaydet = new Button("Yeni Kayıt");
		btnKaydet.setStyleName("gwt-ButtonSave");

		btnKaydet.setText("Kaydet");
		absolutePanel.add(btnKaydet, 531, 30);
		btnKaydet.setSize("78px", "48px");

		Button btnExceleAktar = new Button("Excel'e Aktar");
		btnExceleAktar.setStyleName("gwt-ButtonExceleAktar");
		absolutePanel.add(btnExceleAktar, 622, 30);
		btnExceleAktar.setSize("78px", "48px");

		button = new Button("ARA");
		button.setStyleName("gwt-ButonKapat");
		button.addClickHandler(new ButtonClickHandler());
		absolutePanel.add(button, 342, 30);
		button.setSize("78px", "48px");
	}

	private class BtnYeniKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			// cbxEgitimTuru.setSelectedIndex(0);
			// cbxAlan.setSelectedIndex(0);
			// cbxDersAdi.setSelectedIndex(0);

			DlgOdevTakipUnite dlgTemp = new DlgOdevTakipUnite();
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);

		}
	}

	private class ButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String urlWithParameters = Util.urlBase + "getodevtakipunite"
					+ "?egitim_turu=" + cbxEgitimTuru.getSelectedIndex();

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

								List<XMLOdevTakipUnite> listXmlOdevTakipUnite = XMLOdevTakipUnite.XML
										.readList(response.getText());

								// XMLOdevTakipUnite xmlOdevTakipUnite =
								// XMLOdevTakipUnite.XML
								// .read(response.getText());

								// lblNewLabel.setText(listxmlOdevTakipUnite
								// .get(0).egitim_turu);

								grdOdevTakipUnite.setRowCount(1, true);

								// Push the data into the widget.
								grdOdevTakipUnite.setRowData(0,
										listXmlOdevTakipUnite);
							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}
}
