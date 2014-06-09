package com.dreinsteinium.wikilink.net;

import java.io.File;

import net.minecraft.client.Minecraft;

public class ClientProxy extends CommonProxy
{
    @Override
    public File getModRoot()
    {
        return Minecraft.getMinecraft().mcDataDir;
    }
}
