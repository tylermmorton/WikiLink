package com.dreinsteinium.wikilink.web.link;

import com.dreinsteinium.wikilink.web.WebHelper;
import com.dreinsteinium.wikilink.web.util.YoutubeParser;

import net.minecraft.item.ItemStack;

public class LinkYoutube extends Link
{
    private String id;
    
    public String title;
    public String viewCount;
    public String likeCount;
    public String dislikeCount;
    public String favoriteCount;
    
    public String username;
    
    public LinkYoutube(ItemStack item, String id)
    {
        super(item, EnumLink.YOUTUBE);
        
        this.id = id;
        
        YoutubeParser parser = new YoutubeParser(this.id);  
            this.title = parser.title;
            this.viewCount = parser.viewCount;
            this.likeCount = parser.likeCount;
            this.dislikeCount = parser.dislikeCount;
            this.favoriteCount = parser.favoriteCount;
            
            this.username = parser.username;
    }

    @Override
    public String getDisplay()
    {       
            return this.title;
    }

    @Override
    public String getHyperlink()
    {
        return "www.youtube.com/watch?v=" + this.id;
    }

}
