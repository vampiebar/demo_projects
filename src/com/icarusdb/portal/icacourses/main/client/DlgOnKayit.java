package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgOnKayit extends DialogBox {
	private TextBox tctAdi;
	private TextBox tctSoyadi;
	private TextBox tctTCKimlikNo;
	private ListBox cbxCinsiyet;
	private ListBox cbxMedeniHali;
	private DateBox dtpDogumTarihi;
	private TextBox tctEvTelefonu;
	private TextBox tctEmail;
	private TextBox tctCepTelefonu;
	private ListBox cbxOgrenciBilgileriUlke;
	private ListBox cbxOgrenciBilgileriIl;
	private ListBox cbxOgrenciBilgileriIlce;
	private ListBox cbxOgrenciBilgileriSinif;
	private ListBox cbxAdresBilgileriUlke;
	private ListBox cbxAdresBilgileriIl;
	private ListBox cbxAdresBilgileriIlce;
	private ListBox cbxSemt;
	private ListBox cbxMahalle;
	private TextBox tctSokakveNo;
	private TextBox tctAileSiraNo;
	private TextBox tctSiraNo;
	private TextBox tctVerildigiYer;
	private TextBox tctVerilisNedeni;
	private TextBox tctKayitNo;
	private DateBox dtpVerilisTarihi;
	private TextBox tctMahalleKoy;
	private ListBox cbxOgrenciKimlikBilgileriIlce;
	private ListBox cbxOgrenciKimlikBilgileriIl;
	private ListBox cbxOgrenciKimlikBilgileriUlke;
	private TextBox tctCuzdanNo;
	private TextBox tctSeriNo;
	private TextBox tctCiltNo;
	private ListBox cbxAlan;
	private ListBox cbxEgitimTuru;
	private ListBox cbxKursZamani;
	private ListBox cbxGorusmeSinif;
	private ListBox cbxGorusmeSonucu;
	private ListBox cbxGorusmeTipi;
	private DateBox dtpGorusmeTarihi;
	private TextBox tctReferans;
	private ListBox cbxIndirimturu;
	private ListBox cbxIndirimMiktari;
	private TextBox tctAciklama;
	private TextBox tctGorusmeYuzdesi;
	private CellTable<XMLVeliEkle> grdVeliEkle;
	private ListBox cbxOkul;
	public DecoratedTabPanel tabOnKayit;
	private CaptionPanel cptnpnlNewPanel;
	private TextBox tctKursIndirimFiyati;

	public DlgOnKayit() {
		setHTML("Ön Kayıt İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		setWidget(absolutePanel);
		absolutePanel.setSize("840px", "695px");

		tabOnKayit = new DecoratedTabPanel();
		absolutePanel.add(tabOnKayit, 10, 0);
		tabOnKayit.setSize("462px", "156px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_2.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_2, "Öğrenci Bilgileri", false);
		absolutePanel_2.setSize("840px", "712px");

		Label label_27 = new Label("Adı");
		label_27.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_27, 10, 10);
		label_27.setSize("133px", "18px");

		Label lblSoyad = new Label("Soyadı");
		lblSoyad.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblSoyad, 10, 34);
		lblSoyad.setSize("105px", "18px");

		tctAdi = new TextBox();
		tctAdi.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctAdi, 157, 10);
		tctAdi.setSize("232px", "14px");

		Label label_29 = new Label("T.C. Kimlik No ");
		label_29.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_29, 10, 58);
		label_29.setSize("85px", "18px");

		Button btnBilgileriniGetir = new Button("Bilgilerini Getir");
		btnBilgileriniGetir.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_2.add(btnBilgileriniGetir, 304, 62);
		btnBilgileriniGetir.setSize("127px", "22px");

		tctSoyadi = new TextBox();
		tctSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctSoyadi, 157, 34);
		tctSoyadi.setSize("232px", "14px");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctTCKimlikNo, 157, 62);
		tctTCKimlikNo.setSize("125px", "14px");

		Label label_30 = new Label("Cinsiyet");
		label_30.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_30, 10, 112);
		label_30.setSize("47px", "18px");

		Label label_31 = new Label("Medeni Hali");
		label_31.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_31, 10, 140);
		label_31.setSize("85px", "18px");

		cbxCinsiyet = new ListBox();
		cbxCinsiyet.setStyleName("gwt-ComboBox1");
		cbxCinsiyet.addItem("Erkek");
		cbxCinsiyet.addItem("Kiz");
		absolutePanel_2.add(cbxCinsiyet, 157, 108);
		cbxCinsiyet.setSize("128px", "22px");

		cbxMedeniHali = new ListBox();
		cbxMedeniHali.addItem("Evli");
		cbxMedeniHali.addItem("Bekar");
		cbxMedeniHali.setStyleName("gwt-ComboBox1");
		absolutePanel_2.add(cbxMedeniHali, 157, 140);
		cbxMedeniHali.setSize("128px", "22px");

		Label label_32 = new Label("Doğum Tarihi");
		label_32.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_32, 10, 174);
		label_32.setSize("77px", "18px");

		dtpDogumTarihi = new DateBox();
		dtpDogumTarihi.setStyleName("gwt-TextBox1");
		dtpDogumTarihi
				.addValueChangeHandler(new DptDogumTarihiValueChangeHandler());
		dtpDogumTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		absolutePanel_2.add(dtpDogumTarihi, 157, 178);
		dtpDogumTarihi.setSize("124px", "14px");

		Label label_33 = new Label("Ev / Cep Telefonu");
		label_33.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_33, 10, 212);
		label_33.setSize("105px", "18px");

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctEvTelefonu, 157, 212);
		tctEvTelefonu.setSize("125px", "14px");

		Label label_34 = new Label("E-Mail");
		label_34.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_34, 10, 255);
		label_34.setSize("37px", "18px");

		tctEmail = new TextBox();
		tctEmail.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctEmail, 157, 255);
		tctEmail.setSize("232px", "14px");

		tctCepTelefonu = new TextBox();
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctCepTelefonu, 301, 212);
		tctCepTelefonu.setSize("143px", "14px");

		cptnpnlNewPanel = new CaptionPanel("Okul Bilgileri");
		cptnpnlNewPanel.setStyleName("gwt-Bold");
		absolutePanel_2.add(cptnpnlNewPanel, 0, 292);
		cptnpnlNewPanel.setSize("420px", "144px");

		FlexTable flexTable = new FlexTable();
		flexTable.setStyleName("gwt-Bold");
		cptnpnlNewPanel.setContentWidget(flexTable);
		flexTable.setSize("100%", "94%");

		Label lbllke = new Label("Ülke");
		lbllke.setStyleName("gwt-Bold");
		flexTable.setWidget(0, 0, lbllke);
		lbllke.setSize("26px", "18px");

		cbxOgrenciBilgileriUlke = new ListBox();
		flexTable.setWidget(0, 2, cbxOgrenciBilgileriUlke);
		cbxOgrenciBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriUlke.addItem("Türkiye");
		cbxOgrenciBilgileriUlke.setSize("128px", "22px");

		Label label_23 = new Label("İl");
		label_23.setStyleName("gwt-Bold");
		flexTable.setWidget(1, 0, label_23);
		label_23.setSize("26px", "18px");

		cbxOgrenciBilgileriIl = new ListBox();
		cbxOgrenciBilgileriIl.addItem(" ");
		flexTable.setWidget(1, 2, cbxOgrenciBilgileriIl);
		cbxOgrenciBilgileriIl
				.addChangeHandler(new CbxOgrenciBilgileriIlChangeHandler());

		cbxOgrenciBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIl.setSize("181px", "22px");

		Label label_24 = new Label("İlçe");
		label_24.setStyleName("gwt-Bold");
		flexTable.setWidget(2, 0, label_24);
		label_24.setSize("20px", "18px");

		cbxOgrenciBilgileriIlce = new ListBox();
		cbxOgrenciBilgileriIlce.addItem(" ");
		flexTable.setWidget(2, 2, cbxOgrenciBilgileriIlce);
		cbxOgrenciBilgileriIlce
				.addChangeHandler(new CbxOgrenciBilgileriIlceChangeHandler());
		cbxOgrenciBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIlce.setSize("181px", "22px");

		Label label_25 = new Label("Okul");
		label_25.setStyleName("gwt-Bold");
		flexTable.setWidget(3, 0, label_25);
		label_25.setSize("27px", "18px");

		cbxOkul = new ListBox();
		flexTable.setWidget(3, 2, cbxOkul);
		cbxOkul.addItem(" ");
		cbxOkul.setSize("350px", "22px");

		Label label_26 = new Label("Sınıf");
		label_26.setStyleName("gwt-Bold");
		flexTable.setWidget(4, 0, label_26);
		label_26.setSize("26px", "18px");

		cbxOgrenciBilgileriSinif = new ListBox();
		flexTable.setWidget(4, 2, cbxOgrenciBilgileriSinif);
		cbxOgrenciBilgileriSinif.addItem("1.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("2.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("3.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("4.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("5.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("6.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("7.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("8.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("9.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("10.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("11.Sınıf");
		cbxOgrenciBilgileriSinif.addItem("Lise Mezun");
		cbxOgrenciBilgileriSinif.addItem("Üniversite Mezun");
		cbxOgrenciBilgileriSinif.addItem("12.Sınıf");
		cbxOgrenciBilgileriSinif.setSize("127px", "22px");

		AbsolutePanel absolutePanel_5 = new AbsolutePanel();
		absolutePanel_5.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_5, "Adres Bilgileri", false);
		absolutePanel_5.setSize("840px", "712px");

		Label label = new Label("Ülke");
		label.setStyleName("gwt-Bold");
		absolutePanel_5.add(label, 10, 18);
		label.setSize("26px", "18px");

		Label label_1 = new Label("İl");
		label_1.setStyleName("gwt-Bold");
		absolutePanel_5.add(label_1, 10, 61);
		label_1.setSize("26px", "18px");

		Label label_2 = new Label("İlçe");
		label_2.setStyleName("gwt-Bold");
		absolutePanel_5.add(label_2, 10, 111);
		label_2.setSize("20px", "18px");

		Label label_3 = new Label("Semt");
		label_3.setStyleName("gwt-Bold");
		absolutePanel_5.add(label_3, 10, 149);
		label_3.setSize("31px", "18px");

		Label label_4 = new Label("Mahalle");
		label_4.setStyleName("gwt-Bold");
		absolutePanel_5.add(label_4, 10, 190);
		label_4.setSize("45px", "18px");

		Label label_5 = new Label("Sokak ve no");
		label_5.setStyleName("gwt-Bold");
		absolutePanel_5.add(label_5, 10, 230);
		label_5.setSize("73px", "18px");

		cbxAdresBilgileriUlke = new ListBox();
		cbxAdresBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriUlke.addItem("Türkiye");
		absolutePanel_5.add(cbxAdresBilgileriUlke, 125, 10);
		cbxAdresBilgileriUlke.setSize("146px", "22px");

		cbxAdresBilgileriIl = new ListBox();
		cbxAdresBilgileriIl.addItem(" ");
		cbxAdresBilgileriIl
				.addChangeHandler(new CbxAdresBilgileriIlChangeHandler());
		cbxAdresBilgileriIl.setStyleName("gwt-ComboBox1");
		absolutePanel_5.add(cbxAdresBilgileriIl, 125, 57);
		cbxAdresBilgileriIl.setSize("146px", "22px");

		cbxAdresBilgileriIlce = new ListBox();
		cbxAdresBilgileriIlce
				.addChangeHandler(new CbxAdresBilgileriIlceChangeHandler());
		cbxAdresBilgileriIlce.addItem(" ");
		cbxAdresBilgileriIlce.setStyleName("gwt-ComboBox1");
		absolutePanel_5.add(cbxAdresBilgileriIlce, 125, 111);
		cbxAdresBilgileriIlce.setSize("146px", "22px");

		cbxSemt = new ListBox();
		cbxSemt.addChangeHandler(new CbxSemtChangeHandler());
		cbxSemt.addItem(" ");

		cbxSemt.setStyleName("gwt-ComboBox1");
		absolutePanel_5.add(cbxSemt, 125, 145);
		cbxSemt.setSize("146px", "22px");

		cbxMahalle = new ListBox();
		cbxMahalle.addItem(" ");
		cbxMahalle.setStyleName("gwt-ComboBox1");
		absolutePanel_5.add(cbxMahalle, 125, 186);
		cbxMahalle.setSize("146px", "22px");

		tctSokakveNo = new TextBox();
		absolutePanel_5.add(tctSokakveNo, 125, 230);
		tctSokakveNo.setSize("191px", "48px");

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_3, "DBS Sonuç", false);
		absolutePanel_3.setSize("840px", "712px");

		AbsolutePanel absolutePanel_4 = new AbsolutePanel();
		absolutePanel_4.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_4, "Görüşme", false);
		absolutePanel_4.setSize("840px", "651px");

		CaptionPanel cptnpnlNewPanel_1 = new CaptionPanel("Önceki Görüşmeler");
		cptnpnlNewPanel_1.setStyleName("gwt-Bold");
		absolutePanel_4.add(cptnpnlNewPanel_1, 10, 10);
		cptnpnlNewPanel_1.setSize("404px", "145px");

		FlexTable flexTable_1 = new FlexTable();
		cptnpnlNewPanel_1.setContentWidget(flexTable_1);
		flexTable_1.setSize("100%", "94%");

		Label lblEitimTr = new Label("Eğitim Türü");
		lblEitimTr.setStyleName("gwt-Bold");
		flexTable_1.setWidget(0, 0, lblEitimTr);

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addItem("YGS HAZIRLIK");
		cbxEgitimTuru.addItem("YGS / LYS HAZIRLIK");
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
		flexTable_1.setWidget(0, 1, cbxEgitimTuru);
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.setSize("140px", "18px");

		Label lblAlan = new Label("Alan");
		lblAlan.setStyleName("gwt-Bold");
		flexTable_1.setWidget(1, 0, lblAlan);

		cbxAlan = new ListBox();
		flexTable_1.setWidget(1, 1, cbxAlan);
		cbxAlan.addItem("ALAN YOK");
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.setSize("140px", "18px");

		Label lblKursZaman = new Label("Kurs Zamanı");
		lblKursZaman.setStyleName("gwt-Bold");
		flexTable_1.setWidget(2, 0, lblKursZaman);

		cbxKursZamani = new ListBox();
		flexTable_1.setWidget(2, 1, cbxKursZamani);
		cbxKursZamani.addItem("Hafta Sonu");
		cbxKursZamani.addItem("Hafta İçi");
		cbxKursZamani.setStyleName("gwt-ComboBox1");
		cbxKursZamani.setSize("140px", "18px");

		Label lblSnf = new Label("Sınıf");
		lblSnf.setStyleName("gwt-Bold");
		flexTable_1.setWidget(3, 0, lblSnf);

		cbxGorusmeSinif = new ListBox();
		flexTable_1.setWidget(3, 1, cbxGorusmeSinif);
		cbxGorusmeSinif.setStyleName("gwt-ComboBox1");
		cbxGorusmeSinif.addItem("a");
		cbxGorusmeSinif.addItem("b");
		cbxGorusmeSinif.setSize("140px", "18px");

		Label lblNewLabel_1 = new Label("Kurs İndirim Fiyatı");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblNewLabel_1, 25, 195);

		Label lblIndirimTr = new Label("İndirim Türü");
		absolutePanel_4.add(lblIndirimTr, 25, 234);
		lblIndirimTr.setStyleName("gwt-Bold");
		lblIndirimTr.setSize("89px", "18px");

		Label lblIndirimMiktar = new Label("İndirim Miktarı");
		absolutePanel_4.add(lblIndirimMiktar, 25, 268);
		lblIndirimMiktar.setStyleName("gwt-Bold");
		lblIndirimMiktar.setSize("101px", "18px");

		Label lblReferans = new Label("Referans");
		absolutePanel_4.add(lblReferans, 25, 306);
		lblReferans.setStyleName("gwt-Bold");

		Label lblGrmeTarihi = new Label("Görüşme Tarihi");
		absolutePanel_4.add(lblGrmeTarihi, 25, 350);
		lblGrmeTarihi.setStyleName("gwt-Bold");

		Label lblGrmeTipi = new Label("Görüşme Tipi");
		absolutePanel_4.add(lblGrmeTipi, 25, 399);
		lblGrmeTipi.setStyleName("gwt-Bold");

		Label lblNewLabel = new Label("Görüşme Sonucu");
		absolutePanel_4.add(lblNewLabel, 25, 442);
		lblNewLabel.setStyleName("gwt-Bold");
		lblNewLabel.setWidth("111px");

		Label lblGrmeYzdesi = new Label("Görüşme Yüzdesi");
		absolutePanel_4.add(lblGrmeYzdesi, 25, 480);
		lblGrmeYzdesi.setStyleName("gwt-Bold");

		Label lblAklama = new Label("Açıklama");
		absolutePanel_4.add(lblAklama, 25, 520);
		lblAklama.setStyleName("gwt-Bold");

		cbxIndirimturu = new ListBox();
		absolutePanel_4.add(cbxIndirimturu, 163, 230);
		cbxIndirimturu.addItem("Pazarlık");
		cbxIndirimturu.addItem("İndirim Yok");
		cbxIndirimturu.setStyleName("gwt-ComboBox1");
		cbxIndirimturu.setSize("140px", "22px");

		cbxIndirimMiktari = new ListBox();
		absolutePanel_4.add(cbxIndirimMiktari, 163, 264);
		cbxIndirimMiktari.addItem("Para");
		cbxIndirimMiktari.addItem("Yüzde");
		cbxIndirimMiktari.setStyleName("gwt-ComboBox1");
		cbxIndirimMiktari.setSize("65px", "22px");

		tctReferans = new TextBox();
		absolutePanel_4.add(tctReferans, 163, 306);
		tctReferans.setSize("132px", "10px");

		dtpGorusmeTarihi = new DateBox();
		absolutePanel_4.add(dtpGorusmeTarihi, 163, 350);
		dtpGorusmeTarihi
				.addValueChangeHandler(new DtpGorusmeTarihiValueChangeHandler());
		dtpGorusmeTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		dtpGorusmeTarihi.setSize("136px", "12px");

		cbxGorusmeTipi = new ListBox();
		absolutePanel_4.add(cbxGorusmeTipi, 163, 395);
		cbxGorusmeTipi.addItem("Yüzyüze");
		cbxGorusmeTipi.addItem("Telefonla");
		cbxGorusmeTipi.setStyleName("gwt-ComboBox1");
		cbxGorusmeTipi.setSize("140px", "18px");

		cbxGorusmeSonucu = new ListBox();
		absolutePanel_4.add(cbxGorusmeSonucu, 163, 438);
		cbxGorusmeSonucu.addItem("Olumlu");
		cbxGorusmeSonucu.addItem("Olumsuz");
		cbxGorusmeSonucu.addItem("Düşünecekler");
		cbxGorusmeSonucu.addItem("Başka Dershaneye Kaydolmuş");
		cbxGorusmeSonucu.setStyleName("gwt-ComboBox1");
		cbxGorusmeSonucu.setSize("140px", "18px");

		tctGorusmeYuzdesi = new TextBox();
		absolutePanel_4.add(tctGorusmeYuzdesi, 163, 480);
		tctGorusmeYuzdesi.setSize("140px", "10px");

		tctAciklama = new TextBox();
		absolutePanel_4.add(tctAciklama, 163, 520);
		tctAciklama.setSize("264px", "58px");

		tctKursIndirimFiyati = new TextBox();
		absolutePanel_4.add(tctKursIndirimFiyati, 163, 191);
		tctKursIndirimFiyati.setSize("128px", "10px");

		AbsolutePanel absolutePanel_8 = new AbsolutePanel();
		absolutePanel_8.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_8, "Öğrenci Kimlik Bilgileri", false);
		absolutePanel_8.setSize("840px", "712px");

		Label label_6 = new Label("Seri No");
		label_6.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_6, 10, 4);
		label_6.setSize("64px", "18px");

		Label label_7 = new Label("Cüzdan No");
		label_7.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_7, 10, 41);
		label_7.setSize("108px", "18px");

		Label lblKaytlOlduu = new Label("Kayıtlı Olduğu");
		lblKaytlOlduu.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblKaytlOlduu, 10, 78);
		lblKaytlOlduu.setSize("108px", "18px");

		Label label_9 = new Label("Ülke");
		label_9.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_9, 10, 113);
		label_9.setSize("43px", "18px");

		Label label_10 = new Label("İl");
		label_10.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_10, 10, 148);
		label_10.setSize("6px", "18px");

		Label label_11 = new Label("İlçe");
		label_11.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_11, 10, 182);
		label_11.setSize("20px", "18px");

		Label label_12 = new Label("Mahalle / Köy");
		label_12.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_12, 10, 227);
		label_12.setSize("108px", "18px");

		Label label_13 = new Label("Cilt No");
		label_13.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_13, 10, 268);
		label_13.setSize("39px", "18px");

		Label label_14 = new Label("Aile Sıra No");
		label_14.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_14, 10, 308);
		label_14.setSize("69px", "18px");

		Label label_15 = new Label("Sıra No");
		label_15.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_15, 10, 346);
		label_15.setSize("43px", "18px");

		tctSeriNo = new TextBox();
		tctSeriNo.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctSeriNo, 130, 4);
		tctSeriNo.setSize("158px", "18px");

		tctCuzdanNo = new TextBox();
		tctCuzdanNo.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctCuzdanNo, 130, 37);
		tctCuzdanNo.setSize("158px", "18px");

		tctMahalleKoy = new TextBox();
		tctMahalleKoy.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctMahalleKoy, 130, 223);
		tctMahalleKoy.setSize("158px", "18px");

		tctCiltNo = new TextBox();
		tctCiltNo.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctCiltNo, 130, 264);
		tctCiltNo.setSize("158px", "18px");

		tctAileSiraNo = new TextBox();
		tctAileSiraNo.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctAileSiraNo, 130, 304);
		tctAileSiraNo.setSize("158px", "18px");

		tctSiraNo = new TextBox();
		tctSiraNo.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctSiraNo, 130, 342);
		tctSiraNo.setSize("158px", "18px");

		cbxOgrenciKimlikBilgileriUlke = new ListBox();
		cbxOgrenciKimlikBilgileriUlke.addItem("Türkiye");
		cbxOgrenciKimlikBilgileriUlke.setStyleName("gwt-ComboBox1");
		absolutePanel_8.add(cbxOgrenciKimlikBilgileriUlke, 130, 105);
		cbxOgrenciKimlikBilgileriUlke.setSize("162px", "22px");

		cbxOgrenciKimlikBilgileriIl = new ListBox();
		cbxOgrenciKimlikBilgileriIl
				.addChangeHandler(new CbxOgrenciKimlikBilgileriIlChangeHandler());
		cbxOgrenciKimlikBilgileriIl.addItem(" ");
		cbxOgrenciKimlikBilgileriIl.setStyleName("gwt-ComboBox1");
		absolutePanel_8.add(cbxOgrenciKimlikBilgileriIl, 130, 144);
		cbxOgrenciKimlikBilgileriIl.setSize("162px", "22px");

		cbxOgrenciKimlikBilgileriIlce = new ListBox();

		cbxOgrenciKimlikBilgileriIlce.addItem(" ");
		cbxOgrenciKimlikBilgileriIlce.setStyleName("gwt-ComboBox1");
		absolutePanel_8.add(cbxOgrenciKimlikBilgileriIlce, 130, 182);
		cbxOgrenciKimlikBilgileriIlce.setSize("162px", "22px");

		CaptionPanel cptnpnlNewPanel_3 = new CaptionPanel("Cüzdan Bilgileri");
		cptnpnlNewPanel_3.setStyleName("gwt-Bold");
		absolutePanel_8.add(cptnpnlNewPanel_3, 10, 388);
		cptnpnlNewPanel_3.setSize("300px", "175px");

		FlexTable flexTable_3 = new FlexTable();
		cptnpnlNewPanel_3.setContentWidget(flexTable_3);
		flexTable_3.setSize("100%", "94%");

		Label label_17 = new Label("Verildiği Yer");
		flexTable_3.setWidget(0, 0, label_17);
		label_17.setSize("99px", "18px");

		tctVerildigiYer = new TextBox();
		flexTable_3.setWidget(0, 1, tctVerildigiYer);
		tctVerildigiYer.setStyleName("gwt-TextBox1");
		tctVerildigiYer.setSize("158px", "18px");

		Label label_18 = new Label("Veriliş Nedeni");
		flexTable_3.setWidget(1, 0, label_18);
		label_18.setSize("115px", "18px");

		tctVerilisNedeni = new TextBox();
		flexTable_3.setWidget(1, 1, tctVerilisNedeni);
		tctVerilisNedeni.setStyleName("gwt-TextBox1");
		tctVerilisNedeni.setSize("158px", "18px");

		Label label_19 = new Label("Kayıt No");
		flexTable_3.setWidget(2, 0, label_19);
		label_19.setSize("50px", "18px");

		tctKayitNo = new TextBox();
		flexTable_3.setWidget(2, 1, tctKayitNo);
		tctKayitNo.setStyleName("gwt-TextBox1");
		tctKayitNo.setSize("158px", "18px");

		Label label_20 = new Label("Veriliş Tarihi");
		flexTable_3.setWidget(3, 0, label_20);
		label_20.setSize("137px", "18px");

		dtpVerilisTarihi = new DateBox();
		flexTable_3.setWidget(3, 1, dtpVerilisTarihi);
		dtpVerilisTarihi.setStyleName("gwt-TextBox1");
		dtpVerilisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getShortDateFormat()));
		dtpVerilisTarihi
				.addValueChangeHandler(new DtpVerilisTarihiValueChangeHandler());
		dtpVerilisTarihi.setSize("158px", "18px");

		AbsolutePanel absolutePanel_7 = new AbsolutePanel();
		absolutePanel_7.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_7, "Veli bilgileri", false);
		absolutePanel_7.setSize("840px", "712px");

		Button button = new Button("Veli Ekle");
		button.setStyleName("gwt-ButonYeniKayit");
		button.addClickHandler(new ButtonClickHandler());
		absolutePanel_7.add(button, 10, 10);
		button.setSize("76px", "24px");

		grdVeliEkle = new CellTable<XMLVeliEkle>();
		absolutePanel_7.add(grdVeliEkle, 10, 54);
		grdVeliEkle.setSize("715px", "174px");

		Column<XMLVeliEkle, Number> column = new Column<XMLVeliEkle, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(XMLVeliEkle object) {
				return (object.veli_bilgileri_tc_kimlik_no);
			}
		};
		grdVeliEkle.addColumn(column, "TC Kimlik No");

		TextColumn<XMLVeliEkle> textColumn = new TextColumn<XMLVeliEkle>() {
			public String getValue(XMLVeliEkle object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(textColumn, "Adı");

		TextColumn<XMLVeliEkle> textColumn_1 = new TextColumn<XMLVeliEkle>() {
			public String getValue(XMLVeliEkle object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(textColumn_1, "Soyadı");

		TextColumn<XMLVeliEkle> textColumn_2 = new TextColumn<XMLVeliEkle>() {
			public String getValue(XMLVeliEkle object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(textColumn_2, "Yakınlık Durumu");

		Column<XMLVeliEkle, String> column_5 = new Column<XMLVeliEkle, String>(
				new EditTextCell()) {
			@Override
			public String getValue(XMLVeliEkle object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column_5, "Ödeme Sorumlusu");

		Column<XMLVeliEkle, Number> column_1 = new Column<XMLVeliEkle, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(XMLVeliEkle object) {
				return (object.cep_tel);
			}
		};
		grdVeliEkle.addColumn(column_1, "Cep Tel");

		Column<XMLVeliEkle, Number> column_2 = new Column<XMLVeliEkle, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(XMLVeliEkle object) {
				return (Number) null;
			}
		};
		grdVeliEkle.addColumn(column_2, "İş Tel");

		Column<XMLVeliEkle, String> column_3 = new Column<XMLVeliEkle, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliEkle object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column_3, "Düzenle");

		Column<XMLVeliEkle, String> column_4 = new Column<XMLVeliEkle, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliEkle object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column_4, "Sil");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel.add(absolutePanel_1, 478, 606);
		absolutePanel_1.setSize("191px", "67px");

		Button btnYeniOgrenci = new Button("Yeni Öğrenci");
		btnYeniOgrenci.setStyleName("gwt-ButtonSave");
		btnYeniOgrenci.addClickHandler(new BtnYeniOgrenciClickHandler());
		absolutePanel_1.add(btnYeniOgrenci, 10, 10);
		btnYeniOgrenci.setSize("78px", "48px");

		Button btnKapat1 = new Button("Kapat");
		btnKapat1.setStyleName("gwt-ButonKapat");
		btnKapat1.addClickHandler(new BtnKapat1ClickHandler());
		absolutePanel_1.add(btnKapat1, 103, 10);
		btnKapat1.setSize("78px", "48px");

		if (!isDesignTime()) {

			putIlToCbx(cbxAdresBilgileriIl);
			putIlToCbx(cbxOgrenciBilgileriIl);
			putIlToCbx(cbxOgrenciKimlikBilgileriIl);

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

	public void putOkulToCbx(int il_id, int ilce_id, final ListBox lbxTemp) {

		lbxTemp.clear();

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getokul?il_id=" + il_id + "&ilce_id=" + ilce_id);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLOkul> xmlokul = XMLOkul.XML.readList(response
							.getText());

					for (int i = 0; i < xmlokul.size(); i++) {

						lbxTemp.addItem(xmlokul.get(i).okul_adi);
					}

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

	// private void putDataToGrid() {
	//
	// String urlWithParameters = Util.urlBase + "getveliekle";
	//
	// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
	// urlWithParameters);
	//
	// Window.alert("URL TO GET VALUES: " + urlWithParameters);
	//
	// try {
	// Request request = builder.sendRequest(null, new RequestCallback() {
	// public void onError(Request request, Throwable exception) {
	//
	// }
	//
	// @Override
	// public void onResponseReceived(Request request,
	// Response response) {
	//
	// Window.alert("AAABBBCCC " + response.getText());
	//
	// List<XMLVeliEkle> listXmlVeliEkle = XMLVeliEkle.XML
	// .readList(response.getText());
	//
	// // Set the total row count. This isn't strictly
	// // necessary, but it affects
	// // paging calculations, so its good habit to
	// // keep the row count up to date.
	// grdVeliEkle.setRowCount(1, true);
	//
	// // Push the data into the widget.
	// grdVeliEkle.setRowData(0, listXmlVeliEkle);
	//
	// }
	//
	// });
	//
	// } catch (RequestException e) {
	// // displayError("Couldn't retrieve JSON");
	//
	// Window.alert(e.getMessage() + "ERROR");
	// }
	//
	// }

	public void putDataFromXML(XMLOnKayit xml) {

		// Window.alert("adi:" + xml.adi);
		// Window.alert(xml);
		tctAdi.setText(xml.adi);
		tctSoyadi.setText(xml.soyadi);
		tctTCKimlikNo.setText(xml.tc_kimlik_no);
		tctEvTelefonu.setText(xml.ev_telefonu);
		tctCepTelefonu.setText(xml.cep_telefonu);
		tctEmail.setText(xml.email);
		tctReferans.setText(xml.referans);
		tctAciklama.setText(xml.aciklama);
		tctSokakveNo.setText(xml.sokak_ve_no);
		tctSeriNo.setText(xml.seri_no);
		tctCuzdanNo.setText(xml.cuzdan_no);
		tctMahalleKoy.setText(xml.mahalle_koy);
		tctCiltNo.setText(xml.cilt_no);
		tctAileSiraNo.setText(xml.aile_sira_no);
		tctSiraNo.setText(xml.sira_no);
		tctVerildigiYer.setText(xml.verildigi_yer);
		tctVerilisNedeni.setText(xml.verilis_nedeni);
		tctKayitNo.setText(xml.kayit_no);

		cbxCinsiyet.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxCinsiyet,
				xml.cinsiyet));
		cbxMedeniHali.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxMedeniHali, xml.medeni_hali));
		cbxOgrenciBilgileriUlke.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOgrenciBilgileriUlke, xml.ogrenci_bilgileri_ulke));
		// cbxOgrenciBilgileriIl.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxOgrenciBilgileriIl, xml.ogrenci_bilgileri_il));
		// cbxOgrenciBilgileriIlce.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxOgrenciBilgileriIlce, xml.ogrenci_bilgileri_ilce));
		// cbxOkul.setSelectedIndex(Util
		// .GetLBXSelectedTextIndex(cbxOkul, xml.okul));
		cbxOgrenciBilgileriSinif.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOgrenciBilgileriSinif, xml.ogrenci_bilgileri_sinif));
		cbxEgitimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxEgitimTuru, xml.egitim_turu));
		cbxAlan.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxAlan, xml.alan));
		cbxKursZamani.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxKursZamani, xml.kurs_zamani));
		cbxGorusmeSinif.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGorusmeSinif, xml.gorusme_sinif));
		cbxIndirimturu.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxIndirimturu, xml.indirim_turu));
		cbxIndirimMiktari.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxIndirimMiktari, xml.indirim_miktari));
		cbxGorusmeTipi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGorusmeTipi, xml.gorusme_tipi));
		cbxGorusmeSonucu.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGorusmeSonucu, xml.gorusme_sonucu));
		cbxAdresBilgileriUlke.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxAdresBilgileriUlke, xml.adres_bilgileri_ulke));
		// cbxAdresBilgileriIl.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxAdresBilgileriIl, xml.adres_bilgileri_il));
		// cbxAdresBilgileriIlce.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxAdresBilgileriIlce, xml.adres_bilgileri_ilce));
		// cbxSemt.setSelectedIndex(Util
		// .GetLBXSelectedTextIndex(cbxSemt, xml.semt));
		// cbxMahalle.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxMahalle,
		// xml.mahalle));
		cbxOgrenciKimlikBilgileriUlke.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxOgrenciBilgileriUlke,
						xml.ogrenci_kimlik_bilgileri_ulke));
		// cbxOgrenciKimlikBilgileriIl.setSelectedIndex(Util
		// .GetLBXSelectedTextIndex(cbxOgrenciKimlikBilgileriIl,
		// xml.ogrenci_kimlik_bilgileri_il));
		// cbxOgrenciKimlikBilgileriIlce.setSelectedIndex(Util
		// .GetLBXSelectedTextIndex(cbxOgrenciBilgileriIlce,
		// xml.ogrenci_kimlik_bilgileri_ilce));
		cbxOgrenciKimlikBilgileriIl.setItemText(0,
				xml.ogrenci_kimlik_bilgileri_il);
		cbxOgrenciBilgileriIl.setItemText(0, xml.ogrenci_bilgileri_il);
		cbxOgrenciBilgileriIlce.setItemText(0, xml.ogrenci_bilgileri_ilce);
		cbxOkul.setItemText(0, xml.okul);

		cbxAdresBilgileriIl.setItemText(0, xml.adres_bilgileri_il);
		cbxAdresBilgileriIlce.setItemText(0, xml.adres_bilgileri_ilce);
		cbxSemt.setItemText(0, xml.semt);
		cbxMahalle.setItemText(0, xml.mahalle);
		cbxOgrenciKimlikBilgileriIl.setItemText(0,
				xml.ogrenci_kimlik_bilgileri_il);
		cbxOgrenciKimlikBilgileriIlce.setItemText(0,
				xml.ogrenci_kimlik_bilgileri_ilce);

	}

	private class BtnYeniOgrenciClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putonkayit?";

			URLValue = URLValue + "adi=" + tctAdi.getText();
			URLValue = URLValue + "&soyadi=" + tctSoyadi.getText();
			URLValue = URLValue + "&tc_kimlik_no=" + tctTCKimlikNo.getText();
			URLValue = URLValue + "&cinsiyet="
					+ cbxCinsiyet.getValue(cbxCinsiyet.getSelectedIndex());
			URLValue = URLValue + "&medeni_hali="
					+ cbxMedeniHali.getValue(cbxMedeniHali.getSelectedIndex());
			URLValue = URLValue + "&ev_telefonu=" + tctEvTelefonu.getText();
			URLValue = URLValue + "&cep_telefonu=" + tctCepTelefonu.getText();
			URLValue = URLValue + "&email=" + tctEmail.getText();

			URLValue = URLValue
					+ "&ogrenci_bilgileri_ulke="
					+ cbxOgrenciBilgileriUlke.getValue(cbxOgrenciBilgileriUlke
							.getSelectedIndex());

			URLValue = URLValue
					+ "&ogrenci_bilgileri_il="
					+ cbxOgrenciBilgileriIl.getValue(cbxOgrenciBilgileriIl
							.getSelectedIndex());

			URLValue = URLValue
					+ "&ogrenci_bilgileri_ilce="
					+ cbxOgrenciBilgileriIlce.getValue(cbxOgrenciBilgileriIlce
							.getSelectedIndex());
			URLValue = URLValue + "&okul="
					+ cbxOkul.getValue(cbxOkul.getSelectedIndex());

			URLValue = URLValue
					+ "&ogrenci_bilgileri_sinif="
					+ cbxOgrenciBilgileriSinif
							.getValue(cbxOgrenciBilgileriSinif
									.getSelectedIndex());

			URLValue = URLValue + "&egitim_turu="
					+ cbxEgitimTuru.getValue(cbxEgitimTuru.getSelectedIndex());
			URLValue = URLValue + "&alan="
					+ cbxAlan.getValue(cbxAlan.getSelectedIndex());
			URLValue = URLValue + "&kurs_zamani="
					+ cbxKursZamani.getValue(cbxKursZamani.getSelectedIndex());
			URLValue = URLValue
					+ "&gorusme_sinif="
					+ cbxGorusmeSinif.getValue(cbxGorusmeSinif
							.getSelectedIndex());
			URLValue = URLValue
					+ "&indirim_turu="
					+ cbxIndirimturu
							.getValue(cbxIndirimturu.getSelectedIndex());
			URLValue = URLValue
					+ "&indirim_miktari="
					+ cbxIndirimMiktari.getValue(cbxIndirimMiktari
							.getSelectedIndex());
			URLValue = URLValue + "&referans=" + tctReferans.getText();
			URLValue = URLValue
					+ "&gorusme_tipi="
					+ cbxGorusmeTipi
							.getValue(cbxGorusmeTipi.getSelectedIndex());
			URLValue = URLValue
					+ "&gorusme_sonucu="
					+ cbxGorusmeSonucu.getValue(cbxGorusmeSonucu
							.getSelectedIndex());
			URLValue = URLValue + "&gorusme_yuzdesi="
					+ tctGorusmeYuzdesi.getText();
			URLValue = URLValue + "&aciklama=" + tctAciklama.getText();

			URLValue = URLValue
					+ "&adres_bilgileri_ulke="
					+ cbxAdresBilgileriUlke.getValue(cbxAdresBilgileriUlke
							.getSelectedIndex());
			URLValue = URLValue
					+ "&adres_bilgileri_il="
					+ cbxAdresBilgileriIl.getValue(cbxAdresBilgileriIl
							.getSelectedIndex());
			URLValue = URLValue
					+ "&adres_bilgileri_ilce="
					+ cbxAdresBilgileriIlce.getValue(cbxAdresBilgileriIlce
							.getSelectedIndex());
			URLValue = URLValue + "&semt="
					+ cbxSemt.getValue(cbxSemt.getSelectedIndex());
			URLValue = URLValue + "&mahalle="
					+ cbxMahalle.getValue(cbxMahalle.getSelectedIndex());
			URLValue = URLValue + "&sokak_ve_no=" + tctSokakveNo.getText();

			URLValue = URLValue + "&seri_no=" + tctSeriNo.getText();
			URLValue = URLValue + "&cuzdan_no=" + tctCuzdanNo.getText();
			URLValue = URLValue
					+ "&ogrenci_kimlik_bilgileri_ulke="
					+ cbxOgrenciKimlikBilgileriUlke
							.getValue(cbxOgrenciKimlikBilgileriUlke
									.getSelectedIndex());
			URLValue = URLValue
					+ "&ogrenci_kimlik_bilgileri_il="
					+ cbxOgrenciKimlikBilgileriIl
							.getValue(cbxOgrenciKimlikBilgileriIl
									.getSelectedIndex());
			URLValue = URLValue
					+ "&ogrenci_kimlik_bilgileri_ilce="
					+ cbxOgrenciKimlikBilgileriIlce
							.getValue(cbxOgrenciKimlikBilgileriIlce
									.getSelectedIndex());
			URLValue = URLValue + "&mahalle_koy=" + tctMahalleKoy.getText();
			URLValue = URLValue + "&cilt_no=" + tctCiltNo.getText();
			URLValue = URLValue + "&aile_sira_no=" + tctAileSiraNo.getText();
			URLValue = URLValue + "&sira_no=" + tctSiraNo.getText();
			URLValue = URLValue + "&verildigi_yer=" + tctVerildigiYer.getText();
			URLValue = URLValue + "&verilis_nedeni="
					+ tctVerilisNedeni.getText();
			URLValue = URLValue + "&kayit_no=" + tctKayitNo.getText();

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "Öğrenci Ön Kaydı Yapılmıştır",
					"Öğrenci Ön Kaydı Yapılamadı.");

		}
	}

	private class DtpGorusmeTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
			// Window.alert(dtf.format(dtpGorusmeTarihi.getValue()));

		}
	}

	private class DptDogumTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
			// Window.alert(dtf.format(dtpDogumTarihi.getValue()));
		}
	}

	private class DtpVerilisTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
			// Window.alert(dtf.format(dtpVerilisTarihi.getValue()));
		}
	}

	private class BtnKapat1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class ButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			DlgVeliEkle dlgTemp = new DlgVeliEkle();
			dlgTemp.center();
		}
	}

	private class CbxAdresBilgileriIlChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {

			// Window.alert(cbxAdresBilgileriIl.getSelectedIndex() + "");
			putIlceToCbx(cbxAdresBilgileriIl.getSelectedIndex(),
					cbxAdresBilgileriIlce);

		}
	}

	private class CbxAdresBilgileriIlceChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxAdresBilgileriIlce.getSelectedIndex() + "");
			putSemtToCbx(cbxAdresBilgileriIl.getItemText(cbxAdresBilgileriIl
					.getSelectedIndex()),
					cbxAdresBilgileriIlce.getItemText(cbxAdresBilgileriIlce
							.getSelectedIndex()), cbxSemt);
		}
	}

	private class CbxOgrenciBilgileriIlChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxOgrenciBilgileriIl.getSelectedIndex() + "");
			putIlceToCbx(cbxOgrenciBilgileriIl.getSelectedIndex(),
					cbxOgrenciBilgileriIlce);
		}
	}

	private class CbxOgrenciBilgileriIlceChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putOkulToCbx(cbxOgrenciBilgileriIl.getSelectedIndex(),
					cbxOgrenciBilgileriIlce.getSelectedIndex(), cbxOkul);
		}
	}

	private class CbxOgrenciKimlikBilgileriIlChangeHandler implements
			ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxOgrenciKimlikBilgileriIl.getSelectedIndex() +
			// "");
			putIlceToCbx(cbxOgrenciKimlikBilgileriIl.getSelectedIndex(),
					cbxOgrenciKimlikBilgileriIlce);

		}
	}

	private class CbxSemtChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxSemt.getSelectedIndex() + "");
			putMahalleToCbx(cbxAdresBilgileriIl.getItemText(cbxAdresBilgileriIl
					.getSelectedIndex()),
					cbxAdresBilgileriIlce.getItemText(cbxAdresBilgileriIlce
							.getSelectedIndex()), cbxSemt.getItemText(cbxSemt
							.getSelectedIndex()), cbxMahalle);

		}
	}
}
