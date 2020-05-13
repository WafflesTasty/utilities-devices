package zeno.util.gfx.system.window.graphics;

import zeno.util.geom.collidables.geometry.planar.Rectangle;
import zeno.util.tools.patterns.manipulators.Resettable;

/**
 * The {@code GFXViewports} interface defines viewport options for {@code GFXGraphics}.
 * The viewport specifies how normalized device coördinates are
 * translated to window coördinates.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXViewports extends Resettable
{
	/**
	 * Changes the window bounds of the {@code GFXViewports}.
	 * 
	 * @param x  a top-left x-coördinate
	 * @param y  a top-left y-coördinate
	 * @param w  a viewport width
	 * @param h  a viewport height
	 */
	public abstract void setBounds(int x, int y, int w, int h);
	
	/**
	 * Changes the window bounds of the {@code GFXViewports}.
	 * </br> Passing a null value disables the viewport.
	 * 
	 * @param rect  a bounding rectangle
	 * 
	 * 
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