package com.icarusdb.portal.icacourses.main.client;

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
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
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
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.view.client.SingleSelectionModel;

public class KesinKayitBilgileri extends DialogBox {

	public boolean _isInsert = true;
	public long _id = -1;
	public DlgVeliEkle _dlgVeliler;

	private ListBox cbxMedeniHali;
	private ListBox cbxCinsiyet;
	private DateBox dtpDogumTarihi;
	private TextBox tctEvTelefonu;
	private TextBox tctCepTelefonu;
	private TextBox tctEmail;
	private DateBox dtpVerilisTarihi;
	private TextBox tctKayitNo;
	private TextBox tctVerilisNedeni;
	private TextBox tctVerildigiYer;
	private TextBox tctSiraNo;
	private TextBox tctAileSiraNo;
	private TextBox tctCiltNo;
	private TextBox tctMahalleKoy;
	private ListBox cbxOgrenciKimlikBilgileriIlce;
	private ListBox cbxOgrenciKimlikBilgileriIl;
	private ListBox cbxOgrenciKimlikBilgileriUlke;
	private TextBox tctCuzdanNo;
	private TextBox tctSeriNo;
	private ListBox cbxAdresBilgileriUlke;
	private ListBox cbxAdresBilgileriIl;
	private ListBox cbxMahalle;
	private ListBox cbxSemt;
	private ListBox cbxAdresBilgileriIlce;
	private ListBox cbxKursZamani;
	private ListBox cbxAlan;
	private ListBox cbxEgitimTuru;
	private ListBox cbxSinif;
	private TextBox tctKursIndirimFiyati;
	private TextBox tctOgrenciNumarasi;
	private ListBox cbxIndirimSekli;
	private ListBox cbxReferans;
	private ListBox cbxIndirimTuru;
	private ListBox cbxHizmetTuru;
	private ListBox cbxHizmetAdi;
	private ListBox cbxHizmetlerIndirimTuru;
	private TextBox tctHizmetlerIndirimMiktari;
	private TextBox tctMiktar;
	private Button btnNewButton;
	private Button btnNewButton_1;
	private CellTable<XMLHizmetTanimla> grdHizmetler;
	private AbsolutePanel tabAdresi;
	private ListBox cbxOkul;
	private AbsolutePanel absolutePanel_2;
	private TextBox tctAdi;
	private TextBox tctSoyadi;
	private TextBox tctTCKimlikNo;
	private ListBox cbxOgrenciBilgileriIlce;
	private ListBox cbxOgrenciBilgileriIl;
	private ListBox cbxOgrenciBilgileriUlke;
	private ListBox cbxOgrenciBilgileriSinif;
	private TextBox tctOkulNumarasi;
	private CellTable<XMLVeliler> grdVeliEkle;
	public DecoratedTabPanel tabKesinKayitBilgileri;
	private TextBox tctHizmetlerinToplamı;
	private TextBox tctIndirimliTutar;
	private TextBox tctToplamTutar;
	private ListBox cbxPesinatOdemeTuru;
	private ListBox cbxPesinatınYatacagiBanka;
	private TextBox tctPesinatMiktari;
	private ListBox cbxTaksitinOdemeTuru;
	private TextBox tctTaksitlerinToplami;
	private TextBox tctSozlesmeDisiKalan;
	private ListBox cbxTaksitinYapilacagiBanka;
	private DateBox dtpTaksideBaslanacakGun;
	private TextBox tctTaksitSayisi;
	private TextBox tctIndirimMiktari;
	private TextArea tctSokakveNo;
	private Button btnOgrenciyiKaydet;
	private Button btnKimligiKaydet;
	private TextArea tctAciklama;
	private TextArea tctTaksitAciklama;
	private Column<XMLVeliler, String> column_1;
	private Column<XMLVeliler, String> column;
	private Image image_1;
	private Image image_2;
	private Image image_3;
	private Image image_4;
	private Image image_6;
	private Image image_5;
	private Image image_7;
	private Image image_8;
	private Image image_9;
	private Image image_10;

