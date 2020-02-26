package zeno.util.gfx.frame.graphics;

import zeno.util.geom.collidables.geometry.planar.Rectangle;
import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXScissorTest} interface defines configurations for the scissor test.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public interface GFXScissorTest extends Resettable
{
	/**
	 * Changes the currently used bounds of the clip test.
	 * 
	 * @param x  the top left x-co�rdinate of the bounds
	 * @param y  the top left y-co�rdinate of the bounds
	 * @param w  the width  of the bounds
	 * @param h  the height of the bounds
	 */
	public abstract void setBounds(int x, int y, int w, int h);
	
	/**
	 * Changes the currently used bounds of the clip test.
	 * <br> Passing a null value will disable the test.
	 * 
	 * @param rect  a new clipping rectangle
	 * @see Rectangle
	 */
	public default void setBounds(Rectangle rect)
	{
		if(rect == null)
			setBounds(0, 0, 0, 0);
		else
		{
			int x = (int) (rect.XMin()   - 0.5f);
			int y = (int) (rect.YMin()   - 0.5f);
			int w = (int) (rect.Width()  + 0.5f);
			int h = (int) (rect.Height() + 0.5f);
			
			setBounds(x, y, w, h);
		}
	}
}