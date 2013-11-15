package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLVeliEkle {
	interface VubReader extends XmlReader<XMLVeliEkle> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("veli_bilgileri_adi")
	String veli_bilgileri_adi;

	@Path("veli_bilgileri_soyadi")
	String veli_bilgileri_soyadi;

	@Path("veli_bilgileri_tc_kimlik_no")
	Number veli_bilgileri_tc_kimlik_no;

	@Path("yakinlik_durumu")
	String yakinlik_durumu;

	@Path("odeme_sorumlusu")
	String odeme_sorumlusu;

	@Path("cep_tel")
	Number cep_tel;

	@Path("ev_tel")
	String ev_tel;

	@Path("is_tel")
	String is_tel;

	@Path("e_mail")
	String e_mail;

	@Path("firma")
	String firma;

	@Path("sektor")
	String sektor;

	@Path("unvani")
	String unvani;

	@Path("gorevi")
	String gorevi;

	@Path("veli_bilgileri_adres")
	String veli_bilgileri_adres;

}
