package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLFizikselSinifTanimlari {

	interface VubReader extends XmlReader<XMLFizikselSinifTanimlari> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("fiziksel_sinif_adi")
	String fiziksel_sinif_adi;
}
