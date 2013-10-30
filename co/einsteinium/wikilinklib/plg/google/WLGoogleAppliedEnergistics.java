package co.einsteinium.wikilinklib.plg.google;

import co.einsteinium.wikilink.api.IGoogleLink;

public class WLGoogleAppliedEnergistics implements IGoogleLink
{

	@Override
	public String getModID()
	{
		return "AppliedEnergistics";
	}

	@Override
	public String getGoogleDomain()
	{
		return "ae-mod.info";
	}

	@Override
	public String getGoogleDisplay()
	{
		return "Applied Energistics Website";
	}

}