	public KesinKayitBilgileri(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;
		setHTML("Kesin Kayıt İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("822px", "650px");

		tabKesinKayitBilgileri = new DecoratedTabPanel();
		tabKesinKayitBilgileri.setAnimationEnabled(true);
		absolutePanel.add(tabKesinKayitBilgileri, 10, 121);
		tabKesinKayitBilgileri.setSize("809px", "500px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabKesinKayitBilgileri.add(absolutePanel_1, "Kişisel Bilgileri", false);
		absolutePanel_1.setSize("713px", "475px");

		Button btnNewButton_4 = new Button("Kapat");
		btnNewButton_4.setVisible(false);
		btnNewButton_4.setText("");
		btnNewButton_4.addClickHandler(new BtnNewButton_4ClickHandler());
		btnNewButton_4.setStyleName("gwt-ButonKapat");
		absolutePanel_1.add(btnNewButton_4, 589, 180);
		btnNewButton_4.setSize("80px", "60px");

		btnOgrenciyiKaydet = new Button("Öğrenciyi Kaydet");
		btnOgrenciyiKaydet.setVisible(false);
		btnOgrenciyiKaydet
				.addClickHandler(new BtnOgrenciyiKaydetClickHandler());
		btnOgrenciyiKaydet.setStyleName("gwt-ButtonSave");
		absolutePanel_1.add(btnOgrenciyiKaydet, 498, 179);
		btnOgrenciyiKaydet.setSize("80px", "60px");

		image_1 = new Image("kaydet-1.png");
		image_1.addMouseOutHandler(new Image_1MouseOutHandler());
		image_1.addMouseOverHandler(new Image_1MouseOverHandler());
		image_1.addClickHandler(new Image_1ClickHandler());
		absolutePanel_1.add(image_1, 491, 324);
		image_1.setSize("72px", "66px");

		image_2 = new Image("kapat-1.png");
		image_2.addMouseOutHandler(new Image_2MouseOutHandler());
		image_2.addMouseOverHandler(new Image_2MouseOverHandler());
		image_2.addClickHandler(new Image_2ClickHandler());
		absolutePanel_1.add(image_2, 569, 324);
		image_2.setSize("72px", "66px");

		FlexTable flexTable = new FlexTable();
		absolutePanel_1.add(flexTable, 10, 10);
		flexTable.setSize("446px", "292px");

		Label label_3 = new Label("Cinsiyet");
		flexTable.setWidget(0, 0, label_3);
		label_3.setStyleName("gwt-Bold");
		label_3.setSize("68px", "18px");

		cbxCinsiyet = new ListBox();
		flexTable.setWidget(0, 1, cbxCinsiyet);
		cbxCinsiyet.setStyleName("gwt-ComboBox1");
		cbxCinsiyet.addItem("Erkek");
		cbxCinsiyet.addItem("Kız");
		cbxCinsiyet.setSize("128px", "22px");

		Label label_4 = new Label("Medeni Hali");
		flexTable.setWidget(1, 0, label_4);
		label_4.setStyleName("gwt-Bold");
		label_4.setSize("85px", "18px");

		cbxMedeniHali = new ListBox();
		flexTable.setWidget(1, 1, cbxMedeniHali);
		cbxMedeniHali.setStyleName("gwt-ComboBox1");
		cbxMedeniHali.addItem("Evli");
		cbxMedeniHali.addItem("Bekar");
		cbxMedeniHali.setSize("128px", "22px");

		Label label_5 = new Label("Doğum Tarihi");
		flexTable.setWidget(2, 0, label_5);
		label_5.setStyleName("gwt-Bold");
		label_5.setSize("128px", "18px");

		dtpDogumTarihi = new DateBox();
		flexTable.setWidget(2, 1, dtpDogumTarihi);
		dtpDogumTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpDogumTarihi.setStyleName("gwt-TextBox1");
		dtpDogumTarihi.setSize("124px", "14px");

		Label label_6 = new Label("Ev / Cep Telefonu");
		flexTable.setWidget(3, 0, label_6);
		label_6.setStyleName("gwt-Bold");
		label_6.setSize("115px", "18px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flexTable.setWidget(3, 1, horizontalPanel);
		horizontalPanel.setSize("296px", "11px");

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.setMaxLength(11);
		tctEvTelefonu.addKeyPressHandler(new TctEvTelefonuKeyPressHandler());
		horizontalPanel.add(tctEvTelefonu);
		horizontalPanel.setCellHeight(tctEvTelefonu, "20");
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		tctEvTelefonu.setSize("126px", "14px");

		tctCepTelefonu = new TextBox();
		tctCepTelefonu.setMaxLength(11);
		tctCepTelefonu.addKeyPressHandler(new TctCepTelefonuKeyPressHandler());
		horizontalPanel.add(tctCepTelefonu);
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		tctCepTelefonu.setSize("143px", "14px");

		Label label_7 = new Label("E-Mail");
		flexTable.setWidget(4, 0, label_7);
		label_7.setStyleName("gwt-Bold");
		label_7.setSize("68px", "18px");

		tctEmail = new TextBox();
		tctEmail.addKeyPressHandler(new TctEmailKeyPressHandler());
		flexTable.setWidget(4, 1, tctEmail);
		tctEmail.setStyleName("gwt-TextBox1");
		tctEmail.setSize("232px", "14px");

		Label lblOkulBilgisi = new Label("OKUL BİLGİSİ");
		flexTable.setWidget(5, 0, lblOkulBilgisi);
		lblOkulBilgisi.setStyleName("gwt-Bold");
		lblOkulBilgisi.setSize("105px", "27px");

		Label lbllke = new Label("Ülke");
		flexTable.setWidget(6, 0, lbllke);
		lbllke.setStyleName("gwt-Bold");
		lbllke.setSize("26px", "18px");

		cbxOgrenciBilgileriUlke = new ListBox();
		flexTable.setWidget(6, 1, cbxOgrenciBilgileriUlke);
		cbxOgrenciBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriUlke.addItem("Türkiye");
		cbxOgrenciBilgileriUlke.setSize("128px", "22px");

		Label label_2 = new Label("İl");
		flexTable.setWidget(7, 0, label_2);
		label_2.setStyleName("gwt-Bold");
		label_2.setSize("68px", "18px");

		cbxOgrenciBilgileriIl = new ListBox();
		flexTable.setWidget(7, 1, cbxOgrenciBilgileriIl);
		cbxOgrenciBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIl
				.addChangeHandler(new CbxOgrenciBilgileriIlChangeHandler());
		cbxOgrenciBilgileriIl.addItem(" ");
		cbxOgrenciBilgileriIl.setSize("163px", "22px");

		Label label_8 = new Label("İlçe");
		flexTable.setWidget(8, 0, label_8);
		label_8.setStyleName("gwt-Bold");
		label_8.setSize("40px", "18px");

		cbxOgrenciBilgileriIlce = new ListBox();
		flexTable.setWidget(8, 1, cbxOgrenciBilgileriIlce);
		cbxOgrenciBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIlce
				.addChangeHandler(new CbxOgrenciBilgileriIlceChangeHandler());
		cbxOgrenciBilgileriIlce.addItem(" ");
		cbxOgrenciBilgileriIlce.setSize("163px", "22px");

		Label label_9 = new Label("Okul");
		flexTable.setWidget(9, 0, label_9);
		label_9.setStyleName("gwt-Bold");
		label_9.setSize("27px", "18px");

		cbxOkul = new ListBox();
		flexTable.setWidget(9, 1, cbxOkul);
		cbxOkul.setStyleName("gwt-ComboBox1");
		cbxOkul.addItem(" ");
		cbxOkul.setSize("258px", "22px");

		Label label_10 = new Label("Sınıf");
		flexTable.setWidget(10, 0, label_10);
		label_10.setStyleName("gwt-Bold");
		label_10.setSize("40px", "18px");

		cbxOgrenciBilgileriSinif = new ListBox();
		flexTable.setWidget(10, 1, cbxOgrenciBilgileriSinif);
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
		cbxOgrenciBilgileriSinif.setSize("127px", "22px");

		Label lblNewLabel_1 = new Label("Okul Numarası");
		flexTable.setWidget(11, 0, lblNewLabel_1);
		lblNewLabel_1.setStyleName("gwt-Bold");
		lblNewLabel_1.setSize("105px", "16px");

		tctOkulNumarasi = new TextBox();
		tctOkulNumarasi
				.addKeyPressHandler(new TctOkulNumarasiKeyPressHandler());
		flexTable.setWidget(11, 1, tctOkulNumarasi);
		tctOkulNumarasi.setStyleName("gwt-TextBox1");
		tctOkulNumarasi.setSize("126px", "15px");

		absolutePanel_2 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_2, "Kimlik Bilgileri", false);
		absolutePanel_2.setSize("609px", "475px");

		btnKimligiKaydet = new Button("Kimliği Kaydet");
		btnKimligiKaydet.setVisible(false);
		btnKimligiKaydet.addClickHandler(new BtnKimligiKaydetClickHandler());
		btnKimligiKaydet.setStyleName("gwt-ButtonSave");
		absolutePanel_2.add(btnKimligiKaydet, 351, 287);
		btnKimligiKaydet.setSize("78px", "49px");

		Button btnKapat2 = new Button("Kapat");
		btnKapat2.setVisible(false);
		btnKapat2.setText("");
		btnKapat2.setStyleName("gwt-ButonKapat");
		absolutePanel_2.add(btnKapat2, 442, 288);
		btnKapat2.setSize("78px", "49px");

		image_3 = new Image("kaydet-1.png");
		image_3.addMouseOutHandler(new Image_3MouseOutHandler());
		image_3.addMouseOverHandler(new Image_3MouseOverHandler());
		image_3.addClickHandler(new Image_3ClickHandler());
		absolutePanel_2.add(image_3, 321, 402);
		image_3.setSize("72px", "66px");

		image_4 = new Image("kapat-1.png");
		image_4.addMouseOutHandler(new Image_4MouseOutHandler());
		image_4.addMouseOverHandler(new Image_4MouseOverHandler());
		image_4.addClickHandler(new Image_4ClickHandler());
		absolutePanel_2.add(image_4, 399, 402);
		image_4.setSize("72px", "66px");

		FlexTable flexTable_1 = new FlexTable();
		absolutePanel_2.add(flexTable_1, 10, 10);
		flexTable_1.setSize("201px", "66px");

		Label label_23 = new Label("Seri No");
		flexTable_1.setWidget(0, 0, label_23);
		label_23.setStyleName("gwt-Bold");
		label_23.setSize("90px", "18px");

		tctSeriNo = new TextBox();
		tctSeriNo.addKeyPressHandler(new TctSeriNoKeyPressHandler());
		flexTable_1.setWidget(0, 1, tctSeriNo);
		tctSeriNo.setMaxLength(4);
		tctSeriNo.setStyleName("gwt-TextBox1");
		tctSeriNo.setSize("160px", "14px");

		Label label_11 = new Label("Cüzdan No");
		flexTable_1.setWidget(1, 0, label_11);
		label_11.setStyleName("gwt-Bold");
		label_11.setSize("100px", "18px");

		tctCuzdanNo = new TextBox();
		tctCuzdanNo.addKeyPressHandler(new TctCuzdanNoKeyPressHandler());
		flexTable_1.setWidget(1, 1, tctCuzdanNo);
		tctCuzdanNo.setMaxLength(10);
		tctCuzdanNo.setStyleName("gwt-TextBox1");
		tctCuzdanNo.setSize("160px", "14px");

		Label label_12 = new Label("Kayıtlı Oldugu");
		flexTable_1.setWidget(2, 0, label_12);
		label_12.setStyleName("gwt-Bold");
		label_12.setSize("115px", "28px");

		Label label_13 = new Label("Ülke");
		flexTable_1.setWidget(3, 0, label_13);
		label_13.setStyleName("gwt-Bold");
		label_13.setSize("43px", "18px");

		cbxOgrenciKimlikBilgileriUlke = new ListBox();
		flexTable_1.setWidget(3, 1, cbxOgrenciKimlikBilgileriUlke);
		cbxOgrenciKimlikBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriUlke.addItem("Türkiye");
		cbxOgrenciKimlikBilgileriUlke.setSize("162px", "22px");

		Label label_14 = new Label("İl");
		flexTable_1.setWidget(4, 0, label_14);
		label_14.setStyleName("gwt-Bold");
		label_14.setSize("6px", "18px");

		cbxOgrenciKimlikBilgileriIl = new ListBox();
		flexTable_1.setWidget(4, 1, cbxOgrenciKimlikBilgileriIl);
		cbxOgrenciKimlikBilgileriIl
				.addChangeHandler(new CbxOgrenciKimlikBilgileriIlChangeHandler_1());

		cbxOgrenciKimlikBilgileriIl.addItem(" ");
		cbxOgrenciKimlikBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriIl.setSize("162px", "22px");

		Label label_15 = new Label("İlçe");
		flexTable_1.setWidget(5, 0, label_15);
		label_15.setStyleName("gwt-Bold");
		label_15.setSize("20px", "18px");

		cbxOgrenciKimlikBilgileriIlce = new ListBox();
		flexTable_1.setWidget(5, 1, cbxOgrenciKimlikBilgileriIlce);

		cbxOgrenciKimlikBilgileriIlce.addItem(" ");
		cbxOgrenciKimlikBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriIlce.setSize("162px", "22px");

		Label label_16 = new Label("Mahalle / Köy");
		flexTable_1.setWidget(6, 0, label_16);
		label_16.setStyleName("gwt-Bold");
		label_16.setSize("100px", "18px");

		tctMahalleKoy = new TextBox();
		flexTable_1.setWidget(6, 1, tctMahalleKoy);
		tctMahalleKoy.setStyleName("gwt-TextBox1");
		tctMahalleKoy.setSize("160px", "14px");

		Label label_17 = new Label("Cilt No");
		flexTable_1.setWidget(7, 0, label_17);
		label_17.setStyleName("gwt-Bold");
		label_17.setSize("53px", "18px");

		tctCiltNo = new TextBox();
		tctCiltNo.addKeyPressHandler(new TctCiltNoKeyPressHandler());
		flexTable_1.setWidget(7, 1, tctCiltNo);
		tctCiltNo.setStyleName("gwt-TextBox1");
		tctCiltNo.setSize("160px", "14px");

		Label label_18 = new Label("Aile Sıra No");
		flexTable_1.setWidget(8, 0, label_18);
		label_18.setStyleName("gwt-Bold");
		label_18.setSize("100px", "18px");

		tctAileSiraNo = new TextBox();
		tctAileSiraNo.addKeyPressHandler(new TctAileSiraNoKeyPressHandler());
		flexTable_1.setWidget(8, 1, tctAileSiraNo);
		tctAileSiraNo.setStyleName("gwt-TextBox1");
		tctAileSiraNo.setSize("160px", "14px");

		Label label_19 = new Label("Sıra No");
		flexTable_1.setWidget(9, 0, label_19);
		label_19.setStyleName("gwt-Bold");
		label_19.setSize("64px", "18px");

		tctSiraNo = new TextBox();
		tctSiraNo.addKeyPressHandler(new TctSiraNoKeyPressHandler());
		flexTable_1.setWidget(9, 1, tctSiraNo);
		tctSiraNo.setStyleName("gwt-TextBox1");
		tctSiraNo.setSize("160px", "14px");

		Label label_20 = new Label("Cüzdan Bilgileri");
		flexTable_1.setWidget(10, 0, label_20);
		label_20.setStyleName("gwt-Bold");
		label_20.setSize("115px", "29px");

		Label label_21 = new Label("Verildiği Yer");
		flexTable_1.setWidget(11, 0, label_21);
		label_21.setStyleName("gwt-Bold");
		label_21.setSize("90px", "18px");

		tctVerildigiYer = new TextBox();
		flexTable_1.setWidget(11, 1, tctVerildigiYer);
		tctVerildigiYer.setStyleName("gwt-TextBox1");
		tctVerildigiYer.setSize("160px", "14px");

		Label label_22 = new Label("Veriliş Nedeni");
		flexTable_1.setWidget(12, 0, label_22);
		label_22.setStyleName("gwt-Bold");
		label_22.setSize("100px", "18px");

		tctVerilisNedeni = new TextBox();
		flexTable_1.setWidget(12, 1, tctVerilisNedeni);
		tctVerilisNedeni.setStyleName("gwt-TextBox1");
		tctVerilisNedeni.setSize("160px", "14px");

		Label label_24 = new Label("Kayıt No");
		flexTable_1.setWidget(13, 0, label_24);
		label_24.setStyleName("gwt-Bold");
		label_24.setSize("64px", "18px");

		tctKayitNo = new TextBox();
		tctKayitNo.addKeyPressHandler(new TctKayitNoKeyPressHandler());
		flexTable_1.setWidget(13, 1, tctKayitNo);
		tctKayitNo.setStyleName("gwt-TextBox1");
		tctKayitNo.setSize("160px", "14px");

		Label label_25 = new Label("Veriliş Tarihi");
		flexTable_1.setWidget(14, 0, label_25);
		label_25.setStyleName("gwt-Bold");
		label_25.setSize("100px", "18px");

		dtpVerilisTarihi = new DateBox();
		flexTable_1.setWidget(14, 1, dtpVerilisTarihi);
		dtpVerilisTarihi.setStyleName("gwt-TextBox1");
		dtpVerilisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpVerilisTarihi.setSize("158px", "14px");

		tabAdresi = new AbsolutePanel();
		tabAdresi.setStyleName("gwt-DialogBackGround");
		tabKesinKayitBilgileri.add(tabAdresi, "Adresi", false);
		tabAdresi.setSize("704px", "475px");

		Button btnAdresiKaydet = new Button("Adresi Kaydet");
		btnAdresiKaydet.setVisible(false);
		btnAdresiKaydet.addClickHandler(new BtnAdresiKaydetClickHandler());
		btnAdresiKaydet.setStyleName("gwt-ButtonSave");
		tabAdresi.add(btnAdresiKaydet, 391, 88);
		btnAdresiKaydet.setSize("78px", "49px");

		Button button_1 = new Button("Kapat");
		button_1.setVisible(false);
		button_1.setText("");
		button_1.setStyleName("gwt-ButonKapat");
		tabAdresi.add(button_1, 482, 89);
		button_1.setSize("78px", "49px");

		image_5 = new Image("kaydet-1.png");
		image_5.addMouseOutHandler(new Image_5MouseOutHandler());
		image_5.addMouseOverHandler(new Image_5MouseOverHandler());
		image_5.addClickHandler(new Image_5ClickHandler());
		tabAdresi.add(image_5, 410, 219);
		image_5.setSize("72px", "66px");

		image_6 = new Image("kapat-1.png");
		image_6.addMouseOutHandler(new Image_6MouseOutHandler());
		image_6.addMouseOverHandler(new Image_6MouseOverHandler());
		image_6.addClickHandler(new Image_6ClickHandler());
		tabAdresi.add(image_6, 488, 219);
		image_6.setSize("72px", "66px");

		FlexTable flexTable_2 = new FlexTable();
		tabAdresi.add(flexTable_2, 10, 10);
		flexTable_2.setSize("287px", "170px");

		Label label_26 = new Label("Ülke");
		flexTable_2.setWidget(0, 0, label_26);
		label_26.setStyleName("gwt-Bold");
		label_26.setSize("26px", "18px");

		cbxAdresBilgileriUlke = new ListBox();
		flexTable_2.setWidget(0, 1, cbxAdresBilgileriUlke);
		cbxAdresBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriUlke.addItem("Türkiye");
		cbxAdresBilgileriUlke.setSize("146px", "22px");

		Label label_27 = new Label("İl");
		flexTable_2.setWidget(1, 0, label_27);
		label_27.setStyleName("gwt-Bold");
		label_27.setSize("26px", "18px");

		cbxAdresBilgileriIl = new ListBox();
		flexTable_2.setWidget(1, 1, cbxAdresBilgileriIl);
		cbxAdresBilgileriIl
				.addChangeHandler(new CbxAdresBilgileriIlChangeHandler());

		cbxAdresBilgileriIl.addItem(" ");
		cbxAdresBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriIl.setSize("146px", "22px");

		Label label_28 = new Label("İlçe");
		flexTable_2.setWidget(2, 0, label_28);
		label_28.setStyleName("gwt-Bold");
		label_28.setSize("20px", "18px");

		cbxAdresBilgileriIlce = new ListBox();
		flexTable_2.setWidget(2, 1, cbxAdresBilgileriIlce);
		cbxAdresBilgileriIlce
				.addChangeHandler(new CbxAdresBilgileriIlceChangeHandler());

		cbxAdresBilgileriIlce.addItem(" ");
		cbxAdresBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriIlce.setSize("146px", "22px");

		Label label_29 = new Label("Semt");
		flexTable_2.setWidget(3, 0, label_29);
		label_29.setStyleName("gwt-Bold");
		label_29.setSize("31px", "18px");

		cbxSemt = new ListBox();
		flexTable_2.setWidget(3, 1, cbxSemt);
		cbxSemt.addChangeHandler(new CbxSemtChangeHandler());

		cbxSemt.addItem(" ");
		cbxSemt.setStyleName("gwt-ComboBox1");
		cbxSemt.setSize("146px", "22px");

		Label label_30 = new Label("Mahalle");
		flexTable_2.setWidget(4, 0, label_30);
		label_30.setStyleName("gwt-Bold");
		label_30.setSize("45px", "18px");

		cbxMahalle = new ListBox();
		flexTable_2.setWidget(4, 1, cbxMahalle);
		cbxMahalle.addItem(" ");
		cbxMahalle.setStyleName("gwt-ComboBox1");
		cbxMahalle.setSize("193px", "22px");

		Label label_31 = new Label("Sokak ve no");
		flexTable_2.setWidget(5, 0, label_31);
		label_31.setStyleName("gwt-Bold");
		label_31.setSize("109px", "18px");

		tctSokakveNo = new TextArea();
		flexTable_2.setWidget(5, 1, tctSokakveNo);
		tctSokakveNo.setStyleName("gwt-TextAreaResible");
		tctSokakveNo.setSize("187px", "50px");
		flexTable_2.getCellFormatter().setVerticalAlignment(5, 0,
				HasVerticalAlignment.ALIGN_TOP);

		AbsolutePanel absolutePanel_4 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_4, "Sınıfı", false);
		absolutePanel_4.setSize("611px", "475px");

		Button btnSinifiKaydet = new Button("Sınıfı Kaydet");
		btnSinifiKaydet.setVisible(false);
		btnSinifiKaydet.addClickHandler(new BtnSinifiKaydetClickHandler());
		btnSinifiKaydet.setStyleName("gwt-ButtonSave");
		absolutePanel_4.add(btnSinifiKaydet, 384, 61);
		btnSinifiKaydet.setSize("78px", "49px");

		Button btnKapat4 = new Button("Kapat");
		btnKapat4.setVisible(false);
		btnKapat4.addClickHandler(new BtnKapat4ClickHandler());
		btnKapat4.setText("");
		btnKapat4.setStyleName("gwt-ButonKapat");
		absolutePanel_4.add(btnKapat4, 475, 62);
		btnKapat4.setSize("78px", "49px");

		image_7 = new Image("kaydet-1.png");
		image_7.addMouseOutHandler(new Image_7MouseOutHandler());
		image_7.addMouseOverHandler(new Image_7MouseOverHandler());
		image_7.addClickHandler(new Image_7ClickHandler());
		absolutePanel_4.add(image_7, 386, 238);
		image_7.setSize("72px", "66px");

		image_8 = new Image("kapat-1.png");
		image_8.addMouseOutHandler(new Image_8MouseOutHandler());
		image_8.addMouseOverHandler(new Image_8MouseOverHandler());
		image_8.addClickHandler(new Image_8ClickHandler());
		absolutePanel_4.add(image_8, 464, 238);
		image_8.setSize("72px", "66px");

		FlexTable flexTable_4 = new FlexTable();
		absolutePanel_4.add(flexTable_4, 10, 10);
		flexTable_4.setSize("335px", "215px");

		Label label_32 = new Label("Eğitim Türü");
		flexTable_4.setWidget(0, 0, label_32);
		label_32.setStyleName("gwt-Bold");
		label_32.setSize("87px", "18px");

		cbxEgitimTuru = new ListBox();
		flexTable_4.setWidget(0, 1, cbxEgitimTuru);
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		cbxEgitimTuru.setSize("166px", "22px");

		Label label_33 = new Label("Alan");
		flexTable_4.setWidget(1, 0, label_33);
		label_33.setStyleName("gwt-Bold");
		label_33.setSize("26px", "18px");

		cbxAlan = new ListBox();
		flexTable_4.setWidget(1, 1, cbxAlan);
		cbxAlan.addItem(" ");
		cbxAlan.addItem("ALAN YOK");
		cbxAlan.setStyleName("gwt-ComboBox1");
		cbxAlan.setSize("166px", "22px");

		Label lblKursZaman = new Label("Kurs Zamanı");
		flexTable_4.setWidget(2, 0, lblKursZaman);
		lblKursZaman.setStyleName("gwt-Bold");
		lblKursZaman.setSize("110px", "18px");

		cbxKursZamani = new ListBox();
		flexTable_4.setWidget(2, 1, cbxKursZamani);
		cbxKursZamani.addChangeHandler(new CbxKursZamaniChangeHandler());
		cbxKursZamani.addItem(" ");
		cbxKursZamani.setStyleName("gwt-ComboBox1");
		cbxKursZamani.setSize("166px", "22px");

		Label lblSnf = new Label("Sınıf");
		flexTable_4.setWidget(3, 0, lblSnf);
		lblSnf.setStyleName("gwt-Bold");
		lblSnf.setSize("67px", "18px");

		cbxSinif = new ListBox();
		flexTable_4.setWidget(3, 1, cbxSinif);
		cbxSinif.addItem(" ");
		cbxSinif.setStyleName("gwt-ComboBox1");
		cbxSinif.setSize("166px", "22px");

		Label lblrenciNumaras = new Label("Öğrenci Numarası");
		flexTable_4.setWidget(4, 0, lblrenciNumaras);
		lblrenciNumaras.setStyleName("gwt-Bold");
		lblrenciNumaras.setSize("124px", "18px");

		tctOgrenciNumarasi = new TextBox();
		tctOgrenciNumarasi
				.addKeyPressHandler(new TctOgrenciNumarasiKeyPressHandler());
		flexTable_4.setWidget(4, 1, tctOgrenciNumarasi);
		tctOgrenciNumarasi.setStyleName("gwt-TextBox1");
		tctOgrenciNumarasi.setSize("164px", "14px");

		Label lblKursIndirimFiyat = new Label("Kurs / İndirim Fiyatı");
		flexTable_4.setWidget(5, 0, lblKursIndirimFiyat);
		lblKursIndirimFiyat.setStyleName("gwt-Bold");
		lblKursIndirimFiyat.setSize("146px", "18px");

		tctKursIndirimFiyati = new TextBox();
		flexTable_4.setWidget(5, 1, tctKursIndirimFiyati);
		tctKursIndirimFiyati.setStyleName("gwt-TextBox1");
		tctKursIndirimFiyati.setSize("164px", "14px");

		Label lblInidirmTr = new Label("İnidirm Türü");
		flexTable_4.setWidget(6, 0, lblInidirmTr);
		lblInidirmTr.setStyleName("gwt-Bold");

		cbxIndirimTuru = new ListBox();
		flexTable_4.setWidget(6, 1, cbxIndirimTuru);
		cbxIndirimTuru.addChangeHandler(new CbxIndirimTuruChangeHandler());
		cbxIndirimTuru.addItem("İndirim Yok ");
		cbxIndirimTuru.addItem("Pazarlık");
		cbxIndirimTuru.setStyleName("gwt-ComboBox1");
		cbxIndirimTuru.setSize("166px", "22px");

		Label lblIndirimMiktar = new Label("İndirim Miktarı");
		flexTable_4.setWidget(7, 0, lblIndirimMiktar);
		lblIndirimMiktar.setStyleName("gwt-Bold");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		flexTable_4.setWidget(7, 1, horizontalPanel_2);
		horizontalPanel_2.setSize("176px", "12px");

		tctIndirimMiktari = new TextBox();
		tctIndirimMiktari
				.addKeyPressHandler(new TctIndirimMiktariKeyPressHandler());
		horizontalPanel_2.add(tctIndirimMiktari);
		horizontalPanel_2.setCellWidth(tctIndirimMiktari, "93");
		tctIndirimMiktari.setStyleName("gwt-TextBox1");
		tctIndirimMiktari.setSize("85px", "17px");

		cbxIndirimSekli = new ListBox();
		horizontalPanel_2.add(cbxIndirimSekli);
		cbxIndirimSekli.setStyleName("gwt-ComboBox1");
		cbxIndirimSekli.addItem("Para");
		cbxIndirimSekli.setSize("73px", "22px");

		Label lblReferans = new Label("Referans");
		flexTable_4.setWidget(8, 0, lblReferans);
		lblReferans.setStyleName("gwt-Bold");

		cbxReferans = new ListBox();
		flexTable_4.setWidget(8, 1, cbxReferans);
		cbxReferans.addItem(" ");
		cbxReferans.setStyleName("gwt-ComboBox1");
		cbxReferans.setSize("166px", "22px");

		AbsolutePanel absolutePanel_5 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_5, "DBS Sonuç", false);
		absolutePanel_5.setSize("718px", "475px");

		AbsolutePanel absolutePanel_6 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_6, "Velileri", false);
		absolutePanel_6.setSize("805px", "475px");

