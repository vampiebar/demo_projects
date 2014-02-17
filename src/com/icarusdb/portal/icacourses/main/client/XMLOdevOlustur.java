package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLOdevOlustur {

	interface VubReader extends XmlReader<XMLOdevOlustur> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("odev_adi")
	String odev_adi;

	@Path("egitim_turu")
	String egitim_turu;

	@Path("alan")
	String alan;

	@Path("ders")
	String ders;

	@Path("unite")
	String unite;

	@Path("soru_sayisi")
	String soru_sayisi;

	@Path("son_harf")
	String son_harf;

	@Path("cevaplar")
	String cevaplar;

}
