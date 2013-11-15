package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLIl {

	interface VubReader extends XmlReader<XMLIl> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("il_id")
	String il_id;

	@Path("il_adi")
	String il_adi;

}
