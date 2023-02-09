package zeno.util.gfx.system.memory.assets;

import zeno.util.gfx.system.memory.GFXAsset;

/**
 * The {@code GFXCanvas} interface defines a texture that can be drawn to.
 *
 * @author Waffles
 * @since 09 Feb 2023
 * @version 1.0
 * 
 * 
 * @see GFXAsset
 */
public interface GFXCanvas extends GFXAsset
{		
	/**
	 * The {@code Type} enum defines data types for a {@code GFXCanvas}.
	 *
	 * @author Waffles
	 * @since 09 Feb 2023
	 * @version 1.0
	 */
	public static enum Type
	{
		/**
		 * 3-component rgb type.
		 */
		RGB,
		/**
		 * 4-component rgba type.
		 */
		RGBA,
		/**
		 * 1-component depth & stencil type.
		 */
		DEPTH_STENCIL,
		/**
		 * 1-component depth type.
		 */
		DEPTH;
	}
}