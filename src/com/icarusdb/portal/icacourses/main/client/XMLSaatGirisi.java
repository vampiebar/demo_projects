package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLSaatGirisi {

	interface VubReader extends XmlReader<XMLSaatGirisi> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("gun")
	String gun;

	@Path("aciklama")
	String aciklama;

	@Path("baslangic_saat")
	String baslangic_saat;

	@Path("baslangic_dakika")
	String baslangic_dakika;

	@Path("bitis_saat")
	String bitis_saat;

	@Path("bitis_dakika")
	String bitis_dakika;

}