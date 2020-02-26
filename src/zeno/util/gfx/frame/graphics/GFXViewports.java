package zeno.util.gfx.frame.graphics;

import zeno.util.geom.collidables.geometry.planar.Rectangle;
import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXViewports} interface defines configurations for the viewport.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public interface GFXViewports extends Resettable
{
	/**
	 * Changes the currently used bounds of the viewport.
	 * 
	 * @param x  the top left x-co�rdinate of the bounds
	 * @param y  the top left y-co�rdinate of the bounds
	 * @param w  the width  of the bounds
	 * @param h  the height of the bounds
	 */
	public abstract void setBounds(int x, int y, int w, int h);
	
	/**
	 * Changes the currently used bounds of the viewport.
	 * <br> Passing a null value will disable the viewport.
	 * 
	 * @param rect  a new viewport rectangle
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