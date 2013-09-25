package co.einsteinium.wikilinklib.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import co.einsteinium.wikilink.WikiLink;
import co.einsteinium.wikilinklib.LibReference;
import co.einsteinium.wikilinklib.WikiLinkLib;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.discovery.ModDiscoverer;

public class UpdateHandler 
{
	
	//File modsDir = new File(Loader.minecraftDir, "mods");
	//private File canonicalModsDir;
	
	public static String getLibraryVersionFromWeb() throws Exception
	{
		URL versionIn = new URL("http://www.catacombs.co/WikiLink/162versionlib.txt");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(versionIn.openStream()));
		
		String inputLine = in.readLine();
		
		in.close();
		return inputLine;
	}
	
	public static void updateLibrary()
	{
		
		File file = new File(LibReference.LIB_FILENAME);
		
		ModDiscoverer discoverer = new ModDiscoverer();
		
		try 
		{
			if(getLibraryVersionFromWeb().contains(LibReference.VER_MINECRAFT))
			{
				if(!getLibraryVersionFromWeb().contains(LibReference.MOD_MINIVER))
				{	
					try
					{
						//WikiLink.LogHelper.info("Deleting Dir: " + discoverer.findClasspathMods();;
						//file.delete();
						//WikiLink.LogHelper.info("Deleted dir: " + file.getPath());
						
						//WikiLink.LogHelper.info("Downloading the WikiLinkLib update from the secure server.");
						//FileUtils.copyURLToFile(new URL(LibReference.LIB_LOCATION), new File(LibReference.LIB_FILENAME));
					}
					catch (Exception e)
					{
						WikiLink.LogHelper.severe("Can not delete dir: "+ file.getPath());
					}

					
				}
				WikiLink.LogHelper.info("WikiLinkLib is up to date with this Minecraft Version. :)");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}	

	}
}
