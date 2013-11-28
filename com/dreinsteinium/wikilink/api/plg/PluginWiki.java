package com.dreinsteinium.wikilink.api.plg;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.plg.Plugin;

/** PluginWiki
 *  **/
public interface PluginWiki extends Plugin 
{
	/** getModId<br>
	 *  Return an ArrayList of the @modId variables
	 *  for this specific wiki. Just create a brand
	 *  new ArrayList, add the Strings and return it.
	 *  **/
	public ArrayList<String> getModId();
	
	/** getWikiName<br>
	 *  Return the "display name" of your wiki. This
	 *  is what shows up in the WikiLink Menu when a
	 *  player searches an item from your mod. 
	 *  <br><br>
	 *  <b>Example: "Minecraft Wiki"</b>
	 *  **/
	public String getWikiName();
	
	/** getSoftwareType<br>
	 *  Return a value from the {@link Software} enum
	 *  based on what type of software your wiki is.
	 *  If you don't know what software type you use
	 *  then you should probably just stop here and call Dr. E. 
	 *  **/
	public Software getSoftwareType();
}
