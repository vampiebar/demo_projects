/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {
	private SimplePanel smpanMain;
	private VerticalPanel vtpanOgrenciIsleri;
	private VerticalPanel vtpanKayitIslemleri;
	private VerticalPanel vtpanDersDagitim;
	private VerticalPanel vtpanOdevTakip;
	private VerticalPanel vtpanSinavDegerlendirme;
	private VerticalPanel vtpanMuhasebe;
	private VerticalPanel vtpanDonemselTanimlar;
	private VerticalPanel vtpanSabitTanimlamalar;
	private VerticalPanel vtpanDestek;
	private VerticalPanel vtpanYetki;
	private Label btnMenuDBSKayit;
	private Label btnMenuSinifTanimlari;
	private Label btnEgitimTurutanimlama;
	private Image ImgLogo;
	private VerticalPanel verticalPanel;

	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setWidth("");
		rootPanel.setStyleName("gwt-DialogBackGround");
		MenuBar menuBar_1 = new MenuBar(true);

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		rootPanel.add(verticalPanel_1);
		verticalPanel_1.setWidth("100%");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel);
		horizontalPanel.setBorderWidth(0);
		horizontalPanel.setStyleName("gwt-HzPan");
		horizontalPanel.setSize("100%", "89px");

		AbsolutePanel horizontalPanel_2 = new AbsolutePanel();
		horizontalPanel.add(horizontalPanel_2);
		horizontalPanel_2.setSize("148px", "74px");

		ImgLogo = new Image("images/1.gif");
		horizontalPanel_2.add(ImgLogo, 23, 10);
		ImgLogo.setSize("125px", "40px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel.add(horizontalPanel_1);
		horizontalPanel.setCellVerticalAlignment(horizontalPanel_1,
				HasVerticalAlignment.ALIGN_BOTTOM);
		horizontalPanel.setCellHorizontalAlignment(horizontalPanel_1,
				HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel_1.setSize("635px", "29px");

		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel_3);
		horizontalPanel_3.setWidth("100%");

		verticalPanel = new VerticalPanel();
		horizontalPanel_3.add(verticalPanel);
		horizontalPanel_3.setCellWidth(verticalPanel, "245px");
		verticalPanel.setSize("245px", "493px");

		HorizontalPanel verticalPanel_2 = new HorizontalPanel();
		verticalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_2.setStyleName("gwt-LabelMor");
		verticalPanel.add(verticalPanel_2);
		verticalPanel.setCellHeight(verticalPanel_2, "33px");
		verticalPanel_2.setSize("244px", "32px");

		Label lblEitimDnemi = new Label("Eğitim Dönemi:");
		verticalPanel_2.add(lblEitimDnemi);
		lblEitimDnemi.setWidth("125px");

		ListBox comboBox = new ListBox();
		verticalPanel_2.add(comboBox);
		comboBox.addItem("2013/2014");
		comboBox.addItem("2014/2015");
		comboBox.setStyleName("gwt-ComboBox1");
		comboBox.setVisibleItemCount(1);
		verticalPanel.setCellHeight(comboBox, "10");
		comboBox.setSize("97px", "21px");

		DecoratedStackPanel decoratedStackPanel = new DecoratedStackPanel();
		decoratedStackPanel.setStylePrimaryName("gwt-StackPanel");
		decoratedStackPanel.setStyleName("gwt-StackPanel");
		verticalPanel.add(decoratedStackPanel);
		decoratedStackPanel.setSize("245px", "296px");

		vtpanKayitIslemleri = new VerticalPanel();
		vtpanKayitIslemleri.setSpacing(2);
		vtpanKayitIslemleri
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		vtpanKayitIslemleri
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		decoratedStackPanel.add(vtpanKayitIslemleri, "KAYIT İŞLEMLERİ", false);
		vtpanKayitIslemleri.setSize("100%", "79px");

		btnMenuDBSKayit = new Label("DBS Kayıt");
		btnMenuDBSKayit
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuDBSKayit.addClickHandler(new BtnMenuDBSKayitClickHandler());

		Button btnNewButton = new Button("New button");
		btnNewButton.addClickHandler(new BtnNewButtonClickHandler());
		vtpanKayitIslemleri.add(btnNewButton);
		btnMenuDBSKayit.setStyleName("gwt-MenuButton");
		vtpanKayitIslemleri.add(btnMenuDBSKayit);
		vtpanKayitIslemleri.setCellHeight(btnMenuDBSKayit, "25");
		btnMenuDBSKayit.setSize("100%", "25px");

		Label btnMenuOnkayit = new Label("Ön Kayıt");
		btnMenuOnkayit
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuOnkayit.addClickHandler(new BtnMenuOnkayitClickHandler());
		btnMenuOnkayit.setStyleName("gwt-MenuButton");
		vtpanKayitIslemleri.add(btnMenuOnkayit);
		vtpanKayitIslemleri.setCellHeight(btnMenuOnkayit, "25");
		btnMenuOnkayit.setSize("100%", "25px");

		Label btnMenuKesinKayit = new Label("Kesin Kayıt");
		btnMenuKesinKayit
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuKesinKayit.addClickHandler(new BtnMenuKesinKayitClickHandler());
		btnMenuKesinKayit.setStyleName("gwt-MenuButton");
		vtpanKayitIslemleri.add(btnMenuKesinKayit);
		btnMenuKesinKayit.setSize("100%", "25px");

		vtpanOgrenciIsleri = new VerticalPanel();
		vtpanOgrenciIsleri
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		decoratedStackPanel.add(vtpanOgrenciIsleri, "ÖĞRENCİ İŞLERİ", false);
		vtpanOgrenciIsleri.setSize("100%", "56px");

		Label btnNewButton_4 = new Label("Öğrenci Kayıtları");
		btnNewButton_4.addClickHandler(new BtnNewButton_4ClickHandler());
		btnNewButton_4
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnNewButton_4.setStyleName("gwt-MenuButton");
		vtpanOgrenciIsleri.add(btnNewButton_4);
		btnNewButton_4.setSize("100%", "25px");
		vtpanOgrenciIsleri.setCellHeight(btnNewButton_4, "30px");

		Label btnNewButton_5 = new Label("Raporlar");
		btnNewButton_5
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnNewButton_5.setStyleName("gwt-MenuButton");
		vtpanOgrenciIsleri.add(btnNewButton_5);
		btnNewButton_5.setSize("100%", "25px");

		vtpanDersDagitim = new VerticalPanel();
		vtpanDersDagitim
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		decoratedStackPanel.add(vtpanDersDagitim, "DERS DAĞITIM", false);
		vtpanDersDagitim.setSize("100%", "100%");

		Label btbMenuDersDagitimSistemi = new Label("Ders Dağıtım Sistemi");
		btbMenuDersDagitimSistemi
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btbMenuDersDagitimSistemi
				.addClickHandler(new BtbMenuDersDagitimSistemiClickHandler());
		btbMenuDersDagitimSistemi.setStyleName("gwt-MenuButton");
		vtpanDersDagitim.add(btbMenuDersDagitimSistemi);
		btbMenuDersDagitimSistemi.setSize("100%", "25px");

		Label btnMenuYetkiTanimlama = new Label("Yetki Tanımlama (Kısıtlama)");
		btnMenuYetkiTanimlama
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuYetkiTanimlama
				.addClickHandler(new BtnMenuYetkiTanimlamaClickHandler());
		btnMenuYetkiTanimlama.setStyleName("gwt-MenuButton");
		vtpanDersDagitim.add(btnMenuYetkiTanimlama);
		btnMenuYetkiTanimlama.setSize("100%", "25px");

		Label btnMenuSaatGirisi = new Label("Saat Girişi");
		btnMenuSaatGirisi
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuSaatGirisi.addClickHandler(new BtnMenuSaatGirisiClickHandler());
		btnMenuSaatGirisi.setStyleName("gwt-MenuButton");
		vtpanDersDagitim.add(btnMenuSaatGirisi);
		btnMenuSaatGirisi.setSize("100%", "25px");

		vtpanOdevTakip = new VerticalPanel();
		vtpanOdevTakip.setSpacing(2);
		vtpanOdevTakip
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		decoratedStackPanel.add(vtpanOdevTakip, "ÖDEV TAKİP", false);
		vtpanOdevTakip.setSize("100%", "100%");

		Label btnMenuOdevOlustur = new Label("Ödev Oluştur");
		btnMenuOdevOlustur
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuOdevOlustur
				.addClickHandler(new BtnMenuOdevOlusturClickHandler());
		btnMenuOdevOlustur.setStyleName("gwt-MenuButton");
		vtpanOdevTakip.add(btnMenuOdevOlustur);
		btnMenuOdevOlustur.setSize("100%", "25px");

		Label btnMenuCevapAdediBelirle = new Label("Cevap Adedi Belirle");
		btnMenuCevapAdediBelirle
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuCevapAdediBelirle
				.addClickHandler(new BtnMenuCevapAdediBelirleClickHandler());
		btnMenuCevapAdediBelirle.setStyleName("gwt-MenuButton");
		vtpanOdevTakip.add(btnMenuCevapAdediBelirle);
		btnMenuCevapAdediBelirle.setSize("100%", "25px");

		Label btnMenuOdevTakipUnite = new Label("Ödev Takip Ünite");
		btnMenuOdevTakipUnite
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuOdevTakipUnite
				.addClickHandler(new BtnMenuOdevTakipUniteClickHandler());
		btnMenuOdevTakipUnite.setStyleName("gwt-MenuButton");
		vtpanOdevTakip.add(btnMenuOdevTakipUnite);
		btnMenuOdevTakipUnite.setSize("100%", "25px");

		Label btnMenuAtanmisOdevler = new Label("Atanmış Ödevler");
		btnMenuAtanmisOdevler
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuAtanmisOdevler
				.addClickHandler(new BtnMenuAtanmisOdevlerClickHandler());
		btnMenuAtanmisOdevler.setStyleName("gwt-MenuButton");
		vtpanOdevTakip.add(btnMenuAtanmisOdevler);
		btnMenuAtanmisOdevler.setSize("100%", "25px");

		vtpanSinavDegerlendirme = new VerticalPanel();
		vtpanSinavDegerlendirme
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vtpanSinavDegerlendirme.setSpacing(2);
		decoratedStackPanel.add(vtpanSinavDegerlendirme, "SINAV DEĞERLENDİRME",
				false);
		vtpanSinavDegerlendirme.setSize("100%", "64px");

		Label btnMenuSinavTanimlama = new Label("Sınav Tanımlama");
		btnMenuSinavTanimlama
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuSinavTanimlama
				.addClickHandler(new BtnMenuSinavTanimlamaClickHandler());
		btnMenuSinavTanimlama.setStyleName("gwt-MenuButton");
		vtpanSinavDegerlendirme.add(btnMenuSinavTanimlama);
		btnMenuSinavTanimlama.setSize("100%", "25px");

		Label btnMenuSablonTanimlari = new Label("Şablon Tanımları");
		btnMenuSablonTanimlari
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuSablonTanimlari
				.addClickHandler(new BtnMenuSablonTanimlariClickHandler());
		btnMenuSablonTanimlari.setStyleName("gwt-MenuButton");
		vtpanSinavDegerlendirme.add(btnMenuSablonTanimlari);
		btnMenuSablonTanimlari.setSize("100%", "25px");

		vtpanMuhasebe = new VerticalPanel();
		vtpanMuhasebe.setSpacing(2);
		vtpanMuhasebe
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		decoratedStackPanel.add(vtpanMuhasebe, "MUHASEBE", false);
		vtpanMuhasebe.setSize("100%", "142px");

		Label btnMenuGelirveGiderler = new Label("Gelir ve Giderler");
		btnMenuGelirveGiderler
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuGelirveGiderler
				.addClickHandler(new BtnMenuGelirveGiderlerClickHandler());
		btnMenuGelirveGiderler.setStyleName("gwt-MenuButton");
		vtpanMuhasebe.add(btnMenuGelirveGiderler);
		btnMenuGelirveGiderler.setSize("100%", "25px");

		Label btnMenuKasaHareketleri = new Label("Kasa Hareketleri");
		btnMenuKasaHareketleri
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuKasaHareketleri
				.addClickHandler(new BtnMenuKasaHareketleriClickHandler());
		btnMenuKasaHareketleri.setStyleName("gwt-MenuButton");
		vtpanMuhasebe.add(btnMenuKasaHareketleri);
		btnMenuKasaHareketleri.setSize("100%", "25px");

		Label btnMenuGelirGiderTanimlari = new Label("Gelir/Gider Tanımları");
		btnMenuGelirGiderTanimlari
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuGelirGiderTanimlari
				.addClickHandler(new BtnMenuGelirGiderTanimlariClickHandler());
		btnMenuGelirGiderTanimlari.setStyleName("gwt-MenuButton");
		vtpanMuhasebe.add(btnMenuGelirGiderTanimlari);
		btnMenuGelirGiderTanimlari.setSize("100%", "25px");

		Label btnMenuGelirGiderKategorileri = new Label(

		"Gelir Gider Kategorileri");
		btnMenuGelirGiderKategorileri
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuGelirGiderKategorileri
				.addClickHandler(new BtnMenuGelirGiderKategorileriClickHandler());
		btnMenuGelirGiderKategorileri.setStyleName("gwt-MenuButton");
		vtpanMuhasebe.add(btnMenuGelirGiderKategorileri);
		btnMenuGelirGiderKategorileri.setSize("100%", "25px");

		Label btnMenuBankaEkle = new Label("Banka Ekle");
		btnMenuBankaEkle
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuBankaEkle.addClickHandler(new BtnMenuBankaEkleClickHandler());
		btnMenuBankaEkle.setStyleName("gwt-MenuButton");
		vtpanMuhasebe.add(btnMenuBankaEkle);
		btnMenuBankaEkle.setSize("100%", "25px");

		vtpanDonemselTanimlar = new VerticalPanel();
		vtpanDonemselTanimlar.setSpacing(1);
		vtpanDonemselTanimlar
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		vtpanDonemselTanimlar
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		decoratedStackPanel.add(vtpanDonemselTanimlar, "DÖNEMSEL TANIMLAR",
				false);
		vtpanDonemselTanimlar.setSize("100%", "202px");

		Label btnMenuDBSSinavTanimla = new Label("DBS Sınav Tanımla");
		btnMenuDBSSinavTanimla
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuDBSSinavTanimla
				.addClickHandler(new BtnMenuDBSSinavTanimlaClickHandler());
		btnMenuDBSSinavTanimla.setStyleName("gwt-MenuButton");
		vtpanDonemselTanimlar.add(btnMenuDBSSinavTanimla);
		btnMenuDBSSinavTanimla.setSize("100%", "25px");

		Label btnMenuOgretmenTanimlari = new Label("Öğretmen Tanımları");
		btnMenuOgretmenTanimlari
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuOgretmenTanimlari
				.addClickHandler(new BtnMenuOgretmenTanimlariClickHandler());
		btnMenuOgretmenTanimlari.setStyleName("gwt-MenuButton");
		vtpanDonemselTanimlar.add(btnMenuOgretmenTanimlari);
		btnMenuOgretmenTanimlari.setSize("100%", "25px");

		btnMenuSinifTanimlari = new Label("Sınıf Tanımları");
		btnMenuSinifTanimlari.setDirection(Direction.LTR);
		btnMenuSinifTanimlari
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuSinifTanimlari
				.addClickHandler(new BtnMenuSinifTanimlariClickHandler());
		btnMenuSinifTanimlari.setStyleName("gwt-MenuButton");
		vtpanDonemselTanimlar.add(btnMenuSinifTanimlari);
		btnMenuSinifTanimlari.setSize("100%", "25px");

		Label btnMenuIndirimTuru = new Label("İndirim Türü");
		btnMenuIndirimTuru.setDirection(Direction.LTR);
		btnMenuIndirimTuru
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuIndirimTuru
				.addClickHandler(new BtnMenuIndirimTuruClickHandler());
		btnMenuIndirimTuru.setStyleName("gwt-MenuButton");
		vtpanDonemselTanimlar.add(btnMenuIndirimTuru);
		btnMenuIndirimTuru.setSize("100%", "25px");

		Label btnMenuHizmetTanmla = new Label("Hizmet Tanımla");
		btnMenuHizmetTanmla.setDirection(Direction.LTR);
		btnMenuHizmetTanmla
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuHizmetTanmla
				.addClickHandler(new BtnMenuHizmetTanmlaClickHandler());
		btnMenuHizmetTanmla.setStyleName("gwt-MenuButton");
		vtpanDonemselTanimlar.add(btnMenuHizmetTanmla);
		btnMenuHizmetTanmla.setSize("100%", "25px");

		Label btnMenuReferanslar = new Label("Referanslar");
		btnMenuReferanslar.setDirection(Direction.LTR);
		btnMenuReferanslar
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuReferanslar
				.addClickHandler(new BtnMenuReferanslarClickHandler());
		btnMenuReferanslar.setStyleName("gwt-MenuButton");
		vtpanDonemselTanimlar.add(btnMenuReferanslar);
		btnMenuReferanslar.setSize("100%", "25px");

		Label btnMenuPersonelTanimlari = new Label("Personel Tanımları");
		btnMenuPersonelTanimlari
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuPersonelTanimlari
				.addClickHandler(new BtnMenuPersonelTanimlariClickHandler());
		btnMenuPersonelTanimlari.setStyleName("gwt-MenuButton");
		vtpanDonemselTanimlar.add(btnMenuPersonelTanimlari);
		btnMenuPersonelTanimlari.setSize("100%", "25px");

		vtpanSabitTanimlamalar = new VerticalPanel();
		vtpanSabitTanimlamalar.setSpacing(2);
		vtpanSabitTanimlamalar
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		vtpanSabitTanimlamalar
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		decoratedStackPanel.add(vtpanSabitTanimlamalar, "SABİT TANIMLAMALAR",
				false);
		vtpanSabitTanimlamalar.setSize("100%", "252px");

		Label btnMenuKurumsalBilgiler = new Label("Kurumsal Bilgiler");
		btnMenuKurumsalBilgiler.setDirection(Direction.LTR);
		btnMenuKurumsalBilgiler
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuKurumsalBilgiler
				.addClickHandler(new BtnMenuKurumsalBilgilerClickHandler());
		btnMenuKurumsalBilgiler.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(btnMenuKurumsalBilgiler);
		btnMenuKurumsalBilgiler.setSize("100%", "25px");

		Label btnMenuDonemTanimlari = new Label("Dönem Tanımları");
		btnMenuDonemTanimlari.setDirection(Direction.LTR);
		btnMenuDonemTanimlari
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuDonemTanimlari
				.addClickHandler(new BtnMenuDonemTanimlariClickHandler());
		btnMenuDonemTanimlari.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(btnMenuDonemTanimlari);
		btnMenuDonemTanimlari.setSize("100%", "25px");

		Label btnMenuDersTanimlari = new Label("Ders Tanımları");
		btnMenuDersTanimlari.setDirection(Direction.LTR);
		btnMenuDersTanimlari
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuDersTanimlari
				.addClickHandler(new BtnMenuDersTanimlariClickHandler());
		btnMenuDersTanimlari.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(btnMenuDersTanimlari);
		btnMenuDersTanimlari.setSize("100%", "25px");

		Label btnMenuUniteTanimlari = new Label("Ünite Tanımları");
		btnMenuUniteTanimlari.setDirection(Direction.LTR);
		btnMenuUniteTanimlari
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuUniteTanimlari
				.addClickHandler(new BtnMenuUniteTanimlariClickHandler());
		btnMenuUniteTanimlari.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(btnMenuUniteTanimlari);
		btnMenuUniteTanimlari.setSize("100%", "25px");

		Label btnMenuKonuTanimlari = new Label("Konu Tanımları");
		btnMenuKonuTanimlari
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuKonuTanimlari
				.addClickHandler(new BtnMenuKonuTanimlariClickHandler());
		btnMenuKonuTanimlari.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(btnMenuKonuTanimlari);
		btnMenuKonuTanimlari.setSize("100%", "25px");

		Label btnMenuFizikselSinifTanimlama = new Label(

		"Fiziksel Sınıf Tanımlama");
		btnMenuFizikselSinifTanimlama
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuFizikselSinifTanimlama
				.addClickHandler(new BtnMenuFizikselSinifTanimlamaClickHandler());
		btnMenuFizikselSinifTanimlama.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(btnMenuFizikselSinifTanimlama);
		btnMenuFizikselSinifTanimlama.setSize("100%", "25px");

		Label btnMenuKursZamaniTanimlama = new Label("Kurs Zamanı Tanımlama");
		btnMenuKursZamaniTanimlama
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuKursZamaniTanimlama
				.addClickHandler(new BtnMenuKursZamaniTanimlamaClickHandler());
		btnMenuKursZamaniTanimlama.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(btnMenuKursZamaniTanimlama);
		btnMenuKursZamaniTanimlama.setSize("100%", "25px");

		Label btnMenuSozlemeMaddeleri = new Label("Sözleşme Maddeleri");
		btnMenuSozlemeMaddeleri
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuSozlemeMaddeleri
				.addClickHandler(new BtnMenuSozlemeMaddeleriClickHandler());
		btnMenuSozlemeMaddeleri.setStyleName("gwt-MenuButton");

		btnEgitimTurutanimlama = new Label("Eğitim Türü Tanimlama");
		btnEgitimTurutanimlama
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnEgitimTurutanimlama
				.addClickHandler(new BtnEgitimTurutanimlamaClickHandler());
		btnEgitimTurutanimlama.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(btnEgitimTurutanimlama);
		btnEgitimTurutanimlama.setSize("100%", "25px");

		Label lblServisTanimlama = new Label("Servis Tanimlama");
		lblServisTanimlama
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblServisTanimlama
				.addClickHandler(new LblServisTanimlamaClickHandler());
		lblServisTanimlama.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(lblServisTanimlama);
		lblServisTanimlama.setSize("100%", "25px");
		vtpanSabitTanimlamalar.add(btnMenuSozlemeMaddeleri);
		btnMenuSozlemeMaddeleri.setSize("100%", "25px");

		Label btnMenuSifreDegistirme = new Label("Şifre Değiştirme");
		btnMenuSifreDegistirme
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuSifreDegistirme
				.addClickHandler(new BtnMenuSifreDegistirmeClickHandler());
		btnMenuSifreDegistirme.setStyleName("gwt-MenuButton");
		vtpanSabitTanimlamalar.add(btnMenuSifreDegistirme);
		btnMenuSifreDegistirme.setSize("100%", "25px");

		vtpanDestek = new VerticalPanel();
		vtpanDestek.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		vtpanDestek.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		decoratedStackPanel.add(vtpanDestek, "DESTEK", false);
		vtpanDestek.setSize("100%", "32px");

		Label btnMenuDestekAlmakIstiyorum = new Label(

		"Destek Almak İstiyorum");
		btnMenuDestekAlmakIstiyorum
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuDestekAlmakIstiyorum
				.addClickHandler(new BtnMenuDestekAlmakIstiyorumClickHandler());
		btnMenuDestekAlmakIstiyorum.setStyleName("gwt-MenuButton");
		vtpanDestek.add(btnMenuDestekAlmakIstiyorum);
		btnMenuDestekAlmakIstiyorum.setSize("100%", "25px");

		vtpanYetki = new VerticalPanel();
		vtpanYetki.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		vtpanYetki.setBorderWidth(0);
		vtpanYetki.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		decoratedStackPanel.add(vtpanYetki, "YETKİ", false);
		vtpanYetki.setSize("100%", "32px");

		Label btnMenuKullaniciTanimlama = new Label("Kullanıcı Tanımlama");
		btnMenuKullaniciTanimlama
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		btnMenuKullaniciTanimlama
				.addClickHandler(new BtnMenuKullaniciTanimlamaClickHandler());
		btnMenuKullaniciTanimlama.setStyleName("gwt-MenuButton");
		vtpanYetki.add(btnMenuKullaniciTanimlama);
		btnMenuKullaniciTanimlama.setSize("100%", "25px");

		smpanMain = new SimplePanel();
		horizontalPanel_3.add(smpanMain);
		horizontalPanel_3.setCellWidth(smpanMain, "0");
		smpanMain.setSize("100%", "674px");

		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		horizontalPanel_4
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_4.setStyleName("gwt-LabelMor2");
		smpanMain.setWidget(horizontalPanel_4);
		horizontalPanel_4.setSize("100%", "33px");

		Label lblDershaneYnetimSistemi = new Label("Dershane Yönetim Sistemi");
		horizontalPanel_4.add(lblDershaneYnetimSistemi);
		lblDershaneYnetimSistemi.setWidth("100%");

		VerticalPanel verticalPanel_3 = new VerticalPanel();
		horizontalPanel_3.add(verticalPanel_3);
		horizontalPanel_3.setCellWidth(verticalPanel_3, "30");
		verticalPanel_3.setSize("247px", "547px");

		StackLayoutPanel stackLayoutPanel = new StackLayoutPanel(Unit.EM);
		stackLayoutPanel.setVisible(true);

		VerticalPanel verticalPanel_4 = new VerticalPanel();
		verticalPanel_4.setSpacing(2);
		stackLayoutPanel.add(verticalPanel_4, new HTML("KAYIT İŞLEMLERİ"), 2.4);
		verticalPanel_4.setSize("100%", "89px");

		Label lblNewLabel = new Label("DBS Kayıt");
		lblNewLabel.setStyleName("gwt-MenuButton");
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_4.add(lblNewLabel);
		lblNewLabel.setSize("100%", "25px");

		Label lblNewLabel_2 = new Label("Ön Kayıt");
		lblNewLabel_2.setStyleName("gwt-MenuButton");
		lblNewLabel_2
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_4.add(lblNewLabel_2);
		lblNewLabel_2.setSize("100%", "25px");

		Label lblNewLabel_3 = new Label("Kesin Kayıt");
		lblNewLabel_3.setStyleName("gwt-MenuButton");
		lblNewLabel_3
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_4.add(lblNewLabel_3);
		lblNewLabel_3.setSize("100%", "25px");

		VerticalPanel lblNewLabel_1 = new VerticalPanel();
		lblNewLabel_1.setSpacing(2);
		stackLayoutPanel.add(lblNewLabel_1, new HTML("ÖĞRENCİ İŞLERİ"), 2.0);
		lblNewLabel_1.setSize("100%", "100%");

		Label lblNewLabel_4 = new Label("Öğrenci Kayıtları");
		lblNewLabel_4.setStyleName("gwt-MenuButton");
		lblNewLabel_4
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblNewLabel_1.add(lblNewLabel_4);
		lblNewLabel_4.setSize("100%", "25px");

		Label lblNewLabel_5 = new Label("Raporlar");
		lblNewLabel_5.setStyleName("gwt-MenuButton");
		lblNewLabel_5
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblNewLabel_1.add(lblNewLabel_5);
		lblNewLabel_5.setSize("100%", "25px");

		VerticalPanel verticalPanel_5 = new VerticalPanel();
		verticalPanel_5.setSpacing(2);
		stackLayoutPanel.add(verticalPanel_5, new HTML("DERS DAĞITIM"), 2.0);
		verticalPanel_5.setSize("100%", "100%");

		Label lblNewLabel_6 = new Label("Ders Dağıtım Sistemi");
		lblNewLabel_6.setStyleName("gwt-MenuButton");
		lblNewLabel_6
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_5.add(lblNewLabel_6);
		lblNewLabel_6.setSize("100%", "25px");

		Label lblNewLabel_8 = new Label("Yetki Tanımlama (Kısıtlama)");
		lblNewLabel_8.setStyleName("gwt-MenuButton");
		lblNewLabel_8
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_5.add(lblNewLabel_8);
		lblNewLabel_8.setSize("100%", "25px");

		Label lblNewLabel_7 = new Label("Saat Girişi");
		lblNewLabel_7.setStyleName("gwt-MenuButton");
		lblNewLabel_7
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_5.add(lblNewLabel_7);
		lblNewLabel_7.setSize("100%", "25px");

		VerticalPanel verticalPanel_6 = new VerticalPanel();
		verticalPanel_6.setSpacing(2);
		stackLayoutPanel.add(verticalPanel_6, new HTML("ÖDEV TAKİP"), 2.0);
		verticalPanel_6.setSize("100%", "100%");

		Label lblNewLabel_9 = new Label("Ödev Oluştur");
		lblNewLabel_9.setStyleName("gwt-MenuButton");
		lblNewLabel_9
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_6.add(lblNewLabel_9);
		lblNewLabel_9.setSize("100%", "25px");

		Label lblCevapAdediBelirle = new Label("Cevap Adedi Belirle");
		lblCevapAdediBelirle.setStyleName("gwt-MenuButton");
		lblCevapAdediBelirle
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_6.add(lblCevapAdediBelirle);
		lblCevapAdediBelirle.setSize("100%", "25px");

		Label lbldevTakipnite = new Label("Ödev Takip Ünite");
		lbldevTakipnite.setStyleName("gwt-MenuButton");
		lbldevTakipnite
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_6.add(lbldevTakipnite);
		lbldevTakipnite.setSize("100%", "25px");

		VerticalPanel verticalPanel_7 = new VerticalPanel();
		verticalPanel_7.setSpacing(2);
		stackLayoutPanel.add(verticalPanel_7, new HTML("SINAV DEĞERLENDİRME"),
				2.0);
		verticalPanel_7.setSize("100%", "25px");

		Label label = new Label("Şablon Tanımları");
		label.setStyleName("gwt-MenuButton");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_7.add(label);
		label.setSize("100%", "25px");

		Label label_1 = new Label("Sınav Tanımlama");
		label_1.setStyleName("gwt-MenuButton");
		label_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_7.add(label_1);
		label_1.setSize("100%", "25px");

		VerticalPanel verticalPanel_8 = new VerticalPanel();
		stackLayoutPanel.add(verticalPanel_8, new HTML("MUHASEBE"), 2.0);
		verticalPanel_8.setSize("100%", "61px");

		Label label_2 = new Label("Gelir ve Giderler");
		label_2.setStyleName("gwt-MenuButton");
		label_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_8.add(label_2);
		label_2.setSize("100%", "25px");

		Label label_3 = new Label("Banka Ekle");
		label_3.setStyleName("gwt-MenuButton");
		label_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_8.add(label_3);
		label_3.setSize("100%", "25px");

		Label label_4 = new Label("Gelir Gider Kategorileri");
		label_4.setStyleName("gwt-MenuButton");
		label_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_8.add(label_4);
		label_4.setSize("100%", "25px");

		Label label_5 = new Label("Gelir/Gider Tanımları");
		label_5.setStyleName("gwt-MenuButton");
		label_5.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_8.add(label_5);
		label_5.setSize("100%", "25px");

		Label label_6 = new Label("Kasa Hareketleri");
		label_6.setStyleName("gwt-MenuButton");
		label_6.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_8.add(label_6);
		label_6.setSize("100%", "25px");

		VerticalPanel verticalPanel_9 = new VerticalPanel();
		stackLayoutPanel.add(verticalPanel_9, new HTML("DÖNEMSEL TANIMLAR"),
				2.0);
		verticalPanel_9.setWidth("100%");

		Label label_7 = new Label("DBS Sınav Tanımla");
		label_7.setStyleName("gwt-MenuButton");
		label_7.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_9.add(label_7);
		label_7.setSize("100%", "25px");

		Label label_8 = new Label("Öğretmen Tanımları");
		label_8.setStyleName("gwt-MenuButton");
		label_8.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_9.add(label_8);
		label_8.setSize("100%", "25px");

		Label label_9 = new Label("Sınıf Tanımları");
		label_9.setStyleName("gwt-MenuButton");
		label_9.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_9.setDirection(Direction.LTR);
		verticalPanel_9.add(label_9);
		label_9.setSize("100%", "25px");

		Label label_10 = new Label("İndirim Türü");
		label_10.setStyleName("gwt-MenuButton");
		label_10.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_10.setDirection(Direction.LTR);
		verticalPanel_9.add(label_10);
		label_10.setSize("100%", "25px");

		Label label_11 = new Label("Hizmet Tanımla");
		label_11.setStyleName("gwt-MenuButton");
		label_11.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_11.setDirection(Direction.LTR);
		verticalPanel_9.add(label_11);
		label_11.setSize("100%", "25px");

		Label label_12 = new Label("Referanslar");
		label_12.setStyleName("gwt-MenuButton");
		label_12.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_12.setDirection(Direction.LTR);
		verticalPanel_9.add(label_12);
		label_12.setSize("100%", "25px");

		Label label_13 = new Label("Personel Tanımları");
		label_13.setStyleName("gwt-MenuButton");
		label_13.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_9.add(label_13);
		label_13.setSize("100%", "25px");

		VerticalPanel verticalPanel_10 = new VerticalPanel();
		stackLayoutPanel.add(verticalPanel_10, new HTML("SABİT TANIMLAMALAR"),
				2.0);
		verticalPanel_10.setSize("100%", "100%");

		Label label_14 = new Label("Kurumsal Bilgiler");
		label_14.setStyleName("gwt-MenuButton");
		label_14.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_14.setDirection(Direction.LTR);
		verticalPanel_10.add(label_14);
		label_14.setSize("100%", "25px");

		Label label_15 = new Label("Dönem Tanımları");
		label_15.setStyleName("gwt-MenuButton");
		label_15.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_15.setDirection(Direction.LTR);
		verticalPanel_10.add(label_15);
		label_15.setSize("100%", "25px");

		Label label_16 = new Label("Ders Tanımları");
		label_16.setStyleName("gwt-MenuButton");
		label_16.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_16.setDirection(Direction.LTR);
		verticalPanel_10.add(label_16);
		label_16.setSize("100%", "25px");

		Label label_17 = new Label("Ünite Tanımları");
		label_17.setStyleName("gwt-MenuButton");
		label_17.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_17.setDirection(Direction.LTR);
		verticalPanel_10.add(label_17);
		label_17.setSize("100%", "25px");

		Label label_18 = new Label("Konu Tanımları");
		label_18.setStyleName("gwt-MenuButton");
		label_18.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_10.add(label_18);
		label_18.setSize("100%", "25px");

		Label label_19 = new Label("Fiziksel Sınıf Tanımlama");
		label_19.setStyleName("gwt-MenuButton");
		label_19.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_10.add(label_19);
		label_19.setSize("100%", "25px");

		Label label_20 = new Label("Kurs Zamanı Tanımlama");
		label_20.setStyleName("gwt-MenuButton");
		label_20.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_10.add(label_20);
		label_20.setSize("100%", "25px");

		Label label_21 = new Label("Eğitim Türü Tanimlama");
		label_21.setStyleName("gwt-MenuButton");
		label_21.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_10.add(label_21);
		label_21.setSize("100%", "25px");

		Label label_22 = new Label("Servis Tanimlama");
		label_22.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label_22.setStyleName("gwt-MenuButton");
		verticalPanel_10.add(label_22);
		label_22.setSize("100%", "25px");

		Label label_23 = new Label("Sözleşme Maddeleri");
		label_23.setStyleName("gwt-MenuButton");
		label_23.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_10.add(label_23);
		label_23.setSize("100%", "25px");
		verticalPanel_3.add(stackLayoutPanel);
		stackLayoutPanel.setSize("100%", "481px");

		if (!isDesignTime()) {
			// DlgLogIn dlgTemp = new DlgLogIn();
			// dlgTemp.center();

		}
	}

	private boolean isDesignTime() {

		return false;
	}

	public static native void scrollToTop() /*-{
											$wnd.scroll(0, 0);
											}-*/;

	private class BtnMenuDBSKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new DBSKayit());
			scrollToTop();

		}
	}

	private class BtnMenuOnkayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new OnKayit());
			scrollToTop();
		}
	}

	private class BtnMenuKesinKayitClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new KesinKayit());
			scrollToTop();
		}
	}

	private class BtbMenuDersDagitimSistemiClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new DersDagitimSistemi());
			scrollToTop();

		}
	}

	private class BtnMenuSaatGirisiClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new SaatGirisi());
			scrollToTop();
		}
	}

	private class BtnMenuYetkiTanimlamaClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new YetkiTanimlama());
			scrollToTop();

		}
	}

	private class BtnMenuOdevTakipUniteClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new OdevTakipUnite());
			scrollToTop();

		}
	}

	private class BtnMenuOdevOlusturClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new OdevOlustur());
			scrollToTop();

		}
	}

	private class BtnMenuCevapAdediBelirleClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new CevapAdediBelirle());
			scrollToTop();

		}
	}

	private class BtnMenuAtanmisOdevlerClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new AtanmisOdevler());
			scrollToTop();

		}
	}

	private class BtnMenuSinavTanimlamaClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new SinavTanimlama());
			scrollToTop();

		}
	}

	private class BtnMenuSablonTanimlariClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new SablonTaninmlari());
			scrollToTop();

		}
	}

	private class BtnMenuBankaEkleClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new BankaEkle());
			scrollToTop();

		}
	}

	private class BtnMenuGelirGiderKategorileriClickHandler implements
			ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new GelirGiderKategorileri());
			scrollToTop();

		}
	}

	private class BtnMenuKasaHareketleriClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new KasaHareketleri());
			scrollToTop();

		}
	}

	private class BtnMenuGelirveGiderlerClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new GelirlerveGiderler());
			scrollToTop();

		}
	}

	private class BtnMenuGelirGiderTanimlariClickHandler implements
			ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new GelirGiderTanimlari());
			scrollToTop();

		}
	}

	private class BtnMenuReferanslarClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new Referanslar());
			scrollToTop();

		}
	}

	private class BtnMenuPersonelTanimlariClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new PersonelTanimlari());
			scrollToTop();

		}
	}

	private class BtnMenuOgretmenTanimlariClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new OgretmenTanimlari());
			scrollToTop();

		}
	}

	private class BtnMenuHizmetTanmlaClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new HizmetTanimla());
			scrollToTop();

		}
	}

	private class BtnMenuDBSSinavTanimlaClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new DBSSinavTanimla());
			scrollToTop();

		}
	}

	private class BtnMenuIndirimTuruClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new IndirimTuru());
			scrollToTop();

		}
	}

	private class BtnMenuSinifTanimlariClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new SinifTanimlari());
			scrollToTop();

		}
	}

	private class BtnMenuKurumsalBilgilerClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new KurumsalBilgiler(false, -1));
			scrollToTop();

		}
	}

	private class BtnMenuSifreDegistirmeClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new SifreDegistirme());
			scrollToTop();

		}
	}

	private class BtnMenuDonemTanimlariClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new DonemTanimlari());
			scrollToTop();

		}
	}

	private class BtnMenuFizikselSinifTanimlamaClickHandler implements
			ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new FizikselSinifTanimlari());
			scrollToTop();

		}
	}

	private class BtnMenuUniteTanimlariClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new UniteTanimlari());
			scrollToTop();

		}
	}

	private class BtnMenuKursZamaniTanimlamaClickHandler implements
			ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new KursZamaniTanimlama());
			scrollToTop();

		}
	}

	private class BtnMenuDersTanimlariClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new DersTanimlari());
			scrollToTop();

		}
	}

	private class BtnMenuSozlemeMaddeleriClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new SozlesmeMaddeleri(false, -1));
			scrollToTop();

		}
	}

	private class BtnMenuKonuTanimlariClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new KonuTanimlari());
			scrollToTop();

		}
	}

	private class BtnMenuDestekAlmakIstiyorumClickHandler implements
			ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();
			DestekAlmakIstiyorum dlgTemp = new DestekAlmakIstiyorum();
			dlgTemp.tabDestekAlmakIstiyorum.selectTab(0);
			smpanMain.add(dlgTemp);

			scrollToTop();

		}
	}

	private class BtnMenuKullaniciTanimlamaClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new KullaniciTanimlama());
			scrollToTop();

		}
	}

	private class BtnEgitimTurutanimlamaClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new EgitimTuruTanimlama());
			scrollToTop();
		}
	}

	private class LblServisTanimlamaClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			smpanMain.clear();

			smpanMain.add(new ServisTanimlama());
			scrollToTop();
		}
	}

	private class BtnNewButton_4ClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			smpanMain.clear();

			smpanMain.add(new OgrenciKayitlari());
			scrollToTop();

		}
	}

	private class BtnNewButtonClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			smpanMain.clear();
			smpanMain.add(new OgrenciIsleri());
			scrollToTop();
		}
	}
}
