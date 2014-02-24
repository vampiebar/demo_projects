package com.icarusdb.portal.icacourses.main.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
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
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.view.client.SingleSelectionModel;

public class DlgDBSYeniKayit extends DialogBox {

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
	private ListBox cbxOkulDurumu;
	private ListBox cbxAlanbilgisi;
	private ListBox cbxSinavTarihi;
	private AbsolutePanel vtpanOgrenciBilgileri;
	private ListBox cbxOkul;
	private CellTable<XMLVeliler> grdVeliler;

	public DialogBox _dlgDBSYeniKayit;
	private HorizontalPanel hzpanMenu1;
	private AbsolutePanel absolutePanel_4;
	private TextArea tctSokakveNo;
	private SimpleCheckBox chxKayitSilinsinMi;
	private TextBox tctSilmeSebebi;
	public AbsolutePanel vtpanKayitSilme;
	private Button btnKapat5;
	private Button btnOgrenciyiKaydet5;
	private Image imgKaydet;
	private Image imgKapat5;

	public DlgDBSYeniKayit(boolean isInsert, long id) {
		setGlassEnabled(true);

		_dlgDBSYeniKayit = this;
		_isInsert = isInsert;
		_id = id;

		setAutoHideOnHistoryEventsEnabled(false);
		setAutoHideEnabled(false);
		setHTML("DBS Sınav Kayıt");

		VerticalPanel vtpanMain = new VerticalPanel();

		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		decoratedTabPanel.setAnimationEnabled(true);
		setWidget(vtpanMain);
		vtpanMain.setSize("788px", "556px");
		decoratedTabPanel.setSize("750px", "496px");

		vtpanMain.add(decoratedTabPanel);

		VerticalPanel hzpanMain = new VerticalPanel();

		vtpanOgrenciBilgileri = new AbsolutePanel();
		vtpanOgrenciBilgileri.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel.add(hzpanMain, "Öğrenci Bilgileri", false);
		vtpanOgrenciBilgileri.setSize("840px", "450px");

		hzpanMain.add(vtpanOgrenciBilgileri);

		hzpanMenu1 = new HorizontalPanel();
		hzpanMenu1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hzpanMenu1.setSize("784px", "72px");
		vtpanMain.add(hzpanMenu1);

		imgKapat5 = new Image("kapat-1.png");
		imgKapat5.addMouseOutHandler(new ImgKapat5MouseOutHandler());
		imgKapat5.addMouseOverHandler(new ImgKapat5MouseOverHandler());
		imgKapat5.addClickHandler(new ImgKapat5ClickHandler());

		imgKaydet = new Image("kaydet-1.png");
		imgKaydet.addMouseOutHandler(new ImgKaydetMouseOutHandler());
		imgKaydet.addMouseOverHandler(new ImgKaydetMouseOverHandler());
		imgKaydet.addClickHandler(new ImgKaydetClickHandler());

		Button btnYeniKayit5 = new Button("");
		btnYeniKayit5.setVisible(false);

		btnOgrenciyiKaydet5 = new Button("Öğrenciyi Kaydet");
		btnOgrenciyiKaydet5.setVisible(false);
		btnOgrenciyiKaydet5.setText("");
		hzpanMenu1.add(btnOgrenciyiKaydet5);
		btnOgrenciyiKaydet5.setStyleName("gwt-ButtonSave");
		btnOgrenciyiKaydet5
				.addClickHandler(new BtnOgrenciyiKaydet5ClickHandler());
		btnOgrenciyiKaydet5.setSize("26px", "67px");
		btnYeniKayit5.setText("");
		hzpanMenu1.add(btnYeniKayit5);
		hzpanMenu1.setCellWidth(btnYeniKayit5, "625");
		btnYeniKayit5.setStyleName("gwt-ButonYeniKayit");
		btnYeniKayit5.setSize("25px", "72px");
		hzpanMenu1.add(imgKaydet);
		imgKaydet.setSize("72px", "66px");
		hzpanMenu1.add(imgKapat5);
		imgKapat5.setSize("72px", "66px");

		btnKapat5 = new Button("Kapat");
		btnKapat5.setVisible(false);
		btnKapat5.setText("");
		hzpanMenu1.add(btnKapat5);
		btnKapat5.setStyleName("gwt-ButonKapat");
		btnKapat5.addClickHandler(new BtnKapat5ClickHandler_1());
		btnKapat5.setSize("23px", "70px");

		FlexTable flexTable = new FlexTable();
		vtpanOgrenciBilgileri.add(flexTable, 10, 10);
		flexTable.setSize("492px", "433px");

		// hzpanMain.add(hzpanMenu1);

		Label lblNewLabel = new Label("Adı");
		flexTable.setWidget(0, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");
		lblNewLabel.setSize("200px", "18px");

		tctAdi = new TextBox();
		tctAdi.setMaxLength(30);
		flexTable.setWidget(0, 1, tctAdi);
		tctAdi.setStyleName("gwt-TextBox1");
		tctAdi.setSize("232px", "15px");

		Label lblNewLabel_1 = new Label("Soyadi");
		flexTable.setWidget(1, 0, lblNewLabel_1);
		lblNewLabel_1.setStyleName("gwt-Bold");
		lblNewLabel_1.setSize("203px", "18px");

		tctSoyadi = new TextBox();
		tctSoyadi.setMaxLength(30);
		flexTable.setWidget(1, 1, tctSoyadi);
		tctSoyadi.setStyleName("gwt-TextBox1");
		tctSoyadi.setSize("232px", "15px");

		Label lblTcKimlikNo = new Label("T.C. Kimlik No ");
		flexTable.setWidget(2, 0, lblTcKimlikNo);
		lblTcKimlikNo.setWidth("170px");
		lblTcKimlikNo.setStyleName("gwt-Bold");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		flexTable.setWidget(2, 1, horizontalPanel_2);
		flexTable.getCellFormatter().setWidth(2, 1, "");
		horizontalPanel_2.setWidth("100%");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.addKeyPressHandler(new TctTCKimlikNoKeyPressHandler());
		horizontalPanel_2.add(tctTCKimlikNo);
		horizontalPanel_2.setCellWidth(tctTCKimlikNo, "100");
		tctTCKimlikNo.setMaxLength(11);
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		tctTCKimlikNo.setSize("126px", "15px");

		Button btnBilgileriniGetir = new Button("Bilgilerini Getir");
		horizontalPanel_2.add(btnBilgileriniGetir);
		btnBilgileriniGetir
				.addClickHandler(new BtnBilgileriniGetirClickHandler());

		btnBilgileriniGetir.setStyleName("gwt-BilgileriniGetir");
		btnBilgileriniGetir.setSize("113px", "22px");

		Label lblCinsiyet = new Label("Cinsiyet");
		flexTable.setWidget(3, 0, lblCinsiyet);
		lblCinsiyet.setStyleName("gwt-Bold");

		cbxCinsiyet = new ListBox();
		flexTable.setWidget(3, 1, cbxCinsiyet);
		cbxCinsiyet.setStyleName("gwt-ComboBox1");
		cbxCinsiyet.addItem("Erkek");
		cbxCinsiyet.addItem("Kız");
		cbxCinsiyet.setSize("128px", "22px");

		Label lblMedeniHali = new Label("Medeni Hali");
		flexTable.setWidget(4, 0, lblMedeniHali);
		lblMedeniHali.setStyleName("gwt-Bold");
		lblMedeniHali.setSize("181px", "18px");

		cbxMedeniHali = new ListBox();
		flexTable.setWidget(4, 1, cbxMedeniHali);
		cbxMedeniHali.setStyleName("gwt-ComboBox1");
		cbxMedeniHali.addItem("Bekar");
		cbxMedeniHali.addItem("Evli");
		cbxMedeniHali.setSize("128px", "22px");

		Label lblDoumTarihi = new Label("Doğum Tarihi");
		flexTable.setWidget(5, 0, lblDoumTarihi);
		lblDoumTarihi.setStyleName("gwt-Bold");

		dtpDogumTarihi = new DateBox();
		flexTable.setWidget(5, 1, dtpDogumTarihi);
		dtpDogumTarihi.setStyleName("gwt-TextBox1");
		dtpDogumTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpDogumTarihi
				.addValueChangeHandler(new DtpDogumTarihiValueChangeHandler());
		dtpDogumTarihi.setSize("126px", "15px");

		Label lblEvCep = new Label("Ev / Cep Telefonu");
		flexTable.setWidget(6, 0, lblEvCep);
		lblEvCep.setStyleName("gwt-Bold");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		flexTable.setWidget(6, 1, horizontalPanel_1);
		horizontalPanel_1.setSize("292px", "21px");

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.addKeyPressHandler(new TctEvTelefonuKeyPressHandler());
		horizontalPanel_1.add(tctEvTelefonu);
		tctEvTelefonu.setMaxLength(10);

		tctEvTelefonu.setStyleName("gwt-TextBox1");
		tctEvTelefonu.setSize("126px", "15px");

		tctCepTelefonu = new TextBox();
		tctCepTelefonu.addKeyPressHandler(new TctCepTelefonuKeyPressHandler());
		horizontalPanel_1.add(tctCepTelefonu);
		tctCepTelefonu.setMaxLength(10);
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		tctCepTelefonu.setSize("143px", "15px");

		Label lblEmail = new Label("E-Mail");
		flexTable.setWidget(7, 0, lblEmail);
		lblEmail.setStyleName("gwt-Bold");
		lblEmail.setSize("77px", "18px");

		tctEmail = new TextBox();
		tctEmail.addKeyPressHandler(new TctEmailKeyPressHandler());
		tctEmail.setMaxLength(30);
		flexTable.setWidget(7, 1, tctEmail);
		tctEmail.setStyleName("gwt-TextBox1");
		tctEmail.setSize("232px", "15px");

		Label lblOkulBilgisi = new Label("OKUL BİLGİSİ");
		flexTable.setWidget(8, 0, lblOkulBilgisi);
		lblOkulBilgisi.setStyleName("gwt-Bold");

		Label lblUlke = new Label("Ulke");
		flexTable.setWidget(9, 0, lblUlke);
		lblUlke.setStyleName("gwt-Bold");

		cbxOgrenciBilgileriUlke = new ListBox();
		flexTable.setWidget(9, 1, cbxOgrenciBilgileriUlke);
		cbxOgrenciBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriUlke.addItem("Türkiye");
		cbxOgrenciBilgileriUlke.setSize("153px", "22px");

		Label label = new Label("İl");
		flexTable.setWidget(10, 0, label);
		label.setStyleName("gwt-Bold");
		label.setSize("26px", "18px");

		cbxOgrenciBilgileriIl = new ListBox();
		flexTable.setWidget(10, 1, cbxOgrenciBilgileriIl);
		cbxOgrenciBilgileriIl
				.addChangeHandler(new CbxOgrenciBilgileriIlChangeHandler());
		cbxOgrenciBilgileriIl.addItem(" ");
		cbxOgrenciBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIl.setSize("153px", "22px");

		Label lblNewLabel_2 = new Label("İlçe");
		flexTable.setWidget(11, 0, lblNewLabel_2);
		lblNewLabel_2.setStyleName("gwt-Bold");

		cbxOgrenciBilgileriIlce = new ListBox();
		flexTable.setWidget(11, 1, cbxOgrenciBilgileriIlce);
		cbxOgrenciBilgileriIlce
				.addChangeHandler(new CbxOgrenciBilgileriIlceChangeHandler());
		cbxOgrenciBilgileriIlce.addItem(" ");
		cbxOgrenciBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIlce.setSize("153px", "22px");

		Label lblNewLabel_3 = new Label("Okul");
		flexTable.setWidget(12, 0, lblNewLabel_3);
		lblNewLabel_3.setStyleName("gwt-Bold");

		cbxOkul = new ListBox();
		flexTable.setWidget(12, 1, cbxOkul);
		cbxOkul.setStyleName("gwt-ComboBox1");
		cbxOkul.addItem(" ");
		cbxOkul.setSize("292px", "22px");

		Label lblNewLabel_4 = new Label("Sınıf");
		flexTable.setWidget(13, 0, lblNewLabel_4);
		lblNewLabel_4.setStyleName("gwt-Bold");

		cbxOgrenciBilgileriSinif = new ListBox();
		flexTable.setWidget(13, 1, cbxOgrenciBilgileriSinif);
		cbxOgrenciBilgileriSinif.addItem(" ");
		cbxOgrenciBilgileriSinif.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriSinif.setSize("153px", "22px");

		Label lblNewLabel_22 = new Label("Kayit Silinsin mi?");
		flexTable.setWidget(14, 0, lblNewLabel_22);
		lblNewLabel_22.setStyleName("gwt-Bold");

		chxKayitSilinsinMi = new SimpleCheckBox();
		flexTable.setWidget(14, 1, chxKayitSilinsinMi);

		Label lblSilmeSebebi = new Label("Silme Sebebi");
		flexTable.setWidget(15, 0, lblSilmeSebebi);
		lblSilmeSebebi.setWidth("154px");
		lblSilmeSebebi.setStyleName("gwt-Bold");

		tctSilmeSebebi = new TextBox();
		tctSilmeSebebi.setStyleName("gwt-TextBox1");
		flexTable.setWidget(15, 1, tctSilmeSebebi);
		tctSilmeSebebi.setSize("151px", "15px");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		decoratedTabPanel.add(verticalPanel_1, "Öğrenci Kimlik Bilgileri",
				false);
		verticalPanel_1.setSize("5cm", "3cm");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		verticalPanel_1.add(absolutePanel);
		absolutePanel.setSize("840px", "450px");

		FlexTable flexTable_1 = new FlexTable();
		absolutePanel.add(flexTable_1, 10, 10);
		flexTable_1.setSize("309px", "264px");

		Label lblSeriNo = new Label("Seri No");
		flexTable_1.setWidget(0, 0, lblSeriNo);
		lblSeriNo.setStyleName("gwt-Bold");

		tctSeriNo = new TextBox();
		tctSeriNo.addKeyPressHandler(new TctSeriNoKeyPressHandler());
		flexTable_1.setWidget(0, 1, tctSeriNo);
		tctSeriNo.setMaxLength(4);
		tctSeriNo.setStyleName("gwt-TextBox1");
		tctSeriNo.setSize("158px", "14px");

		Label lblCzdanNo = new Label("Cüzdan No");
		flexTable_1.setWidget(1, 0, lblCzdanNo);
		lblCzdanNo.setStyleName("gwt-Bold");

		tctCuzdanNo = new TextBox();
		tctCuzdanNo.addKeyPressHandler(new TctCuzdanNoKeyPressHandler());
		flexTable_1.setWidget(1, 1, tctCuzdanNo);
		tctCuzdanNo.setMaxLength(10);
		tctCuzdanNo.setStyleName("gwt-TextBox1");
		tctCuzdanNo.setSize("158px", "14px");

		Label lblNewLabel_5 = new Label("Kayıtlı Oldugu");
		flexTable_1.setWidget(2, 0, lblNewLabel_5);
		lblNewLabel_5.setStyleName("gwt-Bold");

		Label lblIl = new Label("Ülke");
		flexTable_1.setWidget(3, 0, lblIl);
		lblIl.setStyleName("gwt-Bold");
		lblIl.setSize("43px", "18px");

		cbxOgrenciKimlikBilgileriUlke = new ListBox();
		flexTable_1.setWidget(3, 1, cbxOgrenciKimlikBilgileriUlke);
		cbxOgrenciKimlikBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriUlke.addItem("Türkiye");
		cbxOgrenciKimlikBilgileriUlke.setSize("162px", "22px");

		Label lblNewLabel_6 = new Label("İl");
		flexTable_1.setWidget(4, 0, lblNewLabel_6);
		lblNewLabel_6.setStyleName("gwt-Bold");
		lblNewLabel_6.setSize("20px", "16px");

		cbxOgrenciKimlikBilgileriIl = new ListBox();
		flexTable_1.setWidget(4, 1, cbxOgrenciKimlikBilgileriIl);
		cbxOgrenciKimlikBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriIl
				.addChangeHandler(new CbxOgrenciKimlikBilgileriIlChangeHandler());
		cbxOgrenciKimlikBilgileriIl.addItem(" ");
		cbxOgrenciKimlikBilgileriIl.setSize("162px", "22px");

		Label lblNewLabel_7 = new Label("İlçe");
		flexTable_1.setWidget(5, 0, lblNewLabel_7);
		lblNewLabel_7.setStyleName("gwt-Bold");

		cbxOgrenciKimlikBilgileriIlce = new ListBox();
		flexTable_1.setWidget(5, 1, cbxOgrenciKimlikBilgileriIlce);
		cbxOgrenciKimlikBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriIlce.addItem(" ");
		cbxOgrenciKimlikBilgileriIlce.setSize("162px", "22px");

		Label lblNewLabel_8 = new Label("Mahalle / Köy");
		flexTable_1.setWidget(6, 0, lblNewLabel_8);
		lblNewLabel_8.setStyleName("gwt-Bold");

		tctMahalleKoy = new TextBox();
		flexTable_1.setWidget(6, 1, tctMahalleKoy);
		tctMahalleKoy.setStyleName("gwt-TextBox1");
		tctMahalleKoy.setSize("158px", "14px");

		Label lblNewLabel_9 = new Label("Cilt No");
		flexTable_1.setWidget(7, 0, lblNewLabel_9);
		lblNewLabel_9.setStyleName("gwt-Bold");

		tctCiltNo = new TextBox();
		tctCiltNo.addKeyPressHandler(new TctCiltNoKeyPressHandler());
		flexTable_1.setWidget(7, 1, tctCiltNo);
		tctCiltNo.setStyleName("gwt-TextBox1");
		tctCiltNo.setSize("158px", "14px");

		Label lblNewLabel_10 = new Label("Aile Sıra No");
		flexTable_1.setWidget(8, 0, lblNewLabel_10);
		lblNewLabel_10.setStyleName("gwt-Bold");

		tctAileSiraNo = new TextBox();
		tctAileSiraNo.addKeyPressHandler(new TctAileSiraNoKeyPressHandler());
		flexTable_1.setWidget(8, 1, tctAileSiraNo);
		tctAileSiraNo.setStyleName("gwt-TextBox1");
		tctAileSiraNo.setSize("158px", "14px");

		Label lblSraNo = new Label("Sıra No");
		flexTable_1.setWidget(9, 0, lblSraNo);
		lblSraNo.setStyleName("gwt-Bold");

		tctSiraNo = new TextBox();
		tctSiraNo.addKeyPressHandler(new TctSiraNoKeyPressHandler());
		flexTable_1.setWidget(9, 1, tctSiraNo);
		tctSiraNo.setStyleName("gwt-TextBox1");
		tctSiraNo.setSize("158px", "14px");

		Label lblCzdanBilgileri = new Label("Cüzdan Bilgileri");
		flexTable_1.setWidget(10, 0, lblCzdanBilgileri);
		lblCzdanBilgileri.setStyleName("gwt-Bold");

		Label lblVerildiiYer = new Label("Verildiği Yer");
		flexTable_1.setWidget(11, 0, lblVerildiiYer);
		lblVerildiiYer.setStyleName("gwt-Bold");

		tctVerildigiYer = new TextBox();
		flexTable_1.setWidget(11, 1, tctVerildigiYer);
		tctVerildigiYer.setStyleName("gwt-TextBox1");
		tctVerildigiYer.setSize("158px", "14px");

		Label lblVeriliNedeni = new Label("Veriliş Nedeni");
		flexTable_1.setWidget(12, 0, lblVeriliNedeni);
		lblVeriliNedeni.setStyleName("gwt-Bold");

		tctVerilisNedeni = new TextBox();
		flexTable_1.setWidget(12, 1, tctVerilisNedeni);
		tctVerilisNedeni.setStyleName("gwt-TextBox1");
		tctVerilisNedeni.setSize("158px", "14px");

		Label lblNewLabel_11 = new Label("Kayıt No");
		flexTable_1.setWidget(13, 0, lblNewLabel_11);
		lblNewLabel_11.setStyleName("gwt-Bold");

		tctKayitNo = new TextBox();
		tctKayitNo.addKeyPressHandler(new TctKayitNoKeyPressHandler());
		flexTable_1.setWidget(13, 1, tctKayitNo);
		tctKayitNo.setStyleName("gwt-TextBox1");
		tctKayitNo.setSize("158px", "14px");

		Label lblNewLabel_12 = new Label("Veriliş Tarihi");
		flexTable_1.setWidget(14, 0, lblNewLabel_12);
		lblNewLabel_12.setStyleName("gwt-Bold");

		dtpVerilisTarihi = new DateBox();
		flexTable_1.setWidget(14, 1, dtpVerilisTarihi);
		dtpVerilisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpVerilisTarihi.setStyleName("gwt-TextBox1");
		dtpVerilisTarihi.setSize("158px", "14px");

		VerticalPanel verticalPanel_2 = new VerticalPanel();
		decoratedTabPanel.add(verticalPanel_2, "Adres Bilgileri", false);
		verticalPanel_2.setSize("166px", "218px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_2.setStyleName("gwt-DialogBackGround");
		verticalPanel_2.add(absolutePanel_2);
		absolutePanel_2.setSize("840px", "450px");

		FlexTable flexTable_3 = new FlexTable();
		absolutePanel_2.add(flexTable_3, 10, 10);
		flexTable_3.setSize("327px", "213px");

		Label lblNewLabel_13 = new Label("Ülke");
		flexTable_3.setWidget(0, 0, lblNewLabel_13);
		lblNewLabel_13.setStyleName("gwt-Bold");

		cbxAdresBilgileriUlke = new ListBox();
		flexTable_3.setWidget(0, 1, cbxAdresBilgileriUlke);
		cbxAdresBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriUlke.addItem("Türkiye");
		cbxAdresBilgileriUlke.setSize("156px", "22px");

		Label lblNewLabel_14 = new Label("İl");
		flexTable_3.setWidget(1, 0, lblNewLabel_14);
		lblNewLabel_14.setStyleName("gwt-Bold");
		lblNewLabel_14.setSize("26px", "18px");

		cbxAdresBilgileriIl = new ListBox();
		flexTable_3.setWidget(1, 1, cbxAdresBilgileriIl);
		cbxAdresBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriIl
				.addChangeHandler(new CbxAdresBilgileriIlChangeHandler());
		cbxAdresBilgileriIl.addItem(" ");
		cbxAdresBilgileriIl.setSize("156px", "22px");

		Label lblNewLabel_15 = new Label("İlçe");
		flexTable_3.setWidget(2, 0, lblNewLabel_15);
		lblNewLabel_15.setStyleName("gwt-Bold");

		cbxAdresBilgileriIlce = new ListBox();
		flexTable_3.setWidget(2, 1, cbxAdresBilgileriIlce);
		cbxAdresBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriIlce
				.addChangeHandler(new CbxAdresBilgileriIlceChangeHandler());
		cbxAdresBilgileriIlce.addItem(" ");
		cbxAdresBilgileriIlce.setSize("156px", "22px");

		Label lblNewLabel_16 = new Label("Semt");
		flexTable_3.setWidget(3, 0, lblNewLabel_16);
		lblNewLabel_16.setStyleName("gwt-Bold");

		cbxSemt = new ListBox();
		flexTable_3.setWidget(3, 1, cbxSemt);
		cbxSemt.setStyleName("gwt-ComboBox1");
		cbxSemt.addChangeHandler(new CbxSemtChangeHandler());
		cbxSemt.addItem(" ");
		cbxSemt.setSize("156px", "22px");

		Label lblNewLabel_17 = new Label("Mahalle");
		flexTable_3.setWidget(4, 0, lblNewLabel_17);
		lblNewLabel_17.setStyleName("gwt-Bold");

		cbxMahalle = new ListBox();
		flexTable_3.setWidget(4, 1, cbxMahalle);
		cbxMahalle.setStyleName("gwt-ComboBox1");
		cbxMahalle.addItem(" ");
		cbxMahalle.setSize("220px", "22px");

		Label lblNewLabel_18 = new Label("Sokak ve No");
		flexTable_3.setWidget(5, 0, lblNewLabel_18);
		lblNewLabel_18.setStyleName("gwt-Bold");
		lblNewLabel_18.setSize("89px", "16px");

		tctSokakveNo = new TextArea();
		flexTable_3.setWidget(5, 1, tctSokakveNo);
		tctSokakveNo.setStyleName("gwt-TextAreaResible");
		tctSokakveNo.setSize("220px", "53px");
		flexTable_3.getCellFormatter().setVerticalAlignment(5, 0,
				HasVerticalAlignment.ALIGN_TOP);

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel.add(absolutePanel_3, "Sınav Bilgileri", false);
		absolutePanel_3.setSize("840px", "450px");

		FlexTable flexTable_4 = new FlexTable();
		absolutePanel_3.add(flexTable_4, 10, 10);
		flexTable_4.setSize("265px", "80px");

		Label lblNewLabel_19 = new Label("Okul Durumu");
		flexTable_4.setWidget(0, 0, lblNewLabel_19);
		lblNewLabel_19.setStyleName("gwt-Bold");

		cbxOkulDurumu = new ListBox();
		flexTable_4.setWidget(0, 1, cbxOkulDurumu);
		cbxOkulDurumu.addItem(" ");
		cbxOkulDurumu.addChangeHandler(new CbxOkulDurumuChangeHandler());
		cbxOkulDurumu.setStyleName("gwt-ComboBox1");
		cbxOkulDurumu.setSize("132px", "22px");

		Label lblNewLabel_20 = new Label("Alan Bilgisi");
		flexTable_4.setWidget(1, 0, lblNewLabel_20);
		lblNewLabel_20.setStyleName("gwt-Bold");

		cbxAlanbilgisi = new ListBox();
		flexTable_4.setWidget(1, 1, cbxAlanbilgisi);
		cbxAlanbilgisi.addChangeHandler(new CbxAlanbilgisiChangeHandler());
		cbxAlanbilgisi.addItem(" ");
		cbxAlanbilgisi.setStyleName("gwt-ComboBox1");
		cbxAlanbilgisi.setSize("132px", "22px");

		Label lblNewLabel_21 = new Label("Sınav Tarihi");
		flexTable_4.setWidget(2, 0, lblNewLabel_21);
		lblNewLabel_21.setStyleName("gwt-Bold");

		cbxSinavTarihi = new ListBox();
		flexTable_4.setWidget(2, 1, cbxSinavTarihi);
		cbxSinavTarihi.addItem(" ");
		cbxSinavTarihi.setStyleName("gwt-ComboBox1");
		cbxSinavTarihi.setSize("132px", "22px");

		absolutePanel_4 = new AbsolutePanel();
		absolutePanel_4.setStyleName("gwt-DialogBackGround");
		decoratedTabPanel.add(absolutePanel_4, "Veli Bilgileri", false);
		absolutePanel_4.setSize("840px", "450px");

		VerticalPanel verticalPanel = new VerticalPanel();
		absolutePanel_4.add(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		Button btnVeliEkle = new Button("Veli Ekle");
		verticalPanel.add(btnVeliEkle);
		verticalPanel.setCellHeight(btnVeliEkle, "40");
		btnVeliEkle.addClickHandler(new BtnVeliEkleClickHandler());
		btnVeliEkle.setStyleName("gwt-YeniKayit2");
		btnVeliEkle.setSize("120px", "30px");

		VerticalPanel horizontalPanel = new VerticalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "192px");

		grdVeliler = new CellTable<XMLVeliler>();
		horizontalPanel.add(grdVeliler);
		grdVeliler.setVisible(true);
		grdVeliler.setSize("100%", "100%");

		TextColumn<XMLVeliler> textColumn_4 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.veli_bilgileri_tc_kimlik_no.toString();
			}
		};
		grdVeliler.addColumn(textColumn_4, "TC Kimlik No");

		Column<XMLVeliler, ?> textColumn_3 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.veli_bilgileri_adi.toString();
			}
		};
		grdVeliler.addColumn(textColumn_3, "Adı");

		TextColumn<XMLVeliler> textColumn_2 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.veli_bilgileri_soyadi.toString();
			}
		};
		grdVeliler.addColumn(textColumn_2, "Soyadı");

		TextColumn<XMLVeliler> textColumn_1 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.yakinlik_durumu;
			}
		};
		grdVeliler.addColumn(textColumn_1, "Yakınlık Durumu");

		Column<XMLVeliler, Boolean> column = new Column<XMLVeliler, Boolean>(
				new CheckboxCell()) {
			@Override
			public Boolean getValue(XMLVeliler object) {
				return (Boolean) null;
			}
		};
		grdVeliler.addColumn(column, "Ödeme Sorumlusu");

		TextColumn<XMLVeliler> textColumn_5 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.cep_tel.toString();
			}
		};
		grdVeliler.addColumn(textColumn_5, "Cep Tel");

		TextColumn<XMLVeliler> textColumn_6 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.is_tel.toString();
			}
		};
		grdVeliler.addColumn(textColumn_6, "İş Tel");

		Column<XMLVeliler, String> column_3 = new Column<XMLVeliler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return "Düzenle";
			}
		};
		grdVeliler.addColumn(column_3, "Düzenle");

		Column<XMLVeliler, String> column_4 = new Column<XMLVeliler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return "Sil";
			}
		};
		grdVeliler.addColumn(column_4, "Sil");

		// // Set Default page
		decoratedTabPanel.selectTab(0);

		if (!isDesignTime()) {

			putDataToGrid(tctTCKimlikNo.getText());

			putIlToCbx(cbxOgrenciKimlikBilgileriIl, cbxOgrenciBilgileriIl,
					cbxAdresBilgileriIl);
			putOKulDurumuToCbx(cbxOkulDurumu, cbxOgrenciBilgileriSinif);

			final SingleSelectionModel<XMLVeliler> selectionModel = new SingleSelectionModel<XMLVeliler>();

			grdVeliler.setSelectionModel(selectionModel);
			grdVeliler.addDomHandler(new DoubleClickHandler() {

				@Override
				public void onDoubleClick(final DoubleClickEvent event) {
					XMLVeliler selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("asdasd");
						showWithData(selected.id);

					}

				}
			}, DoubleClickEvent.getType());

			column_3.setFieldUpdater(new FieldUpdater<XMLVeliler, String>() {

				@Override
				public void update(int index, XMLVeliler object, String value) {

					XMLVeliler selected = selectionModel.getSelectedObject();
					if (selected != null) {
						// DO YOUR STUFF

						// Window.alert("selected id: " + selected.id);
						showWithData(selected.id);

					}

				}
			});
			column_4.setFieldUpdater(new FieldUpdater<XMLVeliler, String>() {

				@Override
				public void update(int index, XMLVeliler object, String value) {
					XMLVeliler selected = selectionModel.getSelectedObject();
					Boolean x = Window
							.confirm("Kayit Silinecektir, Emin Misiniz?");

					if (x == true) {

						if (selected != null) {
							// DO YOUR STUFF

							// Window.alert("selected id: " + selected.id);
							// showWithData(selected.id);

							String URLValue = Util.urlBase + "putveliler?";

							URLValue = URLValue + "id=" + selected.id;
							URLValue = URLValue + "&ogrenci_tc_kimlik_no="
									+ object.ogrenci_tc_kimlik_no.toString();
							URLValue = URLValue + "&veli_bilgileri_adi="
									+ object.veli_bilgileri_adi.toString();
							URLValue = URLValue + "&veli_bilgileri_soyadi="
									+ object.veli_bilgileri_soyadi.toString();
							URLValue = URLValue
									+ "&veli_bilgileri_tc_kimlik_no="
									+ object.veli_bilgileri_tc_kimlik_no
											.toString();
							URLValue = URLValue + "&yakinlik_durumu="
									+ object.yakinlik_durumu.toString();
							URLValue = URLValue + "&odeme_sorumlusu="
									+ object.odeme_sorumlusu.toString();
							URLValue = URLValue + "&cep_tel="
									+ object.cep_tel.toString();
							URLValue = URLValue + "&ev_tel="
									+ object.ev_tel.toString();
							URLValue = URLValue + "&is_tel="
									+ object.is_tel.toString();
							URLValue = URLValue + "&e_mail="
									+ object.e_mail.toString();
							URLValue = URLValue + "&firma="
									+ object.firma.toString();
							URLValue = URLValue + "&sektor="
									+ object.sektor.toString();
							URLValue = URLValue + "&unvani="
									+ object.unvani.toString();
							URLValue = URLValue + "&gorevi="
									+ object.gorevi.toString();
							URLValue = URLValue + "&veli_bilgileri_adres="
									+ object.veli_bilgileri_adres.toString();

							URLValue = URLValue + "&kayit_silinsin_mi=TRUE";

							// Window.alert(URLValue);

							new Util()
									.sendRequest(URLValue,
											"BAŞARIYLA KAYIT EDİLDİ",
											"KAYIT EDİLEMEDİ");
						}
					}
				}
			});
		}

	}

	private void putOKulDurumuToCbx(final ListBox lbxTemp,
			final ListBox lbxTemp2) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		lbxTemp2.clear();
		lbxTemp2.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getokulsinifbilgisi");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getdbssinavtanimla " + response.getText());

					List<XMLOkulSinifBilgisi> xmlOkulSinifBilgisi = XMLOkulSinifBilgisi.XML
							.readList(response.getText());

					for (int i = 0; i < xmlOkulSinifBilgisi.size(); i++) {

						lbxTemp.addItem(xmlOkulSinifBilgisi.get(i).okul_durumu);

						lbxTemp2.addItem(xmlOkulSinifBilgisi.get(i).okul_durumu);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putAlanBilgisiToCbx(String okul_durumu, final ListBox lbxTemp) {
		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getdbssinavtanimla?okul_durumu=" + okul_durumu);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getdbssinavtanimla " + response.getText());

					List<XMLDBSSinavTanimla> xmlDBSSinavTanimla = XMLDBSSinavTanimla.XML
							.readList(response.getText());

					for (int i = 0; i < xmlDBSSinavTanimla.size(); i++) {

						lbxTemp.addItem(xmlDBSSinavTanimla.get(i).alan_bilgisi);

					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putSinavTarihleriToCbx(String okul_durumu,
			String alan_bilgisi, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getdbssinavtanimla?okul_durumu=" + okul_durumu
						+ "&alan_bilgisi=" + alan_bilgisi);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getdbssinavtanimla " + response.getText());

					List<XMLDBSSinavTanimla> xmlDBSSinavTanimla = XMLDBSSinavTanimla.XML
							.readList(response.getText());

					for (int i = 0; i < xmlDBSSinavTanimla.size(); i++) {

						lbxTemp.addItem(xmlDBSSinavTanimla.get(i).sinav_tarihi
								+ " " + xmlDBSSinavTanimla.get(i).saat + ":"
								+ xmlDBSSinavTanimla.get(i).dakika);

					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putDataToGrid(String tc_kimlik_no) {

		String urlWithParameters = Util.urlBase
				+ "getveliler?kayit_silinsin_mi=FALSE"
				+ "&ogrenci_tc_kimlik_no=" + tc_kimlik_no;

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
					grdVeliler.setRowCount(1, true);

					// Push the data into the widget.
					grdVeliler.setRowData(0, listXmlVeliler);

					if (listXmlVeliler != null) {

						grdVeliler.setRowData(0, listXmlVeliler);

						grdVeliler.redraw();

					} else {

						grdVeliler.setRowCount(0, true);
						grdVeliler.redraw();

					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	protected void showWithData(final String id) {

		String urlWithParameters = Util.urlBase + "getveliler?id=" + id;

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

							putDataToGrid(tctTCKimlikNo.getText());

						}
					});

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
		tctSilmeSebebi.setText(xml.silme_sebebi);

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

		cbxOgrenciBilgileriSinif.setItemText(0, xml.sinif);
		cbxOkulDurumu.setItemText(0, xml.okul_durumu);
		cbxAlanbilgisi.setItemText(0, xml.alan_bilgisi);
		cbxSinavTarihi.setItemText(0, xml.sinav_tarihi);

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

		chxKayitSilinsinMi
				.setValue(xml.kayit_silinsin_mi.equalsIgnoreCase("t") ? true
						: false);

		// Window.alert("DOG T: " + xml.dogum_tarihi);

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
		dtpDogumTarihi.setValue(dtf.parse(xml.dogum_tarihi));
		dtpVerilisTarihi.setValue(dtf.parse(xml.verilis_tarihi));

		putDataToGrid(tctTCKimlikNo.getText());

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
							.getItemText(cbxOgrenciBilgileriSinif
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
			URLValue = URLValue
					+ "&okul_durumu="
					+ cbxOkulDurumu.getItemText(cbxOkulDurumu
							.getSelectedIndex());
			URLValue = URLValue
					+ "&alan_bilgisi="
					+ cbxAlanbilgisi.getItemText(cbxAlanbilgisi
							.getSelectedIndex());

			URLValue = URLValue
					+ "&sinav_tarihi="
					+ cbxSinavTarihi.getItemText(cbxSinavTarihi
							.getSelectedIndex());

			URLValue = URLValue + "&kayit_silinsin_mi="
					+ chxKayitSilinsinMi.getValue().toString();

			URLValue = URLValue + "&silme_sebebi=" + tctSilmeSebebi.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

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

			if (tctAdi.getText() == null) {

				Window.alert("Lütfen İsim giriniz!");
			}

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
			dlgTemp.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putDataToGrid(tctTCKimlikNo.getText());

				}
			});

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

	private class CbxOkulDurumuChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putAlanBilgisiToCbx(
					cbxOkulDurumu.getItemText(cbxOkulDurumu.getSelectedIndex()),
					cbxAlanbilgisi);

		}
	}

	private class CbxAlanbilgisiChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putSinavTarihleriToCbx(cbxOkulDurumu.getItemText(cbxOkulDurumu
					.getSelectedIndex()), cbxAlanbilgisi
					.getItemText(cbxAlanbilgisi.getSelectedIndex()),
					cbxSinavTarihi);
		}
	}

	private class ImgKapat5ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKapat5.click();
		}
	}

	private class ImgKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnOgrenciyiKaydet5.click();
		}
	}

	private class ImgKaydetMouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			imgKaydet.setUrl("kaydet-2.png");
		}
	}

	private class ImgKaydetMouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {
			imgKaydet.setUrl("kaydet-1.png");
		}
	}

	private class ImgKapat5MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {
			imgKapat5.setUrl("kapat-2.png");
		}
	}

	private class ImgKapat5MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {
			imgKapat5.setUrl("kapat-1.png");
		}
	}

	private class TctTCKimlikNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctTCKimlikNo.getText();
			if (!input.matches("[0-9]*")) {
				tctTCKimlikNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctTCKimlikNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctEvTelefonuKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctEvTelefonu.getText();
			if (!input.matches("[0-9]*")) {
				tctEvTelefonu.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctEvTelefonu.setStyleName("gwt-TextBox1");

		}
	}

	private class TctCepTelefonuKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctCepTelefonu.getText();
			if (!input.matches("[0-9]*")) {
				tctCepTelefonu.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctCepTelefonu.setStyleName("gwt-TextBox1");

		}
	}

	private class TctSiraNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctSiraNo.getText();
			if (!input.matches("[0-9]*")) {
				tctSiraNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctSiraNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctCiltNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctCiltNo.getText();
			if (!input.matches("[0-9]*")) {
				tctCiltNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctCiltNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctCuzdanNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctCuzdanNo.getText();
			if (!input.matches("[0-9]*")) {
				tctCuzdanNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctCuzdanNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctAileSiraNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctAileSiraNo.getText();
			if (!input.matches("[0-9]*")) {
				tctAileSiraNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctAileSiraNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctSeriNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctSeriNo.getText();
			if (!input.matches("[0-9]*")) {
				tctSeriNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctSeriNo.setStyleName("gwt-TextBox1");
		}
	}

	private class TctKayitNoKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctKayitNo.getText();
			if (!input.matches("[0-9]*")) {
				tctKayitNo.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctKayitNo.setStyleName("gwt-TextBox1");

		}
	}

	private class TctEmailKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctEmail.getText();
			if (!input
					.matches("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$")) {
				tctEmail.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctEmail.setStyleName("gwt-TextBox1");

		}
	}
}
