package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.view.client.SingleSelectionModel;

public class DlgOnKayit extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	public DlgVeliEkle _dlgVeliler;

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
	private ListBox cbxGorusmeAlan;
	private ListBox cbxGorusmeEgitimTuru;
	private ListBox cbxGorusmeKursZamani;
	private ListBox cbxGorusmeSinif;
	private ListBox cbxGorusmeSonucu;
	private ListBox cbxGorusmeTipi;
	private DateBox dtpGorusmeTarihi;
	private TextBox tctGorusmeReferans;
	private ListBox cbxGorusmeIndirimturu;
	private ListBox cbxGorusmeIndirimMiktari;
	private TextBox tctAciklama;
	private TextBox tctGorusmeYuzdesi;
	private CellTable<XMLVeliler> grdVeliEkle;
	private ListBox cbxOkul;
	public DecoratedTabPanel tabOnKayit;
	private CaptionPanel cptnpnlNewPanel;
	private TextBox tctGorusmeKursIndirimFiyati;

	public DialogBox _dlgonkayit;
	private TextBox tctGorusmeIndirimSekli;
	private SimpleCheckBox chxKesinKayitMi;

	public DlgOnKayit(boolean isInsert, long id) {
		setGlassEnabled(true);

		_dlgonkayit = this;
		_isInsert = isInsert;
		_id = id;

		setAutoHideEnabled(false);
		setHTML("Ön Kayıt İşlemleri");

		VerticalPanel verticalpanel = new VerticalPanel();
		setWidget(verticalpanel);
		verticalpanel.setSize("854px", "737px");

		tabOnKayit = new DecoratedTabPanel();
		tabOnKayit.setAnimationEnabled(true);
		verticalpanel.add(tabOnKayit);
		tabOnKayit.setSize("462px", "705px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_2.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_2, "Öğrenci Bilgileri", false);
		absolutePanel_2.setSize("840px", "667px");

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
		absolutePanel_2.add(label_29, 10, 62);
		label_29.setSize("116px", "18px");

		Button btnBilgileriniGetir = new Button("Bilgilerini Getir");
		btnBilgileriniGetir
				.addClickHandler(new BtnBilgileriniGetirClickHandler());
		btnBilgileriniGetir.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_2.add(btnBilgileriniGetir, 299, 58);
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
		absolutePanel_2.add(label_31, 10, 144);
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
		absolutePanel_2.add(label_32, 10, 178);
		label_32.setSize("105px", "18px");

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
		label_33.setSize("127px", "18px");

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctEvTelefonu, 157, 212);
		tctEvTelefonu.setSize("125px", "14px");

		Label label_34 = new Label("E-Mail");
		label_34.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_34, 10, 244);
		label_34.setSize("85px", "18px");

		tctEmail = new TextBox();
		tctEmail.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctEmail, 157, 244);
		tctEmail.setSize("232px", "14px");

		tctCepTelefonu = new TextBox();
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctCepTelefonu, 301, 212);
		tctCepTelefonu.setSize("143px", "14px");

		cptnpnlNewPanel = new CaptionPanel("Okul Bilgileri");
		cptnpnlNewPanel.setStyleName("gwt-Bold");
		absolutePanel_2.add(cptnpnlNewPanel, 0, 279);
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
		cbxOgrenciBilgileriUlke.setSize("135px", "22px");

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
		cbxOkul.setStyleName("gwt-ComboBox1");
		flexTable.setWidget(3, 2, cbxOkul);
		cbxOkul.addItem(" ");
		cbxOkul.setSize("350px", "22px");

		Label label_26 = new Label("Sınıf");
		label_26.setStyleName("gwt-Bold");
		flexTable.setWidget(4, 0, label_26);
		label_26.setSize("26px", "18px");

		cbxOgrenciBilgileriSinif = new ListBox();
		cbxOgrenciBilgileriSinif.setStyleName("gwt-ComboBox1");
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
		cbxOgrenciBilgileriSinif.setSize("135px", "22px");

		chxKesinKayitMi = new SimpleCheckBox();
		absolutePanel_2.add(chxKesinKayitMi, 157, 86);

		Label lblKesinKayit = new Label("Kesin Kayit");
		lblKesinKayit.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblKesinKayit, 10, 86);

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
		label_5.setSize("93px", "18px");

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
		absolutePanel_5.add(cbxAdresBilgileriIlce, 125, 107);
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
		cbxMahalle.setSize("209px", "22px");

		tctSokakveNo = new TextBox();
		tctSokakveNo.setStyleName("gwt-TextBox1");
		absolutePanel_5.add(tctSokakveNo, 125, 230);
		tctSokakveNo.setSize("207px", "48px");

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_3, "DBS Sonuç", false);
		absolutePanel_3.setSize("840px", "712px");

		Label lblNewLabel_2 = new Label("Okul Durumu");
		lblNewLabel_2.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblNewLabel_2, 10, 22);

		Label lblAlanBilgisi = new Label("Alan Bilgisi");
		lblAlanBilgisi.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblAlanBilgisi, 10, 54);

		Label lblSnavTarihi = new Label("Sınav Tarihi");
		lblSnavTarihi.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblSnavTarihi, 10, 88);

		Label lblNewLabel_3 = new Label("DBS Sıralaması");
		lblNewLabel_3.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblNewLabel_3, 10, 122);

		Label lblSonuc = new Label("Sonuç");
		lblSonuc.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblSonuc, 10, 151);

		TextBox textBox = new TextBox();
		absolutePanel_3.add(textBox, 129, 22);
		textBox.setSize("115px", "10px");

		TextBox textBox_1 = new TextBox();
		absolutePanel_3.add(textBox_1, 129, 54);
		textBox_1.setSize("115px", "10px");

		TextBox textBox_2 = new TextBox();
		absolutePanel_3.add(textBox_2, 129, 88);
		textBox_2.setSize("115px", "10px");

		TextBox txtbxGirilmemi = new TextBox();
		txtbxGirilmemi.setReadOnly(true);
		txtbxGirilmemi.setText("Sonuç Girilmemiş");
		absolutePanel_3.add(txtbxGirilmemi, 129, 122);
		txtbxGirilmemi.setSize("115px", "10px");

		TextBox txtbxSonuGirilmemi = new TextBox();
		txtbxSonuGirilmemi.setReadOnly(true);
		txtbxSonuGirilmemi.setText("Sonuç Girilmemiş");
		absolutePanel_3.add(txtbxSonuGirilmemi, 129, 151);
		txtbxSonuGirilmemi.setSize("115px", "10px");

		TextBox textBox_5 = new TextBox();
		absolutePanel_3.add(textBox_5, 129, 186);
		textBox_5.setSize("115px", "10px");

		Label lblIndirimMiktar_1 = new Label("İndirim Miktarı");
		lblIndirimMiktar_1.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblIndirimMiktar_1, 10, 186);

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

		cbxGorusmeEgitimTuru = new ListBox();
		cbxGorusmeEgitimTuru.addItem(" ");
		cbxGorusmeEgitimTuru
				.addChangeHandler(new CbxGorusmeEgitimTuruChangeHandler());
		flexTable_1.setWidget(0, 1, cbxGorusmeEgitimTuru);
		cbxGorusmeEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxGorusmeEgitimTuru.setSize("140px", "18px");

		Label lblAlan = new Label("Alan");
		lblAlan.setStyleName("gwt-Bold");
		flexTable_1.setWidget(1, 0, lblAlan);

		cbxGorusmeAlan = new ListBox();
		// cbxGorusmeAlan.addChangeHandler(new CbxGorusmeAlanChangeHandler());
		cbxGorusmeAlan.addItem(" ");
		flexTable_1.setWidget(1, 1, cbxGorusmeAlan);
		cbxGorusmeAlan.setStyleName("gwt-ComboBox1");
		cbxGorusmeAlan.setSize("140px", "18px");

		Label lblKursZaman = new Label("Kurs Zamanı");
		lblKursZaman.setStyleName("gwt-Bold");
		flexTable_1.setWidget(2, 0, lblKursZaman);

		cbxGorusmeKursZamani = new ListBox();
		cbxGorusmeKursZamani
				.addChangeHandler(new CbxGorusmeKursZamaniChangeHandler());
		cbxGorusmeKursZamani.addItem(" ");
		flexTable_1.setWidget(2, 1, cbxGorusmeKursZamani);
		cbxGorusmeKursZamani.setStyleName("gwt-ComboBox1");
		cbxGorusmeKursZamani.setSize("140px", "18px");

		Label lblSnf = new Label("Sınıf");
		lblSnf.setStyleName("gwt-Bold");
		flexTable_1.setWidget(3, 0, lblSnf);

		cbxGorusmeSinif = new ListBox();
		cbxGorusmeSinif.addItem(" ");
		flexTable_1.setWidget(3, 1, cbxGorusmeSinif);
		cbxGorusmeSinif.setStyleName("gwt-ComboBox1");
		cbxGorusmeSinif.setSize("140px", "18px");

		Label lblNewLabel_1 = new Label("Kurs İndirim Fiyatı");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblNewLabel_1, 25, 195);
		lblNewLabel_1.setSize("132px", "16px");

		Label lblIndirimTr = new Label("İndirim Türü");
		absolutePanel_4.add(lblIndirimTr, 25, 234);
		lblIndirimTr.setStyleName("gwt-Bold");
		lblIndirimTr.setSize("89px", "18px");

		Label lblIndirimMiktar = new Label("İndirim Miktarı");
		absolutePanel_4.add(lblIndirimMiktar, 25, 268);
		lblIndirimMiktar.setStyleName("gwt-Bold");
		lblIndirimMiktar.setSize("132px", "18px");

		Label lblReferans = new Label("Referans");
		absolutePanel_4.add(lblReferans, 25, 308);
		lblReferans.setStyleName("gwt-Bold");

		Label lblGrmeTarihi = new Label("Görüşme Tarihi");
		absolutePanel_4.add(lblGrmeTarihi, 25, 352);
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

		cbxGorusmeIndirimturu = new ListBox();
		absolutePanel_4.add(cbxGorusmeIndirimturu, 163, 230);
		cbxGorusmeIndirimturu.addItem("Pazarlık");
		cbxGorusmeIndirimturu.addItem("İndirim Yok");
		cbxGorusmeIndirimturu.setStyleName("gwt-ComboBox1");
		cbxGorusmeIndirimturu.setSize("140px", "22px");

		cbxGorusmeIndirimMiktari = new ListBox();
		absolutePanel_4.add(cbxGorusmeIndirimMiktari, 163, 264);
		cbxGorusmeIndirimMiktari.addItem("Para");
		cbxGorusmeIndirimMiktari.addItem("Yüzde");
		cbxGorusmeIndirimMiktari.setStyleName("gwt-ComboBox1");
		cbxGorusmeIndirimMiktari.setSize("71px", "22px");

		tctGorusmeReferans = new TextBox();
		tctGorusmeReferans.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(tctGorusmeReferans, 163, 306);
		tctGorusmeReferans.setSize("138px", "14px");

		dtpGorusmeTarihi = new DateBox();
		dtpGorusmeTarihi.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(dtpGorusmeTarihi, 163, 350);
		dtpGorusmeTarihi
				.addValueChangeHandler(new DtpGorusmeTarihiValueChangeHandler());
		dtpGorusmeTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		dtpGorusmeTarihi.setSize("136px", "15px");

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
		tctGorusmeYuzdesi.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(tctGorusmeYuzdesi, 163, 480);
		tctGorusmeYuzdesi.setSize("138px", "14px");

		tctAciklama = new TextBox();
		tctAciklama.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(tctAciklama, 163, 520);
		tctAciklama.setSize("264px", "58px");

		tctGorusmeKursIndirimFiyati = new TextBox();
		tctGorusmeKursIndirimFiyati.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(tctGorusmeKursIndirimFiyati, 163, 191);
		tctGorusmeKursIndirimFiyati.setSize("138px", "14px");

		tctGorusmeIndirimSekli = new TextBox();
		tctGorusmeIndirimSekli.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(tctGorusmeIndirimSekli, 240, 266);
		tctGorusmeIndirimSekli.setSize("143px", "16px");

		AbsolutePanel absolutePanel_8 = new AbsolutePanel();
		absolutePanel_8.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_8, "Öğrenci Kimlik Bilgileri", false);
		absolutePanel_8.setSize("840px", "666px");

		Label label_6 = new Label("Seri No");
		label_6.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_6, 10, 8);
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
		absolutePanel_8.add(label_9, 10, 109);
		label_9.setSize("43px", "18px");

		Label label_10 = new Label("İl");
		label_10.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_10, 10, 148);
		label_10.setSize("20px", "18px");

		Label label_11 = new Label("İlçe");
		label_11.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_11, 10, 186);
		label_11.setSize("20px", "18px");

		Label label_12 = new Label("Mahalle / Köy");
		label_12.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_12, 10, 227);
		label_12.setSize("108px", "18px");

		Label label_13 = new Label("Cilt No");
		label_13.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_13, 10, 268);
		label_13.setSize("64px", "18px");

		Label label_14 = new Label("Aile Sıra No");
		label_14.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_14, 10, 308);
		label_14.setSize("88px", "18px");

		Label label_15 = new Label("Sıra No");
		label_15.setStyleName("gwt-Bold");
		absolutePanel_8.add(label_15, 10, 346);
		label_15.setSize("64px", "18px");

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
		label_19.setSize("116px", "18px");

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

		grdVeliEkle = new CellTable<XMLVeliler>();
		absolutePanel_7.add(grdVeliEkle, 10, 54);
		grdVeliEkle.setSize("715px", "174px");

		TextColumn<XMLVeliler> textColumn_4 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.veli_bilgileri_tc_kimlik_no.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_4, "TC Kimlik No");
		grdVeliEkle.setColumnWidth(textColumn_4, "129px");

		TextColumn<XMLVeliler> textColumn = new TextColumn<XMLVeliler>() {
			public String getValue(XMLVeliler object) {
				return object.veli_bilgileri_adi.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn, "Adı");

		TextColumn<XMLVeliler> textColumn_1 = new TextColumn<XMLVeliler>() {
			public String getValue(XMLVeliler object) {
				return object.veli_bilgileri_soyadi.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_1, "Soyadı");

		TextColumn<XMLVeliler> textColumn_2 = new TextColumn<XMLVeliler>() {
			public String getValue(XMLVeliler object) {
				return object.yakinlik_durumu;
			}
		};
		grdVeliEkle.addColumn(textColumn_2, "Yakınlık Durumu");

		Column<XMLVeliler, Boolean> column = new Column<XMLVeliler, Boolean>(
				new CheckboxCell()) {
			@Override
			public Boolean getValue(XMLVeliler object) {
				return (Boolean) null;
			}
		};
		grdVeliEkle.addColumn(column, "Ödeme Sorumlusu");

		TextColumn<XMLVeliler> textColumn_3 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.cep_tel.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_3, "Cep Tel");

		TextColumn<XMLVeliler> textColumn_5 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.is_tel.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_5, "İş Tel");

		Column<XMLVeliler, String> column_3 = new Column<XMLVeliler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return "?";
			}
		};
		grdVeliEkle.addColumn(column_3, "Düzenle");

		Column<XMLVeliler, String> column_4 = new Column<XMLVeliler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column_4, "Sil");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		verticalpanel.add(absolutePanel_1);
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
			putIlToCbx(cbxOgrenciBilgileriIl, cbxAdresBilgileriIl,
					cbxOgrenciKimlikBilgileriIl);
			putGorusmeKursZamaniToCbx(cbxGorusmeKursZamani);
			putEgitimTuruToCbx(cbxGorusmeEgitimTuru);

			putDataToGrid();

			final SingleSelectionModel<XMLVeliler> selectionModel = new SingleSelectionModel<XMLVeliler>();

			grdVeliEkle.setSelectionModel(selectionModel);
			grdVeliEkle.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLVeliler selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}

			}, DoubleClickEvent.getType());
		}

	}

	private void putEgitimTuruToCbx(final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturu");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLEgitimTuru> xmlEgitimTuru = XMLEgitimTuru.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuru.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuru.get(i).egitim_turu_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putEgitimTuruAlanToCbx(String egitim_turu_adi,
			final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getegitimturutanimlama?egitim_turu_adi="
						+ egitim_turu_adi);
		// Window.alert("egitim_turu_adi=" + egitim_turu_adi);
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLEgitimTuruTanimlama> xmlEgitimTuruTanimlama = XMLEgitimTuruTanimlama.XML
							.readList(response.getText());

					for (int i = 0; i < xmlEgitimTuruTanimlama.size(); i++) {

						lbxTemp.addItem(xmlEgitimTuruTanimlama.get(i).alan_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putGorusmeKursZamaniToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getkurszamanitanimlama");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLKursZamaniTanimlama> xmlKursZamaniTanimlama = XMLKursZamaniTanimlama.XML
							.readList(response.getText());

					for (int i = 0; i < xmlKursZamaniTanimlama.size(); i++) {

						lbxTemp.addItem(xmlKursZamaniTanimlama.get(i).kurs_zamani);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getveliler?tc_kimlik_no="
				+ tctTCKimlikNo.getText();

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

					List<XMLVeliler> listXmlVeliler = XMLVeliler.XML
							.readList(response.getText());

					_dlgVeliler = new DlgVeliEkle(false, new Long(id)
							.longValue());
					_dlgVeliler.putDataFromXML(listXmlVeliler.get(0));
					_dlgVeliler.center();
					_dlgVeliler.addCloseHandler(new CloseHandler<PopupPanel>() {

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

		String urlWithParameters = Util.urlBase + "getveliler?id="
		// + tctTCKimlikNo.getText();
				+ _id;

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

					List<XMLVeliler> listXmlVeliler = XMLVeliler.XML
							.readList(response.getText());

					// Window.alert("SIZE DBSKAYIT: " + listXmlDBSKayit.);

					// Window.alert("veli_bilgileri_adi: "
					// + listXmlVeliEkle.get(0).veli_bilgileri_adi);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdVeliEkle.setRowCount(1, true);

					// Push the data into the widget.
					grdVeliEkle.setRowData(0, listXmlVeliler);

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putIlToCbx(final ListBox lbxTemp, final ListBox lbxTemp2,
			final ListBox lbxTemp3) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		lbxTemp2.clear();
		lbxTemp2.addItem("");

		lbxTemp3.clear();
		lbxTemp3.addItem("");

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

						lbxTemp2.addItem(xmlil.get(i).il_adi);

						lbxTemp3.addItem(xmlil.get(i).il_adi);
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

	private void putSinifAdiToCbx(String egitim_turu, String alan,
			String kurs_zamani, final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getsiniftanimlari?egitim_turu=" + egitim_turu
						+ "&alan=" + alan + "&kurs_zamani=" + kurs_zamani);

		// Window.alert("egitim_turu_adi=" + egitim_turu_adi);
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLSinifTanimlari> xmlSinifTanimlari = XMLSinifTanimlari.XML
							.readList(response.getText());

					for (int i = 0; i < xmlSinifTanimlari.size(); i++) {

						lbxTemp.addItem(xmlSinifTanimlari.get(i).sinif_adi);
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

	public void putDataFromXML(XMLOnKayit xml) {

		// Window.alert("adi:" + xml.adi);
		// Window.alert(xml);
		tctAdi.setText(xml.adi);
		tctSoyadi.setText(xml.soyadi);
		tctTCKimlikNo.setText(xml.tc_kimlik_no);
		tctEvTelefonu.setText(xml.ev_telefonu);
		tctCepTelefonu.setText(xml.cep_telefonu);
		tctEmail.setText(xml.email);
		tctGorusmeReferans.setText(xml.gorusme_referans);
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
		tctGorusmeKursIndirimFiyati.setText(xml.gorusme_kurs_indirim_fiyati);
		tctGorusmeYuzdesi.setText(xml.gorusme_yuzdesi);
		tctMahalleKoy.setText(xml.mahalle_koy);
		tctGorusmeIndirimSekli.setText(xml.gorusme_indirim_sekli);

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

		cbxGorusmeSinif.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGorusmeSinif, xml.gorusme_sinif));
		cbxGorusmeIndirimturu.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGorusmeIndirimturu, xml.gorusme_indirim_turu));
		cbxGorusmeIndirimMiktari.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGorusmeIndirimMiktari, xml.gorusme_indirim_miktari));
		cbxGorusmeTipi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGorusmeTipi, xml.gorusme_tipi));
		cbxGorusmeSonucu.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxGorusmeSonucu, xml.gorusme_sonucu));
		cbxAdresBilgileriUlke.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxAdresBilgileriUlke, xml.adres_bilgileri_ulke));
		cbxOgrenciKimlikBilgileriUlke.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxOgrenciBilgileriUlke,
						xml.ogrenci_kimlik_bilgileri_ulke));

		cbxGorusmeKursZamani.setItemText(0, xml.gorusme_kurs_zamani);
		cbxGorusmeEgitimTuru.setItemText(0, xml.gorusme_egitim_turu);
		cbxGorusmeAlan.setItemText(0, xml.gorusme_alan);

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

		chxKesinKayitMi
				.setValue(xml.kesin_kayit_mi.equalsIgnoreCase("t") ? true
						: false);

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

		dtpDogumTarihi.setValue(dtf.parse(xml.dogum_tarihi));
		dtpVerilisTarihi.setValue(dtf.parse(xml.verilis_tarihi));
		dtpGorusmeTarihi.setValue(dtf.parse(xml.gorusme_tarihi));

	}

	private class BtnYeniOgrenciClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String URLValue = Util.urlBase + "putonkayit?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&adi=" + tctAdi.getText();
			URLValue = URLValue + "&soyadi=" + tctSoyadi.getText();
			URLValue = URLValue + "&tc_kimlik_no=" + tctTCKimlikNo.getText();
			URLValue = URLValue + "&cinsiyet="
					+ cbxCinsiyet.getValue(cbxCinsiyet.getSelectedIndex());
			URLValue = URLValue + "&medeni_hali="
					+ cbxMedeniHali.getValue(cbxMedeniHali.getSelectedIndex());
			URLValue = URLValue + "&ev_telefonu=" + tctEvTelefonu.getText();
			URLValue = URLValue + "&cep_telefonu=" + tctCepTelefonu.getText();
			URLValue = URLValue + "&email=" + tctEmail.getText();
			URLValue = URLValue + "&gorusme_kurs_indirim_fiyati="
					+ tctGorusmeKursIndirimFiyati.getText();

			URLValue = URLValue
					+ "&ogrenci_bilgileri_ulke="
					+ cbxOgrenciBilgileriUlke.getValue(cbxOgrenciBilgileriUlke
							.getSelectedIndex());

			URLValue = URLValue
					+ "&ogrenci_bilgileri_il="
					+ cbxOgrenciBilgileriIl.getItemText(cbxOgrenciBilgileriIl
							.getSelectedIndex());

			URLValue = URLValue
					+ "&ogrenci_bilgileri_ilce="
					+ cbxOgrenciBilgileriIlce
							.getItemText(cbxOgrenciBilgileriIlce
									.getSelectedIndex());
			URLValue = URLValue + "&okul="
					+ cbxOkul.getItemText(cbxOkul.getSelectedIndex());

			URLValue = URLValue
					+ "&ogrenci_bilgileri_sinif="
					+ cbxOgrenciBilgileriSinif
							.getValue(cbxOgrenciBilgileriSinif
									.getSelectedIndex());

			URLValue = URLValue
					+ "&gorusme_egitim_turu="
					+ cbxGorusmeEgitimTuru.getItemText(cbxGorusmeEgitimTuru
							.getSelectedIndex());
			URLValue = URLValue
					+ "&gorusme_alan="
					+ cbxGorusmeAlan.getItemText(cbxGorusmeAlan
							.getSelectedIndex());
			URLValue = URLValue
					+ "&gorusme_kurs_zamani="
					+ cbxGorusmeKursZamani.getItemText(cbxGorusmeKursZamani
							.getSelectedIndex());
			URLValue = URLValue
					+ "&gorusme_sinif="
					+ cbxGorusmeSinif.getValue(cbxGorusmeSinif
							.getSelectedIndex());
			URLValue = URLValue
					+ "&gorusme_indirim_turu="
					+ cbxGorusmeIndirimturu.getValue(cbxGorusmeIndirimturu
							.getSelectedIndex());
			URLValue = URLValue
					+ "&gorusme_indirim_miktari="
					+ cbxGorusmeIndirimMiktari
							.getValue(cbxGorusmeIndirimMiktari
									.getSelectedIndex());
			URLValue = URLValue + "&gorusme_indirim_sekli="
					+ tctGorusmeIndirimSekli.getText();

			URLValue = URLValue + "&gorusme_referans="
					+ tctGorusmeReferans.getText();
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
					+ cbxAdresBilgileriIl.getItemText(cbxAdresBilgileriIl
							.getSelectedIndex());
			URLValue = URLValue
					+ "&adres_bilgileri_ilce="
					+ cbxAdresBilgileriIlce.getItemText(cbxAdresBilgileriIlce
							.getSelectedIndex());
			URLValue = URLValue + "&semt="
					+ cbxSemt.getItemText(cbxSemt.getSelectedIndex());
			URLValue = URLValue + "&mahalle="
					+ cbxMahalle.getItemText(cbxMahalle.getSelectedIndex());

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
							.getItemText(cbxOgrenciKimlikBilgileriIl
									.getSelectedIndex());
			URLValue = URLValue
					+ "&ogrenci_kimlik_bilgileri_ilce="
					+ cbxOgrenciKimlikBilgileriIlce
							.getItemText(cbxOgrenciKimlikBilgileriIlce
									.getSelectedIndex());
			URLValue = URLValue + "&mahalle_koy=" + tctMahalleKoy.getText();
			URLValue = URLValue + "&cilt_no=" + tctCiltNo.getText();
			URLValue = URLValue + "&aile_sira_no=" + tctAileSiraNo.getText();
			URLValue = URLValue + "&sira_no=" + tctSiraNo.getText();
			URLValue = URLValue + "&verildigi_yer=" + tctVerildigiYer.getText();
			URLValue = URLValue + "&verilis_nedeni="
					+ tctVerilisNedeni.getText();
			URLValue = URLValue + "&kayit_no=" + tctKayitNo.getText();
			URLValue = URLValue + "&kesin_kayit_mi="
					+ chxKesinKayitMi.getValue().toString();

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&dogum_tarihi="
					+ dtf.format(dtpDogumTarihi.getValue());

			URLValue = URLValue + "&gorusme_tarihi="
					+ dtf.format(dtpGorusmeTarihi.getValue());

			URLValue = URLValue + "&verilis_tarihi="
					+ dtf.format(dtpVerilisTarihi.getValue());

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

			_dlgVeliler = new DlgVeliEkle(true, -1);
			_dlgVeliler.center();
			_dlgVeliler.setAnimationEnabled(true);
			Window.alert("id= " + _id);
			_dlgVeliler.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid();

				}
			});

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

	private class BtnBilgileriniGetirClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String urlWithParameters = Util.urlBase + "getonkayit"
					+ "?tc_kimlik_no=" + tctTCKimlikNo.getText();

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

								DlgOnKayit dlgTemp = new DlgOnKayit(_isInsert,
										-1);
								_dlgonkayit.hide();
								dlgTemp.putDataFromXML(listXmlOnKayit.get(0));
								dlgTemp.center();
								dlgTemp.tabOnKayit.selectTab(0);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}

	private class CbxGorusmeEgitimTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxGorusmeEgitimTuru.getSelectedIndex() + "");
			putEgitimTuruAlanToCbx(
					cbxGorusmeEgitimTuru.getItemText(cbxGorusmeEgitimTuru
							.getSelectedIndex()), cbxGorusmeAlan);

		}
	}

	// private class CbxGorusmeAlanChangeHandler implements ChangeHandler {
	// public void onChange(ChangeEvent event) {
	// putSinifAdiToCbx(
	// cbxGorusmeEgitimTuru.getItemText(cbxGorusmeEgitimTuru
	// .getSelectedIndex()),
	// cbxGorusmeAlan.getItemText(cbxGorusmeAlan
	// .getSelectedIndex()), cbxGorusmeSinif);

	// }
	// }
	private class CbxGorusmeKursZamaniChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putSinifAdiToCbx(
					cbxGorusmeEgitimTuru.getItemText(cbxGorusmeEgitimTuru
							.getSelectedIndex()),
					cbxGorusmeAlan.getItemText(cbxGorusmeAlan
							.getSelectedIndex()),
					cbxGorusmeKursZamani.getItemText(cbxGorusmeKursZamani
							.getSelectedIndex()), cbxGorusmeSinif);
		}
	}
}
