package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLIndirimTuru {

	interface VubReader extends XmlReader<XMLIndirimTuru> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("indirim_turu")
	String indirim_turu;

	@Path("indirim_sekli")
	String indirim_sekli;

	@Path("indirim_miktari")
	String indirim_miktari;

}
