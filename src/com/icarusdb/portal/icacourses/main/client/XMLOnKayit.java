package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLOnKayit {

	interface VubReader extends XmlReader<XMLOnKayit> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("adi")
	String adi;

	@Path("soyadi")
	String soyadi;

	@Path("tc_kimlik_no")
	String tc_kimlik_no;

	@Path("cinsiyet")
	String cinsiyet;

	@Path("medeni_hali")
	String medeni_hali;

	@Path("dogum_tarihi")
	String dogum_tarihi;

	@Path("ev_telefonu")
	String ev_telefonu;

	@Path("cep_telefonu")
	String cep_telefonu;

	@Path("email")
	String email;

	@Path("ogrenci_bilgileri_ulke")
	String ogrenci_bilgileri_ulke;

	@Path("ogrenci_bilgileri_il")
	String ogrenci_bilgileri_il;

	@Path("ogrenci_bilgileri_ilce")
	String ogrenci_bilgileri_ilce;

	@Path("okul")
	String okul;

	@Path("ogrenci_bilgileri_sinif")
	String ogrenci_bilgileri_sinif;

	@Path("egitim_turu")
	String egitim_turu;

	@Path("alan")
	String alan;

	@Path("kurs_zamani")
	String kurs_zamani;

	@Path("gorusme_sinif")
	String gorusme_sinif;

	@Path("kurs_indirim_fiyati")
	String kurs_indirim_fiyati;

	@Path("indirim_turu")
	String indirim_turu;

	@Path("indirim_miktari")
	String indirim_miktari;

	@Path("referans")
	String referans;

	@Path("gorusme_tarihi")
	String gorusme_tarihi;

	@Path("gorusme_tipi")
	String gorusme_tipi;

	@Path("gorusme_sonucu")
	String gorusme_sonucu;

	@Path("gorusme_yuzdesi")
	String gorusme_yuzdesi;

	@Path("aciklama")
	String aciklama;

	@Path("seri_no")
	String seri_no;

	@Path("cuzdan_no")
	String cuzdan_no;

	@Path("ogrenci_kimlik_bilgileri_ulke")
	String ogrenci_kimlik_bilgileri_ulke;

	@Path("ogrenci_kimlik_bilgileri_il")
	String ogrenci_kimlik_bilgileri_il;

	@Path("ogrenci_kimlik_bilgileri_ilce")
	String ogrenci_kimlik_bilgileri_ilce;

	@Path("mahalle_koy")
	String mahalle_koy;

	@Path("cilt_no")
	String cilt_no;

	@Path("aile_sira_no")
	String aile_sira_no;

	@Path("sira_no")
	String sira_no;

	@Path("verildigi_yer")
	String verildigi_yer;

	@Path("verilis_nedeni")
	String verilis_nedeni;

	@Path("kayit_no")
	String kayit_no;

	@Path("verilis_tarihi")
	String verilis_tarihi;

	@Path("adres_bilgileri_ulke")
	String adres_bilgileri_ulke;

	@Path("adres_bilgileri_il")
	String adres_bilgileri_il;

	@Path("adres_bilgileri_ilce")
	String adres_bilgileri_ilce;

	@Path("semt")
	String semt;

	@Path("mahalle")
	String mahalle;

	@Path("sokak_ve_no")
	String sokak_ve_no;

	@Path("kesin_kayit_mi")
	String kesin_kayit_mi;

}
