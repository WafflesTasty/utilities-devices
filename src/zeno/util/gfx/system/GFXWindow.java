package zeno.util.gfx.system;

import zeno.util.gfx.GFXSystem;
import zeno.util.gfx.system.window.GFXGraphics;
import zeno.util.tools.patterns.manipulators.Disposable;

/**
 * The {@code GFXWindow} interface defines the rendering window in a {@link GFXSystem}.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Disposable
 */
public interface GFXWindow extends Disposable
{	
	/**
	 * Returns the graphics of the {@code GFXWindow}.
	 * 
	 * @return  a graphics object
	 * 
	 * 
	 * @see GFXGraphics
	 */
	public abstract GFXGraphics Graphics();
}