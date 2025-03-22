package waffles.utils.sys.video.graphics.cmds;

import waffles.utils.sys.video.frames.GFXFrame;
import waffles.utils.sys.video.frames.GFXFrame.Target;

/**
 * The {@code GFXFrameBuffers} interface defines framebuffer options for {@code GFXGraphics}.
 *
 * @author Waffles
 * @since 22 Mar 2025
 * @version 1.1
 */
public interface GFXFrameBuffers
{
	/**
	 * Targets a {@code GFXFrame} with the {@code GFXGraphics}.
	 * If a null value is provided, the default framebuffer is used.
	 * 
	 * @param f  a framebuffer
	 * 
	 * 
	 * @see GFXFrame
	 */
	public abstract void target(GFXFrame f);
	
	/**
	 * Targets a {@code GFXFrame} with the {@code GFXGraphics}.
	 * If a null value is provided, the default framebuffer is used.
	 * 
	 * @param f  a framebuffer
	 * @param t  a render target
	 * 
	 * 
	 * @see GFXFrame
	 */
	public abstract void target(GFXFrame f, Target t);
}