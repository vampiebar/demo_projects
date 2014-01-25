package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DlgOgrenciKayitlari extends DialogBox {
	private Label lblTCKilmikNo;
	private Label lblAdiSoyadi;
	private Label lblDogumTarihi;
	private Label lblCinsiyeti;
	private Label lblDogumYeri;
	private Label lblEvTelefonu;
	private Label lblCepTelefonu;
	private Label lblEmail;
	private Label lblEvAdresi;
	private Label lblOkulu;
	private Label lblOkulNo;
	private Label lblEgitimTuru;
	private Label lblAlani;
	private Label lblKursZamani;
	private Label lblSinifi;
	private Label lblOgrenciNo;
	private Label lblGelmedigiGunSayisi;
	private Label lblGecKaldigiGunSayisi;
	private Label lblKullanilan;
	private Label lblKalan;
	private Label lblAracPlakaNo;
	private Label lblGuzergah;
	private Label lblSoforunCepTelefonu;
	private Label lblOdemeSorumlusuAdresi;
	private Label lblOdemeSorumlusuAdiSoyadi;
	private Label lblOdemeSorumlusuTCKimlikNo;
	private Label lblOdemeSorumlusuEmail;
	private Label lblOdemeSorumlusuEvTelefonu;
	private Label lblOdemeSorumlusuCepTelefonu;
	private Label lblVeliTCKimlikNo;
	private Label lblVeliAdiSoyadi;
	private Label lblVeliYakinligi;
	private Label lblVeliCepTelefonu;
	private Label lblVeliEvTelefonu;
	private Label lblVeliEmail;
	private Label lblOdemeSorumlusuYakinligi;
	private Label lblVeliAdresi;

	public DlgOgrenciKayitlari() {
		setGlassEnabled(true);
		setHTML("Öğrenci Kayitlari");

		VerticalPanel verticalPanel = new VerticalPanel();
		setWidget(verticalPanel);
		verticalPanel.setSize("767px", "550px");

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("100%", "100%");

		TabPanel tabPanel = new TabPanel();
		verticalPanel_1.add(tabPanel);
		tabPanel.setSize("839px", "100%");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-dlgbackgorund");
		tabPanel.add(absolutePanel, "Kişisel Bilgileri", false);
		absolutePanel.setSize("100%", "494px");

		Label lblKiiselBilgiler = new Label("Kişisel Bilgiler");
		lblKiiselBilgiler.setStyleName("gwt-LabelMor");
		absolutePanel.add(lblKiiselBilgiler, 0, 10);
		lblKiiselBilgiler.setSize("647px", "28px");

		Label lblTcKimlikNo = new Label("TC Kimlik No :");
		lblTcKimlikNo.setStyleName("gwt-Bold");
		absolutePanel.add(lblTcKimlikNo, 10, 50);
		lblTcKimlikNo.setSize("101px", "16px");

		Label lblNewLabel = new Label("Adı Soyadı :");
		lblNewLabel.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel, 10, 80);
		lblNewLabel.setSize("101px", "16px");

		Label lblNewLabel_1 = new Label("Doğum Tarihi :");
		lblNewLabel_1.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_1, 10, 110);
		lblNewLabel_1.setSize("115px", "16px");

		Label lblNewLabel_2 = new Label("Doğum Yeri :");
		lblNewLabel_2.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_2, 10, 140);
		lblNewLabel_2.setSize("101px", "16px");

		Label lblNewLabel_3 = new Label("Cinsiyeti :");
		lblNewLabel_3.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_3, 10, 170);
		lblNewLabel_3.setSize("101px", "16px");

		Label lblNewLabel_4 = new Label("Ev Telefonu :");
		lblNewLabel_4.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_4, 10, 216);
		lblNewLabel_4.setSize("101px", "18px");

		Label lblCepTelefon = new Label("Cep Telefonu :\r\n");
		lblCepTelefon.setStyleName("gwt-Bold");
		absolutePanel.add(lblCepTelefon, 10, 246);
		lblCepTelefon.setSize("101px", "18px");

		Label lblNewLabel_5 = new Label("E-Mail :");
		lblNewLabel_5.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_5, 10, 276);
		lblNewLabel_5.setSize("101px", "18px");

		Label lblEvAdres = new Label("Ev Adresi :");
		lblEvAdres.setStyleName("gwt-Bold");
		absolutePanel.add(lblEvAdres, 10, 306);
		lblEvAdres.setSize("101px", "18px");

		Label lblNewLabel_6 = new Label("Okulu :");
		lblNewLabel_6.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_6, 10, 352);
		lblNewLabel_6.setSize("65px", "18px");

		Label lblNewLabel_7 = new Label("Okul No :");
		lblNewLabel_7.setStyleName("gwt-Bold");
		absolutePanel.add(lblNewLabel_7, 10, 382);
		lblNewLabel_7.setSize("65px", "18px");

		Button vtbOgrenciBelgesi = new Button("New button");
		vtbOgrenciBelgesi.setText("Öğrenci Belgesi");
		absolutePanel.add(vtbOgrenciBelgesi, 64, 443);
		vtbOgrenciBelgesi.setSize("133px", "24px");

		Button btnGecKagidi = new Button("New button");
		btnGecKagidi.setText("Geç Kağıdı");
		absolutePanel.add(btnGecKagidi, 203, 443);
		btnGecKagidi.setSize("110px", "24px");

		Button btnIzınKagidi = new Button("New button");
		btnIzınKagidi.setText("İzin Kağıdı");
		absolutePanel.add(btnIzınKagidi, 319, 443);
		btnIzınKagidi.setSize("100px", "24px");

		Button btnOgrenciDurumBelgesi = new Button("New button");
		btnOgrenciDurumBelgesi.setText("Öğrenci Durum Belgesi");
		absolutePanel.add(btnOgrenciDurumBelgesi, 425, 443);
		btnOgrenciDurumBelgesi.setSize("158px", "24px");

		lblTCKilmikNo = new Label("");
		absolutePanel.add(lblTCKilmikNo, 131, 50);
		lblTCKilmikNo.setSize("189px", "18px");

		lblAdiSoyadi = new Label("");
		absolutePanel.add(lblAdiSoyadi, 131, 80);
		lblAdiSoyadi.setSize("189px", "18px");

		lblDogumTarihi = new Label("");
		absolutePanel.add(lblDogumTarihi, 131, 108);
		lblDogumTarihi.setSize("189px", "18px");

		lblDogumYeri = new Label("");
		absolutePanel.add(lblDogumYeri, 131, 138);
		lblDogumYeri.setSize("189px", "18px");

		lblCinsiyeti = new Label("");
		absolutePanel.add(lblCinsiyeti, 131, 168);
		lblCinsiyeti.setSize("189px", "18px");

		lblEvTelefonu = new Label("");
		absolutePanel.add(lblEvTelefonu, 131, 216);
		lblEvTelefonu.setSize("189px", "18px");

		lblCepTelefonu = new Label("");
		absolutePanel.add(lblCepTelefonu, 131, 246);
		lblCepTelefonu.setSize("189px", "18px");

		lblEmail = new Label("");
		absolutePanel.add(lblEmail, 131, 276);
		lblEmail.setSize("189px", "18px");

		lblEvAdresi = new Label("");
		absolutePanel.add(lblEvAdresi, 131, 306);
		lblEvAdresi.setSize("516px", "18px");

		lblOkulNo = new Label("");
		absolutePanel.add(lblOkulNo, 131, 382);
		lblOkulNo.setSize("189px", "18px");

		lblOkulu = new Label("");
		absolutePanel.add(lblOkulu, 131, 352);
		lblOkulu.setSize("189px", "18px");

		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		tabPanel.add(absolutePanel_1, "Sınıf Bilgileri", false);
		absolutePanel_1.setSize("100%", "452px");

		Label lblSnfBilgileri = new Label("Sınıf Bilgileri");
		lblSnfBilgileri.setStyleName("gwt-LabelMor");
		absolutePanel_1.add(lblSnfBilgileri, 10, 10);
		lblSnfBilgileri.setSize("300px", "25px");

		Label lblNewLabel_10 = new Label("Eğitim Türü :");
		lblNewLabel_10.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblNewLabel_10, 10, 50);
		lblNewLabel_10.setSize("114px", "18px");

		Label lblNewLabel_11 = new Label("Alani :");
		lblNewLabel_11.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblNewLabel_11, 10, 80);
		lblNewLabel_11.setSize("114px", "16px");

		Label lblSnf = new Label("Sınıfı :");
		lblSnf.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblSnf, 10, 140);
		lblSnf.setSize("114px", "18px");

		Label lblKursZaman = new Label("Kurs Zamani :");
		lblKursZaman.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblKursZaman, 10, 110);
		lblKursZaman.setSize("114px", "18px");

		Label lblNewLabel_12 = new Label("Öğrenci No :");
		lblNewLabel_12.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblNewLabel_12, 10, 170);
		lblNewLabel_12.setSize("114px", "16px");

		Label lblNewLabel_13 = new Label("Gelmediği gün Sayısı :");
		lblNewLabel_13.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblNewLabel_13, 10, 200);
		lblNewLabel_13.setSize("159px", "18px");

		Label lblNewLabel_14 = new Label("Geç Kaldığı Gün Sayisi :");
		lblNewLabel_14.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblNewLabel_14, 10, 230);
		lblNewLabel_14.setSize("171px", "18px");

		Label lblAldHizmetler = new Label("Aldığı Hizmetler");
		lblAldHizmetler.setStyleName("gwt-LabelMor");
		absolutePanel_1.add(lblAldHizmetler, 327, 10);
		lblAldHizmetler.setSize("300px", "25px");

		Label lblzelDers = new Label("Özel Ders :");
		lblzelDers.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblzelDers, 327, 50);
		lblzelDers.setSize("103px", "16px");

		Label lblAlnan = new Label("Alınan :");
		lblAlnan.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblAlnan, 327, 80);
		lblAlnan.setSize("63px", "18px");

		Label lblKullanlan = new Label("Kullanılan :");
		lblKullanlan.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblKullanlan, 432, 78);
		lblKullanlan.setSize("79px", "18px");

		Label lblKala = new Label("Kalan :");
		lblKala.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblKala, 543, 78);
		lblKala.setSize("57px", "18px");

		Label lblDersProgram = new Label("Ders Programı");
		lblDersProgram.setStyleName("gwt-LabelMor");
		absolutePanel_1.add(lblDersProgram, 10, 269);
		lblDersProgram.setSize("100%", "25px");

		Label lblServis = new Label("Servis :");
		lblServis.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblServis, 327, 110);
		lblServis.setSize("63px", "16px");

		Label lblGzergah = new Label("Güzergah :");
		lblGzergah.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblGzergah, 327, 140);
		lblGzergah.setSize("103px", "16px");

		Label lblCepTelefonu_1 = new Label("Cep Telefonu :");
		lblCepTelefonu_1.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblCepTelefonu_1, 327, 170);
		lblCepTelefonu_1.setSize("103px", "16px");

		Label lblNewLabel_15 = new Label("Araç Plaka No :");
		lblNewLabel_15.setStyleName("gwt-Bold");
		absolutePanel_1.add(lblNewLabel_15, 327, 200);
		lblNewLabel_15.setSize("107px", "16px");

		lblEgitimTuru = new Label("");
		absolutePanel_1.add(lblEgitimTuru, 160, 46);
		lblEgitimTuru.setSize("150px", "22px");

		lblAlani = new Label("");
		absolutePanel_1.add(lblAlani, 160, 74);
		lblAlani.setSize("150px", "22px");

		lblKursZamani = new Label("");
		absolutePanel_1.add(lblKursZamani, 160, 106);
		lblKursZamani.setSize("150px", "22px");

		lblSinifi = new Label("");
		absolutePanel_1.add(lblSinifi, 160, 136);
		lblSinifi.setSize("150px", "22px");

		lblOgrenciNo = new Label("");
		absolutePanel_1.add(lblOgrenciNo, 160, 164);
		lblOgrenciNo.setSize("150px", "22px");

		lblGelmedigiGunSayisi = new Label("");
		absolutePanel_1.add(lblGelmedigiGunSayisi, 160, 196);
		lblGelmedigiGunSayisi.setSize("150px", "22px");

		lblGecKaldigiGunSayisi = new Label("");
		absolutePanel_1.add(lblGecKaldigiGunSayisi, 160, 226);
		lblGecKaldigiGunSayisi.setSize("150px", "22px");

		Label lblAlinan = new Label("");
		absolutePanel_1.add(lblAlinan, 388, 78);
		lblAlinan.setSize("30px", "18px");

		lblKullanilan = new Label("");
		absolutePanel_1.add(lblKullanilan, 507, 78);
		lblKullanilan.setSize("30px", "18px");

		lblKalan = new Label("");
		absolutePanel_1.add(lblKalan, 594, 78);
		lblKalan.setSize("30px", "18px");

		Label label_10 = new Label("");
		absolutePanel_1.add(label_10, 404, 140);
		label_10.setSize("30px", "18px");

		lblSoforunCepTelefonu = new Label("");
		absolutePanel_1.add(lblSoforunCepTelefonu, 425, 170);
		lblSoforunCepTelefonu.setSize("202px", "18px");

		lblAracPlakaNo = new Label("");
		absolutePanel_1.add(lblAracPlakaNo, 425, 200);
		lblAracPlakaNo.setSize("202px", "18px");

		lblGuzergah = new Label("");
		absolutePanel_1.add(lblGuzergah, 425, 140);
		lblGuzergah.setSize("202px", "18px");

		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		tabPanel.add(absolutePanel_2, "Velileri", false);
		absolutePanel_2.setSize("100%", "531px");

		Label lblVeliBilgileri = new Label("Veli Bilgileri");
		lblVeliBilgileri.setStyleName("gwt-LabelMor");
		absolutePanel_2.add(lblVeliBilgileri, 0, 10);
		lblVeliBilgileri.setSize("652px", "25px");

		Label lblNewLabel_8 = new Label("Ödeme Sorumlusu");
		lblNewLabel_8.setStyleName("gwt-LabelMor");
		absolutePanel_2.add(lblNewLabel_8, 10, 52);
		lblNewLabel_8.setSize("127px", "18px");

		Label label = new Label("TC Kimlik No :");
		label.setStyleName("gwt-Bold");
		absolutePanel_2.add(label, 10, 84);
		label.setSize("115px", "16px");

		Label label_1 = new Label("Adı Soyadı :");
		label_1.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_1, 10, 114);
		label_1.setSize("115px", "16px");

		Label label_2 = new Label("Cep Telefonu :\r\n");
		label_2.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_2, 10, 174);
		label_2.setSize("115px", "18px");

		Label label_3 = new Label("Ev Telefonu :");
		label_3.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_3, 10, 204);
		label_3.setSize("115px", "18px");

		Label lblYaknl = new Label("Yakınlığı :");
		lblYaknl.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblYaknl, 10, 144);
		lblYaknl.setSize("115px", "16px");

		Label lblNewLabel_9 = new Label("E-Mail :");
		lblNewLabel_9.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblNewLabel_9, 10, 234);
		lblNewLabel_9.setSize("115px", "16px");

		Label lblVeli = new Label("Veli");
		lblVeli.setStyleName("gwt-LabelMor");
		absolutePanel_2.add(lblVeli, 10, 266);
		lblVeli.setSize("127px", "18px");

		Label label_4 = new Label("TC Kimlik No :");
		label_4.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_4, 10, 301);
		label_4.setSize("115px", "16px");

		Label label_5 = new Label("Adı Soyadı :");
		label_5.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_5, 10, 331);
		label_5.setSize("115px", "16px");

		Label label_6 = new Label("Cep Telefonu :\r\n");
		label_6.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_6, 10, 391);
		label_6.setSize("115px", "18px");

		Label label_7 = new Label("Ev Telefonu :");
		label_7.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_7, 10, 421);
		label_7.setSize("115px", "18px");

		Label label_8 = new Label("Yakınlığı :");
		label_8.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_8, 10, 361);
		label_8.setSize("115px", "16px");

		Label label_9 = new Label("E-Mail :");
		label_9.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_9, 10, 451);
		label_9.setSize("115px", "16px");

		lblOdemeSorumlusuTCKimlikNo = new Label("");
		absolutePanel_2.add(lblOdemeSorumlusuTCKimlikNo, 107, 78);
		lblOdemeSorumlusuTCKimlikNo.setSize("205px", "22px");

		Label lblAdresi = new Label("Adresi");
		lblAdresi.setStyleName("gwt-Bold");
		absolutePanel_2.add(lblAdresi, 505, 52);
		lblAdresi.setSize("81px", "18px");

		lblOdemeSorumlusuAdresi = new Label("");
		absolutePanel_2.add(lblOdemeSorumlusuAdresi, 430, 84);
		lblOdemeSorumlusuAdresi.setSize("205px", "108px");

		lblOdemeSorumlusuAdiSoyadi = new Label("");
		absolutePanel_2.add(lblOdemeSorumlusuAdiSoyadi, 107, 108);
		lblOdemeSorumlusuAdiSoyadi.setSize("205px", "22px");

		lblOdemeSorumlusuCepTelefonu = new Label("");
		absolutePanel_2.add(lblOdemeSorumlusuCepTelefonu, 107, 170);
		lblOdemeSorumlusuCepTelefonu.setSize("205px", "22px");

		lblOdemeSorumlusuYakinligi = new Label("");
		absolutePanel_2.add(lblOdemeSorumlusuYakinligi, 107, 140);
		lblOdemeSorumlusuYakinligi.setSize("205px", "22px");

		lblOdemeSorumlusuEmail = new Label("");
		absolutePanel_2.add(lblOdemeSorumlusuEmail, 107, 228);
		lblOdemeSorumlusuEmail.setSize("205px", "22px");

		lblOdemeSorumlusuEvTelefonu = new Label("");
		absolutePanel_2.add(lblOdemeSorumlusuEvTelefonu, 107, 198);
		lblOdemeSorumlusuEvTelefonu.setSize("205px", "22px");

		lblVeliYakinligi = new Label("");
		absolutePanel_2.add(lblVeliYakinligi, 107, 357);
		lblVeliYakinligi.setSize("205px", "22px");

		lblVeliTCKimlikNo = new Label("");
		absolutePanel_2.add(lblVeliTCKimlikNo, 107, 295);
		lblVeliTCKimlikNo.setSize("205px", "22px");

		lblVeliAdiSoyadi = new Label("");
		absolutePanel_2.add(lblVeliAdiSoyadi, 107, 325);
		lblVeliAdiSoyadi.setSize("205px", "22px");

		lblVeliCepTelefonu = new Label("");
		absolutePanel_2.add(lblVeliCepTelefonu, 107, 387);
		lblVeliCepTelefonu.setSize("205px", "22px");

		lblVeliEvTelefonu = new Label("");
		absolutePanel_2.add(lblVeliEvTelefonu, 107, 415);
		lblVeliEvTelefonu.setSize("205px", "22px");

		lblVeliEmail = new Label("");
		absolutePanel_2.add(lblVeliEmail, 107, 445);
		lblVeliEmail.setSize("205px", "22px");

		Label label_11 = new Label("Adresi");
		label_11.setStyleName("gwt-Bold");
		absolutePanel_2.add(label_11, 505, 299);
		label_11.setSize("81px", "18px");

		lblVeliAdresi = new Label("");
		absolutePanel_2.add(lblVeliAdresi, 412, 333);
		lblVeliAdresi.setSize("205px", "108px");

		AbsolutePanel absolutePanel_3 = new AbsolutePanel();
		tabPanel.add(absolutePanel_3, "Rehberlik", false);
		absolutePanel_3.setSize("100%", "458px");

		Label lblRehberlik = new Label("Rehberlik");
		lblRehberlik.setStyleName("gwt-LabelMor");
		absolutePanel_3.add(lblRehberlik, 0, 10);
		lblRehberlik.setSize("652px", "26px");

		Label lblYaplanGrmeler = new Label("Yapılan Görüşmeler");
		lblYaplanGrmeler.setStyleName("gwt-Bold");
		absolutePanel_3.add(lblYaplanGrmeler, 10, 54);

		AbsolutePanel absolutePanel_4 = new AbsolutePanel();
		tabPanel.add(absolutePanel_4, "Sınavlar", false);
		absolutePanel_4.setSize("100%", "510px");

		Label lblYgsSnavlar = new Label("YGS Sınavları");
		lblYgsSnavlar.setStyleName("gwt-LabelMor");
		absolutePanel_4.add(lblYgsSnavlar, 0, 10);
		lblYgsSnavlar.setSize("693px", "25px");

		Label lblLysSnavlar = new Label("LYS Sınavları");
		lblLysSnavlar.setStyleName("gwt-LabelMor");
		absolutePanel_4.add(lblLysSnavlar, 0, 254);
		lblLysSnavlar.setSize("693px", "25px");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		absolutePanel_4.add(horizontalPanel, 0, 52);
		horizontalPanel.setSize("100%", "129px");

		CellTable<Object> cellTable = new CellTable<Object>();
		horizontalPanel.add(cellTable);
		cellTable.setSize("100%", "111px");

		TextColumn<Object> textColumn = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn, "Sınav");

		TextColumn<Object> textColumn_1 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_1, "Sınav Tarihi");

		TextColumn<Object> textColumn_2 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_2, "YGS-1 P.");

		TextColumn<Object> textColumn_3 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_3, "YGS-2 P.");

		TextColumn<Object> textColumn_4 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_4, "YGS-3 P.");

		TextColumn<Object> textColumn_5 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_5, "YGS-4 P.");

		TextColumn<Object> textColumn_6 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_6, "YGS-5 P.");

		TextColumn<Object> textColumn_7 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_7, "YGS-6 P.");

		Column<Object, String> column = new Column<Object, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Object object) {
				return "Karne Al";
			}
		};
		cellTable.addColumn(column, "Karne Al");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		absolutePanel_4.add(horizontalPanel_1, 0, 297);
		horizontalPanel_1.setSize("100%", "100px");

		CellTable<Object> cellTable_1 = new CellTable<Object>();
		horizontalPanel_1.add(cellTable_1);
		cellTable_1.setSize("100%", "100%");

		TextColumn<Object> textColumn_8 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable_1.addColumn(textColumn_8, "Sınav");

		TextColumn<Object> textColumn_9 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable_1.addColumn(textColumn_9, "Sınav Tarihi");

		TextColumn<Object> textColumn_10 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable_1.addColumn(textColumn_10, "YGS-1 P.");

		TextColumn<Object> textColumn_11 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable_1.addColumn(textColumn_11, "YGS-2 P.");

		TextColumn<Object> textColumn_12 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable_1.addColumn(textColumn_12, "YGS-3 P.");

		TextColumn<Object> textColumn_13 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable_1.addColumn(textColumn_13, "YGS-4 P.");

		TextColumn<Object> textColumn_14 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable_1.addColumn(textColumn_14, "YGS-5 P.");

		TextColumn<Object> textColumn_15 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable_1.addColumn(textColumn_15, "YGS-6 P.");

		Column<Object, String> column_1 = new Column<Object, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Object object) {
				return "Karne Al";
			}
		};
		cellTable_1.addColumn(column_1, "Karne Al");

		AbsolutePanel absolutePanel_5 = new AbsolutePanel();
		tabPanel.add(absolutePanel_5, "Muhasebe", false);
		absolutePanel_5.setSize("844px", "451px");

		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		absolutePanel_5.add(horizontalPanel_2, 10, 10);
		horizontalPanel_2.setSize("548px", "156px");

		CellTable<Object> cellTable_3 = new CellTable<Object>();
		horizontalPanel_2.add(cellTable_3);
		cellTable_3.setSize("632px", "100%");

		TextColumn<Object> textColumn_16 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_3.addColumn(textColumn_16, "TOPLAM KAYIT ÜCRETİ");

		TextColumn<Object> textColumn_17 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_3.addColumn(textColumn_17, "PEŞİNAT");

		TextColumn<Object> textColumn_18 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_3.addColumn(textColumn_18, "TOPLAM ÖDENEN");

		TextColumn<Object> textColumn_19 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_3.addColumn(textColumn_19, "ÖDENECEK TUTAR");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		absolutePanel_5.add(horizontalPanel_3, 0, 201);
		horizontalPanel_3.setSize("100%", "100px");

		CellTable<Object> cellTable_2 = new CellTable<Object>();
		horizontalPanel_3.add(cellTable_2);
		cellTable_2.setSize("100%", "100%");

		TextColumn<Object> textColumn_20 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_2.addColumn(textColumn_20, "Taksit No");

		TextColumn<Object> textColumn_23 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_2.addColumn(textColumn_23, "Taksit Tarihi");

		TextColumn<Object> textColumn_21 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_2.addColumn(textColumn_21, "Tutar");

		TextColumn<Object> textColumn_22 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_2.addColumn(textColumn_22, "Ödenen");

		TextColumn<Object> textColumn_24 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_2.addColumn(textColumn_24, "Bakiye");

		TextColumn<Object> textColumn_25 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_2.addColumn(textColumn_25, "Ödeme Şekli");

		TextColumn<Object> textColumn_26 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_2.addColumn(textColumn_26, "Kasa Seç");

		TextColumn<Object> textColumn_27 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable_2.addColumn(textColumn_27, "Açıklama");

		Column<Object, String> column_2 = new Column<Object, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Object object) {
				return "İşlemler";
			}
		};
		cellTable_2.addColumn(column_2, "İşlemler");

		Column<Object, String> column_3 = new Column<Object, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Object object) {
				return "Makbuz";
			}
		};
		cellTable_2.addColumn(column_3, "Makbuz");

		Label lbldemePlan = new Label("Ödeme Planı");
		lbldemePlan.setStyleName("gwt-Bold");
		absolutePanel_5.add(lbldemePlan, 10, 171);

		Button btndemePlanYazdr = new Button("Ödeme Planı Yazdır");
		absolutePanel_5.add(btndemePlanYazdr, 665, 20);
		btndemePlanYazdr.setSize("108px", "40px");
	}
}
