package co.einsteinium.wikilink.api;

import java.util.HashMap;

public interface IYoutubeLink extends Plugin
{
	/** This HashMap contains the ItemID and the /watch code.
	 *  <p><b>Always return the HashMap when adding indexes. This will
	 *  allow WikiLink to compile all HashMaps into one for easy lookup.</b>
	 */
    public HashMap<Integer, String> getItemStackVideos();
}
