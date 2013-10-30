package co.einsteinium.wikilink.plg;

import java.util.HashMap;

import co.einsteinium.wikilink.api.Software;

/** The Registrar for all Plugin Information
 *  @author DrEinsteinium
 */
public class PluginRegistry
{ 
	 private static final HashMap<String, String> wikiDomainMap = new HashMap<String, String>();
	 private static final HashMap<String, String> wikiDisplayMap = new HashMap<String, String>();
	 private static final HashMap<String, Software> wikiSoftwareMap = new HashMap<String, Software>();
	 private static final HashMap<String, String> wikiCustomSoftwareType = new HashMap<String, String>();
	 
	 private static final HashMap<Integer, String> itemSpotlightMap = new HashMap<Integer, String>();
	 
	 private static final HashMap<String, String> googleDomainMap = new HashMap<String, String>();
	 private static final HashMap<String, String> googleDisplayMap = new HashMap<String, String>();
	 
	 /** Registers a Wiki to the Wiki map sets with the ModId as the keys.
	  *  @param modId    : The ModId of the Mod's Wiki
	  *  @param domain   : The Domain of the Mod's Wiki
	  *  @param display  : The Name/Display of the Mod's Wiki
	  *  @param software : The Software Type of the Mod's Wiki
	  */
	 public static void registerWikiLink(String modId, String domain, String display, Software software, String customSoftware)
	 {
		 if(customSoftware == null || customSoftware.isEmpty())
		 {
			 customSoftware = "404Error"; 
		 }
		 
		 wikiDomainMap.put(modId, domain);
		 wikiDisplayMap.put(modId, display);
		 wikiSoftwareMap.put(modId, software);
		 wikiCustomSoftwareType.put(modId, customSoftware);
	 }	  
	 
	 public static void registerGoogleSite(String modId, String domain, String display)
	 {
		 googleDomainMap.put(modId, domain);
		 googleDisplayMap.put(modId, display);
	 }
	 
	 /** Registers a single Youtube Video to the video mapping.
	  *  @param itemID    : The ItemID of the ItemStack
	  *  @param watchCode : The /watch code of the video
	  */
	 public static void registerYoutubeVideo(int itemID, String watchCode)
	 {
		 itemSpotlightMap.put(itemID, watchCode);
	 }
	 
	 /** Registers a HashMap of Youtube Videos to the video mapping.
	  *  @param map : The map to be registered
	  */
	 public static void registerYoutubeVideo(HashMap<Integer, String> map)
	 {
		 itemSpotlightMap.putAll(map);
	 }
	 
	 /**
	  *  @return itemSpotlightMap
	  */
	 public static HashMap<Integer, String> getItemSpotlightMap()
	 {
		 return itemSpotlightMap;
	 }
	 
	 /**
	  *  @return wikiDomainMap
	  */
	 public static HashMap<String, String> getWikiDomainMap()
	 {
		 return wikiDomainMap;
	 }
	 
	 /**
	  *  @return wikiDisplayMap
	  */
	 public static HashMap<String, String> getWikiDisplayMap()
	 {
		 return wikiDisplayMap;
	 }
	 
	 /**
	  *  @return wikiSoftwareMap
	  */
	 public static HashMap<String, Software> getWikiSoftwareMap()
	 {
		 return wikiSoftwareMap;
	 }
	 
	 /**
	  * @return wikiCustomSoftwareType
	  */
	 public static HashMap<String, String> getCustomWikiSoftwareMap()
	 {
		 return wikiCustomSoftwareType;
	 }
	 
	 /**
	  * @return googleDomainMap
	  */
	 public static HashMap<String, String> getGoogleDomainMap()
	 {
		 return googleDomainMap;
	 }	 
	 
	 /**
	  * @return googleDisplayMap
	  */
	 public static HashMap<String, String> getGoogleDisplayMap()
	 {
		 return googleDisplayMap;
	 }
	 

}
