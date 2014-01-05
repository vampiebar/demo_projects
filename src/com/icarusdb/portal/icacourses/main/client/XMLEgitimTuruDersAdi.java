package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLEgitimTuruDersAdi {

	interface VubReader extends XmlReader<XMLEgitimTuruDersAdi> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("sinif_adi")
	String sinif_adi;

	@Path("ders_adi")
	String ders_adi;

}
