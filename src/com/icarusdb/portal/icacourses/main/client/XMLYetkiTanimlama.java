package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLYetkiTanimlama {

	interface VubReader extends XmlReader<XMLYetkiTanimlama> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("ders_silme_zamani")
	String ders_silme_zamani;

	@Path("en_erken_rezervasyon")
	String en_erken_rezervasyon;

	@Path("en_gec_rezervasyon")
	String en_gec_rezervasyon;

	@Path("etut_maksimum_kisi_sayisi")
	String etut_maksimum_kisi_sayisi;

	@Path("gunluk_saat_kotasi")
	String gunluk_saat_kotasi;

	@Path("haftalik_saat_kotasi")
	String haftalik_saat_kotasi;

	@Path("aylik_saat_kotasi")
	String aylik_saat_kotasi;

}
