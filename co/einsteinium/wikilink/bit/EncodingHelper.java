package co.einsteinium.wikilink.bit;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.WikiLink;

/** This class is for encoding and un-encoding
 *  URLs using percent encoding. This class is
 *  used in the bit.ly system, and is important
 *  when sending/receiving the URL from bit.ly
 *  
 *  @author DrEinsteinium
 */
public class EncodingHelper
{
	//TODO = Iterate through a hashmap to encode/decode
	public String encodeAddress(String str)
	{
	      return str	      
	      .replace(" ","%20")
	  	  .replace("!","%21")
		  .replace("#","%23")
		  .replace("$","%24")
		  .replace("&","%26")
		  .replace("'","%27")
		  .replace("(","%28")
		  .replace(")","%29")
		  .replace("*","%2A")
		  .replace("+","%2B")
		  .replace(",","%2C")
		  .replace("/","%2F")
	      .replace(":","%3A")
	      .replace(";","%3B")
	      .replace("=","%3D")
	      .replace("?","%3F")
          .replace("@","%40")
          .replace("[","%5B")
		  .replace("]","%5D");

	}
	
	public String decodeAddress(String str)
	{
	      return str
	      .replace("%20"," ")
	      .replace("%21","%21")
	      .replace("%23","%23")
	      .replace("%24","%24")
	      .replace("%26","%26")
	      .replace("%27","%27")
	      .replace("%28","%28")
	      .replace("%29","%29")
	      .replace("%2A","%2A")
	      .replace("%2B","%2B")
	      .replace("%2C","%2C")
	      .replace("%2F","%2F")
	      .replace("%3A","%3A")
	      .replace("%3B","%3B")
	      .replace("%3D","%3D")
	      .replace("%3F","%3F")
	      .replace("%40","%40")
	      .replace("%5B","%5B")
	      .replace("%5D","%5D");
	}
	
	/** Replaces the given char in the given string
	 *  with the correct percent-encoded value. The
	 *  method then returns the edited string.
	 *  
	 *  @return given str
	 
	public String encodeCharacter(String str, char c)
	{
	  return str.replace(String.valueOf(c), URIMAP.get(String.valueOf(c)));
	}*/

	/** Used by bit.ly integration to decode the 
	 *  "echo" recieved by the URL shortener. It
	 *  pulls just the bit.ly link out of given str.
	 *  @return bit.ly link from str
	 */
	public String decodeBitlyString(String str)
	{
		if(str.contains("wikilink.info"))
		{
			int i = str.indexOf("wikilink.info");
			return "http://" + str.substring(i, i + 22).replace("\\/", "/");
		}
		else return str;
	}
	
	/** Creates the string that is sent to bit.ly
	 *  that will be shortened. They have a picky
	 *  system, so unencoded URLs will not work.
	 *  
	 *  @param url (decoded)
	 *  @return proper URL to be sent
	 *  @throws MalformedURLException 
	 */
	public URL generateBitlyString(String url) throws MalformedURLException
	{
		String str = encodeAddress(url);
		URL urle = new URL(String.format("https://api-ssl.bitly.com/v3/shorten?access_token=" + "%s" + "&longUrl=" + "%s", Reference.BITAPI_TOKEN, str));
		return urle;
	}
	
	public URL generateAdflyString(String url) throws MalformedURLException
	{
		String str = encodeAddress(url);
		URL urle = new URL(String.format("http://api.adf.ly/api.php?key=" + "%s" + "&uid=5499358" + "&advert_type=int" + "&domain=adf.ly" + "&url=" + "%s", Reference.FLYAPI_TOKEN, str));
		return urle;
	}
}
