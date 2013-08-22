package co.einsteinium.wikilink.run.bind;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

/** KeybindWiki
 * 
 * @since 1.6.2-015
 * @author DrEinsteinium
 *
 */
public class KeybindWiki extends KeyHandler
{
	public static boolean keyPressed = false;
	
    private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
    
    public KeybindWiki(KeyBinding[] keyBindings, boolean[] repeatings)
    {
            super(keyBindings, repeatings);
    }
    
    public String getLabel()
    {
            return "KeybindWiki";
    }
    
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
    {
    	keyPressed = true;
    }
    
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
    {
    }
    
    public EnumSet<TickType> ticks()
    {
            return tickTypes;
    }
	
}
