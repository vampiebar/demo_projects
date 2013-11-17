package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLBankaEkle {

	interface VubReader extends XmlReader<XMLBankaEkle> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("banka_adi")
	String banka_adi;

	@Path("banka_sube")
	String banka_sube;

	@Path("hesap_no")
	String hesap_no;

	@Path("iban_no")
	String iban_no;

	@Path("bankanin_ödeme_sekli")
	String bankanin_ödeme_sekli;

	@Path("vade_tarihi")
	String vade_tarihi;
}
