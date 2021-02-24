package zeno.util.gfx.system.memory;

import zeno.util.gfx.system.GFXMemory;
import zeno.util.gfx.system.window.GFXGraphics;
import zeno.util.tools.patterns.manipulators.Activator;

/**
 * The {@code GFXLayer} interface defines a window layer to draw into.
 *
 * @author Zeno
 * @since 20 Jan 2021
 * @version 1.0
 * 
 * 
 * @see Activator
 * @see GFXMemory
 */
public interface GFXLayer extends GFXMemory.Data, Activator
{		
	public abstract void attach(GFXAsset asset, int index);
	
	public abstract void setTarget(int index);
	
	public default void draw(GFXGraphics g)
	{
		
	}
	
	/**
	 * Returns the texture of the {@code GFXLayer}.
	 * 
	 * @return  a layer texture
	 * 
	 * 
	 * @see GFXAsset
	 */
	public abstract GFXAsset Texture();
	
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