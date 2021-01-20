package zeno.util.gfx.system.memory;

import zeno.util.gfx.system.GFXMemory;
import zeno.util.gfx.system.window.GFXGraphics;

/**
 * The {@code GFXLayer} interface defines a window layer to draw into.
 *
 * @author Zeno
 * @since 20 Jan 2021
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 */
public interface GFXLayer extends GFXMemory.Data
{	
	/**
	 * Draws the {@code GFXLayer} on the screen.
	 * 
	 * @param g  a graphics object
	 * 
	 * 
	 * @see GFXGraphics
	 */
	public abstract void draw(GFXGraphics g);
	
	
	/**
	 * Returns the height of the {@code GFXLayer}.
	 * 
	 * @return  a layer height
	 */
	public abstract int Height();

	/**
	 * Returns the width of the {@code GFXLayer}.
	 * 
	 * @return  a layer width
	 */
	public abstract int Width();
}