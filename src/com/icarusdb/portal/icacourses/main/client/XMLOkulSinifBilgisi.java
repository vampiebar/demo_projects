package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLOkulSinifBilgisi {

	interface VubReader extends XmlReader<XMLOkulSinifBilgisi> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("okul_durumu")
	String okul_durumu;

}
