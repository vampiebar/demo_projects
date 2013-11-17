package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLOdevTakipUnite {

	interface VubReader extends XmlReader<XMLOdevTakipUnite> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("egitim_turu")
	String egitim_turu;

	@Path("alan")
	String alan;

	@Path("ders")
	String ders;

	@Path("unite")
	String unite;

}
