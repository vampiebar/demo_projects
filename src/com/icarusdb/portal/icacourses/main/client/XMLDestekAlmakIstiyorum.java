package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLDestekAlmakIstiyorum {

	interface VubReader extends XmlReader<XMLDestekAlmakIstiyorum> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("konu")
	String konu;

	@Path("bolum")
	String bolum;

	@Path("mesajiniz")
	String mesajiniz;
}