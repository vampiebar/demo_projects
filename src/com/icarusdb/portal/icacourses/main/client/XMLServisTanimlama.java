package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLServisTanimlama {

	interface VubReader extends XmlReader<XMLServisTanimlama> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("kodu")
	String kodu;

	@Path("guzergah")
	String guzergah;

	@Path("servis_ucreti")
	String servis_ucreti;

	@Path("sofor_adi")
	String sofor_adi;

	@Path("soforun_telefonu")
	String soforun_telefonu;

	@Path("arac_sahibi")
	String arac_sahibi;

	@Path("arac_sahibinin_telefonu")
	String arac_sahibinin_telefonu;

	@Path("arac_plakasi")
	String arac_plakasi;

	@Path("kapasitesi")
	String kapasitesi;

	@Path("yolcu_sayisi")
	String yolcu_sayisi;

}
