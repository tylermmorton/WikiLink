package co.einsteinium.wikilink.gui.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import co.einsteinium.wikilink.gui.font.types.TrueTypeFont;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class FontRegistry
{

	/**
	 * USAGE GUIDE, HUE!
	 * 
	 * create a TrueTypeFont object variable using either a resource location to
	 * a .ttf or name of a system font, choose base size and whether or not you
	 * want anti aliasing like so:
	 * 
	 * testFont = createFont(new ResourceLocation("modid", "testfont.ttf"), 24f,
	 * false);
	 * 
	 * 
	 * Once the font has been created, to render to screen, simply use the
	 * static call:
	 * 
	 * FontHelper.drawString(String name, int x, int y, TrueTypeFont font, float
	 * scaleX, float scaleY, float... rgba)
	 * 
	 * (^ help me think of a better class name for that class please o7) --
	 * 
	 * Example:
	 * 
	 * FontHelper.drawString(windowTitle, posX, posY, Fonts.fontHelvetica, 1f,
	 * 1f);
	 * 
	 * --
	 * 
	 * gl&hf - oku
	 * 
	 * */

	public static TrueTypeFont fontVerdana = null;

	public static void initFonts()
	{
		fontVerdana = loadSystemFont("Verdana", 18, false);
	}

	public static TrueTypeFont loadSystemFont(String name, float defSize, boolean antialias)
	{
		return loadSystemFont(name, defSize, antialias, Font.TRUETYPE_FONT);
	}

	public static TrueTypeFont loadSystemFont(String name, float defSize, boolean antialias, int type)
	{
		Font font;
		TrueTypeFont fout = null;
		try
		{
			font = new Font(name, type, (int) defSize);
			font = font.deriveFont(defSize);
			fout = new TrueTypeFont(font, antialias);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return fout;
	}

	public static TrueTypeFont createFont(ResourceLocation res, float defSize,  boolean antialias)
	{
		return createFont(res, defSize, antialias, Font.TRUETYPE_FONT);
	}

	public static TrueTypeFont createFont(ResourceLocation res, float defSize, boolean antialias, int type)
	{
		Font font;
		TrueTypeFont out = null;
		try
		{
			font = Font.createFont(type, Minecraft.getMinecraft()
					.getResourceManager().getResource(res).getInputStream());
			font = font.deriveFont(defSize);
			out = new TrueTypeFont(font, antialias);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return out;
	}

}
