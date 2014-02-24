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
	private TextBox tctGorusmeYuzdesi;
	private CellTable<XMLVeliler> grdVeliEkle;
	private ListBox cbxOkul;
	public DecoratedTabPanel tabOnKayit;

	public DialogBox _dlgonkayit;
	private TextBox tctGorusmeIndirimSekli;
	private SimpleCheckBox chxKesinKayitMi;
	private TextArea tctSokakveNo;
	private TextBox tctSilmeSebebi;
	private SimpleCheckBox chxKayitSilinsinMi;
	private TextArea tctAciklama;
	private Button btnYeniOgrenci;
	private Label tctGorusmeKursIndirimFiyati;
	private Image image;
	private Image image_1;

	public DlgOnKayit(boolean isInsert, long id) {
		setGlassEnabled(true);

		_dlgonkayit = this;
		_isInsert = isInsert;
		_id = id;

		setAutoHideEnabled(false);
		setHTML("Ön Kayıt İşlemleri");

		VerticalPanel verticalpanel = new VerticalPanel();
		setWidget(verticalpanel);
		verticalpanel.setSize("854px", "570px");

		tabOnKayit = new DecoratedTabPanel();
		tabOnKayit.setAnimationEnabled(true);
		verticalpanel.add(tabOnKayit);
		tabOnKayit.setSize("462px", "496px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_2.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_2, "Öğrenci Bilgileri", false);
		absolutePanel_2.setSize("840px", "450px");

		FlexTable flexTable_5 = new FlexTable();
		absolutePanel_2.add(flexTable_5, 10, 10);
		flexTable_5.setSize("531px", "432px");

		Label label_27 = new Label("Adı");
		flexTable_5.setWidget(0, 0, label_27);
		label_27.setStyleName("gwt-Bold");
		label_27.setSize("133px", "18px");

		tctAdi = new TextBox();
		tctAdi.setMaxLength(30);
		flexTable_5.setWidget(0, 1, tctAdi);
		tctAdi.setStyleName("gwt-TextBox1");
		tctAdi.setSize("232px", "14px");

		Label lblSoyad = new Label("Soyadı");
		flexTable_5.setWidget(1, 0, lblSoyad);
		lblSoyad.setStyleName("gwt-Bold");
		lblSoyad.setSize("105px", "18px");

		tctSoyadi = new TextBox();
		tctSoyadi.setMaxLength(30);
		flexTable_5.setWidget(1, 1, tctSoyadi);
		tctSoyadi.setStyleName("gwt-TextBox1");
		tctSoyadi.setSize("232px", "14px");

		Label label_29 = new Label("T.C. Kimlik No ");
		flexTable_5.setWidget(2, 0, label_29);
		label_29.setStyleName("gwt-Bold");
		label_29.setSize("116px", "18px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		flexTable_5.setWidget(2, 1, horizontalPanel_1);

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.addKeyPressHandler(new TctTCKimlikNoKeyPressHandler());
		horizontalPanel_1.add(tctTCKimlikNo);
		horizontalPanel_1.setCellWidth(tctTCKimlikNo, "130");
		tctTCKimlikNo.setMaxLength(11);
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		tctTCKimlikNo.setSize("125px", "14px");

		Button btnBilgileriniGetir = new Button("Bilgilerini Getir");
		horizontalPanel_1.add(btnBilgileriniGetir);
		btnBilgileriniGetir
				.addClickHandler(new BtnBilgileriniGetirClickHandler());
		btnBilgileriniGetir.setStyleName("gwt-BilgileriniGetir");
		btnBilgileriniGetir.setSize("127px", "22px");

		Label lblKesinKayit = new Label("Kesin Kayit");
		flexTable_5.setWidget(3, 0, lblKesinKayit);
		lblKesinKayit.setStyleName("gwt-Bold");

		chxKesinKayitMi = new SimpleCheckBox();
		flexTable_5.setWidget(3, 1, chxKesinKayitMi);

		Label label_30 = new Label("Cinsiyet");
		flexTable_5.setWidget(4, 0, label_30);
		label_30.setStyleName("gwt-Bold");
		label_30.setSize("47px", "18px");

		cbxCinsiyet = new ListBox();
		flexTable_5.setWidget(4, 1, cbxCinsiyet);
		cbxCinsiyet.setStyleName("gwt-ComboBox1");
		cbxCinsiyet.addItem("Erkek");
		cbxCinsiyet.addItem("Kiz");
		cbxCinsiyet.setSize("128px", "22px");

		Label label_31 = new Label("Medeni Hali");
		flexTable_5.setWidget(5, 0, label_31);
		label_31.setStyleName("gwt-Bold");
		label_31.setSize("85px", "18px");

		cbxMedeniHali = new ListBox();
		flexTable_5.setWidget(5, 1, cbxMedeniHali);
		cbxMedeniHali.addItem("Evli");
		cbxMedeniHali.addItem("Bekar");
		cbxMedeniHali.setStyleName("gwt-ComboBox1");
		cbxMedeniHali.setSize("128px", "22px");

		Label label_32 = new Label("Doğum Tarihi");
		flexTable_5.setWidget(6, 0, label_32);
		label_32.setStyleName("gwt-Bold");
		label_32.setSize("105px", "18px");

		dtpDogumTarihi = new DateBox();
		flexTable_5.setWidget(6, 1, dtpDogumTarihi);
		dtpDogumTarihi.setStyleName("gwt-TextBox1");
		dtpDogumTarihi
				.addValueChangeHandler(new DptDogumTarihiValueChangeHandler());
		dtpDogumTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		dtpDogumTarihi.setSize("124px", "14px");

		Label label_33 = new Label("Ev / Cep Telefonu");
		flexTable_5.setWidget(7, 0, label_33);
		label_33.setStyleName("gwt-Bold");
		label_33.setSize("127px", "18px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		flexTable_5.setWidget(7, 1, horizontalPanel_2);
		horizontalPanel_2.setHeight("18px");

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.addKeyPressHandler(new TctEvTelefonuKeyPressHandler());
		horizontalPanel_2.add(tctEvTelefonu);
		horizontalPanel_2.setCellWidth(tctEvTelefonu, "140");
		tctEvTelefonu.setMaxLength(11);
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		tctEvTelefonu.setSize("125px", "14px");

		tctCepTelefonu = new TextBox();
		tctCepTelefonu.addKeyPressHandler(new TctCepTelefonuKeyPressHandler());
		horizontalPanel_2.add(tctCepTelefonu);
		tctCepTelefonu.setMaxLength(11);
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		tctCepTelefonu.setSize("143px", "14px");

		Label label_34 = new Label("E-Mail");
		flexTable_5.setWidget(8, 0, label_34);
		label_34.setStyleName("gwt-Bold");
		label_34.setSize("85px", "18px");

		tctEmail = new TextBox();
		tctEmail.addKeyPressHandler(new TctEmailKeyPressHandler());
		tctEmail.setMaxLength(40);
		flexTable_5.setWidget(8, 1, tctEmail);
		tctEmail.setStyleName("gwt-TextBox1");
		tctEmail.setSize("232px", "14px");

		Label lblOkulBilgileri = new Label("Okul Bilgileri");
		lblOkulBilgileri.setStyleName("gwt-Bold");
		flexTable_5.setWidget(9, 0, lblOkulBilgileri);

		Label lbllke = new Label("Ülke");
		flexTable_5.setWidget(10, 0, lbllke);
		lbllke.setStyleName("gwt-Bold");
		lbllke.setSize("26px", "18px");

		cbxOgrenciBilgileriUlke = new ListBox();
		flexTable_5.setWidget(10, 1, cbxOgrenciBilgileriUlke);
		cbxOgrenciBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriUlke.addItem("Türkiye");
		cbxOgrenciBilgileriUlke.setSize("135px", "22px");

		Label label_23 = new Label("İl");
		flexTable_5.setWidget(11, 0, label_23);
		label_23.setStyleName("gwt-Bold");
		label_23.setSize("26px", "18px");

		cbxOgrenciBilgileriIl = new ListBox();
		flexTable_5.setWidget(11, 1, cbxOgrenciBilgileriIl);
		cbxOgrenciBilgileriIl.addItem(" ");
		cbxOgrenciBilgileriIl
				.addChangeHandler(new CbxOgrenciBilgileriIlChangeHandler());

		cbxOgrenciBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIl.setSize("181px", "22px");

		Label label_24 = new Label("İlçe");
		flexTable_5.setWidget(12, 0, label_24);
		label_24.setStyleName("gwt-Bold");
		label_24.setSize("20px", "18px");

		cbxOgrenciBilgileriIlce = new ListBox();
		flexTable_5.setWidget(12, 1, cbxOgrenciBilgileriIlce);
		cbxOgrenciBilgileriIlce.addItem(" ");
		cbxOgrenciBilgileriIlce
				.addChangeHandler(new CbxOgrenciBilgileriIlceChangeHandler());
		cbxOgrenciBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIlce.setSize("181px", "22px");

		Label label_25 = new Label("Okul");
		flexTable_5.setWidget(13, 0, label_25);
		label_25.setStyleName("gwt-Bold");
		label_25.setSize("27px", "18px");

		cbxOkul = new ListBox();
		flexTable_5.setWidget(13, 1, cbxOkul);
		cbxOkul.setStyleName("gwt-ComboBox1");
		cbxOkul.addItem(" ");
		cbxOkul.setSize("350px", "22px");

		Label label_26 = new Label("Sınıf");
		flexTable_5.setWidget(14, 0, label_26);
		label_26.setStyleName("gwt-Bold");
		label_26.setSize("26px", "18px");

		cbxOgrenciBilgileriSinif = new ListBox();
		flexTable_5.setWidget(14, 1, cbxOgrenciBilgileriSinif);
		cbxOgrenciBilgileriSinif.setStyleName("gwt-ComboBox1");
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

		Label lblKayitSilinsinMi = new Label("Kayit Silinsin Mi?");
		flexTable_5.setWidget(15, 0, lblKayitSilinsinMi);
		lblKayitSilinsinMi.setStyleName("gwt-Bold");
		lblKayitSilinsinMi.setSize("152px", "16px");

		chxKayitSilinsinMi = new SimpleCheckBox();
		flexTable_5.setWidget(15, 1, chxKayitSilinsinMi);

		Label lblSilmeSebebi = new Label("Silme Sebebi");
		flexTable_5.setWidget(16, 0, lblSilmeSebebi);
		lblSilmeSebebi.setStyleName("gwt-Bold");

		tctSilmeSebebi = new TextBox();
		flexTable_5.setWidget(16, 1, tctSilmeSebebi);
		tctSilmeSebebi.setStyleName("gwt-TextBox1");
		tctSilmeSebebi.setSize("165px", "16px");

		AbsolutePanel absolutePanel_5 = new AbsolutePanel();
		absolutePanel_5.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_5, "Adres Bilgileri", false);
		absolutePanel_5.setSize("840px", "450px");

		FlexTable flexTable_2 = new FlexTable();
		absolutePanel_5.add(flexTable_2, 10, 10);
		flexTable_2.setSize("322px", "195px");

		Label label = new Label("Ülke");
		flexTable_2.setWidget(0, 0, label);
		label.setStyleName("gwt-Bold");
		label.setSize("26px", "18px");

		cbxAdresBilgileriUlke = new ListBox();
		flexTable_2.setWidget(0, 1, cbxAdresBilgileriUlke);
		cbxAdresBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriUlke.addItem("Türkiye");
		cbxAdresBilgileriUlke.setSize("146px", "22px");

		Label label_1 = new Label("İl");
		flexTable_2.setWidget(1, 0, label_1);
		label_1.setStyleName("gwt-Bold");
		label_1.setSize("26px", "18px");

		cbxAdresBilgileriIl = new ListBox();
		flexTable_2.setWidget(1, 1, cbxAdresBilgileriIl);
		cbxAdresBilgileriIl.addItem(" ");
		cbxAdresBilgileriIl
				.addChangeHandler(new CbxAdresBilgileriIlChangeHandler());
		cbxAdresBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriIl.setSize("146px", "22px");

		Label label_2 = new Label("İlçe");
		flexTable_2.setWidget(2, 0, label_2);
		label_2.setStyleName("gwt-Bold");
		label_2.setSize("20px", "18px");

		cbxAdresBilgileriIlce = new ListBox();
		flexTable_2.setWidget(2, 1, cbxAdresBilgileriIlce);
		cbxAdresBilgileriIlce
				.addChangeHandler(new CbxAdresBilgileriIlceChangeHandler());
		cbxAdresBilgileriIlce.addItem(" ");
		cbxAdresBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriIlce.setSize("146px", "22px");

		Label label_3 = new Label("Semt");
		flexTable_2.setWidget(3, 0, label_3);
		label_3.setStyleName("gwt-Bold");
		label_3.setSize("31px", "18px");

		cbxSemt = new ListBox();
		flexTable_2.setWidget(3, 1, cbxSemt);
		cbxSemt.addChangeHandler(new CbxSemtChangeHandler());
		cbxSemt.addItem(" ");

		cbxSemt.setStyleName("gwt-ComboBox1");
		cbxSemt.setSize("146px", "22px");

		Label label_4 = new Label("Mahalle");
		flexTable_2.setWidget(4, 0, label_4);
		label_4.setStyleName("gwt-Bold");
		label_4.setSize("45px", "18px");

		cbxMahalle = new ListBox();
		flexTable_2.setWidget(4, 1, cbxMahalle);
		cbxMahalle.addItem(" ");
		cbxMahalle.setStyleName("gwt-ComboBox1");
		cbxMahalle.setSize("209px", "22px");

		Label label_5 = new Label("Sokak ve no");
		flexTable_2.setWidget(5, 0, label_5);
		label_5.setStyleName("gwt-Bold");
		label_5.setSize("93px", "18px");

		tctSokakveNo = new TextArea();
		flexTable_2.setWidget(5, 1, tctSokakveNo);
		tctSokakveNo.setStyleName("gwt-TextAreaResible");
		tctSokakveNo.setSize("203px", "49px");
		flexTable_2.getCellFormatter().setVerticalAlignment(5, 0,
				HasVerticalAlignment.ALIGN_TOP);

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_3, "DBS Sonuç", false);
		absolutePanel_3.setSize("840px", "450px");

		FlexTable flexTable_3 = new FlexTable();
		absolutePanel_3.add(flexTable_3, 10, 10);
		flexTable_3.setSize("280px", "204px");

		Label lblNewLabel_2 = new Label("Okul Durumu");
		flexTable_3.setWidget(0, 0, lblNewLabel_2);
		lblNewLabel_2.setStyleName("gwt-Bold");

		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox1");
		flexTable_3.setWidget(0, 1, textBox);
		textBox.setSize("150px", "15px");

		Label lblAlanBilgisi = new Label("Alan Bilgisi");
		flexTable_3.setWidget(1, 0, lblAlanBilgisi);
		lblAlanBilgisi.setStyleName("gwt-Bold");

		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox1");
		flexTable_3.setWidget(1, 1, textBox_1);
		textBox_1.setSize("150px", "15px");

		Label lblSnavTarihi = new Label("Sınav Tarihi");
		flexTable_3.setWidget(2, 0, lblSnavTarihi);
		lblSnavTarihi.setStyleName("gwt-Bold");

		TextBox textBox_2 = new TextBox();
		textBox_2.setStyleName("gwt-TextBox1");
		flexTable_3.setWidget(2, 1, textBox_2);
		textBox_2.setSize("150px", "15px");

		Label lblNewLabel_3 = new Label("DBS Sıralaması");
		flexTable_3.setWidget(3, 0, lblNewLabel_3);
		lblNewLabel_3.setStyleName("gwt-Bold");

		TextBox txtbxGirilmemi = new TextBox();
		txtbxGirilmemi.setStyleName("gwt-TextBox1");
		flexTable_3.setWidget(3, 1, txtbxGirilmemi);
		txtbxGirilmemi.setReadOnly(true);
		txtbxGirilmemi.setText("Sonuç Girilmemiş");
		txtbxGirilmemi.setSize("150px", "15px");

		Label lblSonuc = new Label("Sonuç");
		flexTable_3.setWidget(4, 0, lblSonuc);
		lblSonuc.setStyleName("gwt-Bold");

		TextBox txtbxSonuGirilmemi = new TextBox();
		txtbxSonuGirilmemi.setStyleName("gwt-TextBox1");
		flexTable_3.setWidget(4, 1, txtbxSonuGirilmemi);
		txtbxSonuGirilmemi.setReadOnly(true);
		txtbxSonuGirilmemi.setText("Sonuç Girilmemiş");
		txtbxSonuGirilmemi.setSize("150px", "15px");

		Label lblIndirimMiktar_1 = new Label("İndirim Miktarı");
		flexTable_3.setWidget(5, 0, lblIndirimMiktar_1);
		lblIndirimMiktar_1.setStyleName("gwt-Bold");

		TextBox textBox_5 = new TextBox();
		textBox_5.setStyleName("gwt-TextBox1");
		flexTable_3.setWidget(5, 1, textBox_5);
		textBox_5.setSize("150px", "15px");

		AbsolutePanel absolutePanel_4 = new AbsolutePanel();
		absolutePanel_4.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_4, "Görüşme", false);
		absolutePanel_4.setSize("840px", "450px");

		FlexTable flexTable_4 = new FlexTable();
		absolutePanel_4.add(flexTable_4, 10, 10);
		flexTable_4.setSize("334px", "94px");

		Label lblEitimTr = new Label("Eğitim Türü");
		flexTable_4.setWidget(0, 0, lblEitimTr);
		lblEitimTr.setStyleName("gwt-Bold");

		cbxGorusmeEgitimTuru = new ListBox();
		flexTable_4.setWidget(0, 1, cbxGorusmeEgitimTuru);
		cbxGorusmeEgitimTuru.addItem(" ");
		cbxGorusmeEgitimTuru
				.addChangeHandler(new CbxGorusmeEgitimTuruChangeHandler());
		cbxGorusmeEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxGorusmeEgitimTuru.setSize("160px", "18px");

		Label lblAlan = new Label("Alan");
		flexTable_4.setWidget(1, 0, lblAlan);
		lblAlan.setStyleName("gwt-Bold");

		cbxGorusmeAlan = new ListBox();
		flexTable_4.setWidget(1, 1, cbxGorusmeAlan);
		// cbxGorusmeAlan.addChangeHandler(new CbxGorusmeAlanChangeHandler());
		cbxGorusmeAlan.addItem(" ");
		cbxGorusmeAlan.setStyleName("gwt-ComboBox1");
		cbxGorusmeAlan.setSize("160px", "18px");

		Label lblKursZaman = new Label("Kurs Zamanı");
		flexTable_4.setWidget(2, 0, lblKursZaman);
		lblKursZaman.setStyleName("gwt-Bold");

		cbxGorusmeKursZamani = new ListBox();
		flexTable_4.setWidget(2, 1, cbxGorusmeKursZamani);
		cbxGorusmeKursZamani
				.addChangeHandler(new CbxGorusmeKursZamaniChangeHandler());
		cbxGorusmeKursZamani.addItem(" ");
		cbxGorusmeKursZamani.setStyleName("gwt-ComboBox1");
		cbxGorusmeKursZamani.setSize("160px", "18px");

		Label lblSnf = new Label("Sınıf");
		flexTable_4.setWidget(3, 0, lblSnf);
		lblSnf.setStyleName("gwt-Bold");

		cbxGorusmeSinif = new ListBox();
		flexTable_4.setWidget(3, 1, cbxGorusmeSinif);

		cbxGorusmeSinif.addItem(" ");
		cbxGorusmeSinif.setStyleName("gwt-ComboBox1");
		cbxGorusmeSinif.setSize("160px", "18px");

		Label lblNewLabel_1 = new Label("Kurs İndirim Fiyatı");
		flexTable_4.setWidget(4, 0, lblNewLabel_1);
		lblNewLabel_1.setStyleName("gwt-Bold");
		lblNewLabel_1.setSize("132px", "16px");

		tctGorusmeKursIndirimFiyati = new Label("New label");
		flexTable_4.setWidget(4, 1, tctGorusmeKursIndirimFiyati);
		tctGorusmeKursIndirimFiyati.setSize("89px", "18px");

		Label lblIndirimTr = new Label("İndirim Türü");
		flexTable_4.setWidget(5, 0, lblIndirimTr);
		lblIndirimTr.setStyleName("gwt-Bold");
		lblIndirimTr.setSize("89px", "18px");

		cbxGorusmeIndirimturu = new ListBox();
		flexTable_4.setWidget(5, 1, cbxGorusmeIndirimturu);
		cbxGorusmeIndirimturu.addItem("Pazarlık");
		cbxGorusmeIndirimturu.addItem("İndirim Yok");
		cbxGorusmeIndirimturu.setStyleName("gwt-ComboBox1");
		cbxGorusmeIndirimturu.setSize("160px", "22px");

		Label lblIndirimMiktar = new Label("İndirim Miktarı");
		flexTable_4.setWidget(6, 0, lblIndirimMiktar);
		lblIndirimMiktar.setStyleName("gwt-Bold");
		lblIndirimMiktar.setSize("132px", "18px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flexTable_4.setWidget(6, 1, horizontalPanel);

		cbxGorusmeIndirimMiktari = new ListBox();
		horizontalPanel.add(cbxGorusmeIndirimMiktari);
		horizontalPanel.setCellWidth(cbxGorusmeIndirimMiktari, "80");
		cbxGorusmeIndirimMiktari.addItem("Para");
		cbxGorusmeIndirimMiktari.addItem("Yüzde");
		cbxGorusmeIndirimMiktari.setStyleName("gwt-ComboBox1");
		cbxGorusmeIndirimMiktari.setSize("71px", "22px");

		tctGorusmeIndirimSekli = new TextBox();
		tctGorusmeIndirimSekli
				.addKeyPressHandler(new TctGorusmeIndirimSekliKeyPressHandler());
		horizontalPanel.add(tctGorusmeIndirimSekli);
		tctGorusmeIndirimSekli.setStyleName("gwt-TextBox1");
		tctGorusmeIndirimSekli.setSize("79px", "16px");

		Label lblReferans = new Label("Referans");
		flexTable_4.setWidget(7, 0, lblReferans);
		lblReferans.setStyleName("gwt-Bold");

		tctGorusmeReferans = new TextBox();
		flexTable_4.setWidget(7, 1, tctGorusmeReferans);
		tctGorusmeReferans.setStyleName("gwt-TextBox1");
		tctGorusmeReferans.setSize("160px", "15px");

		Label lblGrmeTarihi = new Label("Görüşme Tarihi");
		flexTable_4.setWidget(8, 0, lblGrmeTarihi);
		lblGrmeTarihi.setStyleName("gwt-Bold");

		dtpGorusmeTarihi = new DateBox();
		flexTable_4.setWidget(8, 1, dtpGorusmeTarihi);
		dtpGorusmeTarihi.setStyleName("gwt-TextBox1");
		dtpGorusmeTarihi
				.addValueChangeHandler(new DtpGorusmeTarihiValueChangeHandler());
		dtpGorusmeTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy.MM.dd")));
		dtpGorusmeTarihi.setSize("160px", "15px");

		Label lblGrmeTipi = new Label("Görüşme Tipi");
		flexTable_4.setWidget(9, 0, lblGrmeTipi);
		lblGrmeTipi.setStyleName("gwt-Bold");

		cbxGorusmeTipi = new ListBox();
		flexTable_4.setWidget(9, 1, cbxGorusmeTipi);
		cbxGorusmeTipi.addItem("Yüzyüze");
		cbxGorusmeTipi.addItem("Telefonla");
		cbxGorusmeTipi.setStyleName("gwt-ComboBox1");
		cbxGorusmeTipi.setSize("160px", "22px");

		Label lblNewLabel = new Label("Görüşme Sonucu");
		flexTable_4.setWidget(10, 0, lblNewLabel);
		lblNewLabel.setStyleName("gwt-Bold");
		lblNewLabel.setWidth("111px");

		cbxGorusmeSonucu = new ListBox();
		flexTable_4.setWidget(10, 1, cbxGorusmeSonucu);
		cbxGorusmeSonucu.addItem("Olumlu");
		cbxGorusmeSonucu.addItem("Olumsuz");
		cbxGorusmeSonucu.addItem("Düşünecekler");
		cbxGorusmeSonucu.addItem("Başka Dershaneye Kaydolmuş");
		cbxGorusmeSonucu.setStyleName("gwt-ComboBox1");
		cbxGorusmeSonucu.setSize("159px", "22px");

		Label lblGrmeYzdesi = new Label("Görüşme Yüzdesi");
		flexTable_4.setWidget(11, 0, lblGrmeYzdesi);
		lblGrmeYzdesi.setStyleName("gwt-Bold");

		tctGorusmeYuzdesi = new TextBox();
		flexTable_4.setWidget(11, 1, tctGorusmeYuzdesi);
		tctGorusmeYuzdesi.setStyleName("gwt-TextBox1");
		tctGorusmeYuzdesi.setSize("159px", "15px");

		Label lblAklama = new Label("Açıklama");
		flexTable_4.setWidget(12, 0, lblAklama);
		lblAklama.setStyleName("gwt-Bold");

		tctAciklama = new TextArea();
		flexTable_4.setWidget(12, 1, tctAciklama);
		tctAciklama.setStyleName("gwt-TextAreaResible");
		tctAciklama.setSize("238px", "61px");
		flexTable_4.getCellFormatter().setVerticalAlignment(12, 0,
				HasVerticalAlignment.ALIGN_TOP);

		AbsolutePanel absolutePanel_8 = new AbsolutePanel();
		absolutePanel_8.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_8, "Öğrenci Kimlik Bilgileri", false);
		absolutePanel_8.setSize("840px", "450px");

		FlexTable flexTable = new FlexTable();
		absolutePanel_8.add(flexTable, 10, 10);
		flexTable.setSize("278px", "382px");

		Label label_6 = new Label("Seri No");
		flexTable.setWidget(0, 0, label_6);
		label_6.setStyleName("gwt-Bold");
		label_6.setSize("64px", "18px");

		tctSeriNo = new TextBox();
		tctSeriNo.addKeyPressHandler(new TctSeriNoKeyPressHandler());
		flexTable.setWidget(0, 1, tctSeriNo);
		tctSeriNo.setMaxLength(4);
		tctSeriNo.setStyleName("gwt-TextBox1");
		tctSeriNo.setSize("158px", "18px");

		Label label_7 = new Label("Cüzdan No");
		flexTable.setWidget(1, 0, label_7);
		label_7.setStyleName("gwt-Bold");
		label_7.setSize("108px", "18px");

		tctCuzdanNo = new TextBox();
		tctCuzdanNo.addKeyPressHandler(new TctCuzdanNoKeyPressHandler());
		flexTable.setWidget(1, 1, tctCuzdanNo);
		tctCuzdanNo.setMaxLength(10);
		tctCuzdanNo.setStyleName("gwt-TextBox1");
		tctCuzdanNo.setSize("158px", "18px");

		Label lblKaytlOlduu = new Label("Kayıtlı Olduğu");
		flexTable.setWidget(2, 0, lblKaytlOlduu);
		lblKaytlOlduu.setStyleName("gwt-Bold");
		lblKaytlOlduu.setSize("108px", "18px");

		Label label_9 = new Label("Ülke");
		flexTable.setWidget(3, 0, label_9);
		label_9.setStyleName("gwt-Bold");
		label_9.setSize("43px", "18px");

		cbxOgrenciKimlikBilgileriUlke = new ListBox();
		flexTable.setWidget(3, 1, cbxOgrenciKimlikBilgileriUlke);
		cbxOgrenciKimlikBilgileriUlke.addItem("Türkiye");
		cbxOgrenciKimlikBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriUlke.setSize("162px", "22px");

		Label label_10 = new Label("İl");
		flexTable.setWidget(4, 0, label_10);
		label_10.setStyleName("gwt-Bold");
		label_10.setSize("20px", "18px");

		cbxOgrenciKimlikBilgileriIl = new ListBox();
		flexTable.setWidget(4, 1, cbxOgrenciKimlikBilgileriIl);
		cbxOgrenciKimlikBilgileriIl
				.addChangeHandler(new CbxOgrenciKimlikBilgileriIlChangeHandler());
		cbxOgrenciKimlikBilgileriIl.addItem(" ");
		cbxOgrenciKimlikBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriIl.setSize("162px", "22px");

		Label label_11 = new Label("İlçe");
		flexTable.setWidget(5, 0, label_11);
		label_11.setStyleName("gwt-Bold");
		label_11.setSize("20px", "18px");

		cbxOgrenciKimlikBilgileriIlce = new ListBox();
		flexTable.setWidget(5, 1, cbxOgrenciKimlikBilgileriIlce);

		cbxOgrenciKimlikBilgileriIlce.addItem(" ");
		cbxOgrenciKimlikBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriIlce.setSize("162px", "22px");

		Label label_12 = new Label("Mahalle / Köy");
		flexTable.setWidget(6, 0, label_12);
		label_12.setStyleName("gwt-Bold");
		label_12.setSize("108px", "18px");

		tctMahalleKoy = new TextBox();
		flexTable.setWidget(6, 1, tctMahalleKoy);
		tctMahalleKoy.setStyleName("gwt-TextBox1");
		tctMahalleKoy.setSize("158px", "18px");

		Label label_13 = new Label("Cilt No");
		flexTable.setWidget(7, 0, label_13);
		label_13.setStyleName("gwt-Bold");
		label_13.setSize("64px", "18px");

		tctCiltNo = new TextBox();
		tctCiltNo.addKeyPressHandler(new TctCiltNoKeyPressHandler());
		flexTable.setWidget(7, 1, tctCiltNo);
		tctCiltNo.setStyleName("gwt-TextBox1");
		tctCiltNo.setSize("158px", "18px");

		Label label_14 = new Label("Aile Sıra No");
		flexTable.setWidget(8, 0, label_14);
		label_14.setStyleName("gwt-Bold");
		label_14.setSize("88px", "18px");

		tctAileSiraNo = new TextBox();
		tctAileSiraNo.addKeyPressHandler(new TctAileSiraNoKeyPressHandler());
		flexTable.setWidget(8, 1, tctAileSiraNo);
		tctAileSiraNo.setStyleName("gwt-TextBox1");
		tctAileSiraNo.setSize("158px", "18px");

		Label label_15 = new Label("Sıra No");
		flexTable.setWidget(9, 0, label_15);
		label_15.setStyleName("gwt-Bold");
		label_15.setSize("64px", "18px");

		tctSiraNo = new TextBox();
		tctSiraNo.addKeyPressHandler(new TctSiraNoKeyPressHandler());
		flexTable.setWidget(9, 1, tctSiraNo);
		tctSiraNo.setStyleName("gwt-TextBox1");
		tctSiraNo.setSize("158px", "18px");

		Label lblCzdanBilgileri = new Label("Cüzdan Bilgileri");
		lblCzdanBilgileri.setStyleName("gwt-Bold");
		flexTable.setWidget(10, 0, lblCzdanBilgileri);

		Label label_17 = new Label("Verildiği Yer");
		label_17.setStyleName("gwt-Bold");
		flexTable.setWidget(11, 0, label_17);
		label_17.setSize("99px", "18px");

		tctVerildigiYer = new TextBox();
		flexTable.setWidget(11, 1, tctVerildigiYer);
		tctVerildigiYer.setStyleName("gwt-TextBox1");
		tctVerildigiYer.setSize("158px", "18px");

		Label label_18 = new Label("Veriliş Nedeni");
		label_18.setStyleName("gwt-Bold");
		flexTable.setWidget(12, 0, label_18);
		label_18.setSize("115px", "18px");

		tctVerilisNedeni = new TextBox();
		flexTable.setWidget(12, 1, tctVerilisNedeni);
		tctVerilisNedeni.setStyleName("gwt-TextBox1");
		tctVerilisNedeni.setSize("158px", "18px");

		Label label_19 = new Label("Kayıt No");
		label_19.setStyleName("gwt-Bold");
		flexTable.setWidget(13, 0, label_19);
		label_19.setSize("116px", "18px");

		tctKayitNo = new TextBox();
		tctKayitNo.addKeyPressHandler(new TctKayitNoKeyPressHandler());
		flexTable.setWidget(13, 1, tctKayitNo);
		tctKayitNo.setStyleName("gwt-TextBox1");
		tctKayitNo.setSize("158px", "18px");

		Label label_20 = new Label("Veriliş Tarihi");
		label_20.setStyleName("gwt-Bold");
		flexTable.setWidget(14, 0, label_20);
		label_20.setSize("137px", "18px");

		dtpVerilisTarihi = new DateBox();
		flexTable.setWidget(14, 1, dtpVerilisTarihi);
		dtpVerilisTarihi.setStyleName("gwt-TextBox1");
		dtpVerilisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getShortDateFormat()));
		dtpVerilisTarihi
				.addValueChangeHandler(new DtpVerilisTarihiValueChangeHandler());
		dtpVerilisTarihi.setSize("158px", "18px");

		AbsolutePanel absolutePanel_7 = new AbsolutePanel();
		absolutePanel_7.setStyleName("gwt-DialogBackGround");
		tabOnKayit.add(absolutePanel_7, "Veli Bilgileri", false);
		absolutePanel_7.setSize("840px", "450px");

		Button button = new Button("Veli Ekle");
		button.setStyleName("gwt-BilgileriniGetir");
		button.addClickHandler(new ButtonClickHandler());
		absolutePanel_7.add(button, 10, 10);
		button.setSize("76px", "24px");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		absolutePanel_7.add(horizontalPanel_3, 0, 40);
		horizontalPanel_3.setSize("100%", "100px");

		grdVeliEkle = new CellTable<XMLVeliler>();
		horizontalPanel_3.add(grdVeliEkle);
		grdVeliEkle.setSize("100%", "100%");

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

		Column<XMLVeliler, Boolean> column_5 = new Column<XMLVeliler, Boolean>(
				new CheckboxCell()) {
			@Override
			public Boolean getValue(XMLVeliler object) {
				return object.odeme_sorumlusu.equalsIgnoreCase("t") ? true
						: false;
			}
		};
		grdVeliEkle.addColumn(column_5, "Ödeme Sorumlusu");

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

		Column<XMLVeliler, String> column = new Column<XMLVeliler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return "Düzenle";
			}
		};
		grdVeliEkle.addColumn(column, "Düzenle");

		Column<XMLVeliler, String> column_1 = new Column<XMLVeliler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return "Sil";
			}
		};
		grdVeliEkle.addColumn(column_1, "Sil");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		verticalpanel.add(absolutePanel_1);
		verticalpanel.setCellHorizontalAlignment(absolutePanel_1,
				HasHorizontalAlignment.ALIGN_RIGHT);
		absolutePanel_1.setSize("191px", "67px");

		btnYeniOgrenci = new Button("Yeni Öğrenci");
		btnYeniOgrenci.setVisible(false);
		btnYeniOgrenci.setStyleName("gwt-ButtonSave");
		btnYeniOgrenci.addClickHandler(new BtnYeniOgrenciClickHandler());
		absolutePanel_1.add(btnYeniOgrenci, 220, 10);
		btnYeniOgrenci.setSize("80px", "63px");

		Button btnKapat1 = new Button("Kapat");
		btnKapat1.setVisible(false);
		btnKapat1.setText("");
		btnKapat1.setStyleName("gwt-ButonKapat");
		btnKapat1.addClickHandler(new BtnKapat1ClickHandler());
		absolutePanel_1.add(btnKapat1, 313, 10);
		btnKapat1.setSize("80px", "63px");

		image = new Image("kaydet-1.png");
		image.addMouseOutHandler(new ImageMouseOutHandler());
		image.addMouseOverHandler(new ImageMouseOverHandler());
		image.addClickHandler(new ImageClickHandler());
		absolutePanel_1.add(image, 10, 0);
		image.setSize("72px", "66px");

		image_1 = new Image("kapat-1.png");
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel_1.add(image_1, 88, 0);
		image_1.setSize("72px", "66px");

		if (!isDesignTime()) {
			putIlToCbx(cbxOgrenciBilgileriIl, cbxAdresBilgileriIl,
					cbxOgrenciKimlikBilgileriIl);
			putGorusmeKursZamaniToCbx(cbxGorusmeKursZamani);
			putEgitimTuruToCbx(cbxGorusmeEgitimTuru);

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
			column.setFieldUpdater(new FieldUpdater<XMLVeliler, String>() {

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
			column_1.setFieldUpdater(new FieldUpdater<XMLVeliler, String>() {

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
					grdVeliEkle.setRowCount(1, true);

					// Push the data into the widget.
					// grdVeliEkle.setRowData(0, listXmlVeliler);

					if (listXmlVeliler != null) {

						grdVeliEkle.setRowData(0, listXmlVeliler);

						grdVeliEkle.redraw();

					} else {

						grdVeliEkle.setRowCount(0, true);
						grdVeliEkle.redraw();
					}

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
		tctSilmeSebebi.setText(xml.silme_sebebi);

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

		// cbxGorusmeSinif.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxGorusmeSinif, xml.gorusme_sinif));
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
		cbxGorusmeSinif.setItemText(0, xml.gorusme_sinif);

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

		chxKayitSilinsinMi
				.setValue(xml.kayit_silinsin_mi.equalsIgnoreCase("t") ? true
						: false);

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

		dtpDogumTarihi.setValue(dtf.parse(xml.dogum_tarihi));
		dtpVerilisTarihi.setValue(dtf.parse(xml.verilis_tarihi));
		dtpGorusmeTarihi.setValue(dtf.parse(xml.gorusme_tarihi));

		putDataToGrid(tctTCKimlikNo.getText());

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
					+ cbxGorusmeSinif.getItemText(cbxGorusmeSinif
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

			URLValue = URLValue + "&kayit_silinsin_mi="
					+ chxKayitSilinsinMi.getValue().toString();

			URLValue = URLValue + "&silme_sebebi=" + tctSilmeSebebi.getText();
			URLValue = URLValue + "&kayit_silinsin_mi=FALSE";

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
			// String urlWithParameters = Util.urlBase + "getonkayit"
			// + "?tc_kimlik_no=" + tctTCKimlikNo.getText();
			//
			// RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
			// urlWithParameters);
			// // Window.alert("URL TO GET VALUES: " + urlWithParameters);
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
			// // Window.alert("AAABBBCCC " +
			// // response.getText());
			// List<XMLOnKayit> listXmlOnKayit = XMLOnKayit.XML
			// .readList(response.getText());
			//
			// DlgOnKayit dlgTemp = new DlgOnKayit(_isInsert,
			// -1);
			// _dlgonkayit.hide();
			// dlgTemp.putDataFromXML(listXmlOnKayit.get(0));
			// dlgTemp.center();
			// dlgTemp.tabOnKayit.selectTab(0);
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

								_dlgonkayit.hide();

								DlgOnKayit dlgTemp = new DlgOnKayit(_isInsert,
										-1);
								dlgTemp.tabOnKayit.selectTab(0);

								dlgTemp.putDataFromXML(listXmlDBSKayit.get(0));
								dlgTemp.center();

								dlgTemp.addCloseHandler(new CloseHandler<PopupPanel>() {

									@Override
									public void onClose(
											CloseEvent<PopupPanel> event) {

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

	protected void putDataFromXML(XMLDBSKayit xml) {
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

		tctMahalleKoy.setText(xml.mahalle_koy);

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
				cbxOgrenciBilgileriSinif, xml.sinif));

		// cbxGorusmeSinif.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxGorusmeSinif, xml.gorusme_sinif));

		cbxAdresBilgileriUlke.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxAdresBilgileriUlke, xml.adres_bilgileri_ulke));
		cbxOgrenciKimlikBilgileriUlke.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxOgrenciBilgileriUlke,
						xml.ogrenci_kimlik_bilgileri_ulke));

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

		// chxKesinKayitMi
		// .setValue(xml.kesin_kayit_mi.equalsIgnoreCase("t") ? true
		// : false);

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

		dtpDogumTarihi.setValue(dtf.parse(xml.dogum_tarihi));
		dtpVerilisTarihi.setValue(dtf.parse(xml.verilis_tarihi));

	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnYeniOgrenci.click();
		}
	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class Image_1MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_1.setUrl("kapat-2.png");

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

	private class Image_1MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_1.setUrl("kapat-1.png");

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

	private class TctGorusmeIndirimSekliKeyPressHandler implements
			KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctGorusmeIndirimSekli.getText();
			if (!input.matches("[0-9]*")) {
				tctGorusmeIndirimSekli.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctGorusmeIndirimSekli.setStyleName("gwt-TextBox1");
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
}
