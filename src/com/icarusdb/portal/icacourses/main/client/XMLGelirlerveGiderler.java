package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLGelirlerveGiderler {

	interface VubReader extends XmlReader<XMLGelirlerveGiderler> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("islem_tipi")
	String islem_tipi;

	@Path("kategoriler")
	String kategoriler;

	@Path("gelirler")
	String gelirler;

	@Path("odeme_turu")
	String odeme_turu;

	@Path("banka")
	String banka;

	@Path("cek")
	String cek;

	@Path("vade_tarihi")
	String vade_tarihi;

	@Path("miktar")
	String miktar;

	@Path("tarih")
	String tarih;

	@Path("aciklama")
	String aciklama;

}
