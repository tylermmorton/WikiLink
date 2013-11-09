package co.einsteinium.wikilink.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.cfg.ConfigHandler;

public class ShortenedLinkGenerator extends EncodingHelper
{
	private String url;
	
	public ShortenedLinkGenerator(String str)
	{
		this.url = str;
	}
	
	public String getShortenedLink()
	{
		String url = null;
		
		try
		{
			BufferedReader in = null;
			if(ConfigHandler.shortenUrl)
			{	
				if(ConfigHandler.shortenAdfly)
				{
					in = new BufferedReader(new InputStreamReader(generateAdflyString(this.url).openStream()));
				}
				else	
					in = new BufferedReader(new InputStreamReader(generateBitlyString(this.url).openStream()));
			}
			else if(ConfigHandler.shortenAdfly)
			{
				in = new BufferedReader(new InputStreamReader(generateAdflyString(this.url).openStream()));
			}
			
			else return this.url;
			
			if(in != null && !ConfigHandler.shortenAdfly && ConfigHandler.shortenUrl)
			{
				String line;
				String wholeString = "";
		        while((line = in.readLine()) != null)
		        {
		        	wholeString += line;
		        }
		        
		        if(wholeString != null && !wholeString.isEmpty())
		        	url = decodeBitlyString(wholeString);
		        
		        in.close();
			}		
			else
			{
				String line;
				String wholeString = "";
		        while((line = in.readLine()) != null)
		        {
		        	wholeString += line;
		        }
		        
		        if(wholeString != null && !wholeString.isEmpty())
		        	url = wholeString;
		        
		        in.close();
			}
		}
		catch(MalformedURLException e)
		{
			WikiLink.LogHelper.severe("MalformedURLException in WikiLink");
			e.printStackTrace();
			WikiLink.LogHelper.severe("Now returning original String as URL");
			return this.url;
		} 
		catch (IOException e)
		{
			WikiLink.LogHelper.severe("IOException in WikiLink");
			e.printStackTrace();
			WikiLink.LogHelper.severe("Now returning original String as URL");
			return this.url;
		}
		return url;
	}
}
