package co.einsteinium.wikilink.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilink.cfg.ConfigHandler;

public class ShortenedLinkGenerator extends EncodingHelper
{
	private String url;
	
	public ShortenedLinkGenerator(String str)
	{
			this.url = str;
	}
	
	public String createLink()
	{
		String url = null;
		
		try
		{
			BufferedReader in = null;		
			in = new BufferedReader(new InputStreamReader(generateBitlyString(String.valueOf(this.url)).openStream()));

			if(in != null)
			{
				String line = null;
				String wholeString = null;
				
				while((line = in.readLine()) != null)
		        	wholeString += line;
		        
				if(wholeString != null)
					url = decodeBitlyString(wholeString);
				
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
