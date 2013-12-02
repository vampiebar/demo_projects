package com.icarusdb.portal.icacourses.main.client;

import name.pehl.piriti.commons.client.Path;
import name.pehl.piriti.xml.client.XmlReader;

import com.google.gwt.core.client.GWT;

public class XMLOdemeler {
	interface VubReader extends XmlReader<XMLOdemeler> {
	}

	public static final VubReader XML = GWT.create(VubReader.class);

	@Path("id")
	String id;

	@Path("indirimli_tutar")
	String indirimli_tutar;

	@Path("hizmetlerin_toplami")
	String hizmetlerin_toplami;

	@Path("toplam_tutar")
	String toplam_tutar;

	@Path("pesinat_odeme_turu")
	String pesinat_odeme_turu;

	@Path("aciklama")
	String aciklama;

	@Path("pesinatin_yatacagi_banka")
	String pesinatin_yatacagi_banka;

	@Path("pesinat_miktari")
	String pesinat_miktari;

	@Path("taksitlerin_toplami")
	String taksitlerin_toplami;

	@Path("sozlesme_disi_kalan")
	String sozlesme_disi_kalan;

	@Path("taksitin_odeme_turu")
	String taksitin_odeme_turu;

	@Path("taksit_aciklama")
	String taksit_aciklama;

	@Path("taksitin_yatacagi_banka")
	String taksitin_yatacagi_banka;

	@Path("taksit_sayisi")
	String taksit_sayisi;

	@Path("takside_baslanacak_gun")
	String takside_baslanacak_gun;

}
