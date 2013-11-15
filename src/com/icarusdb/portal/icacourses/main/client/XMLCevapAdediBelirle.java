package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLCevapAdediBelirle {

	interface VubReader extends XmlReader<XMLCevapAdediBelirle> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("egitim_turu")
	String egitim_turu;

	@Path("cevap_sayisi")
	String cevap_sayisi;

}
