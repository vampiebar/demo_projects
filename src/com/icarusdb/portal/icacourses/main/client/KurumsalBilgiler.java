package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class KurumsalBilgiler extends Composite {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctSubeAdiKisa;
	private TextBox tctSubeResmiAdi;
	private TextBox tctSirketAdi;
	private TextBox tctVergiDairesi;
	private TextBox tctVergiNo;
	private ListBox cbxUlke;
	private ListBox cbxIl;
	private ListBox cbxIlce;
	private ListBox cbxSemt;
	private ListBox cbxMahalleKoy;
	private TextBox tctYoneticiAdi;
	private TextBox tctYoneticiTel;
	private TextBox tctMudur;
	private TextBox tctMudurYardimcisi;
	private TextBox tctTelefon;
	private TextBox tctFaks;
	private TextBox tctEMail;
	private TextArea tctAdres;
	private FileUpload fileUpload;
	private Button btnKaydet;
	private Image image;

	public KurumsalBilgiler(boolean isInsert, long id) {

		_isInsert = isInsert;
		_id = id;

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("100%", "669px");

		Label lblubeAdKsa = new Label("Şube Adı Kısa");
		lblubeAdKsa.setStyleName("gwt-Bold");
		absolutePanel.add(lblubeAdKsa, 22, 56);

		Label lblubeResmiAd = new Label("Şube Resmi Adı");
		lblubeResmiAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblubeResmiAd, 22, 94);

		Label lblirketAd = new Label("Şirket Adı");
		lblirketAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblirketAd, 22, 135);

		Label lblVergiAd = new Label("Vergi Dairesi");
		lblVergiAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblVergiAd, 23, 171);

		Label lblVergiNo = new Label("Vergi No");
		lblVergiNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblVergiNo, 23, 204);

		tctSubeAdiKisa = new TextBox();
		tctSubeAdiKisa.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSubeAdiKisa, 136, 52);
		tctSubeAdiKisa.setSize("166px", "16px");

		tctSubeResmiAdi = new TextBox();
		tctSubeResmiAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSubeResmiAdi, 136, 90);
		tctSubeResmiAdi.setSize("166px", "16px");

		tctSirketAdi = new TextBox();
		tctSirketAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSirketAdi, 136, 131);
		tctSirketAdi.setSize("166px", "16px");

		tctVergiDairesi = new TextBox();
		tctVergiDairesi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVergiDairesi, 136, 171);
		tctVergiDairesi.setSize("166px", "16px");

		tctVergiNo = new TextBox();
		tctVergiNo.setMaxLength(30);
		tctVergiNo.addKeyPressHandler(new TctVergiNoKeyPressHandler());
		tctVergiNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVergiNo, 136, 204);
		tctVergiNo.setSize("166px", "16px");

		Label lblYneticiAd = new Label("Yönetici Adı");
		lblYneticiAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblYneticiAd, 355, 52);

		Label lblYneticiTel = new Label("Yönetici Tel");
		lblYneticiTel.setStyleName("gwt-Bold");
		absolutePanel.add(lblYneticiTel, 355, 90);

		Label label = new Label("Müdür");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 355, 131);
		label.setSize("68px", "16px");

		Label lblMdrYardmcs = new Label("Müdür Yardımcısı");
		lblMdrYardmcs.setStyleName("gwt-Bold");
		absolutePanel.add(lblMdrYardmcs, 355, 171);

		Label lblLogopng = new Label("Logo (png)");
		lblLogopng.setStyleName("gwt-Bold");
		absolutePanel.add(lblLogopng, 355, 204);

		tctYoneticiAdi = new TextBox();
		tctYoneticiAdi.setMaxLength(30);
		tctYoneticiAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctYoneticiAdi, 497, 52);
		tctYoneticiAdi.setSize("164px", "16px");

		tctYoneticiTel = new TextBox();
		tctYoneticiTel.setMaxLength(11);
		tctYoneticiTel.addKeyPressHandler(new TctYoneticiTelKeyPressHandler());
		tctYoneticiTel.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctYoneticiTel, 497, 90);
		tctYoneticiTel.setSize("164px", "16px");

		tctMudur = new TextBox();
		tctMudur.setMaxLength(30);
		tctMudur.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctMudur, 497, 131);
		tctMudur.setSize("164px", "16px");

		tctMudurYardimcisi = new TextBox();
		tctMudurYardimcisi.setMaxLength(30);
		tctMudurYardimcisi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctMudurYardimcisi, 497, 171);
		tctMudurYardimcisi.setSize("164px", "16px");

		Label lblIletiimBilgiler = new Label("İletişim Bilgiler");
		lblIletiimBilgiler.setStyleName("gwt-Bold");
		absolutePanel.add(lblIletiimBilgiler, 22, 258);
		lblIletiimBilgiler.setSize("101px", "16px");

		Label lbllke = new Label("Ülke");
		lbllke.setStyleName("gwt-Bold");
		absolutePanel.add(lbllke, 22, 302);

		Label lblIl = new Label("İl");
		lblIl.setStyleName("gwt-Bold");
		absolutePanel.add(lblIl, 22, 337);
		lblIl.setSize("27px", "16px");

		Label lblIle = new Label("İlçe");
		lblIle.setStyleName("gwt-Bold");
		absolutePanel.add(lblIle, 22, 372);
		lblIle.setSize("26px", "16px");

		Label lblSemt = new Label("Semt");
		lblSemt.setStyleName("gwt-Bold");
		absolutePanel.add(lblSemt, 22, 407);

		Label lblMahalleKy = new Label("Mahalle / Köy");
		lblMahalleKy.setStyleName("gwt-Bold");
		absolutePanel.add(lblMahalleKy, 22, 442);
		lblMahalleKy.setSize("101px", "16px");

		cbxUlke = new ListBox();
		cbxUlke.addItem("TÜRKİYE");
		cbxUlke.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxUlke, 136, 293);
		cbxUlke.setSize("168px", "23px");

		cbxIl = new ListBox();
		cbxIl.addChangeHandler(new CbxIlChangeHandler());
		cbxIl.addItem(" ");
		cbxIl.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxIl, 136, 328);
		cbxIl.setSize("168px", "23px");

		cbxIlce = new ListBox();
		cbxIlce.addChangeHandler(new CbxIlceChangeHandler());
		cbxIlce.addItem(" ");
		cbxIlce.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxIlce, 136, 363);
		cbxIlce.setSize("168px", "23px");

		cbxSemt = new ListBox();
		cbxSemt.addChangeHandler(new CbxSemtChangeHandler());
		cbxSemt.addItem(" ");
		cbxSemt.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxSemt, 136, 398);
		cbxSemt.setSize("168px", "23px");

		cbxMahalleKoy = new ListBox();
		cbxMahalleKoy.addItem(" ");
		cbxMahalleKoy.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxMahalleKoy, 136, 433);
		cbxMahalleKoy.setSize("168px", "23px");

		Label lblTelefon = new Label("Telefon");
		lblTelefon.setStyleName("gwt-Bold");
		absolutePanel.add(lblTelefon, 355, 303);

		Label lblFaks = new Label("Faks");
		lblFaks.setStyleName("gwt-Bold");
		absolutePanel.add(lblFaks, 355, 337);

		Label lblNewLabel_1 = new Label("E-Mail");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 355, 369);

		Label lblAdres = new Label("Adres");
		lblAdres.setStyleName("gwt-Bold");
		absolutePanel.add(lblAdres, 355, 408);

		tctTelefon = new TextBox();
		tctTelefon.setMaxLength(11);
		tctTelefon.addKeyPressHandler(new TctTelefonKeyPressHandler());
		tctTelefon.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctTelefon, 456, 300);
		tctTelefon.setSize("143px", "16px");

		tctFaks = new TextBox();
		tctFaks.setMaxLength(11);
		tctFaks.addKeyPressHandler(new TctFaksKeyPressHandler());
		tctFaks.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctFaks, 456, 334);
		tctFaks.setSize("143px", "16px");

		tctEMail = new TextBox();
		tctEMail.setMaxLength(40);
		tctEMail.addKeyPressHandler(new TctEMailKeyPressHandler());
		tctEMail.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEMail, 456, 366);
		tctEMail.setSize("234px", "16px");

		tctAdres = new TextArea();
		tctAdres.setStyleName("gwt-TextAreaResible");
		absolutePanel.add(tctAdres, 456, 408);
		tctAdres.setSize("236px", "61px");

		btnKaydet = new Button("Kaydet");
		btnKaydet.setVisible(false);
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 439, 511);
		btnKaydet.setSize("78px", "48px");

		fileUpload = new FileUpload();
		absolutePanel.add(fileUpload, 497, 204);
		fileUpload.setSize("132px", "22px");

		Button btnYkle = new Button("Seç");
		btnYkle.setText("Seç");
		absolutePanel.add(btnYkle, 641, 200);

		image = new Image("kaydet-1.png");
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 540, 493);
		image.setSize("72px", "66px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setStyleName("gwt-LabelMor2");
		absolutePanel.add(horizontalPanel, 0, 0);
		horizontalPanel.setSize("100%", "33px");

		Label lblKurumsalBilgiler_1 = new Label("Kurumsal Bilgiler");
		horizontalPanel.add(lblKurumsalBilgiler_1);
		lblKurumsalBilgiler_1.setWidth("100%");

		if (!isDesignTime()) {
			getKurumsalBilgiler(1);
			putIlToCbx(cbxIl);

		}

	}

	public void putIlToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getil");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLIl> xmlil = XMLIl.XML.readList(response.getText());

					for (int i = 0; i < xmlil.size(); i++) {

						lbxTemp.addItem(xmlil.get(i).il_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putIlceToCbx(int il_id, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getilce?il_id=" + il_id);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLIlce> xmlilce = XMLIlce.XML.readList(response
							.getText());

					for (int i = 0; i < xmlilce.size(); i++) {

						lbxTemp.addItem(xmlilce.get(i).ilce_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putSemtToCbx(String il, String ilce, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getpostakodu?il=" + il + "&ilce=" + ilce);

		// Window.alert(Util.urlBase + "getpostakodu?il=" + il + "&ilce=" +
		// ilce);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLPostaKodu> xmlpostakodu = XMLPostaKodu.XML
							.readList(response.getText());

					for (int i = 0; i < xmlpostakodu.size(); i++) {

						lbxTemp.addItem(xmlpostakodu.get(i).semt_bucak_belde);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putMahalleToCbx(String il, String ilce,
			String semt_bucak_belde, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getpostakodumahalle?il=" + il + "&ilce=" + ilce
						+ "&semt_bucak_belde=" + semt_bucak_belde);

		// Window.alert(Util.urlBase + "getpostakodumahalle?il=" + il + "&ilce="
		// + ilce + "&semt_bucak_belde=" + semt_bucak_belde);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLPostaKoduMahalle> xmlpostakodumahalle = XMLPostaKoduMahalle.XML
							.readList(response.getText());

					for (int i = 0; i < xmlpostakodumahalle.size(); i++) {

						lbxTemp.addItem(xmlpostakodumahalle.get(i).mahalle
								+ " - " + xmlpostakodumahalle.get(i).posta_kodu);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void getKurumsalBilgiler(long id) {
		// protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getkurumsalbilgiler?id="
				+ id;

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

					List<XMLKurumsalBilgiler> listXmlKurumsalBilgiler = XMLKurumsalBilgiler.XML
							.readList(response.getText());

					// Window.alert("AAABBBCCC " + response.getText());

					// KurumsalBilgiler dlgTemp = new KurumsalBilgiler();
					// false, new Long(id).longValue());
					// dlgTemp.
					putDataFromXML(listXmlKurumsalBilgiler.get(0));
					// dlgTemp.tabOnKayit.selectTab(0);

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

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putkurumsalbilgiler?";

			URLValue = URLValue + "id=" + _id;

			URLValue = URLValue + "&sube_kisa_adi=" + tctSubeAdiKisa.getText();
			URLValue = URLValue + "&sube_resmi_adi="
					+ tctSubeResmiAdi.getText();
			URLValue = URLValue + "&sirket_adi=" + tctSirketAdi.getText();
			URLValue = URLValue + "&vergi_dairesi=" + tctVergiDairesi.getText();
			URLValue = URLValue + "&vergi_no=" + tctVergiNo.getText();
			URLValue = URLValue + "&ulke="
					+ cbxUlke.getValue(cbxUlke.getSelectedIndex());
			URLValue = URLValue + "&il="
					+ cbxIl.getItemText(cbxIl.getSelectedIndex());
			URLValue = URLValue + "&ilce="
					+ cbxIlce.getItemText(cbxIlce.getSelectedIndex());
			URLValue = URLValue + "&semt="
					+ cbxSemt.getItemText(cbxSemt.getSelectedIndex());
			URLValue = URLValue
					+ "&mahalle_koy="
					+ cbxMahalleKoy.getItemText(cbxMahalleKoy
							.getSelectedIndex());
			URLValue = URLValue + "&yonetici_adi=" + tctYoneticiAdi.getText();
			URLValue = URLValue + "&yonetici_tel=" + tctYoneticiTel.getText();
			URLValue = URLValue + "&mudur=" + tctMudur.getText();
			URLValue = URLValue + "&mudur_yardimcisi="
					+ tctMudurYardimcisi.getText();
			// URLValue = URLValue + "&logo=" + tctLogo.getText();
			URLValue = URLValue + "&telefon=" + tctTelefon.getText();
			URLValue = URLValue + "&faks=" + tctFaks.getText();
			URLValue = URLValue + "&email=" + tctEMail.getText();
			URLValue = URLValue + "&adres=" + tctAdres.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	private class CbxIlChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putIlceToCbx(cbxIl.getSelectedIndex(), cbxIlce);
		}
	}

	private class CbxIlceChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putSemtToCbx(cbxIl.getItemText(cbxIl.getSelectedIndex()),
					cbxIlce.getItemText(cbxIlce.getSelectedIndex()), cbxSemt);
		}
	}

	public void putDataFromXML(XMLKurumsalBilgiler xml) {
		tctSubeResmiAdi.setText(xml.sube_resmi_adi);
		tctSubeAdiKisa.setText(xml.sube_kisa_adi);
		tctAdres.setText(xml.adres);
		tctEMail.setText(xml.email);
		tctFaks.setText(xml.faks);
		tctMudur.setText(xml.mudur);
		tctMudurYardimcisi.setText(xml.mudur_yardimcisi);
		tctYoneticiAdi.setText(xml.yonetici_adi);
		tctYoneticiTel.setText(xml.yonetici_tel);
		tctSirketAdi.setText(xml.sirket_adi);
		tctTelefon.setText(xml.telefon);
		tctVergiDairesi.setText(xml.vergi_dairesi);
		tctVergiNo.setText(xml.vergi_no);

		cbxUlke.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxUlke, xml.ulke));

		cbxIl.setItemText(0, xml.il);
		cbxIlce.setItemText(0, xml.ilce);
		cbxSemt.setItemText(0, xml.semt);
		cbxMahalleKoy.setItemText(0, xml.mahalle_koy);

	}

	private class CbxSemtChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putMahalleToCbx(cbxIl.getItemText(cbxIl.getSelectedIndex()),
					cbxIlce.getItemText(cbxIlce.getSelectedIndex()),
					cbxSemt.getItemText(cbxSemt.getSelectedIndex()),
					cbxMahalleKoy);

		}
	}

	private class TctVergiNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctVergiNo.getText();
			if (!input.matches("[0-9]*")) {
				tctVergiNo.setStyleName("gwt-TextBoxError");
				return;
			}
			// do your thang

			tctVergiNo.setStyleName("gwt-TextBox1");
		}

	}

	private class TctTelefonKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctTelefon.getText();
			if (!input.matches("[0-9]*")) {
				tctTelefon.setStyleName("gwt-TextBoxError");
				return;
			}
			// do your thing

			tctTelefon.setStyleName("gwt-TextBox1");
		}
	}

	private class TctFaksKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctFaks.getText();
			if (!input.matches("[0-9]*")) {
				tctFaks.setStyleName("gwt-TextBoxError");
				return;
			}
			// do your thing

			tctFaks.setStyleName("gwt-TextBox1");
		}
	}

	private class TctYoneticiTelKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctYoneticiTel.getText();
			if (!input.matches("[0-9]*")) {
				tctYoneticiTel.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctYoneticiTel.setStyleName("gwt-TextBox1");
		}
	}

	private class TctEMailKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctEMail.getText();
			if (!input
					.matches("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$")) {
				tctEMail.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctEMail.setStyleName("gwt-TextBox1");

		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			btnKaydet.click();

		}
	}

	private class ImageMouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image.setUrl("kaydet-2.png");

		}
	}

	private class ImageMouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image.setUrl("kaydet-1.png");

		}
	}
}