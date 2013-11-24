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
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {
	private TreeItem tritmDBSKayit;
	private Tree treeKayitIslemleri;
	private SimplePanel smpanMain;
	private TreeItem tritmOnKayit;
	private TreeItem tritmDersDagitimSistemi;
	private TreeItem tritmYetkiTanimlama;
	private TreeItem tritmSaatGirisi;
	private TreeItem tritmKesinKayit;
	private TreeItem tritmOdevolustur;
	private TreeItem tritmCevapadedibelirle;
	private TreeItem tritmOdevtakipUnite;
	private TreeItem tritmatanmisodevler;
	private TreeItem tritmsinavtanimlama;
	private TreeItem tritmSablontanimlari;
	private TreeItem tritmgelirvegiderler;
	private TreeItem tritmkasahareketleri;
	private TreeItem tritmgelirgidertanimlari;
	private TreeItem tritmgelirgiderkategorileri;
	private TreeItem tritmbankaekle;
	private TreeItem tritmDBSSinavTanimla;
	private TreeItem tritmOgretmenTanimlari;
	private TreeItem tritmSinifTanimlari;
	private TreeItem tritmIndirimturu;
	private TreeItem tritmHizmettanimla;
	private TreeItem tritmreferanslar;
	private TreeItem tritmpersoneltanimlari;
	private TreeItem tritmkurumsalbilgiler;
	private TreeItem tritmdönemtanimlari;
	private TreeItem tritmderstanimlari;
	private TreeItem tritmUnitetanimlari;
	private TreeItem tritmKonutanimlari;
	private TreeItem tritmFizikselsiniftanimlari;
	private TreeItem tritmKurszamanitanimlari;
	private TreeItem tritmsozlesmemaddeleri;
	private TreeItem tritmsifredegistirme;
	private TreeItem tritmDestekAlmakIstiyorum;
	private TreeItem tritmkullanicitanimlama;
	private Tree tritmYetki;
	private Tree tritmDonemseltanimlar;

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
		verticalPanel.setSize("251px", "636px");

		Label lblEitimDnemi = new Label("Eğitim Dönemi:");
		lblEitimDnemi.setStyleName("gwt-Bold");
		verticalPanel.add(lblEitimDnemi);

		ListBox comboBox = new ListBox();
		comboBox.setStyleName("gwt-SuggestBoxPopup");
		comboBox.addItem("2013/2014");
		comboBox.addItem("2014/2015");
		comboBox.setVisibleItemCount(1);
		verticalPanel.add(comboBox);
		comboBox.setSize("217px", "26px");
		MenuBar menuBar_1 = new MenuBar(true);

		DisclosurePanel disclosurePanel_2 = new DisclosurePanel(
				"KAYIT  İŞLEMLERİ", false);
		disclosurePanel_2.setStyleName("gwt-RichTextToolbar");
		disclosurePanel_2.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel_2);
		disclosurePanel_2.setSize("220px", "25px");

		treeKayitIslemleri = new Tree();
		treeKayitIslemleri
				.addSelectionHandler(new TreeKayitIslemleriSelectionHandler());
		disclosurePanel_2.setContent(treeKayitIslemleri);
		treeKayitIslemleri.setSize("122px", "88px");

		tritmDBSKayit = new TreeItem("DBS Kayıt");
		tritmDBSKayit.setStyleName("gwttreeee");
		treeKayitIslemleri.addItem(tritmDBSKayit);
		tritmDBSKayit.setWidth("130px");
		tritmDBSKayit.setState(true);

		tritmOnKayit = new TreeItem("Ön Kayıt");
		tritmOnKayit.setStyleName("gwttreeee");
		treeKayitIslemleri.addItem(tritmOnKayit);
		tritmOnKayit.setSize("130px", "");

		tritmKesinKayit = new TreeItem("Kesin Kayıt");
		tritmKesinKayit.setStyleName("gwttreeee");
		treeKayitIslemleri.addItem(tritmKesinKayit);
		tritmKesinKayit.setWidth("130px");

		DisclosurePanel disclosurePanel_3 = new DisclosurePanel(
				"ÖĞRENCİ İŞLERİ", false);
		disclosurePanel_3.setStyleName("gwt-RichTextToolbar");
		disclosurePanel_3.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel_3);
		disclosurePanel_3.setSize("220px", "25px");

		Tree tree_3 = new Tree();
		tree_3.setAnimationEnabled(true);
		disclosurePanel_3.setContent(tree_3);
		tree_3.setSize("122px", "55px");

		TreeItem trıtmNewItem_7 = new TreeItem("Öğrenci Kayıtları");
		trıtmNewItem_7.setStyleName("gwttreeee");
		tree_3.addItem(trıtmNewItem_7);
		trıtmNewItem_7.setWidth("130px");

		TreeItem trıtmNewItem_10 = new TreeItem("Raporlar");
		trıtmNewItem_10.setStyleName("gwttreeee");
		tree_3.addItem(trıtmNewItem_10);
		trıtmNewItem_10.setWidth("130px");

		DisclosurePanel disclosurePanel_4 = new DisclosurePanel("DERS DAĞITIM",
				false);
		disclosurePanel_4.setStyleName("gwt-RichTextToolbar");
		disclosurePanel_4.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel_4);
		disclosurePanel_4.setSize("220px", "25px");

		Tree treeDersDagitim = new Tree();
		treeDersDagitim
				.addSelectionHandler(new TreeDersDagitimSelectionHandler());
		disclosurePanel_4.setContent(treeDersDagitim);
		treeDersDagitim.setSize("181px", "97px");

		tritmDersDagitimSistemi = new TreeItem("Ders Dağıtım Sistemi");
		tritmDersDagitimSistemi.setStyleName("gwttreeee");
		treeDersDagitim.addItem(tritmDersDagitimSistemi);
		tritmDersDagitimSistemi.setWidth("130px");

		tritmYetkiTanimlama = new TreeItem("Yetki Tanımlama (Kısıtlama)");
		tritmYetkiTanimlama.setStyleName("gwttreeee");
		treeDersDagitim.addItem(tritmYetkiTanimlama);
		tritmYetkiTanimlama.setWidth("130px");

		tritmSaatGirisi = new TreeItem("Saat Girişi");
		tritmSaatGirisi.setStyleName("gwttreeee");
		treeDersDagitim.addItem(tritmSaatGirisi);
		tritmSaatGirisi.setWidth("130px");

		DisclosurePanel disclosurePanel_5 = new DisclosurePanel("ÖDEV TAKİP",
				false);
		disclosurePanel_5.setStyleName("gwt-RichTextToolbar");
		disclosurePanel_5.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel_5);
		disclosurePanel_5.setSize("222px", "25px");

		Tree TreeOdevTakip = new Tree();
		TreeOdevTakip.addSelectionHandler(new TreeOdevTakipSelectionHandler());
		disclosurePanel_5.setContent(TreeOdevTakip);
		TreeOdevTakip.setSize("122px", "97px");

		tritmOdevolustur = new TreeItem("Ödev Oluştur");
		tritmOdevolustur.setStyleName("gwttreeee");
		TreeOdevTakip.addItem(tritmOdevolustur);
		tritmOdevolustur.setWidth("130px");

		tritmCevapadedibelirle = new TreeItem("Cevap Adedi Belirle");
		tritmCevapadedibelirle.setStyleName("gwttreeee");
		TreeOdevTakip.addItem(tritmCevapadedibelirle);
		tritmCevapadedibelirle.setWidth("130px");

		tritmOdevtakipUnite = new TreeItem("Ödev Takip Ünite");
		tritmOdevtakipUnite.setStyleName("gwttreeee");
		TreeOdevTakip.addItem(tritmOdevtakipUnite);
		tritmOdevtakipUnite.setWidth("130px");

		tritmatanmisodevler = new TreeItem("Atanmış Ödevler");
		tritmatanmisodevler.setStyleName("gwttreeee");
		TreeOdevTakip.addItem(tritmatanmisodevler);
		tritmatanmisodevler.setWidth("130px");

		DisclosurePanel disclosurePanel_1 = new DisclosurePanel(
				"SINAV DEĞERLENDİRME", false);
		disclosurePanel_1.setStyleName("gwt-RichTextToolbar");
		disclosurePanel_1.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel_1);
		disclosurePanel_1.setSize("220px", "25px");

		Tree tritmSinavDegerlendirme = new Tree();
		tritmSinavDegerlendirme
				.addSelectionHandler(new TritmSinavDegerlendirmeSelectionHandler());
		disclosurePanel_1.setContent(tritmSinavDegerlendirme);
		tritmSinavDegerlendirme.setSize("122px", "66px");

		tritmsinavtanimlama = new TreeItem("Sınav Tanımlama");
		tritmsinavtanimlama.setStyleName("gwttreeee");
		tritmSinavDegerlendirme.addItem(tritmsinavtanimlama);
		tritmsinavtanimlama.setWidth("130px");

		tritmSablontanimlari = new TreeItem("Şablon Tanımları");
		tritmSablontanimlari.setStyleName("gwttreeee");
		tritmSinavDegerlendirme.addItem(tritmSablontanimlari);
		tritmSablontanimlari.setWidth("130px");

		DisclosurePanel disclosurePanel = new DisclosurePanel("MUHASEBE", false);
		disclosurePanel
				.setStyleName("gwt-RichTextToolbar .gwt-PushButton-up-hovering");
		disclosurePanel.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel);
		disclosurePanel.setSize("220px", "25px");

		Tree tritmmuhasebe = new Tree();
		tritmmuhasebe.addSelectionHandler(new TritmmuhasebeSelectionHandler());
		disclosurePanel.setContent(tritmmuhasebe);
		tritmmuhasebe.setSize("140px", "119px");

		tritmgelirvegiderler = new TreeItem("Gelir ve Giderler");
		tritmgelirvegiderler.setStyleName("gwttreeee");
		tritmmuhasebe.addItem(tritmgelirvegiderler);
		tritmgelirvegiderler.setWidth("130px");

		tritmkasahareketleri = new TreeItem("Kasa Hareketleri");
		tritmkasahareketleri.setStyleName("gwttreeee");
		tritmmuhasebe.addItem(tritmkasahareketleri);
		tritmkasahareketleri.setWidth("130px");

		tritmgelirgidertanimlari = new TreeItem("Gelir/Gider Tanımlarım");
		tritmgelirgidertanimlari.setStyleName("gwttreeee");
		tritmgelirgidertanimlari.setText("Gelir/Gider Tanımları");
		tritmmuhasebe.addItem(tritmgelirgidertanimlari);
		tritmgelirgidertanimlari.setWidth("130px");
		tritmgelirgidertanimlari.setState(true);

		tritmgelirgiderkategorileri = new TreeItem("Gelir/Gider Kategorileri");
		tritmgelirgiderkategorileri.setStyleName("gwttreeee");
		tritmmuhasebe.addItem(tritmgelirgiderkategorileri);
		tritmgelirgiderkategorileri.setWidth("130px");

		tritmbankaekle = new TreeItem("Banka Ekle");
		tritmbankaekle.setStyleName("gwttreeee");
		tritmmuhasebe.addItem(tritmbankaekle);
		tritmbankaekle.setWidth("130px");
		tritmbankaekle.setState(true);

		DisclosurePanel disclosurePanel_7 = new DisclosurePanel(
				"DÖNEMSEL TANIMLAR", false);
		disclosurePanel_7
				.setStyleName("gwt-RichTextToolbar .gwt-PushButton-up-hovering");
		disclosurePanel_7.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel_7);
		disclosurePanel_7.setSize("220px", "25px");

		tritmDonemseltanimlar = new Tree();
		tritmDonemseltanimlar
				.addSelectionHandler(new TritmDonemseltanimlarSelectionHandler());
		disclosurePanel_7.setContent(tritmDonemseltanimlar);
		tritmDonemseltanimlar.setSize("188px", "172px");

		tritmDBSSinavTanimla = new TreeItem("DBS Sınav Tanımla");
		tritmDBSSinavTanimla.setStyleName("gwttreeee");
		tritmDonemseltanimlar.addItem(tritmDBSSinavTanimla);

		tritmOgretmenTanimlari = new TreeItem("Öğretmen Tanımları");
		tritmOgretmenTanimlari.setStyleName("gwttreeee");
		tritmDonemseltanimlar.addItem(tritmOgretmenTanimlari);

		tritmSinifTanimlari = new TreeItem("Sınıf Tanımları");
		tritmSinifTanimlari.setStyleName("gwttreeee");
		tritmDonemseltanimlar.addItem(tritmSinifTanimlari);

		tritmIndirimturu = new TreeItem("İndirim Türü");
		tritmIndirimturu.setStyleName("gwttreeee");
		tritmDonemseltanimlar.addItem(tritmIndirimturu);

		tritmHizmettanimla = new TreeItem("Hizmet Tanımla");
		tritmHizmettanimla.setStyleName("gwttreeee");
		tritmDonemseltanimlar.addItem(tritmHizmettanimla);

		tritmreferanslar = new TreeItem("Referanslar");
		tritmreferanslar.setStyleName("gwttreeee");
		tritmDonemseltanimlar.addItem(tritmreferanslar);

		tritmpersoneltanimlari = new TreeItem("Personel Tanımları");
		tritmpersoneltanimlari.setStyleName("gwttreeee");
		tritmDonemseltanimlar.addItem(tritmpersoneltanimlari);
		tritmpersoneltanimlari.setState(true);

		DisclosurePanel disclosurePanel_8 = new DisclosurePanel(
				"SABİT TANIMLAMALAR", false);
		disclosurePanel_8
				.setStyleName("gwt-RichTextToolbar .gwt-PushButton-up-hovering");
		disclosurePanel_8.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel_8);
		disclosurePanel_8.setSize("220px", "25px");

		Tree tritmSabittanimlamalar = new Tree();
		tritmSabittanimlamalar
				.addSelectionHandler(new TritmSabittanimlamalarSelectionHandler());
		disclosurePanel_8.setContent(tritmSabittanimlamalar);
		tritmSabittanimlamalar.setSize("167px", "213px");

		tritmkurumsalbilgiler = new TreeItem("Kurumsal Bilgiler");
		tritmkurumsalbilgiler.setStyleName("gwttreeee");
		tritmSabittanimlamalar.addItem(tritmkurumsalbilgiler);

		tritmdönemtanimlari = new TreeItem("Dönem Tanımları");
		tritmdönemtanimlari.setStyleName("gwttreeee");
		tritmSabittanimlamalar.addItem(tritmdönemtanimlari);

		tritmderstanimlari = new TreeItem("Ders Tanımları");
		tritmderstanimlari.setStyleName("gwttreeee");
		tritmSabittanimlamalar.addItem(tritmderstanimlari);

		tritmUnitetanimlari = new TreeItem("Ünite Tanımları");
		tritmUnitetanimlari.setStyleName("gwttreeee");
		tritmSabittanimlamalar.addItem(tritmUnitetanimlari);

		tritmKonutanimlari = new TreeItem("Konu Tanımları");
		tritmKonutanimlari.setStyleName("gwttreeee");
		tritmSabittanimlamalar.addItem(tritmKonutanimlari);

		tritmFizikselsiniftanimlari = new TreeItem("Fiziksel Sınıf Tanımları");
		tritmFizikselsiniftanimlari.setStyleName("gwttreeee");
		tritmSabittanimlamalar.addItem(tritmFizikselsiniftanimlari);

		tritmKurszamanitanimlari = new TreeItem("Kurs Zamanı Tanımlama");
		tritmKurszamanitanimlari.setStyleName("gwttreeee");
		tritmSabittanimlamalar.addItem(tritmKurszamanitanimlari);

		tritmsozlesmemaddeleri = new TreeItem("Sözleşme Maddeleri");
		tritmsozlesmemaddeleri.setStyleName("gwttreeee");
		tritmSabittanimlamalar.addItem(tritmsozlesmemaddeleri);

		tritmsifredegistirme = new TreeItem("Şifre Değilştirme");
		tritmsifredegistirme.setStyleName("gwttreeee");
		tritmSabittanimlamalar.addItem(tritmsifredegistirme);

		DisclosurePanel disclosurePanel_9 = new DisclosurePanel("DESTEK", false);
		disclosurePanel_9
				.setStyleName("gwt-RichTextToolbar .gwt-PushButton-up-hovering");
		disclosurePanel_9.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel_9);
		disclosurePanel_9.setSize("220px", "25px");

		Tree tritmDestek = new Tree();
		tritmDestek.addSelectionHandler(new TritmDestekSelectionHandler());
		disclosurePanel_9.setContent(tritmDestek);
		tritmDestek.setSize("122px", "30px");

		tritmDestekAlmakIstiyorum = new TreeItem("Destek Almak İstiyorum");
		tritmDestekAlmakIstiyorum.setStyleName("gwttreeee");
		tritmDestek.addItem(tritmDestekAlmakIstiyorum);

		DisclosurePanel disclosurePanel_10 = new DisclosurePanel("YETKİ", false);
		disclosurePanel_10
				.setStyleName("gwt-RichTextToolbar .gwt-PushButton-up-hovering");
		disclosurePanel_10.setAnimationEnabled(true);
		verticalPanel.add(disclosurePanel_10);
		disclosurePanel_10.setSize("220px", "30px");

		tritmYetki = new Tree();
		tritmYetki.addSelectionHandler(new TritmYetkiSelectionHandler());

		disclosurePanel_10.setContent(tritmYetki);
		tritmYetki.setSize("145px", "31px");

		tritmkullanicitanimlama = new TreeItem("Kullanıcı Tanımlama");
		tritmkullanicitanimlama.setStyleName("gwttreeee");
		tritmYetki.addItem(tritmkullanicitanimlama);
		tritmkullanicitanimlama.setWidth("130px");
		tritmkullanicitanimlama.setState(true);

		smpanMain = new SimplePanel();
		rootPanel.add(smpanMain, 280, 95);
		smpanMain.setSize("1012px", "606px");

		Label lblDer = new Label("Dershane Yönetim Sistemi");
		smpanMain.setWidget(lblDer);
		lblDer.setSize("165px", "34px");
		lblDer.setStylePrimaryName("gwt-LabelNew");
		lblDer.setStyleName("body");
	}

	private class TreeKayitIslemleriSelectionHandler implements
			SelectionHandler<TreeItem> {
		public void onSelection(SelectionEvent<TreeItem> event) {

			smpanMain.clear();

			TreeItem item = event.getSelectedItem();

			if (item == tritmDBSKayit) {

				smpanMain.add(new DBSKayit());
				scrollToTop();

			} else if (item == tritmOnKayit) {

				smpanMain.add(new OnKayit());
				scrollToTop();

			}

			else if (item == tritmKesinKayit) {
				smpanMain.add(new KesinKayit());
				scrollToTop();
			}

		}
	}

	private class TreeDersDagitimSelectionHandler implements
			SelectionHandler<TreeItem> {
		public void onSelection(SelectionEvent<TreeItem> event) {

			smpanMain.clear();

			TreeItem item = event.getSelectedItem();

			if (item == tritmDersDagitimSistemi) {
				scrollToTop();
				smpanMain.add(new DersDagitimSistemi());
			} else if (item == tritmYetkiTanimlama) {
				smpanMain.add(new YetkiTanimlama());
				scrollToTop();
			}

			else if (item == tritmSaatGirisi) {
				smpanMain.add(new SaatGirisi());
				scrollToTop();

			}

		}
	}

	private class TreeOdevTakipSelectionHandler implements
			SelectionHandler<TreeItem> {
		public void onSelection(SelectionEvent<TreeItem> event) {

			smpanMain.clear();

			TreeItem item = event.getSelectedItem();

			if (item == tritmOdevolustur) {
				smpanMain.add(new OdevOlustur());
				scrollToTop();
			}

			else if (item == tritmCevapadedibelirle) {
				smpanMain.add(new CevapAdediBelirle());
				scrollToTop();
			}

			else if (item == tritmOdevtakipUnite) {
				smpanMain.add(new OdevTakipUnite());
				scrollToTop();
			}

			else if (item == tritmatanmisodevler) {
				smpanMain.add(new AtanmisOdevler());
				scrollToTop();
			}

		}

	}

	private class TritmSinavDegerlendirmeSelectionHandler implements
			SelectionHandler<TreeItem> {
		public void onSelection(SelectionEvent<TreeItem> event) {

			smpanMain.clear();

			TreeItem item = event.getSelectedItem();

			if (item == tritmsinavtanimlama) {
				smpanMain.add(new SinavTanimlama());
				scrollToTop();
			}

			else if (item == tritmSablontanimlari) {
				smpanMain.add(new SablonTaninmlari());
				scrollToTop();
			}

		}
	}

	private class TritmmuhasebeSelectionHandler implements
			SelectionHandler<TreeItem> {
		public void onSelection(SelectionEvent<TreeItem> event) {

			smpanMain.clear();

			TreeItem item = event.getSelectedItem();

			if (item == tritmgelirvegiderler) {
				smpanMain.add(new GelirlerveGiderler());
				scrollToTop();
			}

			else if (item == tritmkasahareketleri) {
				smpanMain.add(new KasaHareketleri());
				scrollToTop();
			}

			else if (item == tritmgelirgidertanimlari) {
				smpanMain.add(new GelirGiderTanimlari());
				scrollToTop();
			}

			else if (item == tritmgelirgiderkategorileri) {
				smpanMain.add(new GelirGiderKategorileri());
				scrollToTop();

			}

			else if (item == tritmbankaekle) {

				smpanMain.add(new BankaEkle());
				scrollToTop();
			}

		}
	}

	private class TritmDonemseltanimlarSelectionHandler implements
			SelectionHandler<TreeItem> {
		public void onSelection(SelectionEvent<TreeItem> event) {
			smpanMain.clear();

			TreeItem item = event.getSelectedItem();

			if (item == tritmDBSSinavTanimla) {
				smpanMain.add(new DBSSinavTanimla());
				scrollToTop();
			}

			else if (item == tritmOgretmenTanimlari) {
				smpanMain.add(new OgretmenTanimlari());
				scrollToTop();
			}

			else if (item == tritmSinifTanimlari) {
				smpanMain.add(new SinifTanimlari());
				scrollToTop();
			}

			else if (item == tritmIndirimturu) {
				smpanMain.add(new IndirimTuru());
				scrollToTop();
			}

			else if (item == tritmHizmettanimla) {
				smpanMain.add(new HizmetTanimla());
				scrollToTop();
			}

			else if (item == tritmreferanslar) {
				smpanMain.add(new Referanslar());
				scrollToTop();
			}

			else if (item == tritmpersoneltanimlari) {
				smpanMain.add(new PersonelTanimlari());
				scrollToTop();
			}
		}

	}

	private class TritmSabittanimlamalarSelectionHandler implements
			SelectionHandler<TreeItem> {
		public void onSelection(SelectionEvent<TreeItem> event) {
			smpanMain.clear();

			TreeItem item = event.getSelectedItem();

			if (item == tritmkurumsalbilgiler) {
				smpanMain.add(new KurumsalBilgiler());
				scrollToTop();
			}

			else if (item == tritmdönemtanimlari) {
				smpanMain.add(new DonemTanimlari());
				scrollToTop();
			}

			else if (item == tritmderstanimlari) {
				smpanMain.add(new DersTanimlari());
				scrollToTop();
			}

			else if (item == tritmUnitetanimlari) {
				smpanMain.add(new UniteTanimlari());
				scrollToTop();
			}

			else if (item == tritmKonutanimlari) {
				smpanMain.add(new KonuTanimlari());
				scrollToTop();
			}

			else if (item == tritmFizikselsiniftanimlari) {
				smpanMain.add(new FizikselSinifTanimlari());
				scrollToTop();
			}

			else if (item == tritmKurszamanitanimlari) {
				smpanMain.add(new KursZamaniTanimlama());
				scrollToTop();
			}

			else if (item == tritmsifredegistirme) {
				smpanMain.add(new SifreDegistirme());
				scrollToTop();

			} else if (item == tritmsozlesmemaddeleri) {
				smpanMain.add(new SozlesmeMaddeleri());
				scrollToTop();
			}
		}

	}

	private class TritmDestekSelectionHandler implements
			SelectionHandler<TreeItem> {
		public void onSelection(SelectionEvent<TreeItem> event) {
			smpanMain.clear();

			TreeItem item = event.getSelectedItem();

			if (item == tritmDestekAlmakIstiyorum) {
				smpanMain.add(new DestekAlmakIstiyorum());
				scrollToTop();

			}
		}
	}

	private class TritmYetkiSelectionHandler implements
			SelectionHandler<TreeItem> {
		public void onSelection(SelectionEvent<TreeItem> event) {
			smpanMain.clear();

			TreeItem item = event.getSelectedItem();

			if (item == tritmkullanicitanimlama) {
				smpanMain.add(new KullaniciTanimlama());
				scrollToTop();
			}
		}
	}

	private class LblNewLabelClickHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

		}
	}

	public static native void scrollToTop() /*-{
											$wnd.scroll(0, 0);
											}-*/;
}
