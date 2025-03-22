package waffles.utils.sys.video.graphics.cmds;

import waffles.utils.sys.utilities.Color;

/**
 * The {@code GFXColorEraser} interface defines clear options for {@code GFXGraphics}.
 *
 * @author Waffles
 * @since 22 Mar 2025
 * @version 1.1
 */
public interface GFXColorEraser
{
	/**
	 * The {@code Type} enum defines types of a {@code GFXEraser}.
	 *
	 * @author Waffles
	 * @since 22 Mar 2025
	 * @version 1.1
	 */
	public static enum Type
	{
		/**
		 * A color eraser.
		 */
		COLOR,
		/**
		 * A stencil eraser.
		 */
		STENCIL,
		/**
		 * A depth eraser.
		 */
		DEPTH;
	}
	
			
	/**
	 * Changes the color mask of the {@code GFXColorEraser}.
	 * 
	 * @param mask  an rgba mask
	 */
	public abstract void maskColor(boolean... mask);
	
	/**
	 * Changes the stencil mask of the {@code GFXColorEraser}.
	 * 
	 * @param mask  a stencil mask
	 */
	public abstract void maskStencil(int mask);
	
	/**
	 * Changes the depth mask of the {@code GFXColorEraser}.
	 * 
	 * @param mask  a depth mask
	 */
	public abstract void maskDepth(boolean mask);
	
	
	/**
	 * Changes the color of the {@code GFXColorEraser}.
	 * 
	 * @param c  a clear color
	 */
	public abstract void setColor(Color c);
	
	/**
	 * Changes the depth of the {@code GFXColorEraser}.
	 * 
	 * @param d  a clear depth
	 */
	public abstract void setDepth(float d);
	
	/**
	 * Changes the stencil of the {@code GFXColorEraser}.
	 * 
	 * @param s  a clear stencil
	 */
	public abstract void setStencil(int s);
	
	/**
	 * Clears a value with the {@code GFXColorEraser}.
	 * 
	 * @param type  a value type
	 * 
	 * 
	 * @see Type
	 */
	public abstract void clear(Type type);
}