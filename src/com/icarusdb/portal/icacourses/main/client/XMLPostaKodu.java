package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLPostaKodu {

	interface VubReader extends XmlReader<XMLPostaKodu> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("il")
	String il;

	@Path("ilce")
	String ilce;

	@Path("semt_bucak_belde")
	String semt_bucak_belde;

}
