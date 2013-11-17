package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLSinifTanimlari {

	interface VubReader extends XmlReader<XMLSinifTanimlari> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("sinif_adi")
	String sinif_adi;

	@Path("fiziksel_sinif_adi")
	String fiziksel_sinif_adi;

	@Path("kurs_zamani")
	String kurs_zamani;

	@Path("egitim_turu")
	String egitim_turu;

	@Path("alan")
	String alan;

	@Path("danisman_ogretmen")
	String danisman_ogretmen;

	@Path("sinif_kontenjani")
	String sinif_kontenjani;

	@Path("baslangic_numarasi")
	String baslangic_numarasi;

	@Path("bitis_numarasi")
	String bitis_numarasi;

	@Path("ozel_ders_sayisi")
	String ozel_ders_sayisi;

	@Path("fiyati")
	String fiyati;

	@Path("baslangic_tarihi")
	String baslangic_tarihi;

	@Path("bitis_tarihi")
	String bitis_tarihi;

}
