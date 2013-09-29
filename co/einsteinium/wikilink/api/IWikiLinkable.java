package co.einsteinium.wikilink.api;

import java.util.ArrayList;
import net.minecraft.item.ItemStack;

public interface IWikiLinkable 
{
	public enum Software 
	{
		WIKIA, MEDIAWIKI, DOKUWIKI, PHPWIKI, WIKIDOT, YOUTUBE, VIMEO, CUSTOM
	}
	
	/** This method returns of the @ModId of the mod that is adding the plugin.
	 *  This is used as the unique identifier for every WikiLink plugin.
	 *  
	 *  @return String <@ModId>
	 */
	public String getWikiModId();
	
	/** This method returns the display name of the wiki. Return the string that
	 *  will show up in all tooltips and GUIs.
	 *  
	 *  @return String "Your Display Name"
	 */
	public String getWikiDisplayName();
	
	/** This method returns the URL of the wiki for this plugin. Do not add any
	 *  slashes or backslashes after the string, nor "http://" before the string. 
	 *  WikiLink does this automatically!
	 * 
	 *  @return String "YourUrl.com"
	 */
	public String getWikiDomainAddress();
	
	/** This method returns the software type of the wiki for this plugin. This
	 *  is an enum object, and all of the types can be found in the API file that
	 *  your plugin is implementing. 
	 * 
	 *  @return Software YourSoftwareType
	 */
	public Software getWikiDomainSoftware();
	
	/** This method returns a custom extension for the wiki of this plugin. This
	 *  is only usable if the return value of getWikiDomainSoftware is "CUSTOM"
	 * 
	 *  @return String "/search/q="
	 */
	public String getWikiDomainCustomExtension();
	
	/**  This method returns a special link
	 * 
	 *  @return
	 */	
	public ArrayList<String> getSpecialItemStackLinks();
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<ItemStack> getSpecialItemStackCases();
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Software> getSpecialItemStackCaseTypes();
}
