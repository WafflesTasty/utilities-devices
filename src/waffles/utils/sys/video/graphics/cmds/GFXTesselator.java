package waffles.utils.sys.video.graphics.cmds;

import waffles.utils.tools.patterns.semantics.Resettable;

/**
 * The {@code GFXTesselator} interface defines tesselation options for {@code GFXGraphics}.
 * Tesselation allows you to subdivide vertex fragments into higher detail fragments.
 *
 * @author Waffles
 * @since 13 May 2020
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXTesselator extends Resettable
{
	/**
	 * Changes the input patch count of the {@code GFXTesselator}.
	 * 
	 * @param count  a patch count
	 */
	public abstract void setPatchCount(int count);
	
	/**
	 * Changes the default inner level of the {@code GFXTesselator}.
	 * 
	 * @param level  a tesselation level
	 */
	public abstract void setInnerLevel(int level);

	/**
	 * Changes the default outer level of the {@code GFXTesselator}.
	 * 
	 * @param level  a tesselation level
	 */
	public abstract void setOuterLevel(int level);
}