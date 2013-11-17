package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLAtanmisODevler {
	interface VubReader extends XmlReader<XMLAtanmisODevler> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("baslangic_tarihi")
	String baslangic_tarihi;

	@Path("bitis_tarihi")
	String bitis_tarihi;

}
