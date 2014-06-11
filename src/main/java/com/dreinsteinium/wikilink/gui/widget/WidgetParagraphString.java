package com.dreinsteinium.wikilink.gui.widget;

import net.minecraft.client.gui.FontRenderer;

public class WidgetParagraphString extends Widget
{
    private String str;
    private FontRenderer fontrenderer;

    private int posX;
    private int posY;
    private int width;
    private int height;

    private int color = 0xFFFFFF; 
    
    public WidgetParagraphString(String str, int posX, int posY, int width, int height, FontRenderer fontrenderer)
    {
        this.str = str
                .replace("}", "")
                .replace("'", "")
                .replace("]", "")
                .replace("[", "");;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.fontrenderer = fontrenderer;
    }
    
    @Override
    public void draw()
    {       
        String[] splitstr = this.str.split(" ");
         
        int linec = 0;
        String line = "";
        for(int i = 0; i < splitstr.length; i++)
        {
            // If the line is too long for the width
            if(fontrenderer.getStringWidth(line + splitstr[i]) >= this.width)
            {
                // If the line is not the last line space for the given height
                if((linec * fontrenderer.FONT_HEIGHT) <= this.height)
                {
                    linec++;
                    fontrenderer.drawString(line, this.posX, this.posY + (fontrenderer.FONT_HEIGHT * linec), this.color);
                    
                    line = splitstr[i];
                }
                else 
                {
                    fontrenderer.drawString("...", this.posX, this.posY + (fontrenderer.FONT_HEIGHT * linec), this.color);
                }
            }
            else line += splitstr[i] + " " ;
        }
    }

}
