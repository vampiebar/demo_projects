package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLDonemTanimlari {

	interface VubReader extends XmlReader<XMLDonemTanimlari> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("donem_adi")
	String donem_adi;

	@Path("baslangic_tarihi")
	String baslangic_tarihi;

	@Path("bitis_tarihi")
	String bitis_tarihi;

	@Path("varsayilan_donem")
	String varsayilan_donem;

}
