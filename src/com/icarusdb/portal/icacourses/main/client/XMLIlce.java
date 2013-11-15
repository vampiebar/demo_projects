package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLIlce {

	interface VubReader extends XmlReader<XMLIlce> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("il_id")
	String il_id;

	@Path("ilce_id")
	String ilce_id;

	@Path("ilce_adi")
	String ilce_adi;

}
