package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLKesinKayit {

	interface VubReader extends XmlReader<XMLKesinKayit> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("tc_kimlik_no")
	String tc_kimlik_no;

	@Path("tc_kimlik_no_kullanma")
	String tc_kimlik_no_kullanma;

	@Path("adi")
	String adi;

	@Path("soyadi")
	String soyadi;
}