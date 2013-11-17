package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLOgretmenTanimlari {

	interface VubReader extends XmlReader<XMLOgretmenTanimlari> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("tc_kimlik_no")
	String tc_kimlik_no;

	@Path("adi_soyadi")
	String adi_soyadi;

	@Path("girdigi_ders_bilgisi")
	String girdigi_ders_bilgisi;

	@Path("egitim_turu")
	String egitim_turu;

	@Path("brans")
	String brans;

	@Path("girdigi_dersler")
	String girdigi_dersler;

	@Path("ucreti")
	String ucreti;

	@Path("ev_telefonu")
	String ev_telefonu;

	@Path("cep_telefonu")
	String cep_telefonu;

	@Path("cep_telefonu_2")
	String cep_telefonu_2;

	@Path("email")
	String email;

	@Path("sigorta_gun_sayisi")
	String sigorta_gun_sayisi;

	@Path("ders_programini_gorsun")
	String ders_programini_gorsun;

	@Path("durum")
	String durum;

}
