package co.einsteinium.wikilink.net;

import java.io.File;

import net.minecraft.client.Minecraft;

/** ClientProxy
 * 
 * @since 1.6.2-015
 * @author DrEinsteinium
 *
 */
public class ClientProxy extends CommonProxy
{
	public File getModRoot()
	{
			return Minecraft.getMinecraft().mcDataDir;
	}
}
