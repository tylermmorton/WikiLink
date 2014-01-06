package com.dreinsteinium.wikilink.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.dreinsteinium.wikilink.Reference;
import com.dreinsteinium.wikilink.WikiLink;
import com.esotericsoftware.yamlbeans.YamlReader;

public class UpdateHandler
{
    /** This method checks the MD5 hash "version" inside of the file and
     *  downloads the update from the hyperlink inside of the file.  
     * **/
    public static boolean updateLib(File file)
    {   
        try
        {             
            //Define the temporary file used to download the data to. We'll delete it later.
            File temp = new File(Reference.CFGROOT + "\\plugin\\version.yml");               
            URL version = new URL(Reference.WIKILINKLIB_GIT + "version.yml");
            
            FileUtils.copyURLToFile(version, temp);            
            
            YamlReader r = new YamlReader(new FileReader(temp));
                Object o = r.read();
            Map m = (Map)o;
            
            String filever = (String)m.get(file.getName());
     
            // Tie up any loose ends
            r.close();
            
            if(filever == null)
            {   WikiLink.LogHelper.severe("error: filever is null");
                return false;
            }
                          
            YamlReader reader = new YamlReader(new FileReader(file));
                Object yamlobject = reader.read();
            Map map = (Map)yamlobject;
            
            URL updater = null;               
            // If the file is empty(like on first run) it will download
            // an updated version from my GitHub.
            if(yamlobject == null)             
             updater = new URL(Reference.WIKILINKLIB_GIT + file.getName());
            // Else, download the update from the url specified in the file.
            else 
             updater = new URL((String)map.get("updater"));
      
            if(!map.get("version").equals(filever))
            {
                WikiLink.LogHelper.info("Downloading update from " + updater);
                FileUtils.copyURLToFile(updater, file);  
            }
            
            reader.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }        
        return false;
    }
}
