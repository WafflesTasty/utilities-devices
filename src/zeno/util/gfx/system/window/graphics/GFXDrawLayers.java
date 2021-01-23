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
	 * The {@code Buffer} enum defines buffer layers.
	 *
	 * @author Zeno
	 * @since 23 Jan 2021
	 * @version 1.0
	 */
	public static enum Buffer
	{
		/**
		 * A read buffer target.
		 */
		READ_BUFFER,
		/**
		 * A write buffer target.
		 */
		WRITE_BUFFER,
		/**
		 * Both buffer targets.
		 */
		BOTH_BUFFERS;
	}
	
	/**
	 * Targets a layer in the {@code GFXDrawLayers}.
	 * 
	 * @param buffer  a layer target
	 * @param index   a layer index
	 * 
	 * 
	 * @see Buffer
	 */
	public abstract void target(Buffer buffer, int index);
}