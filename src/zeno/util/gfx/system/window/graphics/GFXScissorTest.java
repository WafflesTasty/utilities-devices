package zeno.util.gfx.system.window.graphics;

import zeno.util.geom.collidables.geometry.planar.Rectangle;
import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXScissorTest} interface defines scissor test options for {@code GFXGraphics}.
 * The scissor test limits the bounds of the screen that is being rendered to.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXScissorTest extends Resettable
{
	/**
	 * Changes the bounds of the {@code GFXScissorTest}.
	 * 
	 * @param x  a top-left x-coördinate
	 * @param y  a top left y-coördinate
	 * @param w  a scissor bounds width
	 * @param h  a scissor bounds height
	 */
	public abstract void setBounds(int x, int y, int w, int h);
	
	/**
	 * Changes the bounds of the {@code GFXScissorTest}.
	 * </br> Passing a null value disables the test.
	 * 
	 * @param bounds  a bounding rectangle
	 * 
	 * 
	 * @see Rectangle
	 */
	public default void setBounds(Rectangle bounds)
	{
		if(bounds == null)
			setBounds(0, 0, 0, 0);
		else
		{
			int x = (int) (bounds.XMin()   - 0.5f);
			int y = (int) (bounds.YMin()   - 0.5f);
			int w = (int) (bounds.Width()  + 0.5f);
			int h = (int) (bounds.Height() + 0.5f);
			
			setBounds(x, y, w, h);
		}
	}
}