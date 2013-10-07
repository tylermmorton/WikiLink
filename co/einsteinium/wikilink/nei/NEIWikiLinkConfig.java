package co.einsteinium.wikilink.nei;

import org.lwjgl.input.Keyboard;

import co.einsteinium.wikilink.Reference;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.forge.GuiContainerManager;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class NEIWikiLinkConfig implements IConfigureNEI
{
    @Override
    public void loadConfig()
    {
        API.addKeyBind("wiki", Keyboard.KEY_I);
        
        LanguageRegistry.instance().addStringLocalization("nei.options.keys.wiki", "Wiki Search");
        
        GuiContainerManager.addInputHandler(new WikiLinkInputHandler());
        GuiContainerManager.addTooltipHandler(new WikiLinkTooltipHandler());
    }

    @Override
    public String getName()
    {
        return "WikiLink Addon";
    }

    @Override
    public String getVersion()
    {
        return Reference.MOD_VERSION;
    }
}
