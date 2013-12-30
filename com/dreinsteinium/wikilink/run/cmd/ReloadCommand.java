package com.dreinsteinium.wikilink.run.cmd;

import java.util.ArrayList;
import java.util.List;

import com.dreinsteinium.wikilink.WikiLink;
import com.dreinsteinium.wikilink.plg.PluginManager;
import com.dreinsteinium.wikilink.plg.PluginRegistrar;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class ReloadCommand implements ICommand
{ 
    private List aliases;
    
    public ReloadCommand()
    {
        this.aliases = new ArrayList();
        this.aliases.add("wlreload");
    }
    
    @Override
    public int compareTo(Object arg0)
    {
        return 0;
    }

    @Override
    public String getCommandName()
    {
        return "wlreload";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender)
    {
        return "wlreload <videos/config>";
    }

    @Override
    public List getCommandAliases()
    {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] astring)
    {
        if(astring.length == 0)
            return;
        
        if(astring[0].equalsIgnoreCase("videos") || astring[0].equalsIgnoreCase("config"))
        {PluginRegistrar.getYoutubeCodeList().clear();
         PluginRegistrar.getYoutubeItemList().clear();
         
         WikiLink.LogHelper.info("WikiLink is now setting up the Youtube data needed during runtime.");
         long start1 = System.currentTimeMillis();
             PluginManager.INSTANCE.loadPostInitPlgs();      
         WikiLink.LogHelper.info(String.format("WikiLink took %s milliseconds to load %s video list(s).", System.currentTimeMillis() - start1, PluginManager.INSTANCE.postInitPlgs.size()));
         
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
    {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
    {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] astring, int i)
    {       
        return false;
    }

}
