package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLKullaniciTanimlama {

	interface VubReader extends XmlReader<XMLKullaniciTanimlama> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("kullanici_kodu")
	String kullanici_kodu;

	@Path("adi")
	String adi;

	@Path("soyadi")
	String soyadi;

	@Path("sifre")
	String sifre;

	@Path("sifre_tekrar")
	String sifre_tekrar;
}
