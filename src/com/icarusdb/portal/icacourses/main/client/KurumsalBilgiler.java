package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.widget.client.TextButton;

public class KurumsalBilgiler extends Composite {
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
	private TextBox tctLogo;
	private TextBox tctTelefon;
	private TextBox tctFaks;
	private TextBox tctEMail;
	private TextArea tctAdres;

	public KurumsalBilgiler() {

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		initWidget(absolutePanel);
		absolutePanel.setSize("808px", "669px");

		Label lblNewLabel = new Label("Kurumsal Bilgileri (Düzenleme)");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("808px", "33px");

		Label lblubeAdKsa = new Label("Şube Adı Kısa");
		lblubeAdKsa.setStyleName("gwt-Bold");
		absolutePanel.add(lblubeAdKsa, 24, 89);

		Label lblubeResmiAd = new Label("Şube Resmi Adı");
		lblubeResmiAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblubeResmiAd, 24, 127);

		Label lblirketAd = new Label("Şirket Adı");
		lblirketAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblirketAd, 24, 168);

		Label lblVergiAd = new Label("Vergi Dairesi");
		lblVergiAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblVergiAd, 25, 208);

		Label lblVergiNo = new Label("Vergi No");
		lblVergiNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblVergiNo, 25, 241);

		tctSubeAdiKisa = new TextBox();
		tctSubeAdiKisa.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSubeAdiKisa, 138, 89);
		tctSubeAdiKisa.setSize("143px", "16px");

		tctSubeResmiAdi = new TextBox();
		tctSubeResmiAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSubeResmiAdi, 138, 127);
		tctSubeResmiAdi.setSize("143px", "16px");

		tctSirketAdi = new TextBox();
		tctSirketAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSirketAdi, 138, 168);
		tctSirketAdi.setSize("143px", "16px");

		tctVergiDairesi = new TextBox();
		tctVergiDairesi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVergiDairesi, 138, 208);
		tctVergiDairesi.setSize("143px", "16px");

		tctVergiNo = new TextBox();
		tctVergiNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVergiNo, 138, 241);
		tctVergiNo.setSize("143px", "16px");

		Label lblYneticiAd = new Label("Yönetici adı");
		lblYneticiAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblYneticiAd, 357, 89);

		Label lblYneticiTel = new Label("Yönetici Tel");
		lblYneticiTel.setStyleName("gwt-Bold");
		absolutePanel.add(lblYneticiTel, 357, 127);

		Label label = new Label("Müdür");
		label.setStyleName("gwt-Bold");
		absolutePanel.add(label, 357, 168);
		label.setSize("68px", "16px");

		Label lblMdrYardmcs = new Label("Müdür Yardımcısı");
		lblMdrYardmcs.setStyleName("gwt-Bold");
		absolutePanel.add(lblMdrYardmcs, 357, 208);

		Label lblLogopng = new Label("Logo (png)");
		lblLogopng.setStyleName("gwt-Bold");
		absolutePanel.add(lblLogopng, 354, 241);

		tctYoneticiAdi = new TextBox();
		tctYoneticiAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctYoneticiAdi, 499, 89);
		tctYoneticiAdi.setSize("143px", "16px");

		tctYoneticiTel = new TextBox();
		tctYoneticiTel.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctYoneticiTel, 499, 127);
		tctYoneticiTel.setSize("143px", "16px");

		tctMudur = new TextBox();
		tctMudur.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctMudur, 499, 168);
		tctMudur.setSize("143px", "16px");

		tctMudurYardimcisi = new TextBox();
		tctMudurYardimcisi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctMudurYardimcisi, 499, 208);
		tctMudurYardimcisi.setSize("143px", "16px");

		tctLogo = new TextBox();
		tctLogo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctLogo, 499, 241);
		tctLogo.setSize("143px", "16px");

		TextButton txtbtnNewButton = new TextButton("Seç");
		absolutePanel.add(txtbtnNewButton, 661, 241);
		txtbtnNewButton.setSize("94px", "25px");

		Label lblKurumsalBilgiler = new Label("Kurumsal Bilgiler");
		absolutePanel.add(lblKurumsalBilgiler, 10, 49);

		Label lblIletiimBilgiler = new Label("İletişim Bilgiler");
		lblIletiimBilgiler.setStyleName("gwt-Bold");
		absolutePanel.add(lblIletiimBilgiler, 24, 295);

		Label lbllke = new Label("Ülke");
		lbllke.setStyleName("gwt-Bold");
		absolutePanel.add(lbllke, 43, 337);

		Label lblIl = new Label("İl");
		lblIl.setStyleName("gwt-Bold");
		absolutePanel.add(lblIl, 43, 371);

		Label lblIle = new Label("İlçe");
		lblIle.setStyleName("gwt-Bold");
		absolutePanel.add(lblIle, 43, 403);

		Label lblSemt = new Label("Semt");
		lblSemt.setStyleName("gwt-Bold");
		absolutePanel.add(lblSemt, 43, 442);

		Label lblMahalleKy = new Label("Mahalle / Köy");
		lblMahalleKy.setStyleName("gwt-Bold");
		absolutePanel.add(lblMahalleKy, 43, 477);
		lblMahalleKy.setSize("89px", "16px");

		cbxUlke = new ListBox();
		cbxUlke.addItem("TÜRKİYE");
		cbxUlke.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxUlke, 138, 331);
		cbxUlke.setSize("158px", "25px");

		cbxIl = new ListBox();
		cbxIl.addItem("Adana");
		cbxIl.addItem("Adıyaman");
		cbxIl.addItem("Afyon");
		cbxIl.addItem("Ağrı");
		cbxIl.addItem("Amasya");
		cbxIl.addItem("Ankara");
		cbxIl.addItem("Antalya");
		cbxIl.addItem("Artvin");
		cbxIl.addItem("Aydın");
		cbxIl.addItem("Balıkesir");
		cbxIl.addItem("Bilecik");
		cbxIl.addItem("Bitlis");
		cbxIl.addItem("Bolu");
		cbxIl.addItem("Burdur");
		cbxIl.addItem("Bursa");
		cbxIl.addItem("Çanakkale");
		cbxIl.addItem("Çankırı");
		cbxIl.addItem("Çorum");
		cbxIl.addItem("Denizli");
		cbxIl.addItem("Diyarbakır");
		cbxIl.addItem("Edirne");
		cbxIl.addItem("Elazığ");
		cbxIl.addItem("Erzurum");
		cbxIl.addItem("Eskişehir");
		cbxIl.addItem("Giresun");
		cbxIl.addItem("Gümüşhane");
		cbxIl.addItem("Hakkari");
		cbxIl.addItem("Hatay");
		cbxIl.addItem("Isparta");
		cbxIl.addItem("İçel");
		cbxIl.addItem("İstanbul");
		cbxIl.addItem("İzmir");
		cbxIl.addItem("Kars");
		cbxIl.addItem("Kastamonu");
		cbxIl.addItem("Kayseri");
		cbxIl.addItem("Kırklareli");
		cbxIl.addItem("Kırşehir");
		cbxIl.addItem("Kocaeli");
		cbxIl.addItem("Konya");
		cbxIl.addItem("Kütahya");
		cbxIl.addItem("Malatya");
		cbxIl.addItem("Manisa");
		cbxIl.addItem("Kahramanmaraş");
		cbxIl.addItem("Mardin");
		cbxIl.addItem("Muğla");
		cbxIl.addItem("Muş");
		cbxIl.addItem("Nevşehir");
		cbxIl.addItem("Niğde");
		cbxIl.addItem("Rize");
		cbxIl.addItem("Sakarya");
		cbxIl.addItem("Samsun");
		cbxIl.addItem("Siirt");
		cbxIl.addItem("Sinop");
		cbxIl.addItem("Sivas");
		cbxIl.addItem("Tekirdağ");
		cbxIl.addItem("Tokat");
		cbxIl.addItem("Trabzon");
		cbxIl.addItem("Tunceli");
		cbxIl.addItem("Şanlıurfa");
		cbxIl.addItem("Uşak");
		cbxIl.addItem("Van");
		cbxIl.addItem("Yozgat");
		cbxIl.addItem("Zonguldak");
		cbxIl.addItem("Aksaray");
		cbxIl.addItem("Bayburt");
		cbxIl.addItem("Karaman");
		cbxIl.addItem("Kırıkkale");
		cbxIl.addItem("Batman");
		cbxIl.addItem("Şırnak");
		cbxIl.addItem("Bartın");
		cbxIl.addItem("Ardahan");
		cbxIl.addItem("Iğdır");
		cbxIl.addItem("Yalova");
		cbxIl.addItem("Karabük");
		cbxIl.addItem("Osmaniye");
		cbxIl.addItem("Düzce");
		cbxIl.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxIl, 138, 365);
		cbxIl.setSize("158px", "25px");

		cbxIlce = new ListBox();
		cbxIlce.addItem("büyükçekmece");
		cbxIlce.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxIlce, 138, 397);
		cbxIlce.setSize("158px", "25px");

		cbxSemt = new ListBox();
		cbxSemt.addItem("kumburgaz");
		cbxSemt.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxSemt, 138, 436);
		cbxSemt.setSize("158px", "25px");

		cbxMahalleKoy = new ListBox();
		cbxMahalleKoy.addItem("1");
		cbxMahalleKoy.addItem("2 ");
		cbxMahalleKoy.setStyleName("gwt-TextBox1");
		absolutePanel.add(cbxMahalleKoy, 138, 471);
		cbxMahalleKoy.setSize("160px", "25px");

		Label lblTelefon = new Label("Telefon");
		lblTelefon.setStyleName("gwt-Bold");
		absolutePanel.add(lblTelefon, 357, 337);

		Label lblFaks = new Label("Faks");
		lblFaks.setStyleName("gwt-Bold");
		absolutePanel.add(lblFaks, 357, 371);

		Label lblNewLabel_1 = new Label("E-Mail");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 357, 403);

		Label lblAdres = new Label("Adres");
		lblAdres.setStyleName("gwt-Bold");
		absolutePanel.add(lblAdres, 357, 442);

		tctTelefon = new TextBox();
		tctTelefon.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctTelefon, 458, 337);
		tctTelefon.setSize("143px", "16px");

		tctFaks = new TextBox();
		tctFaks.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctFaks, 458, 371);
		tctFaks.setSize("143px", "16px");

		tctEMail = new TextBox();
		tctEMail.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctEMail, 458, 403);
		tctEMail.setSize("234px", "16px");

		tctAdres = new TextArea();
		tctAdres.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAdres, 458, 452);
		tctAdres.setSize("236px", "61px");

		Button btnKaydet = new Button("Kaydet");
		btnKaydet.setStyleName("gwt-ButtonSave");
		btnKaydet.addClickHandler(new BtnKaydetClickHandler());
		absolutePanel.add(btnKaydet, 605, 541);
		btnKaydet.setSize("78px", "48px");
	}

	private class BtnKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putkurumsalbilgiler?";
			URLValue = URLValue + "sube_kisa_adi=" + tctSubeAdiKisa.getText();
			URLValue = URLValue + "&sube_resmi_adi="
					+ tctSubeResmiAdi.getText();
			URLValue = URLValue + "&sirket_adi=" + tctSirketAdi.getText();
			URLValue = URLValue + "&vergi_dairesi=" + tctVergiDairesi.getText();
			URLValue = URLValue + "&vergi_no=" + tctVergiNo.getText();
			URLValue = URLValue + "&ulke="
					+ cbxUlke.getValue(cbxUlke.getSelectedIndex());
			URLValue = URLValue + "&il="
					+ cbxIl.getValue(cbxIl.getSelectedIndex());
			URLValue = URLValue + "&ilce="
					+ cbxIlce.getValue(cbxIlce.getSelectedIndex());
			URLValue = URLValue + "&semt="
					+ cbxSemt.getValue(cbxSemt.getSelectedIndex());
			URLValue = URLValue + "&mahalle_koy="
					+ cbxMahalleKoy.getValue(cbxMahalleKoy.getSelectedIndex());
			URLValue = URLValue + "&yonetici_adi=" + tctYoneticiAdi.getText();
			URLValue = URLValue + "&yonetici_tel=" + tctYoneticiTel.getText();
			URLValue = URLValue + "&mudur=" + tctMudur.getText();
			URLValue = URLValue + "&mudur_yardimcisi="
					+ tctMudurYardimcisi.getText();
			URLValue = URLValue + "&logo=" + tctLogo.getText();
			URLValue = URLValue + "&telefon=" + tctTelefon.getText();
			URLValue = URLValue + "&faks=" + tctFaks.getText();
			URLValue = URLValue + "&e_mail=" + tctEMail.getText();
			URLValue = URLValue + "&adres=" + tctAdres.getText();

			Window.alert(URLValue);

			new Util().sendRequest(URLValue);

		}
	}
}
