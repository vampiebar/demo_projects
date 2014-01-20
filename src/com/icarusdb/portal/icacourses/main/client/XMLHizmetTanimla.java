package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLHizmetTanimla {

	interface VubReader extends XmlReader<XMLHizmetTanimla> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("hizmet_adi")
	String hizmet_adi;

	@Path("hizmet_turu")
	String hizmet_turu;

	@Path("birim_fiyati")
	String birim_fiyati;

	@Path("guzergah")
	String guzergah;

}
