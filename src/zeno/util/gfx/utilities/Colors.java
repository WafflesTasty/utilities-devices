package zeno.util.gfx.utilities;

import zeno.util.tools.Floats;
import zeno.util.tools.Longs;
import zeno.util.tools.helper.Randomizer;

/**
 * The {@code Colors} class defines utility methods to generate {@code Colors}.
 *
 * @author Zeno
 * @since Feb 10, 2020
 * @version 1.0
 */
public final class Colors
{
	/**
	 * The color white.
	 */
	public static final Color WHITE 		= new Color(255, 255, 255, 255);
	/**
	 * The color light gray.
	 */
	public static final Color LIGHT_GRAY 	= new Color(192, 192, 192, 255);
	/**
	 * The color gray.
	 */
	public static final Color GRAY 			= new Color(128, 128, 128, 255);
	/**
	 * The color dark gray.
	 */
	public static final Color DARK_GRAY 	= new Color( 64,  64,  64, 255);
	/**
	 * The color black.
	 */
	public static final Color BLACK 		= new Color(  0,   0,   0, 255);
	
	/**
	 * The color red.
	 */
	public static final Color RED 			= new Color(255,   0,   0, 255);
	/**
	 * The color yellow.
	 */
	public static final Color YELLOW 		= new Color(255, 255,   0, 255);
	/**
	 * The color green.
	 */
	public static final Color GREEN 		= new Color(  0, 255,   0, 255);
	/**
	 * The color cyan.
	 */
	public static final Color CYAN 			= new Color(  0, 255, 255, 255);
	/**
	 * The color blue.
	 */
	public static final Color BLUE 			= new Color(  0,   0, 255, 255);
	/**
	 * The color magenta.
	 */
	public static final Color MAGENTA 		= new Color(255,   0, 255, 255);
	
	/**
	 * The color orange.
	 */
	public static final Color ORANGE 		= new Color(255, 200,   0, 255);
	/**
	 * The color pink.
	 */
	public static final Color PINK 			= new Color(255, 175, 175, 255);

	
	/**
	 * Creates a color from an HSB color value.
	 * </br> Parameters are given in [0.0, 1.0].
	 * 
	 * @param h  a hue value
	 * @param s  a saturation value
	 * @param b  a brightness value
	 * @param a  an alpha value
	 * @return   a color
	 * 
	 * 
	 * @see Color
	 */
	public static Color fromHSBA(float h, float s, float b, float a)
	{
		long hex = java.awt.Color.HSBtoRGB(h, s, b) & 0xffffff;
		long alpha = Longs.clamp(Longs.round(255 * a), 0, 255);
		return new Color((hex << 8) + alpha);
	}
		
	/**
	 * Creates a color from an HSB color value.
	 * </br> Parameters are given in [0.0, 1.0].
	 * 
	 * @param h  a hue value
	 * @param s  a saturation value
	 * @param b  a brightness value
	 * @return   a color
	 * 
	 * 
	 * @see Color
	 */
	public static Color fromHSB(float h, float s, float b)
	{
		return fromHSBA(h, s, b, 1f);
	}

	/**
	 * Creates a color brighter than a previous color.
	 * 
	 * @param c  a color to brighten
	 * @param mult  a factor multiplier
	 * @return  a brighter color
	 * 
	 * 
	 * @see Color
	 */
	public static Color brighter(Color c, int mult)
	{
		float pow = Floats.pow(0.666f, mult);
		
		float r = Floats.clamp(c.RGBA()[0] / pow, 0f, 1f);
		float g = Floats.clamp(c.RGBA()[1] / pow, 0f, 1f);
		float b = Floats.clamp(c.RGBA()[2] / pow, 0f, 1f);
		float a = c.RGBA()[3];
		
		return new Color(r, g, b, a);
	}

	/**
	 * Creates a color darker than a previous color.
	 * 
	 * @param c  a color to darken
	 * @param mult  a factor multiplier
	 * @return  a darker color
	 * 
	 * 
	 * @see Color
	 */
	public static Color darker(Color c, int mult)
	{
		float pow = Floats.pow(0.666f, mult);
		
		float r = Floats.clamp(c.RGBA()[0] * pow, 0f, 1f);
		float g = Floats.clamp(c.RGBA()[1] * pow, 0f, 1f);
		float b = Floats.clamp(c.RGBA()[2] * pow, 0f, 1f);
		float a = c.RGBA()[3];
		
		return new Color(r, g, b, a);
	}
	
	/**
	 * Creates a color from a 6-digit hex string.
	 * </br> Hex codes are given as {@code 0xrrggbbaa}.
	 * 
	 * @param text  a hexadecimal string
	 * @return  a color
	 * 
	 * 
	 * @see String
	 * @see Color
	 */
	public static Color parse(String text)
	{
		return new Color(Longs.parse(text, 16));
	}
	
	/**
	 * Returns a random {@code Color}.
	 * 
	 * @return  a random color
	 * 
	 * 
	 * @see Color
	 */
	public static Color random()
	{
		float r = Randomizer.randomFloat(0, 1);
		float g = Randomizer.randomFloat(0, 1);
		float b = Randomizer.randomFloat(0, 1);
		return new Color(r, g, b, 1f);
	}

	
	private Colors()
	{
		// NOT APPLICABLE
	}
}