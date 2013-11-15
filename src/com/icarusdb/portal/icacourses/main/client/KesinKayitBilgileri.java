package com.icarusdb.portal.icacourses.main.client;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class KesinKayitBilgileri extends DialogBox {
	private ListBox cbxMedeniHali;
	private ListBox cbxCinsiyet;
	private DateBox dtpDogumTarihi;
	private TextBox tctEvTelefonu;
	private TextBox tctCepTelefonu;
	private TextBox tctEmail;
	private DateBox dptVerilisTarihi;
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
	private TextBox tctSokakveNo;
	private ListBox cbxMahalle;
	private ListBox cbxSemt;
	private ListBox cbxAdresBilgileriIlce;
	private ListBox cnxKursZamanı;
	private ListBox cbxAlan;
	private ListBox cbxEgitimTuru;
	private ListBox cbxSinif;
	private TextBox textBox_1;
	private TextBox tctOgrenciNumarasi;
	private ListBox cbxIndirimTuru;
	private ListBox cbxReferans;
	private ListBox cbxInidirimMiktari;
	private ListBox cbxHizmetTuru;
	private ListBox cbxHizmetAdi;
	private ListBox listBox_2;
	private TextBox textBox_2;
	private TextBox tctMiktar;
	private Button btnNewButton;
	private Button btnNewButton_1;
	private CellTable<XMLHizmetTanimla> cellTable;
	private ListBox comboBox;
	private TextBox textBox_6;
	private AbsolutePanel tabKisiselBilgileri;
	private ListBox cbxOkul;
	private AbsolutePanel absolutePanel_2;
	private TextBox tctAdi;
	private TextBox tctSoyadi;
	private TextBox tctTCKimlikNo;
	private ListBox cbxOgrenciBilgileriIlce;
	private ListBox cbxOgrenciBilgileriIl;
	private ListBox cbxOgrenciBilgileriUlke;
	private ListBox cbxOgrenciBilgileriSinif;
	private TextBox tctOkulNumarası;
	private CellTable<XMLVeliEkle> grdVeliEkle;

	public KesinKayitBilgileri() {
		setGlassStyleName("");
		setHTML("Kesin Kayıt İşlemleri");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-DialogBackGround");
		setWidget(absolutePanel);
		absolutePanel.setSize("833px", "773px");

		Label lblNewLabel = new Label("Öğrenci");
		lblNewLabel.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblNewLabel, 0, 0);
		lblNewLabel.setSize("833px", "28px");

		TabPanel tabPanel = new TabPanel();
		absolutePanel.add(tabPanel, 0, 121);
		tabPanel.setSize("847px", "639px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("gwt-DialogBackGround");
		tabPanel.add(absolutePanel_1, "Kişisel Bilgileri", false);
		absolutePanel_1.setSize("713px", "467px");

		cbxOgrenciBilgileriUlke = new ListBox();
		cbxOgrenciBilgileriUlke.addItem("Türkiye");
		absolutePanel_1.add(cbxOgrenciBilgileriUlke, 157, 216);
		cbxOgrenciBilgileriUlke.setSize("128px", "22px");

		cbxOgrenciBilgileriIl = new ListBox();
		cbxOgrenciBilgileriIl
				.addChangeHandler(new CbxOgrenciBilgileriIlChangeHandler());
		cbxOgrenciBilgileriIl.addItem(" ");
		absolutePanel_1.add(cbxOgrenciBilgileriIl, 157, 253);
		cbxOgrenciBilgileriIl.setSize("128px", "22px");

		Label lblOkulBilgisi = new Label("OKUL BİLGİSİ");
		lblOkulBilgisi.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblOkulBilgisi, 10, 181);
		lblOkulBilgisi.setSize("85px", "18px");

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
		label_3.setSize("47px", "18px");

		Label label_4 = new Label("Medeni Hali");
		label_4.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_4, 10, 42);
		label_4.setSize("85px", "18px");

		cbxCinsiyet = new ListBox();
		cbxCinsiyet.addItem("Erkek");
		cbxCinsiyet.addItem("Kız");
		absolutePanel_1.add(cbxCinsiyet, 157, 10);
		cbxCinsiyet.setSize("128px", "22px");

		cbxMedeniHali = new ListBox();
		cbxMedeniHali.addItem("Evli");
		cbxMedeniHali.addItem("Bekar");
		absolutePanel_1.add(cbxMedeniHali, 157, 42);
		cbxMedeniHali.setSize("128px", "22px");

		Label label_5 = new Label("Doğum Tarihi");
		label_5.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_5, 10, 76);
		label_5.setSize("77px", "18px");

		dtpDogumTarihi = new DateBox();
		dtpDogumTarihi.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(dtpDogumTarihi, 157, 80);
		dtpDogumTarihi.setSize("124px", "14px");

		Label label_6 = new Label("Ev / Cep Telefonu");
		label_6.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_6, 10, 114);
		label_6.setSize("105px", "18px");

		tctEvTelefonu = new TextBox();
		tctEvTelefonu.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctEvTelefonu, 157, 114);
		tctEvTelefonu.setSize("126px", "14px");

		Label label_7 = new Label("E-Mail");
		label_7.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_7, 10, 157);
		label_7.setSize("37px", "18px");

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
		cbxOgrenciBilgileriIlce
				.addChangeHandler(new CbxOgrenciBilgileriIlceChangeHandler());
		cbxOgrenciBilgileriIlce.addItem(" ");
		absolutePanel_1.add(cbxOgrenciBilgileriIlce, 157, 288);
		cbxOgrenciBilgileriIlce.setSize("128px", "22px");

		Label label_9 = new Label("Okul");
		label_9.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_9, 10, 327);
		label_9.setSize("27px", "18px");

		Label label_10 = new Label("Sınıf");
		label_10.setStyleName("gwt-Bold");
		absolutePanel_1.add(label_10, 10, 365);
		label_10.setSize("26px", "18px");

		cbxOgrenciBilgileriSinif = new ListBox();
		cbxOgrenciBilgileriSinif.addItem(" ");
		absolutePanel_1.add(cbxOgrenciBilgileriSinif, 157, 361);
		cbxOgrenciBilgileriSinif.setSize("127px", "22px");

		Label lblNewLabel_1 = new Label("Okul Numarası");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblNewLabel_1, 10, 408);

		tctOkulNumarası = new TextBox();
		tctOkulNumarası.setStyleName("gwt-TextBox1");
		absolutePanel_1.add(tctOkulNumarası, 157, 408);
		tctOkulNumarası.setSize("126px", "15px");

		cbxOkul = new ListBox();
		cbxOkul.addItem(" ");
		absolutePanel_1.add(cbxOkul, 157, 323);
		cbxOkul.setSize("128px", "22px");

		Button btnNewButton_4 = new Button("Kapat");
		btnNewButton_4.setStyleName("gwt-ButonKapat");
		absolutePanel_1.add(btnNewButton_4, 482, 377);
		btnNewButton_4.setSize("78px", "49px");

		absolutePanel_2 = new AbsolutePanel();
		tabPanel.add(absolutePanel_2, "Kimlik Bilgileri", false);
		absolutePanel_2.setSize("609px", "599px");

		Label label_11 = new Label("Cüzdan No");
		label_11.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_11, 10, 51);
		label_11.setSize("64px", "18px");

		Label label_12 = new Label("Kayıtlı Oldugu");
		label_12.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_12, 10, 88);
		label_12.setSize("81px", "18px");

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
		label_16.setSize("80px", "18px");

		Label label_17 = new Label("Cilt No");
		label_17.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_17, 10, 278);
		label_17.setSize("39px", "18px");

		Label label_18 = new Label("Aile Sıra No");
		label_18.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_18, 10, 318);
		label_18.setSize("69px", "18px");

		Label label_19 = new Label("Sıra No");
		label_19.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_19, 10, 356);
		label_19.setSize("43px", "18px");

		Label label_20 = new Label("Cüzdan Bilgileri");
		label_20.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_20, 10, 390);
		label_20.setSize("90px", "18px");

		Label label_21 = new Label("Verildiği Yer");
		label_21.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_21, 10, 428);
		label_21.setSize("70px", "18px");

		Label label_22 = new Label("Veriliş Nedeni");
		label_22.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_22, 10, 466);
		label_22.setSize("80px", "18px");

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
		label_23.setSize("43px", "18px");

		Label label_24 = new Label("Kayıt No");
		label_24.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_24, 10, 501);
		label_24.setSize("50px", "18px");

		tctKayitNo = new TextBox();
		tctKayitNo.setStyleName("gwt-TextBox1");
		absolutePanel_2.add(tctKayitNo, 130, 497);
		tctKayitNo.setSize("158px", "14px");

		dptVerilisTarihi = new DateBox();
		absolutePanel_2.add(dptVerilisTarihi, 126, 525);
		dptVerilisTarihi.setSize("162px", "12px");

		Label label_25 = new Label("Veriliş Tarihi");
		label_25.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_25, 10, 525);
		label_25.setSize("72px", "18px");

		AbsolutePanel absolutePanel_4 = new AbsolutePanel();
		tabPanel.add(absolutePanel_4, "Sınıfı", false);
		absolutePanel_4.setSize("611px", "494px");

		Label label_32 = new Label("Eğitim Türü");
		label_32.setStyleName("gwt-Bold");
		absolutePanel_4.add(label_32, 10, 29);
		label_32.setSize("67px", "18px");

		Label label_33 = new Label("Alan");
		label_33.setStyleName("gwt-Bold");
		absolutePanel_4.add(label_33, 11, 63);
		label_33.setSize("26px", "18px");

		Label lblKursZaman = new Label("Kurs Zamanı");
		lblKursZaman.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblKursZaman, 10, 94);
		lblKursZaman.setSize("84px", "18px");

		Label lblSnf = new Label("Sınıf");
		lblSnf.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblSnf, 10, 122);
		lblSnf.setSize("67px", "18px");

		cnxKursZamanı = new ListBox();
		cnxKursZamanı.addItem("HAFTA SONU");
		cnxKursZamanı.addItem("HAFTA İÇİ");
		cnxKursZamanı.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cnxKursZamanı, 122, 90);
		cnxKursZamanı.setSize("151px", "18px");

		cbxAlan = new ListBox();
		cbxAlan.addItem(" ");
		cbxAlan.addItem("ALAN YOK");
		cbxAlan.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxAlan, 122, 60);
		cbxAlan.setSize("151px", "18px");

		cbxEgitimTuru = new ListBox();
		cbxEgitimTuru.addItem("YGS HAZIRLIK");
		cbxEgitimTuru.addItem("YGS/LYS HAZIRLIK");
		cbxEgitimTuru.addItem("11.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("10.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("9.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("SBS HAZIRLIK");
		cbxEgitimTuru.addItem("7.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("6.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("5.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("4.SINIF TAKVİYE");
		cbxEgitimTuru.addItem("3.SINIF TAKVİYE");
		cbxEgitimTuru.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxEgitimTuru, 122, 25);
		cbxEgitimTuru.setSize("151px", "18px");

		cbxSinif = new ListBox();
		cbxSinif.setStyleName("gwt-ComboBox1");
		cbxSinif.addItem("1");
		absolutePanel_4.add(cbxSinif, 122, 118);
		cbxSinif.setSize("151px", "18px");

		Label lblrenciNumaras = new Label("Öğrenci Numarası");
		lblrenciNumaras.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblrenciNumaras, 10, 146);

		tctOgrenciNumarasi = new TextBox();
		tctOgrenciNumarasi.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(tctOgrenciNumarasi, 122, 150);
		tctOgrenciNumarasi.setSize("143px", "14px");

		Label lblKursIndirimFiyat = new Label("Kurs İndirim Fiyatı");
		lblKursIndirimFiyat.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblKursIndirimFiyat, 10, 179);

		textBox_1 = new TextBox();
		textBox_1.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(textBox_1, 122, 183);
		textBox_1.setSize("143px", "14px");

		Label lblInidirmTr = new Label("İnidirm Türü");
		lblInidirmTr.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblInidirmTr, 10, 217);

		cbxIndirimTuru = new ListBox();
		cbxIndirimTuru.setStyleName("gwt-ComboBox1");
		cbxIndirimTuru.addItem("Para");
		absolutePanel_4.add(cbxIndirimTuru, 122, 213);
		cbxIndirimTuru.setSize("73px", "22px");

		Label lblIndirimMiktar = new Label("İndirim Miktarı");
		lblIndirimMiktar.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblIndirimMiktar, 10, 254);

		Label lblReferans = new Label("Referans");
		lblReferans.setStyleName("gwt-Bold");
		absolutePanel_4.add(lblReferans, 10, 292);

		cbxReferans = new ListBox();
		cbxReferans.addItem("LÜTFEN SEÇİNİZ");
		cbxReferans.addItem("ESKİ ÖĞRENCİMİZ");
		cbxReferans.addItem("SMS YOLUYLA");
		cbxReferans.addItem("GOOGLE");
		cbxReferans.addItem("ARKADAŞ TAVSİYESİ");
		cbxReferans.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxReferans, 122, 288);
		cbxReferans.setSize("151px", "18px");

		cbxInidirimMiktari = new ListBox();
		cbxInidirimMiktari.addItem("İndirim Yok ");
		cbxInidirimMiktari.addItem("Pazarlık");
		cbxInidirimMiktari.setStyleName("gwt-ComboBox1");
		absolutePanel_4.add(cbxInidirimMiktari, 122, 250);
		cbxInidirimMiktari.setSize("151px", "18px");

		TextBox textBox = new TextBox();
		textBox.setStyleName("gwt-TextBox1");
		absolutePanel_4.add(textBox, 201, 217);
		textBox.setSize("143px", "14px");

		tabKisiselBilgileri = new AbsolutePanel();
		tabKisiselBilgileri.setStyleName("gwt-DialogBackGround");
		tabPanel.add(tabKisiselBilgileri, "Adresi", false);
		tabKisiselBilgileri.setSize("592px", "487px");

		Label label_26 = new Label("Ülke");
		label_26.setStyleName("gwt-Bold");
		tabKisiselBilgileri.add(label_26, 10, 28);
		label_26.setSize("26px", "18px");

		Label label_27 = new Label("İl");
		label_27.setStyleName("gwt-Bold");
		tabKisiselBilgileri.add(label_27, 10, 71);
		label_27.setSize("26px", "18px");

		Label label_28 = new Label("İlçe");
		label_28.setStyleName("gwt-Bold");
		tabKisiselBilgileri.add(label_28, 10, 115);
		label_28.setSize("20px", "18px");

		Label label_29 = new Label("Semt");
		label_29.setStyleName("gwt-Bold");
		tabKisiselBilgileri.add(label_29, 10, 159);
		label_29.setSize("31px", "18px");

		Label label_30 = new Label("Mahalle");
		label_30.setStyleName("gwt-Bold");
		tabKisiselBilgileri.add(label_30, 10, 200);
		label_30.setSize("45px", "18px");

		Label label_31 = new Label("Sokak ve no");
		label_31.setStyleName("gwt-Bold");
		tabKisiselBilgileri.add(label_31, 10, 240);
		label_31.setSize("73px", "18px");

		cbxAdresBilgileriUlke = new ListBox();
		cbxAdresBilgileriUlke.setStyleName("gwt-ComboBox1");
		cbxAdresBilgileriUlke.addItem("Türkiye");
		tabKisiselBilgileri.add(cbxAdresBilgileriUlke, 125, 20);
		cbxAdresBilgileriUlke.setSize("146px", "22px");

		cbxAdresBilgileriIl = new ListBox();
		cbxAdresBilgileriIl
				.addChangeHandler(new CbxAdresBilgileriIlChangeHandler());

		cbxAdresBilgileriIl.addItem(" ");
		cbxAdresBilgileriIl.setStyleName("gwt-ComboBox1");
		tabKisiselBilgileri.add(cbxAdresBilgileriIl, 125, 67);
		cbxAdresBilgileriIl.setSize("146px", "22px");

		cbxAdresBilgileriIlce = new ListBox();
		cbxAdresBilgileriIlce
				.addChangeHandler(new CbxAdresBilgileriIlceChangeHandler());

		cbxAdresBilgileriIlce.addItem(" ");
		cbxAdresBilgileriIlce.setStyleName("gwt-ComboBox1");
		tabKisiselBilgileri.add(cbxAdresBilgileriIlce, 125, 121);
		cbxAdresBilgileriIlce.setSize("146px", "22px");

		cbxSemt = new ListBox();
		cbxSemt.addChangeHandler(new CbxSemtChangeHandler());

		cbxSemt.addItem(" ");
		cbxSemt.setStyleName("gwt-ComboBox1");
		tabKisiselBilgileri.add(cbxSemt, 125, 155);
		cbxSemt.setSize("146px", "22px");

		cbxMahalle = new ListBox();
		cbxMahalle.addItem(" ");
		cbxMahalle.setStyleName("gwt-ComboBox1");
		tabKisiselBilgileri.add(cbxMahalle, 125, 196);
		cbxMahalle.setSize("146px", "22px");

		tctSokakveNo = new TextBox();
		tctSokakveNo.setStyleName("gwt-TextBox1");
		tabKisiselBilgileri.add(tctSokakveNo, 125, 240);
		tctSokakveNo.setSize("191px", "52px");

		AbsolutePanel absolutePanel_5 = new AbsolutePanel();
		tabPanel.add(absolutePanel_5, "DBS Sonuç", false);
		absolutePanel_5.setSize("498px", "410px");

		AbsolutePanel absolutePanel_6 = new AbsolutePanel();
		tabPanel.add(absolutePanel_6, "Velileri", false);
		absolutePanel_6.setSize("825px", "462px");

		grdVeliEkle = new CellTable<XMLVeliEkle>();
		absolutePanel_6.add(grdVeliEkle, 10, 64);
		grdVeliEkle.setSize("715px", "174px");

		TextColumn<XMLVeliEkle> textColumn_9 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.veli_bilgileri_tc_kimlik_no.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_9, "T.C Kimlik No");

		TextColumn<XMLVeliEkle> textColumn = new TextColumn<XMLVeliEkle>() {
			public String getValue(XMLVeliEkle object) {
				return object.veli_bilgileri_adi.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn, "Adı");

		TextColumn<XMLVeliEkle> textColumn_1 = new TextColumn<XMLVeliEkle>() {
			public String getValue(XMLVeliEkle object) {
				return object.veli_bilgileri_soyadi.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_1, "Soyadı");

		TextColumn<XMLVeliEkle> textColumn_2 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_2, "Yakınlık Durumu");

		TextColumn<XMLVeliEkle> textColumn_10 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.odeme_sorumlusu.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_10, "Ödeme Sorumlusu");

		TextColumn<XMLVeliEkle> textColumn_11 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.cep_tel.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_11, "Cep Tel");

		TextColumn<XMLVeliEkle> textColumn_12 = new TextColumn<XMLVeliEkle>() {
			@Override
			public String getValue(XMLVeliEkle object) {
				return object.toString();
			}
		};
		grdVeliEkle.addColumn(textColumn_12, "İş Tel");

		Column<XMLVeliEkle, String> column = new Column<XMLVeliEkle, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliEkle object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column, "Düzenle");

		Column<XMLVeliEkle, String> column_1 = new Column<XMLVeliEkle, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLVeliEkle object) {
				return (String) null;
			}
		};
		grdVeliEkle.addColumn(column_1, "Sil");

		Button btnVeliEkle = new Button("Veli Ekle");
		btnVeliEkle.setStyleName("gwt-ButonYeniKayit");
		btnVeliEkle.addClickHandler(new BtnVeliEkleClickHandler());
		absolutePanel_6.add(btnVeliEkle, 10, 21);

		AbsolutePanel absolutePanel_7 = new AbsolutePanel();
		tabPanel.add(absolutePanel_7, "Hizmetleri", false);
		absolutePanel_7.setSize("765px", "515px");

		Label label_34 = new Label("Hizmet türü");
		label_34.setStyleName("gwt-Bold");
		absolutePanel_7.add(label_34, 10, 23);
		label_34.setSize("71px", "18px");

		Label label_35 = new Label("Hizmet Adı");
		label_35.setStyleName("gwt-Bold");
		absolutePanel_7.add(label_35, 10, 69);
		label_35.setSize("68px", "18px");

		cbxHizmetTuru = new ListBox();
		cbxHizmetTuru.addItem("Servis");
		cbxHizmetTuru.addItem("Ders");
		cbxHizmetTuru.addItem("Diğer");
		cbxHizmetTuru.setStyleName("gwt-ComboBox1");
		absolutePanel_7.add(cbxHizmetTuru, 108, 24);
		cbxHizmetTuru.setSize("151px", "22px");

		cbxHizmetAdi = new ListBox();
		cbxHizmetAdi.setStyleName("gwt-ComboBox1");
		cbxHizmetAdi.addItem(" ");
		absolutePanel_7.add(cbxHizmetAdi, 108, 65);
		cbxHizmetAdi.setSize("151px", "22px");

		Label lblMiktar = new Label("Miktar");
		lblMiktar.setStyleName("gwt-Bold");
		absolutePanel_7.add(lblMiktar, 10, 107);

		Label lblIndirim = new Label("İndirim");
		lblIndirim.setStyleName("gwt-Bold");
		absolutePanel_7.add(lblIndirim, 10, 148);

		listBox_2 = new ListBox();
		listBox_2.setStyleName("gwt-ComboBox1");
		listBox_2.addItem("Para");
		listBox_2.addItem("Yüzde");
		absolutePanel_7.add(listBox_2, 108, 144);
		listBox_2.setSize("67px", "22px");

		textBox_2 = new TextBox();
		textBox_2.setStyleName("gwt-TextBox1");
		absolutePanel_7.add(textBox_2, 181, 148);
		textBox_2.setSize("149px", "14px");

		tctMiktar = new TextBox();
		tctMiktar.setStyleName("gwt-TextBox1");
		absolutePanel_7.add(tctMiktar, 108, 107);
		tctMiktar.setSize("149px", "14px");

		cellTable = new CellTable<XMLHizmetTanimla>();
		absolutePanel_7.add(cellTable, 10, 199);
		cellTable.setSize("725px", "201px");

		TextColumn<XMLHizmetTanimla> textColumn_3 = new TextColumn<XMLHizmetTanimla>() {
			public String getValue(XMLHizmetTanimla object) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn_3, "Hizmet Adı");

		TextColumn<XMLHizmetTanimla> textColumn_4 = new TextColumn<XMLHizmetTanimla>() {
			public String getValue(XMLHizmetTanimla object) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn_4, "Birim Fiyatı");

		TextColumn<XMLHizmetTanimla> textColumn_5 = new TextColumn<XMLHizmetTanimla>() {
			public String getValue(XMLHizmetTanimla object) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn_5, "Miktar");

		TextColumn<XMLHizmetTanimla> textColumn_6 = new TextColumn<XMLHizmetTanimla>() {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_6, "İnidirim Şekli");

		TextColumn<XMLHizmetTanimla> textColumn_7 = new TextColumn<XMLHizmetTanimla>() {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_7, "İnidirm Miktarı");

		TextColumn<XMLHizmetTanimla> textColumn_8 = new TextColumn<XMLHizmetTanimla>() {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_8, "Toplam  Fiyat");

		Column<XMLHizmetTanimla, String> column_2 = new Column<XMLHizmetTanimla, String>(
				new ButtonCell()) {
			@Override
			public String getValue(XMLHizmetTanimla object) {
				return (String) null;
			}
		};
		cellTable.addColumn(column_2, "İşlemler");

		btnNewButton = new Button("Hizmeti Ekle");
		btnNewButton.setStyleName("gwt-ButtonSave");
		absolutePanel_7.add(btnNewButton, 492, 117);
		btnNewButton.setSize("78px", "50px");

		btnNewButton_1 = new Button("Kapat");
		btnNewButton_1.setStyleName("gwt-ButonKapat");
		btnNewButton_1.addClickHandler(new BtnNewButton_1ClickHandler());
		absolutePanel_7.add(btnNewButton_1, 590, 117);
		btnNewButton_1.setSize("78px", "50px");

		AbsolutePanel absolutePanel_8 = new AbsolutePanel();
		tabPanel.add(absolutePanel_8, "Ödemeleri", false);
		absolutePanel_8.setSize("744px", "675px");

		Label lblIndirimTutar = new Label("İndirim Tutar");
		lblIndirimTutar.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblIndirimTutar, 10, 22);

		Label lblHizmetlerinToplam = new Label("Hizmetlerin Toplamı");
		lblHizmetlerinToplam.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblHizmetlerinToplam, 10, 59);

		Label lblToplamTutar = new Label("Toplam Tutar");
		lblToplamTutar.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblToplamTutar, 10, 88);

		Label lblNewLabel_2 = new Label("PeşinatÖdeme Türü");
		lblNewLabel_2.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblNewLabel_2, 10, 127);

		Label lblAklama = new Label("Açıklama");
		lblAklama.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblAklama, 10, 166);

		Label lblPeinatnYatacaBanka = new Label("Peşinatın Yatacağı Banka");
		lblPeinatnYatacaBanka.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblPeinatnYatacaBanka, 10, 232);

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
		absolutePanel_8.add(lblTaksidindemeTr, 10, 391);

		Label lblTaksitAklama = new Label("Taksit Açıklama");
		lblTaksitAklama.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitAklama, 10, 425);

		Label lblTaksitinYapacaBanka = new Label("Taksitin Yapacağı Banka");
		lblTaksitinYapacaBanka.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitinYapacaBanka, 10, 449);

		Label lblTaksitSays = new Label("Taksit Sayısı");
		lblTaksitSays.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitSays, 6, 483);

		Label lblTaksitin = new Label("Takside Başlanacak Gün");
		lblTaksitin.setStyleName("gwt-Bold");
		absolutePanel_8.add(lblTaksitin, 10, 520);

		TextBox textBox_3 = new TextBox();
		textBox_3.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(textBox_3, 177, 19);
		textBox_3.setSize("202px", "14px");

		TextBox textBox_4 = new TextBox();
		textBox_4.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(textBox_4, 177, 56);
		textBox_4.setSize("202px", "14px");

		TextBox textBox_5 = new TextBox();
		textBox_5.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(textBox_5, 177, 85);
		textBox_5.setSize("202px", "14px");

		textBox_6 = new TextBox();
		textBox_6.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(textBox_6, 177, 163);
		textBox_6.setSize("202px", "39px");

		TextBox textBox_7 = new TextBox();
		textBox_7.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(textBox_7, 177, 425);
		textBox_7.setSize("196px", "14px");

		TextBox textBox_8 = new TextBox();
		textBox_8.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(textBox_8, 177, 309);
		textBox_8.setSize("196px", "14px");

		TextBox textBox_9 = new TextBox();
		textBox_9.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(textBox_9, 177, 348);
		textBox_9.setSize("196px", "14px");

		TextBox textBox_10 = new TextBox();
		textBox_10.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(textBox_10, 177, 483);
		textBox_10.setSize("196px", "14px");

		comboBox = new ListBox();
		comboBox.setStyleName("gwt-ComboBox1");
		comboBox.addItem("Senet");
		absolutePanel_8.add(comboBox, 177, 119);
		comboBox.setSize("97px", "22px");

		TextBox textBox_11 = new TextBox();
		textBox_11.setStyleName("gwt-TextBox1");
		absolutePanel_8.add(textBox_11, 177, 266);
		textBox_11.setSize("196px", "14px");

		ListBox comboBox_1 = new ListBox();
		comboBox_1.setStyleName("gwt-ComboBox1");
		comboBox_1.addItem(" ");
		absolutePanel_8.add(comboBox_1, 177, 228);
		comboBox_1.setSize("204px", "22px");

		Button btndemePlanOlutur = new Button("Ödeme Planı Oluştur");
		absolutePanel_8.add(btndemePlanOlutur, 453, 425);

		Button btnSzlemeOlutur = new Button("Sözleşme Oluştur");
		absolutePanel_8.add(btnSzlemeOlutur, 453, 454);
		btnSzlemeOlutur.setSize("134px", "24px");

		Button btnNewButton_2 = new Button("Senetleri Oluştur");
		absolutePanel_8.add(btnNewButton_2, 453, 483);
		btnNewButton_2.setSize("134px", "24px");

		Button btnNewButton_3 = new Button("Taksitleri Oluştur");
		absolutePanel_8.add(btnNewButton_3, 453, 514);
		btnNewButton_3.setSize("134px", "24px");

		tctAdi = new TextBox();
		tctAdi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctAdi, 104, 56);
		tctAdi.setSize("144px", "14px");

		tctSoyadi = new TextBox();
		tctSoyadi.setStyleName("gwt-TextBox1");
		absolutePanel.add(tctSoyadi, 104, 87);
		tctSoyadi.setSize("144px", "14px");

		Label lblAd = new Label("Adı");
		lblAd.setStyleName("gwt-Bold");
		absolutePanel.add(lblAd, 10, 56);

		Label lblSoyad = new Label("Soyadı");
		lblSoyad.setStyleName("gwt-Bold");
		absolutePanel.add(lblSoyad, 10, 87);
		lblSoyad.setSize("51px", "18px");

		Image image = new Image("images/resimyok.png");
		absolutePanel.add(image, 504, 38);
		image.setSize("100px", "77px");

		Label lblTcKimlikNo = new Label("T.C Kimlik No");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblTcKimlikNo, 10, 34);

		tctTCKimlikNo = new TextBox();
		absolutePanel.add(tctTCKimlikNo, 104, 34);
		tctTCKimlikNo.setSize("138px", "8px");

		if (!isDesignTime()) {

			putIlToCbx(cbxAdresBilgileriIl);
			putIlToCbx(cbxOgrenciBilgileriIl);
			putIlToCbx(cbxOgrenciKimlikBilgileriIl);

		}

	}

	private void putDataToGrid() {

		String urlWithParameters = Util.urlBase + "getveliekle";

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

					List<XMLVeliEkle> listXmlVeliEkle = XMLVeliEkle.XML
							.readList(response.getText());

					// Window.alert("SIZE DBSKAYIT: " + listXmlDBSKayit.);

					// Window.alert("gun: " + listXmlSaatGirisi.get(0).gun);

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

	private class BtnNewButton_1ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			hide();
		}
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
		cbxOgrenciBilgileriIl.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOgrenciBilgileriIl, xml.ogrenci_bilgileri_il));
		cbxOgrenciBilgileriIlce.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOgrenciBilgileriIlce, xml.ogrenci_bilgileri_ilce));
		cbxOkul.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxOkul, xml.okul));
		cbxOgrenciBilgileriSinif.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxOgrenciBilgileriSinif, xml.ogrenci_bilgileri_sinif));
		cbxEgitimTuru.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxEgitimTuru, xml.egitim_turu));
		cbxAlan.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxAlan, xml.alan));
		cbxAdresBilgileriUlke.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxAdresBilgileriIlce, xml.adres_bilgileri_ulke));
		cbxAdresBilgileriIl.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxAdresBilgileriIlce, xml.adres_bilgileri_il));
		cbxAdresBilgileriIlce.setSelectedIndex(Util.GetLBXSelectedTextIndex(
				cbxAdresBilgileriIlce, xml.adres_bilgileri_ilce));
		cbxSemt.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxSemt, xml.semt));
		cbxMahalle.setSelectedIndex(Util.GetLBXSelectedTextIndex(cbxMahalle,
				xml.mahalle));
		cbxOgrenciKimlikBilgileriUlke.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxOgrenciBilgileriUlke,
						xml.ogrenci_kimlik_bilgileri_ulke));
		cbxOgrenciKimlikBilgileriIl.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxOgrenciKimlikBilgileriIl,
						xml.ogrenci_kimlik_bilgileri_il));
		cbxOgrenciKimlikBilgileriIlce.setSelectedIndex(Util
				.GetLBXSelectedTextIndex(cbxOgrenciBilgileriIlce,
						xml.ogrenci_kimlik_bilgileri_ilce));

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
			DlgVeliEkle dlgtemp = new DlgVeliEkle();
			dlgtemp.center();

		}
	}
}
