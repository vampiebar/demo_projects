package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLPostaKoduMahalle {

	interface VubReader extends XmlReader<XMLPostaKoduMahalle> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("mahalle")
	String mahalle;

	@Path("posta_kodu")
	String posta_kodu;

}
