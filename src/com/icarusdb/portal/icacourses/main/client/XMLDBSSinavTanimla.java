package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLDBSSinavTanimla {

	interface VubReader extends XmlReader<XMLDBSSinavTanimla> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("okul_adi")
	String okul_adi;

	@Path("alan_bilgisi")
	String alan_bilgisi;

	@Path("sinav_tarihi")
	String sinav_tarihi;

	@Path("kota")
	String kota;

	@Path("sinav_yeri")
	String sinav_yeri;

	@Path("ulke")
	String ulke;

	@Path("il")
	String il;

	@Path("ilce")
	String ilce;

	@Path("semt")
	String semt;

	@Path("mahalle_koy")
	String mahalle_koy;

	@Path("adres")
	String adres;

	@Path("saat")
	String saat;

	@Path("dakika")
	String dakika;
}
