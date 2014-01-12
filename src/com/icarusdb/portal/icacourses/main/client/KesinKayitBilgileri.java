package com.icarusdb.portal.icacourses.main.client;

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
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TabPanel;
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
	private TextBox tctAciklama;
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
	public TabPanel tabKesinKayitBilgileri;
	private TextBox tctHizmetlerinToplamı;
	private TextBox tctIndirimliTutar;
	private TextBox tctToplamTutar;
	private ListBox cbxPesinatOdemeTuru;
	private ListBox cbxPesinatınYatacagiBanka;
	private TextBox tctPesinatMiktari;
	private ListBox cbxTaksitinOdemeTuru;
	private TextBox tctTaksitAciklama;
	private TextBox tctTaksitlerinToplami;
	private TextBox tctSozlesmeDisiKalan;
	private ListBox cbxTaksitinYapilacagiBanka;
	private DateBox dtpTaksideBaslanacakGun;
	private TextBox tctTaksitSayisi;
	private TextBox tctIndirimMiktari;
	private TextArea tctSokakveNo;
	private Button btnOgrenciyiKaydet;
	private Button btnKimligiKaydet;

	public KesinKayitBilgileri(boolean isInsert, long id) {
		setGlassEnabled(true);

		_isInsert = isInsert;
		_id = id;
		setHTML("Kesin Kayıt İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("822px", "828px");

		Label lblNewLabel = new Label("Öğrenci");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("437px", "28px");

		tabKesinKayitBilgileri = new TabPanel();
		tabKesinKayitBilgileri.setAnimationEnabled(true);
		tabKesinKayitBilgileri
				.addSelectionHandler(new TabKesinKayitBilgileriSelectionHandler());
		absolutePanel.add(tabKesinKayitBilgileri, 10, 121);
		tabKesinKayitBilgileri.setSize("809px", "715px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabKesinKayitBilgileri.add(absolutePanel_1, "Kişisel Bilgileri", false);
		absolutePanel_1.setSize("713px", "467px");

		cbxOgrenciBilgileriUlke = new ListBox();
		cbxOgrenciBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriUlke.addItem("Türkiye");
		absolutePanel_1.add(cbxOgrenciBilgileriUlke, 157, 216);
		cbxOgrenciBilgileriUlke.setSize("128px", "22px");

		cbxOgrenciBilgileriIl = new ListBox();
		cbxOgrenciBilgileriIl.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIl
				.addChangeHandler(new CbxOgrenciBilgileriIlChangeHandler());
		cbxOgrenciBilgileriIl.addItem(" ");
		absolutePanel_1.add(cbxOgrenciBilgileriIl, 157, 253);
		cbxOgrenciBilgileriIl.setSize("163px", "22px");

		Label lblOkulBilgisi = new Label("OKUL BİLGİSİ");
		lblOkulBilgisi.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblOkulBilgisi, 10, 181);
		lblOkulBilgisi.setSize("105px", "18px");

		Label lbllke = new Label("Ülke");
		lbllke.setStyleName("gwt-Bold");
		absolutePanel_1.add(lbllke, 10, 216);
		lbllke.setSize("26px", "18px");

		Label label_2 = new Label("İl");
		label_2.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_2, 10, 252);
		label_2.setSize("26px", "18px");

		Label label_3 = new Label("Cinsiyet");
		label_3.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_3, 10, 14);
		label_3.setSize("68px", "18px");

		Label label_4 = new Label("Medeni Hali");
		label_4.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_4, 10, 42);
		label_4.setSize("85px", "18px");

		cbxCinsiyet = new ListBox();
		cbxCinsiyet.setStyleName("gwt-ComboBox1");
		cbxCinsiyet.addItem("Erkek");
		cbxCinsiyet.addItem("Kız");
		absolutePanel_1.add(cbxCinsiyet, 157, 10);
		cbxCinsiyet.setSize("128px", "22px");

		cbxMedeniHali = new ListBox();
		cbxMedeniHali.setStyleName("gwt-ComboBox1");
		cbxMedeniHali.addItem("Evli");
		cbxMedeniHali.addItem("Bekar");
		absolutePanel_1.add(cbxMedeniHali, 157, 42);
		cbxMedeniHali.setSize("128px", "22px");

		Label label_5 = new Label("Doğum Tarihi");
		label_5.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_5, 10, 76);
		label_5.setSize("128px", "18px");

		dtpDogumTarihi = new DateBox();
		dtpDogumTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		dtpDogumTarihi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(dtpDogumTarihi, 157, 80);
		dtpDogumTarihi.setSize("124px", "14px");

		Label label_6 = new Label("Ev / Cep Telefonu");
		label_6.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_6, 10, 114);
		label_6.setSize("115px", "18px");

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctEvTelefonu, 157, 114);
		tctEvTelefonu.setSize("126px", "14px");

		Label label_7 = new Label("E-Mail");
		label_7.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_7, 10, 157);
		label_7.setSize("68px", "18px");

		tctEmail = new TextBox();
		tctEmail.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctEmail, 157, 157);
		tctEmail.setSize("232px", "14px");

		tctCepTelefonu = new TextBox();
		tctCepTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctCepTelefonu, 301, 114);
		tctCepTelefonu.setSize("143px", "14px");

		Label label_8 = new Label("İlçe");
		label_8.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_8, 10, 288);
		label_8.setSize("20px", "18px");

		cbxOgrenciBilgileriIlce = new ListBox();
		cbxOgrenciBilgileriIlce.setStyleName("gwt-ComboBox1");
		cbxOgrenciBilgileriIlce
				.addChangeHandler(new CbxOgrenciBilgileriIlceChangeHandler());
		cbxOgrenciBilgileriIlce.addItem(" ");
		absolutePanel_1.add(cbxOgrenciBilgileriIlce, 157, 288);
		cbxOgrenciBilgileriIlce.setSize("163px", "22px");

		Label label_9 = new Label("Okul");
		label_9.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_9, 10, 327);
		label_9.setSize("27px", "18px");

		Label label_10 = new Label("Sınıf");
		label_10.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_10, 10, 365);
		label_10.setSize("26px", "18px");

		cbxOgrenciBilgileriSinif = new ListBox();
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
		absolutePanel_1.add(cbxOgrenciBilgileriSinif, 157, 361);
		cbxOgrenciBilgileriSinif.setSize("127px", "22px");

		Label lblNewLabel_1 = new Label("Okul Numarası");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblNewLabel_1, 10, 408);
		lblNewLabel_1.setSize("105px", "16px");

		tctOkulNumarasi = new TextBox();
		tctOkulNumarasi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctOkulNumarasi, 157, 408);
		tctOkulNumarasi.setSize("126px", "15px");

		cbxOkul = new ListBox();
		cbxOkul.setStyleName("gwt-ComboBox1");
		cbxOkul.addItem(" ");
		absolutePanel_1.add(cbxOkul, 157, 323);
		cbxOkul.setSize("258px", "22px");

		Button btnNewButton_4 = new Button("Kapat");
		btnNewButton_4.addClickHandler(new BtnNewButton_4ClickHandler());
		btnNewButton_4.setStyleName("gwt-ButonKapat");
		absolutePanel_1.add(btnNewButton_4, 482, 377);
		btnNewButton_4.setSize("78px", "49px");

		btnOgrenciyiKaydet = new Button("Öğrenciyi Kaydet");
		btnOgrenciyiKaydet
				.addClickHandler(new BtnOgrenciyiKaydetClickHandler());
		btnOgrenciyiKaydet.setStyleName("gwt-ButtonSave");
		absolutePanel_1.add(btnOgrenciyiKaydet, 391, 376);
		btnOgrenciyiKaydet.setSize("78px", "49px");

		absolutePanel_2 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_2, "Kimlik Bilgileri", false);
		absolutePanel_2.setSize("609px", "599px");

		Label label_11 = new Label("Cüzdan No");
		label_11.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_11, 10, 51);
		label_11.setSize("100px", "18px");

		Label label_12 = new Label("Kayıtlı Oldugu");
		label_12.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_12, 10, 88);
		label_12.setSize("115px", "18px");

		Label label_13 = new Label("Ülke");
		label_13.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_13, 10, 123);
		label_13.setSize("43px", "18px");

		Label label_14 = new Label("İl");
		label_14.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_14, 10, 158);
		label_14.setSize("6px", "18px");

		Label label_15 = new Label("İlçe");
		label_15.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_15, 10, 192);
		label_15.setSize("20px", "18px");

		Label label_16 = new Label("Mahalle / Köy");
		label_16.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_16, 10, 237);
		label_16.setSize("100px", "18px");

		Label label_17 = new Label("Cilt No");
		label_17.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_17, 10, 278);
		label_17.setSize("53px", "18px");

		Label label_18 = new Label("Aile Sıra No");
		label_18.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_18, 10, 318);
		label_18.setSize("100px", "18px");

		Label label_19 = new Label("Sıra No");
		label_19.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_19, 10, 356);
		label_19.setSize("64px", "18px");

		Label label_20 = new Label("Cüzdan Bilgileri");
		label_20.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_20, 10, 390);
		label_20.setSize("115px", "18px");

		Label label_21 = new Label("Verildiği Yer");
		label_21.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_21, 10, 428);
		label_21.setSize("90px", "18px");

		Label label_22 = new Label("Veriliş Nedeni");
		label_22.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_22, 10, 466);
		label_22.setSize("100px", "18px");

		tctCuzdanNo = new TextBox();
		tctCuzdanNo.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctCuzdanNo, 130, 47);
		tctCuzdanNo.setSize("160px", "14px");

		tctMahalleKoy = new TextBox();
		tctMahalleKoy.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctMahalleKoy, 130, 233);
		tctMahalleKoy.setSize("160px", "14px");

		tctCiltNo = new TextBox();
		tctCiltNo.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctCiltNo, 130, 274);
		tctCiltNo.setSize("160px", "14px");

		tctAileSiraNo = new TextBox();
		tctAileSiraNo.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctAileSiraNo, 130, 314);
		tctAileSiraNo.setSize("160px", "14px");

		tctSiraNo = new TextBox();
		tctSiraNo.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctSiraNo, 130, 352);
		tctSiraNo.setSize("160px", "14px");

		tctVerildigiYer = new TextBox();
		tctVerildigiYer.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctVerildigiYer, 130, 424);
		tctVerildigiYer.setSize("160px", "14px");

		tctVerilisNedeni = new TextBox();
		tctVerilisNedeni.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctVerilisNedeni, 130, 462);
		tctVerilisNedeni.setSize("160px", "14px");

		cbxOgrenciKimlikBilgileriUlke = new ListBox();
		cbxOgrenciKimlikBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxOgrenciKimlikBilgileriUlke.addItem("Türkiye");
		absolutePanel_2.add(cbxOgrenciKimlikBilgileriUlke, 130, 115);
		cbxOgrenciKimlikBilgileriUlke.setSize("162px", "22px");

		cbxOgrenciKimlikBilgileriIl = new ListBox();
		cbxOgrenciKimlikBilgileriIl
				.addChangeHandler(new CbxOgrenciKimlikBilgileriIlChangeHandler_1());

		cbxOgrenciKimlikBilgileriIl.addItem(" ");
		cbxOgrenciKimlikBilgileriIl.setStyleName("gwt-ComboBox1");
		absolutePanel_2.add(cbxOgrenciKimlikBilgileriIl, 130, 154);
		cbxOgrenciKimlikBilgileriIl.setSize("162px", "22px");

		cbxOgrenciKimlikBilgileriIlce = new ListBox();

		cbxOgrenciKimlikBilgileriIlce.addItem(" ");
		cbxOgrenciKimlikBilgileriIlce.setStyleName("gwt-ComboBox1");
		absolutePanel_2.add(cbxOgrenciKimlikBilgileriIlce, 130, 192);
		cbxOgrenciKimlikBilgileriIlce.setSize("162px", "22px");

		tctSeriNo = new TextBox();
		tctSeriNo.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctSeriNo, 130, 10);
		tctSeriNo.setSize("160px", "14px");

		Label label_23 = new Label("Seri No");
		label_23.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_23, 10, 14);
		label_23.setSize("90px", "18px");

		Label label_24 = new Label("Kayıt No");
		label_24.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_24, 10, 497);
		label_24.setSize("64px", "18px");

		tctKayitNo = new TextBox();
		tctKayitNo.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctKayitNo, 130, 497);
		tctKayitNo.setSize("158px", "14px");

		dtpVerilisTarihi = new DateBox();
		dtpVerilisTarihi.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		absolutePanel_2.add(dtpVerilisTarihi, 132, 528);
		dtpVerilisTarihi.setSize("156px", "12px");

		Label label_25 = new Label("Veriliş Tarihi");
		label_25.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_25, 10, 528);
		label_25.setSize("100px", "18px");

		btnKimligiKaydet = new Button("Kimliği Kaydet");
		btnKimligiKaydet.addClickHandler(new BtnKimligiKaydetClickHandler());
		btnKimligiKaydet.setStyleName("gwt-ButtonSave");
		absolutePanel_2.add(btnKimligiKaydet, 342, 496);
		btnKimligiKaydet.setSize("78px", "49px");

		Button btnKapat2 = new Button("Kapat");
		btnKapat2.setStyleName("gwt-ButonKapat");
		absolutePanel_2.add(btnKapat2, 433, 497);
		btnKapat2.setSize("78px", "49px");

		tabAdresi = new AbsolutePanel();
		tabAdresi.setStyleName("gwt-DialogBackGround");
		tabKesinKayitBilgileri.add(tabAdresi, "Adresi", false);
		tabAdresi.setSize("592px", "487px");

		Label label_26 = new Label("Ülke");
		label_26.setStyleName("gwt-Bold");
		tabAdresi.add(label_26, 10, 28);
		label_26.setSize("26px", "18px");

		Label label_27 = new Label("İl");
		label_27.setStyleName("gwt-Bold");
		tabAdresi.add(label_27, 10, 71);
		label_27.setSize("26px", "18px");

		Label label_28 = new Label("İlçe");
		label_28.setStyleName("gwt-Bold");
		tabAdresi.add(label_28, 10, 115);
		label_28.setSize("20px", "18px");

		Label label_29 = new Label("Semt");
		label_29.setStyleName("gwt-Bold");
		tabAdresi.add(label_29, 10, 159);
		label_29.setSize("31px", "18px");

		Label label_30 = new Label("Mahalle");
		label_30.setStyleName("gwt-Bold");
		tabAdresi.add(label_30, 10, 200);
		label_30.setSize("45px", "18px");

		Label label_31 = new Label("Sokak ve no");
		label_31.setStyleName("gwt-Bold");
		tabAdresi.add(label_31, 10, 240);
		label_31.setSize("109px", "18px");

		cbxAdresBilgileriUlke = new ListBox();
		cbxAdresBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriUlke.addItem("Türkiye");
		tabAdresi.add(cbxAdresBilgileriUlke, 125, 20);
		cbxAdresBilgileriUlke.setSize("146px", "22px");

		cbxAdresBilgileriIl = new ListBox();
		cbxAdresBilgileriIl
				.addChangeHandler(new CbxAdresBilgileriIlChangeHandler());

		cbxAdresBilgileriIl.addItem(" ");
		cbxAdresBilgileriIl.setStyleName("gwt-ComboBox1");
		tabAdresi.add(cbxAdresBilgileriIl, 125, 67);
		cbxAdresBilgileriIl.setSize("146px", "22px");

		cbxAdresBilgileriIlce = new ListBox();
		cbxAdresBilgileriIlce
				.addChangeHandler(new CbxAdresBilgileriIlceChangeHandler());

		cbxAdresBilgileriIlce.addItem(" ");
		cbxAdresBilgileriIlce.setStyleName("gwt-ComboBox1");
		tabAdresi.add(cbxAdresBilgileriIlce, 125, 111);
		cbxAdresBilgileriIlce.setSize("146px", "22px");

		cbxSemt = new ListBox();
		cbxSemt.addChangeHandler(new CbxSemtChangeHandler());

		cbxSemt.addItem(" ");
		cbxSemt.setStyleName("gwt-ComboBox1");
		tabAdresi.add(cbxSemt, 125, 155);
		cbxSemt.setSize("146px", "22px");

		cbxMahalle = new ListBox();
		cbxMahalle.addItem(" ");
		cbxMahalle.setStyleName("gwt-ComboBox1");
		tabAdresi.add(cbxMahalle, 125, 196);
		cbxMahalle.setSize("193px", "22px");

		tctSokakveNo = new TextArea();
		tctSokakveNo.setStyleName("gwt-TextAreaResible");
		tabAdresi.add(tctSokakveNo, 125, 240);
		tctSokakveNo.setSize("187px", "50px");

		Button btnAdresiKaydet = new Button("Adresi Kaydet");
		btnAdresiKaydet.addClickHandler(new BtnAdresiKaydetClickHandler());
		btnAdresiKaydet.setStyleName("gwt-ButtonSave");
		tabAdresi.add(btnAdresiKaydet, 348, 330);
		btnAdresiKaydet.setSize("78px", "49px");

		Button button_1 = new Button("Kapat");
		button_1.setStyleName("gwt-ButonKapat");
		tabAdresi.add(button_1, 439, 331);
		button_1.setSize("78px", "49px");

		AbsolutePanel absolutePanel_4 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_4, "Sınıfı", false);
		absolutePanel_4.setSize("611px", "494px");

		Label label_32 = new Label("Eğitim Türü");
		label_32.setStyleName("gwt-Bold");
		absolutePanel_4.add(label_32, 10, 29);
		label_32.setSize("87px", "18px");

		Label label_33 = new Label("Alan");
		label_33.setStyleName("gwt-Bold");
		absolutePanel_4.add(label_33, 11, 63);
		label_33.setSize("26px", "18px");

		Label lblKursZaman = new Label("Kurs Zamanı");
		lblKursZaman.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblKursZaman, 10, 94);
		lblKursZaman.setSize("110px", "18px");

		Label lblSnf = new Label("Sınıf");
		lblSnf.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblSnf, 10, 122);
		lblSnf.setSize("67px", "18px");

		cbxKursZamani = new ListBox();
		cbxKursZamani.addChangeHandler(new CbxKursZamaniChangeHandler());
		cbxKursZamani.addItem(" ");
		cbxKursZamani.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxKursZamani, 162, 94);
		cbxKursZamani.setSize("166px", "22px");

		cbxAlan = new ListBox();
		cbxAlan.addItem(" ");
		cbxAlan.addItem("ALAN YOK");
		cbxAlan.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxAlan, 162, 64);
		cbxAlan.setSize("166px", "22px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addChangeHandler(new CbxEgitimTuruChangeHandler());
		cbxEgitimTuru.addItem(" ");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxEgitimTuru, 162, 29);
		cbxEgitimTuru.setSize("166px", "22px");

		cbxSinif = new ListBox();
		cbxSinif.addItem(" ");
		cbxSinif.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxSinif, 162, 122);
		cbxSinif.setSize("166px", "22px");

		Label lblrenciNumaras = new Label("Öğrenci Numarası");
		lblrenciNumaras.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblrenciNumaras, 10, 154);
		lblrenciNumaras.setSize("124px", "18px");

		tctOgrenciNumarasi = new TextBox();
		tctOgrenciNumarasi.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(tctOgrenciNumarasi, 162, 154);
		tctOgrenciNumarasi.setSize("164px", "14px");

		Label lblKursIndirimFiyat = new Label("Kurs / İndirim Fiyatı");
		lblKursIndirimFiyat.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblKursIndirimFiyat, 10, 187);
		lblKursIndirimFiyat.setSize("146px", "18px");

		tctKursIndirimFiyati = new TextBox();
		tctKursIndirimFiyati.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(tctKursIndirimFiyati, 162, 187);
		tctKursIndirimFiyati.setSize("164px", "14px");

		Label lblInidirmTr = new Label("İnidirm Türü");
		lblInidirmTr.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblInidirmTr, 10, 223);

		cbxIndirimSekli = new ListBox();
		cbxIndirimSekli.setStyleName("gwt-ComboBox1");
		cbxIndirimSekli.addItem("Para");
		absolutePanel_4.add(cbxIndirimSekli, 162, 248);
		cbxIndirimSekli.setSize("73px", "22px");

		Label lblIndirimMiktar = new Label("İndirim Miktarı");
		lblIndirimMiktar.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblIndirimMiktar, 10, 254);

		Label lblReferans = new Label("Referans");
		lblReferans.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblReferans, 10, 282);

		cbxReferans = new ListBox();
		cbxReferans.addItem(" ");
		cbxReferans.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxReferans, 162, 276);
		cbxReferans.setSize("166px", "22px");

		cbxIndirimTuru = new ListBox();
		cbxIndirimTuru.addChangeHandler(new CbxIndirimTuruChangeHandler());
		cbxIndirimTuru.addItem("İndirim Yok ");
		cbxIndirimTuru.addItem("Pazarlık");
		cbxIndirimTuru.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxIndirimTuru, 162, 217);
		cbxIndirimTuru.setSize("166px", "22px");

		tctIndirimMiktari = new TextBox();
		tctIndirimMiktari.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(tctIndirimMiktari, 241, 249);
		tctIndirimMiktari.setSize("85px", "17px");

		Button btnSinifiKaydet = new Button("Sınıfı Kaydet");
		btnSinifiKaydet.addClickHandler(new BtnSinifiKaydetClickHandler());
		btnSinifiKaydet.setStyleName("gwt-ButtonSave");
		absolutePanel_4.add(btnSinifiKaydet, 363, 331);
		btnSinifiKaydet.setSize("78px", "49px");

		Button btnKapat4 = new Button("Kapat");
		btnKapat4.setStyleName("gwt-ButonKapat");
		absolutePanel_4.add(btnKapat4, 454, 332);
		btnKapat4.setSize("78px", "49px");

		AbsolutePanel absolutePanel_5 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_5, "DBS Sonuç", false);
		absolutePanel_5.setSize("498px", "410px");

		AbsolutePanel absolutePanel_6 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_6, "Velileri", false);
		absolutePanel_6.setSize("805px", "462px");

		grdVeliEkle = new CellTable<XMLVeliler>();
		absolutePanel_6.add(grdVeliEkle, 10, 64);
		grdVeliEkle.setSize("715px", "174px");

		TextColumn<XMLVeliler> textColumn_9 = new TextColumn<XMLVeliler>() {
			@Override
			public String getValue(XMLVeliler object) {
				return object.veli_bilgileri_tc_kimlik_no.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_9, "T.C Kimlik No");

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
				return (Boolean) null;
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

		Column<XMLVeliler, String> column = new Column<XMLVeliler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column, "Düzenle");

		Column<XMLVeliler, String> column_1 = new Column<XMLVeliler, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliler object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column_1, "Sil");

		Button btnVeliEkle = new Button("Veli Ekle");
		btnVeliEkle.setStyleName("gwt-ButonYeniKayit");
		btnVeliEkle.addClickHandler(new BtnVeliEkleClickHandler());
		absolutePanel_6.add(btnVeliEkle, 10, 21);

		AbsolutePanel absolutePanel_7 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_7, "Hizmetleri", false);
		absolutePanel_7.setSize("765px", "515px");

		Label label_34 = new Label("Hizmet türü");
		label_34.setStyleName("gwt-Bold");
		absolutePanel_7.add(label_34, 10, 23);
		label_34.setSize("92px", "18px");

		Label label_35 = new Label("Hizmet Adı");
		label_35.setStyleName("gwt-Bold");
		absolutePanel_7.add(label_35, 10, 69);
		label_35.setSize("92px", "18px");

		cbxHizmetTuru = new ListBox();
		cbxHizmetTuru.addChangeHandler(new CbxHizmetTuruChangeHandler());
		cbxHizmetTuru.addItem("Servis");
		cbxHizmetTuru.addItem("Ders");
		cbxHizmetTuru.addItem("Diğer");
		cbxHizmetTuru.setStyleName("gwt-ComboBox1");
		absolutePanel_7.add(cbxHizmetTuru, 108, 19);
		cbxHizmetTuru.setSize("151px", "22px");

		cbxHizmetAdi = new ListBox();
		cbxHizmetAdi.addItem(" ");
		cbxHizmetAdi.setStyleName("gwt-ComboBox1");
		absolutePanel_7.add(cbxHizmetAdi, 108, 65);
		cbxHizmetAdi.setSize("151px", "22px");

		Label lblMiktar = new Label("Miktar");
		lblMiktar.setStyleName("gwt-Bold");
		absolutePanel_7.add(lblMiktar, 10, 107);

		Label lblIndirim = new Label("İndirim");
		lblIndirim.setStyleName("gwt-Bold");
		absolutePanel_7.add(lblIndirim, 10, 148);

		cbxHizmetlerIndirimTuru = new ListBox();
		cbxHizmetlerIndirimTuru.setStyleName("gwt-ComboBox1");
		cbxHizmetlerIndirimTuru.addItem("Para");
		cbxHizmetlerIndirimTuru.addItem("Yüzde");
		absolutePanel_7.add(cbxHizmetlerIndirimTuru, 108, 142);
		cbxHizmetlerIndirimTuru.setSize("67px", "23px");

		tctHizmetlerIndirimMiktari = new TextBox();
		tctHizmetlerIndirimMiktari.setStyleName("gwt-TextBox1");
		absolutePanel_7.add(tctHizmetlerIndirimMiktari, 185, 144);
		tctHizmetlerIndirimMiktari.setSize("149px", "16px");

		tctMiktar = new TextBox();
		tctMiktar.setStyleName("gwt-TextBox1");
		absolutePanel_7.add(tctMiktar, 108, 103);
		tctMiktar.setSize("149px", "16px");

		grdHizmetler = new CellTable<XMLHizmetTanimla>();
		absolutePanel_7.add(grdHizmetler, 10, 199);
		grdHizmetler.setSize("725px", "201px");

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
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		btnNewButton.setStyleName("gwt-ButtonSave");
		absolutePanel_7.add(btnNewButton, 492, 117);
		btnNewButton.setSize("78px", "50px");

		btnNewButton_1 = new Button("Kapat");
		btnNewButton_1.setStyleName("gwt-ButonKapat");
		btnNewButton_1.addClickHandler(new BtnNewButton_1ClickHandler());
		absolutePanel_7.add(btnNewButton_1, 590, 117);
		btnNewButton_1.setSize("78px", "50px");

		AbsolutePanel absolutePanel_8 = new AbsolutePanel();
		tabKesinKayitBilgileri.add(absolutePanel_8, "Ödemeleri", false);
		absolutePanel_8.setSize("797px", "675px");

		Label lblIndirimTutar = new Label("İndirimli Tutar");
		lblIndirimTutar.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblIndirimTutar, 10, 22);

		Label lblHizmetlerinToplam = new Label("Hizmetlerin Toplamı");
		lblHizmetlerinToplam.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblHizmetlerinToplam, 10, 59);

		Label lblToplamTutar = new Label("Toplam Tutar");
		lblToplamTutar.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblToplamTutar, 10, 88);

		Label lblNewLabel_2 = new Label("Peşinat Ödeme Türü");
		lblNewLabel_2.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblNewLabel_2, 10, 123);

		Label lblAklama = new Label("Açıklama");
		lblAklama.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblAklama, 10, 163);
		lblAklama.setSize("72px", "18px");

		Label lblPeinatnYatacaBanka = new Label("Peşinatın Yatacağı Banka");
		lblPeinatnYatacaBanka.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblPeinatnYatacaBanka, 10, 232);
		lblPeinatnYatacaBanka.setSize("161px", "18px");

		Label lblPeinatMiktar = new Label("Peşinat Miktarı");
		lblPeinatMiktar.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblPeinatMiktar, 10, 269);

		Label lblTaksitlerinToplam = new Label("Taksitlerin Toplamı");
		lblTaksitlerinToplam.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitlerinToplam, 10, 312);

		Label lblSzlemeDKalan = new Label("Sözleşme Dışı Kalan");
		lblSzlemeDKalan.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblSzlemeDKalan, 10, 351);

		Label lblTaksidindemeTr = new Label("Taksitin Ödeme Türü");
		lblTaksidindemeTr.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksidindemeTr, 10, 387);

		Label lblTaksitAklama = new Label("Taksit Açıklama");
		lblTaksitAklama.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitAklama, 10, 418);

		Label lblTaksitinYapacaBanka = new Label("Taksitin Yapacağı Banka");
		lblTaksitinYapacaBanka.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitinYapacaBanka, 10, 449);
		lblTaksitinYapacaBanka.setSize("150px", "18px");

		Label lblTaksitSays = new Label("Taksit Sayısı");
		lblTaksitSays.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitSays, 10, 483);

		Label lblTaksitin = new Label("Takside Başlanacak Gün");
		lblTaksitin.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitin, 10, 512);

		tctIndirimliTutar = new TextBox();
		tctIndirimliTutar.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctIndirimliTutar, 177, 19);
		tctIndirimliTutar.setSize("202px", "14px");

		tctHizmetlerinToplamı = new TextBox();
		tctHizmetlerinToplamı.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctHizmetlerinToplamı, 177, 56);
		tctHizmetlerinToplamı.setSize("202px", "14px");

		tctToplamTutar = new TextBox();
		tctToplamTutar.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctToplamTutar, 177, 85);
		tctToplamTutar.setSize("202px", "14px");

		tctAciklama = new TextBox();
		tctAciklama.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctAciklama, 177, 163);
		tctAciklama.setSize("202px", "39px");

		tctTaksitAciklama = new TextBox();
		tctTaksitAciklama.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctTaksitAciklama, 177, 418);
		tctTaksitAciklama.setSize("196px", "14px");

		tctTaksitlerinToplami = new TextBox();
		tctTaksitlerinToplami.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctTaksitlerinToplami, 177, 309);
		tctTaksitlerinToplami.setSize("196px", "14px");

		tctSozlesmeDisiKalan = new TextBox();
		tctSozlesmeDisiKalan.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctSozlesmeDisiKalan, 177, 348);
		tctSozlesmeDisiKalan.setSize("196px", "14px");

		tctTaksitSayisi = new TextBox();
		tctTaksitSayisi.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctTaksitSayisi, 177, 483);
		tctTaksitSayisi.setSize("196px", "14px");

		cbxPesinatOdemeTuru = new ListBox();
		cbxPesinatOdemeTuru.setStyleName("gwt-ComboBox1");
		cbxPesinatOdemeTuru.addItem("Senet");
		absolutePanel_8.add(cbxPesinatOdemeTuru, 177, 119);
		cbxPesinatOdemeTuru.setSize("97px", "22px");

		tctPesinatMiktari = new TextBox();
		tctPesinatMiktari.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(tctPesinatMiktari, 177, 266);
		tctPesinatMiktari.setSize("196px", "14px");

		cbxPesinatınYatacagiBanka = new ListBox();
		cbxPesinatınYatacagiBanka.addItem("  1");
		cbxPesinatınYatacagiBanka.setStyleName("gwt-ComboBox1");
		absolutePanel_8.add(cbxPesinatınYatacagiBanka, 177, 228);
		cbxPesinatınYatacagiBanka.setSize("204px", "22px");

		Button btndemePlanOlutur = new Button("Ödeme Planı Oluştur");
		btndemePlanOlutur.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_8.add(btndemePlanOlutur, 453, 425);
		btndemePlanOlutur.setSize("150px", "24px");

		Button btnSzlemeOlutur = new Button("Sözleşme Oluştur");
		btnSzlemeOlutur.addClickHandler(new BtnSzlemeOluturClickHandler());
		btnSzlemeOlutur.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_8.add(btnSzlemeOlutur, 453, 454);
		btnSzlemeOlutur.setSize("150px", "24px");

		Button btnNewButton_2 = new Button("Senetleri Oluştur");
		btnNewButton_2.addClickHandler(new BtnNewButton_2ClickHandler());
		btnNewButton_2.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_8.add(btnNewButton_2, 453, 483);
		btnNewButton_2.setSize("150px", "24px");

		Button btnNewButton_3 = new Button("Taksitleri Oluştur");
		btnNewButton_3.setStyleName("gwt-ButonYeniKayit");
		absolutePanel_8.add(btnNewButton_3, 453, 514);
		btnNewButton_3.setSize("150px", "24px");

		cbxTaksitinOdemeTuru = new ListBox();
		cbxTaksitinOdemeTuru.addItem("Senet");
		cbxTaksitinOdemeTuru.addItem("Kredi Kartı");
		cbxTaksitinOdemeTuru.addItem("Çek");
		cbxTaksitinOdemeTuru.addItem("Nakit");
		cbxTaksitinOdemeTuru.addItem("EFT-Havale");
		cbxTaksitinOdemeTuru.setStyleName("gwt-ComboBox1");
		absolutePanel_8.add(cbxTaksitinOdemeTuru, 177, 383);
		cbxTaksitinOdemeTuru.setSize("194px", "22px");

		cbxTaksitinYapilacagiBanka = new ListBox();
		cbxTaksitinYapilacagiBanka.addItem("1");
		absolutePanel_8.add(cbxTaksitinYapilacagiBanka, 177, 449);
		cbxTaksitinYapilacagiBanka.setSize("198px", "22px");

		dtpTaksideBaslanacakGun = new DateBox();
		dtpTaksideBaslanacakGun.setFormat(new DefaultFormat(DateTimeFormat
				.getFormat("yyyy-MM-dd")));
		absolutePanel_8.add(dtpTaksideBaslanacakGun, 177, 512);
		dtpTaksideBaslanacakGun.setSize("194px", "12px");

		Button btnKaydetOdemeler = new Button("Kaydet");
		btnKaydetOdemeler.addClickHandler(new BtnKaydetOdemelerClickHandler());
		btnKaydetOdemeler.setText("Kaydet");
		btnKaydetOdemeler.setStyleName("gwt-ButtonSave");
		absolutePanel_8.add(btnKaydetOdemeler, 453, 395);
		btnKaydetOdemeler.setSize("150px", "24px");

		CellTable<Object> cellTable_1 = new CellTable<Object>();
		absolutePanel_8.add(cellTable_1, 10, 539);
		cellTable_1.setSize("100%", "154px");

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

		Image image = new Image("images/resimyok.png");
		absolutePanel.add(image, 545, 0);
		image.setSize("130px", "115px");

		Label lblTcKimlikNo = new Label("T.C Kimlik No");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblTcKimlikNo, 10, 35);
		lblTcKimlikNo.setSize("115px", "18px");

		tctTCKimlikNo = new TextBox();
		tctTCKimlikNo.setReadOnly(true);
		tctTCKimlikNo.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctTCKimlikNo, 131, 33);
		tctTCKimlikNo.setSize("144px", "14px");

		if (!isDesignTime()) {

			putIlToCbx(cbxOgrenciKimlikBilgileriIl, cbxOgrenciBilgileriIl,
					cbxAdresBilgileriIl);
			putReferansToCbx(cbxReferans);
			putKursZamaniToCbx(cbxKursZamani);
			putVelilerToGrid();
			putHizmetlerToGrid();

			putEgitimTuruToCbx(cbxEgitimTuru);
			putIndirimTuruToCbx(cbxIndirimTuru);

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
						showWithData(selected.ogrenci_tc_kimlik_no);

					}

				}

			}, DoubleClickEvent.getType());
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

	private void putVelilerToGrid() {

		String urlWithParameters = Util.urlBase + "getveliler?id=" + _id;

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

							putVelilerToGrid();

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
	}

	public void putDataFromXMLOkulNumarasi(XMLOnKayit xml) {

		tctOgrenciNumarasi.setText(xml.okul_numarasi);
	}

	public void putDataFromXMLSinif(XMLOnKayit xml) {
		cbxReferans.setItemText(0, xml.referans);
		cbxEgitimTuru.setItemText(0, xml.egitim_turu);
		cbxAlan.setItemText(0, xml.alan);
		cbxKursZamani.setItemText(0, xml.kurs_zamani);

		// cbxKursZamani.setSelectedIndex(Util.GetLBXSelectedTextIndex(
		// cbxKursZamani, xml.kurs_zamani));
		cbxSinif.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxSinif,
				xml.sinif));
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
		cbxHizmetAdi.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxHizmetAdi, xml.hizmet_adi));
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
					+ cbxHizmetAdi.getValue(cbxHizmetAdi.getSelectedIndex());
			URLValue = URLValue + "&miktar=" + tctMiktar.getText();
			URLValue = URLValue
					+ "&hizmetler_indirim_turu="
					+ cbxHizmetlerIndirimTuru.getValue(cbxHizmetlerIndirimTuru
							.getSelectedIndex());
			URLValue = URLValue + "&hizmetler_indirim_miktari="
					+ tctHizmetlerIndirimMiktari.getText();
			// Window.alert(URLValue);

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

			_dlgVeliler = new DlgVeliEkle(true, -1);
			_dlgVeliler.center();
			_dlgVeliler.setAnimationEnabled(true);

			_dlgVeliler.addCloseHandler(new CloseHandler<PopupPanel>() {

				@Override
				public void onClose(CloseEvent<PopupPanel> event) {

					putVelilerToGrid();

				}
			});

		}
	}

	private class BtnNewButton_4ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
	}

	private class TabKesinKayitBilgileriSelectionHandler implements
			SelectionHandler<Integer> {
		public void onSelection(SelectionEvent<Integer> event) {

			if (event.getSelectedItem() == 7) {

				showWithDataOdemeler(String.valueOf(_id));

			} else if (event.getSelectedItem() == 4) {
				showWithDataSinif(String.valueOf(_id));
			} else if (event.getSelectedItem() == 6) {
				showWithDataHizmetler(String.valueOf(_id));

			}
			// } else if (event.getSelectedItem() == 1) {
			// showWithDataOkulNumarasi(String.valueOf(_id));
			// }
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

	protected void showWithDataHizmetler(final String ogrenci_tc_kimlik_no) {

		String urlWithParameters = Util.urlBase
				+ "gethizmetler?ogrenci_tc_kimlik_no=" + ogrenci_tc_kimlik_no;

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
}