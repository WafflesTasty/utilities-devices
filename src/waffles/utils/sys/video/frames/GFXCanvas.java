package waffles.utils.sys.video.frames;

import waffles.utils.sys.memory.GFXMemory;

/**
 * A {@code GFXCanvas} defines an asset for a {@code GFXFrame} to draw into.
 *
 * @author Waffles
 * @since 09 Feb 2023
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 */
public interface GFXCanvas extends GFXMemory.Data
{		
	/**
	 * The {@code Hints} interface defines settings for a {@code GFXCanvas}.
	 *
	 * @author Waffles
	 * @since 22 Mar 2025
	 * @version 1.1
	 */
	public static interface Hints
	{
		/**
		 * Returns the type of the {@code Hints}.
		 * 
		 * @return  a canvas type
		 * 
		 * 
		 * @see Type
		 */
		public abstract Type Type();
		
		/**
		 * Returns the height of the {@code Hints}.
		 * 
		 * @return  a canvas height
		 */
		public abstract int Height();
		
		/**
		 * Returns the width of the {@code Hints}.
		 * 
		 * @return  a canvas width
		 */
		public abstract int Width();
	}
	
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
		 * 1-component depth & stencil type.
		 */
		DEPTH_STENCIL,
		/**
		 * 1-component depth type.
		 */
		DEPTH,
		/**
		 * 4-component rgba type.
		 */
		RGBA,
		/**
		 * 3-component rgb type.
		 */
		RGB;
	}

	
	/**
	 * Returns the hints of the {@code GFXCanvas}.
	 * 
	 * @return  canvas hints
	 * 
	 * 
	 * @see Hints
	 */
	public abstract Hints Hints();
}