package com.dreinsteinium.wikilink.web.util;

import com.dreinsteinium.wikilink.Reference;
import com.dreinsteinium.wikilink.web.WebHelper;

public class YoutubeParser extends WebHelper
{
    public static final String YOUTUBE_HYPERLINK = "https://www.googleapis.com/youtube/v3/videos?id=" + "%s" + "&key=" + "%s"+ 
            "&fields=items(snippet(title),statistics)&part=snippet,statistics";
      
    private String response;
    
    /** Data being pulled from YouTube **/
    private String title;
    private String viewCount;
    private String likeCount;
    private String dislikeCount;
    private String favoriteCount;
    
    public YoutubeParser(String id)
    {
        this.response = getResponse(String.format(YOUTUBE_HYPERLINK, id, Reference.GOOGLE_TOKEN));
        
        this.title = parseResponse("title");
        this.viewCount = parseResponse("viewCount");
        this.likeCount = parseResponse("likeCount");
        this.dislikeCount = parseResponse("dislikeCount");
        this.favoriteCount = parseResponse("favoriteCount");
    }
    
    public String parseResponse(String field)
    {
        String valu = null;
        String temp = this.response.substring(response.indexOf("\"" + field + "\":"));
            if(temp.indexOf(",") != -1)
            valu = temp.substring(0, temp.indexOf(","));      
        return valu;           
    }
    
}
