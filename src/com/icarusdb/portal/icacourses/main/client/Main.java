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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
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
	private Button btnMenuDBSKayit;
	private Button btnMenuSinifTanimlari;

	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("gwt-DialogBackGround");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setBorderWidth(0);
		horizontalPanel.setStyleName("gwt-HzPan");
		rootPanel.add(horizontalPanel, 0, 0);
		horizontalPanel.setSize("100%", "89px");

		AbsolutePanel horizontalPanel_2 = new AbsolutePanel();
		horizontalPanel.add(horizontalPanel_2);
		horizontalPanel_2.setSize("148px", "74px");

		Image image_2 = new Image("images/1.gif");
		horizontalPanel_2.add(image_2, 23, 10);
		image_2.setSize("115px", "43px");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel.add(horizontalPanel_1);
		horizontalPanel.setCellVerticalAlignment(horizontalPanel_1,
				HasVerticalAlignment.ALIGN_BOTTOM);
		horizontalPanel.setCellHorizontalAlignment(horizontalPanel_1,
				HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel_1.setSize("635px", "29px");

		Image image_3 = new Image("WEB-INF/profile.png");
		horizontalPanel_1.add(image_3);
		image_3.setSize("24px", "22px");
		horizontalPanel_1.setCellWidth(image_3, "475");

		Button btnNewButton = new Button("Mesajlar");
		btnNewButton.setStyleName("gwt-SuggestBoxPopup");
		horizontalPanel_1.add(btnNewButton);

		Image image = new Image("images/exit.png");
		horizontalPanel_1.add(image);
		horizontalPanel_1.setCellVerticalAlignment(image,
				HasVerticalAlignment.ALIGN_BOTTOM);
		horizontalPanel_1.setCellHorizontalAlignment(image,
				HasHorizontalAlignment.ALIGN_RIGHT);
		image.setSize("20px", "24px");

		Button lblNewLabel = new Button("Çıkış");
		lblNewLabel.addClickHandler(new LblNewLabelClickHandler());
		lblNewLabel.setStyleName("gwt-ButonKapat");
		horizontalPanel_1.add(lblNewLabel);

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("gwt-DialogBackGround");
		verticalPanel.setSpacing(10);
		rootPanel.add(verticalPanel, 23, 95);
		verticalPanel.setSize("240px", "508px");

		Label lblEitimDnemi = new Label("Eğitim Dönemi:");
		lblEitimDnemi.setStyleName("gwt-Bold");
		verticalPanel.add(lblEitimDnemi);
		verticalPanel.setCellHeight(lblEitimDnemi, "10");

		ListBox comboBox = new ListBox();
		comboBox.setStyleName("gwt-ComboBox1");
		comboBox.addItem("2013/2014");
		comboBox.addItem("2014/2015");
		comboBox.setVisibleItemCount(1);
		verticalPanel.add(comboBox);
		verticalPanel.setCellHeight(comboBox, "10");
		comboBox.setSize("217px", "26px");

		DecoratedStackPanel decoratedStackPanel = new DecoratedStackPanel();
		verticalPanel.add(decoratedStackPanel);
		decoratedStackPanel.setSize("220px", "399px");

		vtpanKayitIslemleri = new VerticalPanel();
		vtpanKayitIslemleri.setSpacing(3);
		decoratedStackPanel.add(vtpanKayitIslemleri, "KAYIT İŞLEMLERİ", false);
		vtpanKayitIslemleri.setSize("100%", "108px");

		btnMenuDBSKayit = new Button("DBS Kayıt");
		btnMenuDBSKayit.addClickHandler(new BtnMenuDBSKayitClickHandler());
		vtpanKayitIslemleri.add(btnMenuDBSKayit);
		vtpanKayitIslemleri.setCellHeight(btnMenuDBSKayit, "30");
		btnMenuDBSKayit.setWidth("60%");

		Button btnMenuOnkayit = new Button("Ön Kayıt");
		btnMenuOnkayit.addClickHandler(new BtnMenuOnkayitClickHandler());
		vtpanKayitIslemleri.add(btnMenuOnkayit);
		vtpanKayitIslemleri.setCellHeight(btnMenuOnkayit, "30");
		btnMenuOnkayit.setWidth("60%");

		Button btnMenuKesinKayit = new Button("Kesin Kayıt");
		btnMenuKesinKayit.addClickHandler(new BtnMenuKesinKayitClickHandler());
		vtpanKayitIslemleri.add(btnMenuKesinKayit);
		btnMenuKesinKayit.setSize("60%", "26px");

		vtpanOgrenciIsleri = new VerticalPanel();
		vtpanOgrenciIsleri.setSpacing(3);
		decoratedStackPanel.add(vtpanOgrenciIsleri, "ÖĞRENCİ İŞLERİ", false);
		vtpanOgrenciIsleri.setSize("100%", "100%");

		Button btnNewButton_4 = new Button("Öğrenci Kayıtları");
		vtpanOgrenciIsleri.add(btnNewButton_4);
		vtpanOgrenciIsleri.setCellHeight(btnNewButton_4, "30px");

		Button btnNewButton_5 = new Button("Raporlar");
		vtpanOgrenciIsleri.add(btnNewButton_5);

		vtpanDersDagitim = new VerticalPanel();
		vtpanDersDagitim.setSpacing(3);
		decoratedStackPanel.add(vtpanDersDagitim, "DERS DAĞITIM", false);
		vtpanDersDagitim.setSize("100%", "100%");

		Button btbMenuDersDagitimSistemi = new Button("Ders Dağıtım Sistemi");
		btbMenuDersDagitimSistemi
				.addClickHandler(new BtbMenuDersDagitimSistemiClickHandler());
		vtpanDersDagitim.add(btbMenuDersDagitimSistemi);
		btbMenuDersDagitimSistemi.setWidth("90%");

		Button btnMenuYetkiTanimlama = new Button("Yetki Tanımlama (Kısıtlama)");
		btnMenuYetkiTanimlama
				.addClickHandler(new BtnMenuYetkiTanimlamaClickHandler());
		vtpanDersDagitim.add(btnMenuYetkiTanimlama);
		btnMenuYetkiTanimlama.setWidth("90%");

		Button btnMenuSaatGirisi = new Button("Saat Girişi");
		btnMenuSaatGirisi.addClickHandler(new BtnMenuSaatGirisiClickHandler());
		vtpanDersDagitim.add(btnMenuSaatGirisi);
		btnMenuSaatGirisi.setWidth("90%");

		vtpanOdevTakip = new VerticalPanel();
		vtpanOdevTakip.setSpacing(3);
		decoratedStackPanel.add(vtpanOdevTakip, "ÖDEV TAKİP", false);
		vtpanOdevTakip.setSize("100%", "100%");

		Button btnMenuOdevOlustur = new Button("Ödev Oluştur");
		btnMenuOdevOlustur
				.addClickHandler(new BtnMenuOdevOlusturClickHandler());
		vtpanOdevTakip.add(btnMenuOdevOlustur);
		btnMenuOdevOlustur.setWidth("65%");

		Button btnMenuCevapAdediBelirle = new Button("Cevap Adedi Belirle");
		btnMenuCevapAdediBelirle
				.addClickHandler(new BtnMenuCevapAdediBelirleClickHandler());
		vtpanOdevTakip.add(btnMenuCevapAdediBelirle);

		Button btnMenuOdevTakipUnite = new Button("Ödev Takip Ünite");
		btnMenuOdevTakipUnite
				.addClickHandler(new BtnMenuOdevTakipUniteClickHandler());
		vtpanOdevTakip.add(btnMenuOdevTakipUnite);
		btnMenuOdevTakipUnite.setWidth("65%");

		Button btnMenuAtanmisOdevler = new Button("Atanmış Ödevler");
		btnMenuAtanmisOdevler
				.addClickHandler(new BtnMenuAtanmisOdevlerClickHandler());
		vtpanOdevTakip.add(btnMenuAtanmisOdevler);
		btnMenuAtanmisOdevler.setWidth("65%");

		vtpanSinavDegerlendirme = new VerticalPanel();
		vtpanSinavDegerlendirme.setSpacing(3);
		decoratedStackPanel.add(vtpanSinavDegerlendirme, "SINAV DEĞERLENDİRME",
				false);
		vtpanSinavDegerlendirme.setSize("100%", "64px");

		Button btnMenuSinavTanimlama = new Button("Sınav Tanımlama");
		btnMenuSinavTanimlama
				.addClickHandler(new BtnMenuSinavTanimlamaClickHandler());
		vtpanSinavDegerlendirme.add(btnMenuSinavTanimlama);

		Button btnMenuSablonTanimlari = new Button("Şablon Tanımları");
		btnMenuSablonTanimlari
				.addClickHandler(new BtnMenuSablonTanimlariClickHandler());
		vtpanSinavDegerlendirme.add(btnMenuSablonTanimlari);
		btnMenuSablonTanimlari.setWidth("116px");

		vtpanMuhasebe = new VerticalPanel();
		vtpanMuhasebe.setSpacing(3);
		decoratedStackPanel.add(vtpanMuhasebe, "MUHASEBE", false);
		vtpanMuhasebe.setSize("100%", "142px");

		Button btnMenuGelirveGiderler = new Button("Gelir ve Giderler");
		btnMenuGelirveGiderler
				.addClickHandler(new BtnMenuGelirveGiderlerClickHandler());
		vtpanMuhasebe.add(btnMenuGelirveGiderler);
		btnMenuGelirveGiderler.setWidth("75%");

		Button btnMenuKasaHareketleri = new Button("Kasa Hareketleri");
		btnMenuKasaHareketleri
				.addClickHandler(new BtnMenuKasaHareketleriClickHandler());
		vtpanMuhasebe.add(btnMenuKasaHareketleri);
		btnMenuKasaHareketleri.setWidth("75%");

		Button btnMenuGelirGiderTanimlari = new Button("Gelir/Gider Tanımları");
		btnMenuGelirGiderTanimlari
				.addClickHandler(new BtnMenuGelirGiderTanimlariClickHandler());
		vtpanMuhasebe.add(btnMenuGelirGiderTanimlari);
		btnMenuGelirGiderTanimlari.setWidth("75%");

		Button btnMenuGelirGiderKategorileri = new Button(
				"Gelir Gider Kategorileri");
		btnMenuGelirGiderKategorileri
				.addClickHandler(new BtnMenuGelirGiderKategorileriClickHandler());
		vtpanMuhasebe.add(btnMenuGelirGiderKategorileri);
		btnMenuGelirGiderKategorileri.setWidth("75%");

		Button btnMenuBankaEkle = new Button("Banka Ekle");
		btnMenuBankaEkle.addClickHandler(new BtnMenuBankaEkleClickHandler());
		vtpanMuhasebe.add(btnMenuBankaEkle);
		btnMenuBankaEkle.setWidth("75%");

		vtpanDonemselTanimlar = new VerticalPanel();
		vtpanDonemselTanimlar.setSpacing(3);
		decoratedStackPanel.add(vtpanDonemselTanimlar, "DÖNEMSEL TANIMLAR",
				false);
		vtpanDonemselTanimlar.setSize("100%", "194px");

		Button btnMenuDBSSinavTanimla = new Button("DBS Sınav Tanımla");
		btnMenuDBSSinavTanimla
				.addClickHandler(new BtnMenuDBSSinavTanimlaClickHandler());
		vtpanDonemselTanimlar.add(btnMenuDBSSinavTanimla);
		btnMenuDBSSinavTanimla.setWidth("65%");

		Button btnMenuOgretmenTanimlari = new Button("Öğretmen Tanımları");
		btnMenuOgretmenTanimlari
				.addClickHandler(new BtnMenuOgretmenTanimlariClickHandler());
		vtpanDonemselTanimlar.add(btnMenuOgretmenTanimlari);
		btnMenuOgretmenTanimlari.setWidth("65%");

		btnMenuSinifTanimlari = new Button("Sınıf Tanımları");
		btnMenuSinifTanimlari
				.addClickHandler(new BtnMenuSinifTanimlariClickHandler());
		vtpanDonemselTanimlar.add(btnMenuSinifTanimlari);
		btnMenuSinifTanimlari.setWidth("65%");

		Button btnMenuIndirimTuru = new Button("İndirim Türü");
		btnMenuIndirimTuru
				.addClickHandler(new BtnMenuIndirimTuruClickHandler());
		vtpanDonemselTanimlar.add(btnMenuIndirimTuru);
		btnMenuIndirimTuru.setWidth("65%");

		Button btnMenuHizmetTanmla = new Button("Hizmet Tanımla");
		btnMenuHizmetTanmla
				.addClickHandler(new BtnMenuHizmetTanmlaClickHandler());
		vtpanDonemselTanimlar.add(btnMenuHizmetTanmla);
		btnMenuHizmetTanmla.setWidth("65%");

		Button btnMenuReferanslar = new Button("Referanslar");
		btnMenuReferanslar
				.addClickHandler(new BtnMenuReferanslarClickHandler());
		vtpanDonemselTanimlar.add(btnMenuReferanslar);
		btnMenuReferanslar.setWidth("65%");

		Button btnMenuPersonelTanimlari = new Button("Personel Tanımları");
		btnMenuPersonelTanimlari
				.addClickHandler(new BtnMenuPersonelTanimlariClickHandler());
		vtpanDonemselTanimlar.add(btnMenuPersonelTanimlari);
		btnMenuPersonelTanimlari.setWidth("65%");

		vtpanSabitTanimlamalar = new VerticalPanel();
		vtpanSabitTanimlamalar.setSpacing(3);
		decoratedStackPanel.add(vtpanSabitTanimlamalar, "SABİT TANIMLAMALAR",
				false);
		vtpanSabitTanimlamalar.setSize("100%", "252px");

		Button btnMenuKurumsalBilgiler = new Button("Kurumsal Bilgiler");
		btnMenuKurumsalBilgiler
				.addClickHandler(new BtnMenuKurumsalBilgilerClickHandler());
		vtpanSabitTanimlamalar.add(btnMenuKurumsalBilgiler);
		btnMenuKurumsalBilgiler.setWidth("80%");

		Button btnMenuDonemTanimlari = new Button("Dönem Tanımları");
		btnMenuDonemTanimlari
				.addClickHandler(new BtnMenuDonemTanimlariClickHandler());
		vtpanSabitTanimlamalar.add(btnMenuDonemTanimlari);
		btnMenuDonemTanimlari.setWidth("80%");

		Button btnMenuDersTanimlari = new Button("Ders Tanımları");
		btnMenuDersTanimlari
				.addClickHandler(new BtnMenuDersTanimlariClickHandler());
		vtpanSabitTanimlamalar.add(btnMenuDersTanimlari);
		btnMenuDersTanimlari.setWidth("80%");

		Button btnMenuUniteTanimlari = new Button("Ünite Tanımları");
		btnMenuUniteTanimlari
				.addClickHandler(new BtnMenuUniteTanimlariClickHandler());
		vtpanSabitTanimlamalar.add(btnMenuUniteTanimlari);
		btnMenuUniteTanimlari.setWidth("80%");

		Button btnMenuKonuTanimlari = new Button("Konu Tanımları");
		btnMenuKonuTanimlari
				.addClickHandler(new BtnMenuKonuTanimlariClickHandler());
		vtpanSabitTanimlamalar.add(btnMenuKonuTanimlari);
		btnMenuKonuTanimlari.setWidth("80%");

		Button btnMenuFizikselSinifTanimlama = new Button(
				"Fiziksel Sınıf Tanımlama");
		btnMenuFizikselSinifTanimlama
				.addClickHandler(new BtnMenuFizikselSinifTanimlamaClickHandler());
		vtpanSabitTanimlamalar.add(btnMenuFizikselSinifTanimlama);
		btnMenuFizikselSinifTanimlama.setWidth("80%");

		Button btnMenuKursZamaniTanimlama = new Button("Kurs Zamanı Tanımlama");
		btnMenuKursZamaniTanimlama
				.addClickHandler(new BtnMenuKursZamaniTanimlamaClickHandler());
		vtpanSabitTanimlamalar.add(btnMenuKursZamaniTanimlama);
		btnMenuKursZamaniTanimlama.setWidth("80%");

		Button btnMenuSozlemeMaddeleri = new Button("Sözleşme Maddeleri");
		btnMenuSozlemeMaddeleri
				.addClickHandler(new BtnMenuSozlemeMaddeleriClickHandler());
		vtpanSabitTanimlamalar.add(btnMenuSozlemeMaddeleri);
		btnMenuSozlemeMaddeleri.setWidth("80%");

		Button btnMenuSifreDegistirme = new Button("Şifre Değiştirme");
		btnMenuSifreDegistirme
				.addClickHandler(new BtnMenuSifreDegistirmeClickHandler());
		vtpanSabitTanimlamalar.add(btnMenuSifreDegistirme);
		btnMenuSifreDegistirme.setWidth("80%");

		vtpanDestek = new VerticalPanel();
		vtpanDestek.setSpacing(3);
		decoratedStackPanel.add(vtpanDestek, "DESTEK", false);
		vtpanDestek.setSize("100%", "100%");

		Button btnMenuDestekAlmakIstiyorum = new Button(
				"Destek Almak İstiyorum");
		btnMenuDestekAlmakIstiyorum
				.addClickHandler(new BtnMenuDestekAlmakIstiyorumClickHandler());
		vtpanDestek.add(btnMenuDestekAlmakIstiyorum);

		vtpanYetki = new VerticalPanel();
		vtpanYetki.setSpacing(3);
		decoratedStackPanel.add(vtpanYetki, "YETKİ", false);
		vtpanYetki.setSize("100%", "44px");

		Button btnMenuKullaniciTanimlama = new Button("Kullanıcı Tanımlama");
		btnMenuKullaniciTanimlama
				.addClickHandler(new BtnMenuKullaniciTanimlamaClickHandler());
		vtpanYetki.add(btnMenuKullaniciTanimlama);
		MenuBar menuBar_1 = new MenuBar(true);

		smpanMain = new SimplePanel();
		rootPanel.add(smpanMain, 269, 95);
		smpanMain.setSize("1023px", "606px");

		Label lblDer = new Label("Dershane Yönetim Sistemi");
		smpanMain.setWidget(lblDer);
		lblDer.setSize("165px", "34px");
		lblDer.setStylePrimaryName("gwt-LabelNew");
		lblDer.setStyleName("body");
	}

	// private class TreeKayitIslemleriSelectionHandler implements
	// SelectionHandler<TreeItem> {
	// public void onSelection(SelectionEvent<TreeItem> event) {
	//
	// smpanMain.clear();
	//
	// TreeItem item = event.getSelectedItem();
	//
	// if (item == tritmDBSKayit) {
	//
	// smpanMain.add(new DBSKayit());
	// scrollToTop();
	//
	// } else if (item == tritmOnKayit) {
	//
	// smpanMain.add(new OnKayit());
	// scrollToTop();
	//
	// }
	//
	// else if (item == tritmKesinKayit) {
	// smpanMain.add(new KesinKayit());
	// scrollToTop();
	// }
	//
	// }
	// }
	//
	// private class TreeDersDagitimSelectionHandler implements
	// SelectionHandler<TreeItem> {
	// public void onSelection(SelectionEvent<TreeItem> event) {
	//
	// smpanMain.clear();
	//
	// TreeItem item = event.getSelectedItem();
	//
	// if (item == tritmDersDagitimSistemi) {
	// scrollToTop();
	// smpanMain.add(new DersDagitimSistemi());
	// } else if (item == tritmYetkiTanimlama) {
	// smpanMain.add(new YetkiTanimlama());
	// scrollToTop();
	// }
	//
	// else if (item == tritmSaatGirisi) {
	// smpanMain.add(new SaatGirisi());
	// scrollToTop();
	//
	// }
	//
	// }
	// }
	//
	// private class TreeOdevTakipSelectionHandler implements
	// SelectionHandler<TreeItem> {
	// public void onSelection(SelectionEvent<TreeItem> event) {
	//
	// smpanMain.clear();
	//
	// TreeItem item = event.getSelectedItem();
	//
	// if (item == tritmOdevolustur) {
	// smpanMain.add(new OdevOlustur());
	// scrollToTop();
	// }
	//
	// else if (item == tritmCevapadedibelirle) {
	// smpanMain.add(new CevapAdediBelirle());
	// scrollToTop();
	// }
	//
	// else if (item == tritmOdevtakipUnite) {
	// smpanMain.add(new OdevTakipUnite());
	// scrollToTop();
	// }
	//
	// else if (item == tritmatanmisodevler) {
	// smpanMain.add(new AtanmisOdevler());
	// scrollToTop();
	// }
	//
	// }
	//
	// }
	//
	// private class TritmSinavDegerlendirmeSelectionHandler implements
	// SelectionHandler<TreeItem> {
	// public void onSelection(SelectionEvent<TreeItem> event) {
	//
	// smpanMain.clear();
	//
	// TreeItem item = event.getSelectedItem();
	//
	// if (item == tritmsinavtanimlama) {
	// smpanMain.add(new SinavTanimlama());
	// scrollToTop();
	// }
	//
	// else if (item == tritmSablontanimlari) {
	// smpanMain.add(new SablonTaninmlari());
	// scrollToTop();
	// }
	//
	// }
	// }
	//
	// private class TritmmuhasebeSelectionHandler implements
	// SelectionHandler<TreeItem> {
	// public void onSelection(SelectionEvent<TreeItem> event) {
	//
	// smpanMain.clear();
	//
	// TreeItem item = event.getSelectedItem();
	//
	// if (item == tritmgelirvegiderler) {
	// smpanMain.add(new GelirlerveGiderler());
	// scrollToTop();
	// }
	//
	// else if (item == tritmkasahareketleri) {
	// smpanMain.add(new KasaHareketleri());
	// scrollToTop();
	// }
	//
	// else if (item == tritmgelirgidertanimlari) {
	// smpanMain.add(new GelirGiderTanimlari());
	// scrollToTop();
	// }
	//
	// else if (item == tritmgelirgiderkategorileri) {
	// smpanMain.add(new GelirGiderKategorileri());
	// scrollToTop();
	//
	// }
	//
	// else if (item == tritmbankaekle) {
	//
	// smpanMain.add(new BankaEkle());
	// scrollToTop();
	// }
	//
	// }
	// }
	//
	// private class TritmDonemseltanimlarSelectionHandler implements
	// SelectionHandler<TreeItem> {
	// public void onSelection(SelectionEvent<TreeItem> event) {
	// smpanMain.clear();
	//
	// TreeItem item = event.getSelectedItem();
	//
	// if (item == tritmDBSSinavTanimla) {
	// smpanMain.add(new DBSSinavTanimla());
	// scrollToTop();
	// }
	//
	// else if (item == tritmOgretmenTanimlari) {
	// smpanMain.add(new OgretmenTanimlari());
	// scrollToTop();
	// }
	//
	// else if (item == tritmSinifTanimlari) {
	// smpanMain.add(new SinifTanimlari());
	// scrollToTop();
	// }
	//
	// else if (item == tritmIndirimturu) {
	// smpanMain.add(new IndirimTuru());
	// scrollToTop();
	// }
	//
	// else if (item == tritmHizmettanimla) {
	// smpanMain.add(new HizmetTanimla());
	// scrollToTop();
	// }
	//
	// else if (item == tritmreferanslar) {
	// smpanMain.add(new Referanslar());
	// scrollToTop();
	// }
	//
	// else if (item == tritmpersoneltanimlari) {
	// smpanMain.add(new PersonelTanimlari());
	// scrollToTop();
	// }
	// }
	//
	// }
	//
	// private class TritmSabittanimlamalarSelectionHandler implements
	// SelectionHandler<TreeItem> {
	// public void onSelection(SelectionEvent<TreeItem> event) {
	// smpanMain.clear();
	//
	// TreeItem item = event.getSelectedItem();
	//
	// if (item == tritmkurumsalbilgiler) {
	// smpanMain.add(new KurumsalBilgiler());
	// scrollToTop();
	// }
	//
	// else if (item == tritmdönemtanimlari) {
	// smpanMain.add(new DonemTanimlari());
	// scrollToTop();
	// }
	//
	// else if (item == tritmderstanimlari) {
	// smpanMain.add(new DersTanimlari());
	// scrollToTop();
	// }
	//
	// else if (item == tritmUnitetanimlari) {
	// smpanMain.add(new UniteTanimlari());
	// scrollToTop();
	// }
	//
	// else if (item == tritmKonutanimlari) {
	// smpanMain.add(new KonuTanimlari());
	// scrollToTop();
	// }
	//
	// else if (item == tritmFizikselsiniftanimlari) {
	// smpanMain.add(new FizikselSinifTanimlari());
	// scrollToTop();
	// }
	//
	// else if (item == tritmKurszamanitanimlari) {
	// smpanMain.add(new KursZamaniTanimlama());
	// scrollToTop();
	// }
	//
	// else if (item == tritmsifredegistirme) {
	// smpanMain.add(new SifreDegistirme());
	// scrollToTop();
	//
	// } else if (item == tritmsozlesmemaddeleri) {
	// smpanMain.add(new SozlesmeMaddeleri());
	// scrollToTop();
	// }
	// }
	//
	// }
	//
	// private class TritmDestekSelectionHandler implements
	// SelectionHandler<TreeItem> {
	// public void onSelection(SelectionEvent<TreeItem> event) {
	// smpanMain.clear();
	//
	// TreeItem item = event.getSelectedItem();
	//
	// if (item == tritmDestekAlmakIstiyorum) {
	// smpanMain.add(new DestekAlmakIstiyorum());
	// scrollToTop();
	//
	// }
	// }
	// }
	//
	// private class TritmYetkiSelectionHandler implements
	// SelectionHandler<TreeItem> {
	// public void onSelection(SelectionEvent<TreeItem> event) {
	// smpanMain.clear();
	//
	// TreeItem item = event.getSelectedItem();
	//
	// if (item == tritmkullanicitanimlama) {
	// smpanMain.add(new KullaniciTanimlama());
	// scrollToTop();
	// }
	// }
	// }

	private class LblNewLabelClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

		}
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

			smpanMain.add(new KurumsalBilgiler());
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

			smpanMain.add(new SozlesmeMaddeleri());
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

			smpanMain.add(new DestekAlmakIstiyorum());
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
}
