package zeno.util.gfx.utilities;

import zeno.util.tools.Floats;
import zeno.util.tools.Integers;
import zeno.util.tools.Longs;
import zeno.util.tools.helper.Array;

/**
 * The {@code Color} class defines a basic 24-bit color component.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 */
public class Color
{	
	private float[] rgba;
	
	/**
	 * Creates a new {@code Color}.
	 * </br> Parameters are given in [0.0, 1.0].
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
	 * </br> Parameters are given in [0, 255].
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
	 * </br> Parameters are given in [0.0, 1.0].
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
	 * </br> Parameters are given in [0, 255].
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
	 * </br> Hex codes are given as {@code 0xrrggbbaa}.
	 * 
	 * @param hex  a color hex code
	 */
	public Color(long hex)
	{
		this
		(
			(int)((hex >> 24) & 0xff),
			(int)((hex >> 16) & 0xff),
			(int)((hex >>  8) & 0xff),
			(int)((hex >>  0) & 0xff)
		);
	}
		

	/**
	 * Returns the rgba values of the {@code Color}.
	 * </br> Parameters are given in [0.0, 1.0].
	 * 
	 * @return  a set of rgba values
	 */
	public float[] RGBA()
	{
		return rgba;
	}
	
	/**
	 * Returns the hsba values of the {@code Color}.
	 * </br> Parameters are given in [0.0, 1.0].
	 * 
	 * @return  a set of hsba values
	 */
	public float[] HSBA()
	{
		float[] hsba = Array.copy.of(HSB(), 4);
		hsba[3] = rgba[3];
		return hsba;
	}
	
	/**
	 * Returns the rgb values of the {@code Color}.
	 * </br> Parameters are given in [0.0, 1.0].
	 * 
	 * @return  a set of rgb values
	 */
	public float[] RGB()
	{
		return Array.copy.of(rgba, 3);
	}
	
	/**
	 * Returns the hsb values of the {@code Color}.
	 * </br> Parameters are given in [0.0, 1.0].
	 * 
	 * @return  a set of hsb values
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
	 * </br> Hex codes are given as {@code 0xrrggbbaa}.
	 * 
	 * @return  a color hex code
	 */
	public long HexCode()
	{
		// The parentheses are necessary to maintain operation order.
		return ((Longs.round(255 * rgba[0]) & 0xff) << 24)
			 + ((Longs.round(255 * rgba[1]) & 0xff) << 16)
			 + ((Longs.round(255 * rgba[2]) & 0xff) <<  8)
			 + ((Longs.round(255 * rgba[3]) & 0xff) <<  0);
	}
}