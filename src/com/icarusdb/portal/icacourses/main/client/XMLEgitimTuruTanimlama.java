package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLEgitimTuruTanimlama {

	interface VubReader extends XmlReader<XMLEgitimTuruTanimlama> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("egitim_turu_adi")
	String egitim_turu_adi;

	@Path("alan_adi")
	String alan_adi;

}
