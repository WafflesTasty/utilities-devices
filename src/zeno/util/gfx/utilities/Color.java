package zeno.util.gfx.utilities;

import java.util.Arrays;

import zeno.util.tools.Randomizer;
import zeno.util.tools.primitives.Floats;
import zeno.util.tools.primitives.Integers;

/**
 * The {@code Color} class defines a basic 24-bit color component.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public class Color
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
	 * 
	 * @param h  a hue value
	 * @param s  a saturation value
	 * @param b  a brightness value
	 * @param a  an alpha value
	 * @return  a new color
	 * @see Color
	 */
	public static Color fromHSBA(float h, float s, float b, float a)
	{
		int hex = java.awt.Color.HSBtoRGB(h, s, b);
		return new Color((hex << 8) + Integers.round(255 * a));
	}
		
	/**
	 * Creates a color from an HSB color value.
	 * 
	 * @param h  a hue value
	 * @param s  a saturation value
	 * @param b  a brightness value
	 * @return  a new color
	 * @see Color
	 */
	public static Color fromHSB(float h, float s, float b)
	{
		return fromHSBA(h, s, b, 1f);
	}
		
	/**
	 * Returns a random {@code Color}.
	 * 
	 * @return  a random color
	 */
	public static Color random()
	{
		float r = Randomizer.randomFloat(0, 1);
		float g = Randomizer.randomFloat(0, 1);
		float b = Randomizer.randomFloat(0, 1);
		return new Color(r, g, b, 1f);
	}
	
	
	
	private float[] rgba;
	
	/**
	 * Creates a new {@code Color}.
	 * <br> Values between 0.0 and 1.0 are expected.
	 * 
	 * @param r  a  red   percentage
	 * @param g  a  green percentage
	 * @param b  a  blue  percentage
	 * @param a  an alpha percentage
	 */
	public Color(float r, float g, float b, float a)
	{
		rgba = new float[]
		{
			Floats.clamp(r, 0f, 1f),
			Floats.clamp(g, 0f, 1f),
			Floats.clamp(b, 0f, 1f),
			Floats.clamp(a, 0f, 1f)
		};
	}
	
	/**
	 * Creates a new {@code Color}.
	 * <br> Values between 0 and 255 are expected.
	 * 
	 * @param r  a  red   value
	 * @param g  a  green value
	 * @param b  a  blue  value
	 * @param a  an alpha value
	 */
	public Color(int r, int g, int b, int a)
	{
		this(r / 255f, g / 255f, b / 255f, a / 255f);
	}
	
	/**
	 * Creates a new {@code Color}.
	 * <br> Values between 0.0 and 1.0 are expected.
	 * 
	 * @param r  a  red   percentage
	 * @param g  a  green percentage
	 * @param b  a  blue  percentage
	 */
	public Color(float r, float g, float b)
	{
		this(r, g, b, 1f);
	}
	
	/**
	 * Creates a new {@code Color}.
	 * <br> Values between 0 and 255 are expected.
	 * 
	 * @param r  a  red   value
	 * @param g  a  green value
	 * @param b  a  blue  value
	 */
	public Color(int r, int g, int b)
	{
		this(r, g, b, 255);
	}
			
	/**
	 * Creates a new {@code Color}.
	 * <br> A hexadecimal value 0xrrggbbaa is expected.
	 * 
	 * @param hex  a color hex code
	 */
	public Color(int hex)
	{
		this
		(
			(hex >> 24) & 0xff,
			(hex >> 16) & 0xff,
			(hex >>  8) & 0xff,
			(hex >>  0) & 0xff
		);
	}
		

	/**
	 * Returns the rgba values of the {@code Color}.
	 * <br> The values are presented between 0.0 and 1.0.
	 * 
	 * @return  the color's rgba values
	 */
	public float[] RGBA()
	{
		return rgba;
	}
	
	/**
	 * Returns the hsba values of the {@code Color}.
	 * <br> The values are presented between 0.0 and 1.0.
	 * 
	 * @return  the color's hsba values
	 */
	public float[] HSBA()
	{
		float[] hsba = Arrays.copyOf(HSB(), 4);
		hsba[3] = rgba[3];
		return hsba;
	}
	
	/**
	 * Returns the rgb values of the {@code Color}.
	 * <br> The values are presented between 0.0 and 1.0.
	 * 
	 * @return  the color's rgb values
	 */
	public float[] RGB()
	{
		return Arrays.copyOf(rgba, 3);
	}
	
	/**
	 * Returns the hsb values of the {@code Color}.
	 * <br> The values are presented between 0.0 and 1.0.
	 * 
	 * @return  the color's hsb values
	 */
	public float[] HSB()
	{
		return java.awt.Color.RGBtoHSB
		(
			Integers.round(255 * rgba[0]),
			Integers.round(255 * rgba[1]),
			Integers.round(255 * rgba[2]),
			null
		);
	}
	
	/**
	 * Returns the hex code of the {@code Color}.
	 * 
	 * @return  the color's hex code
	 */
	public int HexCode()
	{
		return (Integers.round(255 * rgba[0]) & 0xff) << 24
			 + (Integers.round(255 * rgba[1]) & 0xff) << 16
			 + (Integers.round(255 * rgba[2]) & 0xff) <<  8
			 + (Integers.round(255 * rgba[3]) & 0xff) <<  0;
	}
}