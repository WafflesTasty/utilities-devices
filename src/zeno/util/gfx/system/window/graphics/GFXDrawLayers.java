package zeno.util.gfx.system.window.graphics;

import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXDrawLayers} interface defines layer options for {@code GFXGraphics}.
 * A window can be assigned multiple layers with different resolutions to draw to.
 * 
 * @author Zeno
 * @since 20 Jan 2021
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXDrawLayers extends Resettable
{
	/**
	 * Targets a layer in the {@code GFXDrawLayers}.
	 * 
	 * @param index  a layer index
	 */
	public abstract void target(int index);
}