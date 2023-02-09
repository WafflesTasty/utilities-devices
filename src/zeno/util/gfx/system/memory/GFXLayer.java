package zeno.util.gfx.system.memory;

import zeno.util.algebra.linear.vector.fixed.Vector2;
import zeno.util.gfx.system.GFXMemory;
import zeno.util.gfx.utilities.Color;
import zeno.util.tools.patterns.manipulators.Loadable;

/**
 * The {@code GFXLayer} interface defines a window layer to draw into.
 *
 * @author Zeno
 * @since 20 Jan 2021
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 * @see Loadable
 */
public interface GFXLayer extends GFXMemory.Data, Loadable
{
	/**
	 * The {@code Target} enum defines all render targets in a {@code GFXLayer}.
	 *
	 * @author Waffles
	 * @since 09 Feb 2023
	 * @version 1.0
	 */
	public static enum Target
	{
		/**
		 * Color buffer 0.
		 */
		COLOR_0,
		/**
		 * Color buffer 1.
		 */
		COLOR_1,
		/**
		 * Color buffer 2.
		 */
		COLOR_2,
		/**
		 * Color buffer 3.
		 */
		COLOR_3,
		/**
		 * Color buffer 4.
		 */
		COLOR_4,
		/**
		 * Color buffer 5.
		 */
		COLOR_5,
		/**
		 * Color buffer 6.
		 */
		COLOR_6,
		/**
		 * Color buffer 7.
		 */
		COLOR_7,
		/**
		 * Color buffer 8.
		 */
		COLOR_8,
		/**
		 * Color buffer 9.
		 */
		COLOR_9,
		/**
		 * Color buffer 10.
		 */
		COLOR_10,
		/**
		 * Color buffer 11.
		 */
		COLOR_11,
		/**
		 * Color buffer 12.
		 */
		COLOR_12,
		/**
		 * Color buffer 13.
		 */
		COLOR_13,
		/**
		 * Color buffer 14.
		 */
		COLOR_14,
		/**
		 * Color buffer 15.
		 */
		COLOR_15,
		/**
		 * Color buffer 16.
		 */
		COLOR_16,
		/**
		 * Color buffer 17.
		 */
		COLOR_17,
		/**
		 * Color buffer 18.
		 */
		COLOR_18,
		/**
		 * Color buffer 19.
		 */
		COLOR_19,
		/**
		 * Color buffer 20.
		 */
		COLOR_20,
		/**
		 * Color buffer 21.
		 */
		COLOR_21,
		/**
		 * Color buffer 22.
		 */
		COLOR_22,
		/**
		 * Color buffer 23.
		 */
		COLOR_23,
		/**
		 * Color buffer 24.
		 */
		COLOR_24,
		/**
		 * Color buffer 25.
		 */
		COLOR_25,
		/**
		 * Color buffer 26.
		 */
		COLOR_26,
		/**
		 * Color buffer 27.
		 */
		COLOR_27,
		/**
		 * Color buffer 28.
		 */
		COLOR_28,
		/**
		 * Color buffer 29.
		 */
		COLOR_29,
		/**
		 * Color buffer 30.
		 */
		COLOR_30,
		/**
		 * Color buffer 31.
		 */
		COLOR_31,
		
		/**
		 * Depth buffer.
		 */
		DEPTH,
		/**
		 * Depth & stencil buffer.
		 */
		DEPTH_STENCIL,
		/**
		 * Stencil buffer.
		 */
		STENCIL;
	}
	
	
	/**
	 * Returns the height of the {@code GFXLayer}.
	 * 
	 * @return  a layer height
	 */
	public default float Height()
	{
		return Dimension().Y();
	}
	
	/**
	 * Returns the width of the {@code GFXLayer}.
	 * 
	 * @return  a layer width
	 */
	public default float Width()
	{
		return Dimension().X();
	}
	
	
	/**
	 * Returns the dimension of the {@code GFXLayer}.
	 * 
	 * @return  a dimension vector
	 * 
	 * 
	 * @see Vector2
	 */
	public abstract Vector2 Dimension();
	
	
	/**
	 * Attaches a renderable asset into the {@code GFXLayer}.
	 * 
	 * @param asset  a graphics asset
	 * @param tgt    a layer target
	 * 
	 * 
	 * @see GFXAsset
	 * @see Target
	 */
	public abstract void attach(GFXAsset asset, Target tgt);
	
	/**
	 * Targets a specific buffer in the {@code GFXLayer}.
	 * </br> The only allowed values here are of the type COLOR_XX.
	 * 
	 * @param tgt  a target buffer
	 * 
	 * 
	 * @see Target
	 */
	public abstract void setTarget(Target tgt);
	
	
	/**
	 * Clears the {@code GFXLayer}.
	 * 
	 * @param c  a base color
	 * 
	 * 
	 * @see Color
	 */
	public abstract void clear(Color c);
	
	/**
	 * Clears the {@code GFXLayer}.
	 */
	public default void clear()
	{
		clear(new Color(0f, 0f, 0f, 0f));
	}
}