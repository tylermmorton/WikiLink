package co.einsteinium.wikilinklib.plg.google;

import co.einsteinium.wikilink.api.IGoogleLink;

public class WLGoogleBibliocraft implements IGoogleLink {

	@Override
	public String getModID()
	{
		return "BiblioCraft";
	}

	@Override
	public String getGoogleDomain() 
	{
		return "www.bibliocraftmod.com";
	}

	@Override
	public String getGoogleDisplay() 
	{
		return "Bibliocraft Website";
	}

}
