package com.dreinsteinium.wikilink.web.util;

import com.dreinsteinium.wikilink.Reference;
import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.web.WebHelper;

public class YoutubeParser extends WebHelper
{
    public static final String YOUTUBE_HYPERLINK = "https://www.googleapis.com/youtube/v3/videos?id=" + "%s" + "&key=" + "%s"+ 
            "&fields=items(snippet(title,channelId),statistics)&part=snippet,statistics";
      
    private String response;
    
    /** Data being pulled from YouTube **/
    public String title;
    public String viewCount;
    public String likeCount;
    public String dislikeCount;
    public String favoriteCount;
    
    public String username;   
    public String channelId;

        
    public YoutubeParser(String id)
    {
        this.response = getResponse(String.format(YOUTUBE_HYPERLINK, id, Reference.GOOGLE_TOKEN));

        try
        {
            this.title = parseResponse("title");
            this.viewCount = parseResponse("viewCount");
            this.likeCount = parseResponse("likeCount");
            this.channelId = parseResponse("channelId");
            this.dislikeCount = parseResponse("dislikeCount");
            this.favoriteCount = parseResponse("favoriteCount");
            
            this.username = parseUsername();
        }
        catch(StringIndexOutOfBoundsException e)
        {
            WikiLink.LogHelper.severe("Can not get response from youtube video with id of " + id);
        }
    }
    
    public String parseResponse(String field)
    {
        String valu = null;
        if(response.indexOf("\"") != -1)
        {
        String temp = this.response.substring(response.indexOf("\"" + field + "\":"));
            if(temp.indexOf(",") != -1)
            valu = temp.substring(("\"" + field + "\":").length(), temp.indexOf(",")).trim().replace("}", "").replace("{", "").replace("\"", "");  
        }
        else return null;
        
        return valu;
    }
    
    // Some special BS you have to go through to get the username from a channelId...
    public String parseUsername()
    {
        String response = getResponse(String.format("https://gdata.youtube.com/feeds/api/users/" + "%s" + "?v=2.1&prettyprint=true", this.channelId));
        return response.substring(response.indexOf("<name>"), response.indexOf("</name>")).replace("<name>", "").replace("</name>", "");
    }
    
}
