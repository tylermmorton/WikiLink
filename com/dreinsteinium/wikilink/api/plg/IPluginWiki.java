package com.dreinsteinium.wikilink.api.plg;

import java.util.ArrayList;

import com.dreinsteinium.wikilink.api.Software;
import com.dreinsteinium.wikilink.plg.Plugin;

/** <b>IPluginWiki</b><br>
 *  IPluginWiki is the interface class that should be implemented when
 *  you want to register a new wiki into WikiLink<br>
 *  In order to avoid dependences WikiLink uses a system designed only
 *  to load plugins that implement interfaces like this. Thanks to the
 *  author of the system, ScottKillen, for this.
 *  @since  11/30/2013
 *  @author DrEinsteinium
 *  **/
public interface IPluginWiki extends Plugin
{    
    /** <b>getIdentification</b><br>
     *  getIdentification should return an ArrayList of @ModId strings
     *  that would be associated with this wiki. You can just create a
     *  new ArrayList<String> object and add the @ModId strings needed
     *  by using ArrayList.add("String").<br><br>
     *  <b>Any items coming from this @ModId will display this wiki as
     *  a search option.</b>
     *  **/
    public ArrayList<String> getIdentification();
    
    /** <b>getDomainName</b><br>
     * getDomainName should return the website URL as a String for the
     * wiki. This should not include any web protocol such as HTTP and
     * HTTPS.
     * @Example www.example.com || wiki.feed-the-beast.com
     *  **/    
    public String getDomainName();
    
    /** <b>getDisplayName</b><br>
     *  getDisplayName should return the String that will be displayed
     *  in the GUI whenever this wiki is offered as a search option.
     *  @example "Example Wiki" || "Feed the Beast Wiki"
     *  **/
    public String getDisplayName();
    
    /** <b>getSoftwareType</b><br>
     *  getSoftwareType should return an enum from {@link Software} that
     *  corresponds with the software type of your wiki.<br> If you dont
     *  know what software type your wiki is please tweet @DrEinsteinium
     *  or post in the Minecraft Forum thread.
     *  @example Software.WIKIA || Software.MEDIAWIKI
     *  **/
    public Software getSoftwareType();
}
