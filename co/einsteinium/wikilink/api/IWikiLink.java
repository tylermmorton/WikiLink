package co.einsteinium.wikilink.api;

import java.util.ArrayList;

import co.einsteinium.wikilink.api.Software;

public interface IWikiLink extends Plugin
{
	/** This is the ArrayList of @ModId objects
	 *  for the wiki. 
	 *  <br><br>
	 *  Note: Create a new ArrayList<String> and
	 *  add the @ModIds, then return the list.
	 *  **/
	public ArrayList<String> getModID();
	
	/** This is the domain, of the wiki in
	 *  question.<b> Do not include any web
	 *  protocol like http:// in the domain.</b>
	 *  
	 *  <pre>wiki.feed-the-beast.com</pre>
	 *  **/
	public String getWikiDomain();
	
	/** This is the "display" String of the
	 *  wiki in question. 
	 *  <pre>Feed The Beast Wiki</pre> 
	 *  **/
	public String getWikiDisplay();
	
	/** This is the "Sofware" type of the
	 *  wiki in question.. Return a value
	 *  from the Software enum class from
	 *  the API.
	 *  
	 *  <pre>return Software.WIKIA</pre>
	 *  
	 *  If the software does not exist in
	 *  the enum, return Software.CUSTOM
	 *  **/
	public Software getWikiSoftware();
	
	/** This method is only runs if the
	 *  Software returns Software.CUSTOM
	 *  
	 *  Return the search extension for
	 *  your software type.
	 *  
	 *  <pre>/index.php?search=</pre>
	 *  **/
	public String getCustomSearchString();
}
