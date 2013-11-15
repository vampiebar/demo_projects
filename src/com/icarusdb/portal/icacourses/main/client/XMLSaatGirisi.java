package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLSaatGirisi {

	interface VubReader extends XmlReader<XMLSaatGirisi> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("baslangic_saati")
	String baslangic_saati;

	@Path("bitis_saati")
	String bitis_saati;

	@Path("gun")
	String gun;

	@Path("aciklama")
	String aciklama;

}