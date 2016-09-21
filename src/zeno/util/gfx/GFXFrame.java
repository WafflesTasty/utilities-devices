package zeno.util.gfx;

import zeno.util.gfx.frame.GFXGraphics;
import zeno.util.tools.generic.manipulators.Disposable;

/**
 * The {@code GFXFrame} interface encapsulates the render mechanisms of the {@link GFXSystem}.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 * 
 * @see Disposable
 * @see GFXSystem
 */
public interface GFXFrame extends Disposable
{
	/**
	 * Returns the graphics of the {@code GFXFrame}.
	 * 
	 * @return  the frame's graphics
	 * @see GFXGraphics
	 */
	public abstract GFXGraphics Graphics();
}
