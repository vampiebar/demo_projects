package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLGelirGiderKategorileri {

	interface VubReader extends XmlReader<XMLGelirGiderKategorileri> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("kategori_adi")
	String kategori_adi;
}