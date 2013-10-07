package co.einsteinium.wikilinklib.plg;

import java.util.ArrayList;
import java.util.HashMap;

import co.einsteinium.wikilink.api.Plugin;

public class PluginMinecraftWiki implements Plugin
{
    @Override
    public String getWikiKey()
    {
        // TODO Auto-generated method stub
        return "001.01";
    }

    @Override
    public String getWikiDisplay()
    {
        // TODO Auto-generated method stub
        return "Minecraft Wiki";
    }

    @Override
    public String getModID()
    {
        // TODO Auto-generated method stub
        return "Minecraft";
    }

    @Override
    public String getWikiDomain()
    {
        // TODO Auto-generated method stub
        return "www.minecraftwiki.net";
    }

    @Override
    public Software getWikiSoftware()
    {
        // TODO Auto-generated method stub
        return Software.MEDIAWIKI;
    }

    @Override
    public String getWikiLocalization()
    {
        // TODO Auto-generated method stub
        return "ALL";
    }

	@Override
	public HashMap<Integer, String> getItemStackVideos()
	{
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
			map.put(159, "cvi5kjjIcg0");		
			map.put(170, "ix5P7uPc79s");
			map.put(172, "I2-5aaqRJHA");
			map.put(173, "DmnNJMsxNEE");
			
		return map;
	}
	
	@Override
	public HashMap<Integer, String> getItemStackDisplay()
	{
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
			map.put(159, "Item Spotlight (mcspotlights)");
			map.put(170, "Item Spotlight (mcspotlights)");
			map.put(172, "Item Spotlight (mcspotlights)");
			map.put(173, "Item Spotlight (mcspotlights)");
		
		return map;
	}
}
