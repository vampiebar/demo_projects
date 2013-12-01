package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
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
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class DlgDBSYeniKayit extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;

	private TextBox tctAdi;
	private TextBox tctSoyadi;
	private TextBox tctTCKimlikNo;
	private ListBox cbxCinsiyet;
	private ListBox cbxMedeniHali;
	private DateBox dtpDogumTarihi;
	private TextBox tctEvTelefonu;
	private TextBox tctCepTelefonu;
	private TextBox tctEmail;
	private ListBox cbxOgrenciBilgileriUlke;
	private ListBox cbxOgrenciBilgileriIl;
	private ListBox cbxOgrenciBilgileriIlce;
	private ListBox cbxOgrenciBilgileriSinif;
	private TextBox tctSeriNo;
	private TextBox tctCuzdanNo;
	private ListBox cbxOgrenciKimlikBilgileriUlke;
	private ListBox cbxOgrenciKimlikBilgileriIl;
	private ListBox cbxOgrenciKimlikBilgileriIlce;
	private TextBox tctMahalleKoy;
	private TextBox tctCiltNo;
	private TextBox tctAileSiraNo;
	private TextBox tctSiraNo;
	private TextBox tctVerildigiYer;
	private TextBox tctVerilisNedeni;
	private TextBox tctKayitNo;
	private DateBox dtpVerilisTarihi;
	private ListBox cbxAdresBilgileriUlke;
	private ListBox cbxAdresBilgileriIl;
	private ListBox cbxAdresBilgileriIlce;
	private ListBox cbxSemt;
	private ListBox cbxMahalle;
	private TextBox tctSokakveNo;
	private ListBox cbxOkulDurumu;
	private ListBox cbxAlanbilgisi;
	private ListBox cbxSinavTarihi;
	private AbsolutePanel vtpanOgrenciBilgileri;
	private ListBox cbxOkul;
	private CellTable<XMLVeliEkle> grdVeliEkle;

	public DialogBox _dlgDBSYeniKayit;

	public DlgDBSYeniKayit(boolean isInsert, long id) {

		_dlgDBSYeniKayit = this;
		_isInsert = isInsert;
		_id = id;

		setAutoHideOnHistoryEventsEnabled(false);
		setAutoHideEnabled(false);
		setHTML("DBS Sınav Kayıt");

		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		setWidget(decoratedTabPanel);
		decoratedTabPanel.setSize("742px", "642px");

		vtpanOgrenciBilgileri = new AbsolutePanel();
		vtpanOgrenciBilgileri.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel
				.add(vtpanOgrenciBilgileri, "Öğrenci Bilgileri", false);
		vtpanOgrenciBilgileri.setSize("736px", "524px");

		Label lblNewLabel = new Label("Adı");
		lblNewLabel.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblNewLabel, 10, 4);
		lblNewLabel.setSize("133px", "18px");

		Label lblNewLabel_1 = new Label("Soyadi");
		lblNewLabel_1.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblNewLabel_1, 10, 28);
		lblNewLabel_1.setSize("203px", "18px");

		tctAdi = new TextBox();
		tctAdi.setStyleName("gwt-TextBox1");
		vtpanOgrenciBilgileri.add(tctAdi, 157, 4);
		tctAdi.setSize("232px", "14px");

		Label lblTcKimlikNo = new Label("T.C. Kimlik No ");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblTcKimlikNo, 10, 52);

		Button btnBilgileriniGetir = new Button("Bilgilerini Getir");
		btnBilgileriniGetir
				.addClickHandler(new BtnBilgileriniGetirClickHandler());

		btnBilgileriniGetir.setStyleName("gwt-ButonYeniKayit");
		vtpanOgrenciBilgileri.add(btnBilgileriniGetir, 298, 52);
		btnBilgileriniGetir.setSize("113px", "22px");

		tctSoyadi = new TextBox();
		tctSoyadi.setStyleName("gwt-TextBox1");
		vtpanOgrenciBilgileri.add(tctSoyadi, 157, 28);
		tctSoyadi.setSize("232px", "14px");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		vtpanOgrenciBilgileri.add(tctTCKimlikNo, 157, 56);
		tctTCKimlikNo.setSize("126px", "14px");

		Label lblCinsiyet = new Label("Cinsiyet");
		lblCinsiyet.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblCinsiyet, 10, 106);

		Label lblMedeniHali = new Label("Medeni Hali");
		lblMedeniHali.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblMedeniHali, 10, 134);
		lblMedeniHali.setSize("85px", "18px");

		cbxCinsiyet = new ListBox();
		cbxCinsiyet.setStyleName("gwt-ComboBox1");
		cbxCinsiyet.addItem("Erkek");
		cbxCinsiyet.addItem("Kız");
		vtpanOgrenciBilgileri.add(cbxCinsiyet, 157, 102);
		cbxCinsiyet.setSize("128px", "22px");

		cbxMedeniHali = new ListBox();
		cbxMedeniHali.setStyleName("gwt-ComboBox1");
		cbxMedeniHali.addItem("Bekar");
		cbxMedeniHali.addItem("Evli");
		vtpanOgrenciBilgileri.add(cbxMedeniHali, 157, 134);
		cbxMedeniHali.setSize("128px", "22px");

		Label lblDoumTarihi = new Label("Doğum Tarihi");
		lblDoumTarihi.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblDoumTarihi, 10, 168);

		dtpDogumTarihi = new DateBox();
		dtpDogumTarihi.setStyleName("gwt-TextBox1");
		dtpDogumTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpDogumTarihi
				.addValueChangeHandler(new DtpDogumTarihiValueChangeHandler());
		vtpanOgrenciBilgileri.add(dtpDogumTarihi, 157, 172);
		dtpDogumTarihi.setSize("124px", "14px");

		Label lblEvCep = new Label("Ev / Cep Telefonu");
		lblEvCep.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblEvCep, 10, 206);

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		vtpanOgrenciBilgileri.add(tctEvTelefonu, 157, 206);
		tctEvTelefonu.setSize("126px", "14px");

		Label lblEmail = new Label("E-Mail");
		lblEmail.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblEmail, 10, 242);
		lblEmail.setSize("37px", "18px");

		Label lblOkulBilgisi = new Label("OKUL BİLGİSİ");
		lblOkulBilgisi.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblOkulBilgisi, 10, 273);

		tctEmail = new TextBox();
		tctEmail.setStyleName("gwt-TextBox1");
		vtpanOgrenciBilgileri.add(tctEmail, 157, 242);
		tctEmail.setSize("232px", "14px");

		Label lblUlke = new Label("Ulke");
		lblUlke.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblUlke, 10, 308);

		Label label = new Label("İl");
		label.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(label, 10, 344);
		label.setSize("26px", "18px");

		Label lblNewLabel_2 = new Label("İlçe");
		lblNewLabel_2.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblNewLabel_2, 10, 380);

		Label lblNewLabel_3 = new Label("Okul");
		lblNewLabel_3.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblNewLabel_3, 10, 419);

		Label lblNewLabel_4 = new Label("Sınıf");
		lblNewLabel_4.setStyleName("gwt-Bold");
		vtpanOgrenciBilgileri.add(lblNewLabel_4, 10, 457);

		cbxOgrenciBilgileriSinif = new ListBox();
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
		cbxOgrenciBilgileriSinif.setStyleName("gwt-ComboBox1");
		vtpanOgrenciBilgileri.add(cbxOgrenciBilgileriSinif, 157, 453);
		cbxOgrenciBilgileriSinif.setSize("138px", "22px");

		cbxOgrenciBilgileriUlke = new ListBox();
		cbxOgrenciBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriUlke.addItem("Türkiye");
		vtpanOgrenciBilgileri.add(cbxOgrenciBilgileriUlke, 157, 308);
		cbxOgrenciBilgileriUlke.setSize("138px", "22px");

		cbxOgrenciBilgileriIl = new ListBox();
		cbxOgrenciBilgileriIl
				.addChangeHandler(new CbxOgrenciBilgileriIlChangeHandler());
		cbxOgrenciBilgileriIl.addItem(" ");
		cbxOgrenciBilgileriIl.setStyleName("gwt-ComboBox1");
		vtpanOgrenciBilgileri.add(cbxOgrenciBilgileriIl, 157, 345);
		cbxOgrenciBilgileriIl.setSize("153px", "22px");

		cbxOgrenciBilgileriIlce = new ListBox();
		cbxOgrenciBilgileriIlce
				.addChangeHandler(new CbxOgrenciBilgileriIlceChangeHandler());
		cbxOgrenciBilgileriIlce.addItem(" ");
		cbxOgrenciBilgileriIlce.setStyleName("gwt-ComboBox1");
		vtpanOgrenciBilgileri.add(cbxOgrenciBilgileriIlce, 157, 380);
		cbxOgrenciBilgileriIlce.setSize("153px", "22px");

		tctCepTelefonu = new TextBox();
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		vtpanOgrenciBilgileri.add(tctCepTelefonu, 304, 206);
		tctCepTelefonu.setSize("143px", "14px");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		vtpanOgrenciBilgileri.add(horizontalPanel_3, 472, 452);
		horizontalPanel_3.setSize("254px", "72px");

		Button btnYeniKayit5 = new Button("Yeni Kayıt");
		horizontalPanel_3.add(btnYeniKayit5);
		btnYeniKayit5.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit5.setSize("78px", "50px");

		Button btnOgrenciyiKaydet5 = new Button("Öğrenciyi Kaydet");
		horizontalPanel_3.add(btnOgrenciyiKaydet5);
		btnOgrenciyiKaydet5.setStyleName("gwt-ButtonSave");
		btnOgrenciyiKaydet5
				.addClickHandler(new BtnOgrenciyiKaydet5ClickHandler());
		btnOgrenciyiKaydet5.setSize("78px", "49px");

		Button btnKapat5 = new Button("Kapat");
		horizontalPanel_3.add(btnKapat5);
		btnKapat5.setStyleName("gwt-ButonKapat");
		btnKapat5.addClickHandler(new BtnKapat5ClickHandler_1());
		btnKapat5.setSize("78px", "50px");

		cbxOkul = new ListBox();
		cbxOkul.setStyleName("gwt-ComboBox1");
		cbxOkul.addItem(" ");
		vtpanOgrenciBilgileri.add(cbxOkul, 157, 419);
		cbxOkul.setSize("292px", "22px");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		decoratedTabPanel.add(verticalPanel_1, "Öğrenci Kimlik Bilgileri",
				false);
		verticalPanel_1.setSize("5cm", "3cm");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		verticalPanel_1.add(absolutePanel);
		absolutePanel.setSize("706px", "648px");

		Label lblSeriNo = new Label("Seri No");
		lblSeriNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblSeriNo, 10, 22);

		Label lblCzdanNo = new Label("Cüzdan No");
		lblCzdanNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblCzdanNo, 10, 59);

		Label lblNewLabel_5 = new Label("Kayıtlı Oldugu");
		lblNewLabel_5.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_5, 10, 96);

		Label lblIl = new Label("Ülke");
		lblIl.setStyleName("gwt-Bold");
		absolutePanel.add(lblIl, 10, 131);
		lblIl.setSize("43px", "18px");

		Label lblNewLabel_6 = new Label("İl");
		lblNewLabel_6.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_6, 10, 166);

		Label lblNewLabel_7 = new Label("İlçe");
		lblNewLabel_7.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_7, 10, 200);

		Label lblNewLabel_8 = new Label("Mahalle / Köy");
		lblNewLabel_8.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_8, 10, 245);

		Label lblNewLabel_9 = new Label("Cilt No");
		lblNewLabel_9.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_9, 10, 286);

		Label lblNewLabel_10 = new Label("Aile Sıra No");
		lblNewLabel_10.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_10, 10, 326);

		Label lblSraNo = new Label("Sıra No");
		lblSraNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblSraNo, 10, 364);

		Label lblCzdanBilgileri = new Label("Cüzdan Bilgileri");
		lblCzdanBilgileri.setStyleName("gwt-Bold");
		absolutePanel.add(lblCzdanBilgileri, 10, 398);

		Label lblVerildiiYer = new Label("Verildiği Yer");
		lblVerildiiYer.setStyleName("gwt-Bold");
		absolutePanel.add(lblVerildiiYer, 10, 436);

		Label lblVeriliNedeni = new Label("Veriliş Nedeni");
		lblVeriliNedeni.setStyleName("gwt-Bold");
		absolutePanel.add(lblVeriliNedeni, 10, 474);

		Label lblNewLabel_11 = new Label("Kayıt No");
		lblNewLabel_11.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_11, 10, 509);

		dtpVerilisTarihi = new DateBox();
		dtpVerilisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpVerilisTarihi.setStyleName("gwt-TextBox1");
		absolutePanel.add(dtpVerilisTarihi, 130, 547);
		dtpVerilisTarihi.setSize("158px", "14px");

		Label lblNewLabel_12 = new Label("Veriliş Tarihi");
		lblNewLabel_12.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_12, 10, 547);

		tctSeriNo = new TextBox();
		tctSeriNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSeriNo, 130, 18);
		tctSeriNo.setSize("158px", "14px");

		tctCuzdanNo = new TextBox();
		tctCuzdanNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctCuzdanNo, 130, 55);
		tctCuzdanNo.setSize("158px", "14px");

		tctMahalleKoy = new TextBox();
		tctMahalleKoy.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctMahalleKoy, 130, 241);
		tctMahalleKoy.setSize("158px", "14px");

		tctCiltNo = new TextBox();
		tctCiltNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctCiltNo, 130, 282);
		tctCiltNo.setSize("158px", "14px");

		tctAileSiraNo = new TextBox();
		tctAileSiraNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAileSiraNo, 130, 322);
		tctAileSiraNo.setSize("158px", "14px");

		tctSiraNo = new TextBox();
		tctSiraNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSiraNo, 130, 360);
		tctSiraNo.setSize("158px", "14px");

		tctVerildigiYer = new TextBox();
		tctVerildigiYer.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVerildigiYer, 130, 432);
		tctVerildigiYer.setSize("158px", "14px");

		tctVerilisNedeni = new TextBox();
		tctVerilisNedeni.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctVerilisNedeni, 130, 470);
		tctVerilisNedeni.setSize("158px", "14px");

		tctKayitNo = new TextBox();
		tctKayitNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctKayitNo, 130, 505);
		tctKayitNo.setSize("158px", "14px");

		cbxOgrenciKimlikBilgileriUlke = new ListBox();
		cbxOgrenciKimlikBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriUlke.addItem("Türkiye");
		absolutePanel.add(cbxOgrenciKimlikBilgileriUlke, 130, 127);
		cbxOgrenciKimlikBilgileriUlke.setSize("162px", "22px");

		cbxOgrenciKimlikBilgileriIl = new ListBox();
		cbxOgrenciKimlikBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriIl
				.addChangeHandler(new CbxOgrenciKimlikBilgileriIlChangeHandler());
		cbxOgrenciKimlikBilgileriIl.addItem(" ");
		absolutePanel.add(cbxOgrenciKimlikBilgileriIl, 130, 162);
		cbxOgrenciKimlikBilgileriIl.setSize("162px", "22px");

		cbxOgrenciKimlikBilgileriIlce = new ListBox();
		cbxOgrenciKimlikBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriIlce.addItem(" ");
		absolutePanel.add(cbxOgrenciKimlikBilgileriIlce, 130, 200);
		cbxOgrenciKimlikBilgileriIlce.setSize("162px", "22px");

		VerticalPanel verticalPanel_2 = new VerticalPanel();
		decoratedTabPanel.add(verticalPanel_2, "Adres Bilgileri", false);
		verticalPanel_2.setSize("166px", "218px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		verticalPanel_2.add(absolutePanel_1);

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_2.setStyleName("gwt-DialogBackGround");
		verticalPanel_2.add(absolutePanel_2);
		absolutePanel_2.setSize("651px", "427px");

		Label lblNewLabel_13 = new Label("Ülke");
		lblNewLabel_13.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblNewLabel_13, 10, 25);

		Label lblNewLabel_14 = new Label("İl");
		lblNewLabel_14.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblNewLabel_14, 10, 68);
		lblNewLabel_14.setSize("26px", "18px");

		Label lblNewLabel_15 = new Label("İlçe");
		lblNewLabel_15.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblNewLabel_15, 10, 112);

		Label lblNewLabel_16 = new Label("Semt");
		lblNewLabel_16.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblNewLabel_16, 10, 156);

		Label lblNewLabel_17 = new Label("Mahalle");
		lblNewLabel_17.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblNewLabel_17, 10, 197);

		Label lblNewLabel_18 = new Label("Sokak ve no");
		lblNewLabel_18.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblNewLabel_18, 10, 237);

		cbxAdresBilgileriUlke = new ListBox();
		cbxAdresBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriUlke.addItem("Türkiye");
		absolutePanel_2.add(cbxAdresBilgileriUlke, 125, 17);
		cbxAdresBilgileriUlke.setSize("156px", "22px");

		cbxAdresBilgileriIl = new ListBox();
		cbxAdresBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriIl
				.addChangeHandler(new CbxAdresBilgileriIlChangeHandler());
		cbxAdresBilgileriIl.addItem(" ");
		absolutePanel_2.add(cbxAdresBilgileriIl, 125, 64);
		cbxAdresBilgileriIl.setSize("156px", "22px");

		cbxAdresBilgileriIlce = new ListBox();
		cbxAdresBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriIlce
				.addChangeHandler(new CbxAdresBilgileriIlceChangeHandler());
		cbxAdresBilgileriIlce.addItem(" ");
		absolutePanel_2.add(cbxAdresBilgileriIlce, 125, 118);
		cbxAdresBilgileriIlce.setSize("156px", "22px");

		cbxSemt = new ListBox();
		cbxSemt.setStyleName("gwt-ComboBox1");
		cbxSemt.addChangeHandler(new CbxSemtChangeHandler());
		cbxSemt.addItem(" ");
		absolutePanel_2.add(cbxSemt, 125, 152);
		cbxSemt.setSize("156px", "22px");

		cbxMahalle = new ListBox();
		cbxMahalle.setStyleName("gwt-ComboBox1");
		cbxMahalle.addItem(" ");
		absolutePanel_2.add(cbxMahalle, 125, 193);
		cbxMahalle.setSize("220px", "22px");

		tctSokakveNo = new TextBox();
		tctSokakveNo.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctSokakveNo, 125, 237);
		tctSokakveNo.setSize("218px", "48px");

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel.add(absolutePanel_3, "Sınav Bilgileri", false);
		absolutePanel_3.setSize("667px", "433px");

		Label lblNewLabel_19 = new Label("Okul Durumu");
		lblNewLabel_19.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblNewLabel_19, 22, 29);

		Label lblNewLabel_20 = new Label("Alan Bilgisi");
		lblNewLabel_20.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblNewLabel_20, 22, 68);

		Label lblNewLabel_21 = new Label("Sınav Tarihi");
		lblNewLabel_21.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblNewLabel_21, 22, 111);

		cbxOkulDurumu = new ListBox();
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
		cbxOkulDurumu.addItem("12.Sınıf");
		cbxOkulDurumu.setStyleName("gwt-ComboBox1");
		absolutePanel_3.add(cbxOkulDurumu, 126, 21);
		cbxOkulDurumu.setSize("132px", "22px");

		cbxAlanbilgisi = new ListBox();
		cbxAlanbilgisi.addItem("a");
		cbxAlanbilgisi.addItem("b");
		cbxAlanbilgisi.setStyleName("gwt-ComboBox1");
		absolutePanel_3.add(cbxAlanbilgisi, 126, 64);
		cbxAlanbilgisi.setSize("132px", "22px");

		cbxSinavTarihi = new ListBox();
		cbxSinavTarihi.addItem("2013-11-24");
		cbxSinavTarihi.setStyleName("gwt-ComboBox1");
		absolutePanel_3.add(cbxSinavTarihi, 126, 107);
		cbxSinavTarihi.setSize("132px", "22px");

		AbsolutePanel absolutePanel_4 = new AbsolutePanel();
		absolutePanel_4.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel.add(absolutePanel_4, "Veli Bilgileri", false);
		absolutePanel_4.setSize("803px", "500px");

		Button btnVeliEkle = new Button("Veli Ekle");
		btnVeliEkle.addClickHandler(new BtnVeliEkleClickHandler());
		btnVeliEkle.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_4.add(btnVeliEkle, 10, 10);

		grdVeliEkle = new CellTable<XMLVeliEkle>();
		absolutePanel_4.add(grdVeliEkle, 0, 42);
		grdVeliEkle.setSize("715px", "174px");

		TextColumn<XMLVeliEkle> textColumn_4 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.veli_bilgileri_tc_kimlik_no.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_4, "TC Kimlik No");

		Column<XMLVeliEkle, ?> textColumn_3 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.veli_bilgileri_adi.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_3, "Adı");

		TextColumn<XMLVeliEkle> textColumn_2 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.veli_bilgileri_soyadi.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_2, "Soyadı");

		TextColumn<XMLVeliEkle> textColumn_1 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.yakinlik_durumu;
			}
		};
		grdVeliEkle.addColumn(textColumn_1, "Yakınlık Durumu");

		TextColumn<XMLVeliEkle> textColumn = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.odeme_sorumlusu;
			}
		};
		grdVeliEkle.addColumn(textColumn, "Ödeme Sorumlusu");

		TextColumn<XMLVeliEkle> textColumn_5 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.cep_tel.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_5, "Cep Tel");

		TextColumn<XMLVeliEkle> textColumn_6 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.is_tel.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_6, "İş Tel");

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

		// Set Default page
		decoratedTabPanel.selectTab(0);

		if (!isDesignTime()) {

			putIlToCbx(cbxOgrenciBilgileriIl);

			putIlToCbx(cbxOgrenciKimlikBilgileriIl);

			putIlToCbx(cbxAdresBilgileriIl);

			putDataToGrid();

			// final SingleSelectionModel<XMLVeliEkle> selectionModel = new
			// SingleSelectionModel<XMLVeliEkle>();
			//
			// // grdVeliEkle.setSelectionModel(selectionModel);
			// grdVeliEkle.addDomHandler(new DoubleClickHandler() {
			//
			// @Override
			// public void onDoubleClick(final DoubleClickEvent event) {
			// XMLVeliEkle selected = selectionModel.getSelectedObject();
			// if (selected != null) {
			// // DO YOUR STUFF
			//
			// // Window.alert("selected id: " + selected.id);
			// showWithData(selected.id);
			//
			// }
			//
			// }
			// }, DoubleClickEvent.getType());
		}
	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase + "getveliler";

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

					List<XMLVeliEkle> listXmlVeliEkle = XMLVeliEkle.XML
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
					grdVeliEkle.setRowData(0, listXmlVeliEkle);

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	// protected void showWithData(String id) {
	//
	// String urlWithParameters = Util.urlBase + "getveliler?id=" + id;
	//
	// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
	// urlWithParameters);
	//
	// // Window.alert("URL TO GET VALUES: " + urlWithParameters);
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
	// // Window.alert("AAABBBCCC " + response.getText());
	//
	// List<XMLVeliEkle> listXmlVeliEkle = XMLVeliEkle.XML
	// .readList(response.getText());
	//
	// DlgVeliEkle dlgTemp = new DlgVeliEkle();
	// dlgTemp.putDataFromXML(listXmlVeliEkle.get(0));
	// dlgTemp.center();
	//
	// }
	//
	// });
	//
	// } catch (RequestException e) {
	// // displayError("Couldn't retrieve JSON");
	//
	// // Window.alert(e.getMessage() + "ERROR");
	// }
	//
	// }

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
		lbxTemp.addItem("");

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

	// private void putDataToGrid() {
	//
	// String urlWithParameters = Util.urlBase + "getveliler";
	//
	// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
	// urlWithParameters);
	//
	// // Window.alert("URL TO GET VALUES: " + urlWithParameters);
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
	// // Window.alert("AAABBBCCC " + response.getText());
	//
	// List<XMLVeliEkle> listXmlVeliEkle = XMLVeliEkle.XML
	// .readList(response.getText());
	//
	// // Window.alert("SIZE DBSKAYIT: " + listXmlDBSKayit.);
	//
	// // Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);
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
	// // Window.alert(e.getMessage() + "ERROR");
	// }
	//
	// }

	// Implement the following method exactly as-is
	private static final boolean isDesignTime() {
		// return Beans.isDesignTime(); // GWT 2.4 and above
		return false; // GWT 2.2 and earlier

	}

	public void putDataFromXML(XMLDBSKayit xml) {
		tctAdi.setText(xml.adi);
		tctSoyadi.setText(xml.soyadi);
		tctTCKimlikNo.setText(xml.tc_kimlik_no);
		tctEvTelefonu.setText(xml.ev_telefonu);
		tctCepTelefonu.setText(xml.cep_telefonu);
		tctEmail.setText(xml.email);
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

		cbxAdresBilgileriUlke.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxAdresBilgileriUlke, xml.adres_bilgileri_ulke));

		cbxOgrenciKimlikBilgileriUlke.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxOgrenciBilgileriUlke,
						xml.ogrenci_kimlik_bilgileri_ulke));

		cbxOkulDurumu.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOkulDurumu, xml.okul_durumu));
		cbxAlanbilgisi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxAlanbilgisi, xml.alan_bilgisi));
		cbxSinavTarihi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxSinavTarihi, xml.sinav_tarihi));

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

		// Window.alert("DOG T: " + xml.dogum_tarihi);

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
		dtpDogumTarihi.setValue(dtf.parse(xml.dogum_tarihi));
		dtpVerilisTarihi.setValue(dtf.parse(xml.verilis_tarihi));

	}

	private class BtnOgrenciyiKaydet5ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putdbskayit?";

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

			URLValue = URLValue
					+ "&ogrenci_bilgileri_ulke="
					+ cbxOgrenciBilgileriUlke.getValue(cbxOgrenciBilgileriUlke
							.getSelectedIndex());

			URLValue = URLValue
					+ "&ogrenci_bilgileri_il="
					+ cbxOgrenciBilgileriIl.getItemText(cbxOgrenciBilgileriIl
							.getSelectedIndex());

			// Window.alert("OGRENCI BILGILERI IL:"
			// + cbxOgrenciBilgileriIl.getItemText(cbxOgrenciBilgileriIl
			// .getSelectedIndex()));

			URLValue = URLValue
					+ "&ogrenci_bilgileri_ilce="
					+ cbxOgrenciBilgileriIlce
							.getItemText(cbxOgrenciBilgileriIlce
									.getSelectedIndex());

			URLValue = URLValue + "&okul="
					+ cbxOkul.getItemText(cbxOkul.getSelectedIndex());

			URLValue = URLValue
					+ "&sinif="
					+ cbxOgrenciBilgileriSinif
							.getValue(cbxOgrenciBilgileriSinif
									.getSelectedIndex());
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
			URLValue = URLValue + "&okul_durumu="
					+ cbxOkulDurumu.getValue(cbxOkulDurumu.getSelectedIndex());
			URLValue = URLValue
					+ "&alan_bilgisi="
					+ cbxAlanbilgisi
							.getValue(cbxAlanbilgisi.getSelectedIndex());

			URLValue = URLValue
					+ "&sinav_tarihi="
					+ cbxSinavTarihi
							.getValue(cbxSinavTarihi.getSelectedIndex());

			// DATEs
			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&dogum_tarihi="
					+ dtf.format(dtpDogumTarihi.getValue());

			URLValue = URLValue + "&verilis_tarihi="
					+ dtf.format(dtpVerilisTarihi.getValue());

			// Window.alert("URL VALUE:  DBS: " + URLValue);

			new Util().sendRequest(URLValue,
					"ÖĞRENCİ BİLGİLERİ BAŞARI İLE KAYIT EDİLDİ",
					"ÖĞRENCİ BİLGİLERİ KAYIT EDİLEMEDİ");

		}
	}

	private class DtpDogumTarihiValueChangeHandler implements
			ValueChangeHandler<Date> {
		public void onValueChange(ValueChangeEvent<Date> event) {

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
			// Window.alert(dtf.format(dtpDogumTarihi.getValue()));
		}
	}

	private class BtnKapat5ClickHandler_1 implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
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
			putIlceToCbx(cbxOgrenciKimlikBilgileriIl.getSelectedIndex(),
					cbxOgrenciKimlikBilgileriIlce);
		}
	}

	private class BtnVeliEkleClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			DlgVeliEkle dlgTemp = new DlgVeliEkle(true, -1);
			dlgTemp.center();
			dlgTemp.setAnimationEnabled(true);
		}
	}

	private class BtnBilgileriniGetirClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String urlWithParameters = Util.urlBase + "getdbskayit"
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
								List<XMLDBSKayit> listXmlDBSKayit = XMLDBSKayit.XML
										.readList(response.getText());

								_dlgDBSYeniKayit.hide();

								DlgDBSYeniKayit dlgTemp = new DlgDBSYeniKayit(
										_isInsert, -1);

								dlgTemp.putDataFromXML(listXmlDBSKayit.get(0));
								dlgTemp.center();
								// dlgTemp.tab.selectTab(0);

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}
}