		grdVeliEkle = new CellTable<XMLVeliler>();
		absolutePanel_6.add(grdVeliEkle, 10, 59);
		grdVeliEkle.setSize("715px", "174px");

		TextColumn<XMLVeliler> textColumn_9 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.veli_bilgileri_tc_kimlik_no.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_9, "T.C Kimlik No");
		grdVeliEkle.setColumnWidth(textColumn_9, "105px");

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
			@Override
			public String getValue(XMLVeliler object) {
				return object.yakinlik_durumu.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_2, "Yakınlık Durumu");

		Column<XMLVeliler, Boolean> column_4 = new Column<XMLVeliler, Boolean>(
				new CheckboxCell()) {
			@Override
			public Boolean getValue(XMLVeliler object) {
				return object.odeme_sorumlusu.equalsIgnoreCase("t") ? true
						: false;
			}
		};
		grdVeliEkle.addColumn(column_4, "Ödeme Sorumlusu");

		TextColumn<XMLVeliler> textColumn_11 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.cep_tel.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_11, "Cep Tel");

		TextColumn<XMLVeliler> textColumn_12 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.is_tel.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_12, "İş Tel");

		column = new Column<XMLVeliler, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column, "Düzenle");
		grdVeliEkle.setColumnWidth(column, "70px");

		column_1 = new Column<XMLVeliler, String>(new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column_1, "Sil");

		Button btnVeliEkle = new Button("Veli Ekle");
		btnVeliEkle.setStyleName("gwt-BilgileriniGetir");
		btnVeliEkle.addClickHandler(new BtnVeliEkleClickHandler());
		absolutePanel_6.add(btnVeliEkle, 10, 10);
		btnVeliEkle.setSize("76px", "32px");

		AbsolutePanel absolutePanel_7 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_7, "Hizmetleri", false);
		absolutePanel_7.setSize("765px", "475px");

		grdHizmetler = new CellTable<XMLHizmetTanimla>();
		absolutePanel_7.add(grdHizmetler, 10, 183);
		grdHizmetler.setSize("725px", "114px");

		TextColumn<XMLHizmetTanimla> textColumn_3 = new TextColumn<XMLHizmetTanimla>() {
			public String getValue(XMLHizmetTanimla object) {
				return (object.hizmet_adi);
			}
		};
		grdHizmetler.addColumn(textColumn_3, "Hizmet Adı");

		TextColumn<XMLHizmetTanimla> textColumn_4 = new TextColumn<XMLHizmetTanimla>() {
			public String getValue(XMLHizmetTanimla object) {
				return (object.birim_fiyati);
			}
		};
		grdHizmetler.addColumn(textColumn_4, "Birim Fiyatı");

		TextColumn<XMLHizmetTanimla> textColumn_5 = new TextColumn<XMLHizmetTanimla>() {
			public String getValue(XMLHizmetTanimla object) {
				return "";
			}
		};
		grdHizmetler.addColumn(textColumn_5, "Miktar");

		TextColumn<XMLHizmetTanimla> textColumn_6 = new TextColumn<XMLHizmetTanimla>() {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return object.toString();
			}
		};
		grdHizmetler.addColumn(textColumn_6, "İnidirim Şekli");

		TextColumn<XMLHizmetTanimla> textColumn_7 = new TextColumn<XMLHizmetTanimla>() {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return object.toString();
			}
		};
		grdHizmetler.addColumn(textColumn_7, "İnidirm Miktarı");

		TextColumn<XMLHizmetTanimla> textColumn_8 = new TextColumn<XMLHizmetTanimla>() {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return object.toString();
			}
		};
		grdHizmetler.addColumn(textColumn_8, "Toplam  Fiyat");

		Column<XMLHizmetTanimla, String> column_2 = new Column<XMLHizmetTanimla, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return (String) null;
			}
		};
		grdHizmetler.addColumn(column_2, "İşlemler");

		btnNewButton = new Button("Hizmeti Ekle");
		btnNewButton.setVisible(false);
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		btnNewButton.setStyleName("gwt-ButtonSave");
		absolutePanel_7.add(btnNewButton, 484, 10);
		btnNewButton.setSize("78px", "50px");

		btnNewButton_1 = new Button("Kapat");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setStyleName("gwt-ButonKapat");
		btnNewButton_1.addClickHandler(new BtnNewButton_1ClickHandler());
		absolutePanel_7.add(btnNewButton_1, 582, 10);
		btnNewButton_1.setSize("78px", "50px");

		image_9 = new Image("kaydet-1.png");
		image_9.addMouseOutHandler(new Image_9MouseOutHandler());
		image_9.addMouseOverHandler(new Image_9MouseOverHandler());
		image_9.addClickHandler(new Image_9ClickHandler());
		absolutePanel_7.add(image_9, 399, 94);
		image_9.setSize("72px", "66px");

		image_10 = new Image("kapat-1.png");
		image_10.addMouseOutHandler(new Image_10MouseOutHandler());
		image_10.addMouseOverHandler(new Image_10MouseOverHandler());
		image_10.addClickHandler(new Image_10ClickHandler());
		absolutePanel_7.add(image_10, 477, 94);
		image_10.setSize("72px", "66px");

		FlexTable flexTable_3 = new FlexTable();
		absolutePanel_7.add(flexTable_3, 10, 10);
		flexTable_3.setSize("100px", "100px");

		Label label_34 = new Label("Hizmet türü");
		flexTable_3.setWidget(0, 0, label_34);
		label_34.setStyleName("gwt-Bold");
		label_34.setSize("92px", "18px");

		cbxHizmetTuru = new ListBox();
		flexTable_3.setWidget(0, 1, cbxHizmetTuru);
		cbxHizmetTuru.addChangeHandler(new CbxHizmetTuruChangeHandler());
		cbxHizmetTuru.addItem("Servis");
		cbxHizmetTuru.addItem("Ders");
		cbxHizmetTuru.addItem("Diğer");
		cbxHizmetTuru.setStyleName("gwt-ComboBox1");
		cbxHizmetTuru.setSize("151px", "22px");

		Label label_35 = new Label("Hizmet Adı");
		flexTable_3.setWidget(1, 0, label_35);
		label_35.setStyleName("gwt-Bold");
		label_35.setSize("92px", "18px");

		cbxHizmetAdi = new ListBox();
		flexTable_3.setWidget(1, 1, cbxHizmetAdi);
		cbxHizmetAdi.addItem(" ");
		cbxHizmetAdi.setStyleName("gwt-ComboBox1");
		cbxHizmetAdi.setSize("151px", "22px");

		Label lblMiktar = new Label("Miktar");
		flexTable_3.setWidget(2, 0, lblMiktar);
		lblMiktar.setStyleName("gwt-Bold");

		tctMiktar = new TextBox();
		tctMiktar.addKeyPressHandler(new TctMiktarKeyPressHandler());
		flexTable_3.setWidget(2, 1, tctMiktar);
		tctMiktar.setStyleName("gwt-TextBox1");
		tctMiktar.setSize("149px", "16px");

		Label lblIndirim = new Label("İndirim");
		flexTable_3.setWidget(3, 0, lblIndirim);
		lblIndirim.setStyleName("gwt-Bold");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		flexTable_3.setWidget(3, 1, horizontalPanel_1);
		horizontalPanel_1.setSize("253px", "21px");

		cbxHizmetlerIndirimTuru = new ListBox();
		horizontalPanel_1.add(cbxHizmetlerIndirimTuru);
		horizontalPanel_1.setCellWidth(cbxHizmetlerIndirimTuru, "78");
		cbxHizmetlerIndirimTuru.setStyleName("gwt-ComboBox1");
		cbxHizmetlerIndirimTuru.addItem("Para");
		cbxHizmetlerIndirimTuru.addItem("Yüzde");
		cbxHizmetlerIndirimTuru.setSize("67px", "23px");

		tctHizmetlerIndirimMiktari = new TextBox();
		tctHizmetlerIndirimMiktari
				.addKeyPressHandler(new TctHizmetlerIndirimMiktariKeyPressHandler());
		horizontalPanel_1.add(tctHizmetlerIndirimMiktari);
		tctHizmetlerIndirimMiktari.setStyleName("gwt-TextBox1");
		tctHizmetlerIndirimMiktari.setSize("71px", "16px");

		AbsolutePanel absolutePanel_8 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_8, "Ödemeleri", false);
		absolutePanel_8.setSize("797px", "475px");

		Label lblTaksitinYapacaBanka = new Label("Taksitin Yapacağı Banka");
		lblTaksitinYapacaBanka.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitinYapacaBanka, 10, 483);
		lblTaksitinYapacaBanka.setSize("150px", "18px");

		Label lblTaksitSays = new Label("Taksit Sayısı");
		lblTaksitSays.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitSays, 10, 517);

		Label lblTaksitin = new Label("Takside Başlanacak Gün");
		lblTaksitin.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitin, 10, 546);

		tctTaksitSayisi = new TextBox();
		tctTaksitSayisi.setText("1");
		tctTaksitSayisi.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctTaksitSayisi, 177, 517);
		tctTaksitSayisi.setSize("196px", "15px");

		Button btndemePlanOlutur = new Button("Ödeme Planı Oluştur");
		btndemePlanOlutur.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_8.add(btndemePlanOlutur, 547, 188);
		btndemePlanOlutur.setSize("150px", "24px");

		Button btnSzlemeOlutur = new Button("Sözleşme Oluştur");
		btnSzlemeOlutur.addClickHandler(new BtnSzlemeOluturClickHandler());
		btnSzlemeOlutur.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_8.add(btnSzlemeOlutur, 547, 217);
		btnSzlemeOlutur.setSize("150px", "24px");

		Button btnNewButton_2 = new Button("Senetleri Oluştur");
		btnNewButton_2.addClickHandler(new BtnNewButton_2ClickHandler());
		btnNewButton_2.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_8.add(btnNewButton_2, 547, 246);
		btnNewButton_2.setSize("150px", "24px");

		Button btnNewButton_3 = new Button("Taksitleri Oluştur");
		btnNewButton_3.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_8.add(btnNewButton_3, 547, 277);
		btnNewButton_3.setSize("150px", "24px");

		cbxTaksitinYapilacagiBanka = new ListBox();
		cbxTaksitinYapilacagiBanka.setEnabled(false);
		cbxTaksitinYapilacagiBanka.addItem(" ");
		absolutePanel_8.add(cbxTaksitinYapilacagiBanka, 177, 483);
		cbxTaksitinYapilacagiBanka.setSize("198px", "22px");

		dtpTaksideBaslanacakGun = new DateBox();
		dtpTaksideBaslanacakGun.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		absolutePanel_8.add(dtpTaksideBaslanacakGun, 177, 546);
		dtpTaksideBaslanacakGun.setSize("194px", "12px");

		Button btnKaydetOdemeler = new Button("Kaydet");
		btnKaydetOdemeler.addClickHandler(new BtnKaydetOdemelerClickHandler());
		btnKaydetOdemeler.setText("Kaydet");
		btnKaydetOdemeler.setStyleName("gwt-ButtonSave");
		absolutePanel_8.add(btnKaydetOdemeler, 547, 158);
		btnKaydetOdemeler.setSize("150px", "24px");

		CellTable<Object> cellTable_1 = new CellTable<Object>();
		absolutePanel_8.add(cellTable_1, 10, 332);
		cellTable_1.setSize("797px", "133px");

		TextColumn<Object> textColumn_14 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_1.addColumn(textColumn_14, "#");
		cellTable_1.setColumnWidth(textColumn_14, "25px");

		TextColumn<Object> textColumn_15 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_1.addColumn(textColumn_15, "Ödeme Tarihi");

		TextColumn<Object> textColumn_17 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_1.addColumn(textColumn_17, "Ödeme Şekli");

		TextColumn<Object> textColumn_19 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_1.addColumn(textColumn_19, "Ödeme Sorumlusu");

		TextColumn<Object> textColumn_18 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_1.addColumn(textColumn_18, "Ekleme Tarihi");

		TextColumn<Object> textColumn_22 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_1.addColumn(textColumn_22, "Güncelleme Tarihi");

		TextColumn<Object> textColumn_21 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_1.addColumn(textColumn_21, "Ödendiği Tarih");

		TextColumn<Object> textColumn_20 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_1.addColumn(textColumn_20, "Ödeme Türü");

		Column<Object, String> column_3 = new Column<Object, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable_1.addColumn(column_3, "İşlemler");

		FlexTable flexTable_5 = new FlexTable();
		absolutePanel_8.add(flexTable_5, 10, 10);
		flexTable_5.setSize("338px", "184px");

		Label lblIndirimTutar = new Label("İndirimli Tutar");
		flexTable_5.setWidget(0, 0, lblIndirimTutar);
		lblIndirimTutar.setStyleName("gwt-Bold");

		tctIndirimliTutar = new TextBox();
		flexTable_5.setWidget(0, 1, tctIndirimliTutar);
		tctIndirimliTutar.setStyleName("gwt-TextBox1");
		tctIndirimliTutar.setSize("202px", "15px");

		Label lblHizmetlerinToplam = new Label("Hizmetlerin Toplamı");
		flexTable_5.setWidget(1, 0, lblHizmetlerinToplam);
		lblHizmetlerinToplam.setWidth("160px");
		lblHizmetlerinToplam.setStyleName("gwt-Bold");

		tctHizmetlerinToplamı = new TextBox();
		flexTable_5.setWidget(1, 1, tctHizmetlerinToplamı);
		tctHizmetlerinToplamı.setStyleName("gwt-TextBox1");
		tctHizmetlerinToplamı.setSize("202px", "15px");

		Label lblToplamTutar = new Label("Toplam Tutar");
		flexTable_5.setWidget(2, 0, lblToplamTutar);
		lblToplamTutar.setStyleName("gwt-Bold");

		tctToplamTutar = new TextBox();
		flexTable_5.setWidget(2, 1, tctToplamTutar);
		tctToplamTutar.setStyleName("gwt-TextBox1");
		tctToplamTutar.setSize("202px", "15px");

		Label lblNewLabel_2 = new Label("Peşinat Ödeme Türü");
		flexTable_5.setWidget(3, 0, lblNewLabel_2);
		lblNewLabel_2.setWidth("175px");
		lblNewLabel_2.setStyleName("gwt-Bold");

		cbxPesinatOdemeTuru = new ListBox();
		flexTable_5.setWidget(3, 1, cbxPesinatOdemeTuru);
		cbxPesinatOdemeTuru
				.addChangeHandler(new CbxPesinatOdemeTuruChangeHandler());
		cbxPesinatOdemeTuru.setStyleName("gwt-ComboBox1");
		cbxPesinatOdemeTuru.addItem("Senet");
		cbxPesinatOdemeTuru.setSize("198px", "22px");

		Label lblAklama = new Label("Açıklama");
		flexTable_5.setWidget(4, 0, lblAklama);
		lblAklama.setStyleName("gwt-Bold");
		lblAklama.setSize("72px", "18px");

		tctAciklama = new TextArea();
		flexTable_5.setWidget(4, 1, tctAciklama);
		tctAciklama.setStyleName("gwt-TextAreaResible");
		tctAciklama.setSize("247px", "38px");
		flexTable_5.getCellFormatter().setVerticalAlignment(4, 0,
				HasVerticalAlignment.ALIGN_TOP);

		Label lblPeinatnYatacaBanka = new Label("Peşinatın Yatacağı Banka");
		flexTable_5.setWidget(5, 0, lblPeinatnYatacaBanka);
		lblPeinatnYatacaBanka.setStyleName("gwt-Bold");
		lblPeinatnYatacaBanka.setSize("180px", "18px");

		cbxPesinatınYatacagiBanka = new ListBox();
		flexTable_5.setWidget(5, 1, cbxPesinatınYatacagiBanka);
		cbxPesinatınYatacagiBanka.addItem(" ");
		cbxPesinatınYatacagiBanka.setEnabled(false);
		cbxPesinatınYatacagiBanka.setStyleName("gwt-ComboBox1");
		cbxPesinatınYatacagiBanka.setSize("198px", "22px");

		Label lblPeinatMiktar = new Label("Peşinat Miktarı");
		flexTable_5.setWidget(6, 0, lblPeinatMiktar);
		lblPeinatMiktar.setStyleName("gwt-Bold");

		tctPesinatMiktari = new TextBox();
		flexTable_5.setWidget(6, 1, tctPesinatMiktari);
		tctPesinatMiktari.setStyleName("gwt-TextBox1");
		tctPesinatMiktari.setSize("196px", "15px");

		Label lblTaksitlerinToplam = new Label("Taksitlerin Toplamı");
		flexTable_5.setWidget(7, 0, lblTaksitlerinToplam);
		lblTaksitlerinToplam.setStyleName("gwt-Bold");

		tctTaksitlerinToplami = new TextBox();
		flexTable_5.setWidget(7, 1, tctTaksitlerinToplami);
		tctTaksitlerinToplami.setEnabled(false);
		tctTaksitlerinToplami.setStyleName("gwt-TextBox1");
		tctTaksitlerinToplami.setSize("196px", "15px");

		Label lblSzlemeDKalan = new Label("Sözleşme Dışı Kalan");
		flexTable_5.setWidget(8, 0, lblSzlemeDKalan);
		lblSzlemeDKalan.setStyleName("gwt-Bold");

		tctSozlesmeDisiKalan = new TextBox();
		flexTable_5.setWidget(8, 1, tctSozlesmeDisiKalan);
		tctSozlesmeDisiKalan.setEnabled(false);
		tctSozlesmeDisiKalan.setStyleName("gwt-TextBox1");
		tctSozlesmeDisiKalan.setSize("196px", "15px");

		Label lblTaksidindemeTr = new Label("Taksitin Ödeme Türü");
		flexTable_5.setWidget(9, 0, lblTaksidindemeTr);
		lblTaksidindemeTr.setStyleName("gwt-Bold");

		cbxTaksitinOdemeTuru = new ListBox();
		flexTable_5.setWidget(9, 1, cbxTaksitinOdemeTuru);
		cbxTaksitinOdemeTuru
				.addChangeHandler(new CbxTaksitinOdemeTuruChangeHandler());
		cbxTaksitinOdemeTuru.addItem("Senet");
		cbxTaksitinOdemeTuru.addItem("Kredi Kartı");
		cbxTaksitinOdemeTuru.addItem("Çek");
		cbxTaksitinOdemeTuru.addItem("Nakit");
		cbxTaksitinOdemeTuru.addItem("EFT-Havale");
		cbxTaksitinOdemeTuru.setStyleName("gwt-ComboBox1");
		cbxTaksitinOdemeTuru.setSize("198px", "22px");

		Label lblTaksitAklama = new Label("Taksit Açıklama");
		flexTable_5.setWidget(10, 0, lblTaksitAklama);
		lblTaksitAklama.setStyleName("gwt-Bold");

		tctTaksitAciklama = new TextArea();
		flexTable_5.setWidget(10, 1, tctTaksitAciklama);
		tctTaksitAciklama.setStyleName("gwt-TextAreaResible");
		tctTaksitAciklama.setSize("247px", "38px");
		flexTable_5.getCellFormatter().setVerticalAlignment(10, 0,
				HasVerticalAlignment.ALIGN_TOP);

		tctAdi = new TextBox();
		tctAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAdi, 131, 58);
		tctAdi.setSize("144px", "14px");

		tctSoyadi = new TextBox();
		tctSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSoyadi, 131, 84);
		tctSoyadi.setSize("144px", "14px");

		Label lblAd = new Label("Adı");
		lblAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblAd, 10, 60);

		Label lblSoyad = new Label("Soyadı");
		lblSoyad.setStyleName("gwt-Bold");
		absolutePanel.add(lblSoyad, 10, 85);
		lblSoyad.setSize("51px", "18px");

		Image image = new Image("fotograf.png");
		image.addClickHandler(new ImageClickHandler());
		absolutePanel.add(image, 545, 3);
		image.setSize("130px", "115px");

		Label lblTcKimlikNo = new Label("T.C Kimlik No");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblTcKimlikNo, 10, 35);
		lblTcKimlikNo.setSize("115px", "18px");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.setMaxLength(11);
		tctTCKimlikNo.setReadOnly(true);
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctTCKimlikNo, 131, 33);
		tctTCKimlikNo.setSize("144px", "14px");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_3
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_3.setStyleName("gwt-LabelMor2");
		absolutePanel.add(horizontalPanel_3, 0, 0);
		horizontalPanel_3.setSize("368px", "22px");

		Label lblrenci = new Label("Öğrenci");
		horizontalPanel_3.add(lblrenci);
		lblrenci.setWidth("100%");

		if (!isDesignTime()) {

			putIlToCbx(cbxOgrenciKimlikBilgileriIl, cbxOgrenciBilgileriIl,
					cbxAdresBilgileriIl);
			putReferansToCbx(cbxReferans);
			putKursZamaniToCbx(cbxKursZamani);

			putHizmetlerToGrid();

			putEgitimTuruToCbx(cbxEgitimTuru);
			putIndirimTuruToCbx(cbxIndirimTuru);
			putBankalarToCbx(cbxTaksitinYapilacagiBanka,
					cbxPesinatınYatacagiBanka);

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
						// showWithData(selected.ogrenci_tc_kimlik_no);

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
		}

	}

	private void putBankalarToCbx(final ListBox lbxTemp, final ListBox lbxTemp2) {

		lbxTemp.clear();
		lbxTemp.addItem("Lütfen Seçiniz");

		lbxTemp2.clear();
		lbxTemp2.addItem("Lütfen Seçiniz");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getbankaekle");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("getgelirlervegiderler " +
					// response.getText());

					List<XMLBankaEkle> xmlBankaEkle = XMLBankaEkle.XML
							.readList(response.getText());

					for (int i = 0; i < xmlBankaEkle.size(); i++) {

						lbxTemp.addItem(xmlBankaEkle.get(i).banka_adi);

						lbxTemp2.addItem(xmlBankaEkle.get(i).banka_adi);

					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putHizmetAdiToCbx(String hizmet_turu, final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "gethizmettanimla?hizmet_turu=" + hizmet_turu);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLHizmetTanimla> xmlHizmetTanimla = XMLHizmetTanimla.XML
							.readList(response.getText());

					for (int i = 0; i < xmlHizmetTanimla.size(); i++) {

						lbxTemp.addItem(xmlHizmetTanimla.get(i).hizmet_adi);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putIndirimTuruToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getindirimturu");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLIndirimTuru> xmlIndirimTuru = XMLIndirimTuru.XML
							.readList(response.getText());

					for (int i = 0; i < xmlIndirimTuru.size(); i++) {

						lbxTemp.addItem(xmlIndirimTuru.get(i).indirim_turu);
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putIndirimMiktariToCbx(String itemText,
			final TextBox lbxTextBox, String indirim_turu) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getindirimturu?indirim_turu=" + indirim_turu);

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLIndirimTuru> xmlIndirimTuru = XMLIndirimTuru.XML
							.readList(response.getText());

					for (int i = 0; i < xmlIndirimTuru.size(); i++) {

						lbxTextBox.setText((xmlIndirimTuru.get(i).indirim_miktari));
					}

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private void putVelilerToGrid(String tc_kimlik_no) {

		String urlWithParameters = Util.urlBase
				+ "getveliler?ogrenci_tc_kimlik_no=" + tc_kimlik_no;

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

					List<XMLVeliler> listXmlVeliler = XMLVeliler.XML
							.readList(response.getText());

					// Window.alert("SIZE DBSKAYIT: " + listXmlDBSKayit.);

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

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

	private void putHizmetlerToGrid() {

		String urlWithParameters = Util.urlBase + "gethizmetler?id=" + _id;

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

					List<XMLHizmetTanimla> listXmlHizmetTanimla = XMLHizmetTanimla.XML
							.readList(response.getText());

					// Window.alert("SIZE DBSKAYIT: " + listXmlDBSKayit.);

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

					// Set the total row count. This isn't strictly
					// necessary, but it affects
					// paging calculations, so its good habit to
					// keep the row count up to date.
					grdHizmetler.setRowCount(1, true);

					// Push the data into the widget.
					grdHizmetler.setRowData(0, listXmlHizmetTanimla);

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
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

	private void putKursZamaniToCbx(final ListBox lbxTemp) {

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

	private void putReferansToCbx(final ListBox lbxTemp) {

		lbxTemp.clear();
		lbxTemp.addItem("");
		// lbxTemp.addItem("1");

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				Util.urlBase + "getreferanslar");

		try {
			Request request = builder.sendRequest(null, new RequestCallback() {

				public void onError(Request request, Throwable exception) {

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLReferanslar> xmlReferanslar = XMLReferanslar.XML
							.readList(response.getText());

					for (int i = 0; i < xmlReferanslar.size(); i++) {

						lbxTemp.addItem(xmlReferanslar.get(i).referans_adi_soyadi);
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

	private class BtnNewButton_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
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

							putVelilerToGrid(tctTCKimlikNo.getText());

						}
					});

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	public void putDataFromXML(XMLOnKayit xml) {

		tctOkulNumarasi.setText(xml.okul_numarasi);
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

		// tctKursIndirimFiyati.setText(xml.sinif_bilgileri_kurs_indirim_fiyati);

		// cbxEgitimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxEgitimTuru, xml.egitim_turu));

		cbxCinsiyet.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxCinsiyet,
				xml.cinsiyet));
		cbxMedeniHali.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxMedeniHali, xml.medeni_hali));
		cbxOgrenciBilgileriUlke.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOgrenciBilgileriUlke, xml.ogrenci_bilgileri_ulke));

		cbxOgrenciBilgileriSinif.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOgrenciBilgileriSinif, xml.ogrenci_bilgileri_sinif));

		cbxAdresBilgileriUlke.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxAdresBilgileriUlke, xml.adres_bilgileri_ulke));

		cbxOgrenciKimlikBilgileriUlke.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxOgrenciBilgileriUlke,
						xml.ogrenci_kimlik_bilgileri_ulke));

		// cbxEgitimTuru.setItemText(0, xml.egitim_turu);
		// cbxAlan.setItemText(0, xml.alan);
		// cbxReferans.setItemText(0, xml.referans);
		// cbxKursZamani.setItemText(0, xml.kurs_zamani);
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

		// DateBox
		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
		dtpDogumTarihi.setValue(dtf.parse(xml.dogum_tarihi));
		dtpVerilisTarihi.setValue(dtf.parse(xml.verilis_tarihi));

		putVelilerToGrid(tctTCKimlikNo.getText());
	}

	public void putDataFromXMLOkulNumarasi(XMLOnKayit xml) {

		tctOkulNumarasi.setText(xml.okul_numarasi);
	}

	public void putDataFromXMLSinif(XMLOnKayit xml) {
		cbxReferans.setItemText(0, xml.referans);
		cbxEgitimTuru.setItemText(0, xml.egitim_turu);
		cbxAlan.setItemText(0, xml.alan);
		cbxKursZamani.setItemText(0, xml.kurs_zamani);
		cbxSinif.setItemText(0, xml.sinif);
		// cbxKursZamani.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxKursZamani, xml.kurs_zamani));
		// cbxSinif.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxSinif,
		// xml.sinif));
		tctOgrenciNumarasi.setText(xml.ogrenci_numarasi);
		tctKursIndirimFiyati.setText(xml.sinif_bilgileri_kurs_indirim_fiyati);
		cbxIndirimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxIndirimTuru, xml.indirim_turu));
		cbxIndirimSekli.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxIndirimSekli, xml.indirim_sekli));
		tctIndirimMiktari.setText(xml.indirim_miktari);

	}

	public void putDataFromXML(XMLHizmetler xml) {

		cbxHizmetTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxHizmetTuru, xml.hizmet_turu));
		cbxHizmetAdi.setItemText(0, xml.hizmet_adi);
		// cbxHizmetAdi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxHizmetAdi, xml.hizmet_adi));
		tctMiktar.setText(xml.miktar);
		cbxHizmetlerIndirimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxHizmetlerIndirimTuru, xml.hizmetler_indirim_turu));
		tctHizmetlerIndirimMiktari.setText(xml.hizmetler_indirim_miktari);

	}

	public void putDataFromXML(XMLOdemeler xml) {

		tctIndirimliTutar.setText(xml.indirimli_tutar);
		tctHizmetlerinToplamı.setText(xml.hizmetlerin_toplami);
		tctToplamTutar.setText(xml.toplam_tutar);
		tctAciklama.setText(xml.aciklama);
		tctPesinatMiktari.setText(xml.pesinat_miktari);
		tctTaksitlerinToplami.setText(xml.taksitlerin_toplami);
		tctSozlesmeDisiKalan.setText(xml.sozlesme_disi_kalan);
		tctTaksitAciklama.setText(xml.taksit_aciklama);
		tctTaksitSayisi.setText(xml.taksit_sayisi);

		cbxPesinatOdemeTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxPesinatOdemeTuru, xml.pesinat_odeme_turu));
		cbxPesinatınYatacagiBanka.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxPesinatınYatacagiBanka,
						xml.pesinatin_yatacagi_banka));
		cbxTaksitinOdemeTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxTaksitinOdemeTuru, xml.taksitin_odeme_turu));
		cbxTaksitinYapilacagiBanka.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxTaksitinYapilacagiBanka,
						xml.taksitin_yatacagi_banka));

		DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
		dtpTaksideBaslanacakGun.setValue(dtf.parse(xml.takside_baslanacak_gun));

	}

	private class BtnOgrenciyiKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putkesinkayitbilgileri?";

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

			URLValue = URLValue
					+ "&ogrenci_bilgileri_ilce="
					+ cbxOgrenciBilgileriIlce
							.getItemText(cbxOgrenciBilgileriIlce
									.getSelectedIndex());
			URLValue = URLValue + "&okul="
					+ cbxOkul.getItemText(cbxOkul.getSelectedIndex());
			URLValue = URLValue + "&okul_numarasi=" + tctOkulNumarasi.getText();
			URLValue = URLValue
					+ "&ogrenci_bilgileri_sinif="
					+ cbxOgrenciBilgileriSinif
							.getValue(cbxOgrenciBilgileriSinif
									.getSelectedIndex());
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

			URLValue = URLValue
					+ "&egitim_turu="
					+ cbxEgitimTuru.getItemText(cbxEgitimTuru
							.getSelectedIndex());
			URLValue = URLValue + "&alan="
					+ cbxAlan.getItemText(cbxAlan.getSelectedIndex());
			URLValue = URLValue
					+ "&kurs_zamani="
					+ cbxKursZamani.getItemText(cbxKursZamani
							.getSelectedIndex());
			URLValue = URLValue + "&sinif="
					+ cbxSinif.getValue(cbxSinif.getSelectedIndex());
			URLValue = URLValue + "&ogrenci_numarasi="
					+ tctOgrenciNumarasi.getText();
			URLValue = URLValue + "&sinif_bilgileri_kurs_indirim_fiyati="
					+ tctKursIndirimFiyati.getText();
			URLValue = URLValue
					+ "&indirim_turu="
					+ cbxIndirimTuru
							.getValue(cbxIndirimTuru.getSelectedIndex());
			URLValue = URLValue
					+ "&indirim_sekli="
					+ cbxIndirimSekli.getValue(cbxIndirimSekli
							.getSelectedIndex());
			URLValue = URLValue + "&indirim_miktari="
					+ tctIndirimMiktari.getText();
			URLValue = URLValue + "&referans="
					+ cbxReferans.getItemText(cbxReferans.getSelectedIndex());

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&dogum_tarihi="
					+ dtf.format(dtpDogumTarihi.getValue());

			URLValue = URLValue + "&verilis_tarihi="
					+ dtf.format(dtpVerilisTarihi.getValue());

			// Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	private class BtnKaydetOdemelerClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "putodemeler?";
			_id = -1;
			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&indirimli_tutar="
					+ tctIndirimliTutar.getText();
			URLValue = URLValue + "&hizmetlerin_toplami="
					+ tctHizmetlerinToplamı.getText();
			URLValue = URLValue + "&toplam_tutar=" + tctToplamTutar.getText();
			URLValue = URLValue
					+ "&pesinat_odeme_turu="
					+ cbxPesinatOdemeTuru.getValue(cbxPesinatOdemeTuru
							.getSelectedIndex());
			URLValue = URLValue + "&aciklama=" + tctAciklama.getText();
			URLValue = URLValue
					+ "&pesinatin_yatacagi_banka="
					+ cbxPesinatınYatacagiBanka
							.getValue(cbxPesinatınYatacagiBanka
									.getSelectedIndex());
			URLValue = URLValue + "&pesinat_miktari="
					+ tctPesinatMiktari.getText();
			URLValue = URLValue + "&taksitlerin_toplami="
					+ tctTaksitlerinToplami.getText();
			URLValue = URLValue + "&sozlesme_disi_kalan="
					+ tctSozlesmeDisiKalan.getText();
			URLValue = URLValue
					+ "&taksitin_odeme_turu="
					+ cbxTaksitinOdemeTuru.getValue(cbxTaksitinOdemeTuru
							.getSelectedIndex());
			URLValue = URLValue + "&taksit_aciklama="
					+ tctTaksitAciklama.getText();
			URLValue = URLValue
					+ "&taksitin_yatacagi_banka="
					+ cbxTaksitinYapilacagiBanka
							.getValue(cbxTaksitinYapilacagiBanka
									.getSelectedIndex());
			URLValue = URLValue + "&taksit_sayisi=" + tctTaksitSayisi.getText();

			URLValue = URLValue + "&ogrenci_numarasi="
					+ tctTCKimlikNo.getText();

			DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");

			URLValue = URLValue + "&takside_baslanacak_gun="
					+ dtf.format(dtpTaksideBaslanacakGun.getValue());

			// Window.alert("URL VALUE:  DBS: " + URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	private class BtnNewButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String URLValue = Util.urlBase + "puthizmetler?";

			URLValue = URLValue + "id=" + _id;
			URLValue = URLValue + "&hizmet_turu="
					+ cbxHizmetTuru.getValue(cbxHizmetTuru.getSelectedIndex());
			URLValue = URLValue + "&hizmet_adi="
					+ cbxHizmetAdi.getItemText(cbxHizmetAdi.getSelectedIndex());
			URLValue = URLValue + "&miktar=" + tctMiktar.getText();
			URLValue = URLValue
					+ "&hizmetler_indirim_turu="
					+ cbxHizmetlerIndirimTuru.getValue(cbxHizmetlerIndirimTuru
							.getSelectedIndex());
			URLValue = URLValue + "&hizmetler_indirim_miktari="
					+ tctHizmetlerIndirimMiktari.getText();

			URLValue = URLValue + "&ogrenci_numarasi="
					+ tctTCKimlikNo.getText();
			Window.alert(URLValue);

			new Util().sendRequest(URLValue, "", "");

		}
	}

	private class BtnSzlemeOluturClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			String pathValue = "path=C:/Program___Files/Apache___Software___Foundation/Tomcat 7.0/webapps/ICACourses/reports";

			pathValue = "path=/usr/local/apache-tomcat-7.0.22/icaruswayapps/ICACourses/reports";

			String urlWithParameters = Util.urlBase + "run_report?" + pathValue
					+ "&jrxmlfile=Sozlesme.jrxml" + "&id=" + _id;

			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
					urlWithParameters);

			Window.alert("URL TO GET VALUES: " + urlWithParameters);

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

								// List<XMLOnKayit> listXmlOnKayit =
								// XMLOnKayit.XML
								// .readList(response.getText());

								// listXmlOnKayit.add(xmlOnKayit);

								// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

								// Set the total row count. This isn't strictly
								// necessary, but it affects
								// paging calculations, so its good habit to
								// keep the row count up to date.
								// grdKesinKayit.setRowCount(1, true);

								// Push the data into the widget.
								// grdKesinKayit.setRowData(0, listXmlOnKayit);

								String url = Window.Location.getHref()
										.substring(
												0,
												Window.Location.getHref()
														.indexOf("?"));
								// Window.open(url.replace("Main.html", "")
								// + "/reports/Sozlesme.pdf", "_blank",
								// "enabled");

								Window.open(
										"http://icarusway.com/ICACourses/reports/Sozlesme.pdf",
										"_blank", "enabled");

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}

	private class BtnNewButton_2ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			String pathValue = "path=C:/Program___Files/Apache___Software___Foundation/Tomcat 7.0/webapps/ICACourses/reports";

			pathValue = "path=/usr/local/apache-tomcat-7.0.22/icaruswayapps/ICACourses/reports";

			String urlWithParameters = Util.urlBase + "run_report?" + pathValue
					+ "&jrxmlfile=Senet.jrxml" + "&id=" + _id;

			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
					urlWithParameters);

			Window.alert("URL TO GET VALUES: " + urlWithParameters);

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

								// List<XMLOnKayit> listXmlOnKayit =
								// XMLOnKayit.XML
								// .readList(response.getText());

								// listXmlOnKayit.add(xmlOnKayit);

								// lblNewLabel.setText(listXmlOnKayit.get(0).tc_kimlik_no);

								// Set the total row count. This isn't strictly
								// necessary, but it affects
								// paging calculations, so its good habit to
								// keep the row count up to date.
								// grdKesinKayit.setRowCount(1, true);

								// Push the data into the widget.
								// grdKesinKayit.setRowData(0, listXmlOnKayit);

								String url = Window.Location.getHref()
										.substring(
												0,
												Window.Location.getHref()
														.indexOf("?"));
								// Window.open(url.replace("Main.html", "")
								// + "/reports/Senet.pdf", "_blank",
								// "enabled");

								Window.open(
										"http://icarusway.com/ICACourses/reports/Senet.pdf",
										"_blank", "enabled");

							}

						});

			} catch (RequestException e) {
				// displayError("Couldn't retrieve JSON");

				// Window.alert(e.getMessage() + "ERROR");
			}

		}
	}

	private class CbxOgrenciBilgileriIlChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
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

	private class CbxOgrenciKimlikBilgileriIlChangeHandler_1 implements
			ChangeHandler {
		public void onChange(ChangeEvent event) {
			putIlceToCbx(cbxOgrenciKimlikBilgileriIl.getSelectedIndex(),
					cbxOgrenciKimlikBilgileriIlce);
		}
	}

	private class CbxAdresBilgileriIlChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putIlceToCbx(cbxAdresBilgileriIl.getSelectedIndex(),
					cbxAdresBilgileriIlce);
		}
	}

	private class CbxAdresBilgileriIlceChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putSemtToCbx(cbxAdresBilgileriIl.getItemText(cbxAdresBilgileriIl
					.getSelectedIndex()),
					cbxAdresBilgileriIlce.getItemText(cbxAdresBilgileriIlce
							.getSelectedIndex()), cbxSemt);
		}
	}

	private class CbxSemtChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putMahalleToCbx(cbxAdresBilgileriIl.getItemText(cbxAdresBilgileriIl
					.getSelectedIndex()),
					cbxAdresBilgileriIlce.getItemText(cbxAdresBilgileriIlce
							.getSelectedIndex()), cbxSemt.getItemText(cbxSemt
							.getSelectedIndex()), cbxMahalle);

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

					putVelilerToGrid(tctTCKimlikNo.getText());

				}
			});

		}
	}

	//
	// _dlgVeliler = new DlgVeliEkle(true, -1);
	// _dlgVeliler.center();
	// _dlgVeliler.setAnimationEnabled(true);
	//
	// _dlgVeliler.addCloseHandler(new CloseHandler<PopupPanel>() {
	//
	// @Override
	// public void onClose(CloseEvent<PopupPanel> event) {
	//
	// putVelilerToGrid(tctTCKimlikNo.getText());
	//
	// }
	// });
	//
	// }
	// }

	private class BtnNewButton_4ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class TabKesinKayitBilgileriSelectionHandler implements
			SelectionHandler<Integer> {
		public void onSelection(SelectionEvent<Integer> event) {

			if (event.getSelectedItem() == 4) {
				showWithDataSinif(String.valueOf(_id));
			} else if (event.getSelectedItem() == 7) {

				showWithDataOdemeler(String.valueOf(_id));
			} else if (event.getSelectedItem() == 6) {
				showWithDataHizmetler(String.valueOf(_id));

			} else if (event.getSelectedItem() == 0) {

				showWithDataOkulNumarasi(String.valueOf(_id));
			}
		}
	}

	protected void showWithDataOkulNumarasi(final String id) {

		String urlWithParameters = Util.urlBase + "getkesinkayitbilgileri?id="
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

					// Window.alert("AAABBBCCC " + response.getText());

					List<XMLOnKayit> listXmlOnKayit = XMLOnKayit.XML
							.readList(response.getText());

					putDataFromXMLOkulNumarasi(listXmlOnKayit.get(0));

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	protected void showWithDataSinif(final String id) {

		String urlWithParameters = Util.urlBase + "getkesinkayitbilgileri?id="
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

					List<XMLOnKayit> listXmlOnKayit = XMLOnKayit.XML
							.readList(response.getText());

					putDataFromXMLSinif(listXmlOnKayit.get(0));

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	protected void showWithDataOdemeler(final String id) {

		String urlWithParameters = Util.urlBase + "getodemeler?id=" + id;

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

					List<XMLOdemeler> listXmlOdemeler = XMLOdemeler.XML
							.readList(response.getText());

					putDataFromXML(listXmlOdemeler.get(0));
				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	protected void showWithDataHizmetler(final String tc_kimlik_no) {

		String urlWithParameters = Util.urlBase
				+ "gethizmetler?ogrenci_numarasi=" + tc_kimlik_no;

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

					List<XMLHizmetler> listXmlHizmetler = XMLHizmetler.XML
							.readList(response.getText());

					putDataFromXML(listXmlHizmetler.get(0));

				}

			});

		} catch (RequestException e) {
			// displayError("Couldn't retrieve JSON");

			// Window.alert(e.getMessage() + "ERROR");
		}

	}

	private class CbxEgitimTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			// Window.alert(cbxEgitimTuru.getSelectedIndex() + "");
			putEgitimTuruAlanToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxAlan);
		}
	}

	private class CbxKursZamaniChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putSinifAdiToCbx(
					cbxEgitimTuru.getItemText(cbxEgitimTuru.getSelectedIndex()),
					cbxAlan.getItemText(cbxAlan.getSelectedIndex()),
					cbxKursZamani.getItemText(cbxKursZamani.getSelectedIndex()),
					cbxSinif);

		}
	}

	private class CbxIndirimTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putIndirimMiktariToCbx(cbxIndirimTuru.getItemText(cbxIndirimTuru
					.getSelectedIndex()), tctIndirimMiktari, null);

		}
	}

	private class CbxHizmetTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {
			putHizmetAdiToCbx(
					cbxHizmetTuru.getItemText(cbxHizmetTuru.getSelectedIndex()),
					cbxHizmetAdi);
		}
	}

	private class BtnKimligiKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			btnOgrenciyiKaydet.click();

		}
	}

	private class BtnAdresiKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			btnOgrenciyiKaydet.click();

		}
	}

	private class BtnSinifiKaydetClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			btnOgrenciyiKaydet.click();

		}
	}

	private class CbxPesinatOdemeTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {

			if (cbxPesinatOdemeTuru.getSelectedIndex() == 0) {
				cbxPesinatınYatacagiBanka.setEnabled(false);

			} else if (cbxPesinatOdemeTuru.getSelectedIndex() == 1) {

				cbxPesinatınYatacagiBanka.setEnabled(true);
			} else if (cbxPesinatOdemeTuru.getSelectedIndex() == 2) {
				cbxPesinatınYatacagiBanka.setEnabled(false);
			} else if (cbxPesinatOdemeTuru.getSelectedIndex() == 3) {
				cbxPesinatınYatacagiBanka.setEnabled(false);
			} else if (cbxPesinatOdemeTuru.getSelectedIndex() == 4) {
				cbxPesinatınYatacagiBanka.setEnabled(true);
			}

		}

	}

	private class CbxTaksitinOdemeTuruChangeHandler implements ChangeHandler {
		public void onChange(ChangeEvent event) {

			if (cbxTaksitinOdemeTuru.getSelectedIndex() == 0) {
				cbxTaksitinYapilacagiBanka.setEnabled(false);

			} else if (cbxTaksitinOdemeTuru.getSelectedIndex() == 1) {

				cbxTaksitinYapilacagiBanka.setEnabled(true);
			} else if (cbxTaksitinOdemeTuru.getSelectedIndex() == 2) {
				cbxTaksitinYapilacagiBanka.setEnabled(false);
			} else if (cbxTaksitinOdemeTuru.getSelectedIndex() == 3) {
				cbxTaksitinYapilacagiBanka.setEnabled(false);
			} else if (cbxTaksitinOdemeTuru.getSelectedIndex() == 4) {
				cbxTaksitinYapilacagiBanka.setEnabled(true);
			}

		}

	}

	private class BtnKapat4ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class Image_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnOgrenciyiKaydet.click();
		}
	}

	private class Image_2ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class Image_3ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKimligiKaydet.click();
		}
	}

	private class Image_4ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class Image_5ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKimligiKaydet.click();
		}
	}

	private class Image_6ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class Image_7ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnKimligiKaydet.click();
		}
	}

	private class Image_8ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class Image_9ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			btnNewButton.click();
		}
	}

	private class Image_10ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class Image_2MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_2.setUrl("kapat-2.png");

		}
	}

	private class Image_1MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_1.setUrl("kaydet-2.png");
		}
	}

	private class Image_1MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_1.setUrl("kaydet-1.png");

		}
	}

	private class Image_2MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_2.setUrl("kapat-1.png");

		}
	}

	private class Image_4MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_4.setUrl("kapat-2.png");

		}
	}

	private class Image_3MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_3.setUrl("kaydet-2.png");

		}
	}

	private class Image_4MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_4.setUrl("kapat-1.png");

		}
	}

	private class Image_3MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_3.setUrl("kaydet-1.png");

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

	private class Image_6MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_6.setUrl("kapat-2.png");

		}
	}

	private class Image_5MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_5.setUrl("kaydet-2.png");

		}
	}

	private class Image_6MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_6.setUrl("kapat-1.png");

		}
	}

	private class Image_5MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_5.setUrl("kaydet-1.png");

		}
	}

	private class Image_8MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_8.setUrl("kapat-2.png");

		}
	}

	private class Image_7MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_7.setUrl("kaydet-2.png");

		}
	}

	private class Image_8MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_8.setUrl("kapat-1.png");

		}
	}

	private class Image_7MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_7.setUrl("kaydet-1.png");

		}
	}

	private class TctOgrenciNumarasiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctOgrenciNumarasi.getText();
			if (!input.matches("[0-9]*")) {
				tctOgrenciNumarasi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctOgrenciNumarasi.setStyleName("gwt-TextBox1");

		}
	}

	private class TctIndirimMiktariKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctIndirimMiktari.getText();
			if (!input.matches("[0-9]*")) {
				tctIndirimMiktari.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctIndirimMiktari.setStyleName("gwt-TextBox1");

		}
	}

	private class Image_9MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_9.setUrl("kaydet-2.png");

		}
	}

	private class Image_10MouseOverHandler implements MouseOverHandler {
		public void onMouseOver(MouseOverEvent event) {

			image_10.setUrl("kapat-2.png");

		}
	}

	private class Image_9MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_9.setUrl("kaydet-1.png");

		}
	}

	private class Image_10MouseOutHandler implements MouseOutHandler {
		public void onMouseOut(MouseOutEvent event) {

			image_10.setUrl("kapat-1.png");

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

	private class TctOkulNumarasiKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctOkulNumarasi.getText();
			if (!input.matches("[0-9]*")) {
				tctOkulNumarasi.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctOkulNumarasi.setStyleName("gwt-TextBox1");

		}
	}

	private class TctHizmetlerIndirimMiktariKeyPressHandler implements
			KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctHizmetlerIndirimMiktari.getText();
			if (!input.matches("[0-9]*")) {
				tctHizmetlerIndirimMiktari.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctHizmetlerIndirimMiktari.setStyleName("gwt-TextBox1");

		}
	}

	private class TctMiktarKeyPressHandler implements KeyPressHandler {
		public void onKeyPress(KeyPressEvent event) {

			String input = tctMiktar.getText();
			if (!input.matches("[0-9]*")) {
				tctMiktar.setStyleName("gwt-TextBoxError");

				return;
			}
			// do your thing

			tctMiktar.setStyleName("gwt-TextBox1");

		}
	}

	private class ImageClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			DlgWebcam dlgTemp = new DlgWebcam();
			dlgTemp.center();

		}
	}
}
