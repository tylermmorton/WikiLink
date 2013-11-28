package com.dreinsteinium.wikilink.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
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
public class WebHelper 
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
	
	/** <b>getResponse</b><br>
	 *  getResponse returns the web api response for
	 *  the given string url. This does not check to
	 *  see if the url is encoded.
	 *  **/
	public static String getResponse(String str)
	{
		String response = null;
		
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
			
			String line;
			while((line = in.readLine()) != null)
				response += line;
				
			in.close();
		}
		catch(Exception e)
		{
			WikiLink.LogHelper.severe("Exception occured while seeking an api response with " + str);	
		}
	
		return response;
	}
	
	/** <b>shortenHyperlink</b><br>
	 *  Returns a shortened version of the hyperlink
	 *  given. This hyperlink is shortened using the
	 *  bit.ly api, and returns a result like:
	 *  <pre>http://wikilink.info/xxxxxx/</pre>
	 *  **/
	public static String shortenHyperlink(String str)
	{
		String hyperlink = str;
		String url = String.format("https://api-ssl.bitly.com/v3/shorten?access_token=%s"
				+ "&longUrl=%s", Reference.BITAPI_TOKEN, encode(str));	
		
		String response = getResponse(url);
			
		if(response != null)
			hyperlink = "http://" + response.substring(response.indexOf("wikilink.info"), 
					response.indexOf("wikilink.info")+22).replace("\\/","/");
		
		return hyperlink;
	}
}
