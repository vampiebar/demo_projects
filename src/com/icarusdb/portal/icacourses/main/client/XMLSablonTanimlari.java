package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLSablonTanimlari {

	interface VubReader extends XmlReader<XMLSablonTanimlari> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("sablon_adi")
	String sablon_adi;

	@Path("erkek")
	String erkek;

	@Path("kiz")
	String kiz;

	@Path("sayisal")
	String sayisal;

	@Path("sozel")
	String sozel;

	@Path("esit_a")
	String esit_a;

	@Path("dil")
	String dil;

	@Path("alani_yok")
	String alani_yok;

	@Path("alan")
	String alan;

	@Path("deger")
	String deger;

	@Path("lys_1")
	String lys_1;

	@Path("lys_2")
	String lys_2;

	@Path("lys_3")
	String lys_3;

	@Path("lys_4")
	String lys_4;

	@Path("lys_5")
	String lys_5;

	@Path("sinav_turu")
	String sinav_turu;
}
