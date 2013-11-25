package co.einsteinium.wikilink.util.json;

import co.einsteinium.wikilink.WikiLink;

import com.google.gson.Gson;

/** This class is a series of different
 *  util methods used to parse any json
 *  file.
 *  
 *  This was created inorder to parse a
 *  file in json format for all web api
 *  based link systems used by WikiLink
 *  **/
public class JsonParser
{	
	private String str;
	
	/** Constructor<p>
	 *  Note, the given str is not checked to be
	 *  a proper json file before parsing the str
	 *  
	 *  @param str : The entire Json file to parse
	 */
	public JsonParser(String str)
	{
		this.str = str;
	}
	
	private String format(String str)
	{
		return  "\"" + str + "\"";
	}
	
	
	/** Returns the String value of the given key
	 *  @param key : The key to get the value of
	 *  **/
	private String getValue(String path, String value)
	{/*
		// Splits metho.debug
		// valuePath[0] = metho
		// valuePath[1] = debug
		String[] valuePath = path.split(".");
		String   tmpString = this.str.substring(1, this.str.length() - 1);
		
		// valuePath[0] is the parent
		// valuePath[1] is a child
		// valuePath[2] is a child of a child
		
		// Find the "scope" of the parent
		// So in this case it's "widget { }"
		String scope = tmpString;
		
		//scope through the json file to find the
		// specific value
		
		for(int i = 0; i < valuePath.length; i++)
		{
			scope = tmpString.substring(tmpString.indexOf(format(valuePath[i]),), endindex);
		}
		

		scope = tmpString.substring(tmpString.indexOf(format(valuePath[0])), tmpString.lastIndexOf("}"));
		
		tmpString.
		
		for(int i = 0; i < tmpString.length(); i++)
			if(str.substring(i, valueForm.length() + 1).contains(valueForm))
				valuecount++;
		
		for(int i = 0; i < tmpString.length(); i++)
			if(str.substring(i, i+1).contains("{"));
				bracketcount++;

		String returnvalue = null;
				
		if(valuecount > 1 && valuecount != 0)
		{
			
		}
		else if(valuecount == 0)
			WikiLink.LogHelper.severe("JsonValue " + valueForm + " not found in the given file.");
		
		else 
		{
			String focusedString = this.str.substring(this.str.indexOf(valueForm));
			this.str.substring(this.str.indexOf(valueForm));
			returnvalue = str.substring(str.indexOf(""), 1);
		}
		
		*/
		return value;
	}
	
	public Integer getInteger(String key)
	{
		return 0;
	}
	
}
