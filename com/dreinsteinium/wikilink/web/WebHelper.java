package com.dreinsteinium.wikilink.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.dreinsteinium.wikilink.Reference;
import com.dreinsteinium.wikilink.WikiLink;

/** <b>WebHelper</b><br>
 *  Parent class designed to extend the use of web
 *  api systems such as bit.ly or Google. 
 *  
 *  @since  11/27/2013
 *  @author DrEinsteinium
 *  **/
public abstract class WebHelper 
{
	/** <b>encode</b><br>
	 *  Returns the ASCII encoded version of the 
	 *  given string. This keeps a great deal of
	 *  confusion away when sending hyperlinks to
	 *  the web api.
	 *  **/
	public static String encode(String str)
	{
		return str;
	}
	/** <b>decode</b><br>
	 *  Returns a decoded ASCII encoded version of
	 *  the given string. See the encode method for
	 *  details.
	 *  <br>
	 *  Use this incase a web api gives back a dumb
	 *  encoded response.
	 *  **/	
	public static String decode(String str)
	{
		return str;
	}
	
	/** <b>shortenHyperlink</b><br>
	 *  Returns a shortened version of the hyperlink
	 *  given. This hyperlink is shortened using the
	 *  bit.ly api, and returns a result like:
	 *  <pre>http://wikilink.info/xxxxxx/</pre>
	 *  **/
	public static String shortenHyperlink(String str)
	{
		String hyperlink = null;
		String url = String.format("https://api-ssl.bitly.com/v3/shorten?access_token=%s"
				+ "&longUrl=%s", Reference.BITAPI_TOKEN, encode(str));	
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			
			if(in != null)
			{
				String l  = null;
				String w = null;
				
				while((l = in.readLine()) != null)
				   w += l;	
				
				if(w != null)
					hyperlink = "http://" + w.substring(w.indexOf("wikilink.info"), 
							w.indexOf("wikilink.info")+22).replace("\\/","/");
				
				in.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			WikiLink.WLLog.info("");
		}
		
		return hyperlink;
	}
}
