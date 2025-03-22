package waffles.utils.sys.video.frames;

import waffles.utils.sys.memory.GFXMemory;
import waffles.utils.sys.utilities.Color;
import waffles.utils.sys.utilities.Colors;
import waffles.utils.sys.video.assets.GFXAsset;

/**
 * A {@code GFXFrame} defines an intermediate frame to render into.
 *
 * @author Waffles
 * @since 20 Jan 2021
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 */
public interface GFXFrame extends GFXMemory.Data
{
	/**
	 * A {@code Target} defines a render buffer of a {@code GFXFrame}.
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
		STENCIL,
		/**
		 * No buffer.
		 */
		NONE;
	}

			
	/**
	 * Attaches a {@code GFXAsset} to the {@code GFXFrame}.
	 * 
	 * @param ast  a texture asset
	 * @param tgt  a target buffer
	 * 
	 * 
	 * @see GFXAsset
	 * @see Target
	 */
	public abstract void attach(GFXAsset ast, Target tgt);
	
	/**
	 * Attaches a {@code GFXCanvas} to the {@code GFXFrame}.
	 * 
	 * @param cvs  a frame canvas
	 * @param tgt  a target buffer
	 * 
	 * 
	 * @see GFXCanvas
	 */
	public abstract void attach(GFXCanvas cvs, Target tgt);	
	
	
	/**
	 * Clears the color of a buffer in the {@code GFXFrame}.
	 * 
	 * @param tgt  a target buffer
	 * @param c  a clear color
	 * 
	 * 
	 * @see Target
	 * @see Color
	 */
	public abstract void clear(Target tgt, Color c);
	
	/**
	 * Clears the depth of a buffer in the {@code GFXFrame}.
	 * 
	 * @param tgt  a target buffer
	 * @param d  a depth value
	 * 
	 * 
	 * @see Target
	 */
	public abstract void clear(Target tgt, float d);
		
	/**
	 * Changes the draw buffer of the {@code GFXFrame}.
	 * The only allowed values here are of the type COLOR_XX.
	 * All future draw calls will target the given buffer.
	 * 
	 * @param tgt  a target buffer
	 * 
	 * 
	 * @see Target
	 */
	public abstract void setDrawTarget(Target tgt);
	
	/**
	 * Changes the read buffer of the {@code GFXFrame}.
	 * The only allowed values here are of the type COLOR_XX.
	 * All future read calls will target the given buffer.
	 * 
	 * @param tgt  a target buffer
	 * 
	 * 
	 * @see Target
	 */
	public abstract void setReadTarget(Target tgt);
	
	/**
	 * Changes the buffer of the {@code GFXFrame}.
	 * The only allowed values here are of the type COLOR_XX.
	 * All future calls will target the given buffer.
	 * 
	 * @param tgt  a target buffer
	 * 
	 * 
	 * @see Target
	 */
	public default void setTarget(Target tgt)
	{
		setDrawTarget(tgt);
		setReadTarget(tgt);
	}
	
	/**
	 * Clears the {@code GFXFrame}.
	 * 
	 * @param tgt  a target buffer
	 * 
	 * 
	 * @see Target
	 */
	public default void clear(Target tgt)
	{
		clear(tgt, Colors.BLACK);
		clear(tgt, 1f);
	}
}