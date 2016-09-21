package zeno.util.gfx.frame.graphics;

import zeno.util.geom.shapes.surfaces.lateral.Rectangle;

/**
 * The {@code GFXViewports} interface defines configurations for the viewport.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public interface GFXViewports
{
	/**
	 * Changes the currently used bounds of the viewport.
	 * 
	 * @param x  the top left x-coördinate of the bounds
	 * @param y  the top left y-coördinate of the bounds
	 * @param w  the width  of the bounds
	 * @param h  the height of the bounds
	 */
	public abstract void setBounds(int x, int y, int w, int h);
	
	/**
	 * Changes the currently used bounds of the viewport.
	 * <br> Passing a null value will disable the viewport.
	 * 
	 * @param bounds  a new viewport bounds
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