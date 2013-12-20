package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLHizmetler {

	interface VubReader extends XmlReader<XMLHizmetler> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("ogrenci_numarasi")
	String ogrenci_numarasi;

	@Path("id")
	String id;

	@Path("hizmet_turu")
	String hizmet_turu;

	@Path("hizmet_adi")
	String hizmet_adi;

	@Path("miktar")
	String miktar;

	@Path("hizmetler_indirim_turu")
	String hizmetler_indirim_turu;

	@Path("hizmetler_indirim_miktari")
	String hizmetler_indirim_miktari;

}
