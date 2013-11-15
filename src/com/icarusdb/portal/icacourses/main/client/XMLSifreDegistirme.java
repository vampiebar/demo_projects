package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLSifreDegistirme {

	interface VubReader extends XmlReader<XMLSifreDegistirme> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("eski_sifre")
	String eski_sifre;

	@Path("yeni_sifre")
	String yeni_sifre;

	@Path("tekrar_yeni_sifre")
	String tekrar_yeni_sifre;

}
