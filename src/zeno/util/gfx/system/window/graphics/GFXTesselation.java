package zeno.util.gfx.system.window.graphics;

import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXTesselation} interface defines tesselation options for {@code GFXGraphics}.
 * Tesselation allows you to subdivide vertex fragments into higher detail fragments.
 *
 * @author Zeno
 * @since 13 May 2020
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXTesselation extends Resettable
{
	/**
	 * Changes the input patch count of the {@code GFXTesselation}.
	 * 
	 * @param count  a patch count
	 */
	public abstract void setPatchCount(int count);
	
	/**
	 * Changes the default inner level of the {@code GFXTesselation}.
	 * 
	 * @param level  a tesselation level
	 */
	public abstract void setInnerLevel(int level);

	/**
	 * Changes the default outer level of the {@code GFXTesselation}.
	 * 
	 * @param level  a tesselation level
	 */
	public abstract void setOuterLevel(int level);
}