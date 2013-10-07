package co.einsteinium.wikilink.api;

import java.util.HashMap;

/** Plugin Interface
 *
 * @since 1.6.2-015
 * @author ScottKillen, DrEinsteinium
 *
 */
public interface Plugin
{
	public enum Software 
	{
		WIKIA, MEDIAWIKI, DOKUWIKI, PHPWIKI, WIKIDOT, YOUTUBE, VIMEO, CUSTOM, WIKISPACES
	}
	
    /* For WIKI */
    
    /** This is the "code" to access your wiki.
     *  /wiki <key> <query>
     *
     *  @since 1.6.2-010
     */
    public String getWikiKey();

    /** This is the english name of your wiki.
     *  "Example Wiki"
     *
     *  @since 1.6.2-010
     */
    public String getWikiDisplay();

    /** Please enter the @modid value here.
     *
     *  @since 1.6.2-011
     */
    public String getModID();

    /** This is the domain name of your wiki.
     *  "wiki.example.com"
     *
     *  Please do not add any slashes!
     *
     *  @since 1.6.2-010
     */

    public String getWikiDomain();

    /** This is the software name of your wiki.
     *  "MEDIAWIKI","DOKUWIKI","WIKIA","WIKISPACES","PHPWIKI"
     *
     *
     *  You can create a custom one, just follow the
     *  instructions on the forum post.
     *
     *  @since 1.6.2-010
     */
    public Software getWikiSoftware();

    /** This is the language of your wiki.
     *
     * ex: en_US, es_ES
     *
     * This is extremely important. This is how WikiLink
     * knows what wiki to search on if you have multiple
     * different translations.
     *
     */
    public String getWikiLocalization();
    
    /* For YOUTUBE */
    
    public HashMap<Integer, String> getItemStackVideos();
    
    public HashMap<Integer, String> getItemStackDisplay();
} 