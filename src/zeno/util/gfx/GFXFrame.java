package zeno.util.gfx;

import zeno.util.gfx.frame.GFXGraphics;

/**
 * The {@code GFXFrame} interface defines the rendering window in a {@link GFXSystem}.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 */
public interface GFXFrame
{	
	/**
	 * Returns the graphics of the {@code GFXFrame}.
	 * 
	 * @return  a graphics object
	 * 
	 * 
	 * @see GFXGraphics
	 */
	public abstract GFXGraphics Graphics();
}