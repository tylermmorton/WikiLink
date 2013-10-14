package co.einsteinium.wikilink.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class LibraryHandler
{
	public static void loadLibClasses(File dir)
	{
		//ArrayList inputClasses = new ArrayList();
		try
		{
			JarInputStream jarFile = new JarInputStream(new FileInputStream(dir.getCanonicalFile() + "//WikiLinkLib.jar"));
			JarEntry jarEntry;
			
			while(true)
			{
				jarEntry = jarFile.getNextJarEntry();
					if(jarEntry == null)
						break;
					if(jarEntry.getName().endsWith(".class"))
					{
						LibraryHandler.class.getClassLoader().loadClass(jarEntry.getName());
					}
			}
			
			jarFile.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		/*
		String pathToJar = dir.getCanonicalFile() + "\\" + "WikiLinkLib.jar";
		
		JarFile jarFile = new JarFile(pathToJar);
		Enumeration e = jarFile.entries();
		
		URL[] urls = { new URL("jar:file" + pathToJar+"!/") };
		URLClassLoader cl = URLClassLoader.newInstance(urls);
		
		while(e.hasMoreElements())
		{
			JarEntry je = (JarEntry) e.nextElement();
			if(je.isDirectory() || je.getName().endsWith(".class"))
			{
				continue;
			}
			
			String className = je.getName().substring(0, je.getName().length() - 6);
			
			className = className.replace("/", ".");
			
			Class c = cl.loadClass(className);
		}*/
		
		
	}
}
