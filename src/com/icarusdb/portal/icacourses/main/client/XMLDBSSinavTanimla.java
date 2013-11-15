package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLDBSSinavTanimla {

	interface VubReader extends XmlReader<XMLDBSSinavTanimla> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("okul_adi")
	String okul_adi;

	@Path("alan_bilgisi")
	String alan_bilgisi;

	@Path("sinav_tarihi")
	String sinav_tarihi;

	@Path("kota")
	String kota;

	@Path("bina_sekli")
	String bina_sekli;

	@Path("adres")
	String adres;
}
