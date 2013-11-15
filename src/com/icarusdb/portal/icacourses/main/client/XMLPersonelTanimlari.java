package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLPersonelTanimlari {

	interface VubReader extends XmlReader<XMLPersonelTanimlari> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("adi_soyadi")
	String adi_soyadi;

	@Path("gorevi")
	String gorevi;

	@Path("ise_giris_tarihi")
	String ise_giris_tarihi;

	@Path("ucreti")
	String ucreti;

	@Path("telefonu_1")
	String telefonu_1;

	@Path("telefonu_2")
	String telefonu_2;
}
