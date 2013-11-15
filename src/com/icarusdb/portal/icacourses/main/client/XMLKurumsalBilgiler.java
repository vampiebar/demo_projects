package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLKurumsalBilgiler {

	interface VubReader extends XmlReader<XMLKurumsalBilgiler> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("sube_resmi_adi")
	String sube_resmi_adi;

	@Path("sirket_adi")
	String sirket_adi;

	@Path("vergi_dairesi")
	String vergi_dairesi;

	@Path("vergi_no")
	String vergi_no;

	@Path("yönetici_adi")
	String yönetici_adi;

	@Path("yonetici_tel")
	String yonetici_tel;

	@Path("mudur")
	String mudur;

	@Path("mudur_yardimcisi")
	String mudur_yardimcisi;

	@Path("logo")
	String logo;

	@Path("ulke")
	String ulke;

	@Path("il")
	String il;

	@Path("ilce")
	String ilce;

	@Path("semt")
	String semt;

	@Path("mahalle_koy")
	String mahalle_koy;

	@Path("telefon")
	String telefon;

	@Path("faks")
	String faks;

	@Path("email")
	String email;

	@Path("adres")
	String adres;

	@Path("sube_kisa_adi")
	String sube_kisa_adi;

}
