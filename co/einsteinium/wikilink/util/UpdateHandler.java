package co.einsteinium.wikilink.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import co.einsteinium.wikilink.Reference;
import co.einsteinium.wikilink.WikiLink;

/**
 * 
 * @author DrEinsteinium
 */
public class UpdateHandler
{
	private static String libName = "WikiLinkLib";
	
	public static void update(File dir)
	{
		String[] fileList =  dir.list();	
			for(int i = 0; i < fileList.length; i++)
			{
				if(fileList[i].contains(libName))
				{
					File fileName = new File(dir + "\\" + fileList[i]);
									
					if(fileName.delete())
					{
					  WikiLink.LogHelper.info(fileList[i] + " deleted!");	
				
							try
							{

								WikiLink.LogHelper.info("Now downloading WikiLinkLib update from a secure server...");
								FileUtils.copyURLToFile(new URL("http://catacombs.co/WikiLink/WikiLinkLib.jar"), new File(dir.getCanonicalFile() + "\\" + "WikiLinkLib.jar"));
								
							} 
							catch(IOException e)
							{
								e.printStackTrace();
							}
					}
				}
			}		
	}
	
	public static void download(File dir)
	{
		try
		{
			WikiLink.LogHelper.info("Now downloading WikiLinkLib from a secure server...");
			FileUtils.copyURLToFile(new URL("http://catacombs.co/WikiLink/WikiLinkLib.jar"), new File(dir.getCanonicalFile() + "\\" + "WikiLinkLib.jar"));
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}	
	}
	
}


