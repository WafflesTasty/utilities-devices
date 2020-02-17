package zeno.util.gfx;

import zeno.util.gfx.frame.GFXGraphics;

/**
 * The {@code GFXFrame} interface encapsulates the render mechanisms of the {@link GFXSystem}.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see GFXSystem
 */
public interface GFXFrame
{	
	/**
	 * Returns the graphics of the {@code GFXFrame}.
	 * 
	 * @return  the frame's graphics
	 * @see GFXGraphics
	 */
	public abstract GFXGraphics Graphics();
}