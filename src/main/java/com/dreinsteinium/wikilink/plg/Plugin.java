package com.dreinsteinium.wikilink.plg;

/** Plugin<br>
 *  The parent interface used by all different
 *  plugin interfaces. This allows them to get
 *  generic information and keep them cleaner.
 *  **/
public interface Plugin 
{
	/** isAvailable<br>
	 *  Will the {@link PluginManager} load this
	 *  particular plugin?
	 *  **/
	public boolean isAvailable();
}
