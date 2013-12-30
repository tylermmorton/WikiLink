package com.dreinsteinium.wikilink.api;

import com.dreinsteinium.wikilink.plg.Plugin;

/** This is one of the main API classes 
 *  used to extend WikiLink. Use this to
 *  add various different API functions
 *  to WikiLink. 
 *  
 *  @since  11/27/2013
 *  @author DrEinsteinium
 *  **/
public interface IConfigureWikiLink extends Plugin
{
	public void onLoad();
}
