package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLSinavTanimlama {

	interface VubReader extends XmlReader<XMLSinavTanimlama> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("sinav_no")
	String sinav_no;

	@Path("sinav_adi")
	String sinav_adi;

	@Path("tarih")
	String tarih;

	@Path("son_kitapcik_no")
	String son_kitapcik_no;

	@Path("sablon_seciniz")
	String sablon_seciniz;

	@Path("saat")
	String saat;

	@Path("dakika")
	String dakika;

}
